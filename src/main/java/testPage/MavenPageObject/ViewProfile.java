package testPage.MavenPageObject;
import TestData.ForgotPassword_TestData;
import TestData.ViewProfile_TestData;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
import TestData.ForgotPassword_TestData;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ViewProfile_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;
public class ViewProfile extends BasePge{

	BasePge base;
	Assert asrt;

	public ViewProfile(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
 
	// <summary>
	// Test Case Title : "Verify that the user should be able to navigates to the Snipback website after entering the URL" 
	// Automation ID : ViewPro_1
	// </summary>
	public void ViewPro_1_ViewProfile()  throws InterruptedException 
	{ 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		//step 1:"Navigate to the snipback page"
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");
	}

	// <summary>
	// Test Case Title : "Verify that the "View profile" option is listing when we click the downarrow button on right side of profile Picture" 
	// Automation ID : ViewPro_2
	// </summary>	
	public void ViewPro_2_ViewProfile() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj poolObj = new Pool_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User unable to click Down Arrow button on right side of profile picture in Snipback page");

		// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");
	}

	
	// <summary>
	// Test Case Title : "Verify whether the user is able to click "View Profile" option on the right side of the profile picture and navigate to the Profile setting page in Snipback" 
	// Automation ID : ViewPro_3
	// </summary>	
	public void ViewPro_3_ViewProfile() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj poolObj = new Pool_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

		// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");

