package testPage.MavenPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestData.AddSnipCollection_TestData;
import TestData.CommonData;
import TestData.EditSnip_TestData;
import objectRepository.AddFollower_Obj;
import objectRepository.AddSnipCollection_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.CreateUpdateDeleteGame_Obj;
import objectRepository.DeleteSnipPlayer_Obj;
import objectRepository.EditSnip_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import utilPack.BasePge;

public class AddSnipCollection extends BasePge {

	BasePge base;
	Assert asrt;

	public AddSnipCollection(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	
	// <summary>
	// Test Case Title :"To Verify that + option should displayed to add the Tags/Snips to the Snip collection in the player page(+ button displayed after we take the snips/tags)"
	// Automation ID   : Snip_1
	// </summary>
	public void Snip_1_AddSnipToCollection() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddSnipCollection_TestData AddSnipCollTestData = new AddSnipCollection_TestData();
		AddSnipCollection_Obj AddSnipCollectionObj = new AddSnipCollection_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3  :"Click Film icon on top of the page"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddSnipCollTestData.Snip_1_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddSnipCollTestData.Snip_1_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_1_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_1_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_1_EventOrGameName)),"Event Game is not Visible");

	    //Step 7  :Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_1_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddSnipCollTestData.Snip_1_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8 : Verify the  + button
		//Expected : User should able Verify the  + button
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection")),"User is not able to view the  + button");
	}

	// <summary>
	// Test Case Title :"To Verify that Add to Snip collection page should be displayed when click on +Button"
	// Automation ID   : Snip_2
	// </summary>
	public void Snip_2_AddSnipToCollection() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddSnipCollection_TestData AddSnipCollTestData = new AddSnipCollection_TestData();
		AddSnipCollection_Obj AddSnipCollectionObj = new AddSnipCollection_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();

		//Step 1 : "Navigate to the SnipBack page"
		//Expected : "User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2 : "Click Login"
		//Expected : "User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3 : "Click Film icon on top of the page"
		//Expected : "User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : "Select a OrgName"
		//Expected : "User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddSnipCollTestData.Snip_2_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddSnipCollTestData.Snip_2_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_2_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_2_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_2_EventOrGameName)),"Event Game is not Visible");

	    //Step 7  : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_2_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddSnipCollTestData.Snip_2_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 7 : Verify the  + button
		//Expected : User should Verify the  + button
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection")),"User is not able to view the  + button");

		//Step 8 : Click on the  + button
		//Expected : User should able clickable on the  + button and Add to Snip collection page should be displayed 
		base.excuteJsClick(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection")),"User is not able to clickable on the  + button and will not able to view the icon 'Add to collection'");

	}

	//<summary>
	//Test Case Title :"To Verify that Add to Snip collection page should be displayed the following;
	//1. Org Collections (eg: Demo Organization)
	//2.Home Collections"
	//Automation ID   : Snip_3
	//</summary>
	public void Snip_3_AddSnipToCollection() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddSnipCollection_TestData AddSnipCollTestData = new AddSnipCollection_TestData();
		AddSnipCollection_Obj AddSnipCollectionObj = new AddSnipCollection_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1 : "Navigate to the SnipBack page"
		//Expected : "User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2 : "Click Login"
		//Expected : "User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3 : "Click Film icon on top of the page"
		//Expected : "User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : "Select a OrgName"
		//Expected : "User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddSnipCollTestData.Snip_3_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddSnipCollTestData.Snip_3_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_3_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_3_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_3_EventOrGameName)),"Event Game is not Visible");

	    //Step 7  : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_3_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddSnipCollTestData.Snip_3_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 7 : Verify the  + button
		//Expected : "User should Verify the  + button"
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection")),"User is not able to view the  + button");

		//Step 8 : Click on the  + button
		//Expected : User should able clickable on the  + button and Add to Snip collection page should be displayed 
		base.excuteJsClick(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection")),"User is not able to clickable on the  + button and will not able to view the icon 'Add to collection'");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("stat-snipcollection-update")),"User unable to click on the 'Add to collection' icon and will not able to view 'Add to Snip collection' page");

		//Step 9 : Verify the Options
		//Expected : Add to Snip collection page should be displayed the following;
		//1. Org Collections
		//2. Home Collections
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_3_OrgName)), "User unable to view the 'Add to Snip collection' page and not displayed 'Org Collections' tab");
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections")), "User unable to view the 'Add to Snip collection' page and not displayed 'Home collections' tab");
	}

	// <summary>
	// Test Case Title :"Verify that Custom tags under both Org Collections &vHome Collections should be listed under the respective heading"
	// Automation ID   : Snip_4
	// </summary>
	public void Snip_4_AddSnipToCollection() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddSnipCollection_TestData AddSnipCollTestData = new AddSnipCollection_TestData();
		AddSnipCollection_Obj AddSnipCollectionObj = new AddSnipCollection_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();

		//Step 1 : "Navigate to the SnipBack page"
		//Expected : "User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2 : "Click Login"
		//Expected : "User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3 : "Click Film icon on top of the page"
		//Expected : "User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : "Select a OrgName"
		//Expected : "User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddSnipCollTestData.Snip_4_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddSnipCollTestData.Snip_4_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_4_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_4_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_4_EventOrGameName)),"Event Game is not Visible");

	    //Step 7  : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_4_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddSnipCollTestData.Snip_4_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 7 : Verify the  + button
		//Expected : "User should Verify the  + button"
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection")),"User is not able to view the  + button");

		//Step 8 : Click on the  + button
		//Expected : User should able clickable on the  + button and Add to Snip collection page should be displayed 
		base.excuteJsClick(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection")),"User is not able to clickable on the  + button and will not able to view the icon 'Add to collection'");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("stat-snipcollection-update")),"User unable to click on the 'Add to collection' icon and will not able to view 'Add to Snip collection' page");

		//Step 9 : Verify the Options
		//Expected : Add to Snip collection page should be displayed the following; 1. Org Collections 2. Home Collections
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_4_OrgName)), "User unable to view the 'Add to Snip collection' page and not displayed 'Org Collections' tab");
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections")), "User unable to view the 'Add to Snip collection' page and not displayed 'Home collections' tab");

		//Step 10 : Verify the cusotm tags
		//Expected : "Custom tags under both Org Collections &vHome Collections should be listed under the respective heading
		base.excuteJsClick(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_4_OrgName));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_demo("tabcontent-game-org-collection")), "User not be able to view that Custom tags under Org Collections should not be listed under the respective heading");
		base.excuteJsClick(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_demo("tabcontent-home-org-collection")), "User not be able to view that Custom tags under Home Collection should not be listed under the respective heading");

	}

	// <summary>
	// Test Case Title :"Verify that snips/tags with Check box above should be displayed when click on + button from the player page"
	// Automation ID   : Snip_5
	// </summary>
	public void Snip_5_AddSnipToCollection() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddSnipCollection_TestData AddSnipCollTestData = new AddSnipCollection_TestData();
		AddSnipCollection_Obj AddSnipCollectionObj = new AddSnipCollection_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1 : "Navigate to the SnipBack page"
		//Expected : "User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2 : "Click Login"
		//Expected : "User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3 : "Click Film icon on top of the page"
		//Expected : "User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : "Select a OrgName"
		//Expected : "User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddSnipCollTestData.Snip_5_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddSnipCollTestData.Snip_5_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_5_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_5_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_5_EventOrGameName)),"Event Game is not Visible");

	    //Step 7  : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_5_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddSnipCollTestData.Snip_5_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 7 : Verify the  + button
		//Expected : "User should Verify the  + button"
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection")),"User is not able to view the  + button");

		//Step 8 : Click on the  + button
		//Expected : User should able clickable on the  + button and Add to Snip collection page should be displayed 
		base.excuteJsClick(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection")),"User is not able to clickable on the  + button and will not able to view the icon 'Add to collection'");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("stat-snipcollection-update")),"User unable to click on the 'Add to collection' icon and will not able to view 'Add to Snip collection' page");

		//Step 9 : Verify the Options
		//Expected : Add to Snip collection page should be displayed the following; 1. Org Collections 2. Home Collections
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_5_OrgName)), "User unable to view the 'Add to Snip collection' page and not displayed 'Org Collections' tab");
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections")), "User unable to view the 'Add to Snip collection' page and not displayed 'Home collections' tab");

		//Step 10 : Verify the Tags/snips at the bottom of the player page
		//Expected : Snips/tags with Check box above should be displayed when click on + button from the player page
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("check-movesnip")), "User unable to view the snips/tags with Check box above when click on + button from the player page");

	}

	// <summary>
	// Test Case Title :"Verify that user should be able to click on the check box to add the snips/tags to the snip collection"
	// Automation ID   : Snip_6
	// </summary>
	public void Snip_6_AddSnipToCollection() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddSnipCollection_TestData AddSnipCollTestData = new AddSnipCollection_TestData();
		AddSnipCollection_Obj AddSnipCollectionObj = new AddSnipCollection_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1 : "Navigate to the SnipBack page"
		//Expected : "User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2 : "Click Login"
		//Expected : "User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3 : "Click Film icon on top of the page"
		//Expected : "User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : "Select a OrgName"
		//Expected : "User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddSnipCollTestData.Snip_6_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddSnipCollTestData.Snip_6_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_6_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_6_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_6_EventOrGameName)),"Event Game is not Visible");

	    //Step 7  : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_6_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddSnipCollTestData.Snip_6_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 7 : Verify the  + button
		//Expected : "User should Verify the  + button"
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection")),"User is not able to view the  + button");

		//Step 8 : Click on the  + button
		//Expected : User should able clickable on the  + button and Add to Snip collection page should be displayed 
		base.excuteJsClick(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection")),"User is not able to clickable on the  + button and will not able to view the icon 'Add to collection'");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("stat-snipcollection-update")),"User unable to click on the 'Add to collection' icon and will not able to view 'Add to Snip collection' page");

		//Step 9 : Verify the Options
		//Expected : Add to Snip collection page should be displayed the following; 1. Org Collections 2. Home Collections
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_6_OrgName)), "User unable to view the 'Add to Snip collection' page and not displayed 'Org Collections' tab");
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections")), "User unable to view the 'Add to Snip collection' page and not displayed 'Home collections' tab");

		//Step 10 : Verify the Tags/snips at the bottom of the player page
		//Expected : Snips/tags with Check box above should be displayed when click on + button from the player page
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("check-movesnip")), "User unable to view the snips/tags with Check box above when click on + button from the player page");

		//Step 11 : Click on the check box
		//Expected : User should be able to click on the check box to add the snips/tags to the snip collection
		base.excuteJsClick(AddSnipCollectionObj.Ele_Checkbox("check-movesnip"));
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("check-movesnip add-move-snip")), "User unable to mark the Check box to add the snips/tags to the snip collection");
	}

	// <summary>
	// Test Case Title :"Verify that user should be able to choose Single/multiple custom tags from Org collections as well as Home collections"
	// Automation ID   : Snip_7
	// </summary>
	public void Snip_7_AddSnipToCollection() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddSnipCollection_TestData AddSnipCollTestData = new AddSnipCollection_TestData();
		AddSnipCollection_Obj AddSnipCollectionObj = new AddSnipCollection_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1 : "Navigate to the SnipBack page"
		//Expected : "User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2 : "Click Login"
		//Expected : "User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3 : "Click Film icon on top of the page"
		//Expected : "User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : "Select a OrgName"
		//Expected : "User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddSnipCollTestData.Snip_7_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddSnipCollTestData.Snip_7_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_7_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_7_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_7_EventOrGameName)),"Event Game is not Visible");

	    //Step 7  : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_7_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddSnipCollTestData.Snip_7_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 7 : Verify the  + button
		//Expected : "User should Verify the  + button"
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection")),"User is not able to view the  + button");

		//Step 8 : Click on the  + button
		//Expected : User should able clickable on the  + button and Add to Snip collection page should be displayed 
		base.excuteJsClick(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection")),"User is not able to clickable on the  + button and will not able to view the icon 'Add to collection'");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("stat-snipcollection-update")),"User unable to click on the 'Add to collection' icon and will not able to view 'Add to Snip collection' page");

		//Step 9 : Verify the Options
		//Expected : Add to Snip collection page should be displayed the following; 1. Org Collections 2. Home Collections
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_7_OrgName)), "User unable to view the 'Add to Snip collection' page and not displayed 'Org Collections' tab");
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections")), "User unable to view the 'Add to Snip collection' page and not displayed 'Home collections' tab");

		//Step 10 : Verify the Tags/snips at the bottom of the player page
		//Expected : Snips/tags with Check box above should be displayed when click on + button from the player page
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("check-movesnip")), "User unable to view the snips/tags with Check box above when click on + button from the player page");

		//Step 11 : Click on the check box
		//Expected : User should be able to click on the check box to add the snips/tags to the snip collection
		base.excuteJsClick(AddSnipCollectionObj.Ele_Checkbox("check-movesnip"));
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("check-movesnip add-move-snip")), "User unable to mark the Check box to add the snips/tags to the snip collection");

		//Step 12 : Choose multiple/single custom tags from org collections/Home collections
		//Expected : User should be able to choose Single/multiple custom tags from Org collections as well as Home collections
		base.excuteJsClick(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_7_OrgName));
		base.excuteJsClick(AddSnipCollectionObj.Ele_CustomTag("AutomationOrg_Collection_01"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_CustomTag("AutomationOrg_Collection_02"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_HomeCollection("HomeCollection_03"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_HomeCollection("HomeCollection_04"));

	}

	// <summary>
	// Test Case Title :"Verify that 'Select All snips' option should be displayed in the 'Add to Snip collection page' to select all snips at the same time"
	// Automation ID   : Snip_8
	// </summary>
	public void Snip_8_AddSnipToCollection() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddSnipCollection_TestData AddSnipCollTestData = new AddSnipCollection_TestData();
		AddSnipCollection_Obj AddSnipCollectionObj = new AddSnipCollection_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1 : "Navigate to the SnipBack page"
		//Expected : "User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2 : "Click Login"
		//Expected : "User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3 : "Click Film icon on top of the page"
		//Expected : "User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : "Select a OrgName"
		//Expected : "User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddSnipCollTestData.Snip_8_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddSnipCollTestData.Snip_8_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_8_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_8_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_8_EventOrGameName)),"Event Game is not Visible");

	    //Step 7  : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_8_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddSnipCollTestData.Snip_8_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 7 : Verify the  + button
		//Expected : "User should Verify the  + button"
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection")),"User is not able to view the  + button");

		//Step 8 : Click on the  + button
		//Expected : User should able clickable on the  + button and Add to Snip collection page should be displayed 
		base.excuteJsClick(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection")),"User is not able to clickable on the  + button and will not able to view the icon 'Add to collection'");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("stat-snipcollection-update")),"User unable to click on the 'Add to collection' icon and will not able to view 'Add to Snip collection' page");

		//Step 9 : Verify the Options
		//Expected : Add to Snip collection page should be displayed the following; 1. Org Collections 2. Home Collections
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_8_OrgName)), "User unable to view the 'Add to Snip collection' page and not displayed 'Org Collections' tab");
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections")), "User unable to view the 'Add to Snip collection' page and not displayed 'Home collections' tab");

		//Step 10 : Verify the Tags/snips at the bottom of the player page
		//Expected : Snips/tags with Check box above should be displayed when click on + button from the player page
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("check-movesnip")), "User unable to view the snips/tags with Check box above when click on + button from the player page");

		//Step 11 : Choose multiple/single custom tags from org collections/Home collections
		//Expected : User should be able to choose Single/multiple custom tags from Org collections as well as Home collections
		base.excuteJsClick(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_8_OrgName));
		base.excuteJsClick(AddSnipCollectionObj.Ele_CustomTag("AutomationOrg_Collection_01"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_CustomTag("AutomationOrg_Collection_02"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_HomeCollection("HomeCollection_03"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_HomeCollection("HomeCollection_04"));

		//Step 12 : Verify the "Select All snips" option should be displayed in the 'Add to Snip collection page'
		//Expected : User should view the 'Select All snips' option displayed in the 'Add to Snip collection page'
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("container-checkbox mt-3 left-border-radius active")), "User unable to view the 'Select All snips' option displayed in the 'Add to Snip collection page'");
		base.excuteJsClick(AddSnipCollectionObj.Ele_Checkbox("container-checkbox mt-3 left-border-radius active"));
	}

	// <summary>
	// Test Case Title :"Verify that the snips are added to the selected snip collection once we click on tick option"
	// Automation ID   : Snip_9
	// </summary>
	public void Snip_9_AddSnipToCollection() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddSnipCollection_TestData AddSnipCollTestData = new AddSnipCollection_TestData();
		AddSnipCollection_Obj AddSnipCollectionObj = new AddSnipCollection_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1 : "Navigate to the SnipBack page"
		//Expected : "User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2 : "Click Login"
		//Expected : "User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3 : "Click Film icon on top of the page"
		//Expected : "User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : "Select a OrgName"
		//Expected : "User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddSnipCollTestData.Snip_9_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddSnipCollTestData.Snip_9_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_9_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_9_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_9_EventOrGameName)),"Event Game is not Visible");

	    //Step 7  : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_9_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddSnipCollTestData.Snip_9_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 7 : Verify the  + button
		//Expected : "User should Verify the  + button"
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection")),"User is not able to view the  + button");

		//Step 8 : Click on the  + button
		//Expected : User should able clickable on the  + button and Add to Snip collection page should be displayed 
		base.excuteJsClick(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection")),"User is not able to clickable on the  + button and will not able to view the icon 'Add to collection'");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("stat-snipcollection-update")),"User unable to click on the 'Add to collection' icon and will not able to view 'Add to Snip collection' page");

		//Step 9 : Verify the Options
		//Expected : Add to Snip collection page should be displayed the following; 1. Org Collections 2. Home Collections
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_9_OrgName)), "User unable to view the 'Add to Snip collection' page and not displayed 'Org Collections' tab");
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections")), "User unable to view the 'Add to Snip collection' page and not displayed 'Home collections' tab");

		//Step 10 : Verify the Tags/snips at the bottom of the player page
		//Expected : Snips/tags with Check box above should be displayed when click on + button from the player page
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("check-movesnip")), "User unable to view the snips/tags with Check box above when click on + button from the player page");

		//Step 11 : Choose multiple/single custom tags from org collections/Home collections
		//Expected : User should be able to choose Single/multiple custom tags from Org collections as well as Home collections
		base.excuteJsClick(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_9_OrgName));
		base.excuteJsClick(AddSnipCollectionObj.Ele_CustomTag("AutomationOrg_Collection_01"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_CustomTag("AutomationOrg_Collection_02"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_HomeCollection("HomeCollection_03"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_HomeCollection("HomeCollection_04"));

		//Step 12 : Verify the "Select All snips" option should be displayed in the 'Add to Snip collection page'
		//Expected : User should view the 'Select All snips' option displayed in the 'Add to Snip collection page'
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("container-checkbox mt-3 left-border-radius active")), "User unable to view the 'Select All snips' option displayed in the 'Add to Snip collection page'");
		base.excuteJsClick(AddSnipCollectionObj.Ele_Checkbox("container-checkbox mt-3 left-border-radius active"));

		//Step 13 : Click on Tick button
		//Expected : The snips are added to the selected snip collection once we click on tick option
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("stat-snip-submit-btn float-end"));
		Thread.sleep(8000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"'Snips added to collection succesfully' success message is not displayed");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
	}

	// <summary>
	// Test Case Title :"verify that a Success message should be displayed once we click on tick option"
	// Automation ID   : Snip_10
	// </summary>
	public void Snip_10_AddSnipToCollection() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddSnipCollection_TestData AddSnipCollTestData = new AddSnipCollection_TestData();
		AddSnipCollection_Obj AddSnipCollectionObj = new AddSnipCollection_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1 : "Navigate to the SnipBack page"
		//Expected : "User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2 : "Click Login"
		//Expected : "User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3 : "Click Film icon on top of the page"
		//Expected : "User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : "Select a OrgName"
		//Expected : "User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddSnipCollTestData.Snip_10_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddSnipCollTestData.Snip_10_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_10_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_10_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_10_EventOrGameName)),"Event Game is not Visible");

	    //Step 7  : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_10_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddSnipCollTestData.Snip_10_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 7 : Verify the  + button
		//Expected : "User should Verify the  + button"
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection")),"User is not able to view the  + button");

		//Step 8 : Click on the  + button
		//Expected : User should able clickable on the  + button and Add to Snip collection page should be displayed 
		base.excuteJsClick(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection")),"User is not able to clickable on the  + button and will not able to view the icon 'Add to collection'");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("stat-snipcollection-update")),"User unable to click on the 'Add to collection' icon and will not able to view 'Add to Snip collection' page");

		//Step 9 : Verify the Options
		//Expected : Add to Snip collection page should be displayed the following; 1. Org Collections 2. Home Collections
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_10_OrgName)), "User unable to view the 'Add to Snip collection' page and not displayed 'Org Collections' tab");
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections")), "User unable to view the 'Add to Snip collection' page and not displayed 'Home collections' tab");

		//Step 10 : Verify the Tags/snips at the bottom of the player page
		//Expected : Snips/tags with Check box above should be displayed when click on + button from the player page
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("check-movesnip")), "User unable to view the snips/tags with Check box above when click on + button from the player page");

		//Step 11 : Choose multiple/single custom tags from org collections/Home collections
		//Expected : User should be able to choose Single/multiple custom tags from Org collections as well as Home collections
		base.excuteJsClick(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_10_OrgName));
		base.excuteJsClick(AddSnipCollectionObj.Ele_CustomTag("AutomationOrg_Collection_01"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_CustomTag("AutomationOrg_Collection_02"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_HomeCollection("HomeCollection_03"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_HomeCollection("HomeCollection_04"));

		//Step 12 : Verify the "Select All snips" option should be displayed in the 'Add to Snip collection page'
		//Expected : User should view the 'Select All snips' option displayed in the 'Add to Snip collection page'
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("container-checkbox mt-3 left-border-radius active")), "User unable to view the 'Select All snips' option displayed in the 'Add to Snip collection page'");
		base.excuteJsClick(AddSnipCollectionObj.Ele_Checkbox("container-checkbox mt-3 left-border-radius active"));

		//Step 13 : Click on Tick button
		//Expected : The snips are added to the selected snip collection once we click on tick option
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("stat-snip-submit-btn float-end"));
		Thread.sleep(5000);
		
		//Step 14 : Verify the success message
		//Expected : A Success message should be displayed once we click on tick option
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"'Snips added to collection succesfully' success message is not displayed once we clicked on tick option");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
	}

	// <summary>
	// Test Case Title :"Verify that the snips with the name of selected custom tags of snipcollections shoud be displayed at the bottom of the player page"
	// Automation ID   : Snip_11
	// </summary>
	public void Snip_11_AddSnipToCollection() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
	    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		AddSnipCollection_TestData AddSnipCollTestData = new AddSnipCollection_TestData();
		AddSnipCollection_Obj AddSnipCollectionObj = new AddSnipCollection_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1 : "Navigate to the SnipBack page"
		//Expected : "User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2 : "Click Login"
		//Expected : "User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3 : "Click Film icon on top of the page"
		//Expected : "User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4 : "Select a OrgName"
		//Expected : "User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), AddSnipCollTestData.Snip_11_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 5 : click on search button and select a team
		//Expected : User should select the searched Team
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), AddSnipCollTestData.Snip_11_teamName);
		Thread.sleep(5000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_11_teamName));
		Thread.sleep(5000);
	    asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",AddSnipCollTestData.Snip_11_teamName)), "Failed to select TEAM");
	    Thread.sleep(5000);
	   
		//Step 6 : Select EVENTS/PRACTICES/SCOUT
        //Expected : Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_11_EventOrGameName)),"Event Game is not Visible");

	    //Step 7  : Click on Completed Game and Navigate to Player Page(Video play)
 		//Expected : Successfully Navigate to Player Page
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",AddSnipCollTestData.Snip_11_EventOrGameName));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+AddSnipCollTestData.Snip_11_EventOrGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 7 : Verify the  + button
		//Expected : "User should Verify the  + button"
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection")),"User is not able to view the  + button");

		//Step 8 : Click on the  + button
		//Expected : User should able clickable on the  + button and Add to Snip collection page should be displayed 
		base.excuteJsClick(AddSnipCollectionObj.Ele_PlusIcon("btnadd-statsnipcollection"));
		asrt.assertTrue(base.isExists(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection")),"User is not able to clickable on the  + button and will not able to view the icon 'Add to collection'");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("btn add-statsnip-collection","Add to collection"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("stat-snipcollection-update")),"User unable to click on the 'Add to collection' icon and will not able to view 'Add to Snip collection' page");

		//Step 9 : Verify the Options
		//Expected : Add to Snip collection page should be displayed the following; 1. Org Collections 2. Home Collections
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_11_OrgName)), "User unable to view the 'Add to Snip collection' page and not displayed 'Org Collections' tab");
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections")), "User unable to view the 'Add to Snip collection' page and not displayed 'Home collections' tab");

		//Step 10 : Verify the Tags/snips at the bottom of the player page
		//Expected : Snips/tags with Check box above should be displayed when click on + button from the player page
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("check-movesnip")), "User unable to view the snips/tags with Check box above when click on + button from the player page");

		//Step 11 : Choose multiple/single custom tags from org collections/Home collections
		//Expected : User should be able to choose Single/multiple custom tags from Org collections as well as Home collections
		base.excuteJsClick(AddSnipCollectionObj.Ele_OrgCollection("tabs",AddSnipCollTestData.Snip_11_OrgName));
		base.excuteJsClick(AddSnipCollectionObj.Ele_CustomTag("AutomationOrg_Collection_01"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_CustomTag("AutomationOrg_Collection_02"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_OrgCollection("tabs","Home collections"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_HomeCollection("HomeCollection_03"));
		base.excuteJsClick(AddSnipCollectionObj.Ele_HomeCollection("HomeCollection_04"));

		//Step 12 : Verify the "Select All snips" option should be displayed in the 'Add to Snip collection page'
		//Expected : User should view the 'Select All snips' option displayed in the 'Add to Snip collection page'
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_Checkbox("container-checkbox mt-3 left-border-radius active")), "User unable to view the 'Select All snips' option displayed in the 'Add to Snip collection page'");
		base.excuteJsClick(AddSnipCollectionObj.Ele_Checkbox("container-checkbox mt-3 left-border-radius active"));

		//Step 13 : Click on Tick button
		//Expected : The snips are added to the selected snip collection once we click on tick option
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("stat-snip-submit-btn float-end"));
		Thread.sleep(5000);
		
		//Step 14 : Verify the success message
		//Expected : A Success message should be displayed once we click on tick option
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")),"'Snips added to collection succesfully' success message is not displayed once we clicked on tick option");
		base.excuteJsClick(AddFollowerObj.Btn_FollowerCancel("swal-button swal-button--confirm","OK"));
		Thread.sleep(5000);

		//Step 15 : Verify the snips at the bottom of the player page
		//Expected : The snips with the name of selected custom tags of snipcollections shoud be displayed at the bottom of the player page
		driver.navigate().refresh();
		asrt.assertTrue(base.isExists(AddSnipCollectionObj.Ele_SnipCollection("each-shot  selected-pined1 foredshot1","N/A,AutomationOrg_Collection_01,AutomationOrg_Collection_02,HomeCollection_03,HomeCollection_04")), "User unable to view the snips with the name of selected custom tags of snip collections" );
	}
}

