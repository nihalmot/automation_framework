package desktopProducts;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.BasePage;

public class ApplePage extends BasePage {

	// constructors for ApplePage

	public ApplePage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("Apple Page not loaded correctly");
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

	public WebElement verifyProductPrice() {
		return driver.findElement(Page_Elements.PRODUCT_PRICE.getLocator());
	}

	public void selectCheckBoxes(String chkBxOption) {
		List<WebElement> elements = driver.findElements(Page_Elements.CHECKBOX_OPTION.getLocator());

		for (WebElement element : elements) {
			if (element.getText().contains(chkBxOption)) {
				element.click();
			}
		}

	}

	public void selectCheckBoxes(String chkBxOption1, String chkBxOption2) {
		List<WebElement> elements = waitForElementsFluent(Page_Elements.CHECKBOX_OPTION.getLocator(), 10, 2);

		for (WebElement element : elements) {

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (element.getText().equals(chkBxOption1) || element.getText().equals(chkBxOption2)) {
				clickElementWithJavascriptExecutor(element);
				System.out.println(element.getText());
			}
		}
	}

	public void typeIntoTextField(String text) {
		type(Page_Elements.TEXT_FIELD.getLocator(), text);
	}

	public void selectProductColour(int index) {
		selectFromDropdown(Page_Elements.PRODUCT_COLOUR_DROPDOWN.getLocator(), index);
	}

	public void typeIntoTextAreaField(String text) {
		type(Page_Elements.TEXTAREA_FIELD.getLocator(), text);
	}

	public void selectDate(String day, String month, String year) {
		click(Page_Elements.DATE_CALANDER_OPTION.getLocator());

		String targetMonthYear = month + " " + year;
		while (true) {
			String dateDisplayed = driver.findElement(Page_Elements.DATE_DISPLAYED.getLocator()).getText().trim();

			if (dateDisplayed.equals(targetMonthYear)) {
				break;
			} else {
				// parse both strings to LocalDate to compare
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);

				YearMonth displayed = YearMonth.parse(dateDisplayed, formatter);
				YearMonth target = YearMonth.parse(targetMonthYear, formatter);

				if (displayed.isBefore(target)) {
					click(Page_Elements.NEXT_DATE.getLocator());
				} else {
					click(Page_Elements.PREV_DATE.getLocator());
				}
			}
		}

		// select specific date from the calendar

