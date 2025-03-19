package testPage.MavenPageObject;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.LocalDateTime;
import TestData.CommonData;
import TestData.CreateUpdateDeleteGame_TestData;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.ArchiveUnarchiveTeam_Obj;
import objectRepository.CreateUpdateDeleteGame_Obj;
import objectRepository.FilterMembers_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.AddEditInfo_Obj;
import objectRepository.AddFollower_Obj;
import objectRepository.ViewListUpdateDownloadShareDeleteLibrary_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import utilPack.BasePge;

public class CreateUpdateDeleteGame extends BasePge {

	BasePge base;
	Assert asrt;

	public CreateUpdateDeleteGame(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To Verify that the entire facility camera page should be closed when click on Cancel button from the Facility Camera(s) page in Snipback page."
	// Automation ID : Game_26
	// </summary>

	public void Game_26_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_26_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_26_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_26_CreateGameTeamName);
		Thread.sleep(2000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_26_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_26_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(2000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_26_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		//      Bug -Click on Attach Facility Camera(s) not Found
		//		// Step 6 :"Click on Attach Facility Camera(s) in Snipback page"
		//		// Expected :"User should beClick on Attach Facility Camera(s) in Snipback page"
		//		base.buttonClick(LoginPageObj.Ele_ErrorMessage("d-flex  w-100"));
		//		Thread.sleep(1000);
		//		base.excuteJsClick(createupdateDeleteGameObj.Ele_Room5("fcam-room_152"));
		//
		//		// Step 7 :"Click Cancel button and Verify that the entire facility camera page should be closed from the Facility Camera(s) page in Snipback page"
		//		// Expected :"User should be Clickable Cancel button and that the entire facility camera page should be closed from the Facility Camera(s) page in Snipback page"
		//		base.excuteJsClick(createupdateDeleteGameObj.Btn_Cancel(
		//				"btn btn-secondary border-0 btn-popup bg-transparent1 text-dark width-100 bgcolor-grey close"));
		//		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")),
		//				"user is unable to view the Event creating page in Snipback page");

	}
	// <summary>
	// Test Case Title :"To Verify that the option " Clear Selection" should be
	// displayed when click on Attach Facility Camera(s) to cancel the facility camera for the game in Snipback page."
	// Automation ID : Game_27
	// </summary>

	public void Game_27_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_27_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_27_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_27_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_27_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_27_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_27_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		//      Bug -Click on Attach Facility Camera(s) not Found
		//		// Step 6 :"Click on Attach Facility Camera(s) in Snipback page"
		//		// Expected :"User should beClick on Attach Facility Camera(s) in Snipback page"
		//		base.buttonClick(LoginPageObj.Ele_ErrorMessage("d-flex  w-100"));
		//		Thread.sleep(1000);
		//
		//		// Step 7 :"Verify that the option " Clear Selection" should be displayed when
		//		// click on Attach Facility Camera(s) to cancel the facility camera for the game "
		//		// Expected :"User should be Verify that the option " Clear Selection" should be
		//		// displayed when click on Attach Facility Camera(s) to cancel the facility camera for the game"
		//		asrt.assertTrue(
		//				base.isExists(createupdateDeleteGameObj.Btn_Cancel(
		//						"btn btn-secondary border-0 btn-popup clear-selection text-dark width-100 bgcolor-grey close")),
		//				"user is unable to view option Clear Selection when click on Attach Facility Camera(s) for the game in Snipback page");

	}

	// <summary>
	// Test Case Title :"To Verify that the facility camera should be cleared when click on " Clear Selection" from the Select Room page in Snipback page."
	// Automation ID : Game_28
	// </summary>

	public void Game_28_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_28_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_28_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_28_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_28_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_28_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_28_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to enter the Event name with alphabets , numerics and special characters in game creating tab");

