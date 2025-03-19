package objectRepository;

import org.openqa.selenium.By;

public class ArchiveUnarchiveTeam_Obj {
	
	//Btn	
	public By Btn_ArchivedTeamThreeDots(String teamname)  {return By.xpath("//span[@id='archiveTitle']/../following-sibling::div[7]/div//span[text()='"+teamname+"']/../following-sibling::div//i"); }
	public By Btn_TThreeDots(String teamname)	{return By.xpath("//span[text()='"+teamname+"']/../following-sibling::div//i");}																	 
	public By Btn_ThreeDotsTeam(String a, String b) { return By.xpath("//a[@class='"+a+"' and @id='"+b+"']"); }
	public By Btn_TeamCreatedClose(String class1, String id1) {return By.xpath("//div[@class='"+class1+"']//button[@id='"+id1+"']");}  
	public By Ele_Archieve(String text, String text1) {return By.xpath("//span[@id='"+text+"']//following::span[text()='"+text1+"']");}
	
	//Ele
	public By Ele_Team3DotsClick(String id, String class1) {return By.xpath("//div[@id='"+id+"']//input[@class='"+class1+"']");}   
	
	//sel
	public By Sel_SelectCategory(String text){return By.xpath("//Select[@id='"+text+"']");}
	public By Sel_SelectTeamType(String text,String value){return By.xpath("//Select[@id='"+text+"']//option[@value='"+value+"']");}
}
