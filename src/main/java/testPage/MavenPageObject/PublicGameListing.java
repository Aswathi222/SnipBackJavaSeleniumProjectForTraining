package testPage.MavenPageObject;
import TestData.ForgotPassword_TestData;
import TestData.PublicGameListing_TestData;
import TestData.Registration_TestData;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import TestData.CommonData;
import objectRepository.LoginPage_Obj;
import objectRepository.Pool_Obj;
import objectRepository.PublicGameListing_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;
public class PublicGameListing extends BasePge{

	BasePge base;
	Assert asrt;

	public PublicGameListing(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	// <summary>
	// Test Case Title : Verify that the games should be listed as per the selected page in the FILM Page (eg: If we select the page 3, the game should be listed from Page 3)
	// Automation ID : Game Listing_14 
	// </summary>
	public void GameListing_14_PublicGameListing() throws InterruptedException
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj= new PublicGameListing_Obj();		

		// step 1:"Enter snipback URL"
		//expected:"User should be able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Click on FILM Tab
		//Expected:The user should be able to direct to the FILM page
		base.buttonClick(PublicGameListingObj.Ele_GameListingoptions("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"The Film Tab is not visible to the User");

		// Step 3:Scroll down the page
		//Expected:"User should be able to View the Film Page Completly"
		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_UpDownArrow("myCheckbox1")),"User is not able to view the Up Arrow with Sort By date in the Film page of snipback");
		base.excuteJsClick(PublicGameListingObj.Ele_UpDownArrow("myCheckbox1"));
		Thread.sleep(5000);

//		base.scrollToElement(PublicGameListingObj.Ele_Scrol("game test400"));
//		Thread.sleep(2000);
//		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_Scrol("game test400")),"User is not able to Sroll down the page");

		//Step4:Click on any page and verify the games
		//Expected:"The games should be listed as per the selected page in the FILM Page"
		base.scrollToElement(LoginPageObj.Btn_Login("2"));
		base.excuteJsClick(LoginPageObj.Btn_Login("2"));
		Thread.sleep(2000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("2")),"The games are not listed as per the selected page in the FILM Page");
		
//		base.buttonClick(PublicGameListingObj.Ele_Scrol("d5"));
//		Thread.sleep(2000);
//		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_Scrol("d5")),"The games are not listed as per the selected page in the FILM Page");
	} 

	// <summary>
	// Test Case Title  : "Verify that the Proper games as per the date should be listed when the user try to filter the games by using the option "Filter by date (MM/DD/YYYY)""
	// Automation ID    : Game Listing_10
	// </summary>
	public void GameListing_10_PublicGameListing() throws InterruptedException
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj= new PublicGameListing_Obj();	
		PublicGameListing_TestData publicgametestdata=new PublicGameListing_TestData();
		Registration_Obj RegistrationObj= new Registration_Obj();

		//Step 1:Enter snipback URL.
		//expected:User should able to view the Snipback page.	  
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Click on FILM Tab
		//expected:User Should  able to View Film Page 
		base.buttonClick(PublicGameListingObj.Ele_GameListingoptions("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"User is not able to view the Film page in the snipback page");

		// step 3:Verify the Option "Filter by date"
		//expected:"User should be able to View the "Filter by date"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Date")),"User is not able to view the Option Filter by date");

		//step 4:Enter the date as per the format "MM/DD/YYYY" .
		//Expected:"User should be able to enter the date as per the format MM/DD/YYY".
		base.setData(RegistrationObj.Edt_Name("MM/DD/YYYY"), publicgametestdata.GameListing_10_GameListingDate);
		String Date=base.GetValue(RegistrationObj.Edt_Name("MM/DD/YYYY"));
		asrt.assertEquals(Date, publicgametestdata.GameListing_10_GameListingDate, "The Entered Date is not displayed");	
		
		//Step 5: Click on Enter
		//Expected : Proper games as per the date should be listed when the user try to filter the games by using the option "Filter by date (MM/DD/YYYY)"
		base.buttonClick(LoginPageObj.Edt_AlertText("Date"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Powers Cheer SVL")),"Games as per the date is not listed when the user try to filter the games by using the option Filter by date (MM/DD/YYYY)");
	}
	// <summary>
	// Test Case Title : "Verify that an option Team with drop down "ALL" should be displayed near to Filter by date option in the FILM page to list all the public games" 
	// Automation ID : Game Listing_11
	// </summary>
	public void GameListing_11_PublicGameListing() throws Exception
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Pool_Obj PoolObj = new  Pool_Obj();
		//Step 1: Click on Film tab
		//Expected: User should be navigated to 'Film' page
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"User is not able to load the Film page in the snipback page");

		//Step 2   :Verify the Option "TEAM with Dropdown ALL
		//Expected :An option Team with drop down "ALL" should be displayed near to Filter by date option in the FILM page to list all the public games
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Team")),"Team option is not displayed.");
		asrt.assertTrue(base.isExists(PoolObj.Ele_PoolTypeDropDown("team_id")),"'All' is not found in 'Team' dropdown menu");

	}
	// <summary>
	// Test Case Title : "Verify that the user should be able to navigates to the  Snipback website after entering the URL" 
	// Automation ID : Game Listing_01
	// </summary>
	public void GameListing_01_PublicGameListing() throws InterruptedException 
	{ 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"The user should be able to navigates to the  Snipback website after entering the URL"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to navigates to the  Snipback website after entering the URL");

	}
	// <summary>
	// Test Case Title : "Verify that the user should be able to see the public games as per the recent dates along with day(eg: Wednesday, Oct 23 2024) after entering into FILM page "
	// Automation ID   : Game Listing_05
	// </summary>
	public void GameListing_05_PublicGameListing() throws InterruptedException 
	{ 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj = new PublicGameListing_Obj();
		
		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"User is not able to load the Film page in the snipback page");

		//Step 3  :"Verify user able to see the public games as per the condition"
		//Expected:"User should be able to see the public games as per the recent dates along with day(eg: Wednesday, Oct 23 2024) after entering into FILM page"
		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_UpDownArrow("myCheckbox1")),"User is not able to view the Up Arrow with Sort By date in the Film page of snipback");
		base.excuteJsClick(PublicGameListingObj.Ele_UpDownArrow("myCheckbox1"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1(" Feb 06 2025")),"User not able to see the public games as per the recent dates.");

	}

	// <summary>
	// Test Case Title : "Verify that the game details (Game name, name of the Organization, Likes, single view/ multiple view, Stat (Only for games with stat) should be displayed under the games" 
	// Automation ID   : Game Listing_08
	// </summary>
	public void GameListing_08_PublicGameListing() throws InterruptedException 
	{
		Login login = new Login(driver); 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj publicgamelistingObj = new PublicGameListing_Obj();

		//Step 1   :"Navigate to the SnipBack page "
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));;
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"User is not able to load the Film page in the snipback page");

		// Step 3         :"Verify Game Name"
		// Expected Result:"Game name should be displayed"
		base.setData(LoginPageObj.Edt_LoginCredentialFields("date_picker"), "02/05/2025");
		base.buttonClick(publicgamelistingObj.Ele_SearchField("search-img"));
		Thread.sleep(1000);
		base.scrollToElement(LoginPageObj.Edt_AlertText("Powers Cheer SVL"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Powers Cheer SVL")),"GameName is incorrect or not displayed");   

		// Step 4         :"Verify Organization Name"
		// Expected Result:"Organization name should be displayed"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_Alert1("Powers Catholic Cheerleading")),"OrganizationName is incorrect or not displayed");

		// Step 5        :"Verify LikesCount"
		// Expected Result:"Likes count should be displayed"
		asrt.assertTrue(base.isExists(publicgamelistingObj.Ele_LikesStatus("Powers Cheer SVL","likes")), "LikesCount is incorrect");

		// Step 6         :"Verify SingleViewType"
		// Expected Result:"View type should be displayed as single view
		asrt.assertTrue(base.isExists(publicgamelistingObj.Ele_Views("Powers Cheer SVL")), "View type is incorrect or multiple type");

		// Step 7         :"Verify Game Stat (only for games with stat)"
		// Expected Result:"Game Stat should be displayed if applicable"
		asrt.assertTrue(base.isExists(publicgamelistingObj.Ele_LikesStatus("Powers Cheer SVL","ago")), "Game stat is incorrect or not displayed");

	}

	// <summary>
	// Test Case Title : "Verify that when the user click on Up arrow, the games should be sorted as per their recent dates from the current page (eg: if we select page number 1, then the game should be sorted based on that page only)" 
	// Automation ID   : Game Listing_15
	// </summary>

	public void GameListing_15_PublicGameListing() throws InterruptedException 
	{ 
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj publicgamelistingObj = new PublicGameListing_Obj();

		//Step 1   :"Navigate to the SnipBack page"
		//Expected :"User should able to view the SnipBack page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2  :"Click the Film Button"
		//Expected:"User should be navigated to Film Page"
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"The Film Tab is not visible to the User");

		//Step 3  :"Verify that when the user click on Up arrow, the games should be sorted as per their recent dates from the current page"
		//Expected:"User should be able to see the games as per the recent dates"
		asrt.assertTrue(base.isExists(publicgamelistingObj.Ele_SearchField("sort-img option-checked first")),"User not able to see the games as per the recent dates from current page.");

	}  

	// <summary>
	// Test Case Title : "Verify that the user should be able to see the following Options when entering into snipaback website"
	//	1.Home
	//	2.Film
	//	3.Pricing
	//	4.Login button
	// Automation ID : Game Listing_02
	// </summary>
	public void GameListing_02_PublicGameListing() throws InterruptedException 
	{

		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj = new PublicGameListing_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Verify the following options are available in the sinpack page:"1.Home 2.Film 3.Pricing 4.Login
		//expected:"User should able to view the following options in the snipback page:"1.Home 2.Film 3.Pricing 4.Login
		String[] HomeOptions = {"Home", "Film", "Pricing"};

		for (String Option : HomeOptions) 
		{ 
			asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_GameListingoptions(Option)), "User is not able to view the " + Option + " option on the SnipBack page");
		}

		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Login option in the Snipback page");
	}

	// <summary>
	// Test Case Title :"Verify that, a Search Option with searh icon should displayed in the FILM Page"
	// Automation ID   : Game Listing_17
	// </summary>
	public void GameListing_17_PublicGameListing() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		Registration_Obj RegistrationObj = new Registration_Obj();

		//Step 1:"Navigate to the Snipback page "
		//Expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Click on FILM Tab
		//Expected:The user should be able to direct to the FILM page
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"The Film Tab is not visible to the user");

		//Step 3:Verify the Search Option
		//Expected: Search Option with search icon should displayed in the FILM Page
		asrt.assertTrue(base.isExists(RegistrationObj.Edt_Name("Search")),"The Search Option isn't visible to the user");
	}		

	// <summary>
	// Test Case Title : "Verify that the user should be able to click on "FILM" tab without login to snipback" 
	// Automation ID : Game Listing_03
	// </summary>  
	public void GameListing_03_PublicGameListing() throws InterruptedException 
	{

		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj = new PublicGameListing_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Verify the following options are available in the sinpack page:"
		//1.Home 2.Film 3.Pricing 4.Login
		//expected:"User should able to view the following options in the snipback page:"
		//1.Home 2.Film 3.Pricing 4.Login
		String[] HomeOptions = {"Home", "Film", "Pricing"};
		for (String Option : HomeOptions) 
		{ 
			asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_GameListingoptions(Option)), "User is not able to view the " + Option + " option on the SnipBack page");
		}
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Login option in the Snipback page");

	}

	// <summary>
	// Test Case Title : Verify that an option  "See All" should be displayed at the right side of the film page,  if multiple games are available under single date 
	// Automation ID : Game Listing_06
	// </summary>
	public void GameListing_06_PublicGameListing() throws InterruptedException
	{

		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj= new PublicGameListing_Obj();		

		//Step 1: Click on Film tab
		//expected:User should be navigated to 'Film' page
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"User is not able to load the Film page in the snipback page");

		//Step 2:Verify the option 'See All'
		//expected: An option  "See All" should be displayed at the right side of the film page,  if multiple games are available under single date. 
		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_UpDownArrow("myCheckbox1")),"User is not able to view the Up Arrow with Sort By date in the Film page of snipback");
		base.excuteJsClick(PublicGameListingObj.Ele_UpDownArrow("myCheckbox1"));
		Thread.sleep(5000);
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login(" See All ")),"See All is not displayed at the right of the page.");
		
	}   
	// <summary>
	// Test Case Title : "Verify that left and right arrow should be displayed to move left and right side to see all the games, if multiple games are available udner single date." 
	// Automation ID : Game Listing_07
	// </summary>
	public void GameListing_07_PublicGameListing() throws InterruptedException
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();
		//Step 1: Click on Film tab
		//Expected: User should be navigated to 'Film' page
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"User is not able to load the Film page in the snipback page");

		//Step 2: Verify the left and right side arrow
		//Expected: Left and right arrow should be displayed to move left and right side to see all the games, if multiple games are available under single date.
		base.setData(LoginPageObj.Edt_LoginCredentialFields("date_picker"), "02/05/2025");
		Thread.sleep(7000);
		base.buttonClick(PublicGameListingObj.Ele_SearchField("search-img"));
		Thread.sleep(7000);
		base.buttonClick(PublicGameListingObj.Ele_RArrow(" Feb 05 2025"));
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("@ NOVI")),"User is not navigated to the next video.");
		Thread.sleep(1000);
		base.buttonClick(PublicGameListingObj.Ele_LArrow(" Feb 05 2025"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("@ East Alton Wood River")),"User is not navigated to previous video.");   		   
	}


	// <summary>
	// Test Case Title : "Verify that when the user click on Down arrow, the games should be listed as per their former dates from the current pageA" 
	// Automation ID : Game Listing_16
	// </summary>  
	    public void GameListing_16_PublicGameListing() throws InterruptedException 
	    {
	    	
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj=new PublicGameListing_Obj();

		// Step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");  		
		//Step 2:Click on FILM Tab
		//Expected:The user should be able to navigate to FILM page
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"The Film Tab is not visible to the User");
		//Step 3: Click on Down arrow 
		//Expected: When the user click on Down arrow, the games should be listed as per their former dates from the current page
		base.buttonClick(PublicGameListingObj.Ele_SearchField("sort-img second"));
		Thread.sleep(1000);
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("mainHead")), "The games are not listed as per their former dates from the current page");
	}


	// <summary>
	// Test Case Title : "Verify whether the user is able to view the Sort By Date option along with Up arrow and Down arrow in Film page of snipback" 
	// Automation ID : Game Listing_12
	// </summary>		  		  
	public void GameListing_12_PublicGameListing() throws InterruptedException 
	{

		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj = new PublicGameListing_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Verify the following options are available in the sinpack page:"
		//1.Home 2.Film 3.Pricing 4.Login
		//expected:"User should able to view the following options in the snipback page:"
		//1.Home 2.Film 3.Pricing 4.Login
		String[] HomeOptions = {"Home", "Film", "Pricing"};
		for (String Option : HomeOptions) 
		{ 
			asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_GameListingoptions(Option)), "User is not able to view the " + Option + " option on the SnipBack page");
		}
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Login option in the Snipback page");

		// step 3:"Verify the user is able to click on Film tab without login to snipback "
		//expected:"User should able to click on Film tab without login to snipback page"
		base.buttonClick(PublicGameListingObj.Ele_GameListingoptions("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"The Film Tab is not visible to the User");

		
		// step 4:"Verify the user is able to view the Sort By Date option along with Up arrow and Down arrow in Film page of snipback "
		//expected:"User should able to view the user is able to view the Sort By Date option along with Up arrow and Down arrow in Film page of snipback"
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_AlertText("Sort by Date")),"User is not able to view the Sort By Date option in the Film page of snipback");
		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_UpDownArrow("myCheckbox1")),"User is not able to view the Up Arrow with Sort By date in the Film page of snipback");
		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_UpDownArrow("myCheckbox2")),"User is not able to view the Down Arrow with Sort By date in the Film page of snipback");

	} 

	// <summary>
	// Test Case Title : "Verify that the user should be able to see only the public games after entering into FILM page" 
	// Automation ID : Game Listing_04
	// </summary>		  
	public void GameListing_04_PublicGameListing() throws InterruptedException 
	{

		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj = new PublicGameListing_Obj();

		// step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		// step 2:"Verify the following options are available in the sinpack page:"
		//1.Home 2.Film 3.Pricing 4.Login
		//expected:"User should able to view the following options in the snipback page:"
		//1.Home 2.Film 3.Pricing 4.Login
		String[] HomeOptions = {"Home", "Film", "Pricing"};
		for (String Option : HomeOptions) 
		{ 
			asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_GameListingoptions(Option)), "User is not able to view the " + Option + " option on the SnipBack page");
		}
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Login option in the Snipback page");

		// step 3:"Verify the user is able to click on Film tab without login to snipback "
		//expected:"User should able to able to click on Film tab without login to snipback page"
		base.excuteJsClick(PublicGameListingObj.Ele_GameListingoptions("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"User is not able to load the Film page in the snipback page");

		// step 4:"Verify the user is able to view the public game in Film page of snipback "
		//expected:"User should able to able to view the public game in Film page of snipback"
		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_UpDownArrow("myCheckbox1")),"User is not able to view the Up Arrow with Sort By date in the Film page of snipback");
		base.excuteJsClick(PublicGameListingObj.Ele_UpDownArrow("myCheckbox1"));
		Thread.sleep(5000);
		base.scrollToElement(PublicGameListingObj.Ele_PublicGames(" Feb 06 2025"));
		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_PublicGames(" Feb 06 2025")),"User is not able to view the Public Games in the Film page of snipback");

	}   

	// <summary>
	// Test Case Title : "Verify that an option Filter by date (MM/DD/YYYY) for filter the games should be displayed" 
	// Automation ID : Game Listing_09
	// </summary>  
	public void GameListing_09_PublicGameListing() throws InterruptedException 
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();

		// Step 1:"Navigate to the snipback page "
		//expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");  		
		//Step 2:Click on FILM Tab
		//Expected:The user should be able to navigate to FILM page
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"The Film Tab is not visible to the User");
		//Step 2:Verify the Option "Filter by date"
		//Expected:The option Filter by date (MM/DD/YYYY) for filter the games should be displayed
		asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("date_picker")),"The user unable to see the Option Filter by date (MM/DD/YYYY) for filter the games ");
	}


	// <summary>
	// Test Case Title :"Verify that the user should be able to watch the game when click the games in the FILM Page"
	// Automation ID   : Game Listing_19
	// </summary>
	public void GameListing_19_PublicGameListing() throws InterruptedException
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj = new PublicGameListing_Obj();

		//Step 1:"Navigate to the snipback page "
		//Expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Click on FILM Tab
		//Expected:The user should be able to direct to the FILM page
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"The Film page is not visible to the User");


		//Step 3:Click on games
		//Expected:User should be able to watch the game when we click the games in the FILM Page
		base.buttonClick(PublicGameListingObj.Img_GameClick("lazy"));
		//asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("block-title payFullVideo")),"User should not be able to watch the game when we click the games in the FILM Page");
		//Cannot inspect the element without logging in
	}	

	// <summary>
	// Test Case Title : Verify that pagination should be displayed at the bottom of the FILM page while scrolling to view the games
	// Automation ID   : Game Listing_13
	// </summary>

	public void GameListing_13_PublicGameListing() throws InterruptedException
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj = new PublicGameListing_Obj();

		//Step 1:"Navigate to the snipback page "
		//Expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Click on FILM Tab
		//Expected:The user should be able to direct to the FILM page
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"The Film page is not visible to the User");

		//Step 3: Scroll down the page
		//Expected: Pagination should be displayed at the bottom of the FILM page while scrolling to view the games 
		asrt.assertTrue(base.isExists(PublicGameListingObj.Ele_UpDownArrow("myCheckbox1")),"User is not able to view the Up Arrow with Sort By date in the Film page of snipback");
		base.excuteJsClick(PublicGameListingObj.Ele_UpDownArrow("myCheckbox1"));
		Thread.sleep(5000);
		base.scrollToElement(LoginPageObj.Ele_ErrorMessage("pagination"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("pagination")),"The pagination is not visible to the user while scrolling down in the Flim module.");

	}

	// <summary>
	// Test Case Title :"Verify that the user should be able to fetch the proper results while searching any games in the serach tab and click on search icon"
	// Automation ID   : Game Listing_18
	// </summary>

	public void GameListing_18_PublicGameListing() throws InterruptedException
	{
		LoginPage_Obj LoginPageObj = new LoginPage_Obj();
		PublicGameListing_Obj PublicGameListingObj = new PublicGameListing_Obj();
		PublicGameListing_TestData PublicGameTestData = new PublicGameListing_TestData();

		//Step 1:"Navigate to the snipback page "
		//Expected:"User should able to view the Snipback page"
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Login")),"User is not able to view Snipback page");

		//Step 2:Click on FILM Tab
		//Expected:The user should be able to direct to the FILM page
		base.buttonClick(LoginPageObj.Btn_Login("Film"));
		asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Film")),"The Film page is not visible to the User");

		//Step 3:Search any games in the search tab
		//Expected: User should be able to fetch the proper results while searching any games in the serach tab and click on search icon.
		base.setData(LoginPageObj.Edt_LoginEmail("search"),PublicGameTestData.GameListing_18_SearchField);
		base.buttonClick(PublicGameListingObj.Ele_SearchField("search-img"));
		asrt.assertTrue(base.isExists(LoginPageObj.Ele_ErrorMessage("subcontent")),"The searched game is not visible to the user in the film module");

	}
}



