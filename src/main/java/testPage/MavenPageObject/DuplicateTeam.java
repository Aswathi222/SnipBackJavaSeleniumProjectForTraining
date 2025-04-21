package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestData.CommonData;
import TestData.DuplicateTeam_TestData;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.DuplicateTeam_Obj;
import objectRepository.LoginPage_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;

public class DuplicateTeam extends BasePge {
	BasePge base;
	Assert asrt;
	ElementActions element;

	public DuplicateTeam(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
		element = new ElementActions(driver);
	}
	
	// <summary>
	// Test Case Title : "To verify whether there is an option as Duplicate Team in the Team Listing page."
	// Automation ID : DT_01
	// </summary>
	public void DT_01_DuplicateTeam() throws InterruptedException 
	{
		DuplicateTeam_Obj DuplicateTeamObj = new DuplicateTeam_Obj();
		DuplicateTeam_TestData DuplicateTeamTestData = new DuplicateTeam_TestData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj = new CreateEditDeletePool_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAddMemberObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();

		//Step 1 : Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		//Step 2 : Click on the Login button
		//Expected : User should be able to login to the SnipBack with the credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to login to SnipBack");

		//Step 3 : Go to Film page
		//Expected : User should be able to navigate to film page
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is unable to navigate to the Film page");

		//Step 4 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAddMemberObj.DdlOrg("form-select select-form film-organizations"), DuplicateTeamTestData.DT_01_OrgName);
		String Orgname = element.DropDownText(CreateAddMemberObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Orgname, DuplicateTeamTestData.DT_01_OrgName, "User is unable to select any organization");
		
		//Step 5 : click on search button and select a team
		//Expected : User should be able to select the searched Team
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), DuplicateTeamTestData.DT_01_TeamName);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(2000);
		base.buttonClick(CreateAddMemberObj.Btn_Team("my-team-content",DuplicateTeamTestData.DT_01_TeamName));
		String TeamName = base.GetValue(LoginPageObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(TeamName, DuplicateTeamTestData.DT_01_TeamName,"User is not able to search and select the Team.");

		//Step 6 : Click on three dots of any team
		//Expected : User should be able to click on the three dots of any team.
		base.buttonClick(DuplicateTeamObj.Btn_ThreeDotsTeam(DuplicateTeamTestData.DT_01_TeamName, "dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Btn_ThreeDotsTeam(DuplicateTeamTestData.DT_01_TeamName,"dropdown-menu")), "User is unable to view the list of options under the three dots in the Games Page");
		Thread.sleep(2000);

		// Step 7 : Verify the Duplicate Team option is shown under team listing page.
		// Expected : User should be able to see the Duplicate team option
		asrt.assertTrue(base.isExists(DuplicateTeamObj.Btn_DuplicateTeam(DuplicateTeamTestData.DT_01_TeamName,"dropdown-menu","dropdown-item duplicate-team")), "Duplicate team option is not shown under the 3 dot menu");
	}
}
