package com.mphasis.training;

import java.util.List;
import java.util.Scanner;

import com.mphasis.training.dao.ProductDAO;
import com.mphasis.training.entities.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
        ProductDAO productdao=new ProductDAO();
        System.out.println("Product App");
        do {
        	System.out.println("1.Add Product \n2.Update Product \n3.Delete Product \n4.Get Product by Id "
        			+ "\n5. Get All Products \n6.Get product by cost  ");
        	switch(sc.nextInt())
        	{
        	case 1:Product p=new Product(); 
        		System.out.println("Enter Product ID");
        		p.setProdId(sc.nextInt());
        		System.out.println("enter product name");
        		p.setProdName(sc.next());
        		System.out.println("Enter product cost");
        		p.setCost(sc.nextDouble());
        		System.out.println("Enter Qunatity");
        		p.setQuantity(sc.nextInt());
        		productdao.insertProduct(p);
        		System.out.println("Product Added Successfully");
        		break;
        	case 2: System.out.println("Enter product ID you want to update");
        		Product product=productdao.retrieveProductById(sc.nextInt()); 
        		System.out.println("1.Update Name\n2.Update Product Cost\n3.Update product Quantity ");
        	switch(sc.nextInt())
        	{
        	case 1:System.out.println("Enter the new name");
        		product.setProdName(sc.next());
        		productdao.UpdateProduct(product);
        		break;
        	case 2:System.out.println("Enter new Cost");
        	product.setCost(sc.nextDouble());
    		productdao.UpdateProduct(product);
    		break;
        	case 3: System.out.println("Enter new quantity");
        	product.setQuantity(sc.nextInt());
        	productdao.UpdateProduct(product);
    		break;
        	}
        	
        	System.out.println("Product Updated Successfully");
        		break;
        	case 3: System.out.println("Enter product ID");
        	productdao.deleteProduct(sc.nextInt());
        	System.out.println("Product deleted Successfully");
        	break;
        	case 4: System.out.println("Enter product id");
        	Product prod=productdao.retrieveProductById(sc.nextInt());
        	System.out.println(prod);
        	break;
        	case 5:System.out.println("List of all products");
        	productdao.retrieveProducts().forEach(System.out::println);
        	break;
        	case 6: System.out.println("Enter cost");
        	System.out.println((productdao.retrieveByCost(sc.nextDouble())));
        	break;
        	default :
        		break;
        	
        	
        	}
        	
        }while(true);
        
   
    }
}
