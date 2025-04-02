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
	@Test()
	public void SG_03_ScheduleUnscheduleGamesTest() throws Exception 
	{	
		ScheduleUnscheduleGames scheduleUnscheduleGames = new ScheduleUnscheduleGames(getDriver());
		scheduleUnscheduleGames.SG_03_ScheduleUnscheduleGames();			
	}
	@Test()
	public void SG_04_ScheduleUnscheduleGamesTest() throws Exception 
	{	
		ScheduleUnscheduleGames scheduleUnscheduleGames = new ScheduleUnscheduleGames(getDriver());
		scheduleUnscheduleGames.SG_04_ScheduleUnscheduleGames();			
	}
}
