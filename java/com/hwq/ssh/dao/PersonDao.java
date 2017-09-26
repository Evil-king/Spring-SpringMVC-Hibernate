package com.hwq.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hwq.ssh.entity.Person;
@Repository
public class PersonDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSeesion() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getPerson(){
		return (List<Person>)this.getSeesion()
				.createCriteria(Person.class).list();
	}
	
	public Person getPersonById(String id) {
		return (Person) this.getSeesion().createQuery("from Person where id=?")
				.setParameter(0, id).uniqueResult();
	}
	
	public void addPerson(Person person) {
		this.getSeesion().save(person);
	}
	
	public void updatePerson(Person person) {
		this.getSeesion().update(person);
	}
	
	public void deletePerson(String id) {
		this.getSeesion().createQuery("delete Person where id=?").setParameter(0, id).executeUpdate();
	}
}
