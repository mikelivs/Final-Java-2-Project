//Michael Livingston
//CMSC256
//Java Project5 
public class StudentAdvancedTicket extends Ticket{

	private double price; //intialize price 
	
	public StudentAdvancedTicket(int days)
	{
		try{
		if(days>=10)
		{
			price = 15.0; //perhaps divide by advanced ticket price 
		}
		else if(days<0)
		{
			throw new IllegalArgumentException(); //throw exception 
		}
		else
		{
			price = 20.0;
		}
		}
	catch(IllegalArgumentException e) //catch exception 
		{
		System.out.println(">>>>>Cannont be negative");

		}
		
	}
	public double getPrice()
	{
		return price;
	}

	
	public String toString() //toString 
	{
		return "StudendAdvTickets class price"+getPrice();
		
	}
}
