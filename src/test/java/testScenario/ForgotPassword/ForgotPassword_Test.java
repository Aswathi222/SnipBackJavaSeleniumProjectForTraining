package testScenario.ForgotPassword;
import org.testng.annotations.Test;

import testPage.MavenPageObject.ForgotPassword;
import testPage.MavenPageObject.SnipBackLogin;
import utilPack.BaseTest;


public class ForgotPassword_Test extends BaseTest 

{	

	@Test()
	public void TC01_ForgotPasswordTest() throws Exception 
	{	
		ForgotPassword forgotpassword = new ForgotPassword(getDriver());
		forgotpassword.TC01_ForgotPassword();

	}

	@Test()
	public void TC02_ForgotPasswordTest() throws Exception

	{	
		ForgotPassword forgotpassword = new ForgotPassword(getDriver());
		forgotpassword.TC02_ForgotPassword();

	}

	@Test()
	public void TC04_ForgotPasswordTest() throws Exception

	{	
		ForgotPassword forgotpassword = new ForgotPassword(getDriver());
		forgotpassword.TC04_ForgotPassword();

	}
}
