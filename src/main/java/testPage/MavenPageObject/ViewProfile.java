package testPage.MavenPageObject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestData.CommonData;
import TestData.ForgotPassword_TestData;
import TestData.SnipBackLogin_TestData;
import TestData.ViewProfile_TestData;
import objectRepository.ForgotPassword_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ViewProfile_Obj;
import utilPack.BasePge;

//import basePackage.BasePge;

public class ViewProfile extends BasePge {

	BasePge base;
	Assert asrt;

	public ViewProfile(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	public void TC01_ViewProfile() {
		LoginPage_Obj loginpage = new LoginPage_Obj();

		//step 1: Open the SnipBack application
		//expected result: The user should be able to navigates to the  Snipback website after entering the URL		
		asrt.assertTrue(base.isExists(loginpage.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate into snipback website");

	}

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

	public void TC03_ViewProfile() throws InterruptedException {
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

		// step 4: Click "View Profile" option
		// expected result: User should be able to navigates to the profile Settings page
		base.buttonClick(viewprofile.Ele_ViewProfile("dropdown-menu show", "View Profile"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("recruitBtn")),"User is unable to navigate to  profile settings page");

	}

	public void TC04_ViewProfile() throws InterruptedException {
		LoginPage_Obj loginpage = new LoginPage_Obj();
		CommonData commondata = new CommonData();
		ViewProfile_Obj viewprofile = new ViewProfile_Obj();
		ViewProfile_TestData viewprofileTestData = new ViewProfile_TestData();

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

		// step 4: Click "View Profile" option
		// expected result: User should be able to navigate to the profile Settings page
		base.buttonClick(viewprofile.Ele_ViewProfile("dropdown-menu show", "View Profile"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("recruitBtn")),"Unable to navigate into Profile settings page");

		//step 5: Verify that the Username field, Email text box, and Reset Password button are displayed on the Profile Settings page.

		//check it is displayed or not, then 

		//expected result: User should Edit the User Name Text field

		String oldusername = base.GetValue(loginpage.Edt_LoginEmail("name"));
		base.clearData(loginpage.Edt_LoginEmail("name"));
		base.setData(loginpage.Edt_LoginEmail("name"),viewprofileTestData.TC04_UserName);
		String username = base.GetValue(loginpage.Edt_LoginEmail("name"));
		asrt.assertNotEquals(username, oldusername,"Username does not match the expected value");

	}

	public void TC05_ViewProfile() throws InterruptedException {
		LoginPage_Obj loginpage = new LoginPage_Obj();
		CommonData commondata = new CommonData();
		ViewProfile_Obj viewprofile = new ViewProfile_Obj();
		ViewProfile_TestData viewprofileTestData = new ViewProfile_TestData();

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

		// step 4: Click "View Profile" option
		// expected result: User should be able to navigates to the profile Settings page
		base.buttonClick(viewprofile.Ele_ViewProfile("dropdown-menu show", "View Profile"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("recruitBtn")),"User is unable to navigate into Profile settings page");

		//step 5: Enter name in User name field
		//expected result: 'User Name' field should  accept only alphabetic letters
		base.clearData(loginpage.Edt_LoginEmail("name"));
		base.setData(loginpage.Edt_LoginEmail("name"),viewprofileTestData.TC05_Alphabets);
		base.scrollToElementtoCenter(loginpage.Btn_SingnIn("save_profile"));
		Thread.sleep(3000);
		base.buttonClick(loginpage.Btn_SingnIn("save_profile"));
		asrt.assertTrue(base.isDoesNotExistBool(viewprofile.Ele_Alert("profile_error")),"Username field incorrectly accepted alphabetic characters, which is not allowed");

		//step 6:  To recover the username
		base.setData(loginpage.Edt_LoginEmail("name"),viewprofileTestData.TC05_RecoverUserName);
	}

	public void TC06_ViewProfile() throws InterruptedException {
		LoginPage_Obj loginpage = new LoginPage_Obj();
		CommonData commondata = new CommonData();
		ViewProfile_Obj viewprofile = new ViewProfile_Obj();//		ViewProfile_TestData viewprofileTestData = new ViewProfile_TestData();

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

		// step 4: Click "View Profile" option
		// expected result: User should be able to navigates to the profile Settings page
		base.buttonClick(viewprofile.Ele_ViewProfile("dropdown-menu show", "View Profile"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("recruitBtn")),"User is unable to navigate into Profile settings page");

		//step 5: Enter No user name and Click SAVE
		//expected result: "Please enter the name"  msg should be displayed when user name field blank
		base.clearData(loginpage.Edt_LoginEmail("name"));
		base.scrollToElementtoCenter(loginpage.Btn_SingnIn("save_profile"));
		Thread.sleep(3000);
		base.buttonClick(loginpage.Btn_SingnIn("save_profile"));
		asrt.assertTrue(base.isExists(viewprofile.Ele_Alert("profile_error")),"'Please enter the name' message was not displayed when the Username field was left blank");
	}

	public void TC07_ViewProfile() throws InterruptedException {
		LoginPage_Obj loginpage = new LoginPage_Obj();
		CommonData commondata = new CommonData();
		ViewProfile_Obj viewprofile = new ViewProfile_Obj();
		ViewProfile_TestData viewprofileTestData = new ViewProfile_TestData();

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

		// step 4: Click "View Profile" option
		// expected result: User should be able to navigates to the profile Settings page
		base.buttonClick(viewprofile.Ele_ViewProfile("dropdown-menu show", "View Profile"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("recruitBtn")),"User is unable to navigate into Profile settings page");

		//step 5: Enter user name with letters or symbols and Click SAVE
		//expected result: Name must only contain letters" msg should be displayed when user name fill with letters or symbols
		base.clearData(loginpage.Edt_LoginEmail("name"));
		base.setData(loginpage.Edt_LoginEmail("name"),viewprofileTestData.TC07_LettersAndSymbols);
		base.scrollToElementtoCenter(loginpage.Btn_SingnIn("save_profile"));
		Thread.sleep(3000);
		base.buttonClick(loginpage.Btn_SingnIn("save_profile"));
		asrt.assertTrue(base.isExists(viewprofile.Ele_Alert("profile_error")),"Name must only contain letters’ message was not displayed for input containing letters and symbols in the Name field");
	}

	public void TC08_ViewProfile() throws InterruptedException {
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

		// step 4: Click "View Profile" option
		// expected result: User should be able to navigates to the profile Settings page
		base.buttonClick(viewprofile.Ele_ViewProfile("dropdown-menu show", "View Profile"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("recruitBtn")),"User is unable to navigate into Profile settings page");

		//step 5: Click Reset Password option
		//expected result: RESET PSSWORD box should display when user click the Reset Password option
		base.buttonClick(loginpage.Btn_SingnIn("reset_password"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("pswd_reset")),"Reset Password box was not displayed after clicking the Reset Password option");
	}

	public void TC09_ViewProfile() throws InterruptedException {
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

		// step 4: Click "View Profile" option
		// expected result: User should be able to navigates to the profile Settings page
		base.buttonClick(viewprofile.Ele_ViewProfile("dropdown-menu show", "View Profile"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("recruitBtn")),"View Profile page not displayed");

		//step 5: Click Reset Password option
		//expected result: RESET PASSWORD box should have following field -Password -Confirm Password -CANCEL Button -RESET Button
		base.buttonClick(loginpage.Btn_SingnIn("reset_password"));
		asrt.assertTrue(base.isExists(loginpage.Edt_LoginEmail("pswd")),"Password' field is missing in the Reset Password box");
		asrt.assertTrue(base.isExists(loginpage.Edt_LoginEmail("cn_password")),"Confirm Password' field is missing in the Reset Password box");
		asrt.assertTrue(base.isExists(viewprofile.Btn_ViewProfile("buttonsGroup","btn btn-cancel")),"'CANCEL' button is not displayed in the Reset Password box");
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("pswd_reset")),"'RESET' button is not displayed in the Reset Password box");
	}

	public void TC10_ViewProfile() throws InterruptedException {
		LoginPage_Obj loginpage = new LoginPage_Obj();
		CommonData commondata = new CommonData();
		ViewProfile_Obj viewprofile = new ViewProfile_Obj();
		ViewProfile_TestData viewprofileTestData = new ViewProfile_TestData();
		Registration_Obj registration = new Registration_Obj();

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

		// step 4: Click "View Profile" option
		// expected result: User should be able to navigates to the profile Settings page
		base.buttonClick(viewprofile.Ele_ViewProfile("dropdown-menu show", "View Profile"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("recruitBtn")),"User is unable to navigate into Profile setting page");

		//step 5: Click Reset Password option and Enter Password
		//expected result: Password field should accept a combination of uppercase letters, lowercase letters, special characters (@ $ * !), and must be at least 7 characters long
		base.buttonClick(loginpage.Btn_SingnIn("reset_password"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("pswd_reset")),"Reset Password box was not displayed after clicking the Reset Password option");
		base.setData(loginpage.Edt_LoginEmail("pswd"),viewprofileTestData.TC10_Password);
		String password = base.GetText(loginpage.Edt_LoginEmail("pswd"));
		asrt.assertFalse(
				base.isExistsNegative(registration.Ele_ErrorMessage("invalid-pswd", "missing lowercase letters")) || 
				base.isExistsNegative(registration.Ele_ErrorMessage("invalid-pswd", "missing uppercase letters")) ||
				base.isExistsNegative(registration.Ele_ErrorMessage("invalid-pswd", "missing special characters (@ $ * !)")) || 
				base.isExistsNegative(registration.Ele_ErrorMessage("invalid-pswd", "missing minimum length 7")) ||
				base.isExistsNegative(registration.Ele_ErrorMessage("invalid-pswd", "missing numeric digits")),
				"Password field failed to accept a valid combination of lowercase, uppercase, special characters (@ $ * !), and minimum length of 7"
				);
	}

	public void TC11_ViewProfile() throws InterruptedException {
		LoginPage_Obj loginpage = new LoginPage_Obj();
		CommonData commondata = new CommonData();
		ViewProfile_Obj viewprofile = new ViewProfile_Obj();
		ViewProfile_TestData viewprofileTestData = new ViewProfile_TestData();
		Registration_Obj registration = new Registration_Obj();

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

		// step 4: Click "View Profile" option
		// expected result: User should be able to navigates to the profile Settings page
		base.buttonClick(viewprofile.Ele_ViewProfile("dropdown-menu show", "View Profile"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("recruitBtn")),"User is unable to navigate into Profile setting page");

		//step 5: Click Reset Password option and Enter Password
		//expected result: A message should come if user will left any character in password field
		base.buttonClick(loginpage.Btn_SingnIn("reset_password"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("pswd_reset")),"Reset Password box was not displayed after clicking the Reset Password option");
		base.setData(loginpage.Edt_LoginEmail("pswd"),viewprofileTestData.TC11_InvalidPassword);
		String password = base.GetText(loginpage.Edt_LoginEmail("pswd"));
		asrt.assertTrue(base.isExists(registration.Ele_ErrorMessage("invalid-pswd", "missing special characters (@ $ * !)")),"Password contains all required character types");
	}

	public void TC12_ViewProfile() throws InterruptedException {
		LoginPage_Obj loginpage = new LoginPage_Obj();
		CommonData commondata = new CommonData();
		ViewProfile_Obj viewprofile = new ViewProfile_Obj();
		ViewProfile_TestData viewprofileTestData = new ViewProfile_TestData();
		Registration_Obj registration = new Registration_Obj();

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

		// step 4: Click "View Profile" option
		// expected result: User should be able to navigates to the profile Settings page
		base.buttonClick(viewprofile.Ele_ViewProfile("dropdown-menu show", "View Profile"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("recruitBtn")),"User is unable to navigate into Profile setting page");

		//step 5: Click Reset Password option and Enter Password
		//expected result: A message "Passwords are not same" should come, if the given Password and Confirm Password are different
		base.buttonClick(loginpage.Btn_SingnIn("reset_password"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("pswd_reset")),"Reset Password box was not displayed after clicking the Reset Password option");
		base.setData(loginpage.Edt_LoginEmail("pswd"),viewprofileTestData.TC12_Password);
		base.setData(loginpage.Edt_LoginEmail("cn_password"),viewprofileTestData.TC12_ConfirmPassword);
		base.buttonClick(loginpage.Btn_SingnIn("pswd_reset"));
		asrt.assertTrue(base.isExists(registration.Ele_Emailerror("er_cn_psw")),"A message 'Passwords are not same' should come, if the given Password and Confirm Password are different");
	}
	
	public void TC13_ViewProfile() throws InterruptedException {
		LoginPage_Obj loginpage = new LoginPage_Obj();
		CommonData commondata = new CommonData();
		ViewProfile_Obj viewprofile = new ViewProfile_Obj();
		ViewProfile_TestData viewprofileTestData = new ViewProfile_TestData();
		Registration_Obj registration = new Registration_Obj();

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

		// step 4: Click "View Profile" option
		// expected result: User should be able to navigates to the profile Settings page
		base.buttonClick(viewprofile.Ele_ViewProfile("dropdown-menu show", "View Profile"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("recruitBtn")),"User is unable to navigate into Profile setting page");

		//step 5: Click Reset Password option and Enter Password
		//expected result: A message "Passwords are not same" should come, if the given Password and Confirm Password are different
		base.buttonClick(loginpage.Btn_SingnIn("reset_password"));
		asrt.assertTrue(base.isExists(loginpage.Btn_SingnIn("pswd_reset")),"Reset Password box was not displayed after clicking the Reset Password option");
		base.setData(loginpage.Edt_LoginEmail("pswd"),viewprofileTestData.TC12_Password);
		base.setData(loginpage.Edt_LoginEmail("cn_password"),viewprofileTestData.TC12_ConfirmPassword);
		base.buttonClick(loginpage.Btn_SingnIn("pswd_reset"));
		asrt.assertTrue(base.isExists(registration.Ele_Emailerror("er_cn_psw")),"A message 'Passwords are not same' should come, if the given Password and Confirm Password are different");
	}
}


