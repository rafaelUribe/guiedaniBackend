package org.generation.controller;

import org.generation.entity.*;
import org.generation.repository.*;
import org.generation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins="*")
public class CustomerController {
  @Autowired
  CustomersService customersService;


  @PostMapping
  @ResponseBody
  public ResponseEntity<?> addNewCustomer(
		 
		 @RequestParam String name,
		 @RequestParam String lastname,
		 @RequestParam String address,
		 @RequestParam String email,
		 @RequestParam String password
		 
		 
		 ) {
	  
	  Customers customer = new Customers();
	  
	  try {
		  
		  customer.setName(name);
		  customer.setLastname(lastname);
		  customer.setAddress(address);
		  customer.setEmail(email);
		  customer.setPassword(password);
		  
		  
		  return new ResponseEntity<Customers>(customersService.saveCustomer(customer),HttpStatus.CREATED);
	  }catch(Exception e){
		  return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	  }
	  
  }

	  
  @GetMapping
  public @ResponseBody Iterable<Customers> getAllCustomer() {
    // This returns a JSON or XML with the users
    return customersService.getAllCustomer();
  }
}

