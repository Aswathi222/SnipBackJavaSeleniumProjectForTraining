package objectRepository;

import org.openqa.selenium.By;

public class TrimVideo_Obj 

{	
	//Ele
	public By Ele_MySnipsOptionsList(String text) { return By.xpath("//ul[@id='"+text+"']"); }  
	public By Ele_GameOrEvenName(String text,String text1) {return By.xpath("//table[@class='"+text+"']/tbody/tr/td/a[text()='"+text1+"']");}
}

