package objectRepository;

import org.openqa.selenium.By;

public class DuplicateTeam_Obj 
{
	//Btn
	public By Btn_ThreeDotsTeam(String text, String classname) {return By.xpath("//span[text()='"+text+"']/../..//div[@class='"+classname+"']");}
	public By Btn_DuplicateTeam(String text, String classname, String classname1) {return By.xpath("//span[text()='"+text+"']/../..//div[@class='"+classname+"']//a[@class='"+classname1+"']");}
}
