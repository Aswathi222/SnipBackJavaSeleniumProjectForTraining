package testPage.MavenPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.testng.Assert;
import TestData.PublicGameLisiting_TestData;
import objectRepository.CreateEditDeletePool_Obj;
import objectRepository.LoginPage_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;
import utilPack.ElementActions;

public class PublicGameListing extends BasePge{

	BasePge base;
	Assert asrt;
	ElementActions element;
	
	public PublicGameListing(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
		element=new ElementActions(driver);
	}
	
	// <summary>
	// Test Case Title : "Verify that the user should be able to navigates to the  Snipback website after entering the URL"
	// Automation ID : GameListing_01
	// </summary>
	public void GameListing_01_PublicGameListing() 
	{
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
	public void GameListing_02_PublicGameListing() 
	{
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
	public void GameListing_03_PublicGameListing() 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");	
		
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to snipback
		base.buttonClick(PublicGameObj.Btn_Menu("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");	
	}
	
	//<summary>
	//Verify that the user should be able to see only the public games after entering into FILM page
	//Automation ID:GameListing_04
	//</summary>
	public void GameListing_04_PublicGameListing() 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");	
		
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");	
		
		//Step3:Verify that the user should be able to see only the public games after entering into FILM page
		//Expected :User should be able to see only the public games along with their dates including day (eg: Wednesday, Oct 23 2024) after entering into FILM page
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("PublicGameLisitngTestGame")) &&  base.isExists(PublicGameObj.Ele_Date("Friday,", " Mar 28 2025")), "User is unable to see public game 'PublicGameLisitngTestGame' with date 'Friday,  Mar 28 2025' on the Films page");
	   
	}
	
	//<summary>
	//Verify that the user should be able to see the public games as per the recent dates along with day after entering into FILM page
    //Automation ID:GameListing_05
	//</summary>
	public void GameListing_05_PublicGameListing() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");	
		//Step 3  :"Verify user able to see the public games as per the condition"
		//Expected:"User should be able to see the public games as per the recent dates along with day after entering into FILM page" 
		ArrayList<LocalDate> extractedDates = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy", Locale.US);
		String todayDate = element.getFormattedDate(PublicGameObj.Ele_GameDate(2, "redText"));  
		for (int i = 2; i <= 26; i++) {  
		    By dateLocate = PublicGameObj.Ele_GameDate(i, "redText"); 
		    String dateText = base.GetText(dateLocate).trim(); 
		    dateText = dateText.substring(0, 1).toUpperCase() + dateText.substring(1).toLowerCase();
		    LocalDate extractedDate = LocalDate.parse(dateText, formatter);
		    if (!extractedDate.equals(todayDate)) {
		        extractedDates.add(extractedDate);
		    }
		}
		boolean isSorted = true;
		for (int i = 2; i < extractedDates.size() - 1; i++) {
		    if (extractedDates.get(i).isBefore(extractedDates.get(i + 1))) {
		        isSorted = false;
		        break;
		    }
		}
		asrt.assertTrue(base.isExists(PublicGameObj.Ele_GameName(1,"cardheading")) && base.isExists(PublicGameObj.Ele_GameName(1,"mainHead")),"User is not able  to see the public game as per the recent dates along with day after entering into FILM page");
	}
	
	//<summary>
	//Verify that an option  "See All" should be displayed at the right side of the film page,  if multiple games are available under single date
    //Automation ID:GameListing_06
	//</summary>
	public void GameListing_06_PublicGameListing() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");	
		//Step3:Verify the option " See All"
		//Expected:An option  "See All" should be displayed at the right side of the film page,  if multiple games are available under single date
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_LoginButton("see-all")),"User is unable to see the 'See All' option on the right side of the film page when multiple games are available under a single date");
	}
	
	//<summary>
	//Verify that left and right arrow should be displayed to move left and right side to see all the games, if multiple games are available under single date
    //Automation ID:GameListing_07
	//</summary>
	public void GameListing_07_PublicGameListing() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		SnipBackLogin_Obj SnipObj=new SnipBackLogin_Obj ();
		
		//Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");
		
		//Step3:Verify left and right side arrow
		//Expected:Left and right arrow should be displayed to move left and right side to see all the games, if multiple games are available under single date
		base.excuteJsClick(SnipObj.Btn_Signin("Next"));
		asrt.assertTrue(base.isExists(PublicGameObj.Ele_GameName(21,"cardheading")),"User is not able to view the next public game");
		base.excuteJsClick(SnipObj.Btn_Signin("Previous"));
		asrt.assertTrue(base.isExists(PublicGameObj.Ele_GameName(20,"cardheading")),"User is not able to view the previous public game.");		
	}
	
	//<summary>
	//Verify that the game details (Game name, name of the Organization, Likes, single view/ multiple view, Stat (Only for games with stat) should be displayed under the games
	//Automation ID:GameListing_08
	//</summary>
	public void GameListing_08_PublicGameListing() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		
		//Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");	
		 
	   //Step3:Verify the Game Details
	   //Expected:Game details (Game name, name of the Organization, Likes, single view/ multiple view, Stat (Only for games with stat) should be displayed under the games
		asrt.assertTrue(base.isExists(PublicGameObj.Ele_GameName(1,"cardheading")),"User is unable to see the game name"); 
		asrt.assertTrue(base.isExists(PublicGameObj.Ele_GameDate(1,"cardSubHead")),"User is unable to see the organisation name"); 
		asrt.assertTrue(base.isExists(PublicGameObj.Ele_GameName(1,"views-content")),"User is unable to see the likes count");
		asrt.assertTrue(base.isExists(PublicGameObj.Ele_GameName(1,"multiview")),"User is unable to see the view type(single view or multiple view)");
		asrt.assertTrue(base.isExists(PublicGameObj.Ele_GameName(1,"views-contents stats")),"User is unable to see the gamestat");
	}
	
	//<summary>
	////Verify that an option Filter by date (MM/DD/YYYY) for filter the games should be displayed
	//Automation ID:GameListing_09
	//</summary>
	public void GameListing_09_PublicGameListing() throws InterruptedException {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to Snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");
		
		//Step3:Verify the Option "Filter by date" 
		//Expected:The option Filter by date for filter the games should be displayed
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("date_picker")),"User is unable to see the Filter by date option to filter the games");
   }
	
	// <summary>
	// Test Case Title  : "Verify that the Proper games as per the date should be listed when the user try to filter the games by using the option "Filter by date (MM/DD/YYYY)""
	// Automation ID    : Game Listing_10
	// </summary>
	public void GameListing_10_PublicGameListing() throws InterruptedException {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		PublicGameLisiting_TestData testObj=new PublicGameLisiting_TestData();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
		
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to Snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");
		
		//Step3:Verify the Option "Filter by date" 
		//Expected:The option Filter by date for filter the games should be displayed
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("date_picker")),"User is unable to see the Filter by date option to filter the games");
		
		//Step4:Enter the date as per the format "MM/DD/YYYY"
		//Expected:"User should be able to enter the date as per the format MM/DD/YYY".
		base.setData(LoginPageObj.Edt_LoginEmail("date_picker"), testObj.GameListing_10_PublicGameLDate);
		
		//Step 5: Click on Enter
		//Expected : Proper games as per the date should be listed when the user try to filter the games by using the option "Filter by date (MM/DD/YYYY)"
		base.pressKey(null,"KEYBOARD_ENTER" );
		List<WebElement> gamesAfterFilter = base.GetElement(LoginPageObj.Ele_ErrorMessage("cardheading"));
		asrt.assertTrue(!gamesAfterFilter.isEmpty(), "User is not able to see the proper games listed after filtering by date using the 'Filter by date (MM/DD/YYYY)' option");
  }
	//<summary>
	// Test Case Title  : Verify that an option Team with drop down "ALL" should be displayed near to Filter by date option in the FILM page to list all the public games
	// Automation ID    : Game Listing_11
	// </summary>
	public void GameListing_11_PublicGameListing() throws InterruptedException {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		CreateEditDeletePool_Obj CDPoolObj=new CreateEditDeletePool_Obj();
				
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to Snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");
				
		//Step3:Verify the Option "TEAM with Dropdown ALL"
		//Expected:An option Team with drop down "ALL" should be displayed near to Filter by date option in the FILM page to list all the public games
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Team")) && base.isExists(CDPoolObj.Sel_PoolType("team_id")),"User is not able to view the Team Option or the 'All' dropdown near to Filter by date option in the FILM page to list all the public games");
		}
	//<summary>
	// Test Case Title  : Verify that another option " Sort By date"  should be displayed along with Up arrow and Down arrow in the FILM Page
	// Automation ID    : Game Listing_12
	// </summary>
	public void GameListing_12_PublicGameListing() throws InterruptedException {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
				
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to Snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");
				
		//Step3:Verify the Option " Sort By date" along with Up arrow and Down arrow
		//Expected:An option " Sort By date"  should be displayed along with Up arrow and Down arrow in the FILM Page
        asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Sort by Date")) && base.isExists(PublicGameObj.Img_sort("sort-img option-checked first")) && base.isExists(PublicGameObj.Img_sort("sort-img second")),"User is not able to view the 'Sort By Date' option along with the Up and Down arrows in the FILM page.");
		}
	
	//<summary>
	// Test Case Title  : Verify that pagination should be displayed at the bottom of the FILM page while scrolling to view the games
	// Automation ID    : Game Listing_13
	// </summary>
	public void GameListing_13_PublicGameListing() throws InterruptedException {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to Snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");
				
		//Step3:Scroll down the page
		//Expected:Pagination should be displayed at the bottom of the FILM page while scrolling to view the games
		base.scrollToElement(LoginPageObj.Ele_ErrorMessage("pagination"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("pagination")),"User is not able to see pagination at the bottom of the FILM page while scrolling to view the games");
		}

	//<summary>
	// Test Case Title  :Verify that the games should be listed as per the selected page in the FILM Page (eg: If we select the page 3, the game should be listed from Page 3)
	// Automation ID    : Game Listing_14
	// </summary>
	public void GameListing_14_PublicGameListing() throws InterruptedException {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		PublicGameLisiting_TestData testObj=new PublicGameLisiting_TestData();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to Snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");
				
		//Step3:Scroll down the page
		//Expected:The user should be able to to scroll down the page to view the games
		base.scrollToElement(LoginPageObj.Ele_ErrorMessage("pagination"));
		
		//Step4:Click on any page and verify the games
		//Expected:The games should be listed as per the selected page in the FILM Page
		base.excuteJsClick(LoginPageObj.Btn_Login("2"));
		ArrayList<String> games = new ArrayList<>();
		games.add(testObj.GameListing_14_PublicGameName1);
		games.add(testObj.GameListing_14_PublicGameName2);
		games.add(testObj.GameListing_14_PublicGameName3);
		games.add(testObj.GameListing_14_PublicGameName4);
		for (String game : games) {
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText(game)),"User is not able to view the games listed as per the selected page in the FILM Page");
		}
		}
	//<summary>
	// Test Case Title  :Verify that when the user click on Up arrow, the games should be sorted as per their recent dates from the current page
	// Automation ID    : Game Listing_15
	// </summary>
	public void GameListing_15_PublicGameListing() throws InterruptedException {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to Snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");
		
		//Step3:Click on Up arrow
		//Expected:User should be able to sort the games by recent dates when the Up arrow is clicked.
		base.buttonClick(PublicGameObj.Img_sort("sort-img option-checked first"));
		asrt.assertTrue(base.isExists(PublicGameObj.Ele_GameName(1,"cardheading")) && base.isExists(PublicGameObj.Ele_GameName(1,"mainHead")),"User is not able  to see the public game as per the recent dates when the Up Arrow is clicked after entering into FILM page");
	
	}
	//<summary>
	// Test Case Title  :Verify that when the user click on Down arrow, the games should be listed as per their former dates from the current page
	// Automation ID    : Game Listing_16
	// </summary>
	public void GameListing_16_PublicGameListing() throws InterruptedException {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to Snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");
		
		//Step3:Click on Down arrow
		//Expected:User should be able to sort the games by their former dates when the Down arrow is clicked
		base.buttonClick(PublicGameObj.Img_sort("sort-img second"));
		asrt.assertTrue(base.isExists(PublicGameObj.Ele_GameName(1,"cardheading")) && base.isExists(PublicGameObj.Ele_GameName(1,"mainHead")),"User is not able  to see the public game as per the former dates when the Down Arrow is clicked after entering into FILM page");
	
	}
	//<summary>
	// Test Case Title  :Verify that a Search Option with search icon should displayed in the FILM Page
	// Automation ID    : Game Listing_17
	// </summary>
	public void GameListing_17_PublicGameListing() throws InterruptedException {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to Snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");
		
		//Step3:Verify the Search Option
		//Expected:User should be able to see the Search Option with search icon in the FILM Page
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("search")) && base.isExists(PublicGameObj.Img_sort("search-img")),"User is not able to see the Search Option with search icon in the FILM Page");
		
	}
	//<summary>
	// Test Case Title  :Verify that the user should be able to fetch the proper results while searching any games in the search tab and click on search icon
	// Automation ID    : Game Listing_18
	// </summary>
	public void GameListing_18_PublicGameListing() throws InterruptedException {
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameObj=new PublicGameListing_Obj();
		PublicGameLisiting_TestData testObj=new PublicGameLisiting_TestData();
		
		// Step1: User navigated to SnipBack Website after entering snipback url
		// Expected:The user should be able to navigate to the  Snipback website after entering the URL
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_SnipBackHomePageLogo("light-logo")), "User is unable to navigate to SnipBack website after entering the URL");
				
		//Step2:Click on FILM Tab without login
		//Expected:The user should be able to click on "FILM" tab without login to Snipback
		base.buttonClick(PublicGameObj.Btn_Home("Film","menu_link nav-link "));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertMessage(" Amplifies")),"User is unable to click on Films tab without login to SnipBack");
		
		//Step3:Search any games in the search tab and click on search icon
		//Expected:User should be able to fetch the proper results while searching any games in the search tab and click on search icon
		base.setData(LoginPageObj.Edt_LoginEmail("search"),testObj.GameListing_14_PublicGameName1);
		base.buttonClick(PublicGameObj.Img_sort("search-img"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("cardheading")),"User is not be able to fetch the proper results while searching any games in the search tab and click on search icon");
			
	}
}


