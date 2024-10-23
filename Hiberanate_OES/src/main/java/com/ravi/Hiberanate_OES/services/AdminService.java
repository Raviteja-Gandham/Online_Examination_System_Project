package com.ravi.Hiberanate_OES.services;

// imported packages
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ravi.Hiberanate_OES.Entities.Admin;

// class
public class AdminService {
	
		   private SessionFactory sessionFactory;

		    public AdminService() {
		        sessionFactory = new Configuration().configure().buildSessionFactory();
		    }
		    public boolean login(String username, String password) {
		        Session session = sessionFactory.openSession();
		        Transaction transaction = null;
		        boolean isValidAdmin = false;
		        
		        try {
		            transaction = session.beginTransaction();
		            Admin admin = session.createQuery("FROM Admin WHERE userName = :userName AND password = :password", Admin.class)
		                               .setParameter("userName", username)
		                               .setParameter("password", password)
		                               .uniqueResult();
		            
		            transaction.commit();
		            isValidAdmin = admin != null;
		        } catch (Exception e) {
		            if (transaction != null) transaction.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		     }
		     return isValidAdmin;
	    }
		    
		    // logout methods
		    public static void logout(Scanner sr) {
		    	while(true) {
		    		 	System.out.println("\u001B[31m");
		        		System.out.println("Do you want to Logout (yes/no): ");
		        		System.out.println("\u001B[0m");
		        		String s = sr.next();
		        		if(s.equalsIgnoreCase("yes")) {
		        			
		        			System.out.println("\u001B[32m");
		        			System.out.println("You logout Successfully...");
		        			System.out.println("\u001B[0m");
		        			break;
		        		} else {
		        			System.out.println("\nOk! if you want to logout please choose 'yes' ");
		        		}
		    		}
		    }
}
