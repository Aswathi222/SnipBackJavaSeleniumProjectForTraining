package testPage.MavenPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
}
