package objectRepository;
import org.openqa.selenium.By;

public class ViewProfile_Obj 
{	
	//Btn
	public By Btn_CanBtn(String text,String cls) {return By.xpath("//button[text()='"+text+"']/../..//div[@class='"+cls+"']");}
	public By Btn_Cancel(String cls,String text){return By.xpath ("//div[@class='"+cls+"']//div//form//child::div//button[text()='"+text+"']");}
	
	//Ele
	public By Ele_ViewProfile(String cls,String text) {return By.xpath("//div[@class='"+cls+"']//a[text()='"+text+"']");}
	public By Ele_ResetPassHeading(String text) {return By.xpath("//h4[text()='"+text+"']");}

	//Edt
	public By Edt_ViewProfiletextfield(String cls,String text) {return By.xpath("//div[@class='"+cls+"']//input[@id='"+text+"']");}

}	 
