package testPage.MavenPageObject;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import objectRepository.LoginPage_Obj;
import objectRepository.SocialMediaSignIn_Obj;
import utilPack.BasePge;
public class SocialMediaSignIn extends BasePge{

	BasePge base;
	Assert asrt;

	public SocialMediaSignIn(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}


	// <summary>
	// Test Case Title :"To verify there is a option to Sign In with Google in login page."
	// Automation ID   : TC_01
	// </summary>
	public void TC_01_SocialMediaSignIn() throws InterruptedException 
	{	  
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SocialMediaSignIn_Obj SocialMediaSignInObj = new SocialMediaSignIn_Obj();

		//Step 1:Navigate to the Snipback HomePage and click on login button.
		//Expected:User should be navigated to Snipback HomePage and login tab should be visible.
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("SIGN IN")),"User unable navigated to Snipback HomePage and login tab should be visible.");

		//Step 2:Check if the "Sign In with Google" visible
		//Expected:User be  able to see "Sign In with Google" option in Login tab
		asrt.assertTrue(base.isExists(SocialMediaSignInObj.Ele_SignInWithGoogle(" Sign In with Google","btn btn-white signin-btn sm")), "User unable to see an option to Sign In with Google in login page.");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks already logged in Google account."
	// Automation ID   : TC_02
	// </summary>
	public void TC_02_SocialMediaSignIn() throws InterruptedException 
	{	  
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SocialMediaSignIn_Obj SignInObj = new SocialMediaSignIn_Obj();

		//Step 1:Navigate to the HomePage and click on login button
		//Expected:User should be navigated to HomePage
		base.buttonClick(LoginPageObj.Btn_Login("Login"));

		//Step 2:Click the Sign In With Google
		//Expected:User should be navigated to Sign In Page
		base.buttonClick(SignInObj.Btn_SignInWithGoogle("https://snipback.com/login/google"));
		//asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Access blocked: This app’s request is invalid")),"The user not able to navigate to Snipback film page.");
	}

}

