package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.ForgotPassword_TestData;
import objectRepository.ForgotPassword_Obj;
import objectRepository.LoginPage_Obj;
import utilPack.BasePge;

public class ForgotPassword extends BasePge {
	BasePge base;
	Assert asrt;

	public ForgotPassword(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	
	//<summery>
	//Test Case Title : Verify that the user can navigate to the "Forgot Password" icon from the login page.
	//Automation ID : FP - 1
	//</summery>
	public void FP_1_ForgotPassword() {		
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ForgotPassword_Obj ForgotPasswordObj =new ForgotPassword_Obj();
		
		//Step 1 : Navigate to Home page
		//Expected : Home page should be displayed
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("login_submit")),"Home Page is not displayed.");
		
		//Step 2 : On the login screen, click the "Forgot Password" icon
	    //Expected : The system navigates to the "Forgot Password" page
		base.buttonClick(LoginPageObj.Btn_LoginButton("forget-password"));
		asrt.assertTrue(base.isExists(ForgotPasswordObj.Ele_ResetPasswordHeading("Reset Password")),"The system is not navigated to the Forgot Password page");
	}
  
  //<summery>
	//Test Case Title : Ensure that the user is required to enter a valid email address in the "Forgot Password" field.
	//Automation ID : FP - 2
	//</summery>
	public void FP_2_ForgotPassword() {	
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ForgotPassword_Obj ForgotPasswordObj =new ForgotPassword_Obj();
		ForgotPassword_TestData ForgotPasswordTestData =new ForgotPassword_TestData();
		
		//Step 1 : Navigate to Home page
		//Expected : Home page should be displayed
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("login_submit")),"Home Page is not displayed.");
		
		//Step 2 : On the login screen, click the "Forgot Password" icon
	    //Expected : The system navigates to the "Forgot Password" page
		base.buttonClick(LoginPageObj.Btn_LoginButton("forget-password"));
		asrt.assertTrue(base.isExists(ForgotPasswordObj.Ele_ResetPasswordHeading("Reset Password")),"The system is not navigated to the Forgot Password page");
		
		//Step 3 : Enter an invalid email id
		//Expected : User should be able to enter invalid email id
		base.setData(LoginPageObj.Edt_LoginEmail("forgot-email"), ForgotPasswordTestData.FP_2_ForgotPasswordInvalidEmail);
		String InvalidEmail = base.GetValue(LoginPageObj.Edt_LoginEmail("forgot-email"));
		asrt.assertEquals(InvalidEmail, ForgotPasswordTestData.FP_2_ForgotPasswordInvalidEmail);
		
		//Step 4 : Click submit button after entering an invalid email id
		//Expected : An error message like "Please enter the valid email, the invalid characters are &/\#,+()$~%.^':*?<>{}"Please enter a valid email address" should be displayed, and the user is not allowed to proceed.
		base.buttonClick(LoginPageObj.Btn_SingnIn("forgot-submit"));
		asrt.assertTrue(base.isExists(ForgotPasswordObj.Ele_Error("commonValidateErr active")),"An error message like 'Please enter the valid email, the invalid characters are &/\\#,+()$~%.^':*?<>{}.Please enter a valid email address'is not displayed");		
	}

	//<summery>
	//Test Case Title : Verify that entering a valid registered email sends a password reset link.
	//Automation ID : FP - 3
	//</summery>
	public void FP_3_ForgotPassword() {		
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ForgotPassword_Obj ForgotPasswordObj =new ForgotPassword_Obj();
		ForgotPassword_TestData ForgotPasswordTestData =new ForgotPassword_TestData();
		
		//Step 1 : Navigate to Home page
		//Expected : Home page should be displayed
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("login_submit")),"Home Page is not displayed.");
		
		//Step 2 : On the login screen, click the "Forgot Password" icon
	    //Expected : The system navigates to the "Forgot Password" page
		base.buttonClick(LoginPageObj.Btn_LoginButton("forget-password"));
		asrt.assertTrue(base.isExists(ForgotPasswordObj.Ele_ResetPasswordHeading("Reset Password")),"The system is not navigated to the Forgot Password page");  
		
		//Step 3 : Enter an valid registered email id
		//Expected : User should be able to enter valid registered email id
		base.setData(LoginPageObj.Edt_LoginEmail("forgot-email"), ForgotPasswordTestData.FP_3_ForgotPasswordEmail);
		String ValidRegEmail = base.GetValue(LoginPageObj.Edt_LoginEmail("forgot-email"));
		asrt.assertEquals(ValidRegEmail, ForgotPasswordTestData.FP_3_ForgotPasswordEmail);
		
		//Step 4 : Click submit button after entering a valid registered email id
		//Expected : A success message is displayed ("A one-time passcode has been sent to your registered email address. Please check your inbox."), and the user receives the email.
		base.buttonClick(LoginPageObj.Btn_SingnIn("forgot-submit"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Reset password link sucessfully sent to your Email")),"A success message is not displayed (\"A one-time passcode has been sent to your registered email address. Please check your inbox.\"), and the user do not receives the email.");		
	}
  

}
