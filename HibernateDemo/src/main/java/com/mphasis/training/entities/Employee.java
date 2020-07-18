package com.mphasis.training.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Employee {
	@Id
	private int eid;
	
	private String ename;
	
	private double salary;
	
	private double bonus;
	
	private Date doj;
	
	@ManyToOne
	private Employee mngrid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Department department=new Department();
	
	@ManyToOne(cascade = CascadeType.ALL)
	Job job=new Job();

	public Employee() {
		super();
	}

	public Employee(int eid, String ename, double salary, double bonus, Date doj, Department department, Job job) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.bonus = bonus;
		this.doj = doj;
		this.department = department;
		this.job = job;
	}

	public Employee getMngrid() {
		return mngrid;
	}

	public void setMngrid(Employee mngrid) {
		this.mngrid = mngrid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	

	
	

}
