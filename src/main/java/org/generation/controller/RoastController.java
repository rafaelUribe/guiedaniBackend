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
@RequestMapping("/api/roast")
@CrossOrigin(origins="*")
public class RoastController {
  @Autowired
  RoastService roastService;


  @PostMapping
  @ResponseBody
  public ResponseEntity<?> addNewRoast(

		 @RequestParam String name) {
	  
	  Roast roast = new Roast();
	  
	  try {		  
		  roast.setName(name);	  
		  return new ResponseEntity<Roast>(roastService.saveRoast(roast),HttpStatus.CREATED);
	  }catch(Exception e){
		  return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	  }
	  
  }

	  
  @GetMapping
  public @ResponseBody Iterable<Roast> getAllRoast() {
    // This returns a JSON or XML with the users
    return roastService.getAllRoast();
  }
}

