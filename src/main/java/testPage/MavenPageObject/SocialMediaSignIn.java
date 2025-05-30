package testPage.MavenPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
import TestData.SnipBackLogin_TestData;
import objectRepository.LoginPage_Obj;
import objectRepository.SocialMediaSignIn_Obj;
import utilPack.BasePge;

public class SocialMediaSignIn extends BasePge 
{
	BasePge base;
	Assert asrt;

	public SocialMediaSignIn(WebDriver driver) 
	{
		super(driver);
		base = new BasePge(driver);
	}

	//<summary>
	// Test Case Title :"To verify there is a option to Sign In with Google in login page."
	// Automation ID   : TC_01
	// </summary>

	public void TC01_SocialMediaSignIn() throws InterruptedException  
	{
		LoginPage_Obj login = new LoginPage_Obj();
		SocialMediaSignIn_Obj socialmediasigninObj = new SocialMediaSignIn_Obj();

		//Step 1:Go to Snipback website
		// Expected:The User must able to view the snipback Home page.
		asrt.assertTrue(base.isExists(login.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to view the Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The user must be able to click the Login button and view the SignIn google option in login page.
		base.buttonClick(login.Btn_LoginButton("nav-link btn btn-white sm"));
		asrt.assertTrue(base.isExists(socialmediasigninObj.Btn_SignInOption("icon icon-google-black sm")), "User is unable to click the login button and unable to view the Signin google option.");
	}
}