package testScenario.DownloadSnip;

import org.testng.annotations.Test;

import testPage.MavenPageObject.DownloadSnip;
import utilPack.BaseTest;

public class DownloadSnip_Test extends BaseTest 
{		

	@Test()
	public void DS_01_DownloadSnipPlayerPageTest() throws Exception 
	{	
		DownloadSnip DS = new DownloadSnip(getDriver());	
		DS.DS_01_DownloadSnipPlayerPage();
	}
	
	@Test()
	public void DS_02_DownloadSnipPlayerPageTest() throws Exception 
	{	
		DownloadSnip DS = new DownloadSnip(getDriver());	
		DS.DS_02_DownloadSnipPlayerPage();
	}
	
	@Test()
	public void DS_04_DownloadSnipPlayerPageTest() throws Exception 
	{	
		DownloadSnip DS = new DownloadSnip(getDriver());	
		DS.DS_04_DownloadSnipPlayerPage();
	}
	
	@Test()
	public void DS_06_DownloadSnipPlayerPageTest() throws Exception 
	{	
		DownloadSnip DS = new DownloadSnip(getDriver());	
		DS.DS_06_DownloadSnipPlayerPage();
	}
	
	@Test()
	public void DS_03_DownloadSnipPlayerPageTest() throws Exception 
	{	
		DownloadSnip DS = new DownloadSnip(getDriver());	
		DS.DS_03_DownloadSnipPlayerPage();
	}
	
	@Test()
	public void DS_05_DownloadSnipPlayerPageTest() throws Exception 
	{	
		DownloadSnip DS = new DownloadSnip(getDriver());	
		DS.DS_05_DownloadSnipPlayerPage();
	}
	@Test()
	public void DS_07_DownloadSnipPlayerPageTest() throws Exception 
	{	
		DownloadSnip DS = new DownloadSnip(getDriver());	
		DS.DS_07_DownloadSnipPlayerPage();
	}
}
