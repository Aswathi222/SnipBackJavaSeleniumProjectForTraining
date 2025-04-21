package testPage.MavenPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import TestData.CommonData;
import objectRepository.LoginPage_Obj;
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
}
