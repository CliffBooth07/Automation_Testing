package provider;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CheckA {
	@SuppressWarnings("deprecation")
	private static List<Date> getWeek(Date date)
	{
		List<Date> ret = new ArrayList<Date>();
		Date pre = new Date(), post = new Date();
		int minus, plus;
		int currDay = date.getDay();
		switch(currDay)
		{
		case	0: minus = 1;plus=5;break;
		case	1: minus = 2;plus=4;break;
		case	2: minus = 3;plus=5;break;
		case	3: minus = 4;plus=2;break;
		case	4: minus = 5;plus=1;break;
		case	5: minus = 6;plus=0;break;
		case	6: minus = 0;plus=6;break;
		default : minus=plus=0;
		}
		pre.setDate(date.getDate()-minus);
		post.setDate(date.getDate()+plus);
		ret.add(pre);
		ret.add(post);
		return ret;
	}
@SuppressWarnings("deprecation")
public static String getDateString(int weekBefore) {
	Date curr = new Date();
	SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	Calendar cal = Calendar.getInstance();
	cal.setTime(curr);
	cal.add(Calendar.DATE, -1*weekBefore*7);
	curr = cal.getTime();
	List<Date> dates = getWeek(curr);	
	String begin = df.format(dates.get(0)), end = df.format(dates.get(1));
	return begin+" To "+end;
}

//public static void main(String[] args)
//{
//	System.out.println(getDateString(0));
//	System.out.println(getDateString(1));
//	System.out.println(getDateString(2));
//}
}
