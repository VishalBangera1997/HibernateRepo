package com.mphasis.training.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int prodId;
	private String prodName;
	private double cost;
	private int quantity;
	
	public Product()
	{
		
	}

	public Product(int prodId, String prodName, double cost, int quantity) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.cost = cost;
		this.quantity = quantity;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", cost=" + cost + ", quantity=" + quantity
				+ "]";
	}
	
	

}
