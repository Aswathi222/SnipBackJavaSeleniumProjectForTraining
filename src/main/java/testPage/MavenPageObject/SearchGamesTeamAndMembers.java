package testPage.MavenPageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestData.CommonData;
import TestData.CreateEditDeletePool_TestData;
import TestData.SearchGamesTeamAndMembers_TestData;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;

public class SearchGamesTeamAndMembers extends BasePge{
	BasePge base;
	Assert asrt;

	public SearchGamesTeamAndMembers(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	//<Summary>
	//Test case Title:To verify whether there is a option to search games in Game Listing page.
	//Automation ID: TC_01
	//</Summary>
	public void TC01_SearchGamesTeamAndMembers() throws InterruptedException{
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
		base.buttonClick(loginObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to search games in games listing page.");
	}
	//<Summary>
	//Test case Title:To verify what happens when the user searches games by entering its first letter as keyword in the search field.
	//Automation ID: TC_02
	//</Summary>
	public void TC02_SearchGamesTeamAndMembers() throws InterruptedException{
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
		base.buttonClick(loginObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to search games in games listing page.");

		//step 5:Click search bar
		//Expected:User should click search bar
		base.buttonClick(loginObj.Edt_LoginEmail("search"));
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_LoginEmail("search")), "User is unable to click search bar");

		//step 6:Enter the first letter of game name
		//Expected:User should enter first letter of game name
		base.setData(loginObj.Edt_LoginEmail("search"), searchGamesTeamAndMembersTestData.TC02_SearchGamesTeamAndMembers);	
		String searchData=base.GetValue(loginObj.Edt_LoginEmail("search"));
		asrt.assertEquals(searchData, searchGamesTeamAndMembersTestData.TC02_SearchGamesTeamAndMembers,"User is unable to enter first letter of game name");

		//step 7:Click Enter
		//Expected:User can see list of games with the given first letter.
		base.pressKey(loginObj.Edt_LoginEmail("search"),"KEYBOARD_ENTER" );
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("T-disable")), "User is unable to view the list of games with given first letter");
	}
	//<Summary>
	//Test case Title:To verify what happens when the user search games by entering numbers as keyword in the search field.
	//Automation ID: TC_03
	//</Summary>
	public void TC03_SearchGamesTeamAndMembers() throws InterruptedException{
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
		base.buttonClick(loginObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to search games in games listing page.");

		//step 5:Click search bar
		//Expected:User should click search bar
		base.buttonClick(loginObj.Edt_LoginEmail("search"));
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_LoginEmail("search")), "User is unable to click search bar");

		//step 6: Enter a number
		//Expected:User should enter a number
		base.setData(loginObj.Edt_LoginEmail("search"), searchGamesTeamAndMembersTestData.TC03_SearchGamesTeamAndMembers_Number);	
		String searchData=base.GetValue(loginObj.Edt_LoginEmail("search"));
		asrt.assertEquals(searchData, searchGamesTeamAndMembersTestData.TC03_SearchGamesTeamAndMembers_Number,"User is unable to enter number");

		//step 7:Click Enter
		//Expected:User can see list of games with the given number.
		base.pressKey(loginObj.Edt_LoginEmail("search"),"KEYBOARD_ENTER" );
		List<String> gameTexts = base.GetElementTexts(searchGameTeamAndMembersObj.Ele_GameList1("table table-striped film-list"));
		asrt.assertTrue(base.isExistsInText(gameTexts, searchGamesTeamAndMembersTestData.TC03_SearchGamesTeamAndMembers_Number), "User is unable to view the list of games with the given number.");
	}

	//<Summary>
	//Test case Title:To verify what happens when the user searches games by entering special characters as keyword in the search field.
	//Automation ID: TC_04
	//</Summary>
	public void TC04_SearchGamesTeamAndMembers() throws InterruptedException{
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
		base.buttonClick(loginObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to search games in games listing page.");

		//step 5:Click search bar and enter a special character
		//Expected:User should click search bar and enter a special character
		base.buttonClick(loginObj.Edt_LoginEmail("search"));
		base.setData(loginObj.Edt_LoginEmail("search"), searchGamesTeamAndMembersTestData.TC04_SearchGamesTeamAndMembers_Special);	
		String searchData=base.GetValue(loginObj.Edt_LoginEmail("search"));
		asrt.assertEquals(searchData, searchGamesTeamAndMembersTestData.TC04_SearchGamesTeamAndMembers_Special,"User is unable to click search bar and enter special character");

		//step 6:Enter a special character and Click Enter
		//Expected:User can see list of games with the given special character.
		base.pressKey(loginObj.Edt_LoginEmail("search"),"KEYBOARD_ENTER" );
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("No Data Found")), "User is unable to view the list of games with given special character.");
	}
	//<Summary>
		//Test case Title:Verify what happens when user searches for a game which is not in the list.
		//Automation ID: TC_05
		//</Summary>
		public void TC05_SearchGamesTeamAndMembers() throws InterruptedException{
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
			base.buttonClick(loginObj.Edt_Alert1("GAMES"));
			asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to search games in games listing page.");

			//step 5:Click search bar and enter a game name
			//Expected:User should click search bar and enter a game name
			base.buttonClick(loginObj.Edt_LoginEmail("search"));
			base.setData(loginObj.Edt_LoginEmail("search"), searchGamesTeamAndMembersTestData.TC05_SearchGamesTeamAndMembers);	
			String searchData=base.GetValue(loginObj.Edt_LoginEmail("search"));
			asrt.assertEquals(searchData, searchGamesTeamAndMembersTestData.TC05_SearchGamesTeamAndMembers,"User is unable to click search bar and enter a game name");

			//step 6:Enter a game which is not in the list and Click Enter
			//Expected:User should receive result as "No data Found"
			base.pressKey(loginObj.Edt_LoginEmail("search"),"KEYBOARD_ENTER" );
			asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("No Data Found")), "User is unable to receive result as 'No data Found'");
		}
}
