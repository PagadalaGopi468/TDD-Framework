package myproject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	@Test(dataProvider = "phone")
	public void addproductToCart(String phone,int price,String model)
	{
		System.out.println(phone+" "+price+" "+model);
	}
	@DataProvider(name="phone")
	public Object[][] getData()
	{
		Object[][] d=new Object[2][3];
		
		d[0][0]="Samsung";
		d[0][1]=54788;
		d[0][2]="Aik";
		
		d[1][0]="Iphone";
		d[1][1]=5478;
		d[1][2]="Ag28";
	    return d;
	}
			
}
