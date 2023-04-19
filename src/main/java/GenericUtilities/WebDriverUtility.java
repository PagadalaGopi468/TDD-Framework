package GenericUtilities;
import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * 
 * @author Gopi
 *
 */
public class WebDriverUtility {

	/**
	 * this method will maximize the webpage
	 * @param driver
	 */
	 public void maximize(WebDriver driver)
	 {
		 driver.manage().window().maximize();
	 }
	 /**
	  * this method will minimize the webpage
	  * @param driver
	  */
	 public void minimize(WebDriver driver)
	 {
		 driver.manage().window().minimize();
	 }
	 /**
	  * this method will wait for 10sec to get all the elements loaded
	  * @param driver
	  */
	 public void waitForLoadPage(WebDriver driver)
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 }
	 /**
	  * this method will handle dropdown by using value
	  * @param element
	  * @param value
	  */
	 public void handleDropDown(WebElement element,String value)
	 {
		 Select s=new Select(element);
		 s.selectByValue(value);
	 }
	 /**
	  * this method will handle dropdown by using index
	  * @param element
	  * @param index
	  */
	 public void handleDropDown(WebElement element,int index)
	 {
		 Select s=new Select(element);
		 s.selectByIndex(index);
	 }
	 /**
	  * this method will handle the dropdown by using visible text 
	  * @param Text
	  * @param element
	  */
	 public void handleDropDown(String Text,WebElement element)
	 {
		 Select s=new Select(element);
		 s.selectByVisibleText(Text);
	 }
	 /**
	  * this method will wait a particular element click
	  * @param driver
	  * @param element
	  */
	 public void waitElemenToBeclickable(WebDriver driver,WebElement element)
	 {
		 WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		 w.until(ExpectedConditions.elementToBeClickable(element));
	 }
	 /**
	  * this method will wait a particular element becomes visible
	  * @param driver
	  * @param element
	  */
	 public void waitElementToBeVisible(WebDriver driver,WebElement element)
	 {
		 WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		 w.until(ExpectedConditions.visibilityOf(element));
		 
	 }
	 /**
	  * this method will perform Hover action on a specified element
	  * @param driver
	  * @param element
	  */
	 public void mouseHoverAction(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.moveToElement(element).perform();
	 }
	 /**
	  * this method will perform double click operation on anywhere in the webpage
	  * @param driver
	  */
	 public void doubleClickAction(WebDriver driver)
	 {
		 Actions act=new Actions(driver);
		 act.doubleClick().perform();
	 }
	 /**
	  * this method will perform double click operation on a particular element
	  * @param driver
	  * @param element
	  */
	 public void doubleClickAction(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.doubleClick(element).perform();
	 }
	 /**
	  * this method will perform right click operation on anywhere in a webpage
	  * @param driver
	  */
	 public void rightClickOperation(WebDriver driver)
	 {
		 Actions act=new Actions(driver);
		 act.contextClick().perform();
	 }
	 /**
	  * this method will perform right click operation on a particular element in the webpage
	  * @param driver
	  * @param element
	  */
	 public void rightClickOperation(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.contextClick(element).perform();
	 }
	 /**
	  * this method will perform drag and drop from source to destination
	  * @param driver
	  * @param srcElement
	  * @param dstElement
	  */
	 public void dragAndDropActions(WebDriver driver,WebElement srcElement,WebElement dstElement)
	 {
		 Actions act=new Actions(driver);
		 act.dragAndDrop(srcElement,dstElement); 
	 }
	 /**
	  * this method switch to frame based on given index
	  * @param driver
	  * @param index
	  */
	 public void switchToFrame(WebDriver driver,int index)
	 {
		 driver.switchTo().frame(index);
	 }
	 /**
	  * this method switch to frame based on given frame name or frame ID
	  * @param driver
	  * @param FrameIdOrName
	  */
	 public void switchToFrame(WebDriver driver,String FrameIdOrName)
	 {
		 driver.switchTo().frame(FrameIdOrName);
	 }
	 /**
	  * this method switch back to immediate parent frame
	  * @param driver
	  */
	 public void switchToParentFrame(WebDriver driver)
	 {
		 driver.switchTo().parentFrame();
	 }
	 /**
	  * this method switch back to default frame
	  * @param driver
	  */
	 public void defaultContent(WebDriver driver)
	 {
		 driver.switchTo().defaultContent();
	 }
	 /**
	  * this method will accept the alert
	  * @param driver
	  */
	 public void acceptAlert(WebDriver driver)
	 {
		 driver.switchTo().alert().accept();
	 }
	 /**
	  * this method will dismiss the alert
	  * @param driver
	  */
	 public void dismissAlert(WebDriver driver)
	 {
		 driver.switchTo().alert().dismiss();
	 }
	 /**
	  * this method will print alert message
	  * @param driver
	  */
	 public void getAlertText(WebDriver driver)
	 {
		 driver.switchTo().alert().getText();
	 }
	 /**
	  * this method will switch to the window ,based on partial window title
	  * @param driver
	  * @param partialwindowTitle
	  */
	 public void switchWindow(WebDriver driver,String partialwindowTitle) 
	 {
		 //capture all the window
		 Set<String> winids = driver.getWindowHandles();
		 //extract individuals window id
		 for(String id:winids)
		 {
			 //capture the current window id
			String currentTitle = driver.switchTo().window(id).getTitle();
			//compare the current title with required title
			if(currentTitle.contains(partialwindowTitle))
			{
				break;
			}
		 } 
	 }
	 /**
	  * this method will take care screenshot and store it in a folder
	  * @param driver
	 * @param Screenshots 
	  * @param screenshotname
	  * @return
	  * @throws Exception
	  */
	 public String screenshot(WebDriver driver ,String Screenshots) throws Exception
	 {
		 TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\src\\main\\resources\\Screenshots"+Screenshots+".png");
		Files.copy(src, dest);
		
		return dest.getAbsolutePath();
	 }
	 
	 public int getRandomNum()
		{
			Random r=new Random();
			int num = r.nextInt();
			return num;
		}
	 
	 public String getsystemDateFormat()
		{
			Date d=new Date();
			String[] da = d.toString().split(" ");
			String date=da[2];
			String month=da[1];
			String year=da[5];
			String time=da[3].replace(":", "-");
			String dateFormat=date+"_"+month+"_"+year+"_"+time;
			return dateFormat;
		}
	 
}

