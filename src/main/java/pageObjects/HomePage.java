package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

	//constructor for HomePage
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		if(!isPageLoaded())
		{
			throw new IllegalStateException("Home Page not loaded correctly");
		}
	}
	
	//abstract methods implementation
	
		@Override
		public boolean isPageLoaded()
		{
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(Page_Elements.PAGE_HEADER_TEXT.getLocator()));
				return isDisplayed(Page_Elements.PAGE_HEADER_TEXT.getLocator());
				
			} catch (Exception e) {
				return false;
			}
		}
		
		@Override
		public String getPageTitle()
		{
			return driver.getTitle();
		}
	
	//action methods
	
	public void clickMyAccount()
	{
		click(Page_Elements.MYACCOUNT_LINK.getLocator());
	}
	
	public void clickRegister()
	{
		click(Page_Elements.REGISTER_LINK.getLocator());
	}
	
	public void clickLogin()
	{
		click(Page_Elements.LOGIN_LINK.getLocator());
	}
	
	
	//locators for Home Page
	
	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//a[contains(text(),'Qafox.com')]")),
		MYACCOUNT_LINK(By.xpath("//span[normalize-space()='My Account']")),
		REGISTER_LINK(By.xpath("//a[normalize-space()='Register']")),
		LOGIN_LINK(By.xpath("//a[normalize-space()='Login']"));
		
		private final By locator;
		
		Page_Elements(By locator)
		{
			this.locator = locator;
		}
		
		public By getLocator()
		{
			return this.locator;
		}
	}
	
}
