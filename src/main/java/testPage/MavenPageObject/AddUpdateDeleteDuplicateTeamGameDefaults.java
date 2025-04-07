package testPage.MavenPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import objectRepository.LoginPage_Obj;
import utilPack.BasePge;

public class AddUpdateDeleteDuplicateTeamGameDefaults  extends BasePge{

	BasePge base;
	Assert asrt;

	public AddUpdateDeleteDuplicateTeamGameDefaults(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	// <summary>
	// Test Case Title :    "1.Verify that user should able to navigate to the snipback website after entering the URL		
	// Automation ID :Team_01
	// </summary>

	public void Team_01_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{	
		LoginPage_Obj loginObj=new LoginPage_Obj();

		//Step 1 : Verify that user should able to navigate to the snipback website after entering the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("nav-link btn btn-white sm")), "User is unable to navigate to SnipBack website after entering the URL");
	}
}
