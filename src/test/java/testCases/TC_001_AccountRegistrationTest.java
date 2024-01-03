package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.Register_page;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(priority = 1, groups = {"regression","master"})
	public void test_HomrPage() {
		HomePage hp = new HomePage(driver);
		logger.info("*** starting TC_001_AccountRegistrationTest *** ");
		logger.info("Clicked on My Account ");
		hp.clickMyaccount();
		logger.info("Clicked on Register link ");
		hp.clickRegister();
		Assert.assertEquals(hp.getConfmsg(), "Register Account");
	}
	@Test(priority = 2, groups = {"regression","master"})
	public void test_registrationPage() {
		Register_page rp = new Register_page(driver);
		logger.info("*** starting TC_001_AccountRegistrationTest *** ");
		
		try {
			logger.info("Providing customer data ");
			rp.setfirstname(randomString());
			rp.setlastname(randomString());
			rp.setemail(randomString()+"@gmail.com");
			rp.settelephn(randomNumber());
			String password = alphaNumeric();
			rp.setpassword(password);
			rp.cnfpassword(password);
			rp.privacypolicy();
			logger.info("Clicked on Continue ");
			rp.clickContinue();
			logger.info("Validating expected result ");
			Assert.assertEquals(rp.getConfmsg(), "Your Account Has Been Created!");
			
		} catch (Exception e) {
			logger.error("test fail");
			Assert.fail();
		}
		logger.info("*** Finished TC_001_AccountRegistrationTest *** ");
		
	}
}
