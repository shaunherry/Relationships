package com.shaun.relationships.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shaun.relationships.models.Person;

@Repository
public interface DriverRepo extends CrudRepository<Person, Long>{
	
	
//	List<Person>save();
	
	List<Person> findAll();
	
	
}
