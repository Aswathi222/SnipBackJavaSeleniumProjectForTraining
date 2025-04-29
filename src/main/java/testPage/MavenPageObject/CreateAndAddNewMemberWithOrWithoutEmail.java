package testPage.MavenPageObject;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import TestData.CommonData;
import TestData.CreateAndAddNewMemberWithOrWithoutEmail_TestData;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.ForgotPassword_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;

public class CreateAndAddNewMemberWithOrWithoutEmail extends BasePge {
	BasePge base;
	Assert asrt;
	ElementActions element;

	public CreateAndAddNewMemberWithOrWithoutEmail(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
		element = new ElementActions(driver);
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_01_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Observe whether there is a option as Create & Add new member with Email
		//Expected : There should be a option to add user with mail id.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email")), "There is no option to add user with mail id.");
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_02_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_02_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_02_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_02_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_03_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_03_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_03_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_03_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_04_CreateandAddnewmemberOrganization);
		Thread.sleep(3000);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_04_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_04_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_04_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_05_CreateandAddnewmemberOrganization);
		Thread.sleep(3000);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_05_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_05_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_05_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 :   Fill all the fields except Email id
		//Expected : The user should receive an alert message as "User Email is required"
		base.setData(LoginPageObj.Edt_LoginEmail("firstnameNew"), CreateAndAddNewMemberTestDataobj.WE_05_CreateandAddnewmemberFirstName);
		base.setData(LoginPageObj.Edt_LoginEmail("lastnameNew"), CreateAndAddNewMemberTestDataobj.WE_05_CreateandAddnewmemberLastName);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn"));
		base.setData(LoginPageObj.Edt_LoginEmail("newJerseyNumber"), CreateAndAddNewMemberTestDataobj.WE_05_CreateandAddnewmemberJerseyNumber);
		base.setData(CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_TextArea("userCreateMessage"), CreateAndAddNewMemberTestDataobj.WE_05_CreateandAddnewmemberMessage);
		base.buttonClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("User Email is required")), "The user is not receiving an alert message as \"User Email is required\".");		
	}
	//<summery>
	//Test Case Title : To verify what happens when the user enters a valid First Name in the ADD NEW USER pop up
	//Automation ID : WE_06
	//</summery>
	public void WE_06_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_06_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_06_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_06_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_06_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 :   Enter a valid name
		//Expected : The user should able to enter the Name without any alert message.
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAndAddNewMemberTestDataobj.WE_06_CreateandAddnewmemberEmail);
		base.setData(LoginPageObj.Edt_LoginEmail("firstnameNew"), CreateAndAddNewMemberTestDataobj.WE_06_CreateandAddnewmemberFirstName);
		base.buttonClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isDoesNotExistBool(LoginPageObj.Edt_AlertMessage("The User Name must be at least 2 characters.")), "The user is not able to enter the Name without any alert message.");
	}
	//<summery>
	//Test Case Title : To verify what happens when the user enters a invalid First Name in the ADD NEW USER pop up
	//Automation ID : WE_07
	//</summery>
	public void WE_07_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_TestData CreateAndAddNewMemberTestDataobj = new CreateAndAddNewMemberWithOrWithoutEmail_TestData();
		CreateEditDeletePool_Obj CreateEditDeletePoolObj = new CreateEditDeletePool_Obj();

		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		Thread.sleep(5000);
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_07_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_07_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_07_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_07_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 :   Enter a invalid name
		//Expected : The user should receive a alert message as "The User Name must be atleast 2 characters."
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAndAddNewMemberTestDataobj.WE_07_CreateandAddnewmemberEmail);
		base.setData(LoginPageObj.Edt_LoginEmail("firstnameNew"), CreateAndAddNewMemberTestDataobj.WE_07_CreateandAddnewmemberInvalidFirstName);
		base.buttonClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("The User Name must be at least 2 characters.")), "The user is not receiving a alert message as \"The User Name must be atleast 2 characters.\"");
	}
	//<summery>
	//Test Case Title : To verify what happens when the user keeps the First Name field empty in the ADD NEW USER pop up
	//Automation ID : WE_08
	//</summery>
	public void WE_08_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_08_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_08_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_08_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_08_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 :    Fill the fields except Name 
		//Expected : The user should receive a alert message as "First Name is required."
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAndAddNewMemberTestDataobj.WE_08_CreateandAddnewmemberEmail);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn"));
		base.setData(LoginPageObj.Edt_LoginEmail("newJerseyNumber"), CreateAndAddNewMemberTestDataobj.WE_08_CreateandAddnewmemberJerseyNumber);
		base.setData(CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_TextArea("userCreateMessage"), CreateAndAddNewMemberTestDataobj.WE_08_CreateandAddnewmemberMessage);
		base.buttonClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("First name is required")), "The user is not receiving a alert message as \"First Name is required.\"");		
	}
	//<summery>
	//Test Case Title : To verify what happens when try to add user without selecting any role
	//Automation ID : WE_09
	//</summery>
	public void WE_09_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_09_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_09_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_09_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_09_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 :    Fill the fields without selecting any role
		//Expected : The user should automatically add as player in that team.
		element.fillFormFields(
				LoginPageObj.Edt_LoginEmail("emailInputNew"), CreateAndAddNewMemberTestDataobj.WE_09_CreateandAddnewmemberEmail,
				LoginPageObj.Edt_LoginEmail("firstnameNew"), CreateAndAddNewMemberTestDataobj.WE_09_CreateandAddnewmemberFirstName,
				LoginPageObj.Edt_LoginEmail("lastnameNew"), CreateAndAddNewMemberTestDataobj.WE_09_CreateandAddnewmemberLastName,
				LoginPageObj.Edt_LoginEmail("newJerseyNumber"), CreateAndAddNewMemberTestDataobj.WE_09_CreateandAddnewmemberJerseyNumber,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_TextArea("userCreateMessage"), CreateAndAddNewMemberTestDataobj.WE_09_CreateandAddnewmemberMessage);		
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn")), "User role \"Player\" is not enabled");
		base.buttonClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("User Added Successfully!")), "The user is not automatically added as player in that team.");		
	}
	//<summery>
	//Test Case Title : To verify what happens when try to add new user with/without filling  Last Name and Jersey Number field
	//Automation ID : WE_10
	//</summery>
	public void WE_10_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_10_CreateandAddnewmemberOrganization);
		Thread.sleep(3000);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_10_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_10_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_10_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 :    Fill the fields except Last Name and Jersey Number field
		//Expected : The user can able to add new member without any alert message.
		element.fillFormFields(
				LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAndAddNewMemberTestDataobj.WE_10_CreateandAddnewmemberEmail,
				LoginPageObj.Edt_LoginEmail("firstnameNew"), CreateAndAddNewMemberTestDataobj.WE_10_CreateandAddnewmemberFirstName,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_TextArea("userCreateMessage"), CreateAndAddNewMemberTestDataobj.WE_10_CreateandAddnewmemberMessage);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("User Added Successfully!")), "The user is not able to add new member without any alert message.");		
	}
	//<summery>
	//Test Case Title : To verify what happens when try to add new user with/without filling  Message field
	//Automation ID : WE_11
	//</summery>
	public void WE_11_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_11_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_11_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_11_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_11_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 :     Fill the fields except message field
		//Expected : The user can be able to add new member in that team.
		element.fillFormFields(
				LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAndAddNewMemberTestDataobj.WE_11_CreateandAddnewmemberEmail,
				LoginPageObj.Edt_LoginEmail("firstnameNew"), CreateAndAddNewMemberTestDataobj.WE_11_CreateandAddnewmemberFirstName,
				LoginPageObj.Edt_LoginEmail("lastnameNew"), CreateAndAddNewMemberTestDataobj.WE_11_CreateandAddnewmemberLastName,
				LoginPageObj.Edt_LoginEmail("newJerseyNumber"), CreateAndAddNewMemberTestDataobj.WE_11_CreateandAddnewmemberJerseyNumber);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("User Added Successfully!")), "The user is not able to add new member in that team.");		
	}
	//<summery>
	//Test Case Title : To verify what happens when user enters all the required field in ADD NEW USER pop up
	//Automation ID : WE_12
	//</summery>
	public void WE_12_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_12_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_12_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_12_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_12_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 :      Fill the fields to be required
		//Expected : The user can be able to add new member in that team.
		element.fillFormFields(
				LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAndAddNewMemberTestDataobj.WE_12_CreateandAddnewmemberEmail,
				LoginPageObj.Edt_LoginEmail("firstnameNew"),CreateAndAddNewMemberTestDataobj.WE_12_CreateandAddnewmemberFirstName);
		base.buttonClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("User Added Successfully!")), "The user is not able to add new member in that team.");		
	}
	//<summery>
	//Test Case Title : To verify whether the user can be able to switch from Add Single User to Add Multiple User
	//Automation ID : WE_13
	//</summery>
	public void WE_13_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_13_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_13_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_13_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_13_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 : Switch to Add Multiple User
		//Expected : User can be able to switch from Add Single User to Add Multiple User.
		base.buttonClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch from Add Single User to Add Multiple User.");
	}
	//<summery>
	//Test Case Title : To verify whether the user can be able to enter a valid email id
	//Automation ID : WE_14
	//</summery>
	public void WE_14_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_14_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_14_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_14_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_14_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 : Switch to Add Multiple User
		//Expected : User can be able to switch from Add Single User to Add Multiple User.
		base.buttonClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch from Add Single User to Add Multiple User.");

		//Step 9 : Enter a valid email id
		//Expected : The user can able to enter the valid mail id. 
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("user_field_elements ui-autocomplete-input"), CreateAndAddNewMemberTestDataobj.WE_14_CreateandAddnewmemberEmail,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("full_name add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_14_CreateandAddnewmemberFullName,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_user_field_elements"),CreateAndAddNewMemberTestDataobj.WE_14_CreateandAddnewmemberJerseyNumber);
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("add-user-form-control form-select add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_14_CreateandAddnewmemberRole);
		asrt.assertTrue(base.isDoesNotExistBool(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_Error("Please Enter a proper email ID.")), "The user is not able to enter the valid mail id.");		
	}
	//<summery>
	//Test Case Title : To verify what happens when the user enters an invalid email id
	//Automation ID : WE_15
	//</summery>
	public void WE_15_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_15_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_15_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_15_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_15_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 : Switch to Add Multiple User
		//Expected : User can be able to switch from Add Single User to Add Multiple User.
		base.buttonClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch from Add Single User to Add Multiple User.");

		//Step 9 : Enter a invalid email id
		//Expected : User will receive an alert message as "Please Enter a proper email ID."
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("user_field_elements ui-autocomplete-input"), CreateAndAddNewMemberTestDataobj.WE_15_CreateandAddnewmemberInvalidEmail,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("full_name add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_15_CreateandAddnewmemberFullName,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_user_field_elements"),CreateAndAddNewMemberTestDataobj.WE_15_CreateandAddnewmemberJerseyNumber);
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("add-user-form-control form-select add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_15_CreateandAddnewmemberRole);
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_Error("Please Enter a proper email ID.")), "User is not receiving an alert message as \"Please Enter a proper email ID.\"");		
	}
	//<summery>
	//Test Case Title : To verify what happens when user left the email field empty
	//Automation ID : WE_16
	//</summery>
	public void WE_16_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_16_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_16_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_16_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_16_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 : Switch to Add Multiple User
		//Expected : User can be able to switch from Add Single User to Add Multiple User.
		base.buttonClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch from Add Single User to Add Multiple User.");

		//Step 9 : Fill the fields to be required except email id
		//Expected : User will receive an alert message as "Please Enter a proper email ID."
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("full_name add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_16_CreateandAddnewmemberFullName,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_user_field_elements"),CreateAndAddNewMemberTestDataobj.WE_16_CreateandAddnewmemberJerseyNumber);
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("add-user-form-control form-select add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_16_CreateandAddnewmemberRole);
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_Error("Please Enter a proper email ID.")), "User is not receiving an alert message as \"Please Enter a proper email ID.\"");		
	}
	//<summery>
	//Test Case Title : To verify whether the user can be able to enter a valid Full Name
	//Automation ID : WE_17
	//</summery>
	public void WE_17_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_17_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_17_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_17_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_17_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 : Switch to Add Multiple User
		//Expected : User can be able to switch from Add Single User to Add Multiple User.
		base.buttonClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch from Add Single User to Add Multiple User.");

		//Step 9 : Enter a valid Full Name
		//Expected : User can able to add new user.
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("user_field_elements ui-autocomplete-input"), CreateAndAddNewMemberTestDataobj.WE_17_CreateandAddnewmemberEmail,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("full_name add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_17_CreateandAddnewmemberFullName,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_user_field_elements"),CreateAndAddNewMemberTestDataobj.WE_17_CreateandAddnewmemberJerseyNumber);
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("add-user-form-control form-select add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_17_CreateandAddnewmemberRole);
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Btn_Logout("card_2", "add-user-card-options card-remove-btn"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("saveMutipleUsers"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "User is not able to add new user.");		
	}
	//<summery>
	//Test Case Title : To verify whether the user can be able to enter a invalid Full Name
	//Automation ID : WE_18
	//</summery>
	public void WE_18_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_18_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_18_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_18_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_18_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 : Switch to Add Multiple User
		//Expected : User can be able to switch from Add Single User to Add Multiple User.
		base.buttonClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch from Add Single User to Add Multiple User.");

		//Step 9 : Enter a invalid Full Name
		//Expected : User should receive alert message as "User's name should be of minimum 3 characters"
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("user_field_elements ui-autocomplete-input"), CreateAndAddNewMemberTestDataobj.WE_18_CreateandAddnewmemberEmail,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("full_name add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_18_CreateandAddnewmemberInvalidFullName);
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_Error("User's name should be of minimum 3 characters.")), "User is not receiving alert message as \"User's name should be of minimum 3 characters\"");		
	}
	//<summery>
	//Test Case Title : To verify what happens when the user left the Full Name field empty
	//Automation ID : WE_19
	//</summery>
	public void WE_19_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_19_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_19_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_19_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_19_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 : Switch to Add Multiple User
		//Expected : User can be able to switch from Add Single User to Add Multiple User.
		base.buttonClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch from Add Single User to Add Multiple User.");

		//Step 9 : Fill the fields to be required except Full Name
		//Expected : User should receive alert message as "Please Enter the User's name."
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("user_field_elements ui-autocomplete-input"), CreateAndAddNewMemberTestDataobj.WE_19_CreateandAddnewmemberEmail,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_user_field_elements"),CreateAndAddNewMemberTestDataobj.WE_19_CreateandAddnewmemberJerseyNumber);
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("add-user-form-control form-select add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_19_CreateandAddnewmemberRole);
		Thread.sleep(5000);
		base.clearAllText(CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("full_name add_user_field_elements"));
		base.pressKey(CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("full_name add_user_field_elements"), "ENTER");	
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_Error("Please Enter the User's name. ")), "User is not receiving alert message as \"Please Enter the User's name.\"");		
	}
	//<summery>
	//Test Case Title : To verify what happens when try to add user without selecting any role
	//Automation ID : WE_20
	//</summery>
	public void WE_20_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_20_CreateandAddnewmemberOrganization);
		Thread.sleep(5000);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_20_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_20_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_20_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 : Switch to Add Multiple User
		//Expected : User can be able to switch from Add Single User to Add Multiple User.
		base.buttonClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch from Add Single User to Add Multiple User.");

		//Step 9 : Fill the fields to be required except Role
		//Expected : The user should automatically add as player in that team.
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("user_field_elements ui-autocomplete-input"), CreateAndAddNewMemberTestDataobj.WE_20_CreateandAddnewmemberEmail,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("full_name add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_20_CreateandAddnewmemberFullName,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_user_field_elements"),CreateAndAddNewMemberTestDataobj.WE_20_CreateandAddnewmemberJerseyNumber);
		String SelectedText = base.GetText(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SelectedText("selected"));
		asrt.assertEquals(SelectedText, CreateAndAddNewMemberTestDataobj.WE_20_CreateandAddnewmemberRole, "Default role is not set to 'Player'.");
		base.buttonClick(LoginPageObj.Btn_Logout("card_2", "add-user-card-options card-remove-btn"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("saveMutipleUsers"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not automatically added as player in that team.");	
	}
	//<summery>
	//Test Case Title : To verify what happens when try to add new user with/without entering Jersey Number
	//Automation ID : WE_21
	//</summery>
	public void WE_21_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_21_CreateandAddnewmemberOrganization);
		Thread.sleep(5000);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_21_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_21_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_21_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 : Switch to Add Multiple User
		//Expected : User can be able to switch from Add Single User to Add Multiple User.
		base.buttonClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch from Add Single User to Add Multiple User.");

		//Step 9 : Fill the fields to be required except Jersey Number
		//Expected : The user can able to add new member without any alert message.
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("user_field_elements ui-autocomplete-input"), CreateAndAddNewMemberTestDataobj.WE_21_CreateandAddnewmemberEmail,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("full_name add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_21_CreateandAddnewmemberFullName);
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("add-user-form-control form-select add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_21_CreateandAddnewmemberRole);
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Btn_Logout("card_2", "add-user-card-options card-remove-btn"));
		base.buttonClick(LoginPageObj.Btn_SingnIn("saveMutipleUsers"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to add new member without any alert message.");	
	}
	//<summery>
	//Test Case Title : To verify what happens when user enters all the required field in ADD NEW USER pop up
	//Automation ID : WE_22
	//</summery>
	public void WE_22_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_Obj CreateAndAddNewMemberWithOrWithoutEmailObj = new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		CreateAndAddNewMemberWithOrWithoutEmail_TestData CreateAndAddNewMemberTestDataobj = new CreateAndAddNewMemberWithOrWithoutEmail_TestData();

		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		Thread.sleep(5000);
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_22_CreateandAddnewmemberOrganization);
		Thread.sleep(5000);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_22_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_22_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_22_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member with Email
		//Expected : The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")),"The user is not navigated to CREATE NEW USER pop up.");

		//Step 8 : Switch to Add Multiple User
		//Expected : User can be able to switch from Add Single User to Add Multiple User.
		base.buttonClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch from Add Single User to Add Multiple User.");

		//Step 9 : Fill the fields to be required
		//Expected : The user can able to add new member .
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("user_field_elements ui-autocomplete-input"), CreateAndAddNewMemberTestDataobj.WE_22_CreateandAddnewmemberEmail,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Edt_Email("full_name add_user_field_elements"), CreateAndAddNewMemberTestDataobj.WE_22_CreateandAddnewmemberFullName);
		base.buttonClick(LoginPageObj.Btn_Logout("card_2", "add-user-card-options card-remove-btn"));
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Btn_SingnIn("saveMutipleUsers"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to add new member .");	
	}
	//<summery>
	//Test Case Title : To verify whether there is a option to add user without email.
	//Automation ID : WE_23
	//</summery>
	public void WE_23_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_23_CreateandAddnewmemberOrganization);
		Thread.sleep(5000);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_23_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_23_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_23_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Observe whether there is a option as Create & Add new member without Email
		//Expected : There should be a option to add user without mail id.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("Create & Add New Member Without Email")), "There is no option to add user without mail id.");
	}
	//<summery>
	//Test Case Title : To verify whether the user navigates to Add New User Without Email pop up while clicking Create & Add New Member without Email. 
	//Automation ID : WE_24
	//</summery>
	public void WE_24_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_24_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_24_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_24_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_24_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member without Email
		//Expected : The user should navigate to Add New User Without Email pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member Without Email"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_PopupHeading("Add New User Without Email")), "The user is not navigated to Add New User Without Email pop up.");
	}
	//<summery>
	//Test Case Title : To verify what happens when the user enters a valid email id in the Add New User Without Email pop up 
	//Automation ID : WE_25
	//</summery>
	public void WE_25_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_25_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_25_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_25_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_25_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member without Email
		//Expected : The user should navigate to Add New User Without Email pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member Without Email"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_PopupHeading("Add New User Without Email")), "The user is not navigated to Add New User Without Email pop up.");

		//Step 8 : Enter a valid mail id
		//Expected : The user can able to enter the valid mail id. 
		base.setData(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_email add_woemail_field_elements"), CreateAndAddNewMemberTestDataobj.WE_25_CreateandAddnewmemberEmail);
		Thread.sleep(1000);
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Btn_SingnIn("saveMutipleUsersWOEmail")), "The user is not able to enter the valid mail id.");
	}
	//<summery>
	//Test Case Title : To verify what happens when the user enters a invalid email id in the Add New User Without Email pop up
	//Automation ID : WE_26
	//</summery>
	public void WE_26_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_26_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_26_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_26_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_26_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member without Email
		//Expected : The user should navigate to Add New User Without Email pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member Without Email"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_PopupHeading("Add New User Without Email")), "The user is not navigated to Add New User Without Email pop up.");

		//Step 8 : Enter a invalid mail id
		//Expected : The user can able to add new member without any alert message.
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_email add_woemail_field_elements"), CreateAndAddNewMemberTestDataobj.WE_26_CreateandAddnewmemberInvalidEmail,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_name add_woemail_field_elements"),CreateAndAddNewMemberTestDataobj.WE_26_CreateandAddnewmemberFullName,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_jersey add_woemail_field_elements"),CreateAndAddNewMemberTestDataobj.WE_26_CreateandAddnewmemberJerseyNumber);
		base.buttonClick(LoginPageObj.Btn_SingnIn("saveMutipleUsersWOEmail"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to add new member without any alert message.");
	}
	//<summery>
	//Test Case Title : To verify what happens when user kept the email field empty
	//Automation ID : WE_27
	//</summery>
	public void WE_27_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_27_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_27_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_27_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_27_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member without Email
		//Expected : The user should navigate to Add New User Without Email pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member Without Email"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_PopupHeading("Add New User Without Email")), "The user is not navigated to Add New User Without Email pop up.");

		//Step 8 : Fill the fields except Email 
		//Expected : The user can able to add new member with a default mail id.
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_name add_woemail_field_elements"),CreateAndAddNewMemberTestDataobj.WE_27_CreateandAddnewmemberFullName,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_jersey add_woemail_field_elements"),CreateAndAddNewMemberTestDataobj.WE_27_CreateandAddnewmemberJerseyNumber);
		base.buttonClick(LoginPageObj.Btn_SingnIn("saveMutipleUsersWOEmail"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to add new member with a default mail id");
	}
	//<summery>
	//Test Case Title : To verify whether the user can be able to enter a valid Full Name
	//Automation ID : WE_28
	//</summery>
	public void WE_28_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_28_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_28_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_28_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_28_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member without Email
		//Expected : The user should navigate to Add New User Without Email pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member Without Email"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_PopupHeading("Add New User Without Email")), "The user is not navigated to Add New User Without Email pop up.");

		//Step 8 : Enter a valid Full Name
		//Expected : The user can able to add new member.
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_email add_woemail_field_elements"), CreateAndAddNewMemberTestDataobj.WE_28_CreateandAddnewmemberEmail,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_name add_woemail_field_elements"),CreateAndAddNewMemberTestDataobj.WE_28_CreateandAddnewmemberFullName,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_jersey add_woemail_field_elements"),CreateAndAddNewMemberTestDataobj.WE_28_CreateandAddnewmemberJerseyNumber);
		base.buttonClick(LoginPageObj.Btn_SingnIn("saveMutipleUsersWOEmail"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to add new member.");
	}
	//<summery>
	//Test Case Title : To verify whether the user can be able to enter a invalid Full Name
	//Automation ID : WE_29
	//</summery>
	public void WE_29_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_29_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_29_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_29_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_29_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member without Email
		//Expected : The user should navigate to Add New User Without Email pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member Without Email"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_PopupHeading("Add New User Without Email")), "The user is not navigated to Add New User Without Email pop up.");

		//Step 8 : Enter a invalid Full Name
		//Expected : The user will receive alert message as "User's name should be of minimum 3 characters."
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_name add_woemail_field_elements"),CreateAndAddNewMemberTestDataobj.WE_29_CreateandAddnewmemberInvalidFullName,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_jersey add_woemail_field_elements"),CreateAndAddNewMemberTestDataobj.WE_29_CreateandAddnewmemberJerseyNumber);
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_Error("User's name should be of minimum 3 characters.")), "The user is not receiving alert message as \"User's name should be of minimum 3 characters.\"");
	}
	//<summery>
	//Test Case Title : To verify what happens when the user left the Full Name field empty
	//Automation ID : WE_30
	//</summery>
	public void WE_30_CreateAndAddNewMemberWithOrWithoutEmail() throws InterruptedException {	
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
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to login");

		//Step 3 : Select any organization
		//Expected : User should be able to select any organization.
		base.selectorByVisibleText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"), CreateAndAddNewMemberTestDataobj.WE_30_CreateandAddnewmemberOrganization);
		String Text = element.DropDownText(CreateAndAddNewMemberWithOrWithoutEmailObj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Text, CreateAndAddNewMemberTestDataobj.WE_30_CreateandAddnewmemberOrganization, "User is not able to select any organization.");

		//Step 4 : Switch to any Team
		//Expected : User should be able to Switch to any Team.
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAndAddNewMemberTestDataobj.WE_30_CreateandAddnewmemberTeam);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"), "ENTER");
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		String TeamName = base.GetText(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
		asrt.assertEquals(TeamName,CreateAndAddNewMemberTestDataobj.WE_30_CreateandAddnewmemberTeam,"User is not able to Switch to any Team.");

		//Step 5 : Click three dots of that team
		//Expected : User should be able to Click three dots of that team.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_ThreeDots("my-team-content", "defaultDropdown-1"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_list("my-team-content", "teamDropdownMenu-1")), "User is not able to Click three dots of that team");
		Thread.sleep(7000);

		//Step 6 :  Select "Edit Team" option 
		//Expected : User should be able to select "Edit Team" option.
		base.buttonClick(CreateAndAddNewMemberWithOrWithoutEmailObj.Btn_EditTeam("475 Playmakers"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("form-control form-control-wrap")), "User is not able to select \"Edit Team\" option");

		//Step 7 :   Click Create&Add New Member without Email
		//Expected : The user should navigate to Add New User Without Email pop up.
		base.buttonClick(LoginPageObj.Edt_AlertMessage("Create & Add New Member Without Email"));
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_PopupHeading("Add New User Without Email")), "The user is not navigated to Add New User Without Email pop up.");

		//Step 8 : Fill the fields except Full Name
		//Expected : User should receive alert message as "Please Enter the User's name."
		element.fillFormFields(
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_email add_woemail_field_elements"), CreateAndAddNewMemberTestDataobj.WE_30_CreateandAddnewmemberEmail,
				CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_jersey add_woemail_field_elements"),CreateAndAddNewMemberTestDataobj.WE_30_CreateandAddnewmemberJerseyNumber);
		base.clearAllText(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_name add_woemail_field_elements"));
		base.pressKey(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_SearchGame("add-user-form-control add_woemail_name add_woemail_field_elements"), "ENTER");
		asrt.assertTrue(base.isExists(CreateAndAddNewMemberWithOrWithoutEmailObj.Ele_Error("Please Enter the User's name. ")), "User is not receiving alert message as \"Please Enter the User's name.\"");
	}
}