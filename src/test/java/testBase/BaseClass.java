package testBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // logging

public class BaseClass {
	public static WebDriver driver;
	public ResourceBundle rb;
	public Logger logger;
	@BeforeClass(groups = { "Master", "Sanity", "Regression" }) 
	@Parameters("browser")
	public void setup (String br) {
		logger=LogManager.getLogger(this.getClass());
		rb=ResourceBundle.getBundle("config"); // Load config.properties file
		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (br.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/upload/");
		driver.manage().window().maximize();
	}
	@AfterClass(groups = { "Master", "Sanity", "Regression" }) 
	public void tearDown() {
		driver.quit();
	}
	public String randomString() {
		String generateAlpha = RandomStringUtils.randomAlphabetic(6);
		return generateAlpha;
	}
	public String randomNumber() {
		String generateNum = RandomStringUtils.randomNumeric(10);
		return generateNum;
	}
	public String alphaNumeric() {
		String alpha = RandomStringUtils.randomAlphabetic(3);
		String numeric = RandomStringUtils.randomNumeric(3);
		return (alpha+"@"+numeric);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}
