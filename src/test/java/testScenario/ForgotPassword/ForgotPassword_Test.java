package testScenario.ForgotPassword;
import org.testng.annotations.Test;
import testPage.MavenPageObject.ForgotPassword;
import utilPack.BaseTest;

public class ForgotPassword_Test extends BaseTest 
{	
	@Test()
	public void FP01_ForgotPasswordTest() throws Exception 
	{	
		ForgotPassword ForgotPassword = new ForgotPassword(getDriver());
		ForgotPassword.FP01_ForgotPassword();			
	}
	@Test()
	public void FP02_ForgotPasswordTest() throws Exception 
	{	
		ForgotPassword ForgotPassword = new ForgotPassword(getDriver());
		ForgotPassword.FP02_ForgotPassword();			
	}

	public void FP03_ForgotPasswordTest() throws Exception 
	{	
		ForgotPassword ForgotPassword = new ForgotPassword(getDriver());
		ForgotPassword.FP03_ForgotPassword();			
	}

}
