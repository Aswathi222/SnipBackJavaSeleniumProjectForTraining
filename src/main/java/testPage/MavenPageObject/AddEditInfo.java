package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestData.AddEditInfo_TestData;
import TestData.CommonData;
import TestData.SnipBackLogin_TestData;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.ViewProfile_Obj;
import objectRepository.AddEditInfo_Obj;
import objectRepository.AddFollower_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;

public class AddEditInfo extends BasePge {

	BasePge base;
	Assert asrt; 

	public AddEditInfo(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify whether there is an option as Add Info in the Games Listing page."
	// Automation ID   : AI_01 
	// </summary>
	public void AI_01_AddEditInfo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddEditInfo_TestData AEITestData = new AddEditInfo_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to games page in Snipback" );

		//Step 5   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AEITestData.AI_01_OrgName);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 6 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AEITestData.AI_01_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_01_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_01_TeamName)), "Failed to select TEAM");
	    Thread.sleep(8000);
		
		//Step 7   :"Click the three dots of GameName"
		//Expected :"There should be a option as Add Info in Games Listing page."
		base.scrollToElement(addeditinfObj.Btn_Threedot(AEITestData.AI_01_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AEITestData.AI_01_EventID,"dropdownMenuButton1"));
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Add Info")), "User not able to view the option as Add Info in Games Listing page.");

	}

	// <summary>
	// Test Case Title :"To verify whether Add Info option is available for Completed Games."
	// Automation ID   : AI_02 
	// </summary>
	public void AI_02_AddEditInfo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddEditInfo_TestData AEITestData = new AddEditInfo_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to games page in Snipback");

		//Step 5   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AEITestData.AI_02_OrgName);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 6 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AEITestData.AI_02_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_02_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_02_TeamName)), "Failed to select TEAM");
	    Thread.sleep(8000);
		
