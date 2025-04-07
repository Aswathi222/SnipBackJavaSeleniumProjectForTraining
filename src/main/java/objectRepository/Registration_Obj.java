package objectRepository;

import org.openqa.selenium.By;

public class Registration_Obj 
{
	//Btn
	public By Btn_Login(String class1,String text1) {return By.xpath("//a[@class='"+class1+"' and text()='"+text1+"']");}
	public By Btn_SignUp(String class1, String text1) {return By.xpath("//div[@class='"+class1+"']//a[text()='"+text1+"']");}
	
	//Ele
	public By Ele_Name(String class1, String id1) {return By.xpath("//div[@class='"+class1+"']//input[@id='"+id1+"']");}
	public By Ele_Emailerror(String id1) {return By.xpath("//span[@id='"+id1+"']");}
	public By Ele_Email(String id1) {return By.xpath("//input[@id='"+id1+"']");}
	public By Ele_Username(String class1,String class2) {return By.xpath("//div[@class='"+class1+"']//label[@class='"+class2+"']");}
	public By Ele_UsernameValid(String id1,String text1) {return By.xpath("//form[@id='"+id1+"']//label[text()='"+text1+"']");}
	public By Ele_BlankValue(String class1,String id1) {return By.xpath("//div[@class='"+class1+"']//span[@id='"+id1+"']");}
	public By Ele_Numberror(String class1,String id1) {return By.xpath("//span[@class='"+class1+"' and @id='"+id1+"']");}
	public By Ele_ErrorMessage(String id1,String text1) {return By.xpath("//span[@id='"+id1+"']//li[text()='"+text1+"']");}
}

