package testPage.MavenPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestData.CommonData;
import TestData.WhiteboardAndReels_TestData;
import objectRepository.AddEditInfo_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.DuplicateTeam_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.ViewListUpdateDownloadShareDeleteLibrary_Obj;
import objectRepository.ViewProfile_Obj;
import utilPack.BasePge;

public class ViewListUpdateDownloadShareDeleteLibrary extends BasePge
{
	BasePge base;
	Assert asrt;

	public ViewListUpdateDownloadShareDeleteLibrary(WebDriver driver)
	{
		super(driver);
		base = new BasePge(driver);
	}
	// <summary>
	// Test Case Title :"Verify that "Library" option should be displayed as 4rth under Film Page for the Users with All roles (Players/Followers/Recruiters/Coach/Admin)"
	// Automation ID   : Library_03_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>
	public void Library_03_ViewListUpdateDownloadShareDeleteLibrary() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback
		//Expected:Games option should be visible
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games option should not be visible");

		//Step 3:Click on Games
		//Expected:User is able to click Games button
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");

		//Step 4:Verify the options
		//Expected:"Library" option should be displayed as 4rth under Film Page for the Users with All roles (Players/Followers/Recruiters/Coach/Admin)
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 2");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"The user should not be able to switch the organization.");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("LIBRARY")),"\"Library\" option should not be displayed as 4rth under Film Page for the Users with All roles (Players/Followers/Recruiters/Coach/Admin)");
	}

	// <summary>
	// Test Case Title :"Verify that the following option should be displayed when click on Library from Film Page
	//1.Resources
	//2.Whiteboard
	//3.Reels"
	// Automation ID   : Library_04_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_04_ViewListUpdateDownloadShareDeleteLibrary() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback
		//Expected:Games option should be visible
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games option should not be visible");

		//Step 3:Click on Games
		//Expected:User is able to click Games button
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");

		//Step 4:Click on Library
		//Expected:The following option should be displayed when click on Library from Film Page
		//1.Resources
		//2.Whiteboard
		//3.Reels
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"The user should not be able to switch the organization.");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("LIBRARY")),"\"Library\" option should not be displayed as 4rth under Film Page for the Users with All roles (Players/Followers/Recruiters/Coach/Admin)");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("LIBRARY"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("resources")),"The Resources option is not displayed when click on Library from Film Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("whiteboards")),"The Whiteboards option is not displayed when click on Library from Film Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("reels")),"The Reels option is not displayed when click on Library from Film Page");
	}

	// <summary>
	// Test Case Title :"Verify that the list of Reels should be displayed when click on Reels from Library"
	// Automation ID   : Library_06_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_06_ViewListUpdateDownloadShareDeleteLibrary() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();
		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback
		//Expected:Games option should be visible
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games option should not be visible");

		//Step 3:Click on Games
		//Expected:User is able to click Games button
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");

		//Step 4:Click on Library
		//Expected:The following option should be displayed when click on Library from Film Page
		//1.Resources
		//2.Whiteboard
		//3.Reels
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"The user should not be able to switch the organization.");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("LIBRARY")),"\"Library\" option should not be displayed as 4rth under Film Page for the Users with All roles (Players/Followers/Recruiters/Coach/Admin)");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("LIBRARY"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("resources")),"The Resources option is not displayed when click on Library from Film Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("whiteboards")),"The Whiteboards option is not displayed when click on Library from Film Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("reels")),"The Reels option is not displayed when click on Library from Film Page");

		//Step 5:Click on Reels
		//Expected:The list of Reels should be displayed when click on Reels from Library
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("reels"));	
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Ele_FirstDate("1")),"The list of Reels shouldn't be displayed when click on Reels from Library");
	}

	// <summary>
	// Test Case Title :"Verify that White boards and Reels should be listed based on the latest date its created"
	// Automation ID   : Library_07_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_07_ViewListUpdateDownloadShareDeleteLibrary() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();
		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback
		//Expected:Games option should be visible
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games option should not be visible");

		//Step 3:Click on Games
		//Expected:User is able to click Games button
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");

		//Step 4:Click on Library
		//Expected:The following option should be displayed when click on Library from Film Page
		//1.Resources
		//2.Whiteboard
		//3.Reels
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"The user should not be able to switch the organization.");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("LIBRARY")),"\"Library\" option should not be displayed as 4rth under Film Page for the Users with All roles (Players/Followers/Recruiters/Coach/Admin)");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("LIBRARY"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("resources")),"The Resources option is not displayed when click on Library from Film Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("whiteboards")),"The Whiteboards option is not displayed when click on Library from Film Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("reels")),"The Reels option is not displayed when click on Library from Film Page");

		//Step 5:Click on Reels//Whiteboards
		//Expected:The list of Reels should be displayed when click on Reels from Library
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Reels"));	
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Ele_FirstDate("1")),"White boards and Reels shouldn't be listed based on the latest date its created");
	}

	// <summary>
	// Test Case Title :"To verify that when click on Share icon the following should be displayed, in Snipback page."
	//1.With Music & Without Music
	//2.Social Medias -Facebook, Whatsapp & Twitter 
	//3.Page Link with URL and a copy icon
	// Automation ID   : Library_23_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>

	public void Library_23_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj viewlistupdatedownloadsharedeletelibrary_Obj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Share icon 
		//Expected : User should be able to view the share reels tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Share"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view facebook icon while clicking on share icon");

		//Step 7   :"Verify that when click on Share icon the following should be displayed,
		//1.With Music & Without Music
		//2.Social Medias -Facebook, Whatsapp & Twitter 
		//3.Page Link with URL and a copy icon"
		//Expected :"User should verify the  following must be displayed
		//1.With Music & Without Music
		//2.Social Medias -Facebook, Whatsapp & Twitter 
		//3.Page Link with URL and a copy icon"
		asrt.assertTrue(base.isExists(createaddnewmemberwithemail_Obj.Ele_EditTeam("reelWithMusic")), "User is not able to view the With Music tab in Share Reel of snipback");
		asrt.assertTrue(base.isExists(createaddnewmemberwithemail_Obj.Ele_EditTeam("reelWithoutMusic")), "User is not able to view the Without Music tab in Share Reel of snipback");
		String[] ShareOptions = {"img-thumbnail fab fa-facebook fa-2x", "img-thumbnail fab fa-twitter fa-2x", "img-thumbnail fab fa-whatsapp fa-2x"};

		for (String Option : ShareOptions) 
		{ 
			asrt.assertTrue(base.isExists(viewlistupdatedownloadsharedeletelibrary_Obj.Ele_Shareoptions(Option)), "User is not able to view the " + Option + " option on the SnipBack page");
		}

		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelSharepageurl")),"User is not able to view Page Link in Sahre reel of the Snipback page");
	}

	// <summary>
	// Test Case Title :"To verify that when click on With Music, the highlight reels should be share with Music in Snipback page."
	// Automation ID   : Library_24_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>

	public void Library_24_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj viewlistupdatedownloadsharedeletelibrary_Obj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Share icon 
		//Expected : User should be able to view the share reels tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Share"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view facebook icon while clicking on share icon");

		//Step 7   :"Verify that when click on With Music, the highlight reels should be share with Music" 
		//Expected :"User should Verify that when click on With Music, the highlight reels should be share with Music"
		base.buttonClick(createaddnewmemberwithemail_Obj.Ele_EditTeam("reelWithMusic"));
		asrt.assertTrue(base.isExists(createaddnewmemberwithemail_Obj.Ele_EditTeam("reelWithMusic")), "User is not able to view the With Music tab in Share Reel of snipback");
	}

	// <summary>
	// Test Case Title :"To verify that when click on Without Music, the highlight reels should be shared without Music in Snipback page."
	// Automation ID   : Library_25_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>

	public void Library_25_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj viewlistupdatedownloadsharedeletelibrary_Obj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Share icon 
		//Expected : User should be able to view the share reels tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Share"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view facebook icon while clicking on share icon");

		//Step 7   :"Verify that when click on With Music, the highlight reels should be share with Music" 
		//Expected :"User should Verify that when click on With Music, the highlight reels should be share with Music"
		base.buttonClick(createaddnewmemberwithemail_Obj.Ele_EditTeam("reelWithoutMusic"));
		asrt.assertTrue(base.isExists(createaddnewmemberwithemail_Obj.Ele_EditTeam("reelWithoutMusic")), "User is not able to view the Without Music tab in Share Reel of snipback");

	}

	// <summary>
	// Test Case Title :"To Verify that the corresponding social media should be navigated while clicking on it from the share otpion to share the Reels in Snipback page."
	// Automation ID   : Library_26_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>

	public void Library_26_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj viewlistupdatedownloadsharedeletelibrary_Obj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Share icon 
		//Expected : User should be able to view the share reels tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Share"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view facebook icon while clicking on share icon");

		//Step 9   :"Verify when the corresponding social media should be navigated while clicking on it from the share otpion to share the Reels"
		//Expected :"User should the corresponding social media should be navigated while clicking on it from the share otpion to share the Reels"
		base.buttonClick(viewlistupdatedownloadsharedeletelibrary_Obj.Ele_Shareoptions("img-thumbnail fab fa-facebook fa-2x"));

	}

	// <summary>
	// Test Case Title :"To Verify that the link should highted and the messaged copied should be displayed when copying  link under Page Link in Snipback page."
	// Automation ID   : Library_27_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>

	public void Library_27_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj viewlistupdatedownloadsharedeletelibrary_Obj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Share icon 
		//Expected : User should be able to view the share reels tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Share"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view facebook icon while clicking on share icon");

		//Step 7   :"Click the copied link icon of URL in snipback"
		//Expected :"User should be clickable the copied link icon of URL in snipback"
		base.excuteJsClick(viewlistupdatedownloadsharedeletelibrary_Obj.Btn_CopiedLink("far fa-clone"));
		asrt.assertTrue(base.isExists(viewlistupdatedownloadsharedeletelibrary_Obj.Ele_LinkMsg("message")), "User not able to view the message Link copied in snipback");

	}

	// <summary>
	// Test Case Title :"To Verify that the copied link should be able to paste in any other platform in Snipback page."
	// Automation ID   : Library_28_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>

	public void Library_28_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj viewlistupdatedownloadsharedeletelibrary_Obj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Share icon 
		//Expected : User should be able to view the share reels tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Share"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view facebook icon while clicking on share icon");

		//Step 7   :"Click the copied link icon of URL in snipback"
		//Expected :"User should be clickable the copied link icon of URL in snipback"
		base.excuteJsClick(viewlistupdatedownloadsharedeletelibrary_Obj.Btn_CopiedLink("far fa-clone"));
		asrt.assertTrue(base.isExists(viewlistupdatedownloadsharedeletelibrary_Obj.Ele_LinkMsg("message")), "User not able to view the message Link copied in snipback");

		//Step 8   :"Paste the copied link of URL into new window in snipback"
		//Expected :"User should be copied link of URL into new window in snipback"
		driver.get("https://snipback-ai-output-videos.s3-accelerate.amazonaws.com/21096/21096_15683_1714477310_final_output.mp4");

	}
	// <summary>
	// Test Case Title :"Verify that the list of whiteboards should be displayed when click on Whiteboards from Library"
	// Automation ID   : Library_05_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_05_ViewListUpdateDownloadShareDeleteLibrary() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();
		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback
		//Expected:Games option should be visible
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games option should not be visible");

		//Step 3:Click on Games
		//Expected:User is able to click Games button
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");

		//Step 4:Click on Library
		//Expected:The following option should be displayed when click on Library from Film Page
		//1.Resources
		//2.Whiteboard
		//3.Reels
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"The user should not be able to switch the organization.");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("LIBRARY")),"\"Library\" option should not be displayed as 4rth under Film Page for the Users with All roles (Players/Followers/Recruiters/Coach/Admin)");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("LIBRARY"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("resources")),"The Resources option is not displayed when click on Library from Film Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("whiteboards")),"The Whiteboards option is not displayed when click on Library from Film Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("reels")),"The Reels option is not displayed when click on Library from Film Page");

		//Step 5:Click on Whiteboard
		//Expected:The list of whiteboards should be displayed when click on Whiteboards from Library
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("reels"));	
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Ele_FirstDate("1")),"The list of reels should not be displayed when click on Whiteboards from Library");
	}

	// <summary>
	// Test Case Title :"Verify that No Data Found Message should be displayed when there is no resources, whiteboards or reels"
	// Automation ID   : Library_08_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_08_ViewListUpdateDownloadShareDeleteLibrary() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();
		Registration_Obj  RegistrationObj = new Registration_Obj();

		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback
		//Expected:Games option should be visible
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games option should not be visible");

		//Step 3:Click on Games
		//Expected:User is able to click Games button
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");

		//Step 4:Click on Library
		//Expected:The following option should be displayed when click on Library from Film Page
		//1.Resources
		//2.Whiteboard
		//3.Reels
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"The user should not be able to switch the organization.");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("LIBRARY")),"\"Library\" option should not be displayed as 4rth under Film Page for the Users with All roles (Players/Followers/Recruiters/Coach/Admin)");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("LIBRARY"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("resources")),"The Resources option is not displayed when click on Library from Film Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("whiteboards")),"The Whiteboards option is not displayed when click on Library from Film Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("reels")),"The Reels option is not displayed when click on Library from Film Page");

		//Step 5:Click on Whiteboards/Reels
		//Expected:No Data Found Message should be displayed when there is no resources, whiteboards or reels 
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("whiteboards"));	
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("nodata")),"No Data Found Message should not be displayed when there is no resources, whiteboards or reels ");
	}

	// <summary>
	// Test Case Title :"Verify that the following details should be displayed for White boards & Reels
	//1.# (Serial Number)
	//2.DATE
	//3.NAME
	//4.GAME NAME
	//5.OPTIONS"
	// Automation ID   : Library_09_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_09_ViewListUpdateDownloadShareDeleteLibrary() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback
		//Expected:Games option should be visible
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games option should not be visible");

		//Step 3:Click on Games
		//Expected:User is able to click Games button
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");

		//Step 4:Click on Library
		//Expected:The following option should be displayed when click on Library from Film Page
		//1.Resources
		//2.Whiteboard
		//3.Reels
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"The user should not be able to switch the organization.");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("LIBRARY")),"\"Library\" option should not be displayed as 4rth under Film Page for the Users with All roles (Players/Followers/Recruiters/Coach/Admin)");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("LIBRARY"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("resources")),"The Resources option is not displayed when click on Library from Film Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("whiteboards")),"The Whiteboards option is not displayed when click on Library from Film Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("reels")),"The Reels option is not displayed when click on Library from Film Page");

		//Step 5:Click on Reels//Whiteboards
		//Expected:The following details should be displayed for White boards & Reels
		//1.# (Serial Number)
		//2.DATE
		//3.NAME
		//4.GAME NAME
		//5.OPTIONS
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("reels"));	
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_WhiteRow()),"The following details should not be displayed for White boards & Reels\r\n"
				+ "		//1.# (Serial Number)\r\n"
				+ "		//2.DATE\r\n"
				+ "		//3.NAME\r\n"
				+ "		//4.GAME NAME\r\n"
				+ "		//5.OPTIONS");
	}
	// <summary>
	// Test Case Title : "Verify that user should able to navigate to the snipback website after entering the URL" 
	// Automation ID : Library_01_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_01_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegObj = new Registration_Obj();
		PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();	
		Thread.sleep(2000);

		//Step 1   :"Verify user reached Snipback website after entering the URL"
		//Expected :"Validate snipback logo is displayed"
		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_SearchField("logo logo1")),"Snipback logo is not displayed in login page");

		//Step 2   :"Verify login is displayed"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

	}
	// <summary>
	// Test Case Title : "Verify that user should able to enter the New name in the name field " 
	// Automation ID : Library_13_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_13_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Rename Icon
		//Expected : User should be able to view the whiteboard rename tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Automation","Rename"));
		asrt.assertTrue(base.isExists(poolObj.Ele_CreatePool("Edit HighlightReel")),"User is not able to view the rename tab while clicking the rename button");

		//Step 7 : Enter New Name for Reels
		//Expected : User should be able to view the name which is renamed
		base.setData(LoginPageObj.Edt_LoginEmail("hr_name"),WhiteboardandreelsTestdata.TC13_Rename);
		base.buttonClick(LoginPageObj.Btn_SigninClick("saveHighlightReel()"));
		asrt.assertTrue(base.isExists(ScheduleunscheduleObj.Ele_FirstDate("New WB")),"User is not able to view the renamed name in the reels list");
	}

	// <summary>
	// Test Case Title : "Verify that user should able to enter the name with Alphabets, symbols, sepcial characters " 
	// Automation ID : Library_14_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_14_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Rename Icon
		//Expected : User should be able to view the whiteboard rename tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Automation","Rename"));
		asrt.assertTrue(base.isExists(poolObj.Ele_CreatePool("Edit HighlightReel")),"User is not able to view the rename tab while clicking the rename button");

		//Step 7 : Enter New Name for Reels
		//Expected : User should be able to view the name which is renamed
		base.setData(LoginPageObj.Edt_LoginEmail("hr_name"),WhiteboardandreelsTestdata.TC13_Specialcharacter);
		base.buttonClick(LoginPageObj.Btn_SigninClick("saveHighlightReel()"));
		asrt.assertTrue(base.isExists(ScheduleunscheduleObj.Ele_FirstDate("New WB@")),"User is not able to view the renamed name in the reels list");
	}

	// <summary>
	// Test Case Title : "Verify that "Name Updated Successfully" message with Ok button should be displayed when we edit the name and click on Save Button " 
	// Automation ID : Library_15_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_15_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Rename Icon
		//Expected : User should be able to view the whiteboard rename tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Automation","Rename"));
		asrt.assertTrue(base.isExists(poolObj.Ele_CreatePool("Edit HighlightReel")),"User is not able to view the rename tab while clicking the rename button");

		//Step 7 : Enter New Name for Reels
		//Expected : User should be able to view the name which is renamed
		base.setData(LoginPageObj.Edt_LoginEmail("hr_name"),WhiteboardandreelsTestdata.TC13_Specialcharacter);
		base.buttonClick(LoginPageObj.Btn_SigninClick("saveHighlightReel()"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Name updated successfully.")),"User is not able to view the Name Updated Successfully message with Ok button when we edit the name and click on Save Button");
		asrt.assertTrue(base.isExists(ScheduleunscheduleObj.Ele_FirstDate("New WB@")),"User is not able to view the renamed name in the reels list");
	}

	// <summary>
	// Test Case Title : "Verify that the page for enter the white board name should be closed when click on Close Button" 
	// Automation ID : Library_16_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_16_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Rename Icon
		//Expected : User should be able to view the whiteboard rename tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Automation","Rename"));
		asrt.assertTrue(base.isExists(poolObj.Ele_CreatePool("Edit HighlightReel")),"User is not able to view the rename tab while clicking the rename button");

		//Step 7 : Click on close button
		//Expected : User should be able to view the reels list while clicking on close button.
		base.buttonClick(poolObj.Btn_ButtonCreate("btn btn-secondary btn-hide-rename-highlightreel p-2"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view reels under Reels section in library");
	}

	// <summary>
	// Test Case Title : "Verify that the new or edited name for the Whiteboard/Reels should be displayed instead of th Old name from the Whiteboard/Reels list " 
	// Automation ID : Library_17_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_17_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Rename Icon
		//Expected : User should be able to view the whiteboard rename tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Rename"));
		asrt.assertTrue(base.isExists(poolObj.Ele_CreatePool("Edit HighlightReel")),"User is not able to view the rename tab while clicking the rename button");

		//Step 7 : Enter New Name for Reels
		//Expected : User should be able to view the name which is renamed
		base.setData(LoginPageObj.Edt_LoginEmail("hr_name"),WhiteboardandreelsTestdata.TC17_Newname);
		base.buttonClick(LoginPageObj.Btn_SigninClick("saveHighlightReel()"));
		asrt.assertTrue(base.isExists(ScheduleunscheduleObj.Ele_FirstDate("New WB 1")),"User is not able to view the renamed name in the reels list");
	}

	// <summary>
	// Test Case Title : "Verify that when click on Share icon from whiteboard, the following should be displayed," 
	// Automation ID : Library_18_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_18_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Share icon 
		//Expected : User should be able to view the share reels tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Share"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view facebook icon while clicking on share icon");
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-twitter fa-2x")),"User is not able to view twitter icon while clicking on share icon");
	}

	// <summary>
	// Test Case Title : "Verify that the corresponding social media should be navigated while clicking on it from the share otpion to share the whiteboard" 
	// Automation ID : Library_19_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_19_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Share icon 
		//Expected : User should be able to view the share reels tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Share"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view facebook icon while clicking on share icon");

		//Step 7 : Click on any social media icon
		//Expected : User should navigate to corresponding social media page 
		base.buttonClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x"));
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("signupBanner")),"User is not navigated to the corresponding social media page while clicking on share icon ");
	}

	// <summary>
	// Test Case Title : "Verify that the link should highted and the messaged copied should be displayed when copying  link under Page Link " 
	// Automation ID : Library_20_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_20_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Share icon 
		//Expected : User should be able to view the share reels tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Share"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view facebook icon while clicking on share icon");

		//Step 7 : Click on the link 
		//Expected : User should be able to click on the share link 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("reelSharepageurl"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelSharepageurl")),"User is not able to view the share link in the share reels tab");
	}

	// <summary>
	// Test Case Title : "Verify that the copied link should be able to paste in any other platform  " 
	// Automation ID : Library_21_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_21_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Share icon 
		//Expected : User should be able to view the share reels tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Share"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view facebook icon while clicking on share icon");

		//Step 7 : Click on the copy link icon 
		//Expected : User should be able to click on copy link icon 
		base.buttonClick(poolObj.Btn_ButtonCreate("cpy reelCopy-shareurl"));		
	}

	// <summary>
	// Test Case Title : "Verify that Close (X) button should be displayed to close the Share page  " 
	// Automation ID : Library_22_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_22_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Share icon 
		//Expected : User should be able to view the share reels tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Share"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view facebook icon while clicking on share icon");

		//Step 7 : Click on the close button 
		//Expected : User should able to view reels under Reels section.
		base.buttonClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Close("Share Reel","close"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view reels under Reels section in library");
	}

	// <summary>
	// Test Case Title : "Verify that the following icons should be displayed under Options in White boards & Reels 1)Rename, 2)Download, 3)Share, 4)Delete" 
	// Automation ID : Library_10_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_10_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show game_content")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.buttonClick(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Team("d-flex align-items-center item-label", "Backup Team"));
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on Whiteboards
		//Expected : User should able to view the whiteboard lists.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Verify the icons under Option
		//Expected : User should able to view the icons under whiteboards
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Automation","Rename")),"User is not able to view the rename icon in the whiteboard list");	;
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Automation","Download")),"User is not able to view the download icon in the whiteboard list");	
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Automation","Share")),"User is not able to view the share icon in the whiteboard list");	
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Automation","Delete")),"User is not able to view the delete icon in the whiteboard list");	
	}

	// <summary>
	// Test Case Title : "Verify that user should able to view the Whiteboard or Reels when click on the Name of the Whiteboard or hightlight reels under the heading Game Name" 
	// Automation ID : Library_11_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_11_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show game_content")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.buttonClick(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Team("d-flex align-items-center item-label", "Backup Team"));
		Thread.sleep(5000);
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on Whiteboards
		//Expected : User should able to view the whiteboard lists.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on the Name of Whiteboards/Reels
		//Expected : User should able to view whiteboard video while clicking the name of whiteboard/reels
		Thread.sleep(10000);
		base.excuteJsClick(ScheduleunscheduleObj.Ele_FirstDate("New WB 1 "));
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("vjs-text-track-display")),"User is not navigated to whiteboard video page while clicking the name of whiteboard");
	}

	// <summary>
	// Test Case Title : "Verify that the following option should be displayed when click on Rename icon,1.Heading- Edit Whiteboard/Edit the HightlightReel, 2. Sub Heading - Name, 3.Field to enter Name for the whiteboard/reels, 4.Close & Save button " 
	// Automation ID : Library_12_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_12_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData commondata = new CommonData();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		Pool_Obj poolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardandreelsTestdata = new WhiteboardAndReels_TestData();
		ScheduleUnscheduleGames_Obj ScheduleunscheduleObj = new ScheduleUnscheduleGames_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Navigate to the Home page and click on Login Button in the Snipback page "
		//expected:"User should able to click Login Button and navigate to Login page in the Snipback page"
		login.loginToApplication(commondata.UserName, commondata.PassWord);

		//Step 3 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(poolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Rename Icon
		//Expected : User should be able to view the whiteboard rename tab 
		Thread.sleep(5000);
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Automation","Rename"));
		asrt.assertTrue(base.isExists(poolObj.Ele_CreatePool("Edit HighlightReel")),"User is not able to view the reels rename tab while clicking the rename button");
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Sub("Edit HighlightReel","Name")),"User is not able to view the sub heading in rename tab while clicking the rename button");
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_Name("HighlightReel Name")),"User is not able to view the edit name field in rename tab while clicking the rename button");
		asrt.assertTrue(base.isExists(poolObj.Btn_ButtonCreate("btn btn-secondary btn-hide-rename-highlightreel p-2")),"User is not able to view the close button in rename tab while clicking the rename button");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SigninClick("saveHighlightReel()")),"User is not able to view the save button in rename tab while clicking the rename button");
	}

	// <summary>
	// Test Case Title :"To Verify that Close (X) button should be displayed to close the Share page in Snipback page."
	// Automation ID   : Library_29_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>
	public void Library_29_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj viewlistupdatedownloadsharedeletelibrary_Obj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");
		
		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to games page in Snipback" );

		//Step 5   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 6 : Click on Share icon 
		//Expected : User should be able to view the share reels tab 
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Rename("Library","Share"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Icon("smd","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view facebook icon while clicking on share icon");

		//Step 7   :"Click the copied link icon of URL in snipback"
		//Expected :"User should be clickable the copied link icon of URL in snipback"
		base.excuteJsClick(viewlistupdatedownloadsharedeletelibrary_Obj.Btn_CopiedLink("far fa-clone"));
		asrt.assertTrue(base.isExists(viewlistupdatedownloadsharedeletelibrary_Obj.Ele_LinkMsg("message")), "User not able to view the message Link copied in snipback");

		//Step 8   :"Click the close icon of snipback"
		//Expected :"User should be clickable the close icon of snipback"
		base.excuteJsClick(viewlistupdatedownloadsharedeletelibrary_Obj.Btn_ShareClose("×"));
	}

	// <summary>
	// Test Case Title : "Verify that user should able to navigate to the Film page once login with credentials" 
	// Automation ID : Library_02_ViewListUpdateDownloadShareDeleteLibrary
	// </summary>
	public void Library_02_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException 
	{ 
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CommonData Commondata = new CommonData();
		DuplicateTeam_Obj DuplicateTeamObj = new DuplicateTeam_Obj();

		//Step 1   :"Enter the URL
		//2.Click on Login button
		//3.Enter the valid email ID & Password"
		//Click on Sign In button
		//Expected :"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		// Step 2: Verify film tab is existing
		// Expected: Film tab is existing
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_DashboardHeaderLink("/games")),"Film sub header link is not showing in dashboard");
		base.buttonClick(DuplicateTeamObj.Ele_DashboardHeaderLink("/games"));

	}
	// <summary>
	// Test Case Title :"Verify that the whiteboard should be removed from Whiteboard list"
	// Automation ID   : Library_33_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>

	public void Library_33_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj viewlistupdatedownloadsharedeletelibrary_Obj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 8   :"Click the delete icon of Whiteboard from Library"
		//Expected :"User clickable the delete icon of Whiteboard from Library in Snipback page"
		base.excuteJsClick(viewlistupdatedownloadsharedeletelibrary_Obj.Btn_Share("20572","fa fa-trash"));

		//Step 9   :"Verify that the message Do you want to delete this White board? with Yes & Cancel  should be displayed when click on Delete icon from the Options of Whitebaord from Library"
		//Expected :"User should be view the message Do you want to delete this White board? with Yes & Cancel  should be displayed when click on Delete icon from the Options of Whitebaord in Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Do you want to delete this Highlight reel?")), "User should not able to view the alert message as Do you want to delete this White board? in popup of snipback");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Yes")), "User should not able to view the Yes button in popup of snipback");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel")), "User should not able to view the Yes button in popup of snipback");

		//Step 10   :"Click the Yes button of delete popup Whiteboard from Library"
		//Expected :"The whiteboard should be removed from Whiteboard list"
		//The step 10 is not executing because we can't able to automate createation of WB so it's would affect the TC to delete WB 
		//			base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		//asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Ele_FirstDate("WB-841")), "The whiteboard is not removed from Whiteboard list");
	}

	// <summary>
	// Test Case Title :"Verify that the message "Success Hightlight reels deleted successfully" should popup when click on Yes button"
	// Automation ID   : Library_36_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>

	public void Library_36_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 8   :"Click the delete icon of Whiteboard from Library"
		//Expected :"User clickable the delete icon of Whiteboard from Library in Snipback page"
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Share("20572","fa fa-trash"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Do you want to delete this Highlight reel?")),"The message Do you want to delete this Highlight reel?? should be displayed when click on Delete icon from the Options of Whitebaord");

		//Step 8   : "Click Yes Button"
		//Expected : "The message "Success Hightlight reels deleted successfully" should popup when click on Yes button"
		//The step 8 is not executing because we are not able to automate creation of Reels so it's would affect the TC to delete Reel 
		//base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		//asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("HighlightReel deleted successfully.")),"The message Success Hightlight reels deleted successfully should popup when click on Yes button");
	}

	// <summary>
	// Test Case Title :"Verify that the Highlight reels should be removed from Whiteboard list"
	// Automation ID   : Library_37_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>

	public void Library_37_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 8   :"Click the delete icon of Whiteboard from Library"
		//Expected :"User clickable the delete icon of Whiteboard from Library in Snipback page"
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Share("20572","fa fa-trash"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Do you want to delete this Highlight reel?")),"The message Do you want to delete this Highlight reel?? should be displayed when click on Delete icon from the Options of Whitebaord");

		//Step 8   : "Click Yes Button"
		//Expected : "The Highlight reels should be removed from Whiteboard list"
		//The step 8 is not executing because we are not able to automate creation of Reels so it's would affect the TC to delete Reel 
		//base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		//asrt.assertFalse(base.isExists(ScheduleUnscheduleGamesObj.Ele_FirstDate("New WB 1")),"The message Success Hightlight reels deleted successfully should popup when click on Yes button");
	}

	// <summary>
	// Test Case Title :"Verify that the message Do you want to delete this Highlight reel?? with Yes & Cancel  should be displayed when click on Delete icon from the Options of Whitebaord"
	// Automation ID   : Library_34_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>

	public void Library_34_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj viewlistupdatedownloadsharedeletelibrary_Obj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 8   :"Click the delete icon of Whiteboard from Library"
		//Expected :"User clickable the delete icon of Whiteboard from Library in Snipback page"
		base.excuteJsClick(viewlistupdatedownloadsharedeletelibrary_Obj.Btn_Share("20572","fa fa-trash"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Do you want to delete this Highlight reel?")),"The message Do you want to delete this Highlight reel?? should be displayed when click on Delete icon from the Options of Whitebaord");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Yes")),"The message 'Yes' should be displayed when click on Delete icon from the Options of Whitebaord");
		asrt.assertTrue(base.isExists(viewlistupdatedownloadsharedeletelibrary_Obj.Btn_ReelsCancel("swal-button swal-button--cancel","Cancel")),"The message 'Cancel'  should be displayed when click on Delete icon from the Options of Whitebaord");
	}

	// <summary>
	// Test Case Title :"Verify that the message Do you want to delete this Highlight reels? popup should be closed when click on Cancel button"
	// Automation ID   : Library_35_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>

	public void Library_35_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 8   :"Click the delete icon of Whiteboard from Library"
		//Expected :"User clickable the delete icon of Whiteboard from Library in Snipback page"
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_Share("20572","fa fa-trash"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Do you want to delete this Highlight reel?")),"The message Do you want to delete this Highlight reel?? should be displayed when click on Delete icon from the Options of Whitebaord");

		//Step 7   :"Click Cancel Button"
		//Expected : The message Do you want to delete this Highlight reels? popup should be closed when click on Cancel button
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("swal-button swal-button--cancel","Cancel"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Reels("table table-striped film-list")), "User not able to be navigate to the Reels tab from Library in Snipback page");
	}
	// <summary>
	// Test Case Title :"To Verify that the message Do you want to delete this White board? with Yes & Cancel  should be displayed when click on Delete icon from the Options of Whitebaord in Snipback page."
	// Automation ID   : Library_30_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>

	public void Library_30_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj viewlistupdatedownloadsharedeletelibrary_Obj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 8   :"Click the delete icon of Whiteboard from Library"
		//Expected :"User clickable the delete icon of Whiteboard from Library in Snipback page"
		base.excuteJsClick(viewlistupdatedownloadsharedeletelibrary_Obj.Btn_Share("20572","fa fa-trash"));

		//Step 9   :"Verify that the message Do you want to delete this White board? with Yes & Cancel  should be displayed when click on Delete icon from the Options of Whitebaord from Library"
		//Expected :"User should be view the message Do you want to delete this White board? with Yes & Cancel  should be displayed when click on Delete icon from the Options of Whitebaord in Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Do you want to delete this Highlight reel?")), "User should not able to view the alert message as Do you want to delete this Highlight reel? in popup of snipback");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Yes")), "User should not able to view the Yes button in popup of snipback");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel")), "User should not able to view the Yes button in popup of snipback");

	}

	// <summary>
	// Test Case Title :"To Verify that the message Do you want to delete this White board? popup should be closed when click on Cancel button in Snipback page."
	// Automation ID   : Library_31_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>

	public void Library_31_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj viewlistupdatedownloadsharedeletelibrary_Obj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 8   :"Click the delete icon of Whiteboard from Library"
		//Expected :"User clickable the delete icon of Whiteboard from Library in Snipback page"
		base.excuteJsClick(viewlistupdatedownloadsharedeletelibrary_Obj.Btn_Share("20572","fa fa-trash"));

		//Step 9   :"Verify that the message Do you want to delete this White board? with Yes & Cancel  should be displayed when click on Delete icon from the Options of Whitebaord from Library"
		//Expected :"User should be view the message Do you want to delete this White board? with Yes & Cancel  should be displayed when click on Delete icon from the Options of Whitebaord in Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Do you want to delete this Highlight reel?")), "User should not able to view the alert message as Do you want to delete this White board? in popup of snipback");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Yes")), "User should not able to view the Yes button in popup of snipback");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel")), "User should not able to view the Yes button in popup of snipback");

		//Step 10   :"Click the Cancel button of delete popup Whiteboard from Library"
		//Expected :"Click the Cancel button of delete popup Whiteboard from Library in Snipback page"
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel"));
		asrt.assertTrue(base.isExists(viewlistupdatedownloadsharedeletelibrary_Obj.Ele_Reels("table table-striped film-list")), "User not able to be navigate to the Whiteboard tab from Library in Snipback page");
	}

	// <summary>
	// Test Case Title :"To Verify that the message "Success Whiteboard deleted successfully" should popup when click on Yes button in Snipback page."
	// Automation ID   : Library_32_ViewListUpdateDownloadShareDeleteLibrary 
	// </summary>

	public void Library_32_ViewListUpdateDownloadShareDeleteLibrary() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj viewlistupdatedownloadsharedeletelibrary_Obj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemail_Obj = new CreateAddNewMemberWithEmail_Obj();

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
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the games tab");

		//Step 4 : Click on Library
		//Expected : User should able to view the files under library module
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("nav-link list-library"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("FILES")),"User is not able to view the files under the library module");

		//Step 5 : Click on whiteboard
		//Expected : User should able to view the whiteboard lists.
		base.buttonClick(LoginPageObj.Btn_SingnIn("reels"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-pane fade active show")),"User is not able to view the whiteboard list under whiteboards");

		//Step 8   :"Click the delete icon of Whiteboard from Library"
		//Expected :"User clickable the delete icon of Whiteboard from Library in Snipback page"
		base.excuteJsClick(viewlistupdatedownloadsharedeletelibrary_Obj.Btn_Share("20572","fa fa-trash"));

		//Step 9   :"Verify that the message Do you want to delete this White board? with Yes & Cancel  should be displayed when click on Delete icon from the Options of Whitebaord from Library"
		//Expected :"User should be view the message Do you want to delete this White board? with Yes & Cancel  should be displayed when click on Delete icon from the Options of Whitebaord in Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Do you want to delete this Highlight reel?")), "User should not able to view the alert message as Do you want to delete this White board? in popup of snipback");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Yes")), "User should not able to view the Yes button in popup of snipback");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel")), "User should not able to view the Yes button in popup of snipback");

		//Step 10   :"Click the Yes button of delete popup Whiteboard from Library"
		//Expected :"Click the Yes button of delete popup Whiteboard from Library in Snipback page"

		//The step 10 is not executing because we can't able to automate create WB so it's difficult to delete WB 
		//base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		//asrt.assertTrue(base.isExists(viewlistupdatedownloadsharedeletelibrary_Obj.Ele_Reels("table table-striped film-list")), "User not able to be navigate to the Whiteboard tab from Library in Snipback page");
	}
}
