package testPage.MavenPageObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.AddUpdateRemoveFollower_TestData;
import TestData.CommonData;
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
		for (Object[] assertion : assertions) {
		    By element = (By) assertion[0];  
		    String errorMessage = (String) assertion[1];  
		    asrt.assertTrue(base.isExists(element), errorMessage); 
		}	
	}
}
