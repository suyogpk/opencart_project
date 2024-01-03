package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002LoginAccount extends BaseClass {
	@Test(groups= {"Sanity","Master"})
	public void TC_002_LoginAccount() {
	 HomePage hp = new HomePage(driver);
	 LoginPage lp = new LoginPage(driver);
	 try {
		 logger.info("*** starting TC_002LoginAccount *** ");
		 logger.info("Clicked on My Account ");
		 hp.clickMyaccount();
		 logger.info("Clicked Login ");
		 hp.clickLogin();
		 logger.info("on account login page ");
		 logger.info("Providing registered customer data ");
		 hp.submitEmail(rb.getString("loginemail"));
		 hp.submitPassword(rb.getString("loginpassword"));
		 logger.info("Click on login button ");
		 hp.clickLoginbutton();
		 logger.info("On account dashboard ");
		 Assert.assertEquals(lp.getConfmsg(), "My Account","Login failed");
		 
		 
		 
	} catch (Exception e) {
		Assert.fail();
	}
	 logger.info("*** Finished TC_002LoginAccount *** ");
	}
}
