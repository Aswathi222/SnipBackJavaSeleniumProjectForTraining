package objectRepository;

import org.openqa.selenium.By;

public class SnipBackLogin_Obj {
	
	//Btn
	public By Btn_Login(String text){return By.xpath("//a[text()='"+text+"']");}
	public By Btn_Signin(String text){return By.xpath("//button[text()='"+text+"']");}
}
