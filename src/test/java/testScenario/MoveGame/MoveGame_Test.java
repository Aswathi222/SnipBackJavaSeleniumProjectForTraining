package testScenario.MoveGame;

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
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class MoveGame_Test extends BaseTest 
{		

	@Test()
	public void TC_04_MoveGameTest() throws Exception 
	{	
		MoveGame movegame = new MoveGame(getDriver());	
		movegame.TC_04_MoveGame();
	}
	@Test()
	public void TC_05_MoveGameTest() throws Exception 
	{	
		MoveGame movegame = new MoveGame(getDriver());	
		movegame.TC_05_MoveGame();
	}
	@Test()
	public void TC_06_MoveGameTest() throws Exception 
	{	
		MoveGame movegame = new MoveGame(getDriver());	
		movegame.TC_06_MoveGame();
	}
	@Test()
	public void TC_07_MoveGameTest() throws Exception 
	{	
		MoveGame movegame = new MoveGame(getDriver());	
		movegame.TC_07_MoveGame();
	}
	@Test()
	public void TC_08_MoveGameTest() throws Exception 
	{	
		MoveGame movegame = new MoveGame(getDriver());	
		movegame.TC_08_MoveGame();
	}
	@Test()
	public void TC_09_MoveGameTest() throws Exception 
	{	
		MoveGame movegame = new MoveGame(getDriver());	
		movegame.TC_09_MoveGame();
	}
	@Test()
	public void TC_10_MoveGameTest() throws Exception 
	{	
		MoveGame movegame = new MoveGame(getDriver());	
		movegame.TC_10_MoveGame();
	}
	
	@Test()
	public void TC_01_MoveGameTest() throws Exception 
	{	
		MoveGame movegame = new MoveGame(getDriver());	
		movegame.TC_01_MoveGame();
	}
	
	@Test()
	public void TC_02_MoveGameTest() throws Exception 
	{	
		MoveGame movegame = new MoveGame(getDriver());	
		movegame.TC_02_MoveGame();
	}
	@Test()
	public void TC_03_MoveGameTest() throws Exception 
	{	
		MoveGame movegame = new MoveGame(getDriver());	
		movegame.TC_03_MoveGame();
	}
	@Test()
	public void TC_11_MoveGameTest() throws Exception 
	{	
		MoveGame movegame = new MoveGame(getDriver());	
		movegame.TC_11_MoveGame();
	}
	@Test()
	public void TC_12_MoveGameTest() throws Exception 
	{	
		MoveGame movegame = new MoveGame(getDriver());	
		movegame.TC_12_MoveGame();
	}

}
