package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestData.CommonData;
import TestData.CreateEditDeletePool_TestData;
import TestData.SnipBackLogin_TestData;
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
	//Test case Title:To verify what happens when user select the Pool Type as Private.
	//Automation ID: TC_06
	//</Summary>
	public void TC06_CreateEditDeletePool() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateEditDeletePool_TestData createEditDeletePoolTestdata=new CreateEditDeletePool_TestData();

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
		base.setData(loginObj.Edt_LoginEmail("pool_name"), createEditDeletePoolTestdata.TC06_CreateEditDeletePool);
		String poolName=base.GetValue(loginObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(poolName, createEditDeletePoolTestdata.TC06_CreateEditDeletePool, "User is not able to enter the pool name");

		//step 7:Select the Pool Type
		//Expected: User should able to select pool type as Private
		base.selectorByVisibleText(createEditDeletePoolObj.Sel_PoolType("pool_type"),createEditDeletePoolTestdata.TC06_CreateEditDeletePool_dropdwn);
		base.setData(loginObj.Edt_LoginEmail("pool_userSearch"),createEditDeletePoolTestdata.TC06_CreateEditDeletePool_addUser );
		base.buttonClick(createEditDeletePoolObj.Ddl_addUser1("ui-corner-all", createEditDeletePoolTestdata.TC06_CreateEditDeletePool_addUser));
		String poolUser=base.GetText(createEditDeletePoolObj.Ele_PoolUser("poolUser", createEditDeletePoolTestdata.TC06_CreateEditDeletePool_poolUser));
		asrt.assertEquals(poolUser, createEditDeletePoolTestdata.TC06_CreateEditDeletePool_poolUser, "User is not able to select the pool type as Private");
		base.setData(loginObj.Edt_LoginEmail("pool_userSearch"),createEditDeletePoolTestdata.TC06_CreateEditDeletePool_addUser2 );
		base.buttonClick(createEditDeletePoolObj.Ddl_addUser1("ui-corner-all", createEditDeletePoolTestdata.TC06_CreateEditDeletePool_addUser2));
		String poolUser2=base.GetText(createEditDeletePoolObj.Ele_PoolUser("poolUser", createEditDeletePoolTestdata.TC06_CreateEditDeletePool_poolUser2));
		asrt.assertEquals(poolUser2, createEditDeletePoolTestdata.TC06_CreateEditDeletePool_poolUser2, "User is not able to select the pool type as Private");
		
		//step 8:Click Create
		//Expected:The user can add multiple users to that pool.
		base.buttonClick(createEditDeletePoolObj.Btn_CreatePoolAlert("submit", "CREATE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Pool created successfully")), "User is unable to add multiple users to the pool.");
	}
	//<Summary>
	//Test case Title:To verify what happens when user doesn't select the pool type.
	//Automation ID: TC_05
	//</Summary>
	public void TC05_CreateEditDeletePool() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateEditDeletePool_TestData createEditDeletePoolTestdata=new CreateEditDeletePool_TestData();

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
		base.setData(loginObj.Edt_LoginEmail("pool_name"), createEditDeletePoolTestdata.TC05_CreateEditDeletePool);
		String poolName=base.GetValue(loginObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(poolName, createEditDeletePoolTestdata.TC05_CreateEditDeletePool, "User is not able to enter the pool name");

		//step 7:Click Create
		//Expected: The user will receive an alert message as "The Pool Type field is required."
		base.buttonClick(createEditDeletePoolObj.Btn_CreatePoolAlert("submit", "CREATE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Pool Type is required!..")), "User will not receive an alert message as 'The pool type is required'");
	}
	//<Summary>
	//Test case Title:To verify what happens when user kept the Pool Name field empty.
	//Automation ID: TC_04
	//</Summary>
	public void TC04_CreateEditDeletePool() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateEditDeletePool_TestData createEditDeletePoolTestdata=new CreateEditDeletePool_TestData();

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

		//step 6:Select the Pool Type
		//Expected: User should able to select pool type
		base.selectorByVisibleText(createEditDeletePoolObj.Sel_PoolType("pool_type"),createEditDeletePoolTestdata.TC04_CreateEditDeletePool_dropdwn);
		String poolType=base.GetText(createEditDeletePoolObj.Ddl_PoolType("SemiPrivate"));
		asrt.assertEquals(poolType, createEditDeletePoolTestdata.TC04_CreateEditDeletePool_dropdwn, "User is not able to select the pool type");

		//step 7:Click Create
		//Expected: The user will receive an alert message as "The Pool Name field is required."
		base.buttonClick(createEditDeletePoolObj.Btn_CreatePoolAlert("submit", "CREATE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Pool Name is required!..")), "User is unable to receive an alert message as 'The Pool name field is required'");
	}
	//<Summary>
	//Test case Title:To verify what happens when the user enters an invalid pool name.
	//Automation ID: TC_03
	//</Summary>
	public void TC03_CreateEditDeletePool() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateEditDeletePool_TestData createEditDeletePoolTestdata=new CreateEditDeletePool_TestData();

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

		//step 6: Enter invalid Pool Name
		//Expected: User should able to enter invalid pool name
		base.setData(loginObj.Edt_LoginEmail("pool_name"), createEditDeletePoolTestdata.TC03_CreateEditDeletePool);
		String poolName=base.GetValue(loginObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(poolName, createEditDeletePoolTestdata.TC03_CreateEditDeletePool, "User is unable to enter invalid pool name");

		//step 7:Select the Pool Type
		//Expected: User should able to select pool type
		base.selectorByVisibleText(createEditDeletePoolObj.Sel_PoolType("pool_type"),createEditDeletePoolTestdata.TC03_CreateEditDeletePool_dropdwn);
		String poolType=base.GetText(createEditDeletePoolObj.Ddl_PoolType("SemiPrivate"));
		asrt.assertEquals(poolType, createEditDeletePoolTestdata.TC03_CreateEditDeletePool_dropdwn, "User is not able to select the pool type");

		//step 8:Click Create
		//Expected: The user will receive an alert message as "The Pool Name must be at least 2 characters."
		base.buttonClick(createEditDeletePoolObj.Btn_CreatePoolAlert("submit", "CREATE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("The Pool Name must be at least 2 characters.")), "User is unable to receive an alert message 'The Pool Name must be at least 2 characters.'");
	}

	//<Summary>
	//Test case Title:To verify whether user can able to create a new pool.
	//Automation ID: TC_02
	//</Summary>
	public void TC02_CreateEditDeletePool() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateEditDeletePool_TestData createEditDeletePoolTestdata=new CreateEditDeletePool_TestData();

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
		base.setData(loginObj.Edt_LoginEmail("pool_name"), createEditDeletePoolTestdata.TC02_CreateEditDeletePool);
		String poolName=base.GetValue(loginObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(poolName, createEditDeletePoolTestdata.TC02_CreateEditDeletePool, "User is not able to enter the pool name");

		//step 7:Select the Pool Type
		//Expected: User should able to select pool type
		base.selectorByVisibleText(createEditDeletePoolObj.Sel_PoolType("pool_type"),createEditDeletePoolTestdata.TC02_CreateEditDeletePool_dropdwn);
		String poolType=base.GetText(createEditDeletePoolObj.Ddl_PoolType("SemiPrivate"));
		asrt.assertEquals(poolType, createEditDeletePoolTestdata.TC02_CreateEditDeletePool_dropdwn, "User is not able to select the pool type");

		//step 8:Click Create
		//Expected: User should able to click create
		base.buttonClick(createEditDeletePoolObj.Btn_CreatePoolAlert("submit", "CREATE"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("OK")), "User is unable to click create");

	}

	//<Summary>
	//Test Case Title: To verify whether there is an option to Create new pool.
	//Automation ID: TC_01
	//</Summary>
	public void TC01_CreateEditDeletePool() throws InterruptedException{
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
