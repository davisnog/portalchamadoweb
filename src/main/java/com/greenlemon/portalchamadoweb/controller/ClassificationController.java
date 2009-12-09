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

import com.greenlemon.portalchamadoweb.dao.ClassificationDao;
import com.greenlemon.portalchamadoweb.model.Classification;

@Resource
public class ClassificationController {

	private final Result result;
	private ClassificationDao dao;
	
	public ClassificationController(Result result, ClassificationDao dao){
		this.result = result;
		this.dao = dao;
	}
	
	public void create(){
		result.include("servicesProvider", this.dao.getServicesProvider());
	}
	
	@Post
	@Path("/classification")
	public void create(Classification classification){
		this.dao.create(classification);
		result.use(Results.logic()).redirectTo(ClassificationController.class).list();
	}
	
	@Put
	@Path("/classification")
	public void update(Classification classification){
		this.dao.update(classification);
		result.use(Results.logic()).redirectTo(ClassificationController.class).list();
	}
	
	@Delete
	@Path("/classification")
	public void delete(Classification classification){
		this.dao.delete(classification);
		result.use(Results.logic()).redirectTo(ClassificationController.class).list();
	}
	
	@Get
	@Path("/classification")
	public void list(){
		List<Classification> classificationsList = this.dao.findAll();
		
		if(classificationsList.isEmpty()){
			result.use(Results.logic()).redirectTo(ClassificationController.class).create();
		}
		
		result.include("classificationsList", classificationsList);
	}
	
	@Get
	@Path("/classification/{classification.id}")
	public void show(Classification classification){
		Classification c = this.dao.findById(classification.getId());
		result.include("classification", c)
		      .include("servicesProvider", this.dao.getServicesProvider());
		
	}
}
