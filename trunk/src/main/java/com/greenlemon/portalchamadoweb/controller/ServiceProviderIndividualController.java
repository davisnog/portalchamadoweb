package com.greenlemon.portalchamadoweb.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.greenlemon.portalchamadoweb.dao.ServiceProviderIndividualDao;
import com.greenlemon.portalchamadoweb.interceptor.UserInfo;
import com.greenlemon.portalchamadoweb.model.Address;
import com.greenlemon.portalchamadoweb.model.Individual;
import com.greenlemon.portalchamadoweb.model.Person;
import com.greenlemon.portalchamadoweb.model.Role;
import com.greenlemon.portalchamadoweb.model.ServiceProvider;

@Resource
public class ServiceProviderIndividualController {

	private ServiceProviderIndividualDao dao;
	private final Result result;
	private UserInfo userInfo;
	
	public ServiceProviderIndividualController(ServiceProviderIndividualDao dao, Result result, UserInfo userInfo){
		this.dao = dao;
		this.result = result;
		this.userInfo = userInfo;
	}
	
	public void create(){
		result.include("cities", this.dao.getCities());
	}
	
	@Post
	@Path("/serviceProviderIndividual")
	public void create(Person person, ServiceProvider serviceProvider, Individual individual, Address address){
		this.dao.create(person, serviceProvider, individual, address);
		result.use(Results.logic()).redirectTo(ServiceProviderIndividualController.class).list();
	}
	
	@Put
	@Path("/serviceProviderIndividual")
	public void update(Person person, ServiceProvider serviceProvider, Individual individual, Address address){
		this.dao.update(person, serviceProvider, individual, address);
		result.use(Results.logic()).redirectTo(ServiceProviderIndividualController.class).list();
	}
	
	@Delete
	@Path("/serviceProviderIndividual")
	public void delete(Person person){
		this.dao.delete(person);
		result.use(Results.logic()).redirectTo(ServiceProviderIndividualController.class).list();
	}
	
	@Get
	@Path("/serviceProviderIndividual")
	public void list(){
		
		if(userInfo.getUser().getRole() == Role.SERVICE_PROVIDER){
			result.use(Results.logic()).redirectTo(UsersController.class).home();
		}
		
		List<Person> servicesProviderIndividual = this.dao.findAll();
		
		if(servicesProviderIndividual.isEmpty()){
			result.use(Results.logic()).redirectTo(ServiceProviderIndividualController.class).create();
		}
		result.include("servicesProviderIndividual", servicesProviderIndividual);
	}
	
	@Get
	@Path("/serviceProviderIndividual/{serviceProviderIndividual.id}")
	public void show(Person serviceProviderIndividual){
		Person person = this.dao.findById(serviceProviderIndividual.getId());
		
		Address address = person.getAddress();
		
		ServiceProvider serviceProvider = person.getServiceProvider();
		
		if(serviceProvider != null){
			Individual individual = serviceProvider.getIndividual();
			result.include("individual", individual);
		}
		
		result.include("person", person)
		      .include("address", address)
		      .include("serviceProvider", serviceProvider)
		      .include("cities", this.dao.getCities());
	}
}
