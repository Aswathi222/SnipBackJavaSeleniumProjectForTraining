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
//import utilPack.BaseTest;
//import basePackage.BasePge;

public class PublicGameListing extends BasePge {

	BasePge base;
	Assert asrt;

	public PublicGameListing(WebDriver driver) {    //WebDriver used to interact with browser
		super(driver);                              //here we are calling the driver given in the basepge class(ie;chromedriver)
		base = new BasePge(driver);                 //base act as a variable
	}
	public void TC01_PublicGameListing() {
		//Step1: Enter snipback URL
		//Expected Result: The user should be able to navigates to the  Snipback website after entering the URL
		LoginPage_Obj home = new LoginPage_Obj();
		asrt.assertTrue(base.isExists(home.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate to Snipback website");
		
	}
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
	public void TC09_PublicGameListing() {
		LoginPage_Obj home = new LoginPage_Obj();	
		GameListing_Obj film = new GameListing_Obj();
		LoginPage_Obj	filter = new LoginPage_Obj();
		
		
		//Step1:Enter snipback URL
		//Expected Result: The user should be able to navigates to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(home.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate to Snipback website");
		
		//Step2:Click on FILM Tab
		//Expected Result: The user should be able to click on "FILM" tab without login to snipback
		asrt.assertTrue(base.isExists(film.Btn_Film("nav-item", "Film")),"Unable to find Film tab");
		base.buttonClick(film.Btn_Film("nav-item", "Film"));
		asrt.assertTrue(base.isExists(film.Ele_FilmBanner("container pb-2 bannerTexts","Powerful Multi- Camera")),"Unable to Navigate to Film Page");
				
		//Step3:Verify the Option "Filter by date"
		//The option Filter by date (MM/DD/YYYY) for filter the games should be displayed
		asrt.assertTrue(base.isExists(filter.Edt_AlertMessage("Filter by")),"'Filter By Text' is not visible");
		asrt.assertTrue(base.isExists(filter.Edt_LoginEmail("date_picker")),"'Filter by date' Option is not Visible");
	}
	public void TC11_PublicGameListing() {
		LoginPage_Obj home = new LoginPage_Obj();	
		GameListing_Obj film = new GameListing_Obj();
		LoginPage_Obj	filter = new LoginPage_Obj();
		
//		Step1: Enter snipback URL
		//Expected Result: The user should be able to navigates to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(home.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate to Snipback website");
		
//		Step2: Click on FILM Tab
		//Expected Result: The user should be able to click on "FILM" tab without login to snipback
		asrt.assertTrue(base.isExists(film.Btn_Film("nav-item", "Film")),"Unable to find Film tab");
		base.buttonClick(film.Btn_Film("nav-item", "Film"));
		asrt.assertTrue(base.isExists(film.Ele_FilmBanner("container pb-2 bannerTexts","Powerful Multi- Camera")),"Unable to Navigate to Film Page");
				
//		Step3: Verify the Option "TEAM with Dropdown ALL"
//		Expected Result: An option Team with drop down "ALL" should be displayed near to Filter by date option in the FILM page to list all the public games
		asrt.assertTrue(base.isExists(filter.Edt_AlertText("Team")),"TEAM text is not visible");
		asrt.assertTrue(base.isExists(film.Ddl_Team("fliter-textInput","team_id")),"Dropdown 'All' is not visible");
	}
	public void TC12_PublicGameListing() {
		LoginPage_Obj home = new LoginPage_Obj();	
		GameListing_Obj film = new GameListing_Obj();
		
//		Step1: Enter snipback URL
//		Expected Result: The user should be able to navigates to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(home.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate to Snipback website");
		
//		Step2: Click on FILM Tab
//		Expected Result: The user should be able to click on "FILM" tab without login to snipback
		asrt.assertTrue(base.isExists(film.Btn_Film("nav-item", "Film")),"Unable to find Film tab");
		base.buttonClick(film.Btn_Film("nav-item", "Film"));
		asrt.assertTrue(base.isExists(film.Ele_FilmBanner("container pb-2 bannerTexts","Powerful Multi- Camera")),"Unable to Navigate to Film Page");
		
//		Step3: Verify the Option "" Sort By date"" along with Up arrow and Down arrow"
//		Expected Result: An option " Sort By date"  should be displayed along with Up arrow and Down arrow in the FILM Page  
		asrt.assertTrue(base.isExists(film.Ele_FilmBanner("fliter-sub","Sort by Date")),"\" Sort By date\"is not visible");
		asrt.assertTrue(base.isExists(film.Ele_Sort("sort-img option-checked first","fliter-textInput")) &&base.isExists(film.Ele_Sort("sort-img second","fliter-textInput")),
				"Either the Up arrow or Down arrow option is not visible in the page");
	}
	public void TC17_PublicGameListing() {
		LoginPage_Obj home = new LoginPage_Obj();	
		GameListing_Obj film = new GameListing_Obj();
		
//		Step1: Enter snipback URL
//		Expected Result: The user should be able to navigates to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(home.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate to Snipback website");
		
//		Step2: Click on FILM Tab
//		Expected Result: The user should be able to click on "FILM" tab without login to snipback
		asrt.assertTrue(base.isExists(film.Btn_Film("nav-item", "Film")),"Unable to find Film tab");
		base.buttonClick(film.Btn_Film("nav-item", "Film"));
		asrt.assertTrue(base.isExists(film.Ele_FilmBanner("container pb-2 bannerTexts","Powerful Multi- Camera")),"Unable to Navigate to Film Page");
		
//		Step3: Verify the Search Option
//		Expected Result: Search Option with searh icon should displayed in the FILM Page
		asrt.assertTrue(base.isExists(home.Edt_LoginEmail("search")),"Search option is not visible in the Film page");
		asrt.assertTrue(base.isExists(film.Ele_Sort("search-img","search-textInput")),"searh icon is not displayed in the FILM Page");
		
	}
	public void TC04_PublicGameListing() {
		LoginPage_Obj home = new LoginPage_Obj();	
		GameListing_Obj film = new GameListing_Obj();
		
//		Step1: Enter snipback URL
//		Expected Result: The user should be able to navigates to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(home.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate to Snipback website");
		
//		Step2: Click on FILM Tab
//		Expected Result: The user should be able to click on "FILM" tab without login to snipback
		asrt.assertTrue(base.isExists(film.Btn_Film("nav-item", "Film")),"Unable to find Film tab");
		base.buttonClick(film.Btn_Film("nav-item", "Film"));
		asrt.assertTrue(base.isExists(film.Ele_FilmBanner("container pb-2 bannerTexts","Powerful Multi- Camera")),"Unable to Navigate to Film Page");
		
//		Step3: Verify only public games are listing
//		Expected Result:user should be able to see only the public games along with their dates including day (eg: Wednesday, Oct 23 2024) after entering into FILM page
		
	

}
	
}