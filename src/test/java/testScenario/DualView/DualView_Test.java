package testScenario.DualView;

import org.testng.annotations.Test;

import testPage.MavenPageObject.DualView;
import utilPack.BaseTest;

public class DualView_Test extends BaseTest 
{		
	@Test()
	public void DV_1_DualViewTest() throws Exception 
	{	
		DualView dualView = new DualView(getDriver());	
		dualView.DV_1_DualView();
	}
	@Test()
	public void DV_2_DualViewTest() throws Exception 
	{	
		DualView dualView = new DualView(getDriver());	
		dualView.DV_2_DualView();
	}
}
