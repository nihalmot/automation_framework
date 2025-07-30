package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.TabletsPage;

public class TabletAddToCartValidation extends BaseTest {

	@Test
	public void verify_tablet_add_to_cart_product() {

		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		homePage.clickLogin();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(p.getProperty("email"));
		loginPage.setPassword(p.getProperty("password"));
		loginPage.clickLogin();

		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.clickTabletsOption();

		TabletsPage tabletsPage = new TabletsPage(driver);
		tabletsPage.clickSamsungTab();
		tabletsPage.enterQuantity();
		tabletsPage.clickAddToCart();

		Assert.assertTrue(tabletsPage.validateProductAdditionToCart(), "Product is not added to cart");

		tabletsPage.clickCartOption();
		tabletsPage.clickCheckoutOption();
	}
}
