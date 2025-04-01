package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
import objectRepository.LoginPage_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;

public class ScheduleUnscheduleGames extends BasePge {
	BasePge base;
	Assert asrt;

	public ScheduleUnscheduleGames(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	//<summery>
	//Test Case Title : To verify whether there is a section as Schedule in Film page..
	//Automation ID : SG_01
	//</summery>
	public void SG_01_ScheduleUnscheduleGames() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
 
		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("SCHEDULE")),"There is no section for Schedule games under Film page.");

		//Step 3: Verify whether there is a section as Schedule in Film page
		//Expected: There should be a section for scheduled games under Film page.
		base.buttonClick(LoginPageObj.Edt_Alert1("SCHEDULE"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("combined-schedule-tab")),"There is no section for Schedule games under Film page.");
	}
	
	//<summery>
	//Test Case Title : To verify whether there is schedule icon near the games under Events/Practices
	//Automation ID : SG_02
	//</summery>
	public void SG_02_ScheduleUnscheduleGames() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		SnipBackLogin_Obj SnipBackLoginObj = new SnipBackLogin_Obj();
		ScheduleUnscheduleGames_Obj ScheduleUnscheduleGamesObj = new ScheduleUnscheduleGames_Obj();

		//Step 1 : Navigate to Snipback Login page
		//Expected : User should be able to navigate to Snipback Login page.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
 
		//Step 2 : Login to Snipback
		//Expected : User should be able to login.
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("SCHEDULE")),"There is no section for Schedule games under Film page.");

		//Step 3: Verify whether there is schedule icon near the games under Events
		//Expected: There should be a schedule icon near the games under Events..
		base.buttonClick(SnipBackLoginObj.Btn_Signin("EVENTS"));
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row ","1","calendar-list scheduled","my_film")),
				"There is no schedule icon near the games under Events.");
		
		//Step 4: Verify whether there is schedule icon near the games under Practices
		//Expected: There should be a schedule icon near the games under Practices..
		base.buttonClick(SnipBackLoginObj.Btn_Signin("PRACTICES"));
		asrt.assertTrue(base.isExists(ScheduleUnscheduleGamesObj.Btn_ScheduleUnschedule("game-row ","1","calendar-list scheduled","practice_film")),
				"There is no schedule icon near the games under Practices.");
		
	}
}
