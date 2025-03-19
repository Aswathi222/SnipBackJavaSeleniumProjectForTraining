package objectRepository;

import org.openqa.selenium.By;

public class DownloadSnip_Obj 
{
	//Ele
	public By Ele_DownloadPBar(String id1, String text1) { return By.xpath("//div[@id='"+id1+"' and text()='"+text1+"']");}
}
