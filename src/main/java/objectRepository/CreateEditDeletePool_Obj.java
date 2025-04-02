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
	public By Ddl_addUser(String id){return By.xpath("//a[@id='"+id+"']");}
}
