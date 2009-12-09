package com.greenlemon.portalchamadoweb.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;

import com.greenlemon.portalchamadoweb.dao.UserDao;
import com.greenlemon.portalchamadoweb.interceptor.UserInfo;
import com.greenlemon.portalchamadoweb.model.Person;

@Resource
public class UsersController {
	
	private final Validator validator;
    private final Result result;
    private final UserInfo userInfo;
	private final UserDao dao;

	public UsersController(UserDao dao, UserInfo userInfo, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
        this.userInfo = userInfo;
	}

	@Path("/")
	@Get
	public void home() {
		dao.refresh(userInfo.getUser());
	}

	@Path("/users")
	@Post
	public void add(final Person user) {
	
	    validator.checking(new Validations() {{
		    
		    boolean loginDoesNotExist = dao.containsPersonWithLogin(user.getEmail());
		    that(loginDoesNotExist, "notice", "Já existe usuário com esse login");
		}});

	
		validator.onErrorUse(Results.page()).of(HomeController.class).login();
		this.dao.create(user);

		result.include("notice", "Usuário " + user.getName() + " adicionado com sucesso");
		result.use(Results.logic()).redirectTo(HomeController.class).login();
	}


	@Path("/users/{user.email}")
	@Get
	public void view(Person user) {
	    this.dao.refresh(user);
	    result.include("user", user);
	}
}
