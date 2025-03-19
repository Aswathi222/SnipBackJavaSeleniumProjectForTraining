package testPage.MavenPageObject;
import static org.testng.Assert.assertEquals;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestData.AddEditInfo_TestData;
import TestData.AddUpdateRemoveMember_TestData;
import TestData.ArchiveUnarchiveTeam_TestData;
import TestData.CommonData;
import TestData.CopyVideoURLPlayer_TestData;
import TestData.CreateAddNewMemberWithEmail_TestData;
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
import objectRepository.AddFollower_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.ArchiveUnarchiveTeam_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.CreateUpdateDeleteGame_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;

public class CopyVideoURLPlayer extends BasePge {
	BasePge base;
	Assert asrt;

	public CopyVideoURLPlayer(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

    // <summary>
	// Test Case Title :"Verify that the "Copy Video URL" option is present on the video in player page"
	// Automation ID   : CV_1 
	// </summary>
	public void CV_1_CopyVideoURLPlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
        CopyVideoURLPlayer_TestData CopyURLTestData = new CopyVideoURLPlayer_TestData();
        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
       
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CopyURLTestData.CV_1_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CopyURLTestData.CV_1_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CopyURLTestData.CV_1_TeamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CopyURLTestData.CV_1_TeamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",CopyURLTestData.CV_1_EventOrGameName)),"Event Game is not Visible");
		
	    //Step 7  :Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",CopyURLTestData.CV_1_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+CopyURLTestData.CV_1_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
        
        //Step 8 : Click 3 dots menu in the video of player page
 		//Expected : User should view and click on the 3 dots icon
        asrt.assertTrue(base.isExists(AddFollowerObj.Btn_MailTick("more-buttons-wrapper", "more-button-icon")),"User is unable to view the 3 dots icon on the video of the player page");
        base.excuteJsClick(AddFollowerObj.Btn_MailTick("more-buttons-wrapper", "more-button-icon"));
        
        //Step 9 : Verify that the "Copy Video URL" option is present on the video in player page
 		//Expected : The "Copy Video URL" option should be present in the video in the player page);
        asrt.assertTrue(base.isExists(AddFollowerObj.Btn_MailTick("panel-content", "ico-copy")),"Unable to Find \"Copy Video URL\" option  in Player Page");
	}
	
    // <summary>
	// Test Case Title :"Verify that the video URL should be successfully copied to the clipboard when the option is clicked"
	// Automation ID   : CV_2 
	// </summary>
	public void CV_2_CopyVideoURLPlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
        CopyVideoURLPlayer_TestData CopyURLTestData = new CopyVideoURLPlayer_TestData();
        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
       
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CopyURLTestData.CV_2_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CopyURLTestData.CV_2_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CopyURLTestData.CV_2_TeamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CopyURLTestData.CV_2_TeamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",CopyURLTestData.CV_2_EventOrGameName)),"Event Game is not Visible");
		
	    //Step 7  :Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",CopyURLTestData.CV_2_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+CopyURLTestData.CV_2_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
        
        //Step 8 : Click 3 dots menu in the video of player page
 		//Expected : User should view and click on the 3 dots icon
        asrt.assertTrue(base.isExists(AddFollowerObj.Btn_MailTick("more-buttons-wrapper", "more-button-icon")),"User is unable to view the 3 dots icon on the video of the player page");
        base.excuteJsClick(AddFollowerObj.Btn_MailTick("more-buttons-wrapper", "more-button-icon"));
        
        //Step 9 : Verify that the "Copy Video URL" option is present on the video in player page
 		//Expected : The "Copy Video URL" option should be present in the video in the player page);
        asrt.assertTrue(base.isExists(AddFollowerObj.Btn_MailTick("panel-content", "ico-copy")),"Unable to Find \"Copy Video URL\" option  in Player Page");
       
        //Step 10 : Click "Copy Video URL" option 
 		//Expected : The video URL should be copied to the clipboard, and the clipboard content should match the video URL exactly 
        base.buttonClick(AddFollowerObj.Btn_MailTick("panel-content", "ico-copy"));
        Thread.sleep(2000);
        // Retrieve clipboard content and validate it
        String expectedURL = CopyURLTestData.CV_2_CopiedURL;
        String clipboardContent = base.getClipboardText();
        asrt.assertEquals(clipboardContent, expectedURL, "The copied video URL does not match the expected URL");
	}
	// <summary>
	// Test Case Title :"Verify that the video in player page and the video playing with Copy URL video both are same"
	// Automation ID   : CV_3
	// </summary>
	public void CV_3_CopyVideoURLPlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
        CopyVideoURLPlayer_TestData CopyURLTestData = new CopyVideoURLPlayer_TestData();
        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
       
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CopyURLTestData.CV_3_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CopyURLTestData.CV_3_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CopyURLTestData.CV_3_TeamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CopyURLTestData.CV_3_TeamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",CopyURLTestData.CV_3_EventOrGameName)),"Event Game is not Visible");
		
	    //Step 7  :Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",CopyURLTestData.CV_3_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+CopyURLTestData.CV_3_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
        
        //Step 8 : Click 3 dots menu in the video of player page
 		//Expected : User should view and click on the 3 dots icon
        asrt.assertTrue(base.isExists(AddFollowerObj.Btn_MailTick("more-buttons-wrapper", "more-button-icon")),"User is unable to view the 3 dots icon on the video of the player page");
        base.excuteJsClick(AddFollowerObj.Btn_MailTick("more-buttons-wrapper", "more-button-icon"));
        
        //Step 9 : Verify that the "Copy Video URL" option is present on the video in player page
 		//Expected : The "Copy Video URL" option should be present in the video in the player page);
        asrt.assertTrue(base.isExists(AddFollowerObj.Btn_MailTick("panel-content", "ico-copy")),"Unable to Find \"Copy Video URL\" option  in Player Page");
       
        //Step 10 : Click "Copy Video URL" option 
 		//Expected : The video URL should be copied to the clipboard, and the clipboard content should match the video URL exactly 
        base.buttonClick(AddFollowerObj.Btn_MailTick("panel-content", "ico-copy"));
        Thread.sleep(2000);
        // Retrieve clipboard content and validate it
        String expectedURL = CopyURLTestData.CV_3_CopiedURL;
        String clipboardContent = base.getClipboardText();
        asrt.assertEquals(clipboardContent, expectedURL, "The copied video URL does not match the expected URL");
	
        //Step 11 : Open a new tab and paste the copied URL Verify that the video in player page and the video playing with Copy URL video both are same
 		//Expected : The video in player page and the video playing in another window tab with Copy URL both should be same 
        asrt.assertFalse(clipboardContent.isEmpty(), "Clipboard content is empty or URL was not copied");
        //Open New browser tab
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
        Thread.sleep(2000);
        base.switchToWindowByIndex(driver, 2); 
        driver.get(clipboardContent); 
        Thread.sleep(5000);
        //Verify both videos are the same
        String videoTitleInNewTab = base.GetText(LoginPageObj.Edt_AlertText("Entire Game Video - "+CopyURLTestData.CV_3_EventOrGameName));
        asrt.assertEquals(videoTitleInNewTab, ("Entire Game Video - "+CopyURLTestData.CV_3_EventOrGameName).toUpperCase(), "The video in the new tab does not match the original video.");	        
	}	
}

