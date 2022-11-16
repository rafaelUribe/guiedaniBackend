package org.generation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.generation.entity.Customers;
import org.generation.repository.*;

@Service
public class CustomersService {
	@Autowired
	ICustomersRepository iCustomersRepository;
	
	
	public Iterable<Customers> getAllCustomer(){
		return iCustomersRepository.findAll();
	}
	
	public Customers saveCustomer(Customers customer) {
		return iCustomersRepository.save(customer);
	}

}
