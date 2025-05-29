package testPage.MavenPageObject;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import objectRepository.LoginPage_Obj;
import utilPack.BasePge;

public class ViewProfile extends BasePge {

	BasePge base;
	Assert asrt;

	public ViewProfile(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}	
	/*<summary>*/
	/*Title: Verify that the user should be able to navigates to the  Snipback website after entering the URL*/
	/*Automation Id: View Pro_1*/
	/*</summary>*/
	public void TC01_ViewProfile() {
		LoginPage_Obj loginpage = new LoginPage_Obj();

		//step 1: Open the SnipBack application
		//expected result: The user should be able to navigates to the  Snipback website after entering the URL		
		asrt.assertTrue(base.isExists(loginpage.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate into snipback website");
	}
}
