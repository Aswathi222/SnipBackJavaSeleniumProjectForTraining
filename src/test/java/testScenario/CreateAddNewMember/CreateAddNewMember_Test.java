package testScenario.CreateAddNewMember;
import org.testng.annotations.Test;
import testPage.MavenPageObject.CreateAddNewMember;
import testPage.MavenPageObject.SnipBackLogin;
import testPage.MavenPageObject.SocialMediaSignIn;
import utilPack.BaseTest;

public class CreateAddNewMember_Test extends BaseTest
{	
	@Test()
	public void TC01_CreateAddNewMember() throws Exception
	{	
		CreateAddNewMember CreateNew = new CreateAddNewMember(getDriver());
		CreateNew.TC01_CreateAddNewMember();	
	}
	
	@Test()
	public void TC02_CreateAddNewMember() throws Exception
	{	
		CreateAddNewMember CreateNew = new CreateAddNewMember(getDriver());
		CreateNew.TC02_CreateAddNewMember();	
	}
}
