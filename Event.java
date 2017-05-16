import java.time.*;

//Michael Livingston
//CMSC256
//Java Project5 
public class Event {
private double price;
private String event;
private int maxNumber;
private String saleTickets;
private LocalDate date;
public Event(){}

public Event(String eventTitle, double priceCost, LocalDate date, int maxNum, String salesTicket) throws IllegalArgumentException 
{
	setPrice(priceCost);
	setEvent(eventTitle);
	setDate(date);
	setMaxNumber(maxNum);
	setSaleTickets(salesTicket);
	

}

public double getPrice()
{
	return price;
}

public void setPrice(double price) 
{
	try{
	if(price< 0)
	{
		throw new IllegalArgumentException();
	}
	else
	{
		this.price = price;
	}
	}
	catch(IllegalArgumentException e)
	{
		System.out.println(">>>>>Cannont be negative");
	}
}

public String getEvent() 

{
	return event;
}

public void setEvent(String event)
{
	this.event = event;
}

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	LocalDate other = LocalDate.now();
	try{
	if(date.isAfter(other))
	{
		throw new IllegalArgumentException();
	}
	else
	{
	this.date = date;
	}
	}
	catch(IllegalArgumentException e)
	{
		System.out.println(">>>Past date for event");
	}
}

public int getMaxNumber() {
	return maxNumber;
}

public void setMaxNumber(int maxNumber) {
	try{
	if(maxNumber < 0)
	{
		throw new IllegalArgumentException();

	}
	else
	{
	this.maxNumber = maxNumber;
	}
	}
	catch(IllegalArgumentException e)
	{
		System.out.println(">>>>>Cannont be negative");
	}
}

public String getSaleTickets() 
{
	return saleTickets;
}

public void setSaleTickets(String saleTickets) 
{
	
	this.saleTickets = saleTickets;
}

public String toString()
{
	return "Event Title: "+ getEvent()+"\nPrice: " +getPrice()+"\nGet Date: "+getDate()+
			"\nMax Number: "+getMaxNumber()+"\n"+"Type of ticket(s): "+getSaleTickets();
}
}
