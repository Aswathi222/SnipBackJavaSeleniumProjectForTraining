package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestData.CommonData;
import TestData.CreateEditDeletePool_TestData;
import TestData.SnipBackLogin_TestData;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
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
	//Test case Title:To verify whether the user can able to edit Pool Type
	//Automation ID: TC_10
	//</Summary>
	public void TC_10_CreateEditDeletePool() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateEditDeletePool_TestData createEditDeletePoolTestdata=new CreateEditDeletePool_TestData();

		//Step 1: Navigate to Snipback page
		//Expected : User should be able to view Snipback page
		asrt.assertTrue(base.isExists(loginObj.Btn_Login("Login")),"User is unable to view SnipBack page" );

		///Step 2 : Login to Snipback
		//Expected : User should be able to login.
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));		
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		asrt.assertTrue(base.isExists(loginObj.Edt_Alert1("GAMES")), "User is not able to login");
		
		//step 3:Go to Film page
		//Expected: User should be able to click film
		base.buttonClick(createEditDeletePoolObj.Btn_Film("navbar-nav ms-auto", "Film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("POOLS")), "User is unable to click the Film");

		//step 4: Under Games section, go to Pools page
		//Expected: There should be an option to create pool
		base.excuteJsClick(loginObj.Btn_SignInButton("POOLS"));
		asrt.assertTrue(base.isExists(loginObj.Edt_Alert1("Create Pool")), "User is unable to view an option to create pool");

		//step 5: Click three dots of any pool
		//Expected:User should be able to click three dots any pool
		base.excuteJsClick(createEditDeletePoolObj.Ele_Pooldots("TC_10CreateEditPool", "dropdown"));
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Ele_Copydots("TC_10CreateEditPool","Edit")), "User is unable to click three dots");

		//step 6:Select Edit
		//Expected:User should be able to select the edit
		base.buttonClick(createEditDeletePoolObj.Ele_Copydots("TC_10CreateEditPool","Edit"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("pool_name")), "User is unable to select the edit");

		//step 7:Enter the Pool Type
		//Expected:The user can't able to edit Pool Type.
		base.selectorByVisibleText(createEditDeletePoolObj.Sel_PoolType("pool_type"),createEditDeletePoolTestdata.TC_10_CreateEditDeletePool);
		String poolType=base.GetText(createEditDeletePoolObj.Ddl_PoolType("Private"));
		asrt.assertEquals(poolType, createEditDeletePoolTestdata.TC_10_CreateEditDeletePool,"User is able to edit Pool Type");
	}
	//<Summary>
	//Test case Title:To verify whether the user can able to Edit Pool.
	//Automation ID: TC_09
	//</Summary>
	public void TC_09_CreateEditDeletePool() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateEditDeletePool_TestData createEditDeletePoolTestdata=new CreateEditDeletePool_TestData();
		ScheduleUnscheduleGames_Obj scheduleUnscheduleGamesObj=new ScheduleUnscheduleGames_Obj();

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

		//step 5: Click three dots of any pool
		//Expected:User should be able to click three dots any pool
		base.excuteJsClick(createEditDeletePoolObj.Ele_Pooldots("TC09_CreateEdit", "dropdown"));
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Ele_Copydots("TC09_CreateEdit","Edit")), "User is unable to click three dots");

		//step 6:Select Edit
		//Expected:User should be able to select the edit
		base.buttonClick(createEditDeletePoolObj.Ele_Copydots("TC09_CreateEdit","Edit"));
		asrt.assertTrue(base.isExists(loginObj.Edt_LoginEmail("pool_name")), "User is unable to select the edit");

		//step 7:Enter the Pool Name
		//Expected:The user can able to Edit Pool.
		base.setData(loginObj.Edt_LoginEmail("pool_name"), createEditDeletePoolTestdata.TC_09_CreateEditDeletePool);
		String poolname=base.GetValue(loginObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(poolname, createEditDeletePoolTestdata.TC_09_CreateEditDeletePool, "User is not able to edit the pool name");
	}
	//<Summary>
	//Test case Title:To verify whether the user can able to Copy Pool URL.
	//Automation ID: TC_08
	//</Summary>
	public void TC_08_CreateEditDeletePool() throws InterruptedException{
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

		//step 4: Under Games section, go to Pools page
		//Expected: There should be an option to create pool
		base.excuteJsClick(loginObj.Btn_SignInButton("POOLS"));
		asrt.assertTrue(base.isExists(loginObj.Edt_Alert1("Create Pool")), "User is unable to view an option to create pool");

		//step 5: Click three dots of any pool
		//Expected:User should be able to click three dots any pool
		base.excuteJsClick(createEditDeletePoolObj.Ele_Pooldots("TC08_CreatePool", "dropdown"));
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Ele_Copydots("TC08_CreatePool", "Copy URL")), "User is unable to click three dots");

		//step 6:Select Copy URL
		//Expected:The user can able to Copy Pool URL.
		base.buttonClick(createEditDeletePoolObj.Ele_Copydots("TC08_CreatePool", "Copy URL"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Copied!..")), "User is unable to copy the Pool URL");
	}

	//<Summary>
	//Test case Title:To verify what happens when user select the Pool Type as SemiPrivate.
	//Automation ID: TC_07
	//</Summary>
	public void TC_07_CreateEditDeletePool() throws InterruptedException{
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
		base.setData(loginObj.Edt_LoginEmail("pool_name"), createEditDeletePoolTestdata.TC_07_CreateEditDeletePool);
		String poolName=base.GetValue(loginObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(poolName, createEditDeletePoolTestdata.TC_07_CreateEditDeletePool, "User is not able to enter the pool name");

		//step 7:Select the Pool Type
		//Expected: User should able to select pool type
		base.selectorByVisibleText(createEditDeletePoolObj.Sel_PoolType("pool_type"),createEditDeletePoolTestdata.TC_07_CreateEditDeletePool_dropdwn);
		String poolType=base.GetText(createEditDeletePoolObj.Ddl_PoolType("SemiPrivate"));
		asrt.assertEquals(poolType, createEditDeletePoolTestdata.TC_07_CreateEditDeletePool_dropdwn, "User is not able to select the pool type");

		//step 8:Click Create
		//Expected: This pool-created user only has the access to this pool.
		base.buttonClick(createEditDeletePoolObj.Btn_CreatePoolAlert("submit", "CREATE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Pool created successfully")), "User will not receive an alert message as 'The Pool name field is required'");
	}
	//<Summary>
	//Test case Title:To verify what happens when user select the Pool Type as Private.
	//Automation ID: TC_06
	//</Summary>
	public void TC_06_CreateEditDeletePool() throws InterruptedException{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Login login=new Login(driver);
		CreateEditDeletePool_Obj createEditDeletePoolObj=new CreateEditDeletePool_Obj();
		CreateEditDeletePool_TestData createEditDeletePoolTestdata=new CreateEditDeletePool_TestData();
		Registration_Obj  RegistrationObj = new Registration_Obj();

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
		base.setData(loginObj.Edt_LoginEmail("pool_name"), createEditDeletePoolTestdata.TC_06_CreateEditDeletePool);
		String poolName=base.GetValue(loginObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(poolName, createEditDeletePoolTestdata.TC_06_CreateEditDeletePool, "User is not able to enter the pool name");

		//step 7:Select the Pool Type
		//Expected: User should able to select pool type as Private
		base.selectorByVisibleText(createEditDeletePoolObj.Sel_PoolType("pool_type"),createEditDeletePoolTestdata.TC_06_CreateEditDeletePool_dropdwn);
		asrt.assertTrue(base.isExists(createEditDeletePoolObj.Ele_PoolType("col-md-6 flex-column mt-3 pool-user", "Users ")), "User is unable to select pool type as Private");

		//step 8:Click Create
		//Expected:The user can add multiple users to that pool.
		base.setData(loginObj.Edt_LoginEmail("pool_userSearch"),createEditDeletePoolTestdata.TC_06_CreateEditDeletePool_addUser );
		base.buttonClick(RegistrationObj.Btn_Login("ui-corner-all", createEditDeletePoolTestdata.TC_06_CreateEditDeletePool_addUser));
		base.setData(loginObj.Edt_LoginEmail("pool_userSearch"),createEditDeletePoolTestdata.TC_06_CreateEditDeletePool_addUser2 );
		base.buttonClick(RegistrationObj.Btn_Login("ui-corner-all", createEditDeletePoolTestdata.TC_06_CreateEditDeletePool_addUser2));
		base.buttonClick(createEditDeletePoolObj.Btn_CreatePoolAlert("submit", "CREATE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Pool created successfully")), "User is unable to add multiple users to the pool.");
	}
	//<Summary>
	//Test case Title:To verify what happens when user doesn't select the pool type.
	//Automation ID: TC_05
	//</Summary>
	public void TC_05_CreateEditDeletePool() throws InterruptedException{
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
		base.setData(loginObj.Edt_LoginEmail("pool_name"), createEditDeletePoolTestdata.TC_05_CreateEditDeletePool);
		String poolName=base.GetValue(loginObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(poolName, createEditDeletePoolTestdata.TC_05_CreateEditDeletePool, "User is not able to enter the pool name");

		//step 7:Click Create
		//Expected: The user will receive an alert message as "The Pool Type field is required."
		base.buttonClick(createEditDeletePoolObj.Btn_CreatePoolAlert("submit", "CREATE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Pool Type is required!..")), "User will not receive an alert message as 'The pool type is required'");
	}
	//<Summary>
	//Test case Title:To verify what happens when user kept the Pool Name field empty.
	//Automation ID: TC_04
	//</Summary>
	public void TC_04_CreateEditDeletePool() throws InterruptedException{
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
		base.selectorByVisibleText(createEditDeletePoolObj.Sel_PoolType("pool_type"),createEditDeletePoolTestdata.TC_04_CreateEditDeletePool_dropdwn);
		String poolType=base.GetText(createEditDeletePoolObj.Ddl_PoolType("SemiPrivate"));
		asrt.assertEquals(poolType, createEditDeletePoolTestdata.TC_04_CreateEditDeletePool_dropdwn, "User is not able to select the pool type");

		//step 7:Click Create
		//Expected: The user will receive an alert message as "The Pool Name field is required."
		base.buttonClick(createEditDeletePoolObj.Btn_CreatePoolAlert("submit", "CREATE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("Pool Name is required!..")), "User is unable to receive an alert message as 'The Pool name field is required'");
	}
	//<Summary>
	//Test case Title:To verify what happens when the user enters an invalid pool name.
	//Automation ID: TC_03
	//</Summary>
	public void TC_03_CreateEditDeletePool() throws InterruptedException{
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
		base.setData(loginObj.Edt_LoginEmail("pool_name"), createEditDeletePoolTestdata.TC_03_CreateEditDeletePool);
		String poolName=base.GetValue(loginObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(poolName, createEditDeletePoolTestdata.TC_03_CreateEditDeletePool, "User is unable to enter invalid pool name");

		//step 7:Select the Pool Type
		//Expected: User should able to select pool type
		base.selectorByVisibleText(createEditDeletePoolObj.Sel_PoolType("pool_type"),createEditDeletePoolTestdata.TC_03_CreateEditDeletePool_dropdwn);
		String poolType=base.GetText(createEditDeletePoolObj.Ddl_PoolType("SemiPrivate"));
		asrt.assertEquals(poolType, createEditDeletePoolTestdata.TC_03_CreateEditDeletePool_dropdwn, "User is not able to select the pool type");

		//step 8:Click Create
		//Expected: The user will receive an alert message as "The Pool Name must be at least 2 characters."
		base.buttonClick(createEditDeletePoolObj.Btn_CreatePoolAlert("submit", "CREATE"));
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertText("The Pool Name must be at least 2 characters.")), "User is unable to receive an alert message 'The Pool Name must be at least 2 characters.'");
	}

	//<Summary>
	//Test case Title:To verify whether user can able to create a new pool.
	//Automation ID: TC_02
	//</Summary>
	public void TC_02_CreateEditDeletePool() throws InterruptedException{
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
		base.setData(loginObj.Edt_LoginEmail("pool_name"), createEditDeletePoolTestdata.TC_02_CreateEditDeletePool);
		String poolName=base.GetValue(loginObj.Edt_LoginEmail("pool_name"));
		asrt.assertEquals(poolName, createEditDeletePoolTestdata.TC_02_CreateEditDeletePool, "User is not able to enter the pool name");

		//step 7:Select the Pool Type
		//Expected: User should able to select pool type
		base.selectorByVisibleText(createEditDeletePoolObj.Sel_PoolType("pool_type"),createEditDeletePoolTestdata.TC_02_CreateEditDeletePool_dropdwn);
		String poolType=base.GetText(createEditDeletePoolObj.Ddl_PoolType("SemiPrivate"));
		asrt.assertEquals(poolType, createEditDeletePoolTestdata.TC_02_CreateEditDeletePool_dropdwn, "User is not able to select the pool type");

		//step 8:Click Create
		//Expected: User should able to click create
		base.buttonClick(createEditDeletePoolObj.Btn_CreatePoolAlert("submit", "CREATE"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SignInButton("OK")), "User is unable to click create");
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
