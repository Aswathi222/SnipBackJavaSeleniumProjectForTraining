package testScenario.TrimVideo;
import org.testng.annotations.Test;

import testPage.MavenPageObject.ArchiveorUnarchiveTeam;
import testPage.MavenPageObject.CreateEditDeletePool;
import testPage.MavenPageObject.ForgotPassword;
import testPage.MavenPageObject.SearchGamesTeamAndMembers;
import testPage.MavenPageObject.TrimVideo;
import utilPack.BaseTest;

public class TrimVideo_Test extends BaseTest 
{	
	@Test()
	public void TV_01_TrimVideoTest() throws Exception 
	{	
		TrimVideo trimVideo=new TrimVideo(getDriver());
		trimVideo.TV_01_TrimVideo();
	}	
	
}

