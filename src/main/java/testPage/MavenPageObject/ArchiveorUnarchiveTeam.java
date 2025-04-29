package testPage.MavenPageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestData.AddorEditInfo_TestData;
import TestData.CommonData;
import TestData.CreateEditDeletePool_TestData;
import TestData.SearchGamesTeamAndMembers_TestData;
import objectRepository.AddorEditInfo_Obj;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;

public class ArchiveorUnarchiveTeam extends BasePge{
	BasePge base;
	Assert asrt;
	ElementActions element;

	public ArchiveorUnarchiveTeam(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
		element=new ElementActions(driver);
	}
	//<Summary>
	//Test case Title:Verify that user should able to navigate to the snipback website after entering the URL
	//Automation ID:Archive_01
	//</Summary>
	public void Archive_01_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );
	}

	//<Summary>
	//Test case Title:Verify that user should able to navigate to the Film page once login with credentials
	//Automation ID:Archive_02
	//</Summary>
	public void Archive_02_ArchiveorUnarchiveTeam() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);	

		//Step 1:Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack website after entering the URL" );

		//Step 2:Login to SnipBack
		//Expected:User should able to navigate to the Film page once login with credentials 
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("GAMES"))," User is unable to navigate to the Film page once login with credentials");
	}
}

