package testScenario.SocialMediaSignIn;
import org.testng.annotations.Test;
import testPage.MavenPageObject.SocialMediaSignIn;
import utilPack.BaseTest;

public class SocialMediaSignIn_Test extends BaseTest
{
	@Test()
	public void TC01_SocialMediaSignIn() throws Exception
	{
		SocialMediaSignIn SignIn = new SocialMediaSignIn(getDriver());
		SignIn.TC01_SocialMediaSignIn();	
	}
	
	@Test()
	public void TC04_SocialMediaSignIn() throws Exception 
	{	
		SocialMediaSignIn SignIn = new SocialMediaSignIn(getDriver());
		SignIn.TC04_SocialMediaSignIn();		
	}
}