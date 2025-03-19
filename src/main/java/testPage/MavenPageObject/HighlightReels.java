package testPage.MavenPageObject;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestData.CommonData;
import objectRepository.AddFollower_Obj;
import TestData.WhiteboardAndReels_TestData;
import TestData.HighlightReels_TestData;
import TestData.TrimVideo_TestData;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.ArchiveUnarchiveTeam_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.DualView_Obj;
import objectRepository.DuplicateSnip_Obj;
import objectRepository.EditSnip_Obj;
import objectRepository.HighlightReels_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.TrimVideo_Obj;
import objectRepository.ViewListUpdateDownloadShareDeleteLibrary_Obj;
import objectRepository.WhiteboardPlayer_Obj;
import utilPack.BasePge;

public class HighlightReels extends BasePge {

	BasePge base;
	Assert asrt; 

	public HighlightReels(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	
	// <summary>
	// Test Case Title :"To verify that what happens when we click Highlight and white boards"
	// Automation ID   : HR_01 
	// </summary>
	public void HR_01_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5:  Switch to any team from the team dropdown menu after selecting an Organization
		//Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The team cannot be selected from the dropdown.");
		Thread.sleep(3000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7  : Select EVENTS/PRACTICES/SCOUT
		//Expected: Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  : Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");             
	
	}	

	// <summary>
	// Test Case Title :"To verify that what happens when we click  My Highlight Reels + icon"
	// Automation ID   : HR_02
	// </summary>
	public void HR_02_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected: The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected: Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");
	
	}

