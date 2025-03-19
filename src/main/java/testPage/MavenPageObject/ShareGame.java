package testPage.MavenPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestData.CommonData;
import TestData.ShareGame_TestData;
import objectRepository.AddFollower_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ShareGame_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import utilPack.BasePge;

public class ShareGame extends BasePge {

	BasePge base;
	Assert asrt; 

	public ShareGame(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}


	// <summary>
	// Test Case Title :"To verify the functionality of a "Share" option in player page"
	// Automation ID   : SG_1 
	// </summary>
	public void SG_1_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_1_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_1_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_1_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_1_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_1_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_1_GameName));
		base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_1_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_1_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.buttonClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  :View the Share icon in the 3 dots menu
		//Expected: User should be able to view the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
	}		

	// <summary>
	// Test Case Title :"Verify that the dialog box closes when the user clicks the close icon(an "X" button)"
	// Automation ID   : SG_2
	// </summary>
	public void SG_2_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_2_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_2_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_2_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_2_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_2_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_2_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_2_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_2_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  :View the Share icon in the 3 dots menu
		//Expected: User should be able to view the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");

		//Step 11 : To verify that when a user click "Share" button  a 'Share Options' dialog box appears
		//Expected : Clicking the "Share" button, the "Share Options" dialog box should appear, displaying sharing options(Share internally, share externally)
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addupdateremoveMemberObj.Ele_SearchGame("gameShareModal")), "User not able to click Share Option and view the ShareGame popup in Player page");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users")), "User not able to click Share Option and view the Share internally option in Player page");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("external-share")), "User not able to click Share Option and view the Share externally option in Player page");

		//Step 12 : To verify that the dialog box closes when the user clicks the close icon(an "X" button)
		//Expected : The dialog box should close immediately after the close icon is clicked, and it should no longer be visible on the screen
		base.excuteJsClick(ShareGameObj.Btn_Close("gameShareModal","close"));
		Thread.sleep(5000);
	}	

	// <summary>
	// Test Case Title :"Verify that when a user click "Share" button  a 'Share Options' dialog box appears"
	// Automation ID   : SG_3
	// </summary>
	public void SG_3_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_3_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_3_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_3_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_3_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_3_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_3_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_3_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_3_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  :View the Share icon in the 3 dots menu
		//Expected: User should be able to view the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");

		//Step 11 : To verify that when a user click "Share" button  a 'Share Options' dialog box appears
		//Expected : Clicking the "Share" button, the "Share Options" dialog box should appear, displaying sharing options(Share internally, share externally)
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addupdateremoveMemberObj.Ele_SearchGame("gameShareModal")), "User not able to click Share Option and view the ShareGame popup in Player page");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users")), "User not able to click Share Option and view the Share internally option in Player page");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("external-share")), "User not able to click Share Option and view the Share externally option in Player page");
	}

	// <summary>
	// Test Case Title :"Verify that Player's Name and Team Name Display on Clicking Share Internally Option"
	// Automation ID   :SG_4
	// </summary>
	public void SG_4_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_4_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_4_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_4_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_4_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_4_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_4_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_4_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_4_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Internally option
		//Expected : The player’s name and team name must appear in the interface whenclicking the "Share Internally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users")), "User not able to view the Share internally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersCreate("playersbtn","PLAYERS")), "User not able to view the Players option");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersCreate("teamsbtn","TEAMS")), "User not able to view the Teams option");
	}

	// <summary>
	// Test Case Title :"Verifying that user clicks the "Players" tab, all players' names should be displayed"
	// Automation ID   :SG_5
	// </summary>
	public void SG_5_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_5_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_5_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_5_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_5_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_5_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_5_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_5_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_5_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Internally option
		//Expected : The player’s name and team name must appear in the interface when clicking the "Share Internally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users")), "User not able to view the Share internally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users"));
		Thread.sleep(5000);

		//Step 12 :" Click Players Tab"
		//Expected:" The user should be able to see a list of player names after clicking the "Players" tab"
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersCreate("playersbtn","PLAYERS")), "User not able to view the Players option");
		base.excuteJsClick(AddFollowerObj.Btn_FollowersCreate("playersbtn","PLAYERS"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("(a12.snip@maildrop.cc)")), "User not able to view the Players name list");
	}

	// <summary>
	// Test Case Title :"Verifying that user clicks the "Team" tab, all team' names should be displayed"
	// Automation ID   :SG_6
	// </summary>
	public void SG_6_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_6_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_6_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_6_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_6_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_6_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_6_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_6_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_6_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Internally option
		//Expected : The player’s name and team name must appear in the interface when clicking the "Share Internally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users")), "User not able to view the Share internally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users"));
		Thread.sleep(5000);

		//Step 12 :" Click Teams Tab"
		//Expected:" The user should be able to see a list of Team names after clicking the "Teams" tab"
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersCreate("teamsbtn","TEAMS")), "User not able to view the Teams option");
		base.excuteJsClick(AddFollowerObj.Btn_FollowersCreate("teamsbtn","TEAMS"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(ShareGameObj.Ele_PlayerTeamName("mystics")), "User not able to view the Team names list");
	}

	// <summary>
	// Test Case Title :"Verify that the search returns correct global results when a valid term is searched Globally"
	// Automation ID   :SG_7
	// </summary>
	public void SG_7_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_7_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_7_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_7_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_7_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_7_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_7_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_7_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_7_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Internally option
		//Expected : The player’s name and team name must appear in the interface when clicking the "Share Internally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users")), "User not able to view the Share internally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users"));
		Thread.sleep(5000);

		//Step 7 :" Enter valid Search Words"
		//Expected:" The user should be able to Enter valid Search Words"
		base.setData(LoginPageObj.Edt_LoginEmail("search-key"),SGTestData.SG_7_PlayerEmail);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("search-key"));
		asrt.assertEquals(ActualName,SGTestData.SG_7_PlayerEmail,"User should not able to enter the name in Search Words");
		Thread.sleep(3000);

		//Step 8:" Click Search Globally"
		//Expected:"The search results should return relevant content related to the search term"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("globalsearch"));
		Thread.sleep(8000);
		String ExpectedName = base.GetText(ShareGameObj.Ele_Search("snip-org-name", ("("+SGTestData.SG_7_PlayerEmail+")")));
		asrt.assertTrue(ExpectedName.contains(SGTestData.SG_7_PlayerEmail),"Not return the relevant content related to the search term");
	}

	// <summary>
	// Test Case Title :"Verify that the system returns a message when an invalid or empty search term is entered."
	// Automation ID   :SG_8
	// </summary>
	public void SG_8_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_8_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_8_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_8_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_8_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_8_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_8_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_8_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_8_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Internally option
		//Expected : The player’s name and team name must appear in the interface when clicking the "Share Internally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users")), "User not able to view the Share internally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users"));
		Thread.sleep(5000);

		//Step 7 :" Enter invalid Search Words"
		//Expected:" The user should be able to Enter valid Search Words"
		base.setData(LoginPageObj.Edt_LoginEmail("search-key"),SGTestData.SG_8_PlayerEmail);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("search-key"));
		asrt.assertEquals(ActualName,SGTestData.SG_8_PlayerEmail,"User should not able to enter the name in Search Words");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("globalsearch"));
		//asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Allowed characters a-z 0-9,.-@?!#$%&:")),"The User will not receive alert popup as 'Allowed characters a-z 0-9,.-@?!#$%&:'" );
		//base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		//Expected:"The system should return a message indicating that no results were found or the search term is invalid"
	}
	
	// <summary>
	// Test Case Title :"To verify that a game has been shared successfully with a user"
	// Automation ID   : SG_9
	// </summary>
	public void SG_9_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_9_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_9_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_9_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_9_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_9_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_9_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_9_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_9_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Internally option
		//Expected : The player’s name and team name must appear in the interface when clicking the "Share Internally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users")), "User not able to view the Share internally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users"));
		Thread.sleep(5000);
		
		//Step 12 :" Enter valid Search Words"
		//Expected:" The user should be able to Enter valid Search Words"
		base.setData(LoginPageObj.Edt_LoginEmail("search-key"),SGTestData.SG_9_PlayerEmail);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("search-key"));
		asrt.assertEquals(ActualName,SGTestData.SG_9_PlayerEmail,"User should not able to enter the name in Search Words");
		Thread.sleep(3000);

		//Step 13 :" Click Search Globally"
		//Expected:"The search results should return relevant content related to the search term"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("globalsearch"));
		Thread.sleep(8000);

		//Step 14 : "Click player Tab & Select a player"
		//Expected:" The user should be able to see a list of player names after clicking the "Players" tab"
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersCreate("playersbtn","PLAYERS")), "User not able to view the Players option");
		base.excuteJsClick(AddFollowerObj.Btn_FollowersCreate("playersbtn","PLAYERS"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("(anshu@maildrop.cc)")), "User not able to view the Players name list");
		base.excuteJsClick(SearchGameTeamAndMembersObj.Ele_MemberName("(anshu@maildrop.cc)"));
		
		//Step 15 : Click Share
		//Expected : A Game shared successfully message should come after share a game with a player
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("listSnipReel()"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Game shared succesfully")),"A Game shared successfully message is not visible to user while user share a game with a player");
	}

	// <summary>
	// Test Case Title :"To verify that a game has been shared successfully with a Team"
	// Automation ID   : SG_10
	// </summary>
	public void SG_10_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_10_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_10_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_10_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_10_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_10_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_10_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_10_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_10_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Internally option
		//Expected : The player’s name and team name must appear in the interface when clicking the "Share Internally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users")), "User not able to view the Share internally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users"));
		Thread.sleep(5000);
		
		//Step 12 :" Enter valid Search Words"
		//Expected:" The user should be able to Enter valid Search Words"
		base.setData(LoginPageObj.Edt_LoginEmail("search-key"),SGTestData.SG_10_TeamID);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("search-key"));
		asrt.assertEquals(ActualName,SGTestData.SG_10_TeamID,"User should not able to enter the name in Search Words");
		Thread.sleep(3000);

		//Step 13 :" Click Search Globally"
		//Expected:"The search results should return relevant content related to the search term"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("globalsearch"));
		Thread.sleep(8000);

		//Step 14 : "Click Team Tab & Select a Team"
		//Expected:" The user should be able to see a list of team names after clicking the "Team" tab"
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersCreate("teamsbtn","TEAMS")), "User not able to view the Teams option");
		base.excuteJsClick(AddFollowerObj.Btn_FollowersCreate("teamsbtn","TEAMS"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(ShareGameObj.Ele_PlayerTeamName(SGTestData.SG_10_TeamID)), "User not able to view the Players name list");
		base.excuteJsClick(ShareGameObj.Ele_PlayerTeamName(SGTestData.SG_10_TeamID));
		
		//Step 15 : Click Share
		//Expected : A Game shared successfully message should come after share a game with a player
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("listSnipReel()"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Game shared succesfully")),"A Game shared successfully message is not visible to user while user share a game with a player");
	}

	// <summary>
	// Test Case Title :"To verify user click "Cancel" on a dialog box, that the dialog box is closed"
	// Automation ID   : SG_11
	// </summary>
	public void SG_11_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_11_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_11_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_11_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_11_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_11_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_11_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_11_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_11_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Internally option
		//Expected : The player’s name and team name must appear in the interface when clicking the "Share Internally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users")), "User not able to view the Share internally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users"));
		Thread.sleep(5000);

		//Step 12 : Click "Cancel" option
		//Expected : The dialog box should close immediately after clicking the "Cancel" button
		base.buttonClick(ShareGameObj.Btn_Cancel("listSnipReel()", "vidback"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_11_GameName)),"The dialog box is not closed when click on cancel button");
	}

	// <summary>
	// Test Case Title :"Verify that the dialog box closes when the user clicks the close icon (an "X" button)"
	// Automation ID   : SG_12
	// </summary>
	public void SG_12_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_12_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_12_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_12_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_12_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_12_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_12_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_12_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_12_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Internally option
		//Expected : The player’s name and team name must appear in the interface when clicking the "Share Internally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users")), "User not able to view the Share internally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("snipback-share-users"));
		Thread.sleep(5000);

		//Step 12 : Click "close" icon
		//Expected : The dialog box should close immediately after the close icon is clicked, and it should no longer be visible on the screen
		base.buttonClick(ShareGameObj.Btn_XButton("mdlcontent", "×"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_12_GameName)),"The dialog box is not closed when click on cancel button");
	}

	// <summary>
	// Test Case Title :"To verify that a game has been shared successfully with a user"
	// Automation ID   : SG_13
	// </summary>
	public void SG_13_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_13_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_13_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_13_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_13_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_13_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_13_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_13_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_13_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Externally option
		//Expected : Facebook, Twitter, whatsapp, Telegram, skype and other social media options should be displayed when click "Share externally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("external-share")), "User not able to view the Share externally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("external-share"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ShareGameObj.Ele_Sharetab("socialShareModal","modal-content col-12"))," Facebook, Twitter, whatsapp, Telegram, skype and other social media options is not displayed when click Share externally option");
	}

	// <summary>
	// Test Case Title :"To verify that a user clicks any Facebook or other social media option and then gets redirected to that particular webpage"
	// Automation ID   : SG_14
	// </summary>
	public void SG_14_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_14_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_14_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_14_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_14_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_14_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_14_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_14_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_14_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Externally option
		//Expected : Facebook, Twitter, whatsapp, Telegram, skype and other social media options should be displayed when click "Share externally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("external-share")), "User not able to view the Share externally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("external-share"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ShareGameObj.Ele_Sharetab("socialShareModal","modal-content col-12"))," Facebook, Twitter, whatsapp, Telegram, skype and other social media options is not displayed when click Share externally option");

		//Step 12 : Click any social media option
		//Expected : Facebook option or other social media should redirected to that particular webpage when the user click on facebook or any other social media options
		base.excuteJsClick(ShareGameObj.Btn_fb("smd col-md-3", "img-thumbnail fab fa-facebook fa-2x"));
		base.switchToWindowByIndex(driver,2);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("clearfix loggedout_menubar")),"User is not able to view the particular social media webpage while user is clicking on any social media icon.");
	}

	// <summary>
	// Test Case Title :"Verify that the correct game URL is copied to the clipboard"
	// Automation ID   : SG_15
	// </summary>
	public void SG_15_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_15_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_15_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_15_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_15_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_15_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_15_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_15_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_15_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Externally option
		//Expected : Facebook, Twitter, whatsapp, Telegram, skype and other social media options should be displayed when click "Share externally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("external-share")), "User not able to view the Share externally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("external-share"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ShareGameObj.Ele_Sharetab("socialShareModal","modal-content col-12"))," Facebook, Twitter, whatsapp, Telegram, skype and other social media options is not displayed when click Share externally option");

		//Step 12 : Click "copy" icon
		//Expected : The URL of the game page should be copied to the clipboard and be accessible when pasted
		base.excuteJsClick(ShareGameObj.Btn_Icon("col-md-9 url-field-block","cpy copy-shareurl"));
		asrt.assertTrue(base.isExists(ShareGameObj.Ele_Copy("Game Link ","message")),"The copied URL of the game page is not copied to the clipboard and be accessible when pasted");
		Thread.sleep(5000);
	}

	// <summary>
	// Test Case Title : "Verify the user can copy the MP4 file URL "
	// Automation ID   : SG_16
	// </summary>
	public void SG_16_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_16_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_16_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_16_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_16_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_16_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_16_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_16_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_16_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Externally option
		//Expected : Facebook, Twitter, whatsapp, Telegram, skype and other social media options should be displayed when click "Share externally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("external-share")), "User not able to view the Share externally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("external-share"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ShareGameObj.Ele_Sharetab("socialShareModal","modal-content col-12"))," Facebook, Twitter, whatsapp, Telegram, skype and other social media options is not displayed when click Share externally option");

		//Step 12 : Click "COPY MP4 URL" option
		//Expected : The MP4 URL of the game page should be copied to the clipboard and be accessible when pasted
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("copymp4-gameurl"));
		asrt.assertTrue(base.isExists(ShareGameObj.Ele_Copy("Game Link ","message")),"The MP4 URL of the game page is not copied to the clipboard and be accessible when pasted");
	}

	// <summary>
	// Test Case Title : "Verify that the dialog box closes when the user clicks the close icon (an "X" button) "
	// Automation ID   : SG_17
	// </summary>
	public void SG_17_ShareGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ShareGame_TestData SGTestData = new ShareGame_TestData();
		ShareGame_Obj ShareGameObj = new ShareGame_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), SGTestData.SG_17_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_17_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_17_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(SGTestData.SG_17_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_17_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_17_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",SGTestData.SG_17_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_17_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  : Check "Share" option
		//Expected : User should be able to click the Share icon in the 3 dots menu
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share")),"'Share Icon' is not displayed in the 3 dots menu");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-share"));
		Thread.sleep(5000);
		
		//Step 11 : Click share Externally option
		//Expected : Facebook, Twitter, whatsapp, Telegram, skype and other social media options should be displayed when click "Share externally" option
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("external-share")), "User not able to view the Share externally option in Player page");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("external-share"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ShareGameObj.Ele_Sharetab("socialShareModal","modal-content col-12"))," Facebook, Twitter, whatsapp, Telegram, skype and other social media options is not displayed when click Share externally option");
		
		//Step 12 : Click "close" icon (an "X" button) 
		//Expected : The dialog box should close immediately after the close icon is clicked, and it should no longer be visible on the screen
		base.excuteJsClick(ShareGameObj.Btn_XClose("socialShareModal", "close"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+SGTestData.SG_17_GameName)),"The dialog box is not closed immediately after clicking the close icon.");
	}
}
