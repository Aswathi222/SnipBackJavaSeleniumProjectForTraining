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
		List<WebElement> GamesteamsList = base.GetElement(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeam("my-team-content", "membertable game_team"));
		for (int i = 0; i < GamesteamsList.size(); i++) {
			WebElement teams = GamesteamsList.get(i);
			WebElement threeDotButton = teams.findElement(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeamDots("my-team-content", "all-teams-menu cursor-pointer"));
			threeDotButton.click();
			asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Login("Team Invite Links")),"Team InviteLinks option is not displayed in the three dots against all teams in the organization if the user as Admin/Coach in the Games tab in the Film page");
			threeDotButton.click();
			Thread.sleep(1000);			
		}
		//Step 5 : Verify the Team InviteLinks option in Members Tab
		//Expected : Team InviteLinks option should be displayed in the three dots against all teams in the organization if the user as Admin/Coach in the Members tab in the Film page
		base.buttonClick(LoginPageObj.Edt_AlertMessage("MEMBERS"));
		//Thread.sleep(3000);
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
		List<WebElement> FollowersteamsList = base.GetElement(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeam("my-team-content", "membertable follower_team"));
		for (int i = 0; i < FollowersteamsList.size(); i++) {
			WebElement teams = FollowersteamsList.get(i);
			WebElement threeDotButton = teams.findElement(ArchiveorUnarchiveTeamObj.Ele_ArchiveTeamDots("my-team-content", "all-teams-menu cursor-pointer"));
			threeDotButton.click();
			asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Login("Team Invite Links")),"Team InviteLinks option is not displayed in the three dots against all teams in the organization if the user as Admin/Coach in the Followers tab in the Film page");
			threeDotButton.click();		
		}
	}
}