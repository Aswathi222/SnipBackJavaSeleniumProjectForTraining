package testPage.MavenPageObject;
import TestData.SnipBackRegistration_TestData;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
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

	public void TC01_Registration() 
	{
		Registration_Obj   RegistrationObj = new Registration_Obj();
		SnipBackRegistration_TestData  snipbackregistrationtestdata = new SnipBackRegistration_TestData();
		LoginPage_Obj loginpageobj = new LoginPage_Obj();

		//Step 1 :  Click on Login button
		//Expected : User should click on login button
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to find sign up button.");

		//Step 2: Click on sign up button
		//Expected : User should click on signup button
		base.buttonClick(RegistrationObj.Btn_SignUp("signup-btn","Sign Up"));
		asrt.assertTrue(base.isExists(loginpageobj.Btn_SingnIn("btn-signup")),"User is unable to click the sign up button'.");

		//Step 3 : Verify if the name field is mandatory or shows an error message when left blank.
		//Expected : There should be a pop-up message "Please enter ur name"
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"), SnipBackRegistration_TestData.TC01_RegistrationInvalidName);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(loginpageobj.Btn_SingnIn("btn-signup")),"User is unable to find the pop up message as 'Please enter your name'.");

		//Step 4 : Verify if the field shows error message for numbers and special characters entry
		//Expected : There should be a pop-up message "Name field must only contain letters "
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"),SnipBackRegistration_TestData.TC01_RegistrationInvalidCharName);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(loginpageobj.Btn_SingnIn("btn-signup")),"User is unable to find the pop up message as 'Name field must only contain letters'.");

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

	public void TC02_Registration()
	{
		Registration_Obj   RegistrationObj = new Registration_Obj();
		LoginPage_Obj loginpageobj = new LoginPage_Obj();
		SnipBackRegistration_TestData  snipbackregistrationtestdata = new SnipBackRegistration_TestData();

		//Step 1 :  Click on Login button
		//Expected : User should click on login button
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to find sign up button.");

		//Step 2: Click on sign up button
		//Expected : User should click on signup button
		base.buttonClick(RegistrationObj.Btn_SignUp("signup-btn","Sign Up"));
		asrt.assertTrue(base.isExists(loginpageobj.Btn_SingnIn("btn-signup")),"User is unable to click the sign up button'.");

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
		asrt.assertTrue(base.isExists(loginpageobj.Edt_LoginEmail("user_email")),"User is unable to find the popup message as 'Please enter the valid email, the invalid characters are &/\\#,+()$~%.^':*?<>{}\"'");

		//Step 5 : Verify if the email address shows an error message when left blank.
		//Expected : There should be a pop-up message "Please enter your email address"
		base.setData(loginpageobj.Edt_LoginEmail("user_email"), SnipBackRegistration_TestData.TC02_RegistrationEmailEmpty);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(loginpageobj.Edt_LoginEmail("user_email")),"User is unable to find the popup message as 'Please enter your email address'");

		//Step 6 :  Verify the field with leading/trailing spaces or extra parameters.
		//Expected : There should be a pop-up message " a part followed by '@' should not contain the     symbol ' ' ','.
		base.setData(loginpageobj.Edt_LoginEmail("user_email"), SnipBackRegistration_TestData.TC02_RegistrationExtraEmail);
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(loginpageobj.Edt_LoginEmail("user_email")),"User is unable to find the popup message as 'A part followed by '@' should not contain the symbol ' ' ','.'");

		//Step 7 :  Verify if the email address is duplicate/already existing in the database.
		//Expected : There should be a pop-up message "Email already exist"
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"),SnipBackRegistration_TestData.TC02_RegistrationValidName);
		base.setData(loginpageobj.Edt_LoginEmail("user_email"),SnipBackRegistration_TestData.TC02_RegistrationValidEmail);
		base.setData(loginpageobj.Edt_LoginEmail("user_name"),SnipBackRegistration_TestData.TC02_RegistrationValidUsername);
		base.setData(loginpageobj.Edt_LoginEmail("user_pass"),SnipBackRegistration_TestData.TC02_RegistrationPassword);
		base.setData(loginpageobj.Edt_LoginEmail("user_confirm_password"),SnipBackRegistration_TestData.TC02_RegistrationPassword);
		base.buttonClick(loginpageobj.Edt_LoginEmail("agreeterms"));		
		base.buttonClick(loginpageobj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_AlreadyExist("formWrap custom-signup","User already exists")),"User is unable to fine the pop up as 'Email already exist'");
	}
}


