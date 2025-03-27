package objectRepository;

import org.openqa.selenium.By;

public class Registration_Obj 
{
	//Btn
	public By Btn_Login(String text1,String text2) {return By.xpath("//a[@class='"+text1+"' and text()='"+text2+"']");}
	public By Btn_SignUp(String text1, String text2) {return By.xpath("//div[@class='"+text1+"']//a[text()='"+text2+"']");}
	
	//Ele
	public By Ele_Name(String text1, String text2) {return By.xpath("//div[@class='"+text1+"']//input[@id='"+text2+"']");}
	public By Ele_Emailerror(String text1) {return By.xpath("//span[@id='"+text1+"']");}
	public By Ele_Email(String text1) {return By.xpath("//input[@id='"+text1+"']");}
	public By Ele_Username(String text1,String text2) {return By.xpath("//div[@class='"+text1+"']//label[@class='"+text2+"']");}
	public By Ele_UsernameValid(String text1,String text2) {return By.xpath("//form[@id='"+text1+"']//label[text()='"+text2+"']");}
	
}

