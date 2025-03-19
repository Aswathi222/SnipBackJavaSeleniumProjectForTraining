package testScenario.CopyVideoURLPlayer;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import TestData.CommonData;
import testPage.MavenPageObject.Login;
import testPage.MavenPageObject.MoveGame;
import testPage.MavenPageObject.SearchGameTeamAndMembers;
import testPage.MavenPageObject.AddEditInfo;
import testPage.MavenPageObject.AddUpdateRemoveMember;
import testPage.MavenPageObject.CopyVideoURLPlayer;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class CopyVideoURLPlayer_Test extends BaseTest 
{		

	@Test()
	public void CV_1_CopyVideoURLPlayerPageTest() throws Exception 
	{	
		CopyVideoURLPlayer copyvideoURLplayer = new CopyVideoURLPlayer(getDriver());	
		copyvideoURLplayer.CV_1_CopyVideoURLPlayerPage();
	}
	@Test()
	public void CV_2_CopyVideoURLPlayerPageTest() throws Exception 
	{	
		CopyVideoURLPlayer copyvideoURLplayer = new CopyVideoURLPlayer(getDriver());	
		copyvideoURLplayer.CV_2_CopyVideoURLPlayerPage();
	}
	@Test()
	public void CV_3_CopyVideoURLPlayerPageTest() throws Exception 
	{	
		CopyVideoURLPlayer copyvideoURLplayer = new CopyVideoURLPlayer(getDriver());	
		copyvideoURLplayer.CV_3_CopyVideoURLPlayerPage();
	}
}
