package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HR1_LoginPage {

	Data_Utility d=new Data_Utility();
	
	@FindBy(xpath = "//input[@id='hrone-username']")
	private WebElement username;
	
	@FindBy(xpath = "//span[text()=' NEXT ']")
	private WebElement nextbtn;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath = "//span[text()=' LOG IN ']")
	private WebElement button;
	
	@FindBy(xpath = "//button[text()=' next ']")
	private WebElement next;
	
	@FindBy(xpath = "//a[text()='May be Later']")
	private WebElement laterClick;
	
//	@FindBy(xpath = "(//i[text()=' clear '])[22]")
//	private WebElement clear;
	
	@FindBy(xpath = "(//em[text()=' clear '])[23]")
	private WebElement Click;
	
	public HR1_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getNextbtn() {
		return nextbtn;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getButton() {
		return button;
	}

	public WebElement getNext() {
		return next;
	}

	public WebElement getLaterClick() {
		return laterClick;
	}

//	public WebElement getClear() {
//		return clear;
//	}
	public WebElement getClick() {
		return Click;
	}
	
	public void login() throws Exception
	{
		username.sendKeys(d.getdatafromProperties("username"));
		nextbtn.click();
		Thread.sleep(2000);
		password.sendKeys(d.getdatafromProperties("password"));
		button.click();
		next.click();
		laterClick.click();
		//clear.click();
		Click.click();
	}
	
	
}
