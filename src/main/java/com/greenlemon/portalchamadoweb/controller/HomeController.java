package com.greenlemon.portalchamadoweb.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import br.com.caelum.vraptor.Get;
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
public class HomeController {

	private final Result result;
    private final Validator validator;
    private final UserInfo userInfo;
	private final UserDao dao;

	public HomeController(UserDao dao, UserInfo userInfo, Result result, Validator validator) {
	    this.dao = dao;
		this.result = result;
	    this.validator = validator;
        this.userInfo = userInfo;
	}

	@Post
	public void login(String email, String password) {
		
		final Person currentUser = dao.find(email, password);

		validator.checking(new Validations() {{
		    that(currentUser, is(notNullValue()), "notice", "Usuário ou senha inválida");
		}});
		
		if(currentUser == null){
			result.include("notice", "Usuário ou senha invalida");
		}
		
		validator.onErrorUse(Results.page()).of(HomeController.class).login();

		userInfo.login(currentUser);

		result.use(Results.logic()).redirectTo(UsersController.class).home();
	}

	public void logout() {
	    userInfo.logout();

	    result.use(Results.logic()).redirectTo(HomeController.class).login();
	}

	@Get
	public void login() {
	}
}
