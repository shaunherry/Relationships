package com.shaun.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaun.relationships.models.License;
import com.shaun.relationships.models.Person;
import com.shaun.relationships.repos.DriverRepo;
import com.shaun.relationships.repos.LicenseRepo;

@Service
public class DriverService {
@Autowired
private DriverRepo driverRepo;
private LicenseRepo licenseRepo;
	
	public List<Person> all() {
		return driverRepo.findAll();
	}
	 public List<License> Lall() {
	        return licenseRepo.findAll();
	    }
	
	public Person createP(Person person) {
		return driverRepo.save(person);
	}
	
	public License createL(License license) {
        System.out.println(license);
        return licenseRepo.save(license);
	}
	
	public Person delete(Long id) {
		driverRepo.deleteById(id);
		return null;
	}
	
	public Person find(Long id) {
		Optional<Person> optionalDriver = driverRepo.findById(id);
		if(optionalDriver.isPresent()) {
			return optionalDriver.get();
		} else {
			return null;
		}
	}
	public License findL(Long id) {
        Optional<License> optionalL = licenseRepo.findById(id);
        if(optionalL.isPresent()) {
            return optionalL.get();
        } else {
            return null;
        }
    }


}
