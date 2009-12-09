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

import com.greenlemon.portalchamadoweb.dao.StateDao;
import com.greenlemon.portalchamadoweb.model.State;

@Resource
public class StateController {
	
	private StateDao dao;
	private final Result result;
	
	public StateController(StateDao dao, Result result){
		this.dao = dao;
		this.result = result;
	}
	
	public void create(){}
	
	@Post
	@Path("/state")
	public void create(State state){
		this.dao.create(state);
		result.use(Results.logic()).redirectTo(StateController.class).list();
	}
	
	@Path("/state")
	@Put
	public void update(State state){
		this.dao.update(state);
		result.use(Results.logic()).redirectTo(StateController.class).list();
	}
	
	@Delete
	@Path("/state")
	public void delete(State state){
		this.dao.delete(state);
		result.use(Results.logic()).redirectTo(StateController.class).list();
	}
	
	@Get
	@Path("/state")
	public void list(){
		List<State> listState = this.dao.findAll();
		
		if(listState.isEmpty()){
			result.use(Results.logic()).redirectTo(StateController.class).create();
		}
		
		result.include("states", listState);
	}
	
	@Get
	@Path("/state/{state.id}")
	public void show(State state){
		State st = this.dao.find(state.getId());
		result.include("state", st);
	}
}
