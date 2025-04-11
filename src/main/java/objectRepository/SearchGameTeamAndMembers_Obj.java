package objectRepository;

import org.openqa.selenium.By;

public class SearchGameTeamAndMembers_Obj {
//Ele
	public By Ele_GameList1(String class1) {return By.xpath("//table[@class='"+class1+"']//tbody//tr");}
	public By Ele_MemberList1(String class1,String style,String id){return By.xpath("//div[@class='"+class1+"']//div[@style='"+style+"']//p[@id='"+id+"']");}
	public By Ele_GameFirst(String id,String class1){return By.xpath("//div[@id='"+id+"']//span[@class='"+class1+"']");}
	public By Ele_GameSpecial(String id){return By.xpath("//div[@id='"+id+"']");}

	public By Ele_ThreeDots(String text,String class1){return By.xpath("//a[normalize-space(text())='"+text+"']/../../..//div[@class='"+class1+"']");}
	public By Ele_ThreeDotsText(String text1,String text2){return By.xpath("//a[normalize-space(text())='"+text1+"']/../../..//a[normalize-space(text())='"+text2+"']");}
}
