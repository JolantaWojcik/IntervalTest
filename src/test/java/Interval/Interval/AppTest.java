package Interval.Interval;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase{
	IntervalService is = new IntervalService();
	
	@Before
	public void setUp() throws Exception {
		// 1) askUserForDate()
		// given
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String givenStartDate = dateFormat.format(is.askForStartDate());
		String givenEndDate = dateFormat.format(is.askForStartDate());
		String yearBeginning = givenStartDate.substring(0,4);
		String yearEnd = givenEndDate.substring(0,4);
		int min = Integer.parseInt(yearBeginning);
		int max = Integer.parseInt(yearEnd);
		//when
		if(min>max){
			//then
			throw new Exception("Start date needs to be smaller than end date");
		}
	}
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