		// step 5:"User is able to click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		//expected:"User should be able click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("row profileWrapper")), "User is unable to view the 'View Profile' page.");
	}

	///<summary>
	// Test Case Title : "Verify Username, Email Text Box and Reset Password Button will be displayed in Profile Settings page" 
	// Automation ID : ViewPro_4
	// </summary>	
	public void ViewPro_4_ViewProfile() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj poolObj = new Pool_Obj();


		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

		// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");

		// step 5:"User is able to click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		//expected:"User should be able click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("row profileWrapper")), "User is unable to view the 'View Profile' page.");

		// step 6:"User is able to view the UserName, Email textfields and Reset Password button in Profile Setting page in Snipback"
		//expected:"User should be able view the UserName, Email textfields and Reset Password button in Profile Setting page in Snipback"
		asrt.assertTrue(base.isExists(ViewProfileObj.Edt_ViewProfiletextfield("form-group","name")), "User is unable to view the UserName textfield in the Profile setting page in Snipback");
		asrt.assertTrue(base.isExists(ViewProfileObj.Edt_ViewProfiletextfield("form-group","email")), "User is unable to view the Email textfield in the Profile setting page in Snipback");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Reset Password")), "User is unable to view the Reset Password Button in Snipback");
	}


	// <summary>
	// Test Case Title : "Verify that the 'User Name' field should accept only alphabetic letters" 
	// Automation ID : ViewPro_5
	// </summary>	
	public void ViewPro_5_ViewProfile() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewProfile_TestData viewProfiletestdata = new ViewProfile_TestData();
		Pool_Obj poolObj = new Pool_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

		// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");

		// step 5:"User is able to click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		//expected:"User should be able click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("row profileWrapper")), "User is unable to view the 'View Profile' page.");

		// step 6:"User is able to click the Username text field  and enter the Username in Profile Setting page of Snipback"
		//expected:"User should be able click the Username text field  and enter the Username in Profile Setting page of Snipback"
		base.buttonClick(ViewProfileObj.Edt_ViewProfiletextfield("form-group","name"));
		base.setData(ViewProfileObj.Edt_ViewProfiletextfield("form-group","name"),viewProfiletestdata.ViewPro_05_ViewProfileUserName);
		asrt.assertTrue(base.isExists(ViewProfileObj.Edt_ViewProfiletextfield("form-group","name")), "User is unable to enter the UserName in UserName textfield in the Profile setting page of Snipback");	

	}

	// <summary>
	// Test Case Title : "Verify that message should be displayed when user name field left blank" 
	// Automation ID : ViewPro_6
	// </summary>

	public void ViewPro_6_ViewProfile() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewProfile_TestData viewProfiletestdata = new ViewProfile_TestData();
		Pool_Obj poolObj = new Pool_Obj();


		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

		// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");

		// step 5:"User is able to click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		//expected:"User should be able click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("row profileWrapper")), "User is unable to view the 'View Profile' page.");

		// step 6:"User is unable to click the Save button without entering the UserName in UserName textfield and display error message as "Please enter the name" in Profile Setting page of Snipback"
		//expected:"User not should be able click the Save button without entering the UserName text field and should display error message as "Please enter the name" in Profile Setting page of Snipback"
		base.buttonClick(ViewProfileObj.Edt_ViewProfiletextfield("form-group","name"));
		base.setData(ViewProfileObj.Edt_ViewProfiletextfield("form-group","name"),viewProfiletestdata.ViewPro_06_ViewProfileBlankrName);
		base.scrollToElement(LoginPageObj.Btn_SingnIn("save_profile"));
		Thread.sleep(1000);
		base.buttonClick(LoginPageObj.Btn_SingnIn("save_profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("save_profile")), "User unable to click save button in Profile setting page of Snipback");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Please enter the name")), "User is unable to view the error message as Please enter the name in Profile setting page of Snipback ");
	}
	
	    // <summary>
		// Test Case Title : "Verify whether the user is able to see the message "Name must only contain " when enter the Username with numbers & symbols in USerName textfield and click on save button in profile picture page of Snipback" 
		// Automation ID : ViewPro_7
		// </summary>

		public void ViewPro_7_ViewProfile() throws InterruptedException 
		{ 
			Login login = new Login(driver);
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
			CommonData commondata = new CommonData();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			ViewProfile_TestData viewProfiletestdata = new ViewProfile_TestData();
			Pool_Obj poolObj = new Pool_Obj();


			// step 1:"Navigate to the snipback page "
			//expected:"User should able to view the Snipback page"
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

			// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
			//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
			login.loginToApplication(commondata.UserName, commondata.PassWord);

			// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
			//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
			base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
			asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

			// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
			//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
			asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");

			// step 5:"User is able to click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
			//expected:"User should be able click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
			base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
			asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("row profileWrapper")), "User is unable to view the 'View Profile' page.");

			// step 6:"User is able to view the error message as "Name must only contain letters" when entering the UserName with numbers & symbols in UserName textfield and click on save button in Profile Setting page of Snipback"
			//expected:"User should be able to view the error message as "Name must only contain letters" when entering the UserName with numbers & symbols in UserName textfield and click on save button in Profile Setting page of Snipback"
			base.buttonClick(ViewProfileObj.Edt_ViewProfiletextfield("form-group","name"));
			base.setData(ViewProfileObj.Edt_ViewProfiletextfield("form-group","name"),viewProfiletestdata.ViewPro_07_ViewProfileUserName);
			base.scrollToElement(LoginPageObj.Btn_SingnIn("save_profile"));
			Thread.sleep(1000);
			base.buttonClick(LoginPageObj.Btn_SingnIn("save_profile"));
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("save_profile")), "User unable to click save button in Profile setting page of Snipback");
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Name must only contain letters")), "User is unable to view the error message as Name must only contain letters in Profile setting page of Snipback ");

		}

	    // <summary>
		// Test Case Title : "Verify that RESET PSSWORD box will display when user click the Reset Password option"
		// Automation ID : ViewPro_8
		// </summary>
		public void ViewPro_8_ViewProfile() throws InterruptedException
		{
			Login login =new Login(driver); 	  
			CommonData CommonData = new CommonData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			Pool_Obj poolObj = new Pool_Obj();

			//Step 1:"Navigate to the Snipback page "
			//Expected:"User should able to view the Snipback page"
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

			//Step 2:Navigate to Homepage and click login button
			//Expected: User should be navigated to login page
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);

			// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
			//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
			base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
			asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

			// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
			//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
			asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");

			// step 5:"User is able to click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
			//expected:"User should be able click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
			base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
			asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("row profileWrapper")), "User is unable to view the 'View Profile' page.");

			//Step 6:Click the 'Reset Password' Button
			//Expected:RESET PASSWORD box should display when user click the Reset Password option
			//Thread.sleep(7000);
			base.excuteJsClick(LoginPageObj.Btn_SignInButton("Reset Password"));
			asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("RESET PASSWORD")),"The Reset Password Heading isn't visible to the user");
		}

	// <summary>
	// Test Case Title : "Verify that RESET PASSWORD box contains following field 
	//1.)Password 
	//2.)Confirm Password
	//3.)CANCEL Button
	//4.)RESET Button" 
	// Automation ID : ViewPro_9
	// </summary>
	public void ViewPro_9_ViewProfile() throws InterruptedException
	{
		Login login =new Login(driver); 	  
		CommonData CommonData = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj poolObj = new Pool_Obj();

		//Step 1:"Navigate to the Snipback page "
		//Expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2:Navigate to Homepage and click login button
		//Expected: User should be navigated to login page
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

		// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");

		// step 5:"User is able to click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		//expected:"User should be able click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("row profileWrapper")), "User is unable to view the 'View Profile' page.");

		//Step 6:Click the 'Reset Password' Button
		//Expected:RESET PASSWORD box should have following field 
		//1.)Password 
		//2.)Confirm Password
		//3.)CANCEL Button
		//4.)RESET Button
		//Thread.sleep(7000);
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Reset Password"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("RESET PASSWORD")),"The Reset Password Heading isn't visible to the user in the profile page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("pswd")),"The Password Field isn't visible to the user in the profile page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("cn_password")),"The Confirm Password Field isn't visible to the user in the profile page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("RESET")),"The RESET Button isn't visible to the user in the profile page");
		asrt.assertTrue(base.isExists(ViewProfileObj.Btn_CanBtn("CANCEL","buttonsGroup")),"The Cancel Button isn't visible to the user in the profile page");

	}
	// <summary>
	// Test Case Title : "Verify that the Password text field will accept combination of 
	//1.-lowercase letters
	//2.-uppercase letters
	//3-Special characters (@ $ * !)
	//4-minimum length 7" 
	// Automation ID : ViewPro_10
	// </summary>	
	public void ViewPro_10_ViewProfile() throws InterruptedException
	{
		Login login =new Login(driver); 	  
		CommonData CommonData = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewProfile_TestData ViewProfileTestData = new ViewProfile_TestData();
		Pool_Obj poolObj = new Pool_Obj();


		//Step 1:"Navigate to the Snipback page "
		//Expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2:Navigate to Homepage and click login button
		//Expected: User should be navigated to login page
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

		// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");

		// step 5:"User is able to click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		//expected:"User should be able click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("row profileWrapper")), "User is unable to view the 'View Profile' page.");

		//Step 6:Click the 'Reset Password' Button
		//Expected:RESET PASSWORD box should have following field 
		//1.)Password 
		//2.)Confirm Password
		//3.)CANCEL Button
		//4.)RESET Button
		//Thread.sleep(7000);
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Reset Password"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("RESET PASSWORD")),"The Reset Password Heading isn't visible to the user in the profile page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("pswd")),"The Password Field isn't visible to the user in the profile page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("cn_password")),"The Confirm Password Field isn't visible to the user in the profile page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("RESET")),"The RESET Button isn't visible to the user in the profile page");
		asrt.assertTrue(base.isExists(ViewProfileObj.Btn_CanBtn("CANCEL","buttonsGroup")),"The Cancel Button isn't visible to the user in the profile page");

		//Step 7:Enter Password
		//Expected:Password text field should accept combination of lowercase letters,uppercase letters,Special characters (@ $ * !)and minimum length 7 
		base.setData(LoginPageObj.Edt_LoginEmail("pswd"),ViewProfileTestData.ViewPro_10_ViewProfilePassword);
		String ActualPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("pswd"));
		asrt.assertEquals(ActualPassword,ViewProfileTestData.ViewPro_10_ViewProfilePassword,"Password text field not accept combination of lowercase letters,uppercase letters,Special characters (@ $ * !)and minimum length 7");

	}
	// <summary>
	// Test Case Title : "Verify that a message will come, if user left anycharacter in password field" 
	// Automation ID : ViewPro_11
	// </summary>	
	public void ViewPro_11_ViewProfile() throws InterruptedException
	{
		Login login =new Login(driver); 	  
		CommonData CommonData = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewProfile_TestData ViewProfileTestData = new ViewProfile_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();

		//Step 1:"Navigate to the Snipback page "
		//Expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2:Navigate to Homepage and click login button
		//Expected: User should be navigated to login page
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

		// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");

		// step 5:"User is able to click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		//expected:"User should be able click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("row profileWrapper")), "User is unable to view the 'View Profile' page.");

		//Step 6:Click the 'Reset Password' Button
		//Expected:RESET PASSWORD box should have following field 
		//1.)Password 
		//2.)Confirm Password
		//3.)CANCEL Button
		//4.)RESET Button
		//Thread.sleep(7000);
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Reset Password"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("RESET PASSWORD")),"The Reset Password Heading isn't visible to the user in the View profile Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("pswd")),"The Password Field isn't visible to the user in the View profile Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("cn_password")),"The Confirm Password Field isn't visible to the user in the View profile Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("RESET")),"The RESET Button isn't visible to the user in the View profile Page");
		asrt.assertTrue(base.isExists(ViewProfileObj.Btn_CanBtn("CANCEL","buttonsGroup")),"The Cancel Button isn't visible to the user in the View profile Page");

		//Step 7:Enter Password
		//Expected:A message should come if user will left any character in password field
		base.setData(LoginPageObj.Edt_LoginEmail("pswd"),ViewProfileTestData.ViewPro_11_ViewProfilePassword);
		String ActualPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("pswd"));
		asrt.assertEquals(ActualPassword,ViewProfileTestData.ViewPro_11_ViewProfilePassword,"The actual and expected password are not matching");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("missing special characters (@ $ * !)")),"Missing special characters (@ $ * !) message isn't visible to the user");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("missing minimum length 7")),"Missing minimum length 7 message isn't visible to the user");

	}

	// <summary>
	// Test Case Title : "Verify that a message will come, Verify that a message will come, if the given Password and Confirm Password length is below7 characters
	// Automation ID : ViewPro_13
	// </summary>
	public void ViewPro_13_ViewProfile() throws InterruptedException
	{
		Login login =new Login(driver); 	  
		CommonData CommonData = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewProfile_TestData ViewProfileTestData = new ViewProfile_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();

		//Step 1:"Navigate to the Snipback page "
		//Expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");
		//Step 2:Navigate to Homepage and click login button
		//Expected: User should be navigated to login page
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

		// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");

		// step 5:"User is able to click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		//expected:"User should be able click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("row profileWrapper")), "User is unable to view the 'View Profile' page.");

		//Step 6:Click the 'Reset Password' Button
		//Expected:RESET PASSWORD box should have following field 
		//1.)Password 
		//2.)Confirm Password
		//3.)CANCEL Button
		//4.)RESET Button
		//Thread.sleep(7000);
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Reset Password"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("RESET PASSWORD")),"The Reset Password Heading isn't visible to the user in the View profile Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("pswd")),"The Password Field isn't visible to the user in the View profile Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("cn_password")),"The Confirm Password Field isn't visible to the user in the View profile Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("RESET")),"The RESET Button isn't visible to the user in the View profile Page");
		asrt.assertTrue(base.isExists(ViewProfileObj.Btn_CanBtn("CANCEL","buttonsGroup")),"The Cancel Button isn't visible to the user in the View profile Page");

		//Step 7: Enter password with length below 7 characters			
		//Expected:A message "Missing minimum length 7" should come,
		base.setData(LoginPageObj.Edt_LoginEmail("pswd"),ViewProfileTestData.ViewPro_13_ViewProfilePassword);
		String ActualPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("pswd"));
		asrt.assertEquals(ActualPassword,ViewProfileTestData.ViewPro_13_ViewProfilePassword,"The actual and expected password are not matching");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("missing minimum length 7")),"missing minimum length 7 message isn't visible to the user");

		//Step 8: Enter confirm password with length below 7 characters			
		//Expected:A message "Missing minimum length 7" should come,
		base.setData(LoginPageObj.Edt_LoginEmail("cn_password"),ViewProfileTestData.ViewPro_13_ViewProfilePassword);
		String ActualConfirmPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("cn_password"));
		asrt.assertEquals(ActualConfirmPassword,ViewProfileTestData.ViewPro_13_ViewProfilePassword,"The actual and expected password are not matching");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("missing minimum length 7")),"missing minimum length 7 message isn't visible to the user");

	}

	

	// <summary>
	// Test Case Title : "Verify that  message should be displayed whenpassword field is left blank " 
	// Automation ID : ViewPro_14
	// </summary>	
	public void ViewPro_14_ViewProfile() throws InterruptedException
	{
		Login login =new Login(driver); 	  
		CommonData CommonData = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();

		//Step 1:"Navigate to the Snipback page "
		//Expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");
		//Step 2:Navigate to Homepage and click login button
		//Expected: User should be navigated to login page

		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

		// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");

		// step 5:"User is able to click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		//expected:"User should be able click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("row profileWrapper")), "User is unable to view the 'View Profile' page.");

		//Step 6:Click the 'Reset Password' Button
		//Expected:RESET PASSWORD box should have following field 
		//1.)Password 
		//2.)Confirm Password
		//3.)CANCEL Button
		//4.)RESET Button
		//Thread.sleep(7000);
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Reset Password"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("RESET PASSWORD")),"The Reset Password Heading isn't visible to the user in the View profile Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("pswd")),"The Password Field isn't visible to the user in the View profile Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("cn_password")),"The Confirm Password Field isn't visible to the user in the View profile Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("RESET")),"The RESET Button isn't visible to the user in the View profile Page");
		asrt.assertTrue(base.isExists(ViewProfileObj.Btn_CanBtn("CANCEL","buttonsGroup")),"The Cancel Button isn't visible to the user in the View profile Page");	

		//Step 7: Enter No Password & click RESET 
		//Expected:A message "Please enter new password"message should be displayed when the password field is left blank
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("RESET"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Please enter new password")),"Please enter new password message isn't displayed to the user");

	}

	// <summary>
	// Test Case Title : "Verify that a message will displayed when we click RESET button, without filling Confirm password, fill password field only" 
	// Automation ID : ViewPro_15
	// </summary>
	public void ViewPro_15_ViewProfile() throws InterruptedException
	{
		Login login =new Login(driver); 	  
		CommonData CommonData = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		ViewProfile_TestData ViewProfileTestData = new ViewProfile_TestData();
		Pool_Obj poolObj = new Pool_Obj();

		//Step 1:"Navigate to the Snipback page "
		//Expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");
		
		//Step 2:Navigate to Homepage and click login button
		//Expected: User should be navigated to login page
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

		// step 4:"User is able to see the "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to see the "View Profile" option on the top list in Snipback page"
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile")), "User is unable to see the View Profile option on the top list in Snipback page");

		// step 5:"User is able to click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		//expected:"User should be able click the "View Profile" option on the top list and navigate to Profile Setting page in Snipback"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("row profileWrapper")), "User is unable to view the 'View Profile' page.");

		//Step 6:Click the 'Reset Password' Button
		//Expected:RESET PASSWORD box should have following field 
		//1.)Password 
		//2.)Confirm Password
		//3.)CANCEL Button
		//4.)RESET Button
		//Thread.sleep(7000);
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Reset Password"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("RESET PASSWORD")),"The Reset Password Heading isn't visible to the user in the view profile page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("pswd")),"The Password Field isn't visible to the user in the view profile page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("cn_password")),"The Confirm Password Field isn't visible to the user in the view profile page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("RESET")),"The RESET Button isn't visible to the user in the view profile page");
		asrt.assertTrue(base.isExists(ViewProfileObj.Btn_CanBtn("CANCEL","buttonsGroup")),"The Cancel Button isn't visible to the user in the view profile page");	

		//Step 7:Enter Password field only
		//Expected:User should be able to enter password
		base.setData(LoginPageObj.Edt_LoginEmail("pswd"),ViewProfileTestData.ViewPro_15_ViewProfilePassword);
		String ActualPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("pswd"));
		asrt.assertEquals(ActualPassword,ViewProfileTestData.ViewPro_15_ViewProfilePassword,"The actual and expected password are not matching");

		//Step 8:Click RESET
		//Expected:A Message " Please enter confirm new password" should displayed when user didnt fill the confirm password field
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("RESET"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Please enter confirm new password")),"Please enter confirm new password message isn't displayed to the user");
	}

	// <summary>
	// Test Case Title : "Verify that a message will displayed when we click RESET button, without filling password field, fill confirm password field only" 
	// Automation ID : ViewPro_16
	// </summary>
	public void ViewPro_16_ViewProfile() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewProfile_TestData ViewProfileTestData = new ViewProfile_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User unable to click Down Arrow button on right side of profile picture in Snipback page");

		// step 4:"User is able to click on "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to click the "View Profile" option on the top list in Snipback page"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("col-lg-3 profileImagespadding")), "User is unable to see the Profile page on clicking view profile fron the drop down list in Snipback page");

		//Step 5: "User is able to click on Reset Password button in the view profile page"
		//Expected :User should be able to click on Reset Password button in the view profile page
		base.buttonClick(LoginPageObj.Btn_SingnIn("reset_password"));
		base.setData(LoginPageObj.Edt_LoginEmail("cn_password"),ViewProfile_TestData.ViewPro_15_ViewProfilePassword);

		//Step 6: Click on Reset button in the view profile Reset Password field
		//Expected : User should be able to click on Reset button in the view profile Reset password field
		base.buttonClick(LoginPageObj.Btn_SingnIn("pswd_reset"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("er_psw")), "User is unable to view the error message while user enter confirm password without entering password in Reset password field in view profile page.");

	}
	
	// <summary>
	// Test Case Title : "Verify that the RESET button will Enable once the given password should be in 7 character" 
	// Automation ID : ViewPro_17
	// </summary>
	public void ViewPro_17_ViewProfile() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewProfile_TestData ViewProfileTestData = new ViewProfile_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Down Arrow on right side of the profile picture");

		// step 4:"User is able to click on "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to click the "View Profile" option on the top list in Snipback page"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("col-lg-3 profileImagespadding")), "User is unable to see the Profile page on clicking view profile fron the drop down list in Snipback page");

		//Step 5: "User is able to click on Reset Password button in the view profile page"
		//Expected :User should be able to click on Reset Password button in the view profile page
		base.buttonClick(LoginPageObj.Btn_SingnIn("reset_password"));
		base.setData(LoginPageObj.Edt_LoginEmail("pswd"),ViewProfile_TestData.ViewPro_17_Password);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("pswd_reset")), "User is unable to view the enabled Reset button once the given password should be in 7 character.");
	}

	// <summary>
	// Test Case Title : Verify that the Reset password box gets closed when user click the CANCEL button
	// Automation ID : ViewPro_18
	// </summary>
	public void ViewPro_18_ViewProfile() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj poolObj = new Pool_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		// step 3:"User able to click Down Arrow button on right side of profile picture in Snipback page"
		//expected:"User should able to click Down Arrow button on right side of profile picture in Snipback page"
		base.buttonClick(poolObj.Btn_ButtonCreate("btn dropdown-toggle"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")), "User is unable to view the Drop Down on right side of the profile picture");

		// step 4:"User is able to click on "View Profile" option on the top list in Snipback page"
		//expected:"User should be able to click the "View Profile" option on the top list in Snipback page"
		base.buttonClick(ViewProfileObj.Ele_ViewProfile("dropdown-menu show","View Profile"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("col-lg-3 profileImagespadding")), "User is unable to see the Profile page on clicking view profile fron the drop down list in Snipback page");

		//Step 5: "User is able to click on Reset Password button in the view profile page"
		//Expected :User should be able to click on Reset Password button in the view profile page
		base.buttonClick(LoginPageObj.Btn_SingnIn("reset_password"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("pswd_reset")), "User is unable to view the enabled Reset button once the given password should be in 7 character.");

		//Step 6: Click on Cancel Button
		//Expected: User should be able to click on Cancel button in reset password page in view profile
		base.buttonClick(ViewProfileObj.Btn_Cancel("modal-content","CANCEL"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("col-lg-3 profileImagespadding")), "User is unable to see the Profile page on clicking view profile fron the drop down list in Snipback page");
	}	
}

