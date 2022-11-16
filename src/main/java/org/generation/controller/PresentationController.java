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
@RequestMapping("/api/presentation")
@CrossOrigin(origins="*")
public class PresentationController {
  @Autowired
  PresentationService presentationService;


  @PostMapping
  @ResponseBody
  public ResponseEntity<?> addNewPresentation(

		 @RequestParam String name) {
	  
	  Presentation presentation = new Presentation();
	  
	  try {		  
		  presentation.setName(name);	  
		  return new ResponseEntity<Presentation>(presentationService.savePresentation(presentation),HttpStatus.CREATED);
	  }catch(Exception e){
		  return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	  }
	  
  }

	  
  @GetMapping
  public @ResponseBody Iterable<Presentation> getAllPresentation() {
    // This returns a JSON or XML with the users
    return presentationService.getAllPresentation();
  }
}
