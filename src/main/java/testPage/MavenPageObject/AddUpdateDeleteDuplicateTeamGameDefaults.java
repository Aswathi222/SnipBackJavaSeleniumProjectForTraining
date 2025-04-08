package testPage.MavenPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestData.AddUpdateDeleteDuplicateTeamGameDefaults_TestData;
import TestData.CommonData;
import objectRepository.AddUpdateDeleteDuplicateTeamGameDefaults_Obj;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
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
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj addpudatedeleteduplicateobj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData  addupdatedeleteobj= new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj createandaddnewmemberobj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();

		//Step 1 : Verify that user is able to Login Snipback
		//Expected : User should be able to login the film page with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab"))," User is unable to login the film page with credentials");

		//Step 2 : Switch the organization if the User as Admin/Coach
		//Expected : User is able to Switch the organization if the User as Admin/Coach
		base.selectorByVisibleText(createandaddnewmemberobj.Btn_Home("form-select select-form film-organizations"),addupdatedeleteobj.Team_03_SelectedValue );
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")),"User is unable to Switch the organization if the User as Admin/Coach");

		//Step 3 : Verify the +Add team option
		//Expected : Add team (+ Add team) option should be displayed in the organization if the user as Admin/Coach in the Games tab
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_Alert1("Add Team")), "User is unable to view the Add team (+ Add team) in the organization if the user as Admin/Coach in the 'Games' tab");

		//Step 4: Verify the +Add team option
		//Expected : Add team (+ Add team) option should be displayed in the organization if the user as Admin/Coach in the Members tab
		base.buttonClick(loginObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(addpudatedeleteduplicateobj.Ele_Memberandfollower("LIST OF MEMBERS")),"User is unable to view the LIST OF MEMBERS heading in film page");		
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_Alert1("Add Team")), "User is unable to view the Add team (+ Add team) in the organization if the user as Admin/Coach in the 'Members' tab");

		//Step 5 : Verify the +Add team option
		//Expected : Add team (+ Add team) option should be displayed in the organization if the user as Admin/Coach in the Followers  tab
		base.buttonClick(loginObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(addpudatedeleteduplicateobj.Ele_Memberandfollower("LIST OF FOLLOWERS")),"User is unable to view the LIST OF FOLLOWERS heading in film page");		
		asrt.assertTrue(base.isEnabledBy(loginObj.Edt_Alert1("Add Team")), "User is unable to view the Add team (+ Add team) in the organization if the user as Admin/Coach in the 'Followers' tab");
	}
}
