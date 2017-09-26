package com.hwq.ssh.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwq.ssh.dao.PersonDao;
import com.hwq.ssh.entity.Person;
@Service
@Transactional
public class PersonService {
	@Autowired
	private PersonDao personDao;
	
	public List<Person> getPerson(){
		return personDao.getPerson();
	}
	
	public Person getPersonById(String id) {
		return personDao.getPersonById(id);
	}
	
	public void addPerson(Person person) {
		personDao.addPerson(person);
	}
	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}
	public void deletePerson(String id) {
		personDao.deletePerson(id);
	}
}
