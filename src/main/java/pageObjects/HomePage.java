package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

	//constructor for HomePage
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//action methods
	
	public void clickMyAccount()
	{
		click(HomePageLocators.MYACCOUNT_LINK.getLocator());
	}
	
	public void clickRegister()
	{
		click(HomePageLocators.REGISTER_LINK.getLocator());
	}
	
	public void clickLogin()
	{
		click(HomePageLocators.LOGIN_LINK.getLocator());
	}
	
	//abstract methods implementation
	
	@Override
	public boolean isPageLoaded()
	{
		return isDisplayed(HomePageLocators.MYACCOUNT_LINK.getLocator());
	}
	
	@Override
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	
	//locators for Home Page
	
	private enum HomePageLocators {
		MYACCOUNT_LINK(By.xpath("//span[normalize-space()='My Account']")),
		REGISTER_LINK(By.xpath("//a[normalize-space()='Register']")),
		LOGIN_LINK(By.xpath("//a[normalize-space()='Login']"));
		
		private final By locator;
		
		HomePageLocators(By locator)
		{
			this.locator = locator;
		}
		
		public By getLocator()
		{
			return this.locator;
		}
	}
	
}
