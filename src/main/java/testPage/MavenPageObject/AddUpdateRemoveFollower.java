package testPage.MavenPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import TestData.AddUpdateRemoveFollower_TestData;
import TestData.CommonData;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.LoginPage_Obj;
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
		Thread.sleep(1000);
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
		Thread.sleep(1000);
		String Org_name=element.DropDownText(cad_obj.DdlOrg("form-select select-form film-organizations"));
		asrt.assertEquals(Org_name,test_obj.Follower_05_SelectedValue,"User is not able to switch the organisation if they are an Admin or Coach");
				
		//Step4:Click on Followers tab
		//Expected:The user (Admin/Coach) should able to click on Followers tab in the Film page
		base.buttonClick(LoginPageObj.Btn_SingnIn("nav-followers-tab"));
		asrt.assertTrue(base.isExists(Sch_Obj.Ele_CreateGameFor("LIST OF FOLLOWERS / MANAGERS")),"The user (Admin/Coach) is unable to click on Followers tab in the Film page");	
	}
}
