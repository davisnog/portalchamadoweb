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

import com.greenlemon.portalchamadoweb.dao.CityDao;
import com.greenlemon.portalchamadoweb.model.City;
import com.greenlemon.portalchamadoweb.model.State;

@Resource
public class CityController {
	
	private final CityDao dao;
	private final Result result;
	
	public CityController(CityDao dao, Result result){
		this.dao = dao;
		this.result = result;
	}
	
	public void create(){
		List<State> states = this.dao.getStates();
		result.include("states", states);
	}
	
	@Post
	@Path("/city")
	public void create(City city){
		this.dao.create(city);
		result.use(Results.logic()).redirectTo(CityController.class).list();
	}
	
	@Put
	@Path("/city")
	public void update(City city){
		this.dao.update(city);
		result.use(Results.logic()).redirectTo(CityController.class).list();
	}
	
	@Delete
	@Path("/city")
	public void delete(City city){
		this.dao.delete(city);
		result.use(Results.logic()).redirectTo(CityController.class).list();
	}
	
	@Get
	@Path("/city")
	public void list(){
		List<City> citiesList = this.dao.findAll();
		
		if(citiesList.isEmpty()){
			result.use(Results.logic()).redirectTo(CityController.class).create();
		}
		
		result.include("citiesList", citiesList);
	}
	
	@Get
	@Path("/city/{city.id}")
	public void show(City city){
		City c = this.dao.find(city.getId());
		result.include("city", c);
		
		State state = city.getState();
		
		//List<State> states = this.dao.getStates();
		result.include("state", state);
	}
}
