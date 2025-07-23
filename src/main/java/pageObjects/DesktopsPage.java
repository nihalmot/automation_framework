package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DesktopsPage extends BasePage {

	// constructors for DesktopsPage

	public DesktopsPage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("Desktops Page not loaded correctly");
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

	public List<WebElement> getAllElements() {
		List<WebElement> elements = driver.findElements(Page_Elements.PRODUCTS_LIST.getLocator());
		return elements;
	}

	// locators for DesktopsPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//h2[contains(text(),'Desktops')]")),
		PRODUCTS_LIST(By.xpath("//div[@id='content']//div[4]//div//img"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}
	}

}
