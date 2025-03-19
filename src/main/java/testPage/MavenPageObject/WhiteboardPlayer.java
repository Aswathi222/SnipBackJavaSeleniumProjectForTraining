package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import TestData.CommonData;
import TestData.MoveGame_TestData;
import TestData.WhiteboardPlayer_TestData;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.EditSnip_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.TrimVideo_Obj;
import objectRepository.ViewListUpdateDownloadShareDeleteLibrary_Obj;
import objectRepository.WhiteboardPlayer_Obj;
import utilPack.BasePge;

public class WhiteboardPlayer extends BasePge {

	BasePge base;
	Assert asrt; 
	Actions actions = new Actions(driver);
	
	public WhiteboardPlayer(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	///<summary>
	// Test Case Title:"User can able to click the whiteboard button."
	// Automation ID  : WB_01_WhiteBoard	
	///</summary>
	public void WB_01_WhiteBoard() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData Commondata= new CommonData();
		Pool_Obj PoolObj =new Pool_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		WhiteboardPlayer_TestData WhiteboardPlayerTestData=new WhiteboardPlayer_TestData(); 
		WhiteboardPlayer_Obj WhiteboardPlayerObj = new WhiteboardPlayer_Obj();
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj= new ViewListUpdateDownloadShareDeleteLibrary_Obj();		
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);

		//Step 2   :"Click on Games Button"
		//Expected :"User should be able to click Games Button"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("nav-game-tab")),"User not able to click Games button");
		
		//Step 3   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), WhiteboardPlayerTestData.WB01_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
		
		//Step 4   :Select a Team from ORG
        //Expected:The New Team is Selected
		base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
		Thread.sleep(3000);			
		
