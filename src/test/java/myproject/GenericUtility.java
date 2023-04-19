 package myproject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import GenericUtilities.WebDriverUtility;
public class GenericUtility {

	public static void main(String[] args) throws Exception {
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--remote-allow-origins=*");
		WebDriver driver1=new ChromeDriver(c);
		driver1.get("https://www.flipkart.com/");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverUtility we=new WebDriverUtility();
		we.screenshot(driver1, we.getsystemDateFormat());
		driver1.close();
		
	}
}
