package testPage.MavenPageObject;

import java.util.HashMap;
import java.util.Map;
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
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
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
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
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
		base.buttonClick(LoginPageObj.Edt_AlertMessage("475 Playmakers"));
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
}