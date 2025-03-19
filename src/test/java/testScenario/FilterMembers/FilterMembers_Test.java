package testScenario.FilterMembers;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import TestData.CommonData;
import testPage.MavenPageObject.Login;
import testPage.MavenPageObject.SearchGameTeamAndMembers;
import testPage.MavenPageObject.AddEditInfo;
import testPage.MavenPageObject.FilterMembers;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class FilterMembers_Test extends BaseTest 
{		

	@Test()
	public void FM_01_FilterMembersTest() throws Exception 
	{	
		FilterMembers filterMembers = new FilterMembers(getDriver());	
		filterMembers.FM_01_FilterMembers();
	}

	@Test()
	public void FM_02_FilterMembersTest() throws Exception 
	{	
		FilterMembers filterMembers = new FilterMembers(getDriver());	
		filterMembers.FM_02_FilterMembers();
	}
	
	@Test()
	public void FM_03_FilterMembersTest() throws Exception 
	{	
		FilterMembers filterMembers = new FilterMembers(getDriver());	
		filterMembers.FM_03_FilterMembers();
	}

	@Test()
	public void FM_04_FilterMembersTest() throws Exception 
	{	
		FilterMembers filterMembers = new FilterMembers(getDriver());	
		filterMembers.FM_04_FilterMembers();
	}
	
	@Test()
	public void FM_05_FilterMembersTest() throws Exception 
	{	
		FilterMembers filterMembers = new FilterMembers(getDriver());	
		filterMembers.FM_05_FilterMembers();
	}

	@Test()
	public void FM_06_FilterMembersTest() throws Exception 
	{	
		FilterMembers filterMembers = new FilterMembers(getDriver());	
		filterMembers.FM_06_FilterMembers();
	}
}
