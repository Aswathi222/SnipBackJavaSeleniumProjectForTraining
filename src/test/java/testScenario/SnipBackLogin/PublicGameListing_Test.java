package testScenario.SnipBackLogin;
import org.testng.annotations.Test;

import testPage.MavenPageObject.PublicGameListing;
import testPage.MavenPageObject.SnipBackLogin;
import utilPack.BaseTest;

public class PublicGameListing_Test extends BaseTest 

{	

	
	@Test()
	public void TC01_PublicGameListingTest() throws Exception 
	{	
		PublicGameListing GameLogin = new PublicGameListing(getDriver());      //method return in basetest class,return type is a WebDriver (from Selenium).
		GameLogin.TC01_PublicGameListing();   //calling our method using object of our created class
		
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
	@Test()
	public void TC12_PublicGameListingTest() throws Exception 
	{	
		PublicGameListing filmtab = new PublicGameListing(getDriver());      
		filmtab.TC12_PublicGameListing();
}
	@Test()
	public void TC17_PublicGameListingTest() throws Exception 
	{	
		PublicGameListing filmtab = new PublicGameListing(getDriver());      
		filmtab.TC17_PublicGameListing();
}
}
