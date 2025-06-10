package testPage.MavenPageObject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.internal.annotations.IListeners;
import TestData.CommonData;
import TestData.CreateAddNewMember_TestData;
import TestData.SnipBackLogin_TestData;
import objectRepository.CreateAddNewMemeber_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SnipBackLogin_Obj;
import objectRepository.SocialMediaSignIn_Obj;
import utilPack.BasePge;

public class CreateAddNewMember extends BasePge {

	BasePge base;
	Assert asrt;

	public CreateAddNewMember(WebDriver driver)
	{
		super(driver);
		base = new BasePge(driver);
	}

	//<summary>
	// Test Case Title : To verify whether there is a option to add user with email.
	// Automation ID   : WE_01
	// </summary>

	public void TC01_CreateAddNewMember() throws InterruptedException  
	{
		LoginPage_Obj loginObj = new LoginPage_Obj();
		SnipBackLogin_Obj snipbackloginObj=new SnipBackLogin_Obj();
		CreateAddNewMemeber_Obj CreateNewMemberObj=new CreateAddNewMemeber_Obj();
		CommonData Commondata=new CommonData();
		CreateAddNewMember_TestData CreateAddNewMemeberTestData=new CreateAddNewMember_TestData();
		Registration_Obj registrationObj=new Registration_Obj();
		Login login=new Login(driver); 

		//Step 1:Go to Snipback website
		// Expected:The Snipback home must load.
		asrt.assertTrue(base.isExists(loginObj.Ele_SnipBackHomePageLogo("light-logo")), "Unable to view Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The Login popup must open with buttons for signin.
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(snipbackloginObj.Btn_Signin("SIGN IN")),"User is not able to view the SignIn button in the Popup");

		//Step 3:Enter User name & password and click on the button "SignIn".
		//Expected:The login must be successful and need to navigate to Page.
		base.setData(loginObj.Edt_LoginCredentialFields("email_address"), CommonData.UserName);
		base.setData(loginObj.Edt_LoginCredentialFields("password"), CommonData.PassWord);
		base.buttonClick(loginObj.Btn_SignInButton("SIGN IN"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("menu_link nav-link  active ")), "User login is unsuccessfull");

		//Step 4:Go to Games/Members page.
		//Expected:The Games page must be loaded.
		//	base.PerformActionOnAlert();	
		base.buttonClick(loginObj.Btn_LoginButton("menu_link nav-link  active "));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("nav-link  tab-team-type active")),"User not able to view the Games page");

		//Step 5: Switch to Any team after searching
		//Expected : The teams and their appropriate event must load fine.
		base.setData(CreateNewMemberObj.Edt_SearchBox("form-control input-wrap"),CreateAddNewMemeberTestData.TC01_CreateAddNewMemberTeamName );
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ele_SearchedSelection("d-flex align-items-center item-label","CreateORAddUserName")), "Searched Team is not loading properly");

		//step 6: Click on the three Dots near the team name.
		//Expected: The option Edit Team must open.
		base.buttonClick(registrationObj.Btn_ResendOTP("defaultDropdown-41"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ddl_Selection("team","Edit Team")), "The User is not able to see the Edit Team option");

		//step 7: Click on the option "Edit Team".
		//Expected: The Edit team grid must open and need the option to add user with email ID.
		base.buttonClick(CreateNewMemberObj.Ddl_Selection("team","Edit Team"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")), "User is not able to see the option Create & Add new member with Email");
	}

	//<summary>
	// Test Case Title : To verify whether the user navigates to ADD NEW USER pop up while clicking Create & Add New Member with Email.
	// Automation ID   : WE_02
	// </summary>

	public void TC02_CreateAddNewMember() throws InterruptedException  
	{
		LoginPage_Obj loginObj = new LoginPage_Obj();
		SnipBackLogin_Obj snipbackloginObj=new SnipBackLogin_Obj();
		CreateAddNewMemeber_Obj CreateNewMemberObj=new CreateAddNewMemeber_Obj();
		CommonData Commondata=new CommonData();
		CreateAddNewMember_TestData CreateAddNewMemeberTestData=new CreateAddNewMember_TestData();
		Registration_Obj registrationObj=new Registration_Obj();

		Login login=new Login(driver);  		   
		//Step 1:Go to Snipback website
		// Expected:The Snipback home must load.
		asrt.assertTrue(base.isExists(loginObj.Ele_SnipBackHomePageLogo("light-logo")), "Unable to view Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The Login popup must open with buttons for signin.
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(snipbackloginObj.Btn_Signin("SIGN IN")),"User is not able to view the SignIn button in the Popup");

		//Step 3:Enter User name & password and click on the button "SignIn".
		//Expected:The login must be successful and need to navigate to Page.
		base.setData(loginObj.Edt_LoginCredentialFields("email_address"), CommonData.UserName);
		base.setData(loginObj.Edt_LoginCredentialFields("password"), CommonData.PassWord);
		base.buttonClick(loginObj.Btn_SignInButton("SIGN IN"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("menu_link nav-link  active ")), "User login is unsuccessfull");

		//Step 4:Go to Games/Members page.
		//Expected:The Games page must be loaded.
		//	base.PerformActionOnAlert();	
		base.buttonClick(loginObj.Btn_LoginButton("menu_link nav-link  active "));
		driver.navigate().refresh();
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("nav-link  tab-team-type active")),"User not able to view the Games page");

		//Step 5: Switch to Any team after searching
		//Expected : The teams and their appropriate event must load fine.
		base.setData(CreateNewMemberObj.Edt_SearchBox("form-control input-wrap"),CreateAddNewMemeberTestData.TC01_CreateAddNewMemberTeamName );
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ele_SearchedSelection("d-flex align-items-center item-label","CreateORAddUserName")), "Searched Team is not loading properly");

		//step 6: Click on the three Dots near the team name.
		//Expected: The option Edit Team must open.
		base.buttonClick(registrationObj.Btn_ResendOTP("defaultDropdown-41"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ddl_Selection("team","Edit Team")), "The User is not able to see the Edit Team option");

		//step 7: Click on the option "Edit Team".
		//Expected: The Edit team grid must open and need the option to add user with email ID.
		base.buttonClick(CreateNewMemberObj.Ddl_Selection("team","Edit Team"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")), "User is not able to see the option Create & Add new member with Email");

		//step 8:Click Create&Add New Member with Email.
		//Expected: The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(loginObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("user-tab nav-link active")), "User is unable to view the Add New User Popup");
	}

	//<summary>
	// Test Case Title : To verify what happens when the user enters a valid email id in the ADD NEW USER pop up.
	// Automation ID   : WE_03
	// </summary>

	public void TC03_CreateAddNewMember() throws InterruptedException  
	{
		LoginPage_Obj loginObj = new LoginPage_Obj();
		SnipBackLogin_Obj snipbackloginObj=new SnipBackLogin_Obj();
		CreateAddNewMemeber_Obj CreateNewMemberObj=new CreateAddNewMemeber_Obj();
		CommonData Commondata=new CommonData();
		CreateAddNewMember_TestData CreateAddNewMemeberTestData=new CreateAddNewMember_TestData();
		Registration_Obj registrationObj=new Registration_Obj();

		Login login=new Login(driver);  		   
		//Step 1:Go to Snipback website
		// Expected:The Snipback home must load.
		asrt.assertTrue(base.isExists(loginObj.Ele_SnipBackHomePageLogo("light-logo")), "Unable to view Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The Login popup must open with buttons for signin.
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(snipbackloginObj.Btn_Signin("SIGN IN")),"User is not able to view the SignIn button in the Popup");

		//Step 3:Enter User name & password and click on the button "SignIn".
		//Expected:The login must be successful and need to navigate to Page.
		base.setData(loginObj.Edt_LoginCredentialFields("email_address"), CommonData.UserName);
		base.setData(loginObj.Edt_LoginCredentialFields("password"), CommonData.PassWord);
		base.buttonClick(loginObj.Btn_SignInButton("SIGN IN"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("menu_link nav-link  active ")), "User login is unsuccessfull");

		//Step 4:Go to Games/Members page.
		//Expected:The Games page must be loaded.
		//	base.PerformActionOnAlert();	
		base.buttonClick(loginObj.Btn_LoginButton("menu_link nav-link  active "));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("nav-link  tab-team-type active")),"User not able to view the Games page");

		//Step 5: Switch to Any team after searching
		//Expected : The teams and their appropriate event must load fine.
		base.setData(CreateNewMemberObj.Edt_SearchBox("form-control input-wrap"),CreateAddNewMemeberTestData.TC01_CreateAddNewMemberTeamName );
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ele_SearchedSelection("d-flex align-items-center item-label","CreateORAddUserName")), "Searched Team is not loading properly");

		//step 6: Click on the three Dots near the team name.
		//Expected: The option Edit Team must open.
		base.buttonClick(registrationObj.Btn_ResendOTP("defaultDropdown-41"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ddl_Selection("team","Edit Team")), "The User is not able to see the Edit Team option");

		//step 7: Click on the option "Edit Team".
		//Expected: The Edit team grid must open and need the option to add user with email ID.
		base.buttonClick(CreateNewMemberObj.Ddl_Selection("team","Edit Team"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")), "User is not able to see the option Create & Add new member with Email");

		//step 8: Click Create&Add New Member with Email.
		//Expected: The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(loginObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("user-tab nav-link active")), "User is unable to view the Add New User Popup");

		//step 9: Enter a valid Email ID and check whether the validation message is comming or not.
		//Expected: The validation message must not show for valid email id.
		base.setData(loginObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemeberTestData.TC03_CreateAddNewMemberEmail );
		Thread.sleep(2000);
		base.buttonClick(loginObj.Edt_LoginEmail("firstnameNew"));
		Thread.sleep(2000);
		List<WebElement> errorMessages = driver.findElements(By.xpath("//span[@class='commonValidateErr active']"));
		asrt.assertTrue(errorMessages.isEmpty(), "User is able to see the validation error message for valid email.");
	}

	//<summary>
	// Test Case Title : To verify what happens when the user enters a invalid email id in the ADD NEW USER pop up.
	// Automation ID   : WE_04
	// </summary>

	public void TC04_CreateAddNewMember() throws InterruptedException  
	{
		LoginPage_Obj loginObj = new LoginPage_Obj();
		SnipBackLogin_Obj snipbackloginObj=new SnipBackLogin_Obj();
		CreateAddNewMemeber_Obj CreateNewMemberObj=new CreateAddNewMemeber_Obj();
		CommonData Commondata=new CommonData();
		CreateAddNewMember_TestData CreateAddNewMemeberTestData=new CreateAddNewMember_TestData();
		Registration_Obj registrationObj=new Registration_Obj();

		Login login=new Login(driver);  		   
		//Step 1:Go to Snipback website
		// Expected:The Snipback home must load.
		asrt.assertTrue(base.isExists(loginObj.Ele_SnipBackHomePageLogo("light-logo")), "Unable to view Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The Login popup must open with buttons for signin.
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(snipbackloginObj.Btn_Signin("SIGN IN")),"User is not able to view the SignIn button in the Popup");

		//Step 3:Enter User name & password and click on the button "SignIn".
		//Expected:The login must be successful and need to navigate to Page.
		base.setData(loginObj.Edt_LoginCredentialFields("email_address"), CommonData.UserName);
		base.setData(loginObj.Edt_LoginCredentialFields("password"), CommonData.PassWord);
		base.buttonClick(loginObj.Btn_SignInButton("SIGN IN"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("menu_link nav-link  active ")), "User login is unsuccessfull");

		//Step 4:Go to Games/Members page.
		//Expected:The Games page must be loaded.
		//	base.PerformActionOnAlert();	
		base.buttonClick(loginObj.Btn_LoginButton("menu_link nav-link  active "));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("nav-link  tab-team-type active")),"User not able to view the Games page");

		//Step 5: Switch to Any team after searching
		//Expected : The teams and their appropriate event must load fine.
		base.setData(CreateNewMemberObj.Edt_SearchBox("form-control input-wrap"),CreateAddNewMemeberTestData.TC01_CreateAddNewMemberTeamName );
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ele_SearchedSelection("d-flex align-items-center item-label","CreateORAddUserName")), "Searched Team is not loading properly");

		//step 6: Click on the three Dots near the team name.
		//Expected: The option Edit Team must open.
		base.buttonClick(registrationObj.Btn_ResendOTP("defaultDropdown-41"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ddl_Selection("team","Edit Team")), "The User is not able to see the Edit Team option");

		//step 7: Click on the option "Edit Team".
		//Expected: The Edit team grid must open and need the option to add user with email ID.
		base.buttonClick(CreateNewMemberObj.Ddl_Selection("team","Edit Team"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")), "User is not able to see the option Create & Add new member with Email");

		//step 8: Click Create&Add New Member with Email.
		//Expected: The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(loginObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("user-tab nav-link active")), "User is unable to view the Add New User Popup");

		//step 9: Enter an Invalid Email ID and check for the error message.
		//Expected: The validation message must be "Please enter the valid email, the invalid characters are &/\#,+()$~%.^':*?<>{}"".
		base.setData(loginObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemeberTestData.TC04_CreateAddNewMemberInvalidEmail );
		Thread.sleep(2000);
		base.buttonClick(loginObj.Edt_LoginEmail("firstnameNew"));
		Thread.sleep(2000);
		String ExpectedMessage= base.GetText(CreateNewMemberObj.Msg_ErrorMessage("Please enter the valid email"));
		asrt.assertEquals(ExpectedMessage,CreateAddNewMemeberTestData.TC04_CreateAddNewMemberActualErrorMessage,"There is no such validation messages on entering invalid mail");
	}

	//<summary>
	// Test Case Title : To verify what happens when the user keeps the email id field empty in the ADD NEW USER pop up.
	// Automation ID   : WE_05
	// </summary>

	public void TC05_CreateAddNewMember() throws InterruptedException  
	{
		LoginPage_Obj loginObj = new LoginPage_Obj();
		SnipBackLogin_Obj snipbackloginObj=new SnipBackLogin_Obj();
		CreateAddNewMemeber_Obj CreateNewMemberObj=new CreateAddNewMemeber_Obj();
		CommonData Commondata=new CommonData();
		CreateAddNewMember_TestData CreateAddNewMemeberTestData=new CreateAddNewMember_TestData();
		Registration_Obj registrationObj=new Registration_Obj();

		Login login=new Login(driver);  		   
		//Step 1:Go to Snipback website
		// Expected:The Snipback home must load.
		asrt.assertTrue(base.isExists(loginObj.Ele_SnipBackHomePageLogo("light-logo")), "Unable to view Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The Login popup must open with buttons for signin.
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(snipbackloginObj.Btn_Signin("SIGN IN")),"User is not able to view the SignIn button in the Popup");

		//Step 3:Enter User name & password and click on the button "SignIn".
		//Expected:The login must be successful and need to navigate to Page.
		base.setData(loginObj.Edt_LoginCredentialFields("email_address"), CommonData.UserName);
		base.setData(loginObj.Edt_LoginCredentialFields("password"), CommonData.PassWord);
		base.buttonClick(loginObj.Btn_SignInButton("SIGN IN"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("menu_link nav-link  active ")), "User login is unsuccessfull");

		//Step 4:Go to Games/Members page.
		//Expected:The Games page must be loaded.
		//	base.PerformActionOnAlert();	
		base.buttonClick(loginObj.Btn_LoginButton("menu_link nav-link  active "));
		Thread.sleep(2000);
		driver.navigate().refresh();
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("nav-link  tab-team-type active")),"User not able to view the Games page");

		//Step 5: Switch to Any team after searching
		//Expected : The teams and their appropriate event must load fine.
		base.setData(CreateNewMemberObj.Edt_SearchBox("form-control input-wrap"),CreateAddNewMemeberTestData.TC01_CreateAddNewMemberTeamName );
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ele_SearchedSelection("d-flex align-items-center item-label","CreateORAddUserName")), "Searched Team is not loading properly");

		//step 6: Click on the three Dots near the team name.
		//Expected: The option Edit Team must open.
		base.buttonClick(registrationObj.Btn_ResendOTP("defaultDropdown-41"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ddl_Selection("team","Edit Team")), "The User is not able to see the Edit Team option");

		//step 7: Click on the option "Edit Team".
		//Expected: The Edit team grid must open and need the option to add user with email ID.
		base.buttonClick(CreateNewMemberObj.Ddl_Selection("team","Edit Team"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")), "User is not able to see the option Create & Add new member with Email");

		//step 8: Click Create&Add New Member with Email.
		//Expected: The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(loginObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("user-tab nav-link active")), "User is unable to view the Add New User Popup");

		//step 9: Enter values in all the fields except 'Enter Email Address'.
		//Expected: The mandatory validation message must show in the field 'Enter Email Address'.
		base.setData(loginObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberFirstName );
		base.setData(loginObj.Edt_LoginEmail("lastnameNew"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberLastName );
		base.setData(loginObj.Edt_LoginEmail("newJerseyNumber"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberJerseyNum );
		base.setData(CreateNewMemberObj.Edt_TextBox("userCreateMessage"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberMessage );
		Thread.sleep(2000);
		base.excuteJsClick(loginObj.Btn_SingnIn("createUserBtn"));
		Thread.sleep(2000);
		String ManadatoryEmailMessage=base.GetText(CreateNewMemberObj.Msg_ErrorMessage("User Email is required"));
		asrt.assertEquals(ManadatoryEmailMessage, CreateAddNewMemeberTestData.TC05_CreateAddNewMemberEmailMandatoryMessage,"The Mandatory alert message 'User Email is required' is not showing");        
	}

	//<summary>
	// Test Case Title : To verify what happens when the user enters a valid First Name in the ADD NEW USER pop up.
	// Automation ID   : WE_06
	// </summary>

	public void TC06_CreateAddNewMember() throws InterruptedException  
	{
		LoginPage_Obj loginObj = new LoginPage_Obj();
		SnipBackLogin_Obj snipbackloginObj=new SnipBackLogin_Obj();
		CreateAddNewMemeber_Obj CreateNewMemberObj=new CreateAddNewMemeber_Obj();
		CommonData Commondata=new CommonData();
		CreateAddNewMember_TestData CreateAddNewMemeberTestData=new CreateAddNewMember_TestData();
		Registration_Obj registrationObj=new Registration_Obj();

		Login login=new Login(driver);  		   
		//Step 1:Go to Snipback website
		// Expected:The Snipback home must load.
		asrt.assertTrue(base.isExists(loginObj.Ele_SnipBackHomePageLogo("light-logo")), "Unable to view Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The Login popup must open with buttons for signin.
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(snipbackloginObj.Btn_Signin("SIGN IN")),"User is not able to view the SignIn button in the Popup");

		//Step 3:Enter User name & password and click on the button "SignIn".
		//Expected:The login must be successful and need to navigate to Page.
		base.setData(loginObj.Edt_LoginCredentialFields("email_address"), CommonData.UserName);
		base.setData(loginObj.Edt_LoginCredentialFields("password"), CommonData.PassWord);
		base.buttonClick(loginObj.Btn_SignInButton("SIGN IN"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("menu_link nav-link  active ")), "User login is unsuccessfull");

		//Step 4:Go to Games/Members page.
		//Expected:The Games page must be loaded.
		//	base.PerformActionOnAlert();	
		base.buttonClick(loginObj.Btn_LoginButton("menu_link nav-link  active "));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("nav-link  tab-team-type active")),"User not able to view the Games page");

		//Step 5: Switch to Any team after searching
		//Expected : The teams and their appropriate event must load fine.
		base.setData(CreateNewMemberObj.Edt_SearchBox("form-control input-wrap"),CreateAddNewMemeberTestData.TC01_CreateAddNewMemberTeamName );
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ele_SearchedSelection("d-flex align-items-center item-label","CreateORAddUserName")), "Searched Team is not loading properly");

		//step 6: Click on the three Dots near the team name.
		//Expected: The option Edit Team must open.
		base.buttonClick(registrationObj.Btn_ResendOTP("defaultDropdown-41"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ddl_Selection("team","Edit Team")), "The User is not able to see the Edit Team option");

		//step 7: Click on the option "Edit Team".
		//Expected: The Edit team grid must open and need the option to add user with email ID.
		base.buttonClick(CreateNewMemberObj.Ddl_Selection("team","Edit Team"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")), "User is not able to see the option Create & Add new member with Email");

		//step 8: Click Create&Add New Member with Email.
		//Expected: The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(loginObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("user-tab nav-link active")), "User is unable to view the Add New User Popup");

		//step 9: Enter a First name and check whether the validation message is comming or not.
		//Expected: The validation message must not show  after entering a valid First Name.
		base.setData(loginObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberFirstName );
		String Text=driver.findElement(loginObj.Edt_LoginEmail("firstnameNew")).getAttribute("value");
		asrt.assertEquals(CreateAddNewMemeberTestData.TC05_CreateAddNewMemberFirstName, Text,"The Value is not present in the field First Name");
	}

	//<summary>
	// Test Case Title : To verify what happens when the user enters a valid First Name in the ADD NEW USER pop up.
	// Automation ID   : WE_07
	// </summary>

	public void TC07_CreateAddNewMember() throws InterruptedException  
	{
		LoginPage_Obj loginObj = new LoginPage_Obj();
		SnipBackLogin_Obj snipbackloginObj=new SnipBackLogin_Obj();
		CreateAddNewMemeber_Obj CreateNewMemberObj=new CreateAddNewMemeber_Obj();
		CommonData Commondata=new CommonData();
		CreateAddNewMember_TestData CreateAddNewMemeberTestData=new CreateAddNewMember_TestData();
		Registration_Obj registrationObj=new Registration_Obj();

		Login login=new Login(driver);  		   
		//Step 1:Go to Snipback website
		// Expected:The Snipback home must load.
		asrt.assertTrue(base.isExists(loginObj.Ele_SnipBackHomePageLogo("light-logo")), "Unable to view Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The Login popup must open with buttons for signin.
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(snipbackloginObj.Btn_Signin("SIGN IN")),"User is not able to view the SignIn button in the Popup");

		//Step 3:Enter User name & password and click on the button "SignIn".
		//Expected:The login must be successful and need to navigate to Page.
		base.setData(loginObj.Edt_LoginCredentialFields("email_address"), CommonData.UserName);
		base.setData(loginObj.Edt_LoginCredentialFields("password"), CommonData.PassWord);
		base.buttonClick(loginObj.Btn_SignInButton("SIGN IN"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("menu_link nav-link  active ")), "User login is unsuccessfull");

		//Step 4:Go to Games/Members page.
		//Expected:The Games page must be loaded.	
		base.buttonClick(loginObj.Btn_LoginButton("menu_link nav-link  active "));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("nav-link  tab-team-type active")),"User not able to view the Games page");

		//Step 5: Switch to Any team after searching
		//Expected : The teams and their appropriate event must load fine.
		base.setData(CreateNewMemberObj.Edt_SearchBox("form-control input-wrap"),CreateAddNewMemeberTestData.TC01_CreateAddNewMemberTeamName );
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ele_SearchedSelection("d-flex align-items-center item-label","CreateORAddUserName")), "Searched Team is not loading properly");

		//step 6: Click on the three Dots near the team name.
		//Expected: The option Edit Team must open.
		base.buttonClick(registrationObj.Btn_ResendOTP("defaultDropdown-41"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ddl_Selection("team","Edit Team")), "The User is not able to see the Edit Team option");

		//step 7: Click on the option "Edit Team".
		//Expected: The Edit team grid must open and need the option to add user with email ID.
		base.buttonClick(CreateNewMemberObj.Ddl_Selection("team","Edit Team"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")), "User is not able to see the option Create & Add new member with Email");

		//step 8: Click Create&Add New Member with Email.
		//Expected: The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(loginObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("user-tab nav-link active")), "User is unable to view the Add New User Popup");

		//step 9: Enter an invalid First name and check whether the validation message is comming or not.
		//Expected: The validation message must not show  after entering a valid First Name.
		base.setData(loginObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemeberTestData.TC03_CreateAddNewMemberEmail );
		base.setData(loginObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemeberTestData.TC07_CreateAddNewMemberInvalidFirstName );
		base.setData(loginObj.Edt_LoginEmail("lastnameNew"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberLastName );
		base.setData(loginObj.Edt_LoginEmail("newJerseyNumber"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberJerseyNum );
		base.setData(CreateNewMemberObj.Edt_TextBox("userCreateMessage"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberMessage );
		Thread.sleep(2000);
		base.excuteJsClick(loginObj.Btn_SingnIn("createUserBtn"));
		Thread.sleep(2000);
		String FirstNameErrorMsg=base.GetText(CreateNewMemberObj.Msg_ErrorMessage("First name should contain only alphabets"));
		asrt.assertEquals(FirstNameErrorMsg,"First name should contain only alphabets" ,"The error message is not showing for invalid Firstname");        
	}

	//<summary>
	// Test Case Title : To verify what happens when the user keeps the First Name field empty in the ADD NEW USER pop up.
	// Automation ID   : WE_08
	// </summary>

	public void TC08_CreateAddNewMember() throws InterruptedException  
	{
		LoginPage_Obj loginObj = new LoginPage_Obj();
		SnipBackLogin_Obj snipbackloginObj=new SnipBackLogin_Obj();
		CreateAddNewMemeber_Obj CreateNewMemberObj=new CreateAddNewMemeber_Obj();
		CommonData Commondata=new CommonData();
		CreateAddNewMember_TestData CreateAddNewMemeberTestData=new CreateAddNewMember_TestData();
		Registration_Obj registrationObj=new Registration_Obj();

		Login login=new Login(driver);  		   
		//Step 1:Go to Snipback website
		// Expected:The Snipback home must load.
		asrt.assertTrue(base.isExists(loginObj.Ele_SnipBackHomePageLogo("light-logo")), "Unable to view Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The Login popup must open with buttons for signin.
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(snipbackloginObj.Btn_Signin("SIGN IN")),"User is not able to view the SignIn button in the Popup");

		//Step 3:Enter User name & password and click on the button "SignIn".
		//Expected:The login must be successful and need to navigate to Page.
		base.setData(loginObj.Edt_LoginCredentialFields("email_address"), CommonData.UserName);
		base.setData(loginObj.Edt_LoginCredentialFields("password"), CommonData.PassWord);
		base.buttonClick(loginObj.Btn_SignInButton("SIGN IN"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("menu_link nav-link  active ")), "User login is unsuccessfull");

		//Step 4:Go to Games/Members page.
		//Expected:The Games page must be loaded.	
		base.buttonClick(loginObj.Btn_LoginButton("menu_link nav-link  active "));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("nav-link  tab-team-type active")),"User not able to view the Games page");

		//Step 5: Switch to Any team after searching
		//Expected : The teams and their appropriate event must load fine.
		base.setData(CreateNewMemberObj.Edt_SearchBox("form-control input-wrap"),CreateAddNewMemeberTestData.TC01_CreateAddNewMemberTeamName );
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ele_SearchedSelection("d-flex align-items-center item-label","CreateORAddUserName")), "Searched Team is not loading properly");

		//step 6: Click on the three Dots near the team name.
		//Expected: The option Edit Team must open.
		base.buttonClick(registrationObj.Btn_ResendOTP("defaultDropdown-41"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ddl_Selection("team","Edit Team")), "The User is not able to see the Edit Team option");

		//step 7: Click on the option "Edit Team".
		//Expected: The Edit team grid must open and need the option to add user with email ID.
		base.buttonClick(CreateNewMemberObj.Ddl_Selection("team","Edit Team"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")), "User is not able to see the option Create & Add new member with Email");

		//step 8: Click Create&Add New Member with Email.
		//Expected: The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(loginObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("user-tab nav-link active")), "User is unable to view the Add New User Popup");

		//step 9: Enter values in all the fields except First Name and check whether the mandatory validation message is comming or not for First Name field.
		//Expected: The mandatory validation message must show for the field First Name.
		base.setData(loginObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemeberTestData.TC03_CreateAddNewMemberEmail );
		base.setData(loginObj.Edt_LoginEmail("lastnameNew"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberLastName );
		base.setData(loginObj.Edt_LoginEmail("newJerseyNumber"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberJerseyNum );
		base.setData(CreateNewMemberObj.Edt_TextBox("userCreateMessage"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberMessage );
		Thread.sleep(2000);
		base.excuteJsClick(loginObj.Btn_SingnIn("createUserBtn"));
		Thread.sleep(2000);
		String FirstNameMandatoryMsg=base.GetText(loginObj.Edt_AlertMessage("First name is required"));
		asrt.assertEquals(FirstNameMandatoryMsg,"First name is required" ,"The Mandatory error message is not showing");        
	}
	
	//<summary>
	// Test Case Title : To verify what happens when try to add user without selecting any role.
	// Automation ID   : WE_09
	// </summary>

	public void TC09_CreateAddNewMember() throws InterruptedException  
	{
		LoginPage_Obj loginObj = new LoginPage_Obj();
		SnipBackLogin_Obj snipbackloginObj=new SnipBackLogin_Obj();
		CreateAddNewMemeber_Obj CreateNewMemberObj=new CreateAddNewMemeber_Obj();
		CommonData Commondata=new CommonData();
		CreateAddNewMember_TestData CreateAddNewMemeberTestData=new CreateAddNewMember_TestData();
		Registration_Obj registrationObj=new Registration_Obj();

		Login login=new Login(driver);  		   
		//Step 1:Go to Snipback website
		// Expected:The Snipback home must load.
		asrt.assertTrue(base.isExists(loginObj.Ele_SnipBackHomePageLogo("light-logo")), "Unable to view Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The Login popup must open with buttons for signin.
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(snipbackloginObj.Btn_Signin("SIGN IN")),"User is not able to view the SignIn button in the Popup");

		//Step 3:Enter User name & password and click on the button "SignIn".
		//Expected:The login must be successful and need to navigate to Page.
		base.setData(loginObj.Edt_LoginCredentialFields("email_address"), CommonData.UserName);
		base.setData(loginObj.Edt_LoginCredentialFields("password"), CommonData.PassWord);
		base.buttonClick(loginObj.Btn_SignInButton("SIGN IN"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("menu_link nav-link  active ")), "User login is unsuccessfull");

		//Step 4:Go to Games/Members page.
		//Expected:The Games page must be loaded.	
		base.buttonClick(loginObj.Btn_LoginButton("menu_link nav-link  active "));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("nav-link  tab-team-type active")),"User not able to view the Games page");

		//Step 5: Switch to Any team after searching
		//Expected : The teams and their appropriate event must load fine.
		base.setData(CreateNewMemberObj.Edt_SearchBox("form-control input-wrap"),CreateAddNewMemeberTestData.TC01_CreateAddNewMemberTeamName );
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ele_SearchedSelection("d-flex align-items-center item-label","CreateORAddUserName")), "Searched Team is not loading properly");

		//step 6: Click on the three Dots near the team name.
		//Expected: The option Edit Team must open.
		base.buttonClick(registrationObj.Btn_ResendOTP("defaultDropdown-41"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ddl_Selection("team","Edit Team")), "The User is not able to see the Edit Team option");

		//step 7: Click on the option "Edit Team".
		//Expected: The Edit team grid must open and need the option to add user with email ID.
		base.buttonClick(CreateNewMemberObj.Ddl_Selection("team","Edit Team"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")), "User is not able to see the option Create & Add new member with Email");

		//step 8: Click Create&Add New Member with Email.
		//Expected: The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(loginObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("user-tab nav-link active")), "User is unable to view the Add New User Popup");

		//step 9: Enter values in all the fields except First Name and check whether the mandatory validation message is comming or not for First Name field.
		//Expected: The mandatory validation message must show for the field First Name.
		base.setData(loginObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemeberTestData.TC03_CreateAddNewMemberEmail );
		base.setData(loginObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberFirstName );
		base.setData(loginObj.Edt_LoginEmail("lastnameNew"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberLastName );
		base.setData(loginObj.Edt_LoginEmail("newJerseyNumber"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberJerseyNum );
		base.setData(CreateNewMemberObj.Edt_TextBox("userCreateMessage"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberMessage );
		Thread.sleep(2000);
		base.scrollToElement(loginObj.Btn_SingnIn("createUserBtn"));
		Thread.sleep(2000);
		base.excuteJsClick(loginObj.Btn_SingnIn("createUserBtn"));
		Thread.sleep(3000);
		base.buttonClick(CreateNewMemberObj.Tab_TabClick("swal-button swal-button--confirm"));
		base.setData(loginObj.Edt_LoginEmail("teamUser"),CreateAddNewMemeberTestData.TC09_CreateAddNewMemberSearchText );
		Thread.sleep(2000);
		String FirstPosition=base.GetText(snipbackloginObj.Btn_Signin("New"));
		Thread.sleep(2000);
		asrt.assertEquals(FirstPosition,"New","Newly Added User is not added to the team");       
	}

	//<summary>
	// Test Case Title : To verify what happens when try to add new user with/without filling  Last Name and Jersey Number field
	// Automation ID   : WE_10
	// </summary>

	public void TC10_CreateAddNewMember() throws InterruptedException  
	{
		LoginPage_Obj loginObj = new LoginPage_Obj();
		SnipBackLogin_Obj snipbackloginObj=new SnipBackLogin_Obj();
		CreateAddNewMemeber_Obj CreateNewMemberObj=new CreateAddNewMemeber_Obj();
		CommonData Commondata=new CommonData();
		CreateAddNewMember_TestData CreateAddNewMemeberTestData=new CreateAddNewMember_TestData();
		Registration_Obj registrationObj=new Registration_Obj();

		Login login=new Login(driver);  		   
		//Step 1:Go to Snipback website
		// Expected:The Snipback home must load.
		asrt.assertTrue(base.isExists(loginObj.Ele_SnipBackHomePageLogo("light-logo")), "Unable to view Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The Login popup must open with buttons for signin.
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(snipbackloginObj.Btn_Signin("SIGN IN")),"User is not able to view the SignIn button in the Popup");

		//Step 3:Enter User name & password and click on the button "SignIn".
		//Expected:The login must be successful and need to navigate to Page.
		base.setData(loginObj.Edt_LoginCredentialFields("email_address"), CommonData.UserName);
		base.setData(loginObj.Edt_LoginCredentialFields("password"), CommonData.PassWord);
		base.buttonClick(loginObj.Btn_SignInButton("SIGN IN"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("menu_link nav-link  active ")), "User login is unsuccessfull");

		//Step 4:Go to Games/Members page.
		//Expected:The Games page must be loaded.	
		base.buttonClick(loginObj.Btn_LoginButton("menu_link nav-link  active "));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("nav-link  tab-team-type active")),"User not able to view the Games page");

		//Step 5: Switch to Any team after searching
		//Expected : The teams and their appropriate event must load fine.
		base.setData(CreateNewMemberObj.Edt_SearchBox("form-control input-wrap"),CreateAddNewMemeberTestData.TC01_CreateAddNewMemberTeamName );
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ele_SearchedSelection("d-flex align-items-center item-label","CreateORAddUserName")), "Searched Team is not loading properly");

		//step 6: Click on the three Dots near the team name.
		//Expected: The option Edit Team must open.
		base.buttonClick(registrationObj.Btn_ResendOTP("defaultDropdown-41"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ddl_Selection("team","Edit Team")), "The User is not able to see the Edit Team option");

		//step 7: Click on the option "Edit Team".
		//Expected: The Edit team grid must open and need the option to add user with email ID.
		base.buttonClick(CreateNewMemberObj.Ddl_Selection("team","Edit Team"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")), "User is not able to see the option Create & Add new member with Email");

		//step 8: Click Create&Add New Member with Email.
		//Expected: The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(loginObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("user-tab nav-link active")), "User is unable to view the Add New User Popup");

		//step 9: Enter values in all the fields except Last Name and jersey number Field and check whether the Player is added or not.
		//Expected: The player must added successfully..
		base.setData(loginObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemeberTestData.TC03_CreateAddNewMemberEmail );
		base.setData(loginObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberFirstName );
		base.setData(CreateNewMemberObj.Edt_TextBox("userCreateMessage"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberMessage );
		Thread.sleep(2000);
		base.scrollToElement(loginObj.Btn_SingnIn("createUserBtn"));
		Thread.sleep(2000);
		base.excuteJsClick(loginObj.Btn_SingnIn("createUserBtn"));
		Thread.sleep(3000);
		base.buttonClick(CreateNewMemberObj.Tab_TabClick("swal-button swal-button--confirm"));
		base.setData(loginObj.Edt_LoginEmail("teamUser"),CreateAddNewMemeberTestData.TC09_CreateAddNewMemberSearchText );
		Thread.sleep(2000);
		String FirstPosition=base.GetText(snipbackloginObj.Btn_Signin("New"));
		Thread.sleep(2000);
		asrt.assertEquals(FirstPosition,"New","Newly Added User is not added to the team");       
	}
	
	//<summary>
	// Test Case Title : To verify what happens when try to add new user with/without filling  Message field
	// Automation ID   : WE_11
	// </summary>

	public void TC11_CreateAddNewMember() throws InterruptedException  
	{
		LoginPage_Obj loginObj = new LoginPage_Obj();
		SnipBackLogin_Obj snipbackloginObj=new SnipBackLogin_Obj();
		CreateAddNewMemeber_Obj CreateNewMemberObj=new CreateAddNewMemeber_Obj();
		CommonData Commondata=new CommonData();
		CreateAddNewMember_TestData CreateAddNewMemeberTestData=new CreateAddNewMember_TestData();
		Registration_Obj registrationObj=new Registration_Obj();

		Login login=new Login(driver);  		   
		//Step 1:Go to Snipback website
		// Expected:The Snipback home must load.
		asrt.assertTrue(base.isExists(loginObj.Ele_SnipBackHomePageLogo("light-logo")), "Unable to view Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The Login popup must open with buttons for signin.
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(snipbackloginObj.Btn_Signin("SIGN IN")),"User is not able to view the SignIn button in the Popup");

		//Step 3:Enter User name & password and click on the button "SignIn".
		//Expected:The login must be successful and need to navigate to Page.
		base.setData(loginObj.Edt_LoginCredentialFields("email_address"), CommonData.UserName);
		base.setData(loginObj.Edt_LoginCredentialFields("password"), CommonData.PassWord);
		base.buttonClick(loginObj.Btn_SignInButton("SIGN IN"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("menu_link nav-link  active ")), "User login is unsuccessfull");

		//Step 4:Go to Games/Members page.
		//Expected:The Games page must be loaded.	
		base.buttonClick(loginObj.Btn_LoginButton("menu_link nav-link  active "));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("nav-link  tab-team-type active")),"User not able to view the Games page");

		//Step 5: Switch to Any team after searching
		//Expected : The teams and their appropriate event must load fine.
		base.setData(CreateNewMemberObj.Edt_SearchBox("form-control input-wrap"),CreateAddNewMemeberTestData.TC01_CreateAddNewMemberTeamName );
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ele_SearchedSelection("d-flex align-items-center item-label","CreateORAddUserName")), "Searched Team is not loading properly");

		//step 6: Click on the three Dots near the team name.
		//Expected: The option Edit Team must open.
		base.buttonClick(registrationObj.Btn_ResendOTP("defaultDropdown-41"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ddl_Selection("team","Edit Team")), "The User is not able to see the Edit Team option");

		//step 7: Click on the option "Edit Team".
		//Expected: The Edit team grid must open and need the option to add user with email ID.
		base.buttonClick(CreateNewMemberObj.Ddl_Selection("team","Edit Team"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")), "User is not able to see the option Create & Add new member with Email");

		//step 8: Click Create&Add New Member with Email.
		//Expected: The user should navigate to CREATE NEW USER pop up.
		base.buttonClick(loginObj.Edt_AlertMessage("Create & Add New Member With Email"));
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("user-tab nav-link active")), "User is unable to view the Add New User Popup");

		//step 9: Enter values in all the fields except Last Name and jersey number Field and check whether the Player is added or not.
		//Expected: The player must added successfully..
		base.setData(loginObj.Edt_LoginEmail("emailInputNew"),CreateAddNewMemeberTestData.TC03_CreateAddNewMemberEmail );
		base.setData(loginObj.Edt_LoginEmail("firstnameNew"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberFirstName );
		base.setData(loginObj.Edt_LoginEmail("lastnameNew"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberLastName );
		base.setData(loginObj.Edt_LoginEmail("newJerseyNumber"),CreateAddNewMemeberTestData.TC05_CreateAddNewMemberJerseyNum );
		base.scrollToElement(loginObj.Btn_SingnIn("createUserBtn"));
		Thread.sleep(2000);
		base.excuteJsClick(loginObj.Btn_SingnIn("createUserBtn"));
		Thread.sleep(3000);
		base.buttonClick(CreateNewMemberObj.Tab_TabClick("swal-button swal-button--confirm"));
		base.setData(loginObj.Edt_LoginEmail("teamUser"),CreateAddNewMemeberTestData.TC09_CreateAddNewMemberSearchText );
		Thread.sleep(2000);
		String FirstPosition=base.GetText(snipbackloginObj.Btn_Signin("New"));
		Thread.sleep(2000);
		asrt.assertEquals(FirstPosition,"New","Newly Added User is not added to the team");       
	}
}
