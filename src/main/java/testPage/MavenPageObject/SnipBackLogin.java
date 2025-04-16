package testPage.MavenPageObject;
import TestData.SnipBackLogin_TestData;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Please enter your email address")), "User can able to login the page and  receive a error message");

	}
	///<summary>
	///Testcase Title:Verify what happens when the user kept the password field empty
	///Automation ID:TC_03
	///</summary>
	public void SH_SnipBackLogin_TC03() {

		SnipBackLogin_Obj SnipBackLoginObj = new SnipBackLogin_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CommonData CommonData = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		//Step 1: Go to Snipback website
		//Click login button from the home page
		//Expected:User should able to click login  button
		base.buttonClick(SnipBackLoginObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Signin("SIGN IN")), "User shouldnot be able to click login  button");

		//Step 2: Enter a valid email address
		//Expected:User should be able to enter the valid email address
		base.setData(RegistrationObj.Ele_Email("email_address"),CommonData.UserName);
		String ActualEmailID = base.GetValue(RegistrationObj.Ele_Email("email_address"));
		asrt.assertEquals(ActualEmailID, CommonData.UserName,"User shouldnot be able to enter the valid email address in the Login page");

		//Step 3.Click on the sign in button 
		//Expected:User Shouldn't able to login the page and should receive a error message
		base.buttonClick(SnipBackLoginObj.Btn_Signin("SIGN IN"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Password is required")), "user not receive the error message in the Login page");

	}

	///<summary>
	///Testcase Title:Verify what happens when the user kept the email address field empty
	///Automation ID:TC_04
	///</summary>
	public void SH_SnipBackLogin_TC04() {
	
		SnipBackLogin_Obj SnipBackLoginObj = new SnipBackLogin_Obj();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData CommonData = new CommonData();
		
		//Step 1: Go to Snipback website
		//Click login button from the home page
		//Expected:User should able to click login  button
		base.buttonClick(SnipBackLoginObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Signin("SIGN IN")), "User shouldnot be able to click login  button");
		
		//Step 2:Enter a valid  password
		//Expected:User should be able enter the valid password
		base.setData(LoginPageObj.Edt_LoginEmail("password"),CommonData.PassWord );
		String ActualPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("password"));
		asrt.assertEquals(ActualPassword, CommonData.PassWord ,"User not able to enter the valid password");
	
		//Step 3: Click on the sign in button 
		//Expected: User Shouldn't able to login the page and should receive a error message(Please enter your email address)
		base.buttonClick(SnipBackLoginObj.Btn_Signin("SIGN IN"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Please enter your email address")),"User able to login the page and not  receive a error message(Please enter your email address)" );
	    base.buttonClick(SnipBackLoginObj.Btn_Signin("SIGN IN"));
	    asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Password is required")), "user not receive the error message in the Login page");

	}
	

	}



