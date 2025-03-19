package testPage.MavenPageObject;
import TestData.ForgotPassword_TestData;
import TestData.PublicGameListing_TestData;
import TestData.Registration_TestData;
import TestData.ScheduleUnscheduleGames_TestData;
import TestData.SnipBackLogin_TestData;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import TestData.CommonData;
import TestData.CreateAddNewMemberWithEmail_TestData;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.AddFollower_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.CreateUpdateDeleteGame_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;


public class ScheduleUnscheduleGames extends BasePge {

	BasePge base;
	Assert asrt;
	Actions actions = new Actions(driver);
	By clickOnStartDate ;
	WebElement webElement;
	public ScheduleUnscheduleGames(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title : "To verify whether there is a section as Schedule in Film page."
	// Automation ID : SG_01
	// </summary>
	public void SG_01_ScheduleUnscheduleGames() throws InterruptedException
	{
		Login login = new Login(driver);
		CommonData commondata= new CommonData();
		LoginPage_Obj LoginPageObj= new LoginPage_Obj();

		//Step 1:Go to Games page
		//Expected:User should be navigated to Games page
		login.loginToApplication(commondata.UserName, commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded");

		//Step 2:Click Schedule section
		//Expected: There should be a section for scheduled games under Film page.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("SCHEDULE")),"There is no section for Schedule games under Film page.");
		base.buttonClick(LoginPageObj.Edt_Alert1("SCHEDULE"));
	}

	// <summary>
	// Test Case Title : "To verify whether there is schedule icon near the games under Events/Practices"
	// Automation ID : SG_02
	// </summary>
	public void SG_02_ScheduleUnscheduleGames() throws InterruptedException
	{
		Login login = new Login(driver);
		CommonData commondata= new CommonData();
		LoginPage_Obj LoginPageObj= new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		ScheduleUnscheduleGames_TestData ScheduleUnscheduleGamesTestData = new ScheduleUnscheduleGames_TestData();
		//Step 1:Go to Games page
		//Expected:User should be navigated to Games page
		login.loginToApplication(commondata.UserName, commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded");

		//Step 2: Select team from dropdown menu
		//Expected: The team should be selected in the dropdown menu in the Games page.
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), ScheduleUnscheduleGamesTestData.SG_01_ScheduleGamesEvent);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("AA Q-Dev - 2054")),"The Team is not selected in the team dropwdown menu in gthe Games page");

		//Step 3: Verify whether there is a schedule icon near games under 'Events'
		//Expected: There should be a schedule icon near the games under Events.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("SCHEDULE")),"The schedule icon is not visible under Events in the Games page");

