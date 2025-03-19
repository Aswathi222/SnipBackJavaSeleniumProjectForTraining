package testScenario.LikeGame;

import org.testng.annotations.Test;

import testPage.MavenPageObject.LikeGame;
import testPage.MavenPageObject.Tags;
import utilPack.BaseTest;

public class LikeGame_Test extends BaseTest 
{		

	@Test()
	public void LG_1_LikeGamePlayerPageTest() throws Exception 
	{	
		LikeGame LG = new LikeGame(getDriver());	
		LG.LG_1_LikeGamePlayerPage();
	}

	@Test()
	public void LG_2_LikeGamePlayerPageTest() throws Exception 
	{	
		LikeGame LG = new LikeGame(getDriver());	
		LG.LG_2_LikeGamePlayerPage();
	}

	@Test()
	public void LG_3_LikeGamePlayerPageTest() throws Exception 
	{	
		LikeGame LG = new LikeGame(getDriver());	
		LG.LG_3_LikeGamePlayerPage();
	}
	
	@Test()
	public void LG_4_LikeGamePlayerPageTest() throws Exception 
	{	
		LikeGame LG = new LikeGame(getDriver());	
		LG.LG_4_LikeGamePlayerPage();
	}
	
	@Test()
	public void LG_5_LikeGamePlayerPageTest() throws Exception 
	{	
		LikeGame LG = new LikeGame(getDriver());	
		LG.LG_5_LikeGamePlayerPage();
	}
	
	@Test()
	public void LG_6_LikeGamePlayerPageTest() throws Exception 
	{	
		LikeGame LG = new LikeGame(getDriver());	
		LG.LG_6_LikeGamePlayerPage();
	}
}
