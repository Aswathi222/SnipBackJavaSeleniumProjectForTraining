package objectRepository;

import org.openqa.selenium.By;

public class DualView_Obj {
	//Btn
	public By Btn_DualView(String text) {return By.xpath("//img[@id='"+text+"']");}
	//Ele
	public By Ele_NoTag(String text) {return By.xpath("(//div[@id='"+text+"']/div//div)[1]");}

}
