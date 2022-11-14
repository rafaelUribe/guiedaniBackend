package org.generation.controller;

import org.generation.entity.*;
import org.generation.repository.IOriginRepository;
import org.generation.service.OriginService;
import org.generation.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/origin")
@CrossOrigin(origins="*")
public class OriginController {

	@Autowired
	OriginService originService;
	
	@PostMapping(path="/add") 
	@ResponseBody
	public ResponseEntity<?> addNewOrigin(@RequestParam String name) {
		try {
			Origin origin = new Origin();
			origin.setName(name);
			return new ResponseEntity<Origin>(originService.saveOrigin(origin),HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		  
	}
	
	@GetMapping(path="/all")
	  public @ResponseBody Iterable<Origin> getAllProducts() {
	    // This returns a JSON or XML with the users
	    return originService.getAllOrigin();
	  }
}