		//Step 7   :"Click the three dots of Completed Game in Game page of Snipback"
		//Expected :"Add Info option should be available for Completed Games."
		base.scrollToElement(addeditinfObj.Btn_Threedot(AEITestData.AI_02_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AEITestData.AI_02_EventID,"dropdownMenuButton1"));
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Add Info")), "Add Info option is not available for Completed Games.");

	}
	// <summary>
	// Test Case Title :"To verify whether the Add Info option is available for In-progress Games."
	// Automation ID   : AI_03 
	// </summary>
	public void AI_03_AddEditInfo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddEditInfo_TestData AEITestData = new AddEditInfo_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to games page in Snipback");

		//Step 5   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AEITestData.AI_03_OrgName);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 6 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AEITestData.AI_03_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_03_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_03_TeamName)), "Failed to select TEAM");
	    Thread.sleep(8000);
	    
		//Step 7   :"Click the three dots of In-Progress Game in Game page of Snipback"
		//Expected :"Add Info option should not be available for In-progress Games."
		base.scrollToElement(addeditinfObj.Btn_Threedot(AEITestData.AI_03_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AEITestData.AI_03_EventID,"dropdownMenuButton1"));
		base.isDoesNotExist(addeditinfObj.Ele_AddInfo("Add Info"), "User able to see the 'Add Info' option under the three dots in the Games Page");
		//asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Add Info")), "Add Info option is not available for In-progress Games.");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks Add Info option."
	// Automation ID   : AI_04 
	// </summary>

	public void AI_04_AddEditInfo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddEditInfo_TestData AEITestData = new AddEditInfo_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to games page in Snipback");

		//Step 5   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AEITestData.AI_04_OrgName);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 6 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AEITestData.AI_04_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_04_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_04_TeamName)), "Failed to select TEAM");
	    Thread.sleep(8000);
		
		//Step 7   :"Click the three dots of Completed Game in Game page of Snipback"
		//Expected :"User should be click three dots of Completed Game and also should be display the AddInfo option in three dots of Completed games of Snipback "
		base.scrollToElement(addeditinfObj.Btn_Threedot(AEITestData.AI_04_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AEITestData.AI_04_EventID,"dropdownMenuButton1"));
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Add Info")), "User not able to view Add Info option when click on the three dots of the In-Progress game in Snipback");

		//Step 8   :"Click the AddInfo option of Completed Game in Game page of Snipback"
		//Expected :"The user should navigate to Score entering pop up for  My Team(Home) and Opponent Team(Away)."
		base.buttonClick(addeditinfObj.Ele_AddInfo("Add Info"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("HOME")), "User not able to view Score entering popup up for My Team(Home) and Opponent Team(Away)");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters alphabets and special characters in the score field."
	// Automation ID   : AI_05 
	// </summary>
	public void AI_05_AddEditInfo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		AddEditInfo_TestData AEITestData = new AddEditInfo_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to games page in Snipback");

		//Step 5   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AEITestData.AI_05_OrgName);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");
		
		//Step 6 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AEITestData.AI_05_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_05_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_05_TeamName)), "Failed to select TEAM");
	    Thread.sleep(8000);

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8   :"Click three dots of a Completed Game"
		//Expected :"User should click three dots of Completed Game and view the AddInfo option in three dots of Completed games of Snipback "
		base.scrollToElement(addeditinfObj.Btn_Threedot(AEITestData.AI_05_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AEITestData.AI_05_EventID,"dropdownMenuButton1"));
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Add Info")), "User not able to view Add Info option when click on the three dots of the In-Progress game in Snipback");

		//Step 9   :"Select Add Info"
		//Expected :"User should click AddInfo of Completed Game and view the Score entering popup up for My Team(Home) and Opponent Team(Away) of Snipback "
		base.buttonClick(addeditinfObj.Ele_AddInfo("Add Info"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("HOME")), "User not able to view Score entering popup up for My Team(Home) and Opponent Team(Away) of Snipback");

		//Step 10   :"Enter the score(HOME)"
		//Expected :"User should enter the Score in HOME Score field of Score entering popup in snipback page"
		base.buttonClick(addeditinfObj.Ele_ScoreFields("home_team_point"));
		base.setData(addeditinfObj.Ele_ScoreFields("home_team_point"),AEITestData.AI_05_HomeScoreSpecial);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_ScoreFields("home_team_point")), "User not able to enter the alphabets and special character in HOME Score field of Score entering popup in snipback page");

		//Step 11   :"Enter the score(AWAY)"
		//Expected :"User should enter the Score in AWAY Score field of Score entering popup in snipback page"
		base.buttonClick(addeditinfObj.Ele_ScoreFields("away_team_point"));
		base.setData(addeditinfObj.Ele_ScoreFields("away_team_point"),AEITestData.AI_05_AwayScoreSpecial);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_ScoreFields("away_team_point")), "User not able to enter the alphabets and special character in AWAY Score field of Score entering popup in snipback page");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn")), "User not able to click the Save icon in snipback page");
		
		//Step 12   :"Click Save"
		//Expected :"The user will receive alert message as "Invalid Point"
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpMinConfPassword("commonValidateErr active")), "The user is not able to receive alert message as \"Invalid Point\"");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user left the HOME score field empty."
	// Automation ID   : AI_06
	// </summary>
	public void AI_06_AddEditInfo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		AddEditInfo_TestData AEITestData = new AddEditInfo_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to games page in Snipback");

		//Step 5   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AEITestData.AI_06_OrgName);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 6 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AEITestData.AI_06_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_06_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_06_TeamName)), "Failed to select TEAM");
	    Thread.sleep(8000);
		
		//Step 7   :"Click three dots of a Completed Game"
		//Expected :"User should click three dots of Completed Game and view the AddInfo option in three dots of Completed games of Snipback "
		base.scrollToElement(addeditinfObj.Btn_Threedot(AEITestData.AI_06_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AEITestData.AI_06_EventID,"dropdownMenuButton1"));
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Add Info")), "User not able to view Add Info option when click on the three dots of the In-Progress game in Snipback");

		//Step 8   :"Select Add Info"
		//Expected :"User should click AddInfo of Completed Game and view the Score entering popup up for My Team(Home) and Opponent Team(Away) of Snipback "
		base.buttonClick(addeditinfObj.Ele_AddInfo("Add Info"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("HOME")), "User not able to view Score entering popup up for My Team(Home) and Opponent Team(Away) of Snipback");

		//Step 9   :"Enter the score(AWAY)"
		//Expected :"User should enter the Score in AWAY Score field of Score entering popup in snipback page"
		base.buttonClick(addeditinfObj.Ele_ScoreFields("away_team_point"));
		base.setData(addeditinfObj.Ele_ScoreFields("away_team_point"),AEITestData.AI_06_AwayScore);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_ScoreFields("away_team_point")), "User not able to enter the Score in AWAY Score field of Score entering popup in snipback page");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn")), "User not able to click Save button in snipback page");
		
		//Step 10   :"Click Save 
		//Expected :"The user will receive alert message as "Please add point for home team.""
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Please add point for home team")), "User not able to receive alert message as \"Please add point for home team");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user left the AWAY score field empty."
	// Automation ID   : AI_07
	// </summary>
	public void AI_07_AddEditInfo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		AddEditInfo_TestData AEITestData = new AddEditInfo_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to games page in Snipback");

		//Step 5   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AEITestData.AI_07_OrgName);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 6 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AEITestData.AI_07_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_07_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_07_TeamName)), "Failed to select TEAM");
	    Thread.sleep(8000);
		
		//Step 7   :"Click three dots of a Completed Game"
		//Expected :"User should click three dots of Completed Game and view the AddInfo option in three dots of Completed games of Snipback "
		base.scrollToElement(addeditinfObj.Btn_Threedot(AEITestData.AI_07_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AEITestData.AI_07_EventID,"dropdownMenuButton1"));
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Add Info")), "User not able to view Add Info option when click on the three dots of the In-Progress game in Snipback");

		//Step 8   :"Select Add Info"
		//Expected :"User should click AddInfo of Completed Game and view the Score entering popup up for My Team(Home) and Opponent Team(Away) of Snipback "
		base.buttonClick(addeditinfObj.Ele_AddInfo("Add Info"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("HOME")), "User not able to view Score entering popup up for My Team(Home) and Opponent Team(Away) of Snipback");

		//Step 9   :"Enter the score(HOME)"
		//Expected :"User should enter the Score in HOME Score field of Score entering popup in snipback page"
		base.buttonClick(addeditinfObj.Ele_ScoreFields("home_team_point"));
		base.setData(addeditinfObj.Ele_ScoreFields("home_team_point"),AEITestData.AI_07_HomeScore);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_ScoreFields("home_team_point")), "User not able to enter the Score in HOME Score field of Score entering popup in snipback page");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn")), "User not able click Save button in snipback page");
		
		//Step 10   :"Click Save "
		//Expected :"The user will receive alert message as "Please add point for away team.""
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Please add point for away team")), "User not able to receive alert message as \"Please add point for away team");
	}

	// <summary>
	// Test Case Title :"To verify what happen when user left both fields empty."
	// Automation ID   : AI_08
	// </summary>
	public void AI_08_AddEditInfo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		AddEditInfo_TestData AEITestData = new AddEditInfo_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to games page in Snipback");

		//Step 5   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AEITestData.AI_08_OrgName);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 6 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AEITestData.AI_08_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_08_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_08_TeamName)), "Failed to select TEAM");
	    Thread.sleep(8000);
		
		//Step 7   :"Click three dots of a Completed Game"
		//Expected :"User should click three dots of Completed Game and view the AddInfo option in three dots of Completed games of Snipback "
		base.scrollToElement(addeditinfObj.Btn_Threedot(AEITestData.AI_08_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AEITestData.AI_08_EventID,"dropdownMenuButton1"));
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Add Info")), "User not able to view Add Info option when click on the three dots of the In-Progress game in Snipback");

		//Step 8   :"Select Add Info"
		//Expected :"User should click AddInfo of Completed Game and view the Score entering popup up for My Team(Home) and Opponent Team(Away) of Snipback "
		base.buttonClick(addeditinfObj.Ele_AddInfo("Add Info"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("HOME")), "User not able to view Score entering popup up for My Team(Home) and Opponent Team(Away) of Snipback");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn")), "User is not able to click Save button in snipback page");
		
		//Step 9   :"Click Save"
		//Expected :"The user will receive alert message as "Please add point for home team."
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Please add point for home team")), "User is not able to receive alert message as \"Please add point for home team");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters score values beyond the limit."
	// Automation ID   : AI_09
	// </summary>
	public void AI_09_AddEditInfo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		AddEditInfo_TestData AEITestData = new AddEditInfo_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to games page in Snipback");

		//Step 5   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AEITestData.AI_09_OrgName);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 6 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AEITestData.AI_09_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_09_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_09_TeamName)), "Failed to select TEAM");
	    Thread.sleep(8000);
		
		//Step 7   :"Click three dots of a Completed Game"
		//Expected :"User should click three dots of Completed Game and view the AddInfo option in three dots of Completed games of Snipback "
		base.scrollToElement(addeditinfObj.Btn_Threedot(AEITestData.AI_09_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AEITestData.AI_09_EventID,"dropdownMenuButton1"));
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Add Info")), "User not able to view Add Info option when click on the three dots of the In-Progress game in Snipback");

		//Step 8   :"Select Add Info"
		//Expected :"User should click AddInfo of Completed Game and view the Score entering popup up for My Team(Home) and Opponent Team(Away) of Snipback "
		base.buttonClick(addeditinfObj.Ele_AddInfo("Add Info"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("HOME")), "User not able to view Score entering popup up for My Team(Home) and Opponent Team(Away) of Snipback");

		//Step 9   :"Enter the score(HOME)"
		//Expected :"User should be enter beyond the limit Score in HOME Score field of Score entering popup in snipback page"
		base.buttonClick(addeditinfObj.Ele_ScoreFields("home_team_point"));
		base.setData(addeditinfObj.Ele_ScoreFields("home_team_point"),AEITestData.AI_09_HomeScoreBeyondlimit);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_ScoreFields("home_team_point")), "User not able to enter beyond the limit Score in HOME Score field of Score entering popup in snipback page");

		//Step 10   :"Enter the score(AWAY)"
		//Expected :"User should be enter beyond the limit Score in AWAY Score field of Score entering popup in snipback page"
		base.buttonClick(addeditinfObj.Ele_ScoreFields("away_team_point"));
		base.setData(addeditinfObj.Ele_ScoreFields("away_team_point"),AEITestData.AI_09_AwayScoreBeyondlimit);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_ScoreFields("away_team_point")), "User not able to enter beyond the limit Score in AWAY Score field of Score entering popup in snipback page");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn")), "User is not able to click Save button in snipback page");
		
		//Step 11   :"Click Save "
		//Expected :"The user will receive alert message as "Invalid Point""
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Invalid point")), "User is not able to receive alert message as \"Invalid Point\"");

	}

	// <summary>
	// Test Case Title :"1. To verify whether the user can enter numeric values in the score field" 2. "To verify whether the user can able to edit the Add Info values."
	// Automation ID   : AI_10 & AI_11
	// </summary>
	public void AI_10_AddEditInfo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		AddEditInfo_TestData AEITestData = new AddEditInfo_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to games page in Snipback");

		//Step 5   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AEITestData.AI_10_OrgName);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 6 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AEITestData.AI_10_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_10_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_10_TeamName)), "Failed to select TEAM");
	    Thread.sleep(8000);
		
		//Step 7   :"Click three dots of a Completed Game"
		//Expected :"User should click three dots of Completed Game and view the AddInfo option in three dots of Completed games of Snipback "
		Thread.sleep(1000);
		base.scrollToElement(addeditinfObj.Btn_Threedot(AEITestData.AI_10_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AEITestData.AI_10_EventID,"dropdownMenuButton1"));
		WebDriverWait wait = new WebDriverWait(driver, 10);  

		try {
			// Check if "Add Info" is displayed
			WebElement addInfoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(addeditinfObj.Ele_AddInfo("Add Info")));
			asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Add Info")), "User able to view 'Add Info' option when clicking on the three dots of the In-Progress game in Snipback");
		} catch (Exception e) {
			// If "Add Info" is not found, check for "Edit Info"
			try {
				WebElement editInfoElement = wait.until(ExpectedConditions.visibilityOfElementLocated((addeditinfObj.Ele_AddInfo("Edit Info"))));
				asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Edit Info")), "User able to view 'Edit Info' option when clicking on the three dots of the In-Progress game in Snipback");
			} catch (Exception ex) {
				asrt.fail("Neither 'Add Info' nor 'Edit Info' options are displayed when clicking on the three dots of the In-Progress game in Snipback.");
			}
		}


		try {   
			base.buttonClick(addeditinfObj.Ele_AddInfo("Add Info"));
			boolean isHomePageDisplayed = base.isExists(RegistrationObj.Ele_RegistrationExists("HOME"));
			asrt.assertTrue(isHomePageDisplayed, "User not able to view Score entering popup for My Team (Home) and Opponent Team (Away) of Snipback");
		} catch (Exception e) {
			// If "Add Info" is not found, check for "Edit Info"
			try {
				base.buttonClick(addeditinfObj.Ele_AddInfo("Edit Info"));
				boolean isHomePageDisplayed = base.isExists(RegistrationObj.Ele_RegistrationExists("HOME"));
				asrt.assertTrue(isHomePageDisplayed, "User not able to view Score entering popup for My Team (Home) and Opponent Team (Away) of Snipback");
			} catch (Exception ex) {
				asrt.fail("Neither 'Add Info' nor 'Edit Info' options are available when clicking on the three dots of the In-Progress game in Snipback.");
			}
		}
		//Step 8   :"Enter the score(HOME)"
		//Expected :"User should be enter the Score in HOME Score field of Score entering popup in snipback page"
		base.buttonClick(addeditinfObj.Ele_ScoreFields("home_team_point"));
		base.setData(addeditinfObj.Ele_ScoreFields("home_team_point"),AEITestData.AI_10_HomeScore);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_ScoreFields("home_team_point")), "User not able to enter the Score in HOME Score field of Score entering popup in snipback page");

		//Step 9   :"Enter the score(AWAY)"
		//Expected :"User should be enter the Score in AWAY Score field of Score entering popup in snipback page"
		base.buttonClick(addeditinfObj.Ele_ScoreFields("away_team_point"));
		base.setData(addeditinfObj.Ele_ScoreFields("away_team_point"),AEITestData.AI_10_AwayScore);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_ScoreFields("away_team_point")), "User not able to enter the Score in AWAY Score field of Score entering popup in snipback page");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn")), "User not able to should be click Save on Score entering popup in snipback page");
		
		//Step 10   :"Click Save on Score entering popup in snipback"
		//Expected :"User should be click Save on Score entering popup in snipback page"
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"'Info added succesfully' success message is not displayed");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
	}
	
	// <summary>
	// Test Case Title :"To verify whether the user can able to change the result of Game.".
	// Automation ID   : AI_12
	// </summary>
	public void AI_12_AddEditInfo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj AddEditInfoObj = new AddEditInfo_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddEditInfo_TestData AEITestData = new AddEditInfo_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Btn_Games("nav-game")),"User not able to navigate to games page in Snipback");

		//Step 5   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AEITestData.AI_12_OrgName);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 6 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AEITestData.AI_12_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_12_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AEITestData.AI_12_TeamName)), "Failed to select TEAM");
	    Thread.sleep(8000);
		
		//Step 7   :"Click the three dots of Completed Game"
		//Expected :"User should click three dots of Completed Game and view the editInfo option in three dots of Completed games of Snipback "
		Thread.sleep(1000);
		base.scrollToElement(AddEditInfoObj.Btn_Threedot(AEITestData.AI_12_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		base.excuteJsClick(AddEditInfoObj.Btn_Threedot(AEITestData.AI_12_EventID,"dropdownMenuButton1"));
		WebDriverWait wait = new WebDriverWait(driver, 10);  

		//Step 8 : "Select edit info"
		//Expected : User is able to view Score entering popup for My Team (Home) and Opponent Team (Away) of Snipback
		base.buttonClick(AddEditInfoObj.Ele_AddInfo("Edit Info"));
		boolean isHomePageDisplayed = base.isExists(RegistrationObj.Ele_RegistrationExists("HOME"));
		asrt.assertTrue(isHomePageDisplayed, "User not able to view Score entering popup for My Team (Home) and Opponent Team (Away) of Snipback");

		//Step 9   :"Enter the score(HOME)"
		//Expected :"User should be enter the Score in HOME Score field of Score entering popup in snipback page"
		base.buttonClick(AddEditInfoObj.Ele_ScoreFields("home_team_point"));
		base.setData(AddEditInfoObj.Ele_ScoreFields("home_team_point"),AEITestData.AI_12_HomeScore);
		asrt.assertTrue(base.isExists(AddEditInfoObj.Ele_ScoreFields("home_team_point")), "User not able to enter the Score in HOME Score field of Score entering popup in snipback page");

		//Step 10   :"Enter the score(AWAY)"
		//Expected :"User should be enter the Score in AWAY Score field of Score entering popup in snipback page"
		base.buttonClick(AddEditInfoObj.Ele_ScoreFields("away_team_point"));
		base.setData(AddEditInfoObj.Ele_ScoreFields("away_team_point"),AEITestData.AI_12_AwayScore);
		asrt.assertTrue(base.isExists(AddEditInfoObj.Ele_ScoreFields("away_team_point")), "User not able to enter the Score in AWAY Score field of Score entering popup in snipback page");

		//Step 11 : "Change WIN to LOSE/viceversa"
		//Expected :The user is able to change WIN to LOSE/viceversa
		base.excuteJsClick(AddEditInfoObj.Ele_SelectWL("switcher-1"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn")),"The user unable to change WIN to LOSE/viceversa");

		//Step 12   :"Click Save on Score entering popup in snipback"
		//Expected :"User is able to edit the result of Game."
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-primary save-btn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"'Info added succesfully' success message is not displayed");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
	}
}

