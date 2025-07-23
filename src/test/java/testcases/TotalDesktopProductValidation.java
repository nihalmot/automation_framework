package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TotalDesktopProductValidation extends BaseTest {

	@Test
	public void verify_total_product() {
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
		try {
			Assert.assertEquals(12, desktopsPage.getAllElements().size());
			System.out.println("Total number of elements displayed : "+desktopsPage.getAllElements().size());
		} catch(Exception e) {
			System.out.println("Total elements displayed is not equals to expected number of elements");
		}
		
	}
}
