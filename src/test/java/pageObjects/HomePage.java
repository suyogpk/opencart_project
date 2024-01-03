package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	//WebElements
	@FindBy(xpath = "//span[text()='My Account']")WebElement lnkMyAccount;
	@FindBy(linkText="Register")WebElement lnkRegister;
	@FindBy(xpath = "//h1[text()='Register Account']")WebElement cnfmsg;
	@FindBy(linkText = "Login")WebElement lnklogin;
	@FindBy(xpath = "//input[@name='email']")WebElement txtemail;
	@FindBy(xpath = "//input[@placeholder='Password']")WebElement txtpassword;
	@FindBy(xpath = "//input[@type='submit']")WebElement btnlogin;
	
	//Action methods
	public void clickMyaccount() {
		lnkMyAccount.click();
	}
	public void clickRegister() {
		lnkRegister.click();
	}
	public String getConfmsg() {
		try {
			return cnfmsg.getText();
		} catch (Exception e) {
			return(e.getMessage());
		}
	}
	public void clickLogin() {
		lnklogin.click();
	}
	public void submitEmail(String email) {
		txtemail.sendKeys(email);
	}
	public void submitPassword(String paswrd) {
		txtpassword.sendKeys(paswrd);
	}
	public void clickLoginbutton() {
		btnlogin.click();
	}	
	
	
	
}
