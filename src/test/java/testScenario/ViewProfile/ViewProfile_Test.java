package testScenario.ViewProfile;
import org.testng.annotations.Test;
import testPage.MavenPageObject.ViewProfile;
import utilPack.BaseTest;

public class ViewProfile_Test extends BaseTest 

{	
	@Test()
	public void TC01_ViewProfileTest() throws Exception 
	{	
		ViewProfile viewprofile = new ViewProfile(getDriver());
		viewprofile.TC01_ViewProfile();
	}
	@Test()
	public void TC02_ViewProfileTest() throws Exception 
	{	
		ViewProfile viewprofile = new ViewProfile(getDriver());
		viewprofile.TC02_ViewProfile();
	}
}
