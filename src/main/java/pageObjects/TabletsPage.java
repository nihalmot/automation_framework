package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TabletsPage extends BasePage {

	// constructors for TabletsPage

	public TabletsPage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("Tablets Page not loaded correctly");
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

	public void clickSamsungTab() {
		click(Page_Elements.SAMSUNG_TAB.getLocator());
	}

	public void enterQuantity() {
		type(Page_Elements.QUANTITY_FIELD.getLocator(), "2");
	}

	public void clickAddToCart() {
		click(Page_Elements.ADD_TO_CART_BUTTON.getLocator());
	}

	public void clickCartOption() {
		click(Page_Elements.CART_OPTION.getLocator());
	}

	public void clickCheckoutOption() {
		click(Page_Elements.CHECKOUT_OPTION.getLocator());
	}

	public boolean validateProductAdditionToCart() {
		return isDisplayed(Page_Elements.PRODUCT_ADD_TO_CART_CONFIRMATION.getLocator());
	}

	// locators for TabletsPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//h2[contains(text(),'Tablets')]")),
		SAMSUNG_TAB(By.xpath("//h4//a[contains(text(),'Samsung Galaxy Tab 10.1')]")),
		QUANTITY_FIELD(By.xpath("//input[@id='input-quantity']")),
		ADD_TO_CART_BUTTON(By.xpath("//button[contains(text(),'Add to Cart')]")),
		CART_OPTION(By.xpath("//span[@id='cart-total']")),
		CHECKOUT_OPTION(By.xpath("//ul[@class='dropdown-menu pull-right']//li[2]//a[2]")),
		PRODUCT_ADD_TO_CART_CONFIRMATION(By.xpath("//div[@class='alert alert-success alert-dismissible']//a[1]"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}
	}

}
