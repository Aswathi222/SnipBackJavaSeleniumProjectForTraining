package objectRepository;
import org.openqa.selenium.By;

public class CreateEditDeletePool_Obj {
	//btn
	public By Btn_Film(String filmClass,String filmText) { return By.xpath("//ul[@class='"+filmClass+"']//a[normalize-space(text())='"+filmText+"']"); }
	public By Btn_CreatePoolAlert(String poolAlert,String alertText) {return By.xpath("//button[@type='"+poolAlert+"' and text()='"+alertText+"']");}

	//sel
	public By Sel_PoolType(String poolId) {return By.xpath("//select[@id='"+poolId+"']");}

	//Ddl
	public By Ddl_PoolType(String poolTypeText) {return By.xpath("//option[text()='"+poolTypeText+"']");}
	
	// Ele
	public By Ele_Pooldots(String dotText, String dotValue){return By.xpath("//a[text()='"+dotText+"']/../../..//button[@data-toggle='"+dotValue+"'] ");}
	public By Ele_Copydots(String copyDotText, String copyDottextValue){return By.xpath("//a[text()='"+copyDotText+"']/../../..//td//div//li//a[text()='"+copyDottextValue+"']");}
	public By Ele_PoolType(String poolTypeClass, String poolTypeText){return By.xpath("//div[@class='"+poolTypeClass+"']//label[text()='"+poolTypeText+"']");}
}

