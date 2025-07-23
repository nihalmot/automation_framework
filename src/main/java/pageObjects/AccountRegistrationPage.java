package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountRegistrationPage extends BasePage {

	// constructor for AccountRegistrationPage

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		if(!isPageLoaded())
		{
			throw new IllegalStateException("Account Registration Page not loaded correctly");
		}
	}

	// abstract methods implementation

	@Override
	public boolean isPageLoaded() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Page_Elements.PAGE_HEADER_TEXT.getLocator()));
			return isDisplayed(Page_Elements.PAGE_HEADER_TEXT.getLocator());
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	// action methods

	public void setFirstName(String fname) {
		type(Page_Elements.FIRST_NAME.getLocator(), fname);
	}

	public void setLastName(String lname) {
		type(Page_Elements.LAST_NAME.getLocator(), lname);
	}

	public void setEmail(String email) {
		type(Page_Elements.EMAIL.getLocator(), email);
	}

	public void setTelephone(String telephone) {
		type(Page_Elements.TELEPHONE.getLocator(), telephone);
	}

	public void setPassword(String password) {
		type(Page_Elements.PASSWORD.getLocator(), password);
	}

	public void setConfirmPassword(String cnfpassword) {
		type(Page_Elements.CONFIRM_PASSWORD.getLocator(), cnfpassword);
	}

	public void setPrivacyPolicy() {
		click(Page_Elements.CHECKED_POLICY.getLocator());
	}

	public void clickContinue() {
		click(Page_Elements.CONTINUE_BUTTON.getLocator());
	}

	public String getConfirmationMsg() {
		try {
			return (getText(Page_Elements.CONFIRMATION_MESSAGE.getLocator()));
		} catch (Exception e) {
			return (e.getMessage());
		}

	}

	// locators of Account Registration page

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//h1[contains(text(),'Register Account')]")),
		FIRST_NAME(By.xpath("//input[@id='input-firstname']")), LAST_NAME(By.xpath("//input[@id='input-lastname']")),
		EMAIL(By.xpath("//input[@id='input-email']")), TELEPHONE(By.xpath("//input[@id='input-telephone']")),
		PASSWORD(By.xpath("//input[@id='input-password']")), CONFIRM_PASSWORD(By.xpath("//input[@id='input-confirm']")),
		CHECKED_POLICY(By.xpath("//input[@name='agree']")), CONTINUE_BUTTON(By.xpath("//input[@value='Continue']")),
		CONFIRMATION_MESSAGE(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}
	}

}
