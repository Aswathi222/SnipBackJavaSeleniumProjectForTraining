package testPage.MavenPageObject;
import TestData.SnipBackLogin_TestData;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
import objectRepository.LoginPage_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;
public class SnipBackLogin extends BasePge{

	BasePge base;
	Assert asrt;

	public SnipBackLogin(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	///<summary>
	///Testcase Title:Verify whether the user can be able to  login 
	///Automation ID:TC_01
	///</summary>
    public void SH_SnipBackLogin_TC01() {
    
    	SnipBackLogin_Obj SnipBackLoginObj=new SnipBackLogin_Obj();
    	
    	 //Step 1:Go to Snipback website
    	 //Step 2:Click Login button
    	//Expected:User should able to click login  button
    	base.buttonClick(SnipBackLoginObj.Btn_Login("Login"));
    	asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Signin("SIGN IN")), "User shouldnot be able to click login  button");
    	
    }
    
  ///<summary>
  	///Testcase Title:Verify what happens when the user does not fill the Email Address and Password field
  	///Automation ID:TC_02
  	///</summary>
      public void SH_SnipBackLogin_TC02() {
    	  SnipBackLogin_Obj SnipBackLoginObj=new SnipBackLogin_Obj();
          LoginPage_Obj  LoginPageObj=new  LoginPage_Obj();
          
    	  
    	 //Step 1: Go to Snipback website
    	//Step  2: Click login button from the home page
    	//Expected:User should able to click login  button
      	base.buttonClick(SnipBackLoginObj.Btn_Login("Login"));
      	asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Signin("SIGN IN")), "User shouldnot be able to click login  button");
      	 
      	//Step 3: Without filling any field, click Sign In
      	//Expected : User Shouldn't able to login the page and should receive a error message(User not found)
      	base.buttonClick(SnipBackLoginObj.Btn_Signin("SIGN IN")); 
      	asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Please enter your email address")), "User can able to login the page and  receive a error message");
    	 
      }
	
}



