package GenericUtilities;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTaskPage {

	@FindBy(name="username")
	private WebElement usernameedt;
	
	@FindBy(name = "pwd")
	private WebElement passwordedt;
	
	@FindBy(id="loginButton")
	private WebElement submit;
	
	@FindBy(id="container_tasks")
	private WebElement button;
	
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement sbutton;
	
	@FindBy(xpath = "//div[@class='item createNewCustomer']")
	private WebElement but;
	
	@FindBy(xpath = "(//input[@type='text'])[68]")
	private WebElement UsernameText;
	
	@FindBy(xpath ="(//textarea[@class='textarea'])[9]")
	private WebElement DescriptionText;
	
	@FindBy(xpath = "//div[text()='Create Customer']")
	private WebElement createCustomer;
	
	public WebElement getUsernameedt() {
		return usernameedt;
	}

	public WebElement getPasswordedt() {
		return passwordedt;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public WebElement getBut() {
		return but;
	}

	public WebElement getSbutton() {
		return sbutton;
	}
	public WebElement getButton() {
		return button;
	}

	public WebElement getUsernameText() {
		return UsernameText;
	}

	public WebElement getDescriptionText() {
		return DescriptionText;
	}

	public WebElement getCreateCustomer() {
		return createCustomer;
	}

	public AddTaskPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void LoginToApp(String USERNAME,String PASSWORD)
	{
		usernameedt.sendKeys(USERNAME);
		passwordedt.sendKeys(PASSWORD);
		submit.click();
	}

	public void CreateUser(String NAME, String Description)
	{
		button.click();
		sbutton.click();
		but.click();
		UsernameText.sendKeys(NAME);
		DescriptionText.sendKeys(Description);
		createCustomer.click();
	}
	}
