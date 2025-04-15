package testPage.MavenPageObject;
import TestData.SnipBackRegistration_TestData;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
import objectRepository.ForgotPassword_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;
public class SnipBackRegistration extends BasePge{

	BasePge base;
	Assert asrt;
	ElementActions element;

	public SnipBackRegistration(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
		element=new ElementActions(driver);
	}
	// <summary>
	// Test Case Title :    "1.Verify if the name field is mandatory or shows an error message when left blank.
	//  2. Verify if the field shows error message for numbers and special characters entry
	//  3.Verify if the name field uses only alphabets"
	// Automation ID :TC01_Registration
	// </summary>

	public void TC01_Registration() throws InterruptedException 
	{
		Registration_Obj   RegistrationObj = new Registration_Obj();
		SnipBackRegistration_TestData  snipbackregistrationtestdata = new SnipBackRegistration_TestData();
		LoginPage_Obj loginpageobj = new LoginPage_Obj();

		//Step 1 :  Click on Login button
		//Expected : User should click on login button
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to click Login button in snipback home page");

		//Step 2: Click on sign up button
		//Expected : User should click on signup button
		base.buttonClick(RegistrationObj.Btn_SignUp("signup-btn","Sign Up"));
		asrt.assertTrue(base.isExists(loginpageobj.Btn_SingnIn("btn-signup")),"User is unable to click the signup button in the signup page");

		//Step 3 : Verify if the name field is mandatory or shows an error message when left blank.
		//Expected : There should be a pop-up message "Please enter ur name"
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"), SnipBackRegistration_TestData.TC01_RegistrationInvalidName);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Emailerror("err_name")),"User is unable to find the pop up message as 'Please enter your name'.");

		//Step 4 : Verify if the field shows error message for numbers and special characters entry
		//Expected : There should be a pop-up message "Name field must only contain letters "
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"),SnipBackRegistration_TestData.TC01_RegistrationInvalidCharName);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Emailerror("err_name")),"User is unable to find the pop up message as 'Name field must only contain letters'.");

		//Step5 : Verify if the name field uses only alphabets
		//Expected : It should accept mentioned test data.
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"),SnipBackRegistration_TestData.TC01_RegistrationValidName);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));	
		String ActualUsername= base.GetValue(RegistrationObj.Ele_Name("form-inlines","first_name"));
		asrt.assertEquals(ActualUsername,SnipBackRegistration_TestData.TC01_RegistrationValidName,"User is unable to accept the valid name");
	}
	// <summary>
	//Test Case Title :"1. Verify for valid email address.
	//                  2. Verify for invalid email address.
	//                 3. Verify if the email address shows an error message when left blank.
	//                 4. Verify the field with leading/trailing spaces or extra parameters.
	//                  5. Verify if the email address is duplicate/already existing in the database."
	//Automation ID :TC02_Registration
	//</summary>

