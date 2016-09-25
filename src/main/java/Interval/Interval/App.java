package Interval.Interval;

import java.text.ParseException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	IntervalService service = new IntervalService();
		
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = service.askForStartDate();
			endDate = service.askForEndDate();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int interval = service.getInterval(startDate, endDate);
		System.out.println("Interval is: "+interval);
    }
}
