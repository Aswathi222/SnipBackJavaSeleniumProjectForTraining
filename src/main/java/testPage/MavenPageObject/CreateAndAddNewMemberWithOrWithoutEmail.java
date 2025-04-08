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
	//Automation ID : WE_01
	//</summery>
	public void WE_01_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
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
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_Home("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberOrganization);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("searchTeam")),"User is not able to select any organization");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_Alert1("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_Alert1("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

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
	//<summery>
	//Test Case Title : To verify whether the user navigates to ADD NEW USER pop up while clicking Create & Add New Member with Email. 
	//Automation ID : WE_02
	//</summery>
	public void WE_02_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
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
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_Home("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberOrganization);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("searchTeam")),"User is not able to select any organization");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_Alert1("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_Alert1("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_TeamName("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");
	}
	//<summery>
	//Test Case Title : To verify what happens when the user enters a valid email id in the ADD NEW USER pop up
	//Automation ID : WE_03
	//</summery>
	public void WE_03_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_TestData CreateAndAddNewMemberTestDataobj = new CreateAndAddNewMemberWithOrWithoutEmail_TestData();
		ForgotPassword_Obj ForgotPasswordObj = new ForgotPassword_Obj();

		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_Home("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberOrganization);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("searchTeam")),"User is not able to select any organization");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_Alert1("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_Alert1("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_TeamName("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 :   Enter a valid mail id
		//Expected : The user can able to enter the valid mail id without any alert message.
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAndAddNewMemberTestDataobj.WE_03_CreateandAddnewmemberEmail);
		base.buttonClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isDoesNotExistBool(ForgotPasswordObj.Ele_Error("commonValidateErr active")), "The user is not able to enter the valid mail id without any alert message.");
	}
	//<summery>
	//Test Case Title : To verify what happens when the user enters a invalid email id in the ADD NEW USER pop up
	//Automation ID : WE_04
	//</summery>
	public void WE_04_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_TestData CreateAndAddNewMemberTestDataobj = new CreateAndAddNewMemberWithOrWithoutEmail_TestData();
		ForgotPassword_Obj ForgotPasswordObj = new ForgotPassword_Obj();

		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_Home("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberOrganization);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("searchTeam")),"User is not able to select any organization");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_Alert1("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_Alert1("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_TeamName("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 :   Enter a invalid mail id
		//Expected : The user should receive a alert message as "Please enter a valid email, the invalid characters are &/\#,+()$~%.^':*?<>{}"
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAndAddNewMemberTestDataobj.WE_04_CreateandAddnewmemberEmail);
		base.buttonClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(ForgotPasswordObj.Ele_Error("commonValidateErr active")), "The user is not receiving a alert message as \"Please enter a valid email, the invalid characters are &/\\#,+()$~%.^':*?<>{}\"");
	}
	//<summery>
	//Test Case Title : To verify what happens when the user keeps the email id field empty in the ADD NEW USER pop up
	//Automation ID : WE_05
	//</summery>
	public void WE_05_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
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
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_Home("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberOrganization);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("searchTeam")),"User is not able to select any organization");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_Alert1("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_Alert1("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_TeamName("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 :   Fill all the fields except Email id
		//Expected : The user should receive an alert message as "User Email is required"
		base.setData(LoginPageObj.Edt_LoginEmail("firstnameNew"), CreateAndAddNewMemberTestDataobj.WE_05_CreateandAddnewmemberFirstName);
		base.setData(LoginPageObj.Edt_LoginEmail("lastnameNew"), CreateAndAddNewMemberTestDataobj.WE_05_CreateandAddnewmemberLastName);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn"));
		base.setData(LoginPageObj.Edt_LoginEmail("newJerseyNumber"), CreateAndAddNewMemberTestDataobj.WE_05_CreateandAddnewmemberJerseyNumber);
		base.setData(CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_TextArea("userCreateMessage"), CreateAndAddNewMemberTestDataobj.WE_05_CreateandAddnewmemberMessage);
		base.buttonClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("User Email is required")), "The user is not receiving an alert message as \"User Email is required\".");		
	}
}