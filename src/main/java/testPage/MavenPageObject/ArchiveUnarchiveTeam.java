package testPage.MavenPageObject;
import TestData.ForgotPassword_TestData;
import TestData.Registration_TestData;
import TestData.ViewProfile_TestData;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestData.AddFollower_TestData;
import TestData.ArchiveUnarchiveTeam_TestData;
import TestData.CommonData;
import TestData.CreateAddNewMemberWithEmail_TestData;
import TestData.ForgotPassword_TestData;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.ViewProfile_Obj;
import objectRepository.AddFollower_Obj;
import objectRepository.AddUpdateDeleteDuplicateTeamGameDefaults_Obj;
import objectRepository.ArchiveUnarchiveTeam_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;
public class ArchiveUnarchiveTeam extends BasePge{

	BasePge base;
	Assert asrt;

	public ArchiveUnarchiveTeam(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title : "Verify that user should able to navigate to the snipback website after entering the URL"
	// Automation ID : Archive_01
	// </summary>
	public void Archive_01_ArchiveUnarchiveTeam() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		//Step 1 : Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to the snipback website after entering the URL");

	}

	//<summary>
	// Test Case Title : "Verify that user should able to navigate to the Film page once login with credentials"
	// Automation ID : Archive_02
	// </summary>
	public void Archive_02_ArchiveUnarchiveTeam() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		
		//Step 1 : Enter the URL		
		//Expected : User should able to navigate to the snipback website after entering the URL.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   : "Click Login"
		//Expected : "User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to navigate to the Film page");
	}

	//<summary>
	// Test Case Title : "Verify that Archive team option should be displayed in the three dots against  all teams in the organization if the user as Admin/Coach in the Game, Members & Followers tab in the Film page"
	// Automation ID : Archive_03
	// </summary>
	public void Archive_03_ArchiveUnarchiveTeam() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		ArchiveUnarchiveTeam_TestData ArchiveUnarchiveTeamTestData= new ArchiveUnarchiveTeam_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();

		//Step 1 : Login to Snipback"	
		//Expected : "User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to navigate to the Film page");

		//Step 2  : Switch the organization if the User as Admin/Coach.
		//Expected : The organization should be selected and the teams displayed
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), ArchiveUnarchiveTeamTestData.Archive_03_ArchiveUnarchiveOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		Thread.sleep(5000);
		
		//Step 3   :"Verify the Archive team option"
		//Expected :"Archive team option should be displayed in the three dots against  all teams in the organization if the user as Admin/Coach in the Game, Members & Followers tab in the Film page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),ArchiveUnarchiveTeamTestData.Archive_03_ArchiveUnarchiveTeamName);
		Thread.sleep(3000);
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_03_ArchiveUnarchiveTeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_03_ArchiveUnarchiveTeamID)), "Archive team option is not displayed in the three dots aginst in the organizationif the user as Admin/Coach in the Game, Members & Followers tab in the Film page");
	}

	// <summary>
	// Test Case Title :"Verify that Archive option should  be disabled in Home organization and in the Organization if the User as Player/Followers/Recruiter in the Film page" 
	// Automation ID   : Archive_04
	// </summary>
	public void Archive_04_ArchiveUnarchiveTeam()  throws InterruptedException 
	{ 
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		ArchiveUnarchiveTeam_TestData ArchiveUnarchiveTeamTestData= new ArchiveUnarchiveTeam_TestData();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();

		//Step 1 : Login to Snipback"	
		//Expected : "User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to navigate to the Film page");

		//Step 2  : Switch the organization if the User as Admin/Coach.
		//Expected : The organization should be selected and the teams displayed
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), ArchiveUnarchiveTeamTestData.Archive_04_ArchiveUnarchiveOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		Thread.sleep(5000);
		
		//Step 3   :"Verify the Archive team option"
		//Expected :"Archive team option should be displayed in the three dots against  all teams in the organization if the user as Admin/Coach in the Game, Members & Followers tab in the Film page"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),ArchiveUnarchiveTeamTestData.Archive_04_ArchiveUnarchiveTeamName);
		Thread.sleep(3000);
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_04_ArchiveUnarchiveTeamName));
		Thread.sleep(5000);
		//asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("archiveTeamDropdown-4608")),"User is not able to view the archive team option in the popup while clicking on three dots against the team");
	}
	
	// <summary>
	// Test Case Title :"Verify that the message "Are you sure want to archive this team?" with Yes or No should be displayed when click on Archive team from the three dots against the respective team" 
	// Automation ID   : Archive_06
	// </summary>
	public void Archive_06_ArchiveUnarchiveTeam()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		ArchiveUnarchiveTeam_TestData ArchiveUnarchiveTeamTestData= new ArchiveUnarchiveTeam_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();

		//Step 1 : Login to Snipback"	
		//Expected : "User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to navigate to the Film page");

		//Step 2  : Switch the organization if the User as Admin/Coach.
		//Expected : The organization should be selected and the teams displayed
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), ArchiveUnarchiveTeamTestData.Archive_06_ArchiveUnarchiveOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		Thread.sleep(5000);
		
		//Step 3   :"Verify the Archive team option"
		//Expected :"Archive Team should displayed in the three dots against all teams in the organization"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),ArchiveUnarchiveTeamTestData.Archive_06_ArchiveUnarchiveTeamName);
		Thread.sleep(3000);
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_06_ArchiveUnarchiveTeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_06_ArchiveUnarchiveTeamID)), "Archive team option is not displayed in the three dots aginst in the organization");

		//Step 4   :"Click on Archive team"
		//Expected :"The team should be archived"
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_06_ArchiveUnarchiveTeamID));
		Thread.sleep(3000);

		//Step 5   :"Verify that message "Are you sure want to archive this team?" should be displayed when click on Archive team from the three dots against the respective team"
		//Expected :"The user should view the message "Are you sure want to archive this team?" should be displayed when click on Archive team from the three dots against the respective team "
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"The user is not able to view the message 'Are you sure want to archive this team?'");
	}	
	
	// <summary>
	// Test Case Title :"Verify that the message "Are you sure want to archive this team?" should be closed when click on No from the popup message" 
	// Automation ID   : Archive_07
	// </summary>
	public void Archive_07_ArchiveUnarchiveTeam()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		ArchiveUnarchiveTeam_TestData ArchiveUnarchiveTeamTestData= new ArchiveUnarchiveTeam_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();

		//Step 1 : Login to Snipback"	
		//Expected : "User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to navigate to the Film page");

		//Step 2  : Switch the organization if the User as Admin/Coach.
		//Expected : The organization should be selected and the teams displayed
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), ArchiveUnarchiveTeamTestData.Archive_07_ArchiveUnarchiveOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		Thread.sleep(5000);
		
		//Step 3   :"Verify the Archive team option"
		//Expected :"Archive Team should displayed in the three dots against all teams in the organization"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),ArchiveUnarchiveTeamTestData.Archive_07_ArchiveUnarchiveTeamName);
		Thread.sleep(3000);
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_07_ArchiveUnarchiveTeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_07_ArchiveUnarchiveTeamID)), "Archive team option is not displayed in the three dots aginst in the organization");

		//Step 4   :"Click on Archive team"
		//Expected :"The team should be archived"
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_07_ArchiveUnarchiveTeamID));
		Thread.sleep(3000);

		//Step 5   :"Verify that message "Are you sure want to archive this team?"
		//Expected :"The user should view the message "Are you sure want to archive this team?"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"The user should not able to view the message 'Are you sure want to archive this team?'");

		//Step 6   :"Click on 'No' from the popup message"
		//Expected : "Are you sure want to archive this team?" should closed when click on 'No' option
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel")),"The user is not able to view the cancel option with 'Are you sure want to archive this team?'");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel"));
		Thread.sleep(5000);
	}	
	
	// <summary>
	// Test Case Title :"Verify the message Success!Team Archived Successfully should popup when click on Yes from the popup message  "Are you sure want to archive this team?"" 
	// Automation ID   : Archive_08
	// </summary>
	public void Archive_08_ArchiveUnarchiveTeam()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		ArchiveUnarchiveTeam_TestData ArchiveUnarchiveTeamTestData= new ArchiveUnarchiveTeam_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();

		//Step 1 : Login to Snipback"	
		//Expected : "User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to navigate to the Film page");

		//Step 2  : Switch the organization if the User as Admin/Coach.
		//Expected : The organization should be selected and the teams displayed
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), ArchiveUnarchiveTeamTestData.Archive_08_ArchiveUnarchiveOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		Thread.sleep(5000);
		
		//Step 3   :"Verify the Archive team option"
		//Expected :"Archive Team should displayed in the three dots against all teams in the organization"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),ArchiveUnarchiveTeamTestData.Archive_08_ArchiveUnarchiveTeamName);
		Thread.sleep(3000);
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_08_ArchiveUnarchiveTeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_08_ArchiveUnarchiveTeamID)), "Archive team option is not displayed in the three dots aginst in the organization");

		//Step 4   :"Click on Archive team"
		//Expected :"The team should be archived"
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_08_ArchiveUnarchiveTeamID));
		Thread.sleep(3000);

		//Step 5   :"Verify that message "Are you sure want to archive this team?"
		//Expected :"The user should view the message "Are you sure want to archive this team?"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"The user should not able to view the message 'Are you sure want to archive this team?'");

		//Step 6   :Click on Yes
		//Expected :"The alert message should be displayed"
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		Thread.sleep(15000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"'Team Archived Succesfully' message is not displayed");
		Thread.sleep(3000);
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		Thread.sleep(5000);
		
		//Removing Steps for unarchive the same team
		base.scrollToElement(ArchiveUnarchiveTeamObj.Ele_Archieve("archiveTitle",ArchiveUnarchiveTeamTestData.Archive_08_ArchiveUnarchiveTeamName));
		Thread.sleep(3000);
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_08_ArchiveUnarchiveTeamName));
		Thread.sleep(3000);
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_08_ArchiveUnarchiveTeamID));
		Thread.sleep(10000);
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	}
	
	// <summary>
	// Test Case Title :"Verify that the Team should be in Archived List when click on OK from the popup message Success!Team Archived Successfully"" 
	// Automation ID   : Archive_09
	// </summary>
	public void Archive_09_ArchiveUnarchiveTeam()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		ArchiveUnarchiveTeam_TestData ArchiveUnarchiveTeamTestData= new ArchiveUnarchiveTeam_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();

		//Step 1 : Login to Snipback"	
		//Expected : "User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to navigate to the Film page");

		//Step 2  : Switch the organization if the User as Admin/Coach.
		//Expected : The organization should be selected and the teams displayed
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), ArchiveUnarchiveTeamTestData.Archive_09_ArchiveUnarchiveOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		Thread.sleep(5000);
		
		//Step 3   :"Verify the Archive team option"
		//Expected :"Archive Team should displayed in the three dots against all teams in the organization"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),ArchiveUnarchiveTeamTestData.Archive_09_ArchiveUnarchiveTeamName);
		Thread.sleep(3000);
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_09_ArchiveUnarchiveTeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_09_ArchiveUnarchiveTeamID)), "Archive team option is not displayed in the three dots aginst in the organization");

		//Step 4   :"Click on Archive team"
		//Expected :"The team should be archived"
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_09_ArchiveUnarchiveTeamID));
		Thread.sleep(3000);

		//Step 5   :"Verify that message "Are you sure want to archive this team?"
		//Expected :"The user should view the message "Are you sure want to archive this team?"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"The user should not able to view the message 'Are you sure want to archive this team?'");

		//Step 6   :Click on Yes
		//Expected :"The alert message should be displayed"
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		Thread.sleep(15000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"'Team Archived Succesfully' message is not displayed");
		Thread.sleep(3000);
		
		//Step 7 : Click on "OK" button
		//Expected : The Team should be in Archived List when click on OK from the popup message
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"'Ok' button is not displayed in the popup message");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		Thread.sleep(5000);
		base.scrollToElement(ArchiveUnarchiveTeamObj.Ele_Archieve("archiveTitle",ArchiveUnarchiveTeamTestData.Archive_09_ArchiveUnarchiveTeamName));
		Thread.sleep(5000); 
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Ele_Archieve("archiveTitle",ArchiveUnarchiveTeamTestData.Archive_09_ArchiveUnarchiveTeamName)),"The Team is not available in Archived List when click on OK from the popup message");
		
		//Removing Steps for unarchive the same team
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_09_ArchiveUnarchiveTeamName));
		Thread.sleep(3000);
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_09_ArchiveUnarchiveTeamID));
		Thread.sleep(10000);
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	}
	
	// <summary>
	// Test Case Title :"Verify that the Unarchive team option should be displayed when click on three dots against the team in the Archive List" 
	// Automation ID   : Archive_10
	// </summary>
	public void Archive_10_ArchiveUnarchiveTeam()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		ArchiveUnarchiveTeam_TestData ArchiveUnarchiveTeamTestData= new ArchiveUnarchiveTeam_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();

		//Step 1 : Login to Snipback"	
		//Expected : "User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to navigate to the Film page");

		//Step 2  : Switch the organization if the User as Admin/Coach.
		//Expected : The organization should be selected and the teams displayed
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), ArchiveUnarchiveTeamTestData.Archive_10_ArchiveUnarchiveOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		Thread.sleep(5000);
		
		//Step 3   :"Verify the Archive team option"
		//Expected :"Archive Team should displayed in the three dots against all teams in the organization"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),ArchiveUnarchiveTeamTestData.Archive_10_ArchiveUnarchiveTeamName);
		Thread.sleep(3000);
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_10_ArchiveUnarchiveTeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_10_ArchiveUnarchiveTeamID)), "Archive team option is not displayed in the three dots aginst in the organization");

		//Step 4   :"Click on Archive team"
		//Expected :"The team should be archived"
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_10_ArchiveUnarchiveTeamID));
		Thread.sleep(3000);

		//Step 5   :"Verify that message "Are you sure want to archive this team?"
		//Expected :"The user should view the message "Are you sure want to archive this team?"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"The user should not able to view the message 'Are you sure want to archive this team?'");

		//Step 6   :Click on Yes
		//Expected :"The alert message should be displayed"
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		Thread.sleep(15000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"'Team Archived Succesfully' message is not displayed");
		Thread.sleep(3000);
		
		//Step 7 : Click on "OK" button
		//Expected : The Team should be in Archived List when click on OK from the popup message
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"'Ok' button is not displayed in the popup message");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		Thread.sleep(5000);
		
		//Step 8 : Click on three dots against the Archive Team
		//Expected : Unarchive team option should be displayed when click on three dots against the team in the Archive List
		base.scrollToElement(ArchiveUnarchiveTeamObj.Ele_Archieve("archiveTitle",ArchiveUnarchiveTeamTestData.Archive_10_ArchiveUnarchiveTeamName));
		Thread.sleep(5000); 
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_10_ArchiveUnarchiveTeamName)),"Three dots icon is not available");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_10_ArchiveUnarchiveTeamName));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_10_ArchiveUnarchiveTeamID)),"Unarchive Team is not available in the three dots icon");
		Thread.sleep(7000);
		
		
		//Removing Steps for unarchive the same team
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_10_ArchiveUnarchiveTeamID));
		Thread.sleep(10000);
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
	}
		
	// <summary>
	// Test Case Title :"Verify that the message Success!Team Unarchived Successfully" with OK should popup when click on Unarchive team option" 
	// Automation ID   : TC11
	// </summary>
	public void Archive_11_ArchiveUnarchiveTeam()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		ArchiveUnarchiveTeam_TestData ArchiveUnarchiveTeamTestData= new ArchiveUnarchiveTeam_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();

		//Step 1 : Login to Snipback"	
		//Expected : "User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to navigate to the Film page");

		//Step 2  : Switch the organization if the User as Admin/Coach.
		//Expected : The organization should be selected and the teams displayed
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), ArchiveUnarchiveTeamTestData.Archive_11_ArchiveUnarchiveOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		Thread.sleep(5000);
		
		//Step 3   :"Verify the Archive team option"
		//Expected :"Archive Team should displayed in the three dots against all teams in the organization"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),ArchiveUnarchiveTeamTestData.Archive_11_ArchiveUnarchiveTeamName);
		Thread.sleep(3000);
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_11_ArchiveUnarchiveTeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_11_ArchiveUnarchiveTeamID)), "Archive team option is not displayed in the three dots aginst in the organization");

		//Step 4   :"Click on Archive team"
		//Expected :"The team should be archived"
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_11_ArchiveUnarchiveTeamID));
		Thread.sleep(3000);

		//Step 5   :"Verify that message "Are you sure want to archive this team?"
		//Expected :"The user should view the message "Are you sure want to archive this team?"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"The user should not able to view the message 'Are you sure want to archive this team?'");

		//Step 6   :Click on Yes
		//Expected :"The alert message should be displayed"
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		Thread.sleep(15000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"'Team Archived Succesfully' message is not displayed");
		Thread.sleep(3000);
		
		//Step 7 : Click on "OK" button
		//Expected : The Team should be in Archived List when click on OK from the popup message
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"'Ok' button is not displayed in the popup message");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		Thread.sleep(5000);
		
		//Step 8 : Click on three dots against the Archive Team
		//Expected : Unarchive team option should be displayed when click on three dots against the team in the Archive List
		base.scrollToElement(ArchiveUnarchiveTeamObj.Ele_Archieve("archiveTitle",ArchiveUnarchiveTeamTestData.Archive_11_ArchiveUnarchiveTeamName));
		Thread.sleep(5000); 
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_11_ArchiveUnarchiveTeamName)),"Three dots icon is not available");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_11_ArchiveUnarchiveTeamName));
		Thread.sleep(3000);

		//Step 9   :"Click on Unarchive team"
		//Expected : The confirmation message should be displayed as "Success!Team Unarchived Successfully"
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_11_ArchiveUnarchiveTeamID)),"Unarchive Team is not available in the three dots icon");
		Thread.sleep(7000);
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_11_ArchiveUnarchiveTeamID));
		Thread.sleep(15000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"The alert message is not displayed after clicking Unarchive Team in dropdown appeared on clicking three dots in 'Archived Team' list");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		Thread.sleep(3000);
	}

	// <summary>
	// Test Case Title :"Verify that the team should be unarchived from the Archived List" 
	// Automation ID   : Archive_12
	// </summary>
	public void Archive_12_ArchiveUnarchiveTeam()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		ArchiveUnarchiveTeam_TestData ArchiveUnarchiveTeamTestData= new ArchiveUnarchiveTeam_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj= new CreateAddNewMemberWithEmail_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();

		//Step 1 : Login to Snipback"	
		//Expected : "User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to navigate to the Film page");

		//Step 2  : Switch the organization if the User as Admin/Coach.
		//Expected : The organization should be selected and the teams displayed
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveOrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		Thread.sleep(5000);
		
		//Step 3   :"Verify the Archive team option"
		//Expected :"Archive Team should displayed in the three dots against all teams in the organization"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveTeamName);
		Thread.sleep(3000);
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveTeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveTeamID)), "Archive team option is not displayed in the three dots aginst in the organization");

		//Step 4   :"Click on Archive team"
		//Expected :"The team should be archived"
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveTeamID));
		Thread.sleep(3000);

		//Step 5   :"Verify that message "Are you sure want to archive this team?"
		//Expected :"The user should view the message "Are you sure want to archive this team?"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"The user should not able to view the message 'Are you sure want to archive this team?'");

		//Step 6   :Click on Yes
		//Expected :"The alert message should be displayed"
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		Thread.sleep(15000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"'Team Archived Succesfully' message is not displayed");
		Thread.sleep(3000);
		
		//Step 7 : Click on "OK" button
		//Expected : The Team should be in Archived List when click on OK from the popup message
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"'Ok' button is not displayed in the popup message");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		Thread.sleep(5000);
		
		//Step 8 : Click on three dots against the Archive Team
		//Expected : Unarchive team option should be displayed when click on three dots against the team in the Archive List
		base.scrollToElement(ArchiveUnarchiveTeamObj.Ele_Archieve("archiveTitle",ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveTeamName));
		Thread.sleep(5000); 
		asrt.assertTrue(base.isExists(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveTeamName)),"Three dots icon is not available");
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveTeamName));
		Thread.sleep(3000);

		//Step 9   :"Click on Unarchive team"
		//Expected : The confirmation message should be displayed as "Success!Team Unarchived Successfully"
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveTeamID)),"Unarchive Team is not available in the three dots icon");
		Thread.sleep(7000);
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveTeamID));
		Thread.sleep(15000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"The alert message is not displayed after clicking Unarchive Team in dropdown appeared on clicking three dots in 'Archived Team' list");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		Thread.sleep(3000);

		//Verifying the unarchived team is removed from the Archived list
		base.scrollToElement(LoginPageObj.Edt_LoginEmail("searchTeam"));
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveTeamName);
		Thread.sleep(3000);
		base.excuteJsClick(ArchiveUnarchiveTeamObj.Btn_TThreeDots(ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveTeamName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam(ArchiveUnarchiveTeamTestData.Archive_12_ArchiveUnarchiveTeamID)), "Archive team option is not displayed in the three dots aginst in the organizationif the user as Admin/Coach in the Game, Members & Followers tab in the Film page");
	}

}




