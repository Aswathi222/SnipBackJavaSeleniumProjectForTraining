package objectRepository;
import org.openqa.selenium.By;

public class SnipCollections_Obj 

{	
	//Ele nav-item Home
		public By Ele_HomePage(String text,String text1) { return By.xpath("//ul/li[@class='"+text+"']/a[text()='"+text1+"']");}
		public By Ele_SnipSuccessMessage(String text, String text1) {return By.xpath("//div["+text+"]//p[@id='"+text1+"']");}
	 
}	

