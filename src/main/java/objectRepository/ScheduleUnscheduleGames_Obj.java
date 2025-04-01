package objectRepository;

import org.openqa.selenium.By;

public class ScheduleUnscheduleGames_Obj {	
	
	//Btn
	public By Btn_ScheduleUnschedule(String text1, String text2, String text3, String text4) 
	{
		return By.xpath("//tr[@class='"+text1+"']//td[text()='"+text2+"']/following-sibling::td//span[contains(@class, '"+text3+"')and @data-type='"+text4+"']");
	}
}

