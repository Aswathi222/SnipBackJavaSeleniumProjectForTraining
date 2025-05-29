package testPage.MavenPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
import TestData.SnipBackLogin_TestData;
import objectRepository.GameListing_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import utilPack.BasePge;

public class PublicGameListing extends BasePge {
	BasePge base;
	Assert asrt;

	public PublicGameListing(WebDriver driver) {    
		super(driver);                              
		base = new BasePge(driver);                 
	}
	//<summary>
	//Test Case Title:"Verify that the user should be able to navigates to the  Snipback website after entering the URL
	//Automation ID: Game Listing_01
	//</summary>
	public void TC01_PublicGameListing() {
		//Step1: Enter snipback URL
		//Expected Result: The user should be able to navigates to the  Snipback website after entering the URL
		LoginPage_Obj home = new LoginPage_Obj();
		asrt.assertTrue(base.isExists(home.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate to Snipback website");

	}
}