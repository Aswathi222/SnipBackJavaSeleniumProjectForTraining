package objectRepository;

import org.openqa.selenium.By;

public class ScheduleUnscheduleGames_Obj {	
	
	//Btn
	public By Btn_ScheduleUnschedule(String class1, String text2, String class2, String dtType) 
	{
		return By.xpath("//tr[@class='"+class1+"']//td[text()='"+text2+"']/following-sibling::td//span[contains(@class, '"+class2+"')and @data-type='"+dtType+"']");
	}
	public By Btn_Create(String cls,String text) {return By.xpath("//button[@class='"+cls+"' and text()='"+text+"']");}
	public By Btn_EventOK(String cls) {return By.xpath("//button[@class='"+cls+"']");}
	
	//Ddl
	public By DdlOrg(String class1) {return By.xpath("//select[@class='"+class1+"']");}
	
	//Ele
	public By Ele_TeamNameFromList(String id1,String text1) {return By.xpath("//div[@id='"+id1+"']//span[text()='"+text1+"']");}
	public By Ele_CreateGameFor(String text1) {return By.xpath("//h3[text()='"+text1+"']");}
	public By Ele_SearchGame(String cls) {return By.xpath("//input[@class='"+cls+"']");}	
}

