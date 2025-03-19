package testPage.MavenPageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import TestData.CommonData;
import TestData.Pool_TestData;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.EditSnip_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.WhiteboardPlayer_Obj;
import utilPack.BasePge;


public class Pool extends BasePge{

	BasePge base;
	Assert asrt;
	Actions actions = new Actions(driver);
	
	public Pool(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	// <summary>
		// Test Case Title :  "To verify what happens when user select the Pool Type as Private"
		// Automation ID : TC_06
		// </summary>
		public void TC_06_CreateEditDeletePool()  throws InterruptedException
		{	
			Login login =new Login(driver);
			CommonData Commondata = new CommonData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj= new Pool_Obj();
			Pool_TestData PoolTestData= new Pool_TestData();
			MoveGame_Obj MoveGameObj = new MoveGame_Obj();
			EditSnip_Obj EditSnipObj=new EditSnip_Obj();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

			//Step 1: Go to Games page
			//Expected: User should be navigated to Games page
			login.loginToApplication(Commondata.UserName,Commondata.PassWord);
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded.");

			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),PoolTestData.TC02_OrgName);
						
			//Step 2   :Select a Team from ORG
			//Expected:The New Team is Selected	
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), PoolTestData.TC06_teamName);
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC06_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC06_teamName)), "Failed to select TEAM");

			//base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeams(PoolTestData.TC06_teamName));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "POOLS")),"User is not able to view the POOLS Button");

			//Step 3: Under Games section, go to Pools page
			//Expected: Pool page should be loaded to the user as expected.
			base.excuteJsClick(LoginPageObj.Btn_SignInButton("POOLS"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"Pool page not loaded to the user as expected");

			//Step 4: Click on Create Pool button
			//Expected: User should be able to click on Create Pool button 
			base.excuteJsClick(LoginPageObj.Edt_Alert1("Create Pool"));
			asrt.assertTrue(base.isExists(PoolObj.Ddl_CreatePool("poolModalHeader")),"Create pool page is not visible to the user.");
			base.setData(LoginPageObj.Edt_LoginEmail("pool_name"),PoolTestData.TC06_PoolName);

			//Step 4: Select the pool type in create pool area
			//Expected: User should be able to select Pool type. 
			base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("pool_type"),"Private");
			asrt.assertTrue(base.isExists(EditSnipObj.Ele_eam("Users ")),"The user is unable to see the 'Users' field to add multiple users to the pool.");	
            			
		}

		// <summary>
		// Test Case Title :  "To verify whether the user can able to Edit Pool.."
		// Automation ID : TC_09
		// </summary>

		public void TC_09_CreateEditDeletePool() throws InterruptedException
		{
			Login login =new Login(driver);
			CommonData Commondata = new CommonData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj= new Pool_Obj();
			Pool_TestData PoolTestData= new Pool_TestData();
			MoveGame_Obj MoveGameObj = new MoveGame_Obj();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
			AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
			
			//Step 1: Go to Games page
			//Expected: User should be navigated to Games page
			login.loginToApplication(Commondata.UserName,Commondata.PassWord);
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded.");

			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),PoolTestData.TC09_OrgName);
						
			//Step 2   :Select a Team from ORG
			//Expected:The New Team is Selected	
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), PoolTestData.TC09_teamName);
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC09_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC09_teamName)), "Failed to select TEAM");

			//base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeams(PoolTestData.TC09_teamName));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "POOLS")),"User is not able to view the POOLS Button");

			//Step 3: Under Games section, go to Pools page
			//Expected: Pool page should be loaded to the user as expected.
			base.excuteJsClick(LoginPageObj.Btn_SignInButton("POOLS"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"Pool page not loaded to the user as expected");

			//Step 3: Click three dots of any pool
			//Excepted:User Is  able to view the menu list.
			//base.excuteJsClick(PoolObj.Btn_PoolDots(PoolTestData.TC09_PoolName));
			base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),PoolTestData.TC09_PoolName);
		    actions.sendKeys(Keys.ENTER).perform();
		    Thread.sleep(9000);
			base.buttonClick(MoveGameObj.Btn_3Dots(PoolTestData.TC09_PoolName));
			asrt.assertTrue(base.isExists(PoolObj.Ddl_PoolMenu("left-menu-list")),"Pool left menu is not displayed");

			//Step 4. Select Edit
			//Expected: Pool 'Edit' page should be displayed
			base.excuteJsClick(PoolObj.Ele_PoolLeftMenuOptions(PoolTestData.TC09_PoolName,"Edit"));
			asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("EDIT POOL")),"Edit Pool PopUp in Games page is not displayed.");

			//Step 5. Enter the Pool Name
			//Expected: User should be able to Edit the Pool name .
			base.setData(LoginPageObj.Edt_LoginEmail("pool_name"), PoolTestData.TC09_NewPoolName);
			String ActualPoolName=base.GetValue(LoginPageObj.Edt_LoginEmail("pool_name"));
			base.buttonClick(LoginPageObj.Btn_SignInButton("UPDATE"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Pool updated successfully")),"User is not able to Edit the Pool name");
			base.buttonClick(LoginPageObj.Btn_SignInButton("OK"));
			
			Thread.sleep(1000);
			base.buttonClick(PoolObj.Btn_PoolDots(ActualPoolName));
			base.excuteJsClick(PoolObj.Ele_PoolLeftMenuOptions(ActualPoolName,"Edit"));
			base.setData(LoginPageObj.Edt_LoginEmail("pool_name"), PoolTestData.TC09_PoolName);
			base.buttonClick(LoginPageObj.Btn_SignInButton("UPDATE"));
			base.buttonClick(LoginPageObj.Btn_SignInButton("OK"));		
		}
		
		// <summary>
		// Test Case Title :"To verify what happens when user doesn't select the pool type."
		// Automation ID : TC_05
		// </summary>
		public void TC_05_CreateEditDeletePool() throws InterruptedException
		{

			Login login =new Login(driver);
			CommonData Commondata = new CommonData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
			Pool_TestData pooltestdata= new Pool_TestData();
			Pool_Obj PoolObj= new Pool_Obj();
			Pool_TestData PoolTestData= new Pool_TestData();
			MoveGame_Obj MoveGameObj = new MoveGame_Obj();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

			//Step 1: Go to Games page
			//Expected: User should be navigated to Games page
			login.loginToApplication(Commondata.UserName,Commondata.PassWord);
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded.");

			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),PoolTestData.TC05_OrgName);
						
			//Step 2   :Select a Team from ORG
			//Expected:The New Team is Selected	
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), PoolTestData.TC05_teamName);
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC05_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC05_teamName)), "Failed to select TEAM");

			//base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeams(PoolTestData.TC05_teamName));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "POOLS")),"User is not able to view the POOLS Button");

			//Step 3: Under Games section, go to Pools page
			//Expected: Pool page should be loaded to the user as expected.
			base.excuteJsClick(LoginPageObj.Btn_SignInButton("POOLS"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"Pool page not loaded to the user as expected");

			//Step 4: Click on Create Pool button
			//Expected: User should be able to click on Create Pool button 
			base.excuteJsClick(LoginPageObj.Edt_Alert1("Create Pool"));
			asrt.assertTrue(base.isExists(PoolObj.Ddl_CreatePool("poolModalHeader")),"Create pool page is not visible to the user.");
			base.setData(LoginPageObj.Edt_LoginEmail("pool_name"),PoolTestData.TC05_PoolName);


			//Step 5: Click on Create button in create pool area
			//Expected : User should be able to click on create button
			base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-primary create-btn border-0 btn-popup pool-create-btn"));
			base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
			//Step4:Enter the Pool Name.
			//Expected: User is able to enter the pool name.
			base.setData(LoginPageObj.Edt_LoginEmail("pool_name"),pooltestdata.TC05_PoolName);
			String ExpectedPoolName= base.GetValue(LoginPageObj.Edt_LoginEmail("pool_name"));
			asrt.assertEquals(ExpectedPoolName,pooltestdata.TC05_PoolName,"User is not able to enter the pool name.");
			
			//Step5.Click Create
			//Expected:User is able to view the popup message as 'The Pool Type field is required'
			base.excuteJsClick(PoolObj.Btn_Create("submit","CREATE"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Pool Type is required!..")),"User is not able view the popup message as 'The Pool Type field is required' popup");
		}


		// <summary>
		// Test Case Title :  "To verify what happens when user select the Pool Type as SemiPrivate."
		// Automation ID : TC_07
		// </summary>

		public void TC_07_CreateEditDeletePool()  throws InterruptedException
		{	
			Login login =new Login(driver);
			CommonData Commondata = new CommonData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj= new Pool_Obj();
			Pool_TestData PoolTestData= new Pool_TestData();
			MoveGame_Obj MoveGameObj = new MoveGame_Obj();
			EditSnip_Obj EditSnipObj=new EditSnip_Obj();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

			//Step 1: Go to Games page
			//Expected: User should be navigated to Games page
			login.loginToApplication(Commondata.UserName,Commondata.PassWord);
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded.");

			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),PoolTestData.TC07_OrgName);
						
			//Step 2   :Select a Team from ORG
			//Expected:The New Team is Selected	
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), PoolTestData.TC07_teamName);
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC07_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC07_teamName)), "Failed to select TEAM");

			//base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeams(PoolTestData.TC07_teamName));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "POOLS")),"User is not able to view the POOLS Button");

			//Step 3: Under Games section, go to Pools page
			//Expected: Pool page should be loaded to the user as expected.
			base.excuteJsClick(LoginPageObj.Btn_SignInButton("POOLS"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"Pool page not loaded to the user as expected");

			//Step 4: Click on Create Pool button
			//Expected: User should be able to click on Create Pool button 
			base.excuteJsClick(LoginPageObj.Edt_Alert1("Create Pool"));
			asrt.assertTrue(base.isExists(PoolObj.Ddl_CreatePool("poolModalHeader")),"Create pool page is not visible to the user.");
			base.setData(LoginPageObj.Edt_LoginEmail("pool_name"),PoolTestData.TC07_PoolName);

			//Step 4: Select the pool type in create pool area
			//Expected: User should be able to select Pool type. 
			base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("pool_type"),"SemiPrivate");			
			boolean isElementPresent;
			try {
			    driver.findElement(EditSnipObj.Ele_eam("Users "));
			    isElementPresent = true; 
			} catch (NoSuchElementException e) {
			    isElementPresent = false; 
			}
		}

		// <summary>
		// Test Case Title :  "To verify what happens when user kept the Pool Name field empty."
		// Automation ID : TC_04
		// </summary>

		public void TC_04_CreateEditDeletePool()  throws InterruptedException
		{	
			Login login =new Login(driver);
			CommonData Commondata = new CommonData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
			Pool_Obj PoolObj =new Pool_Obj();
			MoveGame_Obj MoveGameObj = new MoveGame_Obj();
			Pool_TestData PoolTestData = new Pool_TestData();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

			//Step 1: Go to Games page
			//Expected: User should be navigated to Games page
			login.loginToApplication(Commondata.UserName,Commondata.PassWord);
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded.");

			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),PoolTestData.TC04_OrgName);
						
			//Step 2   :Select a Team from ORG
			//Expected:The New Team is Selected	
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), PoolTestData.TC04_teamName);
			//base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeams(PoolTestData.TC04_teamName));
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC04_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC04_teamName)), "Failed to select TEAM");

			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "POOLS")),"User is not able to view the POOLS Button");

			//Step 3: Under Games section, go to Pools page
			//Expected: Pool page should be loaded to the user as expected.
			base.excuteJsClick(LoginPageObj.Btn_SignInButton("POOLS"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"Pool page not loaded to the user as expected");

			//Step 4: Click on Create Pool button
			//Expected: User should be able to click on Create Pool button 
			base.excuteJsClick(LoginPageObj.Edt_Alert1("Create Pool"));
			asrt.assertTrue(base.isExists(PoolObj.Ddl_CreatePool("poolModalHeader")),"Create pool page is not visible to the user.");
			
			//4. Select the Pool Type
			//Expected:User is able to select the pool type from the dropdown
			base.buttonClick(PoolObj.Ele_PoolTypeDropDown("pool_type"));
			base.autoSuggestiveDropDown(PoolObj.Ele_SelectPoolType("SemiPrivate"),"SemiPrivate");
			base.buttonClick(PoolObj.Ele_SelectPoolType("SemiPrivate"));
			asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType("SemiPrivate")),"user is not able to select poolType as semi Private");

			//5. Click Create
			//Expected:User is able to view the popup message as The Pool Name field is required.
			base.excuteJsClick(PoolObj.Btn_Create("submit","CREATE"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Pool Name is required!..")),"User is not able to view the popup message as 'Pool Name is required!..' ");
		}

		//<summary>
		//Description: To verify whether the user can able to edit Pool Type
		//Automation ID: TC_10
		//</summary>
		public void TC_10_CreateEditDeletePool() throws InterruptedException
		{
			Login login= new Login(driver);
			CommonData Commondata= new CommonData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj= new Pool_Obj();
			Pool_TestData PoolTestData= new Pool_TestData();
			MoveGame_Obj MoveGameObj = new MoveGame_Obj();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
			AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
			
			//Step 1: Go to Games page
			//Expected: User should be navigated to Games page
			login.loginToApplication(Commondata.UserName,Commondata.PassWord);
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded.");

			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),PoolTestData.TC10_OrgName);
						
			//Step 2   :Select a Team from ORG
			//Expected:The New Team is Selected	
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), PoolTestData.TC10_teamName);
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC10_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC10_teamName)), "Failed to select TEAM");

			//base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeams(PoolTestData.TC10_teamName));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "POOLS")),"User is not able to view the POOLS Button");

			//Step 3: Under Games section, go to Pools page
			//Expected: Pool page should be loaded to the user as expected.
			base.excuteJsClick(LoginPageObj.Btn_SignInButton("POOLS"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"Pool page not loaded to the user as expected");

			//Step 3: Click three dots of any pool
			//Excepted:User Is  able to view the menu list.
			
			//base.buttonClick(PoolObj.Btn_PoolDots(PoolTestData.TC10_PoolName));
			base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),PoolTestData.TC10_PoolName);
		    actions.sendKeys(Keys.ENTER).perform();
		    Thread.sleep(9000);
			base.buttonClick(MoveGameObj.Btn_3Dots(PoolTestData.TC10_PoolName));
			asrt.assertTrue(base.isExists(PoolObj.Ddl_PoolMenu("left-menu-list")),"Pool left menu is not displayed");

			//Step 4. Select Edit
			//Expected: Pool 'Edit' page should be displayed
			base.excuteJsClick(PoolObj.Ele_PoolLeftMenuOptions(PoolTestData.TC09_PoolName,"Edit"));
			asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("EDIT POOL")),"Edit Pool PopUp in Games page is not displayed.");

			//Step 5. "Verify the PoolType dropdown is disabled
			//Expected: The user can't able to edit Pool Type.		
            String PoolTypeDropdownVisibility= base.GetAttribte(PoolObj.Ele_PoolTypeDropDown("pool_type"),"disabled");
            asrt.assertEquals(PoolTypeDropdownVisibility, "true", "The user can able to edit Pool Type.");			
		}
		
		// <summary>
		// Test Case Title :  "To verify whether there is an option to Create new pool."
		// Automation ID : TC_01
		// </summary>
		public void TC_01_CreateEditDeletePool() throws InterruptedException
		{
			Login login= new Login(driver);
			CommonData Commondata= new CommonData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj= new Pool_Obj();
			Pool_TestData PoolTestData = new Pool_TestData();
			MoveGame_Obj MoveGameObj = new MoveGame_Obj();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

			//Step 1: Go to Games page
			//Expected: User should be navigated to Games page
			login.loginToApplication(Commondata.UserName,Commondata.PassWord);
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded.");

			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),PoolTestData.TC01_OrgName);
						
			//Step 2   :Select a Team from ORG
			//Expected:The New Team is Selected	
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), PoolTestData.TC01_teamName);
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC01_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC01_teamName)), "Failed to select TEAM");

			//base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeams(PoolTestData.TC01_teamName));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "POOLS")),"User is not able to view the POOLS Button");

			//Step 3: Under Games section, go to Pools page
			//Expected: Pool page should be loaded to the user as expected.
			base.excuteJsClick(LoginPageObj.Btn_SignInButton("POOLS"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"Pool page not loaded to the user as expected");

		}
		// <summary>
		//Test Case Title : To verify whether user can able to create a new pool.
		// Automation ID : TC_02
		// </summary>
		public void TC_02_CreateEditDeletePool() throws InterruptedException
		{
			Login login= new Login(driver);
			CommonData Commondata= new CommonData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj= new Pool_Obj();
			Pool_TestData PoolTestData= new Pool_TestData();
			MoveGame_Obj MoveGameObj = new MoveGame_Obj();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

			//Step 1: Go to Games page
			//Expected: User should be navigated to Games page
			login.loginToApplication(Commondata.UserName,Commondata.PassWord);
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded.");

			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),PoolTestData.TC02_OrgName);
						
			//Step 2   :Select a Team from ORG
			//Expected:The New Team is Selected	
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), PoolTestData.TC02_teamName);
			//base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeams(PoolTestData.TC02_teamName));
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC02_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC02_teamName)), "Failed to select TEAM");
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "POOLS")),"User is not able to view the POOLS Button");

			//Step 3: Under Games section, go to Pools page
			//Expected: Pool page should be loaded to the user as expected.
			base.excuteJsClick(LoginPageObj.Btn_SignInButton("POOLS"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"Pool page not loaded to the user as expected");

			//Step 4: Click on Create Pool button
			//Expected: User should be able to click on Create Pool button 
			base.excuteJsClick(LoginPageObj.Edt_Alert1("Create Pool"));
			asrt.assertTrue(base.isExists(PoolObj.Ddl_CreatePool("poolModalHeader")),"Create pool page is not visible to the user.");
			base.setData(LoginPageObj.Edt_LoginEmail("pool_name"),PoolTestData.TC02_PoolName);

			//Step 4: Select the pool type in create pool area
			//Expected: User should be able to select Pool type. 
			base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("pool_type"),"SemiPrivate");

			//Step 5: Click on Create button in create pool area
			//Expected : User should be able to click on create button
			base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-primary create-btn border-0 btn-popup pool-create-btn"));
			base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login(PoolTestData.TC02_PoolName)),"User is not able to view the created pool in the pool list in the pool page.");

		}
		
		// <summary>
		// Test Case Title :  "To verify whether the user can able to Copy Pool URL."
		// Automation ID : TC_08
		// </summary>
		public void TC_08_CreateEditDeletePool()  throws InterruptedException
		{	
			Login login =new Login(driver);
			CommonData Commondata = new CommonData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj= new Pool_Obj();
			Pool_TestData PoolTestData= new Pool_TestData();
			WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
			MoveGame_Obj MoveGameObj = new MoveGame_Obj();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
			AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
			
			//Step 1: Go to Games page
			//Expected: User should be navigated to Games page
			login.loginToApplication(Commondata.UserName,Commondata.PassWord);
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded.");

			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),PoolTestData.TC08_OrgName);
						
			//Step 2   :Select a Team from ORG
			//Expected:The New Team is Selected	
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), PoolTestData.TC08_teamName);
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC08_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC08_teamName)), "Failed to select TEAM");

			//base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeams(PoolTestData.TC08_teamName));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "POOLS")),"User is not able to view the POOLS Button");

			//Step 3: Under Games section, go to Pools page
			//Expected: Pool page should be loaded to the user as expected.
			base.excuteJsClick(LoginPageObj.Btn_SignInButton("POOLS"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"Pool page not loaded to the user as expected");

			//Step 3: Click three dots of any pool
			//Excepted:User Is  able to view the menu list.
			base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),PoolTestData.TC08_PoolName);
		    actions.sendKeys(Keys.ENTER).perform();
		    Thread.sleep(5000);
			//base.buttonClick(PoolObj.Btn_PoolDots(PoolTestData.TC08_PoolName));
		    base.buttonClick(MoveGameObj.Btn_3Dots(PoolTestData.TC08_PoolName));
			asrt.assertTrue(base.isExists(PoolObj.Ddl_PoolMenu("left-menu-list")),"Pool left menu is not displayed");

			//Step 4: Select Copy URL
			//Excepted:The user can able to Copy Pool URL.
			base.excuteJsClick(PoolObj.Ele_PoolLeftMenuOptions(PoolTestData.TC08_PoolName,"Copy URL"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Done!")),"User is not able to view the popup message as Copy URL");

		}

		// <summary>
		// Test Case Title : To verify whether the user can able to Delete Pool
		// Automation ID : TC_11
		// </summary>
		public void TC_11_CreateEditDeletePool() throws InterruptedException
		{
			Login login= new Login(driver);
			CommonData Commondata= new CommonData();
			LoginPage_Obj LoginPageObj= new LoginPage_Obj();
			Pool_Obj PoolObj= new Pool_Obj();
			Pool_TestData PoolTestData= new Pool_TestData();
			WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
			MoveGame_Obj MoveGameObj = new MoveGame_Obj();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
			AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
			
			//Step 1: Go to Games page
			//Expected: User should be navigated to Games page
			login.loginToApplication(Commondata.UserName,Commondata.PassWord);
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded.");

			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),PoolTestData.TC11_OrgName);
						
			//Step 2   :Select a Team from ORG
			//Expected:The New Team is Selected	
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), PoolTestData.TC11_teamName);
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC11_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC11_teamName)), "Failed to select TEAM");
			//base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeams(PoolTestData.TC11_teamName));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "POOLS")),"User is not able to view the POOLS Button");

			//Step 3: Under Games section, go to Pools page
			//Expected: Pool page should be loaded to the user as expected.
			base.excuteJsClick(LoginPageObj.Btn_SignInButton("POOLS"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"Pool page not loaded to the user as expected");

			//Step 3: Click three dots of any pool
			//Excepted:User Is  able to view the menu list.
			Thread.sleep(2000);	
			base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),PoolTestData.TC11_PoolName);
		    actions.sendKeys(Keys.ENTER).perform();
		    Thread.sleep(9000);
			base.buttonClick(MoveGameObj.Btn_3Dots(PoolTestData.TC11_PoolName));
			//base.excuteJsClick(PoolObj.Btn_PoolDots(PoolTestData.TC11_PoolName));
			asrt.assertTrue(base.isExists(PoolObj.Ddl_PoolMenu("left-menu-list")),"Pool left menu is not displayed");

			//Step 8: Select Delete
			//User should be able to delete the pool
			base.excuteJsClick(PoolObj.Ele_PoolLeftMenuOptions(PoolTestData.TC11_PoolName,"Delete"));
			asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Are you sure you want to delete")),"User is not navigated to Pool delete confirmation PopUp in the Games page.");
			base.buttonClick(LoginPageObj.Btn_SignInButton("Yes"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Done!")),"The user not able to delete the Pool ");
		}
		
		// <summary>
		//Test Case Title : To verify what happens when the user enters an invalid pool name.
		// Automation ID : TC_03
		// </summary>
		public void TC_03_CreateEditDeletePool() throws InterruptedException
		{
			Login login= new Login(driver);
			CommonData Commondata= new CommonData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			Pool_Obj PoolObj= new Pool_Obj();
			Pool_TestData PoolTestData= new Pool_TestData();
			WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
			MoveGame_Obj MoveGameObj = new MoveGame_Obj();
			SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

			//Step 1: Go to Games page
			//Expected: User should be navigated to Games page
			login.loginToApplication(Commondata.UserName,Commondata.PassWord);
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("GAMES")),"Games page is not loaded.");

			base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"),PoolTestData.TC02_OrgName);
						
			//Step 2   :Select a Team from ORG
			//Expected:The New Team is Selected	
			base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), PoolTestData.TC03_teamName);
			base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC03_teamName));
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",PoolTestData.TC03_teamName)), "Failed to select TEAM");
			//base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeams(PoolTestData.TC03_teamName));
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "POOLS")),"User is not able to view the POOLS Button");

			//Step 3: Under Games section, go to Pools page
			//Expected: Pool page should be loaded to the user as expected.
			base.excuteJsClick(LoginPageObj.Btn_SignInButton("POOLS"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Create Pool")),"Pool page not loaded to the user as expected");

			//Step 4: Click on Create Pool button
			//Expected: User should be able to click on Create Pool button 
			base.excuteJsClick(LoginPageObj.Edt_Alert1("Create Pool"));
			asrt.assertTrue(base.isExists(PoolObj.Ddl_CreatePool("poolModalHeader")),"Create pool page is not visible to the user.");
			base.setData(LoginPageObj.Edt_LoginEmail("pool_name"),PoolTestData.TC03_InvalidPoolName);

			//Step 4: Select the pool type in create pool area
			//Expected: User should be able to select Pool type. 
			base.selectorByVisibleText(PoolObj.Ele_PoolTypeDropDown("pool_type"),"SemiPrivate");

			//Step 5: Click on Create button in create pool area
			//Expected : The user will receive an alert message as "The Pool Name must be at least 2 characters."
			base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-primary create-btn border-0 btn-popup pool-create-btn"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("The Pool Name must be at least 2 characters.")),"User is not able to view an alert message as 'The Pool Name must be at least 2 characters.'");

		}
}	

