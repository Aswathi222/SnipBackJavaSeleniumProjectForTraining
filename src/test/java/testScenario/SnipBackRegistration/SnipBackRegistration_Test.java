package testScenario.SnipBackRegistration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testPage.MavenPageObject.SnipBackRegistration;
import utilPack.BaseTest;

public class SnipBackRegistration_Test extends BaseTest {
	@Test()
	public void TC01_RegistrationTest() throws Exception 
	{	
		SnipBackRegistration snipbackregistration = new SnipBackRegistration(getDriver());	
		snipbackregistration.TC01_Registration();			
	}
	@Test()
	public void TC02_RegistrationTest() throws Exception 
	{	
		SnipBackRegistration snipbackregistration = new SnipBackRegistration(getDriver());	
		snipbackregistration.TC02_Registration();			
	}
	@Test()
	public void TC03_RegistrationTest() throws Exception 
	{	
		SnipBackRegistration snipbackregistration = new SnipBackRegistration(getDriver());	
		snipbackregistration.TC03_Registration();			
	}
	@Test()
	public void TC04_RegistrationTest() throws Exception 
	{	
		SnipBackRegistration snipbackregistration = new SnipBackRegistration(getDriver());	
		snipbackregistration.TC04_Registration();			
	}
	@Test()
	public void TC05_Registration() throws Exception 
	{	
		SnipBackRegistration snipbackregistration = new SnipBackRegistration(getDriver());	
		snipbackregistration.TC05_Registration();			
	}
	@Test()
	public void TC06_RegistrationTest() throws Exception 
	{	
		SnipBackRegistration snipbackregistration = new SnipBackRegistration(getDriver());	
		snipbackregistration.TC06_Registration();			
	}


}
