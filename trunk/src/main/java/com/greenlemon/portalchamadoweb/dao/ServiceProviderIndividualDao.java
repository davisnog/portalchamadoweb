package com.greenlemon.portalchamadoweb.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;

import com.greenlemon.portalchamadoweb.interceptor.UserInfo;
import com.greenlemon.portalchamadoweb.model.Address;
import com.greenlemon.portalchamadoweb.model.City;
import com.greenlemon.portalchamadoweb.model.Individual;
import com.greenlemon.portalchamadoweb.model.Person;
import com.greenlemon.portalchamadoweb.model.Role;
import com.greenlemon.portalchamadoweb.model.ServiceProvider;

@Component
public class ServiceProviderIndividualDao {
	
	private final Session session;
	private CityDao cityDao;
	private UserInfo userInfo;
	
	public ServiceProviderIndividualDao(Session session, CityDao cityDao, UserInfo userInfo){
		this.session = session;
		this.cityDao = cityDao;
		this.userInfo = userInfo;
	}
	
	public void create(Person person, ServiceProvider serviceProvider, Individual individual, Address address){
		
		this.session.save(address);
		
		person.setRole(Role.SERVICE_PROVIDER);
		person.setActive(true);
		person.setAddress(address);
		this.session.save(person);
		
		serviceProvider.setPerson(person);
		this.session.save(serviceProvider);
		
		individual.setServiceProvider(serviceProvider);
		this.session.save(individual);
	}
	
	public void update(Person person, ServiceProvider serviceProvider, Individual individual, Address address){
		
		this.session.clear();
		this.session.saveOrUpdate(address);
		person.setRole(Role.SERVICE_PROVIDER);
		person.setActive(true);
		this.session.update(person);
		
		serviceProvider.setIndividual(individual);
		serviceProvider.setPerson(person);
		
		this.session.saveOrUpdate(serviceProvider);
		
		individual.setServiceProvider(serviceProvider);
		this.session.saveOrUpdate(individual);
		
		/*
		Person p = this.findById(person.getId());
		
		Address addr = p.getAddress();
	
		addr.setCity(address.getCity());
		addr.setComplement(address.getComplement());
		addr.setDistrict(address.getDistrict());
		addr.setNumber(address.getNumber());
		addr.setZipCode(address.getZipCode());
		this.session.saveOrUpdate(addr);
	*/	
		
		/*
		p.setAddress(address);
		
		p.setRole(Role.SERVICE_PROVIDER);
		p.setActive(true);
		p.setCell(p.getCell());
		p.setPhone(p.getPhone());
		p.setName(p.getName());
		p.setEmail(p.getEmail());
		p.setPassword(p.getPassword());
		
		this.session.update(p);
		
		ServiceProvider serviceP = (ServiceProvider)this.session.load(ServiceProvider.class, p.getServiceProvider().getId());
		
		serviceP.setIndividual(individual);
		serviceP.setPerson(p);
		serviceP.setFantasyName(serviceP.getFantasyName());
		
		this.session.saveOrUpdate(serviceP);
		
		individual = (Individual)this.session.load(Individual.class, serviceP.getCorporation().getId());
		
		individual.setServiceProvider(serviceP);
		this.session.saveOrUpdate(individual);
		
		this.userInfo.refreshUser();
		*/
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> findAll(){
		
		String hqlDefault = " from Person p left join fetch p.serviceProvider s " +
		 				     "inner join fetch s.individual i where p.active = true";
		Query query = this.session.createQuery(hqlDefault);
		
		List<Person> p = query.list();
		
		if(p.isEmpty()){
			
			String hqlAux = " from Person p fetch all properties" +
							" where p.active = true " +
							"and (p.role = 'CUSTOMER' or p.role = 'ADMINISTRATOR')";
			
			Query queryAux = this.session.createQuery(hqlAux);
			
			return queryAux.list();
		}
		
		return p;
	}
	
	public void delete(Person person){
		person.setId(person.getId());
		person.setActive(false);
		this.session.update(person);
	}
	
	public Person findById(Long id){
		
		String hql = "from Person p fetch all properties where p.id = :id";
		
		Query query = this.session.createQuery(hql);
		query.setParameter("id", id);
		
		return (Person)query.uniqueResult();
	}
	
	public List<City> getCities(){
		return this.cityDao.findAll();
	}
}
