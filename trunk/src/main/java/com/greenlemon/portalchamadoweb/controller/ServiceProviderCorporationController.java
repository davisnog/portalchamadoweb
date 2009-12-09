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

import com.greenlemon.portalchamadoweb.dao.ServiceProviderCorporationDao;
import com.greenlemon.portalchamadoweb.interceptor.UserInfo;
import com.greenlemon.portalchamadoweb.model.Address;
import com.greenlemon.portalchamadoweb.model.Corporation;
import com.greenlemon.portalchamadoweb.model.Person;
import com.greenlemon.portalchamadoweb.model.Role;
import com.greenlemon.portalchamadoweb.model.ServiceProvider;

@Resource
public class ServiceProviderCorporationController {

	private ServiceProviderCorporationDao dao;
	private final Result result;
	private UserInfo userInfo;
	
	public ServiceProviderCorporationController(ServiceProviderCorporationDao dao, Result result, UserInfo userInfo){
		this.dao = dao;
		this.result = result;
		this.userInfo = userInfo;
	}
	
	public void create(){
		result.include("cities", this.dao.getCities());
	}
	
	@Post
	@Path("/serviceProviderCorporation")
	public void create(Person person, ServiceProvider serviceProvider, Corporation corporation, Address address){
		this.dao.create(person, serviceProvider, corporation, address);
		result.use(Results.logic()).redirectTo(ServiceProviderCorporationController.class).list();
	}
	
	@Put
	@Path("/serviceProviderCorporation")
	public void update(Person person, ServiceProvider serviceProvider, Corporation corporation, Address address){
		this.dao.update(person, serviceProvider, corporation, address);
		result.use(Results.logic()).redirectTo(ServiceProviderCorporationController.class).list();
	}
	
	@Delete
	@Path("/serviceProviderCorporation")
	public void delete(Person person){
		this.dao.delete(person);
		result.use(Results.logic()).redirectTo(ServiceProviderCorporationController.class).list();
	}
	
	@Get
	@Path("/serviceProviderCorporation")
	public void list(){
		
		Role role = userInfo.getUser().getRole();
		
		if(role != null && role == Role.ADMINISTRATOR){
		
			List<Person> servicesProviderCorporation = this.dao.findAll();
			
			if(servicesProviderCorporation.isEmpty()){
				result.use(Results.logic()).redirectTo(ServiceProviderCorporationController.class).create();
			}
			result.include("servicesProviderCorporation", servicesProviderCorporation);
			
		}else{
			result.use(Results.logic()).redirectTo(UsersController.class).home();
		}
	}
	
	@Get
	@Path("/serviceProviderCorporation/{serviceProviderCorporation.id}")
	public void show(Person serviceProviderCorporation){
		Person person = this.dao.findById(serviceProviderCorporation.getId());
		
		Address address = person.getAddress();
		
		ServiceProvider serviceProvider = person.getServiceProvider();
		
		if(serviceProvider != null){
			Corporation corporation = serviceProvider.getCorporation();
			result.include("corporation", corporation);
		}
		
		result.include("person", person)
		      .include("address", address)
		      .include("serviceProvider", serviceProvider)
		      .include("cities", this.dao.getCities());
	}
}
