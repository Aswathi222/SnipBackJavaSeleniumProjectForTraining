package testPage.MavenPageObject;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import TestData.AddUpdateDeleteDuplicateTeamGameDefaults_TestData;
import TestData.CommonData;
import objectRepository.AddUpdateDeleteDuplicateTeamGameDefaults_Obj;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.ForgotPassword_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
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
}
