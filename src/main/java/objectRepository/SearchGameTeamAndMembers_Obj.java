package objectRepository;

import org.openqa.selenium.By;

public class SearchGameTeamAndMembers_Obj {
	//Ele
		public By Ele_GameList(String gameClass) {return By.xpath("//table[@class='"+gameClass+"']//tbody//tr");}
		public By Ele_MemberList(String memberClass, String memberId){return By.xpath("//div[@id='"+memberClass+"']//p[@id='"+memberId+"']");}
		public By Ele_MemberListNew(String memberListClass,String memberStyle,String memberId){return By.xpath("//div[@class='"+memberListClass+"']//div[@style='"+memberStyle+"']//p[@id='"+memberId+"']");}
		public By Ele_GameFirst(String gameId,String gameClass){return By.xpath("//div[@id='"+gameId+"']//span[@class='"+gameClass+"']");}
		public By Ele_GameSpecial(String gameId){return By.xpath("//div[@id='"+gameId+"']");}
}
