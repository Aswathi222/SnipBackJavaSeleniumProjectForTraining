package testPage.MavenPageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestData.AddorEditInfo_TestData;
import TestData.CommonData;
import TestData.CreateEditDeletePool_TestData;
import TestData.SearchGamesTeamAndMembers_TestData;
import objectRepository.AddorEditInfo_Obj;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;

public class AddorEditInfo extends BasePge{
	BasePge base;
	Assert asrt;
	ElementActions element;

	public AddorEditInfo(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
		element=new ElementActions(driver);
	}
	//<Summary>
	//Test case Title:Verify whether there is an option as Add Info in the Games Listing page.
	//Automation ID: AI_01
	//</Summary>
	public void AI_01_AddEditInfo() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		AddorEditInfo_Obj addorEditInfoObj=new AddorEditInfo_Obj();
		AddorEditInfo_TestData addorEditInfoTestData=new AddorEditInfo_TestData();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1: Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		//Step 2: Click Login button
		//Expected: user should be able to login to the SnipBack
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to login to SnipBack");

		//step 3:Go to Film page
		//Expected: User should be able to click film
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("POOLS")), "User is unable to click the Film");

		//step 4:Click Games
		//Expected:User should be able to click Games
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click Games");

		//step 5:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"), addorEditInfoTestData.AI_01_AddorEditInfo);
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("AI_01_AddInfo")), "User is unable to click search bar and enter a game");

		//step 6:Click three dots of any game
		//Expected:There should be a option as Add Info in Games Listing page.
		Thread.sleep(1000);
		base.buttonClick(addorEditInfoObj.Ele_ThreeDots("AI_01_AddInfo", "btn-group dropleft right-menu-wrap"));
		asrt.assertTrue(base.isExists(addorEditInfoObj.Ele_ThreeDotsText("AI_01_AddInfo", "Add Info")), "User is unable to see a option as Add Info in Game listng page");
	}
	//<Summary>
	//Test case Title:Verify whether Add Info option is available for Completed Games.
	//Automation ID: AI_02
	//</Summary>
	public void AI_02_AddEditInfo() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		AddorEditInfo_Obj addorEditInfoObj=new AddorEditInfo_Obj();
		AddorEditInfo_TestData addorEditInfoTestData=new AddorEditInfo_TestData();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1: Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		//Step 2: Click Login button
		//Expected: user should be able to login to the SnipBack
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to login to SnipBack");

		//step 3:Go to Film page
		//Expected: User should be able to click film
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("POOLS")), "User is unable to click the Film");

		//step 4:Click Games
		//Expected:User should be able to click Games
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click Games");

		//step 5:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"), addorEditInfoTestData.AI_02_AddorEditInfo);
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("AI_02_AddInfo")), "User is unable to click search bar and enter a game");

		//step 6:Click three dots of a Completed Game
		//Expected:Add Info option should be available for Completed Games.
		Thread.sleep(1000);
		base.buttonClick(addorEditInfoObj.Ele_ThreeDots("AI_02_AddInfo", "btn-group dropleft right-menu-wrap"));
		asrt.assertTrue(base.isExists(addorEditInfoObj.Ele_ThreeDotsText("AI_02_AddInfo", "Add Info")), "User is unable to see an option as Add Info in completed games");
	}
	//<Summary>
	//Test case Title:Verify whether the Add Info option is available for In-progress Games.
	//Automation ID: AI_03
	//</Summary>
	public void AI_03_AddEditInfo() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		AddorEditInfo_Obj addorEditInfoObj=new AddorEditInfo_Obj();
		AddorEditInfo_TestData addorEditInfoTestData=new AddorEditInfo_TestData();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1: Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		//Step 2: Click Login button
		//Expected: user should be able to login to the SnipBack
		Thread.sleep(1000);
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to login to SnipBack");

		//step 3:Go to Film page
		//Expected: User should be able to click film
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("POOLS")), "User is unable to click the Film");

		//step 4:Click Games
		//Expected:User should be able to click Games
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click Games");

		//step 5:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"),addorEditInfoTestData.AI_03_AddorEditInfo );
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("AI_03_AddInfo")), "User is unable to click search bar and enter a game");

		//step 5: Click three dots of a In-progress Game
		//Expected:Add Info option should not be available for In-progress Games.
		base.buttonClick(addorEditInfoObj.Ele_ThreeDots("AI_03_AddInfo", "btn-group dropleft right-menu-wrap"));
		asrt.assertTrue(base.isDoesNotExistBool(addorEditInfoObj.Ele_ThreeDotsText("AI_03_AddInfo", "Add Info")),"User is able to see Add info in 'In progress' games");
	}
	//<Summary>
	//Test case Title:Verify what happens when user clicks Add Info option.
	//Automation ID: AI_04
	//</Summary>
	public void AI_04_AddEditInfo() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		AddorEditInfo_Obj addorEditInfoObj=new AddorEditInfo_Obj();
		AddorEditInfo_TestData addorEditInfoTestData=new AddorEditInfo_TestData();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();

		//Step 1: Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		//Step 2: Click Login button
		//Expected: user should be able to login to the SnipBack
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to login to SnipBack");

		//step 3:Go to Film page
		//Expected: User should be able to click film
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("POOLS")), "User is unable to click the Film");

		//step 4:Click Games
		//Expected:User should be able to click Games
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click Games");

		//step 5:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"),addorEditInfoTestData.AI_04_AddorEditInfo );
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("AI_04_AddInfo")), "User is unable to click search bar and enter a game");

		//step 6:Click three dots of a Completed Game
		//Expected:User should click three dots of completed games
		Thread.sleep(3000);
		base.buttonClick(addorEditInfoObj.Ele_ThreeDots("AI_04_AddInfo", "btn-group dropleft right-menu-wrap"));
		asrt.assertTrue(base.isExists(addorEditInfoObj.Ele_ThreeDotsText("AI_04_AddInfo", "Add Info")), "User is unable to see an option as Add Info in completed games");

		//step 7: Select Add Info
		//Expected:The user should navigate to Score entering pop up for  My Team(Home) and Opponent Team(Away).
		base.buttonClick(addorEditInfoObj.Ele_ThreeDotsText("AI_04_AddInfo", "Add Info"));
		asrt.assertTrue((base.isExists(addorEditInfoObj.Ele_AddInfoText("HOME")) && (base.isExists(addorEditInfoObj.Ele_AddInfoText("AWAY")))), "User is unable to navigate to score entering pop up for My team(Home) & Opponent Team(Away)");
	}
	//<Summary>
	//Test case Title:Verify what happens when user enters alphabets and special characters in the score field.
	//Automation ID: AI_05
	//</Summary>
	public void AI_05_AddEditInfo() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		AddorEditInfo_Obj addorEditInfoObj=new AddorEditInfo_Obj();
		AddorEditInfo_TestData addorEditInfoTestData=new AddorEditInfo_TestData();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();
		ScheduleUnscheduleGames_Obj scheduleUnscheduleGamesObj=new ScheduleUnscheduleGames_Obj();

		//Step 1: Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		//Step 2: Click Login button
		//Expected: user should be able to login to the SnipBack
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to login to SnipBack");

		//step 3:Go to Film page
		//Expected: User should be able to click film
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("POOLS")), "User is unable to click the Film");

		//step 4:Click Games
		//Expected:User should be able to click Games
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click Games");

		//step 5:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"),addorEditInfoTestData.AI_05_AddorEditInfo );
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("AI_05_AddInfo")), "User is unable to click search bar and enter a game");

		//step 6:Click three dots of a Completed Game
		//Expected:User should click three dots of completed games
		Thread.sleep(3000);
		base.buttonClick(addorEditInfoObj.Ele_ThreeDots("AI_05_AddInfo", "btn-group dropleft right-menu-wrap"));
		asrt.assertTrue(base.isExists(addorEditInfoObj.Ele_ThreeDotsText("AI_05_AddInfo", "Add Info")), "User is unable to see an option as Add Info in completed games");

		//step 7: Select Add Info
		//Expected:The user should navigate to Score entering pop up for  My Team(Home) and Opponent Team(Away).
		base.buttonClick(addorEditInfoObj.Ele_ThreeDotsText("AI_05_AddInfo", "Add Info"));
		asrt.assertTrue((base.isExists(addorEditInfoObj.Ele_AddInfoText("HOME")) && (base.isExists(addorEditInfoObj.Ele_AddInfoText("AWAY")))), "User is unable to navigate to score entering pop up for My team(Home) & Opponent Team(Away)");

		//step 8:Enter the score(HOME)
		//Expected: User should enter the score(HOME)
		base.setData(loginObj.Edt_LoginEmail("home_team_point"),addorEditInfoTestData.AI_05_AddInfoHome );
		String home=base.GetValue(loginObj.Edt_LoginEmail("home_team_point"));
		asrt.assertEquals(home, addorEditInfoTestData.AI_05_AddInfoHome,"User is unable to enter in the score(HOME)");

		//step 9: Enter the score(AWAY)
		//Expected: User should enter score(AWAY)
		base.setData(loginObj.Edt_LoginEmail("away_team_point"),addorEditInfoTestData.AI_05_AddInfoAway);
		String away=base.GetValue(loginObj.Edt_LoginEmail("away_team_point"));
		asrt.assertEquals(away, addorEditInfoTestData.AI_05_AddInfoAway,"User is unable to enter in the score(AWAY)");

		//step 10:Click Save
		//Expected:The user will receive alert message as "Invalid Point"
		base.buttonClick(scheduleUnscheduleGamesObj.Btn_Create("btn btn-primary save-btn", "SAVE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Invalid point")), "User is not getting an alert message as 'Invalid Point'");		
	}
	//<Summary>
	//Test case Title:Verify what happens when user left the HOME score field empty.
	//Automation ID: AI_06
	//</Summary>
	public void AI_06_AddEditInfo() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		AddorEditInfo_Obj addorEditInfoObj=new AddorEditInfo_Obj();
		AddorEditInfo_TestData addorEditInfoTestData=new AddorEditInfo_TestData();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();
		ScheduleUnscheduleGames_Obj scheduleUnscheduleGamesObj=new ScheduleUnscheduleGames_Obj();

		//Step 1: Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		//Step 2: Click Login button
		//Expected: user should be able to login to the SnipBack
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to login to SnipBack");

		//step 3:Go to Film page
		//Expected: User should be able to click film
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("POOLS")), "User is unable to click the Film");

		//step 4:Click Games
		//Expected:User should be able to click Games
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click Games");

		//step 5:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"),addorEditInfoTestData.AI_06_AddorEditInfo);
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("AI_06_AddInfo")), "User is unable to click search bar and enter a game");

		//step 6:Click three dots of a Completed Game
		//Expected:User should click three dots of completed games
		Thread.sleep(3000);
		base.buttonClick(addorEditInfoObj.Ele_ThreeDots("AI_06_AddInfo", "btn-group dropleft right-menu-wrap"));
		asrt.assertTrue(base.isExists(addorEditInfoObj.Ele_ThreeDotsText("AI_06_AddInfo", "Add Info")), "User is unable to see an option as Add Info in completed games");

		//step 7: Select Add Info
		//Expected:The user should navigate to Score entering pop up for  My Team(Home) and Opponent Team(Away).
		base.buttonClick(addorEditInfoObj.Ele_ThreeDotsText("AI_06_AddInfo", "Add Info"));
		asrt.assertTrue((base.isExists(addorEditInfoObj.Ele_AddInfoText("HOME")) && (base.isExists(addorEditInfoObj.Ele_AddInfoText("AWAY")))), "User is unable to navigate to score entering pop up for My team(Home) & Opponent Team(Away)");

		//step 8: Enter the score(AWAY)
		//Expected: User should enter score(AWAY)
		base.setData(loginObj.Edt_LoginEmail("away_team_point"),addorEditInfoTestData.AI_06_AddInfoAway);
		String away=base.GetValue(loginObj.Edt_LoginEmail("away_team_point"));
		asrt.assertEquals(away, addorEditInfoTestData.AI_06_AddInfoAway,"User is unable to enter in the score(AWAY)");

		//step 9:Click Save
		//Expected:The user will receive alert message as "Please add point for home team."
		base.buttonClick(scheduleUnscheduleGamesObj.Btn_Create("btn btn-primary save-btn", "SAVE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Please add point for home team")), "User is not getting an alert message as 'Please add point for home team'");		
	}
	//<Summary>
	//Test case Title:Verify what happens when user left the AWAY score field empty.
	//Automation ID: AI_07
	//</Summary>
	public void AI_07_AddEditInfo() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		AddorEditInfo_Obj addorEditInfoObj=new AddorEditInfo_Obj();
		AddorEditInfo_TestData addorEditInfoTestData=new AddorEditInfo_TestData();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();
		ScheduleUnscheduleGames_Obj scheduleUnscheduleGamesObj=new ScheduleUnscheduleGames_Obj();

		//Step 1: Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		//Step 2: Click Login button
		//Expected: user should be able to login to the SnipBack
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to login to SnipBack");

		//step 3:Go to Film page
		//Expected: User should be able to click film
		Thread.sleep(1000);
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("POOLS")), "User is unable to click the Film");

		//step 4:Click Games
		//Expected:User should be able to click Games
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click Games");

		//step 5:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"),addorEditInfoTestData.AI_07_AddorEditInfo);
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("AI_07_AddInfo")), "User is unable to click search bar and enter a game");

		//step 6:Click three dots of a Completed Game
		//Expected:User should click three dots of completed games
		Thread.sleep(3000);
		base.buttonClick(addorEditInfoObj.Ele_ThreeDots("AI_07_AddInfo", "btn-group dropleft right-menu-wrap"));
		asrt.assertTrue(base.isExists(addorEditInfoObj.Ele_ThreeDotsText("AI_07_AddInfo", "Add Info")), "User is unable to see an option as Add Info in completed games");

		//step 7: Select Add Info
		//Expected:The user should navigate to Score entering pop up for  My Team(Home) and Opponent Team(Away).
		base.buttonClick(addorEditInfoObj.Ele_ThreeDotsText("AI_07_AddInfo", "Add Info"));
		asrt.assertTrue((base.isExists(addorEditInfoObj.Ele_AddInfoText("HOME")) && (base.isExists(addorEditInfoObj.Ele_AddInfoText("AWAY")))), "User is unable to navigate to score entering pop up for My team(Home) & Opponent Team(Away)");

		//step 8:Enter the score(HOME)
		//Expected: User should enter the score(HOME)
		base.setData(loginObj.Edt_LoginEmail("home_team_point"),addorEditInfoTestData.AI_07_AddInfoHome );
		String home=base.GetValue(loginObj.Edt_LoginEmail("home_team_point"));
		asrt.assertEquals(home, addorEditInfoTestData.AI_07_AddInfoHome,"User is unable to enter in the score(HOME)");

		//step 9:Click Save
		//Expected:The user will receive alert message as "Please add point for away team."
		base.buttonClick(scheduleUnscheduleGamesObj.Btn_Create("btn btn-primary save-btn", "SAVE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Please add point for away team")), "User is not getting an alert message as 'Please add point for away team.'");		
	}
	//<Summary>
	//Test case Title:Verify what happen when user left both fields empty.
	//Automation ID: AI_08
	//</Summary>
	public void AI_08_AddEditInfo() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		AddorEditInfo_Obj addorEditInfoObj=new AddorEditInfo_Obj();
		AddorEditInfo_TestData addorEditInfoTestData=new AddorEditInfo_TestData();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();
		ScheduleUnscheduleGames_Obj scheduleUnscheduleGamesObj=new ScheduleUnscheduleGames_Obj();

		//Step 1: Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		//Step 2: Click Login button
		//Expected: user should be able to login to the SnipBack
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to login to SnipBack");

		//step 3:Go to Film page
		//Expected: User should be able to click film
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("POOLS")), "User is unable to click the Film");

		//step 4:Click Games
		//Expected:User should be able to click Games
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click Games");

		//step 5:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"),addorEditInfoTestData.AI_08_AddorEditInfo);
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("AI_08_AddInfo")), "User is unable to click search bar and enter a game");

		//step 6:Click three dots of a Completed Game
		//Expected:User should click three dots of completed games
		Thread.sleep(3000);
		base.buttonClick(addorEditInfoObj.Ele_ThreeDots("AI_08_AddInfo", "btn-group dropleft right-menu-wrap"));
		asrt.assertTrue(base.isExists(addorEditInfoObj.Ele_ThreeDotsText("AI_08_AddInfo", "Add Info")), "User is unable to see an option as Add Info in completed games");

		//step 7: Select Add Info
		//Expected:The user should navigate to Score entering pop up for  My Team(Home) and Opponent Team(Away).
		base.buttonClick(addorEditInfoObj.Ele_ThreeDotsText("AI_08_AddInfo", "Add Info"));
		asrt.assertTrue((base.isExists(addorEditInfoObj.Ele_AddInfoText("HOME")) && (base.isExists(addorEditInfoObj.Ele_AddInfoText("AWAY")))), "User is unable to navigate to score entering pop up for My team(Home) & Opponent Team(Away)");

		//step 8:Click Save
		//Expected:The user will receive alert message as "Please add point for home team."
		base.buttonClick(scheduleUnscheduleGamesObj.Btn_Create("btn btn-primary save-btn", "SAVE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Please add point for home team")), "User is not getting an alert message as 'Please add point for home team.'");		
	}
	//<Summary>
	//Test case Title:Verify what happens when user enters score values beyond the limit.
	//Automation ID: AI_09
	//</Summary>
	public void AI_09_AddEditInfo() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		AddorEditInfo_Obj addorEditInfoObj=new AddorEditInfo_Obj();
		AddorEditInfo_TestData addorEditInfoTestData=new AddorEditInfo_TestData();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();
		ScheduleUnscheduleGames_Obj scheduleUnscheduleGamesObj=new ScheduleUnscheduleGames_Obj();

		//Step 1: Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		//Step 2: Click Login button
		//Expected: user should be able to login to the SnipBack
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to login to SnipBack");

		//step 3:Go to Film page
		//Expected: User should be able to click film
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("POOLS")), "User is unable to click the Film");

		//step 4:Click Games
		//Expected:User should be able to click Games
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click Games");

		//step 5:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"),addorEditInfoTestData.AI_09_AddorEditInfo );
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("AI_09_AddInfo")), "User is unable to click search bar and enter a game");

		//step 6:Click three dots of a Completed Game
		//Expected:User should click three dots of completed games
		Thread.sleep(4000);
		base.buttonClick(addorEditInfoObj.Ele_ThreeDots("AI_09_AddInfo", "btn-group dropleft right-menu-wrap"));
		asrt.assertTrue(base.isExists(addorEditInfoObj.Ele_ThreeDotsText("AI_09_AddInfo", "Add Info")), "User is unable to see an option as Add Info in completed games");

		//step 7: Select Add Info
		//Expected:The user should navigate to Score entering pop up for  My Team(Home) and Opponent Team(Away).
		base.buttonClick(addorEditInfoObj.Ele_ThreeDotsText("AI_09_AddInfo", "Add Info"));
		asrt.assertTrue((base.isExists(addorEditInfoObj.Ele_AddInfoText("HOME")) && (base.isExists(addorEditInfoObj.Ele_AddInfoText("AWAY")))), "User is unable to navigate to score entering pop up for My team(Home) & Opponent Team(Away)");

		//step 8:Enter the score(HOME)
		//Expected: User should enter the score(HOME)
		base.setData(loginObj.Edt_LoginEmail("home_team_point"),addorEditInfoTestData.AI_09_AddInfoHome );
		String home=base.GetValue(loginObj.Edt_LoginEmail("home_team_point"));
		asrt.assertEquals(home, addorEditInfoTestData.AI_09_AddInfoHome,"User is unable to enter in the score(HOME)");

		//step 9: Enter the score(AWAY)
		//Expected: User should enter score(AWAY)
		base.setData(loginObj.Edt_LoginEmail("away_team_point"),addorEditInfoTestData.AI_09_AddInfoAway);
		String away=base.GetValue(loginObj.Edt_LoginEmail("away_team_point"));
		asrt.assertEquals(away, addorEditInfoTestData.AI_09_AddInfoAway,"User is unable to enter in the score(AWAY)");

		//step 10:Click Save
		//Expected:The user will receive alert message as "Invalid Point"
		base.buttonClick(scheduleUnscheduleGamesObj.Btn_Create("btn btn-primary save-btn", "SAVE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Invalid point")), "User is not getting an alert message as 'Invalid Point'");		
	}
}
