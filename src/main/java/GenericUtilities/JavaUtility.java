package GenericUtilities;

import java.util.Date;
import java.util.Random;
public class JavaUtility {
	
		public double getRandomNum()
		{
			Random r=new Random();
			double num = r.nextDouble();
			return num;
		}
		public String getSystemDate()
		{
			Date d=new Date();
			String value = d.toString();
			return value;
		}
		
		
		
	}


