package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HR1_LogOutPage {

	@FindBy(xpath = "(//div[@class='avatar-content ng-star-inserted'])[1]")
	private WebElement clk;
	
	@FindBy(xpath = "//a[text()=' Logout ']")
	private WebElement logout;
	
	public HR1_LogOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void logout()
	{
		clk.click();
		logout.click();
	}
}
