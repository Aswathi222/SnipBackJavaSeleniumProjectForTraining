package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestData.CommonData;
import TestData.SnipBackLogin_TestData;
import objectRepository.ForgotPassword_Obj;
import objectRepository.LoginPage_Obj;
import utilPack.BasePge;

//import basePackage.BasePge;

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
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("login_submit")));
		
		//Step 2 : On the login screen, click the "Forgot Password" icon
	    //Expected : The system navigates to the "Forgot Password" page
		base.buttonClick(LoginPageObj.Btn_LoginButton("forget-password"));
		asrt.assertTrue(base.isExists(ForgotPasswordObj.Ele_ResetPasswordHeading("Reset Password")));
	}
	
	
	
	
	

}
