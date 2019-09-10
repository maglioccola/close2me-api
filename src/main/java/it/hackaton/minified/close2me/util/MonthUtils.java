package it.hackaton.minified.close2me.util;

public class MonthUtils {
	
	public static String getMonthOfYear(String month) {
		String m = "00";
		switch(month.toUpperCase().substring(0, 3) ) {
		case "GEN":
			m = "01";
			break;
		case "FEB":
			m = "02";
			break;
		case "MAR":
			m = "03";
			break;
		case "APR":
			m = "04";
			break;
		case "MAG":
			m = "05";
			break;
		case "GIU":
			m = "06";
			break;
		case "LUG":
			m = "07";
			break;
		case "AGO":
			m = "08";
			break;
		case "SET":
			m = "09";
			break;
		case "OTT":
			m = "10";
			break;
		case "NOV":
			m = "11";
			break;
		case "DIC":
			m = "12";
			break;
		}
		return m;
	}
}
