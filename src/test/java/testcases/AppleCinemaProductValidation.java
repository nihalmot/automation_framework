package testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import desktopProducts.ApplePage;
import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class AppleCinemaProductValidation extends BaseTest {

	@Test
	public void verify_apple_cinema_product() {

		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		homePage.clickLogin();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(p.getProperty("email"));
		loginPage.setPassword(p.getProperty("password"));
		loginPage.clickLogin();

		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.clickDesktopsOption();

		DesktopsPage desktopsPage = new DesktopsPage(driver);
		List<WebElement> elements = desktopsPage.getAllElements();
		for (WebElement element : elements) {
			if (element.getAttribute("title").contains("Apple")) {

				element.click();
				break;
			}
		}

		ApplePage applePage = new ApplePage(driver);

		Assert.assertTrue(applePage.verifyProductPrice().getText().equals("$110.00"));
		applePage.selectCheckBoxes("Checkbox 3 (+$36.00)", "Checkbox 4 (+$48.00)");
		applePage.typeIntoTextField("Validate Apple Cinema Product");
		applePage.selectProductColour(1);
		applePage.typeIntoTextAreaField("This test case add apple cinema product into cart");
		applePage.selectDate("20", "May", "2016");
		applePage.selectTime(10, 30);
		applePage.selectInnerDate("20", "May", "2016");
		applePage.selectInnerTime(10, 30);
		applePage.typeIntoQuantity("10");

	}
}
