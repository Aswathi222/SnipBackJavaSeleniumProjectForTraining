package testScenario.Pool;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestData.CommonData;
import testPage.MavenPageObject.Login;
import testPage.MavenPageObject.Pool;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class Pool_Test extends BaseTest 
{		

	@Test()
	public void TC_06_CreateEditDeletePoolTest() throws Exception 
	{	
		Pool pool =new Pool(getDriver());
		pool.TC_06_CreateEditDeletePool();
	}

	@Test()
	public void TC_07_CreateEditDeletePoolTest() throws Exception 
	{	
		Pool pool=new Pool(getDriver());
		pool.TC_07_CreateEditDeletePool();
	}	
  
	@Test()
	public void TC_05_CreateEditDeletePoolTest() throws Exception 
	{	
		Pool pool=new Pool(getDriver());
		pool.TC_05_CreateEditDeletePool();
	}	

	@Test()
	public void TC_02_CreateEditDeletePoolTest() throws Exception 
	{	
		Pool pool=new Pool(getDriver());
		pool.TC_02_CreateEditDeletePool();
  }
  
  @Test()
	public void TC_01_CreateEditDeletePoolTest() throws Exception 
	{	
		Pool pool=new Pool(getDriver());
		pool.TC_01_CreateEditDeletePool();
	}
  @Test()
	public void TC_03_CreateEditDeletePoolTest() throws Exception 
	{	
		Pool pool=new Pool(getDriver());
		pool.TC_03_CreateEditDeletePool();
	}

  @Test()
  public void TC_04_CreateEditDeletePoolTest() throws Exception
  {
	  Pool pool=new Pool(getDriver());
	  pool.TC_04_CreateEditDeletePool();
  }
  @Test
  public void TC_10_CreateEditDeletePoolTest() throws Exception
  {
	  Pool pool=new Pool(getDriver());
	  pool.TC_10_CreateEditDeletePool();
  }
  @Test
  public void TC_11_CreateEditDeletePoolTest() throws Exception
  {
	  Pool pool=new Pool(getDriver());
	  pool.TC_11_CreateEditDeletePool();
  }
  @Test
  public void TC_08_CreateEditDeletePoolTest() throws Exception
  {
	  Pool pool=new Pool(getDriver());
	  pool.TC_08_CreateEditDeletePool();
  }
  
  @Test()
 	public void TC_09_CreateEditDeletePoolTest() throws Exception 
 	{	
 		Pool pool=new Pool(getDriver());
 		pool.TC_09_CreateEditDeletePool();
 	}
  
}
