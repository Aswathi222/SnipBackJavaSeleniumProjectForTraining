package testScenario.SocialMediaSignIn;
import org.testng.annotations.Test;
import testPage.MavenPageObject.SnipBackLogin;
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
}