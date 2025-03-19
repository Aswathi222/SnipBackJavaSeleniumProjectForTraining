package objectRepository;

import org.openqa.selenium.By;

public class DuplicateSnip_Obj 

{	
	//Ele
    public By Ele_SelectGame(String cls, String text) { return By.xpath("//a[@class='"+cls+"' and text()='"+text+"']");}
    public By Ele_Frame(String text1, String text2, int index) { return By.xpath("(//div[@id='"+text1+"']//div[@title=' "+text2+"'])["+index+"]");}
    
//Btn	
	public By Btn_Cancel(String text1, String text2, int index) { return By.xpath("(//div[@class='"+text1+"']/..//div[@class='"+text2+"'])["+index+"]");}	
}

