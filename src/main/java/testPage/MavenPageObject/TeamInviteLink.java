package testPage.MavenPageObject;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import TestData.CommonData;
import TestData.TeamInviteLink_TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.TeamInviteLink_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.CreateUpdateDeleteGame_Obj;
import utilPack.BasePge;

public class TeamInviteLink extends BasePge {

	BasePge base;
	Assert asrt; 

	public TeamInviteLink (WebDriver driver) 
	{
		super(driver);
		base = new BasePge(driver);
	}

	//<summary>
	// Test Case Title:"Verify that the respective link should be highlighted and the message "Copied" when click on Copy symbol against the respective link"
	// Automation ID  : Invitelink_06
	///</summary>
	public void Invitelink_06_TeamInviteLink() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData CommonData = new CommonData();
		Pool_Obj Pool_obj =new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestData = new TeamInviteLink_TestData();
		TeamInviteLink_Obj TeamInviteLinkObj =new TeamInviteLink_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		///Step 3  :"Click on Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User unable to click Games button");

		//Step 4 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_06_OrgName));
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_06_OrgName)),
				"The option 'Org' is not selected from the team dropdown.");
		//Step 5 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("defaultDropdown-2"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("teamDropdownMenu-2")),"User is unable to view the team drop down menu in the team list.");

		//Step 6 : Click on Team Invite Link
		//Expected : User should be able to click on Team Invite Link
		base.buttonClick(TeamInviteLinkObj.Ele_Teamlink("teamDropdownMenu-2","Team Invite Links"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-content share_url")),"User is unable to view the team invite link copy area.");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(" INVITE PLAYER "))," The Team Invite Link  is not clicked in Games page.");

		// Step 7  :"Click the "Copy" button for the invite link"
		// Expected:"The invite link should be highlighted and "Copied" message should appear"
		base.buttonClick(LoginPageObj.Btn_SingnIn("sharePlayerHref"));
		//Validate the InviteLink Color
		String expectedColor = "rgba(255, 255, 255, 1)";
		boolean isHighlighted = base.validateInviteLinkColor(LoginPageObj.Edt_LoginEmail("invitePlayerUrl"), expectedColor);
		// Assert the result
		if (isHighlighted) {
			System.out.println("Invite link is correctly highlighted in red.");
		} else {
			System.out.println("Invite link is NOT highlighted in red.");
		}
	}

	// <summary>
	// Test Case Title :"Verify that Signup Page should be displayed if we click on Singup from the login page displayed using Team Invite Links"
	// Automation ID   : Invitelink_12
	// </summary>

	public void Invitelink_12_TeamInviteLink() throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException
	{System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "off");

	Login login = new Login(driver); 
	LoginPage_Obj LoginPageObj = new LoginPage_Obj();
	Pool_Obj PoolObj = new Pool_Obj();
	Registration_Obj RegistrationObj = new Registration_Obj();
	SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
	CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemailObj = new CreateAddNewMemberWithEmail_Obj();
	TeamInviteLink_TestData TeamInviteLinkTestData = new TeamInviteLink_TestData();
	TeamInviteLink_Obj TeamInviteLinkObj =new TeamInviteLink_Obj();

	//Step 1   :"Navigate to the SnipBack page"
	//Expected :"User should able to view the SnipBack page"
	asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("navbar-brand")),"User is unable to view Snipback page");

	//Step 2   :"Click Login"
	//Expected :"User should able to click LoginButton"
	login.loginToApplication(CommonData.UserName, CommonData.PassWord);
	asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User is unable to view the Games section under film module.");

	//Step 3 : Switch the organization 
	//Expected : User should be able to switch the organization.
	base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_12_OrgName));
	asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_12_OrgName)),
			"The option 'Org' is not selected from the team dropdown.");
	//Step 4 : Click on three dots in the teams
	//Expected : User should be able to click on the three dots
	base.buttonClick(createaddnewmemberwithemailObj.Ele_EditTeam("defaultDropdown-2"));
	asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("teamDropdownMenu-2")),"User is unable to view the team drop down menu in the team list.");

	//Step 5 : Click on Team Invite Link
	//Expected : User should be able to click on Team Invite Link
	//base.buttonClick(AddupdateremovememberObj.Ele_EditTeam("showInviteModal(4684);"));
	base.buttonClick(TeamInviteLinkObj.Ele_Teamlink("teamDropdownMenu-2","Team Invite Links"));
	asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-content share_url")),"User is unable to view the team invite link copy area.");

	//Step 6 : Copy the team invite link links
	//Expected : User should be able to copy team invite links
	base.excuteJsClick(LoginPageObj.Btn_SingnIn("sharePlayerHref"));
	//asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("sharePlayerHref")),"User is unable to copy the team invite links from the Team Invite Link area.");	    
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	String copiedLink = (String) toolkit.getSystemClipboard().getData(DataFlavor.stringFlavor);
	System.out.println("Copied Link: " + copiedLink); // Verify the copied link
	driver.quit();

	//Step 7 : Copy the team invite link links in new browser
	//Expected : User should be able to paste the link
	WebDriverManager.edgedriver().setup();
	EdgeOptions options = new EdgeOptions();
	options.setCapability("ms:edgeOptions", Collections.singletonMap("args", new String[]{"--start-maximized"}));
	WebDriver edgeDriver = new EdgeDriver(options); // Initialize EdgeDriver with options
	// Open the copied link
	edgeDriver.get(copiedLink);
	// Validate the URL
	String actualURL = edgeDriver.getCurrentUrl();
	String expectedLink = "https://snipback.com/login";
	Assert.assertEquals(actualURL, expectedLink, "Unable to paste the copied link in any browser");
	// Validate the Sign-In button is visible
	Thread.sleep(2000);

	//Step 8 : View on Signup button
	//Expected : User should be able to view the signup button
	boolean isSignUpEnabled = edgeDriver.findElement(RegistrationObj.Edt_SignUpMinConfPassword("signup_text")).isEnabled();
	Assert.assertTrue(isSignUpEnabled, "Snipback signup button not displayed");
	edgeDriver.quit();
	} 

	// <summary>
	// Test Case Title :"Verify that an OTP field should be displayed after entering all the required fields from the Signup page "
	// Automation ID   : Invitelink_13
	// </summary>

	public void Invitelink_13_TeamInviteLink() throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException
	{System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "off");
	Login login = new Login(driver); 
	LoginPage_Obj LoginPageObj = new LoginPage_Obj();
	Pool_Obj PoolObj = new Pool_Obj();
	Registration_Obj RegistrationObj = new Registration_Obj();
	SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
	CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemailObj = new CreateAddNewMemberWithEmail_Obj();
	TeamInviteLink_TestData TeamInviteLinkTestData = new TeamInviteLink_TestData();
	TeamInviteLink_Obj TeamInviteLinkObj =new TeamInviteLink_Obj();

	//Step 1   :"Navigate to the SnipBack page"
	//Expected :"User should able to view the SnipBack page"
	asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("navbar-brand")),"User is unable to view Snipback page");

	//Step 2   :"Click Login"
	//Expected :"User should able to click LoginButton"
	login.loginToApplication(CommonData.UserName, CommonData.PassWord);
	asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User is unable to view the Games section under film module.");

	//Step 3 : Switch the organization 
	//Expected : User should be able to switch the organization.
	base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_13_OrgName));
	asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_13_OrgName)),
			"The option 'Org' is not selected from the team dropdown.");
	//Step 4 : Click on three dots in the teams
	//Expected : User should be able to click on the three dots
	base.buttonClick(createaddnewmemberwithemailObj.Ele_EditTeam("defaultDropdown-2"));
	asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("teamDropdownMenu-2")),"User is unable to view the team drop down menu in the team list.");

	//Step 5 : Click on Team Invite Link
	//Expected : User should be able to click on Team Invite Link
	Thread.sleep(2000);
	base.buttonClick(TeamInviteLinkObj.Ele_Teamlink("teamDropdownMenu-2","Team Invite Links"));
	asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-content share_url")),"User is unable to view the team invite link copy area.");

	//Step 6 : Copy the team invite link links
	//Expected : User should be able to copy team invite links
	base.buttonClick(LoginPageObj.Btn_SingnIn("sharePlayerHref"));
	//asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("myTooltip")),"User is unable to copy the team invite links from the Team Invite Link area.");	    
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	String copiedLink = (String) toolkit.getSystemClipboard().getData(DataFlavor.stringFlavor);
	System.out.println("Copied Link: " + copiedLink); // Verify the copied link
	driver.quit();
	Thread.sleep(6000);	        //Step 7 : Copy the team invite link links in new browser
	//Expected : User should be able to paste the link
	WebDriverManager.edgedriver().setup();
	EdgeOptions options = new EdgeOptions();
	options.setCapability("ms:edgeOptions", Collections.singletonMap("args", new String[]{"--start-maximized"}));
	WebDriver edgeDriver = new EdgeDriver(options); // Initialize EdgeDriver with options

	//Step 8 : Paste the link any browser
	//Expected : User should be able to paste the link on any browser       
	edgeDriver.manage().window().maximize();
	edgeDriver.get(copiedLink);
	// Validate the URL
	String actualURL = edgeDriver.getCurrentUrl();
	String expectedLink = "https://snipback.com/login";
	Assert.assertEquals(actualURL, expectedLink, "Unable to paste the copied link in any browser");
	// Validate the Sign-In button is visible
	Thread.sleep(2000);
	boolean isSignUpEnabled = edgeDriver.findElement(RegistrationObj.Edt_SignUpMinConfPassword("signup_text")).isEnabled();
	Assert.assertTrue(isSignUpEnabled, "Snipback signup page not displayed");

	//Step 9 : View on Signup button
	//Expected : User should be able to view the signup button and view the OTP field after Signup Clicked
	base.setZoom(edgeDriver,80);
	edgeDriver.findElement(RegistrationObj.Edt_SignUpMinConfPassword("signup_text")).click();
	boolean signUpFormPageDisplayed =edgeDriver.findElement(LoginPageObj.Ele_ErrorMessage("formWrap custom-signup")).isDisplayed();
	Assert.assertTrue(signUpFormPageDisplayed, "User is unable to view the signup form page.");

	//Step 10 : Verify that an OTP field should be displayed after entering all the required fields from the Signup page 
	//Expected : User should be able to view the signup page 
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("first_name")).sendKeys(TeamInviteLinkTestData.Invitelink_13_Name);
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("user_email")).sendKeys(TeamInviteLinkTestData.Invitelink_13_Email);
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("user_name")).sendKeys(TeamInviteLinkTestData.Invitelink_13_UserName);
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("user_pass")).sendKeys(TeamInviteLinkTestData.Invitelink_13_Password);
	base.setZoom(edgeDriver,60);
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("user_confirm_password")).sendKeys(TeamInviteLinkTestData.Invitelink_13_ConfirmPassword);
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("agreeterms")).click();
	edgeDriver.findElement(PoolObj.Btn_ButtonCreate("btn btn-submit")).click();
	Thread.sleep(2000);
	boolean OTPFieldDisplayed =edgeDriver.findElement(LoginPageObj.Btn_SingnIn("otp-submit")).isDisplayed();
	Assert.assertTrue(OTPFieldDisplayed, "User is unable to view the OTP field after clicking signup button.");

	edgeDriver.quit();


	}
	// <summary>
	// Test Case Title :"Verify that User should be joined to the team after enter the OTP received from the user's mail."
	// Automation ID   : Invitelink_14
	// </summary>

	public void Invitelink_14_TeamInviteLink() throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException
	{System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "off");
	Login login = new Login(driver); 
	LoginPage_Obj LoginPageObj = new LoginPage_Obj();
	Pool_Obj PoolObj = new Pool_Obj();
	Registration_Obj RegistrationObj = new Registration_Obj();
	SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
	CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemailObj = new CreateAddNewMemberWithEmail_Obj();
	TeamInviteLink_TestData TeamInviteLinkTestData = new TeamInviteLink_TestData();
	TeamInviteLink_Obj TeamInviteLinkObj =new TeamInviteLink_Obj();

	//Step 1   :"Navigate to the SnipBack page"
	//Expected :"User should able to view the SnipBack page"
	asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("navbar-brand")),"User is unable to view Snipback page");

	//Step 2   :"Click Login"
	//Expected :"User should able to click LoginButton"
	login.loginToApplication(CommonData.UserName, CommonData.PassWord);
	asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User is unable to view the Games section under film module.");

	//Step 3 : Switch the organization 
	//Expected : User should be able to switch the organization.
	base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_14_OrgName));
	asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_14_OrgName)),
			"The option 'Org' is not selected from the team dropdown.");
	
	//Step 4 : Click on three dots in the teams
	//Expected : User should be able to click on the three dots
	base.buttonClick(createaddnewmemberwithemailObj.Ele_EditTeam("defaultDropdown-2"));
	asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("teamDropdownMenu-2")),"User is unable to view the team drop down menu in the team list.");

	//Step 5 : Click on Team Invite Link
	//Expected : User should be able to click on Team Invite Link
	base.buttonClick(TeamInviteLinkObj.Ele_Teamlink("teamDropdownMenu-2","Team Invite Links"));
	asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-content share_url")),"User is unable to view the team invite link copy area.");

	//Step 6 : Copy the team invite link links
	//Expected : User should be able to copy team invite links
	base.buttonClick(LoginPageObj.Btn_SingnIn("sharePlayerHref"));
	//asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("myTooltip")),"User is unable to copy the team invite links from the Team Invite Link area.");	    
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	String copiedLink = (String) toolkit.getSystemClipboard().getData(DataFlavor.stringFlavor);
	System.out.println("Copied Link: " + copiedLink); // Verify the copied link
	driver.quit();

	//Step 7 : Copy the team invite link links in new browser
	//Expected : User should be able to paste the link
	WebDriverManager.edgedriver().setup();
	EdgeOptions options = new EdgeOptions();
	options.setCapability("ms:edgeOptions", Collections.singletonMap("args", new String[]{"--start-maximized"}));
	WebDriver edgeDriver = new EdgeDriver(options); // Initialize EdgeDriver with options

	//Step 8 : Paste the link any browser
	//Expected : User should be able to paste the link on any browser       
	edgeDriver.get(copiedLink);
	// Validate the URL
	String actualURL = edgeDriver.getCurrentUrl();
	String expectedLink = "https://snipback.com/login";
	Assert.assertEquals(actualURL, expectedLink, "Unable to paste the copied link in any browser");
	// Validate the Sign-In button is visible
	Thread.sleep(2000);
	boolean isSignUpEnabled = edgeDriver.findElement(RegistrationObj.Edt_SignUpMinConfPassword("signup_text")).isEnabled();
	Assert.assertTrue(isSignUpEnabled, "Snipback signup page not displayed");

	//Step 9 : View on Signup button
	//Expected : User should be able to view the signup button and view the OTP field after Signup Clicked
	base.setZoom(edgeDriver,80);
	edgeDriver.findElement(RegistrationObj.Edt_SignUpMinConfPassword("signup_text")).click();
	boolean signUpFormPageDisplayed =edgeDriver.findElement(LoginPageObj.Ele_ErrorMessage("formWrap custom-signup")).isDisplayed();
	Assert.assertTrue(signUpFormPageDisplayed, "User is unable to view the signup form page.");

	//Step 10 : Click on Signup button and able to view otp passcode
	//Expected : User should be able to view the signup page 
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("first_name")).sendKeys(TeamInviteLinkTestData.Invitelink_14_Name);
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("user_email")).sendKeys(TeamInviteLinkTestData.Invitelink_14_Email);
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("user_name")).sendKeys(TeamInviteLinkTestData.Invitelink_14_UserName);
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("user_pass")).sendKeys(TeamInviteLinkTestData.Invitelink_14_Password);
	base.setZoom(edgeDriver,60);
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("user_confirm_password")).sendKeys(TeamInviteLinkTestData.Invitelink_14_ConfirmPassword);
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("agreeterms")).click();
	edgeDriver.findElement(PoolObj.Btn_ButtonCreate("btn btn-submit")).click();
	Thread.sleep(2000);
	boolean OTPFieldDisplayed =edgeDriver.findElement(LoginPageObj.Btn_SingnIn("otp-submit")).isDisplayed();
	Assert.assertTrue(OTPFieldDisplayed, "User is unable to view the OTP field after clicking signup button.");


	//Step 9 : Enter the OTP  //We cant Automate OTP..Dummy
	//Expected : User should be able to join the team after entering OTP
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("signUp-otp")).sendKeys(TeamInviteLinkTestData.Invitelink_14_Otp); 
	edgeDriver.findElement(LoginPageObj.Btn_SingnIn("otp-submit")).click();

	edgeDriver.quit();
	}

	// <summary>
	// Test Case Title :"Verify that the Team and the Games under the team should be displayed in the User's snipback account after joining the team using singup(Player/Coach/Follower)."
	// Automation ID   : Invitelink_15
	// </summary>

	public void Invitelink_15_TeamInviteLink() throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException
	{System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "off");
	Login login = new Login(driver); 
	LoginPage_Obj LoginPageObj = new LoginPage_Obj();
	Pool_Obj PoolObj = new Pool_Obj();
	Registration_Obj RegistrationObj = new Registration_Obj();
	SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
	CreateAddNewMemberWithEmail_Obj createaddnewmemberwithemailObj = new CreateAddNewMemberWithEmail_Obj();
	TeamInviteLink_TestData TeamInviteLinkTestData = new TeamInviteLink_TestData();
	TeamInviteLink_Obj TeamInviteLinkObj =new TeamInviteLink_Obj();
	CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
	//Step 1   :"Navigate to the SnipBack page"
	//Expected :"User should able to view the SnipBack page"
	asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("navbar-brand")),"User is unable to view Snipback page");

	//Step 2   :"Click Login"
	//Expected :"User should able to click LoginButton"
	login.loginToApplication(CommonData.UserName, CommonData.PassWord);
	asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Btn_Games("nav-game")),"User is unable to view the Games section under film module.");

	//Step 3 : Switch the organization 
	//Expected : User should be able to switch the organization.
	base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
	base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_15_OrgName));
	asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_15_OrgName)),
			"The option 'Org' is not selected from the team dropdown.");
	
	//Step 4 : Click on three dots in the teams
	//Expected : User should be able to click on the three dots
	base.buttonClick(createaddnewmemberwithemailObj.Ele_EditTeam("defaultDropdown-2"));
	asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("teamDropdownMenu-2")),"User is unable to view the team drop down menu in the team list.");

	//Step 5 : Click on Team Invite Link
	//Expected : User should be able to click on Team Invite Link
	base.buttonClick(TeamInviteLinkObj.Ele_Teamlink("teamDropdownMenu-2","Team Invite Links"));
	asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-content share_url")),"User is unable to view the team invite link copy area.");

	//Step 6 : Copy the team invite link links
	//Expected : User should be able to copy team invite links
	base.buttonClick(LoginPageObj.Btn_SingnIn("sharePlayerHref"));
	//asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("myTooltip")),"User is unable to copy the team invite links from the Team Invite Link area.");	    
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	String copiedLink = (String) toolkit.getSystemClipboard().getData(DataFlavor.stringFlavor);
	System.out.println("Copied Link: " + copiedLink); // Verify the copied link
	driver.quit();

	//Step 7 : Copy the team invite link links in new browser
	//Expected : User should be able to paste the link
	WebDriverManager.edgedriver().setup();
	EdgeOptions options = new EdgeOptions();
	options.setCapability("ms:edgeOptions", Collections.singletonMap("args", new String[]{"--start-maximized"}));
	WebDriver edgeDriver = new EdgeDriver(options); // Initialize EdgeDriver with options

	//Step 8 : Paste the link any browser
	//Expected : User should be able to paste the link on any browser       
	edgeDriver.get(copiedLink);
	// Validate the URL
	String actualURL = edgeDriver.getCurrentUrl();
	String expectedLink = "https://snipback.com/login";
	Assert.assertEquals(actualURL, expectedLink, "Unable to paste the copied link in any browser");
	// Validate the Sign-In button is visible
	Thread.sleep(2000);
	boolean isSignInEnabled = edgeDriver.findElement(RegistrationObj.Edt_SignUpMinConfPassword("signup_text")).isEnabled();
	Assert.assertTrue(isSignInEnabled, "Snipback signup button not displayed");

	//Step 8 : Login with existing credentials
	//Expected : User should be able to login with existing credentials    
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("email_address")).sendKeys(CommonData.UserName);
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("password")).sendKeys(CommonData.PassWord);
	edgeDriver.findElement(PoolObj.Btn_ButtonCreate("btn btn-submit")).click();
	Thread.sleep(3000);
	boolean isGameDisplayed = edgeDriver.findElement(LoginPageObj.Btn_SingnIn("nav-game-tab")).isDisplayed();
	Assert.assertTrue(isGameDisplayed, "User is unable to view the Games section under film module.");

	//Step 9 : Verify Team and Games under the Team
	//Expected : User should be able to view teams and games under the team
	edgeDriver.findElement(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")).click();
	edgeDriver.findElement(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_15_OrgName)).click();
	edgeDriver.findElement(LoginPageObj.Btn_SingnIn("nav-game-tab")).click();
	base.setZoom(edgeDriver, 60);
	Thread.sleep(3000);
	edgeDriver.findElement(LoginPageObj.Edt_LoginEmail("searchTeam")).sendKeys(TeamInviteLinkTestData.Invitelink_15_TeamName);
	Thread.sleep(2000);
	boolean isTeamDisplayed = edgeDriver.findElement(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(TeamInviteLinkTestData.Invitelink_08_TeamName,"dropdown-wrapper teams-menu")).isDisplayed();
	Assert.assertTrue(isTeamDisplayed, "User is unable to view the teams under the organization.");
	//asrt.assertTrue(base.isExists(PoolObj.Ele_PoolTitle("GAME")),"User is unable to view the teams and games under the teams.");
	edgeDriver.quit();
	}

	// <summary>
	// Test Case Title :"Verify that user should able to navigate to the snipback website after entering the URL"
	// Automation ID   : Invitelink_01
	// </summary>
	public void Invitelink_01_TeamInviteLink() throws InterruptedException {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");
	}

	// <summary>
	// Test Case Title :"Verify that user should able to navigate to the Film page once login with credentials"
	// Automation ID   : Invitelink_02
	// </summary>
	public void Invitelink_02_TeamInviteLink() throws InterruptedException {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		//Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User unable to navigate to the Film page once login with credentials");

	}

	// <summary>
	// Test Case Title :"Verify that Team InviteLinks option should be displayed in the three dots against all teams in the organization if the user as Admin/Coach in the Game, Members & Followers tab in the Film page"
	// Automation ID   : Invitelink_03
	// </summary>
	public void Invitelink_03_TeamInviteLink() throws InterruptedException {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Pool_Obj Pool_obj =new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmail = new CreateAddNewMemberWithEmail_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestData = new TeamInviteLink_TestData();
		TeamInviteLink_Obj TeamInviteLinkObj =new TeamInviteLink_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		//Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));	
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 4   :"Select Organization"
		//Expected :"User should be navigated to Organization and select AutomationOrg - 1 "
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"),TeamInviteLinkTestData.Invitelink_03_OrgName);
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_03_OrgName)),
				"The option 'Org' is not selected from the team dropdown.");
		
		//Step 5 :"Three Dot Option should be displayed in the organization if the Admin/Coach user	
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmail.Ele_EditTeam("defaultDropdown-2")),"Three Dot Option should not be displayed in the Games Page if the user is admin/coach organization");
		base.buttonClick(CreateAddNewMemberWithEmail.Ele_EditTeam("defaultDropdown-2"));
		asrt.assertTrue(base.isExists(TeamInviteLinkObj.Ele_Teamlink("teamDropdownMenu-2","Team Invite Links")),"Team Invite Links is not displayed in the three dot option");
		//Thread.sleep(1000);

		//Step 6 :"Three Dot Option should be displayed in the organization if the Admin/Coach user	in Members page
		base.buttonClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("MEMBERS")),"User should not be navigated to Members");
		//Thread.sleep(500);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmail.Ele_EditTeam("defaultDropdown-2")),"Three Dot Option should not be displayed in the Members Page if the user is admin/coach organization");
		base.buttonClick(CreateAddNewMemberWithEmail.Ele_EditTeam("defaultDropdown-2"));
		//Thread.sleep(500);
		asrt.assertTrue(base.isExists(TeamInviteLinkObj.Ele_Teamlink("teamDropdownMenu-2","Team Invite Links")),"Team Invite Links is not displayed in the three dot option");
		//Thread.sleep(1000);

		//Step 7 :"Three Dot Option should be displayed in the organization if the Admin/Coach user	in Followers Page
		base.buttonClick(LoginPageObj.Edt_Alert1("FOLLOWERS"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("FOLLOWERS")),"User should not be navigated to Followers");
		//Thread.sleep(500);
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmail.Ele_EditTeam("defaultDropdown-2")),"Three Dot Option not displayed in the Followers Page if the user is admin/coach organization");
		base.buttonClick(CreateAddNewMemberWithEmail.Ele_EditTeam("defaultDropdown-2"));
		//Thread.sleep(500);
		asrt.assertTrue(base.isExists(TeamInviteLinkObj.Ele_Teamlink("teamDropdownMenu-2","Team Invite Links")),"Team Invite Links is not displayed in the three dot option");
		//Thread.sleep(1000);		
	}

	// <summary>
	// Test Case Title :"Verify that Team InviteLinks option should be disabled in Home organization and in the Organization if the User as Player/Followers/Recruiter in the Film page"
	// Automation ID   : Invitelink_04
	// </summary>
	public void Invitelink_04_TeamInviteLink() throws InterruptedException {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Pool_Obj Pool_obj =new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmail = new CreateAddNewMemberWithEmail_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMember = new AddUpdateRemoveMember_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestData = new TeamInviteLink_TestData();
		TeamInviteLink_Obj TeamInviteLinkObj =new TeamInviteLink_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		//Thread.sleep(3000);	
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 4   :"Select Home"
		//Expected :"Three dot option should not display in Home page"
		//Thread.sleep(3000);	
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "Home");
		asrt.assertTrue(base.isExists(AddUpdateRemoveMember.Btn_selectteam("teamSidebar")),"There is team to select showing in Home");

		//Step 5   :"Select an org have player/recruiter/Followers"
		//Expected :"Three dot option should display in the ORg"
		//Thread.sleep(500);	
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TeamInviteLinkTestData.Invitelink_04_OrgName);		
		//Thread.sleep(500);	
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmail.Ele_EditTeam("defaultDropdown-1")),"Three Dot Option  not be displayed in the Games Page if the user is admin/coach organization");			
		base.buttonClick(CreateAddNewMemberWithEmail.Ele_EditTeam("defaultDropdown-1"));

		//Step 6   :"to check teaminvitelink option display in player/recruiter/Followers"
		//Expected :"Team InviteLink option should not display in Android Tab - test"
		//asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Chat with Team")),"There is element showing TeamInviteLink");
		asrt.assertFalse(base.isExistsNegative(TeamInviteLinkObj.Ele_Teamlink("teamDropdownMenu-2","Team Invite Links")),"Team Invite Links is  displayed in the three dot option");

	}
	// <summary>
	// Test Case Title :"Verify that when click on Team InviteLinks from the three dots against the team, the following links should be displayed;
	//INVITE PLAYER with player link & the icon for copying,INVITE COACH with coch link & the icon for copying,INVITE FOLLOWER with Follower link & the icon for copying
	// Automation ID   : Invitelink_05
	// </summary>
	public void Invitelink_05_TeamInviteLink() throws InterruptedException {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Pool_Obj Pool_obj =new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmail = new CreateAddNewMemberWithEmail_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestData = new TeamInviteLink_TestData();
		TeamInviteLink_Obj TeamInviteLinkObj =new TeamInviteLink_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		//Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Btn_Login("Film"));	
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"User should not be navigated to Film Page");

		//Step 4   :"Select Organization"
		//Expected :"User should be navigated to Organization and select org contain admin/coach "
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TeamInviteLinkTestData.Invitelink_05_OrgName);
		asrt.assertTrue(base.isExists(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the GameList");
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_05_OrgName)),
				"The option 'Org' is not selected from the team dropdown.");

		//Step 5 :"Three Dot Option should be displayed in the organization if the Org Admin/Coach user	
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmail.Ele_EditTeam("defaultDropdown-2")),"Three Dot Option not be displayed in the Games Page if the user is admin/coach organization");

		//step 6:"Click on ThreeDot Option and displaying TeamInviteLink"
		base.buttonClick(CreateAddNewMemberWithEmail.Ele_EditTeam("defaultDropdown-2"));
		asrt.assertTrue(base.isExists(TeamInviteLinkObj.Ele_Teamlink("teamDropdownMenu-2","Team Invite Links")),"Team Invite Links is not displayed in the three dot option");

		//Step 7 :"Select TeamInvitelink 	
		base.buttonClick(TeamInviteLinkObj.Ele_Teamlink("teamDropdownMenu-2","Team Invite Links"));
		//Thread.sleep(500);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(" INVITE PLAYER ")),"INVITE PLAYER  not be displayed in the Team Invite Link option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("invitePlayerUrl")),"Invite Player URl  not be displayed in the InvitePlayer option");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SigninClick("sharePlayerInvite()")),"CopyURl  not be displayed in the InvitePlayer option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(" INVITE COACH ")),"INVITE COACH  not be displayed in the Team Invite Link option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("inviteCoachUrl")),"Invite Coach URl  not be displayed in the InviteCoach option");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SigninClick("shareCoachInvite()")),"CopyURl  not be displayed in the InviteCoach option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(" INVITE FOLLOWER ")),"INVITE FOLLOWER  not be displayed in the Team Invite Link option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("inviteFollowerUrl")),"Invite Follower URl  not be displayed in the InviteFollower option");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SigninClick("shareFollowerInvite()")),"CopyURl  not be displayed in the InviteFollower option");


	}
	///<summary>
	// Test Case Title:""Verify that user should be able to join the team by using the respective link by the following ways"
	// Automation ID  : Invitelink_08
	///</summary>

	public void Invitelink_08_TeamInviteLink() throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData CommonData = new CommonData();
		Pool_Obj Pool_obj =new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		TeamInviteLink_Obj TeamInviteLinkObj = new TeamInviteLink_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestData = new TeamInviteLink_TestData();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		///Step 3  :"Click on Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User unable to click Games button");

		//Step 4   :"Select GameName"
		//Expected :"User should be navigated to GameList"
		base.selectorByVisibleText(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"), TeamInviteLinkTestData.Invitelink_08_OrgName);
		asrt.assertTrue(base.isExists(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to click GameList");
		//base.scrollToElement(ScheduleUnscheduleGamesObj.Ele_FirstDate("5"));

		//Step 5   :"Click Org"
		//Expected :"User should be navigated to Org"
		driver.navigate().refresh();
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TeamInviteLinkTestData.Invitelink_08_TeamName);
		Thread.sleep(2000);
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_SelectTeam2(TeamInviteLinkTestData.Invitelink_08_TeamName,"dropdown-wrapper teams-menu"));
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_08_OrgName)),
				"The option 'Org' is not selected from the team dropdown.");
	
		//Step 6   :"Click Team Invite Link"
		//Expected :"User should be navigated to Team Invite Link"
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), TeamInviteLinkTestData.Invitelink_08_TeamName);
		Thread.sleep(2000);
		base.buttonClick(TeamInviteLinkObj.Ele_TeamOptions(TeamInviteLinkTestData.Invitelink_08_TeamName,"teamDropdownMenu","Team Invite Links"));//"teamDropdownMenu-3"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(" INVITE PLAYER "))," The Team Invite Link  is not clicked in Games page.");

		// Step 7  :"Click the "Copy" button for the invite link"
		// Expected:"The invite link should be highlighted and "Copied" message should appear"
		base.buttonClick(LoginPageObj.Btn_SingnIn("sharePlayerHref"));
		// Retrieve the copied link from the clipboard
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		String copiedLink = (String) toolkit.getSystemClipboard().getData(DataFlavor.stringFlavor);

		System.out.println("Copied Link: " + copiedLink); // Verify the copied link

		//Validate the InviteLink Color
		String expectedColor = "rgba(255, 255, 255, 1)";
		boolean isHighlighted = base.validateInviteLinkColor(LoginPageObj.Edt_LoginEmail("invitePlayerUrl"), expectedColor);

		// Assert the result
		if (isHighlighted) {
			System.out.println("Invite link is correctly highlighted in red.");
		} else {
			System.out.println("Invite link is NOT highlighted in red.");
		}

		//Step    8:"Verify that Snipback login page should displayed when paste the copied link in any browser"
		//Expected :"Snipback login page should displayed when paste the copied link in any browser" 
		Thread.sleep(5000);
		login.logoutApplication(LoginPageObj.Ele_ErrorMessage("dropdown-menu show"), LoginPageObj.Btn_LoginButton("dropdown-item bdr-top-2 logout-class"));
		driver.get(copiedLink);
		String actualURL = driver.getCurrentUrl();
		String expectedLink = "https://snipback.com/login";
		asrt.assertEquals(expectedLink, actualURL, "Snipback login page should not be displayed when paste the copied link in any browser");
		//Thread.sleep(2000);

		//Step 9   :"Signup as a New User"
		//Expected :"User should able to Signup as New User"
		base.buttonClick(LoginPageObj.Edt_Alert1("Sign up"));
		String ExcepectedUrl = "https://snipback.com/signup";
		String CurrentUrl = driver.getCurrentUrl();
		asrt.assertEquals(CurrentUrl, ExcepectedUrl, "User is unable to navigate to signup page");
		String NewUserName = TeamInviteLinkTestData.Invitelink_08_TeamName + CreateRandomWithoutNumbers(2);

		base.setData(LoginPageObj.Edt_LoginEmail("first_name"), NewUserName);
		String enteredName = base.GetValue(LoginPageObj.Edt_LoginEmail("first_name"));
		asrt.assertEquals(NewUserName, enteredName, "EnteredName is not displayed as  NewUserName");

		String NewUserEmail = "SemTest" + CreateRandom(2) + TeamInviteLinkTestData.Invitelink_08_Email;
		base.setData(LoginPageObj.Edt_LoginEmail("user_email"), NewUserEmail);
		String enteredUserEmail = base.GetValue(LoginPageObj.Edt_LoginEmail("user_email"));
		asrt.assertEquals(NewUserEmail, enteredUserEmail, "EnteredUserEMail is not displayed as  NewUserEmail");

		base.setData(LoginPageObj.Edt_LoginEmail("user_name"), NewUserName);
		String enteredUserName = base.GetValue(LoginPageObj.Edt_LoginEmail("user_name"));
		asrt.assertEquals(NewUserName, enteredUserName, "EnteredUserName is not displayed as  NewUserName");

		String NewPassword = NewUserName + CreateRandom(2) +"@1";
		base.setData(LoginPageObj.Edt_LoginEmail("user_pass"), NewPassword);
		String enteredUserPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("user_pass"));
		asrt.assertEquals(NewPassword, enteredUserPassword, "EnteredUserPassword is not displayed as  NewPassword");		

		base.setData(LoginPageObj.Edt_LoginEmail("user_confirm_password"), NewPassword);
		String enteredConfirmPassword = base.GetValue(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		asrt.assertEquals(NewPassword, enteredConfirmPassword, "EnteredConfirmPassword is not displayed as  NewPassword");		

		base.scrollToElement(LoginPageObj.Edt_LoginEmail("user_confirm_password"));
		base.buttonClick(LoginPageObj.Edt_LoginEmail("agreeterms"));
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Btn_SingnIn("btn-signup"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("VERIFY ONE-TIME PASSCODE")), "User unable to Signup as new user");

	}

	//<summary>
	// Test Case Title:"Verify that Snipback login page should displayed when paste the copied link in any browser"
	// Automation ID  : Invitelink_07
	//</summary>

	public void Invitelink_07_TeamInviteLink() throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData CommonData = new CommonData();
		Pool_Obj Pool_obj =new Pool_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SearchGameTeamAndMembers_Obj searchgameteamandmembersObj = new SearchGameTeamAndMembers_Obj();
		TeamInviteLink_TestData TeamInviteLinkTestData = new TeamInviteLink_TestData();
		TeamInviteLink_Obj TeamInviteLinkObj = new TeamInviteLink_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is unable to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		///Step 3  :"Click on Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User unable to click Games button");

		//Step 4 : Switch the organization 
		//Expected : User should be able to switch the organization.
		base.buttonClick(Pool_obj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_07_OrgName));
		asrt.assertTrue(base.isExists(searchgameteamandmembersObj.Edt_DataName(TeamInviteLinkTestData.Invitelink_07_OrgName)),
				"The option 'Org' is not selected from the team dropdown.");
	
		//Step 5 : Click on three dots in the teams
		//Expected : User should be able to click on the three dots
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("defaultDropdown-2"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("teamDropdownMenu-2")),"User is unable to view the team drop down menu in the team list.");

		//Step 6 : Click on Team Invite Link
		//Expected : User should be able to click on Team Invite Link
		base.buttonClick(TeamInviteLinkObj.Ele_Teamlink("teamDropdownMenu-2","Team Invite Links"));		
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("modal-content share_url")),"User is unable to view the team invite link copy area.");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(" INVITE PLAYER "))," The Team Invite Link  is not clicked in Games page.");

		// Step 8  :"Click the "Copy" button for the invite link"
		// Expected:"The invite link should be highlighted and "Copied" message should appear"
		base.buttonClick(LoginPageObj.Btn_SingnIn("sharePlayerHref"));
		// Retrieve the copied link from the clipboard
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		String copiedLink = (String) toolkit.getSystemClipboard().getData(DataFlavor.stringFlavor);
		System.out.println("Copied Link: " + copiedLink); // Verify the copied link

		//Validate the InviteLink Color
		String expectedColor = "rgba(255, 255, 255, 1)";
		boolean isHighlighted = base.validateInviteLinkColor(LoginPageObj.Edt_LoginEmail("invitePlayerUrl"), expectedColor);
		// Assert the result
		if (isHighlighted) {
			System.out.println("Invite link is correctly highlighted in red.");
		} else {
			System.out.println("Invite link is NOT highlighted in red.");
		}

		//Step 9:"Verify that Snipback login page should displayed when paste the copied link in any browser"
		//Expected :"Snipback login page should displayed when paste the copied link in any browser" 
		driver.get(copiedLink);
		String actualURL = driver.getCurrentUrl();
		String expectedLink = "https://snipback.com/";
		asrt.assertEquals(expectedLink, actualURL, "Snipback login page should not be displayed when paste the copied link in any browser");

	}

}

