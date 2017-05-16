//Michael Livingston 
//CMSC256
//Ticket System Simulation 
//Ticket System Simulation is a	simulation	of	a	ticket	purchasing	system
/**
 * A class that use a queue to simulate a waiting line.
 */
 import java.util.*;
 import java.time.temporal.ChronoUnit;

public class WaitLine{
  private PriorityQueue<Customer> line; //initialize priority queue
  private int numberOfArrivals;
  private int numberServed;
  private int totalTimeWaited;
  int customerLeft =0;
  double totalSales;
  public WaitLine(){ //default constuctor 
    line = new PriorityQueue<Customer>();
    reset();
  } 
  
  /** Task: Simulates a waiting line with one serving agent.
   *  @param duration  the number of simulated minutes 
   *  @param arrivalProbability  a real number between 0 and 1, and the
   *                             probability that a customer arrives at
   *                             a given time
   *  @param maxTransactionTime  the longest transaction time for a
   *                             customer 
   */ 
  public void simulate(int duration, double arrivalProbability, 
                                   int maxTransactionTime, boolean checkstatus, ArrayList<Event>arrlist) { //simlation method
	  int clock = 0;
	  
 	 if(checkstatus == false) //check status of simulation 
    {
        int transactionTimeLeft = 0;
        
    
	
    for (clock = 0; clock < duration; clock++) {
      if (Math.random() < arrivalProbability)  {
        numberOfArrivals++;
        int transactionTime = (int)(Math.random() * maxTransactionTime+1); //randomly generate transaction time 
    	
    	 
              
        Customer newCustomer = new Customer(clock, transactionTime, numberOfArrivals); //create new customer 
        line.add(newCustomer); //add customer to priority queue 
        
        
        System.out.println("Customer "  + numberOfArrivals 
        	    + " enters line at time " + clock 
                + ". Transaction time is " + transactionTime);
      }
        if (transactionTimeLeft > 0)
        {
          transactionTimeLeft--;
        }
        else if (!line.isEmpty()) {
            Customer nextCustomer = line.remove();
            transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
            int timeWaited = clock - nextCustomer.getArrivalTime();
            totalTimeWaited = totalTimeWaited + timeWaited;
            numberServed++;
            System.out.println("Customer " + nextCustomer.getCustomerNumber() 
                             + " begins service at time " + clock 
                             + ". Time waited is " + timeWaited);
          } 
    
    Iterator iterate = line.iterator(); //iterate through queue
    
        while(iterate.hasNext())
        {
        	Customer customerLine = (Customer) iterate.next();
        	int time = customerLine.getArrivalTime();
        	
        	if(clock - time >= 10) //check if wait time is greater than 10
        	{
        		iterate.remove(); //if true remove them
        		customerLeft++;//add to customers who leave counter/tally
        		System.out.println(customerLine.getCustomerNumber()+" left the line");
        	}
        }
        
      }
    }
    
    

 	 
    else //if boolean == true 
    {
        int transactionTimeLeft = 0;

    int randomEvent = (int)(Math.random()*arrlist.size());
    
	int randomTicket = (int)(Math.random() * 6)+1;
	


    for (clock = 0; clock < duration; clock++) {
      if (Math.random() < arrivalProbability)  {
        numberOfArrivals++;
        int transactionTime = (int)(Math.random() * maxTransactionTime+1); //randomly generate transaction time 
    	int randomStatus = (int) (Math.random()*10) +1;
    	int thisStatus = justStatus(randomStatus);
    	 
              
        Customer newCustomer = new Customer(clock, transactionTime, numberOfArrivals, thisStatus); //create new customer 
        
        
        line.add(newCustomer);
     
        
         //add customer to priority queue 
        
        
        System.out.println("Customer "  + numberOfArrivals 
        	    + " enters line at time " + clock 
                + ". Transaction time is " + transactionTime);
      }

      
          	
        if (transactionTimeLeft > 0)
        {
          transactionTimeLeft--;
        }
        else if (!line.isEmpty()) {
            Customer nextCustomer = line.remove();
            transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
            int timeWaited = clock - nextCustomer.getArrivalTime();
            totalTimeWaited = totalTimeWaited + timeWaited;
            numberServed++;
            System.out.println("Customer " + nextCustomer.getCustomerNumber() 
                             + " begins service at time " + clock 
                             + ". Time waited is " + timeWaited);
            
        	// totalSales = nextCustomer.getNumTickets() * nextCustomer.getTicketType().getPrice();
            Iterator iterate = line.iterator(); //iterate through queue
            
            while(iterate.hasNext())
            {

            	Customer customerLine = (Customer) iterate.next();
            	int time = customerLine.getArrivalTime();
            	
            	if(clock - time >= 10) //check if wait time is greater than 10
            	{
            		iterate.remove(); //if true remove them
            		customerLeft++;//add to customers who leave counter/tally
            		System.out.println(customerLine.getCustomerNumber()+" left the line");
            	}
            
			}
          } 
        
    
        }
        
      }
    }
    
    	
  
    
    
  
  
  
  /** Task: Displays summary results of the simulation. 
  */ 
  public void displayResults() {
    System.out.println();
    System.out.println("Number served = " + numberServed);
    System.out.println("Total time waited = " + totalTimeWaited);
 
    double averageTimeWaited = ((double)totalTimeWaited) / numberServed;
    System.out.println("Average time waited = " + averageTimeWaited);
 
    int leftInLine = numberOfArrivals - numberServed;
    System.out.println("Number left in line = " + leftInLine);
    System.out.println("Number of People who left the line after 15 min: "+customerLeft);
    
  } 
  
private static void printHeading(){
    
    System.out.println("Michael Livingston");
    System.out.println("CMSC 256");
    System.out.println("Ticket System Simulation "); 
    System.out.println("Ticket System Simulation is a simulation of	a ticket purchasing	system \n"); 
  }
  
  public int justStatus(int i) //creates the correct ratio of status in the simulation population 
  {

	  int assignedStatus = 0;
	  
	  if(i >= 8)
	  {
		 assignedStatus = 4; //platinum 
	  }
	  else if(i >= 4)
	  {
		  assignedStatus = 3;//gold
	  }
	  else if(i >= 2)
	  {
		  assignedStatus = 2; //silver
	  }
	  else
	  {
		  assignedStatus = 1; //none
	  }
	  return assignedStatus;
  }
  
  /** Task: Initializes the simulation. 
  */ 
  public final void reset() {
    line.clear();
    numberOfArrivals = 0;
    numberServed = 0;
    totalTimeWaited = 0;
  } 
  
  public static void main(String[] args){
	 // printHeading();
   /* WaitLine customerLine = new WaitLine();
    //simulate 20 min. with 50% arrival probability & 5 min. max. transaction time
    customerLine.simulate(20, 0.5, 15, true);
    customerLine.displayResults();*/
  }
}