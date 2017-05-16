//Michael Livingston 
//CMSC256
//Ticket System Simulation 
//Ticket System Simulation is a	simulation	of	a	ticket	purchasing	system
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class project6 {
		  
	private static void printHeading(){
	    
	    System.out.println("Michael Livingston");
	    System.out.println("CMSC 256");
	    System.out.println("Ticket System Simulation "); 
	    System.out.println("Ticket System Simulation is a simulation of	a ticket purchasing	system \n"); 
	  }
	
	public static void main(String[] args) throws FileNotFoundException  //going to change 
	{
		printHeading();
		
		
		
		
		Boolean fileFound = false;
		String fileName="";
		File newFile = null;
		/*try{
		  while(args.length > 0 && fileFound == false)
		  {

			  fileName = args[1];
			   fileScanner = new Scanner(fileName);
			   newFile = new File(args[1]);
			   
			   if(!newFile.exists())
			   {
				   throw new IOException();
			   }
			   fileFound = true;
		  }
		}
		catch(IOException e)
		{
			System.out.println("File not found");
		}*/
		
		Scanner fileScanner = new Scanner(new File(args[1]));
		//read in file info
		DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		//Scanner fileScanner = new Scanner(new File("ErrorFreeEventList.txt"));
	    String [] eventArr = new String[0];
	    ArrayList<Event> eventArrList = new  ArrayList<Event>();
		String in;
		String eventName;
		double price;
		int maxNum;
		String ticketType = null;
		
		//read in file and split file to use info for objects made
		while(fileScanner.hasNextLine()) //iterates through file while has next line
	    {
	      
	      
	      in = fileScanner.nextLine();
	      in = in.replaceAll("\\s+"," "); 
	      eventArr = in.split(";");
	      
	      String dayMonth = eventArr[1];
	      dayMonth = dayMonth.substring(dayMonth.indexOf(",")+2); //use substring to seperate date
	      String month = dayMonth.substring(0, dayMonth.indexOf(" ")).trim();
	      String day = dayMonth.substring(dayMonth.indexOf(",")+4).trim();
	      String year = dayMonth.substring(dayMonth.indexOf(",")+2).trim();
	      
	      if(day.length() < 1)
	      {
	    	  day = "0"+day;
	      }
		 
	      LocalDate eventDate = LocalDate.parse(year+"-"+month+"-"+day,time); //parse to make local date
	      
	      
	      for (int i = 0; i < eventArr.length; i++)
	      {
	          eventArr[i] = eventArr[i].trim();
	          
	          if(eventArr[i].equals(""))
	          {
	        	  eventArr[i]= "50.00"; //make empty price 50, this is string
	          }
	       
	      }

	      eventName = eventArr[0];
	      price = Double.parseDouble(eventArr[2]);
	      maxNum = Integer.parseInt(eventArr[3]);
	      try{
	    	  if(eventArr[4].equals(""))
	    	  {
	    		  ticketType = "all";
	    	  }
	    	  else
	    	  {
	      ticketType = eventArr[4];
	    	  }
	     }
	      catch(ArrayIndexOutOfBoundsException e)
	      {
	    	  
	    	 System.out.println(">>no ticket type given");
	      }

	   Event event = new Event(eventName, price, eventDate,  maxNum, ticketType);
	  // System.out.println(event.toString());
	      
	     eventArrList.add(event);
	      
	      
	    }
		
	
		 WaitLine simulate = new WaitLine(); //create wait line and run simulation
		 simulate.simulate(Integer.parseInt(args[0]), .5, 10, Boolean.parseBoolean(args[2]), eventArrList); //use command line arguments to run simulation 
		 simulate.displayResults();
		 
}
}
