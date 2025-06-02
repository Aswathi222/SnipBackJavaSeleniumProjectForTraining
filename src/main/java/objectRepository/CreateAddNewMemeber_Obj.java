package objectRepository;
import org.openqa.selenium.By;

public class CreateAddNewMemeber_Obj 
{
	//Edt	
	public By Edt_SearchBox(String SearchText) { return By.xpath("//input[@class='"+SearchText+"']"); }
	public By Edt_SearchBoxClick(String Text1,String Text2) { return By.xpath("//input[@class='"+Text1+"']//parent::div[@class='"+Text2+"']");}
	
	//Tab
	public By Tab_TabClick(String TabClick) { return By.xpath("//button[@class='"+TabClick+"']"); }
	
	//Ddl
	public By Ddl_Selection(String DrpDwn, String Option) { return By.xpath("//a[@id='"+DrpDwn+"-5281' and text()='"+Option+"']");}
	
    //Ele
	public By Ele_ValidationMessage(String Msg) {return By.xpath("//span[@class='"+Msg+"']"); }
	public By Msg_ErrorMessage(String Msg) {return By.xpath("//span [contains(text(),'"+Msg+"')]");}
}

	