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
}
