package testScenario.ForgotPassword;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestData.CommonData;
import testPage.MavenPageObject.Login;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class ForgotPassword_Test extends BaseTest 
{		

	@Test()
	public void FP_1_ForgotPasswordTest() throws Exception 
	{	
		ForgotPassword forgotPassword = new ForgotPassword(getDriver());	
		forgotPassword.FP_1_ForgotPassword();
	}

	@Test()
	public void FP_4_ForgotPasswordTest() throws Exception 
	{	
		ForgotPassword forgotPassword = new ForgotPassword(getDriver());	
		forgotPassword.FP_4_ForgotPassword();
	}
	
	@Test()
	public void FP_2_ForgotPasswordTest() throws Exception 
	{	
		ForgotPassword forgotPassword = new ForgotPassword(getDriver());	
		forgotPassword.FP_2_ForgotPassword();
	}
	@Test()
	public void FP_3_ForgotPasswordTest() throws Exception 
	{	
		ForgotPassword forgotPassword = new ForgotPassword(getDriver());	
		forgotPassword.FP_3_ForgotPassword();
	}

	@Test()
	public void FP_5_ForgotPasswordTest() throws Exception 
	{	
		ForgotPassword forgotPassword = new ForgotPassword(getDriver());	
		forgotPassword.FP_5_ForgotPassword();			
	}
}
