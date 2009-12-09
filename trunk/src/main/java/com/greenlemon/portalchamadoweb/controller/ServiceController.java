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

import com.greenlemon.portalchamadoweb.dao.ServiceDao;
import com.greenlemon.portalchamadoweb.interceptor.UserInfo;
import com.greenlemon.portalchamadoweb.model.Role;
import com.greenlemon.portalchamadoweb.model.Service;

@Resource
public class ServiceController {

	private final Result result;
	private ServiceDao dao;
	private UserInfo userInfo;
	
	public ServiceController(Result result, ServiceDao dao, UserInfo userInfo){
		this.result = result;
		this.dao = dao;
		this.userInfo = userInfo;
	}
	
	public void create(){
		
	}
	
	@Post
	@Path("/service")
	public void create(Service service){
		service.setServiceProvider(userInfo.getUser().getServiceProvider());
		this.dao.create(service);
		result.use(Results.logic()).redirectTo(ServiceController.class).list();
	}
	
	@Put
	@Path("/service")
	public void update(Service service){
		service.setServiceProvider(userInfo.getUser().getServiceProvider());
		this.dao.update(service);
		result.use(Results.logic()).redirectTo(ServiceController.class).list();
	}
	
	@Delete
	@Path("/service")
	public void delete(Service service){
		this.dao.delete(service);
		result.use(Results.logic()).redirectTo(ServiceController.class).list();
	}
	
	@Get
	@Path("/service/{service.id}")
	public void show(Service service){
		this.result.include("service", this.dao.find(service.getId()));
	}
	
	@Get
	@Path("/service")
	public void list(){
		
		List<Service> services = null;
		
		if(userInfo.getUser().getRole() == Role.SERVICE_PROVIDER){
			services = this.dao.findAll(userInfo.getUser());
		}else{
			services = this.dao.findAll(null);
		}
		
		this.result.include("services", services);
	}
}
