package testPage.MavenPageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestData.CommonData;
import TestData.KeyboardShortcut_TestData;
import objectRepository.AddFollower_Obj;
import objectRepository.DualView_Obj;
import objectRepository.KeyboardShortcut_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import utilPack.BasePge;

public class KeyboardShortcut extends BasePge {

	BasePge base;
	Assert asrt;

	public KeyboardShortcut(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify whether there is a option for list of Keyboard Shortcuts in the player page.."
	// Automation ID   : KS_01
	// </summary>
	public void KS_01_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_01_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_01_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_01_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_01_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_01_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_01_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_01_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_01_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 6:To check user able to view 'Keyboard shortcut icon'
		//Expected:"User should able to view 'Keyboard shortcut icon'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"There should not be a option for list of Keyboard Shortcuts in Player page.");	
	}
	
	// <summary>
	// Test Case Title :"To verify what happen when user clicks the Keyboard Shortcuts option.."
	// Automation ID   : KS_02
	// </summary>
	public void KS_02_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_02_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_02_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_02_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_02_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_02_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_02_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_02_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_02_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9:Click on 'Keyboard shortcut icon'
		//Expected:"The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");		
		Thread.sleep(3000);
	}
	
	// <summary>
	// Test Case Title :"To verify what happens when user clicks SPACEBAR or  Letter 'K' in the Keyboard."
	// Automation ID   : KS_03
	// </summary>
	public void KS_03_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_03_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_03_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_03_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_03_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_03_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_03_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_03_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_03_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Step 10 : Click SPACEBAR or letter 'K'
		//Expected : "The user should able to Play or Pause the video."
		base.pressKey(null, "KEYBOARD_SPACE");
		//asrt.assertTrue(base.isExists(KeyboardShortcutObj.Btn_KBShortcut("vjs-play-control vjs-control vjs-button vjs-paused","vjs-control-text","Play")),"The user not able to Play or Pause the video.");	
	}
				
	// <summary>
	// Test Case Title :"To verify what happens when user clicks the Letter 'M' in the Keyboard.."
	// Automation ID   : KS_04
	// </summary>
	public void KS_04_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_04_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_04_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_04_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_04_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_04_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_04_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_04_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_04_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Step 10 : Click the letter 'M'
		//Expected : "The user should able to mute or unmute the video."
        base.pressKey(null,"KEYBOARD_M");
        Thread.sleep(1000);
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Btn_KBShortcut("vjs-mute-control vjs-control vjs-button vjs-vol-3","vjs-control-text","Mute")),"The user not able to mute or unmute the video.");	
	}
				
	// <summary>
	// Test Case Title :"To verify what happens when user clicks the Left or Right Arrow in the Keyboard.."
	// Automation ID   : KS_05
	// </summary>
	public void KS_05_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_05_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_05_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_05_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_05_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_05_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_05_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_05_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_05_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Step 10 : Click the Left or Right Arrow
		//Expected : "The user should able to Skip 3sec forward in a video."
		base.pressKey(null,"KEYBOARD_RIGHTARROW");
	}
				
	// <summary>
	// Test Case Title :"To verify what happens when user clicks the Letter 'L' in the Keyboard."
	// Automation ID   : KS_06
	// </summary>
	public void KS_06_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_06_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_06_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_06_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_06_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_06_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_06_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_06_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_06_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Step 10 : Click the letter 'L'
		//Expected : "The user should able to Skip 7sec forward in a video."
		base.pressKey(null,"KEYBOARD_L");
	}
				
	// <summary>
	// Test Case Title :"To verify what happens when user clicks the Letter 'J' in the Keyboard."
	// Automation ID   : KS_07
	// </summary>
	public void KS_07_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_07_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_07_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_07_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_07_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_07_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_07_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_07_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_07_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Step 10 : Click the letter 'J'
		//Expected : "The user should able to Skip 7sec back in a video."
		base.pressKey(null,"KEYBOARD_J");
	}
				
	// <summary>
	// Test Case Title :"To verify what happens when user clicks the single quotes(') in the Keyboard."
	// Automation ID   : KS_08
	// </summary>
	public void KS_08_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_08_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_08_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_08_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_08_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_08_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_08_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_08_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_08_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Step 10 : Click single quotes(')
		//Expected:"The user should able to skip to the previous frame when the video is paused."
		base.pressKey(null,"KEYBOARD_'");
	}
				
	// <summary>
	// Test Case Title :"To verify what happens when user clicks dot (.) in the Keyboard."
	// Automation ID   : KS_09
	// </summary>
	public void KS_09_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_09_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_09_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_09_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_09_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_09_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_09_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_09_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_09_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Step 10 : Click dot (.)
		//Expected : "The user should able to skip to the next frame when the video is paused."
		base.pressKey(null,"KEYBOARD_.");
	}
				
	// <summary>
	// Test Case Title :"To verify what happens when user clicks Greater than(>) in the Keyboard.."
	// Automation ID   : KS_10
	// </summary>
	public void KS_10_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_10_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_10_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_10_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_10_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_10_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_10_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_10_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_10_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Step 10 : Click Less than(<) or Greater than(>)
		//Expected : "The user should able to Speed up/ slow down video play back."
		base.pressKey(null,"KEYBOARD_>");
	}
				
	// <summary>
	// Test Case Title :"To verify what happens when user clicks Down arrow in the Keyboard."
	// Automation ID   : KS_11
	// </summary>
	public void KS_11_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_11_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_11_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_11_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_11_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_11_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_11_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_11_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_11_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Step 10 : Click Up or Down arrow
		//Expected : "The user should able to Change views for multi view videos."
		base.pressKey(null,"KEYBOARD_DOWN");
	}
				
	// <summary>
	// Test Case Title :"To verify what happens when user clicks close square brackets ( ] ) in the Keyboard."
	// Automation ID   : KS_12
	// </summary>
	public void KS_12_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		DualView_Obj DualViewObj = new DualView_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_12_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_12_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_12_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_12_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_12_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_12_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_12_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_12_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
	    //Step 10 : To create a new Snip
 		//Expected : Successfully Created a Snip
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-snip")),"Unable to take Snip of the Video");
        base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-snip"));
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateMySnip("d-flex flex-column bg-body list-wrap pb-3", "My Snips")),"Unable to select the Type of Snip needed");
        base.excuteJsClick(MoveGameObj.Btn_Video_CreateMySnip("d-flex flex-column bg-body list-wrap pb-3", "My Snips"));
        asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateBtnSnip("swal-button-container", "Snip")),"Unable to select the 'Snip' in Snip section details");
        base.excuteJsClick(MoveGameObj.Btn_Video_CreateBtnSnip("swal-button-container", "Snip"));
        Thread.sleep(5000);
        base.excuteJsClick(MoveGameObj.Btn_Video_SnipDetails("row entire-video-shot-section", "My Snips"));
        Thread.sleep(5000);	
		
		//Step 11 : verify and click NoTag box
		//Expected : "User should able to select notagbox
		asrt.assertTrue(base.isExists(DualViewObj.Ele_NoTag("allFrame")),"'NoTag Box' option is not displayed below video");
		base.excuteJsClick(DualViewObj.Ele_NoTag("allFrame"));					
		Thread.sleep(5000);
		
		//Step 12 : Click open square brackets ( ] )
		//Expected : "The user should able to skip to next snip."
		base.pressKey(null,"KEYBOARD_]");
	}
				
	// <summary>
	// Test Case Title :"To verify what happens when user clicks open square brackets ( [ ) in the Keyboard."
	// Automation ID   : KS_13
	// </summary>
	public void KS_13_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		DualView_Obj DualViewObj = new DualView_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_13_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_13_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_13_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_13_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_13_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_13_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_13_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_13_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
	    //Step 10 : To create a new Snip
 		//Expected : Successfully Created a Snip
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-snip")),"Unable to take Snip of the Video");
        base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-snip"));
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateMySnip("d-flex flex-column bg-body list-wrap pb-3", "My Snips")),"Unable to select the Type of Snip needed");
        base.excuteJsClick(MoveGameObj.Btn_Video_CreateMySnip("d-flex flex-column bg-body list-wrap pb-3", "My Snips"));
        asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateBtnSnip("swal-button-container", "Snip")),"Unable to select the 'Snip' in Snip section details");
        base.excuteJsClick(MoveGameObj.Btn_Video_CreateBtnSnip("swal-button-container", "Snip"));
        Thread.sleep(5000);
        base.excuteJsClick(MoveGameObj.Btn_Video_SnipDetails("row entire-video-shot-section", "My Snips"));
        Thread.sleep(5000);	
		
		//Step 11 : verify and click NoTag box
		//Expected : "User should able to select notagbox
		asrt.assertTrue(base.isExists(DualViewObj.Ele_NoTag("allFrame")),"'NoTag Box' option is not displayed below video");
		base.excuteJsClick(DualViewObj.Ele_NoTag("allFrame"));					
		Thread.sleep(5000);
		
		//Step 12 : Click open square brackets ( [ )
		//Expected : "The user should able to skip to previous snip."
		base.pressKey(null,"KEYBOARD_[");
	}
				
	// <summary>
	// Test Case Title :"To verify what happens when user clicks 0-9 in the Keyboard."
	// Automation ID   : KS_14
	// </summary>
	public void KS_14_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_14_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_14_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_14_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_14_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_14_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_14_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_14_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_14_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Step 10 : Click 0-9
		//Expected : "The user should able to skip to a different view in a video."
		base.pressKey(null,"KEYBOARD_1-9");
	}
				
	// <summary>
	// Test Case Title :"To verify what happens when user clicks the letter 'F' in the Keyboard."
	// Automation ID   : KS_15
	// </summary>
	public void KS_15_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_15_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_15_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_15_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_15_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_15_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_15_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_15_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_15_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Step 10 : Click the letter 'F'
		//Expected:"The user should able to take the video in and out of full screen mode."
		base.pressKey(null,"KEYBOARD_F");
	}		
	
	// <summary>
	// Test Case Title :"To verify what happens when user clicks the letter 'D' in the Keyboard."
	// Automation ID   : KS_17
	// </summary>
	public void KS_17_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_17_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_17_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_17_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_17_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_17_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_17_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_17_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_17_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Step 10 : Click the letter 'D'
		//Expected:"The user should able to create Simple snip"
		base.pressKey(null,"KEYBOARD_D");
	}
	
	// <summary>
	// Test Case Title :"To verify what happens when user clicks the letter 'S' in the Keyboard."
	// Automation ID   : KS_16
	// </summary>
	public void KS_16_KeyboardShortcut() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		KeyboardShortcut_TestData KSTestData = new KeyboardShortcut_TestData();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		KeyboardShortcut_Obj KeyboardShortcutObj = new KeyboardShortcut_Obj();
		AddFollower_Obj AddFollowerObj = new AddFollower_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(3000);
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), KSTestData.KS_16_OrgName);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_16_TeamName, "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_16_TeamName, "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName(KSTestData.KS_16_TeamName, "d-flex align-items-center item-label"));

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_16_GameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_16_GameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",KSTestData.KS_16_GameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+KSTestData.KS_16_GameName)),"Different Event Game Video/Irrelevant Video is Displaying");
		Thread.sleep(5000);
		
		//Step 9 : Click on 'Keyboard shortcut icon'
		//Expected : "The list of Keyboard Shortcuts page should pop up.'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut")),"User is not navigated to the Keyboard shortcut in player page while clicking on Game ");	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-shortcut"));
		asrt.assertTrue(base.isExists(KeyboardShortcutObj.Ele_KBPop("keyboard-shortcuts-info","img-block")),"The list of Keyboard Shortcuts page is not shown.");	
		Thread.sleep(3000);
		base.excuteJsClick(AddFollowerObj.Btn_MailTick("keyboard-shortcuts-info", "icofont-close"));
		Thread.sleep(3000);
		
		//Added for bug
		//Step 10 : Verify to create Simple snip.
		//Expected : "The user should able to create Simple snip"
		base.pressKey(null,"KEYBOARD_D");
		
		//Step 11 : Click the letter 'S'
		//Expected : "The user should able to view create snip popup"
		base.pressKey(null,"KEYBOARD_S");			
	}
}
