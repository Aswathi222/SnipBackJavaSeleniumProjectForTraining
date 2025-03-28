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
import utilPack.BasePge;
public class SnipBackRegistration extends BasePge{

	BasePge base;
	Assert asrt;

	public SnipBackRegistration(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
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
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to find signup button in login page.");

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
	/* <summary>
	Test Case Title :"1. Verify for valid email address.
	                  2. Verify for invalid email address.
	                  3. Verify if the email address shows an error message when left blank.
	                  4. Verify the field with leading/trailing spaces or extra parameters.
	                  5. Verify if the email address is duplicate/already existing in the database."
	Automation ID :TC02_Registration
	</summary>*/

	public void TC02_Registration() throws InterruptedException 
	{
		Registration_Obj   RegistrationObj = new Registration_Obj();
		LoginPage_Obj loginpageobj = new LoginPage_Obj();
		SnipBackRegistration_TestData  snipbackregistrationtestdata = new SnipBackRegistration_TestData();
		ForgotPassword_Obj forgotPasswordobj = new ForgotPassword_Obj();

		//Step 1 :  Click on Login button
		//Expected : User should click on login button
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to find signup button in login page.");

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
	/*<summary>
	Test Case Title :"1. Verify for invalid usernames with wrong characters, such as {}[]<>\/() .
                      2. Verify the username field maximum length(50) of the input characters.
	                  3. Verify if the field allows alphanumeric input as per user specifications.
	                  4. Verify if an error message is shown for using an existing username 
	                  5. Verify if the system trims the whitespace and accepts the username.
	 Automation ID :TC03_Registration
	 </summary> */

	public void TC03_Registration() throws InterruptedException 
	{
		Registration_Obj   RegistrationObj = new Registration_Obj();
		SnipBackRegistration_TestData  snipbackregistrationtestdata = new SnipBackRegistration_TestData();
		LoginPage_Obj loginpageobj = new LoginPage_Obj();
		ForgotPassword_Obj   forgotpasswordobj = new ForgotPassword_Obj();

		//Step 1 :  Click on Login button
		//Expected : User should click on login button
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to find signup button in login page.");

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
}


