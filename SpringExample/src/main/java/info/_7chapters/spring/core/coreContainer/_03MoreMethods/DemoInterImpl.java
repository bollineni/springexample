package info._7chapters.spring.core.coreContainer._03MoreMethods;

import java.util.*;
import java.text.*;
public class  DemoInterImpl  implements DemoInter
{	
	private String  message;

	 public void setMessage(String s)
	{
		message=s;
	}

	public String wish(String uname)
	{	String str="";
		Calendar c1=Calendar.getInstance();

		int h=c1.get(Calendar.HOUR_OF_DAY);
		if( h < 12)
		     str="Good Morning ";
		else if( h < 17)
		      str="Good Afternoon ";
		else
			str="Good Evening ";

		return   message+" "+str+" "+uname;
	}

    public String getDateTime()
	{
	         DateFormat  df=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
			String date = df.format(new Date());
	 		return date;
	}
}