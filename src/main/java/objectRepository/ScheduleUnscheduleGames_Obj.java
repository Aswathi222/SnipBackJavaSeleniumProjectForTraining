package objectRepository;

import org.openqa.selenium.By;

public class ScheduleUnscheduleGames_Obj {
	
	//Img
	public By Img_ScheduleIcon() { return By.xpath("//button[@class='film-tab nav-link active']//img[@src='https://web06-stg-ch.snipback.com/assets/images/film/calendar.svg']");}
	
	//Ele
	public By Ele_ScheduleIc(String text) {return By.xpath("//a[text()='"+text+"']/../..//span[@class='calendar-list scheduled']");}
	public By Ele_FirstDate(String text) {return By.xpath("//td[text()='"+text+"']");}
	public By Ele_Practice() {return By.xpath("//span[text()='Practice']/../..//a[@class='add-btn d-flex-block cursor-pointer bg-danger add-popup add-game']");}
	public By Ele_GameSchedule(String text,String text2) {return By.xpath("//div[@class='"+text+"']/../../../..//span[@data-id='"+text2+"']");}
	public By Ele_SearchGame(String text,String text2) {return By.xpath("//div[@class='"+text+"'] //a[text()='"+text2+"']");}
	public By Ele_Data(String a) {return By.xpath("//td[@class='"+a+"']");}
	public By Ele_Game(String game) {return By.xpath("//tr[@id='"+game+"']");}
	public By Ele_Event(String a, String b) {return By.xpath("//button[@id='"+a+"']/../../../..//a[text()='"+b+"']");}
	public By Ele_Pagination(String page ,String a) {return By.xpath("//div[@aria-labelledby='"+page+"']//a[text()='"+a+"']");}
	//div[@class='"+text+"']//span[@data-id='"+text2+"']
	//Btn
	public By Btn_Create() {return By.xpath("//button[text()='CREATE']/../..//h3[text()='Create Game for ']");}
	}
	

