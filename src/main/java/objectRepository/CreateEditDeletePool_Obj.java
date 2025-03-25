package objectRepository;
import org.openqa.selenium.By;

public class CreateEditDeletePool_Obj {
	//btn
	public By Btn_Film(String class1,String text) { return By.xpath("//ul[@class='"+class1+"']//a[normalize-space(text())='"+text+"']"); }
	public By Btn_Pool(String text) { return By.xpath("//button[text()='"+text+"']");}
	public By Btn_CreatePool(String text) { return By.xpath("//span[text()='"+text+"']");}
}
