package myproject;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.Base_Utility;
@Listeners(GenericUtilities.ListnerImplementationClass.class)
public class ClickOnRequestTest extends Base_Utility{
	@Test(groups = "SmokeSuite")
	public void Request() throws InterruptedException
	{
		driver.findElement(By.xpath("(//a[@href='javascript:void(0)'])[3]")).click();
		System.out.println("Click on Request Successfully...!!");
	}
	
}

