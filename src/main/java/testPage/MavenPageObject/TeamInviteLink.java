package testPage.MavenPageObject;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import TestData.CommonData;
import TestData.CreateAndAddNewMemberWithOrWithoutEmail_TestData;
import TestData.TeamInviteLink_TestData;
import objectRepository.ArchiveorUnarchiveTeam_Obj;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.ForgotPassword_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;

public class TeamInviteLink extends BasePge {
	BasePge base;
	Assert asrt;
	ElementActions element;

	public TeamInviteLink(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
		element = new ElementActions(driver);
	}	
	//<summery>
	//Test Case Title : Verify that user should able to navigate to the snipback website after entering the URL
	//Automation ID : Invitelink_01
	//</summery>
	public void Invitelink_01_TeamInviteLink() throws InterruptedException {	
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		//Step 1 : Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to the snipback website after entering the URL");
	}
	//<summery>
	//Test Case Title : Verify that user should able to navigate to the Film page once login with credentials
	//Automation ID : Invitelink_02
	//</summery>
	public void Invitelink_02_TeamInviteLink() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		//Step 1 : Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to the snipback website after entering the URL");

		//Step 2 : Login to Snipback
		//Expected : User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to navigate to the Film page once login with credentials");
	}
	//<summery>
	//Test Case Title : Verify that Team InviteLinks option should be displayed in the three dots against all teams in the organization if the user as Admin/Coach in the Game, Members & Followers tab in the Film page
	//Automation ID : Invitelink_03
	//</summery>
	public void Invitelink_03_TeamInviteLink() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		ArchiveorUnarchiveTeam_Obj ArchiveorUnarchiveTeamObj =new ArchiveorUnarchiveTeam_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestDataobj = new TeamInviteLink_TestData();
		SnipBackLogin_Obj SnipBackLoginObj = new SnipBackLogin_Obj();

		//Step 1 : Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to the snipback website after entering the URL");

		//Step 2 : Login to Snipback
		//Expected : User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to navigate to the Film page once login with credentials");

		//Step 3 : Switch the organization if the User as Admin/Coach
		//Expected : User should be able to switch the organization if the User as Admin/Coach.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), TeamInviteLinkTestDataobj.Invitelink_03_TeamInviteLinkOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, TeamInviteLinkTestDataobj.Invitelink_03_TeamInviteLinkOrganization, "User is not able to switch the organization if the User as Admin/Coach.");

		//Step 4 : Verify the Team InviteLinks option in Games Tab
		//Expected : Team InviteLinks option should be displayed in the three dots against all teams in the organization if the user as Admin/Coach in the Games tab in the Film page
		base.buttonClick(LoginPageObj.Edt_AlertMessage("GAMES"));
		Thread.sleep(4000);
		List<WebElement> GamesteamsList = base.GetElement(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeam("my-team-content", "membertable game_team"));	
		for (int i = 0; i < GamesteamsList.size(); i++) {
			WebElement teams = GamesteamsList.get(i);		
			WebElement threeDotButton = teams.findElement(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeamDots("my-team-content", "all-teams-menu cursor-pointer"));
			threeDotButton.click();
			Thread.sleep(2000);
			asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Login("Team Invite Links")),"Team InviteLinks option is not displayed in the three dots against all teams in the organization if the user as Admin/Coach in the Games tab in the Film page");
			threeDotButton.click();
			Thread.sleep(1000);			
		}
		//Step 5 : Verify the Team InviteLinks option in Members Tab
		//Expected : Team InviteLinks option should be displayed in the three dots against all teams in the organization if the user as Admin/Coach in the Members tab in the Film page
		base.buttonClick(LoginPageObj.Edt_AlertMessage("MEMBERS"));
		Thread.sleep(4000);
		List<WebElement> MembersteamsList = base.GetElement(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeam("my-team-content", "membertable player_team"));
		for (int i = 0; i <  MembersteamsList.size(); i++) {
			WebElement teams =  MembersteamsList.get(i);
			WebElement threeDotButton = teams.findElement(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeamDots("my-team-content", "all-teams-menu cursor-pointer"));
			threeDotButton.click();
			asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Login("Team Invite Links")),"Team InviteLinks option is not displayed in the three dots against all teams in the organization if the user as Admin/Coach in the Members tab in the Film page");
			threeDotButton.click();
			Thread.sleep(1000);			
		}
		//Step 6 : Verify the Team InviteLinks option in Followers Tab
		//Expected : Team InviteLinks option should be displayed in the three dots against all teams in the organization if the user as Admin/Coach in the Followers tab in the Film page
		base.buttonClick(LoginPageObj.Edt_AlertMessage("FOLLOWERS"));
		Thread.sleep(4000);
		List<WebElement> FollowersteamsList = base.GetElement(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeam("my-team-content", "membertable follower_team"));
		for (int i = 0; i < FollowersteamsList.size(); i++) {
			WebElement teams = FollowersteamsList.get(i);
			WebElement threeDotButton = teams.findElement(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeamDots("my-team-content", "all-teams-menu cursor-pointer"));
			threeDotButton.click();
			asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Login("Team Invite Links")),"Team InviteLinks option is not displayed in the three dots against all teams in the organization if the user as Admin/Coach in the Followers tab in the Film page");
			threeDotButton.click();		
		}
	}
	//<summery>
	//Test Case Title : Verify that Team InviteLinks option should  be disabled in Home organization and in the Organization if the User as Player/Followers/Recruiter in the Film page
	//Automation ID : Invitelink_04
	//</summery>
	public void Invitelink_04_TeamInviteLink() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		ArchiveorUnarchiveTeam_Obj ArchiveorUnarchiveTeamObj =new ArchiveorUnarchiveTeam_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestDataobj = new TeamInviteLink_TestData();
		SnipBackLogin_Obj SnipBackLoginObj = new SnipBackLogin_Obj();

		//Step 1 : Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to the snipback website after entering the URL");

		//Step 2 : Login to Snipback
		//Expected : User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to navigate to the Film page once login with credentials");

		//Step 3 : Switch the organization if the User as Player/Followers/Recruiter
		//Expected : User should be able to switch the organization if the User as Player/Followers/Recruiter
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), TeamInviteLinkTestDataobj.Invitelink_04_TeamInviteLinkOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, TeamInviteLinkTestDataobj.Invitelink_04_TeamInviteLinkOrganization, "User is not able to switch the organization if the User as Player/Followers/Recruiter");

		//Step 4 : Verify the Team InviteLinks option is disabled in the Organization if the User as Player/Followers/Recruiter in the Film page
		//Expected : Team InviteLinks option should  be disabled in the Organization if the User as Player/Followers/Recruiter in the Film page
		base.buttonClick(LoginPageObj.Edt_AlertMessage("GAMES"));
		List<WebElement> GamesteamsList = base.GetElement(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeam("my-team-content", "membertable game_team"));
		for (int i = 0; i < GamesteamsList.size(); i++) {
			WebElement teams = GamesteamsList.get(i);
			WebElement threeDotButton = teams.findElement(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeamDots("my-team-content", "all-teams-menu cursor-pointer"));
			element.getWait();
			threeDotButton.click();
			asrt.assertTrue(base.isDoesNotExistBool(SnipBackLoginObj.Btn_Login("Team Invite Links")),"Team InviteLinks option is not displayed in the Organization if the User as Player/Followers/Recruiter in the Film page");
			element.getWait();
			threeDotButton.click();	
			Thread.sleep(1000);
		}

		//Step 5 : Switch the organization to Home
		//Expected : User should be able to switch the organization to Home
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), TeamInviteLinkTestDataobj.Invitelink_04_TeamInviteLinkHomeOrganization);
		String HomeText = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(HomeText, TeamInviteLinkTestDataobj.Invitelink_04_TeamInviteLinkHomeOrganization, "User is not able to switch the organization if the User as Admin/Coach.");

		//Step 6: Verify the Team InviteLinks option is disabled in Home organization in the Film page
		//Expected : Team InviteLinks option should  be disabled in Home organization in the Film page
		asrt.assertTrue(base.isDoesNotExistBool(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeam("my-team-content", "membertable game_team")), "Team InviteLinks option is not displayed in Home organization in the Film page");
	}
	//<summery>
	//Test Case Title : Verify that when click on Team InviteLinks from the three dots against the team, the following links should be displayed; 1.INVITE PLAYER with player link & the icon for copying, 2.INVITE COACH with coch link & the icon for copying, 3.INVITE FOLLOWER with Follower link & the icon for copying
	//Automation ID : Invitelink_05
	//</summery>
	public void Invitelink_05_TeamInviteLink() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestDataobj = new TeamInviteLink_TestData();
		SnipBackLogin_Obj SnipBackLoginObj = new SnipBackLogin_Obj();

		//Step 1 : Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to the snipback website after entering the URL");

		//Step 2 : Login to Snipback
		//Expected : User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to navigate to the Film page once login with credentials");

		//Step 3 : Switch the organization if the User as Admin/Coach
		//Expected : User should be able to switch the organization if the User as Admin/Coach.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), TeamInviteLinkTestDataobj.Invitelink_05_TeamInviteLinkOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, TeamInviteLinkTestDataobj.Invitelink_05_TeamInviteLinkOrganization, "User is not able to switch the organization if the User as Admin/Coach.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TeamInviteLinkTestDataobj.Invitelink_05_TeamInviteLinkTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,TeamInviteLinkTestDataobj.Invitelink_05_TeamInviteLinkTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click on three dots
		//Expected: User should be able to click on three dots
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Login("Team Invite Links")),"User is not able to click on three dots");

		//Step 6 : Click on Team InviteLinks
		//Expected : When click on Team InviteLinks from the three dots against the team, the following links should be displayed; 1.INVITE PLAYER with player link & the icon for copying, 2.INVITE COACH with coch link & the icon for copying, 3.INVITE FOLLOWER with Follower link & the icon for copying 
		base.buttonClick(SnipBackLoginObj.Btn_Login("Team Invite Links"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("invitePlayerUrl"))&& base.isExists(LoginPageObj.Edt_LoginEmail("inviteCoachUrl"))&& base.isExists(LoginPageObj.Edt_LoginEmail("inviteFollowerUrl")),"When click on Team InviteLinks from the three dots against the team, the following links is not displayed; 1.INVITE PLAYER with player link & the icon for copying, 2.INVITE COACH with coch link & the icon for copying, 3.INVITE FOLLOWER with Follower link & the icon for copying");
	}
	//<summery>
	//Test Case Title : Verify that the respective link should be highlighted and the message "Copied" when click on Copy symbol against the respective link 
	//Automation ID : Invitelink_06
	//</summery>
	public void Invitelink_06_TeamInviteLink() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestDataobj = new TeamInviteLink_TestData();
		SnipBackLogin_Obj SnipBackLoginObj = new SnipBackLogin_Obj();

		//Step 1 : Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to the snipback website after entering the URL");

		//Step 2 : Login to Snipback
		//Expected : User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to navigate to the Film page once login with credentials");

		//Step 3 : Switch the organization if the User as Admin/Coach
		//Expected : User should be able to switch the organization if the User as Admin/Coach.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), TeamInviteLinkTestDataobj.Invitelink_06_TeamInviteLinkOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, TeamInviteLinkTestDataobj.Invitelink_06_TeamInviteLinkOrganization, "User is not able to switch the organization if the User as Admin/Coach.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TeamInviteLinkTestDataobj.Invitelink_06_TeamInviteLinkTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,TeamInviteLinkTestDataobj.Invitelink_06_TeamInviteLinkTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click on three dots
		//Expected: User should be able to click on three dots
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Login("Team Invite Links")),"User is not able to click on three dots");

		//Step 6 : Click on Team InviteLinks
		//Expected : When click on Team InviteLinks from the three dots against the team, the following links should be displayed; 1.INVITE PLAYER with player link & the icon for copying, 2.INVITE COACH with coch link & the icon for copying, 3.INVITE FOLLOWER with Follower link & the icon for copying 
		base.buttonClick(SnipBackLoginObj.Btn_Login("Team Invite Links"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("invitePlayerUrl"))&& base.isExists(LoginPageObj.Edt_LoginEmail("inviteCoachUrl"))&& base.isExists(LoginPageObj.Edt_LoginEmail("inviteFollowerUrl")),"When click on Team InviteLinks from the three dots against the team, the following links is not displayed; 1.INVITE PLAYER with player link & the icon for copying, 2.INVITE COACH with coch link & the icon for copying, 3.INVITE FOLLOWER with Follower link & the icon for copying");

		//Step 7: Copy the link (Player/Coach/Admin)
		//Expected : The respective link should be highlighted and the message "Copied" when click on Copy symbol against the respective link
		base.buttonClick(LoginPageObj.Btn_SingnIn("sharePlayerHref"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Copied")) && base.isEnabledBy(LoginPageObj.Edt_LoginEmail("invitePlayerUrl")), "The respective link is not highlighted and the message \"Copied\" is not displayed when click on Copy symbol against the respective link");
	}
	//<summery>
	//Test Case Title : Verify that Snipback login page should displayed when paste the copied link in any browser 
	//Automation ID : Invitelink_07
	//</summery>
	public void Invitelink_07_TeamInviteLink() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestDataobj = new TeamInviteLink_TestData();
		SnipBackLogin_Obj SnipBackLoginObj = new SnipBackLogin_Obj();

		//Step 1 : Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to the snipback website after entering the URL");

		//Step 2 : Login to Snipback
		//Expected : User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to navigate to the Film page once login with credentials");

		//Step 3 : Switch the organization if the User as Admin/Coach
		//Expected : User should be able to switch the organization if the User as Admin/Coach.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), TeamInviteLinkTestDataobj.Invitelink_07_TeamInviteLinkOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, TeamInviteLinkTestDataobj.Invitelink_07_TeamInviteLinkOrganization, "User is not able to switch the organization if the User as Admin/Coach.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TeamInviteLinkTestDataobj.Invitelink_07_TeamInviteLinkTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,TeamInviteLinkTestDataobj.Invitelink_07_TeamInviteLinkTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click on three dots
		//Expected: User should be able to click on three dots
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Login("Team Invite Links")),"User is not able to click on three dots");

		//Step 6 : Click on Team InviteLinks
		//Expected : When click on Team InviteLinks from the three dots against the team, the following links should be displayed; 1.INVITE PLAYER with player link & the icon for copying, 2.INVITE COACH with coch link & the icon for copying, 3.INVITE FOLLOWER with Follower link & the icon for copying 
		base.buttonClick(SnipBackLoginObj.Btn_Login("Team Invite Links"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("invitePlayerUrl"))&& base.isExists(LoginPageObj.Edt_LoginEmail("inviteCoachUrl"))&& base.isExists(LoginPageObj.Edt_LoginEmail("inviteFollowerUrl")),"When click on Team InviteLinks from the three dots against the team, the following links is not displayed; 1.INVITE PLAYER with player link & the icon for copying, 2.INVITE COACH with coch link & the icon for copying, 3.INVITE FOLLOWER with Follower link & the icon for copying");

		//Step 7: Copy the link (Player/Coach/Admin)
		//Expected : The respective link should be highlighted and the message "Copied" when click on Copy symbol against the respective link
		base.buttonClick(LoginPageObj.Btn_SingnIn("sharePlayerHref"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Copied")) && base.isEnabledBy(LoginPageObj.Edt_LoginEmail("invitePlayerUrl")), "The respective link is not highlighted and the message \"Copied\" is not displayed when click on Copy symbol against the respective link");

		//Step 8 : Paste the link any browser
		//Expected : Snipback login page should displayed when paste the copied link in any browser 
		String Url = base.GetValue(LoginPageObj.Edt_LoginEmail("invitePlayerUrl"));
		element.NewTab(Url);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("login_submit")), "Snipback login page is not displayed when paste the copied link in any browser");
	}
	//<summery>
	//Test Case Title : Verify that Signup Page should be displayed if we click on Singup from the login page displayed using Team Invite Links
	//Automation ID : Invitelink_12
	//</summery>
	public void Invitelink_12_TeamInviteLink() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestDataobj = new TeamInviteLink_TestData();
		SnipBackLogin_Obj SnipBackLoginObj = new SnipBackLogin_Obj();

		//Step 1 : Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to the snipback website after entering the URL");

		//Step 2 : Login to Snipback
		//Expected : User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to navigate to the Film page once login with credentials");

		//Step 3 : Switch the organization if the User as Admin/Coach
		//Expected : User should be able to switch the organization if the User as Admin/Coach.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), TeamInviteLinkTestDataobj.Invitelink_12_TeamInviteLinkOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, TeamInviteLinkTestDataobj.Invitelink_12_TeamInviteLinkOrganization, "User is not able to switch the organization if the User as Admin/Coach.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TeamInviteLinkTestDataobj.Invitelink_12_TeamInviteLinkTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,TeamInviteLinkTestDataobj.Invitelink_12_TeamInviteLinkTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click on three dots
		//Expected: User should be able to click on three dots
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Login("Team Invite Links")),"User is not able to click on three dots");

		//Step 6 : Click on Team InviteLinks
		//Expected : When click on Team InviteLinks from the three dots against the team, the following links should be displayed; 1.INVITE PLAYER with player link & the icon for copying, 2.INVITE COACH with coch link & the icon for copying, 3.INVITE FOLLOWER with Follower link & the icon for copying 
		base.buttonClick(SnipBackLoginObj.Btn_Login("Team Invite Links"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("invitePlayerUrl"))&& base.isExists(LoginPageObj.Edt_LoginEmail("inviteCoachUrl"))&& base.isExists(LoginPageObj.Edt_LoginEmail("inviteFollowerUrl")),"When click on Team InviteLinks from the three dots against the team, the following links is not displayed; 1.INVITE PLAYER with player link & the icon for copying, 2.INVITE COACH with coch link & the icon for copying, 3.INVITE FOLLOWER with Follower link & the icon for copying");

		//Step 7: Copy the link (Player/Coach/Admin)
		//Expected : The respective link should be highlighted and the message "Copied" when click on Copy symbol against the respective link
		base.buttonClick(LoginPageObj.Btn_SingnIn("sharePlayerHref"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Copied")) && base.isEnabledBy(LoginPageObj.Edt_LoginEmail("invitePlayerUrl")), "The respective link is not highlighted and the message \"Copied\" is not displayed when click on Copy symbol against the respective link");

		//Step 8 : Paste the link any browser
		//Expected : Snipback login page should displayed when paste the copied link in any browser 
		String Url = base.GetValue(LoginPageObj.Edt_LoginEmail("invitePlayerUrl"));
		element.NewTab(Url);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("login_submit")), "Snipback login page is not displayed when paste the copied link in any browser");

		// Step 9 : Click on Signup 
		//Expected : Signup Page should be displayed if we click on Singup from the login page displayed using Team Invite Links
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Sign up"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("btn-signup")), "Signup Page is not displayed if we click on Singup from the login page displayed using Team Invite Links");
	}
	//<summery>
	//Test Case Title : Verify that an OTP field should be displayed after entering all the required fields from the Signup page 
	//Automation ID : Invitelink_13
	//</summery>
	public void Invitelink_13_TeamInviteLink() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestDataobj = new TeamInviteLink_TestData();
		SnipBackLogin_Obj SnipBackLoginObj = new SnipBackLogin_Obj();

		//Step 1 : Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to the snipback website after entering the URL");

		//Step 2 : Login to Snipback
		//Expected : User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to navigate to the Film page once login with credentials");

		//Step 3 : Switch the organization if the User as Admin/Coach
		//Expected : User should be able to switch the organization if the User as Admin/Coach.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), TeamInviteLinkTestDataobj.Invitelink_13_TeamInviteLinkOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, TeamInviteLinkTestDataobj.Invitelink_13_TeamInviteLinkOrganization, "User is not able to switch the organization if the User as Admin/Coach.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TeamInviteLinkTestDataobj.Invitelink_13_TeamInviteLinkTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,TeamInviteLinkTestDataobj.Invitelink_13_TeamInviteLinkTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click on three dots
		//Expected: User should be able to click on three dots
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Login("Team Invite Links")),"User is not able to click on three dots");

		//Step 6 : Click on Team InviteLinks
		//Expected : When click on Team InviteLinks from the three dots against the team, the following links should be displayed; 1.INVITE PLAYER with player link & the icon for copying, 2.INVITE COACH with coch link & the icon for copying, 3.INVITE FOLLOWER with Follower link & the icon for copying 
		base.buttonClick(SnipBackLoginObj.Btn_Login("Team Invite Links"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("invitePlayerUrl"))&& base.isExists(LoginPageObj.Edt_LoginEmail("inviteCoachUrl"))&& base.isExists(LoginPageObj.Edt_LoginEmail("inviteFollowerUrl")),"When click on Team InviteLinks from the three dots against the team, the following links is not displayed; 1.INVITE PLAYER with player link & the icon for copying, 2.INVITE COACH with coch link & the icon for copying, 3.INVITE FOLLOWER with Follower link & the icon for copying");

		//Step 7: Copy the link (Player/Coach/Admin)
		//Expected : The respective link should be highlighted and the message "Copied" when click on Copy symbol against the respective link
		base.buttonClick(LoginPageObj.Btn_SingnIn("sharePlayerHref"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Copied")) && base.isEnabledBy(LoginPageObj.Edt_LoginEmail("invitePlayerUrl")), "The respective link is not highlighted and the message \"Copied\" is not displayed when click on Copy symbol against the respective link");

		//Step 8 : Paste the link any browser
		//Expected : Snipback login page should displayed when paste the copied link in any browser 
		String Url = base.GetValue(LoginPageObj.Edt_LoginEmail("invitePlayerUrl"));
		element.NewTab(Url);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("login_submit")), "Snipback login page is not displayed when paste the copied link in any browser");

		// Step 9 : Click on Signup 
		//Expected : Signup Page should be displayed if we click on Singup from the login page displayed using Team Invite Links
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Sign up"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("btn-signup")), "Signup Page is not displayed if we click on Singup from the login page displayed using Team Invite Links");

		// Step 10 : Enter all required fields and Click on Signup 
		//Expected :  OTP field should be displayed after entering all the required fields from the Signup page 
		element.fillFormFields(
				LoginPageObj.Edt_LoginEmail("first_name"),TeamInviteLinkTestDataobj.Invitelink_13_TeamInviteLinkName,
				LoginPageObj.Edt_LoginEmail("user_email"),TeamInviteLinkTestDataobj.Invitelink_13_TeamInviteLinkEmail,
				LoginPageObj.Edt_LoginEmail("user_name"),TeamInviteLinkTestDataobj.Invitelink_13_TeamInviteLinkUserName,
				LoginPageObj.Edt_LoginEmail("user_pass"),TeamInviteLinkTestDataobj.Invitelink_13_TeamInviteLinkPassword,
				LoginPageObj.Edt_LoginEmail("user_confirm_password"),TeamInviteLinkTestDataobj.Invitelink_13_TeamInviteLinkConfirmPassword);
		base.scrollToElement(LoginPageObj.Edt_LoginEmail("agreeterms"));
		base.selectCheckBox(LoginPageObj.Edt_LoginEmail("agreeterms"));
		base.scrollToElement(LoginPageObj.Btn_SingnIn("btn-signup"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("btn-signup"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("signUp-otp")), "OTP field is not displayed after entering all the required fields from the Signup page ");
	}
}