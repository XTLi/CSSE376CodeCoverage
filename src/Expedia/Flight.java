package Expedia;

import java.util.Date;

public class Flight implements Booking {

	private Date dateThatFlightLeaves;
	private Date dateThatFlightReturns;
	
	public int Miles;
	
	public int getMiles(){
		return Miles;
	}
	
	public double getBasePrice ()
	{
		double lengthOfSpread = (dateThatFlightReturns.getTime() - dateThatFlightLeaves.getTime())/1000.0/60.0/60.0/24.0;
		
		return 200 + lengthOfSpread*20;
	}
	
	public int NumberOfPassengers()
	{
		return Database.Passengers.size();
		
	}
	
	public IDatabase Database;
	
	public Flight (Date startDate, Date endDate, int someMiles)
	{
		if(endDate.before(startDate))
			throw new RuntimeException("End date cannot be before start date!");
		
		if(someMiles < 0)
			throw new RuntimeException("Miles must be positive!");
		
		dateThatFlightLeaves = startDate;
		dateThatFlightReturns = endDate;
		Miles = someMiles;
	}

}
