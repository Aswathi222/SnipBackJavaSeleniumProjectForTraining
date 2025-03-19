package objectRepository;

import org.openqa.selenium.By;

public class EditSnip_Obj {

	//Btn
	public By Btn_EditBtn(String text, String text2) {return By.xpath("//button[@class='"+text+"' and text()='"+text2+"']");}
	public By Btn_TagBox(String text, String text3){return By.xpath("//div[@id='"+text+"']//div[text()='"+text3+"']");}
	public By Btn_Member(String text,String text2){return By.xpath("//div[@class='"+text+"']//button[@class='"+text2+"']");}
	public By Btn_Home(String text,String text2){return By.xpath("//button[@class='"+text+"'and text()='"+text2+"']");}
	public By Btn_Chk(String text1, String text2) {return By.xpath("//label[text()='"+text1+"']/..//input[@class='"+text2+"']");}
	public By Btn_Done(String text1, String text2) {return By.xpath("//div[@class='"+text1+"']//button[text()='"+text2+"']");}
	public By Btn_OK(String text1, String text2){return By.xpath("//button[@class='"+text1+"'and text()='"+text2+"']");}
	public By Btn_Color(String text){return By.xpath("//div[@class='"+text+"' and @data-color='#8392C9']");}
	public By Btn_Member1(String text,String text2){return By.xpath("//div[text()='"+text+"']/ancestor::div[@data-id='"+text2+"']//button[@class='sec-right add-usertocustomtagbtn']");}
	public By Btn_Done(String text){return By.xpath("//ul[@class='nav nav-tabs custom-tags-tabmenu d-flex']/following-sibling::div//button[@class='"+text+"']");}
	public By Btn_demo(String text){return By.xpath("//li[@id='"+text+"']");}
	public By Btn_ChkMember(String text1, String text2) {return By.xpath("(//div[@id='"+text1+"']//input[@class='"+text2+"'])[1]");}

	//Ele
	public By Ele_TagName(String text) { return By.xpath("//div[@class='col-md-11 col-10 left-items']//div[text()='"+text+"']");}	
	public By Ele_SaveBtn(String class1, String class2) {return By.xpath("//div[@class='"+class1+"']//a[@class='"+class2+"']");}
	public By Ele_ColorTag(String text1,String text2) { return By.xpath("//div[@class='"+text1+"']//div[text()='"+text2+"']");}
	public By Ele_Close(String text1, String text2){return By.xpath("//div[@class='"+text1+"']//i[@class='"+text2+"']");}
	public By Ele_Player(String text1, String text2){return By.xpath("//label[@class='"+text1+"'and text()='"+text2+"']");}
	public By Ele_Tagbox(String text,String text2, String text3) { return By.xpath("//div[@id='"+text+"']//div[@class='"+text2+"' and text()='"+text3+"']");}
	public By Ele_eam(String text){return By.xpath("//label[text()='"+text+"']");}
	public By Ele_Tag(String a, String b) {return By.xpath("//div[@id='"+a+"']//div//div//div//div[text()='"+b+"']");}
	public By Ele_EditTag(String a, String b) {return By.xpath("(//div[@class='"+a+"']//following::div[@class='"+b+"'])[8]");}
	public By Ele_Video(String a) {return By.xpath("(//section[@id='"+a+"']");}
	public By Ele_EditMember(String a, String b) {return By.xpath("(//div[@class='"+a+"']//following::button[@class='"+b+"'])[9]");}
	public By Ele_ListMember(String a, String b) {return By.xpath("//div[@id='"+a+"']//ul[@class='"+b+"'][li]");}

}
