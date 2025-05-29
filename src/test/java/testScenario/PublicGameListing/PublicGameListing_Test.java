package testScenario.PublicGameListing;
import org.testng.annotations.Test;
import testPage.MavenPageObject.PublicGameListing;
import testPage.MavenPageObject.SnipBackLogin;
import utilPack.BaseTest;

public class PublicGameListing_Test extends BaseTest {	
	@Test()
	public void TC01_PublicGameListingTest() throws Exception 
	{	
		PublicGameListing GameLogin = new PublicGameListing(getDriver());      
		GameLogin.TC01_PublicGameListing();   		
	}
}