package objectRepository;

import org.openqa.selenium.By;

public class SearchGameTeamAndMembers_Obj {
//Ele
	public By Ele_GameList1(String class1) {return By.xpath("//table[@class='"+class1+"']//tbody//tr");}
	public By Ele_MemberList(String class1, String id){return By.xpath("//div[@class='"+class1+"']//p[@id='"+id+"']");}
}

