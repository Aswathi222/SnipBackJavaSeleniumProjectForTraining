package testScenario.WhiteboardPlayer;

import org.testng.annotations.Test;

import testPage.MavenPageObject.WhiteboardPlayer;
import utilPack.BaseTest;

public class WhiteboardPlayer_Test extends BaseTest  {

	
	@Test
	public void WB_01_WhiteBoardTest() throws Exception 
	{
		WhiteboardPlayer whiteboardPlayer = new WhiteboardPlayer(getDriver());	
		whiteboardPlayer.WB_01_WhiteBoard();
	}
	@Test()
	public void WB_14_WhiteBoardTest() throws Exception 
	{	
		WhiteboardPlayer whiteboardplayer = new WhiteboardPlayer(getDriver());	
		whiteboardplayer.WB_14_WhiteBoard();
	}
	@Test()
	public void WB_15_WhiteBoardTest() throws Exception 
	{	
		WhiteboardPlayer whiteboardplayer = new WhiteboardPlayer(getDriver());	
		whiteboardplayer.WB_15_WhiteBoard();
	}
	@Test()
	public void WB_16_WhiteBoardTest() throws Exception 
	{	
		WhiteboardPlayer whiteboardplayer = new WhiteboardPlayer(getDriver());	
		whiteboardplayer.WB_16_WhiteBoard();
	}
	@Test()
	public void WB_18_WhiteBoardTest() throws Exception 
	{	
		WhiteboardPlayer whiteboardplayer = new WhiteboardPlayer(getDriver());	
		whiteboardplayer.WB_18_WhiteBoard();
	}
	@Test()
	public void WB_20_WhiteBoardTest() throws Exception 
	{	
		WhiteboardPlayer whiteboardplayer = new WhiteboardPlayer(getDriver());	
		whiteboardplayer.WB_20_WhiteBoard();
	}
	@Test()
	public void WB_19_WhiteBoardTest() throws Exception 
	{	
		WhiteboardPlayer whiteboardplayer = new WhiteboardPlayer(getDriver());	
		whiteboardplayer.WB_19_WhiteBoard();
	}
}
