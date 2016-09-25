package Interval.Interval;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class IntervalService {
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	
	public Date askForStartDate() throws ParseException {
		boolean validDate = false;
		Date date = null;
		while (!validDate) {
			try {
				date = DATE_FORMATTER.parse(JOptionPane.showInputDialog("Podaj date poczatkowa w formacie yyyy-MM-dd"));
				validDate = true;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Format daty niepoprawny", "Bład", JOptionPane.ERROR_MESSAGE);
			}
		}
		return date;
	}
	
	public Date askForEndDate() throws ParseException {
		boolean validDate = false;
		Date date = null;
		while (!validDate) {
			try {
				date = DATE_FORMATTER.parse(JOptionPane.showInputDialog("Podaj date poczatkowa w formacie yyyy-MM-dd"));
				validDate = true;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Format daty niepoprawny", "Bład", JOptionPane.ERROR_MESSAGE);
			}
		}
		return date;
	}
	
	public int getInterval(Date startDate, Date endDate){
		 try {
			startDate = askForStartDate();
			endDate = askForEndDate();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 GivenDate min = new GivenDate(startDate);
		 GivenDate max = new GivenDate(endDate);
		 
		 int differenceInyears = max.getYear()-min.getYear();
		 if (isMonthNotPassed(min, max) || isDayInMonthNotPassed(min, max)) {
			 differenceInyears -= 1;
			}
		 
			return differenceInyears;
	}
	
	private boolean isDayInMonthNotPassed(GivenDate start, GivenDate end) {
		return start.getMonth() == end.getMonth() && start.getDate() < end.getDate();
	}

	private boolean isMonthNotPassed(GivenDate start, GivenDate end) {
		return start.getMonth() < end.getMonth();
	}
	
	private final class GivenDate {
		private final int year;
		private final int month;
		private final int date;

		public GivenDate(Date date) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			this.year = cal.get(Calendar.YEAR);
			this.month = cal.get(Calendar.MONTH);
			this.date = cal.get(Calendar.DATE);
		}

		public int getYear() {
			return year;
		}

		public int getMonth() {
			return month;
		}

		public int getDate() {
			return date;
		}
	}
   
}
