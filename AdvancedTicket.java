//Michael Livingston
//CMSC256
//Java Project5 
public class AdvancedTicket extends Ticket{  //intiate class that extends ticket for inheritance 
private double price;

	public AdvancedTicket(int days) //paramarterized constructor 
	{
		 super();

	  setPrice(getPrice()); 

		
	}
	
	public double getPrice() //getPrice method implemented
	{
		return price;
	}
	public void setPrice(double price1)
	{
		if (price1<0)
		{
			throw new IllegalArgumentException("No negative price");
		}
		price = price1-(price1*.10); 
	}
	}

