package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestData.CommonData;
import TestData.CreateEditDeletePool_TestData;
import TestData.SnipBackLogin_TestData;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;

//import basePackage.BasePge;

public class CreateEditDeletePool extends BasePge {

	BasePge base;
	Assert asrt;

	public CreateEditDeletePool(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	//<Summary>
		//Test case Title:To verify whether user can able to create a new pool.
		//Automation ID: TC_02
		//</Summary>
		public void TC_02_CreateEditDeletePool() throws InterruptedException{
			LoginPage_Obj loginObj=new LoginPage_Obj();
			Login login=new Login(driver);
			CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
			CreateEditDeletePool_TestData createEditDeletePool_testdata=new CreateEditDeletePool_TestData();
			
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

			//step 4: Under Games section, go to Pools page
			//Expected: There should be an option to create pool
			base.excuteJsClick(loginObj.Btn_SignInButton("POOLS"));
			asrt.assertTrue(base.isExists(loginObj.Edt_Alert1("Create Pool")), "User is unable to view an option to create pool");

			//step 5: Click "+Create Pool" button
			//Expected: User should able to click '+ Create Pool'
			base.buttonClick(loginObj.Edt_Alert1("Create Pool"));
			asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("pool_name")), "User is unable to click '+Create Pool' button");
			
			//step 6: Enter the Pool Name
			//Expected: User should able to enter pool name
			base.setData(loginObj.Edt_LoginEmail("pool_name"), createEditDeletePool_testdata.TC_02_CreateEditDeletePool);
	        String poolName=base.GetValue(loginObj.Edt_LoginEmail("pool_name"));
	        asrt.assertEquals(poolName, createEditDeletePool_testdata.TC_02_CreateEditDeletePool);
			
			//step 7:Select the Pool Type
			//Expected: User should able to select pool type
			base.selectorByVisibleText(createEditDeletePoolObj.Sel_PoolType("pool_type"),createEditDeletePool_testdata.TC_02_CreateEditDeletePool_dropdwn );
			//String poolType=base.GetText(createEditDeletePoolObj.Sel_PoolType("pool_type"));
			asrt.assertTrue(base.isExists(createEditDeletePoolObj.Sel_PoolType("pool_type")),"User unable to navigate to the pool type");
			
			//step 8:Click Create
			//Expected: User should able to click create
			base.buttonClick(createEditDeletePoolObj.Btn_CreatePoolAlert("submit", "CREATE"));
			asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("OK")), "User is unable to click create");
			
	}
		
}
