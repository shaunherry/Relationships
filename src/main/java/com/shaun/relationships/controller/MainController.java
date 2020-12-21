package com.shaun.relationships.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shaun.relationships.models.License;
import com.shaun.relationships.models.Person;
import com.shaun.relationships.services.DriverService;


@Controller
public class MainController {
	@Autowired
	private DriverService driverService;
		@RequestMapping("/")
		public String index(@ModelAttribute("person") Person person) {
			return "index.jsp";
		}
		@RequestMapping("/license")
		public String license(@ModelAttribute("license") License license, Model model) {
			List<Person> persons = driverService.all();
			model.addAttribute("persons", persons);
			return "license.jsp";
		}
		@PostMapping("/create")
		public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
	        if (result.hasErrors()) {
	            return "index.jsp";
	        } else {
			driverService.createP(person);
			return "redirect:/license";
	        }
		}
		@PostMapping("/create/license")
		public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
			if (result.hasErrors()) {
	            return "license.jsp";
	        } else {
	        	System.out.println(license.getState());
			driverService.createL(license);
			return "redirect:/view/" + license.getPerson().getId();
	        }
		}
		@RequestMapping("/view/{id}")
		public String view(@Valid @ModelAttribute("license") License license, @PathVariable("id") Long id, Model model) {
			Person person = driverService.find(id);
			Person card = driverService.find(id);
			model.addAttribute("license", card);
			model.addAttribute("person", person);
			return "view.jsp";
		}
		
		
		
		
	

}
