package myproject;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.Base_Utility;

@Listeners(GenericUtilities.ListnerImplementationClass.class)
public class DemoTest extends Base_Utility {
@Test
	public void demoTest1()
	{
		System.out.println("Commit");
		//Assert.fail();

	}
}
