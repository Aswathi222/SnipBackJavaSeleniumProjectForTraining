package objectRepository;

import org.openqa.selenium.By;

public class KeyboardShortcut_Obj {
	//Ele
	public By Ele_KBPop(String text1,String text2) {return By.xpath("//div[@class='"+text1+"']//div[@class='"+text2+"']");}
	
	//Btn
	public By Btn_KBShortcut(String text1,String text2,String text3) {return By.xpath("//button[@class='"+text1+"']//span[@class='"+text2+"' and text()='"+text3+"']");}
	
}
