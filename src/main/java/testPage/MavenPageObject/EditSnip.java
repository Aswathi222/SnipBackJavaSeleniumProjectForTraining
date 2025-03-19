package testPage.MavenPageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import TestData.CommonData;
import TestData.EditSnip_TestData;
import objectRepository.AddFollower_Obj;
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

public class EditSnip extends BasePge {

	BasePge base;
	Assert asrt;

	public EditSnip(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters an existing Custom Tag name."
	// Automation ID   : ES_17
	// </summary>
	public void ES_17_EditSnip() throws InterruptedException {	

		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC17_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC17_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC15_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC17_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(4000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step 10:  Click the Pencil Icon
		//Expected:User should able to  Clickable the Pencil Icon and a text field will appear, prompting the user to enter a new Custom Tag name.
		base.scrollToElement(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to view a text field will appear and the user not able to enter a new Custom Tag name.");

		//Step 11:  Enter a valid Custom Tag Name
		//Expected:User should able to Enter a valid Custom Tag Name
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("InputCustom"));
		base.setData(LoginPageObj.Edt_LoginEmail("InputCustom"), EditSnipTestData.TC17_TagName);
		String Name =base.GetValue(LoginPageObj.Edt_LoginEmail("InputCustom"));
		System.out.println("The name is: "+Name);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to Enter a valid Custom Tag Name");
		Thread.sleep(2000);

		//Step 12:  Click tick Icon
		//Expected:User should able to clickable tick Icon
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("custom-tag-listing custom-tag-edit-enable")),"User should not able to click the tick icon");
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-danger mt-5"));
		Thread.sleep(2000);
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger mt-5"));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt")),"User should not able to view the pencil icon");

		//Step 13:  Click the Pencil Icon
		//Expected:User should able to  Clickable the Pencil Icon and a text field will appear, prompting the user to enter a new Custom Tag name.
		base.scrollToElement(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to view a text field will appear and the user not able to enter a new Custom Tag name.");

		//Step 14:  Enter a valid Custom Tag Name
		//Expected:User should able to Enter a valid Custom Tag Name
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("InputCustom"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("InputCustom"), Name);
		//String Name =base.GetText(LoginPageObj.Edt_LoginEmail("InputCustom"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to Enter a valid Custom Tag Name");

		//Step 15:  Click tick Icon
		//Expected:User should able to clickable tick Icon
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));
		Thread.sleep(2000);

		//Step 16: Error popup is displayed
		//Expected:Validate if the text message is "Custom Tag already exists"
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-danger mt-5"));
		Thread.sleep(2000);
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger mt-5"));
		Thread.sleep(4000);
		//asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt")),"User should not able to view the pencil icon");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Custom Tag Already Exists","\"Custom Tag Already Exists\" text is not matching");			
	}

	// <summary>
	// Test Case Title :"To verify what happens when user left the List name field empty.
	// Automation ID   : ES_18
	// </summary>
	public void ES_18_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC18_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC18_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC18_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC18_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(4000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step 10:  Click the Pencil Icon
		//Expected:User should able to  Clickable the Pencil Icon and a text field will appear, prompting the user to enter a new Custom Tag name.
		base.scrollToElement(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to view a text field will appear and the user not able to enter a new Custom Tag name.");

		//Step 11:  Enter a valid Custom Tag Name and Click tick Icon then Error message is displayed
		//Expected:User should able to Enter a valid Custom Tag Name and Click tick Icon Validate if the text message is "Custom Tag name is empty"
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("InputCustom"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to Enter a valid Custom Tag Name");
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("alert alert-danger p-2 mt-2")),"'Custom Tag name is empty' message is not displayed in the custom Tag");								


	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the 'x' icon.".
	// Automation ID   : ES_19
	// </summary>
	public void ES_19_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC19_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC19_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC19_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC19_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step 10:  Click the Pencil Icon
		//Expected:User should able to  Clickable the Pencil Icon and a text field will appear, prompting the user to enter a new Custom Tag name.
		base.scrollToElement(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to view a text field will appear and the user not able to enter a new Custom Tag name.");

		//Step12: Click on close icon
		//Expected:The text field will closes once user clicks the 'x' icon.
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.I_Close("trash-icon px-2 close-createcustomtag","icofont-close"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.I_Close("trash-icon px-2 close-createcustomtag","icofont-close"));	
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("custom-tag-listing")),"User should not able to click the tick icon");

	}	


	// <summary>
	// Test Case Title :"To verify what happens when user clicks the member icon in the Custom tags pop up".
	// Automation ID   : ES_22
	// </summary>
	public void ES_22_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC22_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC22_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC22_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC22_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(4000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step10: Verify and select Member Option
		//Expected:Verified and selected Member Icon
		base.scrollToElementtoCenter(EditSnipObj.Ele_EditMember("col-md-1 col-2 right-items","sec-right add-usertocustomtagbtn"));
		base.excuteJsClick(EditSnipObj.Ele_EditMember("col-md-1 col-2 right-items","sec-right add-usertocustomtagbtn"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Home("nav-link  active fw-500 text-uppercase","Home")),"'Home Icon' is not displayed in Members page");	

		//Step11:Verify All players in the team should be displayed under the title Home.
		//Expected:All players in the team displayed under the title Home.
		asrt.assertTrue(base.isExists(EditSnipObj.Ele_ListMember("nav-home","d-flex flex-column pb-5 bg-body list-wrap pb-5")),"The members name are not displayed in Members page");	


	}

	// <summary>
	// Test Case Title :"To verify what happens when user selects any one of the player from the members list.".
	// Automation ID   : ES_23
	// </summary>
	public void ES_23_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC23_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC23_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC23_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC23_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step10: Verify and select Member Option
		//Expected:Verified and selected Member Icon
		base.scrollToElementtoCenter(EditSnipObj.Ele_EditMember("col-md-1 col-2 right-items","sec-right add-usertocustomtagbtn"));
		base.excuteJsClick(EditSnipObj.Ele_EditMember("col-md-1 col-2 right-items","sec-right add-usertocustomtagbtn"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Home("nav-link  active fw-500 text-uppercase","Home")),"'Home Icon' is not displayed in Members page");	

		//Step11:Verify All players in the team should be displayed under the title Home.
		//Expected:All players in the team displayed under the title Home.
		asrt.assertTrue(base.isExists(EditSnipObj.Ele_ListMember("nav-home","d-flex flex-column pb-5 bg-body list-wrap pb-5")),"The members name are not displayed in Members page");	

		//Step12:Verify and click on checkbox .
		//Expected:  checkbox selected
		base.scrollToElementtoCenter(EditSnipObj.Btn_ChkMember("nav-home","form-check-input"));
		Thread.sleep(3000);
		base.buttonClick(EditSnipObj.Btn_ChkMember("nav-home","form-check-input"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_ChkMember("nav-home","form-check-input")),"'Checkbox' is not selcted in Member page");	


	}

	// <summary>
	// Test Case Title :"To verify what happens when user deselect the player from the members list..".
	// Automation ID   : ES_24
	// </summary>
	public void ES_24_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC23_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC23_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC23_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC23_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step10: Verify and select Member Option
		//Expected:Verified and selected Member Icon
		base.scrollToElementtoCenter(EditSnipObj.Ele_EditMember("col-md-1 col-2 right-items","sec-right add-usertocustomtagbtn"));
		base.excuteJsClick(EditSnipObj.Ele_EditMember("col-md-1 col-2 right-items","sec-right add-usertocustomtagbtn"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Home("nav-link  active fw-500 text-uppercase","Home")),"'Home Icon' is not displayed in Members page");	

		//Step11:Verify All players in the team should be displayed under the title Home.
		//Expected:All players in the team displayed under the title Home.
		asrt.assertTrue(base.isExists(EditSnipObj.Ele_ListMember("nav-home","d-flex flex-column pb-5 bg-body list-wrap pb-5")),"The members name are not displayed in Members page");	

		//Step12:Verify and click on checkbox .
		//Expected:  checkbox selected
		base.scrollToElementtoCenter(EditSnipObj.Btn_ChkMember("nav-home","form-check-input"));
		Thread.sleep(2000);
		base.buttonClick(EditSnipObj.Btn_ChkMember("nav-home","form-check-input"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_ChkMember("nav-home","form-check-input")),"'Checkbox' is not selcted in Member page");	

		//Step13:Verify and deselect on checkbox .
		//Expected:  checkbox deselected
		base.scrollToElementtoCenter(EditSnipObj.Btn_ChkMember("nav-home","form-check-input"));
		Thread.sleep(2000);
		base.buttonClick(EditSnipObj.Btn_ChkMember("nav-home","form-check-input"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_ChkMember("nav-home","form-check-input")),"'Checkbox' is not selcted in Member page");	


	}

	// <summary>
	// Test Case Title :"To verify what happens when user click Refresh in the members page..".
	// Automation ID   : ES_25
	// </summary>
	public void ES_25_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC25_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC25_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC25_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC25_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(3000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step10: Verify and select Member Option
		//Expected:Verified and selected Member Icon
		base.scrollToElementtoCenter(EditSnipObj.Ele_EditMember("col-md-1 col-2 right-items","sec-right add-usertocustomtagbtn"));
		base.excuteJsClick(EditSnipObj.Ele_EditMember("col-md-1 col-2 right-items","sec-right add-usertocustomtagbtn"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Home("nav-link  active fw-500 text-uppercase","Home")),"'Home Icon' is not displayed in Members page");	

		//Step11:Verify All players in the team should be displayed under the title Home.
		//Expected:All players in the team displayed under the title Home.
		asrt.assertTrue(base.isExists(EditSnipObj.Ele_ListMember("nav-home","d-flex flex-column pb-5 bg-body list-wrap pb-5")),"The members name are not displayed in Members page");	

		//Step12:Verify and click on checkbox .
		//Expected:  checkbox selected
		base.scrollToElementtoCenter(EditSnipObj.Btn_ChkMember("nav-home","form-check-input"));
		Thread.sleep(2000);
		base.buttonClick(EditSnipObj.Btn_ChkMember("nav-home","form-check-input"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_ChkMember("nav-home","form-check-input")),"'Checkbox' is not selcted in Member page");	

		//Step12:Verify and check the members list gets refreshed with a loader. .
		//Expected: The members list gets refreshed with a loader.
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap refresh-teamplayers")),"'Refresh' is not displayed in Member page");	
		base.scrollToElementtoCenter(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap refresh-teamplayers"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap refresh-teamplayers"));
	}

	// <summary>
	// Test Case Title :"To verify what happens when user try to create snip with tag after selecting a member."
	// Automation ID   : ES_26
	// </summary>
	public void ES_26_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC26_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC26_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC26_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC26_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step10: Verify and select Member Option
		//Expected:Verified and selected Member Icon
		base.scrollToElementtoCenter(EditSnipObj.Ele_EditMember("col-md-1 col-2 right-items","sec-right add-usertocustomtagbtn"));
		base.excuteJsClick(EditSnipObj.Ele_EditMember("col-md-1 col-2 right-items","sec-right add-usertocustomtagbtn"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Home("nav-link  active fw-500 text-uppercase","Home")),"'Home Icon' is not displayed in Members page");	

		//Step11:Verify All players in the team should be displayed under the title Home.
		//Expected:All players in the team displayed under the title Home.
		asrt.assertTrue(base.isExists(EditSnipObj.Ele_ListMember("nav-home","d-flex flex-column pb-5 bg-body list-wrap pb-5")),"The members name are not displayed in Members page");	

		//Step12:Verify and check the members list gets refreshed with a loader. .
		//Expected: The members list gets refreshed with a loader.
		base.scrollToElementtoCenter(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap refresh-teamplayers"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap refresh-teamplayers"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap refresh-teamplayers")),"'Refresh' is not displayed in Member page");	

		//Step12:Verify and click on checkbox .
		//Expected:  checkbox selected
		base.scrollToElementtoCenter(EditSnipObj.Btn_ChkMember("nav-home","form-check-input"));
		Thread.sleep(2000);
		base.buttonClick(EditSnipObj.Btn_ChkMember("nav-home","form-check-input"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_ChkMember("nav-home","form-check-input")),"'Checkbox' is not selcted in Member page");	

		//Step13:Verify and click on 'Done' button after checkbox selected .
		//Expected: 'Done' selected
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Done("d-flex button-wrap justify-content-between","Done")),"'Done' is not displayed in Member page");	
		base.scrollToElementtoCenter(EditSnipObj.Btn_Done("d-flex button-wrap justify-content-between","Done"));
		base.buttonClick(EditSnipObj.Btn_Done("d-flex button-wrap justify-content-between","Done"));
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton")),"'Tick' option is not displayed in the Custom Tag page");

		//Step14:Click on Tick icon
		//Expected:"User should be select tick icon"
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-text")));

		//Step 15: Verify 'Bookmark Tag updated successfully' popup displaying
		//Expected:Validate if the text message is "Bookmark Tag updated successfully"
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Bookmark Tag updated successfully","\"Bookmark Tag updated successfully\" text is not matching");

		//Step 16: Verify 'OK' button displaying
		//Expected:OK button displaying"
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_OK("swal-button swal-button--confirm","OK")),"'OK' option is not displayed in the Custom Tag page");
		base.scrollToElementtoCenter(EditSnipObj.Btn_OK("swal-button swal-button--confirm","OK"));
		base.buttonClick(EditSnipObj.Btn_OK("swal-button swal-button--confirm","OK"));


	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks CANCEL in the members page.".
	// Automation ID   : ES_27
	// </summary>
	public void ES_27_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC27_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC27_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC27_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC27_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step10: Verify and select Member Option
		//Expected:Verified and selected Member Icon
		base.scrollToElementtoCenter(EditSnipObj.Ele_EditMember("col-md-1 col-2 right-items","sec-right add-usertocustomtagbtn"));
		base.excuteJsClick(EditSnipObj.Ele_EditMember("col-md-1 col-2 right-items","sec-right add-usertocustomtagbtn"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Home("nav-link  active fw-500 text-uppercase","Home")),"'Home Icon' is not displayed in Members page");	

		//Step11:Verify All players in the team should be displayed under the title Home.
		//Expected:All players in the team displayed under the title Home.
		asrt.assertTrue(base.isExists(EditSnipObj.Ele_ListMember("nav-home","d-flex flex-column pb-5 bg-body list-wrap pb-5")),"The members name are not displayed in Members page");	

		//Step12:Verify and check the members list gets refreshed with a loader. .
		//Expected: The members list gets refreshed with a loader.
		base.scrollToElementtoCenter(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap refresh-teamplayers"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap refresh-teamplayers"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap refresh-teamplayers")),"'Refresh' is not displayed in Member page");	

		//Step13:Verify and click on checkbox .
		//Expected:  checkbox selected
		base.scrollToElementtoCenter(EditSnipObj.Btn_ChkMember("nav-home","form-check-input"));
		Thread.sleep(2000);
		base.buttonClick(EditSnipObj.Btn_ChkMember("nav-home","form-check-input"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_ChkMember("nav-home","form-check-input")),"'Checkbox' is not selcted in Member page");	

		//Step14:Verify and select cancel button.
		//Expected:cancel button selected.
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("cancel")),"'cancel'button is not displayed in Member page");	
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("cancel"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("cancel"));
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks EDIT TAG option from the poop up."
	// Automation ID   : ES_10
	// </summary>
	public void ES_10_EditSnip() throws InterruptedException {	

		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();


		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC09_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC10_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC10_SearchTeam)),"User unable to unable to select Team");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC10_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify what happens when user clicks EDIT FRAME option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 10: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.buttonClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks any one of the tag from "Custom tags" popup."
	// Automation ID   : ES_11
	// </summary>
	public void ES_11_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC11_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC11_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC11_SearchTeam)),"User unable to unable to select Team");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC11_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 10: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.buttonClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step 11: select and click any Tag Name Option
		//Expected: User should select and click any Tag Name from Popup.
		base.scrollToElement(EditSnipObj.Ele_EditTag("col-md-11 col-10 left-items","custom-tag-label"));
		base.excuteJsClick(EditSnipObj.Ele_EditTag("col-md-11 col-10 left-items","custom-tag-label"));
		asrt.assertTrue(base.isExists(EditSnipObj.Ele_EditTag("col-md-11 col-10 left-items","custom-tag-label")),"User not able to select and click any tag name");

		//Step 12:  Click done button 
		//Expected: User should be clickable done button.
		base.scrollToElement(EditSnipObj.Btn_Done("custom-tags-savebutton"));
		base.excuteJsClick(EditSnipObj.Btn_Done("custom-tags-savebutton"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Done("custom-tags-savebutton")),"User not able to click done button");


		//Step 13:  Click OK button 
		//Expected: User should be clickable OK button.
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user switches from Custom Tags to Snip Collections/Home Collections."
	// Automation ID   : ES_12
	// </summary>
	public void ES_12_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC12_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC12_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC12_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC12_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 10: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.buttonClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step 10: Click demo organization Snip Collections button
		//Expected:User should able to click the demo organization Snip Collections and it should contains the list of collection tags there.
		base.excuteJsClick(EditSnipObj.Btn_demo("org-collection"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("custom-tag-listing collection-list")),"User should not able to view the list of collection tags under demo organization Snip Collections tab");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user switches Share with option in the "Custom Tags" pop up."
	// Automation ID   : ES_13
	// </summary>
	public void ES_13_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC13_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC13_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC13_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC13_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		base.buttonClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step 10: Switch the option under 'Share with' to Player
		//Expected:User should able to Switch the option under 'Share with' to Player
		base.scrollToElement(SnipCreationWithAndWithoutTagObj.Btn_Player("type-playersnips"));
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Player("type-playersnips"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Player("type-playersnips")),"User not able select the option switch under 'Share with' to Player");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the pencil icon in the "Custom tags" pop up."
	// Automation ID   : ES_14
	// </summary>
	public void ES_14_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC14_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC14_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC14_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC14_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step 10:  Click the Pencil Icon
		//Expected:User should able to  Clickable the Pencil Icon and a text field will appear, prompting the user to enter a new Custom Tag name.
		base.scrollToElement(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to view a text field will appear and the user not able to enter a new Custom Tag name.");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters a valid Custom Tag Name in the text field"
	// Automation ID   : ES_15
	// </summary>
	public void ES_15_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC15_SearchTeam);	
		Thread.sleep(4000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC15_SearchTeam));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC15_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC15_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step 10:  Click the Pencil Icon
		//Expected:User should able to  Clickable the Pencil Icon and a text field will appear, prompting the user to enter a new Custom Tag name.
		base.scrollToElement(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(4000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to view a text field will appear and the user not able to enter a new Custom Tag name.");

		//Step 11:  Enter a valid Custom Tag Name
		//Expected:User should able to Enter a valid Custom Tag Name
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("InputCustom"));
		base.setData(LoginPageObj.Edt_LoginEmail("InputCustom"), EditSnipTestData.TC15_TagName);
		String Name =base.GetText(LoginPageObj.Edt_LoginEmail("InputCustom"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to Enter a valid Custom Tag Name");

		//Step 12:  Click tick Icon
		//Expected:User should able to clickable tick Icon
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("custom-tag-listing custom-tag-edit-enable")),"User should not able to click the tick icon");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters a  invalid Custom Tag Name."
	// Automation ID   : ES_16
	// </summary>
	public void ES_16_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC15_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC15_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC15_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC15_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step 10:  Click the Pencil Icon
		//Expected:User should able to  Clickable the Pencil Icon and a text field will appear, prompting the user to enter a new Custom Tag name.
		base.scrollToElement(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to view a text field will appear and the user not able to enter a new Custom Tag name.");

		//Step 11:  Enter a Invalid Custom Tag Name
		//Step10:  Enter a Invalid Custom Tag Name
		//Expected:User should able to Enter a valid Custom Tag Name
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("InputCustom"));
		base.setData(LoginPageObj.Edt_LoginEmail("InputCustom"), EditSnipTestData.TC16_TagName);

		//Step11:  Click tick Icon
		//Expected:User should able to clickable tick Icon and the User will receive alert popup as "Allowed characters a-z 0-9,.-@?!#$%&:"
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-danger mt-5"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("btn btn-danger mt-5"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Allowed characters a-z 0-9,.-@?!#$%&:")),"The User will not receive alert popup as 'Allowed characters a-z 0-9,.-@?!#$%&:'" );
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("custom-tag-listing")),"User should not able to click the tick icon");

	}
	// <summary>
	// Test Case Title :"To verify what happens when user click the colour circle..".
	// Automation ID   : ES_20
	// </summary>
	public void ES_20_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		Thread.sleep(3000);		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC20_SearchTeam);	
		Thread.sleep(4000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC20_SearchTeam));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC20_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC20_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step 10:  Click the Pencil Icon
		//Expected:User should able to  Clickable the Pencil Icon and a text field will appear, prompting the user to enter a new Custom Tag name.
		base.scrollToElement(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to view a text field will appear and the user not able to enter a new Custom Tag name.");

		//Step 11:  Enter a valid Custom Tag Name
		//Expected:User should able to Enter a valid Custom Tag Name
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("InputCustom"));
		base.setData(LoginPageObj.Edt_LoginEmail("InputCustom"), EditSnipTestData.TC20_TagName);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to Enter a valid Custom Tag Name");

		//Step13: Verify and select Color icon
		//Expected:Verified and selected Color Icon
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_BookMark("btn-select-color-newtag no-color")),"'Color' icon is not displayed in Player Page");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_BookMark("btn-select-color-newtag no-color"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_BookMark("btn-select-color-newtag no-color"));

		Thread.sleep(3000);
		base.selectCustomTagColor(21,35);
		Thread.sleep(3000);
		base.adjustBrightnessCustomTag(50);

		//Step14: Verify and select Tick icon
		//Expected:Verified and selected Tick Icon
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));//		asrt.assertTrue(base.isExists(EditSnipObj.Ele_ColorTag("custom-tag-list-item","EditSnipTest20")),"Tag label is not displayed in Player Page");	
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("custom-tag-listing custom-tag-edit-enable")),"User should not able to click the tick icon");
		base.scrollToElement(PoolObj.Btn_ButtonCreate("btn btn-danger mt-5"));
		Thread.sleep(2000);
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger mt-5"));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt")),"User should not able to select and click the tick icon");

	}	

	// <summary>
	// Test Case Title :"To verify what happens when user clicks CANCEL on the Custom tags pop up..".
	// Automation ID   : ES_21
	// </summary>
	public void ES_21_EditSnip() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);

		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 5:Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC21_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC21_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC21_SearchTeam)),"User unable to unable to select Team");

		//Step 6   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 7  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC21_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 8  :To verify what happens when user can view EDIT TAG option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag")),"'EDIT TAG' is not displayed in Edit Snip");	

		//Step 9: Verify and select Edit Tag Option
		//Expected:Verified and selected Edit Tag Icon
		base.scrollToElementtoCenter(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		base.excuteJsClick(EditSnipObj.Btn_EditBtn("snipback-btn edit-tag","Edit Tag"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(PoolObj.Ele_CreatePool("Custom tags")),"User not able to view the Edit Tag PopUp");

		//Step 10:  Click the Pencil Icon
		//Expected:User should able to  Clickable the Pencil Icon and a text field will appear, prompting the user to enter a new Custom Tag name.
		base.scrollToElement(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to view a text field will appear and the user not able to enter a new Custom Tag name.");

		//Step 11:  Enter a valid Custom Tag Name
		//Expected:User should able to Enter a valid Custom Tag Name
		base.excuteJsClick(LoginPageObj.Edt_LoginEmail("InputCustom"));
		base.setData(LoginPageObj.Edt_LoginEmail("InputCustom"), EditSnipTestData.TC21_TagName);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should not able to Enter a valid Custom Tag Name");

		//Step12: Verify and select Color icon
		//Expected:Verified and selected Color Icon
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_BookMark("btn-select-color-newtag no-color"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_BookMark("btn-select-color-newtag no-color"));
		asrt.assertTrue(base.isExists(EditSnipObj.Ele_Close("d-flex justify-content-between","icofont-close")),"'Close icon' is not displayed in Player Page");	

		//Step13: Verify and select x icon
		//Expected:Verified and selected x Icon
		base.scrollToElementtoCenter(EditSnipObj.Ele_Close("d-flex justify-content-between","icofont-close"));
		base.buttonClick(EditSnipObj.Ele_Close("d-flex justify-content-between","icofont-close"));	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("roboto-medium-black"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("roboto-medium-black")),"'Cancel button' is not displayed in Player Page");	

		//Step14: Verify and select Cancel icon
		//Expected:Verified and selected cancel Icon
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("roboto-medium-black"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("roboto-medium-black"));	
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

	}

	// <summary>
	// Test Case Title :"To verify whether there is an option to Edit Snip in Player page."
	// Automation ID   : TC01 
	// </summary>
	public void ES_01_EditSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

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
		base.excuteJsClick(MoveGameObj.Btn_Master_Games("tab-title","GAMES"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Master_Games("tab-title","GAMES")),"User unable to navigate to games page in Snipback" );

		//Step 5   :"Select a OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC02_SearchTeam);	
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC02_SearchTeam));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC02_SearchTeam)),"User unable to unable to select Team");

		//		//Step 6   :Select a Team from ORG
		//		//Expected:The New Team is Selected
		//		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		//		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC01_SearchTeam);	
		//		Thread.sleep(5000);
		//		base.buttonClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC01_SearchTeam));
		//		Thread.sleep(5000);
		//		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC01_SearchTeam)),"User unable to unable to select Team");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");


		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC01_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify whether there is an option to Edit Snip in Player page.
		//Expected:There should be options to Edit Snip in Player page.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");

	}


	// <summary>
	// Test Case Title :"To verify what happens when user clicks Edit Snip option.."
	// Automation ID   : TC02 
	// </summary>
	public void ES_02_EditSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC02_SearchTeam);	
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC02_SearchTeam));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC02_SearchTeam)),"User unable to unable to select Team");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");


		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC02_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :TTo verify what happens when user clicks Edit Snip option.
		//Expected:It should show two options "EDIT FRAME" & "EDIT TAG" options.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Done("d-flex","Edit Frame")),"Edit Frame Option Not Available");
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Done("d-flex","Edit Tag")),"Edit Tag Option Not Available");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks EDIT FRAME option form the pop up."
	// Automation ID   : TC03 
	// </summary>
	public void ES_03_EditSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC03_SearchTeam);	
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC03_SearchTeam));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC03_SearchTeam)),"User unable to unable to select Team");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC03_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify what happens when user clicks EDIT FRAME option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Done("d-flex","Edit Frame")),"Edit Frame Option Not Available");
		base.buttonClick(EditSnipObj.Btn_Done("d-flex","Edit Frame"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("editStartRange")),"User Unable to view Slider in snip editing Page");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user adjust the slider on the editing page."
	// Automation ID   : TC04 
	// </summary>
	public void ES_04_EditSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");
		Thread.sleep(5000);

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC04_SearchTeam);	
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC04_SearchTeam));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC04_SearchTeam)),"User unable to unable to select Team");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC04_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify what happens when user clicks EDIT FRAME option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Done("d-flex","Edit Frame")),"Edit Frame Option Not Available");
		base.buttonClick(EditSnipObj.Btn_Done("d-flex","Edit Frame"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("editStartRange")),"User Unable to view Slider in snip editing Page");

		//Step 10  :To verify what happens when user adjust the slider on the editing page.
		//Expected:The slider's starting section is enabled to allow editing of the snip's beginning segment.
		String Actual=base.GetAttribte(LoginPageObj.Edt_LoginEmail("editRange1"),"className");
		base.moveSlider(LoginPageObj.Edt_LoginEmail("editRange1"),"value","");
		asrt.assertEquals(Actual,"sliderStart active","slider's starting section is not enabled");

	}

	// <summary>
	// Test Case Title :"To verify what happens when user switch |<BEGIN to END>| at the right side of the screen."
	// Automation ID   : TC05 
	// </summary>
	public void ES_05_EditSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC05_SearchTeam);	
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC05_SearchTeam));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC05_SearchTeam)),"User unable to unable to select Team");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC05_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify what happens when user clicks EDIT FRAME option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Done("d-flex","Edit Frame")),"Edit Frame Option Not Available");
		base.buttonClick(EditSnipObj.Btn_Done("d-flex","Edit Frame"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("editStartRange")),"User Unable to view Slider in snip editing Page");

		//Step 10  :To verify what happens when user adjust the slider on the editing page.
		//Expected:The slider's starting section is enabled to allow editing of the snip's beginning segment.
		String Actual=base.GetAttribte(LoginPageObj.Edt_LoginEmail("editRange1"),"className");
		base.moveSlider(LoginPageObj.Edt_LoginEmail("editRange1"),"value","Unable to edit the Slider");
		asrt.assertEquals(Actual,"sliderStart active","slider's starting section is not enabled");

		//Step 11 :To verify what happens when user switch |<BEGIN to END>| at the right side of the screen.
		//Expected:The slider's ending section is enabled to allow editing of the snip's end segment.
		base.buttonClick(EditSnipObj.Ele_SaveBtn("col-lg-2 col-2 col-md-2 col-xl-1 editMasterRight","end_btn"));	
		String Actual1=base.GetAttribte(LoginPageObj.Edt_LoginEmail("editRange2"),"className");
		base.moveSlider(LoginPageObj.Edt_LoginEmail("editRange2"),"value","Unable to edit the Slider");
		asrt.assertEquals(Actual1,"sliderEnd active","slider's Ending section is not enabled");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user click the tick icon near the slider."
	// Automation ID   : TC06 
	// </summary>
	public void ES_06_EditSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC06_SearchTeam);	
		Thread.sleep(5000);
		base.buttonClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC06_SearchTeam));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC06_SearchTeam)),"User unable to unable to select Team");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC06_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify what happens when user clicks EDIT FRAME option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Done("d-flex","Edit Frame")),"Edit Frame Option Not Available");
		base.buttonClick(EditSnipObj.Btn_Done("d-flex","Edit Frame"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("editStartRange")),"User Unable to view Slider in snip editing Page");

		//Step 10  :To verify what happens when user adjust the slider on the editing page.
		//Expected:The slider's starting section is enabled to allow editing of the snip's beginning segment.
		String Actual=base.GetAttribte(LoginPageObj.Edt_LoginEmail("editRange1"),"className");
		base.moveSlider(LoginPageObj.Edt_LoginEmail("editRange1"),"value","Unable to edit the Slider");
		asrt.assertEquals(Actual,"sliderStart active","slider's starting section is not enabled");

		//Step 11 :To verify what happens when user switch |<BEGIN to END>| at the right side of the screen.
		//Expected:The slider's ending section is enabled to allow editing of the snip's end segment.
		base.buttonClick(EditSnipObj.Ele_SaveBtn("col-lg-2 col-2 col-md-2 col-xl-1 editMasterRight","end_btn"));	
		String Actual1=base.GetAttribte(LoginPageObj.Edt_LoginEmail("editRange2"),"className");
		base.moveSlider(LoginPageObj.Edt_LoginEmail("editRange2"),"value","Unable to edit the Slider");
		asrt.assertEquals(Actual1,"sliderEnd active","slider's Ending section is not enabled");

		//Step 11 :To verify what happens when user click the tick icon near the slider.
		//Expected:An confirmation pop up displays as "Do you want to update snip?"
		base.buttonClick(AddFollowerObj.Btn_MailTick("editSaveDiv","icon-snip-edit-save"));
		asrt.assertEquals(base.GetText(LoginPageObj.Edt_AlertText("Do you want to update snip?")), "Do you want to update snip?","Confirmation pop up not displaed as \"Do you want to update snip?");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user click Yes in the confirmation Popup."
	// Automation ID   : TC07 
	// </summary>
	public void ES_07_EditSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();


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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(4000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC07_SearchTeam);	
		Thread.sleep(4000);
		base.buttonClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC07_SearchTeam));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC07_SearchTeam)),"User unable to unable to select Team");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC07_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify what happens when user clicks EDIT FRAME option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Done("d-flex","Edit Frame")),"Edit Frame Option Not Available");
		base.buttonClick(EditSnipObj.Btn_Done("d-flex","Edit Frame"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("editStartRange")),"User Unable to view Slider in snip editing Page");

		//Step 10  :To verify what happens when user adjust the slider on the editing page.
		//Expected:The slider's starting section is enabled to allow editing of the snip's beginning segment.
		String Actual=base.GetAttribte(LoginPageObj.Edt_LoginEmail("editRange1"),"className");
		base.moveSlider(LoginPageObj.Edt_LoginEmail("editRange1"),"value","Unable to edit the Slider");
		asrt.assertEquals(Actual,"sliderStart active","slider's starting section is not enabled");

		//Step 11 :To verify what happens when user switch |<BEGIN to END>| at the right side of the screen.
		//Expected:The slider's ending section is enabled to allow editing of the snip's end segment.
		base.buttonClick(EditSnipObj.Ele_SaveBtn("col-lg-2 col-2 col-md-2 col-xl-1 editMasterRight","end_btn"));	
		String Actual1=base.GetAttribte(LoginPageObj.Edt_LoginEmail("editRange2"),"className");
		base.moveSlider(LoginPageObj.Edt_LoginEmail("editRange2"),"value","Unable to edit the Slider");
		asrt.assertEquals(Actual1,"sliderEnd active","slider's Ending section is not enabled");

		//Step 12 :To verify what happens when user click the tick icon near the slider.
		//Expected:An confirmation pop up displays as "Do you want to update snip?"
		base.buttonClick(AddFollowerObj.Btn_MailTick("editSaveDiv","icon-snip-edit-save"));
		asrt.assertEquals(base.GetText(LoginPageObj.Edt_AlertText("Do you want to update snip?")), "Do you want to update snip?","Confirmation pop up not displaed as \"Do you want to update snip?");

		//Step 13: Click Yes button.
		//Expected:User should able to click Yes button and the confirmation pop up closes when user clicks No in the confirmation Popup."
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		Thread.sleep(700);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");

	}		

	// <summary>
	// Test Case Title :"To verify what happens when user click No in the confirmation Popup."
	// Automation ID   : TC08 
	// </summary>
	public void ES_08_EditSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();


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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(4000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC08_SearchTeam);	
		Thread.sleep(4000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC08_SearchTeam));
		Thread.sleep(4000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC08_SearchTeam)),"User unable to unable to select Team");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC08_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify what happens when user clicks EDIT FRAME option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Done("d-flex","Edit Frame")),"Edit Frame Option Not Available");
		base.buttonClick(EditSnipObj.Btn_Done("d-flex","Edit Frame"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("editStartRange")),"User Unable to view Slider in snip editing Page");

		//Step 10  :To verify what happens when user adjust the slider on the editing page.
		//Expected:The slider's starting section is enabled to allow editing of the snip's beginning segment.
		String Actual=base.GetAttribte(LoginPageObj.Edt_LoginEmail("editRange1"),"className");
		base.moveSlider(LoginPageObj.Edt_LoginEmail("editRange1"),"value","Unable to edit the Slider");
		asrt.assertEquals(Actual,"sliderStart active","slider's starting section is not enabled");

		//Step 11 :To verify what happens when user switch |<BEGIN to END>| at the right side of the screen.
		//Expected:The slider's ending section is enabled to allow editing of the snip's end segment.
		base.buttonClick(EditSnipObj.Ele_SaveBtn("col-lg-2 col-2 col-md-2 col-xl-1 editMasterRight","end_btn"));	
		String Actual1=base.GetAttribte(LoginPageObj.Edt_LoginEmail("editRange2"),"className");
		base.moveSlider(LoginPageObj.Edt_LoginEmail("editRange2"),"value","Unable to edit the Slider");
		asrt.assertEquals(Actual1,"sliderEnd active","slider's Ending section is not enabled");

		//Step 12 :To verify what happens when user click the tick icon near the slider.
		//Expected:An confirmation pop up displays as "Do you want to update snip?"
		base.buttonClick(AddFollowerObj.Btn_MailTick("editSaveDiv","icon-snip-edit-save"));
		asrt.assertEquals(base.GetText(LoginPageObj.Edt_AlertText("Do you want to update snip?")), "Do you want to update snip?","Confirmation pop up not displaed as \"Do you want to update snip?");

		//Step13: Click No button.
		//Expected:User should able to click No button and the confirmation pop up closes when user clicks No in the confirmation Popup."
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
	}		

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the arrow near the tick icon"
	// Automation ID   : TC09 
	// </summary>
	public void ES_09_EditSnip() throws Exception
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj =new DeleteSnipPlayer_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		EditSnip_Obj EditSnipObj = new EditSnip_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		EditSnip_TestData EditSnipTestData = new EditSnip_TestData();

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
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), "AutomationOrg - 1");
		asrt.assertTrue(base.isExists(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations")),"User unable to Navigate to the Orglist and unable to select OrgName");

		//Step 6   :Select a Team from ORG
		//Expected:The New Team is Selected
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), EditSnipTestData.TC09_SearchTeam);	
		Thread.sleep(3000);
		base.excuteJsClick(LoginPageObj.Edt_Alert1(EditSnipTestData.TC09_SearchTeam));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(EditSnipTestData.TC09_SearchTeam)),"User unable to unable to select Team");

		//Step 7   :Select EVENTS/PRACTICES/SCOUT
		//Expected:Successfully selected the EVENTS 
		base.scrollToElement(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"User is unable to see Event");

		//Step 8  :Click on Game and Navigate to Player Page(Video play)
		//Expected: Successfully Navigate to Player Page
		base.setData(LoginPageObj.Edt_LoginEmail("search"), EditSnipTestData.TC09_Searchname);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("text-decoration-none text-reset"));	 
		base.switchToWindowByIndex(driver,1);//Switching to another window
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Entire Game Video - KS01_KeyBoard")),"Different Event Game Video/Irrelevant Video is Displaying");

		//Step 9  :To verify what happens when user clicks EDIT FRAME option form the pop up.
		//Expected:It should navigate to the snip editing page, featuring a slider.
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));//if 2 or more snip xpath needs to change	  
		asrt.assertTrue(base.isExists(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit")),"Unable to take Snip of the Video");
		base.excuteJsClick(MoveGameObj.Btn_Video_CreateSnip("float-end d-flex player-right-icons", "icon-snip-edit"));
		asrt.assertTrue(base.isExists(EditSnipObj.Btn_Done("d-flex","Edit Frame")),"Edit Frame Option Not Available");
		base.buttonClick(EditSnipObj.Btn_Done("d-flex","Edit Frame"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("editStartRange")),"User Unable to view Slider in snip editing Page");

		//Step 10  :To verify what happens when user adjust the slider on the editing page.
		//Expected:The slider's starting section is enabled to allow editing of the snip's beginning segment.
		String Actual=base.GetAttribte(LoginPageObj.Edt_LoginEmail("editRange1"),"className");
		base.moveSlider(LoginPageObj.Edt_LoginEmail("editRange1"),"value","Unable to edit the Slider");
		asrt.assertEquals(Actual,"sliderStart active","slider's starting section is not enabled");

		//Step 11 :To verify what happens when user switch |<BEGIN to END>| at the right side of the screen.
		//Expected:The slider's ending section is enabled to allow editing of the snip's end segment.
		base.buttonClick(EditSnipObj.Ele_SaveBtn("col-lg-2 col-2 col-md-2 col-xl-1 editMasterRight","end_btn"));	
		String Actual1=base.GetAttribte(LoginPageObj.Edt_LoginEmail("editRange2"),"className");
		base.moveSlider(LoginPageObj.Edt_LoginEmail("editRange2"),"value","Unable to edit the Slider");
		asrt.assertEquals(Actual1,"sliderEnd active","slider's Ending section is not enabled");

		//Step11:  Click the arrow near the tick icon
		//Expected:User should able to clickable the arrow near the tick icon and it should navigate to the player page.
		base.buttonClick(AddFollowerObj.Btn_MailTick("col-lg-10 col-xl-11 col-10 p-0 mt-2 editMasterLeft", "icon-snip-edit-left-arrow"));
		asrt.assertTrue(base.isExists(CreateUpdateDeleteGameObj.Ele_FirstTeamName("allFrame")),"'Tag Box' option is not displayed below video");
	}
}

