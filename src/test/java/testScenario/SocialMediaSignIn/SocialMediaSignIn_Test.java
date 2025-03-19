package testScenario.SocialMediaSignIn;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestData.CommonData;
import testPage.MavenPageObject.Login;
import testPage.MavenPageObject.SocialMediaSignIn;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class SocialMediaSignIn_Test extends BaseTest 
{		
	@Test()
	public void TC_01_SocialMediaSignInTest() throws Exception 
	{	
		SocialMediaSignIn socialMediaSignIn = new SocialMediaSignIn(getDriver());
		socialMediaSignIn.TC_01_SocialMediaSignIn();
	}
	
	@Test()
	public void TC_02_SocialMediaSignInTest() throws Exception 
	{	
		SocialMediaSignIn socialMediaSignIn = new SocialMediaSignIn(getDriver());
		socialMediaSignIn.TC_02_SocialMediaSignIn();
	}


	
}