		List<WebElement> allDates = getElements(Page_Elements.ALL_DATES.getLocator());
		for (WebElement date : allDates) {
			if (date.getText().equals(day)) {
				date.click();
				break;
			}
		}
	}

	public void selectTime(int hour, int minute) {
		click(Page_Elements.TIME_PICKER_OPTION.getLocator());
		selectHour(hour);
		selectMinute(minute);
		click(Page_Elements.TIME_PICKER_OPTION.getLocator());

	}

	public void selectHour(int hour) {

		while (true) {
			int hourDisplayed = Integer
					.parseInt(driver.findElement(Page_Elements.HOUR_DISPLAYED.getLocator()).getText().trim());

			if (hourDisplayed == hour) {
				break;
			} else if (hourDisplayed < hour) {

				click(Page_Elements.UP_HOUR_ARROW.getLocator());
			} else {

				click(Page_Elements.DOWN_HOUR_ARROW.getLocator());
			}
		}
	}

	public void selectMinute(int minute) {

		while (true) {
			int hourDisplayed = Integer
					.parseInt(driver.findElement(Page_Elements.MINUTE_DISPLAYED.getLocator()).getText().trim());

			if (hourDisplayed == minute) {
				break;
			} else if (hourDisplayed < minute) {

				click(Page_Elements.UP_MINUTE_ARROW.getLocator());
			} else {

				click(Page_Elements.DOWN_MINUTE_ARROW.getLocator());
			}
		}
	}

	public void selectInnerDate(String day, String month, String year) {
		click(Page_Elements.DATE_AND_TIME_PICKER_OPTION.getLocator());

		String targetMonthYear = month + " " + year;
		while (true) {
			String dateDisplayed = driver.findElement(Page_Elements.INNER_DATE_DISPLAYED.getLocator()).getText().trim();

			if (dateDisplayed.equals(targetMonthYear)) {
				break;
			} else {
				// parse both strings to LocalDate to compare
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);

				YearMonth displayed = YearMonth.parse(dateDisplayed, formatter);
				YearMonth target = YearMonth.parse(targetMonthYear, formatter);

				if (displayed.isBefore(target)) {
					click(Page_Elements.INNER_NEXT_DATE.getLocator());
				} else {
					click(Page_Elements.INNER_PREV_DATE.getLocator());
				}
			}
		}

		// select specific date from the calendar

		List<WebElement> allDates = getElements(Page_Elements.INNER_ALL_DATES.getLocator());
		for (WebElement date : allDates) {
			if (date.getText().equals(day)) {
				date.click();
				break;
			}
		}

	}

	public void selectInnerTime(int hour, int minute) {
		clickElementWithJavascriptExecutor(getElement(Page_Elements.INNER_TIME_PICKER_OPTION.getLocator()));
		selectInnerHour(hour);
		selectInnerMinute(minute);
		click(Page_Elements.DATE_AND_TIME_PICKER_OPTION.getLocator());

	}

	public void selectInnerHour(int hour) {

		while (true) {

			int hourDisplayed = Integer.parseInt(
					waitForElementVisiblity(Page_Elements.INNER_HOUR_DISPLAYED.getLocator(), 10).getText().trim());

			if (hourDisplayed == hour) {
				break;
			} else if (hourDisplayed < hour) {

				click(Page_Elements.INNER_UP_HOUR_ARROW.getLocator());
			} else {

				click(Page_Elements.INNER_DOWN_HOUR_ARROW.getLocator());
			}
		}
	}

	public void selectInnerMinute(int minute) {

		while (true) {
			int hourDisplayed = Integer
					.parseInt(driver.findElement(Page_Elements.INNER_MINUTE_DISPLAYED.getLocator()).getText().trim());

			if (hourDisplayed == minute) {
				break;
			} else if (hourDisplayed < minute) {

				click(Page_Elements.INNER_UP_MINUTE_ARROW.getLocator());
			} else {

				click(Page_Elements.INNER_DOWN_MINUTE_ARROW.getLocator());
			}
		}
	}

	public void typeIntoQuantity(String qty) {
		type(Page_Elements.QUANTITY_OPTION.getLocator(), qty);
	}

	// locators for ApplePage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//h1[contains(text(),'Apple')]")),
		PRODUCT_PRICE(By.xpath("//h2[contains(text(),'$110.00')]")),
		CHECKBOX_OPTION(By.xpath("//div[@class='checkbox']")), TEXT_FIELD(By.xpath("//input[@id='input-option208']")),
		PRODUCT_COLOUR_DROPDOWN(By.xpath("//select[@id='input-option217']")),
		TEXTAREA_FIELD(By.xpath("//textarea[@id='input-option209']")),
		DATE_CALANDER_OPTION(By.xpath("(//span[@class='input-group-btn'])[2]")),
		PREV_DATE(By.xpath("(//th[@class='prev'])[1]")), NEXT_DATE(By.xpath("(//th[@class='next'])[1]")),
		DATE_DISPLAYED(By.xpath("(//th[@class='picker-switch'])[1]")),
		ALL_DATES(By.xpath("(//table[@class='table-condensed'])[1]//tbody//tr//td")),
		TIME_PICKER_OPTION(By.xpath("(//span[@class='input-group-btn'])[3]")),
		UP_HOUR_ARROW(By.xpath(
				"((//table[@class='table-condensed'])[10]//tr//a//span[@class='glyphicon glyphicon-chevron-up'])[1]")),
		UP_MINUTE_ARROW(By.xpath(
				"((//table[@class='table-condensed'])[10]//tr//a//span[@class='glyphicon glyphicon-chevron-up'])[2]")),
		DOWN_HOUR_ARROW(By.xpath(
				"((//table[@class='table-condensed'])[10]//tr//a//span[@class='glyphicon glyphicon-chevron-down'])[1]")),
		DOWN_MINUTE_ARROW(By.xpath(
				"((//table[@class='table-condensed'])[10]//tr//a//span[@class='glyphicon glyphicon-chevron-down'])[2]")),
		HOUR_DISPLAYED(By.xpath("(//table[@class='table-condensed'])[10]//tr//span[@class='timepicker-hour']")),
		MINUTE_DISPLAYED(By.xpath("(//table[@class='table-condensed'])[10]//tr//span[@class='timepicker-minute']")),
		DATE_AND_TIME_PICKER_OPTION(By.xpath("(//span[@class='input-group-btn'])[4]")),
		INNER_TIME_PICKER_OPTION(By.xpath("//LI[@class='picker-switch accordion-toggle']")),
		INNER_PREV_DATE(By.xpath("(//th[@class='prev'])[4]")), INNER_NEXT_DATE(By.xpath("(//th[@class='next'])[4]")),
		INNER_DATE_DISPLAYED(By.xpath("(//th[@class='picker-switch'])[4]")),
		INNER_ALL_DATES(By.xpath("(//table[@class='table-condensed'])[4]//tbody//tr//td")),
		INNER_UP_HOUR_ARROW(By.xpath(
				"((//table[@class='table-condensed'])[7]//tr//a//span[@class='glyphicon glyphicon-chevron-up'])[1]")),
		INNER_UP_MINUTE_ARROW(By.xpath(
				"((//table[@class='table-condensed'])[7]//tr//a//span[@class='glyphicon glyphicon-chevron-up'])[2]")),
		INNER_DOWN_HOUR_ARROW(By.xpath(
				"((//table[@class='table-condensed'])[7]//tr//a//span[@class='glyphicon glyphicon-chevron-down'])[1]")),
		INNER_DOWN_MINUTE_ARROW(By.xpath(
				"((//table[@class='table-condensed'])[7]//tr//a//span[@class='glyphicon glyphicon-chevron-down'])[2]")),
		INNER_HOUR_DISPLAYED(By.xpath("(//table[@class='table-condensed'])[7]//tr//span[@class='timepicker-hour']")),
		INNER_MINUTE_DISPLAYED(
				By.xpath("(//table[@class='table-condensed'])[7]//tr//span[@class='timepicker-minute']")),
		QUANTITY_OPTION(By.xpath("//input[@id='input-quantity']"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}
	}

}
