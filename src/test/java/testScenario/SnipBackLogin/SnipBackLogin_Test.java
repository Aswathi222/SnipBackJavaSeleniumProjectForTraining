package testScenario.SnipBackLogin;
import org.testng.annotations.Test;

import testPage.MavenPageObject.SnipBackLogin;
import utilPack.BaseTest;


public class SnipBackLogin_Test extends BaseTest 

{	

	@Test()
	public void TC04_LoginTest() throws Exception 
	{	
		SnipBackLogin snipbacklogin = new SnipBackLogin(getDriver());	
		snipbacklogin.TC04_Login();			
	}

	@Test()
	public void TC01_LoginTest() throws Exception 
	{	
		SnipBackLogin snipBackLogin= new SnipBackLogin(getDriver());
		snipBackLogin.TC01_Login();
	}

	@Test()
	public void TC08_LoginTest() throws Exception 
	{	
		SnipBackLogin snipBackLogin = new SnipBackLogin(getDriver());	
		snipBackLogin.TC08_Login();
	}

	@Test()
	public void TC03_LoginTest() throws Exception 
	{
		SnipBackLogin SnipBacklogin = new SnipBackLogin(getDriver());
		SnipBacklogin.TC03_Login();
	}
	
	@Test()
	public void TC05_LoginTest() throws Exception 
	{	
		SnipBackLogin SnipBacklogin = new SnipBackLogin(getDriver());
		SnipBacklogin.TC05_Login();			
	}

	@Test()
	public void TC06_LoginTest() throws Exception 
	{	
		SnipBackLogin SnipBacklogin = new SnipBackLogin(getDriver());
		SnipBacklogin.TC06_LoginTest();		
	}

}
