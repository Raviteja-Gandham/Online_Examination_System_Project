package com.ravi.Hiberanate_OES.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.ravi.Hiberanate_OES.Entities.Exam;
import com.ravi.Hiberanate_OES.Entities.Questions;

import jakarta.persistence.Query;

public class QuestionsDao {

	// Questions class Method
    public static Questions createQuestions(Scanner sr, Session session) {
      //  System.out.println("Questions Table");
      //  System.out.println("-------------");
       
        System.out.println("Enter Question Id: ");
        int q_Id = sr.nextInt();
        System.out.println("Enter Question Type (e.g., Multi-choice, essay, etc.): ");
        String q_Type = sr.next();
        System.out.println("Enter Total Marks: ");
        int q_Marks = sr.nextInt();

        // creating object for Questions class
        Questions questions = new Questions();
        questions.setqId(q_Id);
        questions.setQueType(q_Type);
        questions.setMarks(q_Marks);
        
        // Fetch exam without involving course
        System.out.println("Enter Exam Id for the Questions: ");
        int examId = sr.nextInt();
        Exam exam = session.get(Exam.class, examId);  // Only access Exam table

        if (exam != null) {
            questions.setExam(exam);  // Associate the Question with the exam
            exam.getQuestions().add(questions);  // Maintain bidirectional relationship
        } else {
            System.out.println("Exam Id with "+examId+" is not found!");
        }

        return questions;
    }

    public static void deleteQuestions(Scanner sr, Session session) {
    	System.out.println("Enter which questionId do you want to delete: ");
     	 int qId = sr.nextInt();  // Example: Assume you want to delete the user with ID 123
     	 Questions questions = session.find(Questions.class, qId);  // Find the entity by its primary key
     	// Check if the record exists
     	    if (questions != null) {
     	        // If the entity is found, remove it
     	        session.remove(questions);
     	        System.out.println("Questions with ID " + qId + " has been deleted.");
     	    } else {
     	        System.out.println("No questions found with ID: " + qId);
     	    }
    }
    
  public static void updateQuestions(Scanner sr, Session session) {  
    System.out.println("Enter Question id which you want to update: ");
   	int q_Id = sr.nextInt();
       Questions questionTable = session.find(Questions.class,q_Id);
       if(questionTable != null) // if the tables is present then enter into the loop and execute
       {
       	System.out.println("Which field do you want to update: ");
       	System.out.println(" 1. Question Type \n 2. Marks for question \n Select an Option: ");
       	int choice3 = sr.nextInt();
       	switch(choice3) {
       	case 1:
       		System.out.println("Enter New Question Type (Multi-choice,Essay,etc...): ");
       		String qType = sr.next();
       		questionTable.setQueType(qType);
       		break;
       	case 2:
   			System.out.println("Enter New Marks for queston: ");
   			int qMarks = sr.nextInt();
   			questionTable.setMarks(qMarks);
   			break;
       	}	
       }
       else {
       	System.out.println("Searching with id number "+q_Id+" is not found");
       }
  	}
  
 public static void selectQuestions(Session session) {
     Query query5 = session.createQuery("Select q From Questions q", Questions.class);
      List<Questions> questionList = query5.getResultList();
      System.out.println("\nqId\tmarks\tqueType\t\texamId");
      System.out.println("----------------------------------------------------------------------");

      for (Questions q : questionList) {
      	System.out.println(q.getqId()+"\t"+q.getMarks()+"\t"+q.getQueType()+"\t"+q.getExam());
      	//System.out.println(user);
     }
      System.out.println("-----------------------------------------------------------------------\n");
 	}
}
