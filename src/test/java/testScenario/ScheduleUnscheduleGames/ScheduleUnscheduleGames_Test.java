package testScenario.ScheduleUnscheduleGames;

import org.testng.annotations.Test;

import testPage.MavenPageObject.CreateAddNewMemberWithEmail;
import testPage.MavenPageObject.PublicGameListing;
import testPage.MavenPageObject.ScheduleUnscheduleGames;
import utilPack.BaseTest;

public class ScheduleUnscheduleGames_Test extends BaseTest {
	
	
	@Test
    public void SG_01_ScheduleUnscheduleGamesTest() throws Exception
    {
		ScheduleUnscheduleGames scheduleUnscheduleGames  = new ScheduleUnscheduleGames(getDriver());	
		scheduleUnscheduleGames.SG_01_ScheduleUnscheduleGames();	
    }

	@Test
    public void SG_02_ScheduleUnscheduleGamesTest() throws Exception
    {
		ScheduleUnscheduleGames scheduleUnscheduleGames  = new ScheduleUnscheduleGames(getDriver());	
		scheduleUnscheduleGames.SG_02_ScheduleUnscheduleGames();	
    }
	@Test
	public void SG_06_ScheduleUnscheduleGamesTest() throws Exception
    {
		ScheduleUnscheduleGames scheduleUnscheduleGames  = new ScheduleUnscheduleGames(getDriver());	
		scheduleUnscheduleGames.SG_06_ScheduleUnscheduleGames();
    }
	@Test
    public void SG_07_ScheduleUnscheduleGamesTest() throws Exception
    {
		ScheduleUnscheduleGames scheduleUnscheduleGames  = new ScheduleUnscheduleGames(getDriver());	
		scheduleUnscheduleGames.SG_07_ScheduleUnscheduleGames();
    }
	@Test
	public void SG_08_ScheduleUnscheduleGamesTest() throws Exception
    {
		ScheduleUnscheduleGames scheduleUnscheduleGames  = new ScheduleUnscheduleGames(getDriver());	
		scheduleUnscheduleGames.SG_08_ScheduleUnscheduleGames();
    }
	@Test
	public void SG_10_ScheduleUnscheduleGamesTest() throws Exception
	{
		ScheduleUnscheduleGames scheduleUnscheduleGames  = new ScheduleUnscheduleGames(getDriver());	
		scheduleUnscheduleGames.SG_10_ScheduleUnscheduleGames();
	}
	@Test
  	public void SG_09_ScheduleUnscheduleGamesTest() throws Exception
    {
		ScheduleUnscheduleGames scheduleUnscheduleGames  = new ScheduleUnscheduleGames(getDriver());	
		scheduleUnscheduleGames.SG_09_ScheduleUnscheduleGames();
    }
    @Test
  	public void SG_03_ScheduleUnscheduleGamesTest() throws Exception
    {
    	ScheduleUnscheduleGames scheduleUnscheduleGames  = new ScheduleUnscheduleGames(getDriver());	
    	scheduleUnscheduleGames.SG_03_ScheduleUnscheduleGames();
    }
    @Test
    public void SG_04_ScheduleUnscheduleGamesTest() throws Exception
    {
    	ScheduleUnscheduleGames scheduleUnscheduleGames  = new ScheduleUnscheduleGames(getDriver());	
    	scheduleUnscheduleGames.SG_04_ScheduleUnscheduleGames();
    }
    @Test
    public void SG_05_ScheduleUnscheduleGamesTest() throws Exception
    {
    	ScheduleUnscheduleGames scheduleUnscheduleGames  = new ScheduleUnscheduleGames(getDriver());	
    	scheduleUnscheduleGames.SG_05_ScheduleUnscheduleGames();
    }
  

}
