package testScenario.SnipBackLogin;
import org.testng.annotations.Test;

import testPage.MavenPageObject.SnipBackLogin;
import utilPack.BaseTest;


public class SnipBackLogin_Test extends BaseTest 

{	

	
	@Test()
	public void TC01_SH_LoginTest() throws Exception 
	{	
		SnipBackLogin SnipBacklogin = new SnipBackLogin(getDriver());
		SnipBacklogin.SH_SnipBackLogin_TC01();		
	}

	@Test()
	public void TC02_SH_LoginTest() throws Exception 
	{	
		SnipBackLogin SnipBacklogin = new SnipBackLogin(getDriver());
		SnipBacklogin.SH_SnipBackLogin_TC02();		
	}

}
