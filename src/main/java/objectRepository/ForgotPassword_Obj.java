package objectRepository;

import org.openqa.selenium.By;

public class ForgotPassword_Obj {	
	//Ele
	public By Ele_ResetPasswordHeading(String text) {return By.xpath("//b[text()='"+text+"']");}
	public By Ele_Error(String text) {return By.xpath("//span[@class='"+text+"']");}
	public By Ele_MailSentMessage(String text) {return By.xpath("//span[text()='"+text+"']");}
}

