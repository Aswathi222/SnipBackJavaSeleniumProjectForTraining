package testScenario.SocialMediaSignIn;

import org.testng.annotations.Test;

import testPage.MavenPageObject.SocialMediaSignIn;
import utilPack.BaseTest;

public class SocialMediaSignIn_Test extends BaseTest{
	@Test()
	public void TC_01SocialMediaSignIn_Test() throws Exception 
	{	
		SocialMediaSignIn socialMediaSignIn = new SocialMediaSignIn(getDriver());	
		socialMediaSignIn.TC_01SocialMediaSignIn();			
	}

	@Test()
	public void TC_02SocialMediaSignIn_Test() throws Exception 
	{	
		SocialMediaSignIn socialMediaSignIn = new SocialMediaSignIn(getDriver());	
		socialMediaSignIn.TC_02SocialMediaSignIn();			
	}
}
