package testScenario.DeleteSnipPlayer;

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
import testPage.MavenPageObject.DeleteSnipPlayer;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class DeleteSnipPlayer_Test extends BaseTest 
{		
	@Test()
	public void Delete_01_DeleteSnipTest() throws Exception 
	{	
		DeleteSnipPlayer deletesnipplayer = new DeleteSnipPlayer(getDriver());	
		deletesnipplayer.Delete_01_DeleteSnip();
	}
	@Test()
	public void Delete_02_DeleteSnipTest() throws Exception 
	{	
		DeleteSnipPlayer deletesnipplayer = new DeleteSnipPlayer(getDriver());	
		deletesnipplayer.Delete_02_DeleteSnip();
	}
	@Test()
	public void Delete_03_DeleteSnipTest() throws Exception 
	{	
		DeleteSnipPlayer deletesnipplayer = new DeleteSnipPlayer(getDriver());	
		deletesnipplayer.Delete_03_DeleteSnip();
	}
	@Test()
	public void Delete_04_DeleteSnipTest() throws Exception 
	{	
		DeleteSnipPlayer deletesnipplayer = new DeleteSnipPlayer(getDriver());	
		deletesnipplayer.Delete_04_DeleteSnip();
	}
}
