package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {

	// constructor for MyAccountPage

	public MyAccountPage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("My Account Page not loaded correctly");
		}
	}

	// abstract methods implementations
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

	public void clickLogout() {
		click(Page_Elements.LOGOUT_LINK.getLocator());
	}

	public void clickDesktopsOption() {
		WebElement element = driver.findElement(Page_Elements.DESKTOPS_OPTION.getLocator());
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		click(Page_Elements.ALL_DESKTOPS_OPTION.getLocator());
		
	}
	
	// locators for MyAccountPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//h2[contains(text(),'My Account')]")),
		PAGE_HEADING(By.xpath("//h2[normalize-space()='My Account']")),
		LOGOUT_LINK(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")),
		DESKTOPS_OPTION(By.xpath("(//a[contains(text(),'Desktops')])[1]")),
		ALL_DESKTOPS_OPTION(By.xpath("//a[contains(text(),'Show AllDesktops')]"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}
	}

}
