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
}

