package testPage.MavenPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
import TestData.SnipBackLogin_TestData;
import objectRepository.GameListing_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import utilPack.BasePge;

public class PublicGameListing extends BasePge {
	BasePge base;
	Assert asrt;

	public PublicGameListing(WebDriver driver) {    
		super(driver);                            
		base = new BasePge(driver);                 
	}
	//<summary>
	//Test Case Title: Verify that the user should be able to navigates to the  Snipback website after entering the URL
	//Automation ID: Game Listing_01
	//</summary>
	public void TC01_PublicGameListing() {
		//Step1: Enter snipback URL
		//Expected Result: The user should be able to navigates to the  Snipback website after entering the URL
		LoginPage_Obj home = new LoginPage_Obj();
		asrt.assertTrue(base.isExists(home.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate to Snipback website");
	}
	//<summary>
	//Test Case Title: "Verify that the user should be able to see the following Options when entering into snipaback website
	//1.Home, 2.Film, 3.Pricing, 4.Login button"
	//Automation ID: Game Listing_02
	//</summary>
	public void TC02_PublicGameListing() {
		LoginPage_Obj home = new LoginPage_Obj();
		Registration_Obj options = new Registration_Obj();
		
		//Step1: Enter snipback URL
		//Expected Result: The user should be able to navigates to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(home.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate to Snipback website");
		
		//Step2: Verify the Options (Home,Film, Pricing, Login Button
		//Expected Result:The user should be able to see the following Options when entering into snipaback website
		//1.Home 2.Film 3.Pricing 4.Login button"
		asrt.assertTrue(base.isExists(options.Btn_Login("menu_link nav-link  active ","Home")),"Unable to find Home Option");
		asrt.assertTrue(base.isExists(options.Btn_Login("menu_link nav-link ", "Film")),"Unable to find Film Option");
		asrt.assertTrue(base.isExists(options.Btn_Login("menu_link nav-link ", "Pricing")),"Unable to find Pricing Option");
		asrt.assertTrue(base.isExists(options.Btn_Login("nav-link btn btn-white sm", "Login")),"Unable to find Login Button");
	}	
	//<summary>
	//Test Case Title: Verify that the user should be able to click on "FILM" tab without login to snipback
	//Automation ID: Game Listing_03
	//</summary>
	public void TC03_PublicGameListing() {
		LoginPage_Obj home = new LoginPage_Obj();	
		GameListing_Obj film = new GameListing_Obj();
		
		//Step1: Enter snipback URL
		//Expected Result: The user should be able to navigates to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(home.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate to Snipback website");
		
		//Step2: Click on FILM Tab
		//Expected Result: The user should be able to click on "FILM" tab without login to snipback
		asrt.assertTrue(base.isExists(film.Btn_Film("nav-item", "Film")),"Unable to find Film tab");
		base.buttonClick(film.Btn_Film("nav-item", "Film"));
		asrt.assertTrue(base.isExists(film.Ele_FilmBanner("container pb-2 bannerTexts","Powerful Multi- Camera")),"Unable to Navigate to Film Page");
	}
}