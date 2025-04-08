package testScenario.SearchGamesTeamAndMembers;
import org.testng.annotations.Test;

import testPage.MavenPageObject.CreateEditDeletePool;
import testPage.MavenPageObject.ForgotPassword;
import testPage.MavenPageObject.SearchGamesTeamAndMembers;
import utilPack.BaseTest;

public class SearchGamesTeamAndMembers_Test extends BaseTest 
{	
	@Test()
	public void SH01_SearchGamesTeamAndMembersTest() throws Exception 
	{	
		SearchGamesTeamAndMembers searchGamesTeamAndMembersTest = new SearchGamesTeamAndMembers(getDriver());
		searchGamesTeamAndMembersTest.SH01_SearchGamesTeamAndMembers();		
	}	
	@Test()
	public void SH02_SearchGamesTeamAndMembersTest() throws Exception 
	{	
		SearchGamesTeamAndMembers searchGamesTeamAndMembersTest = new SearchGamesTeamAndMembers(getDriver());
		searchGamesTeamAndMembersTest.SH02_SearchGamesTeamAndMembers();		
	}	
	@Test()
	public void SH03_SearchGamesTeamAndMembersTest() throws Exception 
	{	
		SearchGamesTeamAndMembers searchGamesTeamAndMembersTest = new SearchGamesTeamAndMembers(getDriver());
		searchGamesTeamAndMembersTest.SH03_SearchGamesTeamAndMembers();		
	}	
	@Test()
	public void SH04_SearchGamesTeamAndMembersTest() throws Exception 
	{	
		SearchGamesTeamAndMembers searchGamesTeamAndMembersTest = new SearchGamesTeamAndMembers(getDriver());
		searchGamesTeamAndMembersTest.SH04_SearchGamesTeamAndMembers();		
	}
	@Test()
	public void SH05_SearchGamesTeamAndMembersTest() throws Exception 
	{	
		SearchGamesTeamAndMembers searchGamesTeamAndMembersTest = new SearchGamesTeamAndMembers(getDriver());
		searchGamesTeamAndMembersTest.SH05_SearchGamesTeamAndMembers();		
	}
	@Test()
	public void SH13_SearchGamesTeamAndMembersTest() throws Exception 
	{	
		SearchGamesTeamAndMembers searchGamesTeamAndMembersTest = new SearchGamesTeamAndMembers(getDriver());
		searchGamesTeamAndMembersTest.SH13_SearchGamesTeamAndMembers();		
	}
}
