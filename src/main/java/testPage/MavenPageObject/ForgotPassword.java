package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestData.CommonData;
import TestData.ForgotPassword_TestData;
import TestData.ForgotPassword_TestData;
import TestData.SnipBackLogin_TestData;
import objectRepository.ForgotPassword_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import utilPack.BasePge;

//import basePackage.BasePge;

public class ForgotPassword extends BasePge {

	BasePge base;
	Assert asrt;

	public ForgotPassword(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	public void TC01_ForgotPassword() {
		LoginPage_Obj loginpage = new LoginPage_Obj();
		ForgotPassword_Obj forgotpassword = new ForgotPassword_Obj();

		//step 1: Open the SnipBack application
		//expected result: Snipback home page is displayed
		asrt.assertTrue(base.isExists(loginpage.Ele_SnipBackHomePageLogo("light-logo")),"User is unable to navigate to snipback application");

		//step 2: On the login screen, click the "Forgot Password" icon.
		//expected result: The system should navigate to the "Forgot Password" page.
		base.buttonClick(loginpage.Btn_LoginButton("nav-link btn btn-white sm"));
		base.buttonClick(loginpage.Btn_LoginButton("forget-password"));
		asrt.assertTrue(base.isExists(forgotpassword.Ele_ResetPassword("Reset Password")),"Unable to navigate to Forgot Password page");

	}

	public void TC02_ForgotPassword() throws InterruptedException {
		LoginPage_Obj loginpage = new LoginPage_Obj();
		ForgotPassword_Obj forgotpassword = new ForgotPassword_Obj();
		ForgotPassword_TestData forgotpasswordTestData = new ForgotPassword_TestData();
		Registration_Obj registration = new Registration_Obj();

		//step 1: Open the SnipBack application
		//expected result: Snipback home page is displayed
		asrt.assertTrue(base.isExists(loginpage.Ele_SnipBackHomePageLogo("light-logo")),"User is unable to navigate to snipback application");

		//step 2: On the login screen, click the "Forgot Password" icon.
		//expected result: The system should navigate to the "Forgot Password" page.
		base.buttonClick(loginpage.Btn_LoginButton("nav-link btn btn-white sm"));
		base.buttonClick(loginpage.Btn_LoginButton("forget-password"));
		asrt.assertTrue(base.isExists(forgotpassword.Ele_ResetPassword("Reset Password")),"Unable to navigate to Forgot Password page");

		//step 3: Enter an invalid email format  (e.g., "rahul123gmail.com, rahul123@gma.com, rahul123@gmailcom...")
		//expected result: An error message like "Please enter the valid email, the invalid characters are &/\#,+()$~%.^':*?<>{}" Please enter a valid email address" should be displayed, and the user is not allowed to proceed.
		base.setData(loginpage.Edt_LoginEmail("forgot-email"),forgotpasswordTestData.TC02_InvalidEmailId);
		base.buttonClick(loginpage.Btn_SingnIn("forgot-submit"));
		base.buttonClick(loginpage.Btn_SingnIn("forgot-submit"));
		asrt.assertTrue(base.isExists(registration.Ele_Emailerror("forgot-err-email")),"Invalid characters are &/\\#,+()$~%.^':*?<>{} error is not displayed");		
		asrt.assertTrue(base.isExists(forgotpassword.Ele_ValidationError("commonValidateErr active")),"'Please enter a valid email address' error is not displayed");

	}

	public void TC04_ForgotPassword() {

		LoginPage_Obj loginpage = new LoginPage_Obj();
		ForgotPassword_Obj forgotpassword = new ForgotPassword_Obj();
		ForgotPassword_TestData forgotpasswordTestData = new ForgotPassword_TestData();
		Registration_Obj registration = new Registration_Obj();

		//step 1: Open the SnipBack application
		//expected result: Snipback home page is displayed		
		asrt.assertTrue(base.isExists(loginpage.Ele_SnipBackHomePageLogo("light-logo")),"User is unable to navigate to snipback application");

		//step 2: On the login screen, click the "Forgot Password" icon.
		//expected result: The system should navigate to the "Forgot Password" page.
		base.buttonClick(loginpage.Btn_LoginButton("nav-link btn btn-white sm"));
		base.buttonClick(loginpage.Btn_LoginButton("forget-password"));
		asrt.assertTrue(base.isExists(forgotpassword.Ele_ResetPassword("Reset Password")),"Unable to navigate to Forgot Password page");

		//step 3: Enter an unregistered email address
		//expected result: User should be able to enter the invalid email id
		base.setData(loginpage.Edt_LoginEmail("forgot-email"),forgotpasswordTestData.TC04_UnregisteredEmailId);
		String unregisteredemailid = base.GetValue(loginpage.Edt_LoginEmail("forgot-email"));
		asrt.assertEquals(unregisteredemailid, forgotpasswordTestData.TC04_UnregisteredEmailId,"Email ID does not match expected value");
		System.out.println("STRING: "+unregisteredemailid);
		
		//step 4: Click Submit using an invalid or unregistered email address
		//expected result: Display an error like "Incorrect Email Address"
		base.buttonClick(loginpage.Btn_SingnIn("forgot-submit"));
		asrt.assertTrue(base.isExists(registration.Ele_Emailerror("forgot-result")),"User is unable to view 'Incorrect Email Address' message");		
		
	}
}
