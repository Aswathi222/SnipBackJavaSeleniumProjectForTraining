package objectRepository;
import org.openqa.selenium.By;

public class AddEditInfo_Obj 
{	
	//Btn
	public By Btn_Threedots(String text){ return By.xpath("//tr[@id='30315']//button[@id='"+text+"']");  }
	public By Btn_Threedot(String text1, String text){ return By.xpath("//tr[@id='"+text1+"']//button[@id='"+text+"']");  }
	public By Btn_InProgressThreedots(String text){ return By.xpath("//tr[@id='29816']//button[@id='"+text+"']");  }
	public By Btn_ThreedotsEditInfo(String text){ return By.xpath("//tr[@id='30089']//button[@id='"+text+"']");  }
	
	//Ele 
	public By Ele_AddInfo(String text) { return By.xpath("//div[@class='btn-group dropleft right-menu-wrap show']//a[text()='"+text+"']"); }
	public By Ele_ScoreFields(String text) { return By.xpath("//div[@class='info-popup-input']//input[@id='"+text+"']");}
	public By Ele_SelectWL(String text) { return By.xpath("//label[@for='"+text+"']");}
}	

