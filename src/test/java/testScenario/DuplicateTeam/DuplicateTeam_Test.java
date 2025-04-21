package testScenario.DuplicateTeam;

import org.testng.annotations.Test;

import testPage.MavenPageObject.DuplicateTeam;
import utilPack.BaseTest;

public class DuplicateTeam_Test extends BaseTest 
{	
	@Test()
	public void DT_01_DuplicateTeamTest() throws Exception 
	{	
		DuplicateTeam duplicateteam = new DuplicateTeam(getDriver());
		duplicateteam.DT_01_DuplicateTeam();			
	}

}
