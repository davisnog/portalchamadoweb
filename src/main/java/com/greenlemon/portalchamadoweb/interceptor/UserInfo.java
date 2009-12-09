package com.greenlemon.portalchamadoweb.interceptor;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

import com.greenlemon.portalchamadoweb.model.Person;

@Component
@SessionScoped
public class UserInfo {

	public static final String CURRENT_USER = "currentUser";
	private final HttpSession session;
	private Person user;
	
	public UserInfo(HttpSession session) {
		this.session = session;
		refreshUser();
	}

	public Person getUser(){
		return this.user;
	}

	public void login(Person user) {
		this.user = user;
		session.setAttribute(CURRENT_USER, user);
	}

	public void refreshUser() {
		this.user = (Person) session.getAttribute(CURRENT_USER);
	}

	public void logout() {
		session.setAttribute(CURRENT_USER, null);
		this.user = null;
	}
}
