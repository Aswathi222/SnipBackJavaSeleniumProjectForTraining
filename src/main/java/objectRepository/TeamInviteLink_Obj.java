package objectRepository;
import org.openqa.selenium.By;

public class TeamInviteLink_Obj 

{	
	//Ele 
	 public By Ele_TeamOptions(String value, String id,String text){ return By.xpath("//input[@value='"+value+"']/../..//div[contains(@id,'"+id+"')]//a[text()='"+text+"']");}
	 public By Ele_Teamlink(String id, String text) { return By.xpath("//div[@id='"+id+"']//a[text()='"+text+"']");}
}	

