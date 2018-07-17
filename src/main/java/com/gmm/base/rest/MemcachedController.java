package com.gmm.base.rest;

//Author: Muthu Mariyappan G


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemcachedController {
	
	@Autowired
	private MemcachedService memcservice;
	
	@RequestMapping(value="/set")  
	public String set(@RequestParam("id") String id,@RequestParam("name") String name) {
		this.memcservice.setValue(id, name);
		return "Name "+name+" is added successfully!";
	}
	@RequestMapping(value="/get/{id}")  
	public String get(@PathVariable("id") String id) {
		return "ID: "+id+", Name :"+this.memcservice.getValue(id);
	}
	@RequestMapping(value="/delete/{id}")  
	public String delete(@PathVariable("id") String id) {
		String name = this.memcservice.getValue(id);
		this.memcservice.deleteValue(id);
		return "Deleted key value pair is : ID: "+id+", Name :"+name;
	}
}