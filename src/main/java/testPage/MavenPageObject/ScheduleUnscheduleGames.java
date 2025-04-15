package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
import TestData.ScheduleUnschedule_TestData;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;

public class ScheduleUnscheduleGames extends BasePge {
	BasePge base;
	Assert asrt;

	public ScheduleUnscheduleGames(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	//<summery>
	//Test Case Title : To verify whether there is a section as Schedule in Film page..
	//Automation ID : SG_01
	//</summery>
	public void SG_01_ScheduleUnscheduleGames() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("SCHEDULE")),"User not able to login");

		//Step 3: Verify whether there is a section as Schedule in Film page
		//Expected: There should be a section for scheduled games under Film page.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("SCHEDULE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("combined-schedule-tab")),"There is no section for Schedule games under Film page.");
	}

	//<summery>
	//Test Case Title : To verify whether there is schedule icon near the games under Events/Practices
	//Automation ID : SG_02
	//</summery>
	public void SG_02_ScheduleUnscheduleGames() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SnipBackLogin_Obj SnipBackLoginObj = new SnipBackLogin_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();

		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("SCHEDULE")),"User not able to login");

		//Step 3: Verify whether there is schedule icon near the games under Events
		//Expected: There should be a schedule icon near the games under Events..
		base.buttonClick(SnipBackLoginObj.Btn_Signin("EVENTS"));
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row ","1","calendar-list scheduled","my_film")),
				"There is no schedule icon near the games under Events.");

		//Step 4: Verify whether there is schedule icon near the games under Practices
		//Expected: There should be a schedule icon near the games under Practices..
		base.buttonClick(SnipBackLoginObj.Btn_Signin("PRACTICES"));
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row ","1","calendar-list scheduled","practice_film")),
				"There is no schedule icon near the games under Practices.");		
	}

	//<summery>
	//Test Case Title : To verify whether the games are automatically scheduled while creating a new Events/Practices.
	//Automation ID : SG_03
	//</summery>
	public void SG_03_ScheduleUnscheduleGames() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		
		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("SCHEDULE")),"User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), ScheduleUnschedule_TestData.SG_03_OrgName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("searchTeam")),"User is not able to select any organization");

		//Step 4 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), ScheduleUnschedule_TestData.SG_03_TeamName);
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Ele_TeamNameFromList("my-team-content",ScheduleUnschedule_TestData.SG_03_TeamName));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Event")),"User is not able to select the searched Team");

		//Step 5 : click on +Event button
		//Expected : User should be able to click on +Event button
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage("Event")); 
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Ele_CreateGameFor("Create Game for ")),"User is not able to click on +Event button");

		//Step 6: Enter the Event Name
		//Expected:The user should be able to enter the event name
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),ScheduleUnschedule_TestData.SG_03_ScheduleGamesEventName);
		String ActualEvent = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertEquals(ActualEvent,ScheduleUnschedule_TestData.SG_03_ScheduleGamesEventName,"The user is not able to enter the event name");

		//Step 7:Create new Events/Practices
		//Expected:The user should be able create new Events/Practices
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Btn_Create("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red","CREATE"));
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Btn_EventOK("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row ","1","calendar-list scheduled","my_film")),"The user is not able to create new Events/Practices");

		//Step 8:Click on schedule section
		//Expected:The user should be able to navigate to schedule section
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage("SCHEDULE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("GAME SCHEDULE")),"The user is not able to navigate to schedule section");		    

		//Step 9 : click on search button and select game under schedule
		//Expected : User should be able to select the searched game under schedule
		base.excuteJsClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search")); 
		base.setData(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search"),ActualEvent);
		base.pressKey(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search"),"KEYBOARD_ENTER" );
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row","1","calendar-list scheduled","5")),
				"User is not able to select the searched game under schedule");
	}
	//<summery>
	//Test Case Title : To verify whether the games created under Events are scheduled under Game Schedule
	//Automation ID : SG_04
	//</summery>
	public void SG_04_ScheduleUnscheduleGames() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		
		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to Snipback Login page");

		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("SCHEDULE")),"User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), ScheduleUnschedule_TestData.SG_04_OrgName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("searchTeam")),"User is not able to select any organization");

		//Step 4 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), ScheduleUnschedule_TestData.SG_04_TeamName);
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Ele_TeamNameFromList("my-team-content",ScheduleUnschedule_TestData.SG_04_TeamName));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Event")),"User is not able to select the searched Team");

		//Step 5 : click on +Event button
		//Expected : User should be able to click on +Event button
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage("Event")); 
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Ele_CreateGameFor("Create Game for ")),"User is not able to click on +Event button");

		//Step 6: Enter the Event Name
		//Expected:The user should be able to enter the event name
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),ScheduleUnschedule_TestData.SG_04_ScheduleGamesEventName);
		String ActualEvent = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertEquals(ActualEvent,ScheduleUnschedule_TestData.SG_04_ScheduleGamesEventName,"The user is not able to enter the event name");

		//Step 7:Create new Events/Practices
		//Expected:The user should be able create new Events/Practices
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Btn_Create("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red","CREATE"));
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Btn_EventOK("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row ","1","calendar-list scheduled","my_film")),"The user is not able to create new Events/Practices");

		//Step 8:Click on schedule section
		//Expected:The user should be able to navigate to schedule section
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage("SCHEDULE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("GAME SCHEDULE")),"The user should not be able to navigate to schedule section");		    

		//Step 9:Click on GameSchedule section
		//Expected:The user should be able to navigate to GameSchedule section
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("GAME SCHEDULE"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search")),"The user is not able to navigate to GameSchedule section");		    

		//Step 10 : click on search button and select game under GameSchedule
		//Expected : User should be able to select the searched game under GameSchedule
		base.excuteJsClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search")); 
		base.setData(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search"),ActualEvent);
		base.pressKey(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search"),"KEYBOARD_ENTER" );
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row","1","calendar-list scheduled","5")),
				"User is not able to select the searched game under GameSchedule");
	}
	//<summery>
	//Test Case Title : To verify whether the games created under Practices are scheduled under Practice Schedule.
	//Automation ID : SG_05
	//</summery>
	public void SG_05_ScheduleUnscheduleGames() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		
		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to Snipback Login page");

		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("SCHEDULE")),"User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), ScheduleUnschedule_TestData.SG_05_OrgName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("searchTeam")),"User is not able to select any organization");

		//Step 4 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), ScheduleUnschedule_TestData.SG_05_TeamName);
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Ele_TeamNameFromList("my-team-content",ScheduleUnschedule_TestData.SG_05_TeamName));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Event")),"User is not able to select the searched Team");

		//Step 5 : click on Practice section
		//Expected : User should be able to click on practice section
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("PRACTICES")); 
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Practice")),"User is not able to click on practice section");

		//Step 6 : click on +Practice button
		//Expected : User should be able to click on +Practice button
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage("Practice")); 
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Ele_CreateGameFor("Create Game for ")),"User is not able to click on +Practice button");

		//Step 7: Enter the Practice Name
		//Expected:The user should be able to enter the practice name
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),ScheduleUnschedule_TestData.SG_05_ScheduleGamesPracticeName);
		String ActualEvent = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertEquals(ActualEvent,ScheduleUnschedule_TestData.SG_05_ScheduleGamesPracticeName,"The user is not able to enter the practice name");

		//Step 8:Create new Events/Practices
		//Expected:The user should be able to create new Events/Practices
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Btn_Create("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red","CREATE"));
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Btn_EventOK("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row ","1","calendar-list scheduled","practice_film")),"The user is not able to create new Events/Practices");

		//Step 9:Click on schedule section
		//Expected:The user should be able to navigate to schedule section
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage("SCHEDULE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("PRACTICE SCHEDULE")),"The user should not be able to navigate to schedule section");		    

		//Step 10:Click on PracticeSchedule section
		//Expected:The user should be able to navigate to PracticeSchedule section
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("PRACTICE SCHEDULE"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search")),"The user is not able to navigate to PracticeSchedule section");		    

		//Step 11 : click on search button and select game under PracticeSchedule
		//Expected : User should be able to select the searched game under PracticeSchedule
		base.excuteJsClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search")); 
		base.setData(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search"),ActualEvent);
		base.pressKey(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search"),"KEYBOARD_ENTER" );
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row","1","calendar-list scheduled","5")),
				"User is not able to select the searched game under PracticeSchedule");
	}
	//<summery>
	//Test Case Title : To verify what happens when user click the Schedule icon of already scheduled games..
	//Automation ID : SG_06
	//</summery>
	public void SG_06_ScheduleUnscheduleGames() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		
		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to Snipback Login page");

		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("SCHEDULE")),"User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), ScheduleUnschedule_TestData.SG_06_OrgName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("searchTeam")),"User is not able to select any organization");

		//Step 4 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), ScheduleUnschedule_TestData.SG_06_TeamName);
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Ele_TeamNameFromList("my-team-content",ScheduleUnschedule_TestData.SG_06_TeamName));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Event")),"User is not able to select the searched Team");

		//Step 5 : click on Practice section
		//Expected : User should be able to click on practice section
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("PRACTICES")); 
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Practice")),"User is not able to click on practice section");

		//Step 6 : click on +Practice button
		//Expected : User should be able to click on +Practice button
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage("Practice")); 
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Ele_CreateGameFor("Create Game for ")),"User is not able to click on +Practice button");

		//Step 7: Enter the Practice Name
		//Expected:The user should be able to enter the practice name
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),ScheduleUnschedule_TestData.SG_06_ScheduleGamesPracticeName);
		String ActualEvent = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertEquals(ActualEvent,ScheduleUnschedule_TestData.SG_06_ScheduleGamesPracticeName,"The user is not able to enter the practice name");

		//Step 8:Create new Events/Practices
		//Expected:The user should be able to create new Events/Practices
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Btn_Create("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red","CREATE"));
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Btn_EventOK("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row ","1","calendar-list scheduled","practice_film")),"The user is not able to create new Events/Practices");

		//Step 9:Click on schedule section
		//Expected:The user should be able to navigate to schedule section
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage("SCHEDULE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("PRACTICE SCHEDULE")),"The user should not be able to navigate to schedule section");		    

		//Step 10:Click on PracticeSchedule section
		//Expected:The user should be able to navigate to PracticeSchedule section
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("PRACTICE SCHEDULE"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search")),"The user is not able to navigate to PracticeSchedule section");		    

		//Step 11 : click on search button and select game under PracticeSchedule
		//Expected : User should be able to select the searched game under PracticeSchedule
		base.excuteJsClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search")); 
		base.setData(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search"),ActualEvent);
		base.pressKey(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control input-wrap game-search"),"KEYBOARD_ENTER" );
		asrt.assertTrue(base.isEnabledBy(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row","1","calendar-list scheduled","5")),
				"User is not able to select the searched game under PracticeSchedule");

		//Step 12 : Click schedule icon 
		//Expected : User should be able to click schedule icon
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row","1","calendar-list scheduled","5")); 
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Btn_EventOK("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")),"The user is not able to click schedule icon"); 

		//Step 13 : Check the game should be automatically unscheduled.
		//Expected : The game should be automatically unscheduled.
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage("GAMES")); 
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("PRACTICES")); 
		asrt.assertTrue(base.isEnabledBy(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row ","1","calendar-list schedule","practice_film")),
				"The game automatically scheduled.");	
	}
}