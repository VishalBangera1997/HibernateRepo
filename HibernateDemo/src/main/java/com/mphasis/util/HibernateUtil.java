package com.mphasis.util;



import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


import com.mphasis.training.entities.Department;
import com.mphasis.training.entities.Employee;
import com.mphasis.training.entities.Job;
import com.mphasis.training.entities.Location;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory=null;
	
	private HibernateUtil()
	{
		
	}
	
	public static SessionFactory getSessionFactory()
	{
		Configuration con=new Configuration();
		 Properties props=new Properties();
	        props.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
	        props.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:xe");
	        props.put(Environment.USER, "newdb");
	        props.put(Environment.PASS, "newdb");
	        props.put(Environment.DIALECT, "org.hibernate.dialect.OracleDialect");
	        props.put(Environment.HBM2DDL_AUTO, "create");
	        props.put(Environment.SHOW_SQL, "true");
	        props.put(Environment.FORMAT_SQL, "true");  
	        props.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
	        props.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");
	        con.setProperties(props);
	        con.addAnnotatedClass(Job.class);
	        con.addAnnotatedClass(Employee.class);
	        con.addAnnotatedClass(Location.class);
	        con.addAnnotatedClass(Department.class);
	        StandardServiceRegistryBuilder builder=
	                new StandardServiceRegistryBuilder().applySettings(con.getProperties());
	         sessionFactory = con.buildSessionFactory(builder.build());
		
		return sessionFactory;
	}

}
