package testScenario.ScheduleUnscheduleGames;
import org.testng.annotations.Test;

import testPage.MavenPageObject.ScheduleUnscheduleGames;
import utilPack.BaseTest;

public class ScheduleUnscheduleGames_Test extends BaseTest 
{	
	@Test()
	public void SG_01_ScheduleUnscheduleGamesTest() throws Exception 
	{	
		ScheduleUnscheduleGames scheduleUnscheduleGames = new ScheduleUnscheduleGames(getDriver());
		scheduleUnscheduleGames.SG_01_ScheduleUnscheduleGames();			
	}
	@Test()
	public void SG_02_ScheduleUnscheduleGamesTest() throws Exception 
	{	
		ScheduleUnscheduleGames scheduleUnscheduleGames = new ScheduleUnscheduleGames(getDriver());
		scheduleUnscheduleGames.SG_02_ScheduleUnscheduleGames();			
	}
}
