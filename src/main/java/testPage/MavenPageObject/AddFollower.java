package testPage.MavenPageObject;
import TestData.ForgotPassword_TestData;
import TestData.Registration_TestData;
import TestData.ViewProfile_TestData;

import java.util.Arrays;
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
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.ViewProfile_Obj;
import objectRepository.AddFollower_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.DuplicateSnip_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;
public class AddFollower extends BasePge{

	BasePge base;
	Assert asrt;

	public AddFollower(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"Verify that user should able to navigate to the snipback website after entering the URL" 
	// Automation ID   : Follower_01
	// </summary>
	public void Follower_01_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		//Step 1  :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");
	}

	// <summary>
	// Test Case Title :"Verify that user should able to navigate to the Film page once login with credentials"
	// Automation ID   : Follower_02
	// </summary>
	public void Follower_02_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();

		//Step 1  :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected:"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");
	}

	// <summary>
	// Test Case Title :"Verify that Followers tab should be displayed in the organization if the user as Admin/Coach in the Film page"
	// Automation ID   : Follower_03
	// </summary>
	public void Follower_03_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();

		//Step 1  :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected:"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click On LoginButton"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_03_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Verify FOLLOWERS tab is displayed in the organization"
		//Expected:"Followers tab should be displayed in the organization if the user as Admin/Coach in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "Followers tab is not displayed in the organization if the user as Admin/Coach in the Film page");

	}
	
	// <summary>
	// Test Case Title :"Verify that Followers tab should  be disabled in Home organization and in the Organization if the User as Player/Followers in the Film page"
	// Automation ID   : Follower_04
	// </summary>
	public void Follower_04_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		Pool_Obj PoolObj=new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1  :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected:"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4  :"Switch the organization if the User as Player/Follower or Home Organization"
		//Expected :"User should be select the OrgName as Home Organization"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_04_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select the OrgName as Home Organization");

		//Step 5  :"Verify that Followers tab is disabled if the user is a Player/Follower"
		//Expected:"Followers tab should  be disabled in Home organization and in the Organization if the User as Player/Followers in the Film page"
		asrt.assertTrue(base.isExists(addfollowerObj.Btn_Followers("nav-followers-tab")), "Followers tab is not disabled in Home organization if the user as Player/Followers in the Film page");
	}	
	
	// <summary>
	// Test Case Title :"Verify that user (Admin/Coach) should able to click on Followers tab in the Film page" 
	// Automation ID   : Follower_05
	// </summary>
	public void Follower_05_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();

		//Step 1  :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected:"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Switch the organization if the User as Admin/Coach"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_05_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected:"The user (Admin/Coach) should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user (Admin/Coach) is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user (Admin/Coach) is not able to click on Followers tab in the Film page");
	}

	// <summary>
	// Test Case Title :"Verify that a Search bar should be displayed in the Followers page to search Followers/Managers & proper results should be displayed based on the search" 
	// Automation ID   : Follower_06
	// </summary>
	public void Follower_06_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();

		//Step 1 : Navigate to the SnipbackWebsite after entering the URL
		//Expected : User should able to navigate to the SnipbackWebsite after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2 : Click on Login Button
		//Expected : User should able to click Login Button
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3 : Click the Film Button
		//Expected : User should be navigated to Film Page
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : Switch the organization if the User as Admin/Coach
		//Expected : User should be navigated to OrgName list and select the OrgName
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_06_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : Click on Followers tab
		//Expected : The user should able to click on Followers tab in the Film page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		//Step 6 : Search Follower data in the Search tab
		//Expected : Search bar should be displayed in the Followers page to search Followers
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("teamGroupMembers")), "The user unable see the search bar displayed in the Followers page to search Followers");
		base.setData(LoginPageObj.Edt_LoginEmail("teamGroupMembers"),AddFollowerTestData.Follower_06_FollowerSearch);
		
		//Step 7 : Verify the results of the Follower
		//Expected : Proper results should be displayed based on the follower search
		String FollowerSearchValue = base.GetValue(LoginPageObj.Edt_LoginEmail("teamGroupMembers"));
		Thread.sleep(5000);
		asrt.assertEquals(FollowerSearchValue, AddFollowerTestData.Follower_06_FollowerSearch, "User is not able to enter the search follower data");
        asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName(AddFollowerTestData.Follower_06_FollowerSearch)), "Proper results is not displayed based on the follower search");
        Thread.sleep(5000);

		//Step 8 : Search Manager data in the Search tab
		//Expected : Search bar should be displayed in the Followers page to search Managers
        base.backspace(LoginPageObj.Edt_LoginEmail("teamGroupMembers"));
        Thread.sleep(8000);
		base.setData(LoginPageObj.Edt_LoginEmail("teamGroupMembers"),AddFollowerTestData.Follower_06_ManagerSearch);
		
		//Step 9 : Verify the results of the Manager
		//Expected : Proper results should be displayed based on the manager search
		String ManagerSearchValue = base.GetValue(LoginPageObj.Edt_LoginEmail("teamGroupMembers"));
		Thread.sleep(5000);
		asrt.assertEquals(ManagerSearchValue, AddFollowerTestData.Follower_06_ManagerSearch, "User is not able to enter the search manager data");
        asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName(AddFollowerTestData.Follower_06_ManagerSearch)), "Proper results is not displayed based on the manager search");
        Thread.sleep(5000);
        
	}
	
	// <summary>
	// Test Case Title :"Verify that user (Admin/Coach) should able to view the list of Followers/Managers after clicking the Follower tab in the Film page" 
	// Automation ID   : Follower_07
	// </summary>
	public void Follower_07_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();

		//Step 1 : Navigate to the SnipbackWebsite after entering the URL
		//Expected : User should able to navigate to the SnipbackWebsite after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2 : Click on Login Button
		//Expected : User should able to click Login Button
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3 : Click the Film Button
		//Expected : User should be navigated to Film Page
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : Switch the organization if the User as Admin/Coach
		//Expected : User should be navigated to OrgName list and select the OrgName
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_07_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : Click on Followers tab
		//Expected : The user should able to click on Followers tab in the Film page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user (Admin/Coach) is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user (Admin/Coach) is not able to click on Followers tab in the Film page");
		
		//Step 6 : Verify the list of followers is displayed after clicked the Follower tab in the Film page
		//Expected : The user (Admin/Coach) should able to view the list of Followers/Managers after clicking the Follower tab in the Film page
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerList("teamDetailsDiv","teamRole")),"The user (Admin/Coach) is not able to view the list of Followers/Managers after clicking the Follower tab in the Film page");
		List<String> listOfGameModes = base.GetElementTexts(addfollowerObj.Ele_FollowerList("teamDetailsDiv","teamRole")); 
		List<String> expectedList = Arrays.asList("Manager","Follower");
		asrt.assertEquals(listOfGameModes.subList(0, 2), expectedList,"both list is not matching");
	}

	// <summary>
	// Test Case Title :"Verify that an option for add Followers/Managers (+Followers ) should be displayed in the Followers tab under Film page" 
	// Automation ID   : Follower_08
	// </summary>
	public void Follower_08_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();

		//Step 1 : Navigate to the SnipbackWebsite after entering the URL
		//Expected : User should able to navigate to the SnipbackWebsite after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2 : Click on Login Button
		//Expected : User should able to click Login Button
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3 : Click the Film Button
		//Expected : User should be navigated to Film Page
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : Switch the organization if the User as Admin/Coach
		//Expected : User should be navigated to OrgName list and select the OrgName
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_08_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : Click on Followers tab
		//Expected : The user should able to click on Followers tab in the Film page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add Followers/Managers (+Followers )
		// Expected : An option for add Followers/Managers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add Followers/Managers (+Followers ) is not displayed in the Followers tab under Film page");
	}

	// <summary>
	// Test Case Title :"Verify that the following option should be displayed in the page for adding Followers/Managers after clicking +Followers option;" 
	//1.Main Heading- CREATE NEW USER 
	//2.Sub heading- Add Email ID 
	//3.Text field for Entering the Email ID 
	//4.X mark and tick mark against the field for entering the email ID 
	// Automation ID   : Follower_09
	// </summary>
	public void Follower_09_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1 : Navigate to the SnipbackWebsite after entering the URL
		//Expected : User should able to navigate to the SnipbackWebsite after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2 : Click on Login Button
		//Expected : User should able to click Login Button
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3 : Click the Film Button
		//Expected : User should be navigated to Film Page
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : Switch the organization if the User as Admin/Coach
		//Expected : User should be navigated to OrgName list and select the OrgName
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_09_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5 : Click on Followers tab
		//Expected : The user should able to click on Followers tab in the Film page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add Followers/Managers (+Followers )
		// Expected : An option for add Followers/Managers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add Followers/Managers (+Followers ) is not displayed in the Followers tab under Film page");

		// Step 7 : Click on +Follow button tab in the Follow page
		// Expected : The following option should be displayed in the page for adding Followers/Managers after clicking +Followers option; 1.Main Heading- CREATE NEW USER 2.Sub heading- Add Email ID 3.Text field for Entering the Email ID 4.X mark and tick mark against the field for entering the email ID
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerHedder("CREATE NEW USER")),"The user not able to see Main Heading- CREATE NEW USER after clicking +Followers option");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerX("bi bi-x")),"The user not able to see X mark against the field for entering the email ID");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerCheck("bi bi-check2")),"The user not able to see tick mark against the field for entering the email ID");
	}

	// <summary>
	// Test Case Title :"Verify that add followers option should be displayed in Individuals teams as well" 
	// Automation ID   : Follower_10
	// </summary>
	public void Follower_10_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1 : Navigate to the SnipbackWebsite after entering the URL
		//Expected : User should able to navigate to the SnipbackWebsite after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2 : Click on Login Button
		//Expected : User should able to click Login Button
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3 : Click the Film Button
		//Expected : User should be navigated to Film Page
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : Switch the organization if the User as Admin/Coach
		//Expected : User should be navigated to OrgName list and select the OrgName
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_10_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
        //Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(AddFollowerTestData.Follower_10_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(AddFollowerTestData.Follower_10_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(AddFollowerTestData.Follower_10_TeamName, "d-flex align-items-center item-label"));
		
		//Step 6 : Click on Followers tab
		//Expected : The user should able to click on Followers tab in the Film page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 7 : Verify an option to add Followers/Managers (+Followers ) for individual teams
		// Expected : Add followers option should be displayed in Individuals teams as well
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "Add followers option not displayed in Individuals teams as well");
	}	
	
	// <summary>
	// Test Case Title :"Verify that the list of smiliar email ids (Email id of users already in any organization/team) should displayed when we try to add the users as Followers/Managers using that email id" 
	// Automation ID   : Follower_11
	// </summary>
	public void Follower_11_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		DuplicateSnip_Obj DuplicateSnipObj = new DuplicateSnip_Obj();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_11_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add followers (+Followers )
		// Expected : An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");

		// Step 7 : Click on +Follow button tab in the Follow page
		// Expected : User should view the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");

		// Step 8 : Enter the users's email id
		// Expected : The list of smiliar email ids (Email id of users already in any organization/team) should displayed when we try to add the users as Followers/Managers using that email id
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_11_AddEmailAddress);
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(DuplicateSnipObj.Ele_SelectGame("ui-corner-all",AddFollowerTestData.Follower_11_AddEmailAddress)), "The list of smiliar email ids (Email id of users already in any organization/team) is not displayed when we try to add the users as Followers/Managers using that email id");
	}

	// <summary>
	// Test Case Title :"Verify that No Data Found message should displayed if we use the new Email  ld to add user as Followers/Managers" 
	// Automation ID   : Follower_12
	// </summary>
	public void Follower_12_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		DuplicateSnip_Obj DuplicateSnipObj = new DuplicateSnip_Obj();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_12_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add followers (+Followers )
		// Expected : An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");

		// Step 7 : Click on + Follow button tab in the Follow page
		// Expected : User should view the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");

		// Step 8 : Enter the New email id
		// Expected : No Data Found message should displayed if we use the new email id to add as follower
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_12_AddEmailAddress);
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(DuplicateSnipObj.Ele_SelectGame("ui-corner-all","No data found")), "No Data Found message is not displayed if we use the new emaild to add as follower");
	}	
	
	// <summary>
	// Test Case Title :"Verify that the page for entering the details of Followers/Managers should be displayed when clicking on the tick button after entering the email id"
	// Automation ID   : Follower_13
	// </summary>
	public void Follower_13_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_13_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add followers (+Followers )
		// Expected : An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");

		// Step 7 : Click on + Follow button tab in the Follow page
		// Expected : User should view the Main Heading- CREATE NEW USER to enter the details
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerCheck("bi bi-check2")),"The user not able to see tick mark against the field for entering the email ID");

		// Step 8  : "Enter the user's email ID"
		// Expected : "User should be able to enter the email ID"
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_13_AddEmailAddress);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		Assert.assertEquals(Email, AddFollowerTestData.Follower_13_AddEmailAddress, "User should not able to enter Email in the Follower page");

		// Step 9 : "Click on the tick button"
		// Expected : "The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id"
		base.buttonClick(LoginPageObj.Btn_SigninClick("checkMail();"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SigninClick("checkMail();")), "The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");
	}

	// <summary>
	// Test Case Title :"Verify that the entered email should be cleared once we click on X button "
	// Automation ID   : Follower_14	
	// </summary>

	public void Follower_14_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_14_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add followers (+Followers )
		// Expected : An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");
		
		// Step 7 : Click on +Follow button tab in the Follow page
		//Expected : User should view the Main Heading- CREATE NEW USER to enter the details
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerX("bi bi-x")),"The user not able to see X mark against the field for entering the email ID");

		// Step 8  : "Enter the user's email ID"
		// Expected : "User should be able to enter the email ID"
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_14_AddEmailAddress);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		Assert.assertEquals(Email, AddFollowerTestData.Follower_14_AddEmailAddress, "User should not able to enter Email in the Follower page");

		// Step 9 : "Click on the X button"
		// Expected : "The entered email should be cleared once we click on X button "
		base.buttonClick(LoginPageObj.Btn_SigninClick("clearEmail(1)"));
		String Email1 = base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		asrt.assertEquals(Email1, "", "User not able to clear the email address");
	}

	// <summary>
	// Test Case Title :"Verify that the following option should be displayed when clicking on the tick button after entering the email id;"
	//1.First Name (Mandatory)
	//2.Last Name (Optional)
	//3.Team Name
	//4.Jersey number (#)
	//5.The text Send a message along with notification email 
	//6.Field for adding message
	//7.Add as Player/users Organization button
	// Automation ID   : Follower_15
	// </summary>
	public void Follower_15_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_15_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add followers (+Followers )
		// Expected : An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");

		// Step 7 : Click on + Follow button tab in the Follow page
		// Expected : User should view the Main Heading- CREATE NEW USER to enter the details
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerCheck("bi bi-check2")),"The user not able to see tick mark against the field for entering the email ID");

		// Step 8  : "Enter the user's email ID"
		// Expected : "User should be able to enter the email ID"
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_15_AddEmailAddress);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		Assert.assertEquals(Email, AddFollowerTestData.Follower_15_AddEmailAddress, "User should not able to enter Email in the Follower page");

		// Step 9 : "Click on the tick button"
		// Expected : "The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id"
		base.buttonClick(LoginPageObj.Btn_SigninClick("checkMail();"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SigninClick("checkMail();")), "The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");

		//Step 10 : "To verify the option 'First Name'" is mandatory
		//Expected : "First Name field should be displayed and mandatory"
		base.setData(LoginPageObj.Edt_LoginEmail("firstname"),AddFollowerTestData.Follower_15_AddFollowerFirstName);
		String ActualFname=base.GetValue(LoginPageObj.Edt_LoginEmail("firstname"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("firstname")),"First Name field is not displayed or not mandatory");

		//Step 11 : "To verify the option 'Last Name'" is optional
		//Expected : "Last Name field should be displayed and optional"
		base.setData(LoginPageObj.Edt_LoginEmail("lastname"), AddFollowerTestData.Follower_15_AddFollowerLastName);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("lastname")),"Last Name field is not displayed or not optional");

		//Step 12 : "To verify the option 'Team Name'" is displayed
		//Expected : "Team Name field should be displayed"
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_DropdownClick("createUserTeamName")),"Unable to view the Team select Dropdown");
		base.buttonClick(addfollowerObj.Ele_DropdownClick("createUserTeamName"));
		base.buttonClick(addfollowerObj.Ele_DropdownSelection("text",AddFollowerTestData.Follower_15_TeamName));	
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_DropdownSelection("text",AddFollowerTestData.Follower_15_TeamName)),"Unable to select the particular Team name from the Dropdown");

		//Step 13 : "To verify the option 'Jersey Number(#)'" is displayed
		//Expected : "Jersey Number(#) field should be displayed"
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), AddFollowerTestData.Follower_15_AddFollowerJerseyNumber );
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("jerseyNumber")),"Jersey Number field is not displayed");

		//Step 14 : "To verify the option 'Send a message along with notification email'" is displayed
		//Expected : "Send a message along with notification email should be displayed"
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_NotificationEmail("Send a message along with notification email.")),"Send a message along with notification email is not displayed");

		//Step 15 : "To verify the option 'Field for adding message'" is displayed
		//Expected : "Field for adding message should be displayed"
		base.setData(addfollowerObj.Ele_FollowerMessage("addUserdetails","playerCreateMessage"), AddFollowerTestData.Follower_15_AddFollowerAddingMessage );
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerMessage("addUserdetails","playerCreateMessage")),"Field for adding message is not be displayed");

		//Step 16 : "To verify the option Add as Player/User" is displayed
		//Expected : "Add as Player/User button should be displayed"
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn")), "'CREATE ACCOUNT & ADD AS FOLLOWER TO ORGANIZATION' is not displayed in the  Create New User Page");
	}
	
	// <summary>
	// Test Case Title :"Verify that the proper message " User already in the organization" should be displayed after clicking "Add Users/Players to the Organization" if we try to add the same user as Follower/Manager in the  same Organization." 
	// Automation ID   : Follower_16
	// </summary>
	public void Follower_16_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_16_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add followers (+Followers )
		// Expected : An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");

		// Step 7 : Click on + Follow button tab in the Follow page
		// Expected : User should view the Main Heading- CREATE NEW USER to enter the details
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerCheck("bi bi-check2")),"The user not able to see tick mark against the field for entering the email ID");

		// Step 8  : "Enter the user's email ID"
		// Expected : "User should be able to enter the email ID"
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_16_AddEmailAddress);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		Assert.assertEquals(Email, AddFollowerTestData.Follower_16_AddEmailAddress, "User should not able to enter Email in the Follower page");

		// Step 9 : "Click on the tick button"
		// Expected : "The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id"
		base.buttonClick(LoginPageObj.Btn_SigninClick("checkMail();"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SigninClick("checkMail();")), "The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");	
		Thread.sleep(3000);
		
		//Step 10 : Click on ADD AS PLAYER / USER TO ORGANIZATION button
		//Expected : The proper message " User already in the organization" should be displayed after clicking "Add Users/Players to the Organization" if we try to add the same user as Follower/Manager in the  same Organization
		base.buttonClick(addfollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("user already added in organization")), "Proper message 'User already in the organization' is not dispalyed if we try to add the same user as Follower/Manager in the  same Organization");
		Thread.sleep(3000);
	}

	// <summary>
	// Test Case Title :"Verify that there should not be any restriction to add same email ld  in different teams as followers" 
	// Automation ID   : Follower_17
	// </summary>
	public void Follower_17_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata=new CommonData();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj=new Pool_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData=new AddFollower_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Switch the organization if the User as Admin/Coach"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_17_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		// Step 5 : Click on Follow button tab in the Film page
		// Expected : Add followers option should be displayed in Individuals teams as well
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(AddFollowerTestData.Follower_17_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(AddFollowerTestData.Follower_17_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(AddFollowerTestData.Follower_17_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(LoginPageObj.Edt_Alert1("FOLLOWERS"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")),"The user not able to see Main Heading- CREATE NEW USER after clicking +Followers option");

		// Step 6 : Click on +Follow button tab in the Follow page
		// Expected : The user is able to see Main Heading- CREATE NEW USER after clicking +Followers option
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerHedder("CREATE NEW USER")),"The user not able to see Main Heading- CREATE NEW USER after clicking +Followers option");

		// Step 7  : "Enter the user's existing email ID"
		// Expected : "User should be able to enter the email ID"
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_17_AddEmailAddress);
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		Assert.assertEquals(Email, AddFollowerTestData.Follower_17_AddEmailAddress, "User should not able to enter Email in the Follower page");

		// Step 8 : "Click on the tick button"
		// Expected : "The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id"
		base.excuteJsClick(LoginPageObj.Btn_SigninClick("checkMail();"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SigninClick("checkMail();")), "The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");	
		Thread.sleep(3000);
		
		//Step 9 : Click on ADD AS PLAYER / USER TO ORGANIZATION button
		//Expected : The proper message " User already in the organization" should be displayed after clicking "Add Users/Players to the Organization" if we try to add the same user as Follower/Manager in the  same Organization
		base.excuteJsClick(AddFollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Record Updated Successfully")),  "There is restriction to add same email ld  in different teams as followers");
		Thread.sleep(5000);
		
		//Steps to Removing The Same Follower Data
		base.excuteJsClick(AddFollowerObj.Btn_FollowersClose("Close"));
		base.excuteJsClick(AddFollowerObj.Btn_FollowersEdit("nav-followers","bi bi-pencil"));
		base.excuteJsClick(AddFollowerObj.Chk_TeamSelect(AddFollowerTestData.Follower_17_FollowerName,"checkbox"));
		base.excuteJsClick(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
	}	

	// <summary>
	// Test Case Title :"Verify that proper message " First name is required" should be dispalyed if leaving the First name field empty and Click on Add Players/Users To Organization" 
	// Automation ID   : Follower_18
	// </summary>
	public void Follower_18_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_18_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		//Step 6 : Verify an option for add followers (+Followers )
		//Expected : An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");

		//Step 7 : Click on + Follow button tab in the Follow page
		//Expected : User should view the Main Heading- CREATE NEW USER to enter the details
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerHedder("CREATE NEW USER")),"The user not able to see Main Heading- CREATE NEW USER after clicking +Followers option");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");

		//Step 8 : Enter a valid email in the email field of add follower
		//Expected : The user is able to enter the valid email adders
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_18_AddEmailAddress);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2")), "The user is able to enter the valid email adders");

		//Step 9 : Click on tick option
		//Expected : The user should be able to see the rest of the options
		base.buttonClick(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2")), "The page for entering the details of followers is not displayed");

		//Step 10 : Click on ADD AS PLAYER / USER TO ORGANIZATION button
		//Expected : Verify that proper message " First name is required" should be displayed if leaving the First name field empty and Click on Add Players/Users To Organization
		base.clearData(LoginPageObj.Edt_LoginEmail("firstname"));
		base.buttonClick(addfollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Firstname is required")), "Proper message 'First name is required' is not dispalyed if leaving the First name field empty and Click on Add Players/Users To Organization");
	}

	// <summary>
	// Test Case Title :"Verify that the user should able to Enter the Jersey number in the Jersey number filed and also  has a up and down arrow to enter the jersey number" 
	// Automation ID   : Follower_19
	// </summary>
	public void Follower_19_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_19_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add followers (+Followers )
		// Expected : An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");

		// Step 7: Click on + Follow button tab in the Follow page
		// Expected: User should view the Main Heading- CREATE NEW USER to enter the details
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerHedder("CREATE NEW USER")),"The user not able to see Main Heading- CREATE NEW USER after clicking +Followers option");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");

		// Step8: Enter a valid email in the email field of add follower
		// Expected: The user is able to enter the valid email adders
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_18_AddEmailAddress);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2")), "The user is able to enter the valid email adders");

		//Step9: Click on tick option
		//Expected: The user should be able to see the rest of the options
		base.buttonClick(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2")), "The page for entering the details of followers is not displayed");

		//Step10: Enter the Jersey number in the Jersey number filed 
		//Expected:	Verify that the user should able to Enter the Jersey number in the Jersey number filed and also  has a up and down arrow to enter the jersey number
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), AddFollowerTestData.Follower_19_AddFollowersJersyumber);
		Thread.sleep(2000);
		String EnteredNumber= base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertEquals(EnteredNumber, AddFollowerTestData.Follower_19_AddFollowersJersyumber, "Verify that the user should able to Enter the Jersey number in the Jersey number filed");
	}
	
	// <summary>
	// Test Case Title :"Verify that the user should able to Enter the Jersey number between 1 to 999 in the Jersey number field" 
	// Automation ID   : Follower_20
	// </summary>
	public void Follower_20_AddUpdateRemoveFollower() throws InterruptedException
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_20_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add followers (+Followers )
		// Expected : An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");

		// Step 7: Click on + Follow button tab in the Follow page
		// Expected: User should view the Main Heading- CREATE NEW USER to enter the details
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerHedder("CREATE NEW USER")),"The user not able to see Main Heading- CREATE NEW USER after clicking +Followers option");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");

		// Step 8: Enter a valid email in the email field of add follower
		// Expected: The user is able to enter the valid email adders
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_20_AddFollowerEmail1);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2")), "The user is able to enter the valid email adders");

		//Step 9: Click on tick option
		//Expected: The user should be able to see the rest of the options
		base.buttonClick(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2")), "The page for entering the details of followers is not displayed");
		
		//Step 10.Enter Jersey number between 1 to 999
		//Expected: The user should able to Enter the Jersey number between 1 to 999 in the Jersey number field
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), AddFollowerTestData.Follower_20_AddFollowerJnum);
		Thread.sleep(2000);
		String EnterdNum= base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertEquals(EnterdNum, AddFollowerTestData.Follower_20_AddFollowerJnum,"The entered and given Jersey numbers don't match");
	}
	
	// <summary>
	// Test Case Title :"Verify that  4 digit numeric should not be as Jersey number" 
	// Automation ID   : Follower_21
	// </summary>
	public void Follower_21_AddUpdateRemoveFollower() throws InterruptedException
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_21_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add followers (+Followers )
		// Expected : An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");

		// Step 7: Click on + Follow button tab in the Follow page
		// Expected: User should view the Main Heading- CREATE NEW USER to enter the details
		base.buttonClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerHedder("CREATE NEW USER")),"The user not able to see Main Heading- CREATE NEW USER after clicking +Followers option");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");

		// Step 8: Enter a valid email in the email field of add follower
		// Expected: The user is able to enter the valid email adders
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_21_AddFollowerEmail1);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2")), "The user is able to enter the valid email adders");

		//Step 9: Click on tick option
		//Expected: The user should be able to see the rest of the options
		base.buttonClick(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2")), "The page for entering the details of followers is not displayed");
		
		//Step 10: Enter 4 digit Jersey number
		//Expected: 4 digit numeric should not be as Jersey number
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), AddFollowerTestData.Follower_21_AddFollowerJnum);
		Thread.sleep(2000);
		String EnterdNum= base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertNotEquals(EnterdNum, AddFollowerTestData.Follower_21_AddFollowerJnum,"Invalid Jersey number is getting entered in the Jersey number field in the 'Create New user' pop-Up in the Followers page");
	}

	// <summary>
	// Test Case Title :"Verify that the user should added as Follower/Manager to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization" 
	// Automation ID   : Follower_22
	// </summary>
	public void Follower_22_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj addfollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_22_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add followers (+Followers )
		// Expected : An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");

		// Step 7: Click on + Follow button tab in the Follow page
		// Expected: User should view the Main Heading- CREATE NEW USER to enter the details
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerHedder("CREATE NEW USER")),"The user not able to see Main Heading- CREATE NEW USER after clicking +Followers option");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");

		// Step 8: Enter a valid email in the email field of add follower
		// Expected: The user is able to enter the valid email adders
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_22_AddEmailAddress);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2")), "The user is able to enter the valid email adders");

		//Step 9: Click on tick option
		//Expected: The user should be able to see the rest of the options
		base.excuteJsClick(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn")), "");

		//Step 10: Enter the Jersey number in the Jersey number filed 
		//Expected:The user should able to Enter the Jersey number in the Jersey number filed 
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), AddFollowerTestData.Follower_22_AddFollowersJersyumber);
		String EnteredNumber= base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertEquals(EnteredNumber, AddFollowerTestData.Follower_22_AddFollowersJersyumber, "The user not able to Enter the Jersey number in the Jersey number filed");

		//Step 11: Select the team from the drop down
		//Expected:The user should be able to select the team from the drop down 
		base.excuteJsClick(addfollowerObj.Ele_DropdownClick("createUserTeamName"));
		base.excuteJsClick(addfollowerObj.Ele_DropdownSelection("text",AddFollowerTestData.Follower_22_TeamName));

		//Step 12: Click on ADD AS PLAYER / USER TO ORGANIZATION Button
		//Expected: The user should added as follower to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization
		base.excuteJsClick(addfollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Record Updated Successfully")), "The user not able added as follower to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization");
		Thread.sleep(10000);
		
		//Steps to Removing The Same Follower Data
		base.excuteJsClick(addfollowerObj.Btn_FollowersClose("Close"));
		base.excuteJsClick(addfollowerObj.Btn_FollowersEdit("nav-followers","bi bi-pencil"));
		base.excuteJsClick(addfollowerObj.Chk_TeamSelect(AddFollowerTestData.Follower_22_FollowerName,"checkbox"));
		base.excuteJsClick(addfollowerObj.Btn_RemoveAll("REMOVE ALL"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		
		//For adding user as "Manager"

		// Step 13 : Click on + Follow button tab in the Follow page
		// Expected : User should view the Main Heading- CREATE NEW USER to enter the details
		base.scrollUp(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerHedder("CREATE NEW USER")),"The user not able to see Main Heading- CREATE NEW USER after clicking +Followers option");
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");

		// Step 14 : Enter a valid email in the email field of add follower
		// Expected : The user is able to enter the valid email adders
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_22_AddEmailAddress);
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2")), "The user is able to enter the valid email adders");

		//Step 15 : Click on tick option
		//Expected : The user should be able to see the rest of the options
		base.excuteJsClick(addfollowerObj.Ele_FollowerTickBtn("bi bi-check2"));
		asrt.assertTrue(base.isExists(addfollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn")), "Unable to view the follower/manager creation page");
		
		//Step 16 : Mark on the Manager option
		//Expected : The user should be able to mark on the "Manager" option
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("createManagerRadioBtnMdl")), "The user is not able to view the radio button for marking as 'Manager'");
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("createManagerRadioBtnMdl"));

		//Step 17 : Enter the Jersey number in the Jersey number filed 
		//Expected :The user should able to Enter the Jersey number in the Jersey number filed 
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), AddFollowerTestData.Follower_22_AddFollowersJersyumber);
		String EnteredNumberManager= base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertEquals(EnteredNumberManager, AddFollowerTestData.Follower_22_AddFollowersJersyumber, "The user not able to Enter the Jersey number in the Jersey number filed");

		//Step 18 : Select the organization or team from the drop down
		//Expected :The user should be able to select the organization or team from the drop down 
		base.excuteJsClick(addfollowerObj.Ele_DropdownClick("createUserTeamName"));
		base.excuteJsClick(addfollowerObj.Ele_DropdownSelection("text",AddFollowerTestData.Follower_22_TeamName));

		//Step 19 : Click on ADD AS PLAYER / USER TO ORGANIZATION Button
		//Expected : The user should added as Manager to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization
		base.excuteJsClick(addfollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Record Updated Successfully")), "The user not able added as Manager to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization");

		//Steps to Removing The Same Manager Data
		Thread.sleep(10000);
		base.excuteJsClick(addfollowerObj.Btn_FollowersClose("Close"));
		base.excuteJsClick(addfollowerObj.Btn_FollowersEdit("nav-followers","bi bi-pencil"));
		base.excuteJsClick(addfollowerObj.Chk_TeamSelect(AddFollowerTestData.Follower_22_FollowerName,"checkbox"));
		base.excuteJsClick(addfollowerObj.Btn_RemoveAll("REMOVE ALL"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));	
	}

	// <summary>
	// Test Case Title :"Verify that the newly added user as Follower/Manager to the organization/team should be displayed in the Followers list in Followers tab under Film Page" 
	// Automation ID   : Follower_23
	// </summary>
	public void Follower_23_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_23_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6 : Verify an option for add followers (+Followers )
		// Expected : An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");

		// Step 7: Click on + Follow button tab in the Follow page
		// Expected: User should view the Main Heading- CREATE NEW USER to enter the details
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerHedder("CREATE NEW USER")),"The user not able to see Main Heading- CREATE NEW USER after clicking +Followers option");
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");

		// Step 8: Enter a valid email in the email field of add follower
		// Expected: The user is able to enter the valid email adders
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_23_AddEmailAddress);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerTickBtn("bi bi-check2")), "The user is able to enter the valid email adders");

		//Step 9: Click on tick option
		//Expected: The user should be able to see the rest of the options
		base.excuteJsClick(AddFollowerObj.Ele_FollowerTickBtn("bi bi-check2"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn")), "Unable to view the follower/manager creation page");

		//Step 10: Enter the Jersey number in the Jersey number filed 
		//Expected:The user should able to Enter the Jersey number in the Jersey number filed 
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), AddFollowerTestData.Follower_23_AddFollowersJersyumber);
		String EnteredNumber= base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertEquals(EnteredNumber, AddFollowerTestData.Follower_23_AddFollowersJersyumber, "The user not able to Enter the Jersey number in the Jersey number filed");

		//Step 11 : Select the organization or team from the drop down
		//Expected : The user should be able to select the organization or team from the drop down 
		base.excuteJsClick(AddFollowerObj.Ele_DropdownClick("createUserTeamName"));
		base.excuteJsClick(AddFollowerObj.Ele_DropdownSelection("text",AddFollowerTestData.Follower_23_TeamName));

		//Step 12 : Click on ADD AS PLAYER / USER TO ORGANIZATION Button
		//Expected : The user should added as follower to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization
		base.excuteJsClick(AddFollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Record Updated Successfully")), "The user not able added as follower to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization");

		//Step 13 : Click on Close Button
		//Expected : The newly added user as Follower to the organization/team should be displayed in the Followers list in Followers tab under Film Page
		Thread.sleep(10000);
		base.excuteJsClick(AddFollowerObj.Btn_FollowersClose("Close"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName(AddFollowerTestData.Follower_23_AddEmailAddress)),"The newly added user as Follower to the organization/team is not displayed in the Followers list in Followers tab under Film Page");
		Thread.sleep(10000);
		
		//Steps to Removing The Same Follower Data
		base.excuteJsClick(AddFollowerObj.Btn_FollowersEdit("nav-followers","bi bi-pencil"));
		base.excuteJsClick(AddFollowerObj.Chk_TeamSelect(AddFollowerTestData.Follower_23_FollowerName,"checkbox"));
		base.excuteJsClick(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		
		//For adding user as "Manager"

		// Step 14 : Click on + Follow button tab in the Follow page
		// Expected : User should view the Main Heading- CREATE NEW USER to enter the details
		base.scrollUp(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn")), "An option for add followers (+Followers ) is not displayed in the Followers tab under Film page");
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerHedder("CREATE NEW USER")),"The user not able to see Main Heading- CREATE NEW USER after clicking +Followers option");
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerAddEmail("Add Email Address")),"The user not able to see Sub heading- Add Email ID after clicking +Followers option");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"The user not able to see Text field for Entering the Email ID after clicking +Followers option");

		// Step 15 : Enter a valid email in the email field of add follower
		// Expected : The user is able to enter the valid email adders
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_23_AddEmailAddress);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerTickBtn("bi bi-check2")), "The user is able to enter the valid email adders");

		//Step 16 : Click on tick option
		//Expected : The user should be able to see the rest of the options
		base.excuteJsClick(AddFollowerObj.Ele_FollowerTickBtn("bi bi-check2"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn")), "Unable to view the follower/manager creation page");
		
		//Step 17 : Mark on the Manager option
		//Expected : The user should be able to mark on the "Manager" option
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("createManagerRadioBtnMdl")), "The user is not able to view the radio button for marking as 'Manager'");
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("createManagerRadioBtnMdl"));

		//Step 18 : Enter the Jersey number in the Jersey number filed 
		//Expected :The user should able to Enter the Jersey number in the Jersey number filed 
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), AddFollowerTestData.Follower_23_AddManagerJersyumber);
		String EnteredNumberManager= base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertEquals(EnteredNumberManager, AddFollowerTestData.Follower_23_AddManagerJersyumber, "The user not able to Enter the Jersey number in the Jersey number filed");

		//Step 19 : Select the organization or team from the drop down
		//Expected :The user should be able to select the organization or team from the drop down 
		base.excuteJsClick(AddFollowerObj.Ele_DropdownClick("createUserTeamName"));
		base.excuteJsClick(AddFollowerObj.Ele_DropdownSelection("text",AddFollowerTestData.Follower_23_TeamName));

		//Step 20 : Click on ADD AS PLAYER / USER TO ORGANIZATION Button
		//Expected : The user should added as Manager to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization
		base.excuteJsClick(AddFollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Record Updated Successfully")), "The user not able added as Manager to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization");

		//Step 21 : Click on Close Button
		//Expected : The newly added user as Manager to the organization/team should be displayed in the Followers list in Followers tab under Film Page
		Thread.sleep(10000);
		base.excuteJsClick(AddFollowerObj.Btn_FollowersClose("Close"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName(AddFollowerTestData.Follower_23_AddEmailAddress)),"The newly added user as Manager to the organization/team is not displayed in the Followers list in Followers tab under Film Page");
		Thread.sleep(10000);		
		
		//Steps to Removing The Same Manager Data
		base.excuteJsClick(AddFollowerObj.Btn_FollowersEdit("nav-followers","bi bi-pencil"));
		base.excuteJsClick(AddFollowerObj.Chk_TeamSelect(AddFollowerTestData.Follower_23_ManagerName,"checkbox"));
		base.excuteJsClick(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));		
	}
	
	// <summary>
	// Test Case Title :"Verify that the details of the Followers/Managers should be displayed when we click on the name of the follower in the followers list under film page" 
	// Automation ID   : Follower_24
	// </summary>
	public void Follower_24_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_24_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6: Click on the follower's name
		// Expected: The details of the followers should be displayed when we click on the name of the follower in the followers list under film page
		base.buttonClick(AddFollowerObj.Ele_FollowerName(AddFollowerTestData.Follower_24_FollowerName,AddFollowerTestData.Follower_24_FollowerEmail));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("First Name")), "The details of the follower is not displayed when we click on the name of the follower in the followers list under film page");
		
		//For verifying the details of the manager
		
		//Step 7  : Click on Followers tab
		//Expected : The user should able to click on Followers tab in the Film page
		base.buttonClick(AddFollowerObj.Btn_FollowersUpdate("DISMISS"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 8 : Click on the Managers's name
		// Expected : The details of the Manager should be displayed when we click on the name of the Manager in the followers list under film page
		base.buttonClick(AddFollowerObj.Ele_FollowerName(AddFollowerTestData.Follower_24_ManagerName,AddFollowerTestData.Follower_24_ManagerEmail));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("First Name")), "The details of the Manager is not displayed when we click on the name of the Manager in the followers list under film page");
	}

	// <summary>
	// Test Case Title :"Verify that the following details should be displayed in the follower's details page"
	//1.First name
	//2.Last name 
	//3.Email address
	//4.Team
	//5.Role with drop down
	//6.Update & Dismiss button
	// Automation ID   : Follower_25
	// </summary>
	public void Follower_25_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_25_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6: Click on the follower's name
		// Expected: The following details should be displayed in the follower's details page 1.First name 2.Last name 3.Email address 4.Team 5.Role with drop down 6.Update & Dismiss button
		Thread.sleep(3000);
		base.buttonClick(AddFollowerObj.Ele_FollowerName(AddFollowerTestData.Follower_25_FollowerName,AddFollowerTestData.Follower_25_FollowerEmail));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("First Name")),"First name is not displayed in the follower's details page");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Last Name")),"Last Name is not displayed in the follower's details page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerEmailField("Email Address")),"Email Address is not displayed in the follower's details page");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Team")),"Team in not displayed in the follower's details page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerEmailField("Role")),"Role is not displayed in the follower's details page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersUpdate("UPDATE")),"UPDATE button is not displayed in the follower's details page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersUpdate("DISMISS")),"DISMISS button is not displayed in the follower's details page");
		
		//For verifying the details of the manager
		
		// Step 7 : Click on the Manager's name
		// Expected : The following details should be displayed in the Manager's details page 1.First name 2.Last name 3.Email address 4.Team 5.Role with drop down 6.Update & Dismiss button
		base.buttonClick(AddFollowerObj.Btn_FollowersUpdate("DISMISS"));
		Thread.sleep(3000);
		base.buttonClick(AddFollowerObj.Ele_FollowerName(AddFollowerTestData.Follower_25_ManagerName,AddFollowerTestData.Follower_25_ManagerEmail));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("First Name")),"First name is not displayed in the follower's details page");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Last Name")),"Last Name is not displayed in the follower's details page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerEmailField("Email Address")),"Email Address is not displayed in the follower's details page");
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Team")),"Team in not displayed in the follower's details page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerEmailField("Role")),"Role is not displayed in the follower's details page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersUpdate("UPDATE")),"UPDATE button is not displayed in the follower's details page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowersUpdate("DISMISS")),"DISMISS button is not displayed in the follower's details page");
	}

	// <summary>
	// Test Case Title :"Verify that the details page should closed when we click on "Dismiss" button " 
	// Automation ID   : Follower_26
	// </summary>
	public void Follower_26_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_26_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		// Step 6: Click on the follower's name
		// Expected: The details of the followers should be displayed when we click on the name of the follower in the followers list under film page
		base.buttonClick(AddFollowerObj.Ele_FollowerName(AddFollowerTestData.Follower_26_FollowerName,AddFollowerTestData.Follower_26_FollowerEmail));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("First Name")), "The details of the follower is not displayed when we click on the name of the follower in the followers list under film page");

		// Step 7: Click on the DISMISS button
		// Expected: The details page should closed when we click on "Dismiss" button 
		base.buttonClick(AddFollowerObj.Btn_FollowersUpdate("DISMISS"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerName(AddFollowerTestData.Follower_26_FollowerName,AddFollowerTestData.Follower_26_FollowerEmail)), "The details page is not closed when we click on \"Dismiss\" button  and the name of the follower is not in the followers list under film page");
	}
	
	// <summary>
	// Test Case Title :"Verify that the message "First Name must only contain letters" should be displayed when we try to enter the numerics/special charaters in the First name field and click on Update button" 
	// Automation ID   : Follower_27
	// </summary>
	public void Follower_27_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj=new Registration_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_27_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		//Step 6:Click on the follower's name and change the first name
		//Expected:User is able to view the follower's details with Update and dismiss button
		base.buttonClick(AddFollowerObj.Ele_FollowerName(AddFollowerTestData.Follower_27_FollowerName,AddFollowerTestData.Follower_27_FollowerEmail));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Btn_Create("button","UPDATE")),"User is not able to view the follower's details with Update and dismiss button");

		//Step 7 :Enter the numerics/special characters in the First name field and click on Update button
		//Expected:The message "First Name must only contain letters" should be displayed when User try to enter the numerics/special charaters in the First name field and click on Update button
		base.setData(LoginPageObj.Edt_LoginEmail("ed_first_name"), AddFollowerTestData.Follower_27_AddFollowerFirstName);
		base.buttonClick(PoolObj.Btn_Create("button","UPDATE"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Firstname must only contain letters")), "Firstname  must only contain letters message is not displayed if we use the new lastname to add as follower");
	}

	// <summary>
	// Test Case Title :"Verify that the message "Last Name must only contain letters" should be displayed when we try to enter the numerics/special charaters in the last name field and click on Update button" 
	// Automation ID   : Follower_28
	// </summary>
	public void Follower_28_AddUpdateRemoveFollower()  throws InterruptedException 
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_28_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		//Step 6:Click on the follower's name and change the first name
		//Expected:User is able to view the follower's details with Update and dismiss button
		base.buttonClick(AddFollowerObj.Ele_FollowerName(AddFollowerTestData.Follower_28_FollowerName,AddFollowerTestData.Follower_28_FollowerEmail));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Btn_Create("button","UPDATE")),"User is not able to view the follower's details with Update and dismiss button");

		//Step 7 :Enter the numerics/special characters in the last name field and click on Update button
		//Expected:The message "Last Name must only contain letters" should be displayed when User try to enter the numerics/special charaters in the last name field and click on Update button
		base.setData(LoginPageObj.Edt_LoginEmail("ed_last_name"), AddFollowerTestData.Follower_28_AddFollowerLastName);
		base.buttonClick(PoolObj.Btn_Create("button","UPDATE"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Lastname must only contain letters")), "Lastname must only contain letters message is not displayed if we use the new lastname to add as follower");
	}
	
	// <summary>
	// Test Case Title :"Verify that no changes should be made in the following fields;1.Email address	2.Team" 
	// Automation ID   : Follower_29
	// </summary>
	public void Follower_29_AddUpdateRemoveFollower()  throws InterruptedException 
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_29_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		//Step 6:Click on the follower's name 
		//Expected:User is able to view the follower's details with Update and dismiss button
		base.buttonClick(AddFollowerObj.Ele_FollowerName(AddFollowerTestData.Follower_29_FollowerName,AddFollowerTestData.Follower_29_FollowerEmail));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Btn_Create("button","UPDATE")),"User is not able to view the follower's details with Update and dismiss button");

		//Step 7:Try to change mail id and Team 
		//Expected:User is not able to edit  to  change mail id and Team 
		String ReadonlyAttribute=base.GetAttribte(LoginPageObj.Edt_LoginEmail("ed_email"), "readonly");
		if(ReadonlyAttribute !=null) {
			System.out.println("The field is Readonly");
		}
		else
		{
			System.out.println("The field is not Readonly");
		}
		
		String ReadonlyAttribute1=base.GetAttribte(LoginPageObj.Edt_LoginEmail("ed_teams"), "readonly");
		if(ReadonlyAttribute1 !=null) {
			System.out.println("The field is Readonly");
		}
		else
		{
			System.out.println("The field is not Readonly");
		}
	}  
	
	// <summary>
	// Test Case Title :"Verify that the following option should be displayed in the Role drop down;"
	//1.Player/Users
	//2.Followers
	//3.Recruiter
	//4.Coach
	//5.Admin
	// Automation ID   : Follower_30
	// </summary>
	public void Follower_30_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_30_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		//Step 6:Click on the follower's name and change the first name
		//Expected:User is able to view the follower's details with Update and dismiss button
		base.buttonClick(AddFollowerObj.Ele_FollowerName(AddFollowerTestData.Follower_30_FollowerName,AddFollowerTestData.Follower_30_FollowerEmail));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Btn_Create("button","UPDATE")),"User is not able to view the follower's details with Update and dismiss button");

		//Step 7:Try to change Role as Player/Recruiter/Coach/Admin
		//Expected:The role of the follower can be changed to; 1.Player/User2.Recruiter3.Coach OR4.Admin
		base.buttonClick(PoolObj.Ele_PoolTypeDropDown("ed_user_role"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole("Player / User")),"The 'Player / User' Role is not listed in the role dropdown");
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole("Follower")),"The 'Follower' Role is not listed in the role dropdown");
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole("Coach")),"The 'Coach' Role is not listed in the role dropdown");
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole("Admin")),"The 'Admin' Role is not listed in the role dropdown");
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole("Manager")),"The 'Manager' Role is not listed in the role dropdown");
	}
	
	// <summary>
	// Test Case Title :"Verify that the role of the follower can be changed to;1.Player/User2.Recruiter3.Coach OR 4.Admin" 
	// Automation ID   : Follower_31
	// </summary>
	public void Follower_31_AddUpdateRemoveFollower()  throws InterruptedException 
	{ 
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_31_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		//Step 6:Click on the follower's name and change the first name
		//Expected:User is able to view the follower's details with Update and dismiss button
		base.pressKey(null, "ESCAPE1");
		base.excuteJsClick(AddFollowerObj.Ele_FollowerName(AddFollowerTestData.Follower_31_FollowerName,AddFollowerTestData.Follower_31_FollowerEmail));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Btn_Create("button","UPDATE")),"User is not able to view the follower's details with Update and dismiss button");

		//Step 7:Try to change Role as Player/Recruiter/Coach/Admin
		//Expected:The role of the follower can be changed to; 1.Player/User2.Recruiter3.Coach OR4.Admin
		base.buttonClick(PoolObj.Ele_PoolTypeDropDown("ed_user_role"));
		base.buttonClick(AddFollowerObj.Ele_SelectRole("Coach"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole("Coach")),"The Role is not change from  followers to coach in User INFO page ");
	}

	// <summary>
	// Test Case Title :"Verify that after making changes in the follower's details page and click on the update button, the changes should be saved" 
	// Automation ID   : Follower_32
	// </summary>

	public void Follower_32_AddUpdateRemoveFollower()  throws InterruptedException 
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData=new AddFollower_TestData();
		
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_32_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		//Step 6:Click on the follower's name 
		//Expected:User is able to view the follower's details with Update and dismiss button
		Thread.sleep(2000);
		base.excuteJsClick(AddFollowerObj.Ele_FollowerID(AddFollowerTestData.Follower_32_FollowerID));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Btn_Create("button","UPDATE")),"User is not able to view the follower's details with Update and dismiss button");

		//Step 4:Make changes in the details page
		//Expected:User should be able to change the details in User INFO page.
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("ed_first_name"), AddFollowerTestData.Follower_32_UpdateFollowerFirstName);	
		String  FirstName = base.GetValue(LoginPageObj.Edt_LoginEmail("ed_first_name"));
		asrt.assertEquals(FirstName,AddFollowerTestData.Follower_32_UpdateFollowerFirstName,"The entered First Name is not displayed in the First Name text field in User INFO page");
		base.setData(LoginPageObj.Edt_LoginEmail("ed_last_name"), AddFollowerTestData.Follower_32_UpdateFollowerLastName);
		String  LastName = base.GetValue(LoginPageObj.Edt_LoginEmail("ed_last_name"));
		asrt.assertEquals(LastName,AddFollowerTestData.Follower_32_UpdateFollowerLastName,"The entered Last Name is not displayed in the Last Name text field in User INFO page");
		base.buttonClick(PoolObj.Ele_PoolTypeDropDown("ed_user_role"));
		base.buttonClick(AddFollowerObj.Ele_SelectRole("Manager"));

		//Step:5.Click on Update button
		//Expected:After making changes in the follower's details page and click on the update button, the changes should be saved.
		base.buttonClick(PoolObj.Btn_Create("button","UPDATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Profile updated successfully")), "User is not able to update the follower's details in User INFO page");

		//Steps to update as previous Data
		Thread.sleep(10000);
		base.buttonClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
		base.excuteJsClick(AddFollowerObj.Ele_FollowerID(AddFollowerTestData.Follower_32_FollowerID));
		Thread.sleep(5000);
		base.setData(LoginPageObj.Edt_LoginEmail("ed_first_name"), AddFollowerTestData.Follower_32_FollowerFirstName);
		base.setData(LoginPageObj.Edt_LoginEmail("ed_last_name"), AddFollowerTestData.Follower_32_FollowerLastName);
		base.buttonClick(PoolObj.Ele_PoolTypeDropDown("ed_user_role"));
		base.buttonClick(AddFollowerObj.Ele_SelectRole("Follower"));
		base.excuteJsClick(PoolObj.Btn_Create("button","UPDATE"));
		Thread.sleep(5000);
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
	}

	// <summary>
	// Test Case Title :"Verify that the follower should be removed from follower's list to member's list when we change the role from follower to 1.Player/User2.Recruiter3.Coach OR 4.Admin" 
	// Automation ID   : Follower_33
	// </summary>
	public void Follower_33_AddUpdateRemoveFollower()  throws InterruptedException 
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData=new AddFollower_TestData();
	
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_33_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");

		//Step 6 :Click on the follower's name and change the first name
		//Expected:User is able to view the follower's details with Update and dismiss button
		base.excuteJsClick(AddFollowerObj.Ele_FollowerID(AddFollowerTestData.Follower_33_FollowerID));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Btn_Create("button","UPDATE")),"User is not able to view the follower's details with Update and dismiss button");

		//Step 7 :Change Role from follower to player/Recruiter/Coach/Admin.
		//Expected:The role of the follower can be changed to; 1.Player/User2.Recruiter3.Coach OR4.Admin
		base.buttonClick(PoolObj.Ele_PoolTypeDropDown("ed_user_role"));
		base.buttonClick(AddFollowerObj.Ele_SelectRole("Player / User"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole("Player / User")),"The Role is not change from 'Follower' to 'Player / User' in User INFO page ");

		//Step 8 :Click on Update button
		//Expected:"The user should be change the role from follower to any one of the roles listed in the drop down".
		base.excuteJsClick(PoolObj.Btn_Create("button","UPDATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Profile updated successfully")), "User is not able to change the follower's details in User INFO page");
		Thread.sleep(10000);
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
		Thread.sleep(5000);
		
		//Step 9 : Verify the updated follower is listed in Member's tab
		//Expected : "The follower should be removed from follower's list to member's list when we change the role from follower to 1.Player/User 2.Recruiter 3.Coach or 4.Admin"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("MEMBERS")),"The user is not able to view the Member Icon");
		base.excuteJsClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamPlayerUserRadioBtn","checkmark")),"The user is not able to view the radio button for recruiters");
		base.excuteJsClick(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamPlayerUserRadioBtn","checkmark"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerID(AddFollowerTestData.Follower_33_FollowerID)),"The changed role from 'Follower' to 'Recruiter' is not listed under the member's list .");
		
		//Steps to change the updated data to previous data
		base.excuteJsClick(AddFollowerObj.Ele_FollowerID(AddFollowerTestData.Follower_33_FollowerID));
		base.buttonClick(PoolObj.Ele_PoolTypeDropDown("ed_user_role"));
		base.buttonClick(AddFollowerObj.Ele_SelectRole("Follower"));
		base.excuteJsClick(PoolObj.Btn_Create("button","UPDATE"));
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
		
		//For updating the role from Manager to some other role
		
		//Step 10  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");
		
		//Step 11 :Click on the Manager's name
		//Expected:User is able to view the Manager's details with Update and dismiss button
		base.excuteJsClick(AddFollowerObj.Ele_FollowerID(AddFollowerTestData.Follower_33_ManagerID));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Btn_Create("button","UPDATE")),"User is not able to view the Manager's details with Update and dismiss button");

		//Step 12 :Change Role from Manager to player/Recruiter/Coach/Admin.
		//Expected:The role of the Manager can be changed to; 1.Player/User2.Recruiter3.Coach OR4.Admin
		base.buttonClick(PoolObj.Ele_PoolTypeDropDown("ed_user_role"));
		base.buttonClick(AddFollowerObj.Ele_SelectRole("Player / User"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole("Player / User")),"The Role is not change from 'Manager' to 'Player / User' in User INFO page ");

		//Step 13 :Click on Update button
		//Expected:"The user should be change the role from Manager to any one of the roles listed in the drop down".
		base.excuteJsClick(PoolObj.Btn_Create("button","UPDATE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Profile updated successfully")), "User is not able to change the Manager's details in User INFO page");
		Thread.sleep(10000);
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
		Thread.sleep(5000);
		
		//Step 14 : Verify the updated follower is listed in Member's tab
		//Expected : "The follower should be removed from follower's list to member's list when we change the role from follower to 1.Player/User 2.Recruiter 3.Coach or 4.Admin"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("MEMBERS")),"The user is not able to view the Member Icon");
		base.excuteJsClick(LoginPageObj.Edt_Alert1("MEMBERS"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamPlayerUserRadioBtn","checkmark")),"The user is not able to view the radio button for recruiters");
		base.excuteJsClick(AddFollowerObj.Chk_TeamCoachAdmincheckbox("teamPlayerUserRadioBtn","checkmark"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerID(AddFollowerTestData.Follower_33_ManagerID)),"The changed role from 'Follower' to 'Recruiter' is not listed under the member's list .");
		
		//Steps to change the updated data to previous data
		base.excuteJsClick(AddFollowerObj.Ele_FollowerID(AddFollowerTestData.Follower_33_ManagerID));
		base.buttonClick(PoolObj.Ele_PoolTypeDropDown("ed_user_role"));
		base.buttonClick(AddFollowerObj.Ele_SelectRole("Follower"));
		base.excuteJsClick(PoolObj.Btn_Create("button","UPDATE"));
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		base.excuteJsClick(AddFollowerObj.Ele_FollowerID(AddFollowerTestData.Follower_33_ManagerID));
		base.buttonClick(PoolObj.Ele_PoolTypeDropDown("ed_user_role"));
		base.buttonClick(AddFollowerObj.Ele_SelectRole("Manager"));
		base.excuteJsClick(PoolObj.Btn_Create("button","UPDATE"));
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
	}
	
	// <summary>
	// Test Case Title :"Verify that a pencil icon should be displayed to remove followers from the Organization/Team" 
	// Automation ID   : Follower_34
	// </summary>
	public void Follower_34_AddUpdateRemoveFollower()  throws InterruptedException 
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
	
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_34_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");
		Thread.sleep(5000);
		
		//Step 6 :Verify the pencil icon
		//Expected :A pencil icon should be displayed to remove followers from the Organization/Team
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil")),"User unable to view the pencil icon to remove followers from the Organization/Team on the Followers List page.");


	}
	// <summary>
	// Test Case Title :"Verify that "Remove All" button should be displayed when click on Pencil icon from the Follower's page" 
	// Automation ID   : Follower_35
	// </summary>
	public void Follower_35_AddUpdateRemoveFollower()  throws InterruptedException 
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData=new AddFollower_TestData();
	
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_35_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");
		Thread.sleep(5000);
		
		//Step 6 :Click on the Pencil icon 			
		//Expected : A pencil icon should be displayed to remove followers from the Organization/Team
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil")),"User unable to view the pencil icon to remove followers");
		base.buttonClick(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil"));
		Thread.sleep(3000);
		
		//Step 7: Verify the option "Remove All"
		//Expected :Remove All" button should be displayed when click on Pencil icon from the Follower's page
		base.scrollToElement(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_RemoveAll("REMOVE ALL")),"Remove All button is not displayed when click on Pencil icon from the Follower's page");
	}

	// <summary>
	// Test Case Title :"Verify that "Check box" against the name of the Followers/Managers should be displayed when click on Pencil icon from the Follower's page" 
	// Automation ID   : Follower_36
	// </summary>
	public void Follower_36_AddUpdateRemoveFollower()  throws InterruptedException 
	{   
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
	
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_36_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");
		Thread.sleep(5000);
		
		//Step 6 :Click on the Pencil icon 			
		//Expected : A pencil icon should be displayed to remove followers from the Organization/Team
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil")),"User unable to view the pencil icon to remove followers");
		base.buttonClick(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil"));
		Thread.sleep(3000);

		//Step 7: Verify the "Check box"
		//Expected :"Check box" against the name of the Followers/Managers should be displayed when click on Pencil icon from the Follower's page
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_36_FollowerCheckbox)),"The checkbox against the name of the Follower is not displayed after clicking the Pencil button in the Followers page.");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_36_ManagerCheckbox)),"The checkbox against the name of the Manager is not displayed after clicking the Pencil button in the Followers page.");
	}
	
	// <summary>
	// Test Case Title :"Verify that user should able to click the check box against the Followers/Managers to remove them from Organization/Team" 
	// Automation ID   : Follower_37
	// </summary>
	public void Follower_37_AddUpdateRemoveFollower()  throws InterruptedException 
	{   
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
	
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_37_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");
		Thread.sleep(5000);
		
		//Step 6 :Click on the Pencil icon 			
		//Expected : A pencil icon should be displayed to remove followers from the Organization/Team
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil")),"User unable to view the pencil icon to remove followers");
		base.buttonClick(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil"));
		Thread.sleep(3000);
		
		//Step 7 : Verify the "Check box"
		//Expected :"Check box" against the name of the Followers/Managers should be displayed when click on Pencil icon from the Follower's page
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_37_FollowerCheckbox)),"The checkbox is not displayed after clicking the Pencil button in the Followers page.");
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_37_ManagerCheckbox)),"The checkbox against the name of the Manager is not displayed after clicking the Pencil button in the Followers page.");
		
		//Step 8 :Click on the checkbox of the Follower
		//Expected :User should able to click the check box against the Follower to remove them from Organization/Team
		base.selectCheckBox(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_37_FollowerCheckbox));
		Thread.sleep(3000);
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_37_FollowerCheckbox)).isSelected(),"The checkbox of the follower is not selected in the Followers page.");
		
		//Step 9 :Click on the checkbox of the Manager
		//Expected :User should able to click the check box against the Manager to remove them from Organization/Team
		base.selectCheckBox(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_37_ManagerCheckbox));
		Thread.sleep(3000);
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_37_ManagerCheckbox)).isSelected(),"The checkbox of the manager is not selected in the Followers page.");
	}

	// <summary>
	// Test Case Title :"Verify that the message"Are you sure you want to remove player?" with Yes and Cancel option should be popup when click on check box against the Followers/Managers and also click on the "Remove All" button " 
	// Automation ID   : Follower_38
	// </summary>
	public void Follower_38_AddUpdateRemoveFollower()  throws InterruptedException 
	{   
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
	
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_38_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");
		Thread.sleep(5000);
		
		//Step 6 :Click on the Pencil icon 			
		//Expected : A pencil icon should be displayed to remove followers from the Organization/Team
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil")),"User unable to view the pencil icon to remove followers");
		base.buttonClick(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil"));
		Thread.sleep(3000);
		
		//Step 7 : Verify the "Check box"
		//Expected :"Check box" against the name of the followers should be displayed when click on Pencil icon from the Follower's page
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_38_FollowerCheckbox)),"The checkbox is not displayed after clicking the Pencil button in the Followers page.");
		
		//Step 8 :Click on the checkbox
		//Expected :User should able to click the check box against the followers to remove them from Organization/Team
		base.selectCheckBox(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_38_FollowerCheckbox));
		Thread.sleep(3000);
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_38_FollowerCheckbox)).isSelected(),"The checkbox is not selected in the Followers page.");
		Thread.sleep(3000);

		//Step 9:Click on 'Remove All' button
		//Expected:The message"Are you sure you want to remove player?" with Yes and Cancel option should be popup when click on check box against the follower and also click on the "Remove All" button 
		base.Hover(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		base.buttonClick(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Are you sure you want to remove 1 player?")),"The Remove All button is not visible in the Followers page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--catch","Yes")),"The Yes button is not visible in the Followers page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--cancel","Cancel")),"The Cancel button is not visible in the Followers page");
		Thread.sleep(5000);
		base.buttonClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--cancel","Cancel"));
		
		//For verifying Manager
		
		//Step 6 :Click on the Pencil icon 			
		//Expected : A pencil icon should be displayed to remove followers from the Organization/Team
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil")),"User unable to view the pencil icon to remove followers");
		base.excuteJsClick(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil"));
		Thread.sleep(3000);
		
		//Step 7 : Verify the "Check box"
		//Expected :"Check box" against the name of the followers should be displayed when click on Pencil icon from the Follower's page
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_38_ManagerCheckbox)),"The checkbox is not displayed after clicking the Pencil button in the Followers page.");
		
		//Step 10 : Click on the checkbox of the Manager
		//Expected : User should able to click the check box against the Manager to remove them from Organization/Team
		base.selectCheckBox(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_38_ManagerCheckbox));
		Thread.sleep(3000);
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_38_ManagerCheckbox)).isSelected(),"The checkbox of the manager is not selected in the Followers page.");
		Thread.sleep(3000);

		//Step 11 : Click on 'Remove All' button
		//Expected : The message"Are you sure you want to remove player?" with Yes and Cancel option should be popup when click on check box against the follower and also click on the "Remove All" button 
		base.Hover(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		base.excuteJsClick(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Are you sure you want to remove 1 player?")),"The Remove All button is not visible in the Followers page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--catch","Yes")),"The Yes button is not visible in the Followers page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--cancel","Cancel")),"The Cancel button is not visible in the Followers page");
		Thread.sleep(5000);
	}
	// <summary>
	// Test Case Title :"Verify that the Followers/Managers should removed from the organization when click on YES option from the Popup messge "Are you sure you want to remove player?" 
	// Automation ID   : Follower_39
	// </summary>
	public void Follower_39_AddUpdateRemoveFollower()  throws InterruptedException 
	{   
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		CreateAddNewMemberWithEmail_Obj CreateAddNewMemberWithEmailObj = new CreateAddNewMemberWithEmail_Obj();
	
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_39_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");
		Thread.sleep(5000);
		
		//Step 6 :Click on the Pencil icon 			
		//Expected : A pencil icon should be displayed to remove followers from the Organization/Team
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil")),"User unable to view the pencil icon to remove followers");
		base.excuteJsClick(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil"));
		Thread.sleep(8000);
		
		//Step 7 : Verify the "Check box"
		//Expected :"Check box" against the name of the followers should be displayed when click on Pencil icon from the Follower's page
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_39_FollowerCheckbox)),"The checkbox is not displayed after clicking the Pencil button in the Followers page.");

		//Step 8 :Click on the check box
		//Expected :User should able to click the check box against the followers to remove them from Organization/Team
		base.selectCheckBox(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_39_FollowerCheckbox));
		Thread.sleep(3000);
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_39_FollowerCheckbox)).isSelected(),"The checkbox is not selected in the Followers page.");
		Thread.sleep(3000);

		//Step 9 :Click on 'Remove All' button
		//Expected:The message"Are you sure you want to remove player?" with Yes and Cancel option should be popup when click on check box against the follower and also click on the "Remove All" button 
		base.Hover(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		base.excuteJsClick(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Are you sure you want to remove 1 player?")),"The Remove All button in the Followers page is not clickable");
		
		//Step 10: Click on the 'Yes' button
		//Expected : The Followers/Managers should removed from the organization when click on YES option from the Popup messge "Are you sure you want to remove player?
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--catch","Yes")),"The Yes button is not visible in the Followers page");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--catch","Yes"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK")),"The follower is removed from the 'List of Followers' in the 'Followers' page.");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
		Thread.sleep(8000);
		
		//Step to add the same follower
		base.scrollUp(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		Thread.sleep(3000);
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_39_FollowerEmailAddress);
		base.excuteJsClick(AddFollowerObj.Ele_FollowerTickBtn("bi bi-check2"));
		base.excuteJsClick(AddFollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn"));
		base.excuteJsClick(AddFollowerObj.Btn_FollowersClose("Close"));
		driver.navigate().refresh();
		
		//For removing the user as 'Manager'
		
		//Step 11  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");
		Thread.sleep(5000);
		
		//Step 12 :Click on the Pencil icon 			
		//Expected : A pencil icon should be displayed to remove followers from the Organization/Team
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil")),"User unable to view the pencil icon to remove followers");
		base.excuteJsClick(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil"));
		Thread.sleep(8000);
		
		//Step 13 : Verify the "Check box"
		//Expected :"Check box" against the name of the followers should be displayed when click on Pencil icon from the Follower's page
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_39_ManagerCheckbox)),"The checkbox is not displayed after clicking the Pencil button in the Followers page.");

		//Step 14 :Click on the check box
		//Expected :User should able to click the check box against the followers to remove them from Organization/Team
		base.selectCheckBox(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_39_ManagerCheckbox));
		Thread.sleep(3000);
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_39_ManagerCheckbox)).isSelected(),"The checkbox of the manager is not selected in the Followers page.");
		Thread.sleep(3000);

		//Step 15 :Click on 'Remove All' button
		//Expected:The message"Are you sure you want to remove player?" with Yes and Cancel option should be popup when click on check box against the follower and also click on the "Remove All" button 
		base.Hover(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		base.excuteJsClick(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Are you sure you want to remove 1 player?")),"The Remove All button in the Followers page is not clickable");
		
		//Step 16 : Click on the 'Yes' button
		//Expected : The Followers/Managers should removed from the organization when click on YES option from the Popup messge "Are you sure you want to remove player?
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--catch","Yes")),"The Yes button is not visible in the Followers page");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--catch","Yes"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK")),"The follower is removed from the 'List of Followers' in the 'Followers' page.");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
		Thread.sleep(8000);
		
		//Step to add the same manager
		base.scrollUp(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		base.excuteJsClick(CreateAddNewMemberWithEmailObj.Ele_EditTeam("addFollowerBtn"));
		Thread.sleep(3000);
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), AddFollowerTestData.Follower_39_ManagerEmailAddress);
		base.excuteJsClick(AddFollowerObj.Ele_FollowerTickBtn("bi bi-check2"));
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("createManagerRadioBtnMdl"));
		base.excuteJsClick(AddFollowerObj.Ele_FollowerCreateBtn("addUserdetails","createUserBtn"));
		base.excuteJsClick(AddFollowerObj.Btn_FollowersClose("Close"));
		
	}
	// <summary>
	// Test Case Title :"Verify that the Followers/Managers should not be removed from the organization when click on Cancel option from the Popup messge "Are you sure you want to remove player?" 
	// Automation ID   : Follower_40
	// </summary>
	public void Follower_40_AddUpdateRemoveFollower()  throws InterruptedException 
	{   
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		AddFollower_TestData AddFollowerTestData = new AddFollower_TestData();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();
	
		//Step 1   :"Navigate to the SnipbackWebsite after entering the URL"
		//Expected :"User should able to navigate to the SnipbackWebsite after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User should not be able to navigate to the SnipbackWebsite after entering the URL");

		//Step 2   :"Click on Login Button"
		//Expected :"User should able to click Login Button"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3   :"Click the Film Button"
		//Expected :"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select the organization"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddFollowerTestData.Follower_40_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5  :"Click on Followers tab"
		//Expected :"The user should able to click on Followers tab in the Film page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")), "The user is not able to view the Followers tab in the Film page");
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_Followers("LIST OF FOLLOWERS / MANAGERS")), "The user is not able to click on Followers tab in the Film page");
		Thread.sleep(5000);
		
		//Step 6 :Click on the Pencil icon 			
		//Expected : A pencil icon should be displayed to remove followers from the Organization/Team
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil")),"User unable to view the pencil icon to remove followers");
		base.buttonClick(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil"));
		Thread.sleep(8000);
		
		//Step 7 : Verify the "Check box"
		//Expected :"Check box" against the name of the followers should be displayed when click on Pencil icon from the Follower's page
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_40_FollowerCheckbox)),"The checkbox is not displayed after clicking the Pencil button in the Followers page.");

		//Step 8 :Click on the check box
		//Expected :User should able to click the check box against the followers to remove them from Organization/Team
		base.selectCheckBox(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_40_FollowerCheckbox));
		Thread.sleep(3000);
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_40_FollowerCheckbox)).isSelected(),"The checkbox is not selected in the Followers page.");
		Thread.sleep(3000);

		//Step 9 :Click on 'Remove All' button
		//Expected :The message"Are you sure you want to remove player?" with Yes and Cancel option should be popup when click on check box against the follower and also click on the "Remove All" button 
		base.Hover(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		base.buttonClick(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Are you sure you want to remove 1 player?")),"The Remove All button is not visible in the Followers page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--catch","Yes")),"The Yes button is not visible in the Followers page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--cancel","Cancel")),"The Cancel button is not visible in the Followers page");
		base.buttonClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--cancel","Cancel"));

		base.Hover(SearchGameTeamAndMembersObj.Ele_MemberName(AddFollowerTestData.Follower_40_FollowerEmail));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName(AddFollowerTestData.Follower_40_FollowerEmail)),"The follower is removed from the 'List of Followers' in the 'Followers' page.");

		//For verifying the details of manager
		
		//Step 10 :Click on the Pencil icon 			
		//Expected : A pencil icon should be displayed to remove Followers/Managers from the Organization/Team
		base.scrollUp(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil")),"User unable to view the pencil icon to remove followers");
		base.excuteJsClick(AddFollowerObj.Ele_FollowerPencil("bi bi-pencil"));
		Thread.sleep(8000);
		
		//Step 11 : Verify the "Check box"
		//Expected :"Check box" against the name of the Followers/Managers should be displayed when click on Pencil icon from the Follower's page
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_40_FollowerCheckbox)),"The checkbox is not displayed after clicking the Pencil button in the Followers page.");

		//Step 12 :Click on the check box
		//Expected :User should able to click the check box against the Followers/Managers to remove them from Organization/Team
		base.selectCheckBox(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_40_ManagerCheckbox));
		Thread.sleep(3000);
		asrt.assertTrue(driver.findElement(LoginPageObj.Edt_LoginEmail(AddFollowerTestData.Follower_40_ManagerCheckbox)).isSelected(),"The checkbox is not selected in the Followers page.");
		Thread.sleep(3000);

		//Step 13 :Click on 'Remove All' button
		//Expected :The message"Are you sure you want to remove player?" with Yes and Cancel option should be popup when click on check box against the Followers/Managers and also click on the "Remove All" button 
		base.Hover(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		base.excuteJsClick(AddFollowerObj.Btn_RemoveAll("REMOVE ALL"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Are you sure you want to remove 1 player?")),"The Remove All button is not visible in the Followers page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--catch","Yes")),"The Yes button is not visible in the Followers page");
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--cancel","Cancel")),"The Cancel button is not visible in the Followers page");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--cancel","Cancel"));

		base.Hover(SearchGameTeamAndMembersObj.Ele_MemberName(AddFollowerTestData.Follower_40_ManagerEmail));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName(AddFollowerTestData.Follower_40_ManagerEmail)),"The Manager is removed from the 'List of Followers' in the 'Followers' page.");
	}

}




