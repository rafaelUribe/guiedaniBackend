package org.generation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Order_item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_order_item;
	  
	@ManyToOne
	@JoinColumn(name="id_order")
	private Orders id_order;
	  
	@ManyToOne
	@JoinColumn(name="id_product")
	private Products id_product;
	
	

	public Integer getId_order_item() {
		return id_order_item;
	}

	public void setId_order_item(Integer id_order_item) {
		this.id_order_item = id_order_item;
	}

	public Orders getId_order() {
		return id_order;
	}

	public void setId_order(Orders id_order) {
		this.id_order = id_order;
	}

	public Products getId_product() {
		return id_product;
	}

	public void setId_product(Products id_product) {
		this.id_product = id_product;
	}	

}