	// <summary>
	// Test Case Title :"To verify that what happens when we click  X Button in the Highlight reel name "
	// Automation ID   : HR_03
	// </summary>
	public void HR_03_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 9  : View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter any name and clear it
		//Expected : The user should be able to Clear the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_03_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_03_TestData, "User not able to enter the highlightreel name");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("cleartext(this)")), "User is not able to view the clear icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("cleartext(this)"));
		String HighlightReelName1 = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName1, "", "User not able to clear the highlightreel name");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user enter a Invalid Intro Slide Text"
	// Automation ID   : HR_15
	// </summary>
	public void HR_15_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid highlight reel Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_15_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_15_TestData, "User not able to enter the highlightreel name");
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		
		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 : To enter a Invalid Intro Slide Text
		//Expected : The user should get a ERROR popup message that"Allowed characters a-z 0-9,.-@?!#$%&:"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the InvalidIntroSlideText textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_15_IntroSlideText);
		String InvalidIntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(5000);
		asrt.assertEquals(InvalidIntroSlideText, HighlightReelsTestData.HR_15_IntroSlideText, "User not able to enter the Invalid Intro Slide Text name");
		base.excuteJsClick(HighlightReelsObj.Ele_InvalidIntro("slide-button"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Allowed characters a-z 0-9,.-@?!#$%&:")),"User is able to enter the Invalid IntroSlideText");		
	}

	// <summary>
	// Test Case Title :"To verify that what happens when we click  X Button in the Extro Header (Large Text)"
	// Automation ID   : HR_24
	// </summary>
	public void HR_24_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_23_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_24_TestData, "User not able to enter the highlightreel name");
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		
		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_24_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText, HighlightReelsTestData.HR_24_ExtroHeader, "User not able to enter the ExtroHeader");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("cleartitletext(this)")), "User is not able to view the clear icon of ExtroHeader");
		
		//Step 14 : To clear the ExtroHeader
		//Expected : The user should be able to clear the ExtroHeader Name.
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("cleartitletext(this)"));
		String ExtroHeaderText1 = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText1, " ", "User is not able to clear the ExtroHeader name");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user enter a Valid Extro-Sub Header (medium Text)"
	// Automation ID   : HR_30
	// </summary>
	public void HR_30_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));	
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		
		//Step 9:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		
		//Step 10:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 11: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		
		//Step 12: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Snip"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 13  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 14 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 15 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		
		//Step 16 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 17 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), HighlightReelsTestData.HR_30_IntroSlideText);

		//Step 18 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_30_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 19 :  Enter valid Extro Sub-header
		//Expected : User should able to enter a valid Extro Sub-Header.
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), HighlightReelsTestData.HR_30_ExtroSubHeader);

		//Step 20 : Enter valid Extro Details and click on Save button
		//Expected : The valid Extro-Sub Header (medium Text) should be saved without any issues.
		base.setData(HighlightReelsObj.Ele_Subheader("details"), "user should able to enter valid extro details");
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"The valid Extro-Sub Header (medium Text) is not saved without any issues.");   
		
	}

	// <summary>
	// Test Case Title :"To verify what happens when user leave the Intro Slide Text empty"
	// Automation ID   : HR_16
	// </summary>
	public void HR_16_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_16_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_16_TestData, "User not able to enter the highlightreel name");
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		
		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 : To verify what happens when user leave the Intro Slide Text empty
		//Expected : The user should get a message that "Please enter the Intro Text"
		//To enter the ExtroHeader
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_16_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText, HighlightReelsTestData.HR_16_ExtroHeader, "User not able to enter the ExtroHeader");

		//To enter the ExtroSubHeader
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2")),"User is not able to view the ExtroSubHeader textbox in highlightreels");   
		base.setData(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2"), HighlightReelsTestData.HR_16_ExtroSubHeader);
		String ExtroSubHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroSubHeaderText, HighlightReelsTestData.HR_16_ExtroSubHeader, "User not able to enter the ExtroSubHeader in Hightlightreels");

		//To enter the ExtroDetails
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3")),"User is not able to view the ExtroDetails textbox in highlightreels");   
		base.setData(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3"), HighlightReelsTestData.HR_16_ExtroDetails);
		String ExtroDetailsText = base.GetValue(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroDetailsText, HighlightReelsTestData.HR_16_ExtroDetails, "User not able to enter the ExtroDetails in Hightlightreels");

		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-save-createhighlight","Save")),"The Save button is not displayed in the highlightreel popup in player page.");		
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-save-createhighlight","Save"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Please enter the Intro Text")),"User is able to save highlightReels without IntroSlideText");		
	}

	// <summary>
	// Test Case Title :"To verify what happens when user enter Invalid Extro Details (Small Text)"
	// Automation ID   : HR_31
	// </summary>
	public void HR_31_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));	
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_31_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_31_TestData, "User not able to enter the highlightreel name");
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		
		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), HighlightReelsTestData.HR_31_IntroSlideText);

		//Step 14 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_31_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 15 :  Enter valid Extro Sub-header
		//Expected : User should able to enter a valid Extro Sub-Header.
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), HighlightReelsTestData.HR_31_ExtroSubHeader);

		//Step 16 : Enter Invalid Extro Details
		//Expected : The user should get a ERROR popup message that"Allowed characters a-z 0-9,.-@?!#$%&:"
		base.setData(HighlightReelsObj.Ele_Subheader("details"), HighlightReelsTestData.HR_31_ExtroDetails);
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		//asrt.assertTrue(base.isExists(LoginPageObj1.Edt_AlertText("Allowed characters a-z 0-9,.-@?!#$%&:"))," The user is not able to view an ERROR popup message that\"Allowed characters a-z 0-9,.-@?!#$%&:");   
	}

	// <summary>
	// Test Case Title :"To verify whether the user is able to change Public and Private options."
	// Automation ID   : HR_04 
	// </summary>
	public void HR_04_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_04_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_04_TestData, "User not able to enter the highlightreel name");
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		
		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), HighlightReelsTestData.HR_04_IntroSlideText);

		//Step 14 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_04_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 15 :  Enter valid Extro Sub-header
		//Expected : User should able to enter a valid Extro Sub-Header.
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), HighlightReelsTestData.HR_04_ExtroSubHeader);

		//Step 16 : Enter Invalid Extro Details
		//Expected : The user should get a ERROR popup message that"Allowed characters a-z 0-9,.-@?!#$%&:"
		base.setData(HighlightReelsObj.Ele_Subheader("details"), HighlightReelsTestData.HR_04_ExtroDetails);
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Allowed characters a-z 0-9,.-@?!#$%&:"))," The user is not able to view an ERROR popup message that\"Allowed characters a-z 0-9,.-@?!#$%&:");   
	}

	// <summary>
	// Test Case Title :"To verify what happens when user leave the Extro Details (Small Text)"
	// Automation ID   : HR_32
	// </summary>
	public void HR_32_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));	
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		
		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), HighlightReelsTestData.HR_30_IntroSlideText);

		//Step 14 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_30_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 15 :  Enter valid Extro Sub-header and click on save button
		//Expected : The user should get a message that"Please enter the Extro Details (Small Text)"
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), HighlightReelsTestData.HR_30_ExtroSubHeader);
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Please enter the extro details")),"The user is not able to view a message that Please enter the Extro Details");
	}

	// <summary>
	// Test Case Title :"To verify that what happens when we click  X Button in the Intro Slide Text "
	// Automation ID   : HR_17
	// </summary>
	public void HR_17_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 10 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_04_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_04_TestData, "User not able to enter the highlightreel name");

		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 : To enter a valid Intro Slide Text
		//Expected : The user should be able to enter the text"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the IntroSlideText textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_04_IntroSlideText);
		String IntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(5000);
		asrt.assertEquals(IntroSlideText, HighlightReelsTestData.HR_04_IntroSlideText, "User not able to enter the valid Intro Slide Text name");

		//Step 14 : Click X icon near the Intro Slide text field
		//Expected : The user should be able to Clear the Intro Slide Text.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_IntroClear("clearsubheadertext(this)")), "User is not able to view the clear icon of intro slide");
		base.excuteJsClick(HighlightReelsObj.Ele_IntroClear("clearsubheadertext(this)"));
		//String IntroSlideTextClear = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		//Thread.sleep(5000);
		//asrt.assertEquals(IntroSlideTextClear, "", "User not able to clear the intro slide name");
	}

	// <summary>
	// Test Case Title :"To verify that what happens when we click  X Button in the Extro Details (Small Text)"
	// Automation ID   : HR_33
	// </summary>
	public void HR_33_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 4   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 5   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 6  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));	
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 7  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 8 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 9 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_31_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_31_TestData, "User not able to enter the highlightreel name");

		//Step 10 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 11 : To enter a valid Intro Slide Text
		//Expected : The user should be able to enter the text"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the IntroSlideText textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_30_IntroSlideText);
		String IntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(5000);
		asrt.assertEquals(IntroSlideText, HighlightReelsTestData.HR_30_IntroSlideText, "User not able to enter the valid Intro Slide Text name");

		//Step 12 : Click X icon near the Intro Slide text field
		//Expected : The user should be able to Clear the Intro Slide Text.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_IntroClear("clearsubheadertext(this)")), "User is not able to view the clear icon of intro slide");
		base.excuteJsClick(HighlightReelsObj.Ele_IntroClear("clearsubheadertext(this)"));
		//String IntroSlideTextClear = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		//Thread.sleep(5000);
		//asrt.assertEquals(IntroSlideTextClear, "", "User not able to clear the intro slide name");
	}


	// <summary>
	// Test Case Title :"To verify what happens when user Click the Select all button "
	// Automation ID   : HR_09
	// </summary>
	public void HR_09_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		
		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 10 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_04_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_04_TestData, "User not able to enter the highlightreel name");
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		
		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), HighlightReelsTestData.HR_04_IntroSlideText);

		//Step 14 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_04_ExtroDetails);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 15 :  Enter valid Extro Sub-header 
		//Expected : The user should able to enter a valid Extro Sub-header
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), HighlightReelsTestData.HR_04_ExtroHeader);

		//Step 16 : Enter valid Extro Details and click on X button
		//Expected : The user should be able to Clear the Extro Details (Small Text)
		base.setData(HighlightReelsObj.Ele_Subheader("details"), HighlightReelsTestData.HR_04_ExtroDetails);
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("cleardetailstext(this)"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_Subheader("details")),"The user is not able to clear the Extro Details in Highlight and Whiteboard tab.");
	}

	// <summary>
	// Test Case Title :"To verify that what happens when a user type more than 180 characters in Extro Details (Small Text)"
	// Automation ID   : HR_34
	// </summary>
	public void HR_34_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");

		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), HighlightReelsTestData.HR_30_IntroSlideText);

		//Step 14 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_30_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 15 :  Enter valid Extro Sub-header 
		//Expected : The user should able to enter a valid Extro Sub-header
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), HighlightReelsTestData.HR_30_ExtroSubHeader);

		//Step 16 : Enter the Extro details with more than 180 characters and click on Save button.
		//Expected : The input field should restrict further input and not allow typing beyond 180 characters in Extro Details 
		base.setData(HighlightReelsObj.Ele_Subheader("details"), HighlightReelsTestData.HR_34_ExtroDetails);
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("section1 clickopenpopup")),"The input field should not restrict further input and allow typing beyond 180 characters in Extro Details");
	}
	
	// <summary>
	// Test Case Title :"To verify what happens when user Click the De-select all button"
	// Automation ID   : HR_10
	// </summary>
	public void HR_10_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		
		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		
		//Step 9  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		
		//Step 10  : click  My Hightlight Reels + icon
		//Expected: User able to view My Hightlight Reels + icon
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		
		//Step 11  :To verify what happens when user Click the Select all button 
		//Expected:Clicking the "Select All" button should select all items in the list.    
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(5));
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Deselect All","checkmark")),"user unable to select to Select All");
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Deselect All","checkmark"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("each-shot selected-pined1 foredshot1 after-elem-enable removed-bk-from-hightlight")),"User unable to select all items in the list");
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("each-shot selected-pined1 foredshot2 after-elem-enable removed-bk-from-hightlight")),"User unable to select all items in the list");
	}  

	// <summary>
	// Test Case Title :"To verify that the Music Slide Dropdown  is working or not"
	// Automation ID   : HR_35
	// </summary>
	public void HR_35_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		Thread.sleep(20000);
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");

		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), HighlightReelsTestData.HR_30_IntroSlideText);

		//Step 14 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_30_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 15 :  Enter valid Extro Sub-header and Extro Details
		//Expected : The user should able to enter a valid Extro Sub-header and Extro Details
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), HighlightReelsTestData.HR_30_ExtroSubHeader);
		base.setData(HighlightReelsObj.Ele_Subheader("details"), "user should able to enter valid extro details");

		//Step 16 : Click Music Dropdown
		//Expected : The Music Slide Dropdown should open when clicked and display a list of available 
		base.excuteJsClick(HighlightReelsObj.Btn_Music("#collapseTwo"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("SELECT AUDIO")),"The Music Slide Dropdown will not open when clicked and user is not able to view  list of available");   
	} 

	// <summary>
	// Test Case Title :"The selected theme should immediately reflect in the UI after the user makes a selection from the Snipback Theme Dropdown."
	// Automation ID   : HR_18
	// </summary>
	public void HR_18_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		TrimVideo_Obj TrimVideoObj=new TrimVideo_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		HighlightReels_TestData HighlightReelsTestData=new HighlightReels_TestData(); 
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj(); 
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		Thread.sleep(4000);
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));

		//Step 10  : click  My Highlight Reels + icon
		//Expected: User able to view My Highlight Reels + icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 11  :To verify what happens when user Click the Select all button 
		//Expected:Clicking the "Select All" button should select all items in the list.    
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(5));
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Deselect All","checkmark")),"user unable to select to Select All");
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Deselect All","checkmark"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("each-shot selected-pined1 foredshot1 after-elem-enable removed-bk-from-hightlight")),"User unable to select all items in the list");
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("each-shot selected-pined1 foredshot2 after-elem-enable removed-bk-from-hightlight")),"User unable to select all items in the list");
	}  

	// <summary>
	// Test Case Title :"To verify that the Select Audio Dropdown  is working or not"
	// Automation ID   : HR_36
	// </summary>
	public void HR_36_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");

		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), HighlightReelsTestData.HR_30_IntroSlideText);

		//Step 14 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_30_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 15 :  Enter valid Extro Sub-header and Extro Details
		//Expected : The user should able to enter a valid Extro Sub-header and Extro Details
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), HighlightReelsTestData.HR_30_ExtroSubHeader);
		base.setData(HighlightReelsObj.Ele_Subheader("details"), "user should able to enter valid extro details");

		//Step 16 : Click Music Dropdown
		//Expected : The Music Slide Dropdown should open when clicked and display a list of available 
		base.excuteJsClick(HighlightReelsObj.Btn_Music("#collapseTwo"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("SELECT AUDIO")),"The Music Slide Dropdown will not open when clicked and user is not able to view  list of available");   

		//Step 17 : Click Audio Dropdown
		//Expected : The Select Audio Dropdown should open when clicked and display a list of Available
		base.excuteJsClick(PoolObj.Ele_PoolTypeDropDown("select-audio-option"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("CUSTOM")),"The Select Audio Dropdown is not opened when user clicked and user is not able to view the list of Available");   
	}

	// <summary>
	// Test Case Title :"To verify what happens when user leave the Extro Header (Large Text) empty"
	// Automation ID   : HR_23
	// </summary>
	public void HR_23_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 10 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_23_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_23_TestData, "User not able to enter the highlightreel name");

		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 : To verify what happens when user leave the Extro Header (Large Text) empty
		//Expected : The user should get a message that "Please enter the Intro Text"
		//To enter the IntroSlide
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the IntroSlide textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_23_IntroSlideText);
		String InvalidIntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(5000);
		asrt.assertEquals(InvalidIntroSlideText, HighlightReelsTestData.HR_23_IntroSlideText, "User is not able to enter the IntroSlidetext in highlightReels");

		//To enter the ExtroSubHeader
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2")),"User is not able to view the ExtroSubHeader textbox in highlightreels");   
		base.setData(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2"), HighlightReelsTestData.HR_23_ExtroHeader);
		String ExtroSubHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroSubHeaderText, HighlightReelsTestData.HR_23_ExtroHeader, "User is not able to enter the ExtroSubHeader in Hightlightreels");

		//To enter the ExtroDetails
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3")),"User is not able to view the ExtroDetails textbox in highlightreels");   
		base.setData(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3"), HighlightReelsTestData.HR_23_ExtroDetails);
		String ExtroDetailsText = base.GetValue(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroDetailsText, HighlightReelsTestData.HR_23_ExtroDetails, "User is not able to enter the ExtroDetails in Hightlightreels");

		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-save-createhighlight","Save")),"The Save button is not displayed in the highlightreel popup in player page.");		
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-save-createhighlight","Save"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Please enter the extro header")),"User is able to save highlightReels without ExtroHeaderText");		
	}

	// <summary>
	// Test Case Title :"To verify that by selecting Default Audio is Selected or not"
	// Automation ID   : HR_37
	// </summary>
	public void HR_37_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");

		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), HighlightReelsTestData.HR_30_IntroSlideText);

		//Step 14 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_04_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 15 :  Enter valid Extro Sub-header and Extro Details
		//Expected : The user should able to enter a valid Extro Sub-header and Extro Details
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"),HighlightReelsTestData.HR_04_ExtroSubHeader);
		base.setData(HighlightReelsObj.Ele_Subheader("details"), "user should able to enter valid extro details");

		//Step 16 : Click Music Dropdown
		//Expected : The Music Slide Dropdown should open when clicked and display a list of available 
		base.excuteJsClick(HighlightReelsObj.Btn_Music("#collapseTwo"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("SELECT AUDIO")),"The Music Slide Dropdown will not open when clicked and user is not able to view  list of available");   

		//Step 17 : Click Audio Dropdown
		//Expected : The Select Audio Dropdown should open when clicked and display a list of Available
		base.excuteJsClick(PoolObj.Ele_PoolTypeDropDown("select-audio-option"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("CUSTOM")),"The Select Audio Dropdown is not opened when user clicked and user is not able to view the list of Available");   

		//Step 18 : Click Default Audio
		//Expected : The Default Audio should be Selected
		base.excuteJsClick(PoolObj.Ele_SelectPoolType("DEFAULT"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("DEFAULT")),"The default audio is not selected by the user.");   
	}

	// <summary>
	// Test Case Title :"To verify what happens when user click the cancel  button after create a Highlight reels"
	// Automation ID   : HR_12
	// </summary>
	public void HR_12_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		
		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		
		//Step 9  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		
		//Step 10  : click  My Highlight Reels + icon
		//Expected: User able to view My Highlight Reels + icon
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		
		//Step 11  :click the checkbox Generate default highlight reel
		//Expected:Clicking the "Select All" button should select all items in the list.    
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(5));
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));
		asrt.assertTrue( base.isEnabledBy(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"User Unable to select check box 'Generate default highlight reel'");

		//Step 12  :To verify what happens when user click the cancel  button after create a Highlight reels
		//Expected:When the user clicks "cancel," all changes made to the Highlight reel should be discarded.    
		base.excuteJsClick(EditSnipObj.Btn_Done("add-hightlightreel-block","Cancel"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"changes made to the Highlight reel not get discarded" );
	}


	// <summary>
	// Test Case Title :"To verify that the Select Default Audios Dropdown is working or not"
	// Automation ID   : HR_38
	// </summary>
	public void HR_38_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");

		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), HighlightReelsTestData.HR_30_IntroSlideText);

		//Step 14 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_04_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 15 :  Enter valid Extro Sub-header and Extro Details
		//Expected : The user should able to enter a valid Extro Sub-header and Extro Details
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"),HighlightReelsTestData.HR_04_ExtroSubHeader);
		base.setData(HighlightReelsObj.Ele_Subheader("details"), "user should able to enter valid extro details");

		//Step 16 : Click Music Dropdown
		//Expected : The Music Slide Dropdown should open when clicked and display a list of available 
		base.excuteJsClick(HighlightReelsObj.Btn_Music("#collapseTwo"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("SELECT AUDIO")),"The Music Slide Dropdown will not open when clicked and user is not able to view  list of available");   

		//Step 17 : Click Audio Dropdown
		//Expected : The Select Audio Dropdown should open when clicked and display a list of Available
		base.excuteJsClick(PoolObj.Ele_PoolTypeDropDown("select-audio-option"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("CUSTOM")),"The Select Audio Dropdown is not opened when user clicked and user is not able to view the list of Available");   

		//Step 18 : Click Default Audio
		//Expected : The Default Audio should be Selected
		base.excuteJsClick(PoolObj.Ele_SelectPoolType("DEFAULT"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("DEFAULT")),"The default audio is not selected by the user.");   

		//Step 19 : Click Default Audios Dropdown
		//Expected : The Select Default Audios Dropdown should open when clicked and display a list of Available.
		base.excuteJsClick(PoolObj.Ele_PoolTypeDropDown("select-music"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_Audio("assets/mp3/SNIPBACKmusic2.mp3")),"The Select Default Audios Dropdown will not open when user clicked and user is not able to view the list of Available.");   
	}

	// <summary>
	// Test Case Title :"To verify that the Title Slide Dropdown  is working or not"
	// Automation ID   : HR_13
	// </summary>
	public void HR_13_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		HighlightReels_TestData HighlightReelsTestData=new HighlightReels_TestData();
		TrimVideo_Obj TrimVideoObj=new TrimVideo_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		Thread.sleep(3000); 
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);

		// Step 4:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		

		//Step 5:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TrimVideoTestData.TV_01_teamName);

		//Step 6:Selecting the team
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName)), "Failed to select TEAM");
		Thread.sleep(5000);
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		
		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		// Step 8: Switching to window
		// Expected : Verify  "HIGHLIGHTS & WHITEBOARDS" is visible in right side  
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_selectteam("hightlight-popup-button")),"User is not able to view 'HIGHLIGHTS & WHITEBOARDS' button");
		Thread.sleep(2000);	

		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 10 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the private radio button
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(6000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Chk_PrivateRadioButton("newhighlightradiotwo","span","checkmark")),"User is not able to view the private option radio button");

		//Step 11: click on private
		//Expected:HightlightReel Name ( Max 25 characters) input text box is displayed
		base.excuteJsClick(HighlightReelsObj.Chk_PrivateRadioButton("newhighlightradiotwo","span","checkmark"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 12: Enter name in HighlightReel Name text input box
		//Expected:Verify if text entered in HighlightReel Name text input box
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),HighlightReelsTestData.HR_19_highlightReelName);
		asrt.assertEquals(base.GetValue(LoginPageObj.Edt_LoginEmail("reelname")), HighlightReelsTestData.HR_19_highlightReelName,"Test not entered in HighlightReel Name textbox");

		//Step 13: Get the dropdown option selected by default
		String currentOptionInDropDown = base.getTheSelectedTextInDropDown(By.id("select-theme"));

		//Step 14:Getting the list of options in the dropdown 
		List<WebElement> listOfOptions = base.getTheAllOptions(By.id("select-theme"));
		for(WebElement element:listOfOptions) {

		//Step 15:Change the dropdown option
			if(!element.getText().equals(currentOptionInDropDown)) {
				base.selectorByVisibleText(By.id("select-theme"), element.getText());
				break;
			}
		}
		//Step 16:Get the text shown after changing the  dropdown option 
		String updatedOptionInDropDown=base.getTheSelectedTextInDropDown(By.id("select-theme")); 

		//Step 17:Verifying if the text by default and the changed text is different
		//By looking like this we can declare if the dropdown is working or not 
		asrt.assertNotEquals(currentOptionInDropDown,updatedOptionInDropDown,"the selected Snipback Drop down is not shown and dropdown is not working");

	}	

	// <summary>
	// Test Case Title :"The selected theme should immediately reflect in the UI after the user makes a selection from the Snipback Theme Dropdown."
	// Automation ID   : HR_19
	// </summary>
	public void HR_19_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		TrimVideo_Obj TrimVideoObj=new TrimVideo_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		HighlightReels_TestData HighlightReelsTestData=new HighlightReels_TestData(); 
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));

		//Step 10  : click  My Hightlight Reels + icon
		//Expected: User able to view My Hightlight Reels + icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 11  :To verify that the Title Slide Dropdown  is working or not
		//Expected:The Title Slide Dropdown should open when clicked and display a list of available themes.  
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(5));

		//Step 12  :To verify that the Title Slide Dropdown  is working or not
		//Expected:The Title Slide Dropdown should open when clicked and display a list of available themes. 
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsDrop("TITLE SLIDE"));//bug
		Thread.sleep(3000);
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsDrop("TITLE SLIDE"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("DESIGN")),"Unable to view list of available themes");
	}

	// <summary>
	// Test Case Title :"To verify that the Select Default Audios Dropdown  is working or not"
	// Automation ID   : HR_40
	// </summary>
	public void HR_40_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.excuteJsClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 10 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");

		//Step 12 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 13 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), HighlightReelsTestData.HR_30_IntroSlideText);

		//Step 14 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_04_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 15 :  Enter valid Extro Sub-header and Extro Details
		//Expected : The user should able to enter a valid Extro Sub-header and Extro Details
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"),HighlightReelsTestData.HR_04_ExtroSubHeader);
		base.setData(HighlightReelsObj.Ele_Subheader("details"), "user should able to enter valid extro details");

		//Step 16 : Click Music Dropdown
		//Expected : The Music Slide Dropdown should open when clicked and display a list of available 
		base.excuteJsClick(HighlightReelsObj.Btn_Music("#collapseTwo"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("SELECT AUDIO")),"The Music Slide Dropdown will not open when clicked and user is not able to view  list of available");   

		//Not able to automate
		//Step 17 : Move seek Bar Forward/Backward
		//Expected : The seek Bar functionality works as expected with the default audio source, allowing users to scrub forward and backward through the audio track smoothly and without issues.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_Seek("music")),"The seek bar functionality does not work as expected with the default audio source");   
	}

	// <summary>
	// Test Case Title :"To verify that the Snipback Theme Drop down is working or not"
	// Automation ID   : HR_14
	// </summary>
	public void HR_14_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		
		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		
		//Step 9  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		
		//Step 10  : click  My Highlight Reels + icon
		//Expected: User able to view My Highlight Reels + icon
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		
		//Step 11  :To verify that the Title Slide Dropdown  is working or not
		//Expected:The Title Slide Dropdown should open when clicked and display a list of available themes.  
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(5));

		//Step 12  :To verify that the Snipback Theme Drop down is working or not
		//Expected:The Snipback Theme Dropdown should open when clicked and display a list of available themes. 	  
		base.selectorByVisibleText(HighlightReelsObj.Ddl_SnipbackThemeDropDown("distesign-select pb-3 pt-2","form-select"), "SNIPBACK THEME 4");
		String selectedText=base.getTheSelectedTextInDropDown(HighlightReelsObj.Ddl_SnipbackThemeDropDown("distesign-select pb-3 pt-2","form-select"));
		asrt.assertEquals(selectedText, "SNIPBACK THEME 4", "Snipback Theme Dropdown not open and Unable to view  a list of available themes");
	}

	// <summary>
	// Test Case Title :"Verify that the Edit highlight reel page should be displayed when click on edit option against the highlight reel in the player page"
	// Automation ID   : HR_57
	// </summary>
	public void HR_57_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();	
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
	
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		
		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 8  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));

		//Step 9:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 10:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
				
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 11: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		Thread.sleep(5000);	
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 12: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Snip"));

		//Step 13  : click  My Hightlight Reels + icon
		//Expected: User able to view My Hightlight Reels + icon
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 14 :To verify that highlight reels public checked or not 
		//Expected: Highlight reels set as public. 
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(8));

		//Step 15 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 16 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), base.CreateRandomWithoutNumbers(9));

		//Step 17 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), base.CreateRandomWithoutNumbers(9));
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 18 :  Enter valid Extro Sub-header
		//Expected : User should able to enter a valid Extro Sub-Header.
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), base.CreateRandomWithoutNumbers(10));

		//Step 19 : Enter valid Extro Details and click on Save button
		//Expected : The valid Extro-Sub Header (medium Text) should be saved without any issues.
		base.setData(HighlightReelsObj.Ele_Subheader("details"), "extro details");
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"The valid Extro-Sub Header (medium Text) is not saved without any issues.");   

		Thread.sleep(30000);	

		//Step 20  : Click  Edit icon
		//Expected: User able to view Edit icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit")),"Unable to view Edit icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit"));

		//Step 21  : Verify that the Edit highligh reel page should be displayed when click on edit option against the highlight reel in the player page
		//Expected: The Edit highligh reel page should be displayed when click on edit option against the highlight reel in the player page
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips")),"Unable to view Edit Other details button");	  
		base.excuteJsClick(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Edit Hightlight Reel")),"Unable to view Hightlight Reel");	
		
		
	}

	// <summary>
	// Test Case Title :"Verify that user should able to edit the name and other details related to the highlight reels when click on edit button"
	// Automation ID   : HR_58
	// </summary>
	public void HR_58_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
				
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
				
		//Step 4   :"Select a OrgName"			
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 8:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 9:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 10: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 11: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Snip"));
		
		//Step 12  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));

		//Step 13 : click  My Highlight Reels + icon
		//Expected: User able to view My Highlight Reels + icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 14 :To verify that highlight reels public checked or not 
		//Expected: Highlight reels set as public. 
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(12));

		//Step 15 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 16 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"),base.CreateRandomWithoutNumbers(5));

		//Step 17 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), base.CreateRandomWithoutNumbers(15));
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 18 :  Enter valid Extro Sub-header
		//Expected : User should able to enter a valid Extro Sub-Header.
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), base.CreateRandomWithoutNumbers(13));

		//Step 19 : Enter valid Extro Details and click on Save button
		//Expected : The valid Extro-Sub Header (medium Text) should be saved without any issues.
		base.setData(HighlightReelsObj.Ele_Subheader("details"), "user should able to enter valid extro details");
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"The valid Extro-Sub Header (medium Text) is not saved without any issues.");   

		Thread.sleep(30000);	

		//Step 20  : Click  Edit icon
		//Expected: User able to view Edit icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit")),"Unable to view Edit icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit"));

		//Step 21  : Verify that the Edit highligh reel page should be displayed when click on edit option against the highlight reel in the player page
		//Expected: The Edit highligh reel page should be displayed when click on edit option against the highlight reel in the player page
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips")),"Unable to view Edit Other details button");	  
		base.excuteJsClick(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Edit Hightlight Reel")),"Unable to view Hightlight Reel");	   

		//Step 22 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), base.CreateRandomWithoutNumbers(15));

		//Step 23 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), base.CreateRandomWithoutNumbers(8));
		String ExtrosHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 24 :  Enter valid Extro Sub-header
		//Expected : User should able to enter a valid Extro Sub-Header.
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), base.CreateRandomWithoutNumbers(11));

		//Step 25 : Enter valid Extro Details 
		//Expected : Added extro details
		base.setData(HighlightReelsObj.Ele_Subheader("details"), "extro details added");
		
	}

	//<summary>
	// Test Case Title :"Verify that the following option should be displayed in the edit highlight reel page 1.Cancel 2.Save 3.Save as"
	// Automation ID   : HR_59
	// </summary>
	public void HR_59_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
				
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
				
		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 8:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 9:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 10: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"	
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 11: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Snip"));
		
		//Step 12  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));

		//Step 13: click  My Hightlight Reels + icon
		//Expected: User able to view My Hightlight Reels + icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 14:To verify that highlight reels public checked or not 
		//Expected: Highlight reels set as public. 
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(8));

		//Step 15 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 16 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), base.CreateRandomWithoutNumbers(9));

		//Step 17 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), base.CreateRandomWithoutNumbers(9));
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 18 :  Enter valid Extro Sub-header
		//Expected : User should able to enter a valid Extro Sub-Header.
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), base.CreateRandomWithoutNumbers(10));

		//Step 19 : Enter valid Extro Details and click on Save button
		//Expected : The valid Extro-Sub Header (medium Text) should be saved without any issues.
		base.setData(HighlightReelsObj.Ele_Subheader("details"), "extro details");
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"The valid Extro-Sub Header (medium Text) is not saved without any issues.");   

		Thread.sleep(30000);	

		//Step 20 : Click  Edit icon
		//Expected: User able to view Edit icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit")),"Unable to view Edit icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit"));

		//Step 21  : Verify that the Edit highligh reel page should be displayed when click on edit option against the highlight reel in the player page
		//Expected: The Edit highligh reel page should be displayed when click on edit option against the highlight reel in the player page
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips")),"Unable to view Edit Other details button");	  
		base.excuteJsClick(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Edit Hightlight Reel")),"Unable to view Hightlight Reel");	   
	 
		//Step 22 :  Check and verify user can view cancel,save,save as button in edit highlight reels
		//Expected : User should able to view cancel,save,save as button in edit highlight reels 
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-cancel-createhighlight")),"Unable to view cancel button");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"Unable to view save button");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-save-as-createhighlight")),"Unable to view save as button");
		
					
	}

	// <summary>
	// Test Case Title :"Verify that when click on With music the reels should be downloaded with music"
	// Automation ID   : HR_66
	// </summary>
	public void HR_66_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardAndReelsTestData = new WhiteboardAndReels_TestData();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
				
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
	    //Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 9:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 10:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 11: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"	
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 12: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Snip"));
		
		//Step 13  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));


		//Step 14 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.excuteJsClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 15 : To click on Public/Private
		//Expected : User should be able to mark any one of them
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));

		//Step 16 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_66_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_66_TestData, "User not able to enter the highlightreel name");

		//Step 17 : Click the checkbox Generate default highlight reel
		//Expected : User should be able to mark the checkbox    
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"user is not able to mark the checkbox");
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));

		//Step 18 : Click Save button
		//Expected : User should be able to create a highlightreel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to change to Public");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		Thread.sleep(30000);

		//Step 19 : Click on Download Icon
		//Expected : User should be able to see the two options(with music & without music)
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("reel-icon popup-btn-download-hightlight")),"User is not able to view the download icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("reel-icon popup-btn-download-hightlight"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-downloadmusicfile")),"user is not able to view the with music option to download");	    
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-downloadNomusicfile")),"user is not able to view the without music option to download");		    
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-downloadmusicfile"));
		// String downloadPath = System.getProperty("/Users/anaghasnair/Downloads/");
		// String expectedFileName = "31417_17877_1736234166_final_output.mp4";	       
		// File downloadedFile = new File(downloadPath + expectedFileName);
		// Thread.sleep(15000);
		// asrt.assertTrue(downloadedFile.exists(),"The video was not downloaded successfully or not saved in the Downloads folder");  
				
	} 
	// <summary>
	// Test Case Title :"Verify that when click on Cancel button the Edit highlight reel page get closed"
	// Automation ID   : HR_60
	// </summary>
	public void HR_60_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
	
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		
		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 8:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 9:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 10: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 11: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Snip"));
		
		//Step 12  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));
		
		//Step 13  : click  My Highlight Reels + icon
		//Expected: User able to view My Highlight Reels + icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 14 :To verify that highlight reels public checked or not 
		//Expected: Highlight reels set as public.
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(8));

		//Step 15 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 16 :  Enter a Valid Intro Slide Text
		//Expected : User should able to enter a valid Intro Slide Text.
		base.setData(RegistrationObj.Ele_SignupField("intro-slide-text"), base.CreateRandomWithoutNumbers(9));

		//Step 17 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), base.CreateRandomWithoutNumbers(9));
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));

		//Step 18 :  Enter valid Extro Sub-header
		//Expected : User should able to enter a valid Extro Sub-Header.
		base.setData(HighlightReelsObj.Ele_Subheader("sub-header"), base.CreateRandomWithoutNumbers(10));

		//Step 19 : Enter valid Extro Details and click on Save button
		//Expected : The valid Extro-Sub Header (medium Text) should be saved without any issues.
		base.setData(HighlightReelsObj.Ele_Subheader("details"), "extro details");
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"The valid Extro-Sub Header (medium Text) is not saved without any issues.");   

		Thread.sleep(30000);	

		//Step 20  : Click  Edit icon
		//Expected: User able to view Edit icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit")),"Unable to view Edit icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit"));

		//Step 21  : Verify that the Edit highlight reel page should be displayed when click on edit option against the highlight reel in the player page
		//Expected: The Edit highlight reel page should be displayed when click on edit option against the highlight reel in the player page
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips")),"Unable to view Edit Other details button");	  
		base.excuteJsClick(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Edit Hightlight Reel")),"Unable to view Hightlight Reel");	

		//Step 22 :  User can verify and select cancel button in edit highlight reels
		//Expected : User should able to select cancel button in edit highlight reels 
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-cancel-createhighlight")),"Unable to view cancel button");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-cancel-createhighlight"));
		

	}

	// <summary>
	// Test Case Title :"Verify that when click on save button the the highlight reels saved with the updated changes"
	// Automation ID   : HR_61
	// </summary>
	public void HR_61_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		DualView_Obj DualViewObj = new DualView_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
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
				
		//Step 4   :"Select a OrgName"				
		//Expected :"User should be navigated to OrgName list and select the OrgName"		
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);			
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));			
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected		
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 8:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 9:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 10: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 11: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));	
		
		//Step 12  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));	

		//Step 13 : click  My Highlight Reels + icon
		//Expected: User able to view My Highlight Reels + icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 14:To verify that highlight reels public checked or not 
		//Expected: Highlight reels set as public.
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.buttonClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(8));

		//Step 15 :To check and verify Generate default highlight reel checkbox is present or not
		//Expected: selected Generate default highlight reel checkbox is present or not
		asrt.assertTrue( base.isEnabledBy(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"user unable to select Generate default highlight reel");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));

		//Step 16:To check and verify Save option
		//Expected: selected save button in Generate default highlight reel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to select save option");
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));

		//Step 17:Click  Edit icon
		//Expected: User able to view Edit icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit")),"Unable to view Edit icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit"));

		//Step 18 : Verify that the Edit highligh reel page should be displayed when click on edit option against the highlight reel in the player page
		//Expected: The Edit highligh reel page should be displayed when click on edit option against the highlight reel in the player page
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips")),"Unable to view Edit Other details button");	  
		base.excuteJsClick(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Edit Hightlight Reel")),"Unable to view Hightlight Reel");

		//Step 19:To verify that SelectAll checked or not in HighLightReels
		//Expected: SelectAll checked in HighLightReels
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Select All","checkmark")),"user unable to change to SelectAll");
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Select All","checkmark"));

		//Step 20:Check and select No_Tag box
		//Expected: selected No_Tag box
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(DualViewObj.Ele_NoTag("allFrame")),"'NoTag Box' option is not displayed below video");
		base.scrollToElementtoCenter(DualViewObj.Ele_NoTag("allFrame"));
		base.excuteJsClick(DualViewObj.Ele_NoTag("allFrame"));

		//Step 21:To check and verify Save option
		//Expected: selected save button in Generate default highlight reel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to select save option");
		Thread.sleep(500);
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));

		//Step 22: To check Edit Highlight reel popup is displayed and edit 
		//Expected:Validate if the text message is "Are you sure.Do you want to edit this Highlight reel?"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to edit this Highlight reel?","\"Do you want to edit this Highlight reel?\" text is not matching");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")),"Unable to view Yes option to delete reel");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		
	}

	// <summary>
	// Test Case Title :"Verify that when click on Save as button another one copy of the highlight reel should be generated with the changes (eg: we can again give a new name and edit some of the snips)"
	// Automation ID   : HR_62
	// </summary>
	public void HR_62_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		DualView_Obj DualViewObj = new DualView_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
					
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
						
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		
		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 8:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 9:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 10: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 11: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));		
		
		//Step 12 :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));

		//Step 13 : click  My Hightlight Reels + icon
		//Expected: User able to view My Hightlight Reels + icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 14:To verify that highlight reels public checked or not 
		//Expected: Highlight reels set as public.
		Thread.sleep(1000);
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.buttonClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(8));

		//Step 15 :To check and verify Generate default highlight reel checkbox is present or not
		//Expected: selected Generate default highlight reel checkbox is present or not
		asrt.assertTrue( base.isEnabledBy(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"user unable to select Generate default highlight reel");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));

		//Step 16:To check and verify Save option
		//Expected: selected save button in Generate default highlight reel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to select save option");
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));

		//Step 17:Click  Edit icon
		//Expected: User able to view Edit icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit")),"Unable to view Edit icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit"));

		//Step 18  : Verify that the Edit highligh reel page should be displayed when click on edit option against the highlight reel in the player page
		//Expected: The Edit highligh reel page should be displayed when click on edit option against the highlight reel in the player page
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips")),"Unable to view Edit Other details button");	  
		base.excuteJsClick(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Edit Hightlight Reel")),"Unable to view Hightlight Reel");

		//Step 19:To verify that SelectAll checked or not in HighLightReels
		//Expected: SelectAll checked in HighLightReels
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Select All","checkmark")),"user unable to change to SelectAll");
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Select All","checkmark"));

		//Step 20:Check and select No_Tag box
		//Expected: selected No_Tag box
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(DualViewObj.Ele_NoTag("allFrame")),"'NoTag Box' option is not displayed below video");
		base.scrollToElementtoCenter(DualViewObj.Ele_NoTag("allFrame"));
		base.buttonClick(DualViewObj.Ele_NoTag("allFrame"));

		//Step 21:To check and verify SaveAs option
		//Expected: selected saveAs button in Generate default highlight reel
		Thread.sleep(500);
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-as-createhighlight")),"user unable to select saveAs option");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-as-createhighlight"));

		//Step 22: To check Edit Highlight reel popup is displayed and Save 
		//Expected:Validate if the text message is "Are you sure.Provide a new name for the highlight reel to proceed.?"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are You Sure");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Provide a new name for the highlight reel to proceed.?","\"Provide a new name for the highlight reel to proceed.?\" text is not matching");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")),"Unable to view Confirm option to delete reel");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));

		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(8));
		//Step 23:To check and verify Save option
		//Expected: selected save button in Generate default highlight reel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to select save option");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));

		//Step 24: To check Edit Highlight reel popup is displayed and Save 
		//Expected:Validate if the text message is "Are you sure.Provide a new name for the highlight reel to proceed.?"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to edit this Highlight reel?","\"Do you want to edit this Highlight reel?\" text is not matching");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")),"Unable to view 'Yes' option to delete reel");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		
	}

	// <summary>
	// Test Case Title :"Verify that proper message should be displayed when click on Save button and save as button"
	// Automation ID   : HR_63
	// </summary>
	public void HR_63_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		DualView_Obj DualViewObj = new DualView_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
	    base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 9:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 10:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 11: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 12: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));
		
		//Step 13  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));

		//Step 14 : click  My Highlight Reels + icon
		//Expected: User able to view My Highlight Reels + icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 15:To verify that highlight reels public checked or not 
		//Expected: Highlight reels set as public.
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.buttonClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(8));

		//Step 16 :To check and verify Generate default highlight reel checkbox is present or not
		//Expected: selected Generate default highlight reel checkbox is present or not
		asrt.assertTrue( base.isEnabledBy(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"user unable to select Generate default highlight reel");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));

		//Step 17:To check and verify Save option
		//Expected: selected save button in Generate default highlight reel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to select save option");
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));

		//Step 18:Click  Edit icon
		//Expected: User able to view Edit icon
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit")),"Unable to view Edit icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon","fa fa-edit"));

		//Step 19  : Verify that the Edit highlight reel page should be displayed when click on edit option against the highlight reel in the player page
		//Expected: The Edit highlight reel page should be displayed when click on edit option against the highlight reel in the player page
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips")),"Unable to view Edit Other details button");	  
		base.excuteJsClick(HighlightReelsObj.Btn_Edit("sb-non-list","Add/Remove Snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Edit Hightlight Reel")),"Unable to view Hightlight Reel");

		//Step 20:To verify that SelectAll checked or not in HighLightReels
		//Expected: SelectAll checked in HighLightReels
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Select All","checkmark")),"user unable to change to SelectAll");
		base.buttonClick(HighlightReelsObj.Chk_HighlightReelsPublic("Select All","checkmark"));

		//Step 21:Check and select No_Tag box
		//Expected: selected No_Tag box
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(DualViewObj.Ele_NoTag("allFrame")),"'NoTag Box' option is not displayed below video");
		base.scrollToElementtoCenter(DualViewObj.Ele_NoTag("allFrame"));
		base.buttonClick(DualViewObj.Ele_NoTag("allFrame"));

		//Step 22:To check and verify SaveAs option
		//Expected: selected saveAs button in Generate default highlight reel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-as-createhighlight")),"user unable to select saveAs option");
		Thread.sleep(500);    
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-as-createhighlight"));

		//Step 23: To check Edit Highlight reel popup is displayed and Save 
		//Expected:Validate if the text message is "Are you sure.Provide a new name for the highlight reel to proceed.?"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are You Sure");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Provide a new name for the highlight reel to proceed.?","\"Provide a new name for the highlight reel to proceed.?\" text is not matching");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")),"Unable to view Confirm option to delete reel");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));

		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(8));
		//Step 24:To check and verify Save option
		//Expected: selected save button in Generate default highlight reel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to select save option");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));

		//Step 25: To check Edit Highlight reel popup is displayed and Save 
		//Expected:Validate if the text message is "Are you sure.Provide a new name for the highlight reel to proceed.?"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to edit this Highlight reel?","\"Do you want to edit this Highlight reel?\" text is not matching");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")),"Unable to view 'Yes' option to delete reel");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		
	}

	// <summary>
	// Test Case Title :"Verify that there should be a download icon against the reel to download the reels"
	// Automation ID   : HR_64
	// </summary>
	public void HR_64_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		DualView_Obj DualViewObj = new DualView_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
				
		//Step 9:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 10:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 11: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 12: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));
		
		//Step 13  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));

		//Step 14 : click  My Highlight Reels + icon
		//Expected: User able to view My Hightlight Reels + icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 15:To verify that highlight reels public checked or not 
		//Expected: Highlight reels set as public.
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.buttonClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(8));

		//Step 16 :To check and verify Generate default highlight reel checkbox is present or not
		//Expected: selected Generate default highlight reel checkbox is present or not
		asrt.assertTrue( base.isEnabledBy(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"user unable to select Generate default highlight reel");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));

		//Step 17:To check and verify Save option
		//Expected: selected save button in Generate default highlight reel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to select save option");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));

		//Step 18:Verify  download icon
		//Expected: User able to view Download icon
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon popup-btn-download-hightlight","bx bxs-download")),"Unable to view Download icon");	   		    
		
	}
	// <summary>
	// Test Case Title :"Verify that with Music and Without Music option should be displayed when click on download icon
	// Automation ID   : HR_65
	// </summary>
	public void HR_65_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		DualView_Obj DualViewObj = new DualView_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
				
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 9:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 10:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 11: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 12: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));		
				
		//Step 13  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
	    base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));

		//Step 14 : click  My Hightlight Reels + icon
		//Expected: User able to view My Hightlight Reels + icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 15:To verify that highlight reels public checked or not 
		//Expected: Highlight reels set as public.
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.buttonClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(8));

		//Step 16 :To check and verify Generate default highlight reel checkbox is present or not
		//Expected: selected Generate default highlight reel checkbox is present or not
		asrt.assertTrue( base.isEnabledBy(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"user unable to select Generate default highlight reel");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));

		//Step 17:To check and verify Save option
		//Expected: selected save button in Generate default highlight reel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to select save option");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));

		//Step 18:Verify view and select download icon
		//Expected: User able to view and select Download icon
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon popup-btn-download-hightlight","bx bxs-download")),"Unable to view Download icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon popup-btn-download-hightlight","bx bxs-download"));	   		    

		//Step 19:Check and verify WithMusic,WithoutMusic option present or not
		//Expected: WithMusic,WithoutMusic option is present
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-downloadmusicfile")),"user unable to view WithMusic option");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-downloadNomusicfile")),"user unable to view WithoutMusic option");
		
				
	}

	// <summary>
	// Test Case Title :"Verify that when click on Without music the reels should be downloaded without music"
	// Automation ID   : HR_67
	// </summary>
	public void HR_67_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardAndReelsTestData = new WhiteboardAndReels_TestData();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 9:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 10:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 11: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 12: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));
		
		//Step 13  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));
		
		//Step 14 : click  My Highlight Reels + icon
		//Expected: User able to view My Highlight Reels + icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 15:To verify that highlight reels public checked or not 
		//Expected: Highlight reels set as public.
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.buttonClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(8));

		//Step 16 :To check and verify Generate default highlight reel checkbox is present or not
		//Expected: selected Generate default highlight reel checkbox is present or not
		asrt.assertTrue( base.isEnabledBy(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"user unable to select Generate default highlight reel");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));

		//Step 17:To check and verify Save option
		//Expected: selected save button in Generate default highlight reel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to select save option");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		Thread.sleep(20000);
		
		//Step 18 : Click on Download Icon
		//Expected : User should be able to see the two options(with music & without music)
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("reel-icon popup-btn-download-hightlight")),"User is not able to view the download icon");
		base.buttonClick(LoginPageObj.Btn_LoginButton("reel-icon popup-btn-download-hightlight"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-downloadmusicfile")),"user is not able to view the with music option to download");	    
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-downloadNomusicfile")),"user is not able to view the without music option to download");		    
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-downloadNomusicfile"));

	} 
	// <summary>
	// Test Case Title :"Verify that when click on share button, with music and without music option should be displayed to share the highlight reels"
	// Automation ID   : HR_69
	// </summary>
	public void HR_69_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		WhiteboardAndReels_TestData WhiteboardAndReelsTestData = new WhiteboardAndReels_TestData();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 9  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));

		//Step 10:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 11:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
						
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 12: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		Thread.sleep(5000);	
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 13: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));

		//Step 14 : click  My Hightlight Reels + icon
		//Expected: User able to view My Hightlight Reels + icon
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));

		//Step 15:To verify that highlight reels public checked or not 
		//Expected: Highlight reels set as public.
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.buttonClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(8));

		//Step 16 :To check and verify Generate default highlight reel checkbox is present or not
		//Expected: selected Generate default highlight reel checkbox is present or not
		asrt.assertTrue( base.isEnabledBy(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"user unable to select Generate default highlight reel");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));

		//Step 17:To check and verify Save option
		//Expected: selected save button in Generate default highlight reel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to select save option");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		Thread.sleep(20000);

		//Step 18 : Click on Share Icon
		//Expected : When click on share button, with music and without music option should be displayed to share the highlight reels
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon btn-share-reel","fa fa-share")),"Unable to view My Hightlight Reels + icon");	   		    
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("reel-icon btn-share-reel","fa fa-share"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("With Music")),"user is not able to view the with music option to share");	    
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("no-padd-top-bottom withoutaudio-block video-section-non-active")),"user is not able to view the without music option to share");		    

	}  
	
	// <summary>
	// Test Case Title :"To verify what happens when user enter a Invalid name"
	// Automation ID   : HR_06 
	// </summary>
	public void HR_06_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		
		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		
		//Step 9  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		
		//Step 10  : click  My Highlight Reels + icon
		//Expected: User able to view My Highlight Reels + icon
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		
		//Step 11  :Click Public/ Private
		//Expected:  user able to change to Public
		base.buttonClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));

		//Step 12  :To verify what happens when user enter a Invalid name
		//Expected:The user should get a ERROR popup message that"Allowed characters a-z 0-9,.-@?!#$%&:"	    
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),HighlightReelsTestData.HR_06_TestData);	 

		//Step 13 :Click the checkbox Generate default highlight reel
		//Expected:User able to select checkbox Generate default highlight reel
		asrt.assertTrue( base.isEnabledBy(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"User unable to Click the checkbox Generate default highlight reel");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));

		//Step 14 :User able to verify popup showing as "Allowed characters a-z 0-9,.-@?!#$%&:" 
		//Expected:"Allowed characters a-z 0-9,.-@?!#$%&:" showing
		Thread.sleep(5000);	
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Error");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Allowed characters a-z 0-9,.-@?!#$%&:","\"Allowed characters a-z 0-9,.-@?!#$%&:\" text is not matching");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user leave the Highlight Reels name empty"
	// Automation ID   : HR_07
	// </summary>
	public void HR_07_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		
		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		
		//Step 9  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		//js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		
		//Step 10  : click  My Hightlight Reels + icon
		//Expected: User able to view My Hightlight Reels + icon
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		
		//Step 11  :To verify what happens when user click on the Generate default highlight reel checkbox
		//Expected:When the user click the "Generate Default Highlight Reel" checkbox, the system should enable the feature to generate a default highlight reel.	    
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		asrt.assertTrue( base.isEnabledBy(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"User unable to Click the checkbox Generate default highlight reel");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to select save option");
		
		//Step 12:To check and verify Save option
		//Expected: selected save button in Generate default highlight reel
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		Thread.sleep(5000);	
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Error");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Please enter the highlightreel name","\"Please enter the highlightreel name\" text is not matching");

	} 

	// <summary>
	// Test Case Title :"To verify what happens when user click on the Generate default highlight reel checkbox"
	// Automation ID   : HR_08
	// </summary>
	public void HR_08_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		
		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		
		//Step 9  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		
		//Step 10:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		
		//Step 11:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");			
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 12: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		
		//Step 13: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		
		//Step 14  : click  My Hightlight Reels + icon
		//Expected: User able to view My Hightlight Reels + icon
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		
		//Step 15  :To verify what happens when user click on the Generate default highlight reel checkbox
		//Expected:When the user click the "Generate Default Highlight Reel" checkbox, the system should enable the feature to generate a default highlight reel.	    
		base.buttonClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(5));
		asrt.assertTrue( base.isEnabledBy(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"User unable to Click the checkbox Generate default highlight reel");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to select save option");
		
		//Step 16:To check and verify Save option
		//Expected: selected save button in Generate default highlight reel
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		Thread.sleep(20000);
		
		
	}  

	// <summary>
	// Test Case Title :"Verify that when click on share option, social media icons are also displayed to share the reels via social meidas"
	// Automation ID   : HR_72
	// </summary>
	public void HR_72_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 9:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 10:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 11: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 12: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));
		
		//Step 13 :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 14 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 15 : To click on Public/Private
		//Expected : User should be able to mark any one of them
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		base.excuteJsClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));

		//Step 16 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_72_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_72_TestData, "User not able to enter the highlightreel name");

		//Step 17 : Click the checkbox Generate default highlight reel
		//Expected : User should be able to mark the checkbox    
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"user is not able to mark the checkbox");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));

		//Step 18 : Click Save button
		//Expected : User should be able to create a highlightreel
		asrt.assertTrue( base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"user unable to change to Public");
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		Thread.sleep(30000);

		//Step 19 : Click on Share Icon
		//Expected : User should be able to see the share options
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("reel-icon btn-share-reel")),"User is not able to view the Share icon");
		base.buttonClick(LoginPageObj.Btn_LoginButton("reel-icon btn-share-reel"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("snipback-share-twitter"," img-thumbnail fab fa-twitter fa-2x")),"User is not able to view the 'Twitter' icon");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("snipback-share-facebook","img-thumbnail fab fa-facebook fa-2x")),"User is not able to view the 'Facebook' icon");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("snipback-share-whatsapp","img-thumbnail fab fa-whatsapp fa-2x")),"User is not able to view the 'Whatsapp' icon");

		//driver.navigate().refresh();    	
	}

	// <summary>
	// Test Case Title :"To verify what happens when user leave the Extro Header (Large Text) empty"
	// Automation ID   : HR_54
	// </summary>
	public void HR_54_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();	
		HighlightReels_Obj HighlightReels_Obj =new HighlightReels_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
	
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		
		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));				
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 8:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 9:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 10: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 11: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));
		
		
		//Step 12  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 13 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 14 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_54_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_54_TestData, "User not able to enter the highlightreel name");

		//Step 15 : Click Title Slide Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 16 : To enter the IntroSlide
		//Expected : The user should be able to enter the Intro Text
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the IntroSlide textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_54_IntroSlideText);
		String InvalidIntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(5000);
		asrt.assertEquals(InvalidIntroSlideText, HighlightReelsTestData.HR_54_IntroSlideText, "User is not able to enter the IntroSlidetext in highlightReels");

		//Step 17 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_54_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText, HighlightReelsTestData.HR_54_ExtroHeader, "User not able to enter the ExtroHeader");

		//Step 18 : To enter the ExtroSubHeader
		//Expected : The user should be able to enter the ExtroSubHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2")),"User is not able to view the ExtroSubHeader textbox in highlightreels");   
		base.setData(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2"), HighlightReelsTestData.HR_54_ExtroSubHeader);
		String ExtroSubHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroSubHeaderText, HighlightReelsTestData.HR_54_ExtroSubHeader, "User is not able to enter the ExtroSubHeader in Hightlightreels");

		//Step 19 : To enter the ExtroDetails
		//Expected : The user should be able to enter the ExtroDetails.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3")),"User is not able to view the ExtroDetails textbox in highlightreels");   
		base.setData(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3"), HighlightReelsTestData.HR_54_ExtroDetails);
		String ExtroDetailsText = base.GetValue(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroDetailsText, HighlightReelsTestData.HR_54_ExtroDetails, "User is not able to enter the ExtroDetails in Hightlightreels");

		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-save-createhighlight","Save")),"The Save button is not displayed in the highlightreel popup in player page.");		
		base.buttonClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-save-createhighlight","Save"));
		Thread.sleep(30000);		
	
	}

	// <summary>
	// Test Case Title :"Verify that the entire highlight reel popup should be closed when click on Cancel button"
	// Automation ID   : HR_55
	// </summary>
	public void HR_55_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
	
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		
		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReelsObj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		
		//Step 8  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 9 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 10 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_55_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_55_TestData, "User not able to enter the highlightreel name");

		//Step 11 : Click Title Slide Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 12 : To enter the IntroSlide
		//Expected : The user should be able to enter the Intro Text
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the IntroSlide textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_55_IntroSlideText);
		String InvalidIntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(5000);
		asrt.assertEquals(InvalidIntroSlideText, HighlightReelsTestData.HR_55_IntroSlideText, "User is not able to enter the IntroSlidetext in highlightReels");

		//Step 13 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_55_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText, HighlightReelsTestData.HR_55_ExtroHeader, "User not able to enter the ExtroHeader");

		//Step 14 : To enter the ExtroSubHeader
		//Expected : The user should be able to enter the ExtroSubHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2")),"User is not able to view the ExtroSubHeader textbox in highlightreels");   
		base.setData(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2"), HighlightReelsTestData.HR_55_ExtroSubHeader);
		String ExtroSubHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroSubHeaderText, HighlightReelsTestData.HR_55_ExtroSubHeader, "User is not able to enter the ExtroSubHeader in Hightlightreels");

		//Step 15 : To enter the ExtroDetails
		//Expected : The user should be able to enter the ExtroDetails.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3")),"User is not able to view the ExtroDetails textbox in highlightreels");   
		base.setData(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3"), HighlightReelsTestData.HR_55_ExtroDetails);
		String ExtroDetailsText = base.GetValue(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroDetailsText, HighlightReelsTestData.HR_55_ExtroDetails, "User is not able to enter the ExtroDetails in Hightlightreels");

		//Step 16 : Click on the Cancel button
		//Expected : The entire highlight reel popup should be closed when click on Close button
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-cancel-createhighlight","Cancel")),"The Save button is not displayed in the highlightreel popup in player page.");		
		base.buttonClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-cancel-createhighlight","Cancel"));
		Thread.sleep(5000);	
	}

	// <summary>
	// Test Case Title :"Verify that the following option should be displayed after we click on save button; 1.Edit 2.Download 3.Share 4.Delete"
	// Automation ID   : HR_56
	// </summary>
	public void HR_56_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
	
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		
		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 8:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 9:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 10: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"	
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 11: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));
		
		//Step 12  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
        base.setZoom(driver, 82);
		//Step 13 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 14 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_56_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_56_TestData, "User not able to enter the highlightreel name");

		//Step 15 : Click Title Slide Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");
		
		//Step 16 : To enter the IntroSlide
		//Expected : The user should be able to enter the Intro Text
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the IntroSlide textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_56_IntroSlideText);
		String InvalidIntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(5000);
		asrt.assertEquals(InvalidIntroSlideText, HighlightReelsTestData.HR_56_IntroSlideText, "User is not able to enter the IntroSlidetext in highlightReels");

		//Step 17 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_56_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText, HighlightReelsTestData.HR_56_ExtroHeader, "User not able to enter the ExtroHeader");

		//Step 18 : To enter the ExtroSubHeader
		//Expected : The user should be able to enter the ExtroSubHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2")),"User is not able to view the ExtroSubHeader textbox in highlightreels");   
		base.setData(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2"), HighlightReelsTestData.HR_56_ExtroSubHeader);
		String ExtroSubHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroSubHeader("sub-header","floatingTextarea2"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroSubHeaderText, HighlightReelsTestData.HR_56_ExtroSubHeader, "User is not able to enter the ExtroSubHeader in Hightlightreels");

		//Step 19 : To enter the ExtroDetails
		//Expected : The user should be able to enter the ExtroDetails.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3")),"User is not able to view the ExtroDetails textbox in highlightreels");   
		base.scrollUp(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3"), HighlightReelsTestData.HR_56_ExtroDetails);
		String ExtroDetailsText = base.GetValue(HighlightReelsObj.Ele_ExtroSubHeader("details","floatingTextarea3"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroDetailsText, HighlightReelsTestData.HR_56_ExtroDetails, "User is not able to enter the ExtroDetails in Hightlightreels");

		//Step 20 : Click on the Save button
		//Expected : User should be able to save the highlight reels
		base.scrollToElement(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-save-createhighlight","Save"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-save-createhighlight","Save")),"The Save button is not displayed in the highlightreel popup in player page.");		
		//base(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-save-createhighlight","Save"));)
		base.buttonClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-save-createhighlight","Save"));
		Thread.sleep(30000);		
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText(HighlightReelsTestData.HR_56_TestData)),"User is not able to save highlightReels");	

		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Delete("reel-icon","Edit")),"User is not able to view the Edit icon");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("reel-icon popup-btn-download-hightlight")),"User is not able to view the download icon");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("reel-icon btn-share-reel")),"User is not able to view the Share icon");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Delete("reel-icon","Delete")),"User is not able to view the Delete icon");
		
	}


	// <summary>
	// Test Case Title :"To verify that we what happens we select a valid image less than 2mb"
	// Automation ID   : HR_20
	// </summary>
	public void HR_20_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		TrimVideo_Obj TrimVideoObj=new TrimVideo_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		HighlightReels_TestData HighlightReelsTestData=new HighlightReels_TestData(); 
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		Thread.sleep(4000);
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
				
		// Step 5:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);

		// Step 6:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7:click on search button and search for team name Backup Team
		//Expected:Backup team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), HighlightReelsTestData.HR_20_teamName);

		//Step 8:Selecting the team
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",HighlightReelsTestData.HR_20_teamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",HighlightReelsTestData.HR_20_teamName)), "Failed to select TEAM");
		Thread.sleep(5000);

		//Step 9  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		// Step 10: Switching to window
		// Expected : Verify  "HIGHLIGHTS & WHITEBOARDS" is visible in right side  
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_selectteam("hightlight-popup-button")),"User is not able to view 'HIGHLIGHTS & WHITEBOARDS' button");
		Thread.sleep(2000);	

		//Step 11  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 12 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the private radio button
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(6000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Chk_PrivateRadioButton("newhighlightradiotwo","span","checkmark")),"User is not able to view the private option radio button");

		//Step 13: click on private Radio button
		base.buttonClick(HighlightReelsObj.Chk_PrivateRadioButton("newhighlightradiotwo","span","checkmark"));

		//Step 14: Enter name in HighlightReel Name text input box
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),HighlightReelsTestData.HR_19_highlightReelName);

		//Step 15: Select  "Title Slider" Design dropdown
		String defaultOptionInDropDown=base.getTheSelectedTextInDropDown(By.id("select-theme"));
		List<WebElement> listOfOptions=base.getTheAllOptions(By.id("select-theme"));
		for(WebElement element:listOfOptions) {
			if(!element.getText().equals(defaultOptionInDropDown)) {
				base.selectorByVisibleText(By.id("select-theme"), element.getText());
				break;
			}
		}

		//Step 16:Verifying if the dropdown option has been changed 
		//Expected:dropdown option selected
		String updatedOptionInDropDown=base.getTheSelectedTextInDropDown(By.id("select-theme")); 
		asrt.assertNotEquals(defaultOptionInDropDown,updatedOptionInDropDown,"the selected Snipback Drop down is not shown and dropdown is not getting selected");

		//Step 17:Scroll to LOGO ? and mouse hover on the ? 
		// Expected:The user should be able to see the "JPG or PNG or format and less than 2MB in size".
		asrt.assertTrue(base.isExists(HighlightReelsObj.Img_Logo("LOGO","fa fa-question-circle fa-4")),"LOGO ? image is not displayed");
		base.scrollToElementtoCenter(HighlightReelsObj.Img_Logo("LOGO","fa fa-question-circle fa-4"));
		// base.excuteJsClick(LoginPageObj.Edt_LoginEmail("upload-logo"));

		//Step 18: click on the Choose File icon, Verify that the file is mp4 or mov
		//Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir")+ "/Utils/Img_Logo/imagelessthan2mb.jpg";
		List<String> allowedTypes = Arrays.asList(".jpg", ".jpeg",".png");
		// Choose the file

		base.uploadFile(LoginPageObj.Edt_LoginEmail("upload-logo"), videoFilePath, allowedTypes);
		String uploadedFileExtension = videoFilePath.substring(videoFilePath.lastIndexOf("."));
		asrt.assertTrue(allowedTypes.contains(uploadedFileExtension),"Invalid file type uploaded: " + uploadedFileExtension);
		String actualImagePath =base.GetAttribte(LoginPageObj.Edt_LoginEmail("upload-logo"), "value");
		// System.out.println(base.GetAttribte(LoginPageObj.Edt_LoginEmail("upload-logo"), "value"));//C:\fakepath\imagelessthan2mb.jpg
		asrt.assertTrue(actualImagePath.contains("imagelessthan2mb.jpg"), "Failed to update image in Logo");
	}	

	// <summary>
	// Test Case Title :"To verify that we what happens we select a image Greater than 2mb"
	// Automation ID   : HR_21
	// </summary>
	public void HR_21_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		TrimVideo_Obj TrimVideoObj=new TrimVideo_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		HighlightReels_TestData HighlightReelsTestData=new HighlightReels_TestData(); 
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		Thread.sleep(4000);
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");	

		// Step 5:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);

		// Step 6:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7:click on search button and search for team name Backup team
		//Expected:backup team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), HighlightReelsTestData.HR_21_teamName);

		//Step 8:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",HighlightReelsTestData.HR_21_teamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",HighlightReelsTestData.HR_21_teamName)), "Failed to select TEAM");
		Thread.sleep(5000);

		//Step 9  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		// Step 10: Switching to window
		// Expected : Verify  "HIGHLIGHTS & WHITEBOARDS" is visible in right side  
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_selectteam("hightlight-popup-button")),"User is not able to view 'HIGHLIGHTS & WHITEBOARDS' button");
		Thread.sleep(2000);	

		//Step 11  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 12 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the private radio button
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(6000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Chk_PrivateRadioButton("newhighlightradiotwo","span","checkmark")),"User is not able to view the private option radio button");

		//Step 13: click on private Radio button
		base.buttonClick(HighlightReelsObj.Chk_PrivateRadioButton("newhighlightradiotwo","span","checkmark"));

		//Step 14: Enter name in HighlightReel Name text input box
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),HighlightReelsTestData.HR_19_highlightReelName);

		//Step 15: Select  "Title Slider" Design dropdown
		String defaultOptionInDropDown=base.getTheSelectedTextInDropDown(By.id("select-theme"));
		List<WebElement> listOfOptions=base.getTheAllOptions(By.id("select-theme"));
		for(WebElement element:listOfOptions) {
			if(!element.getText().equals(defaultOptionInDropDown)) {
				base.selectorByVisibleText(By.id("select-theme"), element.getText());
				break;
			}
		}

		//Step 16:Verifying if the dropdown option has been changed 
		String updatedOptionInDropDown=base.getTheSelectedTextInDropDown(By.id("select-theme")); 
		asrt.assertNotEquals(defaultOptionInDropDown,updatedOptionInDropDown,"the selected Snipback Drop down is not shown and dropdown is not getting selected");

		//Step 17:Scroll to LOGO ? and mouse hover on the ? 
		// Expected:The user should be able to see the "JPG or PNG or format and less than 2MB in size".
		asrt.assertTrue(base.isExists(HighlightReelsObj.Img_Logo("LOGO","fa fa-question-circle fa-4")),"LOGO ? image is not displayed");
		base.scrollToElementtoCenter(HighlightReelsObj.Img_Logo("LOGO","fa fa-question-circle fa-4"));
		// base.excuteJsClick(LoginPageObj.Edt_LoginEmail("upload-logo"));

		//Step 18: click on the Choose File icon, Verify that the file is mp4 or mov
		//Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir")+ "/Utils/Img_Logo/imagegreaterthan2mb.jpg";
		List<String> allowedTypes = Arrays.asList(".jpg");
		// Choose the file

		base.uploadFile(LoginPageObj.Edt_LoginEmail("upload-logo"), videoFilePath, allowedTypes);//Ele_ErrorMessage

		String actualErrorMessage =base.GetText(LoginPageObj.Ele_ErrorMessage("swal-text"));
		// System.out.println(base.GetAttribte(LoginPageObj.Edt_LoginEmail("upload-logo"), "value"));//C:\fakepath\imagelessthan2mb.jpg
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")), "Error: File with greater then 2mb has been uploaded");
		asrt.assertEquals(actualErrorMessage, "Invalid file size, please select a file less than 2mb","Error: File with greater then 2mb has been uploaded");

	}	

	// <summary>
	// Test Case Title :"Verify that when we click on delete button the highlight reel should be deleted from the highlight reels list"
	// Automation ID   : HR_68
	// </summary>
	public void HR_68_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		TrimVideo_Obj TrimVideoObj=new TrimVideo_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		HighlightReels_TestData HighlightReelsTestData=new HighlightReels_TestData(); 
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		Thread.sleep(4000);
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 9:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 10:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"'My Snips' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//Step 11: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 12: Click on 'Snip'
		//Expected:"User should able to select 'Snip'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));

		// Step 13: Switching to window
		// Expected : Verify  "HIGHLIGHTS & WHITEBOARDS" is visible in right side  
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_selectteam("hightlight-popup-button")),"User is not able to view 'HIGHLIGHTS & WHITEBOARDS' button");
		Thread.sleep(2000);	

		//Step 14  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		base.setZoom(driver, 50);

		//Step 15 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the private radio button
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(6000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Chk_PrivateRadioButton("newhighlightradiotwo","span","checkmark")),"User is not able to view the private option radio button");

		//Step 16: click on private Radio button
		base.excuteJsClick(HighlightReelsObj.Chk_PrivateRadioButton("newhighlightradiotwo","span","checkmark"));

		//Step 17: Enter name in HighlightReel Name text input box
		// Expected:General Default Highlight Reel Checkbox displayed
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),HighlightReelsTestData.HR_68_highlightReelName);
		String hightLightReelName=base.GetAttribte(LoginPageObj.Edt_LoginEmail("reelname"),"value");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"General Default Highlight Reel Checkbox is not displayed");

		//Step 18: click on General Default Highlight Reel Checkbox
		//Expected:save button is displayed
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")),"Save button is not displayed");

		//Step 19: click on Save button 
		//Expected:Delete button icon is displayed
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		Thread.sleep(60000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_SnipDisable("Delete")),"Delete icon is not displayed below My Highlight reels");

		//Step 20: click on Delete icon
		//Expected:Delete button icon is displayed
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_SnipDisable("Delete"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_SnipDisable("Delete")),"Delete icon is not displayed below My Highlight reels");

		//Step 21: click on OK button
		//Expected:Highlight reel is deleted after clicking delete icon
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		Thread.sleep(2000);
		//base.isDoesNotExist(LoginPageObj.Ele_ErrorMessage("title"),"created highlight reel is not deleted after clicking delete icon");

	}
	
	// <summary>
	// Test Case Title :"To verify what happens when user enter a Valid name"
	// Automation ID   : HR_05
	// </summary>
	public void HR_05_HighlightReels() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		HighlightReels_Obj HighlightReelsObj =new HighlightReels_Obj();
		EditSnip_Obj EditSnipObj=new EditSnip_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :Click on HIGHLIGHTS
		//Expected:The User should able to view the HIGHLIGHTS
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute JavaScript to set zoom level to 80%
		js.executeScript("document.body.style.zoom = '50%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS")),"Unable to find the HIGHLIGHTS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","HIGHLIGHTS"));		
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus")),"Unable to view My Hightlight Reels + icon");	   		    
		
		//Step 10  : click  My Hightlight Reels + icon
		//Expected: User able to view My Hightlight Reels + icon
		base.excuteJsClick(HighlightReelsObj.Ele_HighlightReelsPlus("plusbtn add-my-hightlight-reel","fa fa-plus"));
		asrt.assertTrue( base.isEnabledBy(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark")),"user unable to change to Public");
		
		//Step 11  :Click Public/ Private
		//Expected:  user able to change to Public
		base.buttonClick(HighlightReelsObj.Chk_HighlightReelsPublic("Public","checkmark"));

		//Step 12  :Enter a valid Name and Click the checkbox Generate default highlight reel
		//Expected:User able to select checkbox Generate default highlight reel
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),base.CreateRandomWithoutNumbers(5));
		String Expected= base.GetText(LoginPageObj.Edt_LoginEmail("reelname"));
		System.out.println(Expected);
		asrt.assertTrue( base.isEnabledBy(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel")),"User unable to Click the checkbox Generate default highlight reel");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("is_default_highlight_reel"));

		//Step13 :Click SAVE
		//Expected:  The valid name should be saved without any issues.
		//base.buttonClick(EditSnipObj.Btn_Done("add-hightlightreel-block","Save"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		Thread.sleep(20000);
		
	} 

	// <summary>
	// Test Case Title :"To verify what happens when user enter a Extro Header (Large Text)"
	// Automation ID   : HR_22
	// </summary>
	public void HR_22_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		DuplicateSnip_Obj DuplicateSnipObj=new DuplicateSnip_Obj();
		CommonData commonData = new CommonData();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		TrimVideo_Obj TrimVideoObj=new TrimVideo_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj(); 
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		//Step 1  :"Login to snipback "
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
				
		base.switchToWindowByIndex(driver, 1);
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 9 :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 10 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 11 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),HighlightReelsTestData.HR_22ExtroHeader);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(3000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_22ExtroHeader, "User not able to enter the highlightreel name");

		//Step 12 : To enter a Valid Intro Slide Text
		//Expected : The user should able to enter a Valid Intro Slide Text"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the InvalidIntroSlideText textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_22IntroSlideText);
		String IntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(2000);
		asrt.assertEquals(IntroSlideText, HighlightReelsTestData.HR_22IntroSlideText, "User not able to enter the Valid Intro Slide Text name");

		//Step 13 : Enter Extro Sub-header
		//Expected : The user should able to enter Enter Extro Sub-header
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2")),"User is not able to view the Extro Sub-header textbox");   
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2"), HighlightReelsTestData.HR_22ExtroSubHeader);
		String ExtroSubheader = base.GetValue(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2"));
		Thread.sleep(2000);
		asrt.assertEquals(ExtroSubheader,HighlightReelsTestData.HR_22ExtroSubHeader, "User not able to enter the ExtroHeader");
		Thread.sleep(2000);
		
		//Step 14 : Enter Extro Details
		//Expected : The user should able to enter Enter Extro Details
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2")),"User is not able to view the Extro Details textbox");   
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea3"), HighlightReelsTestData.HR_22ExtroDetails);
		String ExtroDetails = base.GetValue(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea3"));
		Thread.sleep(2000);
		asrt.assertEquals(ExtroDetails,HighlightReelsTestData.HR_22ExtroDetails, "User not able to enter the ExtroDetails");

		//Step 15: Enter the Invalid Extro Header
		//Expected : The user should able to enter a Invalid Extro Header"
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_22InvalidExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		asrt.assertEquals(ExtroHeaderText,HighlightReelsTestData.HR_22InvalidExtroHeader, "User not able to enter the ExtroHeader");
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HRSave("display: none;","Save")),"User is not able to view Save button");        
		
		//Bug --invalid extro header After a click throwing the error message

		//Step 16 : Click SAVE
		//Expected :The user should get a ERROR popup message that"Allowed characters a-z 0-9,.-@?!#$%&:
		base.excuteJsClick(HighlightReelsObj.Btn_HRSave("display: none;","Save"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Allowed characters a-z 0-9,.-@?!#$%&:")),"The user should not get a ERROR popup message that\"Allowed characters a-z 0-9,.-@?!#$%&:");

	}

	// <summary>
	// Test Case Title :"To verify that what happens when a user type more than 25 characters Extro Header (Large Text)"
	// Automation ID   : HR_25
	// </summary>
	public void HR_25_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		DuplicateSnip_Obj DuplicateSnipObj=new DuplicateSnip_Obj();
		CommonData commonData = new CommonData();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		Thread.sleep(4000);
		
		//Step 1  :"Login to snipback "
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		//Step 2   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 3   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 4   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 5  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		base.switchToWindowByIndex(driver, 1);
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 6 :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 7 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 8 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),HighlightReelsTestData.HR_25ExtroHeader );
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(3000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_25ExtroHeader, "User not able to enter the highlightreel name");

		//Step 9 : To enter a Valid Intro Slide Text
		//Expected : The user should able to enter a Valid Intro Slide Text"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the InvalidIntroSlideText textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_25IntroSlideText);
		String IntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(5000);
		asrt.assertEquals(IntroSlideText, HighlightReelsTestData.HR_25IntroSlideText, "User not able to enter the Valid Intro Slide Text name");

		//Step 10 : Enter Extro Sub-header
		//Expected : The user should able to enter Enter Extro Sub-header
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2")),"User is not able to view the Extro Sub-header textbox");   
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2"), HighlightReelsTestData.HR_25ExtroSubHeader);
		String ExtroSubheader = base.GetValue(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2"));
		Thread.sleep(2000);
		asrt.assertEquals(ExtroSubheader,HighlightReelsTestData.HR_25ExtroSubHeader, "User not able to enter the ExtroHeader");
		Thread.sleep(2000);

		//Step 11 : Enter Extro Details
		//Expected : The user should able to enter Enter Extro Details
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2")),"User is not able to view the Extro Details textbox");   
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea3"), HighlightReelsTestData.HR_25ExtroDetails);
		String ExtroDetails = base.GetValue(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea3"));
		Thread.sleep(2000);
		asrt.assertEquals(ExtroDetails,HighlightReelsTestData.HR_25ExtroDetails, "User not able to enter the ExtroDetails");

		//Step 12 : Type a Extro Header (Large Text) with 25 characters
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"),HighlightReelsTestData.HR25_ExtroHeaderChar);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		asrt.assertEquals(ExtroHeaderText,"HRTC25HIGHLIGHTREELWITHMO","The input field should not restrict further input and allow allow typing beyond 25 characters in Extro Header");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user enter invalid Extro Header (Large Text)"
	// Automation ID   : HR_26
	// </summary>
	public void HR_26_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		DuplicateSnip_Obj DuplicateSnipObj=new DuplicateSnip_Obj();
		CommonData commonData = new CommonData();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		//Step 1  :"Login to snipback "
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		//Step 2   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 3   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 4   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 5  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		base.switchToWindowByIndex(driver, 1);
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 6 :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 7 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 8 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),HighlightReelsTestData.HR_26ExtroHeader );
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(3000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_26ExtroHeader, "User not able to enter the highlightreel name");

		//Step 9 : To enter a Valid Intro Slide Text
		//Expected : The user should able to enter a Valid Intro Slide Text"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the InvalidIntroSlideText textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_26IntroSlideText);
		String IntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(2000);
		asrt.assertEquals(IntroSlideText, HighlightReelsTestData.HR_26IntroSlideText, "User not able to enter the Valid Intro Slide Text name");

		//Step 10: Enter the Valid Extro Header
		//Expected : The user should able to enter a Invalid Extro Header"
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_26ValidExtroHeader);
		String ValidExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		asrt.assertEquals(ValidExtroHeaderText,HighlightReelsTestData.HR_26ValidExtroHeader, "User not able to enter the ExtroHeader");

		//Step 11 : Enter Extro Details
		//Expected : The user should able to enter Enter Extro Details
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2")),"User is not able to view the Extro Details textbox");   
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea3"), HighlightReelsTestData.HR_22ExtroDetails);
		String ExtroDetails = base.GetValue(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea3"));
		Thread.sleep(2000);
		asrt.assertEquals(ExtroDetails,HighlightReelsTestData.HR_22ExtroDetails, "User not able to enter the ExtroDetails");

		//Step 12 : Enter Invalid Extro Sub-header
		//Expected : The user should able to enter Enter Invalid Extro Sub-header
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2")),"User is not able to view the Extro Sub-header textbox");   
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2"), HighlightReelsTestData.HR_26InvalidExtroSubHeader);
		String ExtroSubheader = base.GetValue(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2"));
		Thread.sleep(2000);
		asrt.assertEquals(ExtroSubheader,HighlightReelsTestData.HR_26InvalidExtroSubHeader, "User not able to enter the Invalid ExtroHeader");
		Thread.sleep(2000);
		//Bug --invalid extro header After a click throwing the error message

		//Step 13 : Click SAVE
		//Expected :The user should get a ERROR popup message that"Allowed characters a-z 0-9,.-@?!#$%&:
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HRSave("display: none;","Save")),"User is not able to view Save button");        
		base.excuteJsClick(HighlightReelsObj.Btn_HRSave("display: none;","Save"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Allowed characters a-z 0-9,.-@?!#$%&:")),"The user should not get a ERROR popup message that\"Allowed characters a-z 0-9,.-@?!#$%&:");


	}
	// <summary>
	// Test Case Title :"To verify what happens when user leave the Extro-Sub Header (medium Text) empty"
	// Automation ID   : HR_27
	// </summary>
	public void HR_27_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		DuplicateSnip_Obj DuplicateSnipObj=new DuplicateSnip_Obj();
		CommonData commonData = new CommonData();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		//Step 1  :"Login to snipback "
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		//Step 2   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 3   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 4   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 5  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		base.switchToWindowByIndex(driver, 1);
		Thread.sleep(2000);

		//Step 6 :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 7 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 8 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),HighlightReelsTestData.HR_27ExtroHeader );
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(3000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_27ExtroHeader, "User not able to enter the highlightreel name");

		//Step 9 : To enter a Valid Intro Slide Text
		//Expected : The user should able to enter a Valid Intro Slide Text"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the InvalidIntroSlideText textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_27IntroSlideText);
		String IntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(5000);
		asrt.assertEquals(IntroSlideText, HighlightReelsTestData.HR_27IntroSlideText, "User not able to enter the Valid Intro Slide Text name");

		//Step 10: Enter the Valid Extro Header
		//Expected : The user should able to enter a Invalid Extro Header"
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_27ValidExtroHeader);
		String ValidExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		asrt.assertEquals(ValidExtroHeaderText,HighlightReelsTestData.HR_27ValidExtroHeader, "User not able to enter the ExtroHeader");

		//Step 11 : Enter Extro Details
		//Expected : The user should able to enter Enter Extro Details
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2")),"User is not able to view the Extro Details textbox");   
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea3"), HighlightReelsTestData.HR_27ExtroDetails);
		String ExtroDetails = base.GetValue(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea3"));
		Thread.sleep(2000);
		asrt.assertEquals(ExtroDetails,HighlightReelsTestData.HR_27ExtroDetails, "User not able to enter the ExtroDetails");

		//Step 12 : Click SAVE
		//Expected :The user should get a message that"Please enter the Extro-Sub Header (medium Text)"
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HRSave("display: none;","Save")),"User is not able to view Save button");        
		base.excuteJsClick(HighlightReelsObj.Btn_HRSave("display: none;","Save"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Please enter the extro sub header")),"The user should not get a message that Please enter the Extro-Sub Header (medium Text)");

	}

	// <summary>
	// Test Case Title :"To verify that what happens when we click  X Button in the Extro-Sub Header (medium Text)"
	// Automation ID   : HR_28
	// </summary>
	public void HR_28_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		DuplicateSnip_Obj DuplicateSnipObj=new DuplicateSnip_Obj();
		CommonData commonData = new CommonData();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		//Step 1  :"Login to snipback "
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		//Step 2   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 3   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 4   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 5  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		base.switchToWindowByIndex(driver, 1);
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 6 :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 7 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 8 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),HighlightReelsTestData.HR_28ExtroHeader );
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(3000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_28ExtroHeader, "User not able to enter the highlightreel name");

		//Step 9 : To enter a Valid Intro Slide Text
		//Expected : The user should able to enter a Valid Intro Slide Text"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the InvalidIntroSlideText textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_28IntroSlideText);
		String IntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(2000);
		asrt.assertEquals(IntroSlideText, HighlightReelsTestData.HR_28IntroSlideText, "User not able to enter the Valid Intro Slide Text name");

		//Step 10: Enter the Valid Extro Header
		//Expected : The user should able to enter a Invalid Extro Header"
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_28ValidExtroHeader);
		String ValidExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		asrt.assertEquals(ValidExtroHeaderText,HighlightReelsTestData.HR_28ValidExtroHeader, "User not able to enter the ExtroHeader");

		//Step 11 : Enter Invalid Extro Sub-header
		//Expected : The user should able to enter Enter Invalid Extro Sub-header
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2")),"User is not able to view the Extro Sub-header textbox");   
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2"), HighlightReelsTestData.HR_28InvalidExtroSubHeader);
		String ExtroSubheader = base.GetValue(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2"));
		Thread.sleep(2000);
		asrt.assertEquals(ExtroSubheader,HighlightReelsTestData.HR_28InvalidExtroSubHeader, "User not able to enter the Invalid ExtroHeader");
		Thread.sleep(2000);
		//Bug --invalid extro header After a click throwing the error message

		//Step 12 : Click X button
		//Expected :The user should be able to Clear the Extro-Sub Header (medium Text).
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroSubheaderClose("EXTRO SUB-HEADER (MEDIUM TEXT)", "cursor-pointer ms-3 sub-header")), "User is not able to view the clear icon");
		Thread.sleep(2000);
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubheaderClose("EXTRO SUB-HEADER (MEDIUM TEXT)", "cursor-pointer ms-3 sub-header"));
		String ExtroSubheader1 = base.GetValue(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2"));
		Thread.sleep(1000);
		asrt.assertEquals(ExtroSubheader1," ", "User not able to clear the Extro-Sub Header");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Allowed characters a-z 0-9,.-@?!#$%&:")),"The user should not get a ERROR popup message that\"Allowed characters a-z 0-9,.-@?!#$%&:");


	}

	// <summary>
	// Test Case Title :"To verify that what happens when a user type more than 70 characters in Extro-Sub Header (medium Text)"
	// Automation ID   : HR_29
	// </summary>
	public void HR_29_HighlightReels() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		DuplicateSnip_Obj DuplicateSnipObj=new DuplicateSnip_Obj();
		CommonData commonData = new CommonData();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		//Step 1  :"Login to snipback "
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		Thread.sleep(5000);

		//Step 2   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		
		//Step 3   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		//Step 4   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 5  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));
		base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		base.switchToWindowByIndex(driver, 1);
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		
		//Step 6 :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		
		//Step 7 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 8 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"),HighlightReelsTestData.HR_29ExtroHeader );
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(3000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_29ExtroHeader, "User not able to enter the highlightreel name");

		//Step 9 : To enter a Valid Intro Slide Text
		//Expected : The user should able to enter a Valid Intro Slide Text"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("intro-slide-text")),"User is not able to view the InvalidIntroSlideText textbox");   
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestData.HR_29IntroSlideText);
		String IntroSlideText = base.GetValue(LoginPageObj.Edt_LoginEmail("intro-slide-text"));
		Thread.sleep(5000);
		asrt.assertEquals(IntroSlideText, HighlightReelsTestData.HR_29IntroSlideText, "User not able to enter the Valid Intro Slide Text name");

		//Step 10: Enter the Valid Extro Header
		//Expected : The user should able to enter a Invalid Extro Header"
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_29ValidExtroHeader);
		String ValidExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		asrt.assertEquals(ValidExtroHeaderText,HighlightReelsTestData.HR_29ValidExtroHeader, "User not able to enter the ExtroHeader");

		//Step 11 : Enter Extro Details
		//Expected : The user should able to enter Enter Extro Details
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2")),"User is not able to view the Extro Details textbox");   
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea3"), HighlightReelsTestData.HR_29ExtroDetails);
		String ExtroDetails = base.GetValue(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea3"));
		Thread.sleep(2000);
		asrt.assertEquals(ExtroDetails,HighlightReelsTestData.HR_29ExtroDetails, "User not able to enter the ExtroDetails");

		//Step 12 : Enter valid Extro Sub-header with more than 70 characters
		//Expected : The input field should restrict further input and not allow typing beyond 70 characters in Extro-Sub Header (medium Text).
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2")),"User is not able to view the Extro Sub-header textbox");   
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2"),HighlightReelsTestData.HR29_ExtroHeaderChar);
		String ExtroHeaderText2 = base.GetValue(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("floatingTextarea2"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		asrt.assertEquals(ExtroHeaderText2,"HRTC29HIGHLIGHTREELWITHMORETHAN70CHARACTER ENTERED AND VERIFYING IS IT","The input field should not restrict further input and  allow typing beyond 70 characters in Extro-Sub Header (medium Text)");

	}
	// <summary>
	// Test Case Title :"Verify that " Custom" option should be displayed under Music dropdown in the player page"
	// Automation ID   : HR_47
	// </summary>
	
	public void HR_47_HighlightReels() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		HighlightReels_TestData HighlightReelsTestDataObj = new HighlightReels_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
	
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
	
		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
	
		//Step 8  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
	
		//Step 9 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.scrollToElement(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");
	
		//Step 10 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");
	
		//Step 11 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");
	
		//Step 12 : To enter the Intro Slide Text
		//Expected : The user should be able to enter the Intro Slide Text.
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestDataObj.HR47_IntroSlideText);	
	
		//Step 13 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_04_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText, HighlightReelsTestData.HR_04_ExtroHeader, "User not able to enter the ExtroHeader");
	
		//Step 14 : To enter the Extro Sub-header
		//Expected : The user should be able to enter the Extro Sub-header
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"), HighlightReelsTestDataObj.HR47_ExtroSubheader);	
	
		//Step 15 : To enter the Extro details 
		//Expected : The user should be able to enter the Extro details 
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"), HighlightReelsTestDataObj.HR47_Extrodetails);	
	
		//Step 16 : Click Music Dropdown
		//Expected : The user should be able to click Music Dropdown
		base.scrollToElement(HighlightReelsObj.Btn_Music("accordion mt-2 accordion-wrap","headingTwo"));
		base.buttonClick(HighlightReelsObj.Btn_Music("accordion mt-2 accordion-wrap","headingTwo"));
	
		//Step 17 : Click Audio Dropdown
		//Expected : The user should be able to click Audio Dropdown
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option"));
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option")),"Unable to select the Audio from the Dropdown");
	
		//Step 18 : Click Custom Dropdown
		//Expected : The user should be able to click Audio Dropdown
		base.selectorByVisibleText(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option"), "CUSTOM");
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option")),"Unable to select the CUSTOM from the Dropdown");
	
	}
	// <summary>
	// Test Case Title :"Verify that there should be an option for "Upload an Audio" under the Music in the player page"
	// Automation ID   : HR_48
	// </summary>
	
	public void HR_48_HighlightReels() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		HighlightReels_TestData HighlightReelsTestDataObj = new HighlightReels_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
	
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
	
		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));	
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
	
		//Step 8  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
	
		//Step 9 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.scrollToElement(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");
	
		//Step 10 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");
	
		//Step 11 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");
	
		//Step 12 : To enter the Intro Slide Text
		//Expected : The user should be able to enter the Intro Slide Text.		
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestDataObj.HR47_IntroSlideText);	
	
		//Step 13 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_04_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText, HighlightReelsTestData.HR_04_ExtroHeader, "User not able to enter the ExtroHeader");
	
		//Step 14 : To enter the Extro Sub-header
		//Expected : The user should be able to enter the Extro Sub-header
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"), HighlightReelsTestDataObj.HR47_ExtroSubheader);	
	
		//Step 15 : To enter the Extro details 
		//Expected : The user should be able to enter the Extro details 
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"), HighlightReelsTestDataObj.HR47_Extrodetails);	
	
		//Step 16 : Click Music Dropdown
		//Expected : The user should be able to click Music Dropdown
		base.scrollToElement(HighlightReelsObj.Btn_Music("accordion mt-2 accordion-wrap","headingTwo"));
		base.buttonClick(HighlightReelsObj.Btn_Music("accordion mt-2 accordion-wrap","headingTwo"));
	
		//Step 17 : Click Audio Dropdown
		//Expected : The user should be able to click Audio Dropdown
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option"));
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option")),"Unable to select the Audio from the Dropdown");
	
		//Step 18: Click Custom Dropdown
		//Expected : The user should be able to click Audio Dropdown
		base.selectorByVisibleText(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option"), "CUSTOM");
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option")),"Unable to select the CUSTOM from the Dropdown");
	
		//Step 19 : Verify that there should be an option for "Upload an Audio" under the Music 
		//Expected : The user should be able to view that there should be an option for "Upload an Audio" under the Music 
		asrt.assertTrue(base.isExists(RegistrationObj.Nav_RegistrationPage("audioForm")), "The user is not able to view that there should be an option for 'Upload an Audio' under the Music ");
	}
	
	// <summary>
	// Test Case Title :"Verify that user should able to upload the custom audio from their own when click on Choose file from Upload an audio"
	// Automation ID   : HR_49
	// </summary>	
	public void HR_49_HighlightReels() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		HighlightReels_TestData HighlightReelsTestDataObj = new HighlightReels_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();	
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
	
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
	
		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
	
		//Step 8  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
	
		//Step 9 : Click on My Hightlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.scrollToElement(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");
	
		//Step 10 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");
	
		//Step 11 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");
	
		//Step 12 : To enter the Intro Slide Text
		//Expected : The user should be able to enter the Intro Slide Text.		
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestDataObj.HR47_IntroSlideText);	
	
		//Step 13 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_04_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText, HighlightReelsTestData.HR_04_ExtroHeader, "User not able to enter the ExtroHeader");
	
		//Step 14 : To enter the Extro Sub-header
		//Expected : The user should be able to enter the Extro Sub-header
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"), HighlightReelsTestDataObj.HR47_ExtroSubheader);	
	
		//Step 15 : To enter the Extro details 
		//Expected : The user should be able to enter the Extro details 
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"), HighlightReelsTestDataObj.HR47_Extrodetails);	
	
		//Step 16 : Click Music Dropdown
		//Expected : The user should be able to click Music Dropdown
		base.scrollToElement(HighlightReelsObj.Btn_Music("accordion mt-2 accordion-wrap","headingTwo"));
		base.buttonClick(HighlightReelsObj.Btn_Music("accordion mt-2 accordion-wrap","headingTwo"));
	
		//Step 17 : Click Audio Dropdown
		//Expected : The user should be able to click Audio Dropdown
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option"));
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option")),"Unable to select the Audio from the Dropdown");
	
		//Step 18 : Click Custom Dropdown
		//Expected : The user should be able to click Audio Dropdown
		base.selectorByVisibleText(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option"), "CUSTOM");
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option")),"Unable to select the CUSTOM from the Dropdown");
	
		//Step 19 : Verify that there should be an option for "Upload an Audio" under the Music 
		//Expected : The user should be able to view that there should be an option for "Upload an Audio" under the Music 
		asrt.assertTrue(base.isExists(RegistrationObj.Nav_RegistrationPage("audioForm")), "The user is not able to view that there should be an option for 'Upload an Audio' under the Music ");
	
		//Step 20 : Click on Choose file
		//Expected : The user should be able to click on Choose file
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("upload-audio"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("upload-audio")), "The user is not able to view that there should be an option for 'Choose File' under the Music ");
	
		//Step 21: Verify upload the custom audio from their own when click on Choose file from Upload an audio
		//Expected: User should able to upload the custom audio from their own when click on Choose file from Upload an audio
		String videoFilePath = System.getProperty("user.dir")+ "/Utils/Audio/Audio_Check_Snip.mp3";
		List<String> allowedTypes = Arrays.asList(".mp3");
		// Choose the file
		base.uploadFile(LoginPageObj.Edt_LoginEmail("upload-audio"), videoFilePath, allowedTypes);
		String uploadedFileExtension = videoFilePath.substring(videoFilePath.lastIndexOf("."));
		asrt.assertTrue(allowedTypes.contains(uploadedFileExtension),"Invalid file type uploaded: " + uploadedFileExtension);
		String actualImagePath =base.GetAttribte(LoginPageObj.Edt_LoginEmail("upload-audio"), "value");
		asrt.assertTrue(actualImagePath.contains("Audio_Check_Snip.mp3"), "Failed to update Audio in Choose File");
	}
	
	// <summary>
	// Test Case Title :"Verify that the audio size should not be more than 4MB "
	// Automation ID   : HR_50
	// </summary>
	public void HR_50_HighlightReels() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		HighlightReels_TestData HighlightReelsTestDataObj = new HighlightReels_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		HighlightReels_Obj HighlightReels_Obj =new HighlightReels_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
	
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
	
		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));	
		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		//Step 8  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
	
		//Step 9 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.scrollToElement(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");
	
		//Step 10 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");
	
		//Step 11 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");
	
		//Step 12 : To enter the Intro Slide Text
		//Expected : The user should be able to enter the Intro Slide Text.		
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestDataObj.HR47_IntroSlideText);	
	
		//Step 13 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_04_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText, HighlightReelsTestData.HR_04_ExtroHeader, "User not able to enter the ExtroHeader");
	
		//Step 14 : To enter the Extro Sub-header
		//Expected : The user should be able to enter the Extro Sub-header
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"), HighlightReelsTestDataObj.HR47_ExtroSubheader);	
	
		//Step 15 : To enter the Extro details 
		//Expected : The user should be able to enter the Extro details 
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"), HighlightReelsTestDataObj.HR47_Extrodetails);	
	
		//Step 16 : Click Music Dropdown
		//Expected : The user should be able to click Music Dropdown
		base.scrollToElement(HighlightReelsObj.Btn_Music("accordion mt-2 accordion-wrap","headingTwo"));
		base.buttonClick(HighlightReelsObj.Btn_Music("accordion mt-2 accordion-wrap","headingTwo"));
	
		//Step 17 : Click Audio Dropdown
		//Expected : The user should be able to click Audio Dropdown
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option"));
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option")),"Unable to select the Audio from the Dropdown");
	
		//Step 18 : Click Custom Dropdown
		//Expected : The user should be able to click Audio Dropdown
		base.selectorByVisibleText(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option"), "CUSTOM");
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-audio-option")),"Unable to select the CUSTOM from the Dropdown");
	
		//Step 19 : Verify that there should be an option for "Upload an Audio" under the Music 
		//Expected : The user should be able to view that there should be an option for "Upload an Audio" under the Music 
		asrt.assertTrue(base.isExists(RegistrationObj.Nav_RegistrationPage("audioForm")), "The user is not able to view that there should be an option for 'Upload an Audio' under the Music ");
	
		//Step 20 : Click on Choose file
		//Expected : The user should be able to click on Choose file
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("upload-audio"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("upload-audio")), "The user is not able to view that there should be an option for 'Choose File' under the Music ");
	
		//Step 21: Verify that the audio size should not be more than 4MB 
		//Expected: User able choose that the audio size should not be more than 4MB 
		String videoFilePath = System.getProperty("user.dir")+ "/Utils/Audio/Audio_Check_morethan4MB_Snip.mp3";
		List<String> allowedTypes = Arrays.asList(".mp3");
		// Choose the file
		base.uploadFile(LoginPageObj.Edt_LoginEmail("upload-audio"), videoFilePath, allowedTypes);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-icon swal-icon--error")), "User can able to upload audio size should more than 4MB ");
	
	}
	// <summary>
	// Test Case Title :"Verify that Social Media dropdown should be displayed in the player page down to Music "
	// Automation ID   : HR_51
	// </summary>

	public void HR_51_HighlightReels() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		HighlightReels_TestData HighlightReelsTestDataObj = new HighlightReels_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		HighlightReels_Obj HighlightReels_Obj =new HighlightReels_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));	
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 9 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.scrollToElement(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 10 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");

		//Step 11 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 12 : To enter the Intro Slide Text
		//Expected : The user should be able to enter the Intro Slide Text.		
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestDataObj.HR47_IntroSlideText);	

		//Step 13 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_04_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText, HighlightReelsTestData.HR_04_ExtroHeader, "User not able to enter the ExtroHeader");

		//Step 14 : To enter the Extro Sub-header
		//Expected : The user should be able to enter the Extro Sub-header
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"), HighlightReelsTestDataObj.HR47_ExtroSubheader);	

		//Step 15 : To enter the Extro details 
		//Expected : The user should be able to enter the Extro details 
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"), HighlightReelsTestDataObj.HR47_Extrodetails);	

		//Step 16 : Verify that Social Media dropdown should be displayed in the player page down to Music
		//Expected : The user should be able view that Social Media dropdown should be displayed in the player page down to Music
		base.scrollToElement(HighlightReelsObj.Btn_Music("accordion-item","headingThree"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Music("accordion-item","headingThree")), "The user should not able to view that Social Media dropdown should be displayed in the player page down to Music");
	}
	
	// <summary>
	// Test Case Title :"Verify that the following social media icons and field for enter the link should be displayed when click on social media dropdown"
	//Twitter
	//Instagram
	//Youtube
	//Email
	// Automation ID   : HR_52
	// </summary>

	public void HR_52_HighlightReels() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		HighlightReels_TestData HighlightReelsTestDataObj = new HighlightReels_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		HighlightReels_Obj HighlightReels_Obj =new HighlightReels_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();
		
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step  5  :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");


		//Step 8  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   

		//Step 9 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.scrollToElement(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");

		//Step 10 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");

		//Step 11 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");

		//Step 12 : To enter the Intro Slide Text
		//Expected : The user should be able to enter the Intro Slide Text.		
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestDataObj.HR47_IntroSlideText);	

		//Step 13 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_04_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText, HighlightReelsTestData.HR_04_ExtroHeader, "User not able to enter the ExtroHeader");

		//Step 14 : To enter the Extro Sub-header
		//Expected : The user should be able to enter the Extro Sub-header
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"), HighlightReelsTestDataObj.HR47_ExtroSubheader);	

		//Step 15 : To enter the Extro details 
		//Expected : The user should be able to enter the Extro details 
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"), HighlightReelsTestDataObj.HR47_Extrodetails);	

		//Step 16 : Verify that Social Media dropdown should be displayed in the player page down to Music
		//Expected : The user should be able view that Social Media dropdown should be displayed in the player page down to Music
		base.scrollToElement(HighlightReelsObj.Btn_Music("accordion-item","headingThree"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_Music("accordion-item","headingThree")), "The user should not able to view that Social Media dropdown should be displayed in the player page down to Music");

		//Step 17 : Click on Social Media dropdown
		//Expected : The user should be able to click on Social Media dropdown
		base.buttonClick(HighlightReelsObj.Btn_Music("accordion-item","headingThree"));

		//Step 17 : Verify that the following social media icons and field for enter the link should be displayed when click on social media dropdown
		//	1.Twitter
		//	2.Instagram
		//	3.Youtube
		//	4.Email
		//Expected : The user should be able view that the following social media icons and field for enter the link should be displayed when click on social media dropdown
		//	1.Twitter
		//	2.Instagram
		//	3.Youtube
		//	4.Email
		base.scrollToElement(HighlightReelsObj.Ele_Social_Media("cursor-pointer me-3 social-media-icon", "https://aicloud.snipback.com/assets/img/highlightreels/twitter.svg"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_Social_Media("cursor-pointer me-3 social-media-icon", "https://aicloud.snipback.com/assets/img/highlightreels/twitter.svg")),"The Twitter social media icon is not displayed under Social Media dropdown");
		base.scrollToElement(HighlightReelsObj.Ele_Social_Media("cursor-pointer me-3 social-media-icon", "https://aicloud.snipback.com/assets/img/highlightreels/instagram.svg"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_Social_Media("cursor-pointer me-3 social-media-icon", "https://aicloud.snipback.com/assets/img/highlightreels/instagram.svg")),"The Instagram social media icon is not displayed under Social Media dropdown");
		base.scrollToElement(HighlightReelsObj.Ele_Social_Media("cursor-pointer me-3 social-media-icon", "https://aicloud.snipback.com/assets/img/highlightreels/youtube.svg"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_Social_Media("cursor-pointer me-3 social-media-icon", "https://aicloud.snipback.com/assets/img/highlightreels/youtube.svg")),"The Youtube social media icon is not displayed under Social Media dropdown");
		base.scrollToElement(HighlightReelsObj.Ele_Social_Media("cursor-pointer me-3 social-media-icon", "https://aicloud.snipback.com/assets/img/highlightreels/email.svg"));
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_Social_Media("cursor-pointer me-3 social-media-icon", "https://aicloud.snipback.com/assets/img/highlightreels/email.svg")),"The Email social media icon is not displayed under Social Media dropdown");

	}
	// <summary>
	// Test Case Title :"Verify that Save and Cancel button should be displayed at the bottom of the Highlight reel popup page in the player page"
	// Automation ID   : HR_53
	// </summary>
	
	public void HR_53_HighlightReels() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		HighlightReels_TestData HighlightReelsTestDataObj = new HighlightReels_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		HighlightReels_Obj HighlightReels_Obj =new HighlightReels_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		HighlightReels_TestData HighlightReelsTestData = new HighlightReels_TestData();	
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
	
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		
		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(TrimVideoTestData.TV_01_teamName, "d-flex align-items-center item-label"));

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		Thread.sleep(20000);
		asrt.assertTrue(base.isExists(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game)),"Event Game is not Visible");
		base.scrollToElementtoCenter(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));
		base.excuteJsClick(HighlightReels_Obj.Btn_Game("d-flex justify-content-between",TrimVideoTestData.TV_01_Game));		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+TrimVideoTestData.TV_01_Game)),"Different Event Game Video/Irrelevant Video is Displaying");
	
		//Step 8  :View and Click the Highlight and white boards button
		//Expected: User will able to see the Highlight reels Pop up
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title")),"User is not able to view the Highlight and white boards button");
		base.buttonClick(HighlightReelsObj.Btn_HL("hightlight-popup-button","block-title"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_HL_Popup("highlight-reel-popup")),"User is not able to view the Highlight reels popup window");   
	
		//Step 9 : Click on My Highlight Reels + icon
		//Expected : The user should be able to view the Highlight reel create page.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus")),"User is not able to view the HighlightReels '+' icon");        
		base.scrollToElement(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		base.buttonClick(HighlightReelsObj.Btn_icon("plusbtn add-my-hightlight-reel","fa fa-plus"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("reelname")),"User is not able to view the HighlightReel Name textbox");
	
		//Step 10 : To enter a valid Name
		//Expected : The user should be able to enter the Highlight Reel Name.
		base.setData(LoginPageObj.Edt_LoginEmail("reelname"), HighlightReelsTestData.HR_30_TestData);
		String HighlightReelName = base.GetValue(LoginPageObj.Edt_LoginEmail("reelname"));
		Thread.sleep(5000);
		asrt.assertEquals(HighlightReelName, HighlightReelsTestData.HR_30_TestData, "User not able to enter the highlightreel name");
	
		//Step 11 : Click on the Design Snipback Theme Dropdown and select any one of it
		//Expected : User should be able select any of the theme from the dropdown list
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme")),"Unable to view the Snipback Theme Dropdown");
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectCategory("select-theme"));
		base.buttonClick(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2"));	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Sel_SelectTeamType("select-theme","2")),"Unable to select the particular Snipback Theme from the Dropdown");
	
		//Step 12 : To enter the Intro Slide Text
		//Expected : The user should be able to enter the Intro Slide Text.		
		base.setData(LoginPageObj.Edt_LoginEmail("intro-slide-text"), HighlightReelsTestDataObj.HR47_IntroSlideText);	
	
		//Step 13 : To enter the ExtroHeader
		//Expected : The user should be able to enter the ExtroHeader Name.
		asrt.assertTrue(base.isExists(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header")),"User is not able to view the Extroheader textbox");   
		base.setData(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"), HighlightReelsTestData.HR_04_ExtroHeader);
		String ExtroHeaderText = base.GetValue(HighlightReelsObj.Ele_ExtroHeader("exampleInputEmail5","header"));
		Thread.sleep(5000);
		asrt.assertEquals(ExtroHeaderText, HighlightReelsTestData.HR_04_ExtroHeader, "User not able to enter the ExtroHeader");
	
		//Step 14 : To enter the Extro Sub-header
		//Expected : The user should be able to enter the Extro Sub-header
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area snipback-customtext"), HighlightReelsTestDataObj.HR47_ExtroSubheader);	
	
		//Step 15 : To enter the Extro details 
		//Expected : The user should be able to enter the Extro details 
		base.scrollToElement(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.buttonClick(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"));
		base.setData(HighlightReelsObj.Ele_ExtroSubHeaderMedium("form-control text-area height-100 snipback-customtext"), HighlightReelsTestDataObj.HR47_Extrodetails);	
	
		//Step 16 : Verify that Save and Cancel button should be displayed at the bottom of the Highlight reel popup page in the player page
		//Expected : The user should be able view  that Save and Cancel button should be displayed at the bottom of the Highlight reel popup page in the player page
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-cancel-createhighlight"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-cancel-createhighlight")), "The user should not able to view Cancel button should be displayed at the bottom of the Highlight reel popup page in the player page");
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-save-createhighlight")), "The user should not able to view Save button should be displayed at the bottom of the Highlight reel popup page in the player page");
	
	}
}
