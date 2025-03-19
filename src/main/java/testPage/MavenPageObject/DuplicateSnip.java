package testPage.MavenPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import TestData.AddEditInfo_TestData;
import TestData.CommonData;
import TestData.DuplicateSnip_TestData;
import TestData.SnipBackLogin_TestData;
import TestData.Tags_TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import TestData.CommonData;
import TestData.Tags_TestData;
import TestData.WhiteboardAndReels_TestData;
import objectRepository.AddEditInfo_Obj;
import objectRepository.AddFollower_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.DeleteSnipPlayer_Obj;
import objectRepository.DuplicateSnip_Obj;
import objectRepository.DuplicateTeam_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import objectRepository.Tags_Obj;
import objectRepository.ViewProfile_Obj;
import objectRepository.AddEditInfo_Obj;
import objectRepository.AddUpdateDeleteDuplicateTeamGameDefaults_Obj;
import objectRepository.ForgotPassword_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.Tags_Obj;
import objectRepository.ViewListUpdateDownloadShareDeleteLibrary_Obj;
import objectRepository.ViewProfile_Obj;
import utilPack.BasePge;

public class DuplicateSnip extends BasePge {

	BasePge base;
	Assert asrt; 

	public DuplicateSnip(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"To verify whether there is an option to duplicate snip in player page."
	// Automation ID   :Dup_01 
	// </summary>
	public void Dup_01_DuplicateSnip() throws InterruptedException
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Pool_Obj PoolObj=new Pool_Obj();
		DuplicateSnip_Obj DuplicateSnipObj=new DuplicateSnip_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj=new SnipCreationWithAndWithoutTag_Obj();
		DuplicateSnip_TestData DuplicateSnipTestData =new DuplicateSnip_TestData();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj=new DeleteSnipPlayer_Obj();

		//Step 1  :"Login to snipback "
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		//Thread.sleep(2000);

		//Step 2  :"Navigate to Org"
		//Expected:"User should able to navigate to Org"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DuplicateSnipTestData.Dup_01_DuplicateSnipOrg);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole(DuplicateSnipTestData.Dup_01_DuplicateSnipOrg)), "User is not able to Choose  organization (User as Admin/Coach)");
		//Thread.sleep(2000);

		//Step 2  :"Navigate to Team"
		//Expected:"User should able to navigate to Team"
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), DuplicateSnipTestData.Dup_01_DuplicateSnipTeamName);	
		base.buttonClick(LoginPageObj.Edt_Alert1(DuplicateSnipTestData.Dup_01_DuplicateSnipTeamName));

		//Step 3  :"Play any snip"
		//Expected:"User should able to Play any snip"
		base.buttonClick(DuplicateSnipObj.Ele_SelectGame("text-decoration-none text-reset",DuplicateSnipTestData.Dup_01_DuplicateSnipGameName));
		base.switchToWindowByIndex(driver, 1);
		Thread.sleep(2000);
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));

		//Step 4  :"Click on three dots at the right side of the video player"
		//Expected:"There should be an option to duplicate snip in player page."
		base.setZoom(driver, 40);	
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("more-button-icon"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Player("duplicate-snip")), "There is no  option to duplicate snip in player page");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks the duplicate icon."
	// Automation ID   :Dup_02
	// </summary>
	public void Dup_02_DuplicateSnip() throws InterruptedException
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Pool_Obj PoolObj=new Pool_Obj();
		DuplicateSnip_Obj DuplicateSnipObj=new DuplicateSnip_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj=new SnipCreationWithAndWithoutTag_Obj();
		DuplicateSnip_TestData DuplicateSnipTestData =new DuplicateSnip_TestData();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj=new DeleteSnipPlayer_Obj();

		//Step 1  :"Login to snipback "
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		//Thread.sleep(2000);

		//Step 2  :"Navigate to Org"
		//Expected:"User should able to navigate to Org"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DuplicateSnipTestData.Dup_01_DuplicateSnipOrg);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole(DuplicateSnipTestData.Dup_02_DuplicateSnipOrg)), "User is not able to Choose  organization (User as Admin/Coach)");
		//Thread.sleep(2000);

		//Step 2  :"Navigate to Team"
		//Expected:"User should able to navigate to Team"
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), DuplicateSnipTestData.Dup_02_DuplicateSnipTeamName);	
		base.buttonClick(LoginPageObj.Edt_Alert1(DuplicateSnipTestData.Dup_02_DuplicateSnipTeamName));

		//Step 3  :"Play any snip"
		//Expected:"User should able to Play any snip"
		Thread.sleep(3000);
		base.buttonClick(DuplicateSnipObj.Ele_SelectGame("text-decoration-none text-reset",DuplicateSnipTestData.Dup_01_DuplicateSnipGameName));
		base.switchToWindowByIndex(driver, 1);
		//Thread.sleep(2000);
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));

		//Step 4  :"Click on three dots at the right side of the video player"
		//Expected:"There should be an option to duplicate snip in player page."
		base.setZoom(driver, 40);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("more-button-icon"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Player("duplicate-snip")), "There is no  option to duplicate snip in player page");

		//Step 5  :"5. Click Duplicate Snip icon"
		//Expected:"An confirmation popup will display as "Are you sure want to duplicate this snip"
		//Thread.sleep(2000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Player("duplicate-snip"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Are you sure want to duplicate this snip")), "An confirmation popup is not displayed as Are you sure want to duplicate this snip");	
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks Yes in the confirmation pop up."
	// Automation ID   :Dup_03
	// </summary>
	public void Dup_03_DuplicateSnip() throws InterruptedException
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Pool_Obj PoolObj=new Pool_Obj();
		DuplicateSnip_Obj DuplicateSnipObj=new DuplicateSnip_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj=new SnipCreationWithAndWithoutTag_Obj();
		DuplicateSnip_TestData DuplicateSnipTestData =new DuplicateSnip_TestData();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj=new DeleteSnipPlayer_Obj();

		//Step 1  :"Login to snipback "
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		//Thread.sleep(2000);

		//Step 2  :"Navigate to Org"
		//Expected:"User should able to navigate to Org"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DuplicateSnipTestData.Dup_01_DuplicateSnipOrg);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole(DuplicateSnipTestData.Dup_01_DuplicateSnipOrg)), "User is not able to Choose  organization (User as Admin/Coach)");
		//Thread.sleep(2000);

		//Step 2  :"Navigate to Team"
		//Expected:"User should able to navigate to Team"
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), DuplicateSnipTestData.Dup_03_DuplicateSnipTeamName);	
		base.buttonClick(LoginPageObj.Edt_Alert1(DuplicateSnipTestData.Dup_03_DuplicateSnipTeamName));

		//Step 3  :"Play any snip"
		//Expected:"User should able to Play any snip"
		Thread.sleep(3000);
		base.buttonClick(DuplicateSnipObj.Ele_SelectGame("text-decoration-none text-reset",DuplicateSnipTestData.Dup_03_DuplicateSnipGameName));
		base.switchToWindowByIndex(driver, 1);		
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));

		//Step 4  :"Click on three dots at the right side of the video player"
		//Expected:"There should be an option to duplicate snip in player page."
		base.setZoom(driver, 40);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("more-button-icon"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Player("duplicate-snip")), "There is no  option to duplicate snip in player page");

		//Step 5  :"Click Duplicate Snip icon"
		//Expected:"An confirmation popup will display as "Are you sure want to duplicate this snip"
		//Thread.sleep(2000);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Player("duplicate-snip"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Are you sure want to duplicate this snip")), "An confirmation popup will not display as Are you sure want to duplicate this snip");

		//Step 6  :" Click Yes"
		//Expected:"A duplicate of the selected snip will appear below the video player."
		Thread.sleep(1000);
		base.excuteJsClick(LoginPageObj.Btn_SignInButton("Yes"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("The snip has been duplicated.")), "User is not able to view the duplicate of the selected snip below the video player");
	}

	// <summary>
	// Test Case Title :"To verify what happens when user clicks Cancel in the confirmation pop up."
	// Automation ID   :Dup_04
	// </summary>
	public void Dup_04_DuplicateSnip() throws InterruptedException
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Pool_Obj PoolObj=new Pool_Obj();
		DuplicateSnip_Obj DuplicateSnipObj=new DuplicateSnip_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj=new SnipCreationWithAndWithoutTag_Obj();
		DuplicateSnip_TestData DuplicateSnipTestData =new DuplicateSnip_TestData();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj=new DeleteSnipPlayer_Obj();

		//Step 1  :"Login to snipback "
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		//Thread.sleep(2000);

		//Step 2  :"Navigate to Org"
		//Expected:"User should able to navigate to Org"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DuplicateSnipTestData.Dup_01_DuplicateSnipOrg);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole(DuplicateSnipTestData.Dup_01_DuplicateSnipOrg)), "User is not able to Choose  organization (User as Admin/Coach)");
		//Thread.sleep(2000);

		//Step 2  :"Navigate to Team"
		//Expected:"User should able to navigate to Team"
		Thread.sleep(2000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), DuplicateSnipTestData.Dup_04_DuplicateSnipTeamName);	
		base.buttonClick(LoginPageObj.Edt_Alert1(DuplicateSnipTestData.Dup_04_DuplicateSnipTeamName));

		//Step 3  :"Play any snip"
		//Expected:"User should able to Play any snip"
		Thread.sleep(3000);
		base.buttonClick(DuplicateSnipObj.Ele_SelectGame("text-decoration-none text-reset",DuplicateSnipTestData.Dup_04_DuplicateSnipGameName));
		base.switchToWindowByIndex(driver, 1);
		//Thread.sleep(2000);
		base.excuteJsClick(DeleteSnipPlayerObj.Btn_MySnipsSelect("allFrame"));

		//Step 4  :"Click on three dots at the right side of the video player"
		//Expected:"There should be an option to duplicate snip in player page."
		base.setZoom(driver, 40);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("more-button-icon"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(SnipCreationWithAndWithoutTagObj.Btn_Player("duplicate-snip")), "There is no  option to duplicate snip in player page");

		//Step 6  :" Click Cancel"
		//Expected:"The confirmation popup closes when user clicks Cancel option"
		//Thread.sleep(2000);
		base.buttonClick(SnipCreationWithAndWithoutTagObj.Btn_Player("duplicate-snip"));
		base.buttonClick(DuplicateSnipObj.Btn_Cancel("swal-modal", "swal-button-container", 2));
		Thread.sleep(1000);	
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		boolean isInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(DuplicateSnipObj.Btn_Cancel("swal-modal", "swal-button-container", 2)));
		asrt.assertTrue(isInvisible, "The dialog box with the 'Cancel' button did not disappear as expected.");
	}

	// <summary>
	// Test Case Title :"To verify whether the duplicate snip option is not available for games without any snips."
	// Automation ID   :Dup_05
	// </summary>
	public void Dup_05_DuplicateSnip() throws InterruptedException
	{
		Login login = new Login(driver);
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		CommonData commonData = new CommonData();
		Pool_Obj PoolObj=new Pool_Obj();
		DuplicateSnip_Obj DuplicateSnipObj=new DuplicateSnip_Obj();
		AddFollower_Obj AddFollowerObj=new AddFollower_Obj();
		SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj=new SnipCreationWithAndWithoutTag_Obj();
		DuplicateSnip_TestData DuplicateSnipTestData =new DuplicateSnip_TestData();
		DeleteSnipPlayer_Obj DeleteSnipPlayerObj=new DeleteSnipPlayer_Obj();

		//Step 1  :"Login to snipback "
		//Expected:"User should able to navigate to the Film page once login with credentials"
		login.loginToApplication(commonData.UserName, commonData.PassWord);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("container film-container")),"User not able to navigate Film page in Snipback");
		//Thread.sleep(2000);

		//Step 2  :"Navigate to Org"
		//Expected:"User should able to navigate to Org"
		base.selectorByVisibleText(PoolObj.Ddl_TeamDropdwn("form-select select-form film-organizations"), DuplicateSnipTestData.Dup_01_DuplicateSnipOrg);
		asrt.assertTrue(base.isExists(AddFollowerObj.Ele_SelectRole(DuplicateSnipTestData.Dup_05_DuplicateSnipOrg)), "User is not able to Choose  organization (User as Admin/Coach)");
		//Thread.sleep(2000);

		//Step 2  :"Navigate to Team"
		//Expected:"User should able to navigate to Team"
		Thread.sleep(3000);
		base.buttonClick(LoginPageObj.Edt_LoginEmail("searchTeam"));
		base.setData(LoginPageObj.Edt_LoginEmail("searchTeam"), DuplicateSnipTestData.Dup_01_DuplicateSnipTeamName);	
		base.buttonClick(LoginPageObj.Edt_Alert1(DuplicateSnipTestData.Dup_05_DuplicateSnipTeamName));

		//Step 3  :"Play any snip"
		//Expected:"User should able to Play any snip"
		base.buttonClick(DuplicateSnipObj.Ele_SelectGame("text-decoration-none text-reset",DuplicateSnipTestData.Dup_05_DuplicateSnipGameName));
		base.switchToWindowByIndex(driver, 1);

		//Step 4  :"Click on three dots at the right side of the video player"
		//Expected:"To verify whether the duplicate snip option is not available for games without any snips."
		base.setZoom(driver, 40);
		base.excuteJsClick(SnipCreationWithAndWithoutTagObj.Btn_Pencil("more-button-icon"));
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		boolean isInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(SnipCreationWithAndWithoutTagObj.Btn_Player("duplicate-snip")));
		asrt.assertTrue(isInvisible, "The Duplicate Snip option is available for games without any snips.");
	}	
}