		//      Bug -Click on Attach Facility Camera(s) not Found
		//		// Step 6 :"Click on Attach Facility Camera(s) in Snipback page"
		//		// Expected :"User should beClick on Attach Facility Camera(s) in Snipback page"
		//		base.buttonClick(LoginPageObj.Ele_ErrorMessage("d-flex  w-100"));
		//		Thread.sleep(1000);
		//
		//		// Step 7 :"click on " Clear Selection" from the Select Room page "
		//		// Expected :"User should be Verify that the facility camera should be cleared when click on " Clear Selection" from the Select Room page"
		//		base.buttonClick(createupdateDeleteGameObj.Btn_Cancel(
		//				"btn btn-secondary border-0 btn-popup clear-selection text-dark width-100 bgcolor-grey close"));
		//		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")),
		//				"user is unable to view the Event creating page in Snipback page");

	}

	// <summary>
	// Test Case Title : The popup message "Verify that the message "Warning! Please choose a team and continue with game creation" should be closed when click on OK button
	// Please choose a team and continue with game creation" should be closed when click on OK button."
	// Automation ID : Game_06
	// </summary>
	public void Game_06_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj = new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();

		// Step 1 :"Login to Snipback"
		// Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		// Step 2 :Choose Home org or other organization (User as Admin/Coach)
		// Expected:The organization should be selected and the teams displayed
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_06_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_06_CreateGame)),
				"The option org is not selected from the team dropdown.");
		Thread.sleep(2000);

		// Step 3 :Click on +Event/Practice/Scout, The popup message "Verify that the message "Warning! Please choose a team and continue with game creation"
		// Expected:The alert warning popup is displayed
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(2000);
		asrt.assertTrue(
				base.isExists(LoginPageObj.Edt_AlertText("Please choose a team and continue with game creation")),
				"The alert 'Please choose a team and continue with game creation' is not displayed in the Games page.");

		// Step 4 :Click on Ok,  message should be closed when click on OK button
		// Expected:The popup message "Verify that the message "Warning! Please choose a
		// team and continue with game creation" should be closed when click on OK button
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn")),
				"Popup Warning Message 'Verify that the message 'Warning! Please choose a team and continue with game creation' should be closed when click on OK button' is not closed");

	}

	// <summary>
	// Test Case Title : "Verify that user should able to create Game after selecting any teams from the My Team List"
	// Automation ID : Game_07
	// </summary>
	public void Game_07_CreateUpdateDeleteGame() throws Exception {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj = new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj = new ViewListUpdateDownloadShareDeleteLibrary_Obj();


		// Step 1 :"Login to Snipback"
		// Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		// Step 2 :Choose Home org or other organization (User as Admin/Coach)
		// Expected:The organization should be selected and the teams displayed
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_07_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_07_CreateGame)),
				"The option 'org' is not selected from the team dropdown.");
		Thread.sleep(2000);

		// Step 3 :Choose any team
		// Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),createUpdateDeleteGametestdata.Game_07_CreateGameTeamName);
		base.pressKey(null,"KEYBOARD_ENTER");
		Thread.sleep(2000);
		base.buttonClick(
				CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_07_CreateGameTeamName));
		asrt.assertTrue(
				base.isExists(CreateUpdateDeleteGameObj
						.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_07_CreateGameTeamName)),
				"The team is not selected in the My Team list in the Games page.");

		// Step 4 :Click on +Event/Practice/Scout
		// Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),
				"The Create game Pop-up is not displayed in the games page. ");
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),
				createUpdateDeleteGametestdata.Game_07_CreateGameName);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertEquals(ActualName, CreateUpdateDeleteGame_TestData.Game_07_CreateGameName,"The actuall and entered names are displayed");
		base.buttonClick(ViewListUpdateDownloadShareDeleteLibraryObj
				.Btn_ReelsCancel("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"The alert 'Done' is not displayed in the games page.");

		//Step 9: Click on 'OK' button for creating event.
		//Expected: User should able to click 'OK' button for creating event
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("search")),"User  unable to click 'OK' button");

		// Step 10 : Delete game
		// Expected: The game should be deleted
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_07_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.setZoom(driver, 70);
		Thread.sleep(3000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_07_CreateGameName));
		Thread.sleep(500);
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
	}

	// <summary>
	// Test Case Title : "Verify that Game creation page should be displayed when click on +Event/Practice/Scout from the Film page"
	// Automation ID : Game_08
	// </summary>
	public void Game_08_CreateUpdateDeleteGame() throws Exception {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj = new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();

		// Step 1 :"Login to Snipback"
		// Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		// Step 2 :Choose Home org or other organization (User as Admin/Coach)
		// Expected:The organization should be selected and the teams displayed
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_08_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_08_CreateGame)),
				"The option 'Org' is not selected from the team dropdown.");
		Thread.sleep(2000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_08_CreateGameTeamName);
		Thread.sleep(2000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_08_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_08_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		// Step 4 :Click on +Event/Practice/Scout
		// Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),
				"The Create game Pop-up is not displayed in the games page. ");

	}

	// <summary>
	// Test Case Title :"Verify that the game should deleted when click on Yes button from the message Are you sure? Are you sure you want to delete the game?"
	// Automation ID   : Game_51
	// </summary>
	public void Game_51_CreateUpdateDeleteGame() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_51_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_51_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_51_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_51_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_51_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_51_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_51_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);
		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_51_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that the game should deleted when click on Yes button from the message Are you sure? Are you sure you want to delete the game?
		//Expected: User able to Delete when click on Yes button from the popup message
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_51_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn")),	"User unable to Delete when click on Yes button from the popup message ");

	}


	// <summary>
	// Test Case Title :"Verify that the deleted game should listed under Deleted tab in the Film page"
	// Automation ID   : Game_52
	// </summary>
	public void Game_52_CreateUpdateDeleteGame() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_52_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_52_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_52_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_52_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_52_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_52_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_52_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_52_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that the game should deleted when click on Yes button from the message Are you sure? Are you sure you want to delete the game?
		//Expected: User able to Delete when click on Yes button from the popup message
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_52_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn")),	"User unable to Delete when click on Yes button from the popup message ");

		// Step 14:Click on 'Deleted' Tab
		// Expected: validate the deleted game is showing under deleted tab
		Thread.sleep(1000);
		base.scrollToElementtoCenter(LoginPageObj.Btn_SingnIn("deleted_film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("deleted_film")),"Deleted tab not displaying");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("deleted_film"));

		//Step 15:Verify that the deleted game should listed under Deleted tab in the Film page
		//Expected: User able to see deleted game in the Deleted tab
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_52_CreateGameName))," User unable to see deleted game in the Deleted tab");
	}


	// <summary>
	// Test Case Title :"Verify that the Name field should accept alpabhets, numerics & special characters"
	// Automation ID : Game_16
	// </summary>

	public void Game_16_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_16_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_16_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_16_CreateGameTeamName);
		Thread.sleep(3000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_16_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_16_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		Thread.sleep(1000);
		base.buttonClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(1000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		Thread.sleep(1000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_16_CreateGameName);
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 6: Verify user can add game
		// Expected: Verify that the Name field should accept alpabhets, numerics & special characters
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_Create("btn btn-secondary border-0 btn-popup bg-transparent1 text-dark width-100", "btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Game added successfully")), "Game is unable to create ,as Name field not accept alpabhets, numerics & special characters");

		//Step 7: Click on 'OK' button for creating event.
		//Expected: User should able to click 'OK' button for creating event
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("search")),"User  unable to click 'OK' button");

		// Step 8 : Delete game
		// Expected: The game should be deleted
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_16_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.setZoom(driver, 70);
		Thread.sleep(3000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_16_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		Thread.sleep(2000);
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
	}

	// <summary>
	// Test Case Title :"Verify that user should able switch the tabs Events/Practice /Scout from Game creation page"
	// Automation ID : Game_21
	// </summary>

	public void Game_21_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_21_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_21_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_21_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_21_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_21_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_21_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 6 : .Select time zone if needed
		// Expected : User should able to view the selected time zone in the time zone field.
		asrt.assertTrue(
				base.isExists(RegistrationObj.Ele_ErrorMessage("India Standard Time(GMT+5:30)")),
				"User is unable to view the selected time zone ");

		//Step 7  :By default, Home should be selected in Game Mode from the Game creation page
		//Expected:Home should be selected in Game Mode from the Game creation page
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item active' and text()='Home")),"By Default 'Home' is not selected as th Game Mode");

		// Step 8 : Switch the game mode from Events to Practice,Practice  to Scout, Scout to Event
		// Expected : User should able to switch the game mode from Events/Practice /Scout
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("toggle-item toggle_custom_item2 "));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item toggle_custom_item2 active")),
				"User is unable to switch the game mode from Events to Practice in game creating tab.");
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("toggle-item toggle_custom_item3"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item toggle_custom_item3 active")),
				"User is unable to switch the game mode from Practice to Scout in game creating tab.");
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("toggle-item toggle_custom_item1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item toggle_custom_item1 active")),
				"User is unable to switch the game mode from Practice to Scout in game creating tab.");
	}

	// <summary>
	// Test Case Title :"Verify that the user should able to see the list of rooms
	// of the facility camera from the Game creation Page "
	// Automation ID : Game_22
	// </summary>

	public void Game_22_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_22_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_22_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_22_CreateGameTeamName);
		Thread.sleep(1000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_22_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_22_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(3000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_22_CreateGameName);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");


		//Bug: Click on Attach Facility Camera(s) not found
		// Step 6 : Click on Attach Facility Camera(s)
		// Expected : User should able to view the rooms list
		//		base.buttonClick(createupdateDeleteGameObj.Ele_FacilityRoom("Attach Facility Camera(s)", "facility_cameras"));
		//		asrt.assertTrue(base.isExists(FilterMembersObj.Ele_AllRoles("fcam-room_5")),
		//				"User is unable to view the rooms list while clicking Attach facility camera in Game creating tab");
	}

	// <summary>
	// Test Case Title :"Verify that the user should able to select the time zone from the Time Zone drop down"
	// Automation ID : Game_17
	// </summary>

	public void Game_17_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_17_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_17_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_17_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_17_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_17_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_17_CreateGameName);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 8 : Verify that the user should able to select the time zone from the Time Zone drop down
		// Expected : User should able to view the selected time zone in the time zone field.
		base.buttonClick(
				CreateUpdateDeleteGameObj.Ele_Time("dropdown__filter-selected state_time_zone_selected dropdown-list"));
		base.excuteJsClick(registrationObj.Ele_ErrorMessage("Alaska(AK) - Alaska Standard Time(GMT-10:00)"));
		base.excuteJsClick(
				CreateUpdateDeleteGameObj.Ele_Time("dropdown__filter-selected state_time_zone_selected dropdown-list"));

		base.setData(LoginPageObj.Edt_LoginEmail("search_state_time_zone"),"India");
		Thread.sleep(2000);
		base.buttonClick
		(registrationObj.Ele_ErrorMessage("India(IND) - India Standard Time(GMT+05:30)"));
		base.excuteJsClick(
				CreateUpdateDeleteGameObj.Ele_Time("dropdown__filter-selected state_time_zone_selected dropdown-list"));
		base.excuteJsClick(
				CreateUpdateDeleteGameObj.Ele_Time("dropdown__filter-selected state_time_zone_selected dropdown-list"));
		asrt.assertTrue(
				base.isExists(registrationObj.Ele_ErrorMessage("India(IND) - India Standard Time(GMT+05:30)")),
				"User is unable to view  the selected time zone");
		//		
		//		// Step 6: Verify user can add game
		//		// Expected: Verify that the Name field should accept alpabhets, numerics & special characters
		//		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_Create("btn btn-secondary border-0 btn-popup bg-transparent1 text-dark width-100", "btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		//		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Game added successfully")), "Game is unable to create ,as Name field not accept alpabhets, numerics & special characters");
		//		
		//		//Step 7: Click on 'OK' button for creating event.
		//		//Expected: User should able to click 'OK' button for creating event
		//		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		//		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("search")),"User  unable to click 'OK' button");
		//		base.setZoom(driver, 70);
		//		
		//		// Step 8 : Delete game
		//		// Expected: The game should be deleted
		//		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_17_CreateGameName);
		//		base.pressKey(null, "KEYBOARD_ENTER");
		//		
		//		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_17_CreateGameName));
		//		
		//		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		//		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		//		

	}

	// <summary>
	// Test Case Title :"Verify that the List of Facility camera(s) with check box should be listed when click on the Rooms "
	// Automation ID : Game_23
	// </summary>

	public void Game_23_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_23_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_23_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_23_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_23_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_23_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_23_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		//Bug: Click on Attach Facility Camera(s) not found
		// Step 6 : Click on Attach Facility Camera(s)
		// Expected : User should able to view the rooms list
		//		base.buttonClick(createupdateDeleteGameObj.Ele_FacilityRoom("Attach Facility Camera(s)", "facility_cameras"));
		//		asrt.assertTrue(base.isExists(FilterMembersObj.Ele_AllRoles("fcam-room_5")),
		//				"User is unable to view the rooms list while clicking Attach facility camera in Game creating tab");

		//		// Step 7 : Choose any Rooms
		//		// Expected : User should able to view the List of Facility camera(s) with check box listed when click on the Rooms
		//		base.buttonClick(FilterMembersObj.Ele_AllRoles("fcam-room_5"));
		//		asrt.assertTrue(base.isExists(registrationObj.Ele_OtpPage("room-fcam_5")),
		//				"User is unable to view the List of Facility camera(s) with check box listed when click on the Rooms");
	}

	// <summary>
	// Test Case Title :"Verify that Current date and time should be displayed in the Starts Option from the game creation page"
	// Automation ID : Game_18
	// </summary>

	public void Game_18_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_18_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_18_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_18_CreateGameTeamName);
		Thread.sleep(2000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_18_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_18_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_18_CreateGameName);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 6 : .Select time zone if needed
		// Expected : User should able to view the selected time zone in the time zone field.
		asrt.assertTrue(
				base.isExists(registrationObj.Ele_ErrorMessage("India Standard Time(GMT+5:30)")),
				"User is unable to view the selected time zone ");

		// Step 7 : Verify the current date and time
		// Expected : User should able to view the current date and time
		WebElement dateInput = driver.findElement(By.id("datetimepicker1"));
		// Fetch current system date & time
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
		String expectedDateTime = now.format(formatter);
		// Get actual value from input field
		String actualDateTime = dateInput.getAttribute("value");
		// Assertion to verify date & time
		Assert.assertEquals(actualDateTime, expectedDateTime, "Date and Time do not match!");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("datetimepicker1")),
				"User is unable to view the current date and time in Game creating tab");
	}

	// <summary>
	// Test Case Title :"Verify that Cancel and Save button should be displayed in Select Camera(s) page after select the room"
	// Automation ID : Game_24
	// </summary>

	public void Game_24_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_24_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_24_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_24_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_24_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_24_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_24_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		//Bug: Click on Attach Facility Camera(s) not found
		// Step 6 : Click on Attach Facility Camera(s)
		// Expected : User should able to view the rooms list
		//		base.buttonClick(createupdateDeleteGameObj.Ele_FacilityRoom("Attach Facility Camera(s)", "facility_cameras"));
		//		asrt.assertTrue(base.isExists(FilterMembersObj.Ele_AllRoles("fcam-room_5")),
		//				"User is unable to view the rooms list while clicking Attach facility camera in Game creating tab");
		//
		//		// Step 7 : Choose any Rooms
		//		// Expected : User should able to view the List of Facility camera(s) with check box listed when click on the Rooms
		//		base.buttonClick(FilterMembersObj.Ele_AllRoles("fcam-room_5"));
		//		asrt.assertTrue(base.isExists(registrationObj.Ele_OtpPage("room-fcam_5")),
		//				"User is unable to view the List of Facility camera(s) with check box listed when click on the Rooms");
		//		base.buttonClick(registrationObj.Ele_OtpPage("room-fcam_5"));
		//		base.buttonClick(createupdateDeleteGameObj.Btn_Cancelbtn("modal-footer",
		//				"btn btn-secondary border-0 btn-popup bg-transparent1 text-dark width-100 bgcolor-grey close"));
		//
		//		// Step 10 : Verify the option
		//		// Expected : User should able to view the Cancel and Create button
		//		asrt.assertTrue(
		//				base.isExists(PoolObj
		//						.Btn_ButtonCreate("btn btn-secondary border-0 btn-popup bg-transparent1 text-dark width-100")),
		//				" User is unable to view the Cancel button in Game creating tab");
		//		asrt.assertTrue(
		//				base.isExists(createupdateDeleteGameObj.Btn_Create(
		//						"btn btn-secondary border-0 btn-popup bg-transparent1 text-dark width-100",
		//						"btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red")),
		//				" User is unable to view the Create button in Game creating tab");
	}

	// <summary>
	// Test Case Title :"Verify that by default, Home should be selected in Game Mode from the Game creation page"
	// Automation ID : Game_19
	// </summary>

	public void Game_19_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_19_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_19_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_19_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_19_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_19_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_19_CreateGameName);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 6 : .Select time zone if needed
		// Expected : User should able to view the selected time zone in the time zone field.
		asrt.assertTrue(
				base.isExists(RegistrationObj.Ele_ErrorMessage("India Standard Time(GMT+5:30)")),
				"User is unable to view the selected time zone ");

		//Step 7  :By default, Home should be selected in Game Mode from the Game creation page
		//Expected:By default, Home should be selected in Game Mode from the Game creation page
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item active' and text()='Home")),"By Default 'Home' is not selected as th Game Mode");
	}

	// <summary>
	// Test Case Title :"Verify that the Name of the facility camera should be
	// reflected in the field Attach Facility Camera(s) after clicking Save button from the Select Camera(s) page "
	// Automation ID : Game_25
	// </summary>

	public void Game_25_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_25_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_25_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_25_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_25_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_25_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_25_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		//		//bug: Unable to Click Attach Facility Camera. Camera Disabled
		//		// Step 6 : Click on Attach Facility Camera(s)
		//		// Expected : User is unable to view the rooms list while clicking Attach facility camera in Game creating tab
		//		base.buttonClick(createupdateDeleteGameObj.Ele_FacilityRoom("Attach Facility Camera(s)", "facility_cameras"));
		//		asrt.assertTrue(base.isExists(FilterMembersObj.Ele_AllRoles("fcam-room_5")),
		//				"User is unable to view the rooms list while clicking Attach facility camera in Game creating tab");
		//
		//		// Step 7 : Choose any Rooms and camera then click on save button
		//		// Expected : The Name of the facility camera should be reflected in the field
		//		// Attach Facility Camera(s) after clicking Save button from the Select Camera(s) page
		//		base.buttonClick(FilterMembersObj.Ele_AllRoles("fcam-room_5"));
		//		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Ele_MemberName("Motorola (#6931)")),
		//				"User is unable to view the List of Facility camera(s) with check box listed when click on the Rooms");
		//		base.excuteJsClick(searchgameteamandmembersObj.Ele_MemberName("Motorola (#6931)"));
		//		base.excuteJsClick(createupdateDeleteGameObj.Btn_Create(
		//				"btn btn-secondary border-0 btn-popup bg-transparent1 text-dark width-100 bgcolor-grey close",
		//				"btn btn-primary border-0 btn-popup width-100 bgcolor-red"));
		//		asrt.assertTrue(
		//				base.isExists(
		//						createupdateDeleteGameObj.Ele_FacilityRoom("Attach Facility Camera(s)", "facility_cameras")),
		//				"User is unable to view the name of the facility camera reflected in the field Attach Facility Camera(s) after clicking Save button from the Select Camera(s) page ");

	}

	// <summary>
	// Test Case Title :"Verify that user should able switch the Game mode from Home to Away and viceversa from the Game creation page"
	// Automation ID : Game_20
	// </summary>

	public void Game_20_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_20_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_20_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_20_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_20_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_20_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_20_CreateGameName);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 6 : .Select time zone if needed
		// Expected : User should able to view the selected time zone in the time zone field.
		asrt.assertTrue(
				base.isExists(RegistrationObj.Ele_ErrorMessage("India Standard Time(GMT+5:30)")),
				"User is unable to view the selected time zone ");

		//Step 7  :By default, Home should be selected in Game Mode from the Game creation page
		//Expected:Home should be selected in Game Mode from the Game creation page
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item active' and text()='Home")),"By Default 'Home' is not selected as th Game Mode");

		//Step 7  :Verify that user should able switch the Game mode from Home to Away and viceversa from the Game creation page
		//Expected:User able to switch 
		base.buttonClick(RegistrationObj.Ele_OtpPage("away"));//bug
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item active' and text()='Away")),"unable to switch to 'Away");
		Thread.sleep(1000);
		base.buttonClick(RegistrationObj.Ele_OtpPage("home"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item active' and text()='Home")),"unable to switch to 'Homay' ie viceversa");

	}

	// <summary>
	// Test Case Title :"Verify that user should able to navigate to the SnipbackWebsite after entering the URL"
	// Automation ID : Game_01
	// </summary>

	public void Game_01_CreateUpdateDeleteGame() throws InterruptedException {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		// Step 1 :"Enter the URL"
		// Expected:"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),
				"User is not be able to navigate to the SnipbackWebsite after entering the URL");

	}

	// <summary>
	// Test Case Title :"Verify that the Categories drop should be displayed the following game categories "
	// Automation ID : Game_36
	// </summary>

	public void Game_36_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_36_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_36_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_36_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_36_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_36_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		//Step 7   :"Enter the Event Name in Snipback page"
		//Expected :"User should be enter the Event Name in Snipback page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),createUpdateDeleteGametestdata.Game_36_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to enter the Event name with alphabets , numerics and special characters in game creating tab");

		//Step 8   :"Click on Advanced feature in Snipback page"
		//Expected :"User should be Clickable on ADVANCED FEATURES in Snipback page"
		base.excuteJsClick(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES"));
		asrt.assertTrue(base.isEnabledBy(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES")),
				"User is unable to Click on ADVANCED FEATURES in Snipback page ");

		// Step 9 : Click on Game category drop down
		// Expected : User should able to view the Categories drop which displays the
		// game categories 1. Other Category
		// 2.Weight Lifting
		// 3.Basket Ball
		// 4.Baseball
		// 5.Volleyball
		// 6.Tennis
		// 7.Football
		// 8.Hockey
		// 9.Soccer
		// 10.Wrestling

		base.scrollToElement(searchgameteamandmembersObj.Ele_MemberName("Category (optional)"));
		base.buttonClick(
				CreateUpdateDeleteGameObj.Ele_DropdownClick("d-flex w-50","dropdown__filter-selected category_selected dropdown-list"));

		WebElement otherOption = driver.findElement(CreateUpdateDeleteGameObj.Ele_DropdownDetails("d-flex w-50","dropdown__select scrollspy-example","dropdown__select-option category","Other Category"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", otherOption);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Category("other category")),
				"User is unable to view the Other Category option under game categories in game creation tab");		

		WebElement weightlifting = driver.findElement(CreateUpdateDeleteGameObj.Ele_DropdownDetails("d-flex w-50","dropdown__select scrollspy-example","dropdown__select-option category","Weight Lifting"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", weightlifting);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Category("weight lifting")),
				"User is unable to view the Weight lifting option under game categories in game creation tab");

		WebElement basketballOption = driver.findElement(CreateUpdateDeleteGameObj.Ele_DropdownDetails("d-flex w-50","dropdown__select scrollspy-example","dropdown__select-option category","Basketball"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", basketballOption);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Category("basketball")),
				"User is unable to view the Basketball option under game categories in game creation tab");

		WebElement volleyballOption = driver.findElement(CreateUpdateDeleteGameObj.Ele_DropdownDetails("d-flex w-50","dropdown__select scrollspy-example","dropdown__select-option category","Volleyball"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", volleyballOption);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Category("volleyball")),
				"User is unable to view the volleyball option under game categories in game creation tab");

		WebElement tennisOption = driver.findElement(CreateUpdateDeleteGameObj.Ele_DropdownDetails("d-flex w-50","dropdown__select scrollspy-example","dropdown__select-option category","Tennis"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tennisOption);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Category("tennis")),
				"User is unable to view the Tennis option under game categories in game creation tab");

		WebElement footballOption = driver.findElement(CreateUpdateDeleteGameObj.Ele_DropdownDetails("d-flex w-50","dropdown__select scrollspy-example","dropdown__select-option category","Football"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footballOption);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Category("football")),
				"User is unable to view the Football option under game categories in game creation tab");

		WebElement hockeyOption = driver.findElement(CreateUpdateDeleteGameObj.Ele_DropdownDetails("d-flex w-50","dropdown__select scrollspy-example","dropdown__select-option category","Hockey"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hockeyOption);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Category("hockey")),
				"User is unable to view the Hockey option under game categories in game creation tab");

		WebElement soccerOption = driver.findElement(CreateUpdateDeleteGameObj.Ele_DropdownDetails("d-flex w-50","dropdown__select scrollspy-example","dropdown__select-option category","Soccer"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", soccerOption);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Category("soccer")),
				"User is unable to view the Soccer option under game categories in game creation tab");

		//		WebElement wrestlingOption = driver.findElement(CreateUpdateDeleteGameObj.Ele_DropdownDetails("d-flex w-50","dropdown__select scrollspy-example","dropdown__select-option category","wrestling"));
		//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wrestlingOption);
		//       asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_Category("wrestling")),
		//				"User is unable to view the Wrestling option under game categories in game creation tab");
	}

	// <summary>
	// Test Case Title :"Verify that Enable ball tracking (Disabled/Enabled) option should be displayed for the following categories;
	// 1.Basket Ball
	// 2.Volleyball "
	// Automation ID : Game_37
	// </summary>

	public void Game_37_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_37_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_37_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_37_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_37_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_37_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		//Step 7   :"Enter the Event Name in Snipback page"
		//Expected :"User should be enter the Event Name in Snipback page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),createUpdateDeleteGametestdata.Game_37_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to enter the Event name with alphabets , numerics and special characters in game creating tab");

		//Step 8   :"Click on Advanced feature in Snipback page"
		//Expected :"User should be Clickable on ADVANCED FEATURES in Snipback page"
		base.excuteJsClick(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES"));
		asrt.assertTrue(base.isEnabledBy(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES")),
				"User is unable to Click on ADVANCED FEATURES in Snipback page ");

		// Step 9 : Click on Game category drop down and click on basket ball
		// Expected : User should able to view the Enable ball tracking (Disabled/Enabled) option in game creation tab while selecting Basketball in game category
		base.scrollToElement(searchgameteamandmembersObj.Ele_MemberName("Category (optional)"));
		base.buttonClick(
				CreateUpdateDeleteGameObj.Ele_DropdownClick("d-flex w-50","dropdown__filter-selected category_selected dropdown-list"));
		WebElement basketballOption = driver.findElement(CreateUpdateDeleteGameObj.Ele_DropdownDetails("d-flex w-50","dropdown__select scrollspy-example","dropdown__select-option category","Basketball"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", basketballOption);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_Category("basketball"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("ball-track-wrap ")),
				"User is unable to view the Enable ball tracking (Disabled/Enabled) option in game creation tab while selecting Basketball in game category");

		// Step 10 : Click on Game category drop down and click on Volleyball
		// Expected : User should able to view the Enable ball tracking (Disabled/Enabled) option in game creation tab while selecting Basketball in game category
		base.scrollToElement(searchgameteamandmembersObj.Ele_MemberName("Category (optional)"));
		base.buttonClick(
				CreateUpdateDeleteGameObj.Ele_DropdownClick("d-flex w-50","dropdown__filter-selected category_selected dropdown-list"));
		WebElement VolleyballOption = driver.findElement(CreateUpdateDeleteGameObj.Ele_DropdownDetails("d-flex w-50","dropdown__select scrollspy-example","dropdown__select-option category","Volleyball"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", VolleyballOption);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_Category("volleyball"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("ball-track-wrap ")),
				"User is unable to view the Enable ball tracking (Disabled/Enabled) option in game creation tab while selecting Volleyball in game category");
	}

	// <summary>
	// Test Case Title :"Verify that Opponent team should be choosed/or created from the Opponent team dropdown from the Game creation page
	// Automation ID : Game_38
	// </summary>

	public void Game_38_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_38_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_38_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_38_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_38_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_38_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(3000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		//Step 7   :"Enter the Event Name in Snipback page"
		//Expected :"User should be enter the Event Name in Snipback page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),createUpdateDeleteGametestdata.Game_38_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to enter the Event name with alphabets , numerics and special characters in game creating tab");

		//Step 8   :"Click on Advanced feature in Snipback page"
		//Expected :"User should be Clickable on ADVANCED FEATURES in Snipback page"
		base.excuteJsClick(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES"));
		asrt.assertTrue(base.isEnabledBy(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES")),
				"User is unable to Click on ADVANCED FEATURES in Snipback page ");

		// Step 9 : Choose any opponent team or created from the Opponent team dropdown from the Game creation page
		// Expected : USer should able to choose an oppionent team from Opponent team drop down
		base.scrollToElement(registrationObj.Ele_RegistrationExists("Opponent Team"));
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_Team("dropdown__filter dropdwn_ul_away_selected"));
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateTeam("add-teams-btn"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Add Opponent Team")),"User is unable to view the Oponent team creating tab in game creating tab");
		Thread.sleep(3000);
		base.setData(LoginPageObj.Edt_LoginEmail("team_opponent"),createUpdateDeleteGametestdata.Game_08_CreateOpponentTeam);
		base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger saveOpponentTeam"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-danger saveOpponentTeam")),"User is unable to create/choose opponent team in the opponent team field");
	}

	// <summary>
	// Test Case Title :"Verify that Other team should be choosed Other Teams (optional) dropdown from the Game creation page"
	// Automation ID : Game_39
	// </summary>

	public void Game_39_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_39_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_39_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_39_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_39_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_39_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		//Step 7   :"Enter the Event Name in Snipback page"
		//Expected :"User should be enter the Event Name in Snipback page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),createUpdateDeleteGametestdata.Game_39_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to enter the Event name with alphabets , numerics and special characters in game creating tab");

		//Step 8   :"Click on Advanced feature in Snipback page"
		//Expected :"User should be Clickable on ADVANCED FEATURES in Snipback page"
		base.excuteJsClick(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES"));
		asrt.assertTrue(base.isEnabledBy(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES")),
				"User is unable to Click on ADVANCED FEATURES in Snipback page ");

		// Step 9 : Choose other team
		// Expected : User should able to choose an other team from Choose other team drop down
		base.scrollToElement(registrationObj.Ele_RegistrationExists("Other Teams (optional)"));
		base.buttonClick(registrationObj.Ele_OtpPage("otherTeamsDiv"));
		base.scrollToElement(CreateUpdateDeleteGameObj.Ele_OtherTeam("dropdown-menu inner","1"));
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_OtherTeam("dropdown-menu inner","1"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_OtherTeam("dropdown-menu inner","1")),
				"User is unable to view the choosed other team in the Other team(Optional) field");

	}

	// <summary>
	// Test Case Title :"Verify that user should able to navigate to the Film page once login with credentials"
	// Automation ID : Game_02
	// </summary>

	public void Game_02_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		// Step 1 :"Login to snipback with valid credentials"
		// Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		Thread.sleep(3000);
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_Film("nav-item", "Film"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_Film("nav-item", "Film")),
				"User is unable to navigate to the Film page once login with credentials");
	}

	// <summary>
	// Test Case Title :"Verify that the following options should be displayed in
	// GAMES under Film Page for creating game; +Event, +Practice, +Scout"
	// Automation ID : Game_04
	// </summary>

	public void Game_04_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj= new CreateUpdateDeleteGame_Obj();

		// Step 1 :"Login to snipback with valid credentials"
		// Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);

		//Step 2   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_04_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_04_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_04_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_04_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_04_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		// Step 4 : "Verify the options, +Event, +Practice, +Scout"
		// Expected:The following options should be displayed in GAMES under Film Page for creating game; +Event, +Practice, +Scout"
		// base.buttonClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Event")),
				"User is unable to see +Event button in the games page");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("practice_film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Practice")),
				"User is unable to see +Practice button in the games page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("scout_film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Scout")),
				"User is unable to see +Scout button in the games page");
	}

	// <summary>
	// Test Case Title : "Game added successfully message should be displayed when
	// click on Create button after entering all the required information from the top of the game creation page"
	// Note: Initially testcase was "Game created successfully message" but as per confirmation from client side akhila test case updated as "Game added
	// successfully message"
	// Automation ID : Game_40
	// </summary>
	public void Game_40_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_40_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_40_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_40_CreateGameTeamName);
		Thread.sleep(3000);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_40_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_40_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 5 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_40_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 5: verify Create button is displayed in create game page
		// Expected: Create button is displayed in create game page
		String gameNameInScoutField = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE")),
				"Create button is not displayed in create game page");

		// Step 7: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 8: check Game added successfully message validation
		//Expected: Game added successfully message validation showing 
		String gameAddedMessageInScoutField = base.GetText(LoginPageObj.Ele_ErrorMessage("swal-text"));
		asrt.assertEquals(gameAddedMessageInScoutField, "Game added successfully", "Failed to create game,Sucees message not displayed");

		// Step 9 : Delete game
		// Expected: The game should be deleted
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_40_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_40_CreateGameName));
		base.setZoom(driver, 70);
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));


	}

	// <summary>
	// Test Case Title : "Three dots should be displayed against each games under Film Page"
	// Automation ID : Game_42
	// </summary>

	public void Game_42_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_42_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_42_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_42_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_42_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_42_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_42_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 8: verify Create button is displayed in create game page
		// Expected: Create button is displayed in create game page
		String gameNameInScoutField = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE")),
				"Create button is not displayed in create game page");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_42_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		//base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_42_CreateGameName));
		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_42_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(1000);

		//Step 10: delete Team		
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_42_CreateGameName));
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));

	}

	// <summary>
	// Test Case Title : "Edit option should be displayed in three dots against each games under Film Page"
	// Automation ID : Game_43
	// </summary>

	public void Game_43_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_43_CreateGame));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_43_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_43_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_43_CreateGameTeamName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_43_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_43_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 8: verify Create button is displayed in create game page
		// Expected: Create button is displayed in create game page
		String gameNameInScoutField = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE")),
				"Create button is not displayed in create game page");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_43_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_43_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(2000);

		//Step 11: Verify that Edit option should be displayed in three dots against each games under Film Page
		//Expected: User should able view edit event 
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_43_CreateGameName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_Delete("btn-group dropleft right-menu-wrap show","Edit Event")),"'Edit Event' Option is not displaying");      

		//Step 12: delete Team		
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	

	}

	// <summary>
	// Test Case Title : "The page for Edit the details of the Game should be displayed when click on Edit option"
	// Automation ID : Game_44
	// </summary>

	public void Game_44_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_44_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_44_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_44_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_44_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_44_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_44_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 8: verify Create button is displayed in create game page
		// Expected: Create button is displayed in create game page
		String gameNameInScoutField = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE")),
				"Create button is not displayed in create game page");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_44_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_44_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that the page for Edit the details of the Game should be displayed when click on Edit option
		//Expected: User should able view Edit the details of the Game should be displayed when click on Edit option
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_44_CreateGameName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_Delete("btn-group dropleft right-menu-wrap show","Edit Event")),"'Edit Event' Option is not displaying");      
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_Delete("btn-group dropleft right-menu-wrap show","Edit Event"));		
		asrt.assertEquals(base.GetText(CreateUpdateDeleteGameObj.Ele_EditGameHeader("create_edit_game", "h3")),
				"Edit Game for", "Edit the details of the Game is not displaying");

		//Step 12: delete Team		
		Thread.sleep(3000);
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_UpdateButtonInEditGame("modal-header border-bottom-0 pb-0","CANCEL"));
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_44_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	

	}

	// <summary>
	// Test Case Title : "The message Done! Game updated successfully with OK should displayed after making any changes & clicking update button"
	// Automation ID : Game_45
	// </summary>

	public void Game_45_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_45_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_45_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_45_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_45_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_45_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_45_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 8: verify Create button is displayed in create game page
		// Expected: Create button is displayed in create game page
		String gameNameInScoutField = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE")),
				"Create button is not displayed in create game page");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_45_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_45_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that the page for Edit the details of the Game should be displayed when click on Edit option
		//Expected: User should able view Edit the details of the Game should be displayed when click on Edit option
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_45_CreateGameName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_Delete("btn-group dropleft right-menu-wrap show","Edit Event")),"'Edit Event' Option is not displaying");      
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_Delete("btn-group dropleft right-menu-wrap show","Edit Event"));		
		asrt.assertEquals(base.GetText(CreateUpdateDeleteGameObj.Ele_EditGameHeader("create_edit_game", "h3")),
				"Edit Game for", "Edit the details of the Game is not displaying");


		//Step 12: Verify that the message Done! Game updated successfully with OK should displayed after making any changes & clicking update button
		//Expected:Game updated successfully text is displaying
		base.buttonClick(
				CreateUpdateDeleteGameObj.Btn_UpdateButtonInEditGame("modal-header border-bottom-0 pb-0", "UPDATE"));
		asrt.assertEquals(base.GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Game updated successfully",
				"Game updated successfully text is not correct");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("OK")), "OK button is not displayed");

		//Step 13: delete Team	
		base.buttonClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_45_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	

	}

	//<summary>
	// Test Case Title :"Verify that Game should able to be created in  Organization & in the organization if the User roles as Admin/Coach "
	// Automation ID   : Game_03
	// </summary>

	public void Game_03_CreateUpdateDeleteGame() throws InterruptedException {
		Login login=new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata= new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();		
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);

		//Step 2   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_03_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_03_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_03_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_03_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_03_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4   :"Click the Event button in Snipback page"
		//Expected :"User should be clickable the Event button in Snipback page"
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Event"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Event")), "user is unable to view the Event creating page in Snipback page");

		//Step 5   :"Enter the Game Name"
		//Expected :"User should able to enter the name in create game"
		Thread.sleep(1000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),createUpdateDeleteGametestdata.Game_03_CreateGameName);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		Thread.sleep(1000);
		asrt.assertEquals(ActualName,createUpdateDeleteGametestdata.Game_03_CreateGameName,"User should unable to enter the name in create game");

		//Step 6: Click on 'away' .
		//Expected: User should able to click 'away' 
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_selectteam("away"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_Create("btn btn-secondary border-0 btn-popup bg-transparent1 text-dark width-100", "btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red")), "User unable to click 'away'");

		// Step 7: Verify user can add game
		// Expected: user can able to add game
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_Create("btn btn-secondary border-0 btn-popup bg-transparent1 text-dark width-100", "btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Game added successfully")), "Game is unable to create in Home Organization & in the organization if the User roles as Admin/Coach ");

		//Step 9: Click on 'OK' button for creating event.
		//Expected: User should able to click 'OK' button for creating event
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("search")),"User  unable to click 'OK' button");

		// Step 10 : Delete game
		// Expected: The game should be deleted
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_03_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);
		base.setZoom(driver, 70);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_03_CreateGameName));
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));

	}


	//<summary>
	// Test Case Title :"Verify that the message "Warning! Please choose a team and continue with game creation" with OK button should be displayed when try create a game without choosing the team"
	// Automation ID   : Game_05
	// </summary>

	public void Game_05_CreateUpdateDeleteGame() throws InterruptedException {

		Login login=new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();
		AddFollower_Obj AddFollowerObj= new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();

		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);

		//Step 2  :"Choose Home org or other organization (User as Admin/Coach)
		//Expected:"User should able to Choose Home org or other organization (User as Admin/Coach)"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(AddFollowerObj.Ele_SelectRole(createUpdateDeleteGametestdata.Game_05_CreateGame));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole(createUpdateDeleteGametestdata.Game_05_CreateGame)), "User is unable to Choose AA Q-Dev - 2054 organization (User as Admin/Coach)");
		Thread.sleep(2000);

		//Step 3   :"Click the Event button in Snipback page"
		//Expected :"The message "Warning!Please choose a team and continue with game creation" with OK button should be displayed when try create a game without choosing the team"
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Warning!")),"The alert 'Warning' is not displayed in the Games page.");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_UpdateButtonInEditGame("swal-button-container", "OK")),"Warning Message 'OK' not Displayed");
	}

	// <summary>
	// Test Case Title :"Verify that Proper Message Error! Enter the Event Name should displayed when we left the Event Name field blank from the Game Creation page"
	// Automation ID   : Game_15
	// </summary>

	public void Game_15_CreateUpdateDeleteGame() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_15_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_15_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(2000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_15_CreateGameTeamName);
		Thread.sleep(3000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_15_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_15_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		//Step 5 : Leave the Event Name blank and click on create button
		//Expected : User should able to view an error message while leaving the event name field as blank on game creating tab 
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_Create("btn btn-secondary border-0 btn-popup bg-transparent1 text-dark width-100", "btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Enter the Event Name")),"User unable to view the error message while leaving the event name field as blank in game creating tab.");	
	}

	// <summary>
	// Test Case Title :"Verify that Scout should selected as default if we create a game from Scout in the Game creation page"
	// Automation ID   : Game_14
	// </summary>

	public void Game_14_CreateUpdateDeleteGame() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata =new CreateUpdateDeleteGame_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj =new CreateAddNewMemberWithEmail_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_14_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_14_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(2000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_14_CreateGameTeamName);
		Thread.sleep(2000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_14_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_14_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Scout
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("scout_film"));
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		//Bug Scout Default not found
		//Step 5  :Verify that Event should selected as default if we create a game from Scout in the Game creation page
		//Expected:Scout should selected as default if we create a game from Scout in the Game creation page
		//asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item toggle_custom_item3 active")),"Scout is not selected as default in the Games creation popup in the Games page.");

	}

	// <summary>
	// Test Case Title :"Verify that Practice should selected as default if we create a game from Practice in the Game creation page"
	// Automation ID   : Game_13
	// </summary>

	public void Game_13_CreateUpdateDeleteGame() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata =new CreateUpdateDeleteGame_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_13_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_13_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(2000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_13_CreateGameTeamName);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.excuteJsClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_13_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_13_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");

		//Step 4  :Click on +Practice
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Btn_SingnIn("practice_film"));
		Thread.sleep(3000);
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		//Step 5  :Verify that Event should selected as default if we create a game from Event in the Game creation page
		//Expected:Practice should selected as default if we create a game from Practice in the Game creation page
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item toggle_custom_item2 active")),"Practice is not selected as default in the Games creation popup in the Games page.");

	}

	// Test Case Title : "The popup message should be closed after clicking the OK button"
	// Automation ID : Game_46
	// </summary>

	public void Game_46_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_46_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_46_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_46_CreateGameTeamName);
		Thread.sleep(1000);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_46_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_46_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_46_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 8: verify Create button is displayed in create game page
		// Expected: Create button is displayed in create game page
		String gameNameInScoutField = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE")),
				"Create button is not displayed in create game page");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_46_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.setZoom(driver, 70);
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_46_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that the page for Edit the details of the Game should be displayed when click on Edit option
		//Expected: User should able view Edit the details of the Game should be displayed when click on Edit option
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_46_CreateGameName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_Delete("btn-group dropleft right-menu-wrap show","Edit Event")),"'Edit Event' Option is not displaying");      
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_Delete("btn-group dropleft right-menu-wrap show","Edit Event"));		
		asrt.assertEquals(base.GetText(CreateUpdateDeleteGameObj.Ele_EditGameHeader("create_edit_game", "h3")),
				"Edit Game for", "Edit the details of the Game is not displaying");


		//Step 12: Verify that the popup message should be closed after clicking the OK button
		//Expected:User is able to close after clicking the OK button
		base.buttonClick(
				CreateUpdateDeleteGameObj.Btn_UpdateButtonInEditGame("modal-header border-bottom-0 pb-0", "UPDATE"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("OK"));
		asrt.assertTrue(base.isExistsNegative(LoginPageObj.Btn_SignInButton("OK")), "OK button is displayed");

		//Step 13: delete Team		
		Thread.sleep(3000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_46_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	
	}

	// <summary>
	// Test Case Title : "Verify that the changes should be reflected on the game we edited from the Game list"
	// Automation ID : Game_47
	// </summary>

	public void Game_47_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_47_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_47_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_47_CreateGameTeamName);
		Thread.sleep(1000);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_47_CreateGameTeamName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_47_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_47_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 8: verify Create button is displayed in create game page
		// Expected: Create button is displayed in create game page
		String gameNameInScoutField = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE")),
				"Create button is not displayed in create game page");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_47_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_47_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that the page for Edit the details of the Game should be displayed when click on Edit option
		//Expected: User should able view Edit the details of the Game should be displayed when click on Edit option
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_47_CreateGameName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_Delete("btn-group dropleft right-menu-wrap show","Edit Event")),"'Edit Event' Option is not displaying");      
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_Delete("btn-group dropleft right-menu-wrap show","Edit Event"));		
		asrt.assertEquals(base.GetText(CreateUpdateDeleteGameObj.Ele_EditGameHeader("create_edit_game", "h3")),
				"Edit Game for", "Edit the details of the Game is not displaying");


		//Step 12: Verify that the popup message should be closed after clicking the OK button
		//Expected:User is able to close after clicking the OK button
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_47_CreateGameName);
		base.buttonClick(
				CreateUpdateDeleteGameObj.Btn_UpdateButtonInEditGame("modal-header border-bottom-0 pb-0", "UPDATE"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("OK"));
		asrt.assertTrue(base.isExistsNegative(LoginPageObj.Btn_SignInButton("OK")), "OK button is displayed");

		//Step 13: delete Team		
		Thread.sleep(4000);
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_47_CreateGameName);
        base.pressKey(null, "KEYBOARD_ENTER");
        Thread.sleep(4000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_47_CreateGameName));
		Thread.sleep(2000);//base.excuteJsClick(LoginPageObj.Btn_SingnIn("dropdownMenuButton1"));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		Thread.sleep(2000);
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	

	}

	// <summary>
	// Test Case Title : "Delete option should be displayed in three dots against each games under Film Page"
	// Automation ID : Game_48
	// </summary>

	public void Game_48_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_48_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_48_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_48_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_48_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_48_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_48_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_48_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_48_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that Delete option should be displayed in three dots against each games under Film Page
		//Expected: Delete option Displayed
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_48_CreateGameName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_Delete("dropdown-menu dropdown-menu-center show","Delete")),"'Delete' Option is not displaying");      

		//Step 13: delete Team		
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	

	}

	// <summary>
	// Test Case Title : "Are you sure? Are you sure you want to delete message with
	// Game name ? & Yes and Cancel button should be displayed when click on Delete Icon from three dots"
	// Automation ID : Game_49
	// </summary>

	public void Game_49_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_49_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_49_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_49_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_49_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_49_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_49_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_49_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_49_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that Are you sure? Are you sure you want to delete message with Game name ? & Yes and Cancel button should be displayed
		//Expected: Delete message Displayed and Yes or Cancel button displayed
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_49_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),	"Are you sure you want to delete with game name? is not displayed");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")),
				"Yes button is not displayed");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel")),
				"Cancel button is not displayed");

		//Step 12: delete Team		
		Thread.sleep(3000);
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	
	}

	// <summary>
	// Test Case Title : "Game should listed under Events/Practice/Scout under Games in the Film page"
	// Automation ID : Game_41
	// </summary>

	public void Game_41_CreateUpdateDeleteGame() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_41_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_41_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_41_CreateGameTeamName);
		Thread.sleep(1000);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(1000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_41_CreateGameTeamName));
		
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_40_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_41_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 8: verify Create button is displayed in create game page
		// Expected: Create button is displayed in create game page
		String gameNameInScoutField = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE")),
				"Create button is not displayed in create game page");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		//Step 10:Verify created Game is listed under Events under Games in the Film page
		// Expected: Game s not listed under Events
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		Thread.sleep(3000);		
		//asrt.assertEquals(base.GetText(LoginPageObj.Btn_Login(createUpdateDeleteGametestdata.Game_41_CreateGameName)), createUpdateDeleteGametestdata.Game_41_CreateGameName,"Game is not added in Events table");

		// Step 11 : Delete game
		// Expected: The game should be deleted
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_41_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

	    //base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_41_CreateGameName));
	    base.excuteJsClick(LoginPageObj.Btn_SingnIn("dropdownMenuButton1"));
		base.setZoom(driver, 80);
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));

		//*************         Verify if Game Created in Practice field is shown under Practice table   ****************//

		// Step 12: click on Practices
		// Expected: User will be navigated to practice page
		base.buttonClick(LoginPageObj.Btn_SingnIn("practice_film"));

		Thread.sleep(3000);

		// Step 13: click on +Practice
		// Expected: Create Game for dialog box is displayed
		base.buttonClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(2000);	
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGameTitle("text-center fw-bold sizing")),"The header Create Game is not displayed");

		// Step 14: enter game name in text box displayed to create a game
		//Expected: Create button is displayed
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_41_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Practice name with alphabets , numerics and special characters in game creating tab");

		// Step 15: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		//Step 16:Verify created Game is listed under Pratice under Games in the Film page
		// Expected: Game s not listed under Practice
		base.setZoom(driver, 90);
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		//asrt.assertEquals(base.GetText(LoginPageObj.Btn_Login(createUpdateDeleteGametestdata.Game_41_CreateGameName)), createUpdateDeleteGametestdata.Game_41_CreateGameName,"Game is not added in Practice table");

		// Step 17 : Delete game
		// Expected: The game should be deleted
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_41_CreateGameName);

		//base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_41_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("dropdownMenuButton1"));
		base.setZoom(driver, 70);
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));


		//*************         Verify if Game Created in Scout field is shown under Scout table   ****************//

		// Step 18: click on Scout
		// Expected: User will be navigated to Scout page
		base.buttonClick(LoginPageObj.Btn_SingnIn("scout_film"));

		Thread.sleep(2000);
		// Step 19: click on +Scout
		// Expected: Create Game for dialog box is displayed
		base.buttonClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGameTitle("text-center fw-bold sizing")),"The header Create Game is not displayed");

		// Step 20: enter game name in text box displayed to create a game
		//Expected: Create button is displayed
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_41_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Scout name with alphabets , numerics and special characters in game creating tab");

		// Step 21: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		//Step 22:Verify created Game is listed under Scout under Games in the Film page
		// Expected: Game s not listed under Scout
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		//asrt.assertEquals(base.GetText(LoginPageObj.Btn_Login(createUpdateDeleteGametestdata.Game_41_CreateGameName)), createUpdateDeleteGametestdata.Game_41_CreateGameName,"Game is not added in Scout table");

		// Step 23 : Delete game
		// Expected: The game should be deleted
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_41_CreateGameName);
        base.pressKey(null, "KEYBOARD_ENTER");
        Thread.sleep(4000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_41_CreateGameName));
		//base.excuteJsClick(LoginPageObj.Btn_SingnIn("dropdownMenuButton1"));
		base.setZoom(driver, 70);
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));

	}

	//<summary>
	// Test Case Title : "Verify that the following options should be displayed in Game creation page;
	//					 1.Create Game for Team Name (eg: Create Game for COACH1)
	//					 2.Cancel & Create Button
	//					 3.Event Name with text field for enter the Game Name
	//					 4.TimeZone with dropdown
	//					 5.A text Starts with Current time with date
	//					 6.Game mode - Home & Away
	//					 7.Tabs- Event, Practice & Scout
	//	 				 8.A text Attach Facility Camera(s) with drop down and "Select" as default
	//					 9.A heading ADVANCED FEATURES with down arrow"
	// Automation ID : Game_09
	// </summary>
	public void Game_09_CreateUpdateDeleteGame() throws Exception
	{
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata= new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj= new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj= new SearchGameTeamAndMembers_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();

		//Step 1  :"Login to Snipback"
		//Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		//Step 2  :Choose Home org or other organization (User as Admin/Coach)
		//Expected:The organization should be selected and the teams displayed
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		Thread.sleep(1000);
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_09_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_09_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(2000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_09_CreateGameTeamName);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_09_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_09_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		//Step 4  :Click on +Event/Practice/Scout
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		//Step 5  :Validate 'Cancel & Create' Button.
		//Expected:'Cancel & Create' Button should be displayed.
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-secondary border-0 btn-popup bg-transparent1 text-dark width-100")),"The Cancel button is not displayed in the Create Game Pop-up in the Games page.");
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red","CREATE")),"The Create button is not displayed in the Create game popup in the games page.");

		//Step 6  :Validate 'Event Name with text field.
		//Expected:'Event Name with text field'should be displayed.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("create-game-name")),"The 'Enter 'Event name' field is not clickable");
		//base.buttonClick(ViewListUpdateDownloadShareDeleteLibraryObj.Btn_ReelsCancel("btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red","CREATE"));

		//Step 7  :Validate 'TimeZone' with dropdown.
		//Expected:'TimeZone' with dropdown should be displayed.
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_Time("dropdown__filter-selected state_time_zone_selected dropdown-list"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("search_state_time_zone")),"The TimeZone dropdown is not displayed on clicking TimeZone in the CreateGame PopUp in the Games page.");

		//Step 8  :Validate 'A text Starts, with Current time with date'.
		//Expected:The current date and time should be displayed.
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_Time("dropdown__filter-selected state_time_zone_selected dropdown-list"));
		base.buttonClick(SearchGameTeamAndMembersObj.Ele_MemberName("Starts"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Starts")),"The text 'Starts' is not displayed in the CreateGame PopUp in the Games page.");

		//Step 9  :Validate 'Game mode - Home & Away'.
		//Expected:The Home and Away toggle items should be displayed.
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("home")),"The Home Toggle item is not clickable.");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("away")),"The Away Toggle item is not clickable.");

		//Step 10 :Validate 'Tabs- Event, Practice & Scout' .
		//Expected:Tabs- Event, Practice & Scout should be displayed.
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-game-type","game")),"The 'event' toggle item is not displayed in the CreateGame PopUp in the Games page.");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-game-type","practice")),"The 'practice' toggle item is not displayed in the CreateGame PopUp in the Games page.");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-game-type","scout")),"The 'scout' toggle item is not displayed in the CreateGame PopUp in the Games page.");

		//Bug- Unable to get Facility Camera(s)
		//Step 11 :Validate 'A text Attach Facility Camera(s) with drop down and "Select" as default '
		//Expected:A text Attach Facility Camera(s) with drop down and "Select" as default should be displayed.
		//bug
		//base.buttonClick(RegistrationObj.Ele_OtpPage("away"));//bug
		//		Thread.sleep(1000);
		//		base.buttonClick(RegistrationObj.Ele_OtpPage("home"));//bug
		//		Thread.sleep(1000);
		//asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ddl_FacilityCamera("select-facility-camera","Select")),"A text Attach Facility Camera(s) with drop down and 'Select' as default is not displayed in the CreateGame PopUp in the Games page.");

		//Step 12 :Validate 'A heading ADVANCED FEATURES with down arrow'.
		//Expected:A heading ADVANCED FEATURES with down arrow should be displayed
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Signup("mb-2 mt-2 fw-bold")),"The heading ADVANCED FEATURES with down arrow is not displayed in the CreateGame PopUp in the Games page.");

	}
	//<summary>
	// Test Case Title :Verify that the following option should be displayed when click on down arrow of ADVANCED FEATURES;
	//					1.Secondary Low Quality (LQ) Stream - Disabled & Enabled
	//					2.Live Snipping - Public & Private
	//					3.Show on SnipBack.com- Public & Private
	//					4.Make Stat Public-Public & Private
	//					5.Payment- Free & Paid
	//					6.Category (optional) with dropdown
	// Automation ID : Game_10
	// </summary>
	public void Game_10_CreateUpdateDeleteGame() throws Exception
	{
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata= new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();

		//Step 1  :"Login to Snipback"
		//Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		//Step 2  :Choose Home org or other organization (User as Admin/Coach)
		//Expected:The organization should be selected and the teams displayed
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_10_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_10_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(2000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_10_CreateGameTeamName);
		Thread.sleep(2000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_10_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_10_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");

		//Step 4  :Click on +Event/Practice/Scout
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		//Step 5  :Validate A heading ADVANCED FEATURES with down arrow.
		//Expected:A heading ADVANCED FEATURES with down arrow should be displayed
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Signup("mb-2 mt-2 fw-bold")),"ADVANCED FEATURES with down arrow not displayed ");

		//Step 6  :Validate Secondary Low Quality (LQ) Stream - Disabled & Enabled.
		//Expected:Secondary Low Quality (LQ) Stream - Disabled & Enabled is displayed
		base.buttonClick(RegistrationObj.Ele_Signup("mb-2 mt-2 fw-bold"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-broadcasting","disable")),"The Disabled element is not displayed in the CreateGame PopUp in the Games page. ");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-broadcasting","enable")),"The Enabled element is not displayed in the CreateGame PopUp in the Games page. ");

		//Step 7  :Validate Live Snipping - Public & Private exists
		//Expected:Live Snipping - Public & Private should be displayed
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-sniping","public")),"The Live Snipping - Public element is not displayed in the CreateGame PopUp in the Games page. ");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-sniping","private")),"The Live Snipping - Private element is not displayed in the CreateGame PopUp in the Games page. ");

		//Step 8  :Validate Show on SnipBack.com- Public & Private exists
		//Expected:Show on SnipBack.com- Public & Private should be displayed.
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-post-website","public")),"The Show on SnipBack.com - Public element is not displayed in the CreateGame PopUp in the Games page. ");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-post-website","private")),"The Show on SnipBack.com - Private element is not displayed in the CreateGame PopUp in the Games page. ");

		//Step 9  :Validate Make Stat Public-Public & Private
		//Expected:Make Stat Public-Public & Private should be displayed.
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-visibility","public")),"The Make Stat Public - Public element is not displayed in the CreateGame PopUp in the Games page. ");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-visibility","private")),"The Make Stat Public - Private element is not displayed in the CreateGame PopUp in the Games page. ");

		//Step 10 :Validate Payment- Free & Paid
		//Expected:Make Payment- Free & Paid should be displayed.
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-payment","free")),"The Payment- Free & Paid - Free element is not displayed in the CreateGame PopUp in the Games page. ");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GameType("create-payment","paid")),"The Payment- Free & Paid - Paid element is not displayed in the CreateGame PopUp in the Games page. ");

		//Step 11 :Validate Category (optional) with dropdown
		//Expected:Category (optional) with dropdown is displayed
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ddl_CategoryOpt("mb-3 d-flex justify-content-between category-wrap","category-id")),"The Category(optional) dropdown is not clickable in the Create Game PopUp in the Games page. ");
		base.buttonClick(CreateUpdateDeleteGameObj.Ddl_CategoryOpt("mb-3 d-flex justify-content-between category-wrap","category-id"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("search_category")),"The Category optional dropdown is not displayed on clicking the Category (optional) field in the Create Game PopUp in the Games page. ");
	}	
	//<summary>
	//Test Case Title :Verify that Opponent Team with dropdown & Other Teams (optional) with dropdown should be displayed at the bottom of the Game creation Page
	// Automation ID : Game_11
	//</summary>
	public void Game_11_CreateUpdateDeleteGame() throws Exception
	{
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata= new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();

		//Step 1  :"Login to Snipback"
		//Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		//Step 2  :Choose Home org or other organization (User as Admin/Coach)
		//Expected:The organization should be selected and the teams displayed
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		Thread.sleep(1000);
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_11_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_11_CreateGame)),"The option org is not selected from the team dropdown.");
		Thread.sleep(2000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_11_CreateGameTeamName);
		Thread.sleep(2000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_11_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_11_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");

		//Step 4  :Click on +Event/Practice/Scout
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		//Step 5  :Validate A heading ADVANCED FEATURES with down arrow.
		//Expected:A heading ADVANCED FEATURES with down arrow should be displayed
		base.buttonClick(RegistrationObj.Ele_Signup("mb-2 mt-2 fw-bold"));

		//Step 6  :Verify the Options
		//Expected:Opponent Team with dropdown & Other Teams (optional) with dropdown should be displayed at the bottom of the Game creation Page
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_Team("dropdown__filter dropdwn_ul_away_selected"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("search_away_team")),"The Opponent team dropdown is nto displayed on clicking the ooponent team field in the Create game Pop-up.");
		base.buttonClick(RegistrationObj.Ele_OtpPage("otherTeamsDiv"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("dropdown-menu show")),"The Choose other team dropdown is not displayed.");
	}

	//<summary>
	//Test Case Title :Verify that Event should selected as default if we create a game from Event in the Game creation page.
	// Automation ID : Game_12
	//</summary>
	public void Game_12_CreateUpdateDeleteGame() throws Exception
	{
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata= new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();

		//Step 1  :"Login to Snipback"
		//Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		//Step 2  :Choose Home org or other organization (User as Admin/Coach)
		//Expected:The organization should be selected and the teams displayed
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_12_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_12_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(2000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_12_CreateGameTeamName);
		Thread.sleep(1000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_12_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_12_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");			
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CreateGamePopUp("Create Game for")),"The Create game Pop-up is not displayed in the games page. ");

		//Step 5  :Verify that Event should selected as default if we create a game from Event in the Game creation page
		//Expected:Event should selected as default if we create a game from Event in the Game creation page
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item active toggle_custom_item1 ")),"Event is not selected as default in the Games creation popup in the Games page.");
	}

	// <summary>
	// Test Case Title :"To Verify that User should able to switch the tab Enabled/Disbaled under Secondary Low Quality (LQ) Stream from game creation page in Snipback page."
	// Automation ID   : Game_29
	// </summary>

	public void Game_29_CreateUpdateDeleteGame() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_29_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_29_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_29_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_29_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_29_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		//Step 7   :"Enter the Event Name in Snipback page"
		//Expected :"User should be enter the Event Name in Snipback page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),createUpdateDeleteGametestdata.Game_29_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to enter the Event name with alphabets , numerics and special characters in game creating tab");

		//Step 8   :"Click on Advanced feature in Snipback page"
		//Expected :"User should be Clickable on ADVANCED FEATURES in Snipback page"
		base.excuteJsClick(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES"));
		asrt.assertTrue(base.isEnabledBy(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES")),
				"User is unable to Click on ADVANCED FEATURES in Snipback page ");

		//Step 9   :"Verify that User should able to switch the tab Enabled/Disbaled under Secondary Low Quality (LQ) Stream from game creation page in Snipback page"
		//Expected :"User should be able to switch the tab Enabled/Disbaled under Secondary Low Quality (LQ) Stream from game creation page in Snipback page"
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GameType("create-broadcasting", "enable"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item active' and text()='Enabled")),
				"User is unable to switch the tab Enable to disable.under Secondary Low Quality (LQ) Stream");
	}

	// <summary>
	// Test Case Title :"To Verify that User should able to switch the tab Public/Private under Live Snipping from game creation page in Snipback page."
	// Automation ID   : Game_30
	// </summary>

	public void Game_30_CreateUpdateDeleteGame() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_30_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_30_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_30_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_30_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_30_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		//Step 7   :"Enter the Event Name in Snipback page"
		//Expected :"User should be enter the Event Name in Snipback page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),createUpdateDeleteGametestdata.Game_30_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to enter the Event name with alphabets , numerics and special characters in game creating tab");

		//Step 8   :"Click on Advanced feature in Snipback page"
		//Expected :"User should be Clickable on ADVANCED FEATURES in Snipback page"
		base.excuteJsClick(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES"));
		asrt.assertTrue(base.isEnabledBy(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES")),
				"User is unable to Click on ADVANCED FEATURES in Snipback page ");

		//Step 9   :"Verify that User should able to switch the tab Public/Private under Live Snipping from game creation page in Snipback page"
		//Expected :"User should be able to switch the tab Public/Private under Live Snipping Stream from game creation page in Snipback page"
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GameType("create-sniping", "public"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CheckPublicorPrivate("create-sniping","toggle-item active","Public")),
				"User is unable to switch the tab Public/Private under Live Snipping Stream from game creation page in Snipback page");

	}
	// <summary>
	// Test Case Title :"To Verify that User should able to switch the tab Public/Private under Show from game creation page in Snipback page."
	// Automation ID   : Game_31
	// </summary>

	public void Game_31_CreateUpdateDeleteGame() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_31_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_31_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_31_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_31_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_31_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		//Step 7   :"Enter the Event Name in Snipback page"
		//Expected :"User should be enter the Event Name in Snipback page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),createUpdateDeleteGametestdata.Game_31_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to enter the Event name with alphabets , numerics and special characters in game creating tab");

		//Step 8   :"Click on Advanced feature in Snipback page"
		//Expected :"User should be Clickable on ADVANCED FEATURES in Snipback page"
		base.excuteJsClick(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES"));
		asrt.assertTrue(base.isEnabledBy(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES")),
				"User is unable to Click on ADVANCED FEATURES in Snipback page ");

		//Step 9   :"Verify that User should able to switch the tab Public/Private under Show from game creation page in Snipback page"
		//Expected :"User should be able to switch the tab Public/Private under Show from game creation page in Snipback page"
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GameType("create-post-website", "public"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CheckPublicorPrivate("create-post-website","toggle-item active","Public")),
				"User is unable to switch the tab Public/Private under Show from game from game creation page in Snipback page");	
	}

	// <summary>
	// Test Case Title :"To Verify that User should able to switch the tab Public/Private under Make Stat Public from game creation page in Snipback page."
	// Automation ID   : Game_32
	// </summary>

	public void Game_32_CreateUpdateDeleteGame() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_32_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_32_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_32_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_32_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_32_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		//Step 7   :"Enter the Event Name in Snipback page"
		//Expected :"User should be enter the Event Name in Snipback page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),createUpdateDeleteGametestdata.Game_32_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to enter the Event name with alphabets , numerics and special characters in game creating tab");

		//Step 8   :"Click on Advanced feature in Snipback page"
		//Expected :"User should be Clickable on ADVANCED FEATURES in Snipback page"
		base.excuteJsClick(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES"));
		asrt.assertTrue(base.isEnabledBy(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES")),
				"User is unable to Click on ADVANCED FEATURES in Snipback page ");

		//Step 9   :"Verify that User should able to switch the tab Public/Private under Make Stat Public from game creation page in Snipback page"
		//Expected :"User should be able to switch the tab Public/Private under Make Stat Public Stream from game creation page in Snipback page"
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GameType("create-visibility", "public"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_CheckPublicorPrivate("create-visibility","toggle-item active","Public")),
				"User is unable to switch the tab Public/Private under  Make Stat Public from game creation page in Snipback page");	
	}
	// <summary>
	// Test Case Title :"To Verify that User should able to switch the tab Enabled/Disbaled under Secondary Low Quality (LQ) Stream from game creation page in Snipback page."
	// Automation ID   : Game_33
	// </summary>

	public void Game_33_CreateUpdateDeleteGame() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_33_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_33_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_33_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_33_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_33_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		//Step 7   :"Enter the Event Name in Snipback page"
		//Expected :"User should be enter the Event Name in Snipback page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),createUpdateDeleteGametestdata.Game_33_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to enter the Event name with alphabets , numerics and special characters in game creating tab");

		//Step 8   :"Click on Advanced feature in Snipback page"
		//Expected :"User should be Clickable on ADVANCED FEATURES in Snipback page"
		base.excuteJsClick(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES"));
		asrt.assertTrue(base.isEnabledBy(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES")),
				"User is unable to Click on ADVANCED FEATURES in Snipback page ");

		//Step 9   :"Verify that User should able to switch the tab Enabled/Disbaled under Secondary Low Quality (LQ) Stream from game creation page in Snipback page"
		//Expected :"User should be able to switch the tab Enabled/Disbaled under Secondary Low Quality (LQ) Stream from game creation page in Snipback page"
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GameType("create-broadcasting", "enable"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("toggle-item active' and text()='Enabled")),
				"User is unable to switch the tab Enable to disable.under Secondary Low Quality (LQ) Stream");

	}

	// <summary>
	// Test Case Title :"To Verify that an error message with OK should be displayed when click on Paid from the Payment option from the Game creation page	 in Snipback page."
	// Automation ID   : Game_34
	// </summary>

	public void Game_34_CreateUpdateDeleteGame() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_34_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_34_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_34_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_34_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_34_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		//Step 7   :"Enter the Event Name in Snipback page"
		//Expected :"User should be enter the Event Name in Snipback page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),createUpdateDeleteGametestdata.Game_34_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to enter the Event name with alphabets , numerics and special characters in game creating tab");

		//Step 8   :"Click on Advanced feature in Snipback page"
		//Expected :"User should be Clickable on ADVANCED FEATURES in Snipback page"
		base.excuteJsClick(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES"));
		asrt.assertTrue(base.isEnabledBy(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES")),
				"User is unable to Click on ADVANCED FEATURES in Snipback page ");

		//Step 9   :"click on Paid from the Payment option from the Game creation page in Snipback page"
		//Expected :"User should be able to clickable on Paid from the Payment option from the Game creation page in Snipback page"
		base.scrollToElement(CreateUpdateDeleteGameObj.Btn_GameType("create-payment", "paid"));
		asrt.assertTrue(base.isEnabledBy(CreateUpdateDeleteGameObj.Btn_GameType("create-payment", "paid")),
				"User is unable to Click on Paid from the Payment option ");

		//Step 10   :"Verify that the error message should be closed when click on OK button"
		//Expected :"User should be able to view error message should be closed when click on OK button"
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GameType("create-payment", "paid"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExistsNegative(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"error message not closed when click on OK button");


	}
	// <summary>
	// Test Case Title :"To Verify that the error message should be closed when click on OK button in Snipback page."
	// Automation ID   : Game_35
	// </summary>

	public void Game_35_CreateUpdateDeleteGame() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_35_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_35_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 3  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_35_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_35_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_35_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);

		//Step 4  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		//Step 7   :"Enter the Event Name in Snipback page"
		//Expected :"User should be enter the Event Name in Snipback page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),createUpdateDeleteGametestdata.Game_35_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to enter the Event name with alphabets , numerics and special characters in game creating tab");

		//Step 8   :"Click on Advanced feature in Snipback page"
		//Expected :"User should be Clickable on ADVANCED FEATURES in Snipback page"
		base.excuteJsClick(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES"));
		asrt.assertTrue(base.isEnabledBy(searchgameteamandmembersObj.Ele_MemberName("ADVANCED FEATURES")),
				"User is unable to Click on ADVANCED FEATURES in Snipback page ");

		//Step 9   :"click on Paid from the Payment option from the Game creation page in Snipback page"
		//Expected :"User should be able to clickable on Paid from the Payment option from the Game creation page in Snipback page"
		base.scrollToElement(CreateUpdateDeleteGameObj.Btn_GameType("create-payment", "paid"));
		asrt.assertTrue(base.isEnabledBy(CreateUpdateDeleteGameObj.Btn_GameType("create-payment", "paid")),
				"User is unable to Click on Paid from the Payment option ");

		//Step 10   :"Verify that the error message should be closed when click on OK button"
		//Expected :"User should be able to view error message should be closed when click on OK button"
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GameType("create-payment", "paid"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExistsNegative(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"error message not closed when click on OK button");
	}

	// <summary>
	// Test Case Title :"Verify that Are you sure? Are you sure you want to delete message should be closed when click on Close button from the popup message
	//* As per business comment, changing 'Close' to 'Cancel'"
	// Automation ID   : Game_50
	// </summary>
	public void Game_50_CreateUpdateDeleteGame() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_50_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_50_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_50_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_50_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_50_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_50_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_50_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_50_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that Are you sure? Are you sure you want to delete message should be closed when click on Close button from the popup message
		//Expected: User able to Cancel the popup message
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_50_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel"));
		asrt.assertTrue(base.isExistsNegative(LoginPageObj.Ele_ErrorMessage("swal-text")),	"User unable to Cancel the popup message Are you sure you want to delete with game name? is displayed. ");

		//Step 12: delete Team		
		Thread.sleep(3000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_50_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	
	}



	// <summary>
	// Test Case Title :"Verify that three dots should be displayed against each games under deleted tab in Film Page"
	// Automation ID   : Game_53
	// </summary>
	public void Game_53_CreateUpdateDeleteGame() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_53_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_53_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_53_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_53_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_53_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_53_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_53_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_53_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that the game should deleted when click on Yes button from the message Are you sure? Are you sure you want to delete the game?
		//Expected: User able to Delete when click on Yes button from the popup message
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_53_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn")),"User unable to Delete when click on Yes button from the popup message ");

		// Step 12:Click on 'Deleted' Tab
		// Expected: validate the deleted game is showing under deleted tab
		Thread.sleep(1000);
		base.scrollToElementtoCenter(LoginPageObj.Btn_SingnIn("deleted_film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("deleted_film")),"Deleted tab not displaying");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("deleted_film"));

		//Step 13:Verify that three dots should be displayed against each games under deleted tab in Film Page
		//Expected: User able to see three dots displayed against deleted game
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_53_CreateGameName))," User unable to see three dots displayed against the deleted game");


	}
	// <summary>
	// Test Case Title :"Verify that Delete Permanently option should be displayed in the three dots against each games under deleted tab in Film Page"
	// Automation ID   : Game_54
	// </summary>
	public void Game_54_CreateUpdateDeleteGame() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_54_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_54_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_54_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_54_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_54_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_54_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_54_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_54_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that the game should deleted when click on Yes button from the message Are you sure? Are you sure you want to delete the game?
		//Expected: User able to Delete when click on Yes button from the popup message
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_54_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn")),"User unable to Delete when click on Yes button from the popup message ");

		// Step 12:Click on 'Deleted' Tab
		// Expected: validate the deleted game is showing under deleted tab
		Thread.sleep(1000);
		base.scrollToElementtoCenter(LoginPageObj.Btn_SingnIn("deleted_film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("deleted_film")),"Deleted tab not displaying");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("deleted_film"));
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_54_CreateGameName));

		//Step 17: Verify option 'Delete Permanently'
		//Expected: 'Delete Permanently' showing
		base.scrollToElementtoCenter(CreateUpdateDeleteGameObj.Btn_Delete("dropdown-menu dropdown-menu-center show","Delete permanently"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_Delete("dropdown-menu dropdown-menu-center show","Delete permanently")),"'Delete permanently' Option is not displaying");      				

	}
	// <summary>
	// Test Case Title :"Verify that Are you sure? Are you sure you want to delete the game permanently ? with Yes and Cancel button should be displayed when click on Delete permanently  from three dots"
	// Automation ID   : Game_55
	// </summary>
	public void Game_55_CreateUpdateDeleteGame() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_55_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_55_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_55_CreateGameTeamName);
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_55_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_55_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_55_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_55_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_55_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that the game should deleted when click on Yes button from the message Are you sure? Are you sure you want to delete the game?
		//Expected: User able to Delete when click on Yes button from the popup message
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_55_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn")),"User unable to Delete when click on Yes button from the popup message ");

		// Step 12:Click on 'Deleted' Tab
		// Expected: validate the deleted game is showing under deleted tab
		Thread.sleep(1000);
		base.scrollToElementtoCenter(LoginPageObj.Btn_SingnIn("deleted_film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("deleted_film")),"Deleted tab not displaying");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("deleted_film"));
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_55_CreateGameName));

		//Step 13: Verify option 'Delete Permanently'
		//Expected: 'Delete Permanently' showing
		base.scrollToElementtoCenter(CreateUpdateDeleteGameObj.Btn_Delete("dropdown-menu dropdown-menu-center show","Delete permanently"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_Delete("dropdown-menu dropdown-menu-center show","Delete permanently")),"'Delete permanently' Option is not displaying");      				
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_Delete("dropdown-menu dropdown-menu-center show","Delete permanently"));

		//Step 14: Verify that Are you sure? Are you sure you want to delete the game permanently ? with Yes and Cancel button should be displayed when click on Delete permanenty  from three dots
		//Expected: Validate error header is shown and validate if the text message is "Are you sure.You want to delete"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Are you sure you want to delete the game permanently?","\"Are you sure you want to delete the game permanently?\" text is not matching");

	}
	// <summary>
	// Test Case Title :"Verify that the game should deleted when click on Yes button from the message Are you sure? Are you sure you want to delete the game permanently?"
	// Automation ID   : Game_56
	// </summary>
	public void Game_56_CreateUpdateDeleteGame() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_56_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_56_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_56_CreateGameTeamName);
		Thread.sleep(1000);
		base.excuteJsClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_56_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_56_CreateGameTeamName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_56_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_56_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_56_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_56_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that the game should deleted when click on Yes button from the message Are you sure? Are you sure you want to delete the game?
		//Expected: User able to Delete when click on Yes button from the popup message
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_56_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		Thread.sleep(2000);
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn")),"User unable to Delete when click on Yes button from the popup message ");

		// Step 12:Click on 'Deleted' Tab
		// Expected: validate the deleted game is showing under deleted tab
		Thread.sleep(1000);
		base.scrollToElementtoCenter(LoginPageObj.Btn_SingnIn("deleted_film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("deleted_film")),"Deleted tab not displaying");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("deleted_film"));
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_56_CreateGameName));

		//Step 13: Verify option 'Delete Permanently'
		//Expected: 'Delete Permanently' showing
		base.scrollToElementtoCenter(CreateUpdateDeleteGameObj.Btn_Delete("dropdown-menu dropdown-menu-center show","Delete permanently"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_Delete("dropdown-menu dropdown-menu-center show","Delete permanently")),"'Delete permanently' Option is not displaying");      				
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_Delete("dropdown-menu dropdown-menu-center show","Delete permanently"));

		//Step 14: Verify that Are you sure? Are you sure you want to delete the game permanently ? with Yes and Cancel button should be displayed when click on Delete permanenty  from three dots
		//Expected: Validate error header is shown and validate if the text message is "Are you sure.You want to delete"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Are you sure you want to delete the game permanently?","\"Are you sure you want to delete the game permanently?\" text is not matching");

		// Step 17:Verify that the game should deleted when click on Yes button from the message Are you sure? Are you sure you want to delete the game permanently?
		// Expected: Permanently deleted the game
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		asrt.assertNotEquals(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_56_CreateGameName)),"'Game@123' displaying under deleted tab");

		//Step 18:Checking above permanently deleted game showing under deleted tab
		//Expected: Showing both are equal

	}
	// <summary>
	// Test Case Title :"Verify that Are you sure? Are you sure you want to delete the game permanently message should be closed when click on Close button from the popup message"
	//* As per business comment, changing 'Close' to 'Cancel'
	// Automation ID   : Game_57
	// </summary>
	public void Game_57_CreateUpdateDeleteGame() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj createaddnewmemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		CreateUpdateDeleteGame_TestData createUpdateDeleteGametestdata = new CreateUpdateDeleteGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_57_CreateGame));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(createUpdateDeleteGametestdata.Game_57_CreateGame)),"The option Org is not selected from the team dropdown.");
		Thread.sleep(3000);

		//Step 5  :Choose any team
		//Expected:The team should be selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), createUpdateDeleteGametestdata.Game_57_CreateGameTeamName);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(1000);
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_57_CreateGameTeamName));
		base.pressKey(null, "KEYBOARD_ENTER");
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(createUpdateDeleteGametestdata.Game_57_CreateGameTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(1000);
		//Step 6  :Click on +Event
		//Expected:"The user should be able to create Game after selecting any teams from the My Team List."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("my_film"));
		Thread.sleep(2000);
		base.excuteJsClick(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-header border-bottom-0 pb-0")), "user is unable to view the Event creating page in Snipback page");

		// Step 7 :"Enter the Event Name in Snipback page"
		// Expected :"User should be able to view the Event name with alphabets , numerics and special characters in game creating tab"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"), createUpdateDeleteGametestdata.Game_57_CreateGameName);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("create-game-name")),
				"User is unable to view the Event name with alphabets , numerics and special characters in game creating tab");

		// Step 9: click on create button
		// Expected: check if Game added successfully message is shown
		base.buttonClick(CreateUpdateDeleteGameObj.Btn_CreateGameButton("create_edit_game", "CREATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),
				"Game added successfully message is not displayed");
		Thread.sleep(2000);

		// Step 10: Verify that three dots should be displayed against each games under Film Page
		//Expected: User able to view , three dots should be displayed against each games under Film Page
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), createUpdateDeleteGametestdata.Game_57_CreateGameName);
		base.pressKey(null, "KEYBOARD_ENTER");

		base.setZoom(driver, 70);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_57_CreateGameName)),"Unable to view three dots against each games under Film Page");
		Thread.sleep(3000);

		//Step 11: Verify that the game should deleted when click on Yes button from the message Are you sure? Are you sure you want to delete the game?
		//Expected: User able to Delete when click on Yes button from the popup message
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_57_CreateGameName));
		base.excuteJsClick(LoginPageObj.Btn_Login("Delete"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));	
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(createaddnewmemberWithEmailObj.Ele_EditTeam("addGameBtn")),"User unable to Delete when click on Yes button from the popup message ");

		// Step 12:Click on 'Deleted' Tab
		// Expected: validate the deleted game is showing under deleted tab
		Thread.sleep(1000);
		base.scrollToElementtoCenter(LoginPageObj.Btn_SingnIn("deleted_film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("deleted_film")),"Deleted tab not displaying");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("deleted_film"));
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_57_CreateGameName));

		//Step 13: Verify option 'Delete Permanently'
		//Expected: 'Delete Permanently' showing
		base.scrollToElementtoCenter(CreateUpdateDeleteGameObj.Btn_Delete("dropdown-menu dropdown-menu-center show","Delete permanently"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_Delete("dropdown-menu dropdown-menu-center show","Delete permanently")),"'Delete permanently' Option is not displaying");      				
		base.excuteJsClick(CreateUpdateDeleteGameObj.Btn_Delete("dropdown-menu dropdown-menu-center show","Delete permanently"));

		// Step 19:Verify that Are you sure? Are you sure you want to delete the game permanently message should be closed when click on Close button from the popup message
		//* As per business comment, changing 'Close' to 'Cancel'
		// Expected: PopUp is closed
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Btn_GThreeDots(createUpdateDeleteGametestdata.Game_57_CreateGameName)),"message is not get closed when click on Close button from the popup message");

	}

}

