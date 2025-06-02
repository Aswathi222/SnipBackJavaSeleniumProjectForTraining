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
	//<summary>
	//Test Case Title: Verify that an option Filter by date (MM/DD/YYYY) for filter the games should be displayed
	//Automation ID: Game Listing_09
	//</summary>
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
		asrt.assertTrue(base.isExists(film.Ele_DateInput("MM/DD/YYYY")),"'Filter by date'(MM/DD/YYYY) Option is not Visible");
	}
	//<summary>
	//Test Case Title: Verify that an option Team with drop down "ALL" should be displayed near to Filter by date option in the FILM page to list all the public games
	//Automation ID: Game Listing_11
	//</summary>
	public void TC11_PublicGameListing() {
		LoginPage_Obj home = new LoginPage_Obj();	
		GameListing_Obj film = new GameListing_Obj();
		LoginPage_Obj	filter = new LoginPage_Obj();
		
		//Step1: Enter snipback URL
		//Expected Result: The user should be able to navigates to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(home.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate to Snipback website");
		
		//Step2: Click on FILM Tab
		//Expected Result: The user should be able to click on "FILM" tab without login to snipback
		asrt.assertTrue(base.isExists(film.Btn_Film("nav-item", "Film")),"Unable to find Film tab");
		base.buttonClick(film.Btn_Film("nav-item", "Film"));
		asrt.assertTrue(base.isExists(film.Ele_FilmBanner("container pb-2 bannerTexts","Powerful Multi- Camera")),"Unable to Navigate to Film Page");
				
		//Step3: Verify the Option "TEAM with Dropdown ALL"
		//Expected Result: An option Team with drop down "ALL" should be displayed near to Filter by date option in the FILM page to list all the public games
		asrt.assertTrue(base.isExists(filter.Edt_AlertText("Team")) && base.isExists(film.Ddl_Team("fliter-textInput","team_id")),"Either the filter text \"Team\" or the drop down \"ALL\" is not displayed near to Filter by date option in the FILM page");
	}
	//<summary>
	//Test Case Title: Verify that, a Search Option with search icon should displayed in the FILM Page
	//Automation ID: Game Listing_17
	//</summary>
	public void TC17_PublicGameListing() {
		LoginPage_Obj home = new LoginPage_Obj();	
		GameListing_Obj film = new GameListing_Obj();
		LoginPage_Obj	filter = new LoginPage_Obj();
		
		//Step1: Enter snipback URL
		//Expected Result: The user should be able to navigates to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(home.Ele_SnipBackHomePageLogo("light-logo")),"Unable to navigate to Snipback website");
		
		//Step2: Click on FILM Tab
		//Expected Result: The user should be able to click on "FILM" tab without login to snipback
		asrt.assertTrue(base.isExists(film.Btn_Film("nav-item", "Film")),"Unable to find Film tab");
		base.buttonClick(film.Btn_Film("nav-item", "Film"));
		asrt.assertTrue(base.isExists(film.Ele_FilmBanner("container pb-2 bannerTexts","Powerful Multi- Camera")),"Unable to Navigate to Film Page");
		
		//Step3: Verify the Search Option
		//Expected Result: Search Option with search icon should displayed in the FILM Page
		asrt.assertTrue(base.isExists(home.Edt_LoginEmail("search")) && base.isExists(film.Ele_Sort("search-img","search-textInput")),"Either the Search option or the search icon is not visible in the FILM Page");
}
	//<summary>
	//Test Case Title: Verify that another option " Sort By date"  should be displayed along with Up arrow and Down arrow in the FILM Page
	//Automation ID: Game Listing_12
	//</summary>
	public void TC12_PublicGameListing() {
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
		
		//Step3: Verify the Option "" Sort By date"" along with Up arrow and Down arrow"
		//Expected Result: An option " Sort By date"  should be displayed along with Up arrow and Down arrow in the FILM Page  
		asrt.assertTrue(base.isExists(film.Ele_FilmBanner("fliter-sub","Sort by Date")),"\" Sort By date\" text is not visible near the sort option");
		asrt.assertTrue(base.isExists(film.Ele_Sort("sort-img option-checked first","fliter-textInput")) &&base.isExists(film.Ele_Sort("sort-img second","fliter-textInput")),
				"Either the Up arrow or Down arrow option is not visible in the Film page");
	}
	
}