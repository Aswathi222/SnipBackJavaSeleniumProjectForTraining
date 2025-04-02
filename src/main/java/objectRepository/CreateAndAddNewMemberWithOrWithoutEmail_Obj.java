package objectRepository;

import org.openqa.selenium.By;

public class CreateAndAddNewMemberWithOrWithoutEmail_Obj {	
	//Btn
	public By Btn_Home(String text) {return By.xpath("//select[@class='"+text+"']");}
	public By Btn_Team(String text1, String text2) {return By.xpath("//div[@id='"+text1+"']//span[text()='"+text2+"']");}
	public By Btn_ThreeDots(String text1, String text2) {return By.xpath("//div[@id='"+text1+"']//a[@id='"+text2+"']");}
	public By Btn_EditTeam(String text) {return By.xpath("//a[@data-name='"+text+"']");}
	//Ele	
	public By Ele_list(String text1, String text2) {return By.xpath("//div[@id='"+text1+"']//div[@id='"+text2+"'] ");}
	//Edt
	public By Edt_TeamName(String text) {return By.xpath("//input[@class='"+text+"']");}	
}

