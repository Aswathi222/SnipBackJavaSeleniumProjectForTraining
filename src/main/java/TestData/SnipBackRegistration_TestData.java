package TestData;

public class SnipBackRegistration_TestData 
{
	// TC01_Registration
	public static String TC01_RegistrationInvalidName="";	
	public static String TC01_RegistrationInvalidCharName="Tintu89";
	public static String TC01_RegistrationValidName="TINTU";

	//TC02_Registration
	public static String TC02_RegistrationValidEmail="neethumahendran5@gmail.com";	
	public static String TC02_RegistrationInvalidEmail= "angle89maildrop#.cc";
	public static String TC02_RegistrationEmailEmpty="";
	public static String TC02_RegistrationExtraEmail="angle @maildrop,cc";
	public static String TC02_RegistrationExistEmail="tintu89@maildrop.cc";
	public static String TC02_RegistrationValidUsername="MANASI";
	public static String TC02_RegistrationPassword="Tigerscott@123";
	public static String TC02_RegistrationValidName="TINTU";

	//TC03_Registration
	public static String TC03_RegistrationUsername="tintu<>";
	public static String TC03_RegistrationExeedUsername="qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvb2345eyegbdbhhjd";
	public static String TC03_RegistrationValidUsername="angle$88#";
	public static String TC03_registrationvalidemail="neethumahendran@gmail.com";
	public static String TC03_RegistrationValidName="TINTU";
	public static String TC03_RegistrationPassword="Tigerscott@123";
	public static String TC03_RegistrationTrimName="TINTU TOM";

	//TC04_Registration
	public static String TC04_RegistrationPasswrdMin="Test";
	public static String TC04_RegistrationUpperLower="Testones";
	public static String TC04_RegistartionNumber="12345678";
	public static String TC04_RegistrationSpecialNotAllowed="@#$%^&*()";
	public static String TC04_RegistrationSpecialAllowed="Test@";
	public static String TC04_RegistrationEnteredPassword="Test@1234";
	public static String TC04_RegistrationConfirmPassword="Test@123";
	public static String TC04_RegistrationEmptyPassword="";
	public static String TC04_RegistrationValidPassword="Test@1234";
	public static String TC04_RegistrationValidName="TINTU";
	public static String TC04_registrationvalidemail="neethumahendran@gmail.com";
	public static String TC04_RegistrationValidUsername="anglestar";

	//TC05_Registration
	public static String TC05_RegistrationConfirmPasswordMin="Test";
	public static String TC05_RegistrationUpperLowerPassword="Testones";
	public static String TC05_RegistrationConfirmPasswordNumber="12345678";
	public static String TC05_RegistrationAllowedSpecial="Test@";
	public static String TC05_RegistrationNotAllowedSpecial="@#$%^&*()";
	public static String TC05_RegistrationConfirmPasswordCorrect="Test@1234";
	public static String TC05_RegistrationEnteredPassword="Test@123";
	public static String TC05_RegistrationBlankConfirmPassword="";
	public static String TC05_RegistrationValidName="TINTUSAM";
	public static String TC05_registrationvalidemail="neethumahendran@gmail.com";
	public static String TC05_RegistrationValidUsername="ANGEL";

}


