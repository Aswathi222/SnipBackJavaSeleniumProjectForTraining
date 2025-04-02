package testPage.MavenPageObject;
import TestData.SnipBackLogin_TestData;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import TestData.CommonData;
import objectRepository.LoginPage_Obj;
import objectRepository.SnipBackLogin_Obj;
import utilPack.BasePge;
public class SnipBackLogin extends BasePge{

	BasePge base;
	Assert asrt;

	public SnipBackLogin(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}
	///<summary>
	///Testcase Title:Verify whether the user can be able to  login 
	///Automation ID:TC_01
	///</summary>
    public void SH_SnipBackLogin_TC01() {
    
    	SnipBackLogin_Obj SnipBackLoginObj=new SnipBackLogin_Obj();
    	
    	 //Step 1:Go to Snipback website
    	 //Step 2:Click Login button
    	//Expected:User should able to click login  button
    	base.buttonClick(SnipBackLoginObj.Btn_Login("Login"));
    	asrt.assertTrue(base.isExists(SnipBackLoginObj.Btn_Signin("SIGN IN")), "User shouldnot be able to click login  button");
    	
    }
	
}



