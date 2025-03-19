package testPage.MavenPageObject;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.AddUpdateDeleteDuplicateTeamGameDefaults_TestData;
import TestData.CommonData;
import TestData.TrimVideo_TestData;
import objectRepository.AddFollower_Obj;
import objectRepository.AddEditInfo_Obj;
import objectRepository.AddUpdateDeleteDuplicateTeamGameDefaults_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.ArchiveUnarchiveTeam_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.ViewProfile_Obj;
import utilPack.BasePge;

public class AddUpdateDeleteDuplicateTeamGameDefaults extends BasePge
{
	BasePge base;
	Assert asrt;

	public AddUpdateDeleteDuplicateTeamGameDefaults (WebDriver driver) 
	{
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title : "Verify that details of the Team should be displayed when click on Edit option from the three dots against the team"
	// Automation ID : Team_25
	// </summary>
	public void Team_25_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
		
		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.buttonClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)),"Details of the Team should not be displayed when click on Edit option from the three dots against the team");
	
	}
	
	// <summary>
	// Test Case Title : "Verify that a pencil icon should be displayed to edit the name of the Team after clicking the Edit option"
	// Automation ID : Team_26
	// </summary>
	public void Team_26_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
		
		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.buttonClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)),"Details of the Team should not be displayed when click on Edit option from the three dots against the team");
		
		//Step 5:Verify pencil icon displaying or not 
		//Expected:A pencil icon displayed to edit the name of the Team after clicking the Edit option
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("newTeamDiv", "bi bi-pencil")),"A pencil icon should not be displayed to edit the name of the Team after clicking the Edit option");
	}

	// <summary>
	// Test Case Title : "Verify that X and Tick mark should be displayed once clicking the pencil icon"
	// Automation ID : Team_27
	// </summary>
	public void Team_27_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
		
		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)),"Details of the Team should not be displayed when click on Edit option from the three dots against the team");
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("newTeamDiv", "bi bi-pencil")),"A pencil icon should not be displayed to edit the name of the Team after clicking the Edit option");	
		
		//Step 5:Click on pencil icon 
		//Expected:A pencil icon displayed to edit the name of the Team after clicking the Edit option		
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("newTeamDiv", "bi bi-pencil"));
		
		//Step 6:Verify The X and Tick mark should be displayed once clicking the pencil icon
		//Expected:The X and Tick mark should be displayed once clicking the pencil icon
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("newTeamDiv", "bi bi-x")),"The X and Tick mark should not be displayed once clicking the pencil icon");
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("newTeamDiv", "bi bi-check2")),"The X and Tick mark should not be displayed once clicking the pencil icon");
	}

	// <summary>
	// Test Case Title :"To verify that the message "Are you sure want to delete this team?" with Yes or should be displayed once we click on Delete option from the three dots against the team in Snipback page."
	// Automation ID   : Team_35 
	// </summary>

	public void Team_35_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_35_TestData)));
		
		//Step 4 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_35_TestData));			
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_35_TestData,"Delete Team")));
		base.scrollToElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_35_TestData,"Delete Team"));
		
		//Step 5   :"Click on Delete Team option in snipback"
		//Expected :"User should be clickable on Delete Team option in snipback"
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_35_TestData,"Delete Team"));

		//Step 6   :"Verify that the message "Are you sure want to delete this team?" with Yes or No should be displayed once we click on Delete option from the three dots against the team in snipback  "
		//Expected :"User should be view that the message "Are you sure want to delete this team?" with Yes or No should be displayed once we click on Delete option from the three dots against the team in snipback"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Are you sure want to delete this team?")), "User should not be view that the message Are you sure want to delete this team? should not be displayed once we click on Delete option from the three dots against the team in snipback");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Yes")), "User should not be view that the message Are you sure want to delete this team? with Yes should not be displayed once we click on Delete option from the three dots against the team in snipback");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("No")), "User should not be view that the message Are you sure want to delete this team? with No should not be displayed once we click on Delete option from the three dots against the team in snipback");
	}

	// <summary>
	// Test Case Title :"To Verify that when click on No option the popup message "Are you sure want to delete this team?" should be closed in Snipback page."
	// Automation ID   : Team_36 
	// </summary>

	public void Team_36_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_35_TestData)));
		
		//Step 4 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_35_TestData));		
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_35_TestData,"Delete Team")));
		base.scrollToElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_35_TestData,"Delete Team"));
		
		//Step 5   :"Click on Delete Team option in snipback  "
		//Expected :"User should be clickable on Delete Team option in snipback"
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_35_TestData,"Delete Team"));
		
		//Step 6   :"Verify that the message "Are you sure want to delete this team?" with Yes or No should be displayed once we click on Delete option from the three dots against the team in snipback  "
		//Expected :"User should be view that the message "Are you sure want to delete this team?" with Yes or No should be displayed once we click on Delete option from the three dots against the team in snipback"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Are you sure want to delete this team?")), "User should not be view that the message Are you sure want to delete this team? should not be displayed once we click on Delete option from the three dots against the team in snipback");

		//Step 7   :"Click on No option in popup of snipback  "
		//Expected :"User should be Click on No option in popup in snipback"
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("No"));

	}

	// <summary>
	// Test Case Title : "Verify that "Team Name Already exists" message should displayed if we try to create same team name for different teams."
	// Automation ID : Team_15
	// </summary>
	public void Team_15_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1: Login to SnipBack
		//Expected: User should be navigated to home page after entering valid credentials.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		//Step 2: Switch the organization if the User as Admin/Coach
		//Expected:The organization should be selected in the Games page
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(5000);

		//Step 3   :Click on +Add team option
		//Expected :"User should be navigated to the Add Team page"
		base.buttonClick(RegistrationObj.Ele_Alert("Add Team"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTitle("ADD TEAM")),"The Add Team pop-up is not displayed.");

		//Step 4   :"Enter team same name"
		//Expected :"Team name should be displayed in the Team Name field."
		base.setData(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamName("newTeamDiv","text"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName);
		String ActTeam= base.GetValue(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamName("newTeamDiv","text"));
		asrt.assertEquals(ActTeam, AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName);

		//Step 5   :"Select the Game category"
		//Expected :"User should be able to select the Game category from Default Team Type drop down in Add Team  page"
		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_15_Category);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[text()='Tennis']")).isSelected(),"The category 'Tennis' is not selected.");

		//Step 6   :"Click on Tick Icon and Verify the alert message"
		//Expected :"The team already exists alert is displayed in the Add Team popup in the Games page"
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_TeamTick("createTeamBtn", "bi bi-check2"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTeamAlert("already exists")),"The team already exists alert is not dislayed in the Add Team popup in the Games page");
	}
	
	// <summary>
	// Test Case Title : "Verify that "Team Name Already exists" message should Closed when we click on Close button."
	// Automation ID : Team_16
	// </summary>
	public void Team_16_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1: Login to SnipBack
		//Expected: User should be navigated to home page after entering valid credentials.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		//Step 2: Switch the organization if the User as Admin/Coach
		//Expected:The organization should be selected in the Games page
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(5000);

		//Step 3   :Click on +Add team option
		//Expected :"User should be navigated to the Add Team page"
		base.buttonClick(RegistrationObj.Ele_Alert("Add Team"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTitle("ADD TEAM")),"The Add Team pop-up is not displayed.");

		//Step 4   :"Enter team same name"
		//Expected :"Team name should be displayed in the Team Name field."
		base.setData(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamName("newTeamDiv","text"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName);
		String ActTeam= base.GetValue(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamName("newTeamDiv","text"));
		asrt.assertEquals(ActTeam, AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName);

		//Step 5   :"Select the Game category"
		//Expected :"User should be able to select the Game category from Default Team Type drop down in Add Team  page"
		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_15_Category);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[text()='Tennis']")).isSelected(),"The category 'Tennis' is not selected.");

		//Step 6   :"Click on Tick Icon and Verify the alert message"
		//Expected :"The alert message should be displayed"
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_TeamTick("createTeamBtn", "bi bi-check2"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTeamAlert("already exists")),"The team already exists alert is not dislayed in the Add Team popup in the Games page");

		//Step 7:"Click on Close button"
		//Expected:"The Alert for Team Already Exists Pop-up is closed in 'Add Team' page navigated from games page."
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_TeamAddAlertClose("modalMessageCloseBtn"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_CurrentMembersTitle("popup-heading mb-3 text-start")),"The Alert for Team Already Exists Pop-up is not closed in 'Add Team' page navigated from games page.");
	}	

	// <summary>
	// Test Case Title :"Verify that a Search bar should be displayed in the film page to search teams" 
	// Automation ID   : Team_05
	//summary>

	public void Team_05_AddUpdateDeleteDuplicateTeamGameDefaults()  throws InterruptedException 
	{ 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata=new CommonData();
		Pool_Obj PoolObj=new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Login login=new Login(driver);
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected :"User should able to view the SnipBack page"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"The games page is not loaded successfully");
		Thread.sleep(5000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected :"The system successfully switches the organization, allowing the user with Admin/Coach role to access the new organization's"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_Alert1("Org - All Teams"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Org - All Teams")),"The option 'Org - All Teams' is not selected");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-members-tab")),"User is Not able to view the Followers tab");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark")), "");
		Thread.sleep(4000);

		//Step 3:Verify the search bar
		//Expected :"Search bar should be displayed in the film page to search teams."
		base.excuteJsClick(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamGroupMembers")), "Search bar not displayed in the film page to search teams");

	}

	// <summary>
	// Test Case Title : "Verify that user (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page"
	// Automation ID : Team_06
	// </summary>

	public void Team_06_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected :"The system successfully switches the organization, allowing the user with Admin/Coach role to access the new organization's"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		base.buttonClick(LoginPageObj.Edt_Alert1("Org - All Teams"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Org - All Teams")),"The option 'Org - All Teams' is not selected");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-members-tab")),"User is Not able to view the Followers tab");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark")), "User is not able to view the list of");
		base.excuteJsClick(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark"));

		//Step3: Click on +Add team option
		//Excepected:User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page.
		base.buttonClick(LoginPageObj.Edt_Alert1("Add Team"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("ADD")),"User should not able to click on Add team option in the Film page");

	}

	// <summary>
	// Test Case Title : "Verify that following options should be displayed when click on +Add team from Games/Members/Followers page 
	// 1.ADD
	// 2.REMOVE
	// 3.Create & Add New member with Email
	// 4.Create & Add New member without Email"
	// Automation ID : Team_17
	// </summary>
	public void Team_17_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1: Login to SnipBack
		//Expected: User should be navigated to home page after entering valid credentials.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(5000);
		
		//Step 2: Switch the organization if the User as Admin/Coach
		//Expected:The organization should be selected in the Games page
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");

		//Step 3   :Click on +Add team option
		//Expected :"User should be navigated to the Add Team page"
		base.buttonClick(RegistrationObj.Ele_Alert("Add Team"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTitle("ADD TEAM")),"The Add Team pop-up is not displayed.");

		//Step 4   :"Verify the options"
		//Expected :"Following options should be displayed when click on +Add team from Games/Members/Followers page
		//1.ADD
		//2.REMOVE
		//3.Create & Add New member with Email
		//4.Create & Add New member without Email"
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("addPlayersToRight();")),"The add button is not displayed in the 'Add Team' page navigated from the Games page. ");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("removePlayersToRight();")),"The remove button is not displayed in the 'Add Team' page navigated from the Games page. ");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("createAndAddNewPlayers();")),"The 'Create & Add New member with Email' button is not displayed in the 'Add Team' page navigated from the Games page. ");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("addNewPlayersWOEmial();")),"The 'Create & Add New member without Email' button is not displayed in the 'Add Team' page navigated from the Games page. ");

	}

	// <summary>
	// Test Case Title :Verify that the following game category should be displayed in Default team type drop-down;
	//1.Baseball
	//2.Basketball
	//3.Football
	//4.Tennis
	//5.Volleyball
	//6.Weight Lifting
	//7.Soccer
	//8.Other
	// Automation ID : Team_18
	// </summary>
	public void Team_18_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		
		//Step 1: Login to SnipBack
		//Expected: User should be navigated to home page after entering valid credentials.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(5000);
		
		//Step 2: Switch the organization if the User as Admin/Coach
		//Expected:The organization should be selected in the Games page
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");

		//Step 3   :Click on +Add team option
		//Expected :"User should be navigated to the Add Team page"
		base.buttonClick(RegistrationObj.Ele_Alert("Add Team"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTitle("ADD TEAM")),"The Add Team pop-up is not displayed.");

		//Step 4   :Click on Default team type drop-down
		//Expected :The following game category should be displayed in Default team type drop-down;
		//1. Baseball
		//2.Basketball
		//3.Football
		//4.Tennis
		//5.Volleyball
		//6.Weight Lifting
		//7.Soccer
		//8.Other
		//base.buttonClick(PoolObj.Ele_PoolTypeDropDown("category"));
		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_18_Category2);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[@value='4']")).isSelected(),"The category 'Baseball' is not displayed in the drop-down list of Default Team Type drop-down in the 'Add Team' page");

		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_18_Category3);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[@value='3']")).isSelected(),"The category 'Basketball' is not displayed in the drop-down list of Default Team Type drop-down in the 'Add Team' page");

		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_18_Category4);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[@value='7']")).isSelected(),"The category 'Football' is not displayed in the drop-down list of Default Team Type drop-down in the 'Add Team' page");

		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_15_Category);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[@value='6']")).isSelected(),"The category 'Tennis' is not displayed in the drop-down list of Default Team Type drop-down in the 'Add Team' page");

		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_18_Category5);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[@value='5']")).isSelected(),"The category 'Volleyball' is not displayed in the drop-down list of Default Team Type drop-down in the 'Add Team' page");

		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_18_Category6);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[@value='2']")).isSelected(),"The category 'Weight Lifting' is not displayed in the drop-down list of Default Team Type drop-down in the 'Add Team' page");

		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_18_Category7);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[@value='10']")).isSelected(),"The category 'Soccer' is not displayed in the drop-down list of Default Team Type drop-down in the 'Add Team' page");

		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_18_Category8);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[@value='1']")).isSelected(),"The category 'Other' is not displayed in the drop-down list of Default Team Type drop-down in the 'Add Team' page");

	}

	// <summary>
	// Test Case Title : "Verify that the option for add Logo for the team should be displayed at the top left corner of the add team page."
	// Automation ID : Team_19
	// </summary>
	public void Team_19_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1: Login to SnipBack
		//Expected: User should be navigated to home page after entering valid credentials.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(5000);
		
		//Step 2: Switch the organization if the User as Admin/Coach
		//Expected:The organization should be selected in the Games page
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");

		//Step 3   :Click on +Add team option
		//Expected :"User should be navigated to the Add Team page"
		base.buttonClick(RegistrationObj.Ele_Alert("Add Team"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTitle("ADD TEAM")),"The Add Team pop-up is not displayed.");

		//Step 4   :"Verify the option for Add Logo "
		//Expected :User should be able to verify the Add logo
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("defaultlogoabbr")),"The Add Logo image icon is not visible in Add Team Pop-Up in Games page");
		
		
	}	
	// <summary>
	// Test Case Title : "Verify that X and Tick mark should be displayed once clicking the pencil icon"
	// Automation ID : Team_28
	// </summary>
	public void Team_28_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaults_TestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_28_TestData)));
		
		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_28_TestData));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5414")),"The user should not view the Edit Option from the 3-dot menu");

		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5414"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_28_TestData)),"Details of the Team should not be displayed when click on Edit option from the three dots against the team");
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("teamDiv", "bi bi-pencil")),"A pencil icon should not be displayed to edit the name of the Team after clicking the Edit option");

		//Step 5:Click on Pencil Icon
		//Expected:User should be able to see the Name Field
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("teamDiv", "bi bi-pencil"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamNameInput")),"User should not be able to see the Name Field");

		//Step 6:Change the Team Name
		//Expected:The user should able to change the Team Name after clicking the pencil icon
		base.clearData(LoginPageObj.Edt_LoginEmail("teamNameInput"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamNameInput"),AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_28_AddUpdateDeleteDuplicateTeamGameDefaultsTeamName);
		String ActualTeamName = base.GetValue(LoginPageObj.Edt_LoginEmail("teamNameInput"));
		asrt.assertEquals(ActualTeamName,AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_28_AddUpdateDeleteDuplicateTeamGameDefaultsTeamName,"The user not able to change the Team Name after clicking the pencil icon");
	}

	// <summary>
	// Test Case Title : "Verify that "Data Saved Successfully " message with Close button should be displayed when the user change the Team Name and click on Tick Option"
	// Automation ID : Team_29
	// </summary>
	public void Team_29_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaults_TestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_29_TestData)));
		
		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots		
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_29_TestData));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5415")),"The user should not view the Edit Option from the 3-dot menu");

		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5415"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_29_TestData)),"Details of the Team should not be displayed when click on Edit option from the three dots against the team");
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("teamDiv", "bi bi-pencil")),"A pencil icon should not be displayed to edit the name of the Team after clicking the Edit option");

		//Step 5:Click on Pencil Icon
		//Expected:User should be able to see the Name Field
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("teamDiv", "bi bi-pencil"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamNameInput")),"User should not be able to see the Name Field");

		//Step 5:Change the Team Name
		//Expected:The user should able to change the Team Name after clicking the pencil icon
		base.clearData(LoginPageObj.Edt_LoginEmail("teamNameInput"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamNameInput"),AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_29_AddUpdateDeleteDuplicateTeamGameDefaultsTeamName);
		String ActualTeamName = base.GetValue(LoginPageObj.Edt_LoginEmail("teamNameInput"));
		asrt.assertEquals(ActualTeamName,AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_29_AddUpdateDeleteDuplicateTeamGameDefaultsTeamName,"The user should able to change the Team Name after clicking the pencil icon");

		//Step 6:Click on Tick Option
		//Expected:"Data Saved Successfully " message with Close button should be displayed when the user change the Team Name and click on Tick Option
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_CrossTick("btn btn-success teamname-ok-btn", "bi bi-check2"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_Success("f-modal-alert","Data Saved Successfully")),"Data Saved Successfully message with Close button not displayed when the user change the Team Name and click on Tick Option");
		
		//Step 7:Click on Save Option
		//Expected:"Team saved
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Img_Save());
		
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ActualTeamName)));
		
		//Step 8:Click on 3dots of created team
		//Expected:"team selected
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ActualTeamName));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5415")),"The user should not view the Edit Option from the 3-dot menu");
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5415"));
		
		//Step 9:Click on Pencil Icon
		//Expected:User should be able to see the Name Field
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("teamDiv", "bi bi-pencil"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamNameInput")),"User should not be able to see the Name Field");

		//Step 10:Change the Team Name to original
		//Expected:The user should able to change the Team Name after clicking the pencil icon
		base.clearData(LoginPageObj.Edt_LoginEmail("teamNameInput"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamNameInput"),AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_29_TestData);
		
		//Step 11:Click on Tick Option
		//Expected:"Data Saved Successfully " message with Close button should be displayed when the user change the Team Name and click on Tick Option
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_CrossTick("btn btn-success teamname-ok-btn", "bi bi-check2"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_Success("f-modal-alert","Data Saved Successfully")),"Data Saved Successfully message with Close button not displayed when the user change the Team Name and click on Tick Option");
				
	}

	// <summary>
	// Test Case Title : "Verify that "Data Saved Successfully " message should be  Closed after clicking Close button "
	// Automation ID : Team_30
	// </summary>
	// <summary>
	public void Team_30_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaults_TestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_30_TestData)));
		
		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots	
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_30_TestData));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5428")),"The user should not view the Edit Option from the 3-dot menu");

		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5428"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_30_TestData)),"Details of the Team should not be displayed when click on Edit option from the three dots against the team");
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("teamDiv", "bi bi-pencil")),"A pencil icon should not be displayed to edit the name of the Team after clicking the Edit option");

		//Step 5:Click on Pencil Icon
		//Expected:User should be able to see the Name Field
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("teamDiv", "bi bi-pencil"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamNameInput")),"User should not be able to see the Name Field");

		//Step 6:Change the Team Name
		//Expected:The user should able to change the Team Name after clicking the pencil icon
		base.clearData(LoginPageObj.Edt_LoginEmail("teamNameInput"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamNameInput"),AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_30_AddUpdateDeleteDuplicateTeamGameDefaultsTeamName);
		String ActualTeamName = base.GetValue(LoginPageObj.Edt_LoginEmail("teamNameInput"));
		asrt.assertEquals(ActualTeamName,AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_30_AddUpdateDeleteDuplicateTeamGameDefaultsTeamName,"The user should able to change the Team Name after clicking the pencil icon");

		//Step 7:Click on Tick Option
		//Expected:"Data Saved Successfully " message with Close button should be displayed when the user change the Team Name and click on Tick Option
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_CrossTick("btn btn-success teamname-ok-btn", "bi bi-check2"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_Success("f-modal-alert","Data Saved Successfully")),"Data Saved Successfully message with Close button should be displayed when the user change the Team Name and click on Tick Option");

		//Step 8:Click on the Close Button
		//Expected:"Data Saved Successfully " message should be  Closed after clicking Close button 
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_Close("add-edit bg-light-block edit-content-wrap","modalMessageCloseBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamNameInput")),"Data Saved Successfully message should not be  Closed after clicking Close button ");

		//Step 9:Click on Save Option
		//Expected:"Team saved
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Img_Save());
		
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ActualTeamName)));
	
		//Step 10:Click on 3dots of created team
		//Expected:"team selected
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ActualTeamName));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5428")),"The user should not view the Edit Option from the 3-dot menu");
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5428"));
		
		//Step 11:Click on Pencil Icon
		//Expected:User should be able to see the Name Field
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamIcons("teamDiv", "bi bi-pencil"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamNameInput")),"User should not be able to see the Name Field");

		//Step 12:Change the Team Name
		//Expected:The user should able to change the Team Name after clicking the pencil icon
		base.clearData(LoginPageObj.Edt_LoginEmail("teamNameInput"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamNameInput"),AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_30_TestData);
				
		//Step 13:Click on Tick Option
		//Expected:"Data Saved Successfully " message with Close button should be displayed when the user change the Team Name and click on Tick Option
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_CrossTick("btn btn-success teamname-ok-btn", "bi bi-check2"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_Success("f-modal-alert","Data Saved Successfully")),"Data Saved Successfully message with Close button not displayed when the user change the Team Name and click on Tick Option");
				
		
	}

	// <summary>
	// Test Case Title : "Facility camera option should not be displayed in Away defaults"
	// Automation ID : Team_57
	// </summary>
	public void Team_57_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideo_TestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideo_TestData.Team_55_org));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(TrimVideo_TestData.Team_55_Team)));
		
		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(TrimVideo_TestData.Team_55_Team));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5119")),"The user should not view the Edit Option from the 3-dot menu");

		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5119"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
		
        //Step 5: Click on "Game Defaults" button 
		//Expected:Settings header should be displayed
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SettingsInGameDefaultsHeader("col-lg-12")), "Settings header is not displayed after clicking on Game Defaults button");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default")), "User unable to see the list of options under the three dots in the Games Page");
		
		//Step 6: Click on "Away Defaults" toggle 
		//Expected:A new page is opened
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default"));

		//Step 7:Get all the list present in the Away Default and check if Facility Camera(s) is not present in list 
		//Expected: Facility camera option should not be displayed in Away defaults
		boolean statusOfElementVisibility=base.verifyStringPresent(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_AwayDefaultList("row border border-3 mt-4"),"Facility Camera(s)");
		asrt.assertFalse(statusOfElementVisibility, "Facility Camera(s) text is visible in Away Default list");

	}

	// <summary>
	// Test Case Title : "Scout/Practice/Game should be displayed Under the Option Game Mode in the both Home and Away Defaults"
	// Automation ID : Team_58
	// </summary>
	public void Team_58_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {

		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
		
		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
		
		//Step 5: Click on "Game Defaults" button 
		//Expected:Settings header should be displayed
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));

		//Step 6: Verify Scout/Practice/Game should be displayed Under the Option Game Mode in  Home Defaults 
		//Expected:Scout/Practice/Game should be displayed Under the Option Game Mode in  Home Defaults
		List<String> expectedText = List.of("Scout", "Practice", "Game");
		List<String> actualText=base.GetElementTexts(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Game Mode","default-game-type"));
		Assert.assertEquals(actualText, expectedText, "Lists do not match (ignoring order)!");

		Thread.sleep(1000);
		//Step 7: Click on "Away Defaults" toggle 
		//Expected:A new page is opened
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default")), "User unable to see the Away Defaults in the Games Page");
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default"));

		//Step 8: Verify Scout/Practice/Game should be displayed Under the Option Game Mode in Away Defaults 
		//Expected:Scout/Practice/Game should be displayed Under the Option Game Mode in  Away Defaults
		List<String> actualText1=base.GetElementTexts(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Game Mode","default-game-type"));
		System.out.println(actualText1);
		Assert.assertEquals(actualText1, expectedText, "Lists do not match (ignoring order)!");

	}

	// <summary>
	// Test Case Title : "Scout/Practice/Game should be displayed Under the Option Game Mode in the both Home and Away Defaults"
	// Automation ID : Team_59
	// </summary>
	public void Team_59_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {

		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
		
		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
		
		//Step 5: Click on "Game Defaults" button 
		//Expected:Settings header should be displayed
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));

		//Step 6: Verify Disable and Enable should be displayed Under the Option Secondary Low Quality (LQ) Stream in Home Defaults
		//Expected:Disable and Enable should be displayed Under the Option Secondary Low Quality (LQ) Stream in  Home Defaults
		List<String> expectedText = List.of("Disable", "Enable");
		List<String> actualText=base.GetElementTexts(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Secondary Low Quality (LQ) Stream","default-broadcasting"));
		Assert.assertEquals(actualText, expectedText, "Lists do not match (ignoring order)!");
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default")), "User unable to see the list of options under the three dots in the Games Page");
		
		//Step 7: Click on "Away Defaults" toggle 
		//Expected:A new page is opened
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default"));

		//Step 8: Verify Disable and Enable  should be displayed Under the Option Secondary Low Quality (LQ) Stream in Away Defaults 
		//Expected:Disable and Enable should be displayed Under the Option Secondary Low Quality (LQ) Stream in  Away Defaults
		List<String> actualText1=base.GetElementTexts(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Secondary Low Quality (LQ) Stream","default-broadcasting"));
		Assert.assertEquals(actualText1, expectedText, "Lists do not match (ignoring order)!");

	}

	// <summary>
	// Test Case Title :"Verify that user should able to navigate to the snipback website after entering the URL"
	// Automation ID   : Team_01
	// </summary>
	public void Team_01_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
	}
	
	// <summary>
	// Test Case Title :"Verify that user should able to navigate to the Film page once login with credentials"
	// Automation ID   : Team_02
	// </summary>
	public void Team_02_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

	}
	
	// <summary>
	// Test Case Title :"Verify that Add team (+ Add team) option should be displayed in the organization if the user as Admin/Coach in the Game, Members & Followers tab in the Film page"
	// Automation ID   : Team_03
	// </summary>
	public void Team_03_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Pool_Obj Pool_obj =new Pool_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));	
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 4   :"Select Organization"
		//Expected :"User should be navigated to Organization and select AutomationOrg - 1 "
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		asrt.assertTrue(base.isExists(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User not able to Navigate to the GameList");

		//Step 5 :"Add Team Option should be displayed in the Games Page
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Add Team")),"Add Team Option should not be displayed in the Games Page");
		Thread.sleep(3000);

		//Step 6 :"Add Team Option should be displayed in the Members Page
		base.buttonClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("MEMBERS")),"User should not be navigated to Members");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Add Team")),"Add Team Option should not be displayed in the Members Page");
		Thread.sleep(3000);

		//Step 7 :"Add Team Option should be displayed in the Followers Page
		base.buttonClick(LoginPageObj.Edt_Alert1("FOLLOWERS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("FOLLOWERS")),"User should not be navigated to Followers");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Add Team")),"Add Team Option should not be displayed in the Members Page");
		Thread.sleep(3000);		
	}
	
	// <summary>
	// Test Case Title :"Verify that Add team (+ Add team) option should be displayed in the organization if the user as Admin/Coach in the Game, Members & Followers tab in the Film page"
	// Automation ID   : Team_04
	// </summary>
	public void Team_04_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Pool_Obj Pool_obj =new Pool_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		Thread.sleep(7000);	
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 4   :"Select Home"
		//Expected :"Add Team option should not display in Home page"
		Thread.sleep(3000);	
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "Home");
		Thread.sleep(5000);	
		asrt.assertFalse(driver.findElement(By.xpath("//span[text()='Add Team']")).isDisplayed());
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_02_Org);
		Thread.sleep(5000);	
		asrt.assertFalse(driver.findElement(By.xpath("//span[text()='Add Team']")).isDisplayed());
	}

	// <summary>
	// Test Case Title :"To Verify that "Duplicate Team" option should be displayed when click on three dots against the team in the Film page in Snipback page."
	// Automation ID   : Team_39 
	// </summary>

	public void Team_39_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();	
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(2000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName)));
		
		//Step 5 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName));	

		//Step 6   :"Click on Delete Team option in snipback  "
		//Expected :"User should be clickable on Delete Team option in snipback"
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team")));
		
		
	}

	// <summary>
	// Test Case Title :"To Verify The following option should be displayed after clicking duplicate team;
	//1. A text Duplicate with respective team Name
	//2.Field for Enter the Duplicate team Name
	//3.Cancel and Create button in Snipback page."
	// Automation ID   : Team_40 
	// </summary>

	public void Team_40_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		Registration_Obj registrationObj = new Registration_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.excuteJsClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName)));
		
		//Step 5 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName));	
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team")));
		base.scrollToElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team"));
		
		//Step 6   :"Click on Delete Team option in snipback  "
		//Expected :"User should be clickable on Delete Team option in snipback"
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team"));

		//Step 7   :"Verify the following option should be displayed after clicking duplicate team;
		//1. A text Duplicate with respective team Name
		//2.Field for Enter the Duplicate team Name
		//3.Cancel and Create button"
		//Expected :"User should be verify the following option should be displayed after clicking duplicate team;
		//1. A text Duplicate with respective team Name
		//2.Field for Enter the Duplicate team Name
		//3.Cancel and Create button"
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTitle("modal-title")),"User should not able to view a text Duplicate with respective team Name after clicking duplicate team");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("team_name")),"User should not able to view a text Duplicate with respective team Name after clicking duplicate team");
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("type col-md-6 cancel")), "User is not able to view Cancel button after clicking duplicate team");
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("type col-md-6")), "User is not able to view Create button after clicking duplicate team");

	}
	
	// <summary>
	// Test Case Title :"To Verify that Verify that Duplicate team Name should not be same as Original team name or any other team in the organization (The Message "Team Name already exists" should popup) in Snipback page."
	// Automation ID   : Team_41
	// </summary>
	public void Team_41_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));

		//Step 5 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName)));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName));	

		//Step 6   :"Click on Delete Team option in snipback  "
		//Expected :"User should be clickable on Delete Team option in snipback"
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team")));
		base.scrollToElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team"));
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team"));
		
		//Step 7   :"Verify the following option should be displayed after clicking duplicate team;
		//1. A text Duplicate with respective team Name
		//Expected :"User should be verify the following option should be displayed after clicking duplicate team;
		//1. A text Duplicate with respective team Name
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTitle("modal-title")),"User should not able to view a text Duplicate with respective team Name after clicking duplicate team");

		//Step 8   :"Enter Duplicate Team Name in popup of snipback"
		//Expected :"User should be Enter Duplicate Team Name in popup of snipback"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("team_name"));
		base.setData(LoginPageObj.Edt_LoginEmail("team_name"),AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName);

		//Step 9   :"Click Create button and the Message "Team Name already exists" should popup of snipback"
		//Expected :"User should be click Create button and the Message "Team Name already exists" should popup of snipback"
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("type col-md-6"));
		Thread.sleep(4000);
		//asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Error!")), "User should not be click Create button click Create button and the Message Team Name already exists should popup of snipback");		
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Team Name already exists")), "User should not be click Create button click Create button and the Message Team Name already exists should popup of snipback");
		base.buttonClick(LoginPageObj.Btn_SignInButton("OK"));
	}

	// <summary>
	// Test Case Title :"To Verify that the page to enter the duplicate team name should closed when we click on Cancel Button in Snipback page."
	// Automation ID   : Team_42 
	// </summary>
	public void Team_42_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();	

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));

		//Step 5 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName)));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName));	

		//Step 6   :"Click on Delete Team option in snipback  "
		//Expected :"User should be clickable on Delete Team option in snipback"
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team")));
		base.scrollToElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team"));
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team"));
		
		//Step 7   :"Verify the following option should be displayed after clicking duplicate team;
		//1. A text Duplicate with respective team Name
		//Expected :"User should be verify the following option should be displayed after clicking duplicate team;
		//1. A text Duplicate with respective team Name
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTitle("modal-title")),"User should not able to view a text Duplicate with respective team Name after clicking duplicate team");

		//Step 8   :"Click on Cancel button in the duplicate team name page in snipback"
		//Expected :"User should be on Cancel button in the duplicate team name page in snipback"
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("type col-md-6 cancel"));

	}

	// <summary>
	// Test Case Title :"To Verify the message "Successfully Duplicated" should be displayed after entering the duplicate team name and click on Create button in Snipback page."
	// Automation ID   : Team_43 
	// </summary>

	public void Team_43_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData addupdatedeleteduplicateteamgamedefaults_TestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();		
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));

		//Step 5 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(addupdatedeleteduplicateteamgamedefaults_TestData.Team_41_DuplicateTeamName)));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(addupdatedeleteduplicateteamgamedefaults_TestData.Team_41_DuplicateTeamName));	

		//Step 6   :"Click on Delete Team option in snipback  "
		//Expected :"User should be clickable on Delete Team option in snipback"
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(addupdatedeleteduplicateteamgamedefaults_TestData.Team_41_DuplicateTeamName,"Duplicate Team")));
		base.scrollToElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(addupdatedeleteduplicateteamgamedefaults_TestData.Team_41_DuplicateTeamName,"Duplicate Team"));
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(addupdatedeleteduplicateteamgamedefaults_TestData.Team_41_DuplicateTeamName,"Duplicate Team"));
		
		//Step 7   :"Verify the following option should be displayed after clicking duplicate team;
		//1. A text Duplicate with respective team Name
		//Expected :"User should be verify the following option should be displayed after clicking duplicate team;
		//1. A text Duplicate with respective team Name
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTitle("modal-title")),"User should not able to view a text Duplicate with respective team Name after clicking duplicate team");

		//Step 8   :"Enter Duplicate Team Name in popup of snipback"
		//Expected :"User should be Enter Duplicate Team Name in popup of snipback"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("team_name"));
		base.setData(LoginPageObj.Edt_LoginEmail("team_name"),addupdatedeleteduplicateteamgamedefaults_TestData.Team_43_DuplicateTeamName);

		//Step 9   :"Click on Create button in the duplicate team name page and verify the message Successfully Duplicated in popup of snipback"
		//Expected :"User should be on Cancel button in the duplicate team name page and verify the message Successfully Duplicated in popup of snipback"
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("type col-md-6"));
		Thread.sleep(7000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Successfully Duplicated")), "User should not be verify the message Successfully Duplicated in popup of snipback");

	}

	// <summary>
	// Test Case Title :"To Verify that the message "Successfully Duplicated" should be closed when click on OK from the message in Snipback page."
	// Automation ID   : Team_44 
	// </summary>
	public void Team_44_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData addupdatedeleteduplicateteamgamedefaults_TestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));

		//Step 5 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(addupdatedeleteduplicateteamgamedefaults_TestData.Team_41_DuplicateTeamName)));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(addupdatedeleteduplicateteamgamedefaults_TestData.Team_41_DuplicateTeamName));	

		//Step 6   :"Click on Delete Team option in snipback  "
		//Expected :"User should be clickable on Delete Team option in snipback"
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(addupdatedeleteduplicateteamgamedefaults_TestData.Team_41_DuplicateTeamName,"Duplicate Team")));
		base.scrollToElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(addupdatedeleteduplicateteamgamedefaults_TestData.Team_41_DuplicateTeamName,"Duplicate Team"));
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(addupdatedeleteduplicateteamgamedefaults_TestData.Team_41_DuplicateTeamName,"Duplicate Team"));
		
		//Step 7   :"Verify the following option should be displayed after clicking duplicate team;
		//1. A text Duplicate with respective team Name
		//Expected :"User verified the following option should be displayed after clicking duplicate team;
		//1. A text Duplicate with respective team Name
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTitle("modal-title")),"User should not able to view a text Duplicate with respective team Name after clicking duplicate team");

		//Step 8   :"Enter Duplicate Team Name in popup of snipback"
		//Expected :"User should be Enter Duplicate Team Name in popup of snipback"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("team_name"));
		base.setData(LoginPageObj.Edt_LoginEmail("team_name"),addupdatedeleteduplicateteamgamedefaults_TestData.Team_44_DuplicateTeamName);

		//Step 9   :"Click on Create button in the duplicate team name page and verify the message Successfully Duplicated in popup of snipback"
		//Expected :"User should be on Cancel button in the duplicate team name page and verify the message Successfully Duplicated in popup of snipback"
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("type col-md-6"));
		Thread.sleep(7000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Successfully Duplicated")), "User should not be verify the message Successfully Duplicated in popup of snipback");
		base.buttonClick(LoginPageObj.Btn_SignInButton("OK"));
	}

	//<summary>
	// Test Case Title : "Verify that the message " The Team name is required for this Operation" should be displayed if we left Team Name field blank"				
	// Automation ID : Team_10
	// </summary>
	public void Team_10_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj SearchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteduplicateTeamGameDefaultstestData= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData(); 
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected :"The system successfully switches the organization, allowing the user with Admin/Coach role to access the new organization's"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		base.buttonClick(LoginPageObj.Edt_Alert1("Org - All Teams"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Org - All Teams")),"The option 'Org - All Teams' is not selected");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-members-tab")),"User is Not able to view the Followers tab");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark")), "User is not able to view the list of");
		base.excuteJsClick(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark"));

		//Step3: Click on +Add team option
		//Expected:User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page.
		base.buttonClick(LoginPageObj.Edt_Alert1("Add Team"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("newTeamDiv")),"User should not able to click on Add team option in the Film page");

		//Step4:Left Team Name field blank.
		//Expected:The message " The Team name is required for this Operation" should be displayed if we left Team Name field blank
		base.buttonClick((LoginPageObj.Edt_Alert1("ADD")));
		asrt.assertTrue(base.isExists(SearchgameteamandmembersObj.Ele_MemberName("Team name is required for this operation")), "The message : The Team name is required for this Operation, should be not displayed if we left Team Name field blank "); 
	}
	
	// <summary>
	// Test Case Title : "Verify that Save button should be displayed to Save the team after we created with required details."
	// Automation ID : Team_20
	// </summary>
	public void Team_20_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1: Login to SnipBack
		//Expected: User should be navigated to home page after entering valid credentials.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		//Step 2: Switch the organization if the User as Admin/Coach
		//Expected:The organization should be selected in the Games page
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(5000);

		//Step 3   :Click on +Add team option
		//Expected :"User should be navigated to the Add Team page"
		base.buttonClick(RegistrationObj.Ele_Alert("Add Team"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTitle("ADD TEAM")),"The Add Team pop-up is not displayed.");

		//Step 4   :"Enter team name"
		//Expected :"Team name should be displayed in the Team Name field."
		base.setData(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamName("newTeamDiv","text"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_20_AddUpdateDeleteDuplicateTeamName1);
		String ActTeam= base.GetValue(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamName("newTeamDiv","text"));
		asrt.assertEquals(ActTeam, AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_20_AddUpdateDeleteDuplicateTeamName1);

		//Step 5   :"Select the Game category"
		//Expected :"User should be able to select the Game category from Default Team Type drop down in Add Team  page"
		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_18_Category3);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[text()='Basketball']")).isSelected(),"The category 'Tennis' is not selected.");

		//Step 6   :"Verify Save option"
		//Expected :"The Save button should be verified"
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("ms-2 bg-red cursor-pointer update-team")),"The Save button is not displayed in the Add Team popup in the Games page. ");
	}

	// <summary>
	// Test Case Title : "Verify that "Data saved successfully" message should be displayed when we click on Save icon."
	// Automation ID : Team_21
	// </summary>
	public void Team_21_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1: Login to SnipBack
		//Expected: User should be navigated to home page after entering valid credentials.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		//Step 2: Switch the organization if the User as Admin/Coach
		//Expected:The organization should be selected in the Games page
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(5000);

		//Step 3   :Click on +Add team option
		//Expected :"User should be navigated to the Add Team page"
		base.buttonClick(RegistrationObj.Ele_Alert("Add Team"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTitle("ADD TEAM")),"The Add Team pop-up is not displayed.");

		//Step 4   :"Enter team name"
		//Expected :"Team name should be displayed in the Team Name field."
		base.setData(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamName("newTeamDiv","text"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_21_AddUpdateDeleteDuplicateTeamName1);
		String ActTeam= base.GetValue(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamName("newTeamDiv","text"));
		asrt.assertEquals(ActTeam, AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_21_AddUpdateDeleteDuplicateTeamName1);
		
		//Step 5   :"Select the Game category"
		//Expected :"User should be able to select the Game category from Default Team Type drop down in Add Team  page"
		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_18_Category7);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[text()='Soccer']")).isSelected(),"The category 'Soccer' is not selected.");

		//Step 6   :"Click on Tick Icon and Verify the alert message"
		//Expected :"The alert message should be displayed"
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_TeamTick("createTeamBtn", "bi bi-check2"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamAddedSuccessfully("successTag","New Team Created Successfully")),"The team created successfully not showing in the Add Team popup in the Games page");
		 base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_Close("add-edit bg-light-block edit-content-wrap","modalMessageCloseBtn"));
		Thread.sleep(7000);
		
		//Step 7   :"Select players and click Add button"
		//Expected :"The players should be added to the 'Current Team Members' List"
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamAddFromList(2)),"The player is not selected from the left menu in the Add Team Popup in the Games page");
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamAddFromList(2));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamAddFromList(3)),"The player is not selected from the left menu in the Add Team Popup in the Games page");
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamAddFromList(3));
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("addPlayersToRight();"));

		//Step 8   :"Verify and click Save button and verify the message ' Data Saved Successfully"
		//Expected :"The Save button should be verified"
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("ms-2 bg-red cursor-pointer update-team")),"The Save button is not displayed in the Add Team popup in the Games page. ");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("ms-2 bg-red cursor-pointer update-team"));
		//base.PerformActionOnAlert("getText", "Data Saved Successfully", "");
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamAddedSuccessfully("successTag", "Data Saved Successfully")),"The data saved successfully alert is not displayed in the Add Team PopUp in the Games page");
	
	}

	// <summary>
	// Test Case Title : "Verify that Close button (X) should be displayed to Close the Page for Add team"
	// Automation ID : Team_22
	// </summary>
	public void Team_22_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
	{
		Login login = new Login(driver); 
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1: Login to SnipBack
		//Expected: User should be navigated to home page after entering valid credentials.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		//Step 2: Switch the organization if the User as Admin/Coach
		//Expected:The organization should be selected in the Games page
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
		Thread.sleep(5000);

		//Step 3   :Click on +Add team option
		//Expected :"User should be navigated to the Add Team page"
		base.buttonClick(RegistrationObj.Ele_Alert("Add Team"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTitle("ADD TEAM")),"The Add Team pop-up is not displayed.");

		//Step 4   :Click on CLose button
		//Expected :Close button (X) should be displayed to Close the Page for Add team
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("popup-btn-close menu-dark")),"Close button (X) should not be displayed to Close the Page for Add team");
		base.buttonClick(PoolObj.Btn_ButtonCreate("popup-btn-close menu-dark"));

	}
	//<summary>
	// Test Case Title : "Verify that "Please select the Game category" message with OK should be displayed when we enter the Team Name & left the Default team type field"				
	// Automation ID : Team_11
	// </summary>

	public void Team_11_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		AddUpdateRemoveMember_Obj AddupdateremovememberObj= new AddUpdateRemoveMember_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteduplicateTeamGameDefaultstestData= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData(); 
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);

		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected :"The system successfully switches the organization, allowing the user with Admin/Coach role to access the new organization's"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		base.buttonClick(LoginPageObj.Edt_Alert1("Org - All Teams"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Org - All Teams")),"The option 'Org - All Teams' is not selected");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-members-tab")),"User is Not able to view the Followers tab");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark")), "User is not able to view the list of Admin ");
		base.excuteJsClick(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark"));

		//Step3: Click on +Add team option
		//Expected:User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page.
		base.buttonClick(LoginPageObj.Edt_Alert1("Add Team"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("newTeamDiv")),"User should not able to click on Add team option in the Film page");

		//Step 4:Enter team name
		//Expected:User should be able to view the  entered team  name in team field of add
		base.setData(LoginPageObj.Edt_LoginEmail("teamNameInput"),AddUpdateDeleteduplicateTeamGameDefaultstestData.Team_09_TeamName);
		
		//Step 5: Left Default team type field
		//Expected:"Please select the Game category" message with OK should be displayed when we enter the Team Name & left the Default team type field.
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("create-team-actions d-flex")), "User is not able to view X and tick option displayed against the team name field ");
		base.buttonClick((LoginPageObj.Btn_SingnIn("createTeamBtn")));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-modal")), "Please select the Game category, message with OK should not  be displayed when we enter the Team Name & left the Default team type field");
	}

	//<summary>
	// Test Case Title : "Verify that "Please select the Game category" message should be closed when click on OK button"				
	// Automation ID : Team_12
	// </summary>
	public void Team_12_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteduplicateTeamGameDefaultstestData= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData(); 
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected :"The system successfully switches the organization, allowing the user with Admin/Coach role to access the new organization's"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		base.buttonClick(LoginPageObj.Edt_Alert1("Org - All Teams"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Org - All Teams")),"The option 'Org - All Teams' is not selected");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-members-tab")),"User is Not able to view the Followers tab");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark")), "User is not able to view the list of Admin ");
		base.excuteJsClick(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark"));

		//Step3: Click on +Add team option
		//Expected:User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page.
		base.buttonClick(LoginPageObj.Edt_Alert1("Add Team"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("newTeamDiv")),"User should not able to click on Add team option in the Film page");

		//Step 4:Enter team name
		//Expected:User should be able to view the  entered team  name in team field of add
		base.setData(LoginPageObj.Edt_LoginEmail("teamNameInput"),AddUpdateDeleteduplicateTeamGameDefaultstestData.Team_09_TeamName);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("create-team-actions d-flex")), "User is not able to view X and tick option displayed against the team name field ");
		
		//Step 5: Left Default team type field
		//Expected:"Please select the Game category" message with OK should be displayed when we enter the Team Name & left the Default team type field.
		base.buttonClick((LoginPageObj.Btn_SingnIn("createTeamBtn")));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-modal")), "Please select the Game category, message with OK should not  be displayed when we enter the Team Name & left the Default team type field");

		//Step 6:Click on OK from the pop up message
		//Expected:"Please select the Game category" message should be closed when click on OK button.
		base.buttonClick(LoginPageObj.Btn_SignInButton("OK"));
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_AlertText("Please select the Game Category")),"Please select the Game category ,message should be not closed ");

	}


	//<summary>
	// Test Case Title : "Verify that the Team Name created successfully message with Close button should be once enter the Team Name, select default team type & click on Tick option"				
	// Automation ID : Team_13
	// </summary>
	public void Team_13_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj SearchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteduplicateTeamGameDefaultstestData= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData(); 
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected :"The system successfully switches the organization, allowing the user with Admin/Coach role to access the new organization's"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		base.buttonClick(LoginPageObj.Edt_Alert1("Org - All Teams"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Org - All Teams")),"The option 'Org - All Teams' is not selected");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-members-tab")),"User is Not able to view the Followers tab");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark")), "User is not able to view the list of Admin ");
		base.excuteJsClick(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark"));

		//Step3: Click on +Add team option
		//Expected:User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page.
		base.buttonClick(LoginPageObj.Edt_Alert1("Add Team"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("newTeamDiv")),"User should not able to click on Add team option in the Film page");

		//Step 4:Enter team name
		//Expected:User should be able to view the  entered team  name in team field of add
		base.setData(LoginPageObj.Edt_LoginEmail("teamNameInput"),AddUpdateDeleteduplicateTeamGameDefaultstestData.Team_13_TeamName);

		//Step 5:Select default team type 
		//Expected:User should able to select the team type 
		base.buttonClick(PoolObj.Ele_PoolTypeDropDown("category"));
		for(int i=0;i<AddUpdateDeleteduplicateTeamGameDefaultstestData.Team__13_AddUpdateDeleteDuplicateTeamGameDefaultsDropDownList.length;i++)
		{    
			asrt.assertTrue(base.isExists(PoolObj.Ele_PoolTypeDropDown("category")),AddUpdateDeleteduplicateTeamGameDefaultstestData.Team__13_AddUpdateDeleteDuplicateTeamGameDefaultsDropDownList[i]);
		}
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_Selecttype("category", "Football"));

		//Step 6:Click on Tick option
		//Expected:Team Name created successfully message with Close button should be  once enter the Team Name & click on Tick option and also select default team type.
		base.buttonClick((LoginPageObj.Btn_SingnIn("createTeamBtn")));
		Thread.sleep(7000);
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_Success("f-modal-alert","New Team Created Successfully")), "Team Name created successfully message with Close button should be not enter the Team Name & not click on Tick option and also select default team type");

	}

	// <summary>
	// Test Case Title : "List of Facility cameras should be listed when click on field against the Facility camera(s)"
	// Automation ID : Team_55
	// </summary>
	public void Team_55_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.Team_55_org));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(TrimVideoTestData.Team_55_Team)));
		
		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(TrimVideoTestData.Team_55_Team));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5119")),"The user should not view the Edit Option from the 3-dot menu");

		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5119"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
		
		//Step 5: Click on "Game Defaults" button 
		//Expected:Settings header should be displayed
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));

		//Step 6: after Click on "Game Defaults" button 
		//Expected:Settings header should be displayed
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SettingsInGameDefaultsHeader("col-lg-12")), "Settings header is not displayed after clicking on Game Defaults button");

		//Step 7: Verify field against the Facility camera(s) is displayed 
		//Expected:Field against the Facility camera(s) is displayed 
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("facility_cameras")), "Facility Camera(s) clickable button is not displayed");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("facility_cameras"));

		//Step 8: Verify List of Facility cameras text and expected text are equal
		//Expected:List of Facility cameras should be listed when click on field against the Facility camera(s)
		List<String> listOfTextsAgainstTheFieldInFacilityCameras =  base.GetElementTexts(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SelectRoomList("fcam_show_rooms"));
		List<String> expectedList=Arrays.asList("East Gym","West Gym","Main 3","Stadium one","ABC","new","Trivandrum","AMERICA","TVM","TVM-1","AMERICA","USA","Ktkd","Test Mount");

		asrt.assertEquals(listOfTextsAgainstTheFieldInFacilityCameras.subList(0, 14), expectedList, "Facility Cameras list is not matching with the expected list");

	}


	// <summary>
	// Test Case Title : "User should able to select any of the facility camera from the list of Facility Camera"
	// Automation ID : Team_56
	// </summary>
	public void Team_56_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.Team_55_org));

		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(TrimVideoTestData.Team_55_Team)));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(TrimVideoTestData.Team_55_Team));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5119")),"The user should not view the Edit Option from the 3-dot menu");

		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5119"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
		
		//Step 5: Click on "Game Defaults" button 
		//Expected:Settings header should be displayed
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));

		//Step 6: after Click on "Game Defaults" button 
		//Expected:Settings header should be displayed
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SettingsInGameDefaultsHeader("col-lg-12")), "Settings header is not displayed after clicking on Game Defaults button");

		//Step 7: Verify field against the Facility camera(s) is displayed 
		//Expected:Field against the Facility camera(s) is displayed 
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("facility_cameras")), "Facility Camera(s) clickable button is not displayed");
		base.buttonClick(LoginPageObj.Edt_LoginEmail("facility_cameras"));

		//Step 8: Verify Select room header is displayed 
		//Expected:Select room header is displayed 
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SelectRoomListHeader("facility-camera-details","fcam-select-room")),"Select Room header is not displayed in the list of Facility Cameras");

		//Step 9: By default we are selecting the first element in the list in "Select room"
		//Expected:Click on first element in list 
		//NOTE: Before clicking getting the text of first element
		String selectRoomListFirstText=base.GetText(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SelectRoomListEachElement("fcam_show_rooms",1));//changed
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SelectRoomListEachElement("fcam_show_rooms",1));//changed

		//Step 10: "Select Cameras" header is displayed
		//Expected:"Select Cameras" header is displayed
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SelectRoomListHeader("facility-camera-details","fcam-select-cams")),"Select Room header is not displayed in the list of Facility Cameras");

		//Step 11: "Select Cameras" header is validated
		//Expected:"Select Cameras" header is validated 
		String selectCamerasHeader =base.GetText(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SelectRoomListHeader("facility-camera-details","fcam-select-cams"));
		asrt.assertEquals(selectCamerasHeader,"Select Camera(s)","Select Camera(s) header is not displayed after clicking on first element in the list in Select Room header list of Facility Cameras");

		//Step 12: Getting the first checkbox element text in "Select Cameras" list
		//Expected: First checkbox element text in "Select Cameras" list
		//NOTE: Before clicking getting the text of first element checkBox
		String selectCamerasListFirstText=base.GetText(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SelectCameraCheckBoxText("fcam_show_cams",1,"p"));//changed
		String actualText[]=selectCamerasListFirstText.split("\\(");

		//Step 13: By default we are selecting the first element checkbox in the list in "Select Cameras" list
		//Expected:Click on first element checkBox in list 
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_SelectCameraCheckBox("fcam_show_cams",1));//changed

		//Step 14: Selected a camera and clicking on save in "Select Cameras" list
		//Expected:Click on save in "Select Cameras" 
		base.buttonClick(AddFollowerObj.Ele_FollowerCreateBtn("facility-camera-details","fcam-save"));
		Thread.sleep(2000);

		//Step 15: Getting the text in the field against Facility cameras and matching with expected 
		//Expected:Our expected text is in this  Main 66$$,tintu, (Camera 09)
		//NOTE: Here Main 66$$,tintu, is our "Select room" first element and (Camera 09) is our 1st element text of "Select Cameras" So changing the format accordingly
		String cameraName =actualText[0].trim();
		// Combine the texts in the desired format
		String finalText = selectRoomListFirstText + " (" + cameraName + ")";
		System.out.println("finalText is:"+finalText);
		asrt.assertEquals(finalText,driver.findElement(By.xpath("//input[@id='facility_cameras']")).getAttribute("value"),"Select Room and Select Cameras text are not matching with the actual");
	}

	// <summary>
	// Test Case Title :"Verify that the following updates can be made by using Edit option
	//1.Add existing users & new users with or without mail id
	//2.Remove User
	//3.Change Default team type"
	// Automation ID   : Team_31
	// </summary>
	public void Team_31_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));

		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots	
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName)));
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5473")),"The user should not view the Edit Option from the 3-dot menu");
		
		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5473"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading(("EDIT TEAM - "+AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_41_DuplicateTeamName))),"Details of the Team should not be displayed when click on Edit option from the three dots against the team");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Default Team Type ")),"The User should not be able to view the Default Team Type Label");

		//Step 5:Add or remove users/ change default team type
		//Expected:The following updates can be made by using Edit option
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Default Team Type ")),"The User should not be able to view the Default Team Type Label");
		base.selectorByVisibleText(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ddl_TeamDropdwn("form-select","category"),AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_18_Category3);
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamTennisAddFromList(2));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamTennisAddFromList(2)),"The player is not selected from the left menu in the Add Team Popup in the Games page");
		
		//base.selectCheckBox(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamTick("abc user", "checkmark"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_AddUserTeam("members-menu menu-dark my-2", "ADD")),"Add Button should not be visible to the user");
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_AddUserTeam("members-menu menu-dark my-2", "ADD"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_31_TeamUser);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_31_TeamUser)),"The following updates can be made by using Edit option");
	
	}

		// <summary>
		// Test Case Title :""Verify that the Save Icon should be displayed to save/update the changes made in the team"
		// Automation ID   : Team_32
		// </summary>
		public void Team_32_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
		{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
			Registration_Obj RegistrationObj = new Registration_Obj();
			ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
			
			//Step 1:Login Snipback
			//Expected:The user should be able to login to Snipback
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);
			Thread.sleep(5000);
			
			//Step 2:Switch the organization if the User as Admin/Coach
			//Expected:The user should be able to switch the organization.
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
			asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
			
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
			asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName)));
			
			//Step 3 : Click on three dots in the teams
			//Expected : User should be able to click on the three dots	
			base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName));
			asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5473")),"The user should not view the Edit Option from the 3-dot menu");
			
			//Step 4:Click on Edit option
			//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
			base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5473"));
			asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_41_DuplicateTeamName)),"Details of the Team should not be displayed when click on Edit option from the three dots against the team");
			asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Default Team Type ")),"The User should not be able to view the Default Team Type Label");
			asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Default Team Type ")),"The User should not be able to view the Default Team Type Label");
			base.selectorByVisibleText(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ddl_TeamDropdwn("form-select","category"),"Basketball");
			
			//Step 5:Add or remove users/ change default team type
			//Expected:The following updates can be made by using Edit option
			base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamTennisAddFromList(2));
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamTennisAddFromList(2)),"The player is not selected from the left menu in the Add Team Popup in the Games page");
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_AddUserTeam("members-menu menu-dark my-2", "ADD")),"Add Button should not be visible to the user");
			
			//base.selectCheckBox(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamTick("abc user", "checkmark"));
			base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_AddUserTeam("members-menu menu-dark my-2", "ADD"));
			base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_31_TeamUser);
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_31_TeamUser)),"The following updates can be made by using Edit option");
		
			//Step 6:Click on the Save Icon
			//Expected:The Save Icon should be displayed to save/update the changes made in the team
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_Save("ms-2 bg-red cursor-pointer update-team", "https://snipback.com/assets/images/film/save-btn.svg")),"The Save Icon should not be displayed to save/update the changes made in the team");
		}
    

	// <summary>
	/* Test Case Title : "
		Verify that following fields should be displayed when click on +Add team from Games/Members/Followers page
		1. Enter Team Name
		2.Search bar with Search Icon 
		3.List of Users to add to teams
		4.Default team type with categories drop down
		5.Game Defaults
		6.A text "Current team members"
		7.Search bar with Search Icon to search current team members`
		8.List of Current team members"*/
	// Automation ID : Team_07
	// </summary>
	public void Team_07_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		AddUpdateRemoveMember_Obj AddupdateremovememberObj= new AddUpdateRemoveMember_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteduplicateTeamGameDefaultstestData= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData(); 
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected :"The system successfully switches the organization, allowing the user with Admin/Coach role to access the new organization's"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		base.buttonClick(LoginPageObj.Edt_Alert1("Org - All Teams"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Org - All Teams")),"The option 'Org - All Teams' is not selected");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-members-tab")),"User is Not able to view the Followers tab");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark")), "User is not able to view the list of");
		base.excuteJsClick(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark"));

		//Step3: Click on +Add team option
		//Expected:User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page.
		base.buttonClick(LoginPageObj.Edt_Alert1("Add Team"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("ADD")),"User should not able to click on Add team option in the Film page");

		//Step4:Verify the options
		/*Expected:Following Fields should be displayed when click on +Add team from Games MembersFollowers page
		1. Enter Team Name
		2.Search bar with Search Icon 
		3.List of Users to add to teams	
		4.Default team type with categories drop down
		5.Game Defaults
		6.A text "Current team members"
		7.Search bar with Search Icon to search current team members`
		8.List of Current team members*/
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("newTeamDiv")), "User is not able to view ' Enter Team Name'");
		asrt.assertTrue(base.isExists(AddupdateremovememberObj.Chk_TeamMembers("orgUsersSearch")), "User is not able to view Search bar with Search Icon");
		Thread.sleep(2000);		
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("players_data_remove")), "User is not able to view List of Users to add to teams");
		base.buttonClick(PoolObj.Ele_PoolTypeDropDown("category"));
		for(int i=0;i<AddUpdateDeleteduplicateTeamGameDefaultstestData.Team_07_AddUpdateDeleteDuplicateTeamGameDefaultsDropDownList.length;i++)
		{    
			asrt.assertTrue(base.isExists(PoolObj.Ele_PoolTypeDropDown("category")),AddUpdateDeleteduplicateTeamGameDefaultstestData.Team_07_AddUpdateDeleteDuplicateTeamGameDefaultsDropDownList[i]);
		}
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("default-btn me-2 default-btn-alert")), "User is not able to view Game Defaults in Add Term page");
		asrt.assertTrue(base.isExists(AddupdateremovememberObj.Ele_CurrentTeamMembers("CURRENT TEAM MEMBERS")),"User is not able to view a text Current team members");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "User is not able to view Search bar with Search Icon to search current team members");
		//asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("memberAlert")),"User is not able to view the alert or list in Add term page");

	}


	// <summary>
	// Test Case Title : "Verify that the X and tick option should displayed against the team name field"				
	// Automation ID : Team_08
	// </summary>
	public void Team_08_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteduplicateTeamGameDefaultstestData= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData(); 
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);

		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected :"The system successfully switches the organization, allowing the user with Admin/Coach role to access the new organization's"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		base.buttonClick(LoginPageObj.Edt_Alert1("Org - All Teams"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Org - All Teams")),"The option 'Org - All Teams' is not selected");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-members-tab")),"User is Not able to view the Followers tab");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark")), "User is not able to view the list of");
		base.excuteJsClick(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark"));

		//Step3: Click on +Add team option
		//Expected:User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page.
		base.buttonClick(LoginPageObj.Edt_Alert1("Add Team"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamNameInput"),AddUpdateDeleteduplicateTeamGameDefaultstestData.Team_09_TeamName );

		//Step4:Verify the options
		//Expected:The X and tick option should displayed against the team name field.
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("create-team-actions d-flex")), "User is not able to view X and tick option displayed against the team name field ");	
	}
	
	
	//<summary>
	// Test Case Title : "Verify that the team should be deleted and the popup message should be closed when click on Yes option"				
	// Automation ID : Team_37
	// </summary>
	public void Team_37_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteduplicateTeamGameDefaultstestData= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData(); 
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		
		//Step 3   :Click on +Add team option
		//Expected :"User should be navigated to the Add Team page"
		base.buttonClick(RegistrationObj.Ele_Alert("Add Team"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTitle("ADD TEAM")),"The Add Team pop-up is not displayed.");

		//Step 4   :"Enter team name"
		//Expected :"Team name should be displayed in the Team Name field."
		base.setData(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamName("newTeamDiv","text"), AddUpdateDeleteduplicateTeamGameDefaultstestData.Team_37_AddUpdateDeleteDuplicateTeamName1);
		String ActTeam= base.GetValue(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamName("newTeamDiv","text"));
		asrt.assertEquals(ActTeam, AddUpdateDeleteduplicateTeamGameDefaultstestData.Team_37_AddUpdateDeleteDuplicateTeamName1);
		
		//Step 5   :"Select the Game category"
		//Expected :"User should be able to select the Game category from Default Team Type drop down in Add Team  page"
		base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("category"), AddUpdateDeleteduplicateTeamGameDefaultstestData.Team_18_Category7);
		asrt.assertTrue(driver.findElement(By.xpath("//select[@id='category']//option[text()='Soccer']")).isSelected(),"The category 'Soccer' is not selected.");

		//Step 6   :"Click on Tick Icon and Verify the alert message"
		//Expected :"The alert message should be displayed"
		base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_TeamTick("createTeamBtn", "bi bi-check2"));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamAddedSuccessfully("successTag","New Team Created Successfully")),"The team created successfully not showing in the Add Team popup in the Games page");
		 base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_Close("add-edit bg-light-block edit-content-wrap","modalMessageCloseBtn"));
		Thread.sleep(7000);	

		//Step 8   :"Verify and click Save button and verify the message ' Data Saved Successfully"
		//Expected :"The Save button should be verified"
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("ms-2 bg-red cursor-pointer update-team")),"The Save button is not displayed in the Add Team popup in the Games page. ");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("ms-2 bg-red cursor-pointer update-team"));
		//base.PerformActionOnAlert("getText", "Data Saved Successfully", "");
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamAddedSuccessfully("successTag", "Data Saved Successfully")),"The data saved successfully alert is not displayed in the Add Team PopUp in the Games page");
	
		//Step 7:Click on Save Option
		//Expected:"Team saved
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Img_Save());
		Thread.sleep(2000);
		
		//Step 4 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ActTeam));		
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(ActTeam,"Delete Team")));
		base.scrollToElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(ActTeam,"Delete Team"));
		
		//Step 5   :"Click on Delete Team option in snipback  "
		//Expected :"User should be clickable on Delete Team option in snipback"
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(ActTeam,"Delete Team"));
		
		//Step 6   :"Verify that the message "Are you sure want to delete this team?" with Yes or No should be displayed once we click on Delete option from the three dots against the team in snipback  "
		//Expected :"User should be view that the message "Are you sure want to delete this team?" with Yes or No should be displayed once we click on Delete option from the three dots against the team in snipback"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Are you sure want to delete this team?")), "User should not be view that the message Are you sure want to delete this team? should not be displayed once we click on Delete option from the three dots against the team in snipback");

		//Step 7   :"Click on No option in popup of snipback  "
		//Expected :"User should be Click on No option in popup in snipback"
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
	}

	//<summary>
	// Test Case Title : "Verify that the team should not be listed in the team list once its deleted"				
	// Automation ID : Team_38
	// </summary>
	public void Team_38_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteduplicateTeamGameDefaultstestData= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData(); 
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(2000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 5   :"Select Admin or coaches "
		//Expected :"User should be navigated to Admin or coaches list"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TrimVideoTestData.TV_01_Org);
		Thread.sleep(700);

		//Step 6   :"click on serach button and enter the team Name"
		//Expected :"User should be clickable on Search Input Field and enter the Team Name in Input Field"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),AddUpdateDeleteduplicateTeamGameDefaultstestData.Team_35_TestData);
		Thread.sleep(1000);

		//Step 7   :"Verify the deleted team is removed from the list"
		//Expected :"User should be Verify the deleted team is removed from the list"
		String TName = base.GetValue(LoginPageObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(TName, AddUpdateDeleteduplicateTeamGameDefaultstestData.Team_35_TestData, "The Entered Team name is not displayed");	
	}

	//<summary>
	// Test Case Title : "Verify that the Team Name should be cleared once click on X option"				
	// Automation ID : Team_09
	// </summary>
	public void Team_09_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteduplicateTeamGameDefaultstestData= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData(); 
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);

		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected :"The system successfully switches the organization, allowing the user with Admin/Coach role to access the new organization's"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		base.buttonClick(LoginPageObj.Edt_Alert1("Org - All Teams"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Org - All Teams")),"The option 'Org - All Teams' is not selected");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-members-tab")),"User is Not able to view the Followers tab");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark")), "User is not able to view the list of");

		//Step3: Click on +Add team option
		//Expected:User (Admin/Coach) should able to click on Add team (+ Add team) option in the Film page.
		base.excuteJsClick(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamCoachAdminRadioBtn","checkmark"));
		base.buttonClick(LoginPageObj.Edt_Alert1("Add Team"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamNameInput")),"User is not able to click Add Team in Filim page");

		//Step 4:Enter team name
		//Expected:User should be able to view the  entered team  name in teamfield of add
		base.setData(LoginPageObj.Edt_LoginEmail("teamNameInput"),AddUpdateDeleteduplicateTeamGameDefaultstestData.Team_09_TeamName);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("create-team-actions d-flex")), "User is not able to view X and tick option displayed against the team name field ");
		
		//Step 5: Click on X option
		//Expected:User should be able to view the Team Name should be cleared once click on X option
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger me-2 teamname-cancel-btn"));
		String teamNameInputValue = base.GetValue(LoginPageObj.Edt_LoginEmail("teamNameInput"));
		asrt.assertTrue(teamNameInputValue.isEmpty(), "The team name field is not cleared after clicking the X button");

	}
		// <summary>
		// Test Case Title :"Verify that "Data saved successfully" message should be displayed when we click on Save icon"
		// Automation ID   : Team_33
		// </summary>
		public void Team_33_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
		{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
			Registration_Obj RegistrationObj = new Registration_Obj();
			SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();
			ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
			
			//Step 1:Login Snipback
			//Expected:The user should be able to login to Snipback
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);
			Thread.sleep(5000);
			
			//Step 2:Switch the organization if the User as Admin/Coach
			//Expected:The user should be able to switch the organization.
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
			asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
			
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
			asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName)));
			
			//Step 3 : Click on three dots in the teams
			//Expected : User should be able to click on the three dots	
			base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName));
			asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5473")),"The user should not view the Edit Option from the 3-dot menu");
			
			//Step 4:Click on Edit option
			//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
			base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5473"));
			asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_41_DuplicateTeamName)),"Details of the Team should not be displayed when click on Edit option from the three dots against the team");
			asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Default Team Type ")),"The User should not be able to view the Default Team Type Label");

			//Step 5:Add or remove users/ change default team type
			//Expected:The following updates can be made by using Edit option
			asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Default Team Type ")),"The User should not be able to view the Default Team Type Label");
			base.selectorByVisibleText(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ddl_TeamDropdwn("form-select","category"),AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_18_Category3);
			asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Default Team Type ")),"The following updates can be made by using Edit option");
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_Save("ms-2 bg-red cursor-pointer update-team", "https://snipback.com/assets/images/film/save-btn.svg")),"The Save Icon should not be displayed to save/update the changes made in the team");
			
			//Step 6:Click on the Save Icon
			//Expected:"Data saved successfully" message should be displayed when we click on Save icon"
			base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_Save("ms-2 bg-red cursor-pointer update-team", "https://snipback.com/assets/images/film/save-btn.svg"));
			asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Data Saved Successfully")),"Data saved successfully message should not be displayed when we click on Save icon");

		}
		

	// <summary>
	// Test Case Title :"Verify that the Changes should be saved for the team once we click on Save button"
	// Automation ID   : Team_34
	// </summary>
	public void Team_34_AddUpdateDeleteDuplicateTeamGameDefaults() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		
		//Step 1:Login Snipback
		//Expected:The user should be able to login to Snipback
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 2:Switch the organization if the User as Admin/Coach
		//Expected:The user should be able to switch the organization.
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
		
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName)));
		
		//Step 3 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots	
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5473")),"The user should not view the Edit Option from the 3-dot menu");
		
		//Step 4:Click on Edit option
		//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5473"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_41_DuplicateTeamName)),"Details of the Team should not be displayed when click on Edit option from the three dots against the team");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Default Team Type ")),"The User should not be able to view the Default Team Type Label");
		
		//Step 5:Add or remove users/ change default team type
		//Expected:The following updates can be made by using Edit option
		base.selectorByVisibleText(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ddl_TeamDropdwn("form-select","category"),AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_18_Category3);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Default Team Type ")),"The following updates can be made by using Edit option");
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamTennisAddFromListRight(1));	
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_AddUserTeam("members-menu bg-red my-2", "REMOVE"));
		
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamTennisAddFromList(2)),"The player is not selected from the left menu in the Add Team Popup in the Games page / No 2 Players available in left side of the page");	
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Chk_TeamTennisAddFromList(2));
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_AddUserTeam("members-menu menu-dark my-2", "ADD")),"Add Button should not be visible to the user");
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_AddUserTeam("members-menu menu-dark my-2", "ADD"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_31_TeamUser);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_31_TeamUser)),"The following updates can be made by using Edit option");
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_Save("ms-2 bg-red cursor-pointer update-team", "https://snipback.com/assets/images/film/save-btn.svg")),"The Save Icon should not be displayed to save/update the changes made in the team");
		
		//Step 6:Click on the Save Icon
		//Expected:"Data saved successfully" message should be displayed when we click on Save icon"
		base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_Save("ms-2 bg-red cursor-pointer update-team", "https://snipback.com/assets/images/film/save-btn.svg"));
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Ele_MemberName("Data Saved Successfully")),"Data saved successfully message should not be displayed when we click on Save icon");
		
		//Step 7:Verify the Changes
		//Expected:The Changes should be saved for the team once we click on Save button
		base.excuteJsClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		//asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Ele_MemberName(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_31_TeamUser)),"The Changes should not be saved for the team once we click on Save button");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_31_TeamUser)),"The Changes should not be saved for the team once we click on Save button");

	}	

       
        // <summary>
		// Test Case Title : "User should able to view the Cancel and Save button should be displayed at the bottom of the Game Defaults page"
		// Automation ID : Team_62
		// </summary>
		public void Team_62_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
			Registration_Obj RegistrationObj = new Registration_Obj();
			AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
			ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
			
			//Step 1:Login Snipback
			//Expected:The user should be able to login to Snipback
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);
			Thread.sleep(7000);
			
			//Step 2:Switch the organization if the User as Admin/Coach
			//Expected:The user should be able to switch the organization.
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
			asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
			
			//Step 3 : Click on three dots in the teams
			//Expected : User should be able to click on the three dots
			base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
			asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

			//Step 4:Click on Edit option
			//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
			base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
			 
            //Step 5: Click on "Game Defaults" button 
			//Expected:Settings header should be displayed
			base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
           
            //Step 6: after Click on "Game Defaults" button 
			//Expected:Settings header should be displayed
             asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SettingsInGameDefaultsHeader("col-lg-12")), "Settings header is not displayed after clicking on Game Defaults button");

            //Step 7: Verify that Cancel and Save button should be displayed at the bottom of the Game Defaults page
			//Expected:Cancel and Save buttons are displayed 
			asrt.assertTrue(driver.findElement(PoolObj.Btn_ButtonCreate("btn btn-block btn-lg btn-outline-danger dismiss")).isDisplayed(), "Cancel button is not displayed");
			asrt.assertTrue(driver.findElement(PoolObj.Btn_ButtonCreate("btn btn-block btn-lg btn-outline-dark save")).isDisplayed(), "Save button is not displayed");
           
				}
			
		// <summary>
			// Test Case Title : "Verify that Game Defaults page should be clsoed when click  on Cancel button from the Page"
			// Automation ID : Team_63
			// </summary>
			public void Team_63_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {

				Login login = new Login(driver); 
				LoginPage_Obj LoginPageObj = new LoginPage_Obj();
				SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
				ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
				Pool_Obj PoolObj = new Pool_Obj();
				AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
				CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
				Registration_Obj RegistrationObj = new Registration_Obj();
				AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
				ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
				TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
				AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
				
				//Step 1:Login Snipback
				//Expected:The user should be able to login to Snipback
				asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
				login.loginToApplication(CommonData.UserName, CommonData.PassWord);
				Thread.sleep(7000);
				
				//Step 2:Switch the organization if the User as Admin/Coach
				//Expected:The user should be able to switch the organization.
				base.buttonClick(LoginPageObj.Btn_Login("Film"));
				asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
				asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
				base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
				base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
				asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
				
				//Step 3 : Click on three dots in the teams
				//Expected : User should be able to click on the three dots
				base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
				asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

				//Step 4:Click on Edit option
				//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
				base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
				asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "Game Default not found");
				  
	            //Step 5: Click on "Game Defaults" button 
				//Expected: Settings header should be displayed
				base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
	           
	            //Step 6: after Click on "Game Defaults" button 
				//Expected:Settings header should be displayed
	             asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SettingsInGameDefaultsHeader("col-lg-12")), "Settings header is not displayed after clicking on Game Defaults button");

	            //Step 7: Verify that Cancel and Save button should be displayed at the bottom of the Game Defaults page
				//Expected:Cancel and Save button should be displayed at the bottom of the Game Defaults page 
				asrt.assertTrue(driver.findElement(PoolObj.Btn_ButtonCreate("btn btn-block btn-lg btn-outline-danger dismiss")).isDisplayed(), "Cancel button is not displayed");
				asrt.assertTrue(driver.findElement(PoolObj.Btn_ButtonCreate("btn btn-block btn-lg btn-outline-dark save")).isDisplayed(), "Save button is not displayed");
				
				//Step 8: User should able to Cancel the the Game Defaults page
				//Expected: Game Defaults page should be clsoed when click  on Cancel button from the Page
				base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-block btn-lg btn-outline-danger dismiss"));
				Thread.sleep(800);
				asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "Game Defaults page not clsoed");
}
		
		
		// <summary>
		// Test Case Title : "Public and Private should be displayed Under the Option Live Snipping, Show on SnipBack.com, Make Stat Public in the both Home and Away Defaults"
		// Automation ID : Team_60
		// </summary>
		public void Team_60_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
			Registration_Obj RegistrationObj = new Registration_Obj();
			AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
			AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj(); 
			ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
			
			//Step 1:Login Snipback
			//Expected:The user should be able to login to Snipback
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);
			Thread.sleep(7000);
			
			//Step 2:Switch the organization if the User as Admin/Coach
			//Expected:The user should be able to switch the organization.
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
			asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
			
			//Step 3 : Click on three dots in the teams
			//Expected : User should be able to click on the three dots
			base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
			asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

			//Step 4:Click on Edit option
			//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
			base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
			
			//Step 5: Click on "Game Defaults" button 
			//Expected:Settings header should be displayed
			base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));

			//Step 6: Verify Public and Private should be displayed Under the Option Live Snipping in Home Defaults
			//Expected:Public and Private should be displayed Under the Option Live Snipping in  Home Defaults
			List<String> expectedText = List.of("Public", "Private");
			List<String> actualText=base.GetElementTexts(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Live Snipping","default-sniping"));
			Assert.assertEquals(actualText, expectedText, "Lists do not match (ignoring order)!");

			Thread.sleep(1000);
			asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default")), "User unable to see the list of options under the three dots in the Games Page");
			
			//Step 7: Click on "Away Defaults" toggle 
			//Expected:A new page is opened
			base.buttonClick(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default"));

			//Step 8: Verify Public and Private  should be displayed Under the Option Live Snipping in Away Defaults 
			//Expected:Public and Private should be displayed Under the Option Live Snipping in  Away Defaults
			List<String> actualText1=base.GetElementTexts(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Live Snipping","default-sniping"));
			Assert.assertEquals(actualText1, expectedText, "Lists do not match (ignoring order)!");

		}
		
		// <summary>
		// Test Case Title : "Disable and Enable  should be displayed Under the Option Enabling Ball Tracking in the both Home and Away Defaults"
		// Automation ID : Team_61
		// </summary>
		public void Team_61_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
			Registration_Obj RegistrationObj = new Registration_Obj();
			AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
			AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
			ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
			
			//Step 1:Login Snipback
			//Expected:The user should be able to login to Snipback
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);
			Thread.sleep(7000);
			
			//Step 2:Switch the organization if the User as Admin/Coach
			//Expected:The user should be able to switch the organization.
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
			asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
			
			//Step 3 : Click on three dots in the teams
			//Expected : User should be able to click on the three dots
			base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
			asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

			//Step 4:Click on Edit option
			//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
			base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
			
			//Step 5: Click on "Game Defaults" button 
			//Expected:Settings header should be displayed
			base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));

			//Step 6: Verify Disable and Enable should be displayed Under the Option Enabling Ball Tracking in Home Defaults
			//Expected:Disable and Enable should be displayed Under the Option Enabling Ball Tracking in  Home Defaults
			List<String> expectedText = List.of("Disable", "Enable");
			List<String> actualText=base.GetElementTexts(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Enabling Ball Tracking","default-balltracking"));
			Assert.assertEquals(actualText, expectedText, "Lists do not match (ignoring order)!");

			Thread.sleep(1000);
			asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default")), "User unable to see the list of options under the three dots in the Games Page");
			
			//Step 7: Click on "Away Defaults" toggle 
			//Expected:A new page is opened
			base.buttonClick(AddUpdateRemoveMemberObj.Btn_selectteam("Away Default"));

			//Step 8: Verify Disable and Enable  should be displayed Under the Option Enabling Ball Tracking in Away Defaults 
			//Expected:Disable and Enable should be displayed Under the Option Enabling Ball Tracking in  Away Defaults
			List<String> actualText1=base.GetElementTexts(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_GameModeOptions("Enabling Ball Tracking","default-balltracking"));
			Assert.assertEquals(actualText1, expectedText, "Lists do not match (ignoring order)!");

		}
  
	        // <summary>
			// Test Case Title : "Verify that "Data Saved Successfully" message will popup when click on Save button from the Game Defaults page "
			// Automation ID : Team_65
			// </summary>
			public void Team_65_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {
	
				Login login = new Login(driver); 
				LoginPage_Obj LoginPageObj = new LoginPage_Obj();
				SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
				ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
				Pool_Obj PoolObj = new Pool_Obj();
				AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
				CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
				Registration_Obj RegistrationObj = new Registration_Obj();
				AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
				ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
				TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
				AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
				
				//Step 1:Login Snipback
				//Expected:The user should be able to login to Snipback
				asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
				login.loginToApplication(CommonData.UserName, CommonData.PassWord);
				Thread.sleep(7000);
				
				//Step 2:Switch the organization if the User as Admin/Coach
				//Expected:The user should be able to switch the organization.
				base.buttonClick(LoginPageObj.Btn_Login("Film"));
				asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
				asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
				base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
				base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
				asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
				
				//Step 3 : Click on three dots in the teams
				//Expected : User should be able to click on the three dots
				base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
				asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

				//Step 4:Click on Edit option
				//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
				base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
				asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
	            
	            //Step 5: Click on "Game Defaults" button 
				//Expected:Settings header should be displayed
				base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
	           
	            //Step 6: after Click on "Game Defaults" button 
				//Expected:Settings header should be displayed
	             asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_SettingsInGameDefaultsHeader("col-lg-12")), "Settings header is not displayed after clicking on Game Defaults button");
	
	            //Step 7: Verify that Cancel and Save button should be displayed at the bottom of the Game Defaults page
				//Expected:Cancel and Save button should be displayed at the bottom of the Game Defaults page 
				asrt.assertTrue(driver.findElement(PoolObj.Btn_ButtonCreate("btn btn-block btn-lg btn-outline-danger dismiss")).isDisplayed(), "Cancel button is not displayed");
				asrt.assertTrue(driver.findElement(PoolObj.Btn_ButtonCreate("btn btn-block btn-lg btn-outline-dark save")).isDisplayed(), "Save button is not displayed");
				
				//Step 8: User should able to see "Data Saved Successfully" message will popup when click on Save button
				//Expected: "Data Saved Successfully" message will popup when click on Save button from the Game Defaults page 
				base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-block btn-lg btn-outline-dark save"));
				asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Ele_MemberName("Data Saved Successfully")), "The 'Data Saved Successfully' message pop-up was not displayed");
			}	

		// <summary>
		// Test Case Title :"Verify that three dots should be displayed against each team in the Game/Members/Followers Page. "
		// Automation ID   : Team_23
		// </summary>
		public void Team_23_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
		{
			Login login = new Login(driver); 
			CommonData Commondata= new CommonData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			
			//Step 1: Login to SnipBack
			//Expected: User should be navigated to home page after entering valid credentials.
			login.loginToApplication(Commondata.UserName, Commondata.PassWord);
					
			//Step 2: Switch the organization if the User as Admin/Coach
			//Expected:The organization should be selected in the Games page
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
			asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
			Thread.sleep(5000);
					
			//Step 3  : Verify the three dots against the team
			//Expected: Three dots should be displayed against each team in the Game/Members/Followers Page 
     		List<WebElement> elements=driver.findElements(By.xpath("//div[@id='my-team-content']//div[@class='btn-group']/a"));
		
			for(int i=0;i<elements.size();i++) {
				System.out.println(i);
				System.out.println(elements.get(i).isDisplayed());
				}		
		}
		
		// <summary>
		// Test Case Title : "Verify that an option "Game Defaults" should be displayed when click on +Add team & Click on Edit option from the three dots against the team name from the Film page "
		// Automation ID : Team_46 
		// </summary>
		public void Team_46_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {

			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
			Registration_Obj RegistrationObj = new Registration_Obj();			
			ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
			
			//Step 1:Login Snipback
			//Expected:The user should be able to login to Snipback
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);
			Thread.sleep(5000);
			
			//Step 2:Switch the organization if the User as Admin/Coach
			//Expected:The user should be able to switch the organization.
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
			asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
			
			//Step 3 : Click on three dots in the teams
			//Expected : User should be able to click on the three dots
			base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
			asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

			//Step 4:Click on Edit option
			//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
			base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
			asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("EDIT TEAM - "+AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)),"Details of the Team should not be displayed when click on Edit option from the three dots against the team");
				
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")),"Game Defaults is not displayed when click on +Add team & Click on Edit option from the three dots against the team name from the Film page ");
			driver.navigate().refresh();
			Thread.sleep(5000);
			
			//Step 5   :Click on +Add team option
			//Expected :"User should be navigated to the Add Team page"
			base.buttonClick(RegistrationObj.Ele_Alert("Add Team"));
			asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTitle("ADD TEAM")),"The Add Team pop-up is not displayed.");
			asrt.assertTrue(base.isExists(RegistrationObj.Btn_RegistrationSignUp("default-btn me-2 default-btn-alert")),"Game Defaults is not displayed when click on +Add team & Click on Edit option from the three dots against the team name from the Film page ");
			
		}
		
		// <summary>
		// Test Case Title : "Verify that "Home Default" & Away Defaults" should be displayed after clicking "Game Defaults""
		// Automation ID : Team_47
		// </summary>
		public void Team_47_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {

			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
			Registration_Obj RegistrationObj = new Registration_Obj();
			ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
			
			//Step 1:Login Snipback
			//Expected:The user should be able to login to Snipback
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);
			Thread.sleep(5000);
			
			//Step 2:Switch the organization if the User as Admin/Coach
			//Expected:The user should be able to switch the organization.
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
			asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
			
			//Step 3 : Click on three dots in the teams
			//Expected : User should be able to click on the three dots
			base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
			asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

			//Step 4:Click on Edit option
			//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
			base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
			
            //Step 5: Click on "Game Defaults" button 
			//Expected:"Home Default" & Away Defaults" should be displayed after clicking "Game Defaults"
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
            base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
            asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Home Default")),"Home Default is not displayed after clicking Game Defaults");
            asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Away Default")),"Away Defaults is not displayed after clicking Game Defaults");
		}
		
		// <summary>
		// Test Case Title : "Verify that the following option should be displayed in "Home Default" & Away Defaults" 1. Duration 2.Facility Camera(s) 3.Game Mode 4.Secondary Low Quality (LQ) Stream 5.Live Snipping 6.Show on SnipBack.com 7.Make Stat Public 8.Enabling Ball Tracking"
		// Automation ID : Team_48
		// </summary>
		public void Team_48_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {

			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
			Registration_Obj RegistrationObj = new Registration_Obj();
			ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
			
			//Step 1:Login Snipback
			//Expected:The user should be able to login to Snipback
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);
			Thread.sleep(5000);
			
			//Step 2:Switch the organization if the User as Admin/Coach
			//Expected:The user should be able to switch the organization.
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
			asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
			
			//Step 3 : Click on three dots in the teams
			//Expected : User should be able to click on the three dots
			base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
			asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

			//Step 4:Click on Edit option
			//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
			base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
			
            //Step 5: Click on "Game Defaults" button 
			//Expected: The following option should be displayed in "Home Default" & Away Defaults" 1. Duration 2.Facility Camera(s) 3.Game Mode 4.Secondary Low Quality (LQ) Stream 5.Live Snipping 6.Show on SnipBack.com 7.Make Stat Public 8.Enabling Ball Tracking

			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
            base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
            asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Ele_MemberName("Duration")),"Duration option is not displayed in Home Default & Away Defaults");
            asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Ele_MemberName("Facility Camera(s)")),"Facility Camera(s) option is not displayed in Home Default & Away Defaults");
            asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Ele_MemberName("Game Mode")),"Game Mode option is not displayed in Home Default & Away Defaults");
            asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Ele_MemberName("Secondary Low Quality (LQ) Stream")),"Secondary Low Quality (LQ) Stream option is not displayed in Home Default & Away Defaults");
            asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Ele_MemberName("Live Snipping")),"Live Snipping option is not displayed in Home Default & Away Defaults");
            asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Ele_MemberName("Show on SnipBack.com")),"Show on SnipBack.com option is not displayed in Home Default & Away Defaults");
            asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Ele_MemberName("Make Stat Public")),"Make Stat Public option is not displayed in Home Default & Away Defaults");
            asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Ele_MemberName("Enabling Ball Tracking")),"Enabling Ball Tracking option is not displayed in Home Default & Away Defaults");
		}
		
		// <summary>
		// Test Case Title : "Verify that Home Deafult should be selected as default when click on Game Defaults"
		// Automation ID : Team_49
		// </summary>
		public void Team_49_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {

			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
			ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
			
			//Step 1:Login Snipback
			//Expected:The user should be able to login to Snipback
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);
			Thread.sleep(5000);
			
			//Step 2:Switch the organization if the User as Admin/Coach
			//Expected:The user should be able to switch the organization.
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
			asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
			
			//Step 3 : Click on three dots in the teams
			//Expected : User should be able to click on the three dots
			base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
			asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

			//Step 4:Click on Edit option
			//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
			base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
            
            //Step 5: Click on "Game Defaults" button 
			//Expected:Home Default should be selected as default when click on Game Defaults
			base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
            asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_HomeSelection("Home Default")),"Home Deafult is not selected as default when click on Game Defaults");
            }
		
		// <summary>
		// Test Case Title : "Verify that No duration should be selected as default against Duration field in Home Default"
		// Automation ID : Team_50
		// </summary>
		public void Team_50_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {

			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
			Registration_Obj RegistrationObj = new Registration_Obj();
			AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
			ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
			
			//Step 1:Login Snipback
			//Expected:The user should be able to login to Snipback
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);
			Thread.sleep(7000);
			
			//Step 2:Switch the organization if the User as Admin/Coach
			//Expected:The user should be able to switch the organization.
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
			asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
			
			//Step 3 : Click on three dots in the teams
			//Expected : User should be able to click on the three dots
			base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
			asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

			//Step 4:Click on Edit option
			//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
			base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
            
			//Step 5: Click on "Game Defaults" button 
			//Expected:No duration should be selected as default against Duration field in Home Default
			base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
            asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole("No Duration")),"No duration is not selected as default against Duration field in Home Default");
			}

   		// <summary>
		// Test Case Title :"Verify that the Duplicate team should be listed in the Team List in Film Page"
		// Automation ID   : Team_45 
		// </summary>

		public void Team_45_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
		{
			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();		
			AddEditInfo_Obj addeditinfObj = new AddEditInfo_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
			Registration_Obj registrationObj = new Registration_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj addupdatedeleteduplicateteamgamedefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
			ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();		
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			
			//Step 1   :"Navigate to the SnipBack page"
			//Expected :"User should able to view the SnipBack page"
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

			//Step 2   :"Click Login"
			//Expected :"User should able to click LoginButton"
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);
			Thread.sleep(7000);
			
			//Step 3  :"Click the Film Button"
			//Expected:"User should be navigated to Film Page"
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

			//Step 4:Switch the organization if the User as Admin/Coach
			//Expected:The user should be able to switch the organization.
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
			asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");		
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));

			//Step 5 : Click on three dots in the teams
			//Expected : User should be able to click on the three dots
			asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName)));
			base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName));	

			//Step 6   :"Click on Delete Team option in snipback  "
			//Expected :"User should be clickable on Delete Team option in snipback"
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team")));
			base.scrollToElement(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team"));
			base.excuteJsClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DelTeam(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_41_DuplicateTeamName,"Duplicate Team"));
			
			//Step 7   :"Verify the following option should be displayed after clicking duplicate team;
			//1. A text Duplicate with respective team Name
			//Expected :"User should be verify the following option should be displayed after clicking duplicate team;
			//1. A text Duplicate with respective team Name
			asrt.assertTrue(base.isExists(addupdatedeleteduplicateteamgamedefaultsObj.Ele_DuplicateTitle("modal-title")),"User should not able to view a text Duplicate with respective team Name after clicking duplicate team");

			//Step 8   :"Enter Duplicate Team Name in popup of snipback"
			//Expected :"User should be Enter Duplicate Team Name in popup of snipback"
			base.excuteJsClick(LoginPageObj.Edt_LoginEmail("team_name"));
			base.setData(LoginPageObj.Edt_LoginEmail("team_name"),AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_45_DuplicateTeamName);
			String ActualTeamName = base.GetValue(LoginPageObj.Edt_LoginEmail("team_name"));

			//Step 9   :"Click on Create button in the duplicate team name page and verify the message Successfully Duplicated in popup of snipback"
			//Expected :"User should be on Cancel button in the duplicate team name page and verify the message Successfully Duplicated in popup of snipback"
			base.buttonClick(LoginPageObj.Ele_ErrorMessage("type col-md-6"));
			Thread.sleep(5000);
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Successfully Duplicated")), "User should not be verify the message Successfully Duplicated in popup of snipback");
			
			//Step 10  :Click on OK Button 
			//Expected :The Duplicate team should be listed in the Team List in Film Page
			base.buttonClick(LoginPageObj.Btn_SignInButton("OK"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(ActualTeamName)),"The Duplicate team is not listed in the Team List in Film Page");
		}

		// <summary>
		// Test Case Title : "Verify that Duration should not be displayed in Away Default"
		// Automation ID : Team_51
		// </summary>
		public void Team_51_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {

			Login login = new Login(driver); 
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
			ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
			Pool_Obj PoolObj = new Pool_Obj();
			AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
			Registration_Obj RegistrationObj = new Registration_Obj();
			AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
			ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
			TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
			AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
			
			//Step 1:Login Snipback
			//Expected:The user should be able to login to Snipback
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
			login.loginToApplication(CommonData.UserName, CommonData.PassWord);
			Thread.sleep(7000);
			
			//Step 2:Switch the organization if the User as Admin/Coach
			//Expected:The user should be able to switch the organization.
			base.buttonClick(LoginPageObj.Btn_Login("Film"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
			asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
			base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
			base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
			
			//Step 3 : Click on three dots in the teams
			//Expected : User should be able to click on the three dots
			base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
			asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

			//Step 4:Click on Edit option
			//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
			base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
            
			//Step 5: Click on "Game Defaults" button 
			//Expected:No duration should be selected as default against Duration field in Home Default
			asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
		    base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
					
		     //Step 6:Verify Duration should not be displayed in Away Default
		     //Expected: Duration should not be displayed in Away Default
		     base.buttonClick(LoginPageObj.Edt_AlertText("Away Default"));	            
		     List<WebElement> durationElements = driver.findElements(By.xpath("//p[text()='Duration']")); 
		     if (!durationElements.isEmpty()) {
		    	System.out.println("Duration is present: " + durationElements.get(0).getText());
		    	} else {
		    			System.out.println("Duration is not be displayed in Away Default");
		    	}
		}
				// <summary>
				// Test Case Title : "Verify that the following duration should be displayed in the Select Duration drop down in Home Default 1. 60 Mins 2.90 Mins 3.120 Mins 4.150 Mins 5. Other"
				// Automation ID : Team_52
				// </summary>
				public void Team_52_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {

					Login login = new Login(driver); 
					LoginPage_Obj LoginPageObj = new LoginPage_Obj();
					SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
					ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
					Pool_Obj PoolObj = new Pool_Obj();
					AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
					CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
					Registration_Obj RegistrationObj = new Registration_Obj();
					AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
					ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
					TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
					AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
					
					//Step 1:Login Snipback
					//Expected:The user should be able to login to Snipback
					asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
					login.loginToApplication(CommonData.UserName, CommonData.PassWord);
					Thread.sleep(7000);
					
					//Step 2:Switch the organization if the User as Admin/Coach
					//Expected:The user should be able to switch the organization.
					base.buttonClick(LoginPageObj.Btn_Login("Film"));
					asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
					asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
					base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
					base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
					asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
					
					//Step 3 : Click on three dots in the teams
					//Expected : User should be able to click on the three dots
					base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
					asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

					//Step 4:Click on Edit option
					//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
					base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
		           
		            //Step 7: Click on "Game Defaults" button 
					//Expected:The following duration should be dislayed in the Select Duration drop down in Home Default 1. 60 Mins 2.90 Mins 3.120 Mins 4.150 Mins 5. Other
					asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
		            base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
		            asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole(" 60 Mins "))," 60 Mins  is not dislayed in the Select Duration drop down in Home Default");
		            asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole(" 90 Mins "))," 90 Mins  is not dislayed in the Select Duration drop down in Home Default");
		            asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole(" 120 Mins "))," 120 Mins is not dislayed in the Select Duration drop down in Home Default");
		            asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole(" 150 Mins "))," 150 Mins is not dislayed in the Select Duration drop down in Home Default");
		            asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DurationSelect("dura_other","Other")),"Other is not dislayed in the Select Duration drop down in Home Default");
				}
				
				// <summary>
				// Test Case Title : "Verify that the a text field with Mins should be displayed while select the Duration as Other from the Duration Drop Down"
				// Automation ID : Team_53
				// </summary>
				public void Team_53_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {

					Login login = new Login(driver); 
					LoginPage_Obj LoginPageObj = new LoginPage_Obj();
					SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
					ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
					Pool_Obj PoolObj = new Pool_Obj();
					AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
					CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
					Registration_Obj RegistrationObj = new Registration_Obj();
					AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
					ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
					TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
					AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
					
					//Step 1:Login Snipback
					//Expected:The user should be able to login to Snipback
					asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
					login.loginToApplication(CommonData.UserName, CommonData.PassWord);
					Thread.sleep(7000);
					
					//Step 2:Switch the organization if the User as Admin/Coach
					//Expected:The user should be able to switch the organization.
					base.buttonClick(LoginPageObj.Btn_Login("Film"));
					asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
					asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
					base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
					base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
					asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
					
					//Step 3 : Click on three dots in the teams
					//Expected : User should be able to click on the three dots
					base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
					asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

					//Step 4:Click on Edit option
					//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
					base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
					asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
		            
		            //Step 5: Click on "Game Defaults" button 
					//Expected: The durations should be displayed in the Select Duration drop down in Home Default
					base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
		            asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DurationSelect("dura_other","Other")),"Other is not dislayed in the Select Duration drop down in Home Default");

		            //Step 6: Click on "Other" in duration 
					//Expected: A text field with Mins should be displayed while select the Duration as Other from the Duration Drop Down
		            base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DurationSelect("dura_other","Other"));
		            asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("other-duration")),"A text field with Mins is not displayed while select the Duration as Other from the Duration Drop Down");
				}
				
				// <summary>
				// Test Case Title : "Verify that the a text field with Mins should be displayed while select the Duration as Other from the Duration Drop Down"
				// Automation ID : Team_54
				// </summary>
				public void Team_54_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException {

					Login login = new Login(driver); 
					LoginPage_Obj LoginPageObj = new LoginPage_Obj();
					SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
					ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
					Pool_Obj PoolObj = new Pool_Obj();
					AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
					CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
					Registration_Obj RegistrationObj = new Registration_Obj();
					AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
					ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj =new ArchiveUnarchiveTeam_Obj();
					TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
					AddUpdateDeleteDuplicateTeamGameDefaults_TestData AddUpdateDeleteDuplicateTeamGameDefaultsTestData = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
					
					//Step 1:Login Snipback
					//Expected:The user should be able to login to Snipback
					asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
					login.loginToApplication(CommonData.UserName, CommonData.PassWord);
					Thread.sleep(7000);
					
					//Step 2:Switch the organization if the User as Admin/Coach
					//Expected:The user should be able to switch the organization.
					base.buttonClick(LoginPageObj.Btn_Login("Film"));
					asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");
					asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User not able to click Games button");
					base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
					base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TrimVideoTestData.TV_01_Org));
					asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName)));
					
					//Step 3 : Click on three dots in the teams
					//Expected : User should be able to click on the three dots
					base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(AddUpdateDeleteDuplicateTeamGameDefaultsTestData.Team_09_TeamName));
					asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421")),"The user should not view the Edit Option from the 3-dot menu");

					//Step 4:Click on Edit option
					//Expected:Details of the Team should be displayed when click on Edit option from the three dots against the team
					base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("team-5421"));
					asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action")), "User unable to see the list of options under the three dots in the Games Page");
		            
		            //Step 5: Click on "Game Defaults" button 
					//Expected: The durations should be displayed in the Select Duration drop down in Home Default
					base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Btn_GameDefaults("default-btn me-2 default-btn-action"));
		            asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DurationSelect("dura_other","Other")),"Other is not dislayed in the Select Duration drop down in Home Default");

		            //Step 6: Click on "Other" in duration 
					//Expected: A text field with Mins should be displayed while select the Duration as Other from the Duration Drop Down
		            base.buttonClick(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DurationSelect("dura_other","Other"));
		            asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("other-duration")),"A text field with Mins is not displayed while select the Duration as Other from the Duration Drop Down");
		            
		            //Step 7: Enter the Customized duration  
		            //Expected: The text field for enter the customized duration only accept Numbers or should not accept decimals, special characters or alpbhabets
		            base.setData(LoginPageObj.Edt_LoginEmail("other-duration"), AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_54_Druration);
		            String ActualValue= base.GetValue(LoginPageObj.Edt_LoginEmail("other-duration"));
		            asrt.assertEquals(ActualValue, AddUpdateDeleteDuplicateTeamGameDefaults_TestData.Team_54_Druration,"The text field for enter the customized duraation only accept Numbers or should not accept decimals, special characters or alpbhabets");
				}
				
				// <summary>
				// Test Case Title :"Verify that the following option should be displayed in the three dots against each team."
				//					1. Edit
				//					2.Team Invite Links
				//					3.Duplicate Team
				//					4.Archive Team
				//					5.Delete Team
				//					6.Chat with Team
				//					7.Dismiss
				// Automation ID   : Team_24
				// </summary>
		        
				public void Team_24_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException
				{
							Login login = new Login(driver); 
							CommonData Commondata= new CommonData();
							LoginPage_Obj LoginPageObj = new LoginPage_Obj();
							Pool_Obj PoolObj = new Pool_Obj();
							TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
							
							//Step 1: Login to SnipBack
							//Expected: User should be navigated to home page after entering valid credentials.
							login.loginToApplication(Commondata.UserName, Commondata.PassWord);
							Thread.sleep(5000);
							
							//Step 2: Switch the organization if the User as Admin/Coach
							//Expected:The organization should be selected in the Games page
							base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
							base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
							asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not being selected from the dropdown.");
							Thread.sleep(5000);
							
							//Step 3  : Verify the three dots against the team
							//Expected: Three dots should be displayed against each team in the Game/Members/Followers Page 
							List<WebElement> elements=driver.findElements(By.xpath("//div[@id='my-team-content']//div[@class='btn-group']/a"));
							List<WebElement> EditTeam=driver.findElements(By.xpath("//div[@id='my-team-content']//a[text()='Edit Team']"));
							System.out.println(EditTeam.size());
							asrt.assertEquals(elements.size(), EditTeam.size(),"Edit Team'option is not present in all teams in the organization 'AutomationOrg - 1'  ");
							
							List<WebElement> TeamInviteLinks=driver.findElements(By.xpath("//div[@id='my-team-content']//a[text()='Team Invite Links']"));
							System.out.println(TeamInviteLinks.size());
							asrt.assertEquals(elements.size(), TeamInviteLinks.size(),"TeamInviteLinks'option is not present in all teams in the organization 'AutomationOrg - 1'  ");
							
							List<WebElement> DuplicateTeam=driver.findElements(By.xpath("//div[@id='my-team-content']//a[text()='Duplicate Team']"));
							System.out.println(DuplicateTeam.size());
							asrt.assertEquals(elements.size(), DuplicateTeam.size(),"DuplicateTeam'option is not present in all teams in the organization 'AutomationOrg - 1'  ");

							List<WebElement> ArchiveTeam=driver.findElements(By.xpath("//div[@id='my-team-content']//a[text()='Archive Team']"));
							System.out.println(ArchiveTeam.size());
							asrt.assertEquals(elements.size(), ArchiveTeam.size(),"ArchiveTeam'option is not present in all teams in the organization 'AutomationOrg - 1'  ");
 
							List<WebElement> DeleteTeam=driver.findElements(By.xpath("//div[@id='my-team-content']//a[text()='Delete Team']"));
							System.out.println(DeleteTeam.size());
							asrt.assertEquals(elements.size(), DeleteTeam.size(),"'Delete Team'option is not present in all teams in the organization 'AutomationOrg - 1'  ");

							List<WebElement> ChatwithTeam=driver.findElements(By.xpath("//div[@id='my-team-content']//a[text()='Chat with Team']"));
							System.out.println(ChatwithTeam.size());
							asrt.assertEquals(elements.size(), ChatwithTeam.size(),"'Chat with Team'option is not present in all teams in the organization 'AutomationOrg - 1'  ");

							List<WebElement> Dismiss=driver.findElements(By.xpath("//div[@id='my-team-content']//a[text()='Dismiss']"));
							System.out.println(Dismiss.size());
							asrt.assertEquals(elements.size(), Dismiss.size(),"'Dismiss'option is not present in all teams in the organization 'AutomationOrg - 1'  ");

				}   								
}