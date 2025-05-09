package testPage.MavenPageObject;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.AddUpdateRemoveFollower_TestData;
import TestData.CommonData;
import objectRepository.AddUpdateDeleteDuplicateTeamGameDefaults_Obj;
import objectRepository.AddUpdateRemoveFollower_Obj;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;
public class AddUpdateRemoveFollower extends BasePge{

	BasePge base;
	Assert asrt;
	ElementActions element;
	
	public AddUpdateRemoveFollower(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
		element=new ElementActions(driver);
	}
	
	// <summary>
	// Test Case Title : "Verify that user should able to navigate to the Snipback Website after entering the URL"
	// Automation ID : Follower_01
	// </summary>
	public void Follower_01_AddUpdateRemoveFollower() 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
	}
	
	// <summary>
	// Test Case Title : "Verify that user should able to navigate to the Film page once login with credentials"
	// Automation ID : Follower_02
	// </summary>
	public void Follower_02_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		
		//Step2:Click on the Login button, enter valid Email ID and Password, and click on the Sign In button.
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
	}
	// <summary>
	// Test Case Title : "Verify that Followers tab should be displayed in the organization if the user as Admin/Coach in the Film page"
	// Automation ID : Follower_03
	// </summary>
	public void Follower_03_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
		
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_03_SelectedValue);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_03_SelectedValue,"User is not able to switch the organisation if they are an Admin or Coach");
		
		//Step4:Verify the Followers tab
		//Expected:Followers tab should be displayed in the organization if the user as Admin/Coach in the Film page
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-followers-tab")),"User is not able to view the followers tab if the user as Admin/Coach in the Film page");
	}
	// <summary>
	// Test Case Title : "Verify that Followers tab should  be disabled in Home organization and in the Organization if the User as Player/Followers in the Film page"
	// Automation ID : Follower_04
	// </summary>
	public void Follower_04_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
		
		//Step3:Switch the organization if the User as Player/Follower 
		//Expected:User should be able to switch the organization if they are Player/Follower 
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_04_SelectedValue);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_04_SelectedValue,"User is not able to switch the organisation if they are Player/Follower");
		
		//Step4:Verify the Followers tab should  be disabled in Home organization and in the Organization if the User as Player/Follower in the Film page
		//Expected:Followers tab should  be disabled in Home organization and in the Organization if the User as Player/Follower in the Film page
		asrt.assertTrue(element.isDisabledBy(LoginPageObj.Btn_SingnIn("nav-followers-tab")),"Followers tab is not disabled in Home organization and in the Organization if the user as Player/Follower in the Film page");
	}
	// <summary>
	// Test Case Title : "Verify that user (Admin/Coach) should able to click on Followers tab in the Film page"
	// Automation ID : Follower_05
	// </summary>
	public void Follower_05_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
		
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_05_SelectedValue);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_05_SelectedValue,"User is not able to switch the organisation if they are an Admin or Coach");
				
		//Step4:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");	
	}
	// <summary>
	// Test Case Title : "Verify that a Search bar should be displayed in the Followers page to search Followers & proper results should be displayed based on the search"
	// Automation ID : Follower_06
	// </summary>
	public void Follower_06_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
		
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_05_SelectedValue);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_05_SelectedValue,"User is not able to switch the organisation if they are an Admin or Coach");
				
		//Step4:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
		
		//Step5:Verify that a Search bar should be displayed in the Followers page.
		//Expected:Search bar should be displayed in the Followers page
		asrt.assertTrue(base .isExists(LoginPageObj.Edt_LoginEmail("teamGroupMembers")),"User is not able to see the Seach bar on the Followers Page");
		
		//Step6:Search any data in the Search tab and verify the results
		//Expected:Proper Results should be displayed based on the search
		base.setData(LoginPageObj.Edt_LoginEmail("teamGroupMembers"),test_obj.Follower_06_SelectedValue);
		base.pressKey(null,"KEYBOARD_ENTER" );
		Thread.sleep(5000);
		String follow_searchName=base.GetValue(LoginPageObj.Edt_LoginEmail("teamGroupMembers"));
		asrt.assertEquals(follow_searchName,test_obj.Follower_06_SelectedValue,"User is not able to see the proper results based on the search");
	}
	// <summary>
	// Test Case Title : "Verify that user (Admin/Coach) should able to view the list of Followers after clicking the Follower tab in the Film page"
	// Automation ID : Follower_07
	// </summary>
	public void Follower_07_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		AddUpdateRemoveFollower_Obj Follower_Obj=new AddUpdateRemoveFollower_Obj();
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
		
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_07_SelectedValue);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_07_SelectedValue,"User is not able to switch the organisation if they are an Admin or Coach");
				
		//Step4:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
		
		//Step5:Verify that user (Admin/Coach) should able to view the list of Followers after clicking the Follower tab in the Film page
		//Expected:The user (Admin/Coach) should able to view the list of Followers after clicking the Follower tab in the Film page
		List<WebElement> user_list=base.GetElement(Follower_Obj.Ele_Follower("teamRole"));
		asrt.assertTrue(!user_list.isEmpty(),"User (Admin/Coach) is not  able to view the list of Followers after clicking the Follower tab in the Film page");
	}
	// <summary>
	// Test Case Title : "Verify that an option for add followers (+Followers ) should be displayed in the Followers tab under Film page"
	// Automation ID : Follower_08
	// </summary>
	public void Follower_08_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
		
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
		
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_07_SelectedValue);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_07_SelectedValue,"User is not able to switch the organisation if they are an Admin or Coach");
				
		//Step4:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
		
		//Step5:Verify that an option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		//Expected:An option for add followers (+Followers ) should be displayed in the Followers tab under Film page
		asrt.assertTrue(base.isExists(register_obj.Btn_ResendOTP("addFollowerBtn")),"User is not able to see an option for add followers (+Followers ) in the Followers tab under Film page");	
	}
	// <summary>
	// Test Case Title : "Verify that the following option should be displayed in the page for adding followers after clicking +Followers option;
    //1.Main Heading- CREATE NEW USER
    //2.Sub heading- Add Email ID
    //3.Text field for Entering the Email ID
    //4.X mark and tick mark against the field for entering the email ID"
	// Automation ID : Follower_09
	// </summary>
	public void Follower_09_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
		AddUpdateRemoveFollower_Obj follower_obj=new AddUpdateRemoveFollower_Obj();
		CreateEditDeletePool_Obj pool_obj=new CreateEditDeletePool_Obj();
		
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
		
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_07_SelectedValue);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_07_SelectedValue,"User is not able to switch the organisation if they are an Admin or Coach");
				
		//Step4:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
		
		//Step5:Click on +Followers option
		//Expected:The following options should be displayed in the page for adding followers after clicking +Followers option;
		//1.Main Heading- CREATE NEW USER
	    //2.Sub heading- Add Email ID
	    //3.Text field for Entering the Email ID
	    //4.X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		List<Object[]> assertions = new ArrayList<>();
		assertions.add(new Object[] {follower_obj.Ele_CreateNewUser("modal-content create_newuser", "CREATE NEW USER"), "User is not able to see Main Heading 'CREATE NEW USER' after clicking +Followers option"});
		assertions.add(new Object[] {pool_obj.Ele_PoolType("modal follower show", "Add Email Address"), "User is not able to see Sub Heading 'Add Email ID' after clicking +Followers option"});
		assertions.add(new Object[] {LoginPageObj.Edt_LoginEmail("emailInput"), "User is not able to see Text field for entering the Email ID after clicking +Followers option"});
		assertions.add(new Object[] {follower_obj.Btn_TickIcon("checkMail();", "bi bi-check2"), "User is not able to see tick mark against the field for entering the email ID after clicking +Followers option"});
		assertions.add(new Object[] {follower_obj.Btn_CrossIcon("btn btn-danger", "bi bi-x"), "User is not able to see X mark against the field for entering the email ID after clicking +Followers option"});
		element.verifyElementsExist(base, assertions);	
	}
	// <summary>
	// Test Case Title : "Verify that add followers option should be displayed in Individuals teams as well"
	// Automation ID : Follower_10
	// </summary>
	public void Follower_10_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
				
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_10_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_10_SelectedValue1,"User is not able to switch the organisation if they are an Admin or Coach");
				
		//Step4:Select any team
		//Expected:User should be able to select any team after switching organisation
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),test_obj.Follower_10_SelectedValue);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"),"KEYBOARD_ENTER" );
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage(test_obj.Follower_10_SelectedValue));
		String TeamName=base.GetValue(LoginPageObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(TeamName,test_obj.Follower_10_SelectedValue,"User is not able to select any team after switching organisation");
				
		//Step5:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step6:Verify that add followers option should be displayed in Individuals teams as well
		//Expected:Add followers option should be displayed in Individuals teams as well
		asrt.assertTrue(base.isExists(register_obj.Btn_ResendOTP("addFollowerBtn")),"User is not able to see an option for add followers (+Followers ) for individual teams as well ");	
	}
	// <summary>
	// Test Case Title : "Verify that the list of similar email id (Email id of users already in any organization/team) should displayed when we try to add the users as followers using that email id"
	// Automation ID : Follower_11
	// </summary>
	public void Follower_11_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
				
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_10_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_11_SelectedValue1,"User is not able to switch the organisation if they are an Admin or Coach");
						
		//Step4:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step5:Click on +Followers option
		//Expected:User should be able to see the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"User is not able to see Text field for entering the Email ID after clicking +Followers option");
			
		//Step6:Enter the users's email id
		//Expected:The list of similar email ids (Email id of users already in any organization/team) should be displayed when we try to add the users as followers using that email id
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), test_obj.Follower_11_SelectedValue);
		String value=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		asrt.assertEquals(value, test_obj.Follower_11_SelectedValue,"User is not able to enter the EmailID");
		asrt.assertTrue(base.isExists(register_obj.Btn_Login("ui-corner-all",test_obj.Follower_11_SelectedValue)),"User is not able to view the list of similar email ids (Email id of users already in any organization/team) when we try to add the users as followers using that email id");
	}
	// <summary>
	// Test Case Title : "Verify that No Data Found message should displayed if we use the new emaild to add as follower"
	// Automation ID : Follower_12
	// </summary>
	public void Follower_12_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
				
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_10_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_12_SelectedValue2,"User is not able to switch the organisation if they are an Admin or Coach");
						
		//Step4:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		//asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step5:Click on +Followers option
		//Expected:User should be able to see the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"User is not able to see Text field for entering the Email ID after clicking +Followers option");
			
		//Step6:Enter the new email id
		//Expected:No Data Found message should displayed if we use the new emaild to add as follower
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), test_obj.Follower_12_SelectedValue);
        String value=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		asrt.assertEquals(value, test_obj.Follower_12_SelectedValue,"User is not able to enter the EmailID"); 
		asrt.assertTrue(base.isExists(register_obj.Btn_Login("ui-corner-all",test_obj.Follower_12_SelectedValue1)),"User is not able to see the message 'No Data Found' when trying to add a new email ID as a follower");
	}
	// <summary>
	// Test Case Title : "Verify that the page for entering the details of followers should be displayed when clicking on the tick button after entering the email id"
	// Automation ID : Follower_13
	// </summary>
	public void Follower_13_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
		AddUpdateRemoveFollower_Obj follower_obj=new AddUpdateRemoveFollower_Obj();
				
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_13_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_13_SelectedValue1,"User is not able to switch the organisation if they are an Admin or Coach");
						
		//Step4:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step5:Click on +Followers option
		//Expected:User should be able to see the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"User is not able to see Text field for entering the Email ID after clicking +Followers option");
			
		//Step6:Enter the users's email id
		//Expected:The list of similar email ids (Email id of users already in any organization/team) should be displayed when we try to add the users as followers using that email id
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), test_obj.Follower_13_SelectedValue);
		asrt.assertTrue(base.isExists(register_obj.Btn_Login("ui-corner-all",test_obj.Follower_13_SelectedValue)),"User is not able to view the list of similar email ids (Email id of users already in any organization/team) when we try to add the users as followers using that email id");
		
		//Step7:Click on tick option
		//Expected:The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id
		base.buttonClick(follower_obj.Btn_TickIcon("checkMail();", "bi bi-check2"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("firstname")),"The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");
	}
	// <summary>
	// Test Case Title : "Verify that the entered email should be cleared once we click on X button"
	// Automation ID : Follower_14
	// </summary>
	public void Follower_14_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
		AddUpdateRemoveFollower_Obj follower_obj=new AddUpdateRemoveFollower_Obj();
				
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_10_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_14_SelectedValue1,"User is not able to switch the organisation if they are an Admin or Coach");
						
		//Step4:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		//asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step5:Click on +Followers option
		//Expected:User should be able to see the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"User is not able to see Text field for entering the Email ID after clicking +Followers option");
		
		//Step6:Enter the users's email id
		//Expected:The list of similar email ids (Email id of users already in any organization/team) should be displayed when we try to add the users as followers using that email id
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), test_obj.Follower_14_SelectedValue);
		asrt.assertTrue(base.isExists(register_obj.Btn_Login("ui-corner-all",test_obj.Follower_14_SelectedValue)),"User is not able to view the list of similar email ids (Email id of users already in any organization/team) when we try to add the users as followers using that email id");
		
		//Step7:Click on X button
		//Expected:The entered email should be cleared once we click on X button
		base.buttonClick(follower_obj.Btn_CrossIcon("btn btn-danger", "bi bi-x"));
		String Email = base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		asrt.assertEquals(Email, "", "User is not able to clear the entered email after clicking on X button");	
	}
	// <summary>
	// Test Case Title :Verify that the following option should be displayed when clicking on the tick button after entering the email id;
    //1.First Name (Mandatory)
    //2.Last Name (Optional)
    //3.Team Name
    //4.Jersey number (#)
    //5.The text Send a message along with notification email 
    //6.Field for adding message
    //7.Add as Player/users Organization button
	// Automation ID : Follower_15
	// </summary>
	public void Follower_15_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
		AddUpdateRemoveFollower_Obj follower_obj=new AddUpdateRemoveFollower_Obj();
		CreateEditDeletePool_Obj ced_obj=new CreateEditDeletePool_Obj();
				
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_10_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_15_SelectedValue1,"User is not able to switch the organisation if they are an Admin or Coach");
						
		//Step4:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step5:Click on +Followers option
		//Expected:User should be able to see the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"User is not able to see Text field for entering the Email ID after clicking +Followers option");
			
		//Step6:Enter the users's email id
		//Expected:The list of similar email ids (Email id of users already in any organization/team) should be displayed when we try to add the users as followers using that email id
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), test_obj.Follower_15_SelectedValue);
		asrt.assertTrue(base.isExists(register_obj.Btn_Login("ui-corner-all",test_obj.Follower_15_SelectedValue)),"User is not able to view the list of similar email ids (Email id of users already in any organization/team) when we try to add the users as followers using that email id");
		
		//Step7:Click on tick option
		//Expected:The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id
		base.buttonClick(follower_obj.Btn_TickIcon("checkMail();", "bi bi-check2"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("firstname")),"The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");
		
		//Step8:Verify that the following options(First Name (Mandatory),Last Name (Optional)Team Name,Jersey number (#),The text Send a message along with notification email ,Field for adding message,Add as Player/users Organization button) should be displayed when clicking on the tick button after entering the email id
		//Expected:The following options(First Name (Mandatory),Last Name (Optional)Team Name,Jersey number (#),The text Send a message along with notification email ,Field for adding message,Add as Player/users Organization button) should be displayed when clicking on the tick button after entering the email id
		List<Object[]> assertions = new ArrayList<>();
        assertions.add(new Object[] {
		    LoginPageObj.Edt_LoginEmail("firstname"),
		    "User is not able to see the 'First Name' (Mandatory) field after clicking the tick button upon entering the email ID"});
        assertions.add(new Object[] {
		    LoginPageObj.Edt_LoginEmail("lastname"),
		    "User is not able to see the 'Last Name' (Optional) field after clicking the tick button upon entering the email ID"});
		assertions.add(new Object[] {
		    follower_obj.Ele_SelectText("modal follower show", "Select"),
		    "User is not able to see the 'Team Name' field after clicking the tick button upon entering the email ID"});
		assertions.add(new Object[] {
		    LoginPageObj.Edt_LoginEmail("jerseyNumber"),
		    "User is not able to see the 'Jersey Number (#)' field after clicking the tick button upon entering the email ID"});
		assertions.add(new Object[] {
		    ced_obj.Ele_PoolType("modal follower show", "Send a message along with notification email."),
		    "User is not able to see the text 'Send a message along with notification email' after clicking the tick button upon entering the email ID"});
		assertions.add(new Object[] {
		    follower_obj.Ele_TextArea("modal follower show", "form-control"),
		    "User is not able to see the field for adding a message after clicking the tick button upon entering the email ID"});
		assertions.add(new Object[] {
		    follower_obj.Btn_AddPlayer("modal follower show", "ADD AS PLAYER / USER TO ORGANIZATION"),
		    "User is not able to see the 'Add as Player/User to Organization' button after clicking the tick button upon entering the email ID"});
		element.verifyElementsExist(base, assertions);
	}
	// <summary>
	// Test Case Title : "Verify that there should not be any restriction to add same email ld  in different teams as followers"
	// Automation ID : Follower_17
	// </summary>
	public void Follower_17_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
		AddUpdateRemoveFollower_Obj follower_obj=new AddUpdateRemoveFollower_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj del_obj=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
				
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_10_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_17_SelectedValue1,"User is not able to switch the organisation if they are an Admin or Coach");
		
		//Step4:Select any team
		//Expected:User should be able to select any team after switching organisation
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),test_obj.Follower_17_SelectedValue2);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"),"KEYBOARD_ENTER" );
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage(test_obj.Follower_17_SelectedValue2));
		String TeamName=base.GetValue(LoginPageObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(TeamName,test_obj.Follower_17_SelectedValue2,"User is not able to select any team after switching organisation");
						
		//Step5:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step6:Click on +Followers option
		//Expected:User should be able to see the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"User is not able to see Text field for entering the Email ID after clicking +Followers option");
			
		//Step7:Enter the existing mail 
		//Expected:User should be able to enter the EmailID
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), test_obj.Follower_17_SelectedValue3);
		String value=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		asrt.assertEquals(value, test_obj.Follower_17_SelectedValue3,"User is not able to enter the EmailID");
		
		//Step8:Click on tick option
		//Expected:The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id
		base.buttonClick(follower_obj.Btn_TickIcon("checkMail();", "bi bi-check2"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("firstname")),"The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");
		
		//Step9:Click on Add Players/Users To Organization
		//Expected:There should not be any restriction to add same email ld  in different teams as followers
		base.buttonClick(follower_obj.Btn_AddPlayer("modal follower show", "ADD AS PLAYER / USER TO ORGANIZATION"));
		asrt.assertTrue(base.isExists(del_obj.Ele_Message("Record Updated Successfully")),"User is unable to add same email id in different teams as followers");
		
		//Step10:Remove Followers once automation completed(Optional)
		//Expected:User should be able to remove the added follower after automation
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("modalMessageCloseBtn"));
		base.buttonClick(follower_obj.Btn_FollowersEdit("nav-followers","bi bi-pencil"));
		base.excuteJsClick(follower_obj.Chk_FollowerSelect(test_obj.Follower_17_SelectedValue,"checkbox"));
		base.excuteJsClick(follower_obj.Btn_AddPlayer("col-sm-12 followers_totallist","REMOVE ALL"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Done!")),"User is not able to remove the added follower after automation");		
}
	// <summary>
	// Test Case Title : "Verify that proper message " First name is required" should be displayed if leaving the First name field empty and Click on Add Players/Users To Organization"
	// Automation ID : Follower_18
	// </summary>
	public void Follower_18_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
		AddUpdateRemoveFollower_Obj follower_obj=new AddUpdateRemoveFollower_Obj();
			
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_18_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_18_SelectedValue1,"User is not able to switch the organisation if they are an Admin or Coach");
		
		//Step4:Select any team
		//Expected:User should be able to select any team after switching organisation
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),test_obj.Follower_18_SelectedValue);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"),"KEYBOARD_ENTER" );
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage(test_obj.Follower_18_SelectedValue));
		String TeamName=base.GetValue(LoginPageObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(TeamName,test_obj.Follower_18_SelectedValue,"User is not able to select any team after switching organisation");
						
		//Step5:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step6:Click on +Followers option
		//Expected:User should be able to see the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"User is not able to see Text field for entering the Email ID after clicking +Followers option");
			
		//Step7:Enter the  mail 
		//Expected:User should be able to enter the EmailID
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), test_obj.Follower_18_SelectedValue2);
		String value=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		asrt.assertEquals(value, test_obj.Follower_18_SelectedValue2,"User is not able to enter the EmailID");
		
		//Step8:Click on tick option
		//Expected:The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id
		base.buttonClick(follower_obj.Btn_TickIcon("checkMail();", "bi bi-check2"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("firstname")),"The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");
		
		//Step9:Click on Add Players/Users To Organization
		//Expected: Proper message " First name is required" should be displayed if leaving the First name field empty and Click on Add Players/Users To Organization
		base.clearData(LoginPageObj.Edt_LoginEmail("firstname"));
		base.buttonClick(follower_obj.Btn_AddPlayer("modal follower show", "ADD AS PLAYER / USER TO ORGANIZATION"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Firstname is required")),"User is not able to see the proper message 'First name is required' when leaving the First Name field empty and clicking on 'Add Players/Users To Organization'");		
}
	// <summary>
	// Test Case Title : "Verify that the user should able to Enter the Jersey number in the Jersey number field and also  has a up and down arrow to enter the jersey number"
	// Automation ID : Follower_19
	// </summary>
	public void Follower_19_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
		AddUpdateRemoveFollower_Obj follower_obj=new AddUpdateRemoveFollower_Obj();
			
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_19_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_19_SelectedValue1,"User is not able to switch the organisation if they are an Admin or Coach");
		
		//Step4:Select any team
		//Expected:User should be able to select any team after switching organisation
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),test_obj.Follower_19_SelectedValue);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"),"KEYBOARD_ENTER" );
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage(test_obj.Follower_19_SelectedValue));
		String TeamName=base.GetValue(LoginPageObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(TeamName,test_obj.Follower_19_SelectedValue,"User is not able to select any team after switching organisation");
						
		//Step5:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step6:Click on +Followers option
		//Expected:User should be able to see the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"User is not able to see Text field for entering the Email ID after clicking +Followers option");
			
		//Step7:Enter the  mail 
		//Expected:User should be able to enter the EmailID
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), test_obj.Follower_19_SelectedValue2);
		String value=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		asrt.assertEquals(value, test_obj.Follower_19_SelectedValue2,"User is not able to enter the EmailID");
		
		//Step8:Click on tick option
		//Expected:The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id
		base.buttonClick(follower_obj.Btn_TickIcon("checkMail();", "bi bi-check2"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("firstname")),"The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");
		
		//Step9:Verify should be able to enter  jersey number in the Jersey number field
		//Expected:User should be be able to enter jersey number in the Jersey number field
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), test_obj.Follower_19_SelectedValue3);
		String jerseynum=base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertEquals(jerseynum, test_obj.Follower_19_SelectedValue3,"User is not able to enter the Jerseynumber in the Jersey number field");
		
		//Step10:Verify user  has a UP and DOWN arrow to enter jersey number in the jersey number field
		//Expected:User should be able to enter jersey number in the jersey number field by using the up and down arrow
		
		base.pressKey(LoginPageObj.Edt_LoginEmail("jerseyNumber"), "ARROW_UP");
		String jerseynum_UP=base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertEquals(jerseynum_UP, test_obj.Follower_19_SelectedValue4,"User is not able to enter the Jerseynumber in the Jersey number field using the UP arrow");
		base.pressKey(LoginPageObj.Edt_LoginEmail("jerseyNumber"), "ARROW_DOWN");
		String jerseynum_DOWN=base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertEquals(jerseynum_DOWN, test_obj.Follower_19_SelectedValue3,"User is not able to enter the Jerseynumber in the Jersey number field using the DOWN arrow");			
}
	// <summary>
	// Test Case Title : "Verify that the user should able to Enter the Jersey number between 1 to 999 in the Jersey number field"
	// Automation ID : Follower_20
	// </summary>
	public void Follower_20_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
		AddUpdateRemoveFollower_Obj follower_obj=new AddUpdateRemoveFollower_Obj();
			
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_20_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_20_SelectedValue1,"User is not able to switch the organisation if they are an Admin or Coach");
		
		//Step4:Select any team
		//Expected:User should be able to select any team after switching organisation
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),test_obj.Follower_20_SelectedValue);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"),"KEYBOARD_ENTER" );
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage(test_obj.Follower_20_SelectedValue));
		String TeamName=base.GetValue(LoginPageObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(TeamName,test_obj.Follower_20_SelectedValue,"User is not able to select any team after switching organisation");
						
		//Step5:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step6:Click on +Followers option
		//Expected:User should be able to see the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"User is not able to see Text field for entering the Email ID after clicking +Followers option");
			
		//Step7:Enter the  mail 
		//Expected:User should be able to enter the EmailID
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), test_obj.Follower_20_SelectedValue2);
		String value=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		asrt.assertEquals(value, test_obj.Follower_20_SelectedValue2,"User is not able to enter the EmailID");
		
		//Step8:Click on tick option
		//Expected:The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id
		base.buttonClick(follower_obj.Btn_TickIcon("checkMail();", "bi bi-check2"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("firstname")),"The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");
		
		//Step9:Verify that the user should able to Enter the Jersey number between 1 to 999 in the Jersey number field
		//Expected:User should be be able to enter the Jersey number between 1 to 999 in the Jersey number field
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), test_obj.Follower_20_SelectedValue3);
		String jerseynum=base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertEquals(jerseynum, test_obj.Follower_20_SelectedValue3,"User is not able to enter the Jerseynumber between 1 to 999 in the Jersey number field");				
}
	// <summary>
	// Test Case Title : "Verify that  4 digit numeric should not be as Jersey number"
	// Automation ID : Follower_21
	// </summary>
	public void Follower_21_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
		AddUpdateRemoveFollower_Obj follower_obj=new AddUpdateRemoveFollower_Obj();
			
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_21_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_21_SelectedValue1,"User is not able to switch the organisation if they are an Admin or Coach");
		
		//Step4:Select any team
		//Expected:User should be able to select any team after switching organisation
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),test_obj.Follower_21_SelectedValue);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"),"KEYBOARD_ENTER" );
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage(test_obj.Follower_21_SelectedValue));
		String TeamName=base.GetValue(LoginPageObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(TeamName,test_obj.Follower_21_SelectedValue,"User is not able to select any team after switching organisation");
						
		//Step5:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step6:Click on +Followers option
		//Expected:User should be able to see the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"User is not able to see Text field for entering the Email ID after clicking +Followers option");
			
		//Step7:Enter the  mail 
		//Expected:User should be able to enter the EmailID
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), test_obj.Follower_21_SelectedValue2);
		String value=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		asrt.assertEquals(value, test_obj.Follower_21_SelectedValue2,"User is not able to enter the EmailID");
		
		//Step8:Click on tick option
		//Expected:The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id
		base.buttonClick(follower_obj.Btn_TickIcon("checkMail();", "bi bi-check2"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("firstname")),"The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");
		
		//Step9:Verify that  4 digit numeric should not be as Jersey number
		//Expected:User should not  be be able to enter 4 digit numeric as the Jersey number 
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), test_obj.Follower_21_SelectedValue3);
		String jerseynum=base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertNotEquals(jerseynum, test_obj.Follower_21_SelectedValue3,"User is able to enter 4 digit numeric as the Jersey number ");				
}
	// <summary>
	// Test Case Title : "Verify that the user should added as Follower to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization"
	// Automation ID : Follower_22
	// </summary>
	public void Follower_22_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
		AddUpdateRemoveFollower_Obj follower_obj=new AddUpdateRemoveFollower_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj del_obj=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_22_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_22_SelectedValue1,"User is not able to switch the organisation if they are an Admin or Coach");
		
		//Step4:Select any team
		//Expected:User should be able to select any team after switching organisation
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),test_obj.Follower_22_SelectedValue);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"),"KEYBOARD_ENTER" );
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage(test_obj.Follower_22_SelectedValue));
		String TeamName=base.GetValue(LoginPageObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(TeamName,test_obj.Follower_22_SelectedValue,"User is not able to select any team after switching organisation");
						
		//Step5:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step6:Click on +Followers option
		//Expected:User should be able to see the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"User is not able to see Text field for entering the Email ID after clicking +Followers option");
			
		//Step7:Enter the  mail 
		//Expected:User should be able to enter the EmailID
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), test_obj.Follower_22_SelectedValue2);
		String value=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		asrt.assertEquals(value, test_obj.Follower_22_SelectedValue2,"User is not able to enter the EmailID");
		
		//Step8:Click on tick option
		//Expected:The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id
		base.buttonClick(follower_obj.Btn_TickIcon("checkMail();", "bi bi-check2"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("firstname")),"The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");
		
		//Step 9 : Enter the Jersey number in the Jersey number field 
		//Expected :The user should able to Enter the Jersey number in the Jersey number field 
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), test_obj.Follower_22_SelectedValue3);
		String jerseynum=base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertEquals(jerseynum, test_obj.Follower_22_SelectedValue3,"User is not able to enter the Jerseynumber in the Jersey number field");
		
		//Step10:Enter a message to be send along with notification email   
		//Expected:User should be able to enter a message to be sent along with notification email
		base.setData(follower_obj.Ele_TextArea2("modal follower show","form-floating","playerCreateMessage"),test_obj.Follower_22_SelectedValue4);
		String textValue=base.GetValue(follower_obj.Ele_TextArea2("modal follower show","form-floating","playerCreateMessage"));
		asrt.assertEquals(textValue,test_obj.Follower_22_SelectedValue4,"User is not able to enter a message to be sent along with notification email");
		
		//Step11:Click on Add Players/Users To Organization
		//Expected:User should added as follower to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization
		//base.scrollToElement(follower_obj.Btn_AddPlayer("modal follower show", "ADD AS PLAYER / USER TO ORGANIZATION"));
		base.excuteJsClick(follower_obj.Btn_AddPlayer("modal follower show", "ADD AS PLAYER / USER TO ORGANIZATION"));
		asrt.assertTrue(base.isExists(del_obj.Ele_Message("Record Updated Successfully")),"The user is not added as follower to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization");
		
		//Step12:Remove Followers once automation completed(Optional)
		//Expected:User should be able to remove the added follower after automation
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("modalMessageCloseBtn"));
		base.buttonClick(follower_obj.Btn_FollowersEdit("nav-followers","bi bi-pencil"));
		base.excuteJsClick(follower_obj.Chk_FollowerSelect(test_obj.Follower_22_SelectedValue5,"checkbox"));
		base.excuteJsClick(follower_obj.Btn_AddPlayer("col-sm-12 followers_totallist","REMOVE ALL"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Done!")),"User is not able to remove the added follower after automation");				
}
	// <summary>
	// Test Case Title : "Verify that the newly added user as Follower to the organization/team should be displayed in the Followers list in Followers tab under Film Page"
	// Automation ID : Follower_23
	// </summary>
	public void Follower_23_AddUpdateRemoveFollower() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Login login = new Login(driver);
		CreateAndAddNewMemberWithOrWithoutEmail_Obj cad_obj=new CreateAndAddNewMemberWithOrWithoutEmail_Obj();
		AddUpdateRemoveFollower_TestData test_obj=new AddUpdateRemoveFollower_TestData();
		ScheduleUnscheduleGames_Obj Sch_Obj =new ScheduleUnscheduleGames_Obj();
		Registration_Obj register_obj=new Registration_Obj();
		AddUpdateRemoveFollower_Obj follower_obj=new AddUpdateRemoveFollower_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_Obj del_obj=new AddUpdateDeleteDuplicateTeamGameDefaults_Obj();
			
		// Step1: Enter the URL
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Login Snipback
		//Expected:User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName,CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");	
				
		//Step3:Switch the organization if the User as Admin/Coach
		//Expected:User should be able to switch the organization if they are an Admin or Coach
		base.selectorByVisibleText(cad_obj.DdlOrg("form-select select-form film-organizations"),test_obj.Follower_23_SelectedValue1);
		Thread.sleep(5000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_23_SelectedValue1,"User is not able to switch the organisation if they are an Admin or Coach");
		
		//Step4:Select any team
		//Expected:User should be able to select any team after switching organisation
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"),test_obj.Follower_23_SelectedValue);
		base.pressKey(LoginPageObj.Edt_LoginEmail("searchTeam"),"KEYBOARD_ENTER" );
		Thread.sleep(2000);
		base.excuteJsClick(LoginPageObj.Edt_AlertMessage(test_obj.Follower_23_SelectedValue));
		String TeamName=base.GetValue(LoginPageObj.Edt_LoginEmail("searchTeam"));
		asrt.assertEquals(TeamName,test_obj.Follower_23_SelectedValue,"User is not able to select any team after switching organisation");
						
		//Step5:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");
				
		//Step6:Click on +Followers option
		//Expected:User should be able to see the Main Heading- CREATE NEW USER,Sub heading- Add Email ID,Text field for Entering the Email ID, X mark and tick mark against the field for entering the email ID
		base.buttonClick(register_obj.Btn_ResendOTP("addFollowerBtn"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("emailInput")),"User is not able to see Text field for entering the Email ID after clicking +Followers option");
			
		//Step7:Enter the  mail 
		//Expected:User should be able to enter the EmailID
		base.setData(LoginPageObj.Edt_LoginEmail("emailInput"), test_obj.Follower_23_SelectedValue2);
		String value=base.GetValue(LoginPageObj.Edt_LoginEmail("emailInput"));
		asrt.assertEquals(value, test_obj.Follower_23_SelectedValue2,"User is not able to enter the EmailID");
		
		//Step8:Click on tick option
		//Expected:The page for entering the details of followers should be displayed when clicking on the tick option after entering the email id
		base.buttonClick(follower_obj.Btn_TickIcon("checkMail();", "bi bi-check2"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("firstname")),"The page for entering the details of followers is not displayed when clicking on the tick option after entering the email id");
		
		//Step 9 : Enter the Jersey number in the Jersey number field 
		//Expected :The user should able to Enter the Jersey number in the Jersey number field 
		base.setData(LoginPageObj.Edt_LoginEmail("jerseyNumber"), test_obj.Follower_23_SelectedValue3);
		String jerseynum=base.GetValue(LoginPageObj.Edt_LoginEmail("jerseyNumber"));
		asrt.assertEquals(jerseynum, test_obj.Follower_23_SelectedValue3,"User is not able to enter the Jerseynumber in the Jersey number field");
		
		//Step10:Enter a message to be send along with notification email   
		//Expected:User should be able to enter a message to be sent along with notification email
		base.setData(follower_obj.Ele_TextArea2("modal follower show","form-floating","playerCreateMessage"),test_obj.Follower_23_SelectedValue4);
		String textValue=base.GetValue(follower_obj.Ele_TextArea2("modal follower show","form-floating","playerCreateMessage"));
		asrt.assertEquals(textValue,test_obj.Follower_23_SelectedValue4,"User is not able to enter a message to be sent along with notification email");
		
		//Step11:Click on Add Players/Users To Organization
		//Expected:User should added as follower to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization
		//base.scrollToElement(follower_obj.Btn_AddPlayer("modal follower show", "ADD AS PLAYER / USER TO ORGANIZATION"));
		base.excuteJsClick(follower_obj.Btn_AddPlayer("modal follower show", "ADD AS PLAYER / USER TO ORGANIZATION"));
		asrt.assertTrue(base.isExists(del_obj.Ele_Message("Record Updated Successfully")),"The user is not added as follower to the organization/team after entering all the required information in the page  and Click on Add Players/Users To Organization");
		
		//Step12:Click on Close Button
		//Expected:The newly added user as Follower to the organization/team should be displayed in the Followers list in Followers tab under Film Page
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("modalMessageCloseBtn"));
		asrt.assertTrue(base.isExists(del_obj.Ele_Message(test_obj.Follower_23_SelectedValue2)),"The newly added user as Follower to the organization/team is not displayed in the Followers list in Followers tab under Film Page");
		
		//Step12:Remove Followers once automation completed(Optional)
		//Expected:User should be able to remove the added follower after automation
		base.buttonClick(follower_obj.Btn_FollowersEdit("nav-followers","bi bi-pencil"));
		base.excuteJsClick(follower_obj.Chk_FollowerSelect(test_obj.Follower_23_SelectedValue5,"checkbox"));
		base.excuteJsClick(follower_obj.Btn_AddPlayer("col-sm-12 followers_totallist","REMOVE ALL"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("OK"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Done!")),"User is not able to remove the added follower after automation");				
}
	
}
