package testPage.MavenPageObject;
import TestData.ForgotPassword_TestData;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import TestData.CommonData;
import objectRepository.LoginPage_Obj;
import objectRepository.Registration_Obj;
import objectRepository.ForgotPassword_Obj;
import utilPack.BasePge;
public class ForgotPassword extends BasePge{

	BasePge base;
	Assert asrt;

	public ForgotPassword(WebDriver driver) {
		super(driver);
		base = new BasePge(driver);
	}

	// <summary>
		// Test Case Title : Verify that entering an unregistered email displays an appropriate error message.
		// Automation ID : FP-4
		// </summary>
		public void FP_4_ForgotPassword() {
			ForgotPassword_TestData ForgotPasswordTestData=new ForgotPassword_TestData();
			Registration_Obj RegistrationObj=new Registration_Obj();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();

			//Step 1: Click on Login Button
			//Expected: Signin window should be displayed
			base.buttonClick(LoginPageObj.Btn_Login("Login"));
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Forgot password?")), "User unable to navigate to login page");
			
			//Step 2: Click on ForgotPassword text
			//Expected: Redirected to ForgotPassword page
			base.buttonClick(LoginPageObj.Btn_Login("Forgot password?"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("forgot-email")),"User unable to navigate to Forgot Password page");
			
			//Step 3: Enter email address which is not signedup in the email address field
			//Expected: entered email address visible in text field
			base.setData(LoginPageObj.Edt_LoginEmail("forgot-email"), ForgotPasswordTestData.FP_4_ForgotPasswordUnregistereddEmail);
			String Email= base.GetValue(LoginPageObj.Edt_LoginEmail("forgot-email"));
			asrt.assertEquals(Email, ForgotPasswordTestData.FP_4_ForgotPasswordUnregistereddEmail,"entered email address is not visible in text field");
			
			//Step 4: Click submit button
			//Expected: One-time passcode page should be visible with the text "User not found."
			base.buttonClick(LoginPageObj.Btn_SingnIn("forgot-submit"));
			asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("forgot-result")),"One-time passcode pagein not visible with the text (User not found)");
		}

		// <summary>
		// Test Case Title : Ensure that the user is required to enter a valid email address in the "Forgot Password" field
		// Automation ID : FP-2
		// </summary>
		public void FP_2_ForgotPassword() {
			ForgotPassword_TestData ForgotPasswordTestData=new ForgotPassword_TestData();
			Registration_Obj RegistrationObj=new Registration_Obj();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();

			//Step 1: Click on Login Button
			//Expected: Signin window should be displayed
			base.buttonClick(LoginPageObj.Btn_Login("Login"));
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Forgot password?")), "User unable to navigate to login page");
			
			//Step 2: Click on ForgotPassword text
			//Expected: Redirected to ForgotPassword page
			base.buttonClick(LoginPageObj.Btn_Login("Forgot password?"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("forgot-email")),"User unable to navigate to Forgot Password page");
			
			//Step 3: Enter invalid email address in the email address field
			//Expected: entered email address visible in text field
			base.setData(LoginPageObj.Edt_LoginEmail("forgot-email"), ForgotPasswordTestData.FP_2_ForgotPasswordInvalidEmail);
			
			//Step 4: Click submit button
			//Expected: Error message should be visible(Please enter the valid email, the invalid characters are &/\#,+()$~%.^':*?<>{}")
			base.buttonClick(LoginPageObj.Btn_SingnIn("forgot-submit"));
			asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpMinConfPassword("commonValidateErr active")),"User is able to enter invalid emailaddress");
		}

		// <summary>
		// Test Case Title : "Verify that entering a valid registered email sends a password reset link.
		// Automation ID : FP-3
		// </summary>
		public void FP_3_ForgotPassword() {
			ForgotPassword_TestData ForgotPasswordTestData=new ForgotPassword_TestData();
			Registration_Obj RegistrationObj=new Registration_Obj();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();

			//Step 1: Click on Login Button
			//Expected: Signin window should be displayed
			base.buttonClick(LoginPageObj.Btn_Login("Login"));
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Forgot password?")), "User unable to navigate to login page");
			
			//Step 2: Click on ForgotPassword text
			//Expected: Redirected to ForgotPassword page
			base.buttonClick(LoginPageObj.Btn_Login("Forgot password?"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("forgot-email")),"User unable to navigate to Forgot Password page");
			
			//Step 3: Enter valid email address in the email address field
			//Expected: entered email address visible in text field
			base.setData(LoginPageObj.Edt_LoginEmail("forgot-email"), ForgotPasswordTestData.FP_3_ForgotPasswordValidEmail);
			
			//Step 4: Click submit button
			//Expected: One-time passcode page should be visible with the text "A one-time passcode has been sent to your registered email address. Please check your inbox."
			base.buttonClick(LoginPageObj.Btn_SingnIn("forgot-submit"));
			asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("otp-result")),"User is not sent a One-time passcode to reset password");
		}

		// <summary>
		// Test Case Title : "Verify that the user can navigate to the "Forgot Password" icon from the login page.
		// Automation ID : FP-1
		// </summary>
		public void FP_1_ForgotPassword() throws InterruptedException {

			ForgotPassword_TestData ForgotPasswordTestData=new ForgotPassword_TestData();
			LoginPage_Obj LoginPageObj = new LoginPage_Obj();

			//Step 1:"Navigate to the Homepage
			//Expected:The Home Page should be displayed
			base.buttonClick(LoginPageObj.Btn_Login("Login"));
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_SingnIn("login_submit")));

			//Step 2: Click on Forgot Password Link
			//Expected: Redirected to Forgot Password Page
			base.buttonClick(LoginPageObj.Btn_Login("Forgot password?"));
			Thread.sleep(2000);
			String CurrentURL=driver.getCurrentUrl();
			Assert.assertEquals(ForgotPasswordTestData.FP_1_ForgotPasswordURL, CurrentURL,"User unable to navigate to the Forgot Password page");	
		}	

		// <summary>
		// Test Case Title : "Ensure that the one time password is valid.." 
		// Automation ID : FP_5_ForgotPassword
		// </summary>
		public void FP_5_ForgotPassword() throws InterruptedException 
		{
			ForgotPassword_Obj ForgotPasswordObj = new ForgotPassword_Obj();	       
			Registration_Obj RegistrationObj= new Registration_Obj();
			LoginPage_Obj LoginPageObj=new LoginPage_Obj();

			//step 1:"Navigate to the Homepage"
			//expected: User should be navigated to Homepage  		      					
			base.buttonClick(LoginPageObj.Btn_Login("Login"));
			asrt.assertTrue(base.isExists(LoginPageObj.Btn_Login("Forgot password?")),"User cannot naviagate to the login page");

			//step 2: Click on Forgot Password link
			//expected:User should be navigated to Reset Password page
			base.buttonClick(LoginPageObj.Btn_Login("Forgot password?"));
			asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("forgot-email")),"Reset Password page is not displayed");

			//step 3: Enter Email address in field 
			//expected: user should be able to enter the email address
			base.setData(LoginPageObj.Edt_LoginEmail("forgot-email"), ForgotPassword_TestData.FP_3_ForgotPasswordValidEmail);
			String Email= base.GetValue(LoginPageObj.Edt_LoginEmail("forgot-email"));
			asrt.assertEquals(Email,ForgotPassword_TestData.FP_3_ForgotPasswordValidEmail,"Please enter a valid email address.");

			//step 4:Click on Submit button
			//expected: user should be able to view a message that Reset password link sucessfully sent to your Email
			base.buttonClick(LoginPageObj.Btn_SingnIn("forgot-submit"));
			asrt.assertTrue(base.isExists(RegistrationObj.Edt_SignUpPopupPassword("forgot-result-success")),"Unable to view the message Reset password link sucessfully sent to your Email");
  
//			//step 5:Enter OTP in field.
//			//expected:User should be able to enter the OTP
//			base.setData(LoginPageObj.Edt_LoginEmail("forgot-otp"),ForgotPassword_TestData.FP_5_ForgotPasswordOtp1);
//			asrt.assertTrue(base.isExists(LoginPageObj.Edt_LoginEmail("forgot-otp")),"Please enter a valid OTP");

		}
}	

