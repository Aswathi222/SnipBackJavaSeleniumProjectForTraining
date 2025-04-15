package testPage.MavenPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import TestData.AddUpdateDeleteDuplicateTeamGameDefaults_TestData;
import TestData.CommonData;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import utilPack.BasePge;

public class AddUpdateDeleteDuplicateTeamGameDefaults  extends BasePge{

	BasePge base;
	Assert asrt;

	public AddUpdateDeleteDuplicateTeamGameDefaults(WebDriver driver) 
	{
		super(driver);
		base = new BasePge(driver);
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
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_Alert1("Add Team")),"User is unable to view the Add team (+ Add team) option in the organization if the user as Admin/Coach in the 'Games' tab");

		//Step 4: Verify the +Add team option
		//Expected : Add team (+ Add team) option should be displayed in the organization if the user as Admin/Coach in the Members tab
		base.buttonClick(loginObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_Alert1("Add Team")),"User is unable to view the Add team (+ Add team) option in the organization if the user as Admin/Coach in the 'Members' tab");

		//Step 5 : Verify the +Add team option
		//Expected : Add team (+ Add team) option should be displayed in the organization if the user as Admin/Coach in the Followers  tab
		base.buttonClick(loginObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_Alert1("Add Team")),"User is unable to view the Add team (+ Add team) option in the organization if the user as Admin/Coach in the 'Followers' tab");
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
		String DropdownValue=base.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));		
		asrt.assertEquals(DropdownValue,addupdatedeleteobj.Team_04_SelectedValue,"User is unable to Switch the organization as Home organization");

		//Step 3 : Verify the +Add team option
		//Expected : Add team (+ Add team) option should  be disabled in Home organization in the Film page
		asrt.assertTrue(base.isDoesNotExistBool(loginObj.Edt_Alert1("Add Team")),"Add team (+ Add team) option is not disabled in Home organization in the Film page");

		//Step 4 : Switch the organization if the User as Player/Followers/Recruiter
		//Expected : User is able to Switch the organization if the User as Player/Followers/Recruiter
		base.buttonClick(CreateEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		base.selectorByVisibleText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"),addupdatedeleteobj.Team_04_SelectedFollower);
		String selectedList=base.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectedList,addupdatedeleteobj.Team_04_SelectedFollower,"User is unable to Switch the organization if the User as Player/Followers/Recruiter");

		//Step 5 : Verify the +Add team option
		//Expected : Add team (+ Add team) option should  be disabled in the Organization if the User as Player/Followers/Recruiter in the Film page
		asrt.assertTrue(base.isDoesNotExistBool(loginObj.Edt_Alert1("Add Team")),"Add team (+ Add team) option is not disabled in the organization if the User as Player/Followers/Recruiter in the Film page");
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
		String selectOrg=base.DropDownText(createandaddnewmemberobj.DdlOrg("form-select select-form film-organizations"));			
		asrt.assertEquals(selectOrg,addupdatedeleteobj.Team_05_SelectedValueAdmin,"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : Verify that a Search bar should be displayed in the film page to search teams
		//Expected : Search bar should be displayed in the film page to search teams
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")),"Search bar is not displayed in the film page to search teams");
	}
}
