package com.mphasis.training;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.jaxb.mapping.hbm.JaxbKeyManyToOneElement;

import com.mphasis.training.entities.Department;
import com.mphasis.training.entities.Employee;
import com.mphasis.training.entities.Job;
import com.mphasis.training.entities.Location;
import com.mphasis.util.HibernateUtil;

public class HibernateApp {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		
		Employee e=new Employee();
		Job j=new Job();
		Department department=new Department();
		Location location=new Location();
		e.setBonus(800);
	    
		e.getDepartment().setDcode(1000);
		e.getDepartment().setDname("ABC");
		//location.setLcode(111);
		//location.setLname("Mangalore");
		//department.setDcode(1000);
		//department.setDname("ABC");
		//department.getLocations().add(location);
		e.getDepartment().getLocations().add(new Location(111, "Mangalore"));
		
		e.setDepartment(department);
		e.setDoj(new Date());
		
		e.setEid(1);
		
		e.setEname("Vishal");
		
		//j.setJcode("J111");
		//j.setJname("Tester");
		//e.setJob(j);
		e.getJob().setJcode("J111");
		e.getJob().setJname("Tester");
		
		e.setSalary(55000);
		
		e.setMngrid(e);
		
		
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
	//	session.save(j);
	//	session.save(location);
	//	session.save(department);
		session.save(e);
		session.getTransaction().commit();
		session.close();
		
		
		
		System.out.println("Success");

	}

}
