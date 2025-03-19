package testPage.MavenPageObject;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestData.AddEditInfo_TestData;
import TestData.AddUpdateRemoveMember_TestData;
import TestData.ArchiveUnarchiveTeam_TestData;
import TestData.CommonData;
import TestData.CreateAddNewMemberWithEmail_TestData;
import TestData.DownloadGamePlayer_TestData;
import TestData.MoveGame_TestData;
import TestData.SnipBackLogin_TestData;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.ViewProfile_Obj;
import objectRepository.AddEditInfo_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.ArchiveUnarchiveTeam_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.CreateUpdateDeleteGame_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;

public class DownloadGamePlayer extends BasePge {
	BasePge base;
	Assert asrt;

	public DownloadGamePlayer(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify the functionality of a "Download" button on a player page"
	// Automation ID   : DG_1 
	// </summary>
	public void DG_1_DownloadGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
           MoveGame_Obj MoveGameObj= new MoveGame_Obj();
           DownloadGamePlayer_TestData DownloadGamePlayerTestData=new DownloadGamePlayer_TestData();
           CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
         
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DownloadGamePlayerTestData.DG_01_DownloadGamePlayerOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 6   :Select a Team from ORG
        //Expected:The New Team is Selected
     	base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),DownloadGamePlayerTestData.DG_01_DownloadGamePlayerTeamName);
		Thread.sleep(3000);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.excuteJsClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(DownloadGamePlayerTestData.DG_01_DownloadGamePlayerTeamName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(DownloadGamePlayerTestData.DG_01_DownloadGamePlayerTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(2000);
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
        //Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("search"), DownloadGamePlayerTestData.DG_01_DownloadGamePlayerGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",DownloadGamePlayerTestData.DG_01_DownloadGamePlayerGameName)),"Event  is not Selected");
		 
	    //Step 8  :Click on Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page and the video plays
		String originalWindow = driver.getWindowHandle();//store the current window
		base.setZoom(driver, 70);
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",DownloadGamePlayerTestData.DG_01_DownloadGamePlayerGameName));
        Thread.sleep(7000);
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",DownloadGamePlayerTestData.DG_01_DownloadGamePlayerGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+DownloadGamePlayerTestData.DG_01_DownloadGamePlayerGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
        
        //Step 9  :To verify the functionality of a "Download" button on a player page
 		//Expected: The "Download" button should visible and clickable on the  player page
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-download")),"Unable to Find Download Button in Player Page");
        asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-download")),"Unable to Click Download Button in Player Page");
	}
	
    // <summary>
	// Test Case Title :"To Verify that a message should appear when a user clicks the "Download" button in player page"
	// Automation ID   : DG_2 
	// </summary>
	public void DG_2_DownloadGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
           MoveGame_Obj MoveGameObj= new MoveGame_Obj();DownloadGamePlayer_TestData DownloadGamePlayerTestData=new DownloadGamePlayer_TestData();
           CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
           
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DownloadGamePlayerTestData.DG_02_DownloadGamePlayerOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 6   :Select a Team from ORG
        //Expected:The New Team is Selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),DownloadGamePlayerTestData.DG_02_DownloadGamePlayerTeamName);
		Thread.sleep(3000);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(DownloadGamePlayerTestData.DG_02_DownloadGamePlayerTeamName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(DownloadGamePlayerTestData.DG_02_DownloadGamePlayerTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
        //Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("search"), DownloadGamePlayerTestData.DG_02_DownloadGamePlayerGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",DownloadGamePlayerTestData.DG_02_DownloadGamePlayerGameName)),"Event  is not Selected");
	        
	    //Step 8  :Click on Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",DownloadGamePlayerTestData.DG_02_DownloadGamePlayerGameName));
        Thread.sleep(7000);
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",DownloadGamePlayerTestData.DG_02_DownloadGamePlayerGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+DownloadGamePlayerTestData.DG_02_DownloadGamePlayerGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
        
        //Step 9  :To Verify that a message should appear when a user clicks the "Download" button in player page
 		//Expected: The "Download" button should visible and clickable on the  player page
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-download")),"Unable to Find Download Button in Player Page");
        asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-download")),"Unable to Click Download Button in Player Page");	     	
        base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-download"));
     	
        
     	 //Step 10:To Verify that a message should appear when a user clicks the "Download" button in player page
     	//Expected:A message dialoge box with Yes & Cancel option should appear when a user clicks the "Download" button in player	
     	asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateBtnSnip("swal-title","Yes")),"A message dialoge box with Yes option not Found ");
     	asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateBtnSnip("swal-title","Cancel")),"A message dialoge box with Cancel option not Found ");
	}
	
    // <summary>
	// Test Case Title :"Verify that a user clicks the "Cancel" option in a dialog box, ensuring that the message box disappears"
	// Automation ID   : DG_3 
	// </summary>
	public void DG_3_DownloadGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
           MoveGame_Obj MoveGameObj= new MoveGame_Obj();DownloadGamePlayer_TestData DownloadGamePlayerTestData=new DownloadGamePlayer_TestData();
           CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
           
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DownloadGamePlayerTestData.DG_03_DownloadGamePlayerOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 6   :Select a Team from ORG
        //Expected:The New Team is Selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),DownloadGamePlayerTestData.DG_03_DownloadGamePlayerTeamName);
		Thread.sleep(3000);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(DownloadGamePlayerTestData.DG_03_DownloadGamePlayerTeamName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(DownloadGamePlayerTestData.DG_03_DownloadGamePlayerTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
        //Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("search"), DownloadGamePlayerTestData.DG_03_DownloadGamePlayerGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",DownloadGamePlayerTestData.DG_03_DownloadGamePlayerGameName)),"Event  is not Selected");
        
	    //Step 8  :Click on Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",DownloadGamePlayerTestData.DG_03_DownloadGamePlayerGameName));
        Thread.sleep(7000);
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",DownloadGamePlayerTestData.DG_03_DownloadGamePlayerGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+DownloadGamePlayerTestData.DG_03_DownloadGamePlayerGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
        
        //Step 9  :To Verify that a message should appear when a user clicks the "Download" button in player page
 		//Expected: The "Download" button should visible and clickable on the  player page
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-download")),"Unable to Find Download Button in Player Page");
        asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-download")),"Unable to Click Download Button in Player Page");
        base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-download"));
     	
     	//Step 10:To Verify that a message should appear when a user clicks the "Download" button in player page
     	//Expected:A message dialoge box with Yes & Cancel option should appear when a user clicks the "Download" button in player	
     	asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateBtnSnip("swal-title","Yes")),"A message dialoge box with Yes option not Found ");
     	asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateBtnSnip("swal-title","Cancel")),"A message dialoge box with Cancel option not Found ");
		
     	//Step 11:Verify that a user clicks the "Cancel" option in a dialog box, ensuring that the message box disappears
     	//Expected:A message dialoge box immediately disappear from the  screen after the \"Cancel\" button Clicked	
        base.excuteJsClick(MoveGameObj.Btn_Video_CreateBtnSnip("swal-title","Cancel"));
        WebDriverWait wait = new WebDriverWait(driver, 10); 
        boolean isInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(MoveGameObj.Btn_Video_CreateBtnSnip("swal-title", "Cancel") ));
        asrt.assertTrue(isInvisible, "The dialog box with the 'Cancel' button did not disappear as expected.");
	}
	
    // <summary>
	// Test Case Title :"Verify that a video gets downloaded when user click the  "Yes" option in a dialog box"
	// Automation ID   : DG_4 
	// </summary>
	public void DG_4_DownloadGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();DownloadGamePlayer_TestData DownloadGamePlayerTestData=new DownloadGamePlayer_TestData();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DownloadGamePlayerTestData.DG_04_DownloadGamePlayerOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 6 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), DownloadGamePlayerTestData.DG_04_DownloadGamePlayerTeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",DownloadGamePlayerTestData.DG_04_DownloadGamePlayerTeamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",DownloadGamePlayerTestData.DG_04_DownloadGamePlayerTeamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 7 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",DownloadGamePlayerTestData.DG_04_DownloadGamePlayerGameName)),"Event Game is not Visible");

	    //Step 8  : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",DownloadGamePlayerTestData.DG_04_DownloadGamePlayerGameName)); 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+DownloadGamePlayerTestData.DG_04_DownloadGamePlayerGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
        
        //Step 9  :To Verify that a message should appear when a user clicks the "Download" button in player page
 		//Expected: The "Download" button should visible and clickable on the  player page
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-download")),"Unable to Find Download Button in Player Page");
        asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-download")),"Unable to Click Download Button in Player Page");
        base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-download"));
     	
     	//Step 10:To Verify that a message should appear when a user clicks the "Download" button in player page
     	//Expected:A message dialoge box with Yes & Cancel option should appear when a user clicks the "Download" button in player	
     	asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateBtnSnip("swal-title","Yes")),"A message dialoge box with Yes option not Found ");
     	asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateBtnSnip("swal-title","Cancel")),"A message dialoge box with Cancel option not Found ");
		
     	//Step 11:Verify that a video gets downloaded when user click the  "Yes" option in a dialog box
     	//Expected:The video download should begin immediately, and the file should be saved in the appropriate location on the device (e.g., Downloads folder).
        base.excuteJsClick(MoveGameObj.Btn_Video_CreateBtnSnip("swal-title", "Yes"));
        String downloadPath = System.getProperty("user.home") + "/Downloads/";
        String expectedFileName = DownloadGamePlayerTestData.DG_04_DownloadedGameName;  
        File downloadedFile = new File(downloadPath + expectedFileName);
        Thread.sleep(15000);
        asrt.assertTrue(downloadedFile.exists(), "The video was not downloaded successfully or not saved in the Downloads folder");             
	}
  }

