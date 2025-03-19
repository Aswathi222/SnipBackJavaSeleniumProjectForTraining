package objectRepository;
import org.openqa.selenium.By;

public class EditDeleteCameraViewPlayerPage_Obj 

{	
	//Btn
	public By Btn_Edit(String id,String text) {return By.xpath("//input[@id='"+id+"']/following-sibling::button[@class='"+text+"']");}

	 
}	

