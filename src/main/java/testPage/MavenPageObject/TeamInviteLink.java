package testPage.MavenPageObject;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import TestData.CommonData;
import TestData.CreateAndAddNewMemberWithOrWithoutEmail_TestData;
import objectRepository.CreateAndAddNewMemberWithOrWithoutEmail_Obj;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.ForgotPassword_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;

public class TeamInviteLink extends BasePge {
	BasePge base;
	Assert asrt;
	ElementActions element;

	public TeamInviteLink(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
		element = new ElementActions(driver);
	}	
	//<summery>
	//Test Case Title : Verify that user should able to navigate to the snipback website after entering the URL
	//Automation ID : Invitelink_01
	//</summery>
	public void Invitelink_01_TeamInviteLink() throws InterruptedException {	
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		//Step 1 : Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to the snipback website after entering the URL");
	}
	//<summery>
	//Test Case Title : Verify that user should able to navigate to the Film page once login with credentials
	//Automation ID : Invitelink_02
	//</summery>
	public void Invitelink_02_TeamInviteLink() throws InterruptedException {	
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		//Step 1 : Enter the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigate to the snipback website after entering the URL");

		//Step 2 : Login to Snipback
		//Expected : User should able to navigate to the Film page once login with credentials
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage("GAMES")), "User is not able to navigate to the Film page once login with credentials");
	}
}