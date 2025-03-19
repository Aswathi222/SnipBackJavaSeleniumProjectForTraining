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
import TestData.AddUpdateRemoveMember_TestData;
import TestData.ArchiveUnarchiveTeam_TestData;
import TestData.CommonData;
import TestData.CreateAddNewMemberWithEmail_TestData;
import TestData.MoveGame_TestData;
import TestData.SnipBackLogin_TestData;
import TestData.SnipCreationWithAndWithoutTag_TestData;
import TestData.TrimVideo_TestData;
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
import objectRepository.FilterMembers_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;

public class MoveGame extends BasePge {
	BasePge base;
	Assert asrt;

	public MoveGame(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify the game is successfully moved to the specified organization and game mode upon selecting 'Move.'"
	// Automation ID   : TC_04 
	// </summary>

	public void TC_04_MoveGame() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
        CommonData Commondata= new CommonData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
		
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(5000);
		
		// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_04_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_04_Org)),"The organization is not selected");
		Thread.sleep(3000);

		// Step 3:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		// Step 4:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 5:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), MoveGame_TestData.TC_04_teamName);

		//Step 6:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_04_teamName));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_04_teamName)), "Failed to select TEAM");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
		
		// Step 7 :Create a new Event
		// Expected: New Event is created
		base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),MoveGame_TestData.TC_04_MoveGameEventName);
		Thread.sleep(1000);
		String Game_Name = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
		base.buttonClick(addupdateremoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
		Thread.sleep(3000);

		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		// page loading so need this time
		Thread.sleep(8000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(Game_Name)),"Unable to Click on the menu icon (three dots)");
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
		
		//Step 8   :"Locate Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
		//Expected :"Move Game Popup Displayed"
		base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
		
		//Step 9   :"Click the Organization Option from the dropdown."
		//Expected :"User able to select the Organization"
		base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
		base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_04_Org2));
		base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_04_Org2));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice")),"Unable to Select/Click Game Mode Practice");
		
		//Step 10   :"Select on game mode (Event/Scout/Practices) and click MOVE"
		//Expected :"User able to Select the Game Mode and Able to Click MOVE , Success Message Found"
		base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
		base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Game moved successfully.")),"Confirmation Message not Found / Can't close PopUp");
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
         
        //Step 11   :"Select the Game Moved Organization"
 		//Expected :"User should be navigated to OrgName list and select the OrgName"
        asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"Unable to view the Organization");
        base.scrollToElementtoCenter(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
 		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_04_Org2);
 		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and not able to select OrgName");
 		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES")),"Unable to change Game Mode to PRACTICES/Inaccessible ");
 		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES"));
		
 		//Step 12 : "verify the game is successfully moved to the specified organization"
 		//Expected: The game should displayed to the specified organization and game mode
 		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES"));    
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",Game_Name)),"User unable to view the moved game");
		
		driver.navigate().refresh();
	    try {
			 
			// Step 13: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    
			// Step 14: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			//base.buttonClick(CreateUpdateDeleteGameObj.Ele_ThreeDotDeleteBasedOnGameName(eventOrGameName));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 15: Click on yes in delete popup to delete added game
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	}
	
	    // <summary>
		// Test Case Title :"To verify the pop-up closes without moving the game when the "Cancel" button is clicked."
		// Automation ID   : TC_05 
		// </summary>

		public void TC_05_MoveGame() throws InterruptedException
		{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
	        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
	        CommonData Commondata= new CommonData();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
			FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
			
			// Step 1: Log in to SnipBack with valid credentials.
			// Expected: User should be navigated to the Homepage.
			login.loginToApplication(Commondata.UserName, Commondata.PassWord);
			Thread.sleep(5000);
			
			// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
			// Expected: The team should be selected from dropdown
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_05_Org));
			asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_05_Org)),"The organization is not selected");
			Thread.sleep(3000);

			// Step 3:Click outside the dropdown using Actions
			WebElement body = driver.findElement(By.tagName("body"));
			body.click(); // This will close the dropdown
			Thread.sleep(3000);
			Thread.sleep(3000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
			base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			
			// Step 4:Select EVENTS/PRACTICE/SCOUT
			// Expected:Successfully selected the EVENTS
			base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

			//Step 5:click on search button and search for team name SnipCreation
			//Expected:SnipCreation team is shown 
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), MoveGame_TestData.TC_05_teamName);

			//Step 6:Selecting the team
			//Expected:Team selected
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_05_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_05_teamName)), "Failed to select TEAM");
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
			
			// Step 7 :Create a new Event
			// Expected: New Event is created
			base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
			Thread.sleep(2000);
			base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),MoveGame_TestData.TC_05_MoveGameEventName);
			Thread.sleep(1000);
			String Game_Name = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
			base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
			base.buttonClick(addupdateremoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
			asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
			Thread.sleep(3000);

			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
			// page loading so need this time
			Thread.sleep(8000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(Game_Name)),"Unable to Click on the menu icon (three dots)");
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
			
			//Step 8   :"Locate Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
			//Expected :"Move Game Popup Displayed"
			base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
			
			//Step 9   :"Click the Organization Option from the dropdown."
			//Expected :"User able to select the Organization"
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_05_Org2));
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_05_Org2));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice")),"Unable to Select/Click Game Mode Practice");
			
			//Step 10   :"Select on game mode (Event/Scout/Practices) and click Cancel"
			//Expected :"The Move Game pop-up should close and the game should remain in its original organization and game mode without any changes."
			base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice"));
			base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "CANCEL"));
			asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",Game_Name)),"User unable to view the Game in original organization with same game mode");		
			driver.navigate().refresh();
		    try {
				 
				// Step 11: Delete the added game by clicking 3 dot menu of the added game
				// Expected: Drop down item is displayed with a list
				base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name)); 
				Thread.sleep(1000);
				asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
			    
				// Step 12: Click on delete from the list
				// Expected: A popup with confirmation to delete is shown
				base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				
				// Step 13: Click on yes in delete popup to delete added game
				base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
				Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println("Not an bug: Unable to delete game");
			}
	       }
		// <summary>
		// Test Case Title :"To verify that the user receives a confirmation message when the game is successfully moved to a new organization."
		// Automation ID   : TC_06
		// </summary>

		public void TC_06_MoveGame() throws InterruptedException
		{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
	        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
	        CommonData Commondata= new CommonData();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
			FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
			
			// Step 1: Log in to SnipBack with valid credentials.
			// Expected: User should be navigated to the Homepage.
			login.loginToApplication(Commondata.UserName, Commondata.PassWord);
			Thread.sleep(5000);
			
			// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
			// Expected: The team should be selected from dropdown
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_06_Org));
			asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_06_Org)),"The organization is not selected");
			Thread.sleep(3000);

			// Step 3:Click outside the dropdown using Actions
			WebElement body = driver.findElement(By.tagName("body"));
			body.click(); // This will close the dropdown
			Thread.sleep(3000);
			Thread.sleep(3000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
			base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			
			// Step 4:Select EVENTS/PRACTICE/SCOUT
			// Expected:Successfully selected the EVENTS
			base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

			//Step 5:click on search button and search for team name SnipCreation
			//Expected:SnipCreation team is shown 
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), MoveGame_TestData.TC_05_teamName);

			//Step 6:Selecting the team
			//Expected:Team selected
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_06_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_06_teamName)), "Failed to select TEAM");
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
			
			// Step 7 :Create a new Event
			// Expected: New Event is created
			base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
			Thread.sleep(2000);
			base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),MoveGame_TestData.TC_06_MoveGameEventName);
			Thread.sleep(1000);
			String Game_Name = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
			base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
			base.buttonClick(addupdateremoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
			asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
			Thread.sleep(3000);

			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
			// page loading so need this time
			Thread.sleep(8000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(Game_Name)),"Unable to Click on the menu icon (three dots)");
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
			
			//Step 8   :"Locate Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
			//Expected :"Move Game Popup Displayed"
			base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
			
			//Step 9   :"Click the Organization Option from the dropdown."
			//Expected :"User able to select the Organization"
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_06_Org2));
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_06_Org2));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice")),"Unable to Select/Click Game Mode Practice");
			
			//Step 10   :"Select on game mode (Event/Scout/Practices) and click MOVE"
			//Expected :"User able to Select the Game Mode and Able to Click MOVE , Successful Confirmation Message Found"
			base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
			base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
			asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Game moved successfully.")),"Confirmation Message not Found / Can't close PopUp");			
			asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Successful Confirmation Message not Found");
			
			driver.navigate().refresh();
		    try {
				 
				// Step 11: Delete the added game by clicking 3 dot menu of the added game
				// Expected: Drop down item is displayed with a list
				base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name)); 
				Thread.sleep(1000);
				asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
			    
				// Step 12: Click on delete from the list
				// Expected: A popup with confirmation to delete is shown
				//base.buttonClick(CreateUpdateDeleteGameObj.Ele_ThreeDotDeleteBasedOnGameName(eventOrGameName));
				base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				
				// Step 13: Click on yes in delete popup to delete added game
				base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
				Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println("Not an bug: Unable to delete game");
			}      
	      }
		// <summary>
		// Test Case Title :"To verify that selecting "Move Game" allows a game to move from Film to Practices and vice versa within the organization."
		// Automation ID   : TC_07 
		// </summary>

		public void TC_07_MoveGame() throws InterruptedException
		{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
	        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
	        CommonData Commondata= new CommonData();
	        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    	FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
	    			
	    	// Step 1: Log in to SnipBack with valid credentials.
	    	// Expected: User should be navigated to the Homepage.
	    	login.loginToApplication(Commondata.UserName, Commondata.PassWord);
	    	Thread.sleep(5000);
	    			
	    	// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
	    	// Expected: The team should be selected from dropdown
	    	base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	    	base.buttonClick(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_07_Org));
	    	asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_07_Org)),"The organization is not selected");
	    	Thread.sleep(3000);

	    	// Step 3:Click outside the dropdown using Actions
	    	WebElement body = driver.findElement(By.tagName("body"));
	    	body.click(); // This will close the dropdown
	    	Thread.sleep(3000);
	    	Thread.sleep(3000);
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
	    	base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
	    			
	    	// Step 4:Select EVENTS/PRACTICE/SCOUT
	    	// Expected:Successfully selected the EVENTS
	    	base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

	    	//Step 5:click on search button and search for team name SnipCreation
	    	//Expected:SnipCreation team is shown 
	    	base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
	    	base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), MoveGame_TestData.TC_07_teamName);

	    	//Step 6:Selecting the team
	    	//Expected:Team selected
	    	base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_07_teamName));
	    	asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_07_teamName)), "Failed to select TEAM");
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
	    			
	    	// Step 7 :Create a new Event
	    	// Expected: New Event is created
	    	base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
	    	Thread.sleep(2000);
	    	base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),MoveGame_TestData.TC_07_MoveGameEventName);
	    	Thread.sleep(1000);
	    	String Game_Name = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
	    	base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
	    	base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
	    	base.buttonClick(addupdateremoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
	    	asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
	    	Thread.sleep(3000);

	    	base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	    	// page loading so need this time
	    	Thread.sleep(8000);
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(Game_Name)),"Unable to Click on the menu icon (three dots)");
	    	base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
	    			
	    	//Step 8   :"Locate Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
	    	//Expected :"Move Game Popup Displayed"
	    	base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name));
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
	    	base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
					 		 
			//Step 9   :"Click the Organization Option from the dropdown."
			//Expected :"User able to select the Organization"
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_07_Org2));
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_07_Org2));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice")),"Unable to Select/Click Game Mode Practice");
			
			//Step 10   :"Select on game mode (Film/Scout/Practices) and click MOVE"
			//Expected :"User able to Select the Game Mode and Able to Click MOVE , Success Message Found"
			base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
			base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
			asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Confirmation Message not Found / Can't close PopUp");
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	         
	        //Step 11   :"Select the Game Moved Organization"
	 		//Expected :"User should be navigated to OrgName list and select the OrgName"
	        asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"Unable to view the Organization");
	        base.scrollToElementtoCenter(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	 		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_07_Org2);
	 		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and not able to select OrgName");
	 		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES")),"Unable to change Game Mode to PRACTICES/Inaccessible ");
	 		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES"));
			
	 		//Step 12 : "The game should be successfully moved from Film to Practices, and it should now appear in the Practices section."
	 		//Expected: The game should displayed to the specified organization and game mode
	 		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES"));
			Thread.sleep(3000);
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
			asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",Game_Name)),"User unable to view the moved game from Event to Practices, and it not appears in the Practices section.");
			
			//----------------------------------------------------------------------------------------------------
			//Step 13   :"(Vice-versa Game)Locate the Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
			//Expected :"Move Game Popup Displayed"
			Thread.sleep(3000);
			base.excuteJsClick(MoveGameObj.Btn_3Dots(Game_Name));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			base.excuteJsClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
			
			//Step 14   :"(Vice-versa Game)Click the Organization Option from the dropdown."
			//Expected :"User able to select the Organization"
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_07_Org));
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_07_Org));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Event")),"Unable to Select/Click Game Mode Event");
			
			//Step 15   :"(Vice-versa Game)Select on game mode (Event/Scout/Practices) and click MOVE"
			//Expected :"User able to Select the Game Mode and Able to Click MOVE , Success Message Found"
			base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Event"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
			base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
			asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Game moved successfully.")),"Confirmation Message not Found / Can't close PopUp");
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	         
	        //Step 16   :"(Vice-versa Game)Select the Game Moved Organization"
	 		//Expected :"User should be navigated to OrgName list and select the OrgName"
	        asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"Unable to view the Organization");
	        base.scrollToElementtoCenter(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	 		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_07_Org);
	 		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and not able to select OrgName");
	 		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"Unable to change Game Mode to EVENTS/Inaccessible ");
	 		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			
	 		//Step 17 : "The game should be successfully moved from Practices to Event, and it should now appear in the Events section."
	 		//Expected: The game should displayed to the specified organization and game mode
	 		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		    Thread.sleep(3000);
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
			asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",Game_Name)),"User unable to view the moved game from Practices to Event, and it not appears in the Events section.");
			driver.navigate().refresh();
		    try {
				 
				// Step 18: Delete the added game by clicking 3 dot menu of the added game
				// Expected: Drop down item is displayed with a list
				base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name)); 
				Thread.sleep(1000);
				asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
			    
				// Step 19: Click on delete from the list
				// Expected: A popup with confirmation to delete is shown
				//base.buttonClick(CreateUpdateDeleteGameObj.Ele_ThreeDotDeleteBasedOnGameName(eventOrGameName));
				base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				
				// Step 20: Click on yes in delete popup to delete added game
				base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
				Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println("Not an bug: Unable to delete game");
			} 
		}
        // <summary>
		// Test Case Title :"To verify that selecting "Move Game" allows a game to move from Event to Scout and vice versa within the organization."
		// Automation ID   : TC_08
		// </summary>

		public void TC_08_MoveGame() throws InterruptedException
		{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
	        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
	        CommonData Commondata= new CommonData();
	        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    	FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
	    			
	    	// Step 1: Log in to SnipBack with valid credentials.
	    	// Expected: User should be navigated to the Homepage.
	    	login.loginToApplication(Commondata.UserName, Commondata.PassWord);
	    	Thread.sleep(5000);
	    			
	    	// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
	    	// Expected: The organization should be selected from dropdown
	    	base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	    	base.buttonClick(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_08_Org));
	    	asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_08_Org)),"The organization is not selected");
	    	Thread.sleep(3000);

	    	// Step 3:Click outside the dropdown using Actions
	    	WebElement body = driver.findElement(By.tagName("body"));
	    	body.click(); // This will close the dropdown
	    	Thread.sleep(3000);
	    	Thread.sleep(3000);
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
	    	base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
	    			
	    	// Step 4:Select EVENTS/PRACTICE/SCOUT
	    	// Expected:Successfully selected the EVENTS
	    	base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

	    	//Step 5:click on search button and search for team name SnipCreation
	    	//Expected:SnipCreation team is shown 
	    	base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
	    	base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), MoveGame_TestData.TC_08_teamName);

	    	//Step 6:Selecting the team
	    	//Expected:Team selected
	    	base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_08_teamName));
	    	asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_08_teamName)), "Failed to select TEAM");
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
	    			
	    	// Step 7 :Create a new Event
	    	// Expected: New Event is created
	    	base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
	    	Thread.sleep(2000);
	    	base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),MoveGame_TestData.TC_08_MoveGameEventName);
	    	Thread.sleep(1000);
	    	String Game_Name = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
	    	base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
	    	base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
	    	base.buttonClick(addupdateremoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
	    	asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
	    	Thread.sleep(3000);

	    	base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	    	// page loading so need this time
	    	Thread.sleep(8000);
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(Game_Name)),"Unable to Click on the menu icon (three dots)");
	    	base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
	    			
	    	//Step 8   :"Locate Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
	    	//Expected :"Move Game Popup Displayed"
	    	base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name));
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
	    	base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
	    	 
			//Step 9   :"Click the Organization Option from the dropdown."
			//Expected :"User able to select the Organization"
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_08_Org2));
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_08_Org2));
			
			//Step 10   :"Select on game mode (Event/Scout/Practices) and click MOVE"
			//Expected :"User able to Select the Game Mode and Able to Click MOVE , Success Message Found"
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Scout")),"Unable to Select/Click Game Mode Scout");
			base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Scout"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
			base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
			asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Game moved successfully.")),"Confirmation Message not Found / Can't close PopUp");
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	         
	        //Step 11   :"Select the Game Moved Organization"
	 		//Expected :"User should be navigated to OrgName list and select the OrgName"
	        asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"Unable to view the Organization");
	        base.scrollToElementtoCenter(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	 		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_08_Org2);
	 		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and not able to select OrgName");

	 		//Step 12 : "The game should be successfully moved from Film to Scout, and it should now appear in the Scout section."
	 		//Expected: The game should displayed to the specified organization and game mode
	 		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "SCOUT")),"Unable to change Game Mode to SCOUT/Inaccessible ");
	 		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "SCOUT"));
			base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "SCOUT"));
			Thread.sleep(3000);
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
			asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",Game_Name)),"User unable to view the moved game from Event to Scout, and it not appears in the Scout section.");
			
			//----------------------------------------------------------------------------------------------------
			//Step 13   :"(Vice-versa Game)Locate the Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
			//Expected :"Move Game Popup Displayed"
			Thread.sleep(3000);
			base.excuteJsClick(MoveGameObj.Btn_3Dots(Game_Name));
			//asrt.assertTrue(base.isExists(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
			base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			base.excuteJsClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			 
			//Step 14   :"(Vice-versa Game)Click the Organization Option from the dropdown."
			//Expected :"User able to select the Organization"
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_08_Org));
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_08_Org));
			
			//Step 15   :"(Vice-versa Game)Select on game mode (Event/Scout/Practices) and click MOVE"
			//Expected :"User able to Select the Game Mode and Able to Click MOVE , Success Message Found"
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Event")),"Unable to Select/Click Game Mode Event");
			base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Event"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
			base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
			asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Game moved successfully.")),"Confirmation Message not Found / Can't close PopUp");
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	         
	        //Step 16   :"(Vice-versa Game)Select the Game Moved Organization"
	 		//Expected :"User should be navigated to OrgName list and select the OrgName"
	        asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"Unable to view the Organization");
	        base.scrollToElementtoCenter(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	 		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_08_Org);
	 		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and not able to select OrgName");

	 		//Step 17 : "The game should be successfully moved from Scout to Event, and it should now appear in the Film section."
	 		//Expected: The game should displayed to the specified organization and game mode
	 		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"Unable to change Game Mode to EVENTS/Inaccessible ");
	 		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		    Thread.sleep(3000);
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
			asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",Game_Name)),"User unable to view the moved game from Scout to Event, and it not appears in the Events section.");
			driver.navigate().refresh();
		    try {
				 
				// Step 18: Delete the added game by clicking 3 dot menu of the added game
				// Expected: Drop down item is displayed with a list
				base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name)); 
				Thread.sleep(1000);
				asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
			    
				// Step 19: Click on delete from the list
				// Expected: A popup with confirmation to delete is shown
				//base.buttonClick(CreateUpdateDeleteGameObj.Ele_ThreeDotDeleteBasedOnGameName(eventOrGameName));
				base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				
				// Step 20: Click on yes in delete popup to delete added game
				base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
				Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println("Not an bug: Unable to delete game");
			} 
		}
    // <summary>
	// Test Case Title :"To verify that selecting "Move Game" allows a game to move from Practices to Scout and vice versa"
	// Automation ID   : TC_09	
	// </summary>

	public void TC_09_MoveGame() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
        CommonData Commondata= new CommonData();
        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
    	FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
    			
    	// Step 1: Log in to SnipBack with valid credentials.
    	// Expected: User should be navigated to the Homepage.
    	login.loginToApplication(Commondata.UserName, Commondata.PassWord);
    	Thread.sleep(5000);
    			
    	// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
    	// Expected: The team should be selected from dropdown
    	base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
    	base.buttonClick(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_09_Org));
    	asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_09_Org)),"The organization is not selected");
    	Thread.sleep(3000);

    	// Step 3:Click outside the dropdown using Actions
    	WebElement body = driver.findElement(By.tagName("body"));
    	body.click(); // This will close the dropdown
    	Thread.sleep(3000);
    	Thread.sleep(3000);
    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
    	base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
    			
    	// Step 4:Select EVENTS/PRACTICE/SCOUT
    	// Expected:Successfully selected the EVENTS
    	base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

    	//Step 5:click on search button and search for team name SnipCreation
    	//Expected:SnipCreation team is shown 
    	base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
    	base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), MoveGame_TestData.TC_09_teamName);

    	//Step 6:Selecting the team
    	//Expected:Team selected
    	base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_09_teamName));
    	asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_09_teamName)), "Failed to select TEAM");
    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
    			
    	// Step 7 :Create a new Event
    	// Expected: New Event is created
    	base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
    	Thread.sleep(2000);
    	base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),MoveGame_TestData.TC_09_MoveGameEventName);
    	Thread.sleep(1000);
    	String Game_Name = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
    	base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
    	base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
    	base.buttonClick(addupdateremoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
    	asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
    	Thread.sleep(3000);

    	base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
    	// page loading so need this time
    	Thread.sleep(8000);
    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(Game_Name)),"Unable to Click on the menu icon (three dots)");
    	base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
    			
    	//Step 8   :"Locate Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
    	//Expected :"Move Game Popup Displayed"
    	base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name));
    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
    	base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
    	
		//Step 9   :"Click the Organization Option from the dropdown."
		//Expected :"User able to select the Organization"
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
		base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
		base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_09_Org2));
		base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_09_Org2));
		
		//Step 10   :"Select on game mode (Event/Scout/Practices) and click MOVE"
		//Expected :"User able to Select the Game Mode and Able to Click MOVE , Success Message Found"
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Scout")),"Unable to Select/Click Game Mode Practice");
		base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Scout"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
		base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Game moved successfully.")),"Confirmation Message not Found / Can't close PopUp");
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
         
        //Step 11   :"Select the Game Moved Organization"
 		//Expected :"User should be navigated to OrgName list and select the OrgName"
        asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"Unable to view the Organization");
        base.scrollToElementtoCenter(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
 		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_09_Org2);
 		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and not able to select OrgName");

 		//Step 12 : "The game should be successfully moved from Practice to Scout, and it should now appear in the Scout section."
 		//Expected: The game should displayed to the specified organization and game mode
 		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "SCOUT")),"Unable to change Game Mode to SCOUT/Inaccessible ");
 		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "SCOUT"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "SCOUT"));
		Thread.sleep(3000);
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",Game_Name)),"User unable to view the moved game from Practice to Scout, and it not appears in the Scout section.");
		
		//----------------------------------------------------------------------------------------------------
		//Step 13   :"(Vice-versa Game)Locate the Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
		//Expected :"Move Game Popup Displayed"
		Thread.sleep(3000);
		base.excuteJsClick(MoveGameObj.Btn_3Dots(Game_Name));
		//asrt.assertTrue(base.isExists(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
		base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
		base.excuteJsClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
		 
		//Step 14   :"(Vice-versa Game)Click the Organization Option from the dropdown."
		//Expected :"User able to select the Organization"
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
		base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
		base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_09_Org));
		base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_09_Org));
		
		//Step 15   :"(Vice-versa Game)Select on game mode (Event/Scout/Practices) and click MOVE"
		//Expected :"User able to Select the Game Mode and Able to Click MOVE , Success Message Found"
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice")),"Unable to Select/Click Game Mode Practice");
		base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
		base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Game moved successfully.")),"Confirmation Message not Found / Can't close PopUp");
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
         
        //Step 16   :"(Vice-versa Game)Select the Game Moved Organization"
 		//Expected :"User should be navigated to OrgName list and select the OrgName"
        asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"Unable to view the Organization");
        base.scrollToElementtoCenter(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
 		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_09_Org);
 		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and not able to select OrgName");

 		//Step 17 : "The game should be successfully moved from Scout to Event, and it should now appear in the Film section."
 		//Expected: The game should displayed to the specified organization and game mode
 		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES")),"Unable to change Game Mode to PRACTICES/Inaccessible ");
 		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES"));
	    Thread.sleep(3000);
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",Game_Name)),"User unable to view the moved game from Scout to PRACTICES, and it not appears in the PRACTICES section.");
		
		driver.navigate().refresh();
	    try {
			 
			// Step 18: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    
			// Step 19: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 20: Click on yes in delete popup to delete added game
			//Expected: Yes clicked
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		} 
	}
	
		// <summary>
		// Test Case Title :"verify that , after a successful move, the game is visible only in the target section and removed from the original section"
		// Automation ID   : TC_10 
		// </summary>
		public void TC_10_MoveGame() throws InterruptedException
		{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
	        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
	        CommonData Commondata= new CommonData();
	        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    	FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
	    			
	    	// Step 1: Log in to SnipBack with valid credentials.
	    	// Expected: User should be navigated to the Homepage.
	    	login.loginToApplication(Commondata.UserName, Commondata.PassWord);
	    	Thread.sleep(5000);
	    			
	    	// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
	    	// Expected: The team should be selected from dropdown
	    	base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	    	base.buttonClick(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_10_Org));
	    	asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_10_Org)),"The organization is not selected");
	    	Thread.sleep(3000);

	    	// Step 3:Click outside the dropdown using Actions
	    	WebElement body = driver.findElement(By.tagName("body"));
	    	body.click(); // This will close the dropdown
	    	Thread.sleep(3000);
	    	Thread.sleep(3000);
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
	    	base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
	    			
	    	// Step 4:Select EVENTS/PRACTICE/SCOUT
	    	// Expected:Successfully selected the EVENTS
	    	base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

	    	//Step 5:click on search button and search for team name SnipCreation
	    	//Expected:SnipCreation team is shown 
	    	base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
	    	base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), MoveGame_TestData.TC_10_teamName);

	    	//Step 6:Selecting the team
	    	//Expected:Team selected
	    	base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_10_teamName));
	    	asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_10_teamName)), "Failed to select TEAM");
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
	    			
	    	// Step 7 :Create a new Event
	    	// Expected: New Event is created
	    	base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
	    	Thread.sleep(2000);
	    	base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),MoveGame_TestData.TC_10_MoveGameEventName);
	    	Thread.sleep(1000);
	    	String Game_Name = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
	    	base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
	    	base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
	    	base.buttonClick(addupdateremoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
	    	asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
	    	Thread.sleep(3000);

	    	base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	    	// page loading so need this time
	    	Thread.sleep(8000);
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(Game_Name)),"Unable to Click on the menu icon (three dots)");
	    	base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
	    			
	    	//Step 8   :"Locate Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
	    	//Expected :"Move Game Popup Displayed"
	    	base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name));
	    	asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
	    	base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			 
			//Step 9   :"Click the Organization Option from the dropdown."
			//Expected :"User able to select the Organization"
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_10_Org2));
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_10_Org2));
			
			//Step 10   :"Select on game mode (Event/Scout/Practices) and click MOVE"
			//Expected :"User able to Select the Game Mode and Able to Click MOVE , Success Message Found"
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice")),"Unable to Select/Click Game Mode Practice");
			base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
			base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
			asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Game moved successfully.")),"Confirmation Message not Found / Can't close PopUp");
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	         
	        //Step 11   :"Select the Game Moved Organization"
	 		//Expected :"User should be navigated to OrgName list and select the OrgName"
	        asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"Unable to view the Organization");
	        base.scrollToElementtoCenter(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	 		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_10_Org2);
	 		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and not able to select OrgName");

	 		//Step 12 : "The game should appear in the target section only ."
	 		//Expected: The game should displayed to the specified organization and game mode
	 		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES")),"Unable to change Game Mode to PRACTICES/Inaccessible ");
	 		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES"));
			base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES"));
			base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),Game_Name);
	        Actions actions = new Actions(driver);
	        actions.sendKeys(Keys.ENTER).perform();
	        Thread.sleep(5000);
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
			asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",Game_Name)),"User unable to view the moved game in target section");
			
			//Step 13   :"Select Original Section OrgName"
			//Expected :"User should be navigated to Original Section OrgName list and select the OrgName"
			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_10_Org);
			asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
			
			//Step 14   :Select Original Section Team from ORG
	        //Expected:The Original Section Team is Selected
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(MoveGame_TestData.TC_10_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
			base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(MoveGame_TestData.TC_10_teamName, "d-flex align-items-center item-label"));
			base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(MoveGame_TestData.TC_10_teamName, "d-flex align-items-center item-label"));
			
			//Step 15   :Game should be removed from the original section
	        //Expected:Game Name is  removed from the Orginal Section
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
			base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			Thread.sleep(3000);
		    asrt.assertTrue(driver.findElements(MoveGameObj.Btn_GameName("text-decoration-none text-reset",Game_Name)).isEmpty(), "Game is still in the original section.Game is not removed from the original section.");
			driver.navigate().refresh();
		    try {
				 
				// Step 16: Delete the added game by clicking 3 dot menu of the added game
				// Expected: Drop down item is displayed with a list
				base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name)); 
				Thread.sleep(1000);
				asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
			    
				// Step 17: Click on delete from the list
				// Expected: A popup with confirmation to delete is shown
				//base.buttonClick(CreateUpdateDeleteGameObj.Ele_ThreeDotDeleteBasedOnGameName(eventOrGameName));
				base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				
				// Step 18: Click on yes in delete popup to delete added game
				//Expected: yes clicked
				base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
				Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println("Not an bug: Unable to delete game");
			} 
		}
		
		// <summary>
		// Test Case Title :"The dropdown menu should appear, and the "Move Game" option should be visible in the list."
		// Automation ID   : TC_01
		// </summary>
		public void TC_01_MoveGame() throws InterruptedException
		{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
	        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
	        CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			CommonData Commondata= new CommonData();
			SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
			FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
			AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
			
			// Step 1: Log in to SnipBack with valid credentials.
			// Expected: User should be navigated to the Homepage.
			login.loginToApplication(Commondata.UserName, Commondata.PassWord);
			Thread.sleep(5000);
			
			// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
			// Expected: The team should be selected from dropdown
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_01_Org));
			asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_01_Org)),"The organization is not selected");
			Thread.sleep(3000);

			// Step 3:Click outside the dropdown using Actions
			WebElement body = driver.findElement(By.tagName("body"));
			body.click(); // This will close the dropdown
			Thread.sleep(3000);
			Thread.sleep(3000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
			base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			
			// Step 4:Select EVENTS/PRACTICE/SCOUT
			// Expected:Successfully selected the EVENTS
			base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

			//Step 5:click on search button and search for team name SnipCreation
			//Expected:SnipCreation team is shown 
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), MoveGame_TestData.TC_01_teamName);

			//Step 6:Selecting the team
			//Expected:Team selected
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_01_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_01_teamName)), "Failed to select TEAM");
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
			
			// Step 7 :Create a new Event
			// Expected: New Event is created
			base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
			Thread.sleep(2000);
			base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),MoveGame_TestData.TC_01_MoveGameEventName);
			Thread.sleep(1000);
			String Game_Name = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
			base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
			base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
			asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
			Thread.sleep(3000);

			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
			// page loading so need this time
			Thread.sleep(8000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(Game_Name)),"Unable to Click on the menu icon (three dots)");
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
			
			//Step 8   :"Locate Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
			//Expected :"Move Game Popup Displayed"
			base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
		    base.returnToMainWindow(driver);
		    try {
				 
				// Step 9: Delete the added game by clicking 3 dot menu of the added game
				// Expected: Drop down item is displayed with a list
				base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name)); 
				Thread.sleep(1000);
				asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
			    
				// Step 10: Click on delete from the list
				// Expected: A popup with confirmation to delete is shown
				//base.buttonClick(CreateUpdateDeleteGameObj.Ele_ThreeDotDeleteBasedOnGameName(eventOrGameName));
				base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				
				// Step 11: Click on yes in delete popup to delete added game
				base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
				Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println("Not an bug: Unable to delete game");
			}
		}
		
		// <summary>
		// Test Case Title :"A "Move Game" popup should appear with fields for selecting the organization and game mode."
		// Automation ID   : TC_02
		// </summary>

		public void TC_02_MoveGame() throws InterruptedException
			{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();    	
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		    MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		    TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			CommonData Commondata= new CommonData();
			SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
			FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
			AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
			
			// Step 1: Log in to SnipBack with valid credentials.
			// Expected: User should be navigated to the Homepage.
			login.loginToApplication(Commondata.UserName, Commondata.PassWord);
			Thread.sleep(5000);
			
			// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
			// Expected: The team should be selected from dropdown
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_02_Org));
			asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_02_Org)),"The organization is not selected");
			Thread.sleep(3000);

			// Step 3:Click outside the dropdown using Actions
			WebElement body = driver.findElement(By.tagName("body"));
			body.click(); // This will close the dropdown
			Thread.sleep(3000);
			Thread.sleep(3000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
			base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			
			// Step 4:Select EVENTS/PRACTICE/SCOUT
			// Expected:Successfully selected the EVENTS
			base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

			//Step 5:click on search button and search for team name SnipCreation
			//Expected:SnipCreation team is shown 
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), MoveGame_TestData.TC_02_teamName);

			//Step 6:Selecting the team
			//Expected:Team selected
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_02_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_02_teamName)), "Failed to select TEAM");
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
			
			// Step 7 :Create a new Event
			// Expected: New Event is created
			base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
			Thread.sleep(2000);
			base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),MoveGame_TestData.TC_02_MoveGameEventName);
			Thread.sleep(1000);
			String Game_Name = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
			base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
			base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
			asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
			Thread.sleep(3000);

			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
			// page loading so need this time
			Thread.sleep(8000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(Game_Name)),"Unable to Click on the menu icon (three dots)");
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
			
			//Step 8   :"Locate Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
			//Expected :"Move Game Popup Displayed"
			base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			asrt.assertTrue(base.isExists(MoveGameObj.Ele_HeaderOfPopup("moveGameModal","h5")),"Move Game Popup is not displayed" );
 
			Thread.sleep(2000);
			//Step 9   :"A "Move Game" popup should appear with fields for selecting the organization and game mode."
			//Expected :"Move Game Popup with organisation and game mode options"
			asrt.assertEquals(base.GetText(MoveGameObj.Ele_HeaderOfPopup("moveGameModal","h5")), "Move Game","Move Game text is not correct");
			asrt.assertEquals(base.GetText(MoveGameObj.Ele_OrganisationAndGameModeInPopup("moveGameModal","mb-3 d-flex justify-content-between dd_organization-wrap")), "Organization","Organization is not displayed or the text spelling is incorrect");
			asrt.assertEquals(base.GetText(MoveGameObj.Ele_OrganisationAndGameModeInPopup("moveGameModal","mb-3 d-flex justify-content-between")), "Game Mode","Game Mode is not displayed or the text spelling is incorrect");

		    base.returnToMainWindow(driver);
		    driver.navigate().refresh();
		    try {
				 
				// Step 10: Delete the added game by clicking 3 dot menu of the added game
				// Expected: Drop down item is displayed with a list
				base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name)); 
				Thread.sleep(1000);
				asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
			    
				// Step 11: Click on delete from the list
				// Expected: A popup with confirmation to delete is shown
				//base.buttonClick(CreateUpdateDeleteGameObj.Ele_ThreeDotDeleteBasedOnGameName(eventOrGameName));
				base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				
				// Step 12: Click on yes in delete popup to delete added game
				//Expected: Yes clicked
				base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
				Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println("Not an bug: Unable to delete game");
			}
		}
	
		// <summary>
		// Test Case Title :"Organization and game mode fields should be available for selection."
		// Automation ID   : TC_03
		// </summary>

		public void TC_03_MoveGame() throws InterruptedException
			{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		    MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		    CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();
		    CommonData Commondata= new CommonData();
			SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
			FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
			AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
			
			// Step 1: Log in to SnipBack with valid credentials.
			// Expected: User should be navigated to the Homepage.
			login.loginToApplication(Commondata.UserName, Commondata.PassWord);
			Thread.sleep(5000);
			
			// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
			// Expected: The team should be selected from dropdown
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_03_Org));
			asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(MoveGame_TestData.TC_03_Org)),"The organization is not selected");
			Thread.sleep(3000);

			// Step 3:Click outside the dropdown using Actions
			WebElement body = driver.findElement(By.tagName("body"));
			body.click(); // This will close the dropdown
			Thread.sleep(3000);
			Thread.sleep(3000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
			base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			
			// Step 4:Select EVENTS/PRACTICE/SCOUT
			// Expected:Successfully selected the EVENTS
			base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

			//Step 5:click on search button and search for team name SnipCreation
			//Expected:SnipCreation team is shown 
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), MoveGame_TestData.TC_03_teamName);

			//Step 6:Selecting the team
			//Expected:Team selected
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_03_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",MoveGame_TestData.TC_03_teamName)), "Failed to select TEAM");
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
			
			// Step 7 :Create a new Event
			// Expected: New Event is created
			base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
			Thread.sleep(2000);
			base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),MoveGame_TestData.TC_03_MoveGameEventName);
			Thread.sleep(1000);
			String Game_Name = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
			base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
			base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
			asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
			Thread.sleep(3000);

			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
			// page loading so need this time
			Thread.sleep(8000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(Game_Name)),"Unable to Click on the menu icon (three dots)");
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(Game_Name));
			
			//Step 8   :"Locate Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
			//Expected :"Move Game Popup Displayed"
			base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			Thread.sleep(2000);
			asrt.assertTrue(base.isExists(MoveGameObj.Ele_OrganisationSelectionArrowInMoveGamePopup("filter-switch4","ul")),"Organisation field is not present for selection");
			
			//Step 9   :"Verify organization lists are shown"
			//Expected :"List of organizations in Move Game Pop up"
			base.buttonClick(MoveGameObj.Ele_OrganisationSelectionArrowInMoveGamePopup("filter-switch4","ul"));
			Thread.sleep(8000); 
 
			List<WebElement> allOrganisationInMoveGame = driver.findElements(CreateUpdateDeleteGameObj.Ele_Time("dropdown__select-option dd_organization"));		

			//Step 10   :"Verify Organization fields should be available for selection."
			
			if(allOrganisationInMoveGame.size()>1) {

				for(int i=0;i<=allOrganisationInMoveGame.size();i++) {
				String organizationNamePrevious=	allOrganisationInMoveGame.get(0).getText();
					allOrganisationInMoveGame.get(1).click();
					Thread.sleep(1000);
					String organizationNameUpdated =	allOrganisationInMoveGame.get(0).getText();	
					asrt.assertNotEquals(organizationNamePrevious, organizationNameUpdated,"DropDown list is not working");
					break;
				}
				
			}
			else {
				asrt.fail("No list is shown in organisation in Move Game");
			}
			
			
		  //Step 11  :"Verify game mode fields should be available for selection."
		  asrt.assertTrue(base.isExists(MoveGameObj.Ele_ListOfGameModesInMoveGamePopup("move-game-type","div")),"game mode field is not present for selection");

          List<String> listOfGameModes=base.GetElementTexts(MoveGameObj.Ele_ListOfGameModesInMoveGamePopup("move-game-type","div")); 
          List<String> expectedList= Arrays.asList("Scout","Practice","Event");
          asrt.assertEquals(listOfGameModes, expectedList,"both list is not matching");
         
          base.returnToMainWindow(driver);
          driver.navigate().refresh();
		    try {
				 
				// Step 12: Delete the added game by clicking 3 dot menu of the added game
				// Expected: Drop down item is displayed with a list
				base.buttonClick(MoveGameObj.Btn_3Dots(Game_Name)); 
				Thread.sleep(1000);
				asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
			    
				// Step 13: Click on delete from the list
				// Expected: A popup with confirmation to delete is shown
				//base.buttonClick(CreateUpdateDeleteGameObj.Ele_ThreeDotDeleteBasedOnGameName(eventOrGameName));
				base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
				
				// Step 14: Click on yes in delete popup to delete added game
				base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
				Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println("Not an bug: Unable to delete game");
			}
          	
}	
		// <summary>
		// Test Case Title :"Verify that  to move a film from one organization to another organization the Game should be move along with the snips"
		// Automation ID   : TC_11 
		// </summary>
		public void TC_11_MoveGame() throws InterruptedException
		{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
	        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
	        Actions actions = new Actions(driver);
			
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
			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_11_Org);
			String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(MoveGame_TestData.TC_11_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
			base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(MoveGame_TestData.TC_11_teamName, "d-flex align-items-center item-label"));
			
			//Step 6   :Select a Team from ORG
	        //Expected:The New Team is Selected
			base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(MoveGame_TestData.TC_11_teamName, "d-flex align-items-center item-label"));
			Thread.sleep(3000);			
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
			base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			
			//Step 7   :Select EVENTS/PRACTICES/SCOUT
	        //Expected:Successfully selected the EVENTS 
			base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			
		    //Step 8  :Click on Game and Navigate to Player Page(Video play)
     		//Expected: Successfully Navigate to Player Page
			String originalWindow = driver.getWindowHandle();//store the current window
			base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),MoveGame_TestData.TC_11_GameName);
			Thread.sleep(5000);
	        actions.sendKeys(Keys.ENTER).perform();
	        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_11_GameName)),"Event Game is not Visible");
	        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_11_GameName));
	        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_11_GameName));	 
	        Thread.sleep(5000);
	        base.switchToWindowByIndex(driver,1);//Switching to another window
	        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+MoveGame_TestData.TC_11_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
	        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-snip")),"Unable to take Snip of the Video");
	        
	        //Step 9  :Create a new Snip And Take the count of the My Snips fully
     		//Expected: Successfully Created a Snip and Take the Count
	        base.buttonClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-snip"));
	        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateMySnip("d-flex flex-column bg-body list-wrap pb-3", "My Snips")),"Unable to select the Type of Snip needed");
	        base.buttonClick(MoveGameObj.Btn_Video_CreateMySnip("d-flex flex-column bg-body list-wrap pb-3", "My Snips"));
			base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
	        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateBtnSnip("swal-button-container", "Snip")),"Unable to select the 'Snip' in Snip section details");
	        base.buttonClick(MoveGameObj.Btn_Video_CreateBtnSnip("swal-button-container", "Snip"));
	        base.buttonClick(MoveGameObj.Btn_Video_SnipDetails("row entire-video-shot-section", "My Snips"));
	        Thread.sleep(5000);
	        List<WebElement> NoOfSnips = driver.findElements(MoveGameObj.Ele_FrameCount("allFrame"));
	        int count = NoOfSnips.size();
	        driver.switchTo().window(originalWindow);
			Thread.sleep(800);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(MoveGame_TestData.TC_11_GameName)),"Unable to Click on the menu icon (three dots)");
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(MoveGame_TestData.TC_11_GameName));
			
			//Step 10   :"Locate Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
			//Expected :"Move Game Popup Displayed"
	        base.buttonClick(MoveGameObj.Btn_3Dots(MoveGame_TestData.TC_11_GameName));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
			
			//Step 11   :"Click the Organization Option from the dropdown."
			//Expected :"User able to select the Organization"
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_11_Org2));
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_11_Org2));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice")),"Unable to Select/Click Game Mode Practice");
			
			//Step 12   :"Select on game mode (Film/Scout/Practices) and click MOVE"
			//Expected :"User able to Select the Game Mode and Able to Click MOVE , Success Message Found"
			base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
			base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
			asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Game moved successfully.")),"Confirmation Message not Found / Can't close PopUp");
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	         
	        //Step 13   :"Select the Game Moved Organization"
	 		//Expected :"User should be navigated to OrgName list and select the OrgName"
	        asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"Unable to view the Organization");
	        base.scrollToElementtoCenter(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	 		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_11_Org2);
	 		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and not able to select OrgName");
	 		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES")),"Unable to change Game Mode to PRACTICES/Inaccessible ");
	 		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES"));
			
	 		//Step 14 : "The game should be successfully moved from Film to Practices, and it should now appear in the Practices section."
	 		//Expected: The game should displayed to the specified organization and game mode
	 		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES"));
			Thread.sleep(3000);
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(MoveGame_TestData.TC_11_GameName));
			asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_11_GameName)),"User unable to view the moved game from Event to Practices, and it not appears in the Practices section.");
			
			//Step 15  :Search for MySnip And Check the My Snips are moved
			//Expected: To move a film from one organization to another organization the game should be move along with the snips
			String originalWindow2 = driver.getWindowHandle();//store the current window
			Thread.sleep(3000);
			asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_11_GameName)),"Event Game is not Visible");
	        base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_11_GameName));	 
	        Thread.sleep(10000);
	        base.switchToWindowByIndex(driver,2);//Switching to another window
	        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+MoveGame_TestData.TC_11_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
      
	        List<WebElement> NoOfSnips2 = driver.findElements(MoveGameObj.Ele_FrameCount("allFrame"));
	        int count2 = NoOfSnips2.size();
	        asrt.assertEquals(count2, count, "Game is not moved along with the snips");
	        driver.switchTo().window(originalWindow);
			Thread.sleep(800);
			//----------------------------------------------------------------------------------------------------
			//Step 16   :"(Vice-versa Game)Locate the Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
			//Expected :"Move Game Popup Displayed"
			Thread.sleep(3000);
			base.excuteJsClick(MoveGameObj.Btn_3Dots(MoveGame_TestData.TC_11_GameName));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			base.excuteJsClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
			
			//Step 17   :"(Vice-versa Game)Click the Organization Option from the dropdown."
			//Expected :"User able to select the Organization"
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_11_Org));
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_11_Org));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Event")),"Unable to Select/Click Game Mode Event");
			
			//Step 18   :"(Vice-versa Game)Select on game mode (Event/Scout/Practices) and click MOVE"
			//Expected :"User able to Select the Game Mode and Able to Click MOVE , Success Message Found"
			base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Event"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
			base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
			asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Game moved successfully.")),"Confirmation Message not Found / Can't close PopUp");
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	         
	        //Step 19   :"(Vice-versa Game)Select the Game Moved Organization"
	 		//Expected :"User should be navigated to OrgName list and select the OrgName"
	        asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"Unable to view the Organization");
	        base.scrollToElementtoCenter(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	 		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),MoveGame_TestData.TC_11_Org);
	 		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and not able to select OrgName");
	 		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"Unable to change Game Mode to EVENTS/Inaccessible ");
	 		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			
	 		//Step 20 : "The game should be successfully moved from Practices to Event, and it should now appear in the Events section."
	 		//Expected: The game should displayed to the specified organization and game mode
	 		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),MoveGame_TestData.TC_11_GameName);
		    actions.sendKeys(Keys.ENTER).perform();
		    Thread.sleep(5000);
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(MoveGame_TestData.TC_11_GameName));
			asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_11_GameName)),"User unable to view the moved game from Practices to Event, and it not appears in the Events section.");
		
		}
        // <summary>
		// Test Case Title :"Verify that to move a film from one organization to another organization, tags should not be moved"
		// Automation ID   : TC_12 
		// </summary>
		public void TC_12_MoveGame() throws InterruptedException
		{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		    Actions actions = new Actions(driver);
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
	        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
	        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
			
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
			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),MoveGame_TestData.TC_12_Org);
			String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
			
			//Step 6   :Select a Team from ORG
	        //Expected:The New Team is Selected
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(MoveGame_TestData.TC_12_teamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
			base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(MoveGame_TestData.TC_12_teamName, "d-flex align-items-center item-label"));
			base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(MoveGame_TestData.TC_12_teamName, "d-flex align-items-center item-label"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
			base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			
			//Step 7   :Select EVENTS/PRACTICES/SCOUT
	        //Expected:Successfully selected the EVENTS 
			base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			
		    //Step 8  :Click on Game and Navigate to Player Page(Video play)
     		//Expected: Successfully Navigate to Player Page
			String originalWindow = driver.getWindowHandle();//store the current window
			base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),MoveGame_TestData.TC_12_GameName);
			Thread.sleep(5000);
	        actions.sendKeys(Keys.ENTER).perform();
	        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_12_GameName)),"Event Game is not Visible");
	        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_12_GameName));
	        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_12_GameName));	 
	        Thread.sleep(5000);
	        base.switchToWindowByIndex(driver,1);//Switching to another window
	        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+MoveGame_TestData.TC_12_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
	        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-snip")),"Unable to take Snip of the Video");
	        
	        //Step 9  :Create a new Tag Snip And Take the name of the tagged Snips 
     		//Expected: Successfully Created a Tag Snip 
	        base.buttonClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-snip"));
	        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateMySnip("d-flex flex-column bg-body list-wrap pb-3", "My Snips")),"Unable to select the Type of Snip needed");
	        base.buttonClick(MoveGameObj.Btn_Video_CreateMySnip("d-flex flex-column bg-body list-wrap pb-3", "My Snips"));
	        base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
	        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateBtnSnip("swal-button-container", "Snip with Tag")),"Unable to select the 'Snip with Tag' in Snip section details");
	        base.buttonClick(MoveGameObj.Btn_Video_CreateBtnSnip("swal-button-container", "Snip with Tag"));
	        Thread.sleep(5000);
	        //asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item nav-tab active","Home Collections")),"Home Collection not avilable");
	        //base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item nav-tab active","Home Collections"));
	        //asrt.assertTrue(base.isExists(MoveGameObj.Ele_TagNameGame("custom-tag-listing collection-list")),"Unable to select the tag needed for Snip");
	        //String TagName= base.GetText(MoveGameObj.Ele_TagNameGame("custom-tag-listing collection-list"));
	        //base.buttonClick(MoveGameObj.Ele_TagNameGame("custom-tag-listing collection-list"));
	        //asrt.assertTrue(base.isExists(MoveGameObj.Ele_ConfirmSnipTag("snip-collection-section","✓")),"Unable to Create tags for Snip");
	        //base.scrollToElementtoCenter(MoveGameObj.Ele_ConfirmSnipTag("snip-collection-section","✓"));
	        //base.buttonClick(MoveGameObj.Ele_ConfirmSnipTag("snip-collection-section","✓"));
			//Step 10: Verify Custom Tags is displaying
			//Expected:"User should able to select 'Custom Tags'
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","usa")),"'usa' option is not displayed in the Basketball list");
			base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","usa"));
			String TagName= base.GetText(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","usa"));
	        
			//Step 10 :"Select Tag from list"
			//Expected:"User should be select Tag from List
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","usa"));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton")),"'Tick' option is not displayed in the Custom Tag page");
			base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton"));
			
			//Step 11:Click on Tick icon
			//Expected:"User should be select tick icon"
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton"));

			//Step12: Verify a bookmark with usa tagname is created below videoplayer
			//Expected:A bookmark with the usa tag name is created below the video player.
			Thread.sleep(1000);
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TagBox("mysnips","shot-username pad-c")),"'Tag Box' option is not displayed below video");	
	        
			//Step 13   :"Locate Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
			//Expected :"Move Game Popup Displayed"
	        driver.switchTo().window(originalWindow);
			Thread.sleep(800);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(MoveGame_TestData.TC_12_GameName)),"Unable to Click on the menu icon (three dots)");
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(MoveGame_TestData.TC_12_GameName));
			base.excuteJsClick(MoveGameObj.Btn_3Dots(MoveGame_TestData.TC_12_GameName));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
			
			//Step 14  :"Click the Organization Option from the dropdown."
			//Expected :"User able to select the Organization"
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_12_Org2));
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_12_Org2));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice")),"Unable to Select/Click Game Mode Practice");
			
			//Step 15   :"Select on game mode (Film/Scout/Practices) and click MOVE"
			//Expected :"User able to Select the Game Mode and Able to Click MOVE , Success Message Found"
			base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Practice"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
			base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
			asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Game moved successfully.")),"Confirmation Message not Found / Can't close PopUp");
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	         
	        //Step 16   :"Select the Game Moved Organization"
	 		//Expected :"User should be navigated to OrgName list and select the OrgName"
	        asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"Unable to view the Organization");
	        base.scrollToElementtoCenter(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	 		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_12_Org2);
	 		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and not able to select OrgName");
	 		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES")),"Unable to change Game Mode to PRACTICES/Inaccessible ");
	 		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES"));
			
	 		//Step 17 : "The game should be successfully moved from Film to Practices, and it should now appear in the Practices section."
	 		//Expected: The game should displayed to the specified organization and game mode
	 		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "PRACTICES"));
			Thread.sleep(3000);
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(MoveGame_TestData.TC_12_GameName));
			asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_12_GameName)),"User unable to view the moved game from Event to Practices, and it not appears in the Practices section.");
			
			//Step 18  :Search for MySnip And Check the tags should not be moved from prev Org
			//Expected: To move a film from one organization to another organization tags should not be moved
			String originalWindow2 = driver.getWindowHandle();//store the current window
			Thread.sleep(3000);
			asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_12_GameName)),"Event Game is not Visible");
	        base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_12_GameName));	 
	        Thread.sleep(10000);
	        base.switchToWindowByIndex(driver,2);//Switching to another window
	        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+MoveGame_TestData.TC_12_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
	        Thread.sleep(5000);
	        asrt.assertTrue(driver.findElements(MoveGameObj.Ele_FrameTextMatch("allFrame",TagName)).isEmpty(),"Tagname is also moved from prev Organization ");
	        
	        driver.switchTo().window(originalWindow);
			Thread.sleep(800);
			//----------------------------------------------------------------------------------------------------
			//Step 19   :"(Vice-versa Game)Locate the Event and Click on the menu icon (three dots) ,Select and click "Move Game" from the dropdown."
			//Expected :"Move Game Popup Displayed"
			Thread.sleep(3000);
			base.excuteJsClick(MoveGameObj.Btn_3Dots(MoveGame_TestData.TC_12_GameName));
			//asrt.assertTrue(base.isExists(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game")),"\"Move Game\" from the dropdown not Found/Non-clickable");
			base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			base.excuteJsClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Move Game"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list")),"Unable to click Organization Option from the dropdown");
			
			//Step 20   :"(Vice-versa Game)Click the Organization Option from the dropdown."
			//Expected :"User able to select the Organization"
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg("outer d-flex","dropdown__filter-selected category_selected dropdown-list"));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_12_Org));
			base.buttonClick(MoveGameObj.Ddl_PopUpDropDownOrg2("dropdown__select scrollspy-example",MoveGame_TestData.TC_12_Org));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Event")),"Unable to Select/Click Game Mode Event");
			
			//Step 21   :"(Vice-versa Game)Select on game mode (Event/Scout/Practices) and click MOVE"
			//Expected :"User able to Select the Game Mode and Able to Click MOVE , Success Message Found"
			base.buttonClick(MoveGameObj.Btn_PopUpGameMode("toggle-item-movegame", "Event"));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE")),"MOVE Button NotFound/Non-clickable");
			base.buttonClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "MOVE"));
			asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Game moved successfully.")),"Confirmation Message not Found / Can't close PopUp");
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	         
	        //Step 22  :"(Vice-versa Game)Select the Game Moved Organization"
	 		//Expected :"User should be navigated to OrgName list and select the OrgName"
	        asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"Unable to view the Organization");
	        base.scrollToElementtoCenter(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	 		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), MoveGame_TestData.TC_12_Org);
	 		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and not able to select OrgName");
	 		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"Unable to change Game Mode to EVENTS/Inaccessible ");
	 		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			
	 		//Step 23 : "The game should be successfully moved from Practices to Event, and it should now appear in the Events section."
	 		//Expected: The game should displayed to the specified organization and game mode
	 		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
			base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),MoveGame_TestData.TC_12_GameName);	    
		    actions.sendKeys(Keys.ENTER).perform();
		    Thread.sleep(5000);
			base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(MoveGame_TestData.TC_12_GameName));
			asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",MoveGame_TestData.TC_12_GameName)),"User unable to view the moved game from Practices to Event, and it not appears in the Events section.");
		
		}
	
  }

