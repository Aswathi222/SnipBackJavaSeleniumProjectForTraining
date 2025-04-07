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
	
	@Test()
	public void GameListing_02_PublicGameListingTest() throws Exception 
	{		
		PublicGameListing publicGameListing=new PublicGameListing(getDriver());
		publicGameListing.GameListing_02_PublicGameListing();	
	}
	@Test()
	public void GameListing_03_PublicGameListingTest() throws Exception 
	{		
		PublicGameListing publicGameListing=new PublicGameListing(getDriver());
		publicGameListing.GameListing_03_PublicGameListing();	
	}
	@Test()
	public void GameListing_04_PublicGameListingTest() throws Exception 
	{		
		PublicGameListing publicGameListing=new PublicGameListing(getDriver());
		publicGameListing.GameListing_04_PublicGameListing();	
	}
	@Test()
	public void GameListing_05_PublicGameListingTest() throws Exception 
	{		
		PublicGameListing publicGameListing=new PublicGameListing(getDriver());
		publicGameListing.GameListing_05_PublicGameListing();	
	}
}

