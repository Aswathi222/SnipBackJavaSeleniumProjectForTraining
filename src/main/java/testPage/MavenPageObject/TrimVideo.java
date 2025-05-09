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
import TestData.CommonData;
import TestData.CreateEditDeletePool_TestData;
import TestData.SearchGamesTeamAndMembers_TestData;
import TestData.TrimVideo_TestData;
import objectRepository.AddorEditInfo_Obj;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;

public class TrimVideo extends BasePge{
	BasePge base;
	Assert asrt;
	ElementActions element;

	public TrimVideo(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
		element=new ElementActions(driver);
	}
	//<Summary>
	//Test case Title:To verify whether there is an option to trim the video in the player page
	//Automation ID:TV_01
	//</Summary>
	public void TV_01_TrimVideo() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		TrimVideo_TestData trimVideoTestData=new TrimVideo_TestData();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();
		PublicGameListing_Obj publicGameListingObj=new PublicGameListing_Obj();

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

		//step 5:Click Events/Practices/Scout
		//Expected:User should be able to click Events/Practices/Scout
		Thread.sleep(1000);
		base.buttonClick(snipBackLoginObj.Btn_Signin("EVENTS"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Event")), "User is unable to click Events/Practices/Scout");

		//step 6:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"), trimVideoTestData.TV_01_TrimVideo);
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login(trimVideoTestData.TV_01_TrimVideo)), "User is unable to click search bar and enter a game");

		//step 7:Click on any completed game
		//Expected:There should be a trimming option in the player page of a completed game.
		Thread.sleep(3000);
		base.buttonClick(snipBackLoginObj.Btn_Login(trimVideoTestData.TV_01_TrimVideo));
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(publicGameListingObj.Img_sort("trim-btn-img")), "User is unable to view trimming option in the player page of a completed game");

		//step 8:Click Games
		//Expected:User should be able to click Games
		base.switchToWindowByIndex(driver, 0);
		Thread.sleep(3000);
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click Games");

		//step 9:Click Events/Practices/Scout
		//Expected:User should be able to click Events/Practices/Scout
		base.buttonClick(snipBackLoginObj.Btn_Signin("PRACTICES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Practice")), "User is unable to click Events/Practices/Scout");

		//step 10:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"), trimVideoTestData.TV_01_UploadedVideo);
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login(trimVideoTestData.TV_01_UploadedVideo)), "User is unable to click search bar and enter a game");

		//step 11:Click on any uploaded game
		//Expected:There should be a trimming option in the player page of a uploaded game.
		Thread.sleep(3000);
		base.buttonClick(snipBackLoginObj.Btn_Login(trimVideoTestData.TV_01_UploadedVideo));
		base.switchToWindowByIndex(driver, 2);
		asrt.assertTrue(base.isExists(publicGameListingObj.Img_sort("trim-btn-img")), "User is unable to view trimming option in the player page of a uploaded game");

		//step 12:Click Games
		//Expected:User should be able to click Games
		base.switchToWindowByIndex(driver, 0);
		Thread.sleep(3000);
		base.buttonClick(loginObj.Edt_AlertMessage("GAMES"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click Games");

		//step 13:Click Events/Practices/Scout
		//Expected:User should be able to click Events/Practices/Scout
		base.buttonClick(snipBackLoginObj.Btn_Signin("SCOUT"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Scout")), "User is unable to click Events/Practices/Scout");

		//step 14:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"), trimVideoTestData.TV_01_PausedVideo);
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login(trimVideoTestData.TV_01_PausedVideo)), "User is unable to click search bar and enter a game");

		//step 15:Click on any paused/ in-progress game
		//Expected:The Trimming should not available for paused/in-progress games
		Thread.sleep(4000);
		base.buttonClick(snipBackLoginObj.Btn_Login(trimVideoTestData.TV_01_PausedVideo));
		base.switchToWindowByIndex(driver, 3);
		asrt.assertTrue(base.isDoesNotExistBool(publicGameListingObj.Img_sort("trim-btn-img")), "The Trimming option is available for paused/in-progress games");
	}
	//<Summary>
	//Test case Title:To verify whether the user can be able to click the trim option
	//Automation ID:TV_02
	//</Summary>
	public void TV_02_TrimVideo() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		TrimVideo_TestData trimVideoTestData=new TrimVideo_TestData();
		SnipBackLogin_Obj snipBackLoginObj=new SnipBackLogin_Obj();
		PublicGameListing_Obj publicGameListingObj=new PublicGameListing_Obj();

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

		//step 5:Click Events/Practices/Scout
		//Expected:User should be able to click Events/Practices/Scout
		base.buttonClick(snipBackLoginObj.Btn_Signin("EVENTS"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Event")), "User is unable to click Events/Practices/Scout");

		//step 6:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"), trimVideoTestData.TV_02_TrimVideo);
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login(trimVideoTestData.TV_02_TrimVideo)), "User is unable to click search bar and enter a game");

		//step 7:Click on any completed game
		//Expected:User should be able to click trim option
		Thread.sleep(3000);
		base.buttonClick(snipBackLoginObj.Btn_Login(trimVideoTestData.TV_02_TrimVideo));
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(publicGameListingObj.Img_sort("trim-btn-img")), "User is unable to click trim option");

		//step 8:Click trim option
		//Expected:User can be able to click trim option.
		base.buttonClick(publicGameListingObj.Img_sort("trim-btn-img"));
		asrt.assertTrue(base.isEnabledBy(publicGameListingObj.Img_sort("trim-btn-img")), "User is unable to click trim option");
	}
}

