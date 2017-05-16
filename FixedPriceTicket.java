//Michael Livingston
//CMSC256
//Java Project5 


public abstract class FixedPriceTicket extends Ticket{
	private double price; 
	
	public FixedPriceTicket(){}
	
	 public FixedPriceTicket(double fixedPrice)
	{
		 setPrice(fixedPrice);
	}
	
	public double getPrice()
	{
		return price;
		
	}
	
	public void setPrice(double price3)
	{
		try{
		if(price3 >= 0)
		{
		price = price3;
		}
		else
		{
			throw new IllegalArgumentException();
		}
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(">>>>Price cannont be negative");
		}
		
	}
	
	public String toString()
	{
		//put decimal format 
		int fixedTicket = super.getSerialNumber();
		return "Serial Number: " + fixedTicket + "Price: "+ getPrice();
	 

}
}
