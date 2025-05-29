package testPage.MavenPageObject;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import TestData.CommonData;
import objectRepository.LoginPage_Obj;
import objectRepository.ViewProfile_Obj;
import utilPack.BasePge;

public class ViewProfile extends BasePge {

	BasePge base;
	Assert asrt;

	public ViewProfile(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}	
	/*<summary>*/
	/*Title: Verify that the user should be able to navigates to the  Snipback website after entering the URL*/
	/*Automation Id: View Pro_1*/
	/*</summary>*/
	public void TC01_ViewProfile() {
		LoginPage_Obj loginpage = new LoginPage_Obj();

		//step 1: Open the SnipBack application
		//expected result: The user should be able to navigates to the  Snipback website after entering the URL		
		asrt.assertTrue(base.isExists(loginpage.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate into snipback website");
	}
	/*<summary>*/
	/*Title: Verify that the "View profile" option is listing when we click the downarrow button on right side of profile Picture*/
	/*Automation Id: View Pro_2*/
	/*</summary>*/
	public void TC02_ViewProfile() throws InterruptedException {
		LoginPage_Obj loginpage = new LoginPage_Obj();
		CommonData commondata = new CommonData();
		ViewProfile_Obj viewprofile = new ViewProfile_Obj();

		//step 1: Open the SnipBack application
		//expected result: The user should be able to navigates to the  Snipback website after entering the URL		
		asrt.assertTrue(base.isExists(loginpage.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate into snipback website");

		//step 2: Enter a valid email and password, then click Sign In
		//expected result: The user should be successfully logged in
		base.buttonClick(loginpage.Btn_Login("Login"));
		base.setData(loginpage.Edt_LoginCredentialFields("email_address"), commondata.UserName);		    
		base.setData(loginpage.Edt_LoginCredentialFields("password"),commondata.PassWord);
		base.buttonClick(loginpage.Btn_SignInButton("SIGN IN"));		
		asrt.assertTrue(base.isExists(loginpage.Edt_LoginEmail("search")),"User is unable to login successfully");

		//step 3: Click the Downarrow button on right side of profile picture
		//expected result: User should be able to see the "View Profile" option on the top list
		base.excuteJsClick(viewprofile.Ddl_Profile("buttons profileSec","btn dropdown-toggle"));
		asrt.assertTrue(base.isExists(viewprofile.Ele_ViewProfile("dropdown-menu show", "View Profile")),"User is unable to view View Profile option");
	}
}
