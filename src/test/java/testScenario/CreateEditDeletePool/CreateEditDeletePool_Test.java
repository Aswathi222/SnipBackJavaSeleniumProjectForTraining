package testScenario.CreateEditDeletePool;
import org.testng.annotations.Test;

import testPage.MavenPageObject.CreateEditDeletePool;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class CreateEditDeletePool_Test extends BaseTest 
{	
	@Test()
	public void TC_01_CreateEditDeletePool() throws Exception 
	{	
		CreateEditDeletePool createEditDeletePoolTest = new CreateEditDeletePool(getDriver());
		createEditDeletePoolTest.TC_01_CreateEditDeletePool();			
	}		
}
