package testPage.MavenPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestData.CommonData;
import TestData.CreateEditDeletePool_TestData;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;

public class CreateEditDeletePool extends BasePge {
	BasePge base;
	Assert asrt;
	public CreateEditDeletePool(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	//<Summary>
	//Test Case Title: To verify whether there is an option to Create new pool.
	//Automation ID: TC_01
	//</Summary>
	public void TC_01_CreateEditDeletePool() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();

		//Step 1: Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		//Step 2: Click Login button
		//Expected: user should be able to login to the SnipBack
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Tags"))," User is unable to login to SnipBack");

		//step 3:Go to Film page
		//Expected: User should be able to click film
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("POOLS")), "User is unable to click the Film");

		//step 4: Under Games section, go to Pools page
		//Expected: There should be an option to create pool
		base.buttonClick(loginObj.Btn_SignInButton("POOLS"));
		asrt.assertTrue(base.isExists(loginObj.Edt_Alert1("Create Pool")), "User is unable to view an option to create pool");
	}
}
