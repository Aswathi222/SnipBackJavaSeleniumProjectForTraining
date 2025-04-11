package objectRepository;

import org.openqa.selenium.By;

public class SearchGameTeamAndMembers_Obj {
//Ele
	public By Ele_GameList1(String class1) {return By.xpath("//table[@class='"+class1+"']//tbody//tr");}
	public By Ele_MemberList1(String class1,String style,String id){return By.xpath("//div[@class='"+class1+"']//div[@style='"+style+"']//p[@id='"+id+"']");}
	public By Ele_GameFirst(String id,String class1){return By.xpath("//div[@id='"+id+"']//span[@class='"+class1+"']");}
	public By Ele_GameSpecial(String id){return By.xpath("//div[@id='"+id+"']");}
}
