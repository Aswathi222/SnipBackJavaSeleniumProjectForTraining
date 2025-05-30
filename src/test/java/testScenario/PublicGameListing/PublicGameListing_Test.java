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
	@Test()
	public void TC02_PublicGameListingTest() throws Exception 
	{	
		PublicGameListing GameLogin = new PublicGameListing(getDriver());      
		GameLogin.TC02_PublicGameListing();
}
	@Test()
	public void TC03_PublicGameListingTest() throws Exception 
	{	
		PublicGameListing filmtab = new PublicGameListing(getDriver());      
		filmtab.TC03_PublicGameListing();
}
	@Test()
	public void TC09_PublicGameListingTest() throws Exception 
	{	
		PublicGameListing filmtab = new PublicGameListing(getDriver());      
		filmtab.TC09_PublicGameListing();
}
	@Test()
	public void TC11_PublicGameListingTest() throws Exception 
	{	
		PublicGameListing filmtab = new PublicGameListing(getDriver());      
		filmtab.TC11_PublicGameListing();
}
}