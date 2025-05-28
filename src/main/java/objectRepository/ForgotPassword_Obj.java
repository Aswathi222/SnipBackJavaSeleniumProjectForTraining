package objectRepository;

import org.openqa.selenium.By;

public class ForgotPassword_Obj {
		//Ele
	public By Ele_ResetPassword(String pswdtext) { return By.xpath("//b[text()='"+pswdtext+"']"); }
	public By Ele_ValidationError(String validationmessage) { return By.xpath(" //span[@class='"+validationmessage+"'] "); }
	
}
