package testScenario.TeamInviteLink;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestData.CommonData;
import testPage.MavenPageObject.Login;
import testPage.MavenPageObject.TeamInviteLink;
import testPage.MavenPageObject.ViewProfile;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class TeamInviteLink_Test extends BaseTest
{
	@Test()
	public void Invitelink_01_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink TeamInviteLink = new TeamInviteLink(getDriver());	
		TeamInviteLink.Invitelink_01_TeamInviteLink();	
	}
	
	@Test()
	public void Invitelink_02_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink TeamInviteLink = new TeamInviteLink(getDriver());	
		TeamInviteLink.Invitelink_02_TeamInviteLink();	
	}
	@Test()
	public void Invitelink_03_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink TeamInviteLink = new TeamInviteLink(getDriver());	
		TeamInviteLink.Invitelink_03_TeamInviteLink();	
	}
	@Test()
	public void Invitelink_04_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink TeamInviteLink = new TeamInviteLink(getDriver());	
		TeamInviteLink.Invitelink_04_TeamInviteLink();	
	}
	@Test()
	public void Invitelink_05_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink TeamInviteLink = new TeamInviteLink(getDriver());	
		TeamInviteLink.Invitelink_05_TeamInviteLink();	
	}
  
  @Test
	public void Invitelink_06_TeamInviteLinkTest() throws Exception 
	{
		TeamInviteLink teaminvitelink = new TeamInviteLink(getDriver());	
		teaminvitelink.Invitelink_06_TeamInviteLink();
	}
	
	@Test()
	public void Invitelink_12_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink teamivitelink = new TeamInviteLink(getDriver());	
		teamivitelink.Invitelink_12_TeamInviteLink();
	}

	@Test()
	public void Invitelink_13_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink teamivitelink = new TeamInviteLink(getDriver());	
		teamivitelink.Invitelink_13_TeamInviteLink();
	}

	@Test()
	public void Invitelink_14_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink teamivitelink = new TeamInviteLink(getDriver());	
		teamivitelink.Invitelink_14_TeamInviteLink();
	}

	@Test()
	public void Invitelink_15_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink teamivitelink = new TeamInviteLink(getDriver());	
		teamivitelink.Invitelink_15_TeamInviteLink();
	}

	@Test()
	public void Invitelink_08_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink teamivitelink = new TeamInviteLink(getDriver());	
		teamivitelink.Invitelink_08_TeamInviteLink();
	}
	@Test()
	public void Invitelink_07_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink teamivitelink = new TeamInviteLink(getDriver());	
		teamivitelink.Invitelink_07_TeamInviteLink();
	}

}
