package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountRegistrationPage extends BasePage{

	//constructor for AccountRegistrationPage
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//action methods
	
	public void setFirstName(String fname)
	{
		type(AccountRegistrationPageLocators.FIRST_NAME.getLocator(), fname);
	}
	
	public void setLastName(String lname)
	{
		type(AccountRegistrationPageLocators.LAST_NAME.getLocator(), lname);
	}
	
	public void setEmail(String email)
	{
		type(AccountRegistrationPageLocators.EMAIL.getLocator(), email);
	}
	
	public void setTelephone(String telephone)
	{
		type(AccountRegistrationPageLocators.TELEPHONE.getLocator(), telephone);
	}
	
	public void setPassword(String password)
	{
		type(AccountRegistrationPageLocators.PASSWORD.getLocator(), password);
	}
	
	public void setConfirmPassword(String cnfpassword)
	{
		type(AccountRegistrationPageLocators.CONFIRM_PASSWORD.getLocator(), cnfpassword);
	}
	
	public void setPrivacyPolicy()
	{
		click(AccountRegistrationPageLocators.CHECKED_POLICY.getLocator());
	}
	
	public void clickContinue()
	{
		click(AccountRegistrationPageLocators.CONTINUE_BUTTON.getLocator());
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			return(getText(AccountRegistrationPageLocators.CONFIRMATION_MESSAGE.getLocator()));
		} catch(Exception e) {
			return(e.getMessage());
		}
		
	}
	
	//abstract methods implementation
	
	@Override
	public boolean isPageLoaded() {
		return isDisplayed(AccountRegistrationPageLocators.CONTINUE_BUTTON.getLocator());
	}
	
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	//locators of Account Registration page
	
	private enum AccountRegistrationPageLocators {
		FIRST_NAME(By.xpath("//input[@id='input-firstname']")),
		LAST_NAME(By.xpath("//input[@id='input-lastname']")),
		EMAIL(By.xpath("//input[@id='input-email']")),
		TELEPHONE(By.xpath("//input[@id='input-telephone']")),
		PASSWORD(By.xpath("//input[@id='input-password']")),
		CONFIRM_PASSWORD(By.xpath("//input[@id='input-confirm']")),
		CHECKED_POLICY(By.xpath("//input[@name='agree']")),
		CONTINUE_BUTTON(By.xpath("//input[@value='Continue']")),
		CONFIRMATION_MESSAGE(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
		
		private final By locator;
		
		AccountRegistrationPageLocators(By locator) {
			this.locator = locator;
		}
		
		public By getLocator() {
			return this.locator;
		}
	}
	
}
