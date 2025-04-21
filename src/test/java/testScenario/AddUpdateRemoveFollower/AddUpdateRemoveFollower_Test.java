package testScenario.AddUpdateRemoveFollower;
import org.testng.annotations.Test;
import testPage.MavenPageObject.AddUpdateRemoveFollower;
import utilPack.BaseTest;

public class AddUpdateRemoveFollower_Test extends BaseTest 
{	
	@Test()
	public void Follower_01_AddUpdateRemoveFollowerTest() throws Exception 
	{		
		AddUpdateRemoveFollower addupdateremovefollower=new AddUpdateRemoveFollower(getDriver());
		addupdateremovefollower.Follower_01_AddUpdateRemoveFollower();	
	}
}
