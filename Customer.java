//Michael Livingston 
//CMSC256
//Ticket System Simulation 
//Ticket System Simulation is a	simulation	of	a	ticket	purchasing	system
/**
	 * An immutable class that represents a customer
	 * of a bank or similar place of business.
	 * 
	 */
	public class Customer implements Comparable<Customer> //implement comparable to compare arrival times
	{
		//intiate variables 
		private int arrivalTime;
		private int transactionTime;
		private int customerNumber;
		private int eventSelection;
		private int numTickets;
		private Ticket ticketType;
		private int status;
		String event;
		
		public Customer() //unparamerterized constructor 
		{
			arrivalTime = 0;
			transactionTime =0;
			customerNumber =0;
            setEventSelection(0);
            setStatus(0);
            setNumTickets(0);
		}
		public Customer(int arrivalTime, int transactionTime, int customerNumber, int eventSelection, int numTickets, 
				Ticket ticketType, int status) //constructor
		{
			setArrivalTime(arrivalTime);
			this.transactionTime = transactionTime;
			this.customerNumber = customerNumber;
			setEventSelection(eventSelection);
            setTicketType(ticketType);
            setStatus(status);
            setNumTickets(numTickets);
			

		} 
		public Customer(int clock, int transactionTime, int customerNumber, 
        		int assignedStatus)
		{
			setArrivalTime(clock);
			setTransactionTime(transactionTime);
			setNumTickets(customerNumber);
			setStatus(assignedStatus);
		}
		
		public Customer(int arrivalTime, int transactionTime, int customerNumber) {
			this.arrivalTime = arrivalTime;
			this.transactionTime = transactionTime;
			this.customerNumber = customerNumber;
		} 
		
		//setters and getters 
		public void setTransactionTime(int transactionTime)
		{
			this.transactionTime = transactionTime;
		}
		
		public void setArrivalTime(int arrivalTime)
		{
			this.arrivalTime = arrivalTime;
		}
		
		public int compareTo(Customer i)
		{
			if(status != 0)
			{
				return(i.getStatus()-status);
			}
			else
			{
				return (arrivalTime -i.getArrivalTime());
			}
		}
		
		public void setTicketType(Ticket ticketType)
		{
			
			this.ticketType = ticketType;
		}
		
		public void setEventSelection(int i)
		{
			this.eventSelection = i;
		}
		
		public void setStatus(int status)
		{
			this.status = status;
		}
       public void setNumTickets(int customerNumber)
       {
    	   this.customerNumber =customerNumber;
       }
       public Ticket getTicketType() 
       {
    	   return ticketType;
       }

       public int getEventSelection()
       {
    	   return eventSelection;
       }
       
       public int getStatus()
       {
    	   return status;
       }
	
       public int getNumTickets()
       {
    	   return numTickets;
       }
       
       
		public int getArrivalTime() {
			return arrivalTime;
		} 
		
		public int getTransactionTime() {
			return transactionTime;
		} 
		
		public int getCustomerNumber() {
			return customerNumber;
		} 
		
		public String toString() //print customer variables
		{
			return "Customer Number: "+getCustomerNumber()+ "\nStatus: "+getStatus()+"\nTicket Type: "+getTicketType()
			+"/nNumber of tickets purchased: "+getNumTickets()+"\nEvent: "+getEventSelection()+"\nTransaction Time: "+getTransactionTime()+
			"Arrival Time: "+getArrivalTime();
		}
	} 

