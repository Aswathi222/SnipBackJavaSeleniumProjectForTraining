package testPage.MavenPageObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestData.AddUpdateRemoveMember_TestData;
import TestData.CommonData;
import TestData.DuplicateTeam_TestData;
import objectRepository.AddUpdateDeleteDuplicateTeamGameDefaults_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.DuplicateTeam_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.Registration_Obj;
import utilPack.BasePge;

public class DuplicateTeam extends BasePge {
	BasePge base;
	Assert asrt;

	public DuplicateTeam(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title : "To verify whether there is an option as Duplicate Team in the Team Listing page."
	// Automation ID : DT_01
	// </summary>
	public void DT_01_DuplicateTeam() throws InterruptedException {
		Login login = new Login(driver);
		CommonData Commondata = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DuplicateTeam_Obj DuplicateTeamObj = new DuplicateTeam_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		DuplicateTeam_TestData DuplicateTeamTestData = new DuplicateTeam_TestData();

		// Step 1: Go to Games/Members page
		// Expected: User should be navigated to Games page.
		Thread.sleep(1000);
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");

		// Step 2: Verify film tab is existing
		// Expected: Film tab is existing
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_DashboardHeaderLink("/games")),"Film sub header link is not showing in dashboard");

		// Step 3:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(DuplicateTeamObj.Ele_DashboardHeaderLink("/games"));
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_01_DuplicateSnipOrg));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_01_DuplicateSnipOrg)),"The option org is not selected");
		Thread.sleep(3000);

		//Step 4:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);

		// Step 5:Clicking On 3 dot menu of the first team in the list of teams
		// Expected: Click on 3 dot menu of the first team
		base.scrollToElementtoCenter(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1)); 
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1)),"The 3 dot menu of the first team is not displayed");

		// Step 6:Verify  Duplicate Team option is shown in team listing page.
		// Expected: User is able to see the Duplicate team option is shown
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1));
		Thread.sleep(2000);
		validateText(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team"),"Duplicate Team");
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team")),"The Duplicate team option is not shown after clicking the 3 dot menu of the first team");

	}

	// <summary>
	// Test Case Title : "To verify what happens when user clicks the Duplicate Team option in the Team Listing page"
	// Automation ID : DT_02
	// </summary>
	public void DT_02_DuplicateTeam() throws InterruptedException {
		Login login = new Login(driver);
		CommonData Commondata = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DuplicateTeam_Obj DuplicateTeamObj = new DuplicateTeam_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		DuplicateTeam_TestData DuplicateTeamTestData = new DuplicateTeam_TestData();

		// Step 1: Go to Games/Members page
		// Expected: User should be navigated to Games page.
		Thread.sleep(1000);
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");

		// Step 2: Verify film tab is existing
		// Expected: Film tab is existing
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_DashboardHeaderLink("/games")),"Film sub header link is not showing in dashboard");
		base.buttonClick(DuplicateTeamObj.Ele_DashboardHeaderLink("/games"));

		// Step 3:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_02_DuplicateSnipOrg));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_02_DuplicateSnipOrg)),"The option org is not selected");
		Thread.sleep(3000);

		//Step 4:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);

		// Step 5: Storing first team name from the list of team names in left 
		String firstTeamName = driver.findElement(By.xpath("(//div[@id='my-team-content']//span)[1]")).getText();

		// Step 6:Clicking On 3 dot menu of the first team in the list of teams
		// Expected: Duplicate team is shown
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1)),"The 3 dot menu of the first team is not displayed");
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1));

		// Step 7:Clicking On Duplicate team option 
		// Expected: A dialog box is opened
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team")),"The Duplicate team option is not shown after clicking the 3 dot menu of the first team");

		// Step 8:Duplicate team name dialog box is shown
		// Expected: Duplicate - Team name dialog box is displayed
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team"));
		asrt.assertEquals(GetText(RegistrationObj.Edt_SignUpMinConfPassword("team-name")),firstTeamName,"User unable to view Duplicate, - Team name dialog box is not displayed");
		//asrt.assertTrue(GetText(DuplicateTeamObj.Ele_TeamName("team-name")).contains("User unable to view Duplicate, - Team name dialog box is not displayed"));

		// Step 9:To verify what happens when user clicks the Duplicate Team option in the Team Listing page
		// Expected: User is able to see Create button is shown
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("confirm-duplicate-team")),"Create button is not displayed in duplicate team dialog box");
		asrt.assertEquals(GetText(LoginPageObj.Btn_LoginButton("confirm-duplicate-team")),"Create", "User unable to view Duplicate Team option in the Team Listing page");

	}

	// <summary>
	// Test Case Title : Verify whether the user is able to create  duplicate team name assame as the original team name  "The user Should get a ERROR message that the (Team Name
	// Already Exists)"
	// Automation ID : DT_03
	// </summary>
	public void DT_03_DuplicateTeam() throws InterruptedException {
		Login login = new Login(driver);
		CommonData Commondata = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DuplicateTeam_Obj DuplicateTeamObj = new DuplicateTeam_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		DuplicateTeam_TestData DuplicateTeamTestData = new DuplicateTeam_TestData();

		// Step 1: Go to Games/Members page
		// Expected: User should be navigated to Games page.
		Thread.sleep(1000);
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");

		// Step 2: Verify film tab is existing
		// Expected: Film tab is existing
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_DashboardHeaderLink("/games")),"Film sub header link is not showing in dashboard");

		// Step 3:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The Org should be selected from dropdown
		base.buttonClick(DuplicateTeamObj.Ele_DashboardHeaderLink("/games"));
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_03_DuplicateSnipOrg));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_03_DuplicateSnipOrg)),"The option org is not selected");
		Thread.sleep(3000);

		//Step 4:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);

		// Step 5: Storing first team name from the list of team names in left 
		String firstTeamName = driver.findElement(By.xpath("(//div[@id='my-team-content']//span)[1]")).getText();

		// Step 6: Verify 3 dot menu of the first team in the list of teams
		// Expected: User able to view the 3 dot menu of the first team
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1)),"The 3 dot menu of the first team is not displayed");

		// Step 7: Verify Duplicate team option 
		// Expected: Duplicate team option not displayed
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team")),"The Duplicate team option is not shown after clicking the 3 dot menu of the first team");

		// Step 8:Verifying the header of dialog box is as "Duplicate - Team Name"
		// Expected:User is able to view the header of dialog box is as "Duplicate - Team Name"
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team"));
		asrt.assertEquals(GetText(RegistrationObj.Edt_SignUpMinConfPassword("team-name")), firstTeamName);
		asrt.assertTrue(GetText(DuplicateTeamObj.Ele_TeamName("team-name")).contains("Duplicate"),"Unable to view he header of dialog box is as \"Duplicate - Team Name\"");

		// Step 9:Enter team name same as  the original team name 
		// Expected: the input text box is  present to enter the team name
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("team_name")), "the input text box is not present to enter the team name");

		// Step 10:Verify if the Duplicate team contains the same team name as the original team name
		// Expected: Duplicate team name and orginal team name should be equal
		base.setData(LoginPageObj.Edt_LoginEmail("team_name"), firstTeamName);
		asrt.assertEquals(GetValue(LoginPageObj.Edt_LoginEmail("team_name")), firstTeamName,"Duplicate team name and orginal team name were not same");

		// Step 11:Click on confirm button after entering team name
		// Expected:Create button is  displayed in duplicate team dialog box
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("confirm-duplicate-team")),"Create button is not displayed in duplicate team dialog box");

		// Step 12:Verify whether the user is able to create  duplicate team name assame as the original team name 
		// Expected: Validate error header is shown and validate if the text message is "Team Name already exists"
		base.buttonClick(LoginPageObj.Btn_LoginButton("confirm-duplicate-team"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Error!","Error popup is not displayed");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Team Name already exists","\"Team Name already exists\" text is not matching");

		//		// Step 13:Click on OK button in the error popup
		//		// Expected: PopUp is closed
		//		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"OK button is not there in error dialog box");
		//		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

	}


	// <summary>
	// Test Case Title : "Verify whether the user is able to create a Dulipacte Team with any Name"
	// Automation ID : DT_04
	// </summary>
	public void DT_04_DuplicateTeam() throws InterruptedException {
		Login login = new Login(driver);
		CommonData Commondata = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DuplicateTeam_Obj DuplicateTeamObj = new DuplicateTeam_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		DuplicateTeam_TestData DuplicateTeamTestData = new DuplicateTeam_TestData();

		// Step 1: Go to Games/Members page
		// Expected: User should be navigated to Games page.
		Thread.sleep(1000);
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");

		// Step 2: Verify film tab is existing
		// Expected: Film tab is existing
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_DashboardHeaderLink("/games")),"Film sub header link is not showing in dashboard");
		base.buttonClick(DuplicateTeamObj.Ele_DashboardHeaderLink("/games"));

		// Step 3:Switch to any team from the team dropdown menu after selecting an
		// Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_04_DuplicateSnipOrg));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_04_DuplicateSnipOrg)),"The option org is not selected");
		Thread.sleep(3000);

		//Step 4:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);

		// Step 5: Storing first team name from the list of team names in left 
		String firstTeamName = driver.findElement(By.xpath("(//div[@id='my-team-content']//span)[1]")).getText();

		// Step 6:Clicking On 3 dot menu of the first team in the list of teams
		// Expected: Duplicate team option is shown
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1)),
				"The 3 dot menu of the first team is not displayed");
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1));

		// Step 7:Clicking On Duplicate team option 
		// Expected: A dialog box is opened
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team")),"The Duplicate team option is not shown after clicking the 3 dot menu of the first team");
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team"));

		// Step 8:Enter team name same as  the original team name and concat with random value to make the team name without duplication
		// Expected: New team is created with the same data of the firstTeamInList
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("team_name")), "the input text box is not present");
		base.setData(LoginPageObj.Edt_LoginEmail("team_name"), firstTeamName.concat(base.CreateRandom(5)));
		String duplicateTeamName= base.GetAttribte(LoginPageObj.Edt_LoginEmail("team_name"), "value");

		// Step 9:Click on confirm button after entering team name
		// Expected: Duplicate team is created
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("confirm-duplicate-team")),"Create button is not displayed in duplicate team dialog box");
		base.buttonClick(LoginPageObj.Btn_LoginButton("confirm-duplicate-team"));

		// Step 10:Verify Done popup tick mark image is shown in popup
		// Expected: Confirmation popUp of duplicate team created is shown
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-icon--success__ring")), "Done popup Tick image is not shown");

		// Step 11:Verify Done Text is matching with expected Done  in popup
		// Expected: My Expected is Done and Verify if expected and actual equal
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")), "Done is not shown");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Done!","Done text is not matching");

		// Step 12:Verify whether the user is able to create a Dulipacte Team with any Name
		// Expected: User able to Create a Duplicate Team with any Name and a Successfully Duplicate message appeared
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")), "Successfully Duplicated is not shown");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Successfully Duplicated","Successfully Duplicated message is not matching");

		// Step 13:Deleting the duplicate team Click OK button in popup
		// Expected:Team created confirmation popup is closed
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")), "OK button is not shown");	
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		//Step 14:Deleting the duplicate team
		base.scrollToElementtoCenter(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.scrollToElementtoCenter(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(duplicateTeamName,"Delete Team"));
		base.buttonClick(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(duplicateTeamName,"Delete Team"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--catch']")).click();
	}



	// <summary>
	// Test Case Title : "Verify whether the user is able to get the same default settings as from the original team  after creating the Duplicate Team"
	// Automation ID : DT_05
	// </summary>
	public void DT_05_DuplicateTeam() throws InterruptedException {
		Login login = new Login(driver);
		CommonData Commondata = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DuplicateTeam_Obj DuplicateTeamObj = new DuplicateTeam_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj=new AddUpdateRemoveMember_Obj();
		DuplicateTeam_TestData DuplicateTeamTestData = new DuplicateTeam_TestData();

		// Step 1: Go to Games/Members page
		// Expected: User should be navigated to Games page.
		Thread.sleep(1000);
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");

		// Step 2: Verify film tab is existing
		// Expected: Film tab is existing
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_DashboardHeaderLink("/games")),"Film sub header link is not showing in dashboard");
		base.buttonClick(DuplicateTeamObj.Ele_DashboardHeaderLink("/games"));

		// Step 3:Switch to any team from the team dropdown menu after selecting an
		// Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_05_DuplicateSnipOrg));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_05_DuplicateSnipOrg)),"The option org is not selected");
		Thread.sleep(3000);

		//Step 4:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);

		// Step 5: Storing first team name from the list of team names in left 
		String firstTeamName = driver.findElement(By.xpath("(//div[@id='my-team-content']//span)[1]")).getText();

		// Step 6: Scrolling to the firstTeamName
		base.scrollToElementtoCenter(LoginPageObj.Edt_Alert1(firstTeamName)); 
		base.buttonClick(LoginPageObj.Edt_Alert1(firstTeamName)); 

		// Step 7:Clicking On 3 dot menu of the first team in the list of teams
		// Expected: Click on 3 dot menu of the first team
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1)),"The 3 dot menu of the first team is not displayed");
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1));

		// Step 6:Clicking On Duplicate team option 
		// Expected: Click on Duplicate team
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team")),"The Duplicate team option is not shown after clicking the 3 dot menu of the first team");
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team"));

		// Step 7:Enter team name same as  the original team name and concat with random value to make the team name without duplication
		// Expected: Team name is different with orginal name hence concated with random string
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("team_name")), "the input text box is not present");
		base.setData(LoginPageObj.Edt_LoginEmail("team_name"), firstTeamName.concat(base.CreateRandom(5)));		
		String duplicateTeamName= base.GetAttribte(LoginPageObj.Edt_LoginEmail("team_name"), "value");			

		// Step 8:Click on confirm button after entering team name
		// Expected: Click on confirm button and Click OK button in popup
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("confirm-duplicate-team")),"Create button is not displayed in duplicate team dialog box");
		base.buttonClick(LoginPageObj.Btn_LoginButton("confirm-duplicate-team"));			
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")), "OK button is not shown");		

		// Step 9:Click OK button in popup and after this duplicate team is created

		// Step 10:Click on 3 dot menu of the firstTeamName
		// Expected: Click on 3 dot menu
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(firstTeamName,"dropdown-wrapper teams-menu")), "3 dot menu is not displayed");
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(firstTeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(firstTeamName,"Edit Team")), "3 dot option nod dsiplayed and Edit Team option is not displayed");

		// Step 11:Click on Edit Team the firstTeamName
		// Expected: Click on Edit Team
		base.buttonClick(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(firstTeamName,"Edit Team"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");

		//Step 12: Click on "Game Defaults" button 
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
		base.setZoom(driver, 65);
		Thread.sleep(2000);

		//Step 13: Getting all the toggle active or selected options for each settings in Home default for firstTeamName
		List<String> actualSelectionsForHD = new ArrayList<String>();
		actualSelectionsForHD.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Game Mode","default-game-type")),"className","toggle-item active"));
		actualSelectionsForHD.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Secondary Low Quality (LQ) Stream","default-broadcasting")),"className","toggle-item active"));
		actualSelectionsForHD.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Live Snipping","default-sniping")),"className","toggle-item active"));
		actualSelectionsForHD.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Show on SnipBack.com","default-post")),"className","toggle-item active"));
		actualSelectionsForHD.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Make Stat Public","default-visibility")),"className","toggle-item active"));
		actualSelectionsForHD.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Enabling Ball Tracking","default-balltracking")),"className","toggle-item active"));   

		//Step 13: Click on "Away Defaults" toggle 
		//Expected:A new page is opened
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default")), "User unable to see the list of options under the three dots in the Games Page");
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default"));
		base.setZoom(driver, 65);
		Thread.sleep(2000);

		//Step 14: Getting all the toggle active or selected options for each settings in Away default for firstTeamName
		List<String> actualSelectionsForAD = new ArrayList<String>();
		actualSelectionsForAD.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Game Mode","default-game-type")),"className","toggle-item active"));
		actualSelectionsForAD.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Secondary Low Quality (LQ) Stream","default-broadcasting")),"className","toggle-item active"));
		actualSelectionsForAD.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Live Snipping","default-sniping")),"className","toggle-item active"));
		actualSelectionsForAD.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Show on SnipBack.com","default-post")),"className","toggle-item active"));
		actualSelectionsForAD.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Make Stat Public","default-visibility")),"className","toggle-item active"));
		actualSelectionsForAD.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Enabling Ball Tracking","default-balltracking")),"className","toggle-item active"));

		//Step 15: Click close button of default settings      
		driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@class='btn-close']")).click();          
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);


		// Step 16:Click on 3 dot menu of the duplicateTeamName
		// Expected: Edit team option is shown click on edit team
		base.scrollToElementtoCenter(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.buttonClick(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(duplicateTeamName,"Edit Team"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");

		//Step 17: Click on "Game Defaults" button 
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
		base.setZoom(driver, 65);
		//Step 18: Getting all the toggle active or selected options for each settings in Home default for duplicateTeam
		List<String> actualSelectionsForHDForDuplicate = new ArrayList<String>();
		actualSelectionsForHDForDuplicate.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Game Mode","default-game-type")),"className","toggle-item active"));
		actualSelectionsForHDForDuplicate.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Secondary Low Quality (LQ) Stream","default-broadcasting")),"className","toggle-item active"));
		actualSelectionsForHDForDuplicate.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Live Snipping","default-sniping")),"className","toggle-item active"));
		actualSelectionsForHDForDuplicate.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Show on SnipBack.com","default-post")),"className","toggle-item active"));
		actualSelectionsForHDForDuplicate.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Make Stat Public","default-visibility")),"className","toggle-item active"));
		actualSelectionsForHDForDuplicate.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Enabling Ball Tracking","default-balltracking")),"className","toggle-item active"));

		//Step 19: Click on "Away Defaults" toggle 
		//Expected:A new page is opened
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default")), "User unable to see the list of options under the three dots in the Games Page");
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default"));
		base.setZoom(driver, 65);
		//Step 20: Getting all the toggle active or selected options for each settings in Away default for duplicateTeam
		List<String> actualSelectionsForADForDuplicate = new ArrayList<String>();
		actualSelectionsForADForDuplicate.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Game Mode","default-game-type")),"className","toggle-item active"));
		actualSelectionsForADForDuplicate.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Secondary Low Quality (LQ) Stream","default-broadcasting")),"className","toggle-item active"));
		actualSelectionsForADForDuplicate.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Live Snipping","default-sniping")),"className","toggle-item active"));
		actualSelectionsForADForDuplicate.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Show on SnipBack.com","default-post")),"className","toggle-item active"));
		actualSelectionsForADForDuplicate.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Make Stat Public","default-visibility")),"className","toggle-item active"));
		actualSelectionsForADForDuplicate.add(base.GetValueForList(base.GetElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Enabling Ball Tracking","default-balltracking")),"className","toggle-item active"));

		//Step 21:Asserting if firstTeam and duplicate Team list is same
		//Expected:Verify whether the user is able to get the same default settings as from the original team  after creating the Duplicate Team
		asrt.assertEquals(actualSelectionsForAD, actualSelectionsForADForDuplicate,"User unable to get the same default settings as from the original team  after creating the Duplicate Team in Away mode");
		System.out.println(actualSelectionsForHD);
		System.out.println(actualSelectionsForHDForDuplicate);
		asrt.assertEquals(actualSelectionsForHD, actualSelectionsForHDForDuplicate,"User unable to get the same default settings as from the original team  after creating the Duplicate Team in Home Mode");


		//Step 22:Deleting the duplicate team
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		base.scrollToElementtoCenter(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.scrollToElementtoCenter(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(duplicateTeamName,"Delete Team"));
		base.buttonClick(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(duplicateTeamName,"Delete Team"));
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--catch']")).click();

	}


	// <summary>
	// Test Case Title : "Verify whether the user is able to get the same Default Team Type as from the original team  after creating the Duplicate Team"
	// Automation ID : DT_06
	// </summary>
	public void DT_06_DuplicateTeam() throws InterruptedException {
		Login login = new Login(driver);
		CommonData Commondata = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DuplicateTeam_Obj DuplicateTeamObj = new DuplicateTeam_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		DuplicateTeam_TestData DuplicateTeamTestData = new DuplicateTeam_TestData();

		// Step 1: Go to Games/Members page
		// Expected: User should be navigated to Games page.
		Thread.sleep(2000);
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");

		// Step 2: Verify film tab is existing
		// Expected: Film tab is existing
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_DashboardHeaderLink("/games")),"Film sub header link is not showing in dashboard");
		base.buttonClick(DuplicateTeamObj.Ele_DashboardHeaderLink("/games"));

		// Step 3:Switch to any team from the team dropdown menu after selecting an
		// Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_06_DuplicateSnipOrg));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_06_DuplicateSnipOrg)),"The option org is not selected");
		Thread.sleep(3000);

		//Step 4:Click outside the dropdown
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);

		// Step 5: Storing first team name from the list of team names in left 
		String firstTeamName = driver.findElement(By.xpath("(//div[@id='my-team-content']//span)[1]")).getText();

		// Step 6: Scrolling to the firstTeamName
		base.scrollToElementtoCenter(LoginPageObj.Edt_Alert1(firstTeamName)); 
		base.buttonClick(LoginPageObj.Edt_Alert1(firstTeamName)); 

		// Step 7:Clicking On 3 dot menu of the first team in the list of teams
		// Expected: Click on 3 dot menu of the first team
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1)),"The 3 dot menu of the first team is not displayed");

		// Step 6:Clicking On Duplicate team option 
		// Expected: User is able to Click on Duplicate team and input textbox appears
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team")),"The Duplicate team option is not shown after clicking the 3 dot menu of the first team");
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("team_name")), "User is unable to Click on Duplicate team and the input text box is not present");

		// Step 7:Enter team name same as  the original team name and concat with random value to change the team name
		// Expected: Duplicate Team name is set
		base.setData(LoginPageObj.Edt_LoginEmail("team_name"), firstTeamName.concat(base.CreateRandom(5)));
		String duplicateTeamName= base.GetAttribte(LoginPageObj.Edt_LoginEmail("team_name"), "value");

		// Step 8:Click on confirm button after entering team name
		// Expected: After giving name clicking confirm
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("confirm-duplicate-team")),"Create button is not displayed in duplicate team dialog box");
		base.buttonClick(LoginPageObj.Btn_LoginButton("confirm-duplicate-team"));

		// Step 9:Click OK button to create duplicate team
		// Expected: Duplicate team is created
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")), "OK button is not shown");			

		// Step 10:Click on 3 dot menu of the firstTeamName
		// Expected: Dropdown options are displayed and check for edit team
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(firstTeamName,"dropdown-wrapper teams-menu")), "3 dot menu is not displayed");
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(firstTeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(firstTeamName,"Edit Team")), "Edit Team option is not displayed");

		// Step 11:Click on Edit Team of the firstTeamName
		// Expected: Edit team page is reached is validated by asserting the header
		base.buttonClick(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(firstTeamName,"Edit Team"));
		base.validateTextIfContains(DuplicateTeamObj.Ele_EditTeamPageHeader("abbrmodalbtn", "h4"),"EDIT TEAM");		

		// Step 12:Get the dropdown selected for default team type for original team
		// Expected: Storing the dropdown text in a variable to verify if the duplicate team is having the same default team type 
		String selectedDefaultTeamTypeForOrginalTeam=base.getTheSelectedTextInDropDown(PoolObj.Ele_PoolTypeDropDown("category"));
		driver.navigate().refresh();
		Thread.sleep(5000);
		//Navigating back to home page
		driver.navigate().back();
		Thread.sleep(5000);

		// Step 13:Click on 3 dot menu of the duplicateTeamName
		// Expected: Edit team option is shown click on edit team
		//base.buttonClick(PoolObj.Btn_ButtonCreate("popup-btn-close menu-dark"));
		//Thread.sleep(5000);
		base.scrollToElementtoCenter(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.buttonClick(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(duplicateTeamName,"Edit Team"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolTypeDropDown("category")), "Edit team option is not shown click on edit team");

		// Step 14:Validating if Default Team Type of original team and duplicate team is same
		//Expected: selected Default team type is same for orginal and duplicate team
		String selectedDefaultTeamTypeForDuplicateTeam=base.getTheSelectedTextInDropDown(PoolObj.Ele_PoolTypeDropDown("category"));
		asrt.assertEquals(selectedDefaultTeamTypeForOrginalTeam, selectedDefaultTeamTypeForDuplicateTeam,"selected Default team type is different for orginal and duplicate team");	

		//Step 15:Deleting the duplicate team
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		base.scrollToElementtoCenter(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.scrollToElementtoCenter(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(duplicateTeamName,"Delete Team"));
		base.buttonClick(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(duplicateTeamName,"Delete Team"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--catch']")).click();
	}

	// <summary>
	// Test Case Title : "verify whether the user is able to get the same Members as from the original team  after creating the Duplicate Team"
	// Automation ID : DT_07
	// </summary>
	public void DT_07_DuplicateTeam() throws InterruptedException {
		Login login = new Login(driver);
		CommonData Commondata = new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DuplicateTeam_Obj DuplicateTeamObj = new DuplicateTeam_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		DuplicateTeam_TestData DuplicateTeamTestData = new DuplicateTeam_TestData();

		// Step 1: Go to Games/Members page
		// Expected: User should be navigated to Games page.
		Thread.sleep(2000);
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");

		// Step 2: Verify film tab is existing
		// Expected: Film tab is existing
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_DashboardHeaderLink("/games")),"Film sub header link is not showing in dashboard");
		base.buttonClick(DuplicateTeamObj.Ele_DashboardHeaderLink("/games"));

		// Step 3:Switch to any team from the team dropdown menu after selecting an
		// Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_07_DuplicateSnipOrg));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(DuplicateTeamTestData.DT_07_DuplicateSnipOrg)),"The option org is not selected");
		Thread.sleep(3000);

		//Step 4:Click outside the dropdown
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);

		// Step 5: Storing first team name from the list of team names in left 
		String firstTeamName = driver.findElement(By.xpath("(//div[@id='my-team-content']//span)[1]")).getText();

		// Step 6: Scrolling to the firstTeamName
		base.scrollToElementtoCenter(LoginPageObj.Edt_Alert1(firstTeamName)); 
		base.buttonClick(LoginPageObj.Edt_Alert1(firstTeamName)); 

		// Step 7:Clicking On 3 dot menu of the first team in the list of teams
		// Expected: Click on 3 dot menu of the first team
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1)),"The 3 dot menu of the first team is not displayed");
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeam("dropdown-wrapper teams-menu", 1));

		// Step 6:Clicking On Duplicate team option 
		// Expected: Click on Duplicate team
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team")),"The Duplicate team option is not shown after clicking the 3 dot menu of the first team");
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotsOfTeamDropDownItems("dropdown-wrapper teams-menu", 1,"dropdown-item duplicate-team"));

		// Step 7:Enter team name same as  the original team name and concat with random value to change the team name
		// Expected: Duplicate Team name is set
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("team_name")), "the input text box is not present");
		base.setData(LoginPageObj.Edt_LoginEmail("team_name"), firstTeamName.concat(base.CreateRandom(5)));

		String duplicateTeamName= base.GetAttribte(LoginPageObj.Edt_LoginEmail("team_name"), "value");


		// Step 8:Click on confirm button after entering team name
		// Expected: After giving name clicking confirm
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("confirm-duplicate-team")),"Create button is not displayed in duplicate team dialog box");
		base.buttonClick(LoginPageObj.Btn_LoginButton("confirm-duplicate-team"));


		// Step 9:Click OK button to create duplicate team
		// Expected: Duplicate team is created
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")), "OK button is not shown");	
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		// Step 10:Click on 3 dot menu of the firstTeamName
		// Expected: Dropdown options are displayed and check for edit team
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(firstTeamName,"dropdown-wrapper teams-menu")), "3 dot menu is not displayed");
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(firstTeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(firstTeamName,"Edit Team")), "Edit Team option is not displayed");

		// Step 11:Click on Edit Team of the firstTeamName
		// Expected: Edit team page is reached is validated by asserting the EDIT TEAM header
		base.buttonClick(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(firstTeamName,"Edit Team"));
		base.validateTextIfContains(DuplicateTeamObj.Ele_EditTeamPageHeader("abbrmodalbtn", "h4"),"EDIT TEAM");	

		// Step 12:Get the list of members in the original team
		// Expected: List of team members names
		List<String> teamMemberNamesForOrginalTeam=base.GetElementTexts(By.xpath("//ul[@class='members-list-wrap']/li//h4"));


		// Step 13:Navigating back to home page 
		// Expected: List of teams shown
		driver.navigate().refresh();
		Thread.sleep(5000);

		//Navigating back to home page
		driver.navigate().back();
		Thread.sleep(5000);

		// Step 14:Click on 3 dot menu of the duplicateTeamName
		// Expected: Edit team option is shown click on edit team
		base.scrollToElementtoCenter(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.buttonClick(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(duplicateTeamName,"Edit Team"));

		// Step 15:Get the list of members in the duplicate team
		// Expected: List of team members names
		List<String> teamMemberNamesForDuplicateTeam=base.GetElementTexts(By.xpath("//ul[@class='members-list-wrap']/li//h4"));

		// Sort the lists if order doesn't matter
		Collections.sort(teamMemberNamesForOrginalTeam);
		Collections.sort(teamMemberNamesForDuplicateTeam);

		// Step 16:Assert the list of orginal team members and list of duplicate team members are same
		Assert.assertEquals(teamMemberNamesForOrginalTeam, teamMemberNamesForDuplicateTeam, "Team member lists are not the same!");

		//Step 17:Deleting the duplicate team
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		base.scrollToElementtoCenter(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.buttonClick(DuplicateTeamObj.Ele_ThreeDotMenuOfTeamBasedOnTeamName(duplicateTeamName,"dropdown-wrapper teams-menu"));
		base.scrollToElementtoCenter(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(duplicateTeamName,"Delete Team"));
		base.buttonClick(DuplicateTeamObj.Ele_EditTeamBasedOnTeamName(duplicateTeamName,"Delete Team"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--catch']")).click();
	}

}
