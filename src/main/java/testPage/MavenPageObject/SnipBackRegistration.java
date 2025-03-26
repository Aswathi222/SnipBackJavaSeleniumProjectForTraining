package testPage.MavenPageObject;
import TestData.SnipBackRegistration_TestData;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
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

		//Step 1 :  Click on Login button
		//Expected : User should click on login button
		base.buttonClick(RegistrationObj.Btn_Login("nav-link btn btn-white sm", "Login"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SignUp("signup-btn","Sign Up")),"User unable to find sign up button.");

		//Step 2: Click on sign up button
		//Expected : User should click on signup button
		base.buttonClick(RegistrationObj.Btn_SignUp("signup-btn","Sign Up"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SigUp1("btn-signup")),"User is unable to click the sign up button'.");

		//Step 3 : Verify if the name field is mandatory or shows an error message when left blank.
		//Expected : There should be a pop-up message "Please enter ur name"
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"), SnipBackRegistration_TestData.TC01_RegistrationInvalidName);
		base.buttonClick(RegistrationObj.Btn_SigUp1("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SigUp1("btn-signup")),"User is unable to find the pop up message as 'Please enter your name'.");

		//Step 4 : Verify if the field shows error message for numbers and special characters entry
		//Expected : There should be a pop-up message "Name field must only contain letters "
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"),SnipBackRegistration_TestData.TC01_RegistrationInvalidCharName);
		base.buttonClick(RegistrationObj.Btn_SigUp1("btn-signup"));
		asrt.assertTrue(base.isExists(RegistrationObj.Btn_SigUp1("btn-signup")),"User is unable to find the pop up message as 'Name field must only contain letters'.");

		//Step5 : Verify if the name field uses only alphabets
		//Expected : It should accept mentioned test data.
		base.setData(RegistrationObj.Ele_Name("form-inlines","first_name"),SnipBackRegistration_TestData.TC01_RegistrationValidName);
		base.buttonClick(RegistrationObj.Btn_SigUp1("btn-signup"));	
		String ActualUsername= base.GetValue(RegistrationObj.Ele_Name("form-inlines","first_name"));
		asrt.assertEquals(ActualUsername,SnipBackRegistration_TestData.TC01_RegistrationValidName,"User is unable to accept the valid name");
	}



}


