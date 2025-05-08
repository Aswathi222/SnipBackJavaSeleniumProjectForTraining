package testPage.MavenPageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestData.AddorEditInfo_TestData;
import TestData.ArchiveorUnarchiveTeam_TestData;
import TestData.CommonData;
import TestData.CreateEditDeletePool_TestData;
import TestData.SearchGamesTeamAndMembers_TestData;
import objectRepository.AddorEditInfo_Obj;
import objectRepository.ArchiveorUnarchiveTeam_Obj;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;

public class ArchiveorUnarchiveTeam extends BasePge{
	BasePge base;
	Assert asrt;
	ElementActions element;

	public ArchiveorUnarchiveTeam(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
		element=new ElementActions(driver);
	}
	//<Summary>
	//Test case Title:Verify that user should able to navigate to the snipback website after entering the URL
	//Automation ID:Archive_01
	//</Summary>
	public void Archive_01_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );
	}
	//<Summary>
	//Test case Title:Verify that user should able to navigate to the Film page once login with credentials
	//Automation ID:Archive_02
	//</Summary>
	public void Archive_02_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);	

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );

		//Step 2:Login to SnipBack
		//Expected:User should able to navigate to the Film page once login with credentials 
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("GAMES"))," User is unable to navigate to the Film page once login with credentials");
	}
	//<Summary>
	//Test case Title:Verify that Archive team option should be displayed in the three dots against  all teams in the organization if the user as Admin/Coach in the Game, Members & Followers tab in the Film page
	//Automation ID:Archive_03
	//</Summary>
	public void Archive_03_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createAndAddNewMemberWithOrWithoutEmailObj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		ArchiveorUnarchiveTeam_TestData archiveorUnarchiveTeamTestData=new ArchiveorUnarchiveTeam_TestData();
		ArchiveorUnarchiveTeam_Obj archiveorUnarchiveTeamObj=new ArchiveorUnarchiveTeam_Obj();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );

		//Step 2:Login to SnipBack
		//Expected:User should able to navigate to the Film page once login with credentials 
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to navigate to the Film page once login with credentials");

		//Step 3:Switch the organization if the User as Admin/Coach
		//Expected:User should able to switch the organisation if the user as Admin/Coach
		base.selectorByVisibleText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"),archiveorUnarchiveTeamTestData.Archive_03_ArchiveorUnarchiveTeam);
		Thread.sleep(3000);
		String organisation=element.DropDownText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(organisation, archiveorUnarchiveTeamTestData.Archive_03_ArchiveorUnarchiveTeam,"User unable to switch the organisation if the user as Admin/Coach");

		//Step 4:Verify the Archive team option in Games tab
		//Expected:Archive team option should be displayed in the three dots against  all teams in the organization if the user as Admin/Coach in the Game tab in the Film page
		Thread.sleep(3000);
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		List<WebElement> teams = driver.findElements(archiveorUnarchiveTeamObj.Ele_ArchiveTeam("my-team-content", "content-between align-items-center list-wrap all-teams-dark team"));
		for (int i = 0; i < teams.size(); i++) {
			Thread.sleep(1000);
			WebElement currentTeam = teams.get(i);
			WebElement threeDotsButton = currentTeam.findElement(archiveorUnarchiveTeamObj.Ele_ArchiveTeamDots("my-team-content", "all-teams-menu cursor-pointer"));
			threeDotsButton.click();
			asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("Archive Team")), "Archive Team option is not displayed for team in Game tab in Film page");
			threeDotsButton.click();
			Thread.sleep(2000);
		}

		//Step 5:Verify the Archive team option in Members tab
		//Expected:Archive team option should be displayed in the three dots against  all teams in the organization if the user as Admin/Coach in the Members tab in the Film page
		Thread.sleep(3000);
		base.buttonClick(loginObj.Edt_AlertMessage("MEMBERS"));
		List<WebElement> teamsMembers = driver.findElements(archiveorUnarchiveTeamObj.Ele_ArchiveTeam("my-team-content", "content-between align-items-center list-wrap all-teams-dark team"));
		for (int i = 0; i < teamsMembers.size(); i++) {
			Thread.sleep(1000);
			WebElement currentTeamMembers = teamsMembers.get(i);
			WebElement threeDotsButtonMembers = currentTeamMembers.findElement(archiveorUnarchiveTeamObj.Ele_ArchiveTeamDots("my-team-content", "all-teams-menu cursor-pointer"));
			threeDotsButtonMembers .click();
			asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("Archive Team")), "Archive Team option is not displayed for team in Members tab in Film page");
			threeDotsButtonMembers .click();
			Thread.sleep(2000);
		}

		//Step 6:Verify the Archive team option in Follwers tab
		//Expected:Archive team option should be displayed in the three dots against  all teams in the organization if the user as Admin/Coach in the Followers tab in the Film page
		Thread.sleep(3000);
		base.buttonClick(loginObj.Edt_AlertMessage("FOLLOWERS"));
		List<WebElement> teamsFollwers = driver.findElements(archiveorUnarchiveTeamObj.Ele_ArchiveTeam("my-team-content", "content-between align-items-center list-wrap all-teams-dark team"));
		for (int i = 0; i < teamsFollwers.size(); i++) {
			Thread.sleep(1000);
			WebElement currentTeamFollwers = teamsFollwers.get(i);
			WebElement threeDotsButtonFollowers = currentTeamFollwers.findElement(archiveorUnarchiveTeamObj.Ele_ArchiveTeamDots("my-team-content", "all-teams-menu cursor-pointer"));
			threeDotsButtonFollowers .click();
			asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("Archive Team")), "Archive Team option is not displayed for team in Followers tab in Film page");
			threeDotsButtonFollowers .click();
			Thread.sleep(2000);
		}
	}
	//<Summary>
	//Test case Title:Verify that Archive option should  be disabled in Home organization and in the Organization if the User as Player/Followers/Recruiter in the Film page
	//Automation ID:Archive_04
	//</Summary>
	public void Archive_04_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createAndAddNewMemberWithOrWithoutEmailObj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		ArchiveorUnarchiveTeam_TestData archiveorUnarchiveTeamTestData=new ArchiveorUnarchiveTeam_TestData();
		ArchiveorUnarchiveTeam_Obj archiveorUnarchiveTeamObj=new ArchiveorUnarchiveTeam_Obj();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );

		//Step 2:Login to SnipBack
		//Expected:User should able to navigate to the Film page once login with credentials 
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to navigate to the Film page once login with credentials");

		//Step 3:Switch the organization if the User as Player/Followers/Recruiter
		//Expected:User should able to switch the organisation if the user as Player/Followers/Recruiter in the Film page
		base.selectorByVisibleText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"),archiveorUnarchiveTeamTestData.Archive_04_ArchiveorUnarchiveTeam );
		Thread.sleep(3000);
		String organisation=element.DropDownText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(organisation, archiveorUnarchiveTeamTestData.Archive_04_ArchiveorUnarchiveTeam,"User unable to switch the organisation if the user as Admin/Coach");

		//Step 4:Verify the Archive team option is disabled in the Organization if the User as Player/Followers/Recruiter in the Film page
		//Expected:Archive option should be disabled in the Organization if the User as Player/Followers/Recruiter in the Film page
		Thread.sleep(3000);
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		List<WebElement> teamsDisArchive = driver.findElements(archiveorUnarchiveTeamObj.Ele_ArchiveTeam("my-team-content", "content-between align-items-center list-wrap all-teams-dark team"));
		for (int i = 0; i < teamsDisArchive.size(); i++) {
			Thread.sleep(1000);
			WebElement currentTeam = teamsDisArchive.get(i);
			WebElement threeDotsButton = currentTeam.findElement(archiveorUnarchiveTeamObj.Ele_ArchiveTeamDots("my-team-content", "all-teams-menu cursor-pointer"));
			threeDotsButton.click();
			asrt.assertTrue(base.isDoesNotExistBool(snipBackLoginObj.Btn_Login("Archive Team")), "Archive Team option is displayed in the Organization if the User as Player/Followers/Recruiter in the Film page");
			threeDotsButton.click();
			Thread.sleep(2000);
		}
		//Step 5:Switch the organization to Home
		//Expected:User should able to switch the organisation to Home
		base.selectorByVisibleText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"),archiveorUnarchiveTeamTestData.Archive_04_ArchiveorUnarchiveTeamHome );
		Thread.sleep(3000);
		String organisationhome=element.DropDownText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(organisationhome, archiveorUnarchiveTeamTestData.Archive_04_ArchiveorUnarchiveTeamHome,"User unable to switch the organisation to Home");

		//Step 6:Verify the Archive team option is disabled 
		//Expected:Archive option should  be disabled in Home organization
		asrt.assertTrue(base.isDoesNotExistBool(archiveorUnarchiveTeamObj.Ele_ArchiveTeam("my-team-content", "content-between align-items-center list-wrap all-teams-dark team")), "Archive Team option is displayed for team in Film page");
	}
	//<Summary>
	//Test case Title:Verify that the message "Are you sure want to archive this team?" with Yes or No should be displayed when click on Archive team from the three dots against the respective team
	//Automation ID:Archive_06
	//</Summary>
	public void Archive_06_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createAndAddNewMemberWithOrWithoutEmailObj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		ArchiveorUnarchiveTeam_TestData archiveorUnarchiveTeamTestData=new ArchiveorUnarchiveTeam_TestData();
		ArchiveorUnarchiveTeam_Obj archiveorUnarchiveTeamObj=new ArchiveorUnarchiveTeam_Obj();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );

		//Step 2:Login to SnipBack
		//Expected:User should able to navigate to the Film page once login with credentials 
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to navigate to the Film page once login with credentials");

		//Step 3:Switch the organization if the User as Admin/Coach
		//Expected:User should able to switch the organisation if the user as Admin/Coach
		base.selectorByVisibleText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"),archiveorUnarchiveTeamTestData.Archive_06_ArchiveorUnarchiveTeam );
		Thread.sleep(3000);
		String organisation=element.DropDownText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(organisation,archiveorUnarchiveTeamTestData.Archive_06_ArchiveorUnarchiveTeam ,"User unable to switch the organisation if the user as Admin/Coach");

		//Step 4:Click search bar and enter a team
		//Expected:User should click search bar and enter a team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"), archiveorUnarchiveTeamTestData.Archive_06_ArchiveorUnarchiveTeam_Search);
		String teamValue=base.GetValue(loginObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(teamValue, archiveorUnarchiveTeamTestData.Archive_06_ArchiveorUnarchiveTeam_Search,"User is unable to click search bar and enter a team");

		//Step 5:Click on Three dots
		//Expected: User is able to click on three dots of the team
		base.buttonClick(createAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("Archive Team")), "User is unable to click three dots of the team");

		//Step 6:Click on Archive team
		//Expected:The message "Are you sure want to archive this team?" should be displayed when click on Archive team from the three dots against the respective team
		base.buttonClick(snipBackLoginObj.Btn_Login("Archive Team"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Are you sure want to archive this team?")), "User is unable to receive The message \"Are you sure want to archive this team?\" should be displayed when click on Archive team from the three dots against the respective team");
	}
	//<Summary>
	//Test case Title:Verify that the message "Are you sure want to archive this team?" should be closed when click on No from the popup message
	//Automation ID:Archive_07
	//</Summary>
	public void Archive_07_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createAndAddNewMemberWithOrWithoutEmailObj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		ArchiveorUnarchiveTeam_TestData archiveorUnarchiveTeamTestData=new ArchiveorUnarchiveTeam_TestData();
		ArchiveorUnarchiveTeam_Obj archiveorUnarchiveTeamObj=new ArchiveorUnarchiveTeam_Obj();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );

		//Step 2:Login to SnipBack
		//Expected:User should able to navigate to the Film page once login with credentials 
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to navigate to the Film page once login with credentials");

		//Step 3:Switch the organization if the User as Admin/Coach
		//Expected:User should able to switch the organisation if the user as Admin/Coach
		base.selectorByVisibleText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"),archiveorUnarchiveTeamTestData.Archive_07_ArchiveorUnarchiveTeam );
		Thread.sleep(3000);
		String organisation=element.DropDownText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(organisation,archiveorUnarchiveTeamTestData.Archive_07_ArchiveorUnarchiveTeam ,"User unable to switch the organisation if the user as Admin/Coach");

		//Step 4:Click search bar and enter a team
		//Expected:User should click search bar and enter a team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"), archiveorUnarchiveTeamTestData.Archive_07_ArchiveorUnarchiveTeam_Search);
		base.pressKey(loginObj.Edt_LoginEmail("searchTeam"),"KEYBOARD_ENTER");
		Thread.sleep(4000);
		String teamValue=base.GetValue(loginObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(teamValue, archiveorUnarchiveTeamTestData.Archive_07_ArchiveorUnarchiveTeam_Search,"User is unable to click search bar and enter a team");

		//Step 5:Click on Three dots
		//Expected: User is able to click on three dots of the team
		Thread.sleep(3000);
		base.buttonClick(createAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-2"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_ArchiveOptionText("teamDropdownMenu-2","Archive Team")), "User is unable to click three dots of the team");

		//Step 6:Click on Archive team
		//Expected:User is able to click on Archive team
		base.buttonClick(archiveorUnarchiveTeamObj.Ele_ArchiveOptionText("teamDropdownMenu-2","Archive Team"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Are you sure want to archive this team?")), "User is unable to click on Archive team");

		//Step 7:Click on No
		//Expected:"Are you sure want to archive this team?" should be closed when click on No from the popup message
		base.buttonClick(snipBackLoginObj.Btn_Signin("No"));
		asrt.assertTrue(base.isDoesNotExistBool(snipBackLoginObj.Btn_Signin("No")), "'Are you sure want to archive this team?' is not closed when click on No from the popup message");
	}
	//<Summary>
	//Test case Title:Verify that the message Success! Team Archived Successfully should popup when click on Yes from the popup message  "Are you sure want to archive this team?"
	//Automation ID:Archive_08
	//</Summary>
	public void Archive_08_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createAndAddNewMemberWithOrWithoutEmailObj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		ArchiveorUnarchiveTeam_TestData archiveorUnarchiveTeamTestData=new ArchiveorUnarchiveTeam_TestData();
		ArchiveorUnarchiveTeam_Obj archiveorUnarchiveTeamObj=new ArchiveorUnarchiveTeam_Obj();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );

		//Step 2:Login to SnipBack
		//Expected:User should able to navigate to the Film page once login with credentials 
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("GAMES"))," User is unable to navigate to the Film page once login with credentials");

		//Step 3:Switch the organization if the User as Admin/Coach
		//Expected:User should able to switch the organisation if the user as Admin/Coach
		base.selectorByVisibleText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"),archiveorUnarchiveTeamTestData.Archive_08_ArchiveorUnarchiveTeam );
		Thread.sleep(3000);
		String organisation=element.DropDownText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(organisation,archiveorUnarchiveTeamTestData.Archive_08_ArchiveorUnarchiveTeam ,"User unable to switch the organisation if the user as Admin/Coach");

		//Step 4:Click search bar and enter a team
		//Expected:User should click search bar and enter a team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"), archiveorUnarchiveTeamTestData.Archive_08_ArchiveorUnarchiveTeam_Search);
		base.pressKey(loginObj.Edt_LoginEmail("searchTeam"),"ENTER");
		base.scrollToElement(loginObj.Edt_AlertMessage("AA DEMO"));
		Thread.sleep(2000);
		String teamValue=base.GetValue(loginObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(teamValue, archiveorUnarchiveTeamTestData.Archive_08_ArchiveorUnarchiveTeam_Search,"User is unable to click search bar and enter a team");

		//Step 5:Click on Three dots
		//Expected: User is able to click on three dots of the team
		Thread.sleep(5000);
		base.buttonClick(createAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-6"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_ArchiveOptionText("teamDropdownMenu-6","Archive Team")), "User is unable to click three dots of the team");

		//Step 6:Click on Archive team
		//Expected:User is able to click on Archive team
		Thread.sleep(3000);
		base.buttonClick(archiveorUnarchiveTeamObj.Ele_ArchiveOptionText("teamDropdownMenu-6","Archive Team"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Are you sure want to archive this team?")), "User is unable to click on Archive team");

		//Step 7:Click on Yes
		//Expected:The message Success! Team Archived Successfully should popup when click on Yes from the popup message  "Are you sure want to archive this team?"
		base.buttonClick(snipBackLoginObj.Btn_Signin("Yes"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Team Archived Successfully")), "The message 'Success! Team Archived Successfully' is not showing when user click on Yes from the popup message 'Are you sure want to archive this team?'");
	}
	//<Summary>
	//Test case Title:Verify that the Team should be in Archived List when click on OK from the popup message Success! Team Archived Successfully"
	//Automation ID:Archive_09
	//</Summary>
	public void Archive_09_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createAndAddNewMemberWithOrWithoutEmailObj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		ArchiveorUnarchiveTeam_TestData archiveorUnarchiveTeamTestData=new ArchiveorUnarchiveTeam_TestData();
		ArchiveorUnarchiveTeam_Obj archiveorUnarchiveTeamObj=new ArchiveorUnarchiveTeam_Obj();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );

		//Step 2:Login to SnipBack
		//Expected:User should able to navigate to the Film page once login with credentials 
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("GAMES"))," User is unable to navigate to the Film page once login with credentials");

		//Step 3:Switch the organization if the User as Admin/Coach
		//Expected:User should able to switch the organisation if the user as Admin/Coach
		base.selectorByVisibleText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"),archiveorUnarchiveTeamTestData.Archive_09_ArchiveorUnarchiveTeam );
		Thread.sleep(3000);
		String organisation=element.DropDownText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(organisation,archiveorUnarchiveTeamTestData.Archive_09_ArchiveorUnarchiveTeam ,"User unable to switch the organisation if the user as Admin/Coach");

		//Step 4:Click search bar and enter a team
		//Expected:User should click search bar and enter a team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"), archiveorUnarchiveTeamTestData.Archive_09_ArchiveorUnarchiveTeam_Search);
		base.pressKey(loginObj.Edt_LoginEmail("searchTeam"),"ENTER");
		base.scrollToElement(loginObj.Edt_AlertMessage("AA DEMO"));
		Thread.sleep(2000);
		String teamValue=base.GetValue(loginObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(teamValue, archiveorUnarchiveTeamTestData.Archive_09_ArchiveorUnarchiveTeam_Search,"User is unable to click search bar and enter a team");

		//Step 5:Click on Three dots
		//Expected: User is able to click on three dots of the team
		Thread.sleep(5000);
		base.buttonClick(createAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-9"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_ArchiveOptionText("teamDropdownMenu-9","Archive Team")), "User is unable to click three dots of the team");

		//Step 6:Click on Archive team
		//Expected:User is able to click on Archive team
		Thread.sleep(3000);
		base.buttonClick(archiveorUnarchiveTeamObj.Ele_ArchiveOptionText("teamDropdownMenu-9","Archive Team"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Are you sure want to archive this team?")), "User is unable to click on Archive team");

		//Step 7:Click on Yes
		//Expected:User should able to click Yes
		base.buttonClick(snipBackLoginObj.Btn_Signin("Yes"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Team Archived Successfully")), "User is unable to click 'Yes'");

		//Step 8:Click on OK
		//Expected:The Team should be in Archived List when click on OK from the popup message Success! Team Archived Successfully"
		Thread.sleep(4000);
		base.buttonClick(snipBackLoginObj.Btn_Signin("OK"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_ArchivedTeam("search-result-archive-wrap mt-3", "AA new")), "The Team is not in Archived List when click on OK from the popup message Success! Team Archived Successfully");
	}
	//<Summary>
	//Test case Title:Verify that the Unarchive team option should be displayed when click on three dots against the team in the Archive List
	//Automation ID:Archive_10
	//</Summary>
	public void Archive_10_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createAndAddNewMemberWithOrWithoutEmailObj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		ArchiveorUnarchiveTeam_TestData archiveorUnarchiveTeamTestData=new ArchiveorUnarchiveTeam_TestData();
		ArchiveorUnarchiveTeam_Obj archiveorUnarchiveTeamObj=new ArchiveorUnarchiveTeam_Obj();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );

		//Step 2:Login to SnipBack
		//Expected:User should able to navigate to the Film page once login with credentials 
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("GAMES"))," User is unable to navigate to the Film page once login with credentials");

		//Step 3:Switch the organization if the User as Admin/Coach
		//Expected:User should able to switch the organisation if the user as Admin/Coach
		base.selectorByVisibleText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"),archiveorUnarchiveTeamTestData.Archive_10_ArchiveorUnarchiveTeam );
		Thread.sleep(3000);
		String organisation=element.DropDownText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(organisation,archiveorUnarchiveTeamTestData.Archive_10_ArchiveorUnarchiveTeam ,"User unable to switch the organisation if the user as Admin/Coach");

		//Step 4:Click search bar and enter a team
		//Expected:User should click search bar and enter a team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"), archiveorUnarchiveTeamTestData.Archive_10_ArchiveorUnarchiveTeam_Search);
		base.pressKey(loginObj.Edt_LoginEmail("searchTeam"),"ENTER");
		base.scrollToElement(loginObj.Edt_AlertMessage("AA DEMO"));
		Thread.sleep(2000);
		String teamValue=base.GetValue(loginObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(teamValue, archiveorUnarchiveTeamTestData.Archive_10_ArchiveorUnarchiveTeam_Search,"User is unable to click search bar and enter a team");

		//Step 5:Click on Three dots
		//Expected: User is able to click on three dots of the team
		Thread.sleep(5000);
		base.buttonClick(createAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-9"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_ArchiveOptionText("teamDropdownMenu-9","Archive Team")), "User is unable to click three dots of the team");

		//Step 6:Click on Archive team
		//Expected:User is able to click on Archive team
		Thread.sleep(3000);
		base.buttonClick(archiveorUnarchiveTeamObj.Ele_ArchiveOptionText("teamDropdownMenu-9","Archive Team"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Are you sure want to archive this team?")), "User is unable to click on Archive team");

		//Step 7:Click on Yes
		//Expected:User should able to click Yes
		base.buttonClick(snipBackLoginObj.Btn_Signin("Yes"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Team Archived Successfully")), "User is unable to click 'Yes'");

		//Step 8:Click on OK
		//Expected:User should be able to click OK
		Thread.sleep(4000);
		base.buttonClick(snipBackLoginObj.Btn_Signin("OK"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_ArchivedTeam("search-result-archive-wrap mt-3", "AA new")), "User is unable to click OK");

		//Step 9:Click on three dots against the Archive Team
		//Expected:Unarchive team option should be displayed when click on three dots against the team in the Archive List
		base.buttonClick(archiveorUnarchiveTeamObj.Ele_UnarchivedTeam("search-result-archive-wrap mt-3", "AA new", "all-teams-menu cursor-pointer"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_UnarchivedText("search-result-archive-wrap mt-3", "AA new", "Unarchive Team")), "Unarchive team option is not displayed when click on three dots against the team in the Archive List");
	}
	//<Summary>
	//Test case Title:Verify that the message Success!Team Unarchived Successfully" wih OK should popup when click on Unarchive team option
	//Automation ID:Archive_11
	//</Summary>
	public void Archive_11_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createAndAddNewMemberWithOrWithoutEmailObj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		ArchiveorUnarchiveTeam_TestData archiveorUnarchiveTeamTestData=new ArchiveorUnarchiveTeam_TestData();
		ArchiveorUnarchiveTeam_Obj archiveorUnarchiveTeamObj=new ArchiveorUnarchiveTeam_Obj();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );

		//Step 2:Login to SnipBack
		//Expected:User should able to navigate to the Film page once login with credentials 
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("GAMES"))," User is unable to navigate to the Film page once login with credentials");

		//Step 3:Switch the organization if the User as Admin/Coach
		//Expected:User should able to switch the organisation if the user as Admin/Coach
		base.selectorByVisibleText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"),archiveorUnarchiveTeamTestData.Archive_11_ArchiveorUnarchiveTeam );
		Thread.sleep(3000);
		String organisation=element.DropDownText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(organisation,archiveorUnarchiveTeamTestData.Archive_11_ArchiveorUnarchiveTeam ,"User unable to switch the organisation if the user as Admin/Coach");

		//Step 4:Click search bar and enter a team
		//Expected:User should click search bar and enter a team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"), archiveorUnarchiveTeamTestData.Archive_11_ArchiveorUnarchiveTeam_Search);
		base.pressKey(loginObj.Edt_LoginEmail("searchTeam"),"ENTER");
		base.scrollToElement(loginObj.Edt_AlertMessage("AA DEMO"));
		Thread.sleep(2000);
		String teamValue=base.GetValue(loginObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(teamValue, archiveorUnarchiveTeamTestData.Archive_11_ArchiveorUnarchiveTeam_Search,"User is unable to click search bar and enter a team");

		//Step 5:Click on Three dots
		//Expected: User is able to click on three dots of the team
		Thread.sleep(5000);
		base.buttonClick(createAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-9"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_ArchiveOptionText("teamDropdownMenu-9","Archive Team")), "User is unable to click three dots of the team");

		//Step 6:Click on Archive team
		//Expected:User is able to click on Archive team
		Thread.sleep(3000);
		base.buttonClick(archiveorUnarchiveTeamObj.Ele_ArchiveOptionText("teamDropdownMenu-9","Archive Team"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Are you sure want to archive this team?")), "User is unable to click on Archive team");

		//Step 7:Click on Yes
		//Expected:User should able to click Yes
		base.buttonClick(snipBackLoginObj.Btn_Signin("Yes"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Team Archived Successfully")), "User is unable to click 'Yes'");

		//Step 8:Click on OK
		//Expected:User should be able to click OK
		Thread.sleep(4000);
		base.buttonClick(snipBackLoginObj.Btn_Signin("OK"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_ArchivedTeam("search-result-archive-wrap mt-3", "AA new")), "User is unable to click OK");

		//Step 9:Click on three dots against the Archive Team
		//Expected:User should be able to click on three dots against the Archive Team
		base.buttonClick(archiveorUnarchiveTeamObj.Ele_UnarchivedTeam("search-result-archive-wrap mt-3", "AA new", "all-teams-menu cursor-pointer"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_UnarchivedText("search-result-archive-wrap mt-3", "AA new", "Unarchive Team")), "User is unable to click on three dots against the Archive Team");

		//Step 10:Click on Unarchive team
		//Expected:Team Unarchived Successfully" wih OK should popup when click on Unarchive team option
		base.buttonClick(archiveorUnarchiveTeamObj.Ele_UnarchivedText("search-result-archive-wrap mt-3", "AA new", "Unarchive Team"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Team Unarchived Successfully")), "User is unable to receive 'Team Unarchived Successfully' wih OK should popup when click on Unarchive team option");
	}
	//<Summary>
	//Test case Title:Verify that the team should be unarchived from the Archived List
	//Automation ID:Archive_12
	//</Summary>
	public void Archive_12_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createAndAddNewMemberWithOrWithoutEmailObj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		ArchiveorUnarchiveTeam_TestData archiveorUnarchiveTeamTestData=new ArchiveorUnarchiveTeam_TestData();
		ArchiveorUnarchiveTeam_Obj archiveorUnarchiveTeamObj=new ArchiveorUnarchiveTeam_Obj();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );

		//Step 2:Login to SnipBack
		//Expected:User should able to navigate to the Film page once login with credentials 
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("GAMES"))," User is unable to navigate to the Film page once login with credentials");

		//Step 3:Switch the organization if the User as Admin/Coach
		//Expected:User should able to switch the organisation if the user as Admin/Coach
		base.selectorByVisibleText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"),archiveorUnarchiveTeamTestData.Archive_12_ArchiveorUnarchiveTeam );
		Thread.sleep(3000);
		String organisation=element.DropDownText(createAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(organisation,archiveorUnarchiveTeamTestData.Archive_12_ArchiveorUnarchiveTeam ,"User unable to switch the organisation if the user as Admin/Coach");

		//Step 4:Click search bar and enter a team
		//Expected:User should click search bar and enter a team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"), archiveorUnarchiveTeamTestData.Archive_12_ArchiveorUnarchiveTeam_Search);
		base.pressKey(loginObj.Edt_LoginEmail("searchTeam"),"ENTER");
		base.scrollToElement(loginObj.Edt_AlertMessage("AA DEMO"));
		Thread.sleep(2000);
		String teamValue=base.GetValue(loginObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(teamValue, archiveorUnarchiveTeamTestData.Archive_12_ArchiveorUnarchiveTeam_Search,"User is unable to click search bar and enter a team");

		//Step 5:Click on Three dots
		//Expected: User is able to click on three dots of the team
		Thread.sleep(5000);
		base.buttonClick(createAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-9"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_ArchiveOptionText("teamDropdownMenu-9","Archive Team")), "User is unable to click three dots of the team");

		//Step 6:Click on Archive team
		//Expected:User is able to click on Archive team
		Thread.sleep(3000);
		base.buttonClick(archiveorUnarchiveTeamObj.Ele_ArchiveOptionText("teamDropdownMenu-9","Archive Team"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Are you sure want to archive this team?")), "User is unable to click on Archive team");

		//Step 7:Click on Yes
		//Expected:User should able to click Yes
		base.buttonClick(snipBackLoginObj.Btn_Signin("Yes"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Team Archived Successfully")), "User is unable to click 'Yes'");

		//Step 8:Click on OK
		//Expected:User should be able to click OK
		Thread.sleep(4000);
		base.buttonClick(snipBackLoginObj.Btn_Signin("OK"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_ArchivedTeam("search-result-archive-wrap mt-3", "AA new")), "User is unable to click OK");

		//Step 9:Click on three dots against the Archive Team
		//Expected:User should be able to click on three dots against the Archive Team
		base.buttonClick(archiveorUnarchiveTeamObj.Ele_UnarchivedTeam("search-result-archive-wrap mt-3", "AA new", "all-teams-menu cursor-pointer"));
		asrt.assertTrue(base.isExists(archiveorUnarchiveTeamObj.Ele_UnarchivedText("search-result-archive-wrap mt-3", "AA new", "Unarchive Team")), "User is unable to click on three dots against the Archive Team");

		//Step 10:Click on Unarchive team
		//Expected:The team should be unarchived from the Archived List
		base.buttonClick(archiveorUnarchiveTeamObj.Ele_UnarchivedText("search-result-archive-wrap mt-3", "AA new", "Unarchive Team"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Team Unarchived Successfully")), "User is unable to receive 'Team Unarchived Successfully' wih OK should popup when click on Unarchive team option");

		//Step 11:Click on OK on pop up
		//Expected:The team should be unarchived from the Archived List
		base.buttonClick(snipBackLoginObj.Btn_Signin("OK"));
		asrt.assertTrue(base.isDoesNotExistBool(archiveorUnarchiveTeamObj.Ele_ArchivedTeam("search-result-archive-wrap mt-3", "AA new")), "The team is not unarchived from the Archive List");
	}

}
