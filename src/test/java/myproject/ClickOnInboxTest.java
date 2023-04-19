package myproject;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import GenericUtilities.Base_Utility;

public class ClickOnInboxTest extends Base_Utility{
@Test(groups = "SmokeSuite")
	public void inbox() throws InterruptedException
	{
		driver.findElement(By.xpath("(//a[@href='javascript:void(0)'])[2]")).click();
		System.out.println("click on inbox Successfully...");
	}
}
