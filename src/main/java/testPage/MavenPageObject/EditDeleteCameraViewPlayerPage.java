package testPage.MavenPageObject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import TestData.CommonData;
import TestData.CreateUpdateDeleteGame_TestData;
import TestData.EditDeleteCameraViewPlayerPage_TestData;
import TestData.SnipCreationWithAndWithoutTag_TestData;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.CreateUpdateDeleteGame_Obj;
import objectRepository.EditDeleteCameraViewPlayerPage_Obj;
import objectRepository.FilterMembers_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.TrimVideo_Obj;
import objectRepository.ViewListUpdateDownloadShareDeleteLibrary_Obj;
import utilPack.BasePge;

public class EditDeleteCameraViewPlayerPage extends BasePge {

	BasePge base;
	Assert asrt; 

	public EditDeleteCameraViewPlayerPage(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	///<summary>
	// Test Case Title:"To verify that the "Edit" and "Delete" options  are available in the Camera View"
	// Automation ID  : Cam V_1
	///</summary>
	public void CamV_1_EditDeleteCameraViewPlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
 	    EditDeleteCameraViewPlayerPage_TestData EditDeleteCameraViewPlayerPageTestData=new EditDeleteCameraViewPlayerPage_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), EditDeleteCameraViewPlayerPageTestData.CamV_1_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditDeleteCameraViewPlayerPageTestData.CamV_1_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_1_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_1_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_1_eventOrGameName)),"Event Game is not Visible");

	    //Step 7  :Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_1_eventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+EditDeleteCameraViewPlayerPageTestData.CamV_1_eventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		// Step 9 : Verify "CAMERA VIEW" header is visible on the right side  
		// Expected : User should see the 'Camera View' icon on the right side of the player page
	    asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("shot-user-tile")),"' CAMERA VIEW 'is not displayed on the right side of the player page");
		Thread.sleep(2000);	
		
		//Step 10 : Verify "Edit" /"Delete" option in camera view
		//Expected: Both "Edit" and "Delete" options should be visible and accessible in Camera view
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt")),"Edit icon is not displayed in Camera View");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-trash")),"Delete icon is not displayed in Camera View");
        asrt.assertTrue(base.isEnabledBy(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt")),"Edit icon is not enabled in Camera View");
		asrt.assertTrue(base.isEnabledBy(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-trash")),"Delete icon is not enabled in Camera View");
	}
	
	///<summary>
	// Test Case Title:"To verify that when the user clicks the "Edit" button, then a dialog box with text field. "Save" and "Cancel" options appears"
	// Automation ID  : Cam V_2
	///</summary>
	public void CamV_2_EditDeleteCameraViewPlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
 	    EditDeleteCameraViewPlayerPage_TestData EditDeleteCameraViewPlayerPageTestData=new EditDeleteCameraViewPlayerPage_TestData();
	    EditDeleteCameraViewPlayerPage_Obj EditDeleteCameraViewPlayerPageObj=new EditDeleteCameraViewPlayerPage_Obj();
		
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), EditDeleteCameraViewPlayerPageTestData.CamV_2_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditDeleteCameraViewPlayerPageTestData.CamV_2_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_2_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_2_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_2_eventOrGameName)),"Event Game is not Visible");
		
	    //Step 7  :Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_2_eventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+EditDeleteCameraViewPlayerPageTestData.CamV_2_eventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		// Step 8 : Verify "CAMERA VIEW" header  
		// Expected : User should see the 'Camera View' icon on the right side of the player page
	    asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("shot-user-tile")),"' CAMERA VIEW 'is not displayed on the right side of the player page");
		Thread.sleep(2000);	
		
		//Step 9 : Verify "Edit" option in camera view
		//Expected: User should view the "Edit" option accessible in Camera view
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt")),"Edit icon is not displayed in Camera View");
        asrt.assertTrue(base.isEnabledBy(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt")),"Edit icon is not enabled in Camera View");
		
        // Step 10 : Click on edit icon in "CAMERA VIEW"
		// Expected :After clicking the "Edit" button, a dialog box should opens with a text field , save and cancel option
        base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt"));
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("edit_session_name")),"text box is not displayed in edit CAMERA VIEW");
        asrt.assertTrue(base.isExists(EditDeleteCameraViewPlayerPageObj.Btn_Edit("edit_session_id","btn btn-outline-danger session-rename-confirm")),"Save button is not displayed in edit CAMERA VIEW");
        asrt.assertTrue(base.isExists(EditDeleteCameraViewPlayerPageObj.Btn_Edit("edit_session_id","btn btn-outline-danger")),"Cancel button is not displayed in edit CAMERA VIEW");
        asrt.assertEquals(base.GetText(EditDeleteCameraViewPlayerPageObj.Btn_Edit("edit_session_id","btn btn-outline-danger session-rename-confirm")), "Save","Save button text is incorrect in edit CAMERA VIEW");
        asrt.assertEquals(base.GetText(EditDeleteCameraViewPlayerPageObj.Btn_Edit("edit_session_id","btn btn-outline-danger")), "Cancel","Cancel button text is incorrect in edit CAMERA VIEW");
	}
	
	///<summary>
	// Test Case Title:"Verify that a user can edit Camera name in text field"
	// Automation ID  : Cam V_3
	///</summary>
	public void CamV_3_EditDeleteCameraViewPlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
 	    EditDeleteCameraViewPlayerPage_TestData EditDeleteCameraViewPlayerPageTestData=new EditDeleteCameraViewPlayerPage_TestData();
		
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), EditDeleteCameraViewPlayerPageTestData.CamV_3_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditDeleteCameraViewPlayerPageTestData.CamV_3_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_3_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_3_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_3_eventOrGameName)),"Event Game is not Visible");
		
	    //Step 7  :Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_3_eventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+EditDeleteCameraViewPlayerPageTestData.CamV_3_eventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		// Step 8 : Verify "CAMERA VIEW" header and 'Edit' icon
		// Expected : User should see the 'Camera View' and 'Edit' icon on the right side of the player page
	    asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("shot-user-tile")),"' CAMERA VIEW 'is not displayed on the right side of the player page");
		Thread.sleep(2000);	
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt")),"Edit icon is not displayed in Camera View");
        asrt.assertTrue(base.isEnabledBy(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt")),"Edit icon is not enabled in Camera View");
		
        // Step 9 : Click on edit icon in "CAMERA VIEW"
		// Expected : To verify that when the user clicks the "Edit" button, then a dialog box with text field appears 
        base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt"));
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("edit_session_name")),"text box is not displayed in edit CAMERA VIEW");

        //Step 10 : Enter/Edit Name
        //Expected : User should edit Camera name in text field
        base.setData(LoginPageObj.Edt_LoginEmail("edit_session_name"), EditDeleteCameraViewPlayerPageTestData.CamV_3_CameraName);
        String updatedCameraName = base.GetValue(LoginPageObj.Edt_LoginEmail("edit_session_name"));
        asrt.assertEquals(updatedCameraName, EditDeleteCameraViewPlayerPageTestData.CamV_3_CameraName,"User failed to edit Camera name");
	}
	
	///<summary>
	// Test Case Title:"Verify that the changes are saved, and a successful message came when user click the save option"
	// Automation ID  : Cam V_4
	///</summary>
	public void CamV_4_EditDeleteCameraViewPlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		EditDeleteCameraViewPlayerPage_Obj EditDeleteCameraViewPlayerPageObj=new EditDeleteCameraViewPlayerPage_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
 	    EditDeleteCameraViewPlayerPage_TestData EditDeleteCameraViewPlayerPageTestData=new EditDeleteCameraViewPlayerPage_TestData();
 	    
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), EditDeleteCameraViewPlayerPageTestData.CamV_4_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditDeleteCameraViewPlayerPageTestData.CamV_4_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_4_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_4_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_4_eventOrGameName)),"Event Game is not Visible");
		
	    //Step 7  :Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_4_eventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+EditDeleteCameraViewPlayerPageTestData.CamV_4_eventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		// Step 9 : Verify 'CAMERA VIEW' header and the 'Edit' icon
		// Expected : User should see the 'Camera View' and 'Edit' icon on the right side of the player page
	    asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("shot-user-tile")),"' CAMERA VIEW 'is not displayed on the right side of the player page");
		Thread.sleep(2000);	
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt")),"Edit icon is not displayed in Camera View");
        asrt.assertTrue(base.isEnabledBy(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt")),"Edit icon is not enabled in Camera View");
		
        // Step 10 : Click on edit icon in "CAMERA VIEW"
		// Expected : To verify that when the user clicks the "Edit" button, then a dialog box with text field. "Save" and "Cancel" options appears 
        base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt"));
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("edit_session_name")),"text box is not displayed in edit CAMERA VIEW");

        //Step 11: Enter camera name in text box
        //Expected: User should enter and edit the Camera name in text field
        base.setData(LoginPageObj.Edt_LoginEmail("edit_session_name"), EditDeleteCameraViewPlayerPageTestData.CamV_4_CameraName);
        String updatedCameraName = base.GetValue(LoginPageObj.Edt_LoginEmail("edit_session_name"));
        asrt.assertEquals(updatedCameraName, EditDeleteCameraViewPlayerPageTestData.CamV_4_CameraName,"User failed to edit Camera name");
        asrt.assertTrue(base.isExists(EditDeleteCameraViewPlayerPageObj.Btn_Edit("edit_session_id","btn btn-outline-danger session-rename-confirm")),"Save button is not displayed in edit CAMERA VIEW");
        
        //Step 12: Click Save option
        //Expected: The changes should saved, and a successfull message should came when user click the save option
        base.buttonClick(EditDeleteCameraViewPlayerPageObj.Btn_Edit("edit_session_id","btn btn-outline-danger session-rename-confirm"));
        Thread.sleep(1000);
        asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"'View updated successfully' success message is not displayed");
        
        //Verifying if the camera name is changed
        asrt.assertEquals(base.GetAttribte(LoginPageObj.Ele_ErrorMessage("cam-title"),"textContent"), updatedCameraName,"Camera name is not updated in edit CAMERA VIEW");
   	}
	
	//<summary>
	//Test Case Title:"Verify that the dialog box closes without saving any changes when user click the cancel option"
	//Automation ID  : Cam V_5
	//</summary>
	public void CamV_5_EditDeleteCameraViewPlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		EditDeleteCameraViewPlayerPage_Obj EditDeleteCameraViewPlayerPageObj=new EditDeleteCameraViewPlayerPage_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
 	    EditDeleteCameraViewPlayerPage_TestData EditDeleteCameraViewPlayerPageTestData=new EditDeleteCameraViewPlayerPage_TestData();
 	    
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), EditDeleteCameraViewPlayerPageTestData.CamV_5_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditDeleteCameraViewPlayerPageTestData.CamV_5_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_5_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_5_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_5_eventOrGameName)),"Event Game is not Visible");
		
	    //Step 7 : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_5_eventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+EditDeleteCameraViewPlayerPageTestData.CamV_5_eventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		// Step 9 : Verify 'CAMERA VIEW' header and 'Edit' icon
		// Expected : User should see the 'Camera View' and 'Edit' icon on the right side of the player page
	    asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("shot-user-tile")),"' CAMERA VIEW 'is not displayed on the right side of the player page");
		Thread.sleep(2000);	
		String cameraName=base.GetText(LoginPageObj.Ele_ErrorMessage("cam-title"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt")),"Edit icon is not displayed in CAMERA VIEW");
		 
        // Step 10: Click on edit icon in "CAMERA VIEW"
		//Expected: Verify Cancel button is displayed in edit text box
        base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("fas fa-pencil-alt"));
        asrt.assertTrue(base.isExists(EditDeleteCameraViewPlayerPageObj.Btn_Edit("edit_session_id","btn btn-outline-danger")),"Cancel button is not displayed in edit CAMERA VIEW");
       
        //Step 11: Click on Cancel button  
        //Expected: The dialog box should get closed without saving any changes when user click the cancel option
        base.buttonClick(EditDeleteCameraViewPlayerPageObj.Btn_Edit("edit_session_id","btn btn-outline-danger"));
        base.isDoesNotExist(SnipCreationWithAndWithoutTagObj.Btn_TagBox("session-rename-modal","modal-content col-12"),"Edit box popup still existing in CAMERA VIEW");  
        
        //Verifying if the camera name is not changed as we clicked on cancel without editing the camera name
        asrt.assertEquals(base.GetText(LoginPageObj.Ele_ErrorMessage("cam-title")),cameraName,"Camera name is updated in edit CAMERA VIEW even without editing as we clicked on cancel in edit dialog box");
	}
	
	///<summary>
	// Test Case Title:"Verify that a confirmation message dialog box  appears when the delete option is clicked"
	// Automation ID  : Cam V_6
	///</summary>
	public void CamV_6_EditDeleteCameraViewPlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
 	    EditDeleteCameraViewPlayerPage_TestData EditDeleteCameraViewPlayerPageTestData=new EditDeleteCameraViewPlayerPage_TestData();
 	    
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), EditDeleteCameraViewPlayerPageTestData.CamV_6_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditDeleteCameraViewPlayerPageTestData.CamV_6_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_6_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_6_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_6_eventOrGameName)),"Event Game is not Visible");
		
	    //Step 7 : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_6_eventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+EditDeleteCameraViewPlayerPageTestData.CamV_6_eventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		// Step 8 : Verify "CAMERA VIEW" header  
		// Expected : User should see the 'Camera View' icon on the right side of the player page
	    asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("shot-user-tile")),"' CAMERA VIEW 'is not displayed on the right side of the player page");
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_BookMark("del-session-wrap")),"Delete icon is not displayed in Camera View");
		
        // Step 9 : Click on Delete icon in "CAMERA VIEW"
		// Expected :Verify that a confirmation message dialog box appears when the delete option is clicked
        base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_BookMark("del-session-wrap"));
		Thread.sleep(2000);	
        asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-modal")),"Confirmation dialog box is not appeared when the delete option is clicked");
	}
	
	///<summary>
	// Test Case Title:"Verify that the camera view gets delete when Click "Yes" option in confirmation message dialog box"
	// Automation ID  : Cam V_7
	///</summary>
	public void CamV_7_EditDeleteCameraViewPlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
 	    EditDeleteCameraViewPlayerPage_TestData EditDeleteCameraViewPlayerPageTestData=new EditDeleteCameraViewPlayerPage_TestData();
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
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), EditDeleteCameraViewPlayerPageTestData.CamV_7_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditDeleteCameraViewPlayerPageTestData.CamV_7_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_7_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_7_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Create a new event
        //Expected : User should Successfully create a new EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), EditDeleteCameraViewPlayerPageTestData.CamV_7_eventOrGameName);
		base.excuteJsClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "CREATE"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		Thread.sleep(8000);
		base.excuteJsClick(MoveGameObj.Btn_3Dots(EditDeleteCameraViewPlayerPageTestData.CamV_7_eventOrGameName));
		base.excuteJsClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
        String videoFilePath = System.getProperty("user.dir")+ "/Utils/Video/video_Check_Snip.mp4";
        List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
        base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
        base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
        WebDriverWait wait=new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.textToBe(RegistrationObj.Edt_SignUpPopupPassword("progress"), "100%"));
	    Thread.sleep(10000);
	    base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	    Thread.sleep(3000);
	    
	    //Step 7 : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_7_eventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+EditDeleteCameraViewPlayerPageTestData.CamV_7_eventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		// Step 8 : Verify 'CAMERA VIEW' header  and 'Delete' icon
		// Expected : User should see the 'Camera View' and 'Delete' icon on the right side of the player page
	    asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("shot-user-tile")),"' CAMERA VIEW 'is not displayed on the right side of the player page");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_BookMark("del-session-wrap")),"Delete icon is not displayed in Camera View");
		
        // Step 9 : Click on Delete icon in "CAMERA VIEW"
		// Expected :Verify that a confirmation message dialog box appears when the delete option is clicked
        base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_BookMark("del-session-wrap"));
		Thread.sleep(5000);	
        asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-modal")),"Confirmation dialog box is not appeared when the 'Delete' option is clicked");
        
        //Step 10 : Click on 'Yes' button in the delete option
        //Expected : Verify that a confirmation message to delete entire game when the 'Yes' option is clicked
        base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
        Thread.sleep(2000);
        asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-modal")),"Confirmation dialog box to delete the entire game is not appeared when the 'Yes' option is clicked");
        base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
        Thread.sleep(13000);
        asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("hero-banner-outer slide-show")),"User unable to redirect to 'Home' page in Snipback");
        Thread.sleep(5000);
        
        //Verifying the event is deleted or not
        base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
        base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), EditDeleteCameraViewPlayerPageTestData.CamV_7_OrgName);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditDeleteCameraViewPlayerPageTestData.CamV_7_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_7_teamName));
		Thread.sleep(5000);
	}
	
	///<summary>
	// Test Case Title:"Verify that the dialog box gets close when Click "Cancel" option in confirmation message dialog box"
	// Automation ID  : Cam V_8
	///</summary>
    public void CamV_8_EditDeleteCameraViewPlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
 	    EditDeleteCameraViewPlayerPage_TestData EditDeleteCameraViewPlayerPageTestData=new EditDeleteCameraViewPlayerPage_TestData();
 	    
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), EditDeleteCameraViewPlayerPageTestData.CamV_8_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditDeleteCameraViewPlayerPageTestData.CamV_8_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_8_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",EditDeleteCameraViewPlayerPageTestData.CamV_8_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_8_eventOrGameName)),"Event Game is not Visible");
	    
		//Step 7 : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",EditDeleteCameraViewPlayerPageTestData.CamV_8_eventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+EditDeleteCameraViewPlayerPageTestData.CamV_8_eventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		
		// Step 8 : Verify "CAMERA VIEW" header  
		// Expected : User should see the 'Camera View' icon on the right side of the player page
	    asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("shot-user-tile")),"' CAMERA VIEW 'is not displayed on the right side of the player page");
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_BookMark("del-session-wrap")),"Delete icon is not displayed in Camera View");
		
        // Step 9 : Click on Delete icon in "CAMERA VIEW"
		// Expected : Verify that a confirmation message dialog box appears when the delete option is clicked
        base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_BookMark("del-session-wrap"));
		Thread.sleep(2000);	
        asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-modal")),"Confirmation dialog box is not appeared when the delete option is clicked");
        asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel")),"delete this view popup cancel button is not displayed");
        
        // Step 10 : Click on cancel button in delete view popup of "CAMERA VIEW"
     	// Expected : Verify that the dialog box gets close when Click "Cancel" option in confirmation message dialog box
        base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel"));
        base.isDoesNotExist(LoginPageObj.Ele_ErrorMessage("swal-modal"),"Are you sure want to delete this view? popup is not closed");  
	}
}

