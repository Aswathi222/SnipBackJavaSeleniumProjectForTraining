package objectRepository;
import org.openqa.selenium.By;

public class CreateEditDeletePool_Obj {
	//btn
	public By Btn_Film(String class1,String text) { return By.xpath("//ul[@class='"+class1+"']//a[normalize-space(text())='"+text+"']"); }
	public By Btn_CreatePoolAlert(String type,String text) {return By.xpath("//button[@type='"+type+"' and text()='"+text+"']");}

	//sel
	public By Sel_PoolType(String id) {return By.xpath("//select[@id='"+id+"']");}

	//Ddl
	public By Ddl_PoolType(String text) {return By.xpath("//option[text()='"+text+"']");}
	public By Ddl_addUser1(String class1, String text1){return By.xpath("//a[@class='"+class1+"' and text()='"+text1+"']");}

	// Ele
	public By Ele_PoolUser(String class1, String text1){return By.xpath("//span[@class='"+class1+"' and text()='"+text1+"']");}
	public By Ele_Pooldots(String text, String value){return By.xpath("//a[text()='"+text+"']/../../..//button[@data-toggle='"+value+"'] ");}
	public By Ele_PoolType(String class1, String text){return By.xpath("//div[@class='"+class1+"']//label[text()='"+text+"']");}
}
