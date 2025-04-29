package testScenario.ArchiveorUnarchiveTeam;
import org.testng.annotations.Test;

import testPage.MavenPageObject.ArchiveorUnarchiveTeam;
import testPage.MavenPageObject.CreateEditDeletePool;
import testPage.MavenPageObject.ForgotPassword;
import testPage.MavenPageObject.SearchGamesTeamAndMembers;
import utilPack.BaseTest;

public class ArchiveorUnarchiveTeam_Test extends BaseTest 
{	
	@Test()
	public void Archive_01_ArchiveorUnarchiveTeamTest() throws Exception 
	{	
		ArchiveorUnarchiveTeam ArchiveorUnarchiveTeam=new ArchiveorUnarchiveTeam(getDriver());
		ArchiveorUnarchiveTeam.Archive_01_ArchiveorUnarchiveTeam();
	}	
	
}

