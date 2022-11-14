package org.generation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.generation.entity.*;
import org.generation.repository.*;

@Service
public class OriginService  {
	@Autowired
	IOriginRepository iOriginRepository;
	
	
	public Iterable<Origin> getAllOrigin(){
		return iOriginRepository.findAll();
	}
	
	public Origin saveOrigin(Origin origin) {
		return iOriginRepository.save(origin);
	}
	
}