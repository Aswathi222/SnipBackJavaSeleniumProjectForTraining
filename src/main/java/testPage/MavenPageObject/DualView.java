package testPage.MavenPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import TestData.CommonData;
import TestData.TrimVideo_TestData;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.DualView_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.SnipCreationWithAndWithoutTag_Obj;
import utilPack.BasePge;

public class DualView extends BasePge {

	BasePge base;
	Assert asrt; 
	Actions actions = new Actions(driver);
	public DualView (WebDriver driver) 
	{
		super(driver);
		base = new BasePge(driver);
	}
	
				// <summary>
				// Test Case Title :"To verify that the "Dual view" option is available on the player page"
				// Automation ID   : DV_1
				// </summary>
				public void DV_1_DualView() throws InterruptedException {	
				LoginPage_Obj LoginPageObj=new LoginPage_Obj();
				Login login = new Login(driver);
			    Pool_Obj PoolObj = new Pool_Obj();
			    SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
				DualView_Obj DualViewObj = new DualView_Obj();
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
				Thread.sleep(5000);	
				asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
				asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
				asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
				asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
				base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
				
				//Step 9: Click on 'Snip'
				//Expected:"User should able to select 'Snip'
				base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));				
				
				Thread.sleep(1000);
				asrt.assertTrue(base.isExists(DualViewObj.Ele_NoTag("allFrame")),"'NoTag Box' option is not displayed below video");
				base.scrollToElementtoCenter(DualViewObj.Ele_NoTag("allFrame"));
				
				//Step10: Verify and select a bookmark with Notagname is created below videoplayer
				//Expected:Verified and selected a bookmark with the Notag name is created below the video player.
				base.buttonClick(DualViewObj.Ele_NoTag("allFrame"));
				
				//Step11: Verify and check dualview option is available in player page for completed multiview game snip
				//Expected:Dual view option is available in player page for completed multiview game snip.
				Thread.sleep(1000);
				asrt.assertTrue(base.isExists(DualViewObj.Btn_DualView("dual_view_icon")),"Dual view option is not available in player page for completed multiview game snip");
				
				}
				
				// <summary>
				// Test Case Title :"To verify if user click on"Dual View" option then it redirects to  Dual View page "
				// Automation ID   : DV_2
				// </summary>
				public void DV_2_DualView() throws Exception {	
				LoginPage_Obj LoginPageObj=new LoginPage_Obj();
				Login login = new Login(driver);
				SnipCreationWithAndWithoutTag_Obj SnipCreationWithAndWithoutTagObj = new SnipCreationWithAndWithoutTag_Obj();
				DualView_Obj DualViewObj = new DualView_Obj();
				Pool_Obj PoolObj = new Pool_Obj();
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
				Thread.sleep(5000);	
				asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("swal-title")));
				asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-title")), "Are you sure?");
				asrt.assertEquals(GetText(LoginPageObj.Ele_ErrorMessage("swal-text")), "Do you want to create snip?","\"Do you want to create snip?\" text is not matching");
				asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Snip")),"'Snip' option is not displayed in the snip create popup");
				base.scrollToElementtoCenter(LoginPageObj.Btn_SignInButton("Snip"));
				
				//Step 9: Click on 'Snip'
				//Expected:"User should able to select 'Snip'
				base.buttonClick(LoginPageObj.Btn_SignInButton("Snip"));	
				Thread.sleep(1000);
				asrt.assertTrue(base.isExists(DualViewObj.Ele_NoTag("allFrame")),"'NoTag Box' option is not displayed below video");
				base.scrollToElementtoCenter(DualViewObj.Ele_NoTag("allFrame"));
				
				//Step 10: Verify and select a bookmark with Notagname is created below videoplayer
				//Expected:Verified and selected a bookmark with the Notag name is created below the video player.
				base.buttonClick(DualViewObj.Ele_NoTag("allFrame"));
				Thread.sleep(10000);
				asrt.assertTrue(base.isExists(DualViewObj.Btn_DualView("dual_view_icon")),"Dual view option is not available in player page for completed multiview game snip");
				base.scrollToElementtoCenter(DualViewObj.Btn_DualView("dual_view_icon"));
				
				//Step 11: Verify and check dualview option is available in player page for completed multiview game snip
				//Expected:Dual view option is available in player page for completed multiview game snip.
				base.buttonClick(DualViewObj.Btn_DualView("dual_view_icon"));
				
				//Step 12: Verify and check its redirected to the Dual View page 
				//Expected:redirected to the Dual View page .
				Thread.sleep(50000);
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='dual_view_iframe']")));		 
				Thread.sleep(1000);
				asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Side-by-Side View")),"Redirected to the Dual View page ");
				}
				
}
