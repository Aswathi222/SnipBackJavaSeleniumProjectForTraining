package objectRepository;
import org.openqa.selenium.By;

public class DownloadGamePlayer_Obj 

{	

	//Btn
	public By Btn_Master_Film(String class1, String text) {return By.xpath("//li[@class='"+class1+"']/..//following-sibling::a[text()='"+text+"']");}		
	
	//Ele
	public By Ele_ListOfGameModesInMoveGamePopup(String id,String tagName) { return By.xpath("//div[@id='"+id+"']/"+tagName+""); } 
}

