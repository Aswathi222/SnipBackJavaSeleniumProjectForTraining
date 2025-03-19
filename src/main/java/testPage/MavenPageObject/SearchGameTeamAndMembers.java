package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import TestData.CommonData;
import TestData.SearchGameandTeamMembers_TestData;
import TestData.SnipBackLogin_TestData;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.ViewListUpdateDownloadShareDeleteLibrary_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;

public class SearchGameTeamAndMembers extends BasePge {

	BasePge base;
	Assert asrt;

	public SearchGameTeamAndMembers(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify what happens when the user search games by entering numbers as keyword in the search field."
	// Automation ID   : SH_03 
	// </summary>
	public void SH_03_SearchGameTeamAndMembers() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		Pool_Obj Pool_obj =new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be able to navigate to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User is not able to navigate to Film Page");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");

		//Step 5   :"Select GameName"
		//Expected :"User should be navigated to GameList"
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the GameList");

		//Step 6   :"Option to Search Games"
		//Expected :"Search Option with search icon should displayed in the Games Page
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_Name("Search")),"The Search Option isn't visible to the user in the Games page");

		//Step 7   :"Enter a number in the Search field and verify game list"
		//Expected :"User can see list of games with the given number."
		base.setData(RegistrationObj.Edt_Name("Search"), "1");
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Reels("table table-striped film-list")), "User is not able to see list of games with the given first letter.");
	}


	// <summary>
	// Test Case Title :"To verify what happens when the user searches games by entering its first letter as keyword in the search field."
	// Automation ID   : SH_02 
	// </summary>
	public void SH_02_SearchGameTeamAndMembers() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		Pool_Obj Pool_obj =new Pool_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");

		//Step 5   :"Select GameName"
		//Expected :"User should be navigated to GameList"
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the GameList");

		//Step 6   :"Option to Search Games"
		//Expected :"Search Option with search icon should displayed in the Games Page
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_Name("Search")),"The Search Option isn't visible to the user in the Games page");

		//Step 7   :"Enter the first letter in the Search field and verify game list"
		//Expected :"User can see list of games with the given first letter."
		base.setData(RegistrationObj.Edt_Name("Search"), "B");
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Reels("table table-striped film-list")), "User is not able to see list of games with the given first letter.");
	}

	// <summary>
	// Test Case Title :"To verify whether there is a option to search games in Game Listing page."
	// Automation ID   : SH_01 
	// </summary>
	public void SH_01_SearchGameTeamAndMembers() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		Pool_Obj Pool_obj =new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);


		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");

		//Step 5   :"Select GameName"
		//Expected :"User should be navigated to GameList"
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to click GameList");

		//Step 6   :"Option to Search Games"
		//Expected :"There should be a option to search games in Game Listing page."
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_Name("Search")),"User is not able to view the option to search games in Game Listing page.");
	}


	// <summary>
	// Test Case Title :"To verify what happens when the user searches games by entering special characters as keyword in the search field."
	// Automation ID   : SH_04 
	// </summary>
	public void SH_04_SearchGameTeamAndMembers() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		

		//Step 1  :"Go to Film page"
		//Expected:"User should be navigated to Film Page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 2   :"Select Games section"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User should not be navigated to Games");

		//Step 3  :"Select GameName"
		//Expected :"User should be navigated to GameList"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the GameList");

		//Step 4   :"Option to Search Games"
		//Expected :"Search Option with search icon should displayed in the Games Page
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_Name("Search")),"The Search Option isn't visible to the user in the Games page");

		//Step 5:"Type a special character and click Enter 
		//Expected:User can see list of games with the given special character.
		base.setData(RegistrationObj.Edt_Name("Search"), "@");
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Reels("table table-striped film-list")), "User is not able to see list of games with the given first letter.");
	}


	// <summary>
	// Test Case Title :"To verify what happens when the user search members by entering numbers as keyword in the search field."
	// Automation ID   : SH_13
	// </summary>
	public void SH_13_SearchGameTeamAndMembers() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		SearchGameandTeamMembers_TestData  SearchGameandTeamMembersTestData = new SearchGameandTeamMembers_TestData();
		Pool_Obj poolObj = new Pool_Obj();


		//Step 1  :"Go to Film page"
		//Expected:"User should be navigated to Film Page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 2   :"Select Games section"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User should not be navigated to Games");

		//Step 3  :"Select GameName"
		//Expected :"User should be navigated to GameList"
		base.selectorByVisibleText(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User should not be able to navigate to GameList");

		//Step 4   :"Select Members section"
		//Expected :"User should be navigated to Members section"
		base.buttonClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("MEMBERS")),"User should not be navigated to Members");

		//Step 5   :"Click on Search input field and enter the number as Keyword in the search field"
		//Expected :"User should be click on Search input field and enter the number as Keyword in the search field"
		base.buttonClick(LoginPageObj.Edt_LoginEmail("teamGroupMembers"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamGroupMembers"),SearchGameandTeamMembersTestData.SH13_SearchGamesMemberNumber);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamGroupMembers")), "User should not be click on Search input field and cannot be enter the number as Keyword in the search field");

		//Step 6   :"Verify the members are listed once enter the number as keyword in search text field "
		//Expected :"User can see list of members with the given number in their mail id."
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("srch_result")), "User should not be be able to see list of members with the given number in their mail id");


	}

	// <summary>
	// Test Case Title :"To verify what happens when the user searches members by entering special characters as keyword in the search field."
	// Automation ID   : SH_14
	// </summary>
	public void SH_14_SearchGameTeamAndMembers() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		SearchGameandTeamMembers_TestData  SearchGameandTeamMembersTestData = new SearchGameandTeamMembers_TestData();
		Pool_Obj poolObj = new Pool_Obj();


		//Step 1  :"Go to Film page"
		//Expected:"User should be navigated to Film Page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 2   :"Select Games section"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User should not be navigated to Games");

		//Step 3  :"Select GameName"
		//Expected :"User should be navigated to GameList"
		base.selectorByVisibleText(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(poolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User should not be able to navigate to GameList");

		//Step 4   :"Select Members section"
		//Expected :"User should be navigated to Members section"
		base.buttonClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("MEMBERS")),"User should not be navigated to Members");

		//Step 5   :"Click on Search input field and enter the number as Keyword in the search field"
		//Expected :"User should be click on Search input field and enter the Special Character as Keyword in the search field"
		base.buttonClick(LoginPageObj.Edt_LoginEmail("teamGroupMembers"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamGroupMembers"),SearchGameandTeamMembersTestData.SH14_SearchGamesMemberCharacter);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamGroupMembers")), "User should not be click on Search input field and cannot be enter the Special character as Keyword in the search field");

		//Step 6   :"Verify the members are listed once enter the Special Character as keyword in search text field "
		//Expected :"User can see list of games with the given special character in their mail id."
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("srch_result")), "User should not be be able to see list of games with the given special character in their mail id");


	}

	// <summary>
	// Test Case Title :"To verify what happens when user searches for a game which is not in the list."
	// Automation ID   : SH_05
	// </summary>
	public void SH_05_SearchGameTeamAndMembers() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		SearchGameandTeamMembers_TestData  SearchGameandTeamMembersTestData = new SearchGameandTeamMembers_TestData();
		Pool_Obj PoolObj = new Pool_Obj();

		//Step 1  :"Go to Film page"
		//Expected:"User should be navigated to Film Page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 2   :"Select Games section"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User should not be navigated to Games");

		//Step 3  :"Select GameName"
		//Expected :"User should be navigated to GameList"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User should not be able to navigate to GameList");

		//Step 4   :"Click Search bar"
		//Expected :"Search Option with search icon should displayed in the Games Page
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_Name("Search")),"Search Option with search icon should not be displayed in the Games Page");

		//Step 5   :Enter a random game name in the search bar 
		//Expected:The user should be able to enter the name in the search bar
		base.setData(RegistrationObj.Edt_Name("Search"),SearchGameandTeamMembersTestData.SH05_SearchGamesGameName);
		String ActualGameName = base.GetValue(RegistrationObj.Edt_Name("Search"));
		asrt.assertEquals(ActualGameName,SearchGameandTeamMembersTestData.SH05_SearchGamesGameName,"The user should not be able to enter the name in the search bar");

		//Step 6  :Click Enter
		//Expected:User should receive result as "No data Found"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("No Data Found")),"User should not receive result as \"No data Found\"");
	}

	// <summary>
	// Test Case Title :"To verify whether there is a option to search members in Members Listing page."
	// Automation ID   :SH_11 
	// </summary>

	public void SH_11_SearchGameTeamAndMembers() throws InterruptedException
	{
		Pool_Obj PoolObj = new Pool_Obj();
		Login login = new Login(driver);
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to the Games page under film module.");


		//Step 5  :"Click on Members Button"
		//Expected:"User should be able to click on Members Button"

		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		base.buttonClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("nav-members")),"User is not able to view the list of members area.");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamGroupMembers")),"User is not able to view the search field.");

		//Step 6   :"Click Search bar"
		//Expected :"There should be a option to search members in Members Listing page.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamGroupMembers")),"User is not able to view the option to search members in Members Listing page.");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user searches for a member who is not in the list."
	// Automation ID   : SH_15
	// </summary>
	public void SH_15_SearchGameTeamAndMembers() throws InterruptedException
	{
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		SearchGameandTeamMembers_TestData  SearchGameandTeamMembersTestData = new SearchGameandTeamMembers_TestData();

		//Step 1: Go to Games/Members page
		//Expected: User should be navigated to Games page.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");

		//Step 2:Switch to any team from the team drop-down menu after selecting an Organization
		//Expected: The team should be selected from drop-down
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType("AutomationOrg - 1"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("AutomationOrg - 1")),"The option 'AutomationOrg - 1' is not selected");


		//Step 3: Select Games section
		//Expected: The Games page should be loaded.
		base.buttonClick(LoginPageObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"The Games page is not loaded.");
		base.buttonClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("MEMBERS")),"The Members page is not loaded.");
		Thread.sleep(7000);

		//Step 4: Click search bar and enter invalid member name
		//Expected: There will not list any members if the user enters a member name who doesn't exists.
		base.setData(LoginPageObj.Edt_LoginEmail("teamGroupMembers"),SearchGameandTeamMembersTestData.SH15_SearchGameMemberName);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("col-sm-12 players_totallist")),"Invalid members are displayed, if the user enters a member name who doesn't exists");

	}

	// <summary>
	// Test Case Title :"To verify what happens when the user searches members by entering there first letter as the keyword in the search field."
	// Automation ID   :SH_12 
	// </summary>

	public void SH_12_SearchGameTeamAndMembers() throws InterruptedException
	{
		Pool_Obj PoolObj = new Pool_Obj();
		Login login = new Login(driver);
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		SearchGameandTeamMembers_TestData SearchGameandTeamMembersTestData = new SearchGameandTeamMembers_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);


		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to navigate to the Games page under film module.");

		//Step 5  :"Click on Members Button"
		//Expected:"User should be able to click on Members Button"

		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		base.buttonClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("nav-members")),"User is not able to view the list of members area.");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamGroupMembers")),"User is not able to view the search field.");

		//Step 6   :"Click Search bar"
		//Expected :"Search Option with search icon displayed in the Members Page
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamGroupMembers")),"Search Option with search icon should not be displayed in the Members Page");

		//Step 7   :"Enter the first letter in the Search field and verify Member list"
		//Expected :"User can see list of members with the given first letter."
		base.setData(LoginPageObj.Edt_LoginEmail("teamGroupMembers"),SearchGameandTeamMembersTestData.SH12_SearchGameMemberName);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamGroupMembers")), "User is not able to see list of members with the given first letter.");

	}

	// Test Case Title :"To verify whether there is a option to search teams in the Games/Members Listing page."
	// Automation ID   : SH_06
	// </summary>
	public void SH_06_SearchGameTeamAndMembers() throws InterruptedException
	{
		Pool_Obj PoolObj = new Pool_Obj();
		Login login = new Login(driver);
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("navbar-brand")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User is not able to navigate to the Games section under film module.");

		//Step 5 : Click on Members Button
		//Expected : There should be a option to search teams in the GamesMembers Listing page..
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));
		base.buttonClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("nav-members")),"User is not able to view the list of members area.");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamGroupMembers")),"User is not able to view the option to search teams in the GamesMembers Listing page.");
	}
	// <summary>
	// Test Case Title :"To verify what happens when the user searches teams by entering its first letter as keyword in the search field."
	// Automation ID   : SH_07
	// </summary>

	public void SH_07_SearchGameTeamAndMembers() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SearchGameandTeamMembers_TestData searchgameteamandmemberstestdada = new SearchGameandTeamMembers_TestData();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("navbar-brand")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User is not able to navigate to the Games section under film module.");

		//Step 4 : Click on Members Button
		//Expected : User should be able to click on Members Button.
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));

		//Step 5 :  Click search bar above the teams and enter the first letter of team name
		//Expected : User can see list of teams with the given first letter.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),searchgameteamandmemberstestdada.SH07_TeamSearch);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Backup Team")),"User is not able to see list of teams with the given first letter.");
	}

	// <summary>
	// Test Case Title :"To verify what happens when the user search teams by entering numbers as keyword in the search field."
	// Automation ID   : SH_08
	// </summary>

	public void SH_08_SearchGameTeamAndMembers() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SearchGameandTeamMembers_TestData searchgameteamandmemberstestdada = new SearchGameandTeamMembers_TestData();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("navbar-brand")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User is not able to navigate to the Games section under film module.");

		//Step 4 : Click on Members Button
		//Expected : User should be able to click on Members Button.
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));

		//Step 5 :  Click search bar above the teams and enter a number 
		//Expected : User can see list of teams with the given number.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),searchgameteamandmemberstestdada.SH13_SearchGamesMemberNumber);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Team 1")),"User is not able to see list of teams with the given number.");

	}

	// <summary>
	// Test Case Title :"To verify what happens when the user searches teams by entering special characters as keyword in the search field."
	// Automation ID   : SH_09
	// </summary>

	public void SH_09_SearchGameTeamAndMembers() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SearchGameandTeamMembers_TestData searchgameteamandmemberstestdada = new SearchGameandTeamMembers_TestData();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("navbar-brand")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User is not able to navigate to the Games section under film module.");
		
		//Step 4 : Click on Members Button
		//Expected : User should be able to click on Members Button.
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));

		//Step 5 :  Click search bar above the teams and enter a special character  
		//Expected : User can see list of teams with the given special character.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),searchgameteamandmemberstestdada.SH14_SearchGamesMemberCharacter);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("@Work"))," User is not able to see list of teams with the given special character");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user searches for a team which is not in the list."
	// Automation ID   : SH_10
	// </summary>

	public void SH_10_SearchGameTeamAndMembers() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SearchGameandTeamMembers_TestData searchgameteamandmemberstestdada = new SearchGameandTeamMembers_TestData();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("navbar-brand")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User is not able to navigate to the Games section under film module.");

		//Step 4 : Click on Members Button
		//Expected : User should be able to click on Members Button.
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName("AutomationOrg - 1"));

		//Step 5 :  Click search bar above the teams and enter a team name  
		//Expected : There will not list any teams if the user enters a team name which doesn't exists. 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),searchgameteamandmemberstestdada.SH10_InvalidTeamName);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("search-result-wrap mt-3"))," User is able to view the team name, if the user enters a team name which doesn't exists");

	}
}

