package testScenario.TeamInviteLink;

import org.testng.annotations.Test;
import testPage.MavenPageObject.CreateAndAddNewMemberWithOrWithoutEmail;
import testPage.MavenPageObject.TeamInviteLink;
import utilPack.BaseTest;

public class TeamInviteLink_Test extends BaseTest 
{	
	@Test()
	public void Invitelink_01_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink TeamInviteLink = new TeamInviteLink(getDriver());
		TeamInviteLink.Invitelink_01_TeamInviteLink();			
	}
	@Test()
	public void Invitelink_02_TeamInviteLinkTest() throws Exception 
	{	
		TeamInviteLink TeamInviteLink = new TeamInviteLink(getDriver());
		TeamInviteLink.Invitelink_02_TeamInviteLink();			
	} 
}
