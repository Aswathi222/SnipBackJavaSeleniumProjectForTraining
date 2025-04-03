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
	public By Ddl_addUser1(String text, String text2){return By.xpath("//a[@class='"+text+"' and text()='"+text2+"']");}

	// Ele
	public By Ele_PoolUser(String text, String text2){return By.xpath("//span[@class='"+text+"' and text()='"+text2+"']");}
	public By Ele_Pooldots(String text, String text2){return By.xpath("//a[text()='"+text+"']/../../..//button[@data-toggle='"+text2+"'] ");}
	public By Ele_Copydots(String text, String text2){return By.xpath("//a[text()='"+text+"']/../../..//td//div//li//a[text()='"+text2+"']");}
}
