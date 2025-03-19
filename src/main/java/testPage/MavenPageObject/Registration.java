package testPage.MavenPageObject;

import TestData.ForgotPassword_TestData;
import TestData.Registration_TestData;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;

public class Registration extends BasePge {

	BasePge base;
	Assert asrt;

	public Registration(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	
		/// <summary>
		/// Test Case Title : Verify whether the user can able to register using valid details
		/// Automation ID : SignUp_PositiveScenario
		/// </summary>
	public void SignUp() throws InterruptedException 

	{
		//SignIn_Obj SignInObj = new SignIn_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Registration_TestData registrationtestdata = new Registration_TestData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();

		
		//Step 1 : Click on Login Button
		//User should be able to click on Login Button
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginCredentialFields("email_address")), "User not able to click on the Login Button");

		//Step 2: Click Sign up button
		//User able to click Sign Up button
		base.buttonClick(LoginPageObj.Btn_Login("Sign Up"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("first_name")),"User is not able to view Sign Up page");

		//Step 3: Enter Name 
		//User able to enter the Name
		base.setData(LoginPageObj.Edt_LoginEmail("first_name"),Registration_TestData.SignUp01_ValidName+base.CreateRandomWithoutNumbers(1));
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("first_name"));
	
		//Step 4:Enter Email
		//User able to enter the Email
		base.setData(LoginPageObj.Edt_LoginEmail("user_email"),Registration_TestData.SignUp01_ValidEmail);
		String ActualEmail = base.GetValue(LoginPageObj.Edt_LoginEmail("user_email"));

		//Step 5: Enter Username
		//User able to enter the Username
		base.setData(LoginPageObj.Edt_LoginEmail("user_name"),Registration_TestData.SignUp01_ValidUserName+base.CreateRandomWithoutNumbers(1));
		String ActualUsername = base.GetValue(LoginPageObj.Edt_LoginEmail("user_name"));

		//Step 6: Enter Password
		//User able to enter the Password
		base.setData(LoginPageObj.Edt_LoginEmail("user_pass"),Registration_TestData.SignUp01_Password);
		String ActualPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("user_pass"));
		
		//Step 7 : Enter the Confirm Password
		//User can able to enter the Confirm Password
		base.setData(LoginPageObj.Edt_LoginEmail("user_confirm_password"), Registration_TestData.SignUp01_ConfirmPassword);
		String confirmpass = base.GetValue(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		
		//Step 8 : Accept the terms&conditions checkbox
		//User can able to click the terms&conditions checkbox
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("agreeterms"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("agreeterms")),"'By selecting the checkbox in user Sign Up page, the user agrees to the application's Terms of Service.'");
		
		//Step 9 : Click the SignUp(submit) Button
		//User can able to click the SignUp submit button after filling all the required fields
		base.scrollToElement(LoginPageObj.Btn_SignInButton("SIGN UP"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("SIGN UP"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("signUp-otp")), "User can't able to click the SignUp submit Button");

}
	// <summary>
	// Test Case Title : Name
	//	1.Verify if the name field is mandatory or shows an error message when left blank.
	//	2. Verify if the field shows error message for numbers and special characters entry
	//	3.Verify if the name field uses only alphabets
	// Automation ID : TC01_Registration
	// </summary>
	public void TC01_Registration() throws InterruptedException {
		Registration_Obj RegistrationObj = new Registration_Obj();
		Registration_TestData registrationtestdata = new Registration_TestData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();

		// Step 1: Navigate to the Homepage
		// Expected Result: User should be navigated to the Homepage
		base.buttonClick(LoginPageObj.Btn_Login("Login"));

		// Step 2: Click Sign-up
		// Expected Result: Navigate to SignUp Page
		base.buttonClick(LoginPageObj.Btn_Login("Sign Up"));
		String ExcepectedUrl = "https://snipback.com/signup";
		String CurrentUrl = driver.getCurrentUrl();
		asrt.assertEquals(CurrentUrl, ExcepectedUrl, "User is unable to navigate to signup page");

		// Step 3: Leave Name field blank and click Sign-up
		// Expected Result: Alert is displayed on the Name field for leaving it blank
		base.scrollToElement(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("err_name")),"Alert is  Not Displayed in Name field of Signup page");

		// Step 4: Enter the Special characters and numbers in Namefield of Sigup page.
		// Expected Result:There should be a pop-up message "Name field must only contain letters "
		base.setData(LoginPageObj.Edt_LoginEmail("first_name"),
				registrationtestdata.TC01_RegistrationSpecialCharacters);
		base.buttonClick(LoginPageObj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Alert("Name must only contain letters")),"Alert Not Displayed in Signup page ");

		// Step 5: Enter a valid name in the Name field and click Sign-up
		// Expected Result: Alert should not be displayed under the name field in signup page.
		base.setData(LoginPageObj.Edt_LoginEmail("first_name"),
				registrationtestdata.TC01_RegistrationName1 + CreateRandom(1));
		base.buttonClick(LoginPageObj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("user_email")),"Alert is Displayed under the  Name field of Signup page");
	}

	// <summary>
	// Test Case Title : Email Address
	//	1. Verify for valid email address.
	//	2. Verify for invalid email address.
	//	3. Verify if the email address shows an error message when left blank.
	//	4. Verify the field with leading/trailing spaces or extra parameters.
	//	5. Verify if the email address is duplicate/already existing in the database.
	// Automation ID : TC02_Registration
	// </summary>
	public void TC02_Registration() throws InterruptedException {
		Registration_Obj Registrationobj = new Registration_Obj();
		Registration_TestData registrationtestdata = new Registration_TestData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();

		// Step 1: Navigate to the Homepage
		// Expected Result: User should be navigated to the Homepage
		base.buttonClick(LoginPageObj.Btn_Login("Login"));

		// Step 2: Click Sign-up
		// Expected Result: Navigate to SignUp Page		
		base.buttonClick(LoginPageObj.Btn_Login("Sign Up"));
		String ExcepectedUrl = "https://snipback.com/signup";
		String CurrentUrl = driver.getCurrentUrl();
		asrt.assertEquals(CurrentUrl, ExcepectedUrl, "User is unable to navigate to signup page");

		// Step 3: Verify for valid email address.
		// Expected Result:User is able entered the valid email.
		base.setData(LoginPageObj.Edt_LoginEmail("first_name"),registrationtestdata.TC01_RegistrationName1 + CreateRandom(1));
		base.setData(LoginPageObj.Edt_LoginEmail("user_email"),registrationtestdata.TC02_RegistrationEmailField);
		base.clearData(LoginPageObj.Edt_LoginEmail("first_name"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("user_name")),"Alert is Displayed under the Email field of Signup page");

		// Step 4: Verify for invalid email address.
		// Expected Result: Alert should be displayed under the Email field in signup page.
		base.setData(LoginPageObj.Edt_LoginEmail("user_email"),registrationtestdata.TC02_RegistrationIInvalidEmailId);		
		base.scrollToElement(LoginPageObj.Btn_SingnIn("btn-signup"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(Registrationobj.Ele_Alert("Please enter the valid email, the invalid characters are")),"Alert is Displayed under the Email field of Signup page");

		// Step 5:Verify if the email address shows an error message when left blank.
		// Expected Result:Alert Should Be displayed under the Email_field for Leaving it Blank .
		base.setData(LoginPageObj.Edt_LoginEmail("first_name"),registrationtestdata.TC01_RegistrationName1 + CreateRandomWithoutNumbers(1));

		base.setData(LoginPageObj.Edt_LoginEmail("user_email"),registrationtestdata.TC02_RegistrationBlankEmailId);
		base.buttonClick(LoginPageObj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(Registrationobj.Ele_Alert("Please enter your email address")),"Alert is  Not Displayed in Email field of Signup page");

		// Step 6: Verify the field with leading/trailing spaces or extra parameters.
		// Expected Result:Alert should be displayed under the Email field in signup page
		base.setData(LoginPageObj.Edt_LoginEmail("user_email"),registrationtestdata.TC02_RegistrationInvalidEmailData);
		base.scrollToElement(LoginPageObj.Btn_SingnIn("btn-signup"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(Registrationobj.Ele_Alert("Please enter the valid email, the invalid characters are")),"Alert is  Not Displayed in Email field of Signup page");
		
		// Step 7:Verify if the email address is duplicate/already existing in the database.
		// Expected Result: Alert should be displayed as "User already exists".
		base.setData(LoginPageObj.Edt_LoginEmail("first_name"),registrationtestdata.TC01_RegistrationName1 + CreateRandom(1));
		base.setData(LoginPageObj.Edt_LoginEmail("user_email"),registrationtestdata.TC02_RegistrationExistEmail);
		base.setData(LoginPageObj.Edt_LoginEmail("user_name"), registrationtestdata.TC02_Registrationusername);
		base.setData(LoginPageObj.Edt_LoginEmail("user_pass"), registrationtestdata.TC02_Registrationpassword);
		base.setData(LoginPageObj.Edt_LoginEmail("user_confirm_password"),registrationtestdata.TC02_RegistrationConfirmPassword);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("agreeterms"));		
		base.scrollToElement(LoginPageObj.Btn_SingnIn("btn-signup"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("btn-signup"));
		
	}

	// <summary>
	// Test Case Title :  Username
	//	1. Verify for invalid usernames with wrong characters, such as {}[]<>\/() .
	//	2. Verify the username field maximum length(50) of the input characters.
	//	3. Verify if the field allows alphanumeric input as per user specifications.
	//	4. Verify if an error message is shown for using an existing username.
	//	5. Verify if the system trims the whitespace and accepts the username.
	// Automation ID : TC03_Registration
	// </summary>
	public void TC03_Registration()  throws InterruptedException
	{	

		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_TestData RegistrationTestData = new Registration_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();

		// Step 1 : Click Sign-up
		// Expected : Sign-up page should be displayed.	
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		base.buttonClick(LoginPageObj.Btn_Login("Sign Up"));
		asrt.assertTrue(driver.findElement(RegistrationObj.Nav_RegistrationPage("user-register")).isDisplayed(),"On clicking Sign-up button user is not able to view the Sign-up page.");

		//Step 2: Enter Name
		//Expected : User should be able to enter the name.
		base.setData(LoginPageObj.Edt_LoginEmail("first_name"),RegistrationTestData.TC03_RegistrationName);
		String FirstName = base.GetValue(LoginPageObj.Edt_LoginEmail("first_name"));
		Assert.assertEquals(FirstName,RegistrationTestData.TC03_RegistrationName,"The entered First Name is displayed in the First Name text field in user Sign Up page.");

		//Step 3 : Enter Email Address
		//Expected : User should be able to enter Email address.
		base.setData(LoginPageObj.Edt_LoginEmail("user_email"),RegistrationTestData.TC03_RegistrationEmailId);
		String EmailAddresss = base.GetValue(LoginPageObj.Edt_LoginEmail("user_email"));
		Assert.assertEquals(EmailAddresss,RegistrationTestData.TC03_RegistrationEmailId,"The entered Email Address is displayed in the Email Address text field in user Sign Up page.");

		//Step 4 : Verify for invalid usernames with wrong characters, such as {}[]<>\/() .
		//Expected : There should be a pop-up message " Please enter the valid name, the invalid characters are {}[]<>\/()".
		base.setData(LoginPageObj.Edt_LoginEmail("user_name"),RegistrationTestData.TC03_RegistrationInvalidUsername);
		String InvalidUsername = base.GetValue(LoginPageObj.Edt_LoginEmail("user_name"));
		Assert.assertEquals(InvalidUsername,RegistrationTestData.TC03_RegistrationInvalidUsername,"The entered Invalid Username is displayed in the Username text field");
		base.excuteJsClick(RegistrationObj.Btn_RegistrationSignUp("btn btn-submit"));
		base.buttonClick(LoginPageObj.Edt_LoginEmail("user_pass"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpMinConfPassword("commonValidateErr active")), "On clicking Sign-up button with invalid username -'Please enter the valid name, the invalid characters are &/\\#,+()$~%.^':*?<>{}\"', error message is displayed.");

		//Step 5 : Verify the username field maximum length(50) of the input characters.
		//Expected : There should be a pop-up message "Name must not exceed 50 characters."		
		base.setData(LoginPageObj.Edt_LoginEmail("user_name"),RegistrationTestData.TC03_RegistrationExceedUsername);
		String ExceedUsername = base.GetValue(LoginPageObj.Edt_LoginEmail("user_name"));
		asrt.assertEquals(50,ExceedUsername.length(),"The entered Exceeded Username is displayed in the Username text field in user Sign Up page." );

		//Step 6 : Verify if the field allows alphanumeric input as per user specifications.
		//Expected : It should accept mentioned test data.
		base.setData(LoginPageObj.Edt_LoginEmail("user_name"),RegistrationTestData.TC03_RegistrationAlphanumericUsername);
		String AlphanumericUsername = base.GetValue(LoginPageObj.Edt_LoginEmail("user_name"));
		Assert.assertEquals(AlphanumericUsername,RegistrationTestData.TC03_RegistrationAlphanumericUsername,"The entered Alphanumeric Username is displayed in the Username text field");
		base.excuteJsClick(RegistrationObj.Btn_RegistrationSignUp("btn btn-submit"));

		//Step 7 : Verify if an error message is shown for using an existing username. 
		//Expected : There should be a pop-up message "Username already exists
		base.setData(LoginPageObj.Edt_LoginEmail("user_name"),RegistrationTestData.TC03_RegistrationExistingUser);
		String ExistingUser = base.GetValue(LoginPageObj.Edt_LoginEmail("user_name"));
		Assert.assertEquals(ExistingUser,RegistrationTestData.TC03_RegistrationExistingUser,"The entered Existing Username is displayed in the Username text field");

		//Step 8 : Verify if the system trims the whitespace and accepts the username.
		//Expected : It should accept mentioned test data.
		base.setData(LoginPageObj.Edt_LoginEmail("user_name"),RegistrationTestData.TC03_RegistrationWhitespaceUsername);
		String WhitespaceUsername = base.GetValue(LoginPageObj.Edt_LoginEmail("user_name"));
		Assert.assertEquals(WhitespaceUsername,RegistrationTestData.TC03_RegistrationWhitespaceUsername,"The entered Whitespaced Username is displayed in the Username text field");
		base.excuteJsClick(RegistrationObj.Btn_RegistrationSignUp("btn btn-submit"));

		//Step 9 : Enter Password
		//Expected : User should be able to enter Password.
		base.setData(LoginPageObj.Edt_LoginEmail("user_pass"),RegistrationTestData.TC03_RegistrationPassword);
		String Password = base.GetValue(LoginPageObj.Edt_LoginEmail("user_pass"));
		Assert.assertEquals(Password,RegistrationTestData.TC03_RegistrationPassword,"The entered Password is displayed in the Password text field in user Sign Up page.");

		//Step 10 : Enter Confirm Password
		//Expected : User should be able to enter Confirm Password.
		base.setData(LoginPageObj.Edt_LoginEmail("user_confirm_password"), RegistrationTestData.TC03_RegistrationConfirmPassword);
		String ConfirmPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		Assert.assertEquals(ConfirmPassword,RegistrationTestData.TC03_RegistrationConfirmPassword,"The entered Confirm Password is displayed in the Confirm Password text field in user Sign Up page.");

		//Step 11 : Click on 'I agree to the Terms of Service' checkbox.
		//Expected : User should be able to click on 'I agree to the Terms of Service' checkbox.
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("agreeterms"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("agreeterms")),"'By selecting the checkbox in user Sign Up page, the user agrees to the application's Terms of Service.'");

		//Step 12 : Click on Sign Up button
		//Expected : User should be able to click on Sign Up button.
		base.excuteJsClick(RegistrationObj.Btn_RegistrationSignUp("btn btn-submit"));
		asrt.assertFalse(driver.findElement(RegistrationObj.Ele_OtpPage("register-otp-section")).isDisplayed(),"On clicking Sign-up button user is not able to view the verification page.");

	}


		// <summary>
		// Test Case Title :  Password
		//	1. Verify password should be a minimum and maximum characters long.
		//	2. Verify password should have at least 1 uppercase and 1 lowercase letter
		//	3. Verify Password should consist of at least 1 number.
		//	4. Verify the field must have at least 1 special character.
		//	5. Verify if the input in the password matches with the confirm password fields.
		//	6. Verify the error messages are shown for blank password field
		//	7. Verify password should be Minimum 7 charater with atleast 1 uppercase, lowercase, number, andspecial character
		// Automation ID : TC04_Registration
	public void TC04_Registration() throws InterruptedException {
		Login login = new Login(driver);
		CommonData CommonData = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ForgotPassword_Obj ForgotPasswordObj = new ForgotPassword_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Registration_TestData RegistrationTestData = new Registration_TestData();

		// Step 1:Navigate to the HomePage
		// Expected:User should be navigated to HomePage
		base.buttonClick(LoginPageObj.Btn_Login("Login"));

		// Step 2:Click the SignUp
		// Expected:User should be navigated to SignUp Page
		base.buttonClick(LoginPageObj.Btn_Login("Sign Up"));
		Assert.assertTrue(base.isExists(RegistrationObj.Img_SignUpPageLogo("img-fluid")),"User is not navigated to SignUp page");

		// Step 3:Enter the Name
		// Expected:User should be able to enter the Name
		base.setData(RegistrationObj.Edt_Name("Name"), RegistrationTestData.TC04_RegistrationName1);
		String Name = base.GetValue(RegistrationObj.Edt_Name("Name"));
		Assert.assertEquals(Name, RegistrationTestData.TC04_RegistrationName1,"User should not able to enter Name in the SignUp page");

		// Step 4:Enter the Email
		// Expected:User should be able to enter the Email
		base.setData(LoginPageObj.Edt_LoginEmail("user_email"), RegistrationTestData.TC04_RegistrationEmail1);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("user_email"));
		Assert.assertEquals(Email, RegistrationTestData.TC04_RegistrationEmail1,"User should not able to enter Email in the SignUp page");

		// Step 5:Enter the UserName
		// Expected:User should be able to enter the UserName
		base.setData(LoginPageObj.Edt_LoginEmail("user_name"), RegistrationTestData.TC04_RegistrationName1);
		String UName = base.GetValue(LoginPageObj.Edt_LoginEmail("user_name"));
		Assert.assertEquals(UName, RegistrationTestData.TC04_RegistrationName1,"User should not able to enter UserName in SignUp page");

		// Step 6:Enter the InvalidPassword
		// Expected:User should be able to enter the InvalidPassword
		base.setData(LoginPageObj.Edt_LoginEmail("user_pass"),RegistrationTestData.TC04_RegistrationPassword);
		String InvalidPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("user_pass"));
		Assert.assertEquals(InvalidPassword, RegistrationTestData.TC04_RegistrationPassword,"User should not able to enter InvalidPassword in SignUp page");

		// Step 7:PopUp Message
		// Expected:User should be able to view the PopUpMessage."The password should contain minimum 6 characters."
		base.buttonClick(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		Assert.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("The password should contain minimum 6 characters.")),"User not able to view the error message in the signup page");

		// Step 8: Enter a Password without UpperCase, LowerCase, Numeric, or Special
		// Characters
		// Expected: User should see an error message
		base.setData(LoginPageObj.Edt_LoginEmail("user_pass"),RegistrationTestData.TC04_RegistrationWeakPassword);
		Thread.sleep(10000);
		Assert.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("missing uppercase letters")),"Error message not displayed for invalid password");

		// Step 9: Enter a Password with Missing Digit
		// Expected: User should see an error message
		base.setData(LoginPageObj.Edt_LoginEmail("user_pass"),RegistrationTestData.TC04_RegistrationNodigitPassword);
		Thread.sleep(10000);
		Assert.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("missing numeric digits")),"Error message not displayed for missing number");

		// Step 10: Enter a Valid Password
		// Expected: User should be able to enter the valid password without errors

		base.setData(LoginPageObj.Edt_LoginEmail("user_pass"),RegistrationTestData.TC04_RegistartionValidPassword);
		String enteredPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("user_pass"));
		Assert.assertEquals(enteredPassword, RegistrationTestData.TC04_RegistartionValidPassword,"User should be able to enter a valid password");

		// Step 11: Confirm Password
		// Expected: ConfirmPassword field should match the entered password
		base.setData(LoginPageObj.Edt_LoginEmail("user_confirm_password"),RegistrationTestData.TC04_RegistartionValidPassword);
		String confirmPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		Assert.assertEquals(confirmPassword, RegistrationTestData.TC04_RegistartionValidPassword,"ConfirmPassword does not match the entered password");

	}

	// <summary>
	// Test Case Title : "Confirm Password"
	//	1. Verify password should be a minimum and maximum characters long.
	//	2. Verify password should have at least 1 uppercase and 1 lowercase letter
	//	3. Verify Password should consist of at least 1 number.
	//	4. Verify the field must have at least 1 special character.
	//	5. Verify if the input the confirm password matches with the password fields.
	//	6. Verify the error messages are shown for blank password field
	//	7. Verify password should be Minimum 7 charater with atleast 1 uppercase, lowercase, number, andspecial character
	// Automation ID : TC05_Registration
	// </summary>
	public void TC05_Registration() throws InterruptedException

	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Registration_TestData RegistrationTestData = new Registration_TestData();

		// step 1:"Navigate to the Home page"
		// expected:"User able to view Home page"
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("logo-wrap")), "User is not able to view Home page");

		// step 2:"click Sign up button"
		// expected:"User able to click Sign Up button"
		base.buttonClick(LoginPageObj.Btn_Login("Sign Up"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("first_name")), "User is not able to view Sign Up page");

		// step 3:"Enter Name"
		// expected:"User able to enter the Name"
		base.setData(LoginPageObj.Edt_LoginEmail("first_name"), RegistrationTestData.TC05_Registrationname);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("first_name"));
		asrt.assertEquals(ActualName, RegistrationTestData.TC05_Registrationname, "User is not able to enter the Name in the Sign UP page");

		// step 4:"Enter Email"
		// expected:"User able to enter the Email"
		base.setData(LoginPageObj.Edt_LoginEmail("user_email"), RegistrationTestData.TC05_Registrationemail);
		String ActualEmail = base.GetValue(LoginPageObj.Edt_LoginEmail("user_email"));
		asrt.assertEquals(ActualEmail, RegistrationTestData.TC05_Registrationemail, "User is not able to enter the Email in the Sign UP page");

		// step 5:"Enter Username"
		// expected:"User able to enter the Username"
		base.setData(LoginPageObj.Edt_LoginEmail("user_name"), RegistrationTestData.TC05_Registrationusername);
		String ActualUsername = base.GetValue(LoginPageObj.Edt_LoginEmail("user_name"));
		asrt.assertEquals(ActualUsername, RegistrationTestData.TC05_Registrationusername, "User is not able to enter the Username in the Sign UP page");

		// step 6:"Enter Password"
		// expected:"User able to enter the Password"
		base.setData(LoginPageObj.Edt_LoginEmail("user_pass"), RegistrationTestData.TC05_Registrationpassword);
		String ActualPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("user_pass"));
		asrt.assertEquals(ActualPassword, RegistrationTestData.TC05_Registrationpassword, "User is not able to enter the Password in the Sign UP page");

		// step 7:"Click Signup button without enter the Confirm Password"
		// expected:"User is not able to Signup without entering Confirm Password and the need to display the popup message as Error"
		base.scrollToElement(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		base.scrollToElement(LoginPageObj.Btn_SingnIn("btn-signup"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("err_cpassword")), "User is able to Sig Up without entering the Confirm password in the Sign Up page");

		// step 8: "Enter Confirm Password with one minimum value"
		// expected:"User is not able to enter the Confirm Password and need to display be popup message as:
		// 1."The password should contain minimum 7 characters."
		// 2."Missing lowercase letters"
		// 3."missing uppercase letters"
		// 4."missing numeric digits"
		// 5."missing special characters (@ $ * !)"
		// 6."missing minimum length 7"
		base.setData(LoginPageObj.Edt_LoginEmail("user_confirm_password"), RegistrationTestData.TC05_Registrationminconfirmpassword);
		String ActualminConfirmPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpMinConfPassword("invalid-pswd")), "User is not able to enter Confirm password in the Sign Up page");

		// step 9:"Enter Confirm Password which is not same as Password"
		// expected:"User is not able to enter the Confirm Password and need to display the popup message Error as Passwords are not same"
		base.setData(LoginPageObj.Edt_LoginEmail("user_confirm_password"), RegistrationTestData.TC05_RegistrationSameconfirmpassword);
		String ActualSamePassword = base.GetValue(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("err_cpassword")), "User is able to enter Confirm password which is not same as Password in the Sign Up page ");

		// step 10: "Enter Confirm Password with same as Password data"
		// expected:"User able to enter the Confirm Password"
		base.setData(LoginPageObj.Edt_LoginEmail("user_confirm_password"), RegistrationTestData.TC05_Registrationpassword);
		String ActualConfirmPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		asrt.assertEquals(ActualConfirmPassword, RegistrationTestData.TC05_Registrationpassword, "User is not able to enter Confirm Password in the Sign Up page");

	}

	// <summary>
	// Test Case Title : "One-Time Password"
	//	1. Verify to submit the registration without entering the OTP..
	//	2. Verify submitting an expired OTP after the allowed time period
	//	3. Enter a valid OTP within the allowed time period and submit the  Verify One time password .
	//	4. Verify the "Resend OTP" button.
	//	5. Verify resending the OTP multiple times within a short period
	// Automation ID : TC07_Registration
	// </summary>                           
	public void TC07_Registration() throws InterruptedException { 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Registration_TestData RegistrationTestData = new Registration_TestData();

		// Step 1:"Navigate to the Homepage
		// Expected:The Home Page should be displayed
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Sign Up")), "The 'Sign Up' page isn't visible to the user");

		// Step 2: Click Sign-up
		// Expected Sign Up Page should be visible
		base.buttonClick(LoginPageObj.Btn_Login("Sign Up"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("register-contents")), "Sign Up Page isn't visible to the user");

		// Step 3:Enter Name
		// Expected:User should be able to type the name
		base.setData(RegistrationObj.Ele_SignupField("first_name"), RegistrationTestData.TC07_RegistrationOneTimePassWordName);
		String ActualName = base.GetValue(RegistrationObj.Ele_SignupField("first_name"));
		asrt.assertEquals(ActualName, RegistrationTestData.TC07_RegistrationOneTimePassWordName, "The name entered by the user does not match with the expected name");

		// Step 4:Enter Email
		// Expected:User should be able to type the email
		base.setData(RegistrationObj.Ele_SignupField("user_email"), RegistrationTestData.TC07_RegistrationOneTimePassWordEmail);
		String ActualEmail = base.GetValue(RegistrationObj.Ele_SignupField("user_email"));
		asrt.assertEquals(ActualEmail, RegistrationTestData.TC07_RegistrationOneTimePassWordEmail, "The email entered by the user does not match with the expected email");

		// Step 5:Enter Username
		// Expected:User should be able to type the username
		base.setData(RegistrationObj.Ele_SignupField("user_name"), RegistrationTestData.TC07_RegistrationOneTimePassWordUserName);
		String ActualUserName = base.GetValue(RegistrationObj.Ele_SignupField("user_name"));
		asrt.assertEquals(ActualUserName, RegistrationTestData.TC07_RegistrationOneTimePassWordUserName, "The username entered by the user does not match with the expected username");

		// Step 6:Enter Password
		// Expected:User should be able to enter the Password.
		base.setData(RegistrationObj.Ele_SignupField("user_pass"), RegistrationTestData.TC07_RegistrationOneTimePassWord);
		String ActualPassWord = base.GetValue(RegistrationObj.Ele_SignupField("user_pass"));
		asrt.assertEquals(ActualPassWord, RegistrationTestData.TC07_RegistrationOneTimePassWord, "The password entered by the user does not match with the expected password");

		// Step 7:Enter Confirm PassWord
		// Expected:User should be able to confirm Password
		base.setData(RegistrationObj.Ele_SignupField("user_confirm_password"), RegistrationTestData.TC07_RegistrationOneTimePassWord);
		String ActualConfirmPassWord = base.GetValue(RegistrationObj.Ele_SignupField("user_confirm_password"));
		asrt.assertEquals(ActualConfirmPassWord, RegistrationTestData.TC07_RegistrationOneTimePassWord, "The password entered by the user does not match with the expected password");

		// Step 8:Navigate to 'I agree to the Terms of Service'
		// Expected:User should be able to view Terms and conditions and it should have a checkbox for users to click.
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("mt-2 agree-terms-div")), "The I agree to the Terms of Service does not have a checkbox");

		// Step 9:Click on the Check Box
		// Expected:User should be able to click on the Check box
		base.selectCheckBox(RegistrationObj.Ele_SignupField("agreeterms"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("mt-2 agree-terms-div")), "The 'I agree to the Terms of Service' checkbox does not exist.");
		boolean isCheckBoxSelected = base.isExists(RegistrationObj.Ele_SignupField("agreeterms"));
		asrt.assertTrue(isCheckBoxSelected, "The 'I agree to the Terms of Service' checkbox is not selected.");

		// Step 10:Click on the Signup Button
		// Expected:The User should be directed to the OTP Page.
		base.scrollToElement(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("SIGN UP"));
		base.isExists(RegistrationObj.Ele_OtpPage("register-otp-section"));
		boolean isOtpPageDisplayed = base.isExists(RegistrationObj.Ele_OtpPage("register-otp-section"));
		asrt.assertTrue(isOtpPageDisplayed, "The OTP page is not displayed to the user.");

		// Step 11:Click on the Verify One-Time Passcode without entering the OTP"
		// Expected:There should be a pop-up message "Please enter One-time Passcode received on your email"
		base.buttonClick(LoginPageObj.Btn_SignInButton("VERIFY ONE-TIME PASSCODE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Please enter One-time Passcode received on your email")), "Please enter One-time Passcode received on your email is not displayed");

		//Step 12:Verify submitting an expired OTP after the allowed time period
		//Expected:There should be a pop-up message "Invalid One-time Passcode"
		base.setData(LoginPageObj.Edt_LoginEmail("signUp-otp"),RegistrationTestData.TC07_RegistrationOneTimePasswordInvalidOtp);
		String InvalidOtp = base.GetValue(LoginPageObj.Edt_LoginEmail("signUp-otp"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("VERIFY ONE-TIME PASSCODE")); 
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Invalid One-time Passcode.")),"'Invalid One-time Passcode' isn't displayed to the user");

		//Step 13:Verify the "Resend OTP" button.
		//Expected:There should be a pop-up message "Verification code was resent successfully"
		base.buttonClick(LoginPageObj.Btn_Login("Resend"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Verification code was resent successfully")),"Verification code was resent successfully isn't displayed to the user");
	}

	// <summary>
	// Test Case Title : "Terms and Conditions"
	//	1. Verify that the terms and conditions have a checkbox for users to click.
	//	2. Verify the user should be able to register only when the terms and conditions checkbox is clicked.
	//	3. Verify if the page displays a confirmation message after ticking the checkbox and completing the registration.
	//	4. Verify that the terms and conditions are clearly displayed and visible on the termsof use page when we click on  Terms of Service.
	// Automation ID : TC06_Registration
	// </summary>
	public void TC06_Registration() throws InterruptedException
	{
		Login Login =new Login(driver); 
		CommonData CommonData = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Registration_TestData RegistrationTestData = new Registration_TestData();

		//Step 1:"Navigate to the Homepage
		//Expected:The Home Page should be displayed
		base.buttonClick(LoginPageObj.Btn_Login("Login"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("logo-wrap")), "User is not able to view Home page");
		//Step 2: Click Sign-up 
		//Expected Sign Up Page should be visible
		base.buttonClick(LoginPageObj.Btn_Login("Sign Up"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("register-contents")),"Sign Up Page isn't visible to the user");

		//Step 3:Enter Name
		//Expected:User should be able to type the name
		base.setData(RegistrationObj.Ele_SignupField("first_name"),RegistrationTestData.TC06_RegistrationTermsandConditionsName);
		String ActualName = base.GetValue(RegistrationObj.Ele_SignupField("first_name"));
		asrt.assertEquals(ActualName,RegistrationTestData.TC06_RegistrationTermsandConditionsName,"The Actual and Expected name typed by user are not matching");

		//Step 4:Enter Email
		//Expected:User should be able to type the email
		base.setData(RegistrationObj.Ele_SignupField("user_email"),RegistrationTestData.TC06_RegistrationTermsandConditionsEmail);
		String ActualEmail = base.GetValue(RegistrationObj.Ele_SignupField("user_email"));
		asrt.assertEquals(ActualEmail, RegistrationTestData.TC06_RegistrationTermsandConditionsEmail,"The Actual and Expected email typed by user are not matching");

		//Step 5:Enter Username
		//Expected:User should be able to type the username
		base.setData(RegistrationObj.Ele_SignupField("user_name"),RegistrationTestData.TC06_RegistrationTermsandConditionsUserName);
		String ActualUserName = base.GetValue(RegistrationObj.Ele_SignupField("user_name"));
		asrt.assertEquals(ActualUserName,RegistrationTestData.TC06_RegistrationTermsandConditionsUserName,"The Actual and Expected username typed by user are not matching");

		//Step 6:Enter Password
		//Expected:User should be able to enter the Password.
		base.setData(RegistrationObj.Ele_SignupField("user_pass"), RegistrationTestData.TC06_RegistrationTermsandConditionsPassWord);
		String ActualPassWord = base.GetValue(RegistrationObj.Ele_SignupField("user_pass"));
		asrt.assertEquals(ActualPassWord,RegistrationTestData.TC06_RegistrationTermsandConditionsPassWord,"The Actual and Expected password typed by user are not matching");

		//Step 7:Enter Confirm PassWord
		//Expected:User should be able to confirm Password
		base.setData(RegistrationObj.Ele_SignupField("user_confirm_password"), RegistrationTestData.TC06_RegistrationTermsandConditionsPassWord);
		String ActualConfirmPassWord = base.GetValue(RegistrationObj.Ele_SignupField("user_pass"));
		asrt.assertEquals(ActualConfirmPassWord,RegistrationTestData.TC06_RegistrationTermsandConditionsPassWord,"The Actual and Expected password typed by user are not matching");

		//Step 8:Click checkbox button
		//Expected:It Should be redirect to https://snipback.com/terms-of-use page.
		//1. Verify that the terms and conditions have a checkbox for users to click.
		//Expected:It should be accept to mentioned test datas and click signup button
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("mt-2 agree-terms-div")),"The I agree to the Terms of Service does not have a checkbox");

		//2. Verify the user should be able to register only when the terms and conditions checkbox is clicked.
		//Expected:There should be a pop-up message "Please accept the terms of service".
		base.scrollToElement(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("SIGN UP"));	
		base.isExists(LoginPageObj.Edt_Alert1("Please accept the terms of service"));


		//3. Verify if the page displays a confirmation message after ticking the checkbox and completing the registration.
		//Expected:It should accept mentioned test data and redirect to enter one-time password Page.
		//4. Verify that the terms and conditions are clearly displayed and visible on the termsof use page when we click on  Terms of Service.
		//Expected:It Should be redirect to https://snipback.com/terms-of-use page.
		base.selectCheckBox(RegistrationObj.Ele_SignupField("agreeterms"));
		//Validate if Checkbox is Selected or not
		asrt.assertTrue(driver.findElement(RegistrationObj.Ele_SignupField("agreeterms")).isSelected(),"The Terms of Service checkbox isn't selected by the user");
		base.buttonClick(LoginPageObj.Btn_Login("Terms of Service"));
		base.switchToWindowByIndex(driver, 1);
		//Validate whether it redirects to new window
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Terms()),"The User is not redirected to the Terms and Condition Page");
		base.switchToWindowByIndex(driver, 0);
		base.buttonClick(LoginPageObj.Btn_SignInButton("SIGN UP"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("register-otp-section")),"The One Time Password is not displayed to the user");


	}
}

