package testPage.MavenPageObject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.internal.annotations.IListeners;
import TestData.CommonData;
import TestData.CreateAddNewMember_TestData;
import TestData.SnipBackLogin_TestData;
import objectRepository.CreateAddNewMemeber_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import objectRepository.SnipBackLogin_Obj;
import objectRepository.SocialMediaSignIn_Obj;
import utilPack.BasePge;

public class CreateAddNewMember extends BasePge {

	BasePge base;
	Assert asrt;

	public CreateAddNewMember(WebDriver driver)
	{
		super(driver);
		base = new BasePge(driver);
	}

	//<summary>
	// Test Case Title : To verify whether there is a option to add user with email.
	// Automation ID   : WE_01
	// </summary>

	public void TC01_CreateAddNewMember() throws InterruptedException  
	{
		LoginPage_Obj loginObj = new LoginPage_Obj();
		SnipBackLogin_Obj snipbackloginObj=new SnipBackLogin_Obj();
		CreateAddNewMemeber_Obj CreateNewMemberObj=new CreateAddNewMemeber_Obj();
		CommonData Commondata=new CommonData();
		CreateAddNewMember_TestData CreateAddNewMemeberTestData=new CreateAddNewMember_TestData();
		Registration_Obj registrationObj=new Registration_Obj();
		Login login=new Login(driver); 

		//Step 1:Go to Snipback website
		// Expected:The Snipback home must load.
		asrt.assertTrue(base.isExists(loginObj.Ele_SnipBackHomePageLogo("light-logo")), "Unable to view Snipback Home Page");

		//Step 2:Click Login button
		//Expected:The Login popup must open with buttons for signin.
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(snipbackloginObj.Btn_Signin("SIGN IN")),"User is not able to view the SignIn button in the Popup");

		//Step 3:Enter User name & password and click on the button "SignIn".
		//Expected:The login must be successful and need to navigate to Page.
		base.setData(loginObj.Edt_LoginCredentialFields("email_address"), CommonData.UserName);
		base.setData(loginObj.Edt_LoginCredentialFields("password"), CommonData.PassWord);
		base.buttonClick(loginObj.Btn_SignInButton("SIGN IN"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("menu_link nav-link  active ")), "User login is unsuccessfull");

		//Step 4:Go to Games/Members page.
		//Expected:The Games page must be loaded.
		//	base.PerformActionOnAlert();	
		base.buttonClick(loginObj.Btn_LoginButton("menu_link nav-link  active "));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Tab_TabClick("nav-link  tab-team-type active")),"User not able to view the Games page");

		//Step 5: Switch to Any team after searching
		//Expected : The teams and their appropriate event must load fine.
		base.setData(CreateNewMemberObj.Edt_SearchBox("form-control input-wrap"),CreateAddNewMemeberTestData.TC01_CreateAddNewMemberTeamName );
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("CreateORAddUserName")), "Searched Team is not loading properly");

		//step 6: Click on the three Dots near the team name.
		//Expected: The option Edit Team must open.
		base.buttonClick(registrationObj.Btn_ResendOTP("defaultDropdown-41"));
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(CreateNewMemberObj.Ddl_Selection("team","Edit Team")), "The User is not able to see the Edit Team option");

		//step 7: Click on the option "Edit Team".
		//Expected: The Edit team grid must open and need the option to add user with email ID.
		base.buttonClick(CreateNewMemberObj.Ddl_Selection("team","Edit Team"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(loginObj.Edt_AlertMessage("Create & Add New Member With Email")), "User is not able to see the option Create & Add new member with Email");
	}
}
