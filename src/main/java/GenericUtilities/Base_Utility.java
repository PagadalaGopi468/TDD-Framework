package GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Utility {

	public WebDriver driver;
	public static WebDriver sdriver;
	Data_Utility d=new Data_Utility();


	@BeforeSuite(groups = "SmokeSuite")
	public void Launch_Database()
	{
		System.out.println("Database launched");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void launch_Browser(/*String Browser*/) throws Exception
	{
		String Browser=d.getdatafromProperties("browser");
		String url=d.getdatafromProperties("url");
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
			sdriver=driver;
			System.out.println("Chrome launch Successfully....!!!");
		}
		else if(Browser.equalsIgnoreCase("Edge"))
		{
			//WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", "D:\\Development TFS Project\\msedgedriver.exe");	
			driver=new EdgeDriver();
			sdriver=driver;
			System.out.println("Edgedriver launch Successfully....!!!");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void login() throws Exception
	{
		HR1_LoginPage l=new HR1_LoginPage(driver);
		l.login();
	}
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void logout() throws Exception
	{
		 Robot r=new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
	     r.keyPress(KeyEvent.VK_MINUS);
	     r.keyRelease(KeyEvent.VK_CONTROL);
	     r.keyRelease(KeyEvent.VK_MINUS);
	     
	     r.keyPress(KeyEvent.VK_CONTROL);
	     r.keyPress(KeyEvent.VK_MINUS);
	     r.keyRelease(KeyEvent.VK_CONTROL);
	     r.keyRelease(KeyEvent.VK_MINUS);
	     
		HR1_LogOutPage t=new HR1_LogOutPage(driver);
		t.logout();
	}
	//@AfterTest
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void close()
	{
		driver.quit();
	}
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void Close_Database()
	{
		System.out.println("Database is Closed");
	}

}
