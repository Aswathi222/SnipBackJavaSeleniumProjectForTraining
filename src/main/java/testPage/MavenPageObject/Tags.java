package testPage.MavenPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import TestData.AddEditInfo_TestData;
import TestData.CommonData;
import TestData.SnipBackLogin_TestData;
import TestData.Tags_TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import TestData.CommonData;
import TestData.Tags_TestData;
import TestData.WhiteboardAndReels_TestData;
import objectRepository.AddEditInfo_Obj;
import objectRepository.AddFollower_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.DuplicateTeam_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.Tags_Obj;
import objectRepository.ViewProfile_Obj;
import objectRepository.AddEditInfo_Obj;
import objectRepository.AddUpdateDeleteDuplicateTeamGameDefaults_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.ArchiveUnarchiveTeam_Obj;
import objectRepository.ForgotPassword_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.Tags_Obj;
import objectRepository.ViewListUpdateDownloadShareDeleteLibrary_Obj;
import objectRepository.ViewProfile_Obj;
import utilPack.BasePge;

public class Tags extends BasePge {

	BasePge base;
	Assert asrt; 

	public Tags(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters an invalid Taglist Name."
	// Automation ID   :Tags_05 
	// </summary>

	public void Tags_05_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Click '+' Button"
		//Expected :"User should be able to click '+' Button"
		base.buttonClick(TagsObj.Btn_TagsListPlusButton("showTagListModal"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User not able to click '+' Button");

		//Step 5   :"Enter Tag Name"
		//Expected :"User should be able to Enter Tag Name"
		base.setData(LoginPageObj.Edt_LoginEmail("test1"), TagsTestData.Tags05_InvalidTagListName);
		String actualTagListName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertEquals(actualTagListName, TagsTestData.Tags05_InvalidTagListName, "User not able to enter the Tag Name");

		//Step 6  :"Click Create Button"
		//Expected:"The user will receive alert message as "Please enter the valid name, the invalid characters are &/\#,+()$~%.^':*?<>{}"."
		base.buttonClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Alert("Please enter the valid name, the invalid characters")),"User not able to see the \"Please enter the valid name, the invalid characters are &/\\#,+()$~%.^':*?<>{}\"");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks UPDATE without making any changes in the existing name."
	// Automation ID   : Tags_20
	public void Tags_20_Tags() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Click '+' Button"
		//Expected :"User should be able to click '+' Button"
		base.buttonClick(TagsObj.Btn_TagsListPlusButton("showTagListModal"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User not able to click '+' Button");

		//Step 5   :"Enter Tag Name"
		//Expected :"User should be able to Enter Tag Name"
		base.setData(LoginPageObj.Edt_LoginEmail("test1"), TagsTestData.Tags05_InvalidTagListName);
		String actualTagListName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertEquals(actualTagListName, TagsTestData.Tags05_InvalidTagListName, "User not able to enter the Tag Name");

		//Step 6  :"Click Create Button"
		//Expected:"The user will receive alert message as "Please enter the valid name, the invalid characters are &/\#,+()$~%.^':*?<>{}"."
		base.buttonClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_Alert("Please enter the valid name, the invalid characters")),"User not able to see the \"Please enter the valid name, the invalid characters are &/\\#,+()$~%.^':*?<>{}\"");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters an existing TagList name."
	// Automation ID   :Tags_06 
	// </summary>

	public void Tags_06_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Click '+' Button"
		//Expected :"User should be able to click '+' Button"
		base.buttonClick(TagsObj.Btn_TagsListPlusButton("showTagListModal"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User not able to click '+' Button");

		//Step 5   :"Enter the TagList name"
		//Expected :"User should be able to Enter Tag Name"
		base.setData(LoginPageObj.Edt_LoginEmail("test1"), TagsTestData.Tags06_DuplicateTagListName);
		String actualTagListName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertEquals(actualTagListName, TagsTestData.Tags06_DuplicateTagListName, "User not able to enter the Tag Name");

		//Step 6  :"Click Create Button"
		//Expected:"User will recieves alert message as "Custom Tag List Name Already Exists.""
		base.buttonClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj .Ele_MemberName("Custom Tag List Name Already Exists.")),"User not able to see the Custom Tag List Name Already Exists");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the Delete Icon."
	// Automation ID   : Tags_21
	public void Tags_21_Tags() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj(); 

		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback and click on Tags module
		//Expected:Tags list should be visible to the user.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(TagsObj.Btn_Tags("collapse navbar-collapse", "tags_page"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("customtag-tab-btn active")),"User is not able to view the tag lists under tag module.");

		// Step 3 :"Select any TagList"
		// Expected:"User should Select any TagList"
		base.scrollToElement(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(TagsObj.Ele_TagsName("7407")),
				"User is not Select any TagList");

		// Step 4 :"Click the Delete Icon"
		// Expected:"A popup text field will appear with its name in it, prompting the user : Are you sure want to Delete ?"
		String ActualName=base.GetText(TagsObj.Ele_TagsName("7407"));
		base.excuteJsClick(TagsObj.Btn_Edit(ActualName, 4));
		Thread.sleep(20000);	
		//		asrt.assertTrue(base.isExists(TagsObj.Btn_Edit(ActualName, 4)),
		//				"A popup text field will not appear with its name in it, prompting the user to enter a new TagList name.");

		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Are you sure want to Delete ?"))," User is not received confirmation popup as \"Are you sure want to Delete ? while clicking on delete icon");
	}


	// <summary>
	// Test Case Title :"To verify what happens when user left the List name field empty."
	// Automation ID   :Tags_07 
	// </summary>

	public void Tags_07_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Click '+' Button"
		//Expected :"User should be able to click '+' Button"
		base.buttonClick(TagsObj.Btn_TagsListPlusButton("showTagListModal"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User not able to click '+' Button");

		//Step 5  :"Click Create Button"
		//Expected:"The user will receive alert message as "Please enter the valid name, the invalid characters are &/\#,+()$~%.^':*?<>{}"."
		base.buttonClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj .Ele_MemberName("The Tag List Name field is required.")),"User not able to see the The Tag List Name field is required.");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks Yes in the confirmation popup."
	// Automation ID   : Tags_22
	// </summary>
	public void Tags_22_Tags() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj=new SearchGameTeamAndMembers_Obj();
		ArchiveUnarchiveTeam_Obj ArchiveUnarchiveTeamObj = new ArchiveUnarchiveTeam_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 5   :"Click '+' icon near TagList"
		//Expected :"User should be able to click on the '+' icon near TagList"
		base.buttonClick(TagsObj.Btn_TagsListPlusButton("showTagListModal();"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User is not able to click '+' Button");

		//Step 6   :"Enter Tag Name"
		//Expected :"User should be able to Enter Tag Name"
		base.setData(LoginPageObj.Edt_LoginEmail("test1"), TagsTestData.Tags_22);
		String actualTagListName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		Thread.sleep(5000);
		asrt.assertEquals(actualTagListName, TagsTestData.Tags_22, "User not able to enter the Tag Name");

		//Step 7  :"Click Create Button"
		//Expected:"The user should be able to create a new TagList, and it should appear at the end of the list."
		//asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("tagliatCreate")),"User is not able to view the create button in SnipBack" );
		base.buttonClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		Thread.sleep(5000);
		//asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTeamAlert("Record Created Successfully ")),"The user is not able to create a new TagList");
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Record Created Successfully ")),"The user is not able to create a new TagList");
		base.buttonClick(ArchiveUnarchiveTeamObj.Btn_TeamCreatedClose("modal-footer", "modalMessageCloseBtn"));
		
		base.scrollToElement(TagsObj.Ele_DelTagsName("DelTag"));
		base.excuteJsClick(TagsObj.Btn_Tagdelete("DelTag"));

		
		//		//Step 4   :"Select any TagList"
		//		//Expected :"User should be able to Select any TagList"
		//		String TagName= base.GetText(TagsObj.Ele_UpdateName("flex-grow-1"));
		//		base.buttonClick(TagsObj.Ele_UpdateName("flex-grow-1"));
		//
		//		//Step 5   :"Click the Delete Icon near Tags"
		//		//Expected :"User should be able to clickable the Delete Icon near Tags"
		//		Thread.sleep(500);
			//	base.excuteJsClick(TagsObj.Btn_Tagdelete(TagName));

		//Step 6   :"Click the Yes button near Tags"
		//Expected :"User should be able to clickable the Yes button near Tags"
		base.buttonClick(LoginPageObj.Btn_SingnIn("deleteMsgsave"));

	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks Close in the confirmation popup."
	// Automation ID   : Tags_23	
	public void Tags_23_Tags() throws Exception
	{

		Tags_Obj TagsObj = new Tags_Obj();
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj(); 

		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback and click on Tags module
		//Expected:Tags list should be visible to the user.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(TagsObj.Btn_Tags("collapse navbar-collapse", "tags_page"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("customtag-tab-btn active")),"User is not able to view the tag lists under tag module.");

		// Step 3 :"Select any TagList"
		// Expected:"User should Select any TagList"
		base.scrollToElement(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(TagsObj.Ele_TagsName("7407")),
				"User is not Select any TagList");

		// Step 4 :"Click the Delete Icon"
		// Expected:"A popup text field will appear with its name in it, prompting the user : Are you sure want to Delete ?"
		String ActualName=base.GetText(TagsObj.Ele_TagsName("7407"));
		base.excuteJsClick(TagsObj.Btn_Edit(ActualName, 4));
		Thread.sleep(20000);	
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Are you sure want to Delete ?"))," User is not received confirmation popup as \"Are you sure want to Delete ? while clicking on delete icon");

		//Step 4 : Click on close button in Tag deleting tab
		//Expected : The confirmation popup closes when user clicks Close and user is able to view the Tag list in Tag deleting tab.
		base.buttonClick(LoginPageObj.Btn_SingnIn("deleteMsgClose"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("customtag-tab-btn active")),"User is not able to view the tag lists under tag module.");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks CANCEL instead of CREATE."
	// Automation ID   :Tags_08
	// </summary>

	public void Tags_08_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Click '+' Button"
		//Expected :"User should be able to click '+' Button"
		base.buttonClick(TagsObj.Btn_TagsListPlusButton("showTagListModal"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User not able to click '+' Button");

		//Step 5   :"Enter Tag Name"
		//Expected :"User should be able to Enter Tag Name"
		base.setData(LoginPageObj.Edt_LoginEmail("test1"), TagsTestData.Tags08_NewTagListName);
		String actualTagListName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertEquals(actualTagListName, TagsTestData.Tags08_NewTagListName, "User not able to enter the Tag Name");

		//Step 6  :"Click Cancel Button"
		//Expected:"The text field pop-up should close when user clicks the 'CANCEL' button."
		base.buttonClick(TagsObj.Btn_TagsListCancelButton("CANCEL"));
		Thread.sleep(3000);
		WebElement EntertheListName = driver.findElement(ViewProfileObj.Ele_ResetPassHeading("ENTER THE LIST NAME"));
		asrt.assertFalse(EntertheListName.isDisplayed(),"The text field pop-up should not close when user clicks the 'CANCEL' button");

	}

	// <summary>
	// Test Case Title :"To verify whether the tags are listed according to the selected tag list."
	// Automation ID   : Tags_24
	public void Tags_24_Tags() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj(); 

		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback and click on Tags module
		//Expected:Tags list should be visible to the user.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(TagsObj.Btn_Tags("collapse navbar-collapse", "tags_page"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("customtag-tab-btn active")),"User is not able to view the tag lists under tag module.");


		//Step 3 : Select any TagList
		//Expected : User should able to view the list of tags according the selected tag list.
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("col-12 col-lg-6 customtag-tab")),"User is not able to view the list of tags according the selected tag list");
	}

	// <summary>
	// Test Case Title :"To  verify what happens when user clicks the '+' icon near Tags."
	// Automation ID   : Tags_25
	public void Tags_25_Tags() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		ViewProfile_Obj ViewprofileObj = new ViewProfile_Obj();

		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback and click on Tags module
		//Expected:Tags list should be visible to the user.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(TagsObj.Btn_Tags("collapse navbar-collapse", "tags_page"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("customtag-tab-btn active")),"User is not able to view the tag lists under tag module.");

		//Step 3 : Click '+' icon near Tags
		//Expected : User should be able to view the Tags creating tab 
		base.buttonClick(LoginPageObj.Btn_SigninClick("showTagListModal();"));
		asrt.assertTrue(base.isExists(ViewprofileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User is not able to view the tag creating tab while clicking the + icon");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the 'x' icon in Snipback."
	// Automation ID   :Tags_30 
	// </summary>

	public void Tags_30_Tags() throws InterruptedException
	{
		Tags_Obj TagsObj = new Tags_Obj();
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		ViewProfile_Obj ViewprofileObj = new ViewProfile_Obj();

		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback and click on Tags module
		//Expected:Tags list should be visible to the user.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(TagsObj.Btn_Tags("collapse navbar-collapse", "tags_page"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("customtag-tab-btn active")),"User is not able to view the tag lists under tag module.");

		//Step 3 : Click '+' icon near Tags
		//Expected : User should be able to view the Tags creating tab 
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("showTagListModal();"));
		asrt.assertTrue(base.isExists(ViewprofileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User is not able to view the tag creating tab while clicking the + icon");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters a valid Custom Tag Name."
	// Automation ID   : Tags_26
	public void Tags_26_Tags() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();
		Registration_Obj registrationObj = new Registration_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Select any TagList"
		//Expected :"User should be able to Select any TagList"
		base.buttonClick(TagsObj.Ele_TagsName("7407"));
		asrt.assertTrue(base.isExists(registrationObj.Edt_SignUpPopupPassword("tagListName")), "User not able to select any TagList");

		//Step 5   :"Click '+' icon near Tags"
		//Expected :"User should be able to clickable '+' icon near Tags"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("btnAddTagList"));

		//Step 6   :"Enter the Custom Tag name"
		//Expected :"User should be able to enter the Custom Tag name"
		base.buttonClick(LoginPageObj.Edt_LoginEmail("customTagName"));
		base.setData(LoginPageObj.Edt_LoginEmail("customTagName"), TagsTestData.Tags30_TagName);

		//Step 7   :"Click 'x' Icon"
		//Expected :"User should be able to clickable 'x' Icon"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("cancelTagField"));


	}

	// <summary>
	// Test Case Title :"To verify what happens when user click the colour circle in Snipback."
	// Automation ID   :Tags_31 
	// </summary>

	public void Tags_31_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		ViewProfile_Obj ViewprofileObj = new ViewProfile_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();

		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback and click on Tags module
		//Expected:Tags list should be visible to the user.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(TagsObj.Btn_Tags("collapse navbar-collapse", "tags_page"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("customtag-tab-btn active")),"User is not able to view the tag lists under tag module.");

		//Step 3 : Click '+' icon near Tags
		//Expected : User should be able to view the Tags creating tab 
		base.buttonClick(LoginPageObj.Btn_SigninClick("showTagListModal();"));
		asrt.assertTrue(base.isExists(ViewprofileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User is not able to view the tag creating tab while clicking the + icon");

		//Step 4 : To verify what happens when user enters a valid Custom Tag Name and click on create button.
		//Expected : The user should be able to view the created Tag in the tag lists
		base.setData(LoginPageObj.Edt_LoginEmail("test1"),TagsTestData.TC26_Tags );
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("createNewTagList(2,0)"));
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the Pencil Icon. in Snipback."
	// Automation ID   : Tags_32
	public void Tags_32_Tags() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();
		Registration_Obj registrationObj = new Registration_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Select any TagList"
		//Expected :"User should be able to Select any TagList"
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		asrt.assertTrue(base.isExists(registrationObj.Edt_SignUpPopupPassword("tagListName")), "User not able to select any TagList");

		//Step 5   :"Click '+' icon near Tags"
		//Expected :"User should be able to clickable '+' icon near Tags"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("btnAddTagList"));

		//Step 6   :"Enter the Custom Tag name"
		//Expected :"User should be able to enter the Custom Tag name"
		base.buttonClick(LoginPageObj.Edt_LoginEmail("customTagName"));
		base.setData(LoginPageObj.Edt_LoginEmail("customTagName"), TagsTestData.Tags30_TagName);

		//Step 7   :"Click the colour circle"
		//Expected :"User should be able to clickable the colour circle"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("btnColorPicker"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("IroColorPicker")), "User not able to clickable the colour circle");

		//Step 8   :"Click the Save Changes button"
		//Expected :"User should be able to clickable Save Changes button"
		base.buttonClick(LoginPageObj.Btn_SingnIn("colorChangeCloseBtn"));

		//Step 9   :"Click the tick Icon"
		//Expected :"User should be able to clickable the tick Icon"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("btnAddTag"));

		//Step 10   :"Click the close Icon after successfully created the Tag"
		//Expected :"User should be able to clickable the close Icon after successfully created the Tag"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("modalMessageCloseBtnForTag"));
		Thread.sleep(700);

	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters a  invalid Custom Tag Name."
	// Automation ID   :Tags_27
	// </summary>

	public void Tags_27_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		ViewProfile_Obj ViewprofileObj = new ViewProfile_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj(); 
		Tags_TestData TagsTestData = new Tags_TestData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();

		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback and click on Tags module
		//Expected:Tags list should be visible to the user.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(TagsObj.Btn_Tags("collapse navbar-collapse", "tags_page"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("customtag-tab-btn active")),"User is not able to view the tag lists under tag module.");

		//Step 3 : Click '+' icon near Tags
		//Expected : User should be able to view the Tags creating tab 
		base.buttonClick(LoginPageObj.Btn_SigninClick("showTagListModal();"));
		asrt.assertTrue(base.isExists(ViewprofileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User is not able to view the tag creating tab while clicking the + icon");

		//Step 4 : To verify what happens when user enters an invalid Custom Tag Name and click on create button.
		//Expected : The user should be able to view an error message when the user enter an invalid tag name
		base.setData(LoginPageObj.Edt_LoginEmail("test1"),TagsTestData.TC27_Tags );
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("createNewTagList(2,0)"));
		//asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("The Tag List Name field cannot contain these special characters {}[]<>\\/().")),"User is not able to view the invalid error message while entering an invalid tag name while creating a tag");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters an existing Custom Tag name"
	// Automation ID   : Tags_28
	public void Tags_28_Tags() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Select any TagList"
		//Expected :"User should be able to Select any TagList"
		String TagName= base.GetText(TagsObj.Ele_UpdateName("flex-grow-1"));
		base.buttonClick(TagsObj.Ele_UpdateName("flex-grow-1"));

		//Step 5   :"Click the Pencil Icon near Tags"
		//Expected :"User should be able to clickable the Pencil Icon near Tags"
		Thread.sleep(500);
		base.excuteJsClick(TagsObj.Btn_TagEdit(TagName));

		//Step 6   :"Verify a popup text field will appear with its name in it"
		//Expected :"User should be able to view a popup text field will appear with its name in it"
		asrt.assertTrue(base.isExists(TagsObj.Ele_UpdateTag("modal-body")), "User not able to view a popup text field will appear with its name in it");

	}

	// <summary>
	// Test Case Title :"To verify what happens when clear the existing name from the text field and click tick Icon."
	// Automation ID   :Tags_33 
	// </summary>

	public void Tags_33_Tags() throws InterruptedException 
	{
		Login login = new Login(driver);
		ViewProfile_Obj ViewprofileObj = new ViewProfile_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj(); 
		Tags_TestData TagsTestData = new Tags_TestData();
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();

		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback and click on Tags module
		//Expected:Tags list should be visible to the user.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(TagsObj.Btn_Tags("collapse navbar-collapse", "tags_page"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("customtag-tab-btn active")),"User is not able to view the tag lists under tag module.");

		//Step 3 : Click '+' icon near Tags
		//Expected : User should be able to view the Tags creating tab 
		base.buttonClick(LoginPageObj.Btn_SigninClick("showTagListModal();"));
		asrt.assertTrue(base.isExists(ViewprofileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User is not able to view the tag creating tab while clicking the + icon");

		//Step 4 : Enter the Custom Tag name
		//Expected : The user should be able to view an error message when the user enter an existing tag name
		base.setData(LoginPageObj.Edt_LoginEmail("test1"),TagsTestData.TC26_Tags );
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("createNewTagList(2,0)"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Custom Tag List Name Already Exists.")),"User is not able to view the error message when entering an Existing tag name while creating a tag");
	}

	// <summary>
	// Test Case Title :"To verify whether there is an section as Tags in the Menu option."
	// Automation ID   :Tags_01
	// </summary>

	public void Tags_01_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view SnipBack page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"View Tags Button"
		//Expected :"User should be able to view the Tags menu in SnipBack"
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsButton("Tags")),"User not able to view the Tags menu in SnipBack" );
	}

	// <summary>
	// Test Case Title :"To verify what happens when user switches to Tags section."
	// Automation ID   :Tags_02
	// </summary>		

	public void Tags_02_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"View Tags Button"
		//Expected :"User should be able to view the Tags menu in SnipBack"
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsButton("Tags")),"User not able to view the Tags menu in SnipBack" );

		//Step 4   :"Switch from film to Tags Button and view Tag Lists"
		//Expected :"User should be able to navigate from film to Tags Button and view Tag Lists"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("TAG LISTS")),"User not able to view Tag Lists in Snipback" );
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal();")),"User not able to view + icon in Snipback" );
	}	
	// <summary>
	// Test Case Title :"To verify what happens when user left the List name field empty."
	// Automation ID   : Tags_29
	// </summary>
	public void Tags_29_Tags() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		ViewProfile_Obj ViewprofileObj = new ViewProfile_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj(); 

		//Step 1:Enter the URL
		//ExpectedLUser is able to view Snipback page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Login Snipback and click on Tags module
		//Expected:Tags list should be visible to the user.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		base.buttonClick(TagsObj.Btn_Tags("collapse navbar-collapse", "tags_page"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("customtag-tab-btn active")),"User is not able to view the tag lists under tag module.");

		//Step 3 : Click '+' icon near Tags
		//Expected : User should be able to view the Tags creating tab 
		base.buttonClick(LoginPageObj.Btn_SigninClick("showTagListModal();"));
		asrt.assertTrue(base.isExists(ViewprofileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User is not able to view the tag creating tab while clicking the + icon");

		//Step 4 : Left the tag name field name empty
		//Expected : The user should be able to view an error message when the user left the tag name field empty.
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("createNewTagList(2,0)"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("The Tag List Name field is required.")),"User is not able to view the invalid error message while lefting the tag name field empty");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the Duplicate Icon."
	// Automation ID   :Tags_09 
	// </summary>

	public void Tags_09_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4: Select any TagList and Click the Duplicate Icon
		//Expected : A popup text field will appear, prompting the user to enter a new TagList name.
		base.buttonClick(TagsObj.Btn_DuplicateTagLists(TagsTestData.Tags09_DuplicateTagListName));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"A popup text field will not appear, prompting the user to enter a new TagList name.");

	}

	// <summary>
	// Test Case Title :"To  verify what happens when user clicks the '+' icon near TagList."
	// Automation ID   :Tags_03
	// </summary>		

	public void Tags_03_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"View Tags Button"
		//Expected :"User should be able to view the Tags menu in SnipBack"
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsButton("Tags")),"User is not able to view the Tags menu in SnipBack" );

		//Step 4   :"Switch from film to Tags Button and view Tag Lists"
		//Expected :"User should be able to navigate from film to Tags Button and view Tag Lists"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("TAG LISTS")),"User is not able to view Tag Lists in Snipback" );
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal();")),"User is not able to view + icon in Snipback" );

		//Step 5   :"Click '+' icon near TagList"
		//Expected :"User should be able to click on the '+' icon near TagList"
		base.buttonClick(TagsObj.Btn_TagsListPlusButton("showTagListModal();"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User is not able to click '+' Button");
	}			

	// <summary>
	// Test Case Title :"To verify what happens when user enters a valid Taglist Name."
	// Automation ID   :Tags_04
	// </summary>		

	public void Tags_04_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj=new SearchGameTeamAndMembers_Obj();
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"View Tags Button"
		//Expected :"User should be able to view the Tags menu in SnipBack"
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsButton("Tags")),"User is not able to view the Tags menu in SnipBack" );

		//Step 4   :"Switch from film to Tags Button and view Tag Lists"
		//Expected :"User should be able to navigate from film to Tags Button and view Tag Lists"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("TAG LISTS")),"User is not able to view Tag Lists in Snipback" );
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal();")),"User is not able to view + icon in Snipback" );

		//Step 5   :"Click '+' icon near TagList"
		//Expected :"User should be able to click on the '+' icon near TagList"
		base.buttonClick(TagsObj.Btn_TagsListPlusButton("showTagListModal();"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("ENTER THE LIST NAME")),"User is not able to click '+' Button");

		//Step 6   :"Enter Tag Name"
		//Expected :"User should be able to Enter Tag Name"
		base.setData(LoginPageObj.Edt_LoginEmail("test1"), TagsTestData.Tags_04);
		String actualTagListName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		Thread.sleep(5000);
		asrt.assertEquals(actualTagListName, TagsTestData.Tags_04, "User not able to enter the Tag Name");

		//Step 7  :"Click Create Button"
		//Expected:"The user should be able to create a new TagList, and it should appear at the end of the list."
		//asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("tagliatCreate")),"User is not able to view the create button in SnipBack" );
		base.buttonClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		Thread.sleep(5000);
		//asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTeamAlert("Record Created Successfully ")),"The user is not able to create a new TagList");
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Record Created Successfully ")),"The user is not able to create a new TagList");
	}	

	// <summary>
	// Test Case Title :"To verify what happens when user enters a valid Duplicate Name"
	// Automation ID : Tags_10
	// </summary>

	public void Tags_10_Tags() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Tags_Obj TagsObj =new Tags_Obj ();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj=new SearchGameTeamAndMembers_Obj();


		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),
				"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		// Step 2 :"Switch to Tags from Film"
		// Expected:"User should be navigated to Tags Page"
		base.buttonClick(LoginPageObj.Btn_Login("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Ele_Tagframe("snipback_taglist_management")),
				"User not able to navigate Tags page in Snipback");
		Thread.sleep(2000);
		// Step 3 :"Select any TagList"
		// Expected:"User should Select any TagList"
		base.scrollToElement(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(TagsObj.Ele_TagsName("7407")),
				"User is not Select any TagList");


		// Step 4 :"Click the Duplicate Icon"
		// Expected:"TagList creation pop up should display"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("btnDupicate-7407"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("tagliatCreate")),
				"TagList creation pop up is not displayed");

		// Step 5 :"Enter the Valid Duplicate TagList's Name"
		// Expected:"User should able to enter a Valid Duplicate TagList's Name"
		String DuplicateTaglistname =Tags_TestData.Tags10_ValidDuplicateTaglistName +CreateRandom(2);
		base.setData(LoginPageObj.Edt_LoginEmail("test1"),DuplicateTaglistname);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertEquals(ActualName,DuplicateTaglistname,"User should not able to enter the duplicate taglist name");
		Thread.sleep(2000);

		// Step 6:"Click CREATE"
		// Expected:"User can able to create a duplicate tag with the given Test Data"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Record Created Successfully")),
				"User is not able to create a duplicate tag with the given Test Data");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters the same name for a duplicate tag, as its original name"
	// Automation ID : Tags_11
	// </summary>

	public void Tags_11_Tags() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Tags_Obj TagsObj =new Tags_Obj ();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj=new SearchGameTeamAndMembers_Obj();

		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),
				"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		// Step 2 :"Switch to Tags from Film"
		// Expected:"User should be navigated to Tags Page"
		base.buttonClick(LoginPageObj.Btn_Login("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Ele_Tagframe("snipback_taglist_management")),
				"User not able to navigate Tags page in Snipback");
		Thread.sleep(2000);
		// Step 3 :"Select any TagList"
		// Expected:"User should Select any TagList"
		base.scrollToElement(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(TagsObj.Ele_TagsName("7407")),
				"User is not Select any TagList");

		// Step 4 :"Click the Duplicate Icon"
		// Expected:"TagList creation pop up should display"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("btnDupicate-7407"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("tagliatCreate")),
				"TagList creation pop up is not displayed");

		// Step 5 :"Enter the Duplicate TagList's Name"
		// Expected:"User should able to enter a Valid Duplicate TagList's Name"

		base.setData(LoginPageObj.Edt_LoginEmail("test1"),Tags_TestData.Tags11_DuplicateTaglistName);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertEquals(ActualName,Tags_TestData.Tags11_DuplicateTaglistName,"User should not able to enter the duplicate taglist name");
		Thread.sleep(2000);

		// Step 6 :"Click CREATE"
		// Expected:"User will receives alert message as "Custom Tag List Name Already Exists."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));

	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters a invalid TagList Name"
	// Automation ID : Tags_12
	// </summary>

	public void Tags_12_Tags() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Tags_Obj TagsObj =new Tags_Obj ();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();			
		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),
				"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		// Step 2 :"Switch to Tags from Film"
		// Expected:"User should be navigated to Tags Page"
		base.buttonClick(LoginPageObj.Btn_Login("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Ele_Tagframe("snipback_taglist_management")),
				"User not able to navigate Tags page in Snipback");
		Thread.sleep(2000);

		// Step 3 :"Select any TagList"
		// Expected:"User should Select any TagList"
		base.scrollToElement(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(TagsObj.Ele_TagsName("7407")),
				"User is not Select any TagList");

		// Step 4 :"Click the Duplicate Icon"
		// Expected:"TagList creation pop up should display"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("btnDupicate-7407"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("tagliatCreate")),
				"TagList creation pop up is not displayed");

		// Step 5 :"Enter the Duplicate TagList's Name"
		// Expected:"User should able to enter a Valid Duplicate TagList's Name"

		base.setData(LoginPageObj.Edt_LoginEmail("test1"),Tags_TestData.Tags12_DuplicateTaglistName);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertEquals(ActualName,Tags_TestData.Tags12_DuplicateTaglistName,"User should not able to enter the duplicate taglist name");

		// Step 6 :"Click CREATE"
		// Expected:"User will recieves alert message as "Please enter the valid name, the invalid characters are &/\#,+()$~%.^':*?<>{}"."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		Thread.sleep(1000);	
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTeamAlert("The Tag List Name field cannot contain these special characters {}[]<>\\/().")),
				"User is not recieves alert message as Please enter the valid name, the invalid characters are &/\\#,+()$~%.^':*?<>{}\".");


	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks CANCEL instead of CREATE in duplicate TagName popup."
	// Automation ID : Tags_13
	// </summary>

	public void Tags_13_Tags() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Tags_Obj TagsObj =new Tags_Obj ();

		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),
				"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		// Step 2 :"Switch to Tags from Film"
		// Expected:"User should be navigated to Tags Page"
		base.buttonClick(LoginPageObj.Btn_Login("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Ele_Tagframe("snipback_taglist_management")),
				"User not able to navigate Tags page in Snipback");
		Thread.sleep(2000);

		// Step 3 :"Select any TagList"
		// Expected:"User should Select any TagList"
		Thread.sleep(2000);
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(TagsObj.Ele_TagsName("7407")),
				"User is not Select any TagList");
		// Step 4 :"Click the Duplicate Icon"
		// Expected:"TagList creation pop up should display"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("btnDupicate-7407"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("tagliatCreate")),
				"TagList creation pop up is not displayed");

		// Step 5 :"Enter the Duplicate TagList's Name"
		// Expected:"User should able to enter a Valid Duplicate TagList's Name"

		base.setData(LoginPageObj.Edt_LoginEmail("test1"),Tags_TestData.Tags10_ValidDuplicateTaglistName);
		String ActualName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertEquals(ActualName,Tags_TestData.Tags10_ValidDuplicateTaglistName,"User should not able to enter the duplicate taglist name");
		Thread.sleep(1000);	

		// Step 6 :"Click CANCEL"
		// Expected:"The text field pop-up should close when user clicks the 'CANCEL' button."
		base.excuteJsClick(TagsObj.Btn_Cancel("addTaglist", "CANCEL"));
		Thread.sleep(1000);	
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		boolean isInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(
				TagsObj.Btn_Cancel("addTaglist", "CANCEL") ));
		asrt.assertTrue(isInvisible, "The dialog box with the 'Cancel' button did not disappear as expected.");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user left the Duplicate List name field empty."
	// Automation ID : Tags_14
	// </summary>

	public void Tags_14_Tags() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Tags_Obj TagsObj =new Tags_Obj ();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();			


		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),
				"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		// Step 2 :"Switch to Tags from Film"
		// Expected:"User should be navigated to Tags Page"
		base.buttonClick(LoginPageObj.Btn_Login("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Ele_Tagframe("snipback_taglist_management")),
				"User not able to navigate Tags page in Snipback");
		Thread.sleep(2000);

		// Step 3 :"Select any TagList"
		// Expected:"User should Select any TagList"
		base.scrollToElement(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(TagsObj.Ele_TagsName("7407")),
				"User is not Select any TagList");

		// Step 4 :"Click the Duplicate Icon"
		// Expected:"TagList creation pop up should display"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("btnDupicate-7407"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("tagliatCreate")),
				"TagList creation pop up is not displayed");

		// Step 5 :"Click CREATE"
		// Expected:"User will recieves alert message as "Please enter the valid name, the invalid characters are &/\#,+()$~%.^':*?<>{}"."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		Thread.sleep(1000);	
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTeamAlert("The Tag List Name field is required.")),
				"The user is nor receive alert popup as The Tag List Name field is required.");	

	}	

	// <summary>
	// Test Case Title :"To verify what happens what happens when clear the existing name from the text field and click UPDATE."
	// Automation ID : Tags_16
	// </summary>

	public void Tags_16_Tags() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Tags_Obj TagsObj =new Tags_Obj ();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj=new SearchGameTeamAndMembers_Obj();

		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		Thread.sleep(2000);
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),
				"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		// Step 2 :"Switch to Tags from Film"
		// Expected:"User should be navigated to Tags Page"
		base.buttonClick(LoginPageObj.Btn_Login("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Ele_Tagframe("snipback_taglist_management")),
				"User not able to navigate Tags page in Snipback");
		Thread.sleep(2000);

		// Step 3 :"Select any TagList"
		// Expected:"User should Select any TagList"
		base.scrollToElement(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(TagsObj.Ele_TagsName("7407")),
				"User is not Select any TagList");


		String ActualName=base.GetText(TagsObj.Ele_TagsName("7407"));


		// Step 4 :"Click the Pencil Icon"
		// Expected:"A popup text field will appear with its name in it, prompting the user to enter a new TagList name."
		base.excuteJsClick(TagsObj.Btn_Edit(ActualName, 3));
		Thread.sleep(20000);	
		asrt.assertTrue(base.isExists(TagsObj.Btn_Edit(ActualName, 3)),
				"A popup text field will not appear with its name in it, prompting the user to enter a new TagList name.");


		// Step 5 :"Clear the data"
		// Expected:"User should clear the data from the tag list edit pop up"
		base.clearData(LoginPageObj.Edt_LoginEmail("test1"));

		// Step 6 :"Click UPDATE"
		// Expected:"The user will receive alert popup as "The Tag List Name field is required."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("The Tag List Name field is required.")),
				"The user is not receive alert popup as The Tag List Name field is required.");	
	}
	// <summary>
	// Test Case Title :"To verify what happens when clear the existing name from the text field and enters a valid Custom Tag Name."
	// Automation ID   :Tags_34 
	// </summary>

	public void Tags_34_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Select any TagList"
		//Expected :"User should be able to Select any TagList"
		String TagName= base.GetText(TagsObj.Ele_UpdateName("flex-grow-1"));
		base.buttonClick(TagsObj.Ele_UpdateName("flex-grow-1"));

		//Step 5   :"Click the Pencil Icon near Tags"
		//Expected :"User should be able to clickable the Pencil Icon near Tags"
		Thread.sleep(500);
		base.excuteJsClick(TagsObj.Btn_TagEdit(TagName));

		//Step 6   :"Verify a popup text field will appear with its name in it"
		//Expected :"User should be able to view a popup text field will appear with its name in it"
		asrt.assertTrue(base.isExists(TagsObj.Ele_UpdateTag("modal-body")), "User not able to view a popup text field will appear with its name in it");

		//Step 7   :"Clear the data from Name Input field"
		//Expected :"User should be able to Clear the data from Name Input field"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("test1"));
		base.clearData(LoginPageObj.Edt_LoginEmail("test1"));

		//Step 8   :"Enter the Custom Tag Name in popup"
		//Expected :"User should be able to enter the Custom Tag Name in popup"
		base.setData(LoginPageObj.Edt_LoginEmail("test1"), TagsTestData.Tags34_TagName);

		//Step 9   :"Click Update button in popup"
		//Expected :"User should be able to Clickable Update button in popup"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		base.excuteJsClick(TagsObj.Btn_close("modalMessageCloseBtn"));

	}
	// <summary>
	// Test Case Title :"To verify what happens when clear the existing name from the text field and enters a invalid  Custom Tag Name."
	// Automation ID   :Tags_35 
	// </summary>

	public void Tags_35_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();
		Registration_Obj registrationObj = new Registration_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj addUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Select any TagList"
		//Expected :"User should be able to Select any TagList"
		String TagName= base.GetText(TagsObj.Ele_UpdateName("flex-grow-1"));
		base.buttonClick(TagsObj.Ele_UpdateName("flex-grow-1"));

		//Step 5   :"Click the Pencil Icon near Tags"
		//Expected :"User should be able to clickable the Pencil Icon near Tags"
		Thread.sleep(500);
		base.excuteJsClick(TagsObj.Btn_TagEdit(TagName));

		//Step 6   :"Verify a popup text field will appear with its name in it"
		//Expected :"User should be able to view a popup text field will appear with its name in it"
		asrt.assertTrue(base.isExists(TagsObj.Ele_UpdateTag("modal-body")), "User not able to view a popup text field will appear with its name in it");

		//Step 7   :"Clear the data from Name Input field"
		//Expected :"User should be able to Clear the data from Name Input field"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("test1"));
		base.clearData(LoginPageObj.Edt_LoginEmail("test1"));

		//Step 8   :"Enter the Custom Tag Name in popup"
		//Expected :"User should be able to enter the Custom Tag Name in popup"
		base.setData(LoginPageObj.Edt_LoginEmail("test1"), TagsTestData.Tags35_TagName);

		//Step 9   :"Click UPDATE button in popup"
		//Expected :"User should be able to Clickable UPDATE button in popup"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));

		//Step 10   :"Verify User will recieves alert message as "Please enter the valid name, the invalid characters are &/\#,+()$~%.^':*?<>{}".""
		//Expected :"User should be able to view User will recieves alert message as "Please enter the valid name, the invalid characters are &/\#,+()$~%.^':*?<>{}".""
		asrt.assertTrue(base.isExists(addUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTeamAlert("The Tag List Name field cannot contain these special characters ")), "User should be able to view User will recieves alert message as ,'Please enter the valid name, the invalid characters are &/\\#,+()$~%.^':*?<>{}'.'");

	}

	// <summary>
	// Test Case Title :"To verify what happens when clear the existing name from the text field and click CANCEL."
	// Automation ID   :Tags_36 
	// </summary>

	public void Tags_36_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		Tags_TestData TagsTestData = new Tags_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Select any TagList"
		//Expected :"User should be able to Select any TagList"
		String TagName= base.GetText(TagsObj.Ele_UpdateName("flex-grow-1"));
		base.buttonClick(TagsObj.Ele_UpdateName("flex-grow-1"));

		//Step 5   :"Click the Pencil Icon near Tags"
		//Expected :"User should be able to clickable the Pencil Icon near Tags"
		Thread.sleep(500);
		base.excuteJsClick(TagsObj.Btn_TagEdit(TagName));

		//Step 6   :"Verify a popup text field will appear with its name in it"
		//Expected :"User should be able to view a popup text field will appear with its name in it"
		asrt.assertTrue(base.isExists(TagsObj.Ele_UpdateTag("modal-body")), "User not able to view a popup text field will appear with its name in it");

		//Step 7   :"Clear the data from Name Input field"
		//Expected :"User should be able to Clear the data from Name Input field"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("test1"));
		base.clearData(LoginPageObj.Edt_LoginEmail("test1"));

		//Step 8   :"Enter the Custom Tag Name in popup"
		//Expected :"User should be able to enter the Custom Tag Name in popup"
		base.setData(LoginPageObj.Edt_LoginEmail("test1"), TagsTestData.Tags35_TagName);

		//Step 9   :"Click Cancel button in popup"
		//Expected :"User should be able to Clickable Cancel button in popup"
		base.excuteJsClick(TagsObj.Btn_TagsListCancelButton("CANCEL"));

	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks UPDATE without making any changes in the existing name."
	// Automation ID   :Tags_37 
	// </summary>

	public void Tags_37_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj addUpdateDeleteDuplicateTeamGameDefaultsObj = new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Select any TagList"
		//Expected :"User should be able to Select any TagList"
		String TagName= base.GetText(TagsObj.Ele_UpdateName("flex-grow-1"));
		base.buttonClick(TagsObj.Ele_UpdateName("flex-grow-1"));

		//Step 5   :"Click the Pencil Icon near Tags"
		//Expected :"User should be able to clickable the Pencil Icon near Tags"
		Thread.sleep(500);
		base.excuteJsClick(TagsObj.Btn_TagEdit(TagName));

		//Step 6   :"Verify a popup text field will appear with its name in it"
		//Expected :"User should be able to view a popup text field will appear with its name in it"
		asrt.assertTrue(base.isExists(TagsObj.Ele_UpdateTag("modal-body")), "User not able to view a popup text field will appear with its name in it");

		//Step 7   :"Click UPDATE button in popup"
		//Expected :"User should be able to Clickable UPDATE button in popup"
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));

		//Step 8   :"Verify User will recieves alert message as "No changes found""
		//Expected :"User should be able to view User will recieves alert message as "No changes found." "
		asrt.assertTrue(base.isExists(addUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTeamAlert("No changes found")), "User should not be able to view User will recieves alert message as \"No changes found.");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the Delete Icon near Tags"
	// Automation ID   :Tags_38 
	// </summary>

	public void Tags_38_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//Step 4   :"Select any TagList"
		//Expected :"User should be able to Select any TagList"
		String TagName= base.GetText(TagsObj.Ele_UpdateName("flex-grow-1"));
		base.buttonClick(TagsObj.Ele_UpdateName("flex-grow-1"));

		//Step 5   :"Click the Delete Icon near Tags"
		//Expected :"User should be able to clickable the Delete Icon near Tags"
		Thread.sleep(500);
		base.excuteJsClick(TagsObj.Btn_Tagdelete(TagName));

	}
	// <summary>
	// Test Case Title :"To verify Custom Tag should be removed from the list once user clicks Yes."
	// Automation ID   :Tags_39 
	// </summary>

	public void Tags_39_Tags() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Tags_Obj TagsObj = new Tags_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj=new SnipCreationWithAndWithoutTag_Obj();
		Tags_TestData TagsTestData=new Tags_TestData();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();


		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Navigate to Tags Button"
		//Expected :"User should be able to navigate to Tags Button"
		base.buttonClick(TagsObj.Btn_TagsButton("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Btn_TagsListPlusButton("showTagListModal")),"User not able to navigate to Tags page in Snipback" );

		//		//Step 4   :"Select any TagList"
		//		//Expected :"User should be able to Select any TagList"
		//		String TagName= base.GetText(TagsObj.Ele_UpdateName("flex-grow-1"));
		//		base.buttonClick(TagsObj.Ele_UpdateName("flex-grow-1"));

		// Step 3 :"Create A Tag in Tag List"  
		//Expected : Enter the list name popup is shown
		asrt.assertTrue(base.isEnabledBy(AddFollowerObj.Btn_MailTick("d-flex mb-3 ps-2", "bi bi-plus")), "+ icon is not displayed above the TAG LISTS");
		base.buttonClick(AddFollowerObj.Btn_MailTick("d-flex mb-3 ps-2", "bi bi-plus"));
		base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TagBox("addTaglist", "modal-body"));		

		//Step 4: Verify if text box is displayed in popup to enter the tagname
		//Expected : Create button is shown
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("test1")));
		base.setData(LoginPageObj.Edt_LoginEmail("test1"),TagsTestData.TagName_40);
		Thread.sleep(3000);
		String tagName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("tagliatCreate")), "Create button is not displayed in Enter the list name popup box");

		//Step 5: Click on Create button to create a tag
		//Expected : scrolling to the created tagname in taglist left side and click on that tagname
		base.buttonClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		Thread.sleep(5000);
		//clicking close button popup again
		driver.findElement(By.xpath("//div[@class='modal-footer']/button[@id='modalMessageCloseBtn']")).click();
		base.scrollToElementtoCenter(TagsObj.Ele_TagName(tagName));
		base.buttonClick(TagsObj.Ele_TagName(tagName));

		//loading is slow
		Thread.sleep(30000);
		//Step 6: Add icon in tags in right side
		//Expected:Enter Custom Tag text box is shown
		driver.findElement(TagsObj.Ele_AddIconInTags("btnAddTagList","i")).click();
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("customTagName")));

		//Step 7: Enter the tag name to create in tags
		base.setData(LoginPageObj.Edt_LoginEmail("customTagName"), TagsTestData.CustomTagName_40);
		Thread.sleep(3000);
		String customTagName = base.GetValue(LoginPageObj.Edt_LoginEmail("customTagName"));

		//Verify tick mark is existing click on that tickmark
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bi bi-check2")));
		Thread.sleep(1000);
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bi bi-check2"));
		Thread.sleep(1000);
		base.buttonClick(LoginPageObj.Btn_SingnIn("modalMessageCloseBtnForTag"));


		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(TagsObj.Btn_DeleteIconInTags("listCustomTags",customTagName,"btn tag_delete")),"Delete image is not displayed acroll the tagname");

		//Step 6: Click on delete icon across the customTagName
		//Expected: "Are you sure want to Delete" popup is displayed
		base.buttonClick(TagsObj.Btn_DeleteIconInTags("listCustomTags",customTagName,"btn tag_delete"));
		base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TagBox("deleteAlertmsg", "f-modal-alert"));	

		//Step 7: Click on close button in "Are you sure want to Delete" popup
		//Expected: Verify popup is closed successfully
		//		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("deleteMsgClose")), "Close button is not displayed in delete popup");
		//		base.buttonClick(LoginPageObj.Btn_SingnIn("deleteMsgClose"));

		Thread.sleep(5000);

		//Step 6   :"Click the Yes button near Tags"
		//Expected :"User should be able to clickable the Yes button near Tags"
		base.buttonClick(LoginPageObj.Btn_SingnIn("deleteMsgsave"));

	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks Close in the confirmation popup."
	// Automation ID : Tags_40
	// </summary>

	public void Tags_40_Tags() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Tags_Obj TagsObj =new Tags_Obj ();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj=new SnipCreationWithAndWithoutTag_Obj();
		Tags_TestData TagsTestData=new Tags_TestData();

		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),
				"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		// Step 2 :"Switch to Tags from Film"
		// Expected:"User should be navigated to Tags Page"
		base.buttonClick(LoginPageObj.Btn_Login("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Ele_Tagframe("snipback_taglist_management")),
				"User not able to navigate Tags page in Snipback");
		Thread.sleep(2000);

		// Step 3 :"Create A Tag in Tag List"  
		//Expected : Enter the list name popup is shown
		asrt.assertTrue(base.isEnabledBy(AddFollowerObj.Btn_MailTick("d-flex mb-3 ps-2", "bi bi-plus")), "+ icon is not displayed above the TAG LISTS");
		base.buttonClick(AddFollowerObj.Btn_MailTick("d-flex mb-3 ps-2", "bi bi-plus"));
		base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TagBox("addTaglist", "modal-body"));		

		//Step 4: Verify if text box is displayed in popup to enter the tagname
		//Expected : Create button is shown
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("test1")));
		base.setData(LoginPageObj.Edt_LoginEmail("test1"),TagsTestData.TagName_40);
		Thread.sleep(3000);
		String tagName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("tagliatCreate")), "Create button is not displayed in Enter the list name popup box");

		//Step 5: Click on Create button to create a tag
		//Expected : scrolling to the created tagname in taglist left side and click on that tagname
		base.buttonClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		Thread.sleep(5000);
		//clicking close button popup again
		driver.findElement(By.xpath("//div[@class='modal-footer']/button[@id='modalMessageCloseBtn']")).click();
		base.scrollToElementtoCenter(TagsObj.Ele_TagName(tagName));
		base.buttonClick(TagsObj.Ele_TagName(tagName));

		//loading is slow
		Thread.sleep(30000);
		//Step 6: Add icon in tags in right side
		//Expected:Enter Custom Tag text box is shown
		driver.findElement(TagsObj.Ele_AddIconInTags("btnAddTagList","i")).click();
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("customTagName")));

		//Step 7: Enter the tag name to create in tags
		base.setData(LoginPageObj.Edt_LoginEmail("customTagName"), TagsTestData.CustomTagName_40);
		Thread.sleep(3000);
		String customTagName = base.GetValue(LoginPageObj.Edt_LoginEmail("customTagName"));

		//Verify tick mark is existing click on that tickmark
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bi bi-check2")));
		Thread.sleep(1000);
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bi bi-check2"));
		Thread.sleep(1000);
		base.buttonClick(LoginPageObj.Btn_SingnIn("modalMessageCloseBtnForTag"));


		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(TagsObj.Btn_DeleteIconInTags("listCustomTags",customTagName,"btn tag_delete")),"Delete image is not displayed acroll the tagname");

		//Step 6: Click on delete icon across the customTagName
		//Expected: "Are you sure want to Delete" popup is displayed
		base.buttonClick(TagsObj.Btn_DeleteIconInTags("listCustomTags",customTagName,"btn tag_delete"));
		base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TagBox("deleteAlertmsg", "f-modal-alert"));	

		//Step 7: Click on close button in "Are you sure want to Delete" popup
		//Expected: Verify popup is closed successfully
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("deleteMsgClose")), "Close button is not displayed in delete popup");
		base.buttonClick(LoginPageObj.Btn_SingnIn("deleteMsgClose"));

		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust timeout as needed
		boolean isPopupGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(SnipCreationWithAndWithoutTagObj.Btn_TagBox("deleteAlertmsg", "f-modal-alert")));
		if (isPopupGone) {
			System.out.println("Popup disappeared successfully.");
		} else {
			System.out.println("Popup \"Are you sure want to Delete\" is  still visible even after clicking on close button");
			asrt.fail("popup is still existing and cancel button is not working");
		}


	}

	// <summary>
	// Test Case Title :"To verify that when a user deletes a Tag List, all the Tags within it are also deleted."
	// Automation ID : Tags_41
	// </summary>

	public void Tags_41_Tags() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Tags_Obj TagsObj =new Tags_Obj ();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj=new SnipCreationWithAndWithoutTag_Obj();
		Tags_TestData TagsTestData=new Tags_TestData();

		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),
				"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		// Step 2 :"Switch to Tags from Film"
		// Expected:"User should be navigated to Tags Page"
		base.buttonClick(LoginPageObj.Btn_Login("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Ele_Tagframe("snipback_taglist_management")),
				"User not able to navigate Tags page in Snipback");
		Thread.sleep(2000);

		// Step 3 :"Create A Tag in Tag List"  
		//Expected : Enter the list name popup is shown
		asrt.assertTrue(base.isEnabledBy(AddFollowerObj.Btn_MailTick("d-flex mb-3 ps-2", "bi bi-plus")), "+ icon is not displayed above the TAG LISTS");
		base.buttonClick(AddFollowerObj.Btn_MailTick("d-flex mb-3 ps-2", "bi bi-plus"));
		base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TagBox("addTaglist", "modal-body"));		

		//Step 4: Verify if text box is displayed in popup to enter the tagname
		//Expected : Create button is shown
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("test1")));
		base.setData(LoginPageObj.Edt_LoginEmail("test1"),TagsTestData.TagName_41);
		Thread.sleep(3000);
		String tagName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("tagliatCreate")), "Create button is not displayed in Enter the list name popup box");

		//Step 5: Click on Create button to create a tag
		base.buttonClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-footer']/button[@id='modalMessageCloseBtn']")).click();
		base.scrollToElementtoCenter(TagsObj.Ele_TagName(tagName));
		Thread.sleep(3000);

		base.buttonClick(TagsObj.Ele_TagName(tagName));

		//loading is slow
		Thread.sleep(30000);
		//Step 6: Add icon in tags in right side
		//Expected:Enter Custom Tag text box is shown
		driver.findElement(TagsObj.Ele_AddIconInTags("btnAddTagList","i")).click();
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("customTagName")));

		//Step 7: Enter the tag name to create in tags
		base.setData(LoginPageObj.Edt_LoginEmail("customTagName"), TagsTestData.CustomTagName_41);
		Thread.sleep(3000);
		String customTagName = base.GetValue(LoginPageObj.Edt_LoginEmail("customTagName"));

		//Verify tick mark is existing click on that tickmark
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bi bi-check2")));
		Thread.sleep(1000);
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bi bi-check2"));
		Thread.sleep(1000);
		base.buttonClick(LoginPageObj.Btn_SingnIn("modalMessageCloseBtnForTag"));


		//Step 6: Click on delete icon across the tagname
		//Expected: "Are you sure want to Delete" popup is displayed
		base.buttonClick(TagsObj.Btn_DeleteIcon(tagName,"btn tag_delete"));
		base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TagBox("deleteAlertmsg", "f-modal-alert"));	

		//Step 7:Click on yes button in "Are you sure want to Delete" popup
		//Expected:Verify tag is deleted from tag list 
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("deleteMsgClose")), "Close button is not displayed in delete popup");
		base.buttonClick(LoginPageObj.Btn_SingnIn("deleteMsgsave"));
		Thread.sleep(2000);

		//clicking close button in Record Deleted Successfully popup
		base.buttonClick(TagsObj.Btn_ConfirmationMessageCloseButton("modal-footer","modalMessageCloseBtn"));
		String text =base.GetText(TagsObj.Ele_TagListName("d-flex mx-3 pb-3 align-items-center","tagListName"));
		Thread.sleep(2000);

		//Verifying if the tag is deleted in right side
		asrt.assertNotEquals(tagName, text,"both equal");
		List<WebElement> listOfTagNamesInTagList =driver.findElements(TagsObj.Ele_ListOfTagNames("snipback_taglists_tab"));
		for(WebElement eachTagName:listOfTagNamesInTagList) {
			if(eachTagName.getText().equals(tagName)) {

				asrt.fail("tagname is not deleted from TAGLISTS and tags are existing");
			}

		} 
	}
	// <summary>
	// Test Case Title :" To verify what happens what happens when clear the existing name from the text field and enters a valid TagList Name.."
	// Automation ID : Tags_17
	// </summary>

	public void Tags_17_Tags() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Tags_Obj TagsObj =new Tags_Obj ();
		Registration_Obj RegistrationObj=new Registration_Obj();


		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),
				"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		// Step 2 :"Switch to Tags from Film"
		// Expected:"User should be navigated to Tags Page"
		base.buttonClick(LoginPageObj.Btn_Login("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Ele_Tagframe("snipback_taglist_management")),
				"User not able to navigate Tags page in Snipback");
		Thread.sleep(2000);

		// Step 3 :"Select any TagList"
		// Expected:"User should Select any TagList"
		base.scrollToElement(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(TagsObj.Ele_TagsName("7407")),
				"User is not Select any TagList");

		// Step 4 :"Click the Pencil Icon"
		// Expected:"A popup text field will appear with its name in it, prompting the user to enter a new TagList name."
		String ActualName=base.GetText(TagsObj.Ele_TagsName("7407"));
		base.excuteJsClick(TagsObj.Btn_Edit(ActualName, 3));
		Thread.sleep(20000);	
		asrt.assertTrue(base.isExists(TagsObj.Btn_Edit(ActualName, 3)),
				"A popup text field will not appear with its name in it, prompting the user to enter a new TagList name.");

		// Step 5 :"Clear the data"
		// Expected:"User should clear the data from the tag list edit pop up"
		base.clearData(LoginPageObj.Edt_LoginEmail("test1"));

		// Step 6:"Enter the TagList's Name"
		// Expected:"User should able to enter a TagList's Name"

		String DuplicateTaglistname =Tags_TestData.Tags17_ValidDuplicateTaglistName +CreateRandom(2);
		base.setData(LoginPageObj.Edt_LoginEmail("test1"),DuplicateTaglistname);
		String ActualNam = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertEquals(ActualNam,DuplicateTaglistname,"User should not able to enter the duplicate taglist name");
		Thread.sleep(2000);
		// Step 7 :"Click UPDATE"
		// Expected:"User can able to update the TagList name with a new one.."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("success")),
				"The user is not able to update the TagList name with a new one");	
	}

	// <summary>
	// Test Case Title :" To verify what happens what happens when clear the existing name from the text field and enters a invalid  TagList Name."
	// Automation ID : Tags_18
	// </summary>

	public void Tags_18_Tags() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Tags_Obj TagsObj =new Tags_Obj ();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj AddUpdateDeleteDuplicateTeamGameDefaultsObj=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();				

		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),
				"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		// Step 2 :"Switch to Tags from Film"
		// Expected:"User should be navigated to Tags Page"
		base.buttonClick(LoginPageObj.Btn_Login("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Ele_Tagframe("snipback_taglist_management")),
				"User not able to navigate Tags page in Snipback");
		Thread.sleep(2000);

		// Step 3 :"Select any TagList"
		// Expected:"User should Select any TagList"
		base.scrollToElement(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(TagsObj.Ele_TagsName("7407")),
				"User is not Select any TagList");

		// Step 4 :"Click the Pencil Icon"
		// Expected:"A popup text field will appear with its name in it, prompting the user to enter a new TagList name."
		String ActualName=base.GetText(TagsObj.Ele_TagsName("7407"));
		base.excuteJsClick(TagsObj.Btn_Edit(ActualName, 3));
		Thread.sleep(20000);	
		asrt.assertTrue(base.isExists(TagsObj.Btn_Edit(ActualName, 3)),
				"A popup text field will not appear with its name in it, prompting the user to enter a new TagList name.");

		// Step 5 :"Clear the data"
		// Expected:"User should clear the data from the tag list edit pop up"
		base.clearData(LoginPageObj.Edt_LoginEmail("test1"));

		// Step 6:"Enter the TagList's Name"
		// Expected:"User should able to enter a Valid Duplicate TagList's Name"

		base.setData(LoginPageObj.Edt_LoginEmail("test1"),Tags_TestData.Tags12_DuplicateTaglistName);
		String ActualNam = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertEquals(ActualNam,Tags_TestData.Tags12_DuplicateTaglistName,"User should not able to enter the duplicate taglist name");

		// Step 6 :"Click UPDATE"
		// Expected:"User will recieves alert message as "Please enter the valid name, the invalid characters are &/\#,+()$~%.^':*?<>{}"."
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("tagliatCreate"));
		Thread.sleep(1000);	
		asrt.assertTrue(base.isExists(AddUpdateDeleteDuplicateTeamGameDefaultsObj.Ele_DuplicateTeamAlert("The Tag List Name field cannot contain these special characters {}[]<>\\/().")),
				"User is not recieves alert message as Please enter the valid name, the invalid characters are &/\\#,+()$~%.^':*?<>{}\".");
	}

	// <summary>
	// Test Case Title :" To verify what happens what happens when clear the existing name from the text field and click CANCEL"
	// Automation ID : Tags_19
	// </summary>

	public void Tags_19_Tags() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Tags_Obj TagsObj =new Tags_Obj ();

		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),
				"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		// Step 2 :"Switch to Tags from Film"
		// Expected:"User should be navigated to Tags Page"
		base.buttonClick(LoginPageObj.Btn_Login("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Ele_Tagframe("snipback_taglist_management")),
				"User not able to navigate Tags page in Snipback");
		Thread.sleep(2000);

		// Step 3 :"Select any TagList"
		// Expected:"User should Select any TagList"
		base.scrollToElement(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(TagsObj.Ele_TagsName("7407")),
				"User is not Select any TagList");

		// Step 4 :"Click the Pencil Icon"
		// Expected:"A popup text field will appear with its name in it, prompting the user to enter a new TagList name."
		String ActualName=base.GetText(TagsObj.Ele_TagsName("7407"));
		base.excuteJsClick(TagsObj.Btn_Edit(ActualName, 3));
		Thread.sleep(20000);	
		asrt.assertTrue(base.isExists(TagsObj.Btn_Edit(ActualName, 3)),
				"A popup text field will not appear with its name in it, prompting the user to enter a new TagList name.");

		// Step 5 :"Clear the data"
		// Expected:"User should clear the data from the tag list edit pop up"
		base.clearData(LoginPageObj.Edt_LoginEmail("test1"));

		// Step 6 :"Enter the TagList's Name"
		// Expected:"User should able to enter a TagList's Name"

		base.setData(LoginPageObj.Edt_LoginEmail("test1"),Tags_TestData.Tags12_DuplicateTaglistName);
		String ActualNam = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));
		asrt.assertEquals(ActualNam,Tags_TestData.Tags12_DuplicateTaglistName,"User should not able to enter the duplicate taglist name");

		// Step 6 :"Click CANCEL"
		// Expected:"The text field pop-up should close when user clicks the 'CANCEL' button."
		base.excuteJsClick(TagsObj.Btn_Cancel("addTaglist", "CANCEL"));
		Thread.sleep(1000);	
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		boolean isInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(
				TagsObj.Btn_Cancel("addTaglist", "CANCEL") ));
		asrt.assertTrue(isInvisible, "The dialog box with the 'Cancel' button did not disappear as expected.");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the Pencil Icon."
	// Automation ID : Tags_15
	// </summary>

	public void Tags_15_Tags() throws InterruptedException {
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Tags_Obj TagsObj =new Tags_Obj ();

		//Step 1  :"Login to snipback with valid credentials"
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),
				"User not able to navigate Film page in Snipback");
		Thread.sleep(2000);

		// Step 2 :"Switch to Tags from Film"
		// Expected:"User should be navigated to Tags Page"
		base.buttonClick(LoginPageObj.Btn_Login("Tags"));
		asrt.assertTrue(base.isExists(TagsObj.Ele_Tagframe("snipback_taglist_management")),
				"User not able to navigate Tags page in Snipback");
		Thread.sleep(2000);

		// Step 3 :"Select any TagList"
		// Expected:"User should Select any TagList"
		Thread.sleep(2000);
		base.excuteJsClick(TagsObj.Ele_TagsName("7407"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(TagsObj.Ele_TagsName("7407")),
				"User is not Select any TagList");

		// Step 4 :"Click the Pencil Icon"
		// Expected:"A popup text field will appear with its name in it, prompting the user to enter a new TagList name."
		String ActualName=base.GetText(TagsObj.Ele_TagsName("7407"));
		base.excuteJsClick(TagsObj.Btn_Edit(ActualName, 3));
		Thread.sleep(10000);	
		String ExpectedName = base.GetValue(LoginPageObj.Edt_LoginEmail("test1"));		
		asrt.assertEquals(ActualName, ExpectedName, "A popup text field will not appear with its name in it, prompting the user to enter a new TagList name.");


	}

}





