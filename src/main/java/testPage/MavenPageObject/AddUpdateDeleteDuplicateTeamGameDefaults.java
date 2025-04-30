package testPage.MavenPageObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import TestData.AddUpdateDeleteDuplicateTeamGameDefaults_TestData;
import TestData.CommonData;
import objectRepository.AddUpdateDeleteDuplicateTeamGameDefaults_Obj;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.ForgotPassword_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;

public class AddUpdateDeleteDuplicateTeamGameDefaults  extends BasePge{

	BasePge base;
	Assert asrt;
	ElementActions element;

	public AddUpdateDeleteDuplicateTeamGameDefaults(WebDriver driver) 
	{
		super(driver);
		base = new BasePge(driver);
		element=new ElementActions(driver);
	}

	// <summary>
	// Test Case Title :    "1.Verify that user should able to navigate to the snipback website after entering the URL		
	// Automation ID :Team_01
	// </summary>
	public void Team_01_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{	
		LoginPage_Obj loginObj=new LoginPage_Obj();

		//Step 1 : Verify that user should able to navigate to the snipback website after entering the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("nav-link btn btn-white sm")), "User is unable to navigate to SnipBack website after entering the URL");
	}

	// <summary>
	// Test Case Title : Verify that user should able to navigate to the Film page once login with credentials		
	// Automation ID :Team_02
	// </summary>
	public void Team_02_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);

		//Step 1 : Verify that user should able to navigate to the snipback website after entering the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("nav-link btn btn-white sm")), "User is unable to navigate to SnipBack website after entering the URL");

		//Step 2: Verify that user should able to navigate to the Film page once login with credentials
		//Expected : User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");
	}

	// <summary>
	// Test Case Title : Verify that Add team (+ Add team) option should be displayed in the organization if the user as Admin/Coach in the Game, Members & Followers tab in the Film page		
	// Automation ID :Team_03
	// </summary>
	public void Team_03_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_03_SelectedValue);
		Select select = new Select(driver.findElement(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations")));
		String selectOption = select.getFirstSelectedOption().getText();
		asrt.assertEquals(selectOption, addupdatedeleteobj.Team_03_SelectedValue, "User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : Verify the +Add team option
		//Expected : Add team (+ Add team) option should be displayed in the organization if the user as Admin/Coach in the Games tab
		Thread.sleep(10000);
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_AlertMessage("Add Team")),"User is unable to view the Add team (+ Add team) option in the organization if the user as Admin/Coach in the 'Games' tab");

		//Step 4: Verify the +Add team option
		//Expected : Add team (+ Add team) option should be displayed in the organization if the user as Admin/Coach in the Members tab
		base.buttonClick(loginObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_AlertMessage("Add Team")),"User is unable to view the Add team (+ Add team) option in the organization if the user as Admin/Coach in the 'Members' tab");

		//Step 5 : Verify the +Add team option
		//Expected : Add team (+ Add team) option should be displayed in the organization if the user as Admin/Coach in the Followers  tab
		base.buttonClick(loginObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_AlertMessage("Add Team")),"User is unable to view the Add team (+ Add team) option in the organization if the user as Admin/Coach in the 'Followers' tab");
	}

	// <summary>
	// Test Case Title : Verify that Add team (+ Add team) option should  be disabled in Home organization and in the Organization if the User as Player/Followers/Recruiter in the Film page
	// Automation ID :Team_04
	// </summary>
	public void Team_04_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab")),"User is unable to login the film page with credentials");

		//Step 2 : Switch the organization as Home organization
		//Expected : User is able to Switch the organization as Home organization
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_04_SelectedValue);
		String DropdownValue=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));		
		asrt.assertEquals(DropdownValue,addupdatedeleteobj.Team_04_SelectedValue,"User is unable to Switch the organization as Home organization");

		//Step 3 : Verify the +Add team option
		//Expected : Add team (+ Add team) option should  be disabled in Home organization in the Film page
		asrt.assertTrue(base.isDoesNotExistBool(loginObj.Edt_AlertMessage("Add Team")),"Add team (+ Add team) option is not disabled in Home organization in the Film page");

		//Step 4 : Switch the organization if the User as Player/Followers/Recruiter
		//Expected : User is able to Switch the organization if the User as Player/Followers/Recruiter
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_04_SelectedFollower);
		String selectedList=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectedList,addupdatedeleteobj.Team_04_SelectedFollower,"User is unable to Switch the organization if the User as Player/Followers/Recruiter");

		//Step 5 : Verify the +Add team option
		//Expected : Add team (+ Add team) option should  be disabled in the Organization if the User as Player/Followers/Recruiter in the Film page
		asrt.assertTrue(base.isDoesNotExistBool(loginObj.Edt_AlertMessage("Add Team")),"Add team (+ Add team) option is not disabled in the organization if the User as Player/Followers/Recruiter in the Film page");
	}

	// <summary>
	// Test Case Title : Verify that a Search bar should be displayed in the film page to search teams
	// Automation ID :Team_05
	// </summary>
	public void Team_05_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_05_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_05_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : Verify that a Search bar should be displayed in the film page to search teams
		//Expected : Search bar should be displayed in the film page to search teams
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")),"Search bar is not displayed in the film page to search teams");
	}

	// <summary>
	// Test Case Title : Verify that user (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
	// Automation ID :Team_06
	// </summary>
	public void Team_06_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_06_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_06_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");
	}

	// <summary>
	// Test Case Title : Verify that following fields should be displayed when click on +Add team from Games/Members/Followers page
	//                   1. Enter Team Name
	//                   2.Search bar with Search Icon 
	//                   3.List of Users to add to teams
	//                   4.Default team type with categories drop down
	//                   5.Game Defaults
	//                   6.A text "Current team members"
	//                   7.Search bar with Search Icon to search current team members`
	//                   8.List of Current team members
	// Automation ID :Team_07
	// </summary>
	public void Team_07_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ScheduleUnscheduleGames_Obj  scheduleunschedulegameobj=new ScheduleUnscheduleGames_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj addupdatedeletegamedefaultobj= new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		ForgotPassword_Obj  forgetobj=new ForgotPassword_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_07_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_07_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step 4 : Verify that Enter Team Name fields should be displayed when click on +Add team from Games/Members/Followers page
		//Expected : User should be able to view Enter Team Name field when click on +Add team from Games/Members/Followers page
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")), "User is unable to view Enter Team Name field when click on +Add team from Games/Members/Followers page");

		//Step 5 : Verify that Search bar with Search Icon fields should be displayed when click on +Add team from Games/Members/Followers page
		//Expected : User is able to view Search bar with Search Icon fields should be displayed when click on +Add team from Games/Members/Followers page
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("orgUsersSearch"))," User is unable to view Search bar with Search Icon fields when click on +Add team from Games/Members/Followers page");

		//Step 6 : Verify that List of Users to add to teams should be displayed when click on +Add team from Games/Members/Followers page
		//Expected : User is able to view List of Users to add to teams when click on +Add team from Games/Members/Followers page
		List<String> UserNames=base.GetElementTexts(loginObj.Ele_ErrorMessage("flex-column justify-content-between members-listing-details ms-3 text-start"));
		asrt.assertNotNull(UserNames,"User is unable to view List of Users to add to teams when click on +Add team from Games/Members/Followers page" );

		//Step 7 : Verify that Default team type with categories drop down fields should be displayed when click on +Add team from Games/Members/Followers page
		//Expected : User is able to view Default team type fields  with categories drop down
		asrt.assertTrue(base.isExists(CreateEditDeletePoolObj.Ele_PoolType("d-flex align-items-center","Default Team Type ")) &&  base.isExists(CreateEditDeletePoolObj.Sel_PoolType("category"))," User is unable to view Default team type fields with categories drop down");

		//Step 8 : Verify that Game Defaults fields should be displayed when click on +Add team from Games/Members/Followers page
		//Expected User is able to view Game Defaults fields when click on +Add team from Games/Members/Followers page
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("default-btn me-2 default-btn-alert")),"User is unable to view Game Defaults fields when click on +Add team from Games/Members/Followers page");

		//Step 9 : Verify that A text "Current team members" fields should be displayed when click on +Add team from Games/Members/Followers page
		//Expected : User is able to view A text "Current team members" fields when click on +Add team from Games/Members/Followers page
		asrt.assertTrue(base.isExists(addupdatedeletegamedefaultobj.Ele_CurrentTeamMembers("CURRENT TEAM MEMBERS"))," User is unable to view A text Current team members fields when click on +Add team from Games/Members/Followers page");

		//Step 10 :  Verify that Search bar with Search Icon to search current team members`fields should be displayed when click on +Add team from Games/Members/Followers page
		//Expected :User is able to view Search bar with Search Icon to search current team members`fields when click on +Add team from Games/Members/Followers page
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("teamUser")), "User is unable to view Search bar with Search Icon to search current team members`fields when click on +Add team from Games/Members/Followers page");

		//Step 11 : Verify that List of Current team members`fields should be displayed when click on +Add team from Games/Members/Followers page
		//Expected :Use is able to view  List of Current team members`fields when click on +Add team from Games/Members/Followers page
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"),addupdatedeleteobj.Team_07_TeamName);
		base.buttonClick(loginObj.Btn_SingnIn("createTeamBtn"));		
		base.buttonClick(loginObj.Btn_SingnIn("modalMessageCloseBtn"));
		String SelectedUser = base.GetText(loginObj.Ele_ErrorMessage("flex-column justify-content-between members-listing-details ms-3 text-start"));
		String[] splitSelectedUser = SelectedUser.split("[\\s\\n]+");
		String correctSelectedUser = "";
		for (String splittedValue : splitSelectedUser) 
		{
			if (splittedValue.contains("@")) 
			{
				correctSelectedUser = splittedValue.trim(); 			        
				break;
			}
		}
		base.selectCheckBox(addupdatedeletegamedefaultobj.Ele_CheckboxSelect(correctSelectedUser,"checkmark"));
		base.buttonClick(forgetobj.Ele_Error("members-menu-icon-wrap members-menu-icon-dark"));
		List<String> CurrentTeams=base.GetElementTexts(loginObj.Ele_ErrorMessage("d-flex flex-column listing-details text-start"));
		asrt.assertNotNull(CurrentTeams,"User is unable to view  List of Current team members`fields when click on +Add team from Games/Members/Followers page" );
	}

	// <summary>
	// Test Case Title :Verify that the X and tick option should displayed against the team name field	
	// Automation ID :Team_08
	// </summary>
	public void Team_08_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ScheduleUnscheduleGames_Obj  scheduleunschedulegameobj=new ScheduleUnscheduleGames_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_08_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_08_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step 4 : Verify that the X and tick option should displayed against the team name field
		//Expected : The X and tick option should displayed against the team name field
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"),addupdatedeleteobj.Team_08_TeamName);
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("btn btn-danger me-2 teamname-cancel-btn")) && base.isExists(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn")),"User is unable to view X and tick option against the team name field");
	}

	// <summary>
	// Test Case Title :Verify that the Team Name should be cleared once click on X option
	// Automation ID :Team_09
	// </summary>
	public void Team_09_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ScheduleUnscheduleGames_Obj  scheduleunschedulegameobj=new ScheduleUnscheduleGames_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_09_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_09_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step 4 : .Enter team name
		//Expected : User is able to enter team name
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"),addupdatedeleteobj.Team_09_TeamName);
		String ActualTeamname=base.GetValue(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"));	  	    
		asrt.assertEquals(ActualTeamname , addupdatedeleteobj.Team_09_TeamName,"User is unable to enter the Team name");

		// Step 5: Click on X option
		// Expected: Team Name should be cleared once click on X option
		base.buttonClick(scheduleunschedulegameobj.Btn_EventOK("btn btn-danger me-2 teamname-cancel-btn"));
		String teamNameValue = base.GetValue(scheduleunschedulegameobj.Ele_SearchGame("form-control form-control-wrap"));
		asrt.assertEquals(teamNameValue, "", "Team Name is not cleared once user clicks on X option");
	}

	// <summary>
	// Test Case Title :Verify that the message " The Team name is required for this Operation" should be displayed if we left Team Name field blank
	// Automation ID :Team_10
	// </summary>
	public void Team_10_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ScheduleUnscheduleGames_Obj  scheduleunschedulegameobj=new ScheduleUnscheduleGames_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_10_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_10_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step  4:Verify that the message " The Team name is required for this Operation" should be displayed if we left Team Name field blank
		//Expected :The message " The Team name is required for this Operation" should be displayed if we left Team Name field blank	
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"),addupdatedeleteobj.Team_10_TeamNameBlank);
		base.excuteJsClick(loginObj.Edt_AlertMessage("ADD"));
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("btn popclose ms-auto d-table")),"User is unable to view the message 'The Team name is required for this Operation' if Team Name field is left blank");
	}

	// <summary>
	// Test Case Title :Verify that "Please select the Game category" message with OK should be displayed when we enter the Team Name & left the Default team type field
	// Automation ID :Team_11
	// </summary>
	public void Team_11_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ScheduleUnscheduleGames_Obj  scheduleunschedulegameobj=new ScheduleUnscheduleGames_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_11_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_11_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step 4 : Enter team name
		//Expected : User is able to enter team name
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"),addupdatedeleteobj.Team_11_TeamName);
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn")),"User is unable to enter team name");

		//Step 5 : Verify the Default Team Type dropdown
		//Expected : User should be able to left the Default team type field
		base.selectorByVisibleText(CreateEditDeletePoolObj.Sel_PoolType("category"),addupdatedeleteobj.Team_11_SelectedDropdown);
		String selectedDropdown=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select"));	
		asrt.assertEquals(selectedDropdown , ""," User is unable to left the Default team type field");

		//Step 6: Verify that "Please select the Game category" message with OK should be displayed when we enter the Team Name & left the Default team type field 
		//Expected : "Please select the Game category" message with OK should be displayed when we enter the Team Name & left the Default team type field
		base.excuteJsClick(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn"));
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("swal-button swal-button--confirm")) && base.isExists(loginObj.Ele_ErrorMessage("swal-text")),"User is unable to view the 'Please select the Game category' message with OK when entering the Team Name & left the Default team type field");		
	}	

	// <summary>
	// Test Case Title :Verify that "Please select the Game category" message should be closed when click on OK button
	// Automation ID :Team_12
	// </summary>
	public void Team_12_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ScheduleUnscheduleGames_Obj  scheduleunschedulegameobj=new ScheduleUnscheduleGames_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_12_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_12_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step 4 : .Enter team name
		//Expected : User is able to enter team name
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"),addupdatedeleteobj.Team_12_TeamName);
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn")),"User is unable to enter team name");

		//Step 5 : Verify the Default Team Type dropdown
		//Expected : User should be able to left the Default team type field
		base.selectorByVisibleText(CreateEditDeletePoolObj.Sel_PoolType("category"),addupdatedeleteobj.Team_12_SelectedDropdown);
		String selectedDropdown=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select"));	
		asrt.assertEquals(selectedDropdown , ""," User is unable to left the Default team type field");

		//Step 6:Verify the tick option against the team name field		
		//Expected :User is able to click tick option against the team name field		
		base.excuteJsClick(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn"));
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("swal-button swal-button--confirm")),"User is unable to click tick option against the team name field");

		//Step 7 : Verify that "Please select the Game category" message should be closed when click on OK button
		//Expected : "Please select the Game category" message should be closed when click on OK button
		base.excuteJsClick(scheduleunschedulegameobj.Btn_EventOK("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isDoesNotExistBool(loginObj.Ele_ErrorMessage("swal-text")), "'Please select the Game category' message is not closed when user click on OK button");
	}


	// <summary>
	// Test Case Title :Verify that the Team Name created successfully message with Close button should be  once enter the Team Name, select default team type & click on Tick option
	// Automation ID :Team_13
	// </summary>
	public void Team_13_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ScheduleUnscheduleGames_Obj  scheduleunschedulegameobj=new ScheduleUnscheduleGames_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj addUpdateObject=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_13_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_13_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step 4 : .Enter team name
		//Expected : User is able to enter team name
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"),addupdatedeleteobj.Team_13_TeamName);
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn")),"User is unable to enter team name");

		//Step 5 :Select default team type
		//Expected : User is able to Select default team type		
		base.selectorByVisibleText(CreateEditDeletePoolObj.Sel_PoolType("category"),addupdatedeleteobj.Team_13_SelectedDropdown);
		String selectedDropdown=element.DropDownText(CreateEditDeletePoolObj.Sel_PoolType("category"));	
		asrt.assertEquals(selectedDropdown ,addupdatedeleteobj.Team_13_SelectedDropdown," User is unable to Select default team type");

		//Step 6 :Click on Tick option
		//Expected :Team Name created successfully message with Close button should be viewed once entered the Team Name & click on Tick option and also select default team type	
		base.excuteJsClick(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn"));
		asrt.assertTrue(base.isExists(addUpdateObject.Ele_Successmessage("New Team Created Successfully","successTag")) && base.isExists(addUpdateObject.Btn_CloseClick("modal-body","modalMessageCloseBtn")) && base.isExists(addUpdateObject.Ele_SelectedDropdown("category",addupdatedeleteobj.Team_13_SelectedDropdown)),"User is not able to view the 'Team Name created successfully' message with the Close button after entering the team name and selecting the default team type and clicking tick option");
	}

	// <summary>
	// Test Case Title :Verify that "Team Name Already exists" message should displayed if we try to create same team name for different teams
	// Automation ID :Team_15
	// </summary>
	public void Team_15_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ScheduleUnscheduleGames_Obj  scheduleunschedulegameobj=new ScheduleUnscheduleGames_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj addUpdateObject=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_15_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_15_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step 4 : Enter team name
		//Expected : User is able to enter team same name
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"),addupdatedeleteobj.Team_15_TeamName);
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn")),"User is unable to enter same team name");

		//Step 5 : Select the Game category
		//Expected : User should be able to Select the Game category
		base.selectorByVisibleText(CreateEditDeletePoolObj.Sel_PoolType("category"),addupdatedeleteobj.Team_15_SelectedDropdown);
		String selectedDropdown=element.DropDownText(CreateEditDeletePoolObj.Sel_PoolType("category"));	
		asrt.assertEquals(selectedDropdown ,addupdatedeleteobj.Team_15_SelectedDropdown," User is unable to to Select the Game category");

		//Step 6 : Verify the message
		//Expected : "Team Name Already exists" message should displayed if we try to create same team name for different teams
		base.excuteJsClick(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn"));
		asrt.assertTrue(base.isExists(addUpdateObject.Ele_Message("Team name already exists.")), "'Team Name Already exists' message is not displayed when user enter same team name for different teams");		
	}

	// <summary>
	// Test Case Title :Verify that "Team Name Already exists" message should Closed when we click on Close button 
	// Automation ID :Team_16
	// </summary>
	public void Team_16_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ScheduleUnscheduleGames_Obj  scheduleunschedulegameobj=new ScheduleUnscheduleGames_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj addUpdateObject=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_16_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_16_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step 4 : .Enter same team name
		//Expected : User is able to enter team name
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"),addupdatedeleteobj.Team_16_TeamName);
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn")),"User is unable to enter team name");

		//Step 5 :Select the Game category
		//Expected : User is able to Select the Game category		
		base.selectorByVisibleText(CreateEditDeletePoolObj.Sel_PoolType("category"),addupdatedeleteobj.Team_16_SelectedDropdown);
		String selectedDropdown=element.DropDownText(CreateEditDeletePoolObj.Sel_PoolType("category"));	
		asrt.assertEquals(selectedDropdown ,addupdatedeleteobj.Team_16_SelectedDropdown," User is unable to Select the Game category");

		//Step 6 : Verify the message
		//Expected : "Team Name Already exists" message should displayed 
		base.excuteJsClick(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn"));
		asrt.assertTrue(base.isExists(addUpdateObject.Ele_Message("Team name already exists.")), "User is unable to view 'Team Name Already exists' message");

		//Step 7 : Click on Close button
		//Expected : "Team Name Already exists" message should Closed when we click on Close button 
		base.excuteJsClick(addUpdateObject.Btn_Close("modal","show","modalMessageCloseBtn","Close"));
		asrt.assertTrue(base.isDoesNotExistBool(addUpdateObject.Ele_Message("Team name already exists.")),"'Team Name Already exists' message is not Closed when user click on Close button");
	}

	// <summary>
	// Test Case Title :Verify that following options should be displayed when click on +Add team from Games/Members/Followers page
	//                  1.ADD
	//                  2.REMOVE
	//                  3.Create & Add New member with Email
	//                  4.Create & Add New member without Email
	// Automation ID :Team_17
	// </summary>
	public void Team_17_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_17_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_17_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step 4 : Verify that ADD option is displayed when click on +Add team from Games/Members/Followers page
		//Expected : User is able to view ADD option when click on +Add team from Games/Members/Followers page
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("ADD")),"User is unable to view ADD option when clicking +Add team from Games/Members/Followers page");

		//Step 5 : Verify that REMOVE option is displayed when click on +Add team from Games/Members/Followers page
		//Expected : User is able to view REMOVE option when click on +Add team from Games/Members/Followers page
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("REMOVE")),"User is unable to view REMOVE option when clicking +Add team from Games/Members/Followers page");

		//Step 6 :Verify that Create & Add New member with Email option is displayed when click on +Add team from Games/Members/Followers page
		//Expected : User is able to view Create & Add New member with Email option when click on +Add team from Games/Members/Followers page
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")),"User is unable to view Create & Add New Member With Email option when clicking +Add team from Games/Members/Followers page"); 

		//Step 7 : Verify that Create & Add New member without Email option is displayed when click on +Add team from Games/Members/Followers page
		//Expected : User is able to view Create & Add New member without Email option when click on +Add team from Games/Members/Followers page
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member Without Email")),"User is unable to view Create & Add New Member Without Email option when clicking +Add team from Games/Members/Followers page");
	}

	// <summary>
	// Test Case Title :Verify that the following game cateogory should be displayed in Default team type dropdown;
	//              1.Baseball
	//              2.Basketball
	//              3.Football
	//              4.Tennis
	//              5.Volleyball
	//              6.Weight Lifting
	//              7.Soccer
	//              8.Other
	// Automation ID :Team_18
	// </summary>
	public void Team_18_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_18_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_18_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step 4 : Click on Default team type dropdown
		//Expected :Verify that the following game cateogory should be displayed in Default team type dropdown;
		//          1.Baseball
		//          2.Basketball
		//          3.Football
		//          4.Tennis
		//          5.Volleyball
		//          6.Weight Lifting
		//          7.Soccer
		//          8.Other
		List<WebElement> DropdownOptions = base.getTheAllOptions(CreateEditDeletePoolObj.Sel_PoolType("category"));
		List<String> expectedOptions = Arrays.asList(addupdatedeleteobj.Team_18_Dropdownselectedvalue1,addupdatedeleteobj.Team_18_Dropdownselectedvalue2,addupdatedeleteobj.Team_18_Dropdownselectedvalue3,
				addupdatedeleteobj.Team_18_Dropdownselectedvalue4,addupdatedeleteobj.Team_18_Dropdownselectedvalue5,addupdatedeleteobj.Team_18_Dropdownselectedvalue6,
				addupdatedeleteobj.Team_18_Dropdownselectedvalue7,addupdatedeleteobj.Team_18_Dropdownselectedvalue8);
		List<String> availableOptions = new ArrayList<>();
		for (WebElement option : DropdownOptions) 
		{
			String optionText = option.getText().trim();
			if (!optionText.equalsIgnoreCase("-select-") && !optionText.isEmpty())
			{
				availableOptions.add(optionText);
			}
		}
		for (String expected : expectedOptions)
		{
			asrt.assertTrue(availableOptions.contains(expected),"User is unable to view game cateogory '"+expected+"' in Default team type dropdown ");
		}
	}

	// <summary>
	// Test Case Title :Verify that Save button should be displayed to Save the team after we created with required details 
	// Automation ID :Team_20
	// </summary>
	public void Team_20_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ScheduleUnscheduleGames_Obj  scheduleunschedulegameobj=new ScheduleUnscheduleGames_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_20_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_20_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step 4 : Verify Save option
		//Expected : Save icon should be displayed to Save the team after we created with required details
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("bg-red cursor-pointer update-team")),"Save icon is not displayed to Save the team when user created the required details");
	}

	// <summary>
	// Test Case Title :Verify that "Data saved successfully" message should be displayed when we click on Save icon
	// Automation ID :Team_21
	// </summary>
	public void Team_21_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ScheduleUnscheduleGames_Obj  scheduleunschedulegameobj=new ScheduleUnscheduleGames_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj addUpdateObject=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_21_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_21_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//Step 4 :Enter team name
		//Expected : User is able to enter team name
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"),addupdatedeleteobj.Team_21_TeamName);
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn")),"User is unable to enter team name");

		//Step 5 :Select the Game category
		//Expected : User is able to Select the Game category		
		base.selectorByVisibleText(CreateEditDeletePoolObj.Sel_PoolType("category"),addupdatedeleteobj.Team_21_SelectedDropdown);
		String selectedDropdown=element.DropDownText(CreateEditDeletePoolObj.Sel_PoolType("category"));	
		asrt.assertEquals(selectedDropdown ,addupdatedeleteobj.Team_21_SelectedDropdown," User is unable to Select the Game category");

		//Step 6:Verify the tick option against the team name field		
		//Expected :User is able to click tick option against the team name field		
		base.excuteJsClick(scheduleunschedulegameobj.Btn_EventOK("btn btn-success teamname-ok-btn"));
		asrt.assertTrue(base.isExists(addUpdateObject.Ele_Message("New Team Created Successfully")),"User is unable to click tick option against the team name field");

		//Step 7 :Click on close button option
		//Expected :User is able to click the close button option viewed along with the Team Name created successfully message
		base.excuteJsClick(addUpdateObject.Btn_Close("modal","show","modalMessageCloseBtn","Close"));
		asrt.assertTrue(base.isDoesNotExistBool(addUpdateObject.Ele_Message("New Team Created Successfully")),"User is unable to click the close button option viewed along with the Team Name created successfully message");

		//Step 6:Click on Save Icon
		//Expected : "Data saved successfully" message should be displayed when we click on Save icon
		base.excuteJsClick(scheduleunschedulegameobj.Btn_EventOK("bg-red cursor-pointer update-team"));
		asrt.assertTrue(base.isExists(addUpdateObject.Ele_Message("Data Saved Successfully")),"User is unable to view 'Data saved successfully' message when clicking on Save icon");
	}

	// <summary>
	// Test Case Title :Close button (X) should be displayed to Close the Page for Add team
	// Automation ID :Team_22
	// </summary>
	public void Team_22_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ScheduleUnscheduleGames_Obj  scheduleunschedulegameobj=new ScheduleUnscheduleGames_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_22_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_22_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : .Click on +Add team option
		//Expected : User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page
		base.buttonClick(loginObj.Edt_AlertMessage("Add Team"));
		asrt.assertTrue(base.isExists(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap")),"User is unable to click on Add team (+ Add team) option in the film page");

		//step 4 : Verify that Close button (X) should be displayed to Close the Page for Add team
		//Expected : Close button (X) should be displayed to Close the Page for Add team
		asrt.assertTrue(base.isExists(scheduleunschedulegameobj.Btn_EventOK("popup-btn-close menu-dark")),"User is unable to view Close button (X)  to Close the Page for Add team");
	}

	// <summary>
	// Test Case Title :Verify that three dots should be displayed against each team in the Game/Members/Followers Page
	// Automation ID :Team_23
	// </summary>
	public void Team_23_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		SearchGameTeamAndMembers_Obj SearchGameObjects=new SearchGameTeamAndMembers_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_23_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_23_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : Verify the three dots against the team
		//Expected : Three dots should be displayed against each team in the Game/Members/Followers Page 
		List<String> teamList = base.GetElementTexts(SearchGameObjects.Ele_GameSpecial("my-team-content"));
		for (String team : teamList) 
		{
			WebElement threeDotsButton = driver.findElement(loginObj.Btn_LoginButton("all-teams-menu cursor-pointer"));
			asrt.assertTrue(threeDotsButton.isDisplayed(), "User is unable to view Three dots against team '" + team + "' in the Game/Members/Followers Page");
		}
	}

	// <summary>
	// Test Case Title :Verify that the following option should be displayed in the three dots agaisnt each team 
	//                  1. Edit
	//                  2.Team Invite Links
	//                  3.Duplicate Team
	//                  4.Archive Team
	//                  5.Delete Team
	//                  6.Chat with Team
	//                  7.Dismiss
	// Automation ID :Team_24
	// </summary>
	public void Team_24_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		SearchGameTeamAndMembers_Obj SearchGameObjects=new SearchGameTeamAndMembers_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_24_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_24_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3: Click on three dots 
		//Expected : Verify that the following option should be displayed in the three dots against each team 
		//           1. Edit
		//           2.Team Invite Links
		//           3.Duplicate Team
		//           4.Archive Team
		//           5.Delete Team
		//           6.Chat with Team
		//           7.Dismiss
		List<String> expectedList = Arrays.asList(addupdatedeleteobj.Team_24_Listvalue1,addupdatedeleteobj.Team_24_Listvalue2,addupdatedeleteobj.Team_24_Listvalue3,
				addupdatedeleteobj.Team_24_Listvalue4,addupdatedeleteobj.Team_24_Listvalue5,addupdatedeleteobj.Team_24_Listvalue6,addupdatedeleteobj.Team_24_Listvalue7);
		List<String> teamList = base.GetElementTexts(SearchGameObjects.Ele_GameSpecial("my-team-content"));
		for (int i = 0; i < teamList.size(); i++)
		{
			try
			{
				String team = teamList.get(i);
				WebElement threeDotsButton = driver.findElement(loginObj.Btn_LoginButton("all-teams-menu cursor-pointer"));
				threeDotsButton.click();
				Thread.sleep(1000); 
				List<WebElement> dropdownItems = driver.findElements(loginObj.Ele_ErrorMessage("dropdown-menu-item"));
				List<String> actualOptions = new ArrayList<>();
				for (WebElement item : dropdownItems) 
				{
					String text = item.getText();
					if (!text.isEmpty()) 
						actualOptions.add(text);
				}
				for (String expected : expectedList) 
				{	
					asrt.assertTrue(actualOptions.contains(expected),"User is unable to view option '" + expected + "' when clicking three dots against team '" + team + "'");					
				}
				threeDotsButton.click();
				Thread.sleep(1000);
			} 
			catch (Exception e)
			{
				System.out.println("Error at index " + i + ": " + e.getMessage());
			}
		}
	}

	// <summary>
	// Test Case Title :Verify that details of the Team should be displayed when click on Edit option from the three dots against the team
	// Automation ID :Team_25
	// </summary>
	public void Team_25_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		Registration_Obj regObj=new Registration_Obj ();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_25_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_25_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : Verify the option
		//Expected : User is able to  view edit team option when Click on three dots the team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"),addupdatedeleteobj.Team_25_TeamName);
		Thread.sleep(1000);
		base.pressKey(loginObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(regObj.Btn_ResendOTP("defaultDropdown-1"));	
		asrt.assertTrue(base.isExists(regObj.Btn_Login("dropdown-item","Edit Team")), "User is unable to view edit option when Clicking three dots of the team");

		//Step 4 :  Click on Edit team option
		//Expected :Details of the Team should be displayed when click on Edit option from the three dots against the team
		Thread.sleep(1000);
		base.excuteJsClick(regObj.Btn_Login("dropdown-item","Edit Team"));
		base.switchToWindowByIndex(driver, 0);
		String teamName=base.GetValue(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"));
		asrt.assertEquals(teamName, addupdatedeleteobj.Team_25_TeamName, "Details of the Team is not displayed when user click Edit option from the three dots against the team");
	}

	// <summary>
	// Test Case Title :Verify that a pencil icon should be displayed to edit the name of the Team after clicking the Edit option
	// Automation ID :Team_26
	// </summary>
	public void Team_26_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		Registration_Obj regObj=new Registration_Obj ();
		SearchGameTeamAndMembers_Obj searchGameobject=new SearchGameTeamAndMembers_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_26_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_26_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : Verify the options 
		//Expected : User is able to  view edit option when Click on three dots of the team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"),addupdatedeleteobj.Team_26_TeamName);
		Thread.sleep(1000);
		base.pressKey(loginObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(regObj.Btn_ResendOTP("defaultDropdown-1"));	
		asrt.assertTrue(base.isExists(regObj.Btn_Login("dropdown-item","Edit Team")), "User is unable to view edit option when Clicking three dots of the team");

		//Step 4 : Click on Edit option
		//Expected :A pencil icon should be displayed to edit the name of the Team after clicking the Edit option
		Thread.sleep(1000);
		base.excuteJsClick(regObj.Btn_Login("dropdown-item","Edit Team"));
		base.switchToWindowByIndex(driver, 0);
		asrt.assertTrue(base.isExists(searchGameobject.Ele_GameSpecial("teamDiv")), "A pencil icon is not displayed to edit the name of the Team when user click the Edit option");
	}

	// <summary>
	// Test Case Title :Verify that X and Tick mark should be displayed once clicking the pencil icon
	// Automation ID :Team_27
	// </summary>
	public void Team_27_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		Registration_Obj regObj=new Registration_Obj ();
		SearchGameTeamAndMembers_Obj searchGameobject=new SearchGameTeamAndMembers_Obj();
		ScheduleUnscheduleGames_Obj  scheduleObject=new ScheduleUnscheduleGames_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_27_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_27_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : Verify the option
		//Expected : User is able to  view edit option when Click on three dots of the team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"),addupdatedeleteobj.Team_27_TeamName);
		Thread.sleep(1000);
		base.pressKey(loginObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(regObj.Btn_ResendOTP("defaultDropdown-1"));	
		asrt.assertTrue(base.isExists(regObj.Btn_Login("dropdown-item","Edit Team")), "User is unable to view edit option when Clicking three dots of the team");

		//Step 4 :  Click on Edit team option
		//Expected :A pencil icon should be displayed to edit the name of the Team after clicking the Edit option
		Thread.sleep(1000);
		base.excuteJsClick(regObj.Btn_Login("dropdown-item","Edit Team"));
		base.switchToWindowByIndex(driver, 0);
		asrt.assertTrue(base.isExists(searchGameobject.Ele_GameSpecial("teamDiv")), "A pencil icon is not displayed to edit the name of the Team when user click the Edit option");

		//Step 5 : Click on Pencil Icon
		//Expected : The X and Tick mark should be displayed once clicking the pencil icon
		Thread.sleep(1000);
		base.buttonClick(loginObj.Ele_ErrorMessage("c-pointer "));
		asrt.assertTrue( base.isExists(loginObj.Btn_SingnIn("createTeamBtn")) && base.isExists(scheduleObject.Btn_EventOK("btn btn-danger me-2 teamname-cancel-btn")),"User is unable to view X and tick option once clicking the pencil icon");
	}

	// <summary>
	// Test Case Title :Verify that the user should able to change the Team Name after clicking the pencil icon
	// Automation ID :Team_28
	// </summary>
	public void Team_28_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		Registration_Obj regObj=new Registration_Obj ();
		SearchGameTeamAndMembers_Obj searchGameobject=new SearchGameTeamAndMembers_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_28_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_28_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : Verify the option
		//Expected : User is able to  view edit option when Click on three dots of the team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"),addupdatedeleteobj.Team_28_TeamName);
		Thread.sleep(1000);
		base.pressKey(loginObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(regObj.Btn_ResendOTP("defaultDropdown-1"));	
		asrt.assertTrue(base.isExists(regObj.Btn_Login("dropdown-item","Edit Team")), "User is unable to view edit option when Clicking three dots of the team");

		//Step 4 :  Click on Edit team option
		//Expected :User is able to click Edit team option
		Thread.sleep(1000);
		base.excuteJsClick(regObj.Btn_Login("dropdown-item","Edit Team"));
		base.switchToWindowByIndex(driver, 0);
		asrt.assertTrue(base.isExists(searchGameobject.Ele_GameSpecial("teamDiv")), "User is unable to click the Edit team option");

		//Step 5 : Click on Pencil Icon
		//Expected : User is able to click Pencil icon
		Thread.sleep(1000);
		base.buttonClick(loginObj.Ele_ErrorMessage("c-pointer "));
		asrt.assertTrue( base.isExists(loginObj.Btn_SingnIn("createTeamBtn")) ,"User is unable to click Pencil icon");

		//Step 6 :Change the Team Name
		//Expected : User should be able to edit the team name
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"), addupdatedeleteobj.Team_28_NewTeamName);
		String teamName=base.GetValue(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"));
		asrt.assertEquals(teamName , addupdatedeleteobj.Team_28_NewTeamName,"User is unable to edit the Team name");
	}

	// <summary>
	// Test Case Title :Verify that "Data Saved Successfully " message with Close button should be displayed when the user change the Team Name and click on Tick Option
	// Automation ID :Team_29
	// </summary>
	public void Team_29_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		Registration_Obj regObj=new Registration_Obj ();
		SearchGameTeamAndMembers_Obj searchGameobject=new SearchGameTeamAndMembers_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj addUpdateObject=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_29_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_29_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : Verify the option
		//Expected : User is able to  view edit option when Click on three dots of the team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"),addupdatedeleteobj.Team_29_TeamName);
		Thread.sleep(1000);
		base.pressKey(loginObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(regObj.Btn_ResendOTP("defaultDropdown-1"));	
		asrt.assertTrue(base.isExists(regObj.Btn_Login("dropdown-item","Edit Team")), "User is unable to view edit option when Clicking three dots of the team");

		//Step 4 :  Click on Edit team option
		//Expected :User is able to click Edit team option
		Thread.sleep(1000);
		base.excuteJsClick(regObj.Btn_Login("dropdown-item","Edit Team"));
		base.switchToWindowByIndex(driver, 0);
		asrt.assertTrue(base.isExists(searchGameobject.Ele_GameSpecial("teamDiv")), "User is unable to click Edit team option");

		//Step 5 : Click on Pencil Icon
		//Expected : User is able to click the Pencil icon
		Thread.sleep(1000);
		base.buttonClick(loginObj.Ele_ErrorMessage("c-pointer "));
		asrt.assertTrue( base.isExists(loginObj.Btn_SingnIn("createTeamBtn")),"User is unable to click the Pencil icon");

		//Step 6 :Change the Team Name
		//Expected : User should be able to edit the team name	
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"), addupdatedeleteobj.Team_29_TeamName);
		String teamName=base.GetValue(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"));
		asrt.assertEquals(teamName , addupdatedeleteobj.Team_29_TeamName,"User is unable to edit the Team name");

		//Step 7 : Click on Tick Option
		//Expected : "Data Saved Successfully " message with Close button should be displayed when the user change the Team Name and click on Tick Option
		base.buttonClick(loginObj.Btn_SingnIn("createTeamBtn"));
		asrt.assertTrue(base.isExists(addUpdateObject.Ele_Message("Data Saved Successfully")) &&  base.isExists(addUpdateObject.Btn_CloseClick("modal-body","modalMessageCloseBtn")),"User is unable to view 'Data saved successfully' message  with Close button when clicking on Tick Option");
	}

	// <summary>
	// Test Case Title :Verify that "Data Saved Successfully " message should be  Closed after clicking Close button 
	// Automation ID :Team_30
	// </summary>
	public void Team_30_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login = new Login(driver);
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		Registration_Obj regObj=new Registration_Obj ();
		SearchGameTeamAndMembers_Obj searchGameobject=new SearchGameTeamAndMembers_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj addUpdateObject=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_30_SelectedValueAdmin);
		String selectOrg=element.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_30_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : Verify the option
		//Expected : User is able to  view edit option when Click on three dots of the team
		base.setData(loginObj.Edt_LoginEmail("searchTeam"),addupdatedeleteobj.Team_30_TeamName);
		Thread.sleep(1000);
		base.pressKey(loginObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(regObj.Btn_ResendOTP("defaultDropdown-1"));	
		asrt.assertTrue(base.isExists(regObj.Btn_Login("dropdown-item","Edit Team")), "User is unable to view edit option when Clicking three dots of the team");

		//Step 4 :  Click on Edit team option
		//Expected :User is able to click Edit team option
		Thread.sleep(1000);
		base.excuteJsClick(regObj.Btn_Login("dropdown-item","Edit Team"));
		base.switchToWindowByIndex(driver, 0);
		asrt.assertTrue(base.isExists(searchGameobject.Ele_GameSpecial("teamDiv")), "User is unable to click Edit team option");

		//Step 5 : Click on Pencil Icon
		//Expected :User is able to click Pencil Icon
		Thread.sleep(1000);
		base.buttonClick(loginObj.Ele_ErrorMessage("c-pointer "));
		asrt.assertTrue( base.isExists(loginObj.Btn_SingnIn("createTeamBtn")),"User is unable to click Pencil Icon");

		//Step 6 :Change the Team Name
		//Expected : User should be able to edit the team name		
		base.setData(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"), addupdatedeleteobj.Team_30_NewTeamName);
		String teamName=base.GetValue(createandaddnewmemberobj.Ele_SearchGame("form-control form-control-wrap"));
		asrt.assertEquals(teamName , addupdatedeleteobj.Team_30_NewTeamName,"User is unable to edit the Team name");

		//Step 7 : Click on Tick Option
		//Expected : User should be able to click Tick option
		base.buttonClick(loginObj.Btn_SingnIn("createTeamBtn"));
		asrt.assertTrue(base.isExists(addUpdateObject.Ele_Message("Data Saved Successfully")),"User is unable to  click Tick option");

		//Step 8 : Click on Close button
		//Expected : "Data Saved Successfully " message should be  Closed after clicking Close button  
		base.buttonClick(addUpdateObject.Btn_CloseClick("modal-body","modalMessageCloseBtn"));
		asrt.assertTrue(base.isDoesNotExistBool(addUpdateObject.Ele_Message("Data Saved Successfully"))," 'Data Saved Successfully' message is not Closed when user click Close button ");
	}
}
