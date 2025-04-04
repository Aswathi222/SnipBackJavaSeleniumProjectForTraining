package testScenario.CreateEditDeletePool;
import org.testng.annotations.Test;

import testPage.MavenPageObject.CreateEditDeletePool;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class CreateEditDeletePool_Test extends BaseTest 
{	
	@Test()
	public void TC07_CreateEditDeletePoolTest() throws Exception 
	{	
		CreateEditDeletePool createEditDeletePoolTest = new CreateEditDeletePool(getDriver());
		createEditDeletePoolTest.TC07_CreateEditDeletePool();			
	}
	@Test()
	public void TC06_CreateEditDeletePoolTest() throws Exception 
	{	
		CreateEditDeletePool createEditDeletePoolTest = new CreateEditDeletePool(getDriver());
		createEditDeletePoolTest.TC06_CreateEditDeletePool();			
	}
	@Test()
	public void TC05_CreateEditDeletePoolTest() throws Exception 
	{	
		CreateEditDeletePool createEditDeletePoolTest = new CreateEditDeletePool(getDriver());
		createEditDeletePoolTest.TC05_CreateEditDeletePool();			
	}
	@Test()
	public void TC04_CreateEditDeletePoolTest() throws Exception 
	{	
		CreateEditDeletePool createEditDeletePoolTest = new CreateEditDeletePool(getDriver());
		createEditDeletePoolTest.TC04_CreateEditDeletePool();			
	}
	@Test()
	public void TC03_CreateEditDeletePoolTest() throws Exception 
	{	
		CreateEditDeletePool createEditDeletePoolTest = new CreateEditDeletePool(getDriver());
		createEditDeletePoolTest.TC03_CreateEditDeletePool();			
	}
	@Test()
	public void TC02_CreateEditDeletePoolTest() throws Exception 
	{	
		CreateEditDeletePool createEditDeletePoolTest = new CreateEditDeletePool(getDriver());
		createEditDeletePoolTest.TC02_CreateEditDeletePool();			
	}
	@Test
	public void TC01_CreateEditDeletePoolTest() throws Exception 
	{	
		CreateEditDeletePool createEditDeletePoolTest = new CreateEditDeletePool(getDriver());
		createEditDeletePoolTest.TC01_CreateEditDeletePool();			
	}		
}
