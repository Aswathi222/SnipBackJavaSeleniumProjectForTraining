package testPage.MavenPageObject;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestData.CommonData;
import TestData.LikeGame_TestData;
import TestData.Tags_TestData;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.CreateUpdateDeleteGame_Obj;
import objectRepository.DeleteSnipPlayer_Obj;
import objectRepository.LikeGame_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.Tags_Obj;
import objectRepository.ViewProfile_Obj;
import utilPack.BasePge;

public class LikeGame extends BasePge {

	BasePge base;
	Assert asrt; 

	public LikeGame(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify that the "Like" option is present in the video in the player page"
	// Automation ID   : LG_1 
	// </summary>
	public void LG_1_LikeGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		LikeGame_TestData LikeGameTestData= new LikeGame_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), LikeGameTestData.LG_01_LGOrg);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), LikeGameTestData.LG_01_LGTeamName);
		Thread.sleep(3000);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(LikeGameTestData.LG_01_LGTeamName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(LikeGameTestData.LG_01_LGTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(2000);

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), LikeGameTestData.LG_01_LGGameName);
		Thread.sleep(2000);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_01_LGGameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_01_LGGameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_01_LGGameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+LikeGameTestData.LG_01_LGGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");

		//Step 10  :View the Like icon in the 3 dots menu
		//Expected: User should be able to view the like icon in the 3 dots menu
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-like")),"'Like Icon' is not displayed in the 3 dots menu");
	}

	// <summary>
	// Test Case Title :"To verify that the "Like" button turns green when clicked the "Like" Button"
	// Automation ID   : LG_2
	// </summary>
	public void LG_2_LikeGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		LikeGame_TestData LikeGameTestData= new LikeGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		LikeGame_Obj LikeGameObj = new LikeGame_Obj();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), LikeGameTestData.LG_02_LGOrg);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), LikeGameTestData.LG_02_LGTeamName);
		Thread.sleep(3000);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(LikeGameTestData.LG_02_LGTeamName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(LikeGameTestData.LG_02_LGTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(2000);

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), LikeGameTestData.LG_02_LGGameName);
		Thread.sleep(2000);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_02_LGGameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_02_LGGameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_02_LGGameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+LikeGameTestData.LG_02_LGGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		
		//Step 10  :View the Like icon in the 3 dots menu
		//Expected: User should be able to view the like icon in the 3 dots menu
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LikeGameObj.Ele_LikeButton("ico-like","ico-liked")),"'Like Icon' is not displayed in the 3 dots menu");
		
		//Step 11  :To verify that the "Like" button turns green when clicked the "Like" Button
		//Expected : User able to click like it turns Green
		By likeIconLocator = LikeGameObj.Ele_LikeButton("ico-like","ico-liked");
		// Find the element
		WebElement likeIcon = driver.findElement(likeIconLocator);
		// Check the initial class name of the 'Like' icon
		String initialClassName = likeIcon.getAttribute("class");
		if (initialClassName.equals("ico-like"))
		{
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-like"));
			Thread.sleep(5000);
		}
		else
		{
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-liked"))," User unable to click 'like' ,didnt turn into Green icon under 3 dots menu");
		} 
	}

	// <summary>
	// Test Case Title :"Verify that the user Liked Video is  Displayed on the "Liked Film" Page"
	// Automation ID   : LG_3
	// </summary>
	public void LG_3_LikeGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		LikeGame_TestData LikeGameTestData= new LikeGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		LikeGame_Obj LikeGameObj = new LikeGame_Obj();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), LikeGameTestData.LG_03_LGOrg);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), LikeGameTestData.LG_03_LGTeamName);
		Thread.sleep(3000);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(LikeGameTestData.LG_03_LGTeamName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(LikeGameTestData.LG_03_LGTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(2000);

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), LikeGameTestData.LG_03_LGGameName);
		Thread.sleep(2000);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");


		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_03_LGGameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_03_LGGameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_03_LGGameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+LikeGameTestData.LG_03_LGGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  :View the Like icon in the 3 dots menu
		//Expected: User should be able to view the like icon in the 3 dots menu
		asrt.assertTrue(base.isExists(LikeGameObj.Ele_LikeButton("ico-like","ico-liked")),"'Like Icon' is not displayed in the 3 dots menu");
		
		//Step 11  :Verify that the user Liked Video is  Displayed on the "Liked Film" Page
		//Expected: User should be able to view the liked icon in the 3 dots menu and it turns green
		By likeIconLocator = LikeGameObj.Ele_LikeButton("ico-like","ico-liked");
		WebElement likeIcon = driver.findElement(likeIconLocator);
		// Check the initial class name of the 'Like' icon
		String initialClassName = likeIcon.getAttribute("class");
		if (initialClassName.equals("ico-like"))
		{
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-like"));
			Thread.sleep(5000);
			//asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-like")),"User is unable to click Like Icon in Snipback");
		}
		else
		{
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-liked")),"'Liked Icon' is not displayed in the 3 dots menu");
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-liked"));
			Thread.sleep(3000);
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-like"));
		} 

		//Step 11  :Navigate to film menu
		//Expected: User should be able to navigate to the film menu.
		base.returnToMainWindow(driver);//Returning to previous window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to view Film menu in Snipback page");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(15000);

		//Step 12 : View and click the Grid Icon
		//Expected : User should be able to view and click on the Grid Icon
		base.scrollToElementtoCenter(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("grid-div list-grid-position btn tooltip switch-tooltip  dot-menu-wrap left-dot-menu cursor-pointer")),"User is not able to view the Grid Icon");
	
		//Step 13 : "Verify that the user "Liked Film" Menu Page
		//Expected : User is  able to view Liked film menu in Snipback page
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("grid-div list-grid-position btn tooltip switch-tooltip  dot-menu-wrap left-dot-menu cursor-pointer"));
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(LikeGameObj.Ele_LikedFilm("myCheckboxs","Liked Film")),"User is not able to view Liked film menu in Snipback page");

		//Step 14 : "Verify that the user Liked Video Date is able to enter in the resp field
		//Expected : User able to enter the date period in Liked Filim Menu
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = formatter.format(date);
		base.setData(LoginPageObj.Edt_LoginEmail("date_picker"), currentDate);
		String actualTagListName = base.GetValue(LoginPageObj.Edt_LoginEmail("date_picker"));
		Thread.sleep(5000);
		asrt.assertEquals(actualTagListName, currentDate, "User not able to enter the date period");
		
		//Step 15 : "Verify that the user Liked Video is  Displayed on the "Liked Film" Page
	    //Expected : User should be able to view the liked video in the Liked Film tab.
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("search"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), LikeGameTestData.LG_03_LGGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(1000);
		base.excuteJsClick(LikeGameObj.Ele_LikedFilm("myCheckboxs","Liked Film"));
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText(LikeGameTestData.LG_03_LGGameName)), "User is not able to view the liked video in liked film page");

	}


	// <summary>
	// Test Case Title :"Verify that the user can remove the like (by clicking the green color thumbs up) & then that video must disappeared from "Liked Film" page"
	// Automation ID   : LG_4
	// </summary>
	public void LG_4_LikeGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		LikeGame_TestData LikeGameTestData= new LikeGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		LikeGame_Obj LikeGameObj = new LikeGame_Obj();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), LikeGameTestData.LG_04_LGOrg);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), LikeGameTestData.LG_04_LGTeamName);
		Thread.sleep(3000);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(LikeGameTestData.LG_04_LGTeamName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(LikeGameTestData.LG_04_LGTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(2000);

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), LikeGameTestData.LG_04_LGGameName);
		Thread.sleep(2000);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_04_LGGameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_04_LGGameName));
		Thread.sleep(5000);
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_04_LGGameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+LikeGameTestData.LG_04_LGGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  :View the Like icon in the 3 dots menu
		//Expected: User should be able to view the like icon in the 3 dots menu
		asrt.assertTrue(base.isExists(LikeGameObj.Ele_LikeButton("ico-like","ico-liked")),"'Like Icon' is not displayed in the 3 dots menu");
		// Locate the Like Icon button using its CSS selector or any other suitable locator
		By likeIconLocator = LikeGameObj.Ele_LikeButton("ico-like","ico-liked");
		// Find the element
		WebElement likeIcon = driver.findElement(likeIconLocator);
		// Check the initial class name of the 'Like' icon
		String initialClassName = likeIcon.getAttribute("class");
		if (initialClassName.equals("ico-like"))
		{
			//Step 10  :Click the Like icon
			//Expected: User should be able to click the like icon in the 3 dots menu

			base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-like"));
			Thread.sleep(5000);
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-liked")),"User is unable to click Like Icon in Snipback");
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-liked"));
			Thread.sleep(3000);

		}
		else
		{
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-liked"));
			Thread.sleep(5000);
			asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-like")),"'Like Icon' is not displayed in the 3 dots menu");
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-like"));
			Thread.sleep(3000);
			base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-liked"));
		} 

		//Step 11  :Navigate to film menu
		//Expected: User should be able to navigate to the film menu.
		base.returnToMainWindow(driver);//Returning to previous window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to view Film menu in Snipback page");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(5000);

		//Step 12 : View and click the Grid Icon
		//Expected : User should be able to view and click on the Grid Icon
		base.scrollToElementtoCenter(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("grid-div list-grid-position btn tooltip switch-tooltip  dot-menu-wrap left-dot-menu cursor-pointer")),"User is not able to view the Grid Icon");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("grid-div list-grid-position btn tooltip switch-tooltip  dot-menu-wrap left-dot-menu cursor-pointer"));
		Thread.sleep(10000);

		//Step 13 : View and click the Liked Film
		//Expected : User should be able to view the liked video in the Liked Film tab.
		asrt.assertTrue(base.isExists(LikeGameObj.Ele_LikedFilm("myCheckboxs","Liked Film")),"User is not able to view Liked film menu in Snipback page");
		
		//Step 14 : Verify date period in the Liked Film tab.
		//Expected : User should be able to enter date period in the Liked Film tab.	
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = formatter.format(date);
		base.setData(LoginPageObj.Edt_LoginEmail("date_picker"), currentDate);
		String actualTagListName = base.GetValue(LoginPageObj.Edt_LoginEmail("date_picker"));
		Thread.sleep(5000);
		asrt.assertEquals(actualTagListName, currentDate, "User not able to enter the date period");
		
		//Step 15 : Verify that the user can remove the like (by clicking the green color thumbs up) & then that video must disappeared from "Liked Film" page
		//Expected : User  is unable to view the not liked video in liked film page
		base.excuteJsClick(LikeGameObj.Ele_LikedFilm("myCheckboxs","Liked Film"));
		Thread.sleep(7000);
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("search"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), LikeGameTestData.LG_04_LGGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(1000);
		base.excuteJsClick(LikeGameObj.Ele_LikedFilm("myCheckboxs","Liked Film"));
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("No Data Found")), "User is able to view the not liked video in liked film page");
		
	}	


	// <summary>
	// Test Case Title :"Verify that if a user create a snip from a non-liked video and that  video must appeared in the  "Liked Films" page"
	// Automation ID   : LG_5
	// </summary>
	public void LG_5_LikeGamePlayerPage() throws InterruptedException
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		LikeGame_TestData LikeGameTestData= new LikeGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		LikeGame_Obj LikeGameObj = new LikeGame_Obj();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), LikeGameTestData.LG_05_LGOrg);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), LikeGameTestData.LG_05_LGTeamName);
		Thread.sleep(3000);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(LikeGameTestData.LG_05_LGTeamName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(LikeGameTestData.LG_05_LGTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(2000);

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), LikeGameTestData.LG_05_LGGameName);
		Thread.sleep(2000);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_05_LGGameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_05_LGGameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_05_LGGameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+LikeGameTestData.LG_05_LGGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);

		//Step 10  :View the Like icon in the 3 dots menu
		//Expected: User should be able to view the like icon in the 3 dots menu
		//        WebDriverWait wait = new WebDriverWait(driver, 5);  // Timeout in seconds
		//        WebElement likeIcon = wait.until(ExpectedConditions.presenceOfElementLocated(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-like")));
		//        Assert.assertTrue(likeIcon.isDisplayed(), "'Like Icon' is not displayed in the 3 dots menu");

		//Step 11  :Create a new Snip for a non-liked video
		//Expected: Successfully Created a Snip
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-snip")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-snip"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateMySnip("d-flex flex-column bg-body list-wrap pb-3", "My Snips")),"Unable to select the Type of Snip needed");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateMySnip("d-flex flex-column bg-body list-wrap pb-3", "My Snips"));
		base.excuteJsClick(LoginPageObj.Btn_Login("OK"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateBtnSnip("swal-button-container", "Snip")),"Unable to select the 'Snip' in Snip section details");

		//Step 12  :Navigate to film menu
		//Expected: User should be able to navigate to the film menu.
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateBtnSnip("swal-button-container", "Snip"));
		base.excuteJsClick(MoveGameObj.Btn_Video_SnipDetails("row entire-video-shot-section", "My Snips"));
		Thread.sleep(10000);
		base.returnToMainWindow(driver);//Returning to previous window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to view Film menu in Snipback page");

		//Step 13 : View and click the Grid Icon
		//Expected : User should be able to view and click on the Grid Icon
		base.scrollToElementtoCenter(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(10000);
		base.scrollToElementtoCenter(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("grid-div list-grid-position btn tooltip switch-tooltip  dot-menu-wrap left-dot-menu cursor-pointer")),"User is not able to view the Grid Icon");
		
		//Step 14 : View and click the Liked Film
		//Expected : User is able to view Liked film menu in Snipback page
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("grid-div list-grid-position btn tooltip switch-tooltip  dot-menu-wrap left-dot-menu cursor-pointer"));
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(LikeGameObj.Ele_LikedFilm("myCheckboxs","Liked Film")),"User is not able to view Liked film menu in Snipback page");
		//        base.excuteJsClick(LikeGameObj.likedfilm("myCheckboxs","Liked Film"));
		//        Thread.sleep(5000);


		//Step 14 : Verify date period in the Liked Film tab.
		//Expected : User should be able to enter date period in the Liked Film tab.
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = formatter.format(date);
		base.setData(LoginPageObj.Edt_LoginEmail("date_picker"), currentDate);
		base.setData(LoginPageObj.Edt_LoginEmail("date_picker"), currentDate);
		String actualTagListName = base.GetValue(LoginPageObj.Edt_LoginEmail("date_picker"));
		Thread.sleep(5000);
		asrt.assertEquals(actualTagListName, currentDate, "User not able to enter the date period");
		
		//Step 15 : "Verify that if a user create a snip from a non-liked video and that  video must appeared in the  "Liked Films" page"
		//Expected : User is able to view the snip of a non-liked video in the Liked film tab
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("search"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), LikeGameTestData.LG_05_LGGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(1000);
		base.excuteJsClick(LikeGameObj.Ele_LikedFilm("myCheckboxs","Liked Film"));
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText(LikeGameTestData.LG_05_LGGameName)), "User is not able to view the snip of a non-liked video in the Liked film tab");
	}	

	// <summary>
	// Test Case Title :"Verify that deleting a particular snip of a non-liked video, then that video  does not remove from the  "Liked Films" page"
	// Automation ID   : LG_6
	// </summary>
	public void LG_6_LikeGamePlayerPage() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		LikeGame_TestData LikeGameTestData= new LikeGame_TestData();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj=new CreateUpdateDeleteGame_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		LikeGame_Obj LikeGameObj = new LikeGame_Obj();
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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), LikeGameTestData.LG_06_LGOrg);
		String Parent_OrgName=base.GetText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), LikeGameTestData.LG_06_LGTeamName);
		Thread.sleep(3000);
		base.pressKey(null, "KEYBOARD_ENTER");
		base.buttonClick(CreateUpdateDeleteGameObj.Ele_TeamSelect(LikeGameTestData.LG_06_LGTeamName));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_TeamSelect(LikeGameTestData.LG_06_LGTeamName)),"The team is not selected in the My Team list in the Games page.");
		Thread.sleep(2000);

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), LikeGameTestData.LG_06_LGGameName);
		Thread.sleep(2000);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(2000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		String originalWindow = driver.getWindowHandle();//store the current window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_06_LGGameName)),"Event Game is not Visible");
		base.scrollToElementtoCenter(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_06_LGGameName));
		base.excuteJsClick(MoveGameObj.Btn_GameName("text-decoration-none text-reset",LikeGameTestData.LG_06_LGGameName));	 
		Thread.sleep(5000);
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - "+LikeGameTestData.LG_06_LGGameName)),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :View and click on the 3 dots menu in video
		//Expected: User should be able to view 3 dots icon and click on it
		asrt.assertTrue(base.isExists(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()")),"User is not able to view the 3 dots icon");

		//Step 10  :View the Like icon in the 3 dots menu
		//Expected: User should be able to view the like icon in the 3 dots menu without liked
		base.excuteJsClick(AddUpdateRemoveMemberObj.Ele_EditTeam("expandMoreButtons()"));	
		Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 5);  // Timeout in seconds
        WebElement likeIcon = wait.until(ExpectedConditions.presenceOfElementLocated(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-like")));
        Assert.assertTrue(likeIcon.isDisplayed(), "'Like Icon' is not displayed in the 3 dots menu");

		//Step 11  :To create a new Snip for a non-liked video
		//Expected: Successfully Created a Snip
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-snip")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "ico-snip"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateMySnip("d-flex flex-column bg-body list-wrap pb-3", "My Snips")),"Unable to select the Type of Snip needed");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateMySnip("d-flex flex-column bg-body list-wrap pb-3", "My Snips"));
		base.excuteJsClick(LoginPageObj.Btn_Login("OK"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateBtnSnip("swal-button-container", "Snip")),"Unable to select the 'Snip' in Snip section details");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateBtnSnip("swal-button-container", "Snip"));
		Thread.sleep(5000);
		base.excuteJsClick(MoveGameObj.Btn_Video_SnipDetails("row entire-video-shot-section", "My Snips"));
		Thread.sleep(10000);

		//Step 9  :To delete a snip for a non-liked video
		//Expected: Successfully deleted the snip
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));
		asrt.assertTrue(base.isExists(DeleteSnipPlayerObj.Btn_DeleteSnip("delete-bookmark-btnsection deleteBM btn","fa fa-trash")),"No Option to Delete Snip from Player Page");							
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_DeleteSnip("delete-bookmark-btnsection deleteBM btn","fa fa-trash"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?","Text is not matching \"Are you sure?\"");
		//asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to delete snip 1?","Text is not matching \"Do you want to delete snip 1?\" ");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm swal-button--danger")),"Yes button is not there in dialog box");
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm swal-button--danger"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Snip has been deleted successfully")),"No success Message Found like \"Snip has been deleted successfully\" ");       

		//Step 12  :Navigate to film menu
		//Expected: User should be able to navigate to the film menu.
		base.returnToMainWindow(driver);//Returning to previous window
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Film("nav-item","Film")),"User is not able to view Film menu in Snipback page");
		base.scrollToElementtoCenter(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		base.excuteJsClick(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		Thread.sleep(15000);

		//Step 13 : View and click the Grid Icon
		//Expected : User should be able to view and click on the Grid Icon
		base.scrollToElementtoCenter(MoveGameObj.Btn_Master_Film("nav-item","Film"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("grid-div list-grid-position btn tooltip switch-tooltip  dot-menu-wrap left-dot-menu cursor-pointer")),"User is not able to view the Grid Icon");
		
		//Step 14 : Verify date period in the Liked Film tab.
		//Expected : User should be able to enter date period in the Liked Film tab.
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("grid-div list-grid-position btn tooltip switch-tooltip  dot-menu-wrap left-dot-menu cursor-pointer"));
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(LikeGameObj.Ele_LikedFilm("myCheckboxs","Liked Film")),"User is not able to view Liked film menu in Snipback page");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = formatter.format(date);
		base.setData(LoginPageObj.Edt_LoginEmail("date_picker"), currentDate);
		base.setData(LoginPageObj.Edt_LoginEmail("date_picker"), currentDate);
		String actualTagListName = base.GetValue(LoginPageObj.Edt_LoginEmail("date_picker"));
		Thread.sleep(5000);
		asrt.assertEquals(actualTagListName, currentDate, "User not able to enter the date period");
		
		//Step 15 : "Verify that deleting a particular snip of a non-liked video, then that video  does not remove from the  "Liked Films" page"
		//Excepted : User is  able to view the snip of a non-liked video in the Liked film tab
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("search"));
		base.setData(LoginPageObj.Edt_LoginEmail("search"), LikeGameTestData.LG_06_LGGameName);
		base.pressKey(null, "KEYBOARD_ENTER");
		Thread.sleep(1000);
		base.excuteJsClick(LikeGameObj.Ele_LikedFilm("myCheckboxs","Liked Film"));
		Thread.sleep(10000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText(LikeGameTestData.LG_06_LGGameName)), "User is not able to view the snip of a non-liked video in the Liked film tab");
	}	
}
