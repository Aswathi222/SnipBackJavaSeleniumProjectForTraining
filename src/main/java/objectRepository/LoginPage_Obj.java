package objectRepository;

import org.openqa.selenium.By;

public class LoginPage_Obj {
	//Btn	
	public By Btn_Login(String text) { return By.xpath("//a[normalize-space(text())='"+text+"']"); }
	public By Btn_LoginButton(String login) {return By.xpath("//a[@class='"+login+"']");}
	public By Btn_SignInButton(String text) { return By.xpath("//button[normalize-space(text())='"+text+"']"); }
	public By Btn_Captcha(String check) {return By.xpath("//span[@role='"+check+"']");}
	public By Btn_SingnIn(String id) {return By.xpath("//button[@id='"+id+"']");}
	public By Btn_SigninClick(String onclick) { return By.xpath("//button[@onclick='"+onclick+"']"); }
	public By Btn_Logout() { return By.xpath("//div[@id='navbarSupportedContent']//button[@class='btn dropdown-toggle']");}

	//Edt
	public By Edt_LoginCredentialFields(String id) { return By.xpath("//*[@id='"+id+"']"); }
	public By Edt_LoginEmail(String email) { return By.xpath("//input[@id='"+email+"']"); }
	public By Edt_Alert1(String text) { return By.xpath("//span[text()='"+text+"']"); }
	public By Edt_AlertText(String text) { return By.xpath("//div[text()='"+text+"']"); }

	//Ele
	public By Ele_ErrorMessage(String error) {return By.xpath("//div[@class='"+error+"']");}
	public By Ele_SnipBackHomePageLogo(String id) {return By.xpath("//img[@id='"+id+"']");}
	public By Ele_LogoutOptions(String title) { return By.xpath("//li[contains(@class,'org-wrap') and @title='"+title+"']");}
	public By Ele_LoginPageErrorMsg(String text) {return By.xpath("//strong[contains(text(),'"+text+"')]");}
}
