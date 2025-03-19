package testScenario.Registration;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestData.CommonData;
import testPage.MavenPageObject.Login;
import testPage.MavenPageObject.Registration;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class Registration_Test extends BaseTest 
{	
	@Test()
	public void SignUp_RegistrationTest() throws Exception 
	{	
		Registration registration = new Registration(getDriver());	
		registration.SignUp();			
	}
	@Test()
	public void TC01_RegistrationTest() throws Exception 
	{	
		Registration registration = new Registration(getDriver());	
		registration.TC01_Registration();			
	}
	@Test()
	public void TC02_RegistrationTest() throws Exception 
	{	
		Registration registration = new Registration(getDriver());	
		registration.TC02_Registration();			
	}
	
	@Test()
	public void TC03_RegistrationTest() throws Exception 
	{	
		Registration registration = new Registration(getDriver());
		registration.TC03_Registration();
	}

	@Test()
	public void TC04_RegistrationTest() throws Exception 
	{	
		Registration registration = new Registration(getDriver());	
		registration.TC04_Registration();			
	}

	@Test()
	public void TC05_RegistartionTest() throws Exception 
	{	
		Registration registration = new Registration(getDriver());	
		registration.TC05_Registration();
	}

	@Test()
	public void TC07_RegistrationTest() throws  InterruptedException
	{
		Registration registration = new Registration(getDriver());
		registration.TC07_Registration();
	}
	
	@Test()
	public void TC06_RegistrationTest() throws InterruptedException
	{
		Registration registration = new Registration(getDriver());
		registration.TC06_Registration();
	}

}