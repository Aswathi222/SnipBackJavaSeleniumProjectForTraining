package objectRepository;

import org.openqa.selenium.By;

public class Registration_Obj 
{
	//Btn
	public By Btn_Login(String text1,String text2) {return By.xpath("//a[@class='"+text1+"' and text()='"+text2+"']");}
	public By Btn_SignUp(String text1, String text2) {return By.xpath("//div[@class='"+text1+"']//a[text()='"+text2+"']");}
	public By Btn_SigUp1(String text1) {return By.xpath("//button[@id='"+text1+"']");}	
	
	//Ele
	public By Ele_Name(String text1, String text2) {return By.xpath("//div[@class='"+text1+"']//input[@id='"+text2+"']");}
	public By Ele_Emailerror(String text1) {return By.xpath("//span[@id='"+text1+"']");}
}
