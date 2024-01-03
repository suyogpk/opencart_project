package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDp extends BaseClass {
	
	@Test(dataProvider = "LoginData",dataProviderClass =DataProviders.class )
	public void test_loginData(String email, String pwd, String exp) {
		logger.info(" ***Starting TC_003_LoginDataDrivenTest*** ");

		try {
			HomePage hp = new HomePage(driver);
			LoginPage lp = new LoginPage(driver);
			hp.clickMyaccount();
			hp.clickLogin();
			hp.submitEmail(email);
			hp.submitPassword(pwd);
			hp.clickLoginbutton();

			if (exp.equalsIgnoreCase("Valid")) {
				if (lp.getConfmsg().equals("My Account")) {
					lp.clicklogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (lp.getConfmsg().equals("My Account") ) {
					lp.clicklogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("*** Finished TC_003_LoginDataDrivenTest***");

	}
	}


