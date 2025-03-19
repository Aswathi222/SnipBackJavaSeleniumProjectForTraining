package testPage.MavenPageObject;
import TestData.ForgotPassword_TestData;
import TestData.Login_TestData;
import TestData.Registration_TestData;
import TestData.SnipBackLogin_TestData;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;
public class SnipBackLogin extends BasePge{

	BasePge base;
	Assert asrt;

	public SnipBackLogin(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	// <summary>
	// Test Case Title : "Verify what happens when the user enter a invalid password"
	// Automation ID : TC06_Login
	// </summary>
	public void TC06_LoginTest() {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SnipBackLogin_TestData logintestdata = new SnipBackLogin_TestData();

		//Step 1: Access to the given mail id page
		//Expected: The Login/mail id page should be displayed
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_address")),"The email id page is not displayed.");
		
		//Step 2 : Verify what happens when the user enter a valid email address
		//Expected : User able to enter valid email address
		base.setData(LoginPageObj.Edt_LoginEmail("email_address"),logintestdata.TC06_LoginEmailId);	
		String InvalidEmail=base.GetValue(LoginPageObj.Edt_LoginEmail("email_address"));
		asrt.assertEquals(InvalidEmail,logintestdata.TC06_LoginEmailId,"The email entered does not match the testdata.");
		
		//Step 3 : Verify what happens when the user enter a invalid password
		//Expected : User Shouldn't able to login the page and should receive a error message (Password mismatch)
		base.setData(LoginPageObj.Edt_LoginEmail("password"),logintestdata.TC06_LoginInvalidPassword);
		String InvalidPassword=base.GetValue(LoginPageObj.Edt_LoginEmail("password"));
		asrt.assertEquals(InvalidPassword,logintestdata.TC06_LoginInvalidPassword,"The email entered does not match the testdata.");
		
		//Step 4 : click on signIn button
		//Expected :User Shouldn't able to login the page and should receive a error message (Incorrect Email Address or Password)	
		base.buttonClick(LoginPageObj.Btn_SingnIn("login_submit"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_LoginPageErrorMsg("Incorrect Email Address or Password")),"User is Able to Signin and not receive a error message");
	}


	// <summary>
	// Test Case Title : "Verify what happens when the user kept the password field empty"
	// Automation ID : TC03_Login
	// </summary>
	public void TC03_Login() throws InterruptedException
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		//Step 1: Access to the given mail id page
		//Expected: The Login/mail id page should be displayed
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_address")),"The email id page is not displayed.");

		//Step 2:Enter a valid email address and Leave the password field blank
		//Expected: User should be able to enter username.
		base.setData(LoginPageObj.Edt_LoginEmail("email_address"),SnipBackLogin_TestData.TC03_SnipBackLoginUsername1);
		String EmailNew=base.GetValue(LoginPageObj.Edt_LoginEmail("email_address"));
		asrt.assertEquals(EmailNew,SnipBackLogin_TestData.TC03_SnipBackLoginUsername1,"The email entered does not match the testdata.");

		//Step 3: "Click on Sign In button"
		//Expected:"User Shouldn't able to login the page and should receive a error message (Password is required)"
		base.buttonClick(LoginPageObj.Btn_SingnIn("login_submit"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Password is required")),"Alert is not displayed as expected.");

	}

	// <summary>
	//Test description :Verify what happens when the user does not fill the Email Address and Password field
	//Automation Id    :TC02_Login
	// </summary>
	public void TC02_Login() throws InterruptedException
	{
		Registration_Obj RegistrationObj = new Registration_Obj();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		//Step1:Click on Login button from Homepage
		//expected:Login page should be displayed
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_address"))," The Login page is not displayed.");

		//Step2:Without filling any field, click Sign In
		//expected:User Shouldn't able to login the page and should receive an alert message.
		base.buttonClick(LoginPageObj.Btn_SingnIn("login_submit"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("errr_email")),"Alert message is not displayed in the sign in page");

	}

	// <summary>
	// Test Case Title : "Verify what happens when the user kept the email address field empty"
	// Automation ID : TC04_Login()
	// </summary>
	public void TC04_Login() throws InterruptedException {
		LoginPage_Obj loginPageObj = new LoginPage_Obj();
		SnipBackLogin_TestData SnipBackLoginTestData = new SnipBackLogin_TestData();

		// Step1:Access to the given mail id page
		// Excepected Result:Navigate To Signin Page
		base.buttonClick(loginPageObj.Btn_Login("Login"));

		// Step2:Leave the email address field empty and enter the password
		// Excepected Result:User should be able to view an Alert
		base.setData(loginPageObj.Edt_LoginCredentialFields("password"), SnipBackLoginTestData.TC04_SnipBackLoginPassword1);
		base.buttonClick(loginPageObj.Btn_SignInButton("SIGN IN"));
		asrt.assertTrue(base.isExists(loginPageObj.Edt_Alert1("Please enter your email address")),"Error- Unable to view Signin Page");
		
	}
	// <summary>
	// Test Case Title : "Verify whether the user can be able to  login " 
	// Automation ID   : TC01_Login
	// </summary>
	public void TC01_Login() throws InterruptedException 
	{
		Login login =new Login(driver); 	  
		CommonData Commondata = new CommonData();

		//Step 1: Navigate to Homepage and click login button
		//Expected: User should be navigated to login page
		login.loginToApplication(Commondata.UserName,Commondata.PassWord);

	}

	// <summary>
	// Test Case Title : "Verify what happens the user fill the email address and password field with valid data"
	// Automation ID : TC08_Login
	// </summary>

	public void TC08_Login() throws InterruptedException {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SnipBackLogin_TestData SnipBackLoginTestData = new SnipBackLogin_TestData();
		
		// Step1: User navigated to home page and click on Login button
		// Expected: User navigated to Login tab
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("SIGN IN")), "User is not navigated to Login tab");

		// Step2: Enter a valid email address in email address field
		// Expected: Entered email address should be visible in email address field
		base.setData(LoginPageObj.Edt_LoginCredentialFields("email_address"), SnipBackLoginTestData.TC08_SnipBackLoginEmailaddress);
		String EnteredEmail=base.GetValue(LoginPageObj.Edt_LoginCredentialFields("email_address"));
		asrt.assertEquals(EnteredEmail, SnipBackLoginTestData.TC08_SnipBackLoginEmailaddress,"Entered email address not visible in email address field");

		// Step3: Enter a valid password in Password field
		// Expected: Entered password should be visible in password field
		base.setData(LoginPageObj.Edt_LoginCredentialFields("password"), SnipBackLoginTestData.TC08_SnipBackLoginPassword);
		String EnteredPasword=base.GetValue(LoginPageObj.Edt_LoginCredentialFields("password"));
		asrt.assertEquals(EnteredPasword,SnipBackLoginTestData.TC08_SnipBackLoginPassword, "Entered password not visible in password field");

		// Step4: Click the Submit button
		// Expected: User should navigate to the to the film page
		base.buttonClick(LoginPageObj.Btn_SignInButton("SIGN IN"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("EVENTS")), "User not able to login to the to the film page");
	}

	// <summary>
	// Test Case Title : "Verify what happens when the user enter a invalid email address."
	// Automation ID : TC05_Login
	// </summary
	public void TC05_Login() throws InterruptedException {
		SnipBackLogin_TestData snipbacklogintestdata=new SnipBackLogin_TestData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();

		// Step 1: Navigate to the Homepage
		// Expected Result: User should be navigated to the Homepage
		base.buttonClick(LoginPageObj.Btn_Login("Login"));

		// Step 2: Enter a invalid email address
		//Expected Result:User Should be able to view a Alert Message.
		base.setData(LoginPageObj.Edt_LoginEmail("email_address"),snipbacklogintestdata.TC05_LoginInvailEmail);
		base.setData(LoginPageObj.Edt_LoginEmail("password"),snipbacklogintestdata.TC05_LoginPassword);
		base.buttonClick(LoginPageObj.Btn_SigninClick("myFunction()"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_LoginPageErrorMsg("Incorrect Email Address or Password")),"User is Able to Signin");
	}

}


