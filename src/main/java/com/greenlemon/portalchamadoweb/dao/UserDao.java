package com.greenlemon.portalchamadoweb.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;

import com.greenlemon.portalchamadoweb.model.Person;
import com.greenlemon.portalchamadoweb.model.Role;

@Component
public class UserDao implements ILoginDao {

	private final Session session;
	
	public UserDao(Session session){
		this.session = session;
	}
	
	public void create(Person person) {
		person.setActive(true);
		person.setRole(Role.CUSTOMER);
		this.session.save(person);
	}
	
	public boolean containsPersonWithLogin(String email) {
		return find(email) == null;
	}

	public Person find(String email, String password) {
		
		String hql = "from Person p where p.email = :email and p.password = :password";
		
		Query query = session.createQuery(hql)
			.setParameter("email", email)
			.setParameter("password", password);
		
		return (Person)query.uniqueResult();
	}

	public Person find(String email) {
		String hql = "from Person p where p.email = :email"; 
		Query query = session.createQuery(hql).setParameter("email", email); 
		return (Person) query.uniqueResult();
	}

	public void refresh(Person user) {
		this.session.refresh(user);
	}

	public void update(Person person) {
		this.session.update(person);
	}
}
