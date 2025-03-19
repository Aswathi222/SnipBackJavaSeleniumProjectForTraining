package testPage.MavenPageObject;
import static org.testng.Assert.assertEquals;

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
import TestData.CreateAddNewMemberWithEmail_TestData;
import TestData.DeleteSnip_TestData;
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
import objectRepository.DeleteSnipPlayer_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;

public class DeleteSnipPlayer extends BasePge {
	BasePge base;
	Assert asrt;

	public DeleteSnipPlayer(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify whether there is a option to delete snip from player page."
	// Automation ID   : Delete_01_DeleteSnip 
	// </summary>
	public void Delete_01_DeleteSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		DeleteSnip_TestData DeleteSnipTestData = new DeleteSnip_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DeleteSnipTestData.Delete_01_DeleteSSnip);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library")),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));
		base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));	 
		Thread.sleep(3000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - Library")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify whether there is a option to delete snip from player page.
		//Expected:There should be an option to delete snip from player page.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_Snip("mysnips", "frameshot2"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("delete-bookmark-btnsection deleteBM btn")),"No Option to Delete Snip from Player Page");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks Delete Bookmark button."
	// Automation ID   : Delete_02_DeleteSnip 
	// </summary>
	public void Delete_02_DeleteSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnip_TestData DeleteSnipTestData = new DeleteSnip_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),DeleteSnipTestData.Delete_01_DeleteSSnip);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library")),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));
		Thread.sleep(5000);
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));	 
		Thread.sleep(3000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - Library")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify what happens when user clicks Delete Bookmark button.
		//Expected:A confirmation message pop-up appears, "Are you sure want to delete this (Snip No.1) ?"
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_Snip("mysnips", "frameshot3"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("delete-bookmark-btnsection deleteBM btn")),"No Option to Delete Snip from Player Page");
		base.excuteJsClick(LoginPageObj.Ele_ErrorMessage("delete-bookmark-btnsection deleteBM btn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Do you want to delete snip 3?")),"A confirmation message pop-up is not displayed, \"Are you sure want to delete snip 3?");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks 'Yes' in the confirmation popup."
	// Automation ID   : Delete_03_DeleteSnip 
	// </summary>
	public void Delete_03_DeleteSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnip_TestData DeleteSnipTestData = new DeleteSnip_TestData();
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),DeleteSnipTestData.Delete_01_DeleteSSnip);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		base.setZoom(driver, 55);
		Thread.sleep(3000);		
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));
		Thread.sleep(5000);
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));	 
		Thread.sleep(3000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - Library")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Creating Snip-----So that No Snip issues will
		//Step 9:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

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
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step12: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton")),"'Tick' option is not displayed in the Custom Tag page");
		
		//Step 13 : Click tick icon
		//Expected : A bookmark named "No_tag" is created below the video player.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton"));	
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("shot-username pad-c")),"User is not able to view a bookmark named 'No_tag' below the video player.");
		Thread.sleep(3000);
		
		//Step 14  :To verify what happens when user clicks 'Yes' in the confirmation popup.
		//Expected: receive a success message at the left side of the screen for few seconds ie., "Snip has been deleted successfully"
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_Snip("mysnips","frameshot2"));
//		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelectSnip("mysnips","allFrame"));//, "frameshot3"
//		Thread.sleep(6000); //need this much time to recover
//		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelectSnip("mysnips","allFrame"));//, "frameshot3"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("delete-bookmark-btnsection deleteBM btn")),"No Option to Delete Snip from Player Page");
		base.excuteJsClick(LoginPageObj.Ele_ErrorMessage("delete-bookmark-btnsection deleteBM btn"));
		asrt.assertTrue(base.isExists(DeleteSnipPlayerObj.Btn_Message("Do you want to delete snip")),"A confirmation message pop-up is not displayed, \"Are you sure want to delete snip 3?");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm swal-button--danger"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Snip has been deleted successfully")),"User not receives a success message at the left side of the screen for few seconds ie., \"Snip has been deleted successfully\"");
	}

	// <summary>
	// Test Case Title :To verify what happens when user clicks "Cancel" in the confirmation popup.
	// Automation ID   : Delete_04_DeleteSnip 
	// </summary>
	public void Delete_04_DeleteSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		DeleteSnip_TestData DeleteSnipTestData = new DeleteSnip_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),DeleteSnipTestData.Delete_01_DeleteSSnip);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library")),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));
		Thread.sleep(5000);
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));	 
		Thread.sleep(3000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - Library")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify what happens when user clicks "Cancel" in the confirmation popup.
		//Expected: The confirmation popup closes once user clicks Cancel option.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_Snip("mysnips", "frameshot3"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("delete-bookmark-btnsection deleteBM btn")),"No Option to Delete Snip from Player Page");
		base.excuteJsClick(LoginPageObj.Ele_ErrorMessage("delete-bookmark-btnsection deleteBM btn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Do you want to delete snip 3?")),"A confirmation message pop-up is not displayed, \"Are you sure want to delete snip 3?");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("mysnips")),"The confirmation popup closes and user not able to view the Mysnips in game page.");
	}
}

