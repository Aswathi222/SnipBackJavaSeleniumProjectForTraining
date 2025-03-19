package testPage.MavenPageObject;
import TestData.ForgotPassword_TestData;
import TestData.Registration_TestData;
import TestData.ViewProfile_TestData;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import TestData.AddFollower_TestData;
import TestData.CommonData;
import TestData.CreateAddNewMemberWithEmail_TestData;
import TestData.ForgotPassword_TestData;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.ViewProfile_Obj;
import objectRepository.AddFollower_Obj;
import objectRepository.AddUpdateDeleteDuplicateTeamGameDefaults_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.FilterMembers_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;
public class FilterMembers extends BasePge{

	BasePge base;
	Assert asrt;

	public FilterMembers(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify whether there is an option to filter each category of members." 
	// Automation ID   : FM_01
	// </summary>

	public void FM_01_FilterMembers()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		
		//Step 1  :"Login to Snipback"
		//Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		        
		//Step 2  :"Switch the organization to 'Admin status' org."
		//Expected:"The organization should be selected and the teams displayed."
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType("C4-Org1 - 4262"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("C4-Org1 - 4262")),"The option 'C4-Org1 - 4262' is not selected from the team dropdown.");
		Thread.sleep(5000);
		
		//Step 3  :"Select Members section"
		//EXpected:"There should be an option to filter each category of members."
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("members_total")),"User is not able to view an option to filter each category of members.");		
	}

	// <summary>
	// Test Case Title :"To verify whether the user can filter players alone from the members list."
	// Automation ID   : FM_02
	// </summary>

	public void FM_02_FilterMembers()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		FilterMembers_Obj FilterMembersObj= new FilterMembers_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		
		//Step 1  :"Login to Snipback"
		//Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		        
		//Step 2  :"Switch the organization to 'Admin status' org."
		//Expected:"The organization should be selected and the teams displayed."
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType("C4-Org1 - 4262"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("C4-Org1 - 4262")),"The option 'C4-Org1 - 4262' is not selected from the team dropdown.");
		Thread.sleep(5000);
		
		//Step 3  :"Select Members section"
		//Expected:"There should be an option to filter each category of members."
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("members_total")),"The Members page is not displayed after clicking the Members tab in The Films page.");		
	
		//Step 4  :"Click the radio button near Player/Users"
		//Expected:"Users can filter Players alone from the members list."
		Thread.sleep(2000);
		base.buttonClick(FilterMembersObj.Chk_FilterRole("Players / Users"));
		Thread.sleep(5000);
		//List <WebElement> roles= driver.findElements(By.xpath("//p[@id='teamRole' and text()='Player']"));
		//List <WebElement> roles=AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamAddedSuccessfully("teamRole", "Player");
		List <WebElement> roles= driver.findElements(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamAddedSuccessfully("teamRole", "Player"));
		String TotalPlayersCount= base.GetText(RegistrationObj.Edt_SignUpPopupPassword("members_total"));
		int ActualPlayerCount= Integer.parseInt(TotalPlayersCount);
		asrt.assertEquals(roles.size(), ActualPlayerCount,"User is not able to filter Players alone from the members list");
	}
	
	// <summary>
	// Test Case Title :"To verify whether the user can filter Recruiters alone from the members list."
	// Automation ID   : FM_03
	// </summary>

	public void FM_03_FilterMembers()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		FilterMembers_Obj FilterMembersObj= new FilterMembers_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		
		//Step 1  :"Login to Snipback"
		//Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		        
		//Step 2  :"Switch the organization to 'Admin status' org."
		//Expected:"The organization should be selected and the teams displayed."
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType("C4-Org1 - 4262"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("C4-Org1 - 4262")),"The option 'C4-Org1 - 4262' is not selected from the team dropdown.");
		Thread.sleep(5000);
		
		//Step 3  :"Select Members section"
		//Expected:"There should be an option to filter each category of members."
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("members_total")),"The Members page is not displayed after clicking the Members tab in The Films page.");		
	
		//Step 4  :"Click the radio button near Recruiter"
		//Expected:"Users can filter Recruiter alone from the members list."
		Thread.sleep(2000);
		base.buttonClick(FilterMembersObj.Chk_FilterRole("Recruiter"));
		Thread.sleep(5000);
		List <WebElement> roles= driver.findElements(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamAddedSuccessfully("teamRole", "Recruiter"));
		String TotalRecruiterCount= base.GetText(RegistrationObj.Edt_SignUpPopupPassword("members_total"));
		int ActualRecruiterCount= Integer.parseInt(TotalRecruiterCount);
		asrt.assertEquals(roles.size(), ActualRecruiterCount,"User is not able to filter recruiter alone from the members list");
	}
	// <summary>
	// Test Case Title :"To verify whether the user can filter Coaches alone from the members list."
	// Automation ID   : FM_04
	// </summary>

	public void FM_04_FilterMembers()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		FilterMembers_Obj FilterMembersObj= new FilterMembers_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		
		//Step 1  :"Login to Snipback"
		//Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		        
		//Step 2  :"Switch the organization to 'Admin status' org."
		//Expected:"The organization should be selected and the teams displayed."
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType("C4-Org1 - 4262"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("C4-Org1 - 4262")),"The option 'C4-Org1 - 4262' is not selected from the team dropdown.");
		Thread.sleep(5000);
		
		//Step 3  :"Select Members section"
		//Expected:"There should be an option to filter each category of members."
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("members_total")),"The Members page is not displayed after clicking the Members tab in The Films page.");		
	
		//Step 4  :"Click the radio button near Coaches"
		//Expected:"Users can filter Coaches alone from the members list."
		Thread.sleep(2000);
		base.buttonClick(FilterMembersObj.Chk_FilterRole("Coaches"));
		Thread.sleep(5000);
		List <WebElement> roles= driver.findElements(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamAddedSuccessfully("teamRole", "Coach"));
		String TotalCoachesCount= base.GetText(RegistrationObj.Edt_SignUpPopupPassword("members_total"));
		int ActualCoachesCount= Integer.parseInt(TotalCoachesCount);
		asrt.assertEquals(roles.size(), ActualCoachesCount,"User is not able to filter Coaches alone from the members list");
	}
	// <summary>
	// Test Case Title :"To verify whether the user can filter Admin alone from the members list."
	// Automation ID   : FM_05
	// </summary>

	public void FM_05_FilterMembers()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		FilterMembers_Obj FilterMembersObj= new FilterMembers_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		
		//Step 1  :"Login to Snipback"
		//Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		        
		//Step 2  :"Switch the organization to 'Admin status' org."
		//Expected:"The organization should be selected and the teams displayed."
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType("C4-Org1 - 4262"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("C4-Org1 - 4262")),"The option 'C4-Org1 - 4262' is not selected from the team dropdown.");
		Thread.sleep(5000);
		
		//Step 3  :"Select Members section"
		//Expected:"There should be an option to filter each category of members."
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("members_total")),"The Members page is not displayed after clicking the Members tab in The Films page.");		
	
		//Step 4  :"Click the radio button near Admin"
		//Expected:"Users can filter Admin alone from the members list."
		Thread.sleep(2000);
		base.buttonClick(FilterMembersObj.Chk_FilterRole("Admin"));
		Thread.sleep(5000);
		List <WebElement> roles= driver.findElements(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_TeamAddedSuccessfully("teamRole", "Admin"));
		String TotalCoachesCount= base.GetText(RegistrationObj.Edt_SignUpPopupPassword("members_total"));
		int ActualCoachesCount= Integer.parseInt(TotalCoachesCount);
		asrt.assertEquals(roles.size(), ActualCoachesCount,"User is not able to filter Admin alone from the members list");
	}
	// <summary>
	// Test Case Title :"To verify what happens when user click the radio button near All."
	// Automation ID   : FM_06
	// </summary>

	public void FM_06_FilterMembers()  throws InterruptedException 
	{ 
		Login login= new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata = new CommonData();
		Pool_Obj PoolObj= new Pool_Obj();
		Registration_Obj RegistrationObj= new Registration_Obj();
		FilterMembers_Obj FilterMembersObj= new FilterMembers_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
		
		//Step 1  :"Login to Snipback"
		//Expected:"User should able to navigated to Snipback user homepage"
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		        
		//Step 2  :"Switch the organization to 'Admin status' org."
		//Expected:"The organization should be selected and the teams displayed."
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType("C4-Org1 - 4262"));
		Thread.sleep(5000);
		
		//Step 3  :"Select Members section"
		//Expected:"There should be an option to filter each category of members."
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-members-tab"));
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("members_total")),"The Members page is not displayed after clicking the Members tab in The Films page.");		
	
		//Step 4  :"Click the radio button near All"
		//Expected:"All the members with different role will list once user clicks the radio button near All."
		Thread.sleep(2000);
		base.buttonClick(FilterMembersObj.Chk_FilterAll("d-flex flex-row"));
		Thread.sleep(6000);
		List <WebElement> roles= driver.findElements(FilterMembersObj.Ele_AllRoles("teamRole"));
		String TotalCount= base.GetText(RegistrationObj.Edt_SignUpPopupPassword("members_total"));
		int ActualCount= Integer.parseInt(TotalCount);
		asrt.assertEquals(roles.size(), ActualCount,"All the members with different role is not listed when user clicks the radio button near All.");
	}
}




