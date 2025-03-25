package testPage.MavenPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import objectRepository.LoginPage_Obj;
import utilPack.BasePge;

public class PublicGameListing extends BasePge{

	BasePge base;
	Assert asrt;

	public PublicGameListing(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	
	// <summary>
	// Test Case Title : "Verify that the user should be able to navigates to the  Snipback website after entering the URL"
	// Automation ID : GameListing_01
	// </summary>
	public void GameListing_01_PublicGameListing() {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
	}
}
