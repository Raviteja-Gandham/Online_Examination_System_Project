/*
package com.ravi.Hiberanate_OES.services;

import java.util.Scanner;

import org.hibernate.Session;

import com.ravi.Hiberanate_OES.Entities.Result;
import com.ravi.Hiberanate_OES.Entities.User;

	 public class ExamService
	    {
		 	static Scanner sr = new Scanner(System.in);
		 
		 	private String  questions[];
	        private int answer[];
	        private int userAnswer[];
//	        
		 //public static ExamService examService() {
			 public ExamService()

	    	{
	            questions = new String[5];
	    		answer=new int[5];
	    		userAnswer=new int[5];
	        }
	        	public void addQuestion(String question,int qnum,int ans) 
	    	{
	    		questions[qnum]=question;
	    		answer[qnum]=ans; 
	        	}
	        	public void conductExam() 
	    	{
	            	int score = 0;
	            	System.out.println("	Your Exam has been Started	");
	    		int c=0;
	            	for (int i = 0; i < questions.length; i++) 
	    		{		
	                		System.out.println("\nQuestion " +( i + 1 )+ ": " + questions[i] );
	                		System.out.print("Your answer: ");
	               		userAnswer[i] = sr.nextInt();
	    			if (userAnswer[i]==(answer[i])) 
	    			{
	                    		score++;
	    			}
	            	}
	    			String green="\u001B[32m";
	            	System.out.println(green);
	    			System.out.println("		Exam finished !!		"+"\u001B[0m");
	    			
	    			
	    		if(score==questions.length)
	    		{
	    			String yellow="\u001B[33m";
	    			String blink="\u001B[5m";
	    			String reset="\u001B[0m";
	    			System.out.print(yellow);
	    			System.out.println(blink);
	    			System.out.println("   *****  congratulations  *****		");
	    			System.out.println(reset);
	    		}
	    		for(int i=0;i<questions.length;i++)
	    		{
	    			
	    			System.out.println("Q "+(i+1)+" "+" \n actual answer # " +answer[i]+ " \n your Answer #"+ userAnswer[i]);
	    	
	    		}
	    				String yellow="\u001B[33m";
	    				String reset="\u001B[0m";
	    				
	    				System.out.println(yellow);
	            		System.out.println("Your score: " + score + " out of " + questions.length);
	    				System.out.println(reset);
	}
	   
	        	public static void start(Session session)
	        	{
	        		System.out.println("Enter user Id : ");
	            	 int userId = sr.nextInt();  // Example: Assume you want to delete the user with ID 123
	            	 User user = session.find(User.class, userId);  // Find the entity by its primary key
	            	// Check if the record exists
	            	    if (user != null) {
	            	        // If the entity is found, remove it
	            	    	System.out.println("	Do you want to start the exam (yes/no)?	");
	    	        		String s= sr.next();
	    	        		if(s.equalsIgnoreCase("yes"))
	    	        		{
	    	                	ExamService exam = new ExamService();
	    	        			String red ="\u001B[31m";
	    	        			String reset="\u001B[0m";
	    	        			//System.out.println(red);
	    	        			exam.addQuestion(red+"Who is the CEO of TCS in 2024___ \n"+reset+"1. Natarajan Chandrashekaran \n2. Rajesh Gopinathan\n3. K. Krithivasan\n4. Ratan Tata\n ", 0, 3);
	    	        			
	    	        			exam.addQuestion(red+"Who is the Founder of Tata Group____.\n"+reset+"1. J. R. D. Tata \n2. Ratan Tata \n3. Natarajan\n4. adjustment\n ",1, 1);
	    	                	
	    	        			exam.addQuestion(red+"TCS HeadQuartered Located in__\n"+reset+"1. Hyderabad\n2. Mumbai\n3.  Bangalore\n4. Chennai\n ",2, 2);
	    	                	exam.addQuestion(red+"TCS is___based company\n"+reset+"1. import & Export\n2. Product\n3. Service \n4. Marketing Company\n ", 3,3);
	    	        			exam.addQuestion(red+"TCS stands for____\n"+reset+"1. Tata Consultancy Son\n2. Tata Control Service\n3. Trade Control Cost \n4. Tata Consultancy Services\n ", 4,4);
	    	        			
	    	               		exam.conductExam();
	    	        			end();
	    	        		}
	    	        		else
	    	        		{
	    	        			end();
	    	        		}
	    	        		
	    	        	
	            	        session.save(user);
	            	        System.out.println("User with ID " + userId + " has been Saved.");
	            	    } else {
	            	        System.out.println("No user found with ID: " + userId);
	            	    }
	        	}
	        		
	        	static void end()
	        	{
	                       String green="\u001B[32m";
	                       System.out.print(green);
	        		System.out.println("		Thank you....		");
	                       String reset="\u001B[0m";
	                       System.out.print(reset);
	                       
	                       
	       }
} 
*/


package com.ravi.Hiberanate_OES.services;

// imported packages
import java.util.Scanner;

import org.hibernate.Session;

import com.ravi.Hiberanate_OES.Entities.Result;
import com.ravi.Hiberanate_OES.Entities.User;

import jakarta.transaction.Transaction;

// class
public class ExamService {
	
	// Scanner class is used to taking input from the user
    static Scanner sr = new Scanner(System.in);
    
    // ASCII escape codes for color and text handling
    static String green = "\u001B[32m";
    static String red ="\u001B[31m";
    static String yellow="\u001B[33m";
    static String reset="\u001B[0m";
    static String purple="\u001B[35m";
    
    private String questions[];
    private int answer[];
    private int userAnswer[];

