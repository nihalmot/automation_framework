package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

	//constructor for MyAccountPage
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//action methods
	
	public void clickLogout()
	{
		click(MyAccountPageLocators.LOGOUT_LINK.getLocator());
	}
	
	//abstract methods implementations
	
	public boolean isPageLoaded()
	{
		return isDisplayed(MyAccountPageLocators.PAGE_HEADING.getLocator());
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	//locators for MyAccountPage
	
	private enum MyAccountPageLocators {
		PAGE_HEADING(By.xpath("//h2[normalize-space()='My Account']")),
		LOGOUT_LINK(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));
		
		private final By locator;
		
		MyAccountPageLocators(By locator)
		{
			this.locator = locator;
 		}
		
		public By getLocator()
		{
			return this.locator;
		}
	}
	
}
