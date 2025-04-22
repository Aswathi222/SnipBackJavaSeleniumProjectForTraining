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
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to click Games");

		//step 5:Click search bar and enter a game
		//Expected:User should click search bar and enter a game
		base.setData(loginObj.Edt_LoginEmail("search"), addorEditInfoTestData.AI_01_AddorEditInfo);
		base.pressKey(loginObj.Edt_LoginEmail("search"), "ENTER");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(snipBackLoginObj.Btn_Login("AI_01_AddInfo")), "User is unable to click search bar and enter a game");

		//step 6:Click three dots of any game
		//Expected:There should be a option as Add Info in Games Listing page.
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
}
