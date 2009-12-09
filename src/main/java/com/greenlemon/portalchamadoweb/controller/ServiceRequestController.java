package com.greenlemon.portalchamadoweb.controller;

import java.util.List;

import javax.mail.MessagingException;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.greenlemon.portalchamadoweb.dao.ServiceDao;
import com.greenlemon.portalchamadoweb.dao.ServiceRequestDao;
import com.greenlemon.portalchamadoweb.interceptor.UserInfo;
import com.greenlemon.portalchamadoweb.model.Person;
import com.greenlemon.portalchamadoweb.model.Service;
import com.greenlemon.portalchamadoweb.model.ServiceProvider;
import com.greenlemon.portalchamadoweb.model.ServiceRequest;
import com.greenlemon.portalchamadoweb.provider.MailProvider;

@Resource
public class ServiceRequestController {

	private final Result result;
	private ServiceRequestDao dao;
	private ServiceDao serviceDao;
	private MailProvider mailProvider;
	private UserInfo userInfo;
	
	
	public ServiceRequestController(Result result, ServiceRequestDao dao,
			ServiceDao serviceDao, MailProvider mailProvider, UserInfo userInfo) {
		this.result = result;
		this.dao = dao;
		this.serviceDao = serviceDao;
		this.mailProvider = mailProvider;
		this.userInfo = userInfo;
	}

	public void create() {

	}

	@Put
	@Path("/serviceRequest")
	public void create(Service service, ServiceRequest serviceRequest) {
		try {
			this.dao.create(service, serviceRequest);
			
			Person person = this.dao.getPerson(serviceRequest.getServiceProvider());
			
			String recipient = person.getEmail();
			mailProvider.sendSSLMessage(
					new String[] { recipient },
					service.getDescription(), serviceRequest.getDescription(), 
					userInfo.getUser().getEmail());

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		result.use(Results.logic()).redirectTo(ServiceRequestController.class)
				.services();
	}

	
	public void list() {
		List<Service> filtered = this.serviceDao.findByParams(null);
		result.include("services", filtered);
	}

	@Get
	@Path("/serviceRequest/{service.id}")
	public void create(Service service) {
		Service ser = this.serviceDao.find(service.getId());
		result.include("service", ser);
	}
	
	@Get
	@Path("/serviceRequest")
	public void services(){
		List<Service> filtered = this.serviceDao.findByParams(null);
		result.include("services", filtered);
	}
	
	
	@SuppressWarnings("unchecked")
	@Post
	@Path("/serviceRequest")
	public void services(Service service){
		List filtered = this.serviceDao.findByParams(service);
		result.include("services", filtered);
	}
}
