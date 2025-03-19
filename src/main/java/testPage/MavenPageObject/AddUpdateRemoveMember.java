package testPage.MavenPageObject;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestData.AddEditInfo_TestData;
import TestData.AddUpdateDeleteDuplicateTeamGameDefaults_TestData;
import TestData.AddUpdateRemoveMember_TestData;
import TestData.CommonData;
import TestData.CreateAddNewMemberWithEmail_TestData;
import TestData.EditDeleteCameraViewPlayerPage_TestData;
import TestData.MoveGame_TestData;
import TestData.SnipBackLogin_TestData;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.ShareGame_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.ViewListUpdateDownloadShareDeleteLibrary_Obj;
import objectRepository.ViewProfile_Obj;
import objectRepository.AddEditInfo_Obj;
import objectRepository.AddFollower_Obj;
import objectRepository.AddUpdateDeleteDuplicateTeamGameDefaults_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.ArchiveUnarchiveTeam_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.CreateUpdateDeleteGame_Obj;
import objectRepository.ForgotPassword_Obj;
import objectRepository.HighlightReels_Obj;
import utilPack.BasePge;

public class AddUpdateRemoveMember extends BasePge {
	BasePge base;
	Assert asrt;
	By clickOnStartDate ;
	WebElement webElement;

	public AddUpdateRemoveMember(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify the user can share a game internally with an entire team in Snipback page."
	// Automation ID   : TestCase_17 
	// </summary>
	public void TestCase_17_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_17_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_17_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_17_TeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_17_TeamName)), "Failed to select TEAM");
		Thread.sleep(5000);

		//Step 6 : Select EVENTS/PRACTICES/SCOUT
		//Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddUpdateRemoveMemberTestData.TestCase_17_EventOrGameName)),"Event Game is not Visible");

		//Step 7 : Locate a game in the list and click on the three dots to open the menu.
		//Expected :"There should be a option as 'Share' in Games Listing menu."
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AddUpdateRemoveMemberTestData.TestCase_17_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Share")), "User not able to view the option as 'Share' in Games Listing menu");

		//Step 8 : Select the Share icon from the menu.
		//Expected : A popup screen should appear with option to Share Internally
		base.excuteJsClick(addeditinfObj.Ele_AddInfo("Share"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_ShareHeading("Share Game")),"A popup screen should not appear with options to Share Internally and Share Externally.");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareinternally","snipback-share-users")),"User unable to view the option 'Share Internally'");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareinternally","snipback-share-users"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersCreate("playersbtn","PLAYERS")), "User not able to view the Players option");

		//Step 9 : "Enter valid Search Words and Click Search Globally"
		//Expected: "The search results should return relevant content related to the players"
		base.setData(LoginPageObj.Edt_LoginEmail("search-key"),AddUpdateRemoveMemberTestData.TestCase_17_TeamID);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("search-key"));
		asrt.assertEquals(ActualName,AddUpdateRemoveMemberTestData.TestCase_17_TeamID,"User should not able to enter the name in Search Words");
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("globalsearch"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersCreate("teamsbtn","TEAMS")), "User not able to view the Teams option");

		//Step 10 : "Click player Tab & Select a player from the list"
		//Expected:" The user should be able to see a list of player names after clicking the "Players" tab"
		base.excuteJsClick(AddFollowerObj.Btn_FollowersCreate("teamsbtn","TEAMS"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(ShareGameObj.Ele_PlayerTeamName(AddUpdateRemoveMemberTestData.TestCase_17_TeamID)), "User not able to view the Team name list");
		base.excuteJsClick(ShareGameObj.Ele_PlayerTeamName(AddUpdateRemoveMemberTestData.TestCase_17_TeamID));

		//Step 11 : Click on the Share icon.
		//Expected : A success popup message should appear, confirming the game has been shared with the selected team(s).
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("listSnipReel()"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Game shared succesfully")),"'Game shared successfully' message is not displayed to user while user share a game with a Team");
	}

	// <summary>
	// Test Case Title :"To verify the user can select Share Externally and displays social media sharing icons and a game URL copy link option of Snipback."
	// Automation ID   : TestCase_18 
	// </summary>
	public void TestCase_18_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_18_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_18_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_18_TeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_18_TeamName)), "Failed to select TEAM");
		Thread.sleep(5000);

		//Step 6 : Select EVENTS/PRACTICES/SCOUT
		//Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddUpdateRemoveMemberTestData.TestCase_18_EventOrGameName)),"Event Game is not Visible");

		//Step 7 : Locate a game in the list and click on the three dots to open the menu.
		//Expected :"There should be a option as 'Share' in Games Listing menu."
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AddUpdateRemoveMemberTestData.TestCase_18_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Share")), "User not able to view the option as 'Share' in Games Listing menu");

		//Step 8 :Select the Share icon from the menu.
		//Expected : A popup screen should appear with option to Share Externally.
		base.excuteJsClick(addeditinfObj.Ele_AddInfo("Share"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_ShareHeading("Share Game")),"A popup screen should not appear with options to Share Internally and Share Externally.");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareexternally","external-share")),"User unable to view the option 'Share Externally'");

		//Step 9 : Verify that social media sharing icons and a Copy URL Link option are displayed.
		//Expected : Social media icons (e.g., Facebook, Linkedin, etc.) and a Copy URL Link option should be displayed.
		base.excuteJsClick(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareexternally","external-share"));
		Thread.sleep(8000);
		String[] SearchExternalOptions = {"img-thumbnail fab fa-facebook fa-2x","img-thumbnail fab fa-twitter fa-2x","img-thumbnail fab fa-linkedin fa-2x","img-thumbnail fab fa-pinterest fa-2x","img-thumbnail fab fa-telegram fa-2x","img-thumbnail fab fa-whatsapp fa-2x","img-thumbnail fab fa-skype fa-2x"};
		for(String Option : SearchExternalOptions)
		{
			asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_SearchExternally("smd col-md-3",Option)), "User is not able to view the " + Option + " social media options on the SnipBack page");
		}
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("sharepageurl")), "The user unable see the Copy URL Link option");
	}		

	// <summary>
	// Test Case Title : "Verify whether the user is able to enter an email in the Create & Add New Member With Email option shows relevant email suggestions." 
	// Automation ID : TestCase_32
	// </summary>
	public void TestCase_32_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException 
	{ 
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData=new AddUpdateRemoveMember_TestData();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(AddUpdateRemoveMemberTestData.TestCase_12_Org));

		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
		
		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)),"Details of the Team should not be displayed when click on Edit option from the three dots against the team");
	
		// Step5: Click on Create & Add New Member With Email button
	    // Expected:User should be able to  see Add New user tab 
		base.buttonClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
	    asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to see Add New user tab");
     	        
        // Step6: Enter email id in Enter Email Address field, shows relevant email suggestions and check name auto-fill the name field .
     	// Expected: User should be able to see the Email suggestions should appear, and selecting one should auto-fill the name field
     	base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"), AddUpdateRemoveMemberTestData.TestCase_32_AddUpdateRemoveMember_Email1);
     	asrt.assertTrue(base.validateText(AddUpdateRemoveMemberObj.Ddl_EmailTxt("ui-id-2")), "User unable to see the relevant email suggestions");
     	base.autoSuggestiveDropDown(AddUpdateRemoveMemberObj.Ddl_EmailTxt("ui-id-2"),AddUpdateRemoveMemberTestData.TestCase_32_AddUpdateRemoveMember_Email); 
     	//asrt.assertEquals(base.GetValue(LoginPageObj.Edt_LoginEmail("firstnameNew")),AddUpdateRemoveMemberTestData.TC32_AddUpdateRemoveMember_Name,"The user unable to  view the name that is required to automatically populate in the name field.");
     	
	}
	// <summary>	
	// Test Case Title : "Verify that the user can successfully log in and access the Create Pool page." 
	// Automation ID : TestCase_07
	// </summary>	
	public void  TestCase_07_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws Exception
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		Pool_Obj PoolObj = new Pool_Obj();
		CommonData CommonData = new CommonData();

		// Step1: Log in to SnipBack.
		//Expected:User should be able to login	
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);

		//Step2:Click on the Pool icon in the menu bar.
		//Expected:+ Create Pool icon should be visible to user
		base.buttonClick(LoginPageObj.Btn_SignInButton("POOLS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"+ Create Pool icon should be visible to user");

		//Step3:Click on the + Create Pool icon above the menu bar.
		//Expected:The pool creation page should appear, allowing the user to enter a pool name and select the pool type.
		base.buttonClick(LoginPageObj.Edt_Alert1("Create Pool"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("CREATE POOL")),"The pool creation page should not appear, allowing the user to enter a pool name and select the pool type.");


	}


	// <summary>
	// Test Case Title : "Ensure the user can enter a pool name and select a pool type (Private or Semiprivate)." 
	// Automation ID : TestCase_08
	// </summary>
	public void  TestCase_08_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws Exception
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		Pool_Obj PoolObj = new Pool_Obj();
		CommonData CommonData = new CommonData();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();

		//Step 1:Enter a unique pool name in the input field.
		//Expected:User should be able to add the name
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_SignInButton("POOLS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"+ Create Pool icon should be visible to user");
		base.buttonClick(LoginPageObj.Edt_Alert1("Create Pool"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("CREATE POOL")),"The pool creation page should not appear, allowing the user to enter a pool name and select the pool type.");
		base.setData(LoginPageObj.Edt_LoginEmail("pool_name"),AddUpdateRemoveMemberTestData.TestCase_08_AddUpdateRemoveMemberUniquePoolName);
		String ActualPoolName = base.GetValue(LoginPageObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(ActualPoolName, AddUpdateRemoveMemberTestData.TestCase_08_AddUpdateRemoveMemberUniquePoolName,"User should not be able to add the name");

		//Step 2:Select a pool type (Private or Semiprivate).
		//Expected:The user should be able to enter the pool name and select either Private or Semiprivate as the pool type without errors.
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("fliter-input pool-type-select"),AddUpdateRemoveMemberTestData.TestCase_08_PoolType);
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Private")),"The user should not able to enter the pool name and select either Private or Semiprivate as the pool type without errors.");

	}

	// <summary>
	// Test Case Title : "Ensure the user can enter a pool name and select a pool type (Private or Semiprivate)." 
	// Automation ID : TestCase_09
	// </summary>
	public void TestCase_09_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws Exception
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new 	Registration_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		CommonData CommonData = new CommonData();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();

		//Step 1:Select Private as the pool type.
		//Expected:User should be able to select Private as the pool type.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_SignInButton("POOLS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"+ Create Pool icon should be visible to user");
		base.buttonClick(LoginPageObj.Edt_Alert1("Create Pool"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("CREATE POOL")),"The pool creation page should not appear, allowing the user to enter a pool name and select the pool type.");
		base.setData(LoginPageObj.Edt_LoginEmail("pool_name"),AddUpdateRemoveMemberTestData.TestCase_08_AddUpdateRemoveMemberUniquePoolName);
		String ActualPoolName = base.GetValue(LoginPageObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(ActualPoolName, AddUpdateRemoveMemberTestData.TestCase_08_AddUpdateRemoveMemberUniquePoolName,"User should not be able to add the name");
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("fliter-input pool-type-select"),AddUpdateRemoveMemberTestData.TestCase_08_PoolType);
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Private")),"The user should not be able to enter the pool name and select either Private or Semiprivate as the pool type without errors.");
		base.excuteJsClick((PoolObj.Ele_SelectPoolType("Private")));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Private")),"User should not be able to select Private as the pool type");

		//Step 2:Check if an input field appears for entering email IDs to search for users.
		//Expected: The additional field for entering email IDs should appear only when Private is selected.
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Users ")),"The additional field for entering email IDs should not appear only when Private is selected");

	}

	// <summary>
	// Test Case Title : "Validate that the user can enter an email ID, search, and add users for a Private pool type." 
	// Automation ID : TestCase_10
	// </summary>
	public void TestCase_10_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws Exception
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new 	Registration_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		CommonData CommonData = new CommonData();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMember_Obj = new AddUpdateRemoveMember_Obj();

		//Step 1:Enter a valid email ID in the input field for adding users.
		//Expected:The user should be able to enter a valid email id
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		base.buttonClick(LoginPageObj.Btn_SignInButton("POOLS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"+ Create Pool icon should be visible to user");
		base.buttonClick(LoginPageObj.Edt_Alert1("Create Pool"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("CREATE POOL")),"The pool creation page should not appear, allowing the user to enter a pool name and select the pool type.");
		base.setData(LoginPageObj.Edt_LoginEmail("pool_name"),AddUpdateRemoveMemberTestData.TestCase_08_AddUpdateRemoveMemberUniquePoolName);
		String ActualPoolName = base.GetValue(LoginPageObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(ActualPoolName, AddUpdateRemoveMemberTestData.TestCase_08_AddUpdateRemoveMemberUniquePoolName,"User should not be able to add the name");
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("fliter-input pool-type-select"),AddUpdateRemoveMemberTestData.TestCase_08_PoolType);
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Private")),"The user should not be able to enter the pool name and select either Private or Semiprivate as the pool type without errors.");
		base.excuteJsClick((PoolObj.Ele_SelectPoolType("Private")));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Private")),"User should not be able to select Private as the pool type");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Users ")),"The additional field for entering email IDs should not appear only when Private is selected");
		base.setData(LoginPageObj.Edt_LoginEmail("pool_userSearch"),AddUpdateRemoveMemberTestData.TestCase_10_AddUpdateRemoveMemberEmail);
		String ActualEmail = base.GetValue(LoginPageObj.Edt_LoginEmail("pool_userSearch"));
		asrt.assertEquals(ActualEmail,AddUpdateRemoveMemberTestData.TestCase_10_AddUpdateRemoveMemberEmail,"The user should not be able to enter a valid email id");

		//Step 2:Perform a search and verify that matching users appear.
		//Expected:The user should be able to find the matching users
		base.setData(LoginPageObj.Edt_LoginEmail("pool_userSearch"),AddUpdateRemoveMemberTestData.TestCase_10_AddUpdateRemoveMemberEmail);
		base.excuteJsClick(AddUpdateRemoveMember_Obj.Ddl_Email("ui-menu-item","jhoncy.j@se-mentor.com"));

		//Step 3:Select the user(s) from the search results.
		//Expected:The system should display the relevant users based on the entered email ID, allowing the user to select them.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Jhoncy")),"The system should not display the relevant users based on the entered email ID, not allowing the user to select them");
	}

	// <summary>
	// Test Case Title : "Validate that the user can enter an email ID, search, and add users for a Private pool type." 
	// Automation ID : TestCase_11
	// </summary>
	public void TestCase_11_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws Exception
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new 	Registration_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		CommonData CommonData = new CommonData();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1:Complete the pool name, select pool type, and add users if creating a private pool.
		//Expected:The user should be able to complete the following cases
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(3000);
		
		base.buttonClick(LoginPageObj.Btn_SignInButton("POOLS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"+ Create Pool icon should be visible to user");
		base.buttonClick(LoginPageObj.Edt_Alert1("Create Pool"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("CREATE POOL")),"The pool creation page should not appear, allowing the user to enter a pool name and select the pool type.");
		base.setData(LoginPageObj.Edt_LoginEmail("pool_name"),AddUpdateRemoveMemberTestData.TestCase_08_AddUpdateRemoveMemberUniquePoolName);
		String ActualPoolName = base.GetValue(LoginPageObj.Edt_LoginEmail("pool_name"));
		//asrt.assertEquals(ActualPoolName, AddUpdateRemoveMemberTestData.TestCase_08_AddUpdateRemoveMemberUniquePoolName,"User should not be able to add the name");
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("fliter-input pool-type-select"),"Private");
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Private")),"The user should not be able to enter the pool name and select either Private or Semiprivate as the pool type without errors.");
		base.excuteJsClick((PoolObj.Ele_SelectPoolType("Private")));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Private")),"User should not be able to select Private as the pool type");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Users ")),"The additional field for entering email IDs should not appear only when Private is selected");
		base.setData(LoginPageObj.Edt_LoginEmail("pool_userSearch"),AddUpdateRemoveMemberTestData.TestCase_10_AddUpdateRemoveMemberEmail);
		String ActualEmail = base.GetValue(LoginPageObj.Edt_LoginEmail("pool_userSearch"));
		asrt.assertEquals(ActualEmail,AddUpdateRemoveMemberTestData.TestCase_10_AddUpdateRemoveMemberEmail,"The user should not be able to enter a valid email id");
		base.setData(LoginPageObj.Edt_LoginEmail("pool_userSearch"),AddUpdateRemoveMemberTestData.TestCase_10_AddUpdateRemoveMemberEmail);
		//asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("jhoncy.j@se-mentor.com")),"The user should not be able to find the matching users");
		//base.excuteJsClick(LoginPageObj.Btn_Login("jhoncy.j@se-mentor.com"));
		Thread.sleep(5000);
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ddl_Email("ui-menu-item","jhoncy.j@se-mentor.com"));					
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Jhoncy")),"The system should not display the relevant users based on the entered email ID, not allowing the user to select them");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_PoolCreate("CREATE")),"The user should not be able to complete the following cases");

		//Step 2:Click on the Create icon.
		//Expected:A success message should display, and the new pool should be created and available in the pool list.
		base.excuteJsClick(AddUpdateRemoveMemberObj.Btn_CREATE("modal-footer border-0 flex-column1","CREATE"));
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("PoolWorks")),"A success message should not display, and the new pool should not be created and available in the pool list");
	}


	// <summary>
	// Test Case Title : "To verify whether multiple members can be selected and added or removed in a single action"
	// Automation ID : TestCase_31
	// </summary>
	public void TestCase_31_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_31_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_31_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_31_TeamName));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_31_TeamName)), "Failed to select TEAM");
		Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_31_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_31_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(AddUpdateRemoveMemberTestData.TestCase_31_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateRemoveMemberTestData.TestCase_31_TeamName)), "User unable to click 'Edit Team' option from three dot menu");

		//Step 8 : Review the list on the right side to confirm it only includes current team members.
		//Expected : "All Current Team Members should displayed on the right side of the screen"
		asrt.assertTrue(base.isExists(addupdateremoveMemberObj.Ele_CurrentTeamMembers("CURRENT TEAM MEMBERS")), "User not able to see Current Team Members");
		asrt.assertTrue(base.isExists(addupdateremoveMemberObj.Chk_TeamMembers("checked-right")), "Current Team Members are not displayed on the right side of the edit screen");

		//Step 9 : Select multiple team members from the right side list and click the Remove icon
		//Expected : The selected members should removed from the team, and their name no longer appears in the team member list on the right side.
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers(AddUpdateRemoveMemberTestData.TestCase_31_MemberName1,"teamCheckBox"));
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers(AddUpdateRemoveMemberTestData.TestCase_31_MemberName2,"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		Thread.sleep(3000);

		//Verify if removed member is in left side of the screen
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading(AddUpdateRemoveMemberTestData.TestCase_31_MemberName1)),"User unable to remove the member from the team");
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading(AddUpdateRemoveMemberTestData.TestCase_31_MemberName2)),"User unable to remove the member from the team");
	}

	// <summary>
	// Test Case Title : "Verify that the user can successfully log in and select an organization from the dropdown list.." 
	// Automation ID : TestCase_01
	// </summary>
	public void TestCase_01_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1: Log in to SnipBack with valid credentials.
		//Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(7000);
		
		//Step 2: Select the desired organization from the dropdown list on the left side.
		//Expected: The selected organization’s created games should be displayed in the middle of the page.
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("AutomationOrg - 1")),"The option 'AutomationOrg - 1' is not selected from the team dropdown in the Games page");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("nav-game")),"The game of the organization is not visible under the Events tab in the Games page.");

	}

	// <summary>
	// Test Case Title : "Check that clicking the three dots on a created game and selecting the "Upload Video" icon navigates to the upload video page." 
	// Automation ID : TestCase_02
	// </summary>
	public void TestCase_02_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersobj= new SearchGameTeamAndMembers_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1: Log in to SnipBack with valid credentials.
		//Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(7000);
		
		//Step 3: Select the desired organization from the dropdown list on the left side.
		//Expected: The selected organization’s created games should be displayed in the middle of the page.
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("AutomationOrg - 1")),"The option 'AutomationOrg - 1' is not selected from the team dropdown in the Games page");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("nav-game")),"The game of the organization is not visible under the Events tab in the Games page.");

		//Step 4: Select a Team from ORG
		//Expected: User should able to select Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_02_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(AddUpdateRemoveMemberTestData.TestCase_02_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateRemoveMemberTestData.TestCase_02_SearchTeam)),"User unable to unable to select Team");

		//Step 5  :Select the game and click the three dots on a cretaed game
		//Expected: User is able to Select the game and click the three dots on a cretaed game
		base.setData(LoginPageObj.Edt_LoginEmail("search"), AddUpdateRemoveMemberTestData.TestCase_02_SearchName);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);

		//Step 6: Click the three dots on a created game.
		//Expected: user able to click the three dots on game and select the option the Upload Game
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("btn-group dropleft right-menu-wrap"));
		Thread.sleep(3000);
		base.scrollToElement(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersobj.Ele_MemberName("Upload Video")),"The Upload Widget is not displaying");

	}

	//<summary>
	//Test Case Title : "Ensure that users with roles such as Player, Follower, and Recruiter cannot edit team members" Done with Recruiter because Player and follower are not having any members in team
	//Automation ID : TestCase_33
	//</summary>
	public void TestCase_33_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Verifying 'Edit Team' option available for 'Player' user role.

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_33_OrgNamePlayer);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_33_TeamNamePlayer);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_33_TeamNamePlayer));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_33_TeamNamePlayer)), "Failed to select TEAM");
		Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_33_TeamNamePlayer,"dropdown-wrapper teams-menu"));
		Thread.sleep(3000);
		base.isDoesNotExist(CreateAddNewMemberWithEmailObj.Btn_EditBtn(AddUpdateRemoveMemberTestData.TestCase_33_TeamNamePlayer,"dropdown-menu","Edit Team"), "User unable to see the 'Edit Team' option under the three dots in the Games Page");
		asrt.assertTrue(base.isExists(addfollowerObj.Btn_Followers("nav-members-tab")), "Members tab is not disabled if the user as 'Player' in the Film page");
		driver.navigate().refresh();
		Thread.sleep(5000);

		//Verifying 'Edit Team' option available for 'Follower' user role.

		//Step 7 : "Select a OrgName"
		//Expected : "User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_33_OrgNameFollower);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 8 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_33_TeamNameFollower);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_33_TeamNameFollower));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_33_TeamNameFollower)), "Failed to select TEAM");
		Thread.sleep(3000);

		// Step 9 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_33_TeamNameFollower,"dropdown-wrapper teams-menu"));
		Thread.sleep(3000);
		base.isDoesNotExist(CreateAddNewMemberWithEmailObj.Btn_EditBtn(AddUpdateRemoveMemberTestData.TestCase_33_TeamNameFollower,"dropdown-menu","Edit Team"), "User unable to see the 'Edit Team' option under the three dots in the Games Page");
		asrt.assertTrue(base.isExists(addfollowerObj.Btn_Followers("nav-members-tab")), "Members tab is not disabled if the user as 'Player' in the Film page");
		driver.navigate().refresh();
		Thread.sleep(5000);

		//Verifying 'Edit Team' option available for 'Recruiter' user role.

		//Step 10 : "Select a OrgName"
		//Expected : "User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_33_OrgNameRecruiter);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 11 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_33_TeamNameRecruiter);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_33_TeamNameRecruiter));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_33_TeamNameRecruiter)), "Failed to select TEAM");
		Thread.sleep(3000);

		// Step 12 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_33_TeamNameRecruiter,"dropdown-wrapper teams-menu"));
		Thread.sleep(3000);
		base.isDoesNotExist(CreateAddNewMemberWithEmailObj.Btn_EditBtn(AddUpdateRemoveMemberTestData.TestCase_33_TeamNameRecruiter,"dropdown-menu","Edit Team"), "User unable to see the 'Edit Team' option under the three dots in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-members-tab")), "The user is not able to view the Member's tab in the Film page");

		//Step 13 : Click on the Members Tab
		//Expected :"The user should able to click on Followers tab in the Film page"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		Thread.sleep(5000);

		//Step 14 : Click on the Member's name and change the first name
		//Expected : User is able to view the member's details with Update and dismiss button
		base.excuteJsClick(addfollowerObj.Ele_FollowerName(AddUpdateRemoveMemberTestData.TestCase_33_MemberName,AddUpdateRemoveMemberTestData.TestCase_33_MemberEmail));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Btn_Create("button","UPDATE")),"User is not able to view the Member's details with Update and dismiss button");

		//Step 15 : Change the First name and click on Update button
		//Expected : A popup message should appear as 'Sorry, you are not authorized to update user details'
		base.setData(LoginPageObj.Edt_LoginEmail("ed_first_name"), AddUpdateRemoveMemberTestData.TestCase_33_MemberFirstName);
		base.excuteJsClick(PoolObj.Btn_Create("button","UPDATE"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Sorry, you are not authorized to update user details")), "Recruiter is able to edit the Member details");
		base.excuteJsClick(addfollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
		base.excuteJsClick(addfollowerObj.Btn_FollowersUpdate("DISMISS"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerName(AddUpdateRemoveMemberTestData.TestCase_33_MemberName,AddUpdateRemoveMemberTestData.TestCase_33_MemberEmail)),"The member's detail has been modified");
	}

	// <summary>
	// Test Case Title : "Ensure that the user can cancel the update process and return to the member list without saving changes."
	// Automation ID : TeastCase_37
	// </summary>
	public void TestCase_37_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException {

		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CommonData Commondata=new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData=new AddUpdateRemoveMember_TestData();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj= new SearchGameTeamAndMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1: Go to Games/Members page
		//Expected: User should be navigated to Games page.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		//asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");
		Thread.sleep(7000);
		
		//Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		//Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(AddUpdateRemoveMemberTestData.TestCase_12_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(AddUpdateRemoveMemberTestData.TestCase_12_Org)),"The organization is not selected");
		//base.excuteJsClick(LoginPageObj.Edt_Alert1(AddUpdateRemoveMemberTestData.TestCase_37_TeamName));


		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_37_TeamName);

		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_37_TeamName));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_37_TeamName)), "Failed to select TEAM");

		//Step 3: Click on Home page Memeber	
		//Expected: The member edit page is displayed, allowing the user to modify member details.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("MEMBERS")),"Unable to select Member icon from the home page");
		base.buttonClick(LoginPageObj.Edt_Alert1("MEMBERS"));

		//Step 4: getting the name and email of the user we are clicking
		String actualMemberName=GetText(AddUpdateRemoveMemberObj.Ele_TeamMemberDetails(AddUpdateRemoveMemberTestData.TestCase_37_MemberRole,AddUpdateRemoveMemberTestData.TestCase_37_MemberName));
		String actualMemberEmail=GetText(AddUpdateRemoveMemberObj.Ele_TeamMemberDetails(AddUpdateRemoveMemberTestData.TestCase_37_MemberRole,AddUpdateRemoveMemberTestData.TestCase_37_MemberEmail));
		System.out.println("actualMemberEmail is:"+actualMemberEmail);

		//Step 5: Clicking on the user to edit in the member list of team "SemTest"
		base.scrollToElement(AddUpdateRemoveMemberObj.Ele_TeamMemberRole(AddUpdateRemoveMemberTestData.TestCase_37_MemberRole));
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_TeamMemberRole(AddUpdateRemoveMemberTestData.TestCase_37_MemberRole));

		//Step 6:Verifying we clicked the correct user of Step 4 by checking the name in step 4 and first name inside the edit page
		asrt.assertTrue(actualMemberName.contains(driver.findElement(LoginPageObj.Edt_LoginEmail(AddUpdateRemoveMember_TestData.TestCase_37_FirstNameInEditMember)).getText()),"Failed to click on the required user as name is not matching");				
		Thread.sleep(3000);
		asrt.assertEquals(actualMemberEmail, driver.findElement(LoginPageObj.Edt_LoginEmail(AddUpdateRemoveMember_TestData.TestCase_37_EmailInEditMemberToGetEmail)).getAttribute("value"),"Failed to click on the required user as email is not matching");

		//Step 7: edit the name in edit page
		base.setData(LoginPageObj.Edt_LoginEmail(AddUpdateRemoveMember_TestData.TestCase_37_FirstNameInEditMember),CreateRandom(7));

		//Step 8: edit the email in edit page
		base.setData(LoginPageObj.Edt_LoginEmail(AddUpdateRemoveMember_TestData.TestCase_37_EmailInEditMemberToEnterEmail),CreateRandom(5).concat(AddUpdateRemoveMember_TestData.TestCase_37_gmailcom));

		//Step 9: get the name after editing
		String memberNameAfterEditing=GetText(LoginPageObj.Edt_LoginEmail(AddUpdateRemoveMember_TestData.TestCase_37_FirstNameInEditMember));

		//Step 10: get the email after editing
		String memberEmailAfterEditing=driver.findElement(LoginPageObj.Edt_LoginEmail(AddUpdateRemoveMember_TestData.TestCase_37_EmailInEditMemberToGetEmail)).getAttribute("value");

		//Step 11: Click on Dismiss button
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_Dismiss("btn btn-danger w-100 fs-6 dismiss", "DISMISS")),"Dismiss button is not displayed in edit member page");
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_Dismiss("btn btn-danger w-100 fs-6 dismiss", "DISMISS"));

		//Step 12: Get the name of the member which was clicked and edited and dismissed 
		String nameInListOfMembersAfterClickingDismiss=GetText(AddUpdateRemoveMemberObj.Ele_TeamMemberName(actualMemberName));

		//Step 13: Verify if the member name is same after editing and clicking on dismiss button
		asrt.assertTrue(actualMemberName.contains(nameInListOfMembersAfterClickingDismiss),"Dismiss Button is not working and member name and email got editted");

	}

	// Test Case Title : "Validate that the user can enter an email ID, search, and add users for a Private pool type." 
	// Automation ID : TestCase_12
	// </summary>
	public void TestCase_12_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		Pool_Obj Pool_obj =new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		Actions actions = new Actions(driver);
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();

		//Step 1:Click on the three dots next to a completed game.
		//Expected:User should be able to view the 'Move to Pool' Option
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		//asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("#nav-game")),"User not able to click Games button");
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_12_Org);
		asrt.assertTrue(base.isExists(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the GameList");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("EVENTS"));
		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),MoveGame_TestData.TC_11_GameName);	    
		Thread.sleep(5000);
		actions.sendKeys(Keys.ENTER).perform();
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots("SemMoveGame")),"Unable to Click on the menu icon (three dots)");
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots("SemMoveGame"));
		base.excuteJsClick(MoveGameObj.Btn_3Dots("SemMoveGame"));
		//asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_Pool("dropdown-menu dropdown-menu-center show","Move to pool")),"User should not be able to view the 'Move to Pool' Option");

		//Step 2:Select Move to Pool.
		//Expected:The user should be able to view the popup screen
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_Pool("dropdown-menu dropdown-menu-center show","Move to pool"));
		asrt.assertTrue(base.isExists(Pool_obj.Ele_CreatePool("Move To Pool")),"The user should not be able to view the popup screen");

		//Step 3:In the popup screen, select the previously created pool and click on the Move icon
		//Expected:A success message should appear, confirming that the game has been moved to the selected pool.		
		asrt.assertTrue(base.isExists(Pool_obj.Ddl_TeamDropdwn("fliter-input col-md-7")),"User not able to Navigate to the GameList");
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("fliter-input col-md-7"),AddUpdateRemoveMemberTestData.TestCase_12_PoolTime);
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_PoolCheck());		

		base.excuteJsClick(Pool_obj.Btn_PoolUpdate("MOVE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Game successfully Added to Pool(s).")),"A success message should not appear, confirming that the game has been moved to the selected pool.");
	}


	// <summary>
	// Test Case Title : "Ensure the moved game appears in the correct pool under the Pool section." 
	// Automation ID : TestCase_13
	// </summary>
	public void TestCase_13_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		Pool_Obj Pool_obj =new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData =new AddUpdateRemoveMember_TestData();

		//Step 1:Click on the Pool icon in the menu bar.
		//Expected:The newly created pool should be visible to the user.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		//asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("#nav-game")),"User not able to click Games button");
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_12_Org);
		asrt.assertTrue(base.isExists(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the GameList");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("POOLS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("SemTestPool1")),"The newly created pool should not be visible to the user.");

		//Step 2:Select the newly created pool
		//Expected:The user should be able to find the pool heading
		base.buttonClick(LoginPageObj.Btn_Login("SemTestPool1"));
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTitle("SemTestPool1")),"The user should not be able to find the pool heading");

		//Step 3:Verify that the moved game appears in the list of games within the selected pool.
		//Expected: The moved game should be displayed within the selected pool.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("SemMoveGame")),"The moved game should not be displayed within the selected pool.");
	}

	// <summary>
	// Test Case Title : "Ensure the user can access the Share Game options by clicking on the Share icon within the game menu." 
	// Automation ID : Test Case 14
	// </summary>
	public void TestCase_14_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_14_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_14_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_14_TeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_14_TeamName)), "Failed to select TEAM");
		Thread.sleep(5000);

		//Step 6 : Select EVENTS/PRACTICES/SCOUT
		//Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddUpdateRemoveMemberTestData.TestCase_14_EventOrGameName)),"Event Game is not Visible");

		//Step 7 : Locate a game in the list and click on the three dots to open the menu.
		//Expected :"There should be a option as 'Share' in Games Listing menu."
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AddUpdateRemoveMemberTestData.TestCase_14_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Share")), "User not able to view the option as 'Share' in Games Listing menu");

		//Step 8 : Select the Share icon from the menu.
		//Expected : A popup screen should appear with options to Share Internally and Share Externally.
		base.excuteJsClick(addeditinfObj.Ele_AddInfo("Share"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_ShareHeading("Share Game")),"A popup screen should not appear with options to Share Internally and Share Externally.");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareinternally","snipback-share-users")),"User unable to view the option 'Share Internally'");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareexternally","external-share")),"User unable to view the option 'Share Externally'");
	}

	// <summary>
	// Test Case Title : "Check that selecting Share Internally displays the options to Share Game to Players and Teams." 
	// Automation ID : TestCase_15
	// </summary>
	public void TestCase_15_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_15_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_15_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_15_TeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_15_TeamName)), "Failed to select TEAM");
		Thread.sleep(5000);

		//Step 6 : Select EVENTS/PRACTICES/SCOUT
		//Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddUpdateRemoveMemberTestData.TestCase_15_EventOrGameName)),"Event Game is not Visible");

		//Step 7 : Locate a game in the list and click on the three dots to open the menu.
		//Expected :"There should be a option as 'Share' in Games Listing menu."
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AddUpdateRemoveMemberTestData.TestCase_15_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Share")), "User not able to view the option as 'Share' in Games Listing menu");

		//Step 8 :Select the Share icon from the menu.
		//Expected : A popup screen should appear with options to Share Internally and Share Externally.
		base.excuteJsClick(addeditinfObj.Ele_AddInfo("Share"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_ShareHeading("Share Game")),"A popup screen should not appear with options to Share Internally and Share Externally.");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareinternally","snipback-share-users")),"User unable to view the option 'Share Internally'");

		//Step 9 : Verify that options Share Game to Players and Share Game to Teams are visible.
		//Expected : Both Share Game to Players and Share Game to Teams options should be displayed.
		base.excuteJsClick(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareinternally","snipback-share-users"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersCreate("playersbtn","PLAYERS")), "User not able to view the Players option");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersCreate("teamsbtn","TEAMS")), "User not able to view the Teams option");
	}



	// <summary>
	// Test Case Title : "Ensure the user can share a game internally to individual players." 
	// Automation ID : TestCase_16
	// </summary>
	public void TestCase_16_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_16_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_16_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_16_TeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_16_TeamName)), "Failed to select TEAM");
		Thread.sleep(5000);

		//Step 6 : Select EVENTS/PRACTICES/SCOUT
		//Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddUpdateRemoveMemberTestData.TestCase_16_EventOrGameName)),"Event Game is not Visible");

		//Step 7 : Locate a game in the list and click on the three dots to open the menu.
		//Expected :"There should be a option as 'Share' in Games Listing menu."
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AddUpdateRemoveMemberTestData.TestCase_16_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Share")), "User not able to view the option as 'Share' in Games Listing menu");

		//Step 8 : Select the Share icon from the menu.
		//Expected : A popup screen should appear with option to Share Internally
		base.excuteJsClick(addeditinfObj.Ele_AddInfo("Share"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_ShareHeading("Share Game")),"A popup screen should not appear with options to Share Internally and Share Externally.");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareinternally","snipback-share-users")),"User unable to view the option 'Share Internally'");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareinternally","snipback-share-users"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersCreate("playersbtn","PLAYERS")), "User not able to view the Players option");

		//Step 9 : "Enter valid Search Words and Click Search Globally"
		//Expected: "The search results should return relevant content related to the players"
		base.setData(LoginPageObj.Edt_LoginEmail("search-key"),AddUpdateRemoveMemberTestData.TestCase_16_PlayerEmail);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("search-key"));
		asrt.assertEquals(ActualName,AddUpdateRemoveMemberTestData.TestCase_16_PlayerEmail,"User should not able to enter the name in Search Words");
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("globalsearch"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersCreate("playersbtn","PLAYERS")), "User not able to view the Players option");

		//Step 10 : "Click player Tab & Select a player from the list"
		//Expected:" The user should be able to see a list of player names after clicking the "Players" tab"
		base.excuteJsClick(AddFollowerObj.Btn_FollowersCreate("playersbtn","PLAYERS"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("(anshu@maildrop.cc)")), "User not able to view the Players name list");
		base.excuteJsClick(SearchGameTeamAndMembersObj.Ele_MemberName("(anshu@maildrop.cc)"));

		//Step 11 : Click on the Share icon.
		//Expected : A success popup message should appear, confirming the game has been shared with the selected player(s).
		base.setZoom(driver, 50);
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("listSnipReel()"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Game shared succesfully")),"Game shared successfully message is not displayed to user while user share a game with a player");
	}


	// <summary>
	// Test Case Title :"To verify the user can copy the game URL link for external sharing and pasting it should show the correct game link of Snipback."
	// Automation ID   : TestCase_19 
	// </summary>
	public void TestCase_19_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_19_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_19_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_19_TeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_19_TeamName)), "Failed to select TEAM");
		Thread.sleep(5000);

		//Step 6 : Select EVENTS/PRACTICES/SCOUT
		//Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddUpdateRemoveMemberTestData.TestCase_19_EventOrGameName)),"Event Game is not Visible");

		//Step 7 : Locate a game in the list and click on the three dots to open the menu.
		//Expected :"There should be a option as 'Share' in Games Listing menu."
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AddUpdateRemoveMemberTestData.TestCase_19_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Share")), "User not able to view the option as 'Share' in Games Listing menu");

		//Step 8 : Select the Share icon from the menu.
		//Expected : A popup screen should appear with option to Share Externally.
		base.excuteJsClick(addeditinfObj.Ele_AddInfo("Share"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_ShareHeading("Share Game")),"A popup screen should not appear with options to Share Internally and Share Externally.");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareexternally","external-share")),"User unable to view the option 'Share Externally'");

		//Step 9 : Click on 'Share Externally' and verify Copy URL Link option 
		//Expected : Copy URL Link option should be displayed.
		base.excuteJsClick(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareexternally","external-share"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("sharepageurl")), "The user unable see the Copy URL Link option");

		//Step 10 : "Click on the Copy URL Link icon"
		//Expected : "User should be click on the Copy URL Link icon of Share Game Popup and view the message as 'link copied'"
		base.buttonClick(PoolObj.Btn_ButtonCreate("cpy copy-shareurl"));
		Thread.sleep(5000);
		// Retrieve clipboard content and validate it
		String expectedURL = AddUpdateRemoveMemberTestData.TestCase_19_CopiedURL;
		String clipboardContent = base.getClipboardText();
		asrt.assertEquals(clipboardContent, expectedURL, "The copied video URL does not match the expected URL");	

		//Step 11 : Open a new tab and paste the copied link into a new browser to verify the copied URL.
		//Expected : The URL link should be successfully copied to the clipboard, and pasting it should show the correct game link.
		asrt.assertFalse(clipboardContent.isEmpty(), "Clipboard content is empty or URL was not copied");
		//Open New browser tab
		((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
		Thread.sleep(2000);
		base.switchToWindowByIndex(driver, 1); 
		driver.get(clipboardContent); 
		Thread.sleep(5000);
		//Verify both videos are the same
		String videoTitleInNewTab = base.GetText(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddUpdateRemoveMemberTestData.TestCase_19_EventOrGameName));
		asrt.assertEquals(videoTitleInNewTab, ("Entire Game Video - "+AddUpdateRemoveMemberTestData.TestCase_19_EventOrGameName).toUpperCase(), "The video in the new tab does not match the original video.");	 
	}

	// <summary>
	// Test Case Title :"To verify that each social media sharing icon redirects the user to the appropriate platform of Snipback."
	// Automation ID   : TestCase_20
	// </summary>
	public void TestCase_20_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_20_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_20_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_20_TeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_20_TeamName)), "Failed to select TEAM");
		Thread.sleep(5000);

		//Step 6 : Select EVENTS/PRACTICES/SCOUT
		//Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddUpdateRemoveMemberTestData.TestCase_20_EventOrGameName)),"Event Game is not Visible");

		//Step 7 : Locate a game in the list and click on the three dots to open the menu.
		//Expected :"There should be a option as 'Share' in Games Listing menu."
		base.excuteJsClick(addeditinfObj.Btn_Threedot(AddUpdateRemoveMemberTestData.TestCase_20_EventID,"dropdownMenuButton1"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(addeditinfObj.Ele_AddInfo("Share")), "User not able to view the option as 'Share' in Games Listing menu");

		//Step 8 :Select the Share icon from the menu.
		//Expected : A popup screen should appear with option to Share Externally.
		base.excuteJsClick(addeditinfObj.Ele_AddInfo("Share"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_ShareHeading("Share Game")),"A popup screen should not appear with options to Share Internally and Share Externally.");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareexternally","external-share")),"User unable to view the option 'Share Externally'");

		//Step 9 : Verify that the respective social media site opens and that the game link is prefilled in the chat box.
		//Expected : Each social media platform should open, showing the game link in the sharing post.
		base.excuteJsClick(AddUpdateRemoveMemberObj.Btn_ShareInternalHeading("type col-md-4 shareexternally","external-share"));
		Thread.sleep(8000);
		String[] SearchExternalOptions = {"img-thumbnail fab fa-facebook fa-2x","img-thumbnail fab fa-twitter fa-2x","img-thumbnail fab fa-linkedin fa-2x","img-thumbnail fab fa-pinterest fa-2x","img-thumbnail fab fa-telegram fa-2x","img-thumbnail fab fa-whatsapp fa-2x","img-thumbnail fab fa-skype fa-2x"};
		for(String Option : SearchExternalOptions)
		{
			base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_SearchExternally("smd col-md-3",Option));

		}
	}

	// <summary>
	// Test Case Title :"To verify  that only Admins and Coaches have permissions to add, update, or remove members in an organization or team of Snipback."
	// Automation ID   : TestCase_21
	// </summary>

	public void TestCase_21_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select Admin or coaches "
		//Expected :"User should be navigated to Admin or coaches list"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		// step 5  :"Verify whether the Member and Follower is enabled for Admin or coaches"
		//Expected :"Admin or coaches should be access the Member and Follower options "	
		asrt.assertTrue(base.isEnabledBy(addupdateremoveMemberObj.Ele_enable("member")),"Admin or coaches not should be access the Member options");
		asrt.assertTrue(base.isEnabledBy(addupdateremoveMemberObj.Ele_enable("follower")),"Admin or coaches not should be access the Follower options");

		//Step 6   :"Select Player or Followers or Recruiters"
		//Expected :"User should be navigated to Player or Followers or Recruiters list"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 2");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 7   :"Verify whether the Member and Follower is enabled for Player or Followers or Recruiters"
		//Expected :"Player or Followers or Recruiters should not be access the Member and Follower options"
		asrt.assertFalse(base.isEnabledBy(addupdateremoveMemberObj.Ele_enable("member")),"Player or Follower should be access the Member options");
		asrt.assertFalse(base.isEnabledBy(addupdateremoveMemberObj.Ele_enable("follower")),"Player or Follower should be access the Follower options");

	}


	// <summary>
	// Test Case Title :"To verify that Admin or Coach can successfully add a single member to the organization using the single-user option of Snipback."
	// Automation ID   : TestCase_22
	// </summary>

	public void TestCase_22_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithemailObj = new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_TestData addupdateremovemembertestdata = new AddUpdateRemoveMember_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select Admin or coaches "
		//Expected :"User should be navigated to Admin or coaches list"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 5: Select a Team from ORG
		//Expected: User should able to select Team is Selected
		Thread.sleep(2000);
		base.scrollToElement(LoginPageObj.Edt_Alert1("Backup Team"));
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Backup Team"));
		Thread.sleep(3000);

		//Step 6  :"Click the Member option and "
		//Expected :"User should be navigated to Member page of Snipback"
		base.scrollToElement(addupdateremoveMemberObj.Ele_enable("member"));
		Thread.sleep(2000);
		base.excuteJsClick(addupdateremoveMemberObj.Ele_enable("member"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(addupdateremoveMemberObj.Ele_MemberNav("d-flex header-container-wrap")),"User should not be navigated to Member page of Snipback");

		//Step 7  :"Click the Add Member button"
		//Expected :"User should be navigated to Add Member page of Snipback"
		base.scrollToElement(createaddnewmemberWithemailObj.Ele_EditTeam("addMemberBtn"));
		base.excuteJsClick(createaddnewmemberWithemailObj.Ele_EditTeam("addMemberBtn"));
		asrt.assertTrue(base.isExists(createaddnewmemberWithemailObj.Ele_Heading("ADD NEW USER")), "User should not be navigated to Add Member page of Snipback");

		//Step 8  :"Click the Add Single User button and enter the email, Firtname, lastName, Role,Jesy Number"
		//Expected :"User should be clickable the Add Single User button of Snipback"
		base.buttonClick(LoginPageObj.Edt_Alert1("Add Single User"));
		Thread.sleep(700);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("emailInputNew"));
		Thread.sleep(700);
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"), addupdateremovemembertestdata.TestCase_21_AddUpdateRemoveMemberTestEmail);
		base.setData(LoginPageObj.Edt_LoginEmail("firstnameNew"), addupdateremovemembertestdata.TestCase_21_AddUpdateRemoveMemberTestFirstName);
		String Enteredfirstname = base.GetValue(LoginPageObj.Edt_LoginEmail("firstnameNew"));
		base.setData(LoginPageObj.Edt_LoginEmail("lastnameNew"), addupdateremovemembertestdata.TestCase_21_AddUpdateRemoveMemberTestLastName);
		Thread.sleep(700);
		base.excuteJsClick(addupdateremoveMemberObj.Ele_Role("createPlayerRadioBtn"));
		base.setData(LoginPageObj.Edt_LoginEmail("newJerseyNumber"), addupdateremovemembertestdata.TestCase_21_AddUpdateRemoveMemberTestJesrryNumber);

		//Step 9  :"Click the Add as Player / User To Organization button of snipback"
		//Expected :"User should be clickable the Add as Player / User To Organization button of Snipback and need to successfully add the user in Snipback"
		base.scrollToElement(LoginPageObj.Btn_SigninClick("createNewTeamUserSingle();"));
		Thread.sleep(700);
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("createNewTeamUserSingle();"));
		Thread.sleep(7000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("User Added Successfully!")), "User should not be clickable the Add as Player / User To Organization button of Snipback and cannot view the successfully popup in Snipback");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));

		//Step 10  :"Verify the member’s details should reflect accurately in the organization’s member list."
		//Expected :"User should be view the member’s details accurately in the organization’s member list in Snipback"
		base.scrollToElement(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap player-search"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap player-search"));
		base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap player-search"), Enteredfirstname);
		Thread.sleep(700);

	}

	// <summary>
	// Test Case Title :"To verify that Admin or Coach can successfully add a multiple member to the organization using the multiple-user option of Snipback."
	// Automation ID   : TestCase_23
	// </summary>

	public void TestCase_23_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithemailObj = new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_TestData addupdateremovemembertestdata = new AddUpdateRemoveMember_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select Admin or coaches "
		//Expected :"User should be navigated to Admin or coaches list"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 5: Select a Team from ORG
		//Expected: User should able to select Team is Selected
		Thread.sleep(2000);
		base.scrollToElement(LoginPageObj.Edt_Alert1("Backup Team"));
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Backup Team"));
		Thread.sleep(3000);

		//Step 6  :"Click the Member option and "
		//Expected :"User should be navigated to Member page of Snipback"
		base.scrollToElement(addupdateremoveMemberObj.Ele_enable("member"));
		Thread.sleep(2000);
		base.excuteJsClick(addupdateremoveMemberObj.Ele_enable("member"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(addupdateremoveMemberObj.Ele_MemberNav("d-flex header-container-wrap")),"User should not be navigated to Member page of Snipback");

		//Step 7  :"Click the Add Member button"
		//Expected :"User should be navigated to Add Member page of Snipback"
		base.scrollToElement(createaddnewmemberWithemailObj.Ele_EditTeam("addMemberBtn"));
		base.excuteJsClick(createaddnewmemberWithemailObj.Ele_EditTeam("addMemberBtn"));
		asrt.assertTrue(base.isExists(createaddnewmemberWithemailObj.Ele_Heading("ADD NEW USER")), "User should not be navigated to Add Member page of Snipback");

		//Step  7 :Click the Multiple User button and enter the email, Jesy Number for first user"
		//Expected :"User should be clickable the Multiple User button of Snipback"
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Add Multiple Users"));
		Thread.sleep(700);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("email_1"));
		base.setData(LoginPageObj.Edt_LoginEmail("email_1"), addupdateremovemembertestdata.TestCase_23_AddUpdateRemoveMemberTestEmail1);
		String Enteredemail1=base.GetValue(LoginPageObj.Edt_LoginEmail("email_1"));
		Thread.sleep(700);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("jersey_1"));
		base.setData(LoginPageObj.Edt_LoginEmail("jersey_1"), addupdateremovemembertestdata.TestCase_23_AddUpdateRemoveMemberTestJesrryNumber1);

		//Step 8  :Click the Multiple User button and enter the email, Jesy Number for second user"
		//Expected :"User should be clickable the Multiple User button of Snipback"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("email_2"));
		Thread.sleep(700);
		base.setData(LoginPageObj.Edt_LoginEmail("email_2"), addupdateremovemembertestdata.TestCase_23_AddUpdateRemoveMemberTestEmail2);
		Thread.sleep(700);
		base.setData(LoginPageObj.Edt_LoginEmail("jersey_2"), addupdateremovemembertestdata.TestCase_23_AddUpdateRemoveMemberTestJesrryNumber2);
		Thread.sleep(700);
		base.scrollToElement(addupdateremoveMemberObj.Btn_Close("add-user-card-options card-remove-btn"));
		Thread.sleep(700);
		base.excuteJsClick(addupdateremoveMemberObj.Btn_Close("add-user-card-options card-remove-btn"));
		Thread.sleep(1000);
		
		//Step 9  :"Click the Add User To Organization button of snipback"
		//Expected :"User should be clickable the Add User To Organization button of Snipback and need to successfully add the multiple users in Snipback"
		base.scrollToElement(LoginPageObj.Btn_SingnIn("saveMutipleUsers"));
		Thread.sleep(700);
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("saveMutipleUsers"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "User should not be clickable the  Add User To Organization button of Snipback and cannot view the successfully popup in Snipback");
		base.buttonClick(LoginPageObj.Btn_SignInButton("OK"));

		//Step 10  :"Verify the member’s details should reflect accurately in the organization’s member list."
		//Expected :"User should be view the member’s details accurately in the organization’s member list in Snipback"
		base.scrollToElement(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap player-search"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap player-search"));
		base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap player-search"), Enteredemail1);
		Thread.sleep(700);

	}

	// <summary>
	// Test Case Title :"To verify that Admin or Coach  when entering an email ID in the single/multiple -user addition form, auto-suggestions appear, and selecting a suggestion fills in the name field in Snipback."
	// Automation ID   : TestCase_24
	// </summary>

	public void TestCase_24_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithemailObj = new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_TestData addupdateremovemembertestdata = new AddUpdateRemoveMember_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select Admin or coaches "
		//Expected :"User should be navigated to Admin or coaches list"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 5: Select a Team from ORG
		//Expected: User should able to select Team is Selected
		Thread.sleep(2000);
		base.scrollToElement(LoginPageObj.Edt_Alert1("Backup Team"));
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Backup Team"));
		Thread.sleep(3000);

		//Step 6  :"Click the Member option and "
		//Expected :"User should be navigated to Member page of Snipback"
		base.scrollToElement(addupdateremoveMemberObj.Ele_enable("member"));
		Thread.sleep(2000);
		base.excuteJsClick(addupdateremoveMemberObj.Ele_enable("member"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(addupdateremoveMemberObj.Ele_MemberNav("d-flex header-container-wrap")),"User should not be navigated to Member page of Snipback");

		//Step 7  :"Click the Add Member button"
		//Expected :"User should be navigated to Add Member page of Snipback"
		base.scrollToElement(createaddnewmemberWithemailObj.Ele_EditTeam("addMemberBtn"));
		base.excuteJsClick(createaddnewmemberWithemailObj.Ele_EditTeam("addMemberBtn"));
		asrt.assertTrue(base.isExists(createaddnewmemberWithemailObj.Ele_Heading("ADD NEW USER")), "User should not be navigated to Add Member page of Snipback");

		//Step 7  :"Click the Add Single User button and enter the initial letters of an email in the email input field in Snipback"
		//Expected :"User should be clickable the Add Single User button and successfully entering the initial letters of an email in the email input field in Snipback"
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Add Single User"));
		Thread.sleep(700);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("emailInputNew"));
		Thread.sleep(700);
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"), addupdateremovemembertestdata.TestCase_24_TestEmail);
		Thread.sleep(700);

		//Step 8  :"Click suggested email in the email dropdown field in Snipback and verify the First Name is autofilled or not in snipback"
		//Expected :"User should be clickable suggested email in the email dropdown field in Snipback and user must be view the Firstname field is autofilled in snipback"
		//base.excuteJsClick(LoginPageObj.Btn_Login("neethumahendran5@gmail.com"));
		//base.autoSuggestiveDropDown(Pool_obj.Ele_SelectPoolType("Player"), "Player");
		base.autoSuggestiveDropDown(LoginPageObj.Btn_Login("netthubharthi@gmail.com"), "netthubharthi@gmail.com");
		String firstname=base.GetValue(LoginPageObj.Edt_LoginEmail("firstnameNew"));
		asrt.assertEquals(firstname, "Neethu");

	}

	// <summary>
	// Test Case Title :"To verify that the user can access the edit option for a team by selecting a team and clicking on the Edit Team icon in Snipback."
	// Automation ID   : TestCase_25
	// </summary>

	public void TestCase_25_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithemailObj = new CreateAddNewMemberWithEmail_Obj();
		ViewProfile_Obj viewprofileObj = new ViewProfile_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		AddUpdateRemoveMember_TestData addupdateremovemembertestdata = new AddUpdateRemoveMember_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select Admin or coaches "
		//Expected :"User should be navigated to Admin or coaches list"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the Orglist and not able to select OrgName");

		//Step 5: Select a Team from ORG
		//Expected: User should able to select Team is Selected
		Thread.sleep(2000);
		base.scrollToElement(LoginPageObj.Edt_Alert1("Backup Team"));
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Backup Team"));
		Thread.sleep(3000);

		//Step 5   :"Click three dots of any Team in snipback "
		//Expected :"User should be clickable on three dots of any Team in snipback"
		base.scrollToElement(ArchiveUnarchiveTeamObj.Btn_TThreeDots(addupdateremovemembertestdata.TestCase_25_TeamName));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(addupdateremovemembertestdata.TestCase_25_TeamName));
		Thread.sleep(1000);

		//Step 6   :"Click Edit Team option from three dot option and navigate to Edit Team page in snipback "
		//Expected :"User should be clickable Edit Team option from three dot option  and should navigate to Edit Team page in snipback"
		base.scrollToElement(createaddnewmemberWithemailObj.Ele_EditTeam("team-5380"));
		base.excuteJsClick(createaddnewmemberWithemailObj.Ele_EditTeam("team-5380"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(viewprofileObj.Ele_ResetPassHeading("EDIT TEAM - Backup Team")), "User should not able to clickable Edit Team option from three dot option and should not navigate to Edit Team page in Snipback");
		Thread.sleep(1000);

		//Step 7   :"Verify the edit team screen should be displayed with options to add, remove, create, and add new members with or without email snipback "
		//Expected :"User should be able to view edit team screen and be displayed with options to add, remove, create, and add new members with or without email in snipback"
		String[] EditTeamOption = {"addPlayersToRight();", "removePlayersToRight();", "createAndAddNewPlayers();","addNewPlayersWOEmial();"};
		for (String Option : EditTeamOption) 
		{
			asrt.assertTrue(base.isExists(addupdateremoveMemberObj.Ele_EditTeam(Option)), "User is not able to view the " + Option + " option on the Edit Team page in Snipback");

		}

	}

	// <summary>
	// Test Case Title : "To verify that  that selecting an user from the left side list and clicking the Add icon adds the member to the team in Snipback."
	// Automation ID   : TestCase_26
	// </summary>
	public void TestCase_26_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_26_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_26_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_26_TeamName));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_26_TeamName)), "Failed to select TEAM");
		Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_26_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_26_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(AddUpdateRemoveMemberTestData.TestCase_26_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateRemoveMemberTestData.TestCase_26_TeamName)), "User unable to click 'Edit Team' option from three dot menu");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("orgUsersSearch")), "User unable to see the search tab");

		//Step 8 : Click on the search tab and enter the search keyword
		//Expected : User should search the member name and it should listed below
		base.setData(LoginPageObj.Edt_LoginEmail("orgUsersSearch"), AddUpdateRemoveMemberTestData.TestCase_26_MemberName);
		Thread.sleep(5000);

		//Step 9 : Select an existing member from the left-side list
		//Expected : User should select an existing member from the left-side list
		base.selectCheckBox(LoginPageObj.Edt_LoginEmail(AddUpdateRemoveMemberTestData.TestCase_26_MemberCheckbox));
		Thread.sleep(3000);
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail(AddUpdateRemoveMemberTestData.TestCase_26_MemberCheckbox)).isSelected(),"The checkbox of the manager is not selected in the Followers page.");

		//Step 10 : Click the Add icon.
		//Expected : The selected member is added to the team, and their name appears in the team member list on the right side.
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("addPlayersToRight();"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers(AddUpdateRemoveMemberTestData.TestCase_26_MemberName,"teamCheckBox")), "User unable to view the added member in the right-side team member list");
	}

	//<summary>
	// Test Case Title : " Ensure that clicking on the Choose File icon allows the user to select a valid video file for upload." 
	// Automation ID : TestCase_03
	// </summary>
	public void TestCase_03_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersobj= new SearchGameTeamAndMembers_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1: Log in to SnipBack with valid credentials.
		//Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(7000);

		//Step 2: Select the desired organization from the dropdown list on the left side.
		//Expected: The selected organization’s created games should be displayed in the middle of the page.
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("AutomationOrg - 1")),"The option 'AutomationOrg - 1' is not selected from the team dropdown in the Games page");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("nav-game")),"The game of the organization is not visible under the Events tab in the Games page.");

		//Step 3: Select a Team from ORG
		//Expected: User should able to select Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_03_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(AddUpdateRemoveMemberTestData.TestCase_03_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateRemoveMemberTestData.TestCase_03_SearchTeam)),"User unable to unable to select Team");

		//Step 4  :Select the game and click the three dots on a cretaed game
		//Expected: User is able to Select the game and click the three dots on a cretaed game
		base.setData(LoginPageObj.Edt_LoginEmail("search"), AddUpdateRemoveMemberTestData.TestCase_03_SearchName);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);

		//Step 5: Click the three dots on a created game and select the option the Upload Game.
		//Expected: user able to click the three dots on game and select the option the Upload Game
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("btn-group dropleft right-menu-wrap"));
		Thread.sleep(3000);
		base.scrollToElement(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersobj.Ele_MemberName("Upload Video")),"The Upload Widget is not displaying");

		//Step 6: click on the Choose File icon, Verify that the file is mp4 or mov
		//Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir")+ "/Utils/Video/video_Check_Snip.mp4";
		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")),"Unable to click the Choose File");
		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
		String uploadedFileExtension = videoFilePath.substring(videoFilePath.lastIndexOf("."));
		asrt.assertTrue(allowedTypes.contains(uploadedFileExtension),"Invalid file type uploaded: " + uploadedFileExtension);

		// Step 7: Verify file name upload is same as uploaded
		// Expected: selected video file should appear in the file input field, ready for upload.
		// Extract file name from path
		String actualFileName = videoFilePath.substring(videoFilePath.lastIndexOf("/") + 1); 
		// Locate the file input element to check the uploaded file name
		String actualFilePath = base.GetValue(LoginPageObj.Edt_LoginEmail("game_video"));
		// Extract file name from the full file path returned by the input element
		String uploadedFileNameFromUI = actualFilePath.substring(actualFilePath.lastIndexOf("\\") + 1);       
		asrt.assertEquals(uploadedFileNameFromUI, actualFileName,
				"Uploaded file name does not match the file name from the file path. Found: " + uploadedFileNameFromUI);

	}

	//<summary>
	// Test Case Title : " Ensure that clicking the Upload button uploads the selected valid video file."
	// Automation ID : TestCase_04
	// </summary>
	public void TestCase_04_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersobj= new SearchGameTeamAndMembers_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1: Log in to SnipBack with valid credentials.
		//Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(7000);

		//Step 2: Select the desired organization from the dropdown list on the left side.
		//Expected: The selected organization’s created games should be displayed in the middle of the page.
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("AutomationOrg - 1")),"The option 'AutomationOrg - 1' is not selected from the team dropdown in the Games page");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("nav-game")),"The game of the organization is not visible under the Events tab in the Games page.");

		//Step 3: Select a Team from ORG
		//Expected: User should able to select Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_04_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(AddUpdateRemoveMemberTestData.TestCase_04_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateRemoveMemberTestData.TestCase_04_SearchTeam)),"User unable to unable to select Team");

		//Step 4  :Select the game and click the three dots on a cretaed game
		//Expected: User is able to Select the game and click the three dots on a cretaed game
		base.setData(LoginPageObj.Edt_LoginEmail("search"), AddUpdateRemoveMemberTestData.TestCase_04_SearchName);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);

		//Step 5: Click the three dots on a created game and select the option the Upload Game.
		//Expected: user able to click the three dots on game and select the option the Upload Game
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("btn-group dropleft right-menu-wrap"));
		Thread.sleep(3000);
		base.scrollToElement(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersobj.Ele_MemberName("Upload Video")),"The Upload Widget is not displaying");

		//Step 6: click on the Choose File icon, Verify that the file is mp4 or mov
		//Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir")+ "/Utils/Video/video_Check_Snip.mp4";
		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")),"Unable to click the Choose File");
		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
		String uploadedFileExtension = videoFilePath.substring(videoFilePath.lastIndexOf("."));
		asrt.assertTrue(allowedTypes.contains(uploadedFileExtension),"Invalid file type uploaded: " + uploadedFileExtension);

		// Step 7: Verify file name upload is same as uploaded
		// Expected: selected video file should appear in the file input field, ready for upload.
		// Extract file name from path
		String actualFileName = videoFilePath.substring(videoFilePath.lastIndexOf("/") + 1); 
		// Locate the file input element to check the uploaded file name
		String actualFilePath = base.GetValue(LoginPageObj.Edt_LoginEmail("game_video"));
		// Extract file name from the full file path returned by the input element
		String uploadedFileNameFromUI = actualFilePath.substring(actualFilePath.lastIndexOf("\\") + 1);       
		asrt.assertEquals(uploadedFileNameFromUI, actualFileName,
				"Uploaded file name does not match the file name from the file path. Found: " + uploadedFileNameFromUI);

		//Step 8: Click Upload and Shows Successfully Uploaded
		//Expected : User able to see the Successfully Uploaded Message
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.textToBe(RegistrationObj.Edt_SignUpPopupPassword("progress"), "100%"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Successfully uploaded.")),"File Not Uploaded");

	}


	// <summary>
	// Test Case Title :"Ensure that clicking on Create & Add New Member With Email allows adding a new member to the team using an email address."
	// Automation ID   : TestCase_28
	// </summary>		
	public void TestCase_28_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData=new AddUpdateRemoveMember_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_28_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_28_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_28_TeamName));
		Thread.sleep(3000);
		base.pressKey(clickOnStartDate,"KEYBOARD_ENTER" );
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_28_TeamName)), "Failed to select TEAM");
		Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_28_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_28_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(AddUpdateRemoveMemberTestData.TestCase_28_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		//Step 9 : "Switch to Add Multiple Users"
		//Expected : "User able to switch to Add Multiple Users"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch to Add Multiple User mode");

		// Step 10 : Fill the fields to be required except Role
		// Expected : User can able to enter all the remaining fields except use role
		base.setData(LoginPageObj.Edt_LoginEmail("email_1"), AddUpdateRemoveMemberTestData.TestCase_28_ValidEmailAddress);
		Thread.sleep(3000);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("email_1"));
		Assert.assertEquals(Email, AddUpdateRemoveMemberTestData.TestCase_28_ValidEmailAddress, "User unable to enter invalid Email in the add multiple user page");

		base.buttonClick(PoolObj.Ele_SelectPoolType("Player"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Player")), "User unable to select any role ");

		base.setData(LoginPageObj.Edt_LoginEmail("jersey_1"), AddUpdateRemoveMemberTestData.TestCase_28_JerseyNumber);
		String JersyNum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_1"));
		asrt.assertEquals(JersyNum, AddUpdateRemoveMemberTestData.TestCase_28_JerseyNumber,"Entered Number is not visible in Jersy Number field");
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_CloseBtn("add-user-card-header","New User 2","add-user-card-options card-remove-btn"));
		Thread.sleep(3000);

		// Step 11 : Click on ADD USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		//bug- AddUserToOrganization is disable
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("saveMutipleUsers"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to view 'User Added Successfully popup' while creating a member");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user is not automatically add as player in that team.");

		// Step 12 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(AddUpdateRemoveMemberTestData.TestCase_28_FullName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((AddUpdateRemoveMemberTestData.TestCase_28_FullName),"teamCheckBox")), "The user is not automatically added as player in that team");

		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((AddUpdateRemoveMemberTestData.TestCase_28_FullName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}

	// <summary>
	// Test Case Title :"Ensure that selecting a team member and clicking the Remove icon removes the member from the team."
	// Automation ID   : TestCase_27
	// </summary>
	public void TestCase_27_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_27_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_27_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_27_TeamName));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_27_TeamName)), "Failed to select TEAM");
		Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_27_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_27_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(AddUpdateRemoveMemberTestData.TestCase_27_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateRemoveMemberTestData.TestCase_27_TeamName)), "User unable to click 'Edit Team' option from three dot menu");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("orgUsersSearch")), "User unable to see the search tab");

		//Step 8 : Click on the search tab and enter the search keyword
		//Expected : User should search the member name and it should listed below
		base.setData(LoginPageObj.Edt_LoginEmail("orgUsersSearch"), AddUpdateRemoveMemberTestData.TestCase_27_MemberName);
		Thread.sleep(5000);

		//Step 9 : Select an existing member from the left-side list
		//Expected : User should select an existing member from the left-side list
		base.selectCheckBox(LoginPageObj.Edt_LoginEmail(AddUpdateRemoveMemberTestData.TestCase_27_MemberCheckbox));
		Thread.sleep(3000);
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail(AddUpdateRemoveMemberTestData.TestCase_27_MemberCheckbox)).isSelected(),"The checkbox of the manager is not selected in the Followers page.");

		//Step 10 : Click the Add icon.
		//Expected : The selected member is added to the team, and their name appears in the team member list on the right side.
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("addPlayersToRight();"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers(AddUpdateRemoveMemberTestData.TestCase_27_MemberName,"teamCheckBox")), "User unable to view the added member in the right-side team member list");

		//Step 11 : "Select a team member from right side and click the Remove icon"
		//Expected : The selected member is removed from the team, and their name no longer appears in the team member list on the right side.
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers(AddUpdateRemoveMemberTestData.TestCase_27_MemberName,"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading(AddUpdateRemoveMemberTestData.TestCase_27_MemberName)),"User unable to remove the member from the team");
	}

	///<summary>
	// Test Case Title:"To verify whether a user can add a new team member without an email address when clicking on Create and Add New Member Without Email."
	// Automation ID  : TestCase_29
	///</summary>			
	public void TestCase_29_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData=new AddUpdateRemoveMember_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_29_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_29_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_29_TeamName));
		Thread.sleep(3000);
		base.pressKey(clickOnStartDate,"KEYBOARD_ENTER" );
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_29_TeamName)), "Failed to select TEAM");
		Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_29_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_29_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(AddUpdateRemoveMemberTestData.TestCase_29_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email")), "User is not able to view the option 'Create & Add new member without Email'");

		// Step 8 : Click Create&Add New Member without Email
		// Expected : The user should navigate to Add New User Without Email pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("Add New User Without Email")), "User unable to view the 'Add New User Without Email' popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_woemail_1")), "User unable to view the email field in the Games Page");

		//Step 9 : Fill the fields except Email 
		//Expected : The user can able to add new member with a default mail id (For Eg . user123456@mysnipback.com)
		base.setData(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"), AddUpdateRemoveMemberTestData.TestCase_29_FullName);
		String ActualName=base.GetValue(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"));
		asrt.assertEquals(ActualName,AddUpdateRemoveMemberTestData.TestCase_29_FullName);

		base.setData(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"), AddUpdateRemoveMemberTestData.TestCase_29_JerseyNumber);
		String ActualJnum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"));
		asrt.assertEquals(ActualJnum,AddUpdateRemoveMemberTestData.TestCase_29_JerseyNumber);

		// Step 10 : Click on ADD USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("saveMutipleUsersWOEmail"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to to add new member with a default mail id (For Eg . user123456@mysnipback.com)");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user is not automatically add as player in that team.");

		// Step 11 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(AddUpdateRemoveMemberTestData.TestCase_29_FullName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((AddUpdateRemoveMemberTestData.TestCase_29_FullName),"teamCheckBox")), "The user is not automatically added as player in that team");

		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((AddUpdateRemoveMemberTestData.TestCase_29_FullName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}


	// <summary>
	// Test Case Title :"Ensure all current team members are accurately displayed on the right side of the edit screen."
	// Automation ID   : TestCase_30
	// </summary>		
	public void TestCase_30_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestData.TestCase_30_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_30_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_30_TeamName));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_30_TeamName)), "Failed to select TEAM");
		Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_30_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(AddUpdateRemoveMemberTestData.TestCase_30_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(AddUpdateRemoveMemberTestData.TestCase_30_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateRemoveMemberTestData.TestCase_30_TeamName)), "User unable to click 'Edit Team' option from three dot menu");

		//Step 8 : Review the list on the right side to confirm it only includes current team members.
		//Expected : "All Current Team Members should displayed on the right side of the screen"
		asrt.assertTrue(base.isExists(addupdateremoveMemberObj.Ele_CurrentTeamMembers("CURRENT TEAM MEMBERS")), "User not able to see Current Team Members");
		asrt.assertTrue(base.isExists(addupdateremoveMemberObj.Chk_TeamMembers("checked-right")), "Current Team Members are not displayed on the right side of the edit screen");
	}	


	// <summary>
	// Test Case Title : "To verify whether the user can edit the details of a member successfully."
	// Automation ID : TestCase_35
	// </summary>
	public void TestCase_35_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException {

		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata=new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData=new AddUpdateRemoveMember_TestData();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj= new SearchGameTeamAndMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1: Go to Games/Members page
		//Expected: User should be navigated to Games page.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");

		//Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		//Expected: The team should be selected from dropdown
		base.excuteJsClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(AddUpdateRemoveMemberTestData.TestCase_12_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(AddUpdateRemoveMemberTestData.TestCase_12_Org)),"The organization is not selected");

		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_36_Team);

		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_36_Team));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_36_Team)), "Failed to select TEAM");

		//Step 3: Click on Home page Memeber	
		//Expected: List of Members page is displayed
		base.scrollToElementtoCenter(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("MEMBERS")),"Unable to select Member icon from the home page");
		base.buttonClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_ListTxt("nav-members")),"Unable to view List of Members");

		//Step 4: Select a Member 
		//Expected: Member User Info page displayed and Edit fields Enabled
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_SelectTeamMember(AddUpdateRemoveMemberTestData.TestCase_35_MemberRole)); 
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("User INFO")),"Unable to view Member User Info");
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail("ed_jersey_number")).isEnabled(),"User unable to modify the member Jursey Details"); 
		asrt.assertTrue(driver.findElement(AddUpdateRemoveMemberObj.Sel_Roll("ed_user_role")).isEnabled(),"User unable to modify the member Roll Details");

		//Step 5: Edit the Member FirstName, LastName, JerseyNumber, Roll
		//Expected: User is able to Edit the Name, Role, Jersey
		base.setData(LoginPageObj.Edt_LoginEmail("ed_first_name"),AddUpdateRemoveMember_TestData.TestCase_35_AddUpdateRemoveMemberTestFirstName);
		base.setData(LoginPageObj.Edt_LoginEmail("ed_last_name"),AddUpdateRemoveMember_TestData.TestCase_35_AddUpdateRemoveMemberTestLastName);
		base.setData(LoginPageObj.Edt_LoginEmail("ed_jersey_number"),AddUpdateRemoveMember_TestData.TestCase_35_AddUpdateRemoveMemberTestJesrryNumber);
		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("ed_user_role"),"Player / User");

		//Step 6: Click on Update button and successful Message 
		//Expected: User is able to see successful Message after submission
		base.scrollToElement(AddUpdateRemoveMemberObj.Btn_Update("btn btn-dark w-100 fs-6 update_team_user"));
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_Update("btn btn-dark w-100 fs-6 update_team_user"));
		asrt.assertEquals(AddUpdateRemoveMemberTestData.TestCase_35_TestExpected,base.GetText(LoginPageObj.Ele_ErrorMessage("swal-text")),"Unable to Update the Member Details");

	}

	// <summary>
	// Test Case Title : "To verify whether the user updated details are reflected in the member list after editing."
	// Automation ID : TestCase_36
	// </summary>
	public void TestCase_36_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException {

		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata=new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData=new AddUpdateRemoveMember_TestData();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj= new SearchGameTeamAndMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1: Go to Games/Members page
		//Expected: User should be navigated to Games page.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");

		//Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		//Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(AddUpdateRemoveMemberTestData.TestCase_12_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(AddUpdateRemoveMemberTestData.TestCase_12_Org)),"The organization is not selected");

		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_36_Team);

		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_36_Team));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_36_Team)), "Failed to select TEAM");


		//base.scrollToElementtoCenter(LoginPageObj.Edt_Alert1("SemTest"));
		//base.buttonClick(LoginPageObj.Edt_Alert1("SemTest"));
		// asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("SemTest")), "User unable to select TEAM");

		//Step 3: Click on Home page Memeber	
		//Expected: List of Members page is displayed
		base.scrollToElementtoCenter(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("MEMBERS")),"Unable to select Member icon from the home page");
		base.buttonClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_ListTxt("nav-members")),"Unable to view List of Members");

		//Step 4: Select a Member 
		//Expected: Member User Info page displayed and Edit fields Enabled
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_SelectTeamMember(AddUpdateRemoveMemberTestData.TestCase_36_MemberRole)); 
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("User INFO")),"Unable to view Member User Info");
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail("ed_jersey_number")).isEnabled(),"User unable to modify the member Jursey Details"); 
		asrt.assertTrue(driver.findElement(AddUpdateRemoveMemberObj.Sel_Roll("ed_user_role")).isEnabled(),"User unable to modify the member Roll Details");

		//Step 5: Edit the Member FirstName, LastName, JerseyNumber, Roll
		//Expected: User is able to Edit the Name, Role, Jersey
		base.setData(LoginPageObj.Edt_LoginEmail("ed_first_name"),AddUpdateRemoveMember_TestData.TestCase_36_AddUpdateRemoveMemberTestFirstName);
		base.setData(LoginPageObj.Edt_LoginEmail("ed_last_name"),AddUpdateRemoveMember_TestData.TestCase_36_AddUpdateRemoveMemberTestLastName);
		base.setData(LoginPageObj.Edt_LoginEmail("ed_jersey_number"),AddUpdateRemoveMember_TestData.TestCase_36_AddUpdateRemoveMemberTestJesrryNumber);
		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("ed_user_role"),"Player / User");

		//Step 6: Get The Updated Details Entered in Fields
		//Expected: All Updated Details are fetch
		String ExpectedFullName= base.GetValue(LoginPageObj.Edt_LoginEmail("ed_first_name"))+" "+base.GetValue(LoginPageObj.Edt_LoginEmail("ed_last_name"));	
		String ExpectedJerseyNumber= base.GetValue(LoginPageObj.Edt_LoginEmail("ed_jersey_number"));
		String ExpectedRole= base.GetText(AddUpdateRemoveMemberObj.Sel_Selected("ed_user_role"));

		//Step 6: Click on Update button and successful Message 
		//Expected: User is able to see successful Message after submission
		base.scrollToElement(AddUpdateRemoveMemberObj.Btn_Update("btn btn-dark w-100 fs-6 update_team_user"));
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_Update("btn btn-dark w-100 fs-6 update_team_user"));
		asrt.assertEquals(AddUpdateRemoveMemberTestData.TestCase_36_TestExpected,base.GetText(LoginPageObj.Ele_ErrorMessage("swal-text")),"Unable to Update the Member Details");

		//Step 7: Click Ok and verify the Updated fields were updates
		//Expected: Updated details present in List of Members
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		//Step 8: The updated details are reflected in the member list after editing/Updating
		//Expected: User able to view the updated details are displayed correctly on the member profile.
		Thread.sleep(3000);
		base.scrollToElement(SearchGameTeamAndMembersObj.Ele_MemberName(ExpectedFullName));
		//asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName(ExpectedFullName)),"The Uploaded Member Name not Updated");
		base.scrollToElement(AddUpdateRemoveMemberObj.Ele_GetJerseyNumber(ExpectedJerseyNumber));
		//asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_GetJerseyNumber(ExpectedJerseyNumber)),"The Uploaded Member Jersey Number not Updated");

	}

	// <summary>
	// Test Case Title : "Verify whether the user can access the member edit page by selecting a member icon from the home page" 
	// Automation ID : TestCase_34
	// </summary>
	public void TestCase_34_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException 
	{ 
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CommonData Commondata=new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj= new SearchGameTeamAndMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();

		//Step 1: Go to Games/Members page
		//Expected: User should be navigated to Games page.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");

		//Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		//Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(AddUpdateRemoveMemberTestData.TestCase_12_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(AddUpdateRemoveMemberTestData.TestCase_12_Org)),"The organization is not selected");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_36_Team);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_36_Team));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestData.TestCase_36_Team)), "Failed to select TEAM");

		//Step 3: Click on Home page Memeber	
		//Expected: The member edit page is displayed
		base.scrollToElementtoCenter(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("MEMBERS")),"Unable to select Member icon from the home page");
		base.buttonClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_ListTxt("nav-members")),"Unable to view List of Members");

		//Step 4: Select a Member 
		//Expected: allowing the user to modify member details
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_SelectTeamMember("Player"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("User INFO")),"Unable to view Member User Info");
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail("ed_jersey_number")).isEnabled(),"User unable to modify the member Jursey Details"); 
		asrt.assertTrue(driver.findElement(AddUpdateRemoveMemberObj.Sel_Roll("ed_user_role")).isEnabled(),"User unable to modify the member Roll Details");

	}

	//<summary>
	// Test Case Title : "Ensure that system rejects invalid file formats (e.g., .txt or .pdf) for video upload."
	// Automation ID : TestCase_05
	// </summary>
	public void TestCase_05_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersobj= new SearchGameTeamAndMembers_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestdata=new AddUpdateRemoveMember_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestData = new AddUpdateRemoveMember_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1: Log in to SnipBack with valid credentials.
		//Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(7000);

		//Step 2: Select the desired organization from the dropdown list on the left side.
		//Expected: The selected organization’s created games should be displayed in the middle of the page.
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("AutomationOrg - 1")),"The option 'AutomationOrg - 1' is not selected from the team dropdown in the Games page");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("nav-game")),"The game of the organization is not visible under the Events tab in the Games page.");

		//Step 3: Select a Team from ORG
		//Expected: User should able to select Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestData.TestCase_05_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(AddUpdateRemoveMemberTestData.TestCase_05_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateRemoveMemberTestData.TestCase_05_SearchTeam)),"User unable to unable to select Team");

		//Step 4  :Select the game and click the three dots on a cretaed game
		//Expected: User is able to Select the game and click the three dots on a cretaed game
		base.setData(LoginPageObj.Edt_LoginEmail("search"), AddUpdateRemoveMemberTestData.TestCase_05_SearchName);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);

		//Step 5: Click the three dots on a created game and select the option the Upload Game.
		//Expected: user able to click the three dots on game and select the option the Upload Game
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("btn-group dropleft right-menu-wrap"));
		Thread.sleep(3000);
		base.scrollToElement(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersobj.Ele_MemberName("Upload Video")),"The Upload Widget is not displaying");

		//Step 5: click on the Choose File icon and take Invalid File, Verify that the file is mp4 or mov
		//Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir")+ "/Utils/InvalidTxtFile.txt";
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")),"Unable to click the Choose File");
		base.setData(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath);

		//Step 6: Click Upload and Shows Error Message
		//Expected : User able to see the Error Message
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
		asrt.assertEquals(AddUpdateRemoveMemberTestdata.TestCase_05_TestExpected,base.GetText(LoginPageObj.Ele_ErrorMessage("swal-text")),"upload a valid file");	
	}

	//<summary>
	// Test Case Title : " Ensure that the uploaded video can be played by clicking on the game name icon."
	// Automation ID : TestCase_06
	// </summary>
	public void TestCase_06_UploadVideoMoveToPoolShareGameAddUpdateRemoveMember() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    AddUpdateRemoveMember_TestData AddUpdateRemoveMemberTestdata=new AddUpdateRemoveMember_TestData();
 	    CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
 	    ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
 	    AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
 	    Registration_Obj RegistrationObj = new Registration_Obj();
 	    
	    //Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddUpdateRemoveMemberTestdata.TestCase_06_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddUpdateRemoveMemberTestdata.TestCase_06_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestdata.TestCase_06_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddUpdateRemoveMemberTestdata.TestCase_06_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Create a new event
        //Expected : User should Successfully create a new EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), AddUpdateRemoveMemberTestdata.TestCase_06_eventOrGameName);
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "CREATE"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		Thread.sleep(8000);
		base.excuteJsClick(MoveGameObj.Btn_3Dots(AddUpdateRemoveMemberTestdata.TestCase_06_eventOrGameName));
		base.excuteJsClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video / Clips"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--uploadVideo btn btn-primary"));
        String videoFilePath = System.getProperty("user.dir")+ "/Utils/Video/video_Check_Snip.mp4";
        List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
        base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
        base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
        WebDriverWait wait=new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.textToBe(RegistrationObj.Edt_SignUpPopupPassword("progress"), "100%"));
	    Thread.sleep(10000);
	    base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	    Thread.sleep(6000);
	    
	    //Step 7 : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : The uploaded video should play smoothly without errors in player page.
	    base.setZoom(driver, 85);
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddUpdateRemoveMemberTestdata.TestCase_06_eventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        Thread.sleep(2000);
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddUpdateRemoveMemberTestdata.TestCase_06_eventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
        Thread.sleep(5000);
        
		//For deleting the created event
        base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_BookMark("del-session-wrap"));
		Thread.sleep(5000);	
        base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
        Thread.sleep(2000);
        base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
        Thread.sleep(13000);

	}

}

