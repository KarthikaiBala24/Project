package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private int id;
	private int grandTotal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	
}
