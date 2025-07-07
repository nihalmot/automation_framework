package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	protected WebDriver driver;
	
	//constructor
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//abstract methods that child pages must implement (un-implemented)
	
	public abstract boolean isPageLoaded();
	public abstract String getPageTitle();
	
	//reusable actions (implemented)
	
	//find single element
	
	protected WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	//find multiple elements
	
	protected List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	//actions
	
	protected void click(By locator)
	{
		getElement(locator).click();
	}
	
	protected void type(By locator, String text)
	{
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	protected String getText(By locator)
	{
		return getElement(locator).getText();
	}
	
	protected boolean isDisplayed(By locator)
	{
		try {
			return getElement(locator).isDisplayed();
		} catch(Exception e) {
			return false;
		}
	}
	
	protected String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	protected String getPageSource()
	{
		return driver.getPageSource();
	}
	
	//click radio button by value match
	
	protected void selectRadioButton(By locator, String valueToSelect)
	{
		List<WebElement> radios = getElements(locator);
		for(WebElement radio : radios)
		{
			String value = radio.getAttribute("value");
			if(value != null && value.equalsIgnoreCase(valueToSelect)) {
				if(!radio.isSelected()) {
					radio.click();
				}
				break;
			}
		}
	}
	
	//click radio button by visible label text
	
	protected void selectRadioButtonByLabel(By locator, String labelText)
	{
		List<WebElement> radios = getElements(locator);
		for(WebElement radio : radios) {
			if(radio.getText().trim().equalsIgnoreCase(labelText)) {
				if(!radio.isSelected()) {
					radio.click();
				}
				break;
			}
		}
	}
	
	//select drop down by visible text
	
	protected void selectFromDropdown(By locator, String visibleText)
	{
		WebElement dropdown = getElement(locator);
		Select select = new Select(dropdown);
		select.selectByVisibleText(visibleText);
	}
	
	//select drop down by index
	
	protected void selectFromDropdown(By locator, int index)
	{
		WebElement dropdown = getElement(locator);
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}
	
	//select drop down by value attribute
	
	protected void selectFromDropdownByValue(By locator, String value)
	{
		WebElement dropdown = getElement(locator);
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}
	
	//wait for single element (Explicit Wait)
	
	protected WebElement waitForElementVisiblity(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//wait for multiple elements (Fluent Wait)
	
	protected List<WebElement> waitForElementsFluent(By locator, int timeout, int polling){
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(polling))
				.ignoring(NoSuchElementException.class);
		
		return fluentWait.until(driver -> {
			List<WebElement> elements = driver.findElements(locator);
			return elements.isEmpty() ? null : elements;
		});
	}
	
	
}
