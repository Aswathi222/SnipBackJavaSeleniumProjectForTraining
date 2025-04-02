package testScenario.SearchGamesTeamAndMembers;
import org.testng.annotations.Test;

import testPage.MavenPageObject.CreateEditDeletePool;
import testPage.MavenPageObject.ForgotPassword;
import testPage.MavenPageObject.SearchGamesTeamAndMembers;
import utilPack.BaseTest;

public class SearchGamesTeamAndMembers_Test extends BaseTest 
{	
	@Test()
	public void TC01_SearchGamesTeamAndMembers() throws Exception 
	{	
		SearchGamesTeamAndMembers searchGamesTeamAndMembersTest = new SearchGamesTeamAndMembers(getDriver());
		searchGamesTeamAndMembersTest.TC01_SearchGamesTeamAndMembers();		
	}	
}
