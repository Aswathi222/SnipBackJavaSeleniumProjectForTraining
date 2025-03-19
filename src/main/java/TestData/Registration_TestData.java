package TestData;

public class Registration_TestData {

	//TC01_Registration
	public static String TC01_RegistrationName1 = "TINTU";
	public static String TC01_RegistrationSpecialCharacters="TC01@";		
	
	//TC02_Registration
	public static String TC02_RegistrationEmailField="angle89@maildrop.cc";
	public static String TC02_RegistrationIInvalidEmailId="angle89maildrop.cc";
	public static String TC02_RegistrationBlankEmailId=" ";
	public static String TC02_RegistrationInvalidEmailData="angle @maildrop.cc, angle@maildrop,cc";
	public static String TC02_RegistrationExistEmail=" tintu89@maildrop.cc";
	public static String TC02_Registrationusername = "tc02registration@11";
	public static String TC02_Registrationpassword = "Password@123";
	public static String TC02_RegistrationConfirmPassword="Password@123";
	
	//TC03_Registration
	public static String TC03_RegistrationName = "TCNameRegistration";
	public static String TC03_RegistrationEmailId = "TC03Registration_@gmail.com";
	public static String TC03_RegistrationInvalidUsername = "tintu<>";
	public static String TC03_RegistrationExceedUsername = "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvb2345";
	public static String TC03_RegistrationAlphanumericUsername ="angle$88#";
	public static String TC03_RegistrationPassword = "TC03@Registration";
	public static String TC03_RegistrationConfirmPassword = "TC03@Registration";
	public static String TC03_RegistrationExistingUser = "tintu89";
	public static String TC03_RegistrationWhitespaceUsername = "Angle $88";


	//TC04_Registration
	public static String TC04_RegistrationName1 = "TCRegistrationName";
	public static String TC04_RegistrationEmail1 = "TC04RegistrationEmail1@gmail.com"; 
	public static String TC04_RegistrationWeakPassword = "password";//Password with only LowerCase letters
	public static String TC04_RegistrationNodigitPassword ="Password@";//Password with no digit
	public static String TC04_RegistartionValidPassword = "Password@123"; //Valid Password(contains UpperCase, LowerCase, Digit & Special characters
	public static String TC04_RegistrationPassword = "Test"; 

	//TC05_Registration
	public static String TC05_Registrationname = "Registrationname";
	public static String TC05_Registrationemail = "tc05registration@gmail.com";
	public static String TC05_Registrationusername = "tc05registration@11";
	public static String TC05_Registrationpassword = "TC05Registrationpassword@123";
	public static String TC05_Registrationminconfirmpassword = "reg";
	public static String TC05_RegistrationSameconfirmpassword = "TCRegistrationpasword@12";

	//TC07_Registration	
	public static String TC07_RegistrationOneTimePassWordName = "TCOneTimePassWordName";
	public static String TC07_RegistrationOneTimePassWordEmail = "TC07OneTimePassWordEmail@gmail.com";
	public static String TC07_RegistrationOneTimePassWordUserName= "TC07OneTimePassWord_UserName";
	public static String TC07_RegistrationOneTimePassWord = "Password2831$";
	public static String TC07_RegistrationOneTimePasswordInvalidOtp = "hWyM5U";

	//TC06_Registration
	public static String  TC06_RegistrationTermsandConditionsName = "TCRegistrationTermsandConditionsName";
	public static String  TC06_RegistrationTermsandConditionsEmail = "TC06_RegistrationTermsandConditionsEmail@gmail.com";
	public static String  TC06_RegistrationTermsandConditionsUserName= "TC06_RegistrationTermsandConditionsUserName";
	public static String  TC06_RegistrationTermsandConditionsPassWord = "Password992831$";
	
	public static String  SignUp01_ValidName = "TestScenarioSignUp";
	public static String  SignUp01_ValidEmail = "signup@gmail.com";
	public static String  SignUp01_ValidUserName = "ValidTestScenarioSignUp";
	public static String  SignUp01_Password = "Password@123";
	public static String  SignUp01_ConfirmPassword = "Password@123";
}


