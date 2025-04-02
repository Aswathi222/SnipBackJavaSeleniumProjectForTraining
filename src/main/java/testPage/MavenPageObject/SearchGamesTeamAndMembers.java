package testPage.MavenPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestData.CommonData;
import TestData.CreateEditDeletePool_TestData;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import utilPack.BasePge;

public class SearchGamesTeamAndMembers extends BasePge{
	BasePge base;
	Assert asrt;
	
	public SearchGamesTeamAndMembers(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	
	//<Summary>
	//Test case Title:To verify whether there is a option to search games in Game Listing page.
	//Automation ID: TC_01
	//</Summary>
	public void TC01_SearchGamesTeamAndMembers() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		
		//Step 1: Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		//Step 2: Click Login button
		//Expected: user should be able to login to the SnipBack
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"))," User is unable to login to SnipBack");

		//step 3:Go to Film page
		//Expected: User should be able to click film
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("POOLS")), "User is unable to click the Film");
		
		//step 4: Select Games section
		//Expected:There should be a option to search games in Game Listing page.
		base.buttonClick(loginObj.Edt_Alert1("GAMES"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("searchTeam")), "User is unable to search games in games listing page.");
}

}
