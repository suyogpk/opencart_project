package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//h2[text()='My Account']")WebElement confmsg;
	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[13]")WebElement lnklogout;
	
	
	public String getConfmsg() {
		try {
			return confmsg.getText();
		} catch (Exception e) {
			return(e.getMessage());
		}
	}
	public void clicklogout() {
		
		lnklogout.click();
	}
}
