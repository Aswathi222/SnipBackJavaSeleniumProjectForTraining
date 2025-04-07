package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestData.CommonData;
import TestData.CreateAndAddNewMemberWithOrWithoutEmail_TestData;
import TestData.ForgotPassword_TestData;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.ForgotPassword_Obj;
import objectRepository.LoginPage_Obj;
import utilPack.BasePge;

public class CreateAndAddNewMemberWithOrWithoutEmail extends BasePge {
	BasePge base;
	Assert asrt;

	public CreateAndAddNewMemberWithOrWithoutEmail(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}	
	//<summery>
	//Test Case Title : To verify whether there is a option to add user with email.
	//Automation ID : WE01
	//</summery>
	public void WE01_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData CommonDataobj = new CommonData();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_TestData CreateAndAddNewMemberTestDataobj = new CreateAndAddNewMemberWithOrWithoutEmail_TestData();

		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_Home("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE01_CreateandAddnewmemberOrganization);
		String SelectedText = base.GetText(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_Home("form-select select-form film-organizations"));
		asrt.assertEquals(SelectedText,base.GetText(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_Home("form-select select-form film-organizations")),"User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE01_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_Alert1("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_Alert1("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE01_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_TeamName("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Observe whether there is a option as Create & Add new member with Email
		//Expected : There should be a option to add user with mail id.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "There is no option to add user with mail id.");
	}
}
