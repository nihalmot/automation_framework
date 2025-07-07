package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseTest{

	@Test(groups = {"Sanity","Master"})
	public void verify_login()
	{
		logger.info("*********Starting TC002_LoginTest***********");
		
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		homePage.clickLogin();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(p.getProperty("email"));
		loginPage.setPassword(p.getProperty("password"));
		loginPage.clickLogin();
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		Assert.assertTrue(myAccountPage.isPageLoaded(), "My Account page is not loaded");
		
	}
	
}
