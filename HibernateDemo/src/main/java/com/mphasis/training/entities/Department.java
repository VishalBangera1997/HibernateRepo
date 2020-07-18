package com.mphasis.training.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	private int dcode;
	
	private String dname;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Location> locations=new ArrayList<Location>();
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Employee> employees=new ArrayList<Employee>();

	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Department() {
		super();
	}

	public Department(int dcode, String dname, List<Location> locations) {
		super();
		this.dcode = dcode;
		this.dname = dname;
		this.locations = locations;
	}

	public int getDcode() {
		return dcode;
	}

	public void setDcode(int dcode) {
		this.dcode = dcode;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	

}
