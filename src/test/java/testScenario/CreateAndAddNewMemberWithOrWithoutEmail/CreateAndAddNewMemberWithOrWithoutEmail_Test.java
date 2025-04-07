package testScenario.CreateAndAddNewMemberWithOrWithoutEmail;

import org.testng.annotations.Test;
import testPage.MavenPageObject.CreateAndAddNewMemberWithOrWithoutEmail;
import utilPack.BaseTest;

public class CreateAndAddNewMemberWithOrWithoutEmail_Test extends BaseTest 
{	
	@Test()
	public void WE01_CreateAndAddNewMemberWithOrWithoutEmailTest() throws Exception 
	{	
		testPage.MavenPageObject.CreateAndAddNewMemberWithOrWithoutEmail CreateandAddnewmemberwithorwithoutEmail = new CreateAndAddNewMemberWithOrWithoutEmail(getDriver());
		CreateandAddnewmemberwithorwithoutEmail.WE01_CreateAndAddNewMemberWithOrWithoutEmail();			
	} 
}
