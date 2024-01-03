package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_page extends BasePage {

	public Register_page(WebDriver driver) {
		super(driver);
		
	}
	//WebElements
	
	@FindBy(xpath = "//input[@name='firstname']")WebElement txt_fname;
	@FindBy(xpath = "//input[@name='lastname']")WebElement txt_lname;
	@FindBy(xpath = "//input[@id='input-email']")WebElement txt_email;
	@FindBy(xpath = "//input[@name='telephone']")WebElement num_telephn;
	@FindBy(xpath = "//input[@id='input-password']")WebElement txt_password;
	@FindBy(xpath = "//input[@name='confirm']")WebElement txt_cnfpasswrd;
	@FindBy(xpath = "//input[@type='checkbox']")WebElement rad_prpolicyElement;
	@FindBy(xpath = "//input[@value='Continue']")WebElement btn_continue;
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")WebElement cnfmsg;
	
	//Action methods
	
	public void setfirstname(String fname) {
		txt_fname.sendKeys(fname);
	}
	public void setlastname(String lname) {
		txt_lname.sendKeys(lname);
	}
	public void setemail(String email) {
		txt_email.sendKeys(email);
	}
	public void settelephn(String phn) {
		num_telephn.sendKeys(phn);
	}
	public void setpassword(String paswrd) {
		txt_password.sendKeys(paswrd);
	}
	public void cnfpassword(String cpaswrd) {
		txt_cnfpasswrd.sendKeys(cpaswrd);
	}
	public void privacypolicy() {
		rad_prpolicyElement.click();
	}
	public void clickContinue() {
		btn_continue.click();
	}
	public String getConfmsg() {
		try {
			return cnfmsg.getText();
		} catch (Exception e) {
			return(e.getMessage());
		}
	}
	
	
	
	
	
}
