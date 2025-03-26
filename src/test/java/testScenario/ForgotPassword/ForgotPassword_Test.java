package testScenario.ForgotPassword;
import org.testng.annotations.Test;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class ForgotPassword_Test extends BaseTest 
{	
	@Test()
	public void FP_1_ForgotPasswordTest() throws Exception 
	{	
		ForgotPassword ForgotPassword = new ForgotPassword(getDriver());
		ForgotPassword.FP_1_ForgotPassword();			
	}
	@Test()
	public void FP_3_ForgotPasswordTest() throws Exception 
	{	
		ForgotPassword ForgotPassword = new ForgotPassword(getDriver());
		ForgotPassword.FP_3_ForgotPassword();			
	}
}