	public void TC02_Registration() throws InterruptedException 
	{
		Registration_Obj   RegistrationObj = new Registration_Obj();
		LoginPage_Obj loginpageobj = new LoginPage_Obj();
		SnipBackRegistration_TestData  snipbackregistrationtestdata = new SnipBackRegistration_TestData();
		ForgotPassword_Obj forgotPasswordobj = new ForgotPassword_Obj();

		//Step 1 :  Click on Login button
		//Expected : User should click on login button
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to click Login button in snipback home page");

		//Step 2: Click on sign up button
		//Expected : User should click on signup button
		base.buttonClick(RegistrationObj.Btn_SignUp("signup-btn","Sign Up"));
		asrt.assertTrue(base.isExists(loginpageobj.Btn_SingnIn("btn-signup")),"User is unable to click the signup button in the signup page.");

		//Step 3 : Verify for valid email address.
		//Expected : It should accept mentioned test data.
		base.setData(loginpageobj.Edt_LoginEmail("user_email"),SnipBackRegistration_TestData.TC02_RegistrationValidEmail);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));		
		String ActualEmail= base.GetValue(loginpageobj.Edt_LoginEmail("user_email"));
		asrt.assertEquals(ActualEmail,SnipBackRegistration_TestData.TC02_RegistrationValidEmail,"User is unable to accept the valid email");

		//Step 4 :  Verify for invalid email address.
		//Expected : There should be a pop-up message "Please enter the valid email, the invalid characters are &/\#,+()$~%.^':*?<>{}"
		base.setData(loginpageobj.Edt_LoginEmail("user_email"), SnipBackRegistration_TestData.TC02_RegistrationInvalidEmail);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(forgotPasswordobj.Ele_Error("commonValidateErr active")),"User is unable to find the popup message as 'Please enter the valid email, the invalid characters are &/\\#,+()$~%.^':*?<>{}\"'");

		//Step 5 : Verify if the email address shows an error message when left blank.
		//Expected : There should be a pop-up message "Please enter your email address"
		base.setData(loginpageobj.Edt_LoginEmail("first_name"),SnipBackRegistration_TestData.TC02_RegistrationValidUsername );
		base.setData(loginpageobj.Edt_LoginEmail("user_email"), SnipBackRegistration_TestData.TC02_RegistrationEmailEmpty);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Emailerror("err_email")),"User is unable to find the popup message as 'Please enter your email address'");

		//Step 6 :  Verify the field with leading/trailing spaces or extra parameters.
		//Expected : There should be a pop-up message " a part followed by '@' should not contain the     symbol ' ' ','.
		base.setData(loginpageobj.Edt_LoginEmail("user_email"), SnipBackRegistration_TestData.TC02_RegistrationExtraEmail);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(forgotPasswordobj.Ele_Error("commonValidateErr active")),"User is unable to find the popup message as 'A part followed by '@' should not contain the symbol ' ' ','.'");

		//Step 7 :  Verify if the email address is duplicate/already existing in the database.
		//Expected : There should be a pop-up message "Email already exist"
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"),SnipBackRegistration_TestData.TC02_RegistrationValidName);
		base.setData(loginpageobj.Edt_LoginEmail("user_email"),SnipBackRegistration_TestData.TC02_RegistrationValidEmail);
		base.setData(loginpageobj.Edt_LoginEmail("user_name"),SnipBackRegistration_TestData.TC02_RegistrationValidUsername);
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),SnipBackRegistration_TestData.TC02_RegistrationPassword);
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),SnipBackRegistration_TestData.TC02_RegistrationPassword);
		base.buttonClick(loginpageobj.Edt_LoginEmail("agreeterms"));		
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Username("formWrap custom-signup", "user-registration-error text-center text-danger validatnText")), "User is unable to find the popup message as 'Email already exist'");

	}
	//<summary>
	//Test Case Title :"1. Verify for invalid usernames with wrong characters, such as {}[]<>\/() .
	//                  2. Verify the username field maximum length(50) of the input characters.
	//                  3. Verify if the field allows alphanumeric input as per user specifications.
	//                  4. Verify if an error message is shown for using an existing username 
	//                  5. Verify if the system trims the whitespace and accepts the username.
	//Automation ID :TC03_Registration
	//</summary> 

	public void TC03_Registration() throws InterruptedException 
	{
		Registration_Obj   RegistrationObj = new Registration_Obj();
		SnipBackRegistration_TestData  snipbackregistrationtestdata = new SnipBackRegistration_TestData();
		LoginPage_Obj loginpageobj = new LoginPage_Obj();
		ForgotPassword_Obj   forgotpasswordobj = new ForgotPassword_Obj();

		//Step 1 :  Click on Login button
		//Expected : User should click on login button
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to click Login button in snipback home page");

		//Step 2: Click on sign up button
		//Expected : User should click on signup button
		base.buttonClick(RegistrationObj.Btn_SignUp("signup-btn","Sign Up"));
		asrt.assertTrue(base.isExists(loginpageobj.Btn_SingnIn("btn-signup")),"User is unable to click the signup button in the signup page.");

		//Step 3: Verify for invalid usernames with wrong characters, such as {}[]<>\/() .
		//Expected : There should be a pop-up message " Please enter the valid name, the invalid characters are {}[]<>\/()"
		base.setData(loginpageobj.Edt_LoginEmail("user_name"),snipbackregistrationtestdata.TC03_RegistrationUsername);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(forgotpasswordobj.Ele_Error("commonValidateErr active")),"User is unable to find the popup message as 'Please enter the valid name, the invalid characters are {}[]<>\\/()'");

		//Step 4 : Verify the username field maximum length(50) of the input characters.
		//Expected : There should be a pop-up message "Name must not exceed 50 characters."
		base.setData(loginpageobj.Edt_LoginEmail("user_name"),snipbackregistrationtestdata.TC03_RegistrationExeedUsername);
		String ActualUserNamesExceeds= base.GetValue(loginpageobj.Edt_LoginEmail("user_name"));
		asrt.assertEquals(50,ActualUserNamesExceeds.length(), "User is unable to find the popup message as 'Name must not exceed 50 characters'");

		//Step 5 :  Verify if the field allows alphanumeric input as per user specifications
		//Expected : It should accept mentioned test data.
		base.setData(loginpageobj.Edt_LoginEmail("user_name"),snipbackregistrationtestdata.TC03_RegistrationValidUsername);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		String ActualUsername= base.GetValue(loginpageobj.Edt_LoginEmail("user_name"));
		asrt.assertEquals(ActualUsername,snipbackregistrationtestdata.TC03_RegistrationValidUsername,"User is unable to accept the alphanumeric username");

		//Step 6 : Verify if an error message is shown for using an existing username.
		//Expected : There should be a pop-up message "Username already exists"
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"),snipbackregistrationtestdata.TC03_RegistrationValidName);
		base.setData(loginpageobj.Edt_LoginEmail("user_email"),snipbackregistrationtestdata.TC03_registrationvalidemail);
		base.setData(loginpageobj.Edt_LoginEmail("user_name"),snipbackregistrationtestdata.TC03_RegistrationValidName);
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),snipbackregistrationtestdata.TC03_RegistrationPassword);
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),snipbackregistrationtestdata.TC03_RegistrationPassword);
		base.buttonClick(loginpageobj.Edt_LoginEmail("agreeterms"));		
		base.excuteJsClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Username("formWrap custom-signup","user-registration-error text-center text-danger validatnText")),"User is unable to find the popup message as 'Username already exist'");

		//Step 7 : Verify if the system trims the whitespace and accepts the username.
		//Expected : It should accept mentioned test data
		base.setData(loginpageobj.Edt_LoginEmail("user_name"),snipbackregistrationtestdata.TC03_RegistrationTrimName);
		String ActualTrimUsername= base.GetValue(loginpageobj.Edt_LoginEmail("user_name"));			
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));	
		asrt.assertEquals(ActualTrimUsername,SnipBackRegistration_TestData.TC03_RegistrationTrimName,"User is unable to trim the username and cannot accept the username");	
	}
	//<summary>
	//Test Case Title:"1. Verify password should be a minimum and maximum characters long.
	//                 2. Verify password should have at least 1 uppercase and 1 lowercase letter
	//                 3. Verify Password should consist of at least 1 number.
	//                 4. Verify the field must have at least 1 special character.
	//                 5. Verify if the input in the password matches with the confirm password fields.
	//                 6. Verify the error messages are shown for blank password field
	//                 7. Verify password should be Minimum 7 charater with atleast 1 uppercase, lowercase, number, andspecial character
	//Automation ID :TC04_Registration
	//</summary> 

	public void TC04_Registration() throws InterruptedException 
	{
		Registration_Obj   RegistrationObj = new Registration_Obj();
		SnipBackRegistration_TestData  snipbackregistrationtestdata = new SnipBackRegistration_TestData();
		LoginPage_Obj loginpageobj = new LoginPage_Obj();

		//Step 1 :  Click on Login button
		//Expected : User should click on login button
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to click Login button in snipback home page");

		//Step 2: Click on sign up button
		//Expected : User should click on signup button
		base.buttonClick(RegistrationObj.Btn_SignUp("signup-btn","Sign Up"));
		asrt.assertTrue(base.isExists(loginpageobj.Btn_SingnIn("btn-signup")),"User is unable to click the sign up button in the signup page");

		//Step 3 :  Verify password should be a minimum and maximum characters long.
		//Expected : There should be a pop-up message "The password should contain minimum 7 characters."
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),snipbackregistrationtestdata.TC04_RegistrationPasswrdMin);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd","missing minimum length 7")),"User is unable to find the popup message as 'Missing minimum length 7'");

		//Step 4 : Verify password should have at least 1 uppercase and 1 lowercase letter
		//Expected : There should be a pop up message as 1.'Missing numeric digits'   2.'Missing special characters (@ $ * !)'
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),snipbackregistrationtestdata.TC04_RegistrationUpperLower);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd", "missing numeric digits")) && base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd", "missing special characters (@ $ * !)")),"User is unable to find the popup messages as 'Missing numeric digits' and 'Missing special characters (@ $ * !)'");

		//Step 5 : Verify Password should consist of at least 1 number.
		//Expected : There should be a pop-up message 1."Missing lowercase letters" 2."Missing uppercase letters" 3."Missing special characters (@ $ * !)"
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),snipbackregistrationtestdata.TC04_RegistartionNumber);
		String[] ErrorMessages = {"missing lowercase letters", "missing uppercase letters", "missing special characters (@ $ * !)"};		 
		for (String Messages : ErrorMessages) 
		{ 
			asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd",Messages)), "User is not able to view the popup message as  " + Messages + "in the Signup page");
		}	

		//Step 6: Verify the field must have at least 1 special character.
		//Expected : 1. There should be a pop-up message "Special characters other than @, $, *, ! is not allowed".
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),snipbackregistrationtestdata.TC04_RegistrationSpecialNotAllowed);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd","special characters other than @, $, *, ! is not allowed")),"User is Unable to find the popup message as 'Special characters other than @, $, *, ! is not allowed'");

		//Step 6: Verify the field must have at least 1 special character.
		//Expected : "2. There should be a pop-up message "Missing numeric digits""Missing minimum length 7"
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),snipbackregistrationtestdata.TC04_RegistrationSpecialAllowed);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd", "missing numeric digits")) && base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd", "missing minimum length 7")),"User is unable to find the popup messages as 'Missing numeric digits' and 'Missing minimum length 7'");

		//Step 7 : Verify if the input in the password matches with the confirm password fields.
		//Expected : There should be a pop-up message "Passwords are not same"
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"),snipbackregistrationtestdata.TC04_RegistrationValidName);
		base.setData(loginpageobj.Edt_LoginEmail("user_email"),snipbackregistrationtestdata.TC04_registrationvalidemail);
		base.setData(loginpageobj.Edt_LoginEmail("user_name"),snipbackregistrationtestdata.TC04_RegistrationValidName);
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),snipbackregistrationtestdata.TC04_RegistrationEnteredPassword);
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),snipbackregistrationtestdata.TC04_RegistrationConfirmPassword);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Emailerror("err_cpassword")), "User is unable to find the popup message as 'Passwords are not same'");

		//Step 8 : Verify the error messages are shown for blank password field
		//Expected : There should be a pop-up message "Password is required"
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),snipbackregistrationtestdata.TC04_RegistrationEmptyPassword);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_BlankValue("textFieldslogin mb-4","err_password")),"User is unable to find the pop up message as 'Password is required'.");

		//Step 9 :Verify password should be Minimum 7 charater with atleast 1 uppercase, lowercase, number, andspecial character
		//Expected : It should accept mentioned test data.
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),snipbackregistrationtestdata.TC04_RegistrationValidPassword);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		String ActualPassword=base.GetValue(loginpageobj.Edt_LoginEmail("user_pass"));
		asrt.assertEquals(ActualPassword,snipbackregistrationtestdata.TC04_RegistrationValidPassword,"User is unable to accept the valid password");		
	}
	//<summary>
	//Test Case Title :"1. Verify password should be a minimum and maximum characters long.
	//                  2. Verify password should have at least 1 uppercase and 1 lowercase letter
	//                  3. Verify Password should consist of at least 1 number.
	//                  4. Verify the field must have at least 1 special character.
	//                  5. Verify if the input the confirm password matches with the password fields.
	//                  6. Verify the error messages are shown for blank password field
	//                  7. Verify password should be Minimum 7 character with atleast 1 uppercase, lowercase, number, andspecial character
	// Automation ID :TC05_Registration
	//</summary> 

	public void TC05_Registration() throws InterruptedException 
	{
		Registration_Obj   RegistrationObj = new Registration_Obj();
		SnipBackRegistration_TestData  snipbackregistrationtestdata = new SnipBackRegistration_TestData();
		LoginPage_Obj loginpageobj = new LoginPage_Obj();

		//Step 1 :  Click on Login button
		//Expected : User should click on login button
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to click Login button in snipback home page");

		//Step 2: Click on sign up button
		//Expected : User should click on signup button
		base.buttonClick(RegistrationObj.Btn_SignUp("signup-btn","Sign Up"));
		asrt.assertTrue(base.isExists(loginpageobj.Btn_SingnIn("btn-signup")),"User is unable to click the sign up button in the signup page");

		//Step 3 :  Verify password should be a minimum and maximum characters long.
		//Expected : There should be a pop-up message "The password should contain minimum 7 characters."
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),snipbackregistrationtestdata.TC05_RegistrationConfirmPasswordMin);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd","missing minimum length 7")),"User is unable to find the popup message as 'The password should contain minimum 7 characters.'");

		//Step 4 : Verify password should have at least 1 uppercase and 1 lowercase letter
		//Expected :1. Missing numeric digits  2. Missing special characters (@ $ * !)
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),snipbackregistrationtestdata.TC05_RegistrationUpperLowerPassword);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd", "missing numeric digits")) && base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd", "missing special characters (@ $ * !)")), "User is unable to find the popup messages in confirm password field as 'Missing numeric digits' and 'Missing special characters (@ $ * !)'");

		//Step 5 : Verify Password should consist of at least 1 number.
		//Expected : There should be a pop-up message 1."Missing lowercase letters" 2."Missing uppercase letters" 3."Missing special characters (@ $ * !)"
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),snipbackregistrationtestdata.TC05_RegistrationConfirmPasswordNumber);
		String[] ConfirmErrorMessages = {"missing lowercase letters", "missing uppercase letters", "missing special characters (@ $ * !)"};
		for (String ConfirmMessages : ConfirmErrorMessages) 
		{ 
			asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd",ConfirmMessages)), "User is not able to view the popup message as  " + ConfirmMessages + "in the Signup page");
		}

		//Step 6: Verify the field must have at least 1 special character.
		//Expected :1. There should be a pop-up message "Special characters other than @, $, *, ! is not allowed."2. There should be a pop-up message 1."Missing numeric digits" 2."Missing minimum length 7" 
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),snipbackregistrationtestdata.TC05_RegistrationNotAllowedSpecial);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd","special characters other than @, $, *, ! is not allowed")),"User is Unable to find the popup message in confirm password field as 'Special characters other than @, $, *, ! is not allowed'");

		//Step 7: Verify the field must have at least 1 special character.
		//Expected :There should be a pop-up message "Missing numeric digits""Missing minimum length 7"
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),snipbackregistrationtestdata.TC05_RegistrationAllowedSpecial);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd", "missing numeric digits")) && base.isExists(RegistrationObj.Ele_ErrorMessage("invalid-pswd", "missing minimum length 7")),"User is unable to find the popup messages in confirm password field as 'Missing numeric digits' and 'Missing minimum length 7'");

		//Step 8 : Verify if the input the confirm password matches with the password fields.
		//Expected : There should be a pop-up message "Passwords are not same"
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"),snipbackregistrationtestdata.TC05_RegistrationValidName);
		base.setData(loginpageobj.Edt_LoginEmail("user_email"),snipbackregistrationtestdata.TC05_registrationvalidemail);
		base.setData(loginpageobj.Edt_LoginEmail("user_name"),snipbackregistrationtestdata.TC05_RegistrationValidUsername);
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),snipbackregistrationtestdata.TC05_RegistrationEnteredPassword);
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),snipbackregistrationtestdata.TC05_RegistrationConfirmPasswordCorrect);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Emailerror("err_cpassword")), "User is unable to find the popup message as 'Passwords are not same'");

		//Step 9:   Verify the error messages are shown for blank password field
		//Expected : There should be a pop-up message "Password is required"
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),snipbackregistrationtestdata.TC05_RegistrationBlankConfirmPassword);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Emailerror("err_cpassword")),"User is unable to find the pop up message as 'Password is required'.");

		//Step 10:  Verify password should be Minimum 7 charater with atleast 1 uppercase, lowercase, number, and special character
		//Expected : It should accept mentioned test data.
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),snipbackregistrationtestdata.TC05_RegistrationConfirmPasswordCorrect);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		String ActualPassword=base.GetValue(loginpageobj.Edt_LoginEmail("user_confirm_password"));
		asrt.assertEquals(ActualPassword,snipbackregistrationtestdata.TC05_RegistrationConfirmPasswordCorrect,"User is unable to accept the valid password");	

	}
	//<summary>
	//Test Case Title :"1. Verify that the terms and conditions have a checkbox for users to click.
	//                  2. Verify the user should be able to register only when the terms and conditions checkbox is clicked.
	//                  3. Verify if the page displays a confirmation message after ticking the checkbox and completing the registration.
	//                  4. Verify that the terms and conditions are clearly displayed and visible on the termsof use page when we click on  Terms of Service.
	//Automation ID :TC06_Registration
	//</summary>

	public void TC06_Registration() throws InterruptedException 
	{
		Registration_Obj   RegistrationObj = new Registration_Obj();		
		LoginPage_Obj loginpageobj = new LoginPage_Obj();
		ForgotPassword_Obj   forgotpasswordobj = new ForgotPassword_Obj();

		//Step 1 :  Click on Login button
		//Expected : User should click on login button
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to click Login button in snipback home page");

		//Step 2: Click on sign up button
		//Expected : User should click on signup button
		base.buttonClick(RegistrationObj.Btn_SignUp("signup-btn","Sign Up"));
		asrt.assertTrue(base.isExists(loginpageobj.Btn_SingnIn("btn-signup")),"User is unable to click the sign up button in the signup page");

		//Step 3:Verify that the terms and conditions have a checkbox for users to click.
		//Expected :It should be accept to mentioned test datas and click signup button
		element.fillFormFields(RegistrationObj.Ele_Name("form-inlines","first_name"),SnipBackRegistration_TestData.TC06_RegistrationValidName,loginpageobj.Edt_LoginEmail("user_email"),SnipBackRegistration_TestData.TC06_RegistrationValidEmail,
				loginpageobj.Edt_LoginEmail("user_name"),SnipBackRegistration_TestData.TC06_RegistrationValidName,loginpageobj.Edt_LoginEmail("user_pass"),SnipBackRegistration_TestData.TC06_RegistrationPassword,
				loginpageobj.Edt_LoginEmail("user_confirm_password"),SnipBackRegistration_TestData.TC06_RegistrationPassword);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isEnabledBy(loginpageobj.Edt_LoginEmail("agreeterms")), "User is unable to accept the valid datas and click signup button");

		//Step 4 : Verify the user should be able to register only when the terms and conditions checkbox is clicked.
		//Expected :There should be a pop-up message "Please accept the terms of service".
		element.fillFormFields(RegistrationObj.Ele_Name("form-inlines","first_name"),SnipBackRegistration_TestData.TC06_RegistrationValidName,loginpageobj.Edt_LoginEmail("user_email"),SnipBackRegistration_TestData.TC06_RegistrationValidEmail,
				loginpageobj.Edt_LoginEmail("user_name"),SnipBackRegistration_TestData.TC06_RegistrationValidName,loginpageobj.Edt_LoginEmail("user_pass"),SnipBackRegistration_TestData.TC06_RegistrationPassword,
				loginpageobj.Edt_LoginEmail("user_confirm_password"),SnipBackRegistration_TestData.TC06_RegistrationPassword);
		base.buttonClick(loginpageobj.Edt_LoginEmail("agreeterms"));
		base.scrollToElement(loginpageobj.Btn_SingnIn("btn-signup"));
		base.excuteJsClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Emailerror("err_agreeterms")),"User is unable to find the popup message as 'Please accept the terms of service'");

		//Step 5: Verify if the page displays a confirmation message after ticking the checkbox and completing the registration.	
		//Expected : It should accept mentioned test data and redirect to enter one-time password Page.
		element.fillFormFields(RegistrationObj.Ele_Name("form-inlines","first_name"),SnipBackRegistration_TestData.TC06_RegistrationValidName,loginpageobj.Edt_LoginEmail("user_email"),SnipBackRegistration_TestData.TC06_RegistrationValidEmail,
				loginpageobj.Edt_LoginEmail("user_name"),SnipBackRegistration_TestData.TC06_RegistrationValidName,loginpageobj.Edt_LoginEmail("user_pass"),SnipBackRegistration_TestData.TC06_RegistrationPassword,
				loginpageobj.Edt_LoginEmail("user_confirm_password"),SnipBackRegistration_TestData.TC06_RegistrationPassword);
		base.excuteJsClick(loginpageobj.Edt_LoginEmail("agreeterms"));
		base.excuteJsClick(loginpageobj.Btn_SingnIn("btn-signup"));
		base.switchToWindowByIndex(driver, 0);	
		asrt.assertTrue(base.isExists(loginpageobj.Btn_SingnIn("otp-submit")),"User is unable to accept the valid datas and redirect to enter one-time password page");

		//Step 6 :Verify that the terms and conditions are clearly displayed and visible on the terms of use page when we click on  Terms of Service.
		//Expected : It Should be redirect to https://snipback.com/terms-of-use page.
		driver.navigate().back();
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		base.buttonClick(RegistrationObj.Btn_SignUp("signup-btn","Sign Up"));
		element.fillFormFields(RegistrationObj.Ele_Name("form-inlines","first_name"),SnipBackRegistration_TestData.TC06_RegistrationValidName,loginpageobj.Edt_LoginEmail("user_email"),SnipBackRegistration_TestData.TC06_RegistrationValidEmail,
				loginpageobj.Edt_LoginEmail("user_name"),SnipBackRegistration_TestData.TC06_RegistrationValidName,loginpageobj.Edt_LoginEmail("user_pass"),SnipBackRegistration_TestData.TC06_RegistrationPassword,
				loginpageobj.Edt_LoginEmail("user_confirm_password"),SnipBackRegistration_TestData.TC06_RegistrationPassword);
		base.buttonClick(loginpageobj.Btn_Login("Terms of Service"));
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(forgotpasswordobj.Ele_ResetPasswordHeading("Organization Terms of Service")),"User is unable to redirect to https://snipback.com/terms-of-use page.");
	}
	//<summary>
	//Test Case Title :"1. Verify to submit the registration without entering the OTP..
	//                  2. Verify submitting an expired OTP after the allowed time period
	//                  3. Verify the "Resend OTP" button.
	//                  4. Verify resending the OTP multiple times within a short period
	//Automation ID :TC07_Registration
	//</summary>

	public void TC07_Registration() throws InterruptedException 
	{
		Registration_Obj   RegistrationObj = new Registration_Obj();		
		LoginPage_Obj loginpageobj = new LoginPage_Obj();

		//Step 1 :  Click on Login button
		//Expected : User should click on login button
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to click Login button in snipback home page");

		//Step 2: Click on sign up button
		//Expected : User should click on signup button
		base.buttonClick(RegistrationObj.Btn_SignUp("signup-btn","Sign Up"));
		asrt.assertTrue(base.isExists(loginpageobj.Btn_SingnIn("btn-signup")),"User is unable to click the sign up button in the signup page");

		//Step 3 : Verify to submit the registration without entering the OTP.
		//Expected : There should be a pop-up message "Please enter One-time Passcode received on your email"
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"),SnipBackRegistration_TestData.TC07_RegistrationValidName);
		base.setData(loginpageobj.Edt_LoginEmail("user_email"),SnipBackRegistration_TestData.TC07_RegistrationValidEmail);
		base.setData(loginpageobj.Edt_LoginEmail("user_name"),SnipBackRegistration_TestData.TC07_RegistrationValidName);
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),SnipBackRegistration_TestData.TC07_RegistrationPassword);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),SnipBackRegistration_TestData.TC07_RegistrationPassword);			
		base.excuteJsClick(loginpageobj.Edt_LoginEmail("agreeterms"));		
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		base.buttonClick(loginpageobj.Btn_SingnIn("otp-submit"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Emailerror("signUp-err-otp")),"User is unable to view pop up message in OTP page as 'Please enter One-time Passcode received on your email'");

		//Step 4 : Verify submitting an expired OTP after the allowed time period
		//Expected : There should be a pop-up message "Invalid One-time Passcode"		
		base.setData(loginpageobj.Edt_LoginEmail("signUp-otp"),SnipBackRegistration_TestData.TC07_RegistrationOTP);
		base.buttonClick(loginpageobj.Btn_SingnIn("otp-submit"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Emailerror("otp-result")),"User is unable to view pop up message in OTP page as 'Invalid One-time Passcode'");

		//Step 5 : Verify the "Resend OTP" button.
		//Expected : There should be a pop-up message "Verification code was resent successfully"	
		base.buttonClick(RegistrationObj.Btn_ResendOTP("resend-otp-link"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Emailerror("otp-result-success")),"User is unable to view pop up message in OTP page as 'Verification code was resent successfully'");

		//Step 6: Verify resending the OTP multiple times within a short period
		//Expected : 1. There should be a pop-up message "Invalid One-time Passcode".                                                       
		base.clickMultipleTimes(RegistrationObj.Btn_ResendOTP("resend-otp-link"), 2);
		base.setData(loginpageobj.Edt_LoginEmail("signUp-otp"),SnipBackRegistration_TestData.TC07_RegistrationOTP);
		Thread.sleep(2000);
		base.buttonClick(loginpageobj.Btn_SingnIn("otp-submit"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Emailerror("otp-result")),"User is unable to view pop up message in OTP page as 'Invalid One-time Passcode'");		
	}
}