    public ExamService() {
        questions = new String[5];
        answer = new int[5];
        userAnswer = new int[5];
    }

    public void addQuestion(String question, int qnum, int ans) {
        questions[qnum] = question;
        answer[qnum] = ans;
    }

    public int conductExam() {
        int score = 0;
        System.out.println("Your Exam has been Started");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            System.out.print("Your answer: ");
            userAnswer[i] = sr.nextInt();
            if (userAnswer[i] == (answer[i])) {
            	score++; // each question carried of 1 mark 
                //score = score + 10 ; // To allot each question carried of 10 marks
            }
        }

        System.out.println(green+"\nExam finished!!"+reset);
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Q " + (i + 1) + " \n Actual answer: #" + answer[i] + " \n Your Answer: #" + userAnswer[i]);
        }
        if(score == questions.length) {
        	System.out.println(green+"\n   *****  congratulations  *****		"+reset);
        }
        System.out.println(yellow+"\nYour score: " + score + " out of " + questions.length+reset);  // out of 50" +reset)
        return score;
    }

    public static void start(Session session) {
    	
    	  System.out.println("Enter user ID: ");
          int userId = sr.nextInt();
          User user = session.find(User.class, userId);

          if (user != null) {
       	
       	   System.out.println("Select Your Subject ... \n 1. Java \n 2. HTML \nSelect choice : ");	
   	
       	   int choice = sr.nextInt();
       	   switch(choice) {
       	   
       	   	case 1:
       	   	System.out.println(purple+"Do you want to start the exam (yes/no)?"+reset);
            String st = sr.next();
            if (st.equalsIgnoreCase("yes")) {
                ExamService exam = new ExamService();
                exam.addQuestion(red+"Which of the following is not a java features?"+reset+"\n1. Dynamic\n2. Architecture Neutral\n3. Use of pointers\n4. Object-oriented\n", 0, 3);
                exam.addQuestion(red+"Which keyword is used for accessing the features of a package?"+reset+"\n1. import\n2. package\n3. extends\n4. export\n", 1, 1);
                exam.addQuestion(red+"Which of the following is a mutable class in java?"+reset+"\n1. java.lang.String\n2. java.lang.StringBuilder\n3. java.lang.Byte\n4. java.lang.Short\n", 2, 2);
                exam.addQuestion(red+"How Many threads can be executed at a time?"+reset+"\n1. Only one thread\n2. Only main thread\n3. Multiple threads\n4. two threads\n", 3, 3);
                exam.addQuestion(red+"Which of these cannot be used for a variable name in java?"+reset+"\n1. none \n2. identifier & keyword\n3. identifier\n4. keyword\n", 4, 4);
                int score = exam.conductExam();

                // Save the result
                saveResult(userId, score, session);
                end();
            }
            else {
                end();
            }
       	   		break;
       	   	case 2:
       	  	System.out.println(purple+"Do you want to start the exam (yes/no)?"+reset);
            String str = sr.next();
            if (str.equalsIgnoreCase("yes")) {
                ExamService exam = new ExamService();
                exam.addQuestion(red+"HTML stands for?"+reset+"\n1. HighText Machine Language\n2. HyperText and links Markup Language\n3. HyperText Markup Language\n4. None of these\n", 0, 3);
                exam.addQuestion(red+"The correct sequence of HTML tags for starting  a webpage is___?"+reset+"\n1. HTML, Title, Head, body \n2. HTML, Head, Title, Body \n3. HTML, Body, Head, Title \n4. Head, HTML, Title, Body \n", 1, 2);
                exam.addQuestion(red+"Which tag is used to insert largest heading in HTML?"+reset+"\n1. <h6> \n2. <h1> \n3. <h5> \n4. <h2> \n", 2, 2);
                exam.addQuestion(red+"Which of the tag is responsible for making the text bold in HTML?"+reset+"\n1. <pre>\n2. <bb>\n3. <b> \n4. <i> \n", 3, 3);
                exam.addQuestion(red+"Which of these are containers for <tr>, <th> and <td> ?"+reset+"\n1. <option> \n2. <data>\n3. <group>\n4. <table>\n", 4, 4);
                int score = exam.conductExam();

                // Save the result
                saveResult(userId, score, session);
                end();
            }
            else {
                end();
            }
       	   		break;
       	   	default:
       	   		System.out.println(red+"Invalid choice!"+reset);
       	   		break;
       	   }
         }
       	else {
            System.out.println(red+"Sorry! No user found with ID: " + userId);
            System.out.println("Please enter registered user Id only..."+reset);
        }
    } 
    	
    private static void saveResult(int userId, int score, Session session) {
        Transaction transaction = null;
        try {
            Result result = new Result();
            result.setUserId(userId);
            result.setExamId(1); // Assuming examId is 1 for now
            result.setMarksObtained(score);
           
            if (score == 5) {
                result.setGrade('A');
                result.setPassFail("Pass");
            }
            else if (score == 4 ) {
                result.setGrade('B');
                result.setPassFail("Pass");
            }
            else if (score == 3) {
                result.setGrade('c');
                result.setPassFail("Pass");
            }
            else {
                result.setGrade('F');
                result.setPassFail("Fail");
            }

            session.save(result);
            //transaction.commit();
            System.out.println(green+"\nResult saved successfully."+reset);
            System.out.println("You can check your result by using your result Id : "+result.getId());
        } catch (Exception e) {
           // transaction.rollback();
            e.printStackTrace();
        }
    }

    static void end() {
    	
        System.out.println(green+"\n		Thank you...."+reset);
       
    }
}
