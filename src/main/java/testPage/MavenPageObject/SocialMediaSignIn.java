package testPage.MavenPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import objectRepository.LoginPage_Obj;
import objectRepository.SocialMediaSignIn_obj;
import utilPack.BasePge;

public class SocialMediaSignIn extends BasePge{
	BasePge base;
	Assert asrt;

	public SocialMediaSignIn(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	//<summary>
	//Test Case Title:"To verify there is a option to Sign In with Google in login page."
	//Automation ID: TC_01
	//</summary>
	
	public void TC_01SocialMediaSignIn() throws InterruptedException{
		
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		SocialMediaSignIn_obj SocialMediaSignInObj=new SocialMediaSignIn_obj();
		
		//step 1  : Navigate to Snipback Website
		//Expected: User should be able to navigate to Snipback website
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User unable to Login");
		
	}
	//<summary>
	//Test Case Title:"To verify what happens when user clicks already logged in Google account."
	//Automation ID: TC_02
	//</summary>
	
	public void TC_02SocialMediaSignIn() throws InterruptedException{
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		SocialMediaSignIn_obj SocialMediaSignInObj=new SocialMediaSignIn_obj();
		
		//step 1:Navigate to Snipback Website
		//Expected: User should be able to navigate to Snipback website
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User unable to Login");
		
		//step 2: Click Sign In with Google
		//Expected: User able to click Sign in with Google button.
		base.buttonClick(SocialMediaSignInObj.Btn_SignInWithGoogle(" Sign In with Google"));
		//asrt.assertTrue(base.isExists(SocialMediaSignInObj.Btn_SignInWithGoogle(" Sign In with Google")), "User unable to Sign in with Google");
		//Thread.sleep(2500);
	}
}
