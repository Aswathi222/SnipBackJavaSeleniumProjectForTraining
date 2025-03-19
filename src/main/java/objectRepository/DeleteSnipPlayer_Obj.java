package objectRepository;
import org.openqa.selenium.By;

public class DeleteSnipPlayer_Obj 

{	
	//Btn
	public By Btn_DeleteSnip(String class1, String class2) {return By.xpath("//div[@class='"+class1+"']/..//child::i[@class='"+class2+"']");}
	public By Btn_MySnipsSelect(String id) {return By.xpath("(//div[@id='"+id+"']/div//div)[1]");}
	public By Btn_Snip(String a, String b) {return By.xpath("//div[@id='"+a+"']//div[@id='"+b+"']");}
	public By Btn_MySnipsSelectSnip(String id, String id1) {return By.xpath("(//div[@id='"+id+"']//div[@id='"+id1+"']//div//div)[1]");}
	public By Btn_Message(String text) {return By.xpath("//div[contains(text(), '"+text+"')]");}
}

