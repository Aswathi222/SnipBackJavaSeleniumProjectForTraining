package objectRepository;

import org.openqa.selenium.By;

public class SearchGameTeamAndMembers_Obj {

	//Btn	
	public By Btn_Games(String game) {return By.xpath("//button[@aria-controls='"+game+"']");}

	//Img
	public By Ele_SnipBackHomePageLogo(String id) {return By.xpath("//img[@id='"+id+"']");}

	//Edt
	public By Edt_DataName(String data) {return By.xpath("//option[@data-name='"+data+"']");}
	
	//Page
	public By Pge_MembersList(String member) {return By.xpath("//span[@id='"+member+"']/parent::h3");}

	//Ele
	public By Ele_MemberName(String text) { return By.xpath("//p[text()='"+text+"']"); }
	}


