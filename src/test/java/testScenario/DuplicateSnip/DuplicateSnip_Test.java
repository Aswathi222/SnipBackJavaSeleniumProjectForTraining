package testScenario.DuplicateSnip;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import TestData.CommonData;
import testPage.MavenPageObject.Login;
import testPage.MavenPageObject.SearchGameTeamAndMembers;
import testPage.MavenPageObject.Tags;
import testPage.MavenPageObject.AddEditInfo;
import testPage.MavenPageObject.DuplicateSnip;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class DuplicateSnip_Test extends BaseTest 
{
	@Test()
	public void Dup_01_DuplicateSnipTest() throws Exception 
	{	
		DuplicateSnip duplicateSnip = new DuplicateSnip(getDriver());	
		duplicateSnip.Dup_01_DuplicateSnip();
	}
	@Test()
	public void Dup_02_DuplicateSnipTest() throws Exception 
	{	
		DuplicateSnip duplicateSnip = new DuplicateSnip(getDriver());	
		duplicateSnip.Dup_02_DuplicateSnip();
	}
	
	@Test()
	public void Dup_03_DuplicateSnipTest() throws Exception 
	{	
		DuplicateSnip duplicateSnip = new DuplicateSnip(getDriver());	
		duplicateSnip.Dup_03_DuplicateSnip();
	}
	
	@Test()
	public void Dup_04_DuplicateSnipTest() throws Exception 
	{	
		DuplicateSnip duplicateSnip = new DuplicateSnip(getDriver());	
		duplicateSnip.Dup_04_DuplicateSnip();
	}
	
	@Test()
	public void Dup_05_DuplicateSnipTest() throws Exception 
	{	
		DuplicateSnip duplicateSnip = new DuplicateSnip(getDriver());	
		duplicateSnip.Dup_05_DuplicateSnip();
	}

}
