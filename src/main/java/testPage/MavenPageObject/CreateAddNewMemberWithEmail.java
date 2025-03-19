package testPage.MavenPageObject;
import TestData.ForgotPassword_TestData;
import TestData.PublicGameListing_TestData;
import TestData.Registration_TestData;
import TestData.SnipBackLogin_TestData;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import TestData.CommonData;
import TestData.CreateAddNewMemberWithEmail_TestData;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.ViewProfile_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.ForgotPassword_Obj;
import objectRepository.HighlightReels_Obj;
import utilPack.BasePge;


public class CreateAddNewMemberWithEmail extends BasePge {

	BasePge base;
	Assert asrt;

	public CreateAddNewMemberWithEmail(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	
	// <summary>
	// Test Case Title : "To verify whether there is a option to add user with email."
	// Automation ID   : WE_01
	// </summary>
	public void WE_01_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_01_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_01_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_01_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_01_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_01_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_01_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : User should be navigated to the Edit team page
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_01_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");
	}
	
	// <summary>
	// Test Case Title : "To verify whether the user navigates to ADD NEW USER pop up while clicking Create & Add New Member with Email. "
	// Automation ID   : WE_02
	// </summary>
	public void WE_02_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_02_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_02_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_02_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_02_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_02_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_02_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_02_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");
	}

	// <summary>
	// Test Case Title : "To verify what happens when the user enters a valid email id in the ADD NEW USER pop up"
	// Automation ID   : WE_03
	// </summary>
	public void WE_03_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_03_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_03_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_03_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_03_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_03_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_03_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_03_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		// Step 9 : Enter a valid email id in Enter Email Address field
		// Expected : The user should enter the valid mail id without any alert message.
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemberWithEmailTestData.WE_03_ValidEmailAddress);
		//base.isDoesNotExist(CreateAddNewMemberWithEmailObj.Ele_CommonError("emailInputNew","commonValidateErr active"),"Are you sure want to delete this view? popup is not closed");  
		List<WebElement> errorElements = driver.findElements(By.className("commonValidateErr active")); 
		if (!errorElements.isEmpty()) {
			System.out.println("Error message is present: " + errorElements.get(0).getText());
		} else {
			System.out.println("Error message is not displayed, as the email is valid.");
		}
	}	
	
	//<summary>
	//TestCase Title : To verify what happens when the user enters an invalid email id in the ADD NEW USER pop up.
	//Automation Id : WE_04
	// </summary>
	public void WE_04_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_04_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_04_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_04_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_04_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_04_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_04_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_04_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		// Step 9 : Enter an invalid email id in Enter Email Address field in Add User PopUp
		// Expected : The user should receive a alert message as "Please enter a valid email, the invalid characters are &/\#,+()$~%.^':*?<>{}"
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemberWithEmailTestData.WE_04_InValidEmailAddress);
		String ActualEmail=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInputNew"));
		asrt.assertEquals(ActualEmail,CreateAddNewMemberWithEmailTestData.WE_04_InValidEmailAddress,"The actual and given email doesn't match");
		Thread.sleep(3000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_CommonErrorClick("add_single_user","user_role","USER ROLE"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_CommonError("emailInputNew","commonValidateErr active")),"User not receives an alert message as \"Please enter a valid email, the invalid characters are &/\\#,+()$~%.^':*?<>{}\" while entering an invalid emailid.");
	}	
	
	//<summary>
	//TestCase Title : To verify what happens when the user keeps the email id field empty in the ADD NEW USER pop up.
	//Automation Id : WE_05
	// </summary>
	public void WE_05_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_05_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_05_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_05_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_05_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_05_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_05_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_05_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");
		
		// Step 9 : Enter the First Name,Last Name,User Role,Jersey Number and mesage, but Leave the email id field in the Enter Email Address field in Add User PopUp,blank.
		// Expected : The user should receive an alert message as "User Email is required"
		
		//Enter the 'First Name'
		base.setData(LoginPageObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemberWithEmailTestData.WE_05_FirstName);
		String ActualFname=base.GetValue(LoginPageObj.Edt_LoginEmail("firstnameNew"));
		asrt.assertEquals(ActualFname, CreateAddNewMemberWithEmailTestData.WE_05_FirstName,"The Actual and expected First name doesn't match in the Add User PopUp");
		
		//Enter the 'Last Name'
		base.setData(LoginPageObj.Edt_LoginEmail("lastnameNew"), CreateAddNewMemberWithEmailTestData.WE_05_LastName);
		String ActualLname=base.GetValue(LoginPageObj.Edt_LoginEmail("lastnameNew"));
		asrt.assertEquals(ActualLname, CreateAddNewMemberWithEmailTestData.WE_05_LastName,"The Actual and expected Last name doesn't match in the Add User PopUp");
		
		//Select the 'User Role'
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn"));
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn")).isSelected(),"Unable to select the 'Player radio button' in the Add User PopUp .");
		
		//Enter the 'Jersey Number'
		base.setData(LoginPageObj.Edt_LoginEmail("newJerseyNumber"),CreateAddNewMemberWithEmailTestData.WE_05_JerseyNum );
		String ActualJersey= base.GetValue(LoginPageObj.Edt_LoginEmail("newJerseyNumber"));
		asrt.assertEquals(ActualJersey,CreateAddNewMemberWithEmailTestData.WE_05_JerseyNum,"The Actual and expected 'Jersey Number' doesn't match in the Add User PopUp");
		
		//Enter the 'Email Message'
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("userCreateMessage"), CreateAddNewMemberWithEmailTestData.WE_05_EmailMessage);
		Thread.sleep(3000);
		
		//Click on Create button
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("User Email is required")),"Alert message is not shown as 'User Email is required' when leaves the email field as blank in Add User PopUp");
	}	
	
	// <summary>
	// Test Case Title : "To verify what happens when the user enters a valid First Name in the ADD NEW USER pop up"
	// Automation ID : WE_06
	// </summary>
	public void WE_06_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_06_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_06_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_06_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_06_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_06_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_06_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_06_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		// Step 9 : Enter a valid email id in Enter Email Address field
		// Expected : The user should enter the valid mail id without any alert message.
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemberWithEmailTestData.WE_06_ValidEmailAddress);
		String ActualEmailID=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInputNew"));
		asrt.assertEquals(ActualEmailID, CreateAddNewMemberWithEmailTestData.WE_06_ValidEmailAddress,"The Actual and expected 'EmailID' doesn't match in the Add User PopUp");

		// Step 10 : Enter valid first name in the First Name field 
		// Expected : User is able to enter the Name without any alert message
		base.setData(LoginPageObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemberWithEmailTestData.WE_06_FirstName);
		String ActualFname=base.GetValue(LoginPageObj.Edt_LoginEmail("firstnameNew"));
		asrt.assertEquals(ActualFname, CreateAddNewMemberWithEmailTestData.WE_06_FirstName,"User unable to enter the First Name without any alert message");
	}
	
	// <summary>
	// Test Case Title : "To verify what happens when the user enters a invalid First Name in the ADD NEW USER pop up"
	// Automation ID : WE_07
	// </summary>
	public void WE_07_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_07_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_07_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_07_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_07_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_07_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_07_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_07_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		// Step 9 : Enter a valid email id in Enter Email Address field
		// Expected : The user should enter the valid mail id without any alert message.
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemberWithEmailTestData.WE_07_ValidEmailAddress);
		String ActualEmailID=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInputNew"));
		asrt.assertEquals(ActualEmailID, CreateAddNewMemberWithEmailTestData.WE_07_ValidEmailAddress,"The Actual and expected 'EmailID' doesn't match in the Add User PopUp");

		// Step 10 : Enter invalid first name in the First Name field 
		// Expected : User should enter the invalid Name 
		base.setData(LoginPageObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemberWithEmailTestData.WE_07_FirstName);
		String ActualFname=base.GetValue(LoginPageObj.Edt_LoginEmail("firstnameNew"));
		asrt.assertEquals(ActualFname, CreateAddNewMemberWithEmailTestData.WE_07_FirstName,"User unable to enter the invalid First Name");
		
		// Step 11 : Click on ADD AS PLAYER / USER TO ORGANIZATION button
		// Expected : The user should receive a alert message as "The User Name must be atleast 2 characters."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("The User Name must be at least 2 characters.")), "The user not receiving a alert message as 'The User Name must be atleast 2 characters'");
	}
	
	// <summary>
	// Test Case Title : "To verify what happens when the user keeps the First Name field empty in the ADD NEW USER pop up"
	// Automation ID : WE_08_CreateAddNewMemberWithEmail
	// </summary>
	public void WE_08_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_08_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_08_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_08_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_08_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_08_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_08_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_08_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		// Step 9 : Enter a valid email id in Enter Email Address field
		// Expected : The user should enter the valid mail id without any alert message.
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemberWithEmailTestData.WE_08_ValidEmailAddress);
		String ActualEmailID=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInputNew"));
		asrt.assertEquals(ActualEmailID, CreateAddNewMemberWithEmailTestData.WE_08_ValidEmailAddress,"The Actual and expected 'EmailID' doesn't match in the Add User PopUp");

		// Step 10 : Click on ADD AS PLAYER / USER TO ORGANIZATION button
		// Expected : The user should receive a alert message as "First Name is required."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("First name is required")), "The user do not receive an alert message as First Name is required.");
	}

	// <summary>
	// Test Case Title : "To verify what happens when try to add user without selecting any role"
	// Automation ID : WE_09
	// </summary>
	public void WE_09_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
	    
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_09_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_09_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_09_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_09_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_09_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_09_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_09_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		// Step 9 : Enter a valid email id in Enter Email Address field
		// Expected : The user should enter the valid mail id without any alert message.
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemberWithEmailTestData.WE_09_ValidEmailAddress);
		String ActualEmailID=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInputNew"));
		asrt.assertEquals(ActualEmailID, CreateAddNewMemberWithEmailTestData.WE_09_ValidEmailAddress,"The Actual and expected 'EmailID' doesn't match in the Add User PopUp");

		// Step 10 : Enter valid first name in the First Name field 
		// Expected : User is able to enter the Name without any alert message
		base.setData(LoginPageObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemberWithEmailTestData.WE_09_FirstName);
		String ActualFname=base.GetValue(LoginPageObj.Edt_LoginEmail("firstnameNew"));
		asrt.assertEquals(ActualFname, CreateAddNewMemberWithEmailTestData.WE_09_FirstName,"User unable to enter the First Name without any alert message");
		
		// Step 11 : Enter valid Last name in the First Name field 
		// Expected : User should enter the last Name without any alert message
		base.setData(LoginPageObj.Edt_LoginEmail("lastnameNew"), CreateAddNewMemberWithEmailTestData.WE_09_LastName);
		String ActualLname=base.GetValue(LoginPageObj.Edt_LoginEmail("lastnameNew"));
		asrt.assertEquals(ActualLname, CreateAddNewMemberWithEmailTestData.WE_09_LastName,"User unable to enter the last Name without any alert message");
		
		//Step 12 : Enter the 'Jersey Number'
		//Expected : User should enter the jersey number without any alert message
		base.setData(LoginPageObj.Edt_LoginEmail("newJerseyNumber"),CreateAddNewMemberWithEmailTestData.WE_09_JerseyNum );
		String ActualJersey= base.GetValue(LoginPageObj.Edt_LoginEmail("newJerseyNumber"));
		asrt.assertEquals(ActualJersey,CreateAddNewMemberWithEmailTestData.WE_09_JerseyNum,"User unable to enter the jersey number without any alert message");
		
		//Step 13 : Enter the 'Email Message'
		//Expected : User should enter the email message
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("userCreateMessage"), CreateAddNewMemberWithEmailTestData.WE_09_EmailMessage);
		Thread.sleep(3000);

		// Step 14 : Click on ADD AS PLAYER / USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("User Added Successfully!")), "The user is not able to view 'User Added Successfully popup' while creating a member");

		// Step 15 : Click on OK button
		// Expected : The user should be able to see the list of Members added
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user unable to see the list of Members added");

		// Step 16 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(CreateAddNewMemberWithEmailTestData.WE_09_FirstName+" "+CreateAddNewMemberWithEmailTestData.WE_09_LastName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_09_FirstName+" "+CreateAddNewMemberWithEmailTestData.WE_09_LastName),"teamCheckBox")), "The user is not automatically added as player in that team");
		
		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_09_FirstName+" "+CreateAddNewMemberWithEmailTestData.WE_09_LastName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}

	// <summary>
	// Test Case Title : "To verify what happens when try to add new user with/without filling Last Name and Jersey Number field"
	// Automation ID : WE_10
	// </summary>
	public void WE_10_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
	    
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_10_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_10_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_10_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_10_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_10_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_10_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_10_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		// Step 9 : Enter a valid email id in Enter Email Address field
		// Expected : The user should enter the valid mail id without any alert message.
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemberWithEmailTestData.WE_10_ValidEmailAddress);
		String ActualEmailID=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInputNew"));
		asrt.assertEquals(ActualEmailID, CreateAddNewMemberWithEmailTestData.WE_10_ValidEmailAddress,"The Actual and expected 'EmailID' doesn't match in the Add User PopUp");

		// Step 10 : Enter valid first name in the First Name field 
		// Expected : User is able to enter the Name without any alert message
		base.setData(LoginPageObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemberWithEmailTestData.WE_10_FirstName);
		String ActualFname=base.GetValue(LoginPageObj.Edt_LoginEmail("firstnameNew"));
		asrt.assertEquals(ActualFname, CreateAddNewMemberWithEmailTestData.WE_10_FirstName,"User unable to enter the First Name without any alert message");
		
		//Step 11 : Select the 'User Role'
		//Expected : User should select any one of the user role
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn"));
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn")).isSelected(),"Unable to select the 'Player radio button' in the Add User PopUp .");

		//Step 12 : Enter the 'Email Message'
		//Expected : User should enter the email message
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("userCreateMessage"), CreateAddNewMemberWithEmailTestData.WE_10_EmailMessage);
		Thread.sleep(3000);
		
		// Step 13 : Click on ADD AS PLAYER / USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("User Added Successfully!")), "The user is not able to view 'User Added Successfully popup' while creating a member");

		// Step 14 : Click on OK button
		// Expected : The user should be able to see the list of Members added
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user unable to see the list of Members added");

		// Step 15 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),CreateAddNewMemberWithEmailTestData.WE_10_FirstName);
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers(CreateAddNewMemberWithEmailTestData.WE_10_FirstName,"teamCheckBox")), "The user is not automatically added as player in that team");
		
		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers(CreateAddNewMemberWithEmailTestData.WE_10_FirstName,"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}	
	
	// <summary>
	// Test Case Title : "To verify what happens when try to add new user with/without filling  Message field"
	// Automation ID : WE_11
	// </summary>
	public void WE_11_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
	    
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_11_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_11_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_11_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_11_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_11_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_11_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_11_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		// Step 9 : Enter a valid email id in Enter Email Address field
		// Expected : The user should enter the valid mail id without any alert message.
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemberWithEmailTestData.WE_11_ValidEmailAddress);
		String ActualEmailID=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInputNew"));
		asrt.assertEquals(ActualEmailID, CreateAddNewMemberWithEmailTestData.WE_11_ValidEmailAddress,"The Actual and expected 'EmailID' doesn't match in the Add User PopUp");

		// Step 10 : Enter valid first name in the First Name field 
		// Expected : User is able to enter the Name without any alert message
		base.setData(LoginPageObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemberWithEmailTestData.WE_11_FirstName);
		String ActualFname=base.GetValue(LoginPageObj.Edt_LoginEmail("firstnameNew"));
		asrt.assertEquals(ActualFname, CreateAddNewMemberWithEmailTestData.WE_11_FirstName,"User unable to enter the First Name without any alert message");
		
		//Step 11 : Enter the 'Last Name'
		//Expected : User is able to enter the last Name 
		base.setData(LoginPageObj.Edt_LoginEmail("lastnameNew"), CreateAddNewMemberWithEmailTestData.WE_11_LastName);
		String ActualLname=base.GetValue(LoginPageObj.Edt_LoginEmail("lastnameNew"));
		asrt.assertEquals(ActualLname, CreateAddNewMemberWithEmailTestData.WE_11_LastName,"The Actual and expected Last name doesn't match in the Add User PopUp");
		
		//Step 12 : Select the 'User Role'
		//Expected : User should select any one of the user role
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn"));
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn")).isSelected(),"Unable to select the 'Player radio button' in the Add User PopUp .");
		
		//Step 13 : Enter the 'Jersey Number'
		base.setData(LoginPageObj.Edt_LoginEmail("newJerseyNumber"),CreateAddNewMemberWithEmailTestData.WE_11_JerseyNum );
		String ActualJersey= base.GetValue(LoginPageObj.Edt_LoginEmail("newJerseyNumber"));
		asrt.assertEquals(ActualJersey,CreateAddNewMemberWithEmailTestData.WE_11_JerseyNum,"The Actual and expected 'Jersey Number' doesn't match in the Add User PopUp");
		
		// Step 14 : Click on ADD AS PLAYER / USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("User Added Successfully!")), "The user is not able to view 'User Added Successfully popup' while creating a member");

		// Step 15 : Click on OK button
		// Expected : The user should be able to see the list of Members added
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user unable to see the list of Members added");

		// Step 16 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(CreateAddNewMemberWithEmailTestData.WE_11_FirstName+" "+CreateAddNewMemberWithEmailTestData.WE_11_LastName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_11_FirstName+" "+CreateAddNewMemberWithEmailTestData.WE_11_LastName),"teamCheckBox")), "The user is not automatically added as player in that team");
		
		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_11_FirstName+" "+CreateAddNewMemberWithEmailTestData.WE_11_LastName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}

	// <summary>
	// Test Case Title : "To verify what happens when user enters all the required field in ADD NEW USER pop up"
	// Automation ID : WE_12
	// </summary>
	public void WE_12_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    HighlightReels_Obj HighlightReelsObj = new HighlightReels_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
	    
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_12_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_12_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_12_TeamName));
		Thread.sleep(3000);
		base.pressKey(null, "KEYBOARD_ENTER");
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_12_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_12_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_12_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_12_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		// Step 9 : Enter a valid email id in Enter Email Address field
		// Expected : The user should enter the valid mail id without any alert message.
		base.setData(LoginPageObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemberWithEmailTestData.WE_12_ValidEmailAddress);
		String ActualEmailID=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInputNew"));
		asrt.assertEquals(ActualEmailID, CreateAddNewMemberWithEmailTestData.WE_12_ValidEmailAddress,"The Actual and expected 'EmailID' doesn't match in the Add User PopUp");

		// Step 10 : Enter valid first name in the First Name field 
		// Expected : User is able to enter the Name without any alert message
		base.setData(LoginPageObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemberWithEmailTestData.WE_12_FirstName);
		String ActualFname=base.GetValue(LoginPageObj.Edt_LoginEmail("firstnameNew"));
		asrt.assertEquals(ActualFname, CreateAddNewMemberWithEmailTestData.WE_12_FirstName,"User unable to enter the First Name without any alert message");
		
		//Step 11 : Enter the 'Last Name'
		//Expected : User is able to enter the last Name 
		base.setData(LoginPageObj.Edt_LoginEmail("lastnameNew"), CreateAddNewMemberWithEmailTestData.WE_12_LastName);
		String ActualLname=base.GetValue(LoginPageObj.Edt_LoginEmail("lastnameNew"));
		asrt.assertEquals(ActualLname, CreateAddNewMemberWithEmailTestData.WE_12_LastName,"The Actual and expected Last name doesn't match in the Add User PopUp");
		
		//Step 12 : Select the 'User Role'
		//Expected : User should select any one of the user role
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn"));
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail("createPlayerRadioBtn")).isSelected(),"Unable to select the 'Player radio button' in the Add User PopUp .");
		
		//Step 13 : Enter the 'Jersey Number'
		base.setData(LoginPageObj.Edt_LoginEmail("newJerseyNumber"),CreateAddNewMemberWithEmailTestData.WE_12_JerseyNum );
		String ActualJersey= base.GetValue(LoginPageObj.Edt_LoginEmail("newJerseyNumber"));
		asrt.assertEquals(ActualJersey,CreateAddNewMemberWithEmailTestData.WE_12_JerseyNum,"The Actual and expected 'Jersey Number' doesn't match in the Add User PopUp");
		
		//Step 14 : Enter the 'Email Message'
		//Expected : User should enter the email message
		base.setData(CreateAddNewMemberWithEmailObj.Ele_AddUserMessagebox("userCreateMessage"), CreateAddNewMemberWithEmailTestData.WE_12_EmailMessage);
		Thread.sleep(3000);
		
		// Step 15 : Click on ADD AS PLAYER / USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("createUserBtn"));
		Thread.sleep(3000);		
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("User Added Successfully!")), "The user is not able to view 'User Added Successfully popup' while creating a member");

		// Step 16 : Click on OK button
		// Expected : The user should be able to see the list of Members added
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user unable to see the list of Members added");

		// Step 17 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(CreateAddNewMemberWithEmailTestData.WE_12_FirstName+" "+CreateAddNewMemberWithEmailTestData.WE_12_LastName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_12_FirstName+" "+CreateAddNewMemberWithEmailTestData.WE_12_LastName),"teamCheckBox")), "The user is not automatically added as player in that team");
		
		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_12_FirstName+" "+CreateAddNewMemberWithEmailTestData.WE_12_LastName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}

	// <summary>
	// Test Case Title :"To verify whether the user can be able to switch from Add Single User to Add Multiple User"
	// Automation ID   : WE_13
	// </summary>
	public void WE_13_CreateAddNewMemberWithEmail() throws InterruptedException 
	{ 
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_13_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_13_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_13_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_13_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_13_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_13_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_13_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		//Step 9   :"Switch to Add Multiple Users"
		//Expected :"User able to switch to Add Multiple Users"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch to Add Multiple User mode");
	}	
	
	// <summary>
	// Test Case Title :"To verify whether the user can be able to enter a valid email id"
	// Automation ID   : WE_14
	// </summary>
	public void WE_14_CreateAddNewMemberWithEmail() throws InterruptedException 
	{ 
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_14_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_14_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_14_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_14_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_14_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_14_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_14_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		//Step 9 : "Switch to Add Multiple Users"
		//Expected : "User able to switch to Add Multiple Users"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch to Add Multiple User mode");

		// Step 10 : Enter a valid email id
		// Expected : User able to enter a valid EmailID
		base.setData(LoginPageObj.Edt_LoginEmail("email_1"), CreateAddNewMemberWithEmailTestData.WE_14_ValidEmailAddress);
		Thread.sleep(3000);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("email_1"));
		Assert.assertEquals(Email, CreateAddNewMemberWithEmailTestData.WE_14_ValidEmailAddress, "User unable to enter valid Email in the add multiple user page");
	}

	// <summary>
	// Test Case Title :"To verify what happens when the user enters an invalid email id"
	// Automation ID   : WE_15
	// </summary>
	public void WE_15_CreateAddNewMemberWithEmail() throws InterruptedException 
	{ 
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    Registration_Obj RegistrationObj= new Registration_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_15_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_15_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_15_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_15_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_15_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_15_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_15_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		//Step 9 : "Switch to Add Multiple Users"
		//Expected : "User able to switch to Add Multiple Users"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch to Add Multiple User mode");

		// Step 10 : Enter a Invalid email id
		// Expected : User will receive an alert message as "Please Enter a proper email ID."
		base.setData(LoginPageObj.Edt_LoginEmail("email_1"), CreateAddNewMemberWithEmailTestData.WE_15_ValidEmailAddress);
		Thread.sleep(3000);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("email_1"));
		Assert.assertEquals(Email, CreateAddNewMemberWithEmailTestData.WE_15_ValidEmailAddress, "User unable to enter invalid Email in the add multiple user page");
		
		base.buttonClick(PoolObj.Ele_SelectPoolType("Player"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Player")), "User unable to select any role ");
		
		base.setData(LoginPageObj.Edt_LoginEmail("jersey_1"), CreateAddNewMemberWithEmailTestData.WE_15_JerseyNumber);
		String JersyNum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_1"));
		asrt.assertEquals(JersyNum, CreateAddNewMemberWithEmailTestData.WE_15_JerseyNumber,"Entered Number is not visible in Jersy Number field");
		
		base.setData(CreateAddNewMemberWithEmailObj.Ele_FullNameField("add_user_fields","full_name[]"), CreateAddNewMemberWithEmailTestData.WE_15_FullName);
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("Please Enter a proper email ID.")), "User not receives an alert message as 'Please Enter a proper email ID.'");
	}
	
	// <summary>
	// Test Case Title : "To verify what happens when user left the email field empty"
	// Automation ID : WE_16
	// </summary>
	public void WE_16_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    Registration_Obj RegistrationObj= new Registration_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_16_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_16_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_16_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_16_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_16_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_16_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_16_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		//Step 9 : "Switch to Add Multiple Users"
		//Expected : "User able to switch to Add Multiple Users"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch to Add Multiple User mode");

		// Step 10 : Fill the fields to be required except email id
		// Expected : User will receive an alert message as "Please Enter a proper email ID."
		base.buttonClick(PoolObj.Ele_SelectPoolType("Player"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Player")), "User unable to select any role ");
		
		base.setData(LoginPageObj.Edt_LoginEmail("jersey_1"), CreateAddNewMemberWithEmailTestData.WE_16_JerseyNumber);
		String JersyNum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_1"));
		asrt.assertEquals(JersyNum, CreateAddNewMemberWithEmailTestData.WE_16_JerseyNumber,"Entered Number is not visible in Jersy Number field");
		
		base.setData(CreateAddNewMemberWithEmailObj.Ele_FullNameField("add_user_fields","full_name[]"), CreateAddNewMemberWithEmailTestData.WE_16_FullName);
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_ErrorMessage("Please Enter a proper email ID.")), "User not receives an alert message as 'Please Enter a proper email ID.'");
	}

	// <summary>
	// Test Case Title : "To verify whether the user can be able to enter a valid Full Name"
	// Automation ID : WE_17
	// </summary>
	public void WE_17_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    Registration_Obj RegistrationObj= new Registration_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_17_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_17_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_17_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_17_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_17_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_17_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_17_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		//Step 9 : "Switch to Add Multiple Users"
		//Expected : "User able to switch to Add Multiple Users"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch to Add Multiple User mode");

		// Step 10 : Enter a valid Full Name
		// Expected : User can able to add new user.
		base.setData(LoginPageObj.Edt_LoginEmail("email_1"), CreateAddNewMemberWithEmailTestData.WE_17_ValidEmailAddress);
		Thread.sleep(3000);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("email_1"));
		Assert.assertEquals(Email, CreateAddNewMemberWithEmailTestData.WE_17_ValidEmailAddress, "User unable to enter invalid Email in the add multiple user page");
		
		base.buttonClick(PoolObj.Ele_SelectPoolType("Player"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Player")), "User unable to select any role ");
		
		base.setData(LoginPageObj.Edt_LoginEmail("jersey_1"), CreateAddNewMemberWithEmailTestData.WE_17_JerseyNumber);
		String JersyNum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_1"));
		asrt.assertEquals(JersyNum, CreateAddNewMemberWithEmailTestData.WE_17_JerseyNumber,"Entered Number is not visible in Jersy Number field");
		
		base.setData(CreateAddNewMemberWithEmailObj.Ele_FullNameField("add_user_fields","full_name[]"), CreateAddNewMemberWithEmailTestData.WE_17_FullName);
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("New User 2")),"User unable to view the add new user option");
	}
	
	// <summary>
	// Test Case Title : "To verify whether the user can be able to enter a invalid Full Name"
	// Automation ID : WE_18
	// </summary>
	public void WE_18_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    Registration_Obj RegistrationObj= new Registration_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_18_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_18_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_18_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_18_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_18_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_18_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_18_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		//Step 9 : "Switch to Add Multiple Users"
		//Expected : "User able to switch to Add Multiple Users"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch to Add Multiple User mode");

		// Step 10 : Enter a Invalid Full Name
		// Expected : User should receive alert message as "User's name should be of minimum 3 characters"
		base.setData(LoginPageObj.Edt_LoginEmail("email_1"), CreateAddNewMemberWithEmailTestData.WE_18_ValidEmailAddress);
		Thread.sleep(3000);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("email_1"));
		Assert.assertEquals(Email, CreateAddNewMemberWithEmailTestData.WE_18_ValidEmailAddress, "User unable to enter invalid Email in the add multiple user page");
		
		base.buttonClick(PoolObj.Ele_SelectPoolType("Player"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Player")), "User unable to select any role ");
		
		base.setData(LoginPageObj.Edt_LoginEmail("jersey_1"), CreateAddNewMemberWithEmailTestData.WE_18_JerseyNumber);
		String JersyNum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_1"));
		asrt.assertEquals(JersyNum, CreateAddNewMemberWithEmailTestData.WE_18_JerseyNumber,"Entered Number is not visible in Jersy Number field");
		
		base.setData(CreateAddNewMemberWithEmailObj.Ele_FullNameField("add_user_fields","full_name[]"), CreateAddNewMemberWithEmailTestData.WE_18_InValidFullName);
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_ErrorMsgFName("User's name should be of minimum 3 characters.")), "User not receives an alert message as 'User's name should be of minimum 3 characters'");
	}	

	// <summary>
	// Test Case Title : "To verify what happens when the user left the Full Name field empty"
	// Automation ID : WE_19
	// </summary>
	public void WE_19_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    Registration_Obj RegistrationObj= new Registration_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_19_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_19_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_19_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_19_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_19_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_19_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_19_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		//Step 9 : "Switch to Add Multiple Users"
		//Expected : "User able to switch to Add Multiple Users"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch to Add Multiple User mode");

		// Step 10 : Fill the fields to be required except Full Name
		// Expected : User should receive alert message as "Please Enter the User's name."
		base.setData(LoginPageObj.Edt_LoginEmail("email_1"), CreateAddNewMemberWithEmailTestData.WE_19_ValidEmailAddress);
		Thread.sleep(3000);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("email_1"));
		Assert.assertEquals(Email, CreateAddNewMemberWithEmailTestData.WE_19_ValidEmailAddress, "User unable to enter invalid Email in the add multiple user page");
		
		base.buttonClick(PoolObj.Ele_SelectPoolType("Player"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Player")), "User unable to select any role ");
		
		base.setData(LoginPageObj.Edt_LoginEmail("jersey_1"), CreateAddNewMemberWithEmailTestData.WE_19_JerseyNumber);
		String JersyNum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_1"));
		asrt.assertEquals(JersyNum, CreateAddNewMemberWithEmailTestData.WE_19_JerseyNumber,"Entered Number is not visible in Jersy Number field");
		
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_FullNameField("add_user_fields","full_name[]"));
		base.backspaces(CreateAddNewMemberWithEmailObj.Ele_FullNameField("add_user_fields","full_name[]"),4);
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_ErrorMsgFName("Please Enter the User's name. ")), "User not receives an alert message as 'Please Enter the User's name.'");
	}

	// <summary>
	// Test Case Title : "To verify what happens when try to add user without selecting any role"
	// Automation ID : WE_20
	// </summary>
	public void WE_20_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    Registration_Obj RegistrationObj= new Registration_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_20_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_20_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_20_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_20_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_20_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_20_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_20_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		//Step 9 : "Switch to Add Multiple Users"
		//Expected : "User able to switch to Add Multiple Users"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch to Add Multiple User mode");

		// Step 10 : Fill the fields to be required except Role
		// Expected : User can able to enter all the remaining fields except use role
		base.setData(LoginPageObj.Edt_LoginEmail("email_1"), CreateAddNewMemberWithEmailTestData.WE_20_ValidEmailAddress);
		Thread.sleep(3000);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("email_1"));
		Assert.assertEquals(Email, CreateAddNewMemberWithEmailTestData.WE_20_ValidEmailAddress, "User unable to enter invalid Email in the add multiple user page");
		
		base.setData(LoginPageObj.Edt_LoginEmail("jersey_1"), CreateAddNewMemberWithEmailTestData.WE_20_JerseyNumber);
		String JersyNum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_1"));
		asrt.assertEquals(JersyNum, CreateAddNewMemberWithEmailTestData.WE_20_JerseyNumber,"Entered Number is not visible in Jersy Number field");
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_CloseBtn("add-user-card-header","New User 2","add-user-card-options card-remove-btn"));
		Thread.sleep(3000);
		
		// Step 11 : Click on ADD USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("saveMutipleUsers"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to view 'User Added Successfully popup' while creating a member");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user is not automatically add as player in that team.");

		// Step 12 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(CreateAddNewMemberWithEmailTestData.WE_20_FullName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_20_FullName),"teamCheckBox")), "The user is not automatically added as player in that team");
		
		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_20_FullName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}

	// <summary>
	// Test Case Title : "To verify what happens when try to add new user with/without entering Jersey Number"
	//Automation ID : WE_21
	// </summary>
	public void WE_21_CreateAddNewMemberWithEmail() throws InterruptedException 
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    Registration_Obj RegistrationObj= new Registration_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_21_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_21_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_21_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_21_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_21_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_21_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_21_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		//Step 9 : "Switch to Add Multiple Users"
		//Expected : "User able to switch to Add Multiple Users"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch to Add Multiple User mode");

		// Step 10 : Fill the fields to be required Jersey Number
		// Expected : User can able to enter all the remaining fields except use role
		base.setData(LoginPageObj.Edt_LoginEmail("email_1"), CreateAddNewMemberWithEmailTestData.WE_21_ValidEmailAddress);
		Thread.sleep(3000);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("email_1"));
		Assert.assertEquals(Email, CreateAddNewMemberWithEmailTestData.WE_21_ValidEmailAddress, "User unable to enter invalid Email in the add multiple user page");
		
		base.buttonClick(PoolObj.Ele_SelectPoolType("Player"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Player")), "User unable to select any role ");
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_CloseBtn("add-user-card-header","New User 2","add-user-card-options card-remove-btn"));
		Thread.sleep(3000);
		
		// Step 11 : Click on ADD USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("saveMutipleUsers"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to view 'User Added Successfully popup' while creating a member");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user is not automatically add as player in that team.");

		// Step 12 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(CreateAddNewMemberWithEmailTestData.WE_21_FullName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_21_FullName),"teamCheckBox")), "The user is not automatically added as player in that team");
		
		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_21_FullName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}

	// <summary>
	// Test Case Title : "To verify what happens when user enters all the required field in ADD NEW USER pop up"
	// Automation ID : WE_22
	// </summary>
	public void WE_22_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    Registration_Obj RegistrationObj= new Registration_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_22_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_22_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_22_TeamName));
		Thread.sleep(3000);
		base.pressKey(null, "KEYBOARD_ENTER");
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_22_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_22_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_22_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_22_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member With Email")), "User is not able to view the option 'Create & Add new member with Email'");

		// Step 8 : Click on Create & Add New Member With Email button
		// Expected : The user should navigate to CREATE NEW USER pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member With Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("ADD NEW USER")), "User unable to view the Add New user popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInputNew")), "User unable to view the email field in the Games Page");

		//Step 9 : "Switch to Add Multiple Users"
		//Expected : "User able to switch to Add Multiple Users"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("user_tab_multiple"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("add-user-card-title")), "User is not able to switch to Add Multiple User mode");

		// Step 10 : Fill the fields to be required except Role
		// Expected : User can able to enter all the remaining fields except use role
		base.setData(LoginPageObj.Edt_LoginEmail("email_1"), CreateAddNewMemberWithEmailTestData.WE_22_ValidEmailAddress);
		Thread.sleep(3000);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("email_1"));
		Assert.assertEquals(Email, CreateAddNewMemberWithEmailTestData.WE_22_ValidEmailAddress, "User unable to enter invalid Email in the add multiple user page");
		
		base.buttonClick(PoolObj.Ele_SelectPoolType("Player"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("Player")), "User unable to select any role ");
		
		base.setData(LoginPageObj.Edt_LoginEmail("jersey_1"), CreateAddNewMemberWithEmailTestData.WE_22_JerseyNumber);
		String JersyNum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_1"));
		asrt.assertEquals(JersyNum, CreateAddNewMemberWithEmailTestData.WE_22_JerseyNumber,"Entered Number is not visible in Jersy Number field");
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_CloseBtn("add-user-card-header","New User 2","add-user-card-options card-remove-btn"));
		Thread.sleep(3000);
		
		// Step 11 : Click on ADD USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("saveMutipleUsers"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to view 'User Added Successfully popup' while creating a member");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user is not automatically add as player in that team.");

		// Step 12 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(CreateAddNewMemberWithEmailTestData.WE_22_FullName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_22_FullName),"teamCheckBox")), "The user is not automatically added as player in that team");
		
		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_22_FullName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}

	// <summary>
	// Test Case Title : "To verify whether there is a option to add user without email."
	// Automation ID : WE_23
	// </summary>
	public void WE_23_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_23_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_23_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_23_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_23_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_23_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_23_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : User should be navigated to the Edit team page
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_23_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);

		//Step 8 : Observe whether there is a option as Create & Add new member without Email
		//Expected : There should be an option to add user without mail id.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email")), "User is not able to view the option 'Create & Add new member without Email'");
	}
	
	//<summary>
	// Test Case Title : "To verify whether the user navigates to Add New User Without Email pop up while clicking Create & Add New Member without Email. "
	// Automation ID : WE_24
	// </summary>
	public void WE_24_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_24_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_24_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_24_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_24_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_24_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_24_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_24_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email")), "User is not able to view the option 'Create & Add new member without Email'");

		// Step 8 : Click Create&Add New Member without Email
		// Expected : The user should navigate to Add New User Without Email pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("Add New User Without Email")), "User unable to view the 'Add New User Without Email' popup in the Games Page");
	}

	// <summary>
	// Test Case Title : "To verify what happens when the user enters a valid email id in the Add New User Without Email pop up "
	// Automation ID : WE_25
	// </summary>
	public void WE_25_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_25_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_25_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_25_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_25_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_25_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_25_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_25_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email")), "User is not able to view the option 'Create & Add new member without Email'");

		// Step 8 : Click Create&Add New Member without Email
		// Expected : The user should navigate to Add New User Without Email pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("Add New User Without Email")), "User unable to view the 'Add New User Without Email' popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_woemail_1")), "User unable to view the email field in the Games Page");
		
		// Step 10 : Enter a valid email id
		// Expected : User able to enter a valid EmailID
		base.setData(LoginPageObj.Edt_LoginEmail("email_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_25_ValidEmailAddress);
		Thread.sleep(3000);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("email_woemail_1"));
		Assert.assertEquals(Email, CreateAddNewMemberWithEmailTestData.WE_25_ValidEmailAddress, "User unable to enter valid Email in 'Add New User Without Email' page");
	}
	
	// <summary>
	// Test Case Title : "To verify what happens when the user enters a invalid email id in the Add New User Without Email pop up"
	// Automation ID : WE_26
	// </summary> 
	public void WE_26_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_26_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_26_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_26_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_26_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_26_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_26_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_26_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email")), "User is not able to view the option 'Create & Add new member without Email'");

		// Step 8 : Click Create&Add New Member without Email
		// Expected : The user should navigate to Add New User Without Email pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("Add New User Without Email")), "User unable to view the 'Add New User Without Email' popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_woemail_1")), "User unable to view the email field in the Games Page");

		//Step 9 : Enter invalid email id, valid user name and jersey number and click Add.
		//Expected : The user can able to add new member without any alert message.
		base.setData(LoginPageObj.Edt_LoginEmail("email_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_26_InValidEmailAddress);
		String ActualMail=base.GetValue(LoginPageObj.Edt_LoginEmail("email_woemail_1"));
		asrt.assertEquals(ActualMail,CreateAddNewMemberWithEmailTestData.WE_26_InValidEmailAddress);

		base.setData(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_26_FullName);
		String ActualName=base.GetValue(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"));
		asrt.assertEquals(ActualName,CreateAddNewMemberWithEmailTestData.WE_26_FullName);

		base.setData(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_26_JerseyNumber);
		String ActualJnum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"));
		asrt.assertEquals(ActualJnum,CreateAddNewMemberWithEmailTestData.WE_26_JerseyNumber);

		// Step 10 : Click on ADD USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("saveMutipleUsersWOEmail"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to view 'User Added Successfully popup' while creating a member");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user is not automatically add as player in that team.");

		// Step 11 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(CreateAddNewMemberWithEmailTestData.WE_26_FullName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_26_FullName),"teamCheckBox")), "The user is not automatically added as player in that team");
		
		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_26_FullName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}	
	
	// <summary>
	// Test Case Title : "To verify what happens when user kept the email field empty"
	// Automation ID : WE_27
	// </summary>
	public void WE_27_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_27_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_27_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_27_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_27_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_27_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_27_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_27_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email")), "User is not able to view the option 'Create & Add new member without Email'");

		// Step 8 : Click Create&Add New Member without Email
		// Expected : The user should navigate to Add New User Without Email pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("Add New User Without Email")), "User unable to view the 'Add New User Without Email' popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_woemail_1")), "User unable to view the email field in the Games Page");

		//Step 9 : Fill the fields except Email 
		//Expected : The user can able to add new member with a default mail id (For Eg . user123456@mysnipback.com)
		base.setData(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_27_FullName);
		String ActualName=base.GetValue(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"));
		asrt.assertEquals(ActualName,CreateAddNewMemberWithEmailTestData.WE_27_FullName);

		base.setData(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_27_JerseyNumber);
		String ActualJnum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"));
		asrt.assertEquals(ActualJnum,CreateAddNewMemberWithEmailTestData.WE_27_JerseyNumber);

		// Step 10 : Click on ADD USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("saveMutipleUsersWOEmail"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to to add new member with a default mail id (For Eg . user123456@mysnipback.com)");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user is not automatically add as player in that team.");

		// Step 11 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(CreateAddNewMemberWithEmailTestData.WE_27_FullName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_27_FullName),"teamCheckBox")), "The user is not automatically added as player in that team");
		
		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_27_FullName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}

	// <summary>
	// Test Case Title : "To verify whether the user can be able to enter a valid Full Name"
	// Automation ID : WE_28
	// </summary>
	public void WE_28_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_28_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_28_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_28_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_28_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_28_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_28_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_28_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email")), "User is not able to view the option 'Create & Add new member without Email'");

		// Step 8 : Click Create&Add New Member without Email
		// Expected : The user should navigate to Add New User Without Email pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("Add New User Without Email")), "User unable to view the 'Add New User Without Email' popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_woemail_1")), "User unable to view the email field in the Games Page");

		//Step 9 : Enter a valid Full Name
		//Expected : The user can able to add new member.
		base.setData(LoginPageObj.Edt_LoginEmail("email_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_28_ValidEmailAddress);
		String ActualMail=base.GetValue(LoginPageObj.Edt_LoginEmail("email_woemail_1"));
		asrt.assertEquals(ActualMail,CreateAddNewMemberWithEmailTestData.WE_28_ValidEmailAddress);

		base.setData(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_28_ValidFullName);
		String ActualName=base.GetValue(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"));
		asrt.assertEquals(ActualName,CreateAddNewMemberWithEmailTestData.WE_28_ValidFullName);

		base.setData(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_28_JerseyNumber);
		String ActualJnum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"));
		asrt.assertEquals(ActualJnum,CreateAddNewMemberWithEmailTestData.WE_28_JerseyNumber);

		// Step 10 : Click on ADD USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("saveMutipleUsersWOEmail"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user unable to add new member.");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user is not automatically add as player in that team.");

		// Step 11 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(CreateAddNewMemberWithEmailTestData.WE_28_ValidFullName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_28_ValidFullName),"teamCheckBox")), "The user is not automatically added as player in that team");
		
		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_28_ValidFullName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}

	// <summary>
	// Test Case Title : "To verify whether the user can be able to enter an invalid Full Name"
	// Automation ID : WE_29
	// </summary>
	public void WE_29_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_29_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_29_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_29_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_29_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_29_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_29_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_29_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email")), "User is not able to view the option 'Create & Add new member without Email'");

		// Step 8 : Click Create&Add New Member without Email
		// Expected : The user should navigate to Add New User Without Email pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("Add New User Without Email")), "User unable to view the 'Add New User Without Email' popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_woemail_1")), "User unable to view the email field in the Games Page");

		//Step 9 : Enter a invalid Full Name
		//Expected : The user will receive alert message as "User's name should be of minimum 3 characters."
		base.setData(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_29_JerseyNumber);
		String ActualJnum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"));
		asrt.assertEquals(ActualJnum,CreateAddNewMemberWithEmailTestData.WE_29_JerseyNumber);
		
		base.setData(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_29_InValidFullName);
		String ActualName=base.GetValue(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"));
		asrt.assertEquals(ActualName,CreateAddNewMemberWithEmailTestData.WE_29_InValidFullName);
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_ErrorMsgFName("User's name should be of minimum 3 characters.")), "User not receives an alert message as 'User's name should be of minimum 3 characters'");
	}

	// <summary>
	// Test Case Title : "To verify what happens when the user left the Full Name field empty"
	// Automation ID : WE_30
	// </summary>
	public void WE_30_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_30_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_30_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_30_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_30_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_30_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_30_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_30_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email")), "User is not able to view the option 'Create & Add new member without Email'");

		// Step 8 : Click Create&Add New Member without Email
		// Expected : The user should navigate to Add New User Without Email pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("Add New User Without Email")), "User unable to view the 'Add New User Without Email' popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_woemail_1")), "User unable to view the email field in the Games Page");

		//Step 9 : Fill the fields except Full Name
		//Expected : User should receive alert message as "Please Enter the User's name."
		base.setData(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_30_JerseyNumber);
		String ActualJnum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"));
		asrt.assertEquals(ActualJnum,CreateAddNewMemberWithEmailTestData.WE_30_JerseyNumber,"The actual and given Jersey numbers don't match in Add user without email Pop-Up");
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_ErrorMsgFName("Please Enter the User's name. ")), "User not receives an alert message as 'Please Enter the User's name.'");

	}	
	
	// <summary>
	// Test Case Title : "To verify whether the user can able to change the role"
	// Automation ID : WE_31
	// </summary>
	public void WE_31_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_31_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_31_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_31_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_31_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_31_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_31_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_31_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email")), "User is not able to view the option 'Create & Add new member without Email'");

		// Step 8 : Click Create&Add New Member without Email
		// Expected : The user should navigate to Add New User Without Email pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("Add New User Without Email")), "User unable to view the 'Add New User Without Email' popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_woemail_1")), "User unable to view the email field in the Games Page");

		//Step 9 : Try to change the role
		//Expected : The role field is set as default to Player.
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_UserRole("role_woemail_1")),"Role can be changed in the Add User Without Email Pop-up in the Games page.");
		//asrt.assertFalse(driver.findElement(By.xpath("//input[@id='role_woemail_1']")).isEnabled(),"Role can be changed in the Add User Without Email Pop-up in the Games page.");
	}

	// <summary>
	// Test Case Title : "To verify what happens when user customize the jersey number field"
	// Automation ID : WE_32
	// </summary>
	public void WE_32_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_32_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_32_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_32_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_32_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_32_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_32_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_32_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email")), "User is not able to view the option 'Create & Add new member without Email'");

		// Step 8 : Click Create&Add New Member without Email
		// Expected : The user should navigate to Add New User Without Email pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("Add New User Without Email")), "User unable to view the 'Add New User Without Email' popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_woemail_1")), "User unable to view the email field in the Games Page");

		//Step 9 : Fill the fields without changing the Jersey Number
		//Expected : The user can able to add new member along with the deafut Jersey Number
		base.setData(LoginPageObj.Edt_LoginEmail("email_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_32_ValidEmailAddress);
		String ActualMail=base.GetValue(LoginPageObj.Edt_LoginEmail("email_woemail_1"));
		asrt.assertEquals(ActualMail,CreateAddNewMemberWithEmailTestData.WE_32_ValidEmailAddress);

		base.setData(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_32_ValidFullName);
		String ActualName=base.GetValue(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"));
		asrt.assertEquals(ActualName,CreateAddNewMemberWithEmailTestData.WE_32_ValidFullName);

		base.setData(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_32_JerseyNumber);
		String ActualJnum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"));
		asrt.assertEquals(ActualJnum,CreateAddNewMemberWithEmailTestData.WE_32_JerseyNumber);

		// Step 10 : Click on ADD USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("saveMutipleUsersWOEmail"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user unable to add new member along with the deafut Jersey Number");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user is not automatically add as player in that team.");

		// Step 11 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(CreateAddNewMemberWithEmailTestData.WE_32_ValidFullName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_32_ValidFullName),"teamCheckBox")), "The user is not automatically added as player in that team");
		
		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_32_ValidFullName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}

	// <summary>
	// Test Case Title : "To verify what happens when user kept the jersey number as default"
	// Automation ID : WE_33
	// </summary>
	public void WE_33_CreateAddNewMemberWithEmail() throws InterruptedException
	{
		Login login =new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		CreateAddNewMemberWithEmail_TestData CreateAddNewMemberWithEmailTestData=new CreateAddNewMemberWithEmail_TestData();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
	    AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), CreateAddNewMemberWithEmailTestData.WE_33_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), CreateAddNewMemberWithEmailTestData.WE_33_TeamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_33_TeamName));
		Thread.sleep(3000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",CreateAddNewMemberWithEmailTestData.WE_33_TeamName)), "Failed to select TEAM");
	    Thread.sleep(3000);

		// Step 6 : Click three dots of the team selected
		// Expected : User should be able to see the list of options under the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_33_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(CreateAddNewMemberWithEmailTestData.WE_33_TeamName,"dropdown-menu")), "User unable to see the list of options under the three dots in the Games Page");

		// Step 7 : Click on Edit team under the three dots
		// Expected : There should be a option to add user with mail id. 
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Btn_EditBtn(CreateAddNewMemberWithEmailTestData.WE_33_TeamName,"dropdown-menu","Edit Team"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email")), "User is not able to view the option 'Create & Add new member without Email'");

		// Step 8 : Click Create&Add New Member without Email
		// Expected : The user should navigate to Add New User Without Email pop up.
		base.excuteJsClick(LoginPageObj.Edt_Alert1("Create & Add New Member Without Email"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_Heading("Add New User Without Email")), "User unable to view the 'Add New User Without Email' popup in the Games Page");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("email_woemail_1")), "User unable to view the email field in the Games Page");

		//Step 9 : Enter invalid email id, valid user name and jersey number and click Add.
		//Expected : The user can able to add new member without any alert message.
		base.setData(LoginPageObj.Edt_LoginEmail("email_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_33_ValidEmailAddress);
		String ActualMail=base.GetValue(LoginPageObj.Edt_LoginEmail("email_woemail_1"));
		asrt.assertEquals(ActualMail,CreateAddNewMemberWithEmailTestData.WE_33_ValidEmailAddress);

		base.setData(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_33_ValidFullName);
		String ActualName=base.GetValue(LoginPageObj.Edt_LoginEmail("fullname_woemail_1"));
		asrt.assertEquals(ActualName,CreateAddNewMemberWithEmailTestData.WE_33_ValidFullName);

		base.setData(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"), CreateAddNewMemberWithEmailTestData.WE_33_JerseyNumber);
		String ActualJnum=base.GetValue(LoginPageObj.Edt_LoginEmail("jersey_woemail_1"));
		asrt.assertEquals(ActualJnum,CreateAddNewMemberWithEmailTestData.WE_33_JerseyNumber);

		// Step 10 : Click on ADD USER TO ORGANIZATION button
		// Expected : The user should be able to add member to that team.
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("saveMutipleUsersWOEmail"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Users Added Successfully!")), "The user is not able to view 'User Added Successfully popup' while creating a member");
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamUser")), "The user is not automatically add as player in that team.");

		// Step 11 : Search in the Members Search field if the Added Member Exists
		// Expected : The user should automatically add as player in that team.
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("teamUser"));
		base.setData(LoginPageObj.Edt_LoginEmail("teamUser"),(CreateAddNewMemberWithEmailTestData.WE_33_ValidFullName));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_33_ValidFullName),"teamCheckBox")), "The user is not automatically added as player in that team");
		
		//Steps to Remove the added member
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Chk_TeamMembers((CreateAddNewMemberWithEmailTestData.WE_33_ValidFullName),"teamCheckBox"));
		base.excuteJsClick(addupdateremoveMemberObj.Ele_EditTeam("removePlayersToRight();"));
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("updateUser(1);"));
		Thread.sleep(3000);
	}
}



