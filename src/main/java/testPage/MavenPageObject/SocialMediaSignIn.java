package testPage.MavenPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
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
	//Test Case Title:"To verify there is a option to 'Sign In with Google' in login page."
	//Automation ID: TC_01
	//</summary>
	public void TC_01SocialMediaSignIn() throws InterruptedException{
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		SocialMediaSignIn_obj SocialMediaSignInObj=new SocialMediaSignIn_obj();
		Registration_Obj registrationObj=new Registration_Obj();
		
		//step 1  : Navigate to Snipback Website
		//Expected: There should be a option to view 'Sign In with Google' in login page
		base.excuteJsClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(registrationObj.Btn_Login("btn btn-white signin-btn sm", " Sign In with Google")),"User is unable to view the Sign in with google button in the login page");	
	}
	
	//<summary>
	//Test Case Title:"To verify what happens when user clicks already logged in Google account."
	//Automation ID: TC_02
	//</summary>
	public void TC_02SocialMediaSignIn() throws InterruptedException{
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		SocialMediaSignIn_obj SocialMediaSignInObj=new SocialMediaSignIn_obj();
		Registration_Obj registrationObj=new Registration_Obj();
		
		//step 1:Navigate to Snipback Website
		//Expected: There should be an option to view 'Sign In with Google' in login page.
		base.excuteJsClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(registrationObj.Btn_Login("btn btn-white signin-btn sm", " Sign In with Google")),"User is unable to view the Sign in with google button in the login page");	
		
		//step 2: User should able to click Sign In with Google
		//Expected: The user should navigate to Snipback film page.
		String title1=driver.getCurrentUrl();
		base.buttonClick(registrationObj.Btn_Login("btn btn-white signin-btn sm", " Sign In with Google"));
		String title2=driver.getCurrentUrl();
		asrt.assertNotEquals(title1, title2,"The user is unable to navigate to Snipback film page. ");
	}
}