		//Step 5   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 		
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Reels("table table-striped film-list")),"User Unable to Click the EVENTS button");

		//Step 6  :Click the whiteboard button
		//Expected: User can able to click the whiteboard button.
		String originalWindow = driver.getWindowHandle();//store the current window
		base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),WhiteboardPlayerTestData.WB01_Events);
		Thread.sleep(5000);
        actions.sendKeys(Keys.ENTER).perform();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB01_Events)),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB01_Events));
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB01_Events));	 
		
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Entire Game Video")),"Event Game Video Video is not Displaying");
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("highlight-reels-btn-section no-padd-top-bottom"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("highlight-reel-popup")),"User is not able to click the whiteboard button and not able to view the highlight reel popup.");
	
	}

	// <summary>
	// Test Case Title :"To verify what happens when user edit with a valid name"
	// Automation ID   : WB_14_WhiteBoard 
	// </summary>
	public void WB_14_WhiteBoard() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		WhiteboardPlayer_TestData WhiteboardPlayerTestData=new WhiteboardPlayer_TestData(); 
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj= new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), WhiteboardPlayerTestData.WB14_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
				
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
		Thread.sleep(3000);			
				
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Reels("table table-striped film-list")),"User Unable to Click the EVENTS button");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String WB14originalWindow = driver.getWindowHandle();//store the current window
		base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),WhiteboardPlayerTestData.WB14_Events);
		Thread.sleep(5000);
        actions.sendKeys(Keys.ENTER).perform();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB14_Events)),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB14_Events));
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB14_Events));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Entire Game Video")),"Event Game Video Video is not Displaying");

		//Step 9  :Click on WHITEBOARDS
		//Expected:The User should see the Whiteboards
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '80%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","WHITEBOARDS")),"Unable to find the WHITEBOARDS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","WHITEBOARDS"));

		//Step 10  :To verify what happens when user edit with a valid name.
		//Expected:The valid name should be saved without any issues.
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_WhiteBoardNameEdtBtn("section1 wbtitle","reel-icon btn-rename-whiteboard")),"Unable to view Edit button");	   		
		base.excuteJsClick(WhiteboardPlayerObj.Btn_WhiteBoardNameEdtBtn("section1 wbtitle","reel-icon btn-rename-whiteboard"));		
		asrt.assertTrue(base.isEnabledBy(WhiteboardPlayerObj.Ele_WhiteboardNameEdit("whiteboard-option-block", "wb_name")),"Unabel to edit the name");
		base.setData(WhiteboardPlayerObj.Ele_WhiteboardNameEdit("whiteboard-option-block", "wb_name"),base.CreateRandomWithoutNumbers(5));	
		String expected=base.GetValue(WhiteboardPlayerObj.Ele_WhiteboardNameEdit("whiteboard-option-block", "wb_name"));	
		base.excuteJsClick(WhiteboardPlayerObj.Ele_WhiteboardNameSave("whiteboard-option-block","Save"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText(expected)),"Unable to save to The edited valid name");
	}

	//<summary>
	// Test Case Title :"To verify what happens when user edit with a Invalid name"
	// Automation ID   : WB_15_WhiteBoard 
	// </summary>
	public void WB_15_WhiteBoard() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		WhiteboardPlayer_TestData WhiteboardPlayerTestData=new WhiteboardPlayer_TestData(); 
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj= new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), WhiteboardPlayerTestData.WB15_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
				
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
		Thread.sleep(3000);	
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Reels("table table-striped film-list")),"User Unable to Click the EVENTS button");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String WB14originalWindow = driver.getWindowHandle();//store the current window
		base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),WhiteboardPlayerTestData.WB15_Events);
		Thread.sleep(5000);
        actions.sendKeys(Keys.ENTER).perform();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB15_Events)),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB15_Events));
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB15_Events));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Entire Game Video")),"Event Game Video Video is not Displaying");

		//Step 9  :Click on WHITEBOARDS
		//Expected:The User should see the Whiteboards
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '80%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","WHITEBOARDS")),"Unable to find the WHITEBOARDS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","WHITEBOARDS"));

		//Step 10  :To verify what happens when user edit with a Invalid name
		//Expected:The user should get a ERROR popup message that"Allowed characters a-z 0-9,.-@?!#$%&:"
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_WhiteBoardNameEdtBtn("section1 wbtitle","reel-icon btn-rename-whiteboard")),"Unable to view Edit button");	   		
		base.excuteJsClick(WhiteboardPlayerObj.Btn_WhiteBoardNameEdtBtn("section1 wbtitle","reel-icon btn-rename-whiteboard"));		
		asrt.assertTrue(base.isEnabledBy(WhiteboardPlayerObj.Ele_WhiteboardNameEdit("whiteboard-option-block", "wb_name")),"Unabel to edit the name");	
		base.setData(WhiteboardPlayerObj.Ele_WhiteboardNameEdit("whiteboard-option-block", "wb_name"),"&53*9^)");	
		base.excuteJsClick(WhiteboardPlayerObj.Ele_WhiteboardNameSave("whiteboard-option-block","Save"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Allowed characters a-z 0-9,.-@?!#$%&:")),"ERROR popup message not found like Allowed characters a-z 0-9,.-@?!#$%&:");
	}

	//<summary>
	// Test Case Title :"To verify what happens when user leave the whiteboard name empty"
	// Automation ID   : WB_16_WhiteBoard 
	// </summary>
	public void WB_16_WhiteBoard() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		WhiteboardPlayer_TestData WhiteboardPlayerTestData=new WhiteboardPlayer_TestData(); 
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj= new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();		

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );
		
		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), WhiteboardPlayerTestData.WB16_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
						
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
		Thread.sleep(3000);	
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Reels("table table-striped film-list")),"User Unable to Click the EVENTS button");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String WB14originalWindow = driver.getWindowHandle();//store the current window
		base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),WhiteboardPlayerTestData.WB16_Events);
		Thread.sleep(5000);
        actions.sendKeys(Keys.ENTER).perform();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB16_Events)),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB16_Events));
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB16_Events));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Entire Game Video")),"Event Game Video Video is not Displaying");

		//Step 9  :Click on WHITEBOARDS
		//Expected:The User should see the Whiteboards
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '80%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","WHITEBOARDS")),"Unable to find the WHITEBOARDS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","WHITEBOARDS"));

		//Step 10  :To verify what happens when user edit with a Invalid name
		//Expected:The user should get a ERROR popup message that"Allowed characters a-z 0-9,.-@?!#$%&:"
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_WhiteBoardNameEdtBtn("section1 wbtitle","reel-icon btn-rename-whiteboard")),"Unable to view Edit button");	   		
		base.excuteJsClick(WhiteboardPlayerObj.Btn_WhiteBoardNameEdtBtn("section1 wbtitle","reel-icon btn-rename-whiteboard"));		
		asrt.assertTrue(base.isEnabledBy(WhiteboardPlayerObj.Ele_WhiteboardNameEdit("whiteboard-option-block", "wb_name")),"Unabel to edit the name");
		base.clearData(WhiteboardPlayerObj.Ele_WhiteboardNameEdit("whiteboard-option-block", "wb_name"));	
		base.buttonClick(WhiteboardPlayerObj.Ele_WhiteboardNameSave("whiteboard-option-block","Save"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Whiteboard Name is required")),"Unable to view message that\"Whiteboard Name is required\"");
	}

	//<summary>
	// Test Case Title :"To verify what happens when user Click the delete button and click No"
	// Automation ID   : WB_18_WhiteBoard 
	// </summary>
	public void WB_18_WhiteBoard() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		EditSnip_Obj EditSnipObj= new EditSnip_Obj();	
		WhiteboardPlayer_TestData WhiteboardPlayerTestData=new WhiteboardPlayer_TestData(); 
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj= new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), WhiteboardPlayerTestData.WB18_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
						
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
		Thread.sleep(3000);	
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Reels("table table-striped film-list")),"User Unable to Click the EVENTS button");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String WB14originalWindow = driver.getWindowHandle();//store the current window
		base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),WhiteboardPlayerTestData.WB18_Events);
		Thread.sleep(5000);
        actions.sendKeys(Keys.ENTER).perform();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB18_Events)),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB18_Events));
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB18_Events));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Entire Game Video")),"Event Game Video Video is not Displaying");

		//Step 9  :Click on WHITEBOARDS
		//Expected:The User should see the Whiteboards
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '80%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","WHITEBOARDS")),"Unable to find the WHITEBOARDS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","WHITEBOARDS"));

		String expectedwhiteboard=base.GetValue(LoginPageObj.Ele_ErrorMessage("section1 wbtitle"));
		base.excuteJsClick(WhiteboardPlayerObj.Btn_WhiteBoardNameEdtBtn("section1 wbtitle","reel-icon btn-delete-whiteboard"));	
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Do you want to delete this whiteboard?")), "User s not able to view the Do you want to delete this whiteboard? alert in the WhiteBoard pate");

		//Step 10  :To verify what happens when user Click the delete button and click No
		//Expected:The user shouldn't remove the whiteboard from the list of whiteboards.	
		base.excuteJsClick(EditSnipObj.Btn_Done("swal-modal","Cancel"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("section1 wbtitle")),"user removed the whiteboard from the list of whiteboards");
	}

	//<summary>
	// Test Case Title :"To verify what happens when user click the Share button"
	// Automation ID   : WB_20_WhiteBoard 
	// </summary>
	public void WB_20_WhiteBoard() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		EditSnip_Obj EditSnipObj= new EditSnip_Obj();		
		WhiteboardPlayer_TestData WhiteboardPlayerTestData=new WhiteboardPlayer_TestData(); 
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj= new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), WhiteboardPlayerTestData.WB20_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
								
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
		Thread.sleep(3000);	
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Reels("table table-striped film-list")),"User Unable to Click the EVENTS button");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page		
		String WB14originalWindow = driver.getWindowHandle();//store the current window
		base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),WhiteboardPlayerTestData.WB19_Events);
		Thread.sleep(5000);
        actions.sendKeys(Keys.ENTER).perform();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB19_Events)),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB19_Events));
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB19_Events));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Entire Game Video")),"Event Game Video Video is not Displaying");

		//Step 9  :Click on WHITEBOARDS
		//Expected:The User should see the Whiteboards
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '80%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","WHITEBOARDS")),"Unable to find the WHITEBOARDS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","WHITEBOARDS"));
			   
		//Step 10  :To verify what happens when user click the Share button
		//Expected:The User should get the available sharing options are displayed correctly.
		base.excuteJsClick(WhiteboardPlayerObj.Btn_WhiteBoardNameEdtBtn("section1 wbtitle","reel-icon btn-share-whiteboard"));	
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Ele_WhiteboardShare("Share"))," Unable to get the available sharing options");
	}		

	//<summary>
	// Test Case Title :"To verify what happens when user click the download button"
	// Automation ID   : WB_19_WhiteBoard 
	// </summary>
	public void WB_19_WhiteBoard() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();			
		Pool_Obj PoolObj = new Pool_Obj();		
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		WhiteboardPlayer_Obj WhiteboardPlayerObj= new WhiteboardPlayer_Obj();
		EditSnip_Obj EditSnipObj= new EditSnip_Obj();		
		WhiteboardPlayer_TestData WhiteboardPlayerTestData=new WhiteboardPlayer_TestData(); 
		ViewListUpdateDownloadShareDeleteLibrary_Obj ViewListUpdateDownloadShareDeleteLibraryObj= new ViewListUpdateDownloadShareDeleteLibrary_Obj();
		AddUpdateRemoveMember_Obj addupdateremoveMemberObj = new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User unable to navigate Film page in Snipback");

		//Step 4   :"Navigate to Games Button"
		//Expected :"User should be navigated to Games"
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), WhiteboardPlayerTestData.WB19_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		asrt.assertTrue(base.isEnabledBy(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
								
		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.excuteJsClick(WhiteboardPlayerObj.Ele_ListedTeamSemTest("my-team-content","all-teams text-dark","SemTest"));
		Thread.sleep(3000);	
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(ViewListUpdateDownloadShareDeleteLibraryObj.Ele_Reels("table table-striped film-list")),"User Unable to Click the EVENTS button");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String WB14originalWindow = driver.getWindowHandle();//store the current window
		base.setData(addupdateremoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),WhiteboardPlayerTestData.WB19_Events);
		Thread.sleep(5000);
        actions.sendKeys(Keys.ENTER).perform();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB19_Events)),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB19_Events));
        base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",WhiteboardPlayerTestData.WB19_Events));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolDeleteConfirmationPopUp("Entire Game Video")),"Event Game Video Video is not Displaying");

		//Step 9  :Click on WHITEBOARDS
		//Expected:The User should see the Whiteboards
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS")),"Unable to find HIGHLIGHTS & WHITEBOARDS in Player Page");
		base.buttonClick(WhiteboardPlayerObj.Btn_HighWhiteboard("container-fluid", "HIGHLIGHTS & WHITEBOARDS"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '80%'");
		asrt.assertTrue(base.isExists(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","WHITEBOARDS")),"Unable to find the WHITEBOARDS");    
		base.excuteJsClick(WhiteboardPlayerObj.Btn_HighWhiteboard("highlight-reel-popup","WHITEBOARDS"));
		
		//Step 10  :To verify what happens when user click the Share button
		//Expected:The User should get the available sharing options are displayed correctly.
		Thread.sleep(2000);
		base.excuteJsClick(WhiteboardPlayerObj.Btn_WhiteBoardNameEdtBtn("section1 wbtitle","reel-icon btn-download-whiteboard"));	
		base.switchToWindowByIndex(driver,2);
		String CurrentUrl= driver.getCurrentUrl();
		if(CurrentUrl.contains(".mp4")) {
			System.out.println("Success:Navigated to an mp4 URL"+CurrentUrl );
		}
		else {
			System.out.println("Failure:URL does not contain mp4");
		}
		
	}
}

