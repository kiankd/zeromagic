package zeromagic.datastructures;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ZDate 
{
	public String m, d, y;
	private GregorianCalendar calendar;
	/**
	 * Simple date class. Note that we are assuming that January starts at int 0! December = 11!
	 */
	public ZDate(int month, int day, int year)
	{
		m = Integer.toString(month);
		d = Integer.toString(day);
		y = Integer.toString(year);
		
		if (m.length() == 1)
			m = "0"+m;
		
		if (d.length() == 1)
			d = "0"+d;
		
		calendar = new GregorianCalendar(year, month, day);
	}
	
	public int daysBetween(ZDate date)
	{
		return daysBetween(this.calendar, date.calendar);
	}
	
	// Appropriated from Stack Overflow - http://stackoverflow.com/questions/20165564/calculating-days-between-two-dates-with-in-java
	private static int daysBetween(Calendar day1, Calendar day2)
	{
	    Calendar dayOne = (Calendar) day1.clone(),
	             dayTwo = (Calendar) day2.clone();

	    if (dayOne.get(Calendar.YEAR) == dayTwo.get(Calendar.YEAR)) {
	        return Math.abs(dayOne.get(Calendar.DAY_OF_YEAR) - dayTwo.get(Calendar.DAY_OF_YEAR));
	    } else {
	        if (dayTwo.get(Calendar.YEAR) > dayOne.get(Calendar.YEAR)) {
	            //swap them
	            Calendar temp = dayOne;
	            dayOne = dayTwo;
	            dayTwo = temp;
	        }
	        int extraDays = 0;

	        int dayOneOriginalYearDays = dayOne.get(Calendar.DAY_OF_YEAR);

	        while (dayOne.get(Calendar.YEAR) > dayTwo.get(Calendar.YEAR)) {
	            dayOne.add(Calendar.YEAR, -1);
	            // getActualMaximum() important for leap years
	            extraDays += dayOne.getActualMaximum(Calendar.DAY_OF_YEAR);
	        }

	        return extraDays - dayTwo.get(Calendar.DAY_OF_YEAR) + dayOneOriginalYearDays ;
	    }
	}
	
}
