package testScenario.DownlaodGamePlayer;

import org.testng.annotations.Test;

import testPage.MavenPageObject.DownloadGamePlayer;
import utilPack.BaseTest;

public class DownloadGamePlayer_Test extends BaseTest
{
	@Test()
	public void DG_1_DownloadGamePlayerPageTest() throws Exception 
	{	
		DownloadGamePlayer downloadgameplayer = new DownloadGamePlayer(getDriver());	
		downloadgameplayer.DG_1_DownloadGamePlayerPage();
	}
	@Test()
	public void DG_2_DownloadGamePlayerPageTest() throws Exception 
	{	
		DownloadGamePlayer downloadgameplayer = new DownloadGamePlayer(getDriver());	
		downloadgameplayer.DG_2_DownloadGamePlayerPage();
	}
	@Test()
	public void DG_3_DownloadGamePlayerPageTest() throws Exception 
	{	
		DownloadGamePlayer downloadgameplayer = new DownloadGamePlayer(getDriver());	
		downloadgameplayer.DG_3_DownloadGamePlayerPage();
	}
	@Test()
	public void DG_4_DownloadGamePlayerPageTest() throws Exception 
	{	
		DownloadGamePlayer downloadgameplayer = new DownloadGamePlayer(getDriver());	
		downloadgameplayer.DG_4_DownloadGamePlayerPage();
	}
}
