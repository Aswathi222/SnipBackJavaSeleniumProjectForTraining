package testScenario.AddorEditInfo;
import org.testng.annotations.Test;

import testPage.MavenPageObject.AddorEditInfo;
import testPage.MavenPageObject.CreateEditDeletePool;
import testPage.MavenPageObject.ForgotPassword;
import testPage.MavenPageObject.SearchGamesTeamAndMembers;
import utilPack.BaseTest;

public class AddorEditInfo_Test extends BaseTest 
{	
	@Test()
	public void AI_01_AddorEditInfoTest() throws Exception 
	{	
		AddorEditInfo AddorEditInfoTest=new AddorEditInfo(getDriver());
		AddorEditInfoTest.AI_01_AddEditInfo();
	}	
	@Test()
	public void AI_02_AddorEditInfoTest() throws Exception 
	{	
		AddorEditInfo AddorEditInfoTest=new AddorEditInfo(getDriver());
		AddorEditInfoTest.AI_02_AddEditInfo();
	}
	@Test()
	public void AI_03_AddorEditInfoTest() throws Exception 
	{	
		AddorEditInfo AddorEditInfoTest=new AddorEditInfo(getDriver());
		AddorEditInfoTest.AI_03_AddEditInfo();
	}
	@Test()
	public void AI_04_AddorEditInfoTest() throws Exception 
	{	
		AddorEditInfo AddorEditInfoTest=new AddorEditInfo(getDriver());
		AddorEditInfoTest.AI_04_AddEditInfo();
	}
	@Test()
	public void AI_05_AddorEditInfoTest() throws Exception 
	{	
		AddorEditInfo AddorEditInfoTest=new AddorEditInfo(getDriver());
		AddorEditInfoTest.AI_05_AddEditInfo();
	}
}

