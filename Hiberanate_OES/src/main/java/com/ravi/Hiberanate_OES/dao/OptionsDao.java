package com.ravi.Hiberanate_OES.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.ravi.Hiberanate_OES.Entities.Options;
import com.ravi.Hiberanate_OES.Entities.Questions;

import jakarta.persistence.Query;

public class OptionsDao {

	// Options class Method
    public static Options createOptions(Scanner sr, Session session) {
      //  System.out.println("Options Table");
      //  System.out.println("-------------");
        
        System.out.println("Enter Option Number: ");
        int opt_Num = sr.nextInt();
        System.out.println("Enter Correct Option: ");
        String opt_Crt = sr.next();
        System.out.println("Enter Wrong Option: ");
        String opt_Wrong = sr.next();

        // creating object for Options class 
        Options options = new Options();
        options.setOptionNumber(opt_Num);
        options.setCorrectOpt(opt_Crt);
        options.setWrongOpt(opt_Wrong);
        
        // Fetch Question without involving exam
        System.out.println("Enter Question Id for the options: ");
        int qId = sr.nextInt();
        Questions question = session.get(Questions.class, qId);  // Only access Question table

        if (question != null) {
            options.setQuestions(question);  // Associate the options with the questions
            question.getQuestions().add(options);  // Maintain bidirectional relationship
        } else {
            System.out.println("Question Id with "+qId+" is not found!");
        }

        return options;
    }
    
    public static void deleteOptions(Scanner sr, Session session) {
      System.out.println("Enter which optionId do you want to delete: ");
     	 int optId = sr.nextInt();  // Example: Assume you want to delete the user with ID 123
     	 Options options = session.find(Options.class, optId);  // Find the entity by its primary key
     	// Check if the record exists
     	    if (options != null) {
     	        // If the entity is found, remove it
     	        session.remove(options);
     	        System.out.println("Options with ID " + optId + " has been deleted.");
     	    } else {
     	        System.out.println("No option found with ID: " + optId);
     	    }
    }
    
  public static void updateOptions(Scanner sr, Session session) {
	  
    System.out.println("Enter Option Number which you want to update: ");
   	int opt_Id = sr.nextInt();
       Options optionsTable = session.find(Options.class,opt_Id);
       if(optionsTable != null) // if the tables is present then enter into the loop and execute
       {
       	System.out.println("Which field do you want to update: ");
       	System.out.println(" 1. Correct Option \n 2. Wrong Option \n Select an Option: ");
       	int choice3 = sr.nextInt();
       	switch(choice3) {
       	case 1:
       		System.out.println("Enter New Correct Option : ");
       		String crt_Opt = sr.next();
       		optionsTable.setCorrectOpt(crt_Opt);
       		break;
       	case 2:
   			System.out.println("Enter New Wrong Option : ");
   			String w_Opt = sr.next();
   			optionsTable.setWrongOpt(w_Opt);
   			break;
       	}	
       }
       else {
       	System.out.println("Searching with id number "+opt_Id+" is not found");
       	
       }
	}
  
  public static void selectOptions(Session session) {
	  Query query6 = session.createQuery("Select op From Options op", Options.class);
	        List<Options> optList = query6.getResultList();
	        System.out.println("\nOptionId\tcorrectOpt\twrongOpt\tqId");
	        System.out.println("----------------------------------------------------------------------");

	        for (Options opt : optList) {
	        	System.out.println(opt.getOptionNumber()+"\t\t"+opt.getCorrectOpt()+"\t\t"+opt.getWrongOpt()+"\t\t"+opt.getQuestions());
	        	//System.out.println(user);
	       }
	        System.out.println("-----------------------------------------------------------------------\n");
	   	
  		}
}
