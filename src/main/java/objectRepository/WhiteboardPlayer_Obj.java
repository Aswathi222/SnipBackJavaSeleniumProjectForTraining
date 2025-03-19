package objectRepository;

import org.openqa.selenium.By;

public class WhiteboardPlayer_Obj {
	//Btn
	public By Btn_HighWhiteboard(String class1,String text) { return By.xpath("//div[@class='"+class1+"']//child::div[normalize-space(text())='"+text+"']");}	
    public By Btn_WhiteBoardNameEdtBtn(String text,String classValue) {return By.xpath("//div[@class='"+text+"']/../..//a[@class='"+classValue+"']");}
	
    //Ele
	public By Ele_WhiteboardNameEdit(String class1,String id) { return By.xpath("//div[@class='"+class1+"']//input[@id='"+id+"']");}
	public By Ele_WhiteboardNameSave(String class1,String text) { return By.xpath("//div[@class='"+class1+"']/..//child::button[text()='"+text+"']");}
	public By Ele_WhiteboardShare(String text) { return By.xpath("//div[@id='socialShareModal']//div//h5[text()='"+text+"']");}
	public By Ele_ListedTeams(String TeamName) {return By.xpath("//span[text()='"+TeamName+"']");}
	public By Ele_ListedTeamSemTest(String text1,String text2,String text3) {return By.xpath("//div[@id='"+text1+"']//span[@class='"+text2+"' and text()='"+text3+"']");}
}
