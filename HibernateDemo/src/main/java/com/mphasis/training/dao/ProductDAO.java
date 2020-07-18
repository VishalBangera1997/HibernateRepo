package com.mphasis.training.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mphasis.training.entities.Product;

public class ProductDAO {
	
	SessionFactory sessionFactory=null;
	
	public ProductDAO()
	{
		Configuration con=new Configuration().configure().addAnnotatedClass(Product.class);
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		sessionFactory=con.buildSessionFactory(builder.build());
	}
	
	public void insertProduct(Product p)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
	}
	
	public void UpdateProduct(Product p)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteProduct(int pid)
	{
		Session session=null;
		try {
		session=sessionFactory.openSession();
		session.beginTransaction();
		Product p=(Product)session.get(Product.class, pid);
		session.delete(p);
		session.getTransaction().commit();
		}catch(Exception e)
		{
			session.getTransaction().rollback();
		}finally {
		session.close();
		}
	}
	
	public Product retrieveProductById(int pid)
	{
		Session session=sessionFactory.openSession();
		Product product=(com.mphasis.training.entities.Product) session.get(Product.class, pid);
		return product;
	}
	
	public List<Product> retrieveProducts()
	{
		List<Product> products=new ArrayList<>();
		Session session=sessionFactory.openSession();
		products=session.createCriteria(Product.class).list();
		return products;
		
	}
	
	public List<Product> retrieveByCost(double cost)
	{
		List<Product> products=new ArrayList<>();
		Session session=sessionFactory.openSession();
		products=session.createCriteria(Product.class).add(Restrictions.eq("cost", cost)).list();
		return products;
		
	}

}
