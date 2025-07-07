package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

	//constructor for LoginPage
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//action methods
	
	public void setEmail(String email)
	{
		type(LoginPageLocators.EMAIL_ADDRESS.getLocator(), email);
	}
	
	public void setPassword(String password)
	{
		type(LoginPageLocators.PASSWORD.getLocator(), password);
	}
	
	public void clickLogin()
	{
		click(LoginPageLocators.LOGIN_BUTTON.getLocator());
	}
	
	//abstract methods implementations
	
	@Override
	public boolean isPageLoaded()
	{
		return isDisplayed(LoginPageLocators.LOGIN_BUTTON.getLocator());
	}
	
	@Override
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	//locators for Login Page
	
	private enum LoginPageLocators {
		EMAIL_ADDRESS(By.xpath("//input[@id='input-email']")),
		PASSWORD(By.xpath("//input[@id='input-password']")),
		LOGIN_BUTTON(By.xpath("//input[@value='Login']"));
		
		private final By locator;
		
		LoginPageLocators(By locator)
		{
			this.locator = locator;
		}
		
		public By getLocator()
		{
			return this.locator;
		}
	}
	
}
