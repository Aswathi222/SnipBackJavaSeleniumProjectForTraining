package objectRepository;

import org.openqa.selenium.By;

public class ShareGame_Obj 
{
	//Btn
	public By Btn_Close(String class1, String text1) { return By.xpath("//div[@id='"+class1+"']//button[@class='"+text1 +"']");}
	public By Btn_Team() {return By.xpath("//label[contains(text(),'mystics')]//span[@class='checkmark']");}	
	public By Btn_Cancel(String a , String b) {return By.xpath("//button[@onclick='"+a+"']/../button[@id='"+b+"']");}
	public By Btn_XButton(String a, String b) {return By.xpath("//div[@id='"+a+"']/preceding-sibling::div//button/child::span[text()='"+b+"']");}
	public By Btn_Players(String text1, String text2) { return By.xpath("//li[@class='"+text1+"']//button[@id='"+text2+"']");}
	public By Btn_fb(String f , String b) {return By.xpath("//div[@class='"+f+"']//i[@class='"+b+"']");}
	public By Btn_XClose(String a, String b) {return By.xpath("//div[@id='"+a+"']//div//div//div//button[@class='"+b+"']");}
	public By Btn_Icon(String i, String c) {return By.xpath("//div[@class='"+i+"']//div//button[@class='"+c+"']");}
	public By Ele_Search(String class1, String text) { return By.xpath("//ul//li/label/p[@class='"+class1+"' and text()='"+text+"']");}
	public By Ele_PlayerTeamName(String text) { return By.xpath("//label[contains(text(),'"+text+"')]");}
	
	//Ele
	public By Ele_PlayerMenu(String text, int index) { return By.xpath("//button[@Id='"+text+"']["+index+"]");}
	public By Ele_Share(String text, int index) { return By.xpath("//a[text()='"+text+"']["+index+"]");}
	public By Ele_ShareInternally1(String text1) { return By.xpath("//div[@class='"+text1+"']//a[@href]");}
	public By Ele_PlayerName(String text) { return By.xpath("//div[@id='"+text+"']");}
	public By Ele_SearchResult(String text, int index) { return By.xpath("(//ul//li/label[@class='"+text+"'])["+index+"]");}
	public By Ele_Sharetab(String a, String b) {return By.xpath("//div[@id='"+a+"']//div[@class='"+b+"']");}
	public By Ele_Copy(String c, String p) {return By.xpath("//label[text()='"+c+"']//span[@class='"+p+"']");}
}
