package com.greenlemon.portalchamadoweb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;

import com.greenlemon.portalchamadoweb.interceptor.UserInfo;
import com.greenlemon.portalchamadoweb.model.Address;
import com.greenlemon.portalchamadoweb.model.City;
import com.greenlemon.portalchamadoweb.model.Corporation;
import com.greenlemon.portalchamadoweb.model.Person;
import com.greenlemon.portalchamadoweb.model.Role;
import com.greenlemon.portalchamadoweb.model.ServiceProvider;

@Component
public class ServiceProviderCorporationDao {
	private final Session session;
	private CityDao cityDao;
	private UserInfo userInfo;
	
	public ServiceProviderCorporationDao(Session session, CityDao cityDao, UserInfo userInfo){
		this.session = session;
		this.cityDao = cityDao;
		this.userInfo = userInfo;
	}
	
	public void create(Person person, ServiceProvider serviceProvider, Corporation corporation, Address address){
		
		this.session.save(address);
		
		person.setRole(Role.SERVICE_PROVIDER);
		person.setActive(true);
		person.setAddress(address);
		this.session.save(person);
		
		serviceProvider.setPerson(person);
		this.session.save(serviceProvider);
		
		corporation.setServiceProvider(serviceProvider);
		this.session.save(corporation);
	}
	
	public void update(Person person, ServiceProvider serviceProvider, Corporation corporation, Address address){
		
		this.session.clear();
		this.session.saveOrUpdate(address);
		person.setRole(Role.SERVICE_PROVIDER);
		person.setActive(true);
		this.session.update(person);
		
		serviceProvider.setCorporation(corporation);
		serviceProvider.setPerson(person);
		
		this.session.saveOrUpdate(serviceProvider);
		
		corporation.setServiceProvider(serviceProvider);
		this.session.saveOrUpdate(corporation);
		
		/*
		Person p = this.findById(person.getId());
		
		Address addr = p.getAddress();
		
		addr.setCity(address.getCity());
		addr.setComplement(address.getComplement());
		addr.setDistrict(address.getDistrict());
		addr.setNumber(address.getNumber());
		addr.setZipCode(address.getZipCode());
		
		this.session.saveOrUpdate(addr);
		
		p.setAddress(addr);
		p.setRole(Role.SERVICE_PROVIDER);
		p.setActive(true);
		p.setCell(person.getCell());
		p.setPhone(person.getPhone());
		p.setName(person.getName());
		p.setEmail(person.getEmail());
		p.setPassword(person.getPassword());
		
		this.session.update(p);
		
		ServiceProvider serviceP = (ServiceProvider)this.session.load(ServiceProvider.class, p.getServiceProvider().getId());
		
		serviceP.setCorporation(corporation);
		serviceP.setPerson(p);
		serviceP.setFantasyName(serviceProvider.getFantasyName());
		
		this.session.saveOrUpdate(serviceP);
		
		corporation = (Corporation)this.session.load(Corporation.class, serviceP.getCorporation().getId());
		
		corporation.setServiceProvider(serviceP);
		this.session.saveOrUpdate(corporation);
		
		this.userInfo.refreshUser();
		*/
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> findAll(){
		
		String hql = " from Person p left join fetch p.serviceProvider s " +
					 "inner join fetch s.corporation c where p.active = true";
		
		Query query = this.session.createQuery(hql);
		
		List<Person> p = query.list();
		
		if(p.isEmpty()){
			
			String hqlAux = " from Person p fetch all properties" +
							" where p.role = 'CUSTOMER' or p.role = 'ADMINISTRATOR'" +
							" and p.active = true";
			
			Query queryAux = this.session.createQuery(hqlAux);
			
			return queryAux.list();
		}
		
		
		return p;
		
	}
	
	public void delete(Person person){
		this.session.delete(person);
	}
	
	public Person findById(Long id){
		return (Person)this.session.load(Person.class, id);
	}
	
	public List<City> getCities(){
		return this.cityDao.findAll();
	}
	
	public Corporation findCorpById(long id){
		return (Corporation)this.session.load(Corporation.class, id);
	}
}
