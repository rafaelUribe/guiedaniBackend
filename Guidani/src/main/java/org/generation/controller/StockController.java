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
@RequestMapping("/api/stock")
@CrossOrigin(origins="*")
public class StockController {
  @Autowired
  StockService stockService;


  /*@PostMapping
  @ResponseBody
  public ResponseEntity<?> addNewStock(

		 @RequestParam Integer count) {
	  
	  Stock stock = new Stock();
	  
	  try {		  
		  stock.setCount(count);	  
		  return new ResponseEntity<Roast>(stockService.saveStock(stock),HttpStatus.CREATED);
	  }catch(Exception e){
		  return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	  }
	  
  }*/

	  
  @GetMapping
  public @ResponseBody Iterable<Stock> getAllRoast() {
    // This returns a JSON or XML with the users
    return stockService.getAllStock();
  }
}
