package testPage.MavenPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import TestData.AddEditInfo_TestData;
import TestData.CommonData;
import TestData.CreateAddNewMemberWithEmail_TestData;
import TestData.SnipBackLogin_TestData;
import TestData.TeamInviteLink_TestData;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ScheduleUnscheduleGames_Obj;
import objectRepository.SearchGameTeamAndMembers_Obj;
import objectRepository.SnipCollections_Obj;
import objectRepository.TeamInviteLink_Obj;
import objectRepository.ViewProfile_Obj;
import objectRepository.AddEditInfo_Obj;
import objectRepository.AddUpdateRemoveMember_Obj;
import objectRepository.CreateAddNewMemberWithEmail_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;

public class SnipCollections extends BasePge {

	BasePge base;
	Assert asrt; 

	public SnipCollections (WebDriver driver) 
	{
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :"Verify that a Message will come when user given a  Duplicate Snip Collection name "
	// Automation ID   : Snip Coll_14
	// </summary>
	public void SnipColl_14_SnipCollections() throws InterruptedException 
	{	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegObj = new Registration_Obj();
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User is not able to navigated to Snip Collections Page");
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		
		//Step 4:"Click "+" icon"
		//Expected : User should be able to click on '+' icon
		asrt.assertTrue(base.isExists(RegObj.Edt_SignUpPopupPassword("btnAddTagList")),"User is not able to click on + icon");
		base.buttonClick(RegObj.Edt_SignUpPopupPassword("btnAddTagList"));
		
		//Step 5:"Duplicate Snip Collection name"
		//Expected : User should view the name entering field and should enter the name
		base.setData(LoginPageObj.Edt_LoginEmail("customTagName"), "AAA");
		
		//Step 6: "Click on Save Button"
		//Expected : "The Snip Collection Name field is required" msg should be displayed
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("btnAddTag")),"User is not able to view the save button");
		base.buttonClick(LoginPageObj.Btn_SingnIn("btnAddTag"));
		asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Snip Collection Already Exists.")),"Snip Collection Already Exists.pop up not showing");		
	}
  
	// <summary>
	// Test Case Title :"Verify that the Choose Color Tag box will displayed when user click the color tag icon"
	// Automation ID   : Snip Coll_15
	// </summary>
	public void SnipColl_15_SnipCollections() throws InterruptedException 
	{	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegObj = new Registration_Obj();
		ViewProfile_Obj ViewProfileObj = new ViewProfile_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User is not able to navigated to Snip Collections Page");
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		
		//Step 4:"Click "+" icon"
		//Expected : User should be able to click on '+' icon
		asrt.assertTrue(base.isExists(RegObj.Edt_SignUpPopupPassword("btnAddTagList")),"User is not able to click on + icon");
		base.buttonClick(RegObj.Edt_SignUpPopupPassword("btnAddTagList"));
		
		//Step 5:"Click color tag"
		//Expected : Verify that the Choose Color Tag box should displayed
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("btnColorPicker")),"User is not able to view the Color Tag");
		base.buttonClick(LoginPageObj.Btn_SingnIn("btnColorPicker"));
		asrt.assertTrue(base.isExists(ViewProfileObj.Ele_ResetPassHeading("CHOOSE TAG COLOR")),"Choose Color Tag Box is not displaying");
	}
		
	// <summary>
	// Test Case Title :"Verify that the User can save the Snip collection name with selected color"
	// Automation ID   : Snip Coll_16
	// </summary>
	public void SnipColl_16_SnipCollections() throws InterruptedException 
	{	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegObj = new Registration_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User is not able to navigated to Snip Collections Page");
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		
		//Step 4:"Click "+" icon"
		//Expected : User should be able to click on '+' icon
		asrt.assertTrue(base.isExists(RegObj.Edt_SignUpPopupPassword("btnAddTagList")),"User is not able  to click on + icon");
		base.buttonClick(RegObj.Edt_SignUpPopupPassword("btnAddTagList"));
		
		//Step 5:"Enter Snip collection name"
		//Expected : User should view the name entering field and should enter the name
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("customTagName")),"User is not able to enter Snipcollection name");
		base.setData(LoginPageObj.Edt_LoginEmail("customTagName"), "BBB");
		
		//Step 5:"Click color tag"
		//Expected : Verify that the Choose Color Tag box should displayed
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("btnColorPicker")),"User is not able to view the Color Tag");
		base.buttonClick(LoginPageObj.Btn_SingnIn("btnColorPicker"));
		
		//Step 7:"Point select color"
		//Expected : User should be able to select the color and slidebar
		base.selectColor(205, 110);
		Thread.sleep(1000);
		base.adjustBrightness(100);
		Thread.sleep(1000);
		
		//Step 8:"Click 'Save changes' Button"
		//Expected : User should be able to view and click on the save changes button
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("colorChangeCloseBtn")),"User is not able to view the 'save changes' button");
		base.buttonClick(LoginPageObj.Btn_SingnIn("colorChangeCloseBtn"));
		
		//Step 9:" Click on 'Save Icon'
		//Expected : The saved Snip collection name should be display with the user selected color
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("btnAddTag")),"User is not able to click on Save Icon");
		base.buttonClick(LoginPageObj.Btn_SingnIn("btnAddTag"));
		Thread.sleep(1000);
	}
				
	// <summary>
	// Test Case Title :"Verify that user can change the color of the already saved Snip collections"
	// Automation ID   : Snip Coll_17
	// </summary>
	public void SnipColl_17_SnipCollections() throws InterruptedException 
	{	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User should not be navigated to Snip Collections Page");
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		
		//Step 4	:"Select color icon, right side of which snip collection name"
		//Expected :  User should be able to click the color icon for already saved snip collection name
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("colorPickerBtn")),"User should not be navigated to Color Tag");
		base.buttonClick(LoginPageObj.Btn_SingnIn("colorPickerBtn"));
		
		//Step 5:"Select Color"
		//Expected : User should be able to select the color and slidebar
		base.selectColor(205, 110);
		Thread.sleep(1000);
		base.adjustBrightness(100);
		Thread.sleep(1000);
		
		//Step 6:"Click 'Save changes' Button"
		//Expected : The color of the snip collection name should be changed
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("colorChangeCloseBtn")),"User is not able to click on 'Save changes' button");
		base.buttonClick(LoginPageObj.Btn_SingnIn("colorChangeCloseBtn"));
	}
				
	// <summary>
	// Test Case Title :"Verify that the Choose Color Tag box will closed when user click the close Button on the Choose Color Tag box"
	// Automation ID   : Snip Coll_18
	// </summary>
	public void SnipColl_18_SnipCollections() throws InterruptedException 
	{	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Pool_Obj PoolObj = new Pool_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User should not be navigated to Snip Collections Page");
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		
		//Step 4	:"Select color icon, right side of which snip collection name"
		//Expected :  User should be able to click the color icon for already saved snip collection name
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("colorPickerBtn")),"User should not be navigated to Color Tag");
		base.buttonClick(LoginPageObj.Btn_SingnIn("colorPickerBtn"));
		
		//Step 5	:"Click close button"
		//Expected : Choose Color Tag box should closed when user click the close Button
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(PoolObj.Btn_ButtonCreate("btn btn-secondary me-3")),"User should not be navigated to 'Close' button");
		base.buttonClick(PoolObj.Btn_ButtonCreate("btn btn-secondary me-3"));	
	}
				
	// <summary>
	// Test Case Title :"Verify that user can Edit the saved Snip collection Name"
	// Automation ID   : Snip Coll_19
	// </summary>
	public void SnipColl_19_SnipCollections() throws InterruptedException 
	{	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User is not able to navigated to Snip Collections Page");
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		
		//Step 4	:"Click 3 dots, right side of snip collection name"
		//Expected : User should be able to view and click on the 3 dots
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("dropdownMenuButton")),"User is not able to click on Snip Collections Three Dot Icon");
		base.buttonClick(LoginPageObj.Btn_SingnIn("dropdownMenuButton"));
		
		//Step 5	:"Click Edit Option"
		//Expected : User should be able the edit the name
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Edit")),"User is not able to view the Edit option in Three dot icon");
		base.buttonClick(LoginPageObj.Btn_Login("Edit"));
		
		//Step 6:"Enter a SnipCollection Name"
		//Expected : User should enter a name
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("customTagValue")),"User is not able to view the 'Snip collection name' field");
		base.setData(LoginPageObj.Edt_LoginEmail("customTagValue"), "AAAA");
		
		//Step 7	:"Click Update Option"
		//Expected : The updated name should be displayed 
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("customTagEdit")),"User is not able to view the 'update' button");
		base.buttonClick(LoginPageObj.Btn_SingnIn("customTagEdit"));
	}
				
	// <summary>
	// Test Case Title :"Verify that the user can delete the saved Snip collections"
	// Automation ID   : Snip Coll_20
	// </summary>
	public void SnipColl_20_SnipCollections() throws InterruptedException 
	{	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		SearchGameTeamAndMembers_Obj SearchGameTeamAndMembersObj = new SearchGameTeamAndMembers_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User is not able to navigated to Snip Collections Page");
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		
		//Step 4	:"Click 3 dots, right side of snip collection name"
		//Expected : User should be able to view and click on the 3 dots
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("dropdownMenuButton")),"User is not able to view the Snip Collections Three Dot Option");
		base.buttonClick(LoginPageObj.Btn_SingnIn("dropdownMenuButton"));
		
		//Step 5	:"Click Delete Option"
		//Expected : User should be able to view and click on the delete option
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Delete")),"User is not able  to view the 'Delete' button");
		base.buttonClick(LoginPageObj.Btn_Login("Delete"));
		
		//Step 6	:"Click Yes Option"
		//Expected : The Saved Snip collections should be deleted
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SignInButton("Yes")),"User is not able to click on 'Yes' button");
		base.buttonClick(LoginPageObj.Btn_SignInButton("Yes"));
		//asrt.assertTrue(base.isExists(SearchGameTeamAndMembersObj.Ele_MemberName("Record Deleted Successfully")), "The user is not able to delete the saved snip collections");
	}
				
	// <summary>
	// Test Case Title :"Verify that the Edit, Delete dialogue box gets closed when user click the Dismiss option"
	// Automation ID   : Snip Coll_21
	// </summary>
	public void SnipColl_21_SnipCollections() throws InterruptedException 
	{	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User is not able to navigated to Snip Collections Page");
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		
		//Step 4	:"Click 3 dots, right side of snip collection name"
		//Expected : User should be able to view and click on the 3 dots
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("dropdownMenuButton")),"User is not able to view the Snip Collections Three Dot Option");
		base.buttonClick(LoginPageObj.Btn_SingnIn("dropdownMenuButton"));
		
		//Step 5	:"Click Dismiss Option"
		//Expected : The Edit, Delete dialogue box should closed
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Dismiss")),"User is not able to view the Dismiss Option");
		base.buttonClick(LoginPageObj.Btn_Login("Dismiss"));	
	}
				
	// <summary>
	// Test Case Title :"Verify that the user should be able to navigates to the  Snipback website after entering the URL"
	// Automation ID   : Snip Coll_1
	// </summary>
	public void SnipColl_1_SnipCollections() throws InterruptedException 
	{	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();
		
		Thread.sleep(2000);
		//Step 1   :"Enter Snip back URL"
		//Expected :"Validate snipback logo is displayed"
		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_SearchField("logo logo1")),"Snipback logo is not displayed in login page");
		
		
		//Step 2   :"Verify login is displayed"
		//Expected :"The user should be able to navigates to the  Snipback website after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigates to the  Snipback website after entering the URL");
    }
					
	// <summary>
	// Test Case Title :"Verify that the user should be able to navigates Home page after entering user name & Correct Password"
	// Automation ID   : Snip Coll_2
	// </summary>
	public void SnipColl_2_SnipCollections() throws InterruptedException 
	{	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
	    SnipCollections_Obj SnipCollectionsObj =new SnipCollections_Obj();
		
        //Step 1   :"Enter Snip back URL"
		//Expected :"User should able to view the SnipBack page"
	    Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Enter Username & PW"
		//Expected :"User should able to enter username & password and click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Verify home title is shown in home page"
		//Expected :"The user should be able to navigates to the Homepage after entering Username & PW"
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(SnipCollectionsObj.Ele_HomePage("nav-item","Home")),"The user is not able to navigates to the Homepage after entering Username & PW");
	}
				
	// <summary>
	// Test Case Title :"User should verify that the Snip Collections tab should be on the top side"
	// Automation ID   : Snip Coll_3
	// </summary>
	public void SnipColl_3_SnipCollections() throws InterruptedException 
	{	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);

        //Step 1   :"Enter Snip back UR"
		//Expected :"User should able to view the SnipBack page"
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
	
        //Step 3   :"Snip Collection tab"
		//Expected : " Snip Collections tab should be on the top side"
		Thread.sleep(3000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"Snip Collections tab is not shown in home page");
		asrt.assertEquals(base.GetText(LoginPageObj.Btn_Login("Snip Collections")), "Snip Collections","Snip Collections text is wrong");
	}
				
	// <summary>
	// Test Case Title :"Verify that the user should able to navigate to Snip collection page when click on Snip collection tab"
	// Automation ID   : Snip Coll_4
	// </summary>
    public void SnipColl_4_SnipCollections() throws InterruptedException 
    {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new Registration_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User unable to view to Snip Collections Home Page");	
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")),"User unable to navigate to Snip collection page");
    }
			   
    // <summary>
	// Test Case Title :"Verify that a HOME COLLECTIONS tab is displayed on Snipcollection page"
	// Automation ID   : Snip Coll_5
	// </summary>
    public void SnipColl_5_SnipCollections() throws InterruptedException 
    {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddnewMemeberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User unable to view to Snip Collections Home Page");	
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")),"User unable to navigate to Snip collection page");
	   
		//Step 4   :"Verify that a HOME COLLECTIONS  tab is displayed"
		//Expected :"User should see the HOME COLLECTIONS tab on Snip collection page"
		asrt.assertEquals(base.GetText(CreateAddnewMemeberWithEmailObj.Ele_EditTeam("2816")),"HOME COLLECTIONS","User unable to view HOME COLLECTIONS  tab ");	
    }
    
    // <summary>
	// Test Case Title :"Verify that  a "+"  icon is displayed on the left side of the HOME COLLECTIONS Tab"
	// Automation ID   : Snip Coll_6
	// </summary>
    public void SnipColl_6_SnipCollections() throws InterruptedException 
    {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddnewMemeberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User unable to view to Snip Collections Home Page");	
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")),"User unable to navigate to Snip collection page");
	   
		//Step 4   :"Verify that a HOME COLLECTIONS  tab is displayed"
		//Expected :"User should see the HOME COLLECTIONS tab on Snip collection page"	
		asrt.assertEquals(base.GetText(CreateAddnewMemeberWithEmailObj.Ele_EditTeam("2816")),"HOME COLLECTIONS","User unable to view HOME COLLECTIONS  tab ");	

		//Step 5   :"Verify that  a "+"  icon is displayed on the left side of the HOME COLLECTIONS Tab"
		//Expected :"User should see a "+" button icon on the left side of the HOME COLLECTIONS Tab"	
		asrt.assertTrue(driver.findElement(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")).isDisplayed(),"User unable to view '+' button icon on the left side of the HOME COLLECTIONS Tab");
	}
    
    // <summary>
	// Test Case Title :"Verify that "Enter Snip collection name" text field is displayed when user click the "+" icon"
	// Automation ID   : Snip Coll_7
	// </summary>
    public void SnipColl_7_SnipCollections() throws InterruptedException 
    {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddnewMemeberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User unable to view to Snip Collections Home Page");	
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")),"User unable to navigate to Snip collection page");
	   
		//Step 4   :"Verify that a HOME COLLECTIONS  tab is displayed"
		//Expected :"User should see the HOME COLLECTIONS tab on Snip collection page"
		asrt.assertEquals(base.GetText(CreateAddnewMemeberWithEmailObj.Ele_EditTeam("2816")),"HOME COLLECTIONS","User unable to view HOME COLLECTIONS  tab ");	
		
		//Step 5   :"Verify that  a "+"  icon is displayed on the left side of the HOME COLLECTIONS Tab"
		//Expected :"User should see a "+" buttonicon on the left side of the HOME COLLECTIONS Tab"	
		asrt.assertTrue(driver.findElement(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")).isDisplayed(),"User unable to view "+" icon");
	    
		//Step 6   :"Verify that "Enter Snip collection name" text field is displayed when user click the "+" icon"
		//Expected :"Enter Snip collection name" text field should dipslayed"	
		base.buttonClick(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList"));
		String Expected5="Enter Snip Collection Name";
		asrt.assertEquals(base.GetAttribte(LoginPageObj.Edt_LoginEmail("customTagName"),"placeholder"),Expected5,"User unable to view 'Enter Snip collection name' text field");
    }
				    
    // <summary>
	// Test Case Title :"Verify that the colour option, Save and close symbols will be displayed along with the snip name text field, when user click the "+" icon"
	// Automation ID   : Snip Coll_8
	// </summary>
    public void SnipColl_8_SnipCollections() throws InterruptedException 
    {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddnewMemeberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User unable to view to Snip Collections Home Page");	
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")),"User unable to navigate to Snip collection page");
	   
		//Step 4   :"Verify that a HOME COLLECTIONS  tab is displayed"
		//Expected :"User should see the HOME COLLECTIONS tab on Snip collection page"
		asrt.assertEquals(base.GetText(CreateAddnewMemeberWithEmailObj.Ele_EditTeam("2816")),"HOME COLLECTIONS","User unable to view HOME COLLECTIONS  tab ");	
		
		//Step 5   :"Verify that  a "+"  icon is displayed on the left side of the HOME COLLECTIONS Tab"
		//Expected :"User should see a "+" buttonicon on the left side of the HOME COLLECTIONS Tab"	
		asrt.assertTrue(driver.findElement(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")).isDisplayed(),"User unable to view "+" icon");
	    
		//Step 6   :"Verify that "Enter Snip collection name" text field is displayed when user click the "+" icon"
		//Expected :"Enter Snip collection name" text field should dipslayed"	
		base.buttonClick(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList"));
		String Expected5="Enter Snip Collection Name";
		asrt.assertEquals(base.GetAttribte(LoginPageObj.Edt_LoginEmail("customTagName"),"placeholder"),Expected5,"User unable to view 'Enter Snip collection name' text field");
	    
		//Step 7   :"Verify that the colour option, Save and close symbols will be displayed along with the snip name text field,"
		//Expected :"Colour option, Save and close symbols should be displayed"	
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("btnColorPicker")).isDisplayed(),"User unable to view 'Colour' option");
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("btnAddTag")).isDisplayed(),"User unable to view 'Save' Symbol");
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("cancelTagField")).isDisplayed(),"User unable to view 'Close' Symbol");
    }
				    
    // <summary>
	// Test Case Title :"Verify that the Snip collection name must be atleast 2 characters"
	// Automation ID   : Snip Coll_9
	// </summary>
    public void SnipColl_9_SnipCollections() throws InterruptedException 
    {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddnewMemeberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User unable to view to Snip Collections Home Page");	
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")),"User unable to navigate to Snip collection page");
	   
		//Step 4   :"Verify that a HOME COLLECTIONS  tab is displayed"
		//Expected :"User should see the HOME COLLECTIONS tab on Snip collection page"
		asrt.assertEquals(base.GetText(CreateAddnewMemeberWithEmailObj.Ele_EditTeam("2816")),"HOME COLLECTIONS","User unable to view HOME COLLECTIONS  tab ");	
		
		//Step 5   :"Verify that  a "+"  icon is displayed on the left side of the HOME COLLECTIONS Tab"
		//Expected :"User should see a "+" buttonicon on the left side of the HOME COLLECTIONS Tab"	
		asrt.assertTrue(driver.findElement(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")).isDisplayed(),"User unable to view "+" icon");
	    
		//Step 6   :"Verify that "Enter Snip collection name" text field is displayed when user click the "+" icon"
		//Expected :"Enter Snip collection name" text field should dipslayed"	
		base.buttonClick(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList"));
		String Expected5="Enter Snip Collection Name";
		asrt.assertEquals(base.GetAttribte(LoginPageObj.Edt_LoginEmail("customTagName"),"placeholder"),Expected5,"User unable to view 'Enter Snip collection name' text field");
	    
		//Step 7   :"Verify that the colour option, Save and close symbols will be displayed along with the snip name text field,"
		//Expected :"Colour option, Save and close symbols should be displayed"	
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("btnColorPicker")).isDisplayed(),"User unable to view 'Colour' option");
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("btnAddTag")).isDisplayed(),"User unable to view 'Save' Symbol");
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("cancelTagField")).isDisplayed(),"User unable to view 'Close' Symbol");
		
		//Step 8   :"Verify that the Snip collection name must be atleast 2 characters"
		//Expected :"Snip collection name should be atleast 2 characters"	
		base.setData(LoginPageObj.Edt_LoginEmail("customTagName"), base.CreateRandomWithoutNumbers(2)); 
		String inputField= base.GetValue(LoginPageObj.Edt_LoginEmail("customTagName"));
		asrt.assertTrue(inputField.length() >= 2, "Snip collection name is less than 2 characters, Invalid Name Found");
    }

    // <summary>
	// Test Case Title :"Verify that a message will come when the given Snip collection name is one character"
	// Automation ID   : Snip Coll_10
	// </summary>
    public void SnipColl_10_SnipCollections() throws InterruptedException 
    {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddnewMemeberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		SnipCollections_Obj SnipCollectionsObj= new SnipCollections_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User unable to view to Snip Collections Home Page");	
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")),"User unable to navigate to Snip collection page");
	   
		//Step 4   :"Verify that a HOME COLLECTIONS  tab is displayed"
		//Expected :"User should see the HOME COLLECTIONS tab on Snip collection page"
		asrt.assertEquals(base.GetText(CreateAddnewMemeberWithEmailObj.Ele_EditTeam("2816")),"HOME COLLECTIONS","User unable to view HOME COLLECTIONS  tab ");	
		
		//Step 5   :"Verify that  a "+"  icon is displayed on the left side of the HOME COLLECTIONS Tab"
		//Expected :"User should see a "+" buttonicon on the left side of the HOME COLLECTIONS Tab"	
		asrt.assertTrue(driver.findElement(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")).isDisplayed(),"User unable to view "+" icon");
	    
		//Step 6   :"Verify that "Enter Snip collection name" text field is displayed when user click the "+" icon"
		//Expected :"Enter Snip collection name" text field should dipslayed"	
		base.buttonClick(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList"));
		String Expected5="Enter Snip Collection Name";
		asrt.assertEquals(base.GetAttribte(LoginPageObj.Edt_LoginEmail("customTagName"),"placeholder"),Expected5,"User unable to view 'Enter Snip collection name' text field");
	    
		//Step 7   :"Verify that the colour option, Save and close symbols will be displayed along with the snip name text field,"
		//Expected :"Colour option, Save and close symbols should be displayed"	
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("btnColorPicker")).isDisplayed(),"User unable to view 'Colour' option");
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("btnAddTag")).isDisplayed(),"User unable to view 'Save' Symbol");
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("cancelTagField")).isDisplayed(),"User unable to view 'Close' Symbol");
		
		//Step 8   :"Verify that a message will come when the given Snip collection name is one character"
		//Expected :"The Snip Collection Name must be at least 2 characters" message should be displayed"	
		base.setData(LoginPageObj.Edt_LoginEmail("customTagName"), base.CreateRandomWithoutNumbers(1)); 
		base.buttonClick(LoginPageObj.Btn_SingnIn("btnAddTag"));
		String Actual=base.GetText(SnipCollectionsObj.Ele_SnipSuccessMessage("3", "successTag"));
		String Expected="The Snip Collection Name must be at least 2 characters.";
		asrt.assertEquals(Actual,Expected, "Error/ Relevant message not displayed as expected.");
    }
    
    // <summary>
	// Test Case Title :"Verify that the given Snip collection name is Saved when the user click the save icon"
	// Automation ID   : Snip Coll_11
	// </summary>
    public void SnipColl_11_SnipCollections() throws InterruptedException 
    {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddnewMemeberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		SnipCollections_Obj SnipCollectionsObj= new SnipCollections_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User unable to view to Snip Collections Home Page");	
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")),"User unable to navigate to Snip collection page");
	   
		//Step 4   :"Verify that a HOME COLLECTIONS  tab is displayed"
		//Expected :"User should see the HOME COLLECTIONS tab on Snip collection page"
		asrt.assertEquals(base.GetText(CreateAddnewMemeberWithEmailObj.Ele_EditTeam("2816")),"HOME COLLECTIONS","User unable to view HOME COLLECTIONS  tab ");	
		
		//Step 5   :"Verify that  a "+"  icon is displayed on the left side of the HOME COLLECTIONS Tab"
		//Expected :"User should see a "+" buttonicon on the left side of the HOME COLLECTIONS Tab"	
		asrt.assertTrue(driver.findElement(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")).isDisplayed(),"User unable to view "+" icon");
	    
		//Step 6   :"Verify that "Enter Snip collection name" text field is displayed when user click the "+" icon"
		//Expected :"Enter Snip collection name" text field should dipslayed"	
		base.buttonClick(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList"));
		String Expected5="Enter Snip Collection Name";
		asrt.assertEquals(base.GetAttribte(LoginPageObj.Edt_LoginEmail("customTagName"),"placeholder"),Expected5,"User unable to view 'Enter Snip collection name' text field");
	    
		//Step 7   :"Verify that the colour option, Save and close symbols will be displayed along with the snip name text field,"
		//Expected :"Colour option, Save and close symbols should be displayed"	
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("btnColorPicker")).isDisplayed(),"User unable to view 'Colour' option");
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("btnAddTag")).isDisplayed(),"User unable to view 'Save' Symbol");
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("cancelTagField")).isDisplayed(),"User unable to view 'Close' Symbol");
				
		//Step 8  :"Verify that the given Snip collection name is Saved when the user click the save icon""
		//Expected :"Snip collection name should be saved"	
		base.setData(LoginPageObj.Edt_LoginEmail("customTagName"), base.CreateRandomWithoutNumbers(3)); 
		base.buttonClick(LoginPageObj.Btn_SingnIn("btnAddTag"));
		String Actual1=base.GetText(SnipCollectionsObj.Ele_SnipSuccessMessage("3", "successTag"));
		String Expected1="Record Created Successfully";
		asrt.assertEquals(Actual1,Expected1, "Snip collection name is not saved");
    }
    
    // <summary>
	// Test Case Title :"Verify that the snip collection name text box get closed when user click the close icon"
	// Automation ID   : Snip Coll_12
	// </summary>
    public void SnipColl_12_SnipCollections() throws InterruptedException 
    {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddnewMemeberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User unable to view to Snip Collections Home Page");	
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")),"User unable to navigate to Snip collection page");
	   
		//Step 4   :"Verify that a HOME COLLECTIONS  tab is displayed"
		//Expected :"User should see the HOME COLLECTIONS tab on Snip collection page"
		asrt.assertEquals(base.GetText(CreateAddnewMemeberWithEmailObj.Ele_EditTeam("2816")),"HOME COLLECTIONS","User unable to view HOME COLLECTIONS  tab ");	
		
		//Step 5   :"Verify that  a "+"  icon is displayed on the left side of the HOME COLLECTIONS Tab"
		//Expected :"User should see a "+" buttonicon on the left side of the HOME COLLECTIONS Tab"	
		asrt.assertTrue(driver.findElement(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")).isDisplayed(),"User unable to view "+" icon");
	    
		//Step 6   :"Verify that "Enter Snip collection name" text field is displayed when user click the "+" icon"
		//Expected :"Enter Snip collection name" text field should dipslayed"	
		base.buttonClick(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList"));
		String Expected5="Enter Snip Collection Name";
		asrt.assertEquals(base.GetAttribte(LoginPageObj.Edt_LoginEmail("customTagName"),"placeholder"),Expected5,"User unable to view 'Enter Snip collection name' text field");
	    
		//Step 7   :"Verify that the colour option, Save and close symbols will be displayed along with the snip name text field,"
		//Expected :"Colour option, Save and close symbols should be displayed"	
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("btnColorPicker")).isDisplayed(),"User unable to view 'Colour' option");
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("btnAddTag")).isDisplayed(),"User unable to view 'Save' Symbol");
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("cancelTagField")).isDisplayed(),"User unable to view 'Close' Symbol");
				
		//Step 8  :"Verify that the snip collection name text box get closed when user click the close icon"
		//Expected :"Snip collection name text box should get closed"	
		base.setData(LoginPageObj.Edt_LoginEmail("customTagName"), base.CreateRandomWithoutNumbers(3)); 
		base.buttonClick(LoginPageObj.Btn_SingnIn("cancelTagField"));
		asrt.assertFalse(driver.findElement(LoginPageObj.Btn_SingnIn("cancelTagField")).isDisplayed(),"The Snip collection name text box remains open");	
    }
    
    // <summary>
    // Test Case Title :"Verify that a message will displayed when snip collection name field Blank"
    // Automation ID   : Snip Coll_13
    // </summary>
    public void SnipColl_13_SnipCollections() throws InterruptedException 
    {	
		LoginPage_Obj LoginPageObj=new LoginPage_Obj();
		Login login = new Login(driver);
		Registration_Obj RegistrationObj = new Registration_Obj();
		CreateAddNewMemberWithEmail_Obj CreateAddnewMemeberWithEmailObj=new CreateAddNewMemberWithEmail_Obj();
		SnipCollections_Obj SnipCollectionsObj= new SnipCollections_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");
		
		//Step 2   :"Click Login"
		//Expected :"User should able to click LoginButton"
		login.loginToApplication(CommonData.UserName, CommonData.PassWord);
		
		//Step 3   :"Click Snip Collection Tab on top side"
		//Expected :"User should able to navigate to Snip collection page when click on Snip collection tab"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Snip Collections")),"User unable to view to Snip Collections Home Page");	
		base.buttonClick(LoginPageObj.Btn_Login("Snip Collections"));	
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")),"User unable to navigate to Snip collection page");
	   
		//Step 4   :"Verify that a HOME COLLECTIONS  tab is displayed"
		//Expected :"User should see the HOME COLLECTIONS tab on Snip collection page"
		asrt.assertEquals(base.GetText(CreateAddnewMemeberWithEmailObj.Ele_EditTeam("2816")),"HOME COLLECTIONS","User unable to view HOME COLLECTIONS  tab ");	
		
		//Step 5   :"Verify that  a "+"  icon is displayed on the left side of the HOME COLLECTIONS Tab"
		//Expected :"User should see a "+" buttonicon on the left side of the HOME COLLECTIONS Tab"	
		asrt.assertTrue(driver.findElement(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList")).isDisplayed(),"User unable to view "+" icon");
	    
		//Step 6   :"Verify that "Enter Snip collection name" text field is displayed when user click the "+" icon"
		//Expected :"Enter Snip collection name" text field should dipslayed"	
		base.buttonClick(RegistrationObj.Edt_SignUpPopupPassword("btnAddTagList"));
		String Expected5="Enter Snip Collection Name";
		asrt.assertEquals(base.GetAttribte(LoginPageObj.Edt_LoginEmail("customTagName"),"placeholder"),Expected5,"User unable to view 'Enter Snip collection name' text field");
	    
		//Step 7   :"Verify that the colour option, Save and close symbols will be displayed along with the snip name text field,"
		//Expected :"Colour option, Save and close symbols should be displayed"	
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("btnColorPicker")).isDisplayed(),"User unable to view 'Colour' option");
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("btnAddTag")).isDisplayed(),"User unable to view 'Save' Symbol");
		asrt.assertTrue(driver.findElement(LoginPageObj.Btn_SingnIn("cancelTagField")).isDisplayed(),"User unable to view 'Close' Symbol");
		
		//Step 8  :"Verify that a message will displayed when snip collection name field Blank"
		//Expected :""Snip Collection Already Exists" messages should displayed"	
		base.buttonClick(LoginPageObj.Btn_SingnIn("btnAddTag"));
		String Actual1=base.GetText(SnipCollectionsObj.Ele_SnipSuccessMessage("3", "successTag"));
		String Expected1="The Snip Collection Name field is required.";
		asrt.assertEquals(Actual1,Expected1, "\"Snip Collection Already Exists\" messages not displayed");	
    }
}

