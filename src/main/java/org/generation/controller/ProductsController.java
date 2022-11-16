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
@RequestMapping("/api/products")
@CrossOrigin(origins="*")
public class ProductsController {
  @Autowired
  ProductsService productsService;


  @PostMapping
  @ResponseBody
  public ResponseEntity<?> addNewProduct(
		 @RequestParam String name,
		 @RequestParam Double price,
		 @RequestParam String img_1,
		 @RequestParam String img_2,
		 @RequestParam String img_3,
		 @RequestParam String img_4,
		 @RequestParam String description,
		 @RequestParam Origin id_origin,
		 @RequestParam Integer grams
		 //@RequestParam Roast id_roast,
		 //@RequestParam Presentation id_presentation
		 ) {
	  
	  Products products = new Products();
	  
	  try {
		  products.setName(name);
		  products.setPrice(price);
		  products.setImg_1(img_1);
		  products.setImg_2(img_2);
		  products.setImg_3(img_3);
		  products.setImg_4(img_4);
		  products.setDescription(description);
		  products.setId_origin(id_origin);
		  products.setGrams(grams);
		  //products.setId_roast(id_roast);
		  //products.setId_presentation(id_presentation);
		  
		  return new ResponseEntity<Products>(productsService.saveProducts(products),HttpStatus.CREATED);
	  }catch(Exception e){
		  return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	  }
	  
  }

	  
  @GetMapping
  public @ResponseBody Iterable<Products> getAllProducts() {
    // This returns a JSON or XML with the users
    return productsService.getAllProducts();
  }
}

