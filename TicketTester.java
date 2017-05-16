//Michael Livingston
//CMSC256
//Java Project5 
import java.io.*;
public class TicketTester {
	private static void printHeading(){
	    
	    System.out.println("Michael Livingston");
	    System.out.println("CMSC 256");
	    System.out.println("Project 5"); 
	    System.out.println("The purpose of this code is to handle different type of tickets and handle erros \n"); 
	  }
public static void main(String[] args)
{
	printHeading();
	//test negative days
	TicketOrder ticketArray = new TicketOrder();
	
	//test advanced tickets
	Ticket advancedTicket = new AdvancedTicket(-3); //negative input,  IllegalArgument Exception thrown
	Ticket advancedTicket1 = new AdvancedTicket(20); //tests +10 days in advanced
	Ticket advancedTicket2 = new AdvancedTicket(5);
	Ticket advancedTicket3 = new AdvancedTicket(-5);//tests negative
	
	//test classes that dont take in anything 
	Ticket walkupTicket = new WalkupTicket();
	Ticket freeTicket = new FreeTicket();
	
	//test Student tickets for regular and negative 
	Ticket studentAdvancedTicket = new StudentAdvancedTicket(25);
	Ticket studentAdvancedTicket2 = new StudentAdvancedTicket(-25);
    
	
	Event newEvent = new Event("Concert", 22.0 , "01/11/2016", 60, 50); //dont get how to use LocalDate
	Event newEvent2 = new Event("Concert", -22.0 , "01/11/2016",-60, 50);//dont get how to use LocalDate
	System.out.println(newEvent);
	
	//adding to array. 
	ticketArray.add(advancedTicket1);
	ticketArray.add(advancedTicket2);
	ticketArray.add(walkupTicket);
	ticketArray.add(freeTicket);
	ticketArray.add(studentAdvancedTicket);
	ticketArray.add(studentAdvancedTicket2);


	System.out.print(ticketArray);

	
	
}
}
