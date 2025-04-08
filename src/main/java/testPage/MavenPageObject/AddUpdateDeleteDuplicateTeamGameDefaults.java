package testPage.MavenPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import TestData.AddUpdateDeleteDuplicateTeamGameDefaults_TestData;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import utilPack.BasePge;

public class AddUpdateDeleteDuplicateTeamGameDefaults  extends BasePge{

	BasePge base;
	Assert asrt;

	public AddUpdateDeleteDuplicateTeamGameDefaults(WebDriver driver) 
	{
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
	// Test Case Title :    "1.Verify that user should able to navigate to the snipback website after entering the URL		
	// Automation ID :Team_01
	// </summary>
	public void Team_01_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{	
		LoginPage_Obj loginObj=new LoginPage_Obj();

		//Step 1 : Verify that user should able to navigate to the snipback website after entering the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("nav-link btn btn-white sm")), "User is unable to navigate to SnipBack website after entering the URL");
	}

	// <summary>
	// Test Case Title : Verify that user should able to navigate to the Film page once login with credentials		
	// Automation ID :Team_02
	// </summary>
	public void Team_02_AddUpdateDeleteDuplicateTeamGameDefaults() throws InterruptedException 
	{
		LoginPage_Obj loginObj=new LoginPage_Obj();
		Registration_Obj   registrationobj = new Registration_Obj();
		AddUpdateDeleteDuplicateTeamGameDefaults_TestData addupdatedeleteduplicateteamgamedefaults = new AddUpdateDeleteDuplicateTeamGameDefaults_TestData();

		//Step 1 : Verify that user should able to navigate to the snipback website after entering the URL
		//Expected : User should able to navigate to the snipback website after entering the URL
		asrt.assertTrue(base.isExists(loginObj.Btn_LoginButton("nav-link btn btn-white sm")), "User is unable to navigate to SnipBack website after entering the URL");

		//Step 2: Verify that user should able to navigate to the Film page once login with credentials
		//Expected : User should able to navigate to the Film page once login with credentials
		base.buttonClick(loginObj.Btn_LoginButton("nav-link btn btn-white sm"));
		base.setData(loginObj.Edt_LoginEmail("email_address"),addupdatedeleteduplicateteamgamedefaults.Team02_ValidEmailId );
		base.setData(loginObj.Edt_LoginEmail("password"),addupdatedeleteduplicateteamgamedefaults.Team02_ValidPassword);
		base.buttonClick(loginObj.Btn_SingnIn("login_submit"));
		asrt.assertTrue(base.isExists(loginObj.Btn_SingnIn("nav-game-tab")),"User is unable to navigate to the Film page once login with credentials");
	}
}
