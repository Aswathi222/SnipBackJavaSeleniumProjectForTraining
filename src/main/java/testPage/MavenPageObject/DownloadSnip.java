package testPage.MavenPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestData.CommonData;
import TestData.DownloadSnip_TestData;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.DeleteSnipPlayer_Obj;
import objectRepository.DownloadSnip_Obj;
import objectRepository.LikeGame_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import utilPack.BasePge;

public class DownloadSnip extends BasePge {

	BasePge base;
	Assert asrt; 

	public DownloadSnip(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify whether there is a option to download snip."
	// Automation ID   : DS_01
	// </summary>
	public void DS_01_DownloadSnipPlayerPage() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
        DownloadSnip_TestData DownloadSnipTestData = new DownloadSnip_TestData();
        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
        DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
       
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DownloadSnipTestData.DS_01_DownloadSnip);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 6   :Select a Team from ORG
        //Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
        //Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);
		
	    //Step 8  :Click on Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library")),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));
        base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - Library")),"User is not able to view the player page while clicking on Game");     
          
	    //Step 9  :To view the download icon and download a snip from player page
		//Expected: User should be able to view the download icon and download a snip from player page
	    base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded")),"No Option to Download Snip from Player Page");		
	}		
	
	// <summary>
	// Test Case Title :"To verify what happens when user clicks the Download Snip Icon"
	// Automation ID   : DS_02
	// </summary>
	public void DS_02_DownloadSnipPlayerPage() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		Pool_Obj PoolObj = new Pool_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
        DownloadSnip_TestData DownloadSnipTestData = new DownloadSnip_TestData();
        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
        DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
       
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DownloadSnipTestData.DS_01_DownloadSnip);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 6   :Select a Team from ORG
        //Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		
		//Step 7   :Select EVENTS/PRACTICES/SCOUT
        //Expected:Successfully selected the EVENTS 
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);
		
	    //Step 8  :Click on Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library")),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));
        base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - Library")),"Different Event Game Video/Irrelevant Video is Displaying");     
        
	    //Step 9  :To view the download icon and download a snip from player page
		//Expected: User should be able to view the download icon and download a snip from player page
	    base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded")),"No Option to Download Snip from Player Page");	
		
		//Step 10 : Click on the Download Snip Icon
		//Expected: A progress bar with title "Download link generation in progress..." should display at the left side of the screen.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Download link generation in progress...")),"User is not able to see the progress bar while downloading the snip from Player Page");			
	}	
	
	// <summary>
	// Test Case Title :"To verify whether the snip option is disabled during the snip download process."
	// Automation ID   : DS_04
	// </summary>
	public void DS_04_DownloadSnipPlayerPage() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		Pool_Obj PoolObj = new Pool_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
        DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
        DownloadSnip_TestData DownloadSnipTestData = new DownloadSnip_TestData();
       
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DownloadSnipTestData.DS_01_DownloadSnip);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 6   :Select a Team from ORG
        //Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
        //Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);
		
	    //Step 8  :Click on Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library")),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));
        base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - Library")),"Different Event Game Video/Irrelevant Video is Displaying");     
         
	    //Step 9  :To view the download icon and download a snip from player page
		//Expected: User should be able to view the download icon and download a snip from player page
	    base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded")),"No Option to Download Snip from Player Page");	
		
		//Step 10 : Click on the Download Snip Icon
		//Expected: A progress bar with title "Download link generation in progress..." should display at the left side of the screen.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Download link generation in progress...")),"User is not able to see the progress bar while downloading the snip from Player Page");			
		
		//Step 11 : To verify whether the snip option is disabled during the snip download process.
		//Expected : The snip creating option should be disabled when the snip downloading is in progress.
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark tool-disabled")),"Create Snip Icon is not disabled during the snip download process");	
	}	
	
	// <summary>
	// Test Case Title :"To verify whether the download option is disabled after the first click and the process begins."
	// Automation ID   : DS_06
	// </summary>
	public void DS_06_DownloadSnipPlayerPage() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		Pool_Obj PoolObj = new Pool_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
        DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
        DownloadSnip_TestData DownloadSnipTestData = new DownloadSnip_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DownloadSnipTestData.DS_01_DownloadSnip);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 6   :Select a Team from ORG
        //Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
        //Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);
		
	    //Step 8  :Click on Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library")),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));
        base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - Library")),"Different Event Game Video/Irrelevant Video is Displaying");     
        
	    //Step 9  :To view the download icon and download a snip from player page
		//Expected: User should be able to view the download icon and download a snip from player page
	    base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded")),"No Option to Download Snip from Player Page");	
		
		//Step 10 : Click on the Download Snip Icon
		//Expected: A progress bar with title "Download link generation in progress..." should display at the left side of the screen.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Download link generation in progress...")),"User is not able to see the progress bar while downloading the snip from Player Page");			
		
		//Step 11 : To verify whether the snip option is disabled during the snip download process.
		//Expected : The snip creating option should be disabled when the snip downloading is in progress.
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark tool-disabled")),"Create Snip Icon is not disabled during the snip download process");	
	
		//Step 12 : To verify whether the download option is disabled after the first click and the process begins
		//Expected : The download option should be disabled once the download process begins.
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded btn-disable")),"Download Icon is not disabled during the snip download process");	
	}
	
	// <summary>
	// Test Case Title :"To verify what happens when the downloading progress bar completes."
	// Automation ID   : DS_03
	// </summary>
	public void DS_03_DownloadSnipPlayerPage() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		Pool_Obj PoolObj = new Pool_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
        DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
        DownloadSnip_Obj DownloadSnipObj = new DownloadSnip_Obj();
        DownloadSnip_TestData DownloadSnipTestData = new DownloadSnip_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DownloadSnipTestData.DS_01_DownloadSnip);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 6   :Select a Team from ORG
        //Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
        //Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);
		
	    //Step 8  :Click on Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library")),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));
        base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - Library")),"Different Event Game Video/Irrelevant Video is Displaying");     

	    //Step 9  :To view the download icon and download a snip from player page
		//Expected: User should be able to view the download icon and download a snip from player page
	    base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded")),"No Option to Download Snip from Player Page");	
		
		//Step 10 : Click on the Download Snip Icon
		//Expected: A progress bar with title "Download link generation in progress..." should display at the left side of the screen.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Download link generation in progress...")),"User is not able to see the progress bar while downloading the snip from Player Page");	
	    Thread.sleep(3000);
		
		//Step 11 : To verify what happens when the downloading progress bar completes.
		//Expected : When the progress bar completes, a "Completed" message should appear on the left side of the screen.
		asrt.assertTrue(base.isExists(DownloadSnipObj.Ele_DownloadPBar("downladScroll","Completed")),"User is not able to see the progress bar completes popup while downloading the snip from Player Page");	
	}
	
	// <summary>
	// Test Case Title :"To verify whether the snip option is enabled once the downloading process completes."
	// Automation ID   : DS_05
	// </summary>
	public void DS_05_DownloadSnipPlayerPage() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();	
		Pool_Obj PoolObj = new Pool_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
        DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
        DownloadSnip_Obj DownloadSnipObj = new DownloadSnip_Obj();
        DownloadSnip_TestData DownloadSnipTestData = new DownloadSnip_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DownloadSnipTestData.DS_01_DownloadSnip);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 6   :Select a Team from ORG
        //Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
        //Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);
		
	    //Step 8  :Click on Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library")),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));
        base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - Library")),"Different Event Game Video/Irrelevant Video is Displaying");     
          
	    //Step 9  :To view the download icon and download a snip from player page
		//Expected: User should be able to view the download icon and download a snip from player page
	    base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded")),"No Option to Download Snip from Player Page");	
		
		//Step 10 : Click on the Download Snip Icon
		//Expected: A progress bar with title "Download link generation in progress..." should display at the left side of the screen.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Download link generation in progress...")),"User is not able to see the progress bar while downloading the snip from Player Page");	
		
		//Step 11 : To verify what happens when the downloading progress bar completes.
		//Expected : When the progress bar completes, a "Completed" message should appear on the left side of the screen.
		asrt.assertTrue(base.isExists(DownloadSnipObj.Ele_DownloadPBar("downladScroll","Completed")),"User is not able to see the progress bar completes popup while downloading the snip from Player Page");	
		Thread.sleep(10000);
		//Step 12 : To verify whether the snip option is enabled once the downloading process completes.
		//Expected : The snip creating option should enable once the downloading process completes and refresh the player page.
        driver.navigate().refresh();
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"Create Snip Icon is not enabled after the snip download process");
	}
	
	// <summary>
	// Test Case Title :"To verify whether the download option is enabled once the previous snip downloading process completes."
	// Automation ID   : DS_07
	// </summary>
	public void DS_07_DownloadSnipPlayerPage() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();		
		Pool_Obj PoolObj = new Pool_Obj();
        MoveGame_Obj MoveGameObj= new MoveGame_Obj();
        SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
        DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
        DownloadSnip_Obj DownloadSnipObj = new DownloadSnip_Obj();
        DownloadSnip_TestData DownloadSnipTestData = new DownloadSnip_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DownloadSnipTestData.DS_01_DownloadSnip);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		
		//Step 6   :Select a Team from ORG
        //Expected:The New Team is Selected
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label")),"User Unable to Select a Team from Organization");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		base.excuteJsClick(MoveGameObj.Btn_Select_TeamName("Backup Team", "d-flex align-items-center item-label"));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
        //Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		Thread.sleep(5000);
		
	    //Step 8  :Click on Game and Navigate to Player Page(Video play)
 		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
        asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library")),"Event Game is not Visible");
        base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));
        base.buttonClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset","Library"));	 
        Thread.sleep(5000);
        base.switchToWindowByIndex(driver,1);//Switching to another window
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - Library")),"Different Event Game Video/Irrelevant Video is Displaying");     
               
	    //Step 9  :To view the download icon and download a snip from player page
		//Expected: User should be able to view the download icon and download a snip from player page
	    base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded")),"No Option to Download Snip from Player Page");	
		
		//Step 10 : Click on the Download Snip Icon
		//Expected: A progress bar with title "Download link generation in progress..." should display at the left side of the screen.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Download link generation in progress...")),"User is not able to see the progress bar while downloading the snip from Player Page");	
		
		//Step 11 : To verify what happens when the downloading progress bar completes.
		//Expected : When the progress bar completes, a "Completed" message should appear on the left side of the screen.
		asrt.assertTrue(base.isExists(DownloadSnipObj.Ele_DownloadPBar("downladScroll","Completed")),"User is not able to see the progress bar completes popup while downloading the snip from Player Page");	
		Thread.sleep(10000);
		
		//Step 12 : To verify whether the download option is enabled once the downloading process completes.
		//Expected : The download option should enable once the downloading process completes.
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("download-icon tool-rounded")),"Download Icon is not enabled during the snip download completes");
	}
}
