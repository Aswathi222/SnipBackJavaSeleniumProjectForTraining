package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestData.CommonData;
import TestData.SnipBackLogin_TestData;
import objectRepository.LoginPage_Obj;
import utilPack.BasePge;

//import basePackage.BasePge;

public class Login extends BasePge {

	BasePge base;
	Assert asrt;

	public Login(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	public void loginToApplication(String UserName, String PassWord) throws InterruptedException 
	{
		    LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		    CommonData CommonData = new CommonData();
		    
		    base.buttonClick(LoginPageObj.Btn_Login("Login"));
		    base.buttonClick(LoginPageObj.Edt_LoginCredentialFields("email_address"));
		    base.setData(LoginPageObj.Edt_LoginCredentialFields("email_address"), UserName);		    
			base.setData(LoginPageObj.Edt_LoginCredentialFields("password"),PassWord);
			base.buttonClick(LoginPageObj.Btn_SignInButton("SIGN IN"));
			
			asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("dark-logo")), "Error- Unable to view Home Page");
					
	}
	
	public void logoutApplication(By logoutOptionLocatorForScrollDown, By logoutOptionLocator) 
	{
	        
	        LoginPage_Obj loginPageObj = new LoginPage_Obj();
	        driver.navigate().refresh();
	        base.buttonClick(loginPageObj.Btn_Logout("navbarSupportedContent","btn dropdown-toggle"));
	        WebElement logoutOption = driver.findElement(logoutOptionLocator);
	        base.scrollToElement(logoutOptionLocatorForScrollDown);
	        logoutOption.click();      
	}

}
