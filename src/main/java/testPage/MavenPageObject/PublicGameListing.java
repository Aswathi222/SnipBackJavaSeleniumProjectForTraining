package testPage.MavenPageObject;

import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.ArrayList;
import org.testng.Assert;
import objectRepository.LoginPage_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;

public class PublicGameListing extends BasePge{

	BasePge base;
	Assert asrt;
	
	public PublicGameListing(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	
	// <summary>
	// Test Case Title : "Verify that the user should be able to navigates to the  Snipback website after entering the URL"
	// Automation ID : GameListing_01
	// </summary>
	public void GameListing_01_PublicGameListing() {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
	}
	
	// <summary>
	// Test Case Title : "Verify that the user should be able to see the following Options when entering into snipaback website
	//1.Home
	//2.Film
	//3.Pricing
	//4.Login button"
	// Automation ID :GameListing_02
	// </summary>
	
	public void GameListing_02_PublicGameListing() {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		
		// Step1: User navigated to SnipBack Website after entering Snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");	
		
	    //Step2:.Verify the Options (Home,Film, Pricing, Login Button)
		// Expected: The user should be able to see the following Options when entering into Snipback website
		//1.Home
		//2.Film
		//3.Pricing
		//4.Login button
        ArrayList<String> menu = new ArrayList<>();
        menu.add("Home");
        menu.add("Film");
        menu.add("Pricing");
        for (String option : menu) {
            Assert.assertTrue(base.isExists(PublicGameObj.Btn_Menu(option, "menu_link nav-link ")),"User is unable to view " + option + " Option when entering into the SnipBack Website");
        }
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")), "User is unable to view Login Option when entering into the  SnipBack Website");
	}
	//<summary>
	//Verify that the user should be able to click on "FILM" tab without login to snipback
	//Automation ID:GameListing_03
	//</summary>
		public void GameListing_03_PublicGameListing() {
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
			
			// Step1: User navigated to SnipBack Website after entering snipback url
			// Expected:The user should be able to navigate to the  Snipback website after entering the URL
			asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");	
			
			//Step2:Click on FILM Tab without login
			//Expected:The user should be able to click on "FILM" tab without login to snipback
			base.buttonClick(PublicGameObj.Btn_Menu("Film","menu_link nav-link "));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");	
		}
		//<summary>
		//Verify that the user should be able to see only the public games after entering into FILM page
		//Automation ID:GameListing_04
		//</summary>
		public void GameListing_04_PublicGameListing() {
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();
			PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
			
			// Step1: User navigated to SnipBack Website after entering snipback url
			// Expected:The user should be able to navigate to the  Snipback website after entering the URL
			asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");	
			
			//Step2:Click on FILM Tab without login
			//Expected:The user should be able to click on "FILM" tab without login to snipback
			base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");	
			
			//Step3:Verify that the user should be able to see only the public games after entering into FILM page
			//Expected :User should be able to see only the public games along with their dates including day (eg: Wednesday, Oct 23 2024) after entering into FILM page
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("PublicGameLisitngTestGame")) &&  base.isExists(PublicGameObj.Ele_Date("Friday,", " Mar 28 2025")), "User is unable to see public game 'PublicGameLisitngTestGame' with date 'Friday,  Mar 28 2025' on the Films page");
		   
		}
	
		
}
