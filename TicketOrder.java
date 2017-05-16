//Michael Livingston
//CMSC256
//Java Project5 

import java.util.ArrayList;
import java.text.*;
public class TicketOrder extends Ticket {
	private ArrayList<Ticket>ticketArray; //initialze arrayLsit of ticket type
	double totalPrice;
    private double price;
	public TicketOrder(){
		
		 ticketArray = new ArrayList<Ticket>(); 
	}
	public void add(Ticket ticket1)
	{
		ticketArray.add(ticket1);
	}
public double getPrice()
{ 
	return price;
}


	public double totalPrice()
	{
		 totalPrice = 0; 
		for(Ticket x: ticketArray)
		{
			totalPrice += x.getPrice(); 
			
		}
		return totalPrice; 
	}
	
	public String toString()
	{
		String outString = "";
		String totalPrice1 = null;
		for (Ticket y: ticketArray)//iterate throw ticket array to find type of ticket and print 
		{
			DecimalFormat formatString = new DecimalFormat("#.00");
		  	String stringPrice = formatString.format(y.getPrice());   
		  	 totalPrice1 = formatString.format(totalPrice());   

		    if(y instanceof StudentAdvancedTicket)
			{
				outString += "StudentAdvancedTicket"+"\t("+y.getSerialNumber()  +")\t$"   + stringPrice+"\n";
			}
			if(y instanceof AdvancedTicket)
			{
				outString += "AdvancedTicket"+"\t        ("+y.getSerialNumber()  +")\t$"  + stringPrice+"\n";
			}
			if(y instanceof WalkupTicket)
			{
				outString += "WalkupTicket"+"\t        ("+y.getSerialNumber()  +")\t$"  + stringPrice+"\n";
			}
			if(y instanceof FreeTicket)
			{
				outString += "FreeTicket"+"\t        ("+y.getSerialNumber()  +")\t$"  + stringPrice+"\n";
			}
			
		}
		return outString+ "\nTotal: " +totalPrice1; 

}
}
