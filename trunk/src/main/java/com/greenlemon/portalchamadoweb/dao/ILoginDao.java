package com.greenlemon.portalchamadoweb.dao;

import com.greenlemon.portalchamadoweb.model.Person;

public interface ILoginDao {
	
	Person find(String email, String password);
	Person find(String email);
	void create(Person person);
	void refresh(Person user);
	void update(Person person);
	boolean containsPersonWithLogin(String email);
}