		//Step 4: Click oon 'Practices' and verify whether there is a schedule icon near games under 'Practices'.
		//Expected: There should be a schedule icon near the games under Practices.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("practice_film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("SCHEDULE")),"The schedule icon is not visible under Practices in the Games page");
	}

	// <summary>
	// Test Case Title : "To verify what happens when user click the Schedule icon of already scheduled games."
	// Automation ID : SG_06
	// </summary>
	public void SG_06_ScheduleUnscheduleGames() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData CommonData = new CommonData();
		ScheduleUnscheduleGames_Obj  ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();

		//Step 1  :"Go to Games page"
		//Expected:"User should be navigated to Game Page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Event")));

		//Step 2:Switch to Schedule section
		//Expected:User should be navigated to the Schedule Section
		base.buttonClick(LoginPageObj.Edt_Alert1("SCHEDULE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("GAME SCHEDULE")),"User should not be navigated to the Schedule Section");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("GAME SCHEDULE"));

		//Step 3:Click Schedule icon 
		//Expected:The game unscheduled successfully message should be displayed.
		Thread.sleep(10000);
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Ele_ScheduleIc("SemScheduleEvent3"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Unscheduled successfully.")),"The game unscheduled successfully message should not be displayed");
	}

	// <summary>
	// Test Case Title : "To verify what happens when user unschedule a game."
	// Automation ID : SG_07
	// </summary>
	public void SG_07_ScheduleUnscheduleGames() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData CommonData = new CommonData();
		Pool_Obj PoolObj = new Pool_Obj();
		ScheduleUnscheduleGames_Obj  ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();

		//Step 1  :"Go to Games page"
		//Expected:"User should be navigated to Game Page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Event")));

		//Step 2:Switch to Schedule section
		//Expected:User should be navigated to the Schedule Section
		base.buttonClick(LoginPageObj.Edt_Alert1("SCHEDULE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("GAME SCHEDULE")),"User should not be navigated to the Schedule Section");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("COMBINED SCHEDULE"));

		//Step 3:Click Schedule icon 
		//Expected:The game should be removed from the list under Scheduled section.
		Thread.sleep(10000);
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Ele_ScheduleIc("SemScheduleEvent4"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Unscheduled successfully.")),"The game should not be removed from the list under Scheduled section.");
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("GAME SCHEDULE")),"User should not be navigated to the Schedule Section");
	}

	// <summary>
	// Test Case Title : "To To verify whether the games under the Scheduled section are listing in Ascending order."
	// Automation ID : SG_08
	// </summary>
	public void SG_08_ScheduleUnscheduleGames() throws Exception
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj= new LoginPage_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj= new ScheduleUnscheduleGames_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		ScheduleUnscheduleGames_TestData ScheduleUnscheduleGamesTestData = new ScheduleUnscheduleGames_TestData();
		AddFollower_Obj  AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1  :"Go to Games page"
		//Expected:"User should be navigated to Game Page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Event")));

		//Step 2:Create new Events/Practices
		//a.Click on the 'Event' button
		//Expected:The Event Creation Tab should be visible to the user
		base.buttonClick(LoginPageObj.Edt_Alert1("Event"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("Create Game for ")),"The Event Creation Tab should not be visible to the user");

		//b.Enter the Event Name
		//Expected:The user should be able to enter the event name
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),ScheduleUnscheduleGamesTestData.SG_08_ScheduleGamesEventName);
		String ActualEvent = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertEquals(ActualEvent,ScheduleUnscheduleGamesTestData.SG_08_ScheduleGamesEventName,"The user should not be able to enter the event name");

		//c.Select the Time Zone
		//Expected:The user should be able to select the timezone
		base.buttonClick(RegistrationObj.Ele_ErrorMessage("India Standard Time(GMT+5:30)"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("India Standard Time(GMT+5:30)")),"The user should not be able to select the timezone");

		clickOnStartDate = LoginPageObj.Edt_LoginCredentialFields("datetimepicker1");
		buttonClick(clickOnStartDate);
		Thread.sleep(2000);//wait is required 

		//Step 5: clearing date in the date picker calendar
		webElement=driver.findElement(clickOnStartDate);
		clearTextUsingKeys(webElement);

		webElement.sendKeys(getDate());
		String ActualDate = base.getDate();
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(7000);

		//f.Click the Create Button
		//Expected:Game should be created
		Thread.sleep(7000);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_CREATE("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red","CREATE")),"The Create button not showing");
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_CREATE("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red","CREATE"));

		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		//Step 2:Switch to Schedule section
		//Expected:Games under the Scheduled game section should be in ascending order.(Oldest to Newest)
		base.excuteJsClick(LoginPageObj.Edt_Alert1("SCHEDULE"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("GAME SCHEDULE"));
		Thread.sleep(5000);
		//asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Ele_FirstDate(ActualDate)),"Games under the Scheduled game section should not be in ascending order.(Oldest to Newest)");
	}

	// <summary>
	// Test Case Title : "To verify whether the games are automatically scheduled while creating a new Events/Practices."
	// Automation ID : SG_03
	// </summary>
	public void SG_03_ScheduleUnscheduleGames() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleObj = new ScheduleUnscheduleGames_Obj();
		ScheduleUnscheduleGames_TestData ScheduleUnscheduleGamesTestData = new ScheduleUnscheduleGames_TestData();
		AddFollower_Obj  AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1  :"Go to Games page"
		//Expected:"User should be navigated to Game Page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Event")));

		//Step 2:Create new Events/Practices
		//a.Click on the 'Event' button
		//Expected:The Event Creation Tab should be visible to the user
		base.buttonClick(LoginPageObj.Edt_Alert1("Event"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("Create Game for ")),"The Event Creation Tab should not be visible to the user");

		//b.Enter the Event Name
		//Expected:The user should be able to enter the event name
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),ScheduleUnscheduleGamesTestData.SG_03_ScheduleGamesEventName);
		String ActualEvent = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertEquals(ActualEvent,ScheduleUnscheduleGamesTestData.SG_03_ScheduleGamesEventName,"The user should not be able to enter the event name");

		//c.Select the Time Zone
		//Expected:The user should be able to select the timezone
		base.buttonClick(RegistrationObj.Ele_ErrorMessage("India Standard Time(GMT+5:30)"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("India Standard Time(GMT+5:30)")),"The user should not be able to select the timezone");

		//d.Select the date from date picker
		//Expected:The user should be able to enter the date
		base.buttonClick(LoginPageObj.Edt_LoginEmail("datetimepicker1"));
		base.buttonClick(ScheduleUnscheduleObj.Ele_Data("day active today"));
		Thread.sleep(6000);
		asrt.assertTrue(base.isExists(ScheduleUnscheduleObj.Ele_Data("day active today")),"The user should not be able to enter the date");
		Thread.sleep(7000);

		//e.Click the Create Button
		//Expected:Game should be created
		Thread.sleep(7000);
		base.excuteJsClick(ScheduleUnscheduleObj.Btn_Create());
		asrt.assertTrue(base.isExists(ScheduleUnscheduleObj.Btn_Create()),"Game should not be created");

		//Step 3: Click Schedule section
		//Expected:Newly created Events/Practices should be automatically scheduled and should list under scheduled section.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("SCHEDULE"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("GAME SCHEDULE"));
		asrt.assertTrue(base.isExists(ScheduleUnscheduleObj.Ele_Data(("day active today"))),"Newly created Events/Practices should not be automatically scheduled and should list under scheduled section.");
	}

	// <summary>
	// Test Case Title : "To verify whether the games created under Events are scheduled under Game Schedule."
	// Automation ID : SG_04
	// </summary>
	public void SG_04_ScheduleUnscheduleGames() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ScheduleUnscheduleGames_TestData ScheduleUnscheduleGamesTestData = new ScheduleUnscheduleGames_TestData();
		AddFollower_Obj  AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleObj = new ScheduleUnscheduleGames_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1  :"Go to Games page"
		//Expected:"User should be navigated to Game Page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Event")));

		//Step 2:Create new Events/Practices
		//a.Click on the 'Event' button
		//Expected:The Event Creation Tab should be visible to the user
		base.buttonClick(LoginPageObj.Edt_Alert1("Event"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("Create Game for ")),"The Event Creation Tab should not be visible to the user");

		//b.Enter the Event Name
		//Expected:The user should be able to enter the event name
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),ScheduleUnscheduleGamesTestData.SG_04_ScheduleGamesEventName);
		String ActualEvent = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertEquals(ActualEvent,ScheduleUnscheduleGamesTestData.SG_04_ScheduleGamesEventName,"The user should not be able to enter the event name");

		//c.Select the Time Zone
		//Expected:The user should be able to select the timezone
		base.buttonClick(RegistrationObj.Ele_ErrorMessage("India Standard Time(GMT+5:30)"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("India Standard Time(GMT+5:30)")),"The user should not be able to select the timezone");

		clickOnStartDate = LoginPageObj.Edt_LoginCredentialFields("datetimepicker1");
		buttonClick(clickOnStartDate);
		Thread.sleep(2000); 

		//Step 5: clearing date in the date picker calendar
		webElement=driver.findElement(clickOnStartDate);
		clearTextUsingKeys(webElement);

		webElement.sendKeys(getDateAfterDays(15));
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(7000);

		//f.Click the Create Button
		//Expected:Game should be created
		Thread.sleep(7000);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_CREATE("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red","CREATE")),"The Create button not showing");
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_CREATE("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red","CREATE"));

		//Step 3: Click Schedule section
		//Expected:The Game Schedule bar should be visible to the user
		base.excuteJsClick(LoginPageObj.Edt_Alert1("SCHEDULE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("GAME SCHEDULE")),"The Game Schedule bar should not be visible to the user");

		//Step 4: Switch to Game Schedule
		//Expected:The game created under Events should be listed under Games Schedule.
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("GAME SCHEDULE"));
		Thread.sleep(5000);
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), ScheduleUnscheduleGamesTestData.SG_04_ScheduleGamesEventName);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(ScheduleUnscheduleObj.Ele_Event("game-schedule-tab",ActualEvent)),"The game created under Events is not listed under Games Schedule.");
	}

	// <summary>
	// Test Case Title : "To verify whether the user can be able to play scheduled games"
	// Automation ID : SG_10
	//</summary>
	public void SG_10_ScheduleUnscheduleGames() throws Exception
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj= new LoginPage_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1:Go to Games page
		//Expected:User should be navigated to Games page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Event")));

		//Step 2:Switch to Schedule section
		//Expected:User should be able view the Schedule Tabs
		base.excuteJsClick(LoginPageObj.Edt_Alert1("SCHEDULE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("GAME SCHEDULE")),"User should not be able to view the Schedule Tabs");

		//Step 3:Click any of the game
		//Expected:User should able to play scheduled game.
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Ele_SearchGame("tab-pane fade active show schedule_content","TC07_ScheduleGame")), "User not able to play scheduled games");
		base.excuteJsClick(ScheduleUnscheduleGamesObj.Ele_SearchGame("tab-pane fade active show schedule_content","TC07_ScheduleGame"));
		base.switchToWindowByIndex(driver,0);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("my-player")), "User not able to play the sheduled game");
	}

	// <summary>
	// Test Case Title : "To verify whether the scheduled games can be found through search option"
	// Automation ID : SG_09
	//</summary>
	public void SG_09_ScheduleUnscheduleGames() throws Exception
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj= new LoginPage_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGameObj = new ScheduleUnscheduleGames_Obj();
		ScheduleUnscheduleGames_TestData ScheduleUnscheduleGamesTestData = new ScheduleUnscheduleGames_TestData();
		//Step 1:Go to Games page
		//Expected:User should be navigated to Games page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Event")));

		//Step 2:Switch to Schedule section
		//Expected:User should be able view the Schedule Tabs
		base.excuteJsClick(LoginPageObj.Edt_Alert1("SCHEDULE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("GAME SCHEDULE")),"User should not be able to view the Schedule Tabs");

		//Step 3:Click the Search Icon
		//Expected:User should able to search the scheduled games.
		base.setData(RegistrationObj.Edt_Name("Search"),ScheduleUnscheduleGamesTestData.SG_09_ScheduleGamesEventName);
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGameObj.Ele_SearchGame("tab-pane fade active show schedule_content","TC07_ScheduleGame")), "User should not be able to search the scheduled games.");
	}

	// <summary>
	// Test Case Title : "To verify whether the games created under Practices are scheduled under Practice Schedule."
	// Automation ID : SG_05
	// </summary>
	public void SG_05_ScheduleUnscheduleGames() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleObj = new ScheduleUnscheduleGames_Obj();
		ScheduleUnscheduleGames_TestData ScheduleUnscheduleGamesTestData = new ScheduleUnscheduleGames_TestData();
		AddFollower_Obj  AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1  :"Go to Games page"
		//Expected:"User should be navigated to Game Page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Edt_Alert1("GAMES"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("PRACTICES"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("PRACTICES")),"PRACTICES tab should not be visible to the users");

		//Step 2:Create new Practice
		//a.Click on the 'Practice' button
		//Expected:The Practice Creation Tab should be visible to the user
		base.excuteJsClick(ScheduleUnscheduleObj.Ele_Practice());
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("Create Game for ")),"The Event Creation Tab should not be visible to the user");

		//b.Enter the Event Name
		//Expected:The user should be able to enter the event name
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),ScheduleUnscheduleGamesTestData.SG_05_ScheduleGamesEventName);
		String ActualEvent = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertEquals(ActualEvent,ScheduleUnscheduleGamesTestData.SG_05_ScheduleGamesEventName,"The user should not be able to enter the event name");

		//c.Select the Time Zone
		//Expected:The user should be able to select the timezone
		base.buttonClick(RegistrationObj.Ele_ErrorMessage("India Standard Time(GMT+5:30)"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("India Standard Time(GMT+5:30)")),"The user should not be able to select the timezone");

		clickOnStartDate = LoginPageObj.Edt_LoginCredentialFields("datetimepicker1");
		buttonClick(clickOnStartDate);
		Thread.sleep(2000); 
		webElement=driver.findElement(clickOnStartDate);
		clearTextUsingKeys(webElement);
		webElement.sendKeys(getDateAfterDays(15));
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(7000);

		//f.Click the Create Button
		//Expected:Game should be created
		Thread.sleep(7000);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_CREATE("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red","CREATE")),"The Create button not showing");
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_CREATE("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red","CREATE"));

		//Step 3: Click Schedule section
		//Expected:Practice Schedule Should be visible.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("SCHEDULE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("PRACTICE SCHEDULE")),"Practice Schedule Should not be visible");

		//Step 4:Switch to Practice Schedule
		//Expected:The game created under Practices should be listed under Practice Schedule.
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("PRACTICE SCHEDULE"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage(("nav-schedule"))),"The game created under Practices should not be listed under Practice Schedule.");		
	}
}



