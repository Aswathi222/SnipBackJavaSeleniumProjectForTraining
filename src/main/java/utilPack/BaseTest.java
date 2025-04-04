package utilPack;

import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
public WebDriver driver;

	@BeforeMethod
	@Parameters("Browser")
	public void initializeDriver(String browser) throws InterruptedException {
		
		  if(browser.equalsIgnoreCase("Chrome")) {

             
             ChromeOptions options = new ChromeOptions();
		     options.setAcceptInsecureCerts(true);  //This is to handle the ssl certification issue of chrome browser
		     //options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking","enable-automation"));	    
		     //WebDriverManager.chromedriver().setup();
		     System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Utils/chromedriver.exe");
		     driver=new ChromeDriver(options);
	     
		  }
		 
		 if(browser.equalsIgnoreCase("Firefox")) {
//			 String path=System.getProperty("user.dir");//making reference to the current directory
//		     System.out.println(path);
//		     System.setProperty("webdriver.gecko.driver", path+"\\Utils\\geckodriver.exe");
		     System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		     WebDriverManager.firefoxdriver().setup();
	         driver=new FirefoxDriver();	 
		 }
		 
		 else {
			 System.out.println("Invalid browser type");
		 }
			 
			 driver.manage().window().maximize();
		    // driver.navigate().to("https://snipback.com/");
		     driver.get("https://web06-stg-ch.snipback.com/");
			 //driver.get("https://snipback.com/");
		     
		     String userAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		     System.out.println("User Agent: " + userAgent);
 	    	
	}
	
	@AfterMethod
	public void closeDriver() {
		if (driver!=null) {
	//	   driver.quit();
		}
	}
	public WebDriver getDriver() {
		return driver;
	}

}
