package objectRepository;
import org.openqa.selenium.By;

public class CreateEditDeletePool_Obj {
	//btn
		public By Btn_Film(String class1,String text) { return By.xpath("//ul[@class='"+class1+"']//a[normalize-space(text())='"+text+"']"); }
		public By Btn_CreatePoolAlert(String text1,String text2) {return By.xpath("//button[@type='"+text1+"' and text()='"+text2+"']");}
		
	//sel
		public By Sel_PoolType(String text) {return By.xpath("//select[@id='"+text+"']");}
	//Ddl
		public By Ddl_PoolType(String text) {return By.xpath("//option[text()='"+text+"']");}
}
