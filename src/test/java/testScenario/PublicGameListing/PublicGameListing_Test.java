package testScenario.PublicGameListing;
import org.testng.annotations.Test;
import testPage.MavenPageObject.PublicGameListing;
import utilPack.BaseTest;

public class PublicGameListing_Test extends BaseTest 
{	
	@Test()
	public void GameListing_01_PublicGameListingTest() throws Exception 
	{		
		PublicGameListing publicGameListing=new PublicGameListing(getDriver());
		publicGameListing.GameListing_01_PublicGameListing();	
	}
}
