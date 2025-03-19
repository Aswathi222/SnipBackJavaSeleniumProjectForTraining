package testPage.MavenPageObject;

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
import TestData.CommonData;
import TestData.SnipBackLogin_TestData;
import TestData.Tags_TestData;
import TestData.TrimVideo_TestData;
import TestData.WhiteboardAndReels_TestData;

import objectRepository.AddEditInfo_Obj;
import objectRepository.AddFollower_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.CreateUpdateDeleteGame_Obj;
import objectRepository.DuplicateTeam_Obj;
import objectRepository.FilterMembers_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.Tags_Obj;
import objectRepository.TrimVideo_Obj;
import objectRepository.ViewProfile_Obj;
import objectRepository.AddUpdateDeleteDuplicateTeamGameDefaults_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.ForgotPassword_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;

import objectRepository.ViewListUpdateDownloadShareDeleteLibrary_Obj;
import utilPack.BasePge;

public class TrimVideo extends BasePge {

	BasePge base;
	Assert asrt; 

	public TrimVideo(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	///<summary>
	// Test Case Title:"To verify whether the user can be able to click the trim option"
	// Automation ID  : TV_02
	///</summary>
	public void TV_02_TrimVideo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData=new TrimVideo_TestData();
 	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();
		 
		Thread.sleep(4000);
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		
		//Step 2   :"Click on Games Button"
		//Expected :"User should be able to click Games Button"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User not able to click Games button");
		
		// Step 3:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(3000);

		// Step 4:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);

		// Step 5:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		
		//Step 6:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TrimVideoTestData.TV_01_teamName);
		
		//Step 7:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName));
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
	    // Step 8: Click on game name
		// Expected : new window opened
	    base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_uploadedGame));
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_uploadedGame));
	    
		Thread.sleep(18000);
		
		// Step 9: Switching to window
		// Expected : Trim Video image is shown 
		base.switchToWindowByIndex(driver, 1);
	    asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_SearchField("trim-btn-img")),"Trim Button image is not displayed");
		Thread.sleep(2000);
		
		//   USER IN PLAYER PAGE 
		
		//Step 10: To verify whether the user can be able to click the trim option
		asrt.assertTrue(driver.findElement(PublicGameListingObj.Ele_SearchField("trim-btn-img")).isEnabled(), "Trim Button image is not Enabled for click");
	    base.buttonClick(PublicGameListingObj.Ele_SearchField("trim-btn-img"));
		
		Thread.sleep(2000);
		
}
	
	///<summary>
	// Test Case Title:"To verify whether the user was navigated to video trimming page while clicking trim option"
	// Automation ID  : TV_03
	///</summary>
	public void TV_03_TrimVideo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData=new TrimVideo_TestData();
 		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();
		TrimVideo_Obj TrimVideoObj=new TrimVideo_Obj();
		
		Thread.sleep(4000);
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		
		//Step 2   :"Click on Games Button"
		//Expected :"User should be able to click Games Button"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User not able to click Games button");
		
		// Step 3:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(3000);

		// Step 4:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);

		// Step 5:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		
		//Step 6:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TrimVideoTestData.TV_01_teamName);
		
		//Step 7:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName));
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		// Step 8: Click on game name
		// Expected : new window opened
	    base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_uploadedGame));
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_uploadedGame));
		
		// Step 9: Switching to window
		// Expected : Trim Video image is shown 
		base.switchToWindowByIndex(driver, 1);
	    asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_SearchField("trim-btn-img")),"Trim Button image is not displayed");
		Thread.sleep(2000);
		
		////   USER IN PLAYER PAGE 
	 
		// Step 10: Click on trim video
		// Actual Expected : Verify if User navigated to video trimming page. 
		//Verifying it by checking if My Snips options are not shown
 	    base.buttonClick(PublicGameListingObj.Ele_SearchField("trim-btn-img"));
		base.isDoesNotExist(TrimVideoObj.Ele_MySnipsOptionsList("myTab"), "Failed to navigate to video trimming page");
		
		//Verifying by checking if  Entire Game Video - game name tab is not there
		base.isDoesNotExist(LoginPageObj.Ele_ErrorMessage("block-title payFullVideo"), "Entire Game Video tab is showing means user is Failed to navigate to video trimming page");
 
	
	}
	
	///<summary>
	// Test Case Title:"System should display a trim line in the trimming page."
	//User should be able to adjust the trim line.
	// Automation ID  : TV_04
	///</summary>
	public void TV_04_TrimVideo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData=new TrimVideo_TestData();
 		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
        PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		Thread.sleep(4000);
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		
		//Step 2   :"Click on Games Button"
		//Expected :"User should be able to click Games Button"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User not able to click Games button");
		
		// Step 3:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(3000);

		// Step 4:Click outside the dropdown using Actions

		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);

		// Step 5:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		
		//Step 6:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TrimVideoTestData.TV_01_teamName);
		
		//Step 7:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName));
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	    
	    
	    ///////////////////  CREATE EVENT OR GAME
    
	    // Step 8 :Click on +Event
	    // Expected: "Create Game for" popup shown  to create game or event
	    base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
	    Thread.sleep(2000);
	    base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),TrimVideoTestData.TV_04_eventOrGameName);
	    Thread.sleep(2000);
	    String eventOrGameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
	    Thread.sleep(2000);
	    
	    //Step 9: Click on Create button
	    //Expected:Event not Created/ The confirmation popup appeared 
	    base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
	    asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
	    Thread.sleep(3000);

	    //Step 10: Click on OK button in confirmation popup "Game added successfully"
	    //Expected:Able to Click on the menu icon (three dots)
	    base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	    // page loading so need this time
	    Thread.sleep(8000);
	    asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(eventOrGameName)),"Unable to Click on the menu icon (three dots)");
	    base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(eventOrGameName));
	    
	    ///////////////////   UPLOAD VIDEO 

	    // Step 11 : Click on Upload video.
	    // Expected: Menu Displayed and Able to click the Upload Video from dropdown
	    base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName));
	    asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
	    base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));

	    // Step 12: click on the Choose File icon, Verify that the file is mp4 or mov
	    // Expected: User able to Choose valid file extension only
	    String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
	    List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
	    // Choose the file
	    asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "User unable to Choose valid file extension ");
	    base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
	    asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
	    
	    // Step 13: Click Upload and Shows Successfully Uploaded
	    // Expected : Upload Button is Enabled/Clickable
	    base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
	    base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

	    // Step 14: Click on game name
	    // Expected : new window opened
	    base.buttonClick(LoginPageObj.Btn_Login(eventOrGameName));
	    Thread.sleep(18000);

		// Step 15: Switching to window
		// Expected : Trim Video image is shown 
		base.switchToWindowByIndex(driver, 1);
	    asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_SearchField("trim-btn-img")),"Trim Button image is not displayed");
		Thread.sleep(2000);
		
		///////////////  USER IN PLAYER PAGE 
	 
		// Step 16: Click on trim video
		//Expected : Verify if User navigated to video trimming page. 
		 
 	    base.buttonClick(PublicGameListingObj.Ele_SearchField("trim-btn-img"));
	    asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("slider-distance")),"Trim line in the trimming page is not visible");
	    
	    //Step 17: Moving the trim line to middle and verify if User should be able to adjust the trim line.
	    //Actual Expected:To verify whether the user can be able to adjust the trim line.
	    base.moveSlider(By.id("trimRange1"),"value","trim line is not adjustable");
	    //Step 18: switching back to main window
	    base.returnToMainWindow(driver);
	    try {
			 

			// Step 19: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    
			// Step 20: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			//base.buttonClick(CreateUpdateDeleteGameObj.Ele_ThreeDotDeleteBasedOnGameName(eventOrGameName));
			base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 21: Click on yes in delete popup to delete added game
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	    
}
	
	///<summary>
	// Test Case Title:"System should display the play button in trimming page."
	//User should be able to click the play button in trimming page.
	// Automation ID  : TV_05
	///</summary>
	public void TV_05_TrimVideo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData=new TrimVideo_TestData();
 	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		Thread.sleep(4000);
		
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		
		//Step 2   :"Click on Games Button"
		//Expected :"User should be able to click Games Button"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User not able to click Games button");
		
		// Step 3:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(3000);

		// Step 4:Click outside the dropdown using Actions

		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);

		// Step 5:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		
		//Step 6:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TrimVideoTestData.TV_01_teamName);
		
		//Step 7:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName));
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	    asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
	    
	    ///////////////////  CREATE EVENT OR GAME
	    
	    // Step 8 :Click on +Event
	    // Expected: "Create Game for" popup shown  to create game or event
	    base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
	    Thread.sleep(2000);
	    base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),TrimVideoTestData.TV_05_eventOrGameName);
	    Thread.sleep(2000);
	    String eventOrGameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
	    Thread.sleep(2000);

	    //Step 9: Click on Create button
	    //Expected:confirmation popup
	    base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
	    asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
	    Thread.sleep(3000);

	    //Step 10: Click on OK button in confirmation popup "Game added successfully"
	    base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	    //page loading so need this time
	    Thread.sleep(8000);
	    asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(eventOrGameName)),"Unable to Click on the menu icon (three dots)");
	    base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(eventOrGameName));
	    
	    ///////////////////   UPLOAD VIDEO 

	    //Step 11 : Click on Upload video.
	    //Expected: Menu Displayed and Able to click the Upload Video from dropdown
	    base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName));
	    asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
	    base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));

	    //Step 12: click on the Choose File icon, Verify that the file is mp4 or mov
	    //Expected: User able to Choose valid file extension only
	    String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
	    List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
	    //Choose the file
	    asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to Choose valid file extension only");
	    base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
	    asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
	    
	   //Step 13: Click Upload and Shows Successfully Uploaded
	    //Expected : Upload Button is Enabled/Clickable
	    base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
	    base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

	    //Step 14: Click on game name
	    //Expected : new window opened
	    base.buttonClick(LoginPageObj.Btn_Login(eventOrGameName));
	    Thread.sleep(18000);
	  		
		// Step 15: Switching to window
		// Expected : Trim Video image is shown 
		base.switchToWindowByIndex(driver, 1);
	    asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_SearchField("trim-btn-img")),"Trim Button image is not displayed");
		Thread.sleep(2000);
		
		///////////////  USER IN PLAYER PAGE 
	 
		// Step 16: Click on trim video
		//Expected : Verify if User navigated to video trimming page. 		 
 	    base.buttonClick(PublicGameListingObj.Ele_SearchField("trim-btn-img"));
	    asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("slider-distance")),"Trim line in the trimming page is not visible");
	    
	    //Step 17: To verify whether the user can be able to see the play button in the trimming page.
	    //Expected:user can be able to see the play button in the trimming page
	    asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("playpause")),"Play button is not present in trimming page"); 
 	    
	    //Step 18: Taking the status of play button before clicking on play button
	    //Expected: To verify whether the user can be able to click the play button in the trimming page.
	    String valueBeforeClick= driver.findElement(CreateAddNewMemberWithEmailObj.Ele_EditTeam("playpause")).getAttribute("title");
 	    asrt.assertEquals(valueBeforeClick, "play","play button is not existing");
 	    
 	    //Step 19: Click on play button
 	    //Expected: play button selected
	    base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("playpause"));
	    
	    //Step 20: Taking the status of play button after clicking on play button
	    //Expected:selected status of play button after clicking on play button
	    String valueAfterClick= driver.findElement(CreateAddNewMemberWithEmailObj.Ele_EditTeam("playpause")).getAttribute("title");
	    
	    //Step 21: Validating if the status of play button is changed to pause after clicking on play button 
	    //Note : If status is pause then click happened
	    //IF status is play then click not happened
	    asrt.assertEquals(valueAfterClick, "pause","User is not able to click on play button");
	    base.returnToMainWindow(driver);
	    try {
			 

			// Step 22: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 23: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			//base.buttonClick(CreateUpdateDeleteGameObj.Ele_ThreeDotDeleteBasedOnGameName(eventOrGameName));
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 24: Click on yes in delete popup to delete added game
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	   
}
	
	///<summary>
	// Test Case Title:"System should display a Save option in Trimming page."
	//User should be able to click the Save button.
	// Automation ID  : TV_07
	///</summary>
	public void TV_07_TrimVideo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData=new TrimVideo_TestData();
 		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();
        Registration_Obj RegistrationObj=new Registration_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj =new CreateUpdateDeleteGame_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		
		Thread.sleep(4000);
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		
		//Step 2   :"Click on Games Button"
		//Expected :"User should be able to click Games Button"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User not able to click Games button");
		
		// Step 3:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(3000);

		// Step 4:Click outside the dropdown using Actions

		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);

		// Step 5:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		
		//Step 6:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TrimVideoTestData.TV_01_teamName);
		
		//Step 7:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName));
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName)), "Failed to select TEAM");
        Thread.sleep(5000);
	    
        ///////////////////  CREATE EVENT OR GAME
	    
        //Step 8 :Click on +Event
        //Expected: "Create Game for" popup shown  to create game or event
        asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
        base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
        Thread.sleep(2000);
        base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),TrimVideoTestData.TV_07_eventOrGameName);
        Thread.sleep(2000);
        String eventOrGameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
        //base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_Home("toggle-item active","Home"));
        Thread.sleep(2000);

        //Step 9: Click on Create button
        //Expected:confirmation popup
        base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
        asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
        Thread.sleep(3000);

        //Step 10: Click on OK button in confirmation popup "Game added successfully"
        base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
        //page loading so need this time
        Thread.sleep(8000);
        asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(eventOrGameName)),"Unable to Click on the menu icon (three dots)");
        base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(eventOrGameName));
        
        ///////////////////   UPLOAD VIDEO 

        //Step 11 : Click on Upload video.
        //Expected: Menu Displayed and Able to click the Upload Video from dropdown
        base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName));
        asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
        base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
        base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));

        //Step 12: click on the Choose File icon, Verify that the file is mp4 or mov
        //Expected: User able to Choose valid file extension only
        String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
        List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
        //Choose the file
        asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
        base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
        asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
        
        //Step 13: Click Upload and Shows Successfully Uploaded
        //Expected : User able to see the Successfully Uploaded Message and click
        base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
        base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

        //Step 14: Click on game name
        //Expected : new window opened
        base.buttonClick(LoginPageObj.Btn_Login(eventOrGameName));
        Thread.sleep(18000);	
		
		// Step 15: Switching to window
		// Expected : Trim Video image is shown 
		base.switchToWindowByIndex(driver, 1);
	    asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_SearchField("trim-btn-img")),"Trim Button image is not displayed");
		Thread.sleep(2000);
		
		///////////////  USER IN PLAYER PAGE 
	 
		// Step 16: Click on trim video
		//Expected : Verify if User navigated to video trimming page. 	 
 	    base.buttonClick(PublicGameListingObj.Ele_SearchField("trim-btn-img"));
	    asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("slider-distance")),"Trim line in the trimming page is not visible");
	    Thread.sleep(2000);
	    
	    //Step 17: To verify whether there is Save option in Trimming page.
	    //Expected:  Save option in Trimming page.
	    asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Room("save_trimmed_video")),"Save button is not displayed");
	    
	    //Step 18: Click on save button.
	    //Expected: To verify whether the user can be able to click the save button (Expected)
	    base.isEnabledBy(CreateUpdateDeleteGameObj.Ele_Room("save_trimmed_video"));
	    base.buttonClick(CreateUpdateDeleteGameObj.Ele_Room("save_trimmed_video"));
	    Thread.sleep(4000);    
	    base.returnToMainWindow(driver);
	    try {
			 

			// Step 19: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 20: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 21: Click on yes in delete popup to delete added game
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
}
	
	///<summary>
	// Test Case Title:"User should receive a success pop up as "The game file is currently undergoing trimming. Please check back later."after saving the trimmed video."
	// Automation ID  : TV_09
	///</summary>
	public void TV_09_TrimVideo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData=new TrimVideo_TestData();
 		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
 		PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();
	    Registration_Obj RegistrationObj=new Registration_Obj();
 		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj =new CreateUpdateDeleteGame_Obj();
 		FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		Thread.sleep(4000);
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		
		//Step 2   :"Click on Games Button"
		//Expected :"User should be able to click Games Button"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User not able to click Games button");
		
		// Step 3:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(3000);

		// Step 4:Click outside the dropdown using Actions

		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);

		// Step 5:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
				
		//Step 6:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TrimVideoTestData.TV_01_teamName);
		
		//Step 7:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName));
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName)), "Failed to select TEAM");
        Thread.sleep(5000);
        asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
		
    ///////////////////  CREATE EVENT OR GAME
	    
	    // Step 8 :Click on +Event
		// Expected: "Create Game for" popup shown  to create game or event
		base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),TrimVideoTestData.TV_09_eventOrGameName);
		Thread.sleep(2000);
		String eventOrGameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		
		//Step 8: Click on Create button
		//Expected:confirmation popup
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),
				"Event not Created/ The confirmation popup did not appear ");
		Thread.sleep(3000);

		//Step 9: Click on OK button in confirmation popup "Game added successfully"
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		// page loading so need this time
		Thread.sleep(8000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(eventOrGameName)),"Unable to Click on the menu icon (three dots)");
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(eventOrGameName));
		
		///////////////////   UPLOAD VIDEO 
		
		// Step 10 : Click on Upload video.
		// Expected: Menu Displayed and Able to click the Upload Video from dropdown
		base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		
		// Step 11: click on the Choose File icon, Verify that the file is mp4 or mov
		// Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
		
		// Step 12: Click Upload and Shows Successfully Uploaded
		// Expected : User able to see the Successfully Uploaded Message and click
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		// Step 13: Click on game name
		// Expected : new window opened
		base.buttonClick(LoginPageObj.Btn_Login(eventOrGameName));
		Thread.sleep(18000); 
        
		// Step 15: Switching to window
		// Expected : Trim Video image is shown 
		base.switchToWindowByIndex(driver, 1);
	    asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_SearchField("trim-btn-img")),"Trim Button image is not displayed");
		Thread.sleep(2000);
		
		///////////////  USER IN PLAYER PAGE 
	 
		// Step 16: Click on trim video
		//Expected : Verify if User navigated to video trimming page. 
		 
 	    base.buttonClick(PublicGameListingObj.Ele_SearchField("trim-btn-img"));
	    asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("slider-distance")),"Trim line in the trimming page is not visible");
	    
	    //Step 17: Moving the trim line to middle and verify if User should be able to adjust the trim line.
	    //Expected:Save button is existing.
	    Thread.sleep(5000);
	    base.moveSlider(By.id("trimRange1"),"value","trim line is not adjustable");
	    asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Room("save_trimmed_video")));
	    
	    //Step 18: Click on save button.
	    //Expected:Save button is existing.
	    base.buttonClick(CreateUpdateDeleteGameObj.Ele_Room("save_trimmed_video"));
	    Thread.sleep(4000);
	    
	    //Step 19: Validating save message
	    //Expected: User should receive a success pop up as "The game file is currently undergoing trimming. Please check back later."after saving the trimmed video.(Expected)
	    asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")));
	    asrt.assertEquals(base.GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "The game file is currently undergoing trimming. Please check back later.","the success message is not matching");
	    
	    base.returnToMainWindow(driver);
	    try {
			 

			// Step 20: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 21: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			//base.buttonClick(CreateUpdateDeleteGameObj.Ele_ThreeDotDeleteBasedOnGameName(eventOrGameName));
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 22: Click on yes in delete popup to delete added game
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
}

	///<summary>
	// Test Case Title:"To verify whether the system displays any progress while the trimmed video is getting ready."
	// Automation ID  : TV_10
	///</summary>
	public void TV_10_TrimVideo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		TrimVideo_Obj TrimVideoObj=new TrimVideo_Obj();
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData=new TrimVideo_TestData();
 		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
 		PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();
	    Registration_Obj RegistrationObj=new Registration_Obj();
 		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj =new CreateUpdateDeleteGame_Obj();
 		FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		Thread.sleep(4000);
		
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		
		//Step 2   :"Click on Games Button"
		//Expected :"User should be able to click Games Button"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User not able to click Games button");
		
		// Step 3:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(3000);

		// Step 4:Click outside the dropdown using Actions

		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);

		// Step 5:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		
		//Step 6:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TrimVideoTestData.TV_01_teamName);
		
		//Step 7:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName));
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName)), "Failed to select TEAM");
        Thread.sleep(5000);
        asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
        
        ///////////////////  CREATE EVENT OR GAME
    	    
    	    // Step 8 :Click on +Event
    		// Expected: "Create Game for" popup shown  to create game or event
    		base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
    		Thread.sleep(2000);
    		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),TrimVideoTestData.TV_10_eventOrGameName);
    		Thread.sleep(2000);
    		String eventOrGameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
    		
    		//Step 9: Click on Create button
    		//Expected:confirmation popup
    		base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
    		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),
    				"Event not Created/ The confirmation popup did not appear ");
    		Thread.sleep(3000);

    		//Step 11: Click on OK button in confirmation popup "Game added successfully"
    		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
    		// page loading so need this time
    		Thread.sleep(8000);
    		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(eventOrGameName)),"Unable to Click on the menu icon (three dots)");
    		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(eventOrGameName));
    		
    		///////////////////   UPLOAD VIDEO 
    		
    		// Step 12 : Click on Upload video.
    		// Expected: Menu Displayed and Able to click the Upload Video from dropdown
    		base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName));
    		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
    	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
    		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
    		
    		// Step 13: click on the Choose File icon, Verify that the file is mp4 or mov
    		// Expected: User able to Choose valid file extension only
    		String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
    		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
    		// Choose the file
    		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
    		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
    		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
    		
    		// Step 14: Click Upload and Shows Successfully Uploaded
    		// Expected : User able to see the Successfully Uploaded Message and click
    		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
    		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

    		// Step 15: Click on game name
    		// Expected : new window opened
    		base.buttonClick(LoginPageObj.Btn_Login(eventOrGameName));
    		Thread.sleep(18000); 
        
		// Step 16: Switching to window
		// Expected : Trim Video image is shown 
		base.switchToWindowByIndex(driver, 1);
		Thread.sleep(2000);
	    asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_SearchField("trim-btn-img")),"Trim Button image is not displayed");
		Thread.sleep(2000);
		
		///////////////  USER IN PLAYER PAGE 
	 
		// Step 17: Click on trim video
		//Expected : Verify if User navigated to video trimming page. 
		 
 	    base.buttonClick(PublicGameListingObj.Ele_SearchField("trim-btn-img"));
	    asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("slider-distance")),"Trim line in the trimming page is not visible");
	    
	    //Step 18: Moving the trim line to middle and verify if User should be able to adjust the trim line.
	    //Expected:Save button is existing.
	    base.moveSlider(By.id("trimRange1"),"value","trim line is not adjustable");
	    asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Room("save_trimmed_video")));
	    
	    //Step 19: Click on save button.
	    //Expected:Save button is existing.
	    base.buttonClick(CreateUpdateDeleteGameObj.Ele_Room("save_trimmed_video"));
	    Thread.sleep(4000);
	    asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")));
	    
	    //Step 20: Validating save message
	    //Expected: User should receive a success pop up as "The game file is currently undergoing trimming. Please check back later."after saving the trimmed video.(Expected)
	    base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	   
	    //Step 21:To verify whether the system displays any progress while the trimmed video is getting ready.
	    //asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("circular-progress"))); 
	    base.returnToMainWindow(driver);
	    try {
			 

			// Step 20: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 21: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 22: Click on yes in delete popup to delete added game
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	
	}

	
	///<summary>
	// Test Case Title:"To verify whether the user can be able to play the video according to the trimmed line."
	// Automation ID  : TV_06
	///</summary>
	public void TV_06_TrimVideo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		TrimVideo_Obj TrimVideoObj=new TrimVideo_Obj();
		CommonData Commondata= new CommonData();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData=new TrimVideo_TestData();
 		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
 		PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();
	    Registration_Obj RegistrationObj=new Registration_Obj();
 		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj =new CreateUpdateDeleteGame_Obj();
 		Tags_Obj TagsObj=new Tags_Obj();
 		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		Thread.sleep(4000);
		
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		
		//Step 2   :"Click on Games Button"
		//Expected :"User should be able to click Games Button"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User not able to click Games button");
		
		// Step 3:Switch to any team from the team dropdown menu after selecting an
		// Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(3000);

		// Step 4:Click outside the dropdown using Actions

		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);

		// Step 5:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		
		//Step 6:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TrimVideoTestData.TV_01_teamName);
		
		//Step 7:Selecting the team
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName));
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName)), "Failed to select TEAM");
        Thread.sleep(5000);
        asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
        
        ///////////////////  CREATE EVENT OR GAME
	    
        //Step 8 :Click on +Event
        //Expected: "Create Game for" popup shown  to create game or event
        base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
        Thread.sleep(2000);
        base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),TrimVideoTestData.TV_06_eventOrGameName);
        Thread.sleep(2000);
        String eventOrGameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
        //base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_Home("toggle-item active","Home"));
        Thread.sleep(2000);

        //Step 9: Click on Create button
        //Expected:confirmation popup
        base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
        asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
        Thread.sleep(3000);

        //Step 10: Click on OK button in confirmation popup "Game added successfully"
        base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
        //page loading so need this time
        Thread.sleep(8000);
        asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(eventOrGameName)),"Unable to Click on the menu icon (three dots)");
        base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(eventOrGameName));
        
        ///////////////////   UPLOAD VIDEO 

        //Step 11 : Click on Upload video.
        //Expected: Menu Displayed and Able to click the Upload Video from dropdown
        base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName));
        asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
        base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
        base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));

        //Step 12: click on the Choose File icon, Verify that the file is mp4 or mov
        //Expected: User able to Choose valid file extension only
        String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
        List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
        //Choose the file
        asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
        base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
        asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
        
        //Step 13: Click Upload and Shows Successfully Uploaded
        //Expected : User able to see the Successfully Uploaded Message and click
        base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
        base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

        //Step 14: Click on game name
        //Expected : new window opened
        base.buttonClick(LoginPageObj.Btn_Login(eventOrGameName));
        Thread.sleep(18000);
		
        // Step 15: Switching to window
        // Expected : Trim Video image is shown 
		base.switchToWindowByIndex(driver, 1);
	    asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_SearchField("trim-btn-img")),"Trim Button image is not displayed");
		Thread.sleep(2000);
		
		///////////////  USER IN PLAYER PAGE 
	 
		// Step 16: Click on trim video
		//Expected : Verify if User navigated to video trimming page. 
		 
 	    base.buttonClick(PublicGameListingObj.Ele_SearchField("trim-btn-img"));
	    asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("slider-distance")),"Trim line in the trimming page is not visible");
	    
	    //Step 17: Verify if the Video is not trimmed by checking if the time is 00:00 / 00:15
	    String videoTimeBeforeTrim = base.GetAttribte(TagsObj.Ele_TagsName("video-time"),"textContent");
	    asrt.assertEquals(base.GetAttribte(TagsObj.Ele_TagsName("video-time"),"textContent"), "00:00 / 00:15","video is trimmed by default");
	    
	    //Step 18: Moving the trim line to middle and verify if User should be able to adjust the trim line.
	    //Expected:Save button is existing.
	    base.moveSlider(By.id("trimRange1"),"value","trim line is not adjustable");
	    asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Room("save_trimmed_video")));
	    
	    //Step 19: Click on play button
	    //Expected: System should play the video according to the trim line.
	    base.buttonClick(AddFollowerObj.Btn_FollowersEdit("trim-video-wrap","icon-snip-edit-play"));
	    Thread.sleep(4000);
	    
	    String videoTimeAfterTrim = base.GetAttribte(TagsObj.Ele_TagsName("video-time"),"textContent");
	    //Verifying if the video time before trimming and video time after trimming is different
	    //by checking like this video is playing at 00:00 time and i am trimming it to 00:03 time 
	    //checking if 00:00 and 00:03 is not equal
	    asrt.assertNotEquals(videoTimeBeforeTrim, videoTimeAfterTrim,"Video is not playing after trim");
	    
	    base.returnToMainWindow(driver);
	    try {
			 

			// Step 20: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 21: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 22: Click on yes in delete popup to delete added game
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	}
	
	
	///<summary>
	// Test Case Title:"There should be a trimming option in the player page of a completed game."
	//"There should be a trimming option in the player page of a uploaded game."
	//"The Trimming should not available for paused/in-progress games"
	// Automation ID  : TV_01
	///</summary>
	
	public void TV_01_TrimVideo() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		TrimVideo_TestData TrimVideoTestData=new TrimVideo_TestData();
 		FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersobj = new SearchGameTeamAndMembers_Obj();
		PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();
		TrimVideo_Obj TrimVideoObj=new TrimVideo_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		Thread.sleep(4000);
		
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		
		//Step 2   :"Click on Games Button"
		//Expected :"User should be able to click Games Button"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User not able to click Games button");
		
		// Step 3:Switch to any team from the team dropdown menu after selecting an
		// Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organiation is not being selected from the dropdown.");
		Thread.sleep(3000);

		// Step 4:Click outside the dropdown using Actions

		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);
		
		
		//////////////To verify whether the trim option is available for completed games

		// Step 5:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		
		//Step 6:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TrimVideoTestData.TV_01_teamName);
		
		//Step 7:Selecting the team
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName));
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",TrimVideoTestData.TV_01_teamName)), "Failed to select TEAM");
	    asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
		
	    ///////////////////  CREATE EVENT OR GAME
	    
	    // Step 8 :Click on +Event
		// Expected: "Create Game for" popup shown  to create game or event
		base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),TrimVideoTestData.TV_01_eventOrGameName);
		Thread.sleep(2000);
		String eventOrGameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		//base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_Home("toggle-item active","Home"));
		Thread.sleep(2000);
		
		//Step 9: Click on Create button
		//Expected:confirmation popup
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
		Thread.sleep(3000);

		//Step 10: Click on OK button in confirmation popup "Game added successfully"
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		// page loading so need this time
		Thread.sleep(8000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(eventOrGameName)),"Unable to Click on the menu icon (three dots)");
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(eventOrGameName));
		
		///////////////////   UPLOAD VIDEO 
		
		// Step 11 : Click on Upload video.
		// Expected: Menu Displayed and Able to click the Upload Video from dropdown
		base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		
		// Step 12: click on the Choose File icon, Verify that the file is mp4 or mov
		// Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);

		// Step 13: Click Upload and Shows Successfully Uploaded
		// Expected : User able to see the Successfully Uploaded Message and click
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		// Step 14: Click on game name
		// Expected : new window opened
		base.buttonClick(LoginPageObj.Btn_Login(eventOrGameName));
		Thread.sleep(18000);
		
		
		// Step 15: Switching to window
		base.switchToWindowByIndex(driver, 1);
		
		//Step 16: Getting the game name(TV01_TrimVideo) in the player page Entire Game Video - TV01_TrimVideo
		//Verifying if the user navigated to the same player page of the completed game by checking the game name
		String text=base.GetText(LoginPageObj.Ele_ErrorMessage("block-title payFullVideo"));
		String gameNameInArray[]=text.split("-");
	    asrt.assertTrue(eventOrGameName.equalsIgnoreCase(gameNameInArray[1].trim()));
		
	    //Expected:There should be a trimming option in the player page of a completed game.
	    asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_SearchField("trim-btn-img")),"Trim Button image is not displayed");
	    asrt.assertTrue(driver.findElement(PublicGameListingObj.Ele_SearchField("trim-btn-img")).isEnabled(), "Trim Button image is not Enabled for click");
	    Thread.sleep(2000);
		
	    //Step 17: switching back to main window
	    base.returnToMainWindow(driver);
	    try { 

			// Step 18: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(eventOrGameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 19: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 20: Click on yes in delete popup to delete added game
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	    
	    
	    ///////////////////////////         To verify whether the trim option is available for uploaded games
	    
	    
	    // Step 21: Click on existing and uploaded video game 
	 	// Expected : new window opened
	 	base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_uploadedGame));
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_01_uploadedGame));
	    Thread.sleep(18000);
	 		
	 	// Step 22: Switching to window
	 	//Getting the game name(TV02_TrimVideo) in the player page Entire Game Video - TV02_TrimVideo
	 	// Expected :Verifying if the user navigated to the same player page of the uploaded game by checking the game name
	 	base.switchToWindowByIndex(driver, 2);
	 	String gameNameOfUploadedVideo[]=base.GetText(LoginPageObj.Ele_ErrorMessage("block-title payFullVideo")).split("-");
		asrt.assertTrue(TrimVideoTestData.TV_01_uploadedGame.equalsIgnoreCase(gameNameOfUploadedVideo[1].trim()));
		
		//   USER IN PLAYER PAGE 
	 		
	 	//Step 23: There should be a trimming option in the player page of a uploaded game.
		driver.findElement(By.xpath("//i[@class='next-tool-icon']")).click();
		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_SearchField("trim-btn-img")),"Trim Button image is not displayed");
	 	Thread.sleep(2000);
	 	asrt.assertTrue(driver.findElement(PublicGameListingObj.Ele_SearchField("trim-btn-img")).isEnabled(), "Trim Button image is not Enabled for click");
	 	base.buttonClick(PublicGameListingObj.Ele_SearchField("trim-btn-img"));
	 		
	    Thread.sleep(2000);
	    
	    //Step 24: switching back to main window
	    base.returnToMainWindow(driver);
	    
	    //******************  The Trimming should not available for paused/in-progress games
	    
		//Step 25  :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.excuteJsClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
					
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("all-teams-wrap d-flex justify-content-between align-items-center list-wrap team_membertable game_team defaultteam all-teams-dark"));
	    
		//Step 26:click on 'Upload' game
		//Expected :"User should be able to select 'Upload'"
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_uploadedGame));
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_uploadedGame));
		Thread.sleep(10000);
	    
	    // Step 27: Switching to window
		//Getting the game name(LOOK) in the player page Live Streaming : LOOK 
	 	// Expected :Verifying if the user navigated to the same player page of the uploaded game by checking the game name
	 	base.switchToWindowByIndex(driver, 3);
	 	String gameNameOfInProgressVideo[]=base.GetText(LoginPageObj.Ele_ErrorMessage("live-stream-entire")).split(":");
	    asrt.assertTrue(TrimVideoTestData.TV_02_uploadedGame.equalsIgnoreCase(gameNameOfInProgressVideo[1].trim()));
	 	
	 	//Expected: The Trimming should not available for paused/in-progress games
	 	try {
	 	 Thread.sleep(1000);
	 	asrt.assertFalse(driver.findElement(PublicGameListingObj.Ele_SearchField("trim-btn-img")).isDisplayed(),"Trim Video image is displayed");
	 	}
	 	catch(org.openqa.selenium.NoSuchElementException e) {
	 		asrt.assertTrue(true,"Trim Video image is not displayed and this is expected behaviour");
 	 	}
	  
	}

}

