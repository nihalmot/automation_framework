package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseTest{

	@Test(groups = {"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("*********Starting TC001_AccountRegistrationTest********");
		
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		
		logger.info("Clicked on MyAccount link");
		
		homePage.clickRegister();
		
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer details");
		
		accountRegistrationPage.setFirstName(randomeString().toUpperCase());
		accountRegistrationPage.setLastName(randomeString().toUpperCase());
		accountRegistrationPage.setEmail(randomeString() + "@gmail.com");
		accountRegistrationPage.setTelephone(randomeNumber());
		
		String password = randomeAlphaNumeric();
		accountRegistrationPage.setPassword(password);
		accountRegistrationPage.setConfirmPassword(password);
		
		accountRegistrationPage.setPrivacyPolicy();
		accountRegistrationPage.clickContinue();
		
		logger.info("Validating expected message");
		String confmsg = accountRegistrationPage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs...");
			Assert.assertFalse(false);
		}
		
		logger.info("********Finished TC001_AccountRegistrationTest**********");
	}
	
}
