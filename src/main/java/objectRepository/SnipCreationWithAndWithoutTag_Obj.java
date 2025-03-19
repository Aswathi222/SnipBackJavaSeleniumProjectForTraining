package objectRepository;

import org.openqa.selenium.By;

public class SnipCreationWithAndWithoutTag_Obj 
{
	//Btn
	public By Btn_Snip(String text) {return By.xpath("//a[@class='"+text+"']");}
	public By Btn_Tag(String text,String text2, String text3) { return By.xpath("//div[@class='"+text+"']//div[@class='"+text2+"' and text()='"+text3+"']");}
	public By Btn_TickIcon(String text,String text2) {return By.xpath("//section[@class='"+text+"']//button[@class='"+text2+"']");}
	public By Btn_TagBox(String text,String text2) {return By.xpath("//div[@id='"+text+"']//div[@class='"+text2+"']");}
	public By Btn_BookMark(String text) {return By.xpath("//div[@class='"+text+"']");}
	public By Btn_Player(String text) {return By.xpath("//a[@id='"+text+"']");}
	public By Btn_Pencil(String text) {return By.xpath("//i[@class='"+text+"']");}

	public By Btn_SnipDisable(String snip) {return By.xpath("//a[@title='"+snip+"']");}
	public By Btn_Member1(String a, String b) {return By.xpath("//div[text()='"+a+"']/ancestor::div[@data-id='"+b+"']//button[@class='sec-right add-usertocustomtagbtn']");}

	//Ele
	public By CusTag(String text) {return By.xpath("//h5[text()='"+text+"']");}
	public By Ele_HomePage(String text,String text1) { return By.xpath("//ul/li[@class='"+text+"']/a[text()='"+text1+"']");}
	public By Ele_CreateSnipHeader(String text, String text1) {return By.xpath("//div[@class='"+text+"']//*[@class='"+text1+"']");}  
	public By Ele_CreateSnipOptions(String text) {return By.xpath("//div[@class='"+text+"']//li/button");} 
	public By Ele_CreateSnipDisabled(String text,String text1) {return By.xpath("//div[@id='"+text+"']/div[text()='"+text1+"']");} 
	public By Ele_TeamNameFromList(String text,String text1) {return By.xpath("//div[@id='"+text+"']//span[text()='"+text1+"']");} //mysnipshref   shot-username pad-c
	public By Ele_NoTagInPlayerPage(String text,String text1) {return By.xpath("//a[@id='"+text+"']/../../following-sibling::div//div[@class='"+text1+"']");} 
	public By Ele_Frame(String shot) {return By.xpath("//div[@frameid='"+shot+"']");}
	public By Ele_Check(String h, String a) {return By.xpath("//li[@data-name='"+h+"']//input[@class='"+a+"']");}
	public By Ele_NoTag(String text) {return By.xpath("(//div[@id='"+text+"']/div//div)[1]");}
	
	//Ddl
	public By Ddl_TagDropdwn(String text)  { return By.xpath("//div[@id='"+text+"']");  } 	
	public By I_Close(String text,String text2) {return By.xpath("//span[@class='"+text+"']//i[@class='"+text2+"']");}

}
