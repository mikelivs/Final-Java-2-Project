//Michael Livingston
//CMSC256
//Java Project5 
import java.util.ArrayList;
	import java.util.Random;
	
	public abstract class Ticket {
	
		private int serialNumber;
		ArrayList<Integer> assignedNums = new ArrayList<Integer>();
		
		public Ticket()
		{
			
		 Random random = new Random();
			
	      int number = 1000+ random.nextInt(9000);
	      //assignedNums.add(number);
	      boolean serialCheck = false;
	  
	     for(int x: assignedNums) 
	     {
	    	 if(x == number)
	    	 {
	         serialCheck = true;
	         }
	   	   
	      }
	     while(serialCheck == true)
	     {
	         number = 10000+ random.nextInt(900000);
	         serialCheck = false;
	         for(int i : assignedNums)
	         {
	        	 if(i == number)
	        	 {
	        		 serialCheck = true;
	        	 }
	        	}
	         }
assignedNums.add(number);
setSerialNumber(number);

		}
	      
		
	
	
 public void setSerialNumber(int serialNumber) {
			this.serialNumber = serialNumber;
		}




public abstract double getPrice();
		
	 public int getSerialNumber()
		{
		return serialNumber; 
		}
	
	 public String toString()
	 {
		 return "Ticket Serial Number: "+getSerialNumber()+"\nPrice: "+getPrice();
	 }
	 
	}
	
		

