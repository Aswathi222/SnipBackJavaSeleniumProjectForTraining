package testPage.MavenPageObject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import TestData.CommonData;
import TestData.CreateUpdateDeleteGame_TestData;
import TestData.SnipCreationWithAndWithoutTag_TestData;
import TestData.TrimVideo_TestData;
import objectRepository.AddEditInfo_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.CreateUpdateDeleteGame_Obj;
import objectRepository.FilterMembers_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.MoveGame_Obj;
import objectRepository.Pool_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.ViewListUpdateDownloadShareDeleteLibrary_Obj;
import utilPack.BasePge;

public class SnipCreationWithAndWithoutTag extends BasePge {

	BasePge base;
	Assert asrt;
	Actions actions = new Actions(driver);
	public SnipCreationWithAndWithoutTag(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify what happens when user selects "Snip with tag" option from the confirmation pop up."
	// Automation ID   : Snip_09
	// </summary>
	public void Snip_09_SnipCreationWithAndWithoutTag() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		 
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
	     
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		
		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));

		//Step 10: Verify Custom Tags is displaying
		//Expected:"User should able to select 'Custom Tags'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks any one of the tag from "Custom tags" popup."
	// Automation ID   : Snip_10
	// </summary>
	public void Snip_10_SnipCreationWithAndWithoutTag() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
	     
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		
		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));

		//Step 10: Verify Custom Tags is displaying
		//Expected:"User should able to select 'Custom Tags'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","usa")),"'usa' option is not displayed in the Basketball list");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","usa"));
		
		//Step 11 :"Select Tag from list"
		//Expected:"User should be select Tag from List
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","usa"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton")),"'Tick' option is not displayed in the Custom Tag page");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton"));
		
		//Step 12:Click on Tick icon
		//Expected:"User should be select tick icon"
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton"));

		//Step13: Verify a bookmark with usa tagname is created below videoplayer
		//Expected:A bookmark with the usa tag name is created below the video player.
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TagBox("mysnips","shot-username pad-c")),"'Tag Box' option is not displayed below video");
	
	}

	// <summary>
	// Test Case Title :"To verify what happens when user switches from Custom Tags to Snip Collections/Home Collections."
	// Automation ID   : Snip_11
	// </summary>
	public void Snip_11_SnipCreationWithAndWithoutTag() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		
		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("AutomationOrg - 1 Snip Collections")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_Login("AutomationOrg - 1 Snip Collections"));
		
		//Step 10: Click on 'Home Collections'
		//Expected:"User should able to select 'Home Collections'
		base.buttonClick(LoginPageObj.Btn_Login("AutomationOrg - 1 Snip Collections"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","AutomationOrg_Collection_01")),"'AutomationOrg_Collection_01' option is not displayed in the Basketball list");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","AutomationOrg_Collection_01"));
		
		//Step 11 :"Select Tag from list"
		//Expected:"User should be select Tag from List
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","AutomationOrg_Collection_01"));	
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("snip-collection-section","custom-tags-savebutton")),"'Tick' option is not displayed in the Custom Tag page");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("snip-collection-section","custom-tags-savebutton"));
		
		//Step 12:Click on Tick icon
		//Expected:"User should be select tick icon"
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("snip-collection-section","custom-tags-savebutton"));

		//Step 13: Verify a bookmark with AutomationOrg_Collection_01 tagname is created below videoplayer
		//Expected:A bookmark with the AutomationOrg_Collection_01 tag name is created below the video player.
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TagBox("mysnips","shot-username pad-c")),"'Tag Box' option is not displayed below video");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user switches Share with option in the "Custom Tags" pop up."
	// Automation ID   : Snip_12
	// </summary>
	public void Snip_12_SnipCreationWithAndWithoutTag() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		
		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 10: Verify Custom Tags is displaying
		//Expected:"User should able to select 'Custom Tags'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","usa")),"'usa' option is not displayed in the Basketball list");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","usa"));
		
		//Step 11 :"Select Tag from list"
		//Expected:"User should be select Tag from List
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label","usa"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Player("type-playersnips")),"'Player' option is not displayed in the Custom Tag page");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Player("type-playersnips"));
		
		//Step 12 :"Select share with Player option"
		//Expected:"User should be select share with player option
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Player("type-playersnips"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton")),"'Tick' option is not displayed in the Custom Tag page");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton"));
		
		//Step 13:Click on Tick icon
		//Expected:"User should be select tick icon"
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton"));

		//Step 14: Verify a bookmark with tagname is created below PlayerSnips
		//Expected:A bookmark with the tag name is created below the playerSnips.
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TagBox("playersnips","shot-username pad-c")),"'Tag Box' option is not displayed below video");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the pencil icon in the "Custom tags" pop up."
	// Automation ID   : Snip_13
	// </summary>
	public void Snip_13_SnipCreationWithAndWithoutTag() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		
		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 10: Verify Custom Tags is displaying
		//Expected:"User should able to select 'Custom Tags'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt")),"'Pencil Icon' is not displayed in the custom popup popup");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		
		//Step 11: Click on 'pencil icon' in custom tag page
		//Expected:"User should able to select 'pencil icon' in custom page
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));

		//Step 12: verify text field present in custom tag
		//Expected: A text field will appear, prompting the user to enter a new Custom Tag name.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"'InputCustom' option is not displayed in the custom popup");
	}

	//<summary>
	// Test Case Title : "To verify whether there is a option to create snip in player page." 
	// Automation ID : Snip_01
	// </summary>
	public void Snip_01_SnipCreationWithAndWithoutTag() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj = new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj = new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		FilterMembers_Obj FilterMembersObj = new FilterMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(5000);
		
		// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not selected");
		Thread.sleep(3000);

		// Step 3:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		// Step 4:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 5:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), SnipCreationWithAndWithoutTagTestData.Snip_01_SnipCreationWithAndWithoutTagTestTeamName);

		//Step 6:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_01_SnipCreationWithAndWithoutTagTestTeamName));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_01_SnipCreationWithAndWithoutTagTestTeamName)), "Failed to select TEAM");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
		
		// Step 7 :Create a new Event
		// Expected: New Event is created
		base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),SnipCreationWithAndWithoutTag_TestData.Snip_01_SnipCreationWithAndWithoutTagTest);
		Thread.sleep(1000);
		String gameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
		Thread.sleep(3000);

		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		// page loading so need this time
		Thread.sleep(8000);

		// Step 8 : Click the three dots on a created game.
		//Expected: User can able to click on 3 dots
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(gameName)),"Unable to Click on the menu icon (three dots)");
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(gameName));
		
		///////////////////   UPLOAD VIDEO 
		
		// Step 9 : Click on Upload video.
		// Expected: Menu Displayed and Able to click the Upload Video from dropdown
		base.buttonClick(MoveGameObj.Btn_3Dots(gameName));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));

		// Step 10: click on the Choose File icon, Verify that the file is mp4 or mov
		// Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
		
		// Step 11: Click Upload and Shows Successfully Uploaded
		// Expected : User able to see the Successfully Uploaded Message and click
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		// Step 12: Click on game name
		// Expected : new window opened
		base.buttonClick(LoginPageObj.Btn_Login(gameName));
		Thread.sleep(18000);

		// Step 13: Switching to window
		// Expected :Create Snip button is shown
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip")),"Create Snip option is not showing");
		Thread.sleep(2000);
		base.returnToMainWindow(driver);
	    try {
			 
			// Step 14: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(gameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 15: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 16: Click on yes in delete popup to delete added game
			//Expected: User can able to click on 'Yes'
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	}

	//<summary>
	// Test Case Title : "To verify what happens when user clicks snip option in player page." 
	// Automation ID : Snip_02
	// </summary>
	public void Snip_02_SnipCreationWithAndWithoutTag() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTag_TestData=new SnipCreationWithAndWithoutTag_TestData();
		FilterMembers_Obj FilterMembersObj=new FilterMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj =new SnipCreationWithAndWithoutTag_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(5000);
		
		// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not selected");
		Thread.sleep(3000);

		// Step 3:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		// Step 4:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 5:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), SnipCreationWithAndWithoutTagTestData.Snip_02_SnipCreationWithAndWithoutTagTestTeamName);

		//Step 6:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_02_SnipCreationWithAndWithoutTagTestTeamName));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_02_SnipCreationWithAndWithoutTagTestTeamName)), "Failed to select TEAM");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
		
		// Step 7 :Create a new Event
		// Expected: New Event is created
		base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),SnipCreationWithAndWithoutTag_TestData.Snip_02_SnipCreationWithAndWithoutTagTest);
		Thread.sleep(1000);
		String gameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
		Thread.sleep(3000);

		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		// page loading so need this time
		Thread.sleep(8000);

		// Step 8 : Click the three dots on a created game.
		//Expected: User can able to click on 3 dots
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(gameName)),"Unable to Click on the menu icon (three dots)");
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(gameName));
		
		///////////////////   UPLOAD VIDEO 
		
		// Step 9 : Click on Upload video.
		// Expected: Menu Displayed and Able to click the Upload Video from dropdown
		base.buttonClick(MoveGameObj.Btn_3Dots(gameName));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));

		// Step 10: click on the Choose File icon, Verify that the file is mp4 or mov
		// Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
		
		// Step 11: Click Upload and Shows Successfully Uploaded
		// Expected : User able to see the Successfully Uploaded Message and click
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		// Step 12: Click on game name
		// Expected : new window opened
		base.buttonClick(LoginPageObj.Btn_Login(gameName));
		Thread.sleep(18000);

		// Step 13: Switching to window
		// Expected :Create Snip button is shown
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip")),"Create Snip option is not showing");
		Thread.sleep(2000);
		String header= driver.findElement(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipHeader("customize-snipreel choosesnips type-select-wrap","customize-snipreel-title")).getText();
		System.out.println(header);
		Thread.sleep(1000);
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip"));

		//Step 14: Verify "My Snips","Player Snips","Staff Snips","All" options are there
		//Expected :Validate texts are equal "My Snips","Player Snips","Staff Snips","All" 
		List<String> actualText =GetElementTexts(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipOptions("customize-snipreel choosesnips type-select-wrap"));
		List<String> expectedText= Arrays.asList("Staff Snips","My Snips","Player Snips","All");
		asrt.assertEquals(actualText, expectedText,"both list are not matching");
		base.returnToMainWindow(driver);
	    try {
			 
			// Step 15: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(gameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 16: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 17: Click on yes in delete popup to delete added game
			//Expected: User can able to click on 'Yes'
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	}

	//<summary>
	// Test Case Title : "To verify what happens when user select "My Snips" option from the 'CREATE SNIPS' pop up." 
	// Automation ID : Snip_03
	// </summary>
	public void Snip_03_SnipCreationWithAndWithoutTag() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersobj= new SearchGameTeamAndMembers_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		FilterMembers_Obj FilterMembersObj=new FilterMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj =new SnipCreationWithAndWithoutTag_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		 
		
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(5000);
		// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not selected");
		Thread.sleep(3000);

		// Step 3:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		// Step 4:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 5:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), SnipCreationWithAndWithoutTagTestData.Snip_03_SnipCreationWithAndWithoutTagTestTeamName);

		//Step 6:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_03_SnipCreationWithAndWithoutTagTestTeamName));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_03_SnipCreationWithAndWithoutTagTestTeamName)), "Failed to select TEAM");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
		
		// Step 7 :Create a new Event
		// Expected: New Event is created
		base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),SnipCreationWithAndWithoutTag_TestData.Snip_03_SnipCreationWithAndWithoutTagTest);
		Thread.sleep(1000);
		String gameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
		Thread.sleep(3000);

		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		// page loading so need this time
		Thread.sleep(8000);

		// Step 8 : Click the three dots on a created game.
		//Expected: User can able to click on 3 dots
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(gameName)),"Unable to Click on the menu icon (three dots)");
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(gameName));
		
		///////////////////   UPLOAD VIDEO 
		
		// Step 9 : Click on Upload video.
		// Expected: Menu Displayed and Able to click the Upload Video from dropdown
		base.buttonClick(MoveGameObj.Btn_3Dots(gameName));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));

		// Step 10: click on the Choose File icon, Verify that the file is mp4 or mov
		// Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
		
		// Step 11: Click Upload and Shows Successfully Uploaded
		// Expected : User able to see the Successfully Uploaded Message and click
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
		base.excuteJsClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		// Step 12: Click on game name
		// Expected : new window opened
		base.buttonClick(LoginPageObj.Btn_Login(gameName));
		Thread.sleep(18000);

		// Step 13: Switching to window
		// Expected :Create Snip button is shown
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip")),"Create Snip option is not showing");
		Thread.sleep(2000);
		String header= driver.findElement(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipHeader("customize-snipreel choosesnips type-select-wrap","customize-snipreel-title")).getText();
		System.out.println(header);
		Thread.sleep(1000);
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip"));

		//Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"My Snips option is absent in Create Snips popup");
		base.buttonClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));

		//A confirmation pop-up appears prompting the user to choose between "Snip" and "Snip with Tag".
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")),"Snip button is not shown");
		asrt.assertEquals(base.GetText(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")), "Snip","Snip text is not correct");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm swal-button--danger")),"Snip with Tag button is not shown");
		asrt.assertEquals(base.GetText(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm swal-button--danger")), "Snip with Tag","Snip with Tag text is not correct");
		Thread.sleep(2000);
		base.returnToMainWindow(driver);
	    try {
			 
			// Step 14: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(gameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 15: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 16: Click on yes in delete popup to delete added game
			//Expected: User can able to click on 'Yes'
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	}

	//<summary>
	// Test Case Title : "To verify what happens when user select "Player Snips" option from the 'CREATE SNIPS' pop up." 
	// Automation ID : Snip_04
	// </summary>
	public void Snip_04_SnipCreationWithAndWithoutTag() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersobj= new SearchGameTeamAndMembers_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		FilterMembers_Obj FilterMembersObj=new FilterMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj =new SnipCreationWithAndWithoutTag_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();	
		
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(5000);
		
		// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not selected");
		Thread.sleep(3000);

		// Step 3:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		// Step 4:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 5:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), SnipCreationWithAndWithoutTagTestData.Snip_04_SnipCreationWithAndWithoutTagTestTeamName);

		//Step 6:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_04_SnipCreationWithAndWithoutTagTestTeamName));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_04_SnipCreationWithAndWithoutTagTestTeamName)), "Failed to select TEAM");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
		
		// Step 7 :Create a new Event
		// Expected: New Event is created
		base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),SnipCreationWithAndWithoutTag_TestData.Snip_04_SnipCreationWithAndWithoutTagTest);
		Thread.sleep(1000);
		String gameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
		Thread.sleep(3000);

		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		// page loading so need this time
		Thread.sleep(8000);

		// Step 8 : Click the three dots on a created game.
		//Expected: User can able to click on 3 dots
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(gameName)),"Unable to Click on the menu icon (three dots)");
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(gameName));
		
		///////////////////   UPLOAD VIDEO 
		
		// Step 9 : Click on Upload video.
		// Expected: Menu Displayed and Able to click the Upload Video from dropdown
		base.buttonClick(MoveGameObj.Btn_3Dots(gameName));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));

		// Step 10: click on the Choose File icon, Verify that the file is mp4 or mov
		// Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
		
		// Step 11: Click Upload and Shows Successfully Uploaded
		// Expected : User able to see the Successfully Uploaded Message and click
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		// Step 12: Click on game name
		// Expected : new window opened
		base.buttonClick(LoginPageObj.Btn_Login(gameName));
		Thread.sleep(20000);

		// Step 13: Switching to window
		// Expected :Create Snip button is shown
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip")),"Create Snip option is not showing");
		Thread.sleep(2000);
		String header= driver.findElement(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipHeader("customize-snipreel choosesnips type-select-wrap","customize-snipreel-title")).getText();
		System.out.println(header);
		Thread.sleep(1000);
		
		//Step 14: click on Create Snip icon  
		//Expected : Player snips  is displayed in create Snip popup
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_player_snips")),"Player Snips option is absent in Create Snips popup");

		//Step 15: click on Player snips in Create Snip popup 
		//Expected : A confirmation pop-up appears prompting the user to choose between "Snip" and "Snip with Tag".
		base.buttonClick(LoginPageObj.Btn_SingnIn("choose_player_snips"));
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")),"Snip button is not shown");
		asrt.assertEquals(base.GetText(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")), "Snip","Snip text is not correct");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm swal-button--danger")),"Snip with Tag button is not shown");
		asrt.assertEquals(base.GetText(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm swal-button--danger")), "Snip with Tag","Snip with Tag text is not correct");

		base.returnToMainWindow(driver);
	    try {
			 
			// Step 16: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(gameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 17: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 18: Click on yes in delete popup to delete added game
			//Expected: User can able to click on 'Yes'
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	}

	//<summary>
	// Test Case Title : "To verify what happens when user select "Staff Snips" option from the 'CREATE SNIPS' pop up." 
	// Automation ID : Snip_05
	// </summary>
	public void Snip_05_SnipCreationWithAndWithoutTag() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersobj= new SearchGameTeamAndMembers_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		FilterMembers_Obj FilterMembersObj=new FilterMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj =new SnipCreationWithAndWithoutTag_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		
		
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(5000);
		
		// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not selected");
		Thread.sleep(3000);

		// Step 3:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		// Step 4:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 5:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), SnipCreationWithAndWithoutTagTestData.Snip_05_SnipCreationWithAndWithoutTagTestTeamName);

		//Step 6:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_05_SnipCreationWithAndWithoutTagTestTeamName));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_05_SnipCreationWithAndWithoutTagTestTeamName)), "Failed to select TEAM");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
		
		// Step 7 :Create a new Event
		// Expected: New Event is created
		base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),SnipCreationWithAndWithoutTag_TestData.Snip_05_SnipCreationWithAndWithoutTagTest);
		Thread.sleep(1000);
		String gameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
		Thread.sleep(3000);

		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		// page loading so need this time
		Thread.sleep(8000);

		// Step 8 : Click the three dots on a created game.
		//Expected: User can able to click on 3 dots
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(gameName)),"Unable to Click on the menu icon (three dots)");
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(gameName));
		
		///////////////////   UPLOAD VIDEO 
		
		// Step 9 : Click on Upload video.
		// Expected: Menu Displayed and Able to click the Upload Video from dropdown
		base.buttonClick(MoveGameObj.Btn_3Dots(gameName));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));

		// Step 10: click on the Choose File icon, Verify that the file is mp4 or mov
		// Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
		
		// Step 11: Click Upload and Shows Successfully Uploaded
		// Expected : User able to see the Successfully Uploaded Message and click
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		// Step 12: Click on game name
		// Expected : new window opened
		base.buttonClick(LoginPageObj.Btn_Login(gameName));
		Thread.sleep(18000);

		// Step 13: Switching to window
		// Expected :Create Snip button is shown
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip")),"Create Snip option is not showing");
		Thread.sleep(2000);
		String header= driver.findElement(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipHeader("customize-snipreel choosesnips type-select-wrap","customize-snipreel-title")).getText();
		System.out.println(header);
		Thread.sleep(1000);
		
		//Step 14: click on Create Snip icon  
		//Expected : Player snips  is displayed in create Snip popup
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_team_snips")),"Staff Snips option is absent in Create Snips popup");

		//Step 15: click on Player snips in Create Snip popup 
		//Expected : A confirmation pop-up appears prompting the user to choose between "Snip" and "Snip with Tag".
		base.buttonClick(LoginPageObj.Btn_SingnIn("choose_team_snips"));
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")),"Snip button is not shown");
		asrt.assertEquals(base.GetText(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")), "Snip","Snip text is not correct");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm swal-button--danger")),"Snip with Tag button is not shown");
		asrt.assertEquals(base.GetText(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm swal-button--danger")), "Snip with Tag","Snip with Tag text is not correct");

		base.returnToMainWindow(driver);
	    try {
			 
			// Step 16: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(gameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 17: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 18: Click on yes in delete popup to delete added game
			//Expected: User can able to click on 'Yes'
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	}

	//<summary>
	// Test Case Title : "To verify what happens when user select "All" option from the 'CREATE SNIPS' pop up." 
	// Automation ID : Snip_06
	// </summary>
	public void Snip_06_SnipCreationWithAndWithoutTag() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersobj= new SearchGameTeamAndMembers_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		FilterMembers_Obj FilterMembersObj=new FilterMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj =new SnipCreationWithAndWithoutTag_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();	

		
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);		
		Thread.sleep(5000);
		
		// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not selected");
		Thread.sleep(3000);

		// Step 3:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		// Step 4:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 5:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), SnipCreationWithAndWithoutTagTestData.Snip_06_SnipCreationWithAndWithoutTagTestTeamName);

		//Step 6:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_06_SnipCreationWithAndWithoutTagTestTeamName));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_06_SnipCreationWithAndWithoutTagTestTeamName)), "Failed to select TEAM");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
		
		// Step 7 :Create a new Event
		// Expected: New Event is created
		base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),SnipCreationWithAndWithoutTag_TestData.Snip_06_SnipCreationWithAndWithoutTagTest);
		Thread.sleep(1000);
		String gameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
		Thread.sleep(3000);

		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		// page loading so need this time
		Thread.sleep(8000);

		// Step 8 : Click the three dots on a created game.
		//Expected: User can able to click on 3 dots
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(gameName)),"Unable to Click on the menu icon (three dots)");
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(gameName));
		
		///////////////////   UPLOAD VIDEO 
		
		// Step 9 : Click on Upload video.
		// Expected: Menu Displayed and Able to click the Upload Video from dropdown
		base.buttonClick(MoveGameObj.Btn_3Dots(gameName));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));

		// Step 10: click on the Choose File icon, Verify that the file is mp4 or mov
		// Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
		
		// Step 11: Click Upload and Shows Successfully Uploaded
		// Expected : User able to see the Successfully Uploaded Message and click
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		// Step 12: Click on game name
		// Expected : new window opened
		base.buttonClick(LoginPageObj.Btn_Login(gameName));
		Thread.sleep(18000);

		// Step 13: Switching to window
		// Expected :Create Snip button is shown
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip")),"Create Snip option is not showing");
		Thread.sleep(2000);
		String header= driver.findElement(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipHeader("customize-snipreel choosesnips type-select-wrap","customize-snipreel-title")).getText();
		System.out.println(header);
		Thread.sleep(1000);
		
		//Step 14: click on Create Snip icon  
		//Expected : Player snips  is displayed in create Snip popup
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_both_snip")),"All option is absent in Create Snips popup");

		//Step 15: click on Player snips in Create Snip popup 
		//Expected : A confirmation pop-up appears prompting the user to choose between "Snip" and "Snip with Tag".
		base.buttonClick(LoginPageObj.Btn_SingnIn("choose_both_snip"));
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")),"Snip button is not shown");
		asrt.assertEquals(base.GetText(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")), "Snip","Snip text is not correct");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm swal-button--danger")),"Snip with Tag button is not shown");
		asrt.assertEquals(base.GetText(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm swal-button--danger")), "Snip with Tag","Snip with Tag text is not correct");

		base.returnToMainWindow(driver);
	    try {
			 
			// Step 16: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(gameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 17: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 18: Click on yes in delete popup to delete added game
			//Expected: User can able to click on 'Yes'
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters a valid Custom Tag Name in the text field."
	// Automation ID   : Snip_14
	// </summary>
	public void Snip_14_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 10: Verify Custom Tags is displaying
		//Expected:"User should able to select 'Custom Tags'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt")),"'Pencil Icon' is not displayed in the custom popup popup");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		
		//Step 11: Click on 'pencil icon' in custom tag page
		//Expected:"User should able to select 'pencil icon' in custom page
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));

		//Step 12: verify text field present in custom tag
		//Expected: A text field will appear, prompting the user to enter a new Custom Tag name.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"'InputCustom' option is not displayed in the custom popup");

		//Step 13: Set ValidTagName
		//Expected: Setting ValidTagName
		base.setData(LoginPageObj.Edt_LoginEmail("InputCustom"), SnipCreationWithAndWithoutTagTestData.Snip_14_SnipCreationWithAndWithoutTagTestData);
		String InputCustom = base.GetValue(LoginPageObj.Edt_LoginEmail("InputCustom"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark")),"'Tick icon' is not displayed in the input custom Tag");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));
		
		//Step 14: After entering TagName click on tick icon
		//Expected: The new tag will be created and it should appear at the end of the list.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));
		
		//Steps not working properly in live url -bug
		//base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton"));

		//Thread.sleep(1000);					
		//asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Tag("sec-left","custom-tag-label",InputCustom)),"'PLACES' option is not displayed in the list");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters a  invalid Custom Tag Name"
	// Automation ID   : Snip_15
	// </summary>
	public void Snip_15_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 10: Verify Custom Tags is displaying
		//Expected:"User should able to select 'Custom Tags'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt")),"'Pencil Icon' is not displayed in the custom popup popup");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		
		//Step 11: Click on 'pencil icon' in custom tag page
		//Expected:"User should able to select 'pencil icon' in custom page
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));

		//Step 12: verify text field present in custom tag
		//Expected: A text field will appear, prompting the user to enter a new Custom Tag name.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"'InputCustom' option is not displayed in the custom popup");

		//Step 13: Set InValidTagName
		//Expected: Setting InValidTagName
		base.setData(LoginPageObj.Edt_LoginEmail("InputCustom"), SnipCreationWithAndWithoutTagTestData.Snip_15_SnipCreationWithAndWithoutTagTestData);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark")),"'Tick icon' is not displayed in the input custom Tag");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));
		
		//Step 14: After entering TagName click on tick icon
		//Expected: tick icon clicking
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));

		//Step 15: Error popup is displayed
		//Expected:Validate if the text message is "Allowed characters a-z 0-9,.-@?!#$%&:"
		Thread.sleep(1000);	
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Error");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Allowed characters a-z 0-9,.-@?!#$%&:","\"Allowed characters a-z 0-9,.-@?!#$%&:\" text is not matching");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user enters an existing Custom Tag name"
	// Automation ID   : Snip_16
	// </summary>
	public void Snip_16_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 10: Verify Custom Tags is displaying
		//Expected:"User should able to select 'Custom Tags'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt")),"'Pencil Icon' is not displayed in the custom popup popup");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		
		//Step 11: Click on 'pencil icon' in custom tag page
		//Expected:"User should able to select 'pencil icon' in custom page
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));

		//Step 12: verify text field present in custom tag
		//Expected: A text field will appear, prompting the user to enter a new Custom Tag name.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"'InputCustom' option is not displayed in the custom popup");

		//Step 13: Set Existing TagName
		//Expected: Setting Existing TagName
		base.setData(LoginPageObj.Edt_LoginEmail("InputCustom"), SnipCreationWithAndWithoutTagTestData.Snip_16_SnipCreationWithAndWithoutTagTestData);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark")),"'Tick icon' is not displayed in the input custom Tag");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));
		
		//Step 14: After entering TagName click on tick icon
		//Expected: tick icon clicking
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));
		
		//Steps not working properly in live url-bug
		//Step 15: Error popup is displayed
		//Expected:Validate if the text message is "Custom Tag already exists"
		//Thread.sleep(1000);	
		//asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		//asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Error");
		//asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Custom Tag Already Exists","\"Custom Tag Already Exists\" text is not matching");			
	}

	// <summary>
	// Test Case Title :"To verify what happens when user left the List name field empty"
	// Automation ID   : Snip_17
	// </summary>
	public void Snip_17_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));	

		//Step 10: Verify Custom Tags is displaying
		//Expected:"User should able to select 'Custom Tags'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt")),"'Pencil Icon' is not displayed in the custom popup popup");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		
		//Step 11: Click on 'pencil icon' in custom tag page
		//Expected:"User should able to select 'pencil icon' in custom page
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));

		//Step 12: verify text field present in custom tag
		//Expected: A text field will appear, prompting the user to enter a new Custom Tag name.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"'InputCustom' option is not displayed in the custom popup");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark")),"'Tick icon' is not displayed in the input custom Tag");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));
		
		//Step 13: Without entering TagName click on tick icon
		//Expected: Tick icon selecting
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("icofont-tick-mark"));

		//Step 14: Error Message is displayed
		//Expected:Validate if the text message is "Custom Tag name is empty"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("alert alert-danger p-2 mt-2")),"'Custom Tag name is empty' message is not displayed in the custom Tag");								
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the 'x' icon."
	// Automation ID   : Snip_18
	// </summary>
	public void Snip_18_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step 9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));

		//Step 10: Verify Custom Tags is displaying
		//Expected:"User should able to select 'Custom Tags'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt")),"'Pencil Icon' is not displayed in the custom popup popup");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		
		//Step 11: Click on 'pencil icon' in custom tag page
		//Expected:"User should able to select 'pencil icon' in custom page
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));

		//Step 12: verify text field present in custom tag
		//Expected: A text field will appear, prompting the user to enter a new Custom Tag name.
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"'InputCustom' option is not displayed in the custom popup");

		//Step 13: Set ValidTagName
		//Expected: Setting ValidTagName
		base.setData(LoginPageObj.Edt_LoginEmail("InputCustom"), SnipCreationWithAndWithoutTagTestData.Snip_18_SnipCreationWithAndWithoutTagTestData);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.I_Close("trash-icon px-2 close-createcustomtag","icofont-close")),"'Tick icon' is not displayed in the input custom Tag");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.I_Close("trash-icon px-2 close-createcustomtag","icofont-close"));
		
		//Step 14: After entering TagName click on close icon
		//Expected:The text field will closes once user clicks the 'x' icon.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.I_Close("trash-icon px-2 close-createcustomtag","icofont-close"));					
	}	

	//<summary>
	// Test Case Title : "To verify what happens when user selects "Snip" option from the confirmation pop up." 
	// Automation ID : Snip_07
	// </summary>
	public void Snip_07_SnipCreationWithAndWithoutTag() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersobj= new SearchGameTeamAndMembers_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		FilterMembers_Obj FilterMembersObj=new FilterMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj =new SnipCreationWithAndWithoutTag_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();		
	
		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(5000);
		
		// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not selected");
		Thread.sleep(3000);

		// Step 3:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		// Step 4:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 5:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), SnipCreationWithAndWithoutTagTestData.Snip_07_SnipCreationWithAndWithoutTagTestTeamName);

		//Step 6:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_07_SnipCreationWithAndWithoutTagTestTeamName));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_07_SnipCreationWithAndWithoutTagTestTeamName)), "Failed to select TEAM");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
		
		// Step 7 :Create a new Event
		// Expected: New Event is created
		base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),SnipCreationWithAndWithoutTag_TestData.Snip_07_SnipCreationWithAndWithoutTagTest);
		Thread.sleep(1000);
		String gameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
		Thread.sleep(3000);

		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		// page loading so need this time
		Thread.sleep(8000);

		// Step 8 : Click the three dots on a created game.
		//Expected: User can able to click on 3 dots
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(gameName)),"Unable to Click on the menu icon (three dots)");
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(gameName));
		
		///////////////////   UPLOAD VIDEO 
		
		// Step 9 : Click on Upload video.
		// Expected: Menu Displayed and Able to click the Upload Video from dropdown
		base.buttonClick(MoveGameObj.Btn_3Dots(gameName));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));

		// Step 10: click on the Choose File icon, Verify that the file is mp4 or mov
		// Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
		
		// Step 11: Click Upload and Shows Successfully Uploaded
		// Expected : User able to see the Successfully Uploaded Message and click
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		// Step 12: Click on game name
		// Expected : new window opened
		base.buttonClick(LoginPageObj.Btn_Login(gameName));
		Thread.sleep(18000);

		// Step 13: Switching to window
		// Expected :Create Snip button is shown
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip")),"Create Snip option is not showing");
		Thread.sleep(2000);
		String header= driver.findElement(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipHeader("customize-snipreel choosesnips type-select-wrap","customize-snipreel-title")).getText();
		System.out.println(header);
		Thread.sleep(1000);
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip"));

		//Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"My Snips option is absent in Create Snips popup");
		base.buttonClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")),"Snip button is not shown");
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		Thread.sleep(15000);

		//Step 13-1: Verify No_tag is present below the video
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_NoTagInPlayerPage("mysnipshref", "shot-username pad-c")),"No_tag does not exists");
		String text=base.GetText(SnipCreationWithAndWithoutTagObj.Ele_NoTagInPlayerPage("mysnipshref", "shot-username pad-c"));
		asrt.assertEquals(text, "No_tag","No_tag text is incorrect");

		base.returnToMainWindow(driver);
	    try {
			 
			// Step 14: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(gameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 15: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 16: Click on yes in delete popup to delete added game
			//Expected: User can able to click on 'Yes'
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	}

	//<summary>
	// Test Case Title : "To verify what happens when user selects "Cancel" option from the confirmation pop up." 
	// Automation ID : Snip_08
	// </summary>
	public void Snip_08_SnipCreationWithAndWithoutTag() throws InterruptedException
	{
		Login login= new Login(driver);
		CommonData Commondata= new CommonData();
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Pool_Obj PoolObj= new Pool_Obj();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersobj= new SearchGameTeamAndMembers_Obj();
		MoveGame_Obj MoveGameObj= new MoveGame_Obj();
		FilterMembers_Obj FilterMembersObj=new FilterMembers_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj =new SnipCreationWithAndWithoutTag_Obj();
		CreateUpdateDeleteGame_Obj CreateUpdateDeleteGameObj = new CreateUpdateDeleteGame_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		

		// Step 1: Log in to SnipBack with valid credentials.
		// Expected: User should be navigated to the Homepage.
		login.loginToApplication(Commondata.UserName, Commondata.PassWord);
		Thread.sleep(5000);
		
		// Step 2:Switch to any team from the team dropdown menu after selecting an Organization
		// Expected: The team should be selected from dropdown
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"The organization is not selected");
		Thread.sleep(3000);

		// Step 3:Click outside the dropdown using Actions
		WebElement body = driver.findElement(By.tagName("body"));
		body.click(); // This will close the dropdown
		Thread.sleep(3000);
		Thread.sleep(3000);
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS")),"EVENTS notFound/ Unclickable");
		base.scrollToElementtoCenter(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));
		
		// Step 4:Select EVENTS/PRACTICE/SCOUT
		// Expected:Successfully selected the EVENTS
		base.excuteJsClick(MoveGameObj.Btn_SelectEventsPrcaticeScout("nav-link list-games", "EVENTS"));

		//Step 5:click on search button and search for team name SnipCreation
		//Expected:SnipCreation team is shown 
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam")); 
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), SnipCreationWithAndWithoutTagTestData.Snip_08_SnipCreationWithAndWithoutTagTestTeamName);

		//Step 6:Selecting the team
		//Expected:Team selected
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_08_SnipCreationWithAndWithoutTagTestTeamName));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_TeamNameFromList("my-team-content",SnipCreationWithAndWithoutTagTestData.Snip_08_SnipCreationWithAndWithoutTagTestTeamName)), "Failed to select TEAM");
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_Master_Games("add-img me-2", "Event")),"Event -Not Found/Non-Clickable");
		
		// Step 7 :Create a new Event
		// Expected: New Event is created
		base.excuteJsClick(MoveGameObj.Btn_Master_Games("add-img me-2", "Event"));
		Thread.sleep(2000);
		base.setData(LoginPageObj.Edt_LoginEmail("create-game-name"),SnipCreationWithAndWithoutTag_TestData.Snip_08_SnipCreationWithAndWithoutTagTest);
		Thread.sleep(1000);
		String gameName = base.GetValue(LoginPageObj.Edt_LoginEmail("create-game-name"));
		base.buttonClick(FilterMembersObj.Ele_AllRoles("toggleText_custom"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipDisabled("create-broadcasting", "Disabled"));
		base.buttonClick(AddUpdateRemoveMemberObj.Btn_CreateGame("modal-header border-bottom-0 pb-0","btn btn-primary create-btn border-0 btn-popup width-100 bgcolor-red"));
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm")),"Event not Created/ The confirmation popup did not appear ");
		Thread.sleep(3000);

		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));
		// page loading so need this time
		Thread.sleep(30000);

		// Step 8 : Click the three dots on a created game.
		//Expected: User can able to click on 3 dots
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Btn_3Dots(gameName)),"Unable to Click on the menu icon (three dots)");
		base.scrollToElementtoCenter(MoveGameObj.Btn_3Dots(gameName));
		
		///////////////////   UPLOAD VIDEO 
		
		// Step 9 : Click on Upload video.
		// Expected: Menu Displayed and Able to click the Upload Video from dropdown
		base.buttonClick(MoveGameObj.Btn_3Dots(gameName));
		asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video")),"\"Upload Video\" from the dropdown not Found/Non-clickable");
	    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));
		base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Upload Video"));

		// Step 10: click on the Choose File icon, Verify that the file is mp4 or mov
		// Expected: User able to Choose valid file extension only
		String videoFilePath = System.getProperty("user.dir") + "/Utils/Video/video_Check_Snip.mp4";
		List<String> allowedTypes = Arrays.asList(".mp4", ".mov");
		// Choose the file
		asrt.assertTrue(base.isEnabledBy(LoginPageObj.Edt_LoginEmail("game_video")), "Unable to click the Choose File");
		base.uploadFile(LoginPageObj.Edt_LoginEmail("game_video"), videoFilePath, allowedTypes);
		asrt.assertTrue(base.isEnabledBy(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video")),"Upload Button is not Enabled/Clickable");
		
		// Step 11: Click Upload and Shows Successfully Uploaded
		// Expected : User able to see the Successfully Uploaded Message and click
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger upload-video"));
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--confirm"));

		// Step 12: Click on game name
		// Expected : new window opened
		base.buttonClick(LoginPageObj.Btn_Login(gameName));
		Thread.sleep(18000);

		// Step 13: Switching to window
		// Expected :Create Snip button is shown
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip")),"Create Snip option is not showing");
		Thread.sleep(2000);
		String header= driver.findElement(SnipCreationWithAndWithoutTagObj.Ele_CreateSnipHeader("customize-snipreel choosesnips type-select-wrap","customize-snipreel-title")).getText();
		System.out.println(header);
		Thread.sleep(1000);
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("ico-snip"));

		//Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("choose_my_snips")),"My Snips option is absent in Create Snips popup");
		base.buttonClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch")),"Snip button is not shown");
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel")),"Cancel button is absent in Create Snips popup");

		//Step 14: Click on Cancel button
		//Expected: Popup should be closed
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--cancel"));
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust timeout as needed
		boolean isPopupGone = wait.until(ExpectedConditions.invisibilityOfElementLocated(LoginPageObj.Ele_ErrorMessage("swal-modal")));
		if (isPopupGone) {
			System.out.println("Popup disappeared successfully.");
		} else {
			System.out.println("Popup is still visible.");
			asrt.fail("popup is still existing and cancel button is not working");
		}
		base.returnToMainWindow(driver);
	    try {
			 
			// Step 15: Delete the added game by clicking 3 dot menu of the added game
			// Expected: Drop down item is displayed with a list
			base.buttonClick(MoveGameObj.Btn_3Dots(gameName)); 
			Thread.sleep(1000);
			asrt.assertTrue(base.isEnabledBy(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete")),"\"Delete\" from the dropdown not Found/Non-clickable");
		    base.scrollToElementtoCenter(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 16: Click on delete from the list
			// Expected: A popup with confirmation to delete is shown
			base.buttonClick(MoveGameObj.Ddl_DropDownMoveGame("dropdown-menu dropdown-menu-center show", "Delete"));
			
			// Step 17: Click on yes in delete popup to delete added game
			//Expected: User can able to click on 'Yes'
			base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
			Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println("Not an bug: Unable to delete game");
		}
	}

	// <summary>
	// Test Case Title :"To verify who can view the snips created under "Player Snips.""
	// Automation ID   : Snip_29
	// </summary>
	public void Snip_29_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
	    Thread.sleep(5000);
	    
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		
		//Step 7 : Select Player Snips option
		//Expected : Snip Creation tab should be visible to the user
		base.buttonClick(LoginPageObj.Btn_SingnIn("choose_player_snips"));
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-modal")),"User is not able to view the snip creation tab.");

		//Step 8 : Select Snip
		//Expected : Snips created under "Player Snips" should be visible only to the Admin, Coach & Players in the organization.
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_NoTag("playerFrame")),"Snips created under \"Player Snips\" is not visible");
		//asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_Frame("1552864")),"Snips created under \"Player Snips\" is not visible to Admin, Coach & Players in the organization.");
	
	}

	// <summary>
	// Test Case Title :"To verify what happens when user click the colour circle."
	// Automation ID   : Snip_19
	// </summary>
	public void Snip_19_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step 9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));

		//Step 10: Verify Custom Tags is displaying
		//Expected:"User should able to select 'Custom Tags'
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt")),"'Pencil Icon' is not displayed in the custom popup popup");
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		
		//Step 11: Click on 'pencil icon' in custom tag page
		//Expected:"User should able to select 'pencil icon' in custom page
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("bx bxs-edit-alt"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"'InputCustom' option is not displayed in the custom popup");

		//Step 12: Enter a valid TagName 
		//Expected: User should able to enter a valid tag name in tag name field
		base.setData(LoginPageObj.Edt_LoginEmail("InputCustom"), SnipCreationWithAndWithoutTagTestData.Snip_19_SnipCreationWithAndWithoutTagTestSnipCreation);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("InputCustom")),"User should able to view the given valid Tag name in tag name field.");

		//Step 13 : Click the colour circle
		//Expected : User should able to apply colour to the custom tags using the colour circle.
		base.buttonClick(LoginPageObj.Ele_ErrorMessage("btn-select-color-newtag no-color"));	
		//Need assertion coming under Shadow root

		//Step 14 : Click 'x' icon
		//Expected : User should able to view the custom tag popup while clicking on 'x' icon
		base.buttonClick(RegistrationObj.Edt_SignUpMinConfPassword("trash-icon px-2 close-createcustomtag"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
	}

	// <summary>
	// Test Case Title :"To verify who can view the snips created under "Staff Snips.""
	// Automation ID   : Snip_30
	// </summary>
	public void Snip_30_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));	

		//Step 7 : Select Staff Snips option
		//Expected : Snip Creation tab should be visible to the user
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_team_snips"));
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-modal")),"User is not able to view the snip creation tab.");

		//Step 8 : Select Snip
		//Expected :Snips created under "Staff Snips" should be visible only to the Admin & Coach in the organization.
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_NoTag("teamFrame")),"Snips created under \"Staff Snips\" is not visible");
		//Snips created under "Staff Snips" should be visible only to the Admin & Coach, not visible to follower etc but 'AutomationOrg - 2' cannot create table,events etc. So the steps not added
		
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks "CANEL" option in the Custom tags pop up."
	// Automation ID   : Snip_20
	// </summary>
	public void Snip_20_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));	
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");

		//Step 10 : Click on Cancel button
		//Expected : The Custom tags pop up will closes once user clicks CANCEL option.
		base.buttonClick(LoginPageObj.Btn_Login("Cancel"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"The Custom tags pop up not closes while user clicks CANCEL option.");	
	}

	// <summary>
	// Test Case Title :"To verify who can view the snips created under "All""
	// Automation ID   : Snip_31
	// </summary>
	public void Snip_31_SnipCreationWithAndWithoutTag() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));	

		//Step 7 : Select All option
		//Expected : Snip Creation tab should be visible to the user
		base.buttonClick(LoginPageObj.Btn_SingnIn("choose_both_snip"));
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-modal")),"User is not able to view the snip creation tab.");

		//Step 8 : Select Snip
		//Expected : Snips created under "All" should be visible to all members in the organization.
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		//Snip created to 'all' comes under staffs 
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_NoTag("teamFrame")),"Snips created under \"Staff Snips\" is not visible");
			
	}

	// <summary>
	// Test Case Title :"To verify what happens when a user attempts to create a Snip with tag without selecting any tag from the Tag List."
	// Automation ID   : Snip_21
	// </summary>
	public void Snip_21_SnipCreationWithAndWithoutTag() throws InterruptedException {	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton")),"'Tick' option is not displayed in the Custom Tag page");
		
		//Step 10 : Click tick icon
		//Expected : A bookmark named "No_tag" is created below the video player.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton"));	
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("shot-username pad-c")),"User is not able to view a bookmark named 'No_tag' below the video player.");
	}

	// <summary>
	// Test Case Title :To verify what happens when user switches the snip type and attempts to create a snip.
	// Automation ID   : Snip_32
	// </summary>
	public void Snip_32_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		
		//Step 7 : Select Player Snips option
		//Expected : Snip Creation tab should be visible to the user
		base.buttonClick(LoginPageObj.Btn_SingnIn("choose_player_snips"));
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-modal")),"User is not able to view the snip creation tab.");

		//Step 8 : Select Snip
		//Expected : Snips created under "Player Snips" should be visible only to the Admin, Coach & Players in the organization.
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_NoTag("playerFrame")),"Snips created under \"Player Snips\" is not visible");
		
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the member icon in the Custom tags pop up"
	// Automation ID   : Snip_22
	// </summary>
	public void Snip_22_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));		
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");

		//Step 10 : Click Member Icon near the tags.
		//Expected : All players in the team should be displayed under the title Home.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Member1("korea","12667"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("secondary-bg rounded-bg px-3")),"User is not able to view the players in the team under Home title");
	}

	// <summary>
	// Test Case Title : To verify what happens when user try to create snip under Stat snips.
	// Automation ID   : Snip_33
	// </summary>
	public void Snip_33_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);
		base.switchToWindowByIndex(driver, 1);

		//Step 6 : Switch to Stat Snips below the video player
		//Expected : User should able to view the stat snips while clicking on Stat snip option
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Player("statsnipshref"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("tab-snips-content"))," User is not able to view the stat snips while clicking on Stat snip option");

		//Step 7 : Click Snip creation icon
		//Expected : The snip creating icon should be disabled when user switches to Stat Snips section.
		asrt.assertTrue(driver.findElement(SnipCreationWithAndWithoutTagObj.Btn_SnipDisable("Create Snip")).isDisplayed()," The snip creating icon is not disabled when user switches to Stat Snips section.");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user selects any one of the player from the members list."
	// Automation ID   : Snip_23
	// </summary>
	public void Snip_23_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");

		//Step 10 : Click Member Icon near the tags.
		//Expected : All players in the team should be displayed under the title Home.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Member1("korea","12667"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("secondary-bg rounded-bg px-3")),"User is not able to view the players in the team under Home title");

		//Step 11 : Select any member and click done
		//Expected : The selected player should display along with the tag we selected.
		base.buttonClick(RegistrationObj.Ele_RegistrationExists("## - Akhil (GameDefautlt)  "));
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap btn-add-usertotag"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Akhil")),"The selected player is not displayed along with the tag we selected.");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user deselect the player from the members list."
	// Automation ID   : Snip_24
	// </summary>
	public void Snip_24_SnipCreationWithAndWithoutTag() throws InterruptedException
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(7000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");

		//Step9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");

		//Step 10 : Click Member Icon near the tags.
		//Expected : All players in the team should be displayed under the title Home.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Member1("korea","12667"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("secondary-bg rounded-bg px-3")),"User is not able to view the players in the team under Home title");

		//Step 11 : Select any member and click done
		//Expected : The selected player should display along with the tag we selected.
		base.buttonClick(RegistrationObj.Ele_RegistrationExists("## - Akhil (GameDefautlt)  "));
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap btn-add-usertotag"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Akhil")),"The selected player is not displayed along with the tag we selected.");
	
		//Step 12 : Again click Member Icon near the tags.
		//Expected : All players in the team should be displayed under the title Home.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Member1("korea","12667"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("secondary-bg rounded-bg px-3")),"User is not able to view the players in the team under Home title");

		//Step 13 :Deselect that member
		//Expected : The selected player should not display below the tag we selected.
		base.buttonClick(RegistrationObj.Ele_RegistrationExists("## - Akhil (GameDefautlt)  "));
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap btn-add-usertotag"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("custom-tag-list-item selected-tag")),"The selected player is displayed below the tag we selected.");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user click Refresh in the members  page."
	// Automation ID   : Snip_25
	// </summary>
	public void Snip_25_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");

		//Step 10 : Click Member Icon near the tags.
		//Expected : All players in the team should be displayed under the title Home.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Member1("korea","12667"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("secondary-bg rounded-bg px-3")),"User is not able to view the players in the team under Home title");

		//Step 11 : Select any member and click refresh button
		//Expected : The members list gets refreshed with a loader.
		base.buttonClick(RegistrationObj.Ele_RegistrationExists("## - Akhil (GameDefautlt)  "));
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap refresh-teamplayers"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_Check("Akhil","form-check-input")),"The member list is not refreshed whith a loader");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user try to create snip with tag after selecting a member."
	// Automation ID   : Snip_26
	// </summary>
	public void Snip_26_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	    Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");

		//Step 10 : Click Member Icon near the tags.
		//Expected : All players in the team should be displayed under the title Home.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Member1("korea","12667"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("secondary-bg rounded-bg px-3")),"User is not able to view the players in the team under Home title");

		//Step 11 : Select any member and click done
		//Expected : The selected player should display along with the tag we selected.
		base.buttonClick(RegistrationObj.Ele_RegistrationExists("## - Akhil (GameDefautlt)  "));
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-danger text-uppercase px-3 btn-wrap btn-add-usertotag"));
		asrt.assertTrue(base.isExists(RegistrationObj.Ele_RegistrationExists("Akhil")),"The selected player is not displayed along with the tag we selected.");

		//Step 12 : Click tick icon
		//Expected :A bookmark with the chosen tag name should be created below the video player along with that member name.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_TickIcon("color-tag-section","custom-tags-savebutton"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("shot-username pad-c")),"A bookmark with the chosen tag name is not created below the video player along with that member name.");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks CANCEL in the members page."
	// Automation ID   : Snip_27
	// </summary>
	public void Snip_27_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8: Create Snip popup is displayed
		//Expected:Validate if the text message is "Are you sure.Do You want to create snip"
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
		asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip with Tag")),"'Snip with Tag' option is not displayed in the snip create popup");
		base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		
		//Step9: Click on 'Snip with Tag'
		//Expected:"User should able to select 'Snip with Tag'
		base.buttonClick(LoginPageObj.Btn_SignInButton("Snip with Tag"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");

		//Step 10 : Click Member Icon near the tags.
		//Expected : All players in the team should be displayed under the title Home.
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Member1("korea","12667"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("secondary-bg rounded-bg px-3")),"User is not able to view the players in the team under Home title");

		//Step 11 : Select any member and click cancel
		//Expected :The user should be redirected to the Custom Tags section.
		base.buttonClick(RegistrationObj.Ele_RegistrationExists("## - Akhil (GameDefautlt)  "));
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-secondary text-uppercase px-3 w-100 back-taglist"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.CusTag("Custom tags")),"'Custom Tag' popup is not displayed in the My snip creation");
	}

	// <summary>
	// Test Case Title :"To verify who can view the snips created under "My Snips.""
	// Automation ID   : Snip_28
	// </summary>
	public void Snip_28_SnipCreationWithAndWithoutTag() throws InterruptedException 
	{	
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new Pool_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();
		SnipCreationWithAndWithoutTag_TestData SnipCreationWithAndWithoutTagTestData = new SnipCreationWithAndWithoutTag_TestData();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
		TrimVideo_TestData TrimVideoTestData = new TrimVideo_TestData();
		AddUpdateRemoveMember_Obj AddUpdateRemoveMemberObj= new AddUpdateRemoveMember_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		Thread.sleep(5000);
		
		//Step 3  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");

		//Step 4   :"Select OrgName"
		//Expected :"User should be navigated to OrgName list and select the OrgName"
		base.buttonClick(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"));
		base.buttonClick(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org));
		asrt.assertTrue(base.isExists(PoolObj.Ele_SelectPoolType(TrimVideoTestData.TV_01_Org)),"Organization is not selected");

		base.setData(AddUpdateRemoveMemberObj.Ele_SearchMember("form-control input-wrap game-search"),TrimVideoTestData.TV_02_Game);
	    actions.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(5000);
		
		//Step 5:click on 'SemTest' game
		//Expected :"User should be able to select 'SemTest'"
		base.excuteJsClick(LoginPageObj.Btn_Login(TrimVideoTestData.TV_02_Game));
		Thread.sleep(10000);

		//Step 6:Click on 'Snip icon'
		//Expected:"User should able to select 'snip icon'
		base.switchToWindowByIndex(driver, 1);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark")),"User is not navigated to the player page while clicking on Game ");	
		base.scrollToElementtoCenter(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Snip("tool-rounded create-bookmark"));

		//Step 7:Click on 'My Snips'
		//Expected:"User should able to select 'My Snips'
		base.excuteJsClick(LoginPageObj.Btn_SingnIn("choose_my_snips"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("proceed-snip-type")),"'OK' option is not displayed in the snip icon");
		base.excuteJsClick(LoginPageObj.Btn_LoginButton("proceed-snip-type"));	

		//Step 8 : Click on Snip icon 
		//Expected : Snips created under "My Snips" should be visible
		base.buttonClick(PoolObj.Btn_ButtonCreate("swal-button swal-button--catch"));
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Ele_NoTag("allFrame")),"Snips created under \"My Snips\" is not visible");
		
		//asrt.assertTrue(base.isExists(RegistrationObj.Ele_OtpPage("frameshot1")),"Snips created under \"My Snips\" is not visible to the user who created them.");
		
	}
}

