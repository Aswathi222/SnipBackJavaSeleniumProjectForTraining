package testPage.MavenPageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestData.CommonData;
import TestData.CreateEditDeletePool_TestData;
import TestData.SearchGamesTeamAndMembers_TestData;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;

public class SearchGamesTeamAndMembers extends BasePge{
	BasePge base;
	Assert asrt;
	ElementActions element;

	public SearchGamesTeamAndMembers(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
		element=new ElementActions(driver);
	}
	//<Summary>
	//Test case Title:To verify whether there is a option to search games in Game Listing page.
	//Automation ID: SH_01
	//</Summary>
	public void SH_01_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();

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

		//step 4: Select Games section
		//Expected:There should be a option to search games in Game Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to search games in games listing page.");
	}
	//<Summary>
	//Test case Title:To verify what happens when the user searches games by entering its first letter as keyword in the search field.
	//Automation ID: SH_02
	//</Summary>
	public void SH_02_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		SearchGamesTeamAndMembers_TestData searchGamesTeamAndMembersTestData=new SearchGamesTeamAndMembers_TestData();
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

		//step 4: Select Games section
		//Expected:There should be a option to search games in Game Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to search games in games listing page.");

		//step 5:Click search bar
		//Expected:User should click search bar
		base.buttonClick(loginObj.Edt_LoginEmail("search"));
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_LoginEmail("search")), "User is unable to click search bar");

		//step 6:Enter the first letter of game name
		//Expected:User should enter first letter of game name
		base.setData(loginObj.Edt_LoginEmail("search"), searchGamesTeamAndMembersTestData.SH_02_SearchGamesTeamAndMembers);	
		String searchData=base.GetValue(loginObj.Edt_LoginEmail("search"));
		asrt.assertEquals(searchData, searchGamesTeamAndMembersTestData.SH_02_SearchGamesTeamAndMembers,"User is unable to enter first letter of game name");

		//step 7:Click Enter
		//Expected:User can see list of games with the given first letter.
		base.pressKey(loginObj.Edt_LoginEmail("search"),"KEYBOARD_ENTER" );
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("T-disable")), "User is unable to view the list of games with given first letter");
	}
	//<Summary>
	//Test case Title:To verify what happens when the user search games by entering numbers as keyword in the search field.
	//Automation ID: SH_03
	//</Summary>
	public void SH_03_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		SearchGamesTeamAndMembers_TestData searchGamesTeamAndMembersTestData=new SearchGamesTeamAndMembers_TestData();
		SearchGameTeamAndMembers_Obj searchGameTeamAndMembersObj=new SearchGameTeamAndMembers_Obj();

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

		//step 4: Select Games section
		//Expected:There should be a option to search games in Game Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to search games in games listing page.");

		//step 5:Click search bar
		//Expected:User should click search bar
		base.buttonClick(loginObj.Edt_LoginEmail("search"));
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_LoginEmail("search")), "User is unable to click search bar");

		//step 6: Enter a number
		//Expected:User should enter a number
		base.setData(loginObj.Edt_LoginEmail("search"), searchGamesTeamAndMembersTestData.SH_03_SearchGamesTeamAndMembers_Number);	
		String searchData=base.GetValue(loginObj.Edt_LoginEmail("search"));
		asrt.assertEquals(searchData, searchGamesTeamAndMembersTestData.SH_03_SearchGamesTeamAndMembers_Number,"User is unable to enter number");

		//step 7:Click Enter
		//Expected:User can see list of games with the given number.
		base.pressKey(loginObj.Edt_LoginEmail("search"),"KEYBOARD_ENTER" );
		List<String> gameTexts = base.GetElementTexts(searchGameTeamAndMembersObj.Ele_GameList("table table-striped film-list"));
		asrt.assertTrue(element.isExistsInText(gameTexts, searchGamesTeamAndMembersTestData.SH_03_SearchGamesTeamAndMembers_Number), "User is unable to view the list of games with the given number.");
	}

	//<Summary>
	//Test case Title:To verify what happens when the user searches games by entering special characters as keyword in the search field.
	//Automation ID: SH_04
	//</Summary>
	public void SH_04_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		SearchGamesTeamAndMembers_TestData searchGamesTeamAndMembersTestData=new SearchGamesTeamAndMembers_TestData();

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

		//step 4: Select Games section
		//Expected:There should be a option to search games in Game Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to search games in games listing page.");

		//step 5:Click search bar and enter a special character
		//Expected:User should click search bar and enter a special character
		base.buttonClick(loginObj.Edt_LoginEmail("search"));
		base.setData(loginObj.Edt_LoginEmail("search"), searchGamesTeamAndMembersTestData.SH_04_SearchGamesTeamAndMembers_Special);	
		String searchData=base.GetValue(loginObj.Edt_LoginEmail("search"));
		asrt.assertEquals(searchData, searchGamesTeamAndMembersTestData.SH_04_SearchGamesTeamAndMembers_Special,"User is unable to click search bar and enter special character");

		//step 6:Enter a special character and Click Enter
		//Expected:User can see list of games with the given special character.
		base.pressKey(loginObj.Edt_LoginEmail("search"),"ENTER" );
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("No Data Found")), "User is unable to view the list of games with given special character.");
	}
	//<Summary>
	//Test case Title:Verify what happens when user searches for a game which is not in the list.
	//Automation ID: SH_05
	//</Summary>
	public void SH_05_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		SearchGamesTeamAndMembers_TestData searchGamesTeamAndMembersTestData=new SearchGamesTeamAndMembers_TestData();

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

		//step 4: Select Games section
		//Expected:There should be a option to search games in Game Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to search games in games listing page.");

		//step 5:Click search bar and enter a game name
		//Expected:User should click search bar and enter a game name
		base.buttonClick(loginObj.Edt_LoginEmail("search"));
		base.setData(loginObj.Edt_LoginEmail("search"), searchGamesTeamAndMembersTestData.SH_05_SearchGamesTeamAndMembers);	
		String searchData=base.GetValue(loginObj.Edt_LoginEmail("search"));
		asrt.assertEquals(searchData, searchGamesTeamAndMembersTestData.SH_05_SearchGamesTeamAndMembers,"User is unable to click search bar and enter a game name");

		//step 6:After entering search bar, Click Enter
		//Expected:User should receive result as "No data Found"
		Thread.sleep(1000);
		base.pressKey(loginObj.Edt_LoginEmail("search"),"KEYBOARD_ENTER" );
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("No Data Found")), "User is unable to receive result as 'No data Found'");
	}
	//<Summary>
	//Test case Title:Verify whether there is a option to search teams in the Games/Members Listing page.
	//Automation ID: SH_06
	//</Summary>
	public void SH_06_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();

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

		//step 4:Select the GamesMembers section
		//Expected: There should be a option to search teams  in the GamesMembers Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("MEMBERS"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to view the option to search teams in the GamesMembers Listing page");
	}
	//<Summary>
	//Test case Title:Verify what happens when the user searches teams by entering its first letter as keyword in the search field.
	//Automation ID: SH_07
	//</Summary>
	public void SH_07_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		SearchGamesTeamAndMembers_TestData searchGamesTeamAndMembersTestData=new SearchGamesTeamAndMembers_TestData();
		SearchGameTeamAndMembers_Obj searchGameTeamAndMembersObj=new SearchGameTeamAndMembers_Obj();

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

		//step 4:Select the GamesMembers section
		//Expected: There should be a option to search teams  in the GamesMembers Listing page.
		base.excuteJsClick(loginObj.Edt_AlertMessage("MEMBERS"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to view the option to search teams in the GamesMembers Listing page");

		//step 5:Click search bar above the teams and enter the first letter of team name
		//Expected: User should able to click search bar above teams and enter the first letter of team name
		base.buttonClick(loginObj.Edt_LoginEmail("searchTeam"));
		base.setData(loginObj.Edt_LoginEmail("searchTeam"),searchGamesTeamAndMembersTestData.SH_07_SearchGamesTeamAndMembers);
		List<String> firstLetter=base.GetElementTexts(searchGameTeamAndMembersObj.Ele_GameFirst("my-team-content", "all-teams text-dark"));
		asrt.assertTrue(element.isExistsInStart(firstLetter, searchGamesTeamAndMembersTestData.SH_07_SearchGamesTeamAndMembers),"User is unable to click and enter the first letter of team name in search bar");
	}
	//<Summary>
	//Test case Title:Verify what happens when the user search teams by entering numbers as keyword in the search field.
	//Automation ID: SH_08
	//</Summary>
	public void SH_08_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		SearchGamesTeamAndMembers_TestData searchGamesTeamAndMembersTestData=new SearchGamesTeamAndMembers_TestData();
		SearchGameTeamAndMembers_Obj searchGameTeamAndMembersObj=new SearchGameTeamAndMembers_Obj();

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

		//step 4:Select the GamesMembers section
		//Expected: There should be a option to search teams  in the GamesMembers Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("MEMBERS"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to view the option to search teams in the GamesMembers Listing page");

		//step 5:Click search bar above the teams and enter a number 
		//Expected: User should click search bar above the teams and can see list of teams with the given number.
		base.buttonClick(loginObj.Edt_LoginEmail("searchTeam"));
		base.setData(loginObj.Edt_LoginEmail("searchTeam"),searchGamesTeamAndMembersTestData.SH_08_SearchGamesTeamAndMembers);
		List<String> number=base.GetElementTexts(searchGameTeamAndMembersObj.Ele_GameFirst("my-team-content", "all-teams text-dark"));
		asrt.assertTrue(element.isExistsInText(number, searchGamesTeamAndMembersTestData.SH_08_SearchGamesTeamAndMembers),"User is unable to see the list of teams with given number");
	}
	//<Summary>
	//Test case Title:Verify what happens when the user searches teams by entering special characters as keyword in the search field.
	//Automation ID: SH_09
	//</Summary>
	public void SH_09_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		SearchGamesTeamAndMembers_TestData searchGamesTeamAndMembersTestData=new SearchGamesTeamAndMembers_TestData();
		SearchGameTeamAndMembers_Obj searchGameTeamAndMembersObj=new SearchGameTeamAndMembers_Obj();

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

		//step 4:Select the GamesMembers section
		//Expected: There should be a option to search teams  in the GamesMembers Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("MEMBERS"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to view the option to search teams in the GamesMembers Listing page");

		//step 5:Click search bar above the teams and enter a special character
		//Expected: User should click search bar above the teams and can see list of teams with special character.
		base.buttonClick(loginObj.Edt_LoginEmail("searchTeam"));
		base.setData(loginObj.Edt_LoginEmail("searchTeam"),searchGamesTeamAndMembersTestData.SH_09_SearchGamesTeamAndMembers_Special);
		List<String> special=base.GetElementTexts(searchGameTeamAndMembersObj.Ele_GameSpecial("my-team-content"));
		asrt.assertTrue(element.isExistsInText(special, searchGamesTeamAndMembersTestData.SH_09_SearchGamesTeamAndMembers_Special),"User is unable to see the list of teams with the given special character");
	}
	//<Summary>
	//Test case Title:Verify what happens when user searches for a team which is not in the list.
	//Automation ID: SH_10
	//</Summary>
	public void SH_10_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		SearchGamesTeamAndMembers_TestData searchGamesTeamAndMembersTestData=new SearchGamesTeamAndMembers_TestData();
		SearchGameTeamAndMembers_Obj searchGameTeamAndMembersObj=new SearchGameTeamAndMembers_Obj();

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

		//step 4:Select the GamesMembers section
		//Expected: There should be a option to search teams  in the GamesMembers Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("MEMBERS"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to view the option to search teams in the GamesMembers Listing page");

		//step 5:Click search bar above the teams
		//Expected: User should click search bar above the teams
		base.buttonClick(loginObj.Edt_LoginEmail("searchTeam"));
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click search bar above the teams");

		//step 6: Enter a team name  
		//Expected:There will not list any teams if the user enters a team name which doesn't exists.
		base.setData(loginObj.Edt_LoginEmail("searchTeam"),searchGamesTeamAndMembersTestData.SH_10_SearchGamesTeamAndMembers_Noteam);
		List<String> noTeam=base.GetElementTexts(searchGameTeamAndMembersObj.Ele_GameSpecial("my-team-content"));
		asrt.assertFalse(element.isExistsInText(noTeam, searchGamesTeamAndMembersTestData.SH_10_SearchGamesTeamAndMembers_Noteam),"User is able to see the list of team name");
	}
	//<Summary>
	//Test case Title:Verify whether there is a option to search members in Members Listing page.
	//Automation ID: SH_11
	//</Summary>
	public void SH_11_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();

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

		//step 4:Select Members section
		//Expected:There should be a option to search members in Members Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("MEMBERS"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("teamGroupMembers")),"User is unable to view the option to search members in Members listing page");
	}
	//<Summary>
	//Test case Title:Verify what happens when the user searches members by entering there first letter as the keyword in the search field.
	//Automation ID: SH_12
	//</Summary>
	public void SH_12_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		SearchGamesTeamAndMembers_TestData searchGamesTeamAndMembersTestData=new SearchGamesTeamAndMembers_TestData();

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

		//step 4:Select Members section
		//Expected:There should be a option to search members in Members Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("MEMBERS"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("teamGroupMembers")),"User is unable to view the option to search members in Members listing page");

		//step 5: Click search bar and enter the first letter of the member name
		//Expected: User can see list of members with the given first letter.
		base.buttonClick(loginObj.Edt_LoginEmail("teamGroupMembers"));
		base.setData(loginObj.Edt_LoginEmail("teamGroupMembers"), searchGamesTeamAndMembersTestData.SH_12_SearchGamesTeamAndMembers);
		List<String> firstLetter=base.GetElementTexts(loginObj.Ele_ErrorMessage("player_data"));
		asrt.assertTrue(element.isExistsInText(firstLetter, searchGamesTeamAndMembersTestData.SH_12_SearchGamesTeamAndMembers),"User is unable to click search bar and unable to see the list of members with given first letter");
	}
	//<Summary>
	//Test case Title:Verify what happens when the user search members by entering numbers as keyword in the search field.
	//Automation ID: SH_13
	//</Summary>
	public void SH_13_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		SearchGamesTeamAndMembers_TestData searchGamesTeamAndMembersTestData=new SearchGamesTeamAndMembers_TestData();
		SearchGameTeamAndMembers_Obj searchGameTeamAndMembersObj=new SearchGameTeamAndMembers_Obj();

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

		//step 4:Select Members section
		//Expected:There should be a option to search members in Members Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("MEMBERS"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("teamGroupMembers")),"User is unable to view the option to search members in Members listing page");

		//step 5: Click search bar and enter a number
		//Expected: User should click search bar and see list of members with the given number in their mail id.
		base.buttonClick(loginObj.Edt_LoginEmail("teamGroupMembers"));
		base.setData(loginObj.Edt_LoginEmail("teamGroupMembers"), searchGamesTeamAndMembersTestData.SH_13_SearchGamesTeamAndMembers_Number);
		List<String> number=base.GetElementTexts(searchGameTeamAndMembersObj.Ele_MemberListNew("row p-2","display: block;", "teamEmail"));
		Thread.sleep(4000);
		asrt.assertTrue(element.isExistsInText(number, searchGamesTeamAndMembersTestData.SH_13_SearchGamesTeamAndMembers_Number),"User is unable to click search bar and unable to see the list of members with given number in their mail id");
	}
	//<Summary>
	//Test case Title:Verify what happens when the user searches members by entering special characters as keyword in the search field.
	//Automation ID: SH_14
	//</Summary>
	public void SH_14_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		SearchGamesTeamAndMembers_TestData searchGamesTeamAndMembersTestData=new SearchGamesTeamAndMembers_TestData();
		SearchGameTeamAndMembers_Obj searchGameTeamAndMembersObj=new SearchGameTeamAndMembers_Obj();

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

		//step 4:Select Members section
		//Expected:There should be a option to search members in Members Listing page.
		base.buttonClick(loginObj.Edt_AlertMessage("MEMBERS"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("teamGroupMembers")),"User is unable to view the option to search members in Members listing page");

		//step 5:Click search bar and enter a special character 
		//Expected:User should click search bar and enter a special character 
		base.buttonClick(loginObj.Edt_LoginEmail("teamGroupMembers"));
		base.setData(loginObj.Edt_LoginEmail("teamGroupMembers"), searchGamesTeamAndMembersTestData.SH_14_SearchGamesTeamAndMembers_Special);
		List<String> special=base.GetElementTexts(searchGameTeamAndMembersObj.Ele_MemberListNew("row p-2","display: block;", "teamEmail"));
		asrt.assertTrue(element.isExistsInText(special, searchGamesTeamAndMembersTestData.SH_14_SearchGamesTeamAndMembers_Special),"User is unable to click search bar and unable to see the list of members with given special character");
	}
}

