package objectRepository;

import org.openqa.selenium.By;

public class Pool_Obj {
	//Btn
	public By Btn_Home(String id) { return By.xpath("//option[@value='"+id+"']");}
	public By Btn_select(String id) { return By.xpath("//li[@title='"+id+"']");}
	public By Btn_Create(String path,String Field) { return By.xpath("//button[@type='"+path+"']/..//button[text()='"+Field+"']");}
	public By Btn_PoolDots(String text) {return By.xpath("//a[text()='"+text+"']/../../..//button[@id='dropdownMenuButton1']"); }
	public By Btn_ButtonCreate(String pool) {return By.xpath("//button[@class='"+pool+"']");}
	public By Btn_PoolUpdate(String text) {return By.xpath("//div[@class='modal-footer border-0 flex-column1']//button[text()='"+text+"']"); }
	
	//Ele
	public By Ele_CreatePool(String Field) { return By.xpath("//h5[text()='"+Field+"']");}
	public By Ele_PoolTypeDropDown(String Path) { return By.xpath("//select[@id='"+Path+"']");}
	public By Ele_SelectPoolType(String field) { return By.xpath("//option[text()='"+field+"']");}
	public By Ele_PoolTitle(String text) { return By.xpath("//th[text()='"+text+"']"); }
	public By Ele_PoolPopUp(String text) { return By.xpath("//a[text()='"+text+"']/../..//a[text()='Edit']"); }
	public By Ele_PoolLeftMenuOptions(String PoolName, String Option) { return By.xpath("//a[text()='"+PoolName+"']/../../..//td//div//li//a[text()='"+Option+"']"); }
	public By Ele_PoolDeleteConfirmationPopUp(String text) { return By.xpath("//div[contains(text(),'"+text+"')]"); }
    
	//Ddl
	public By Ddl_TeamDropdwn(String text)  { return By.xpath("//select[@class='"+text+"']");  } 
	public By Ddl_PoolMenu(String text) { return By.xpath("//div[@class='dropdown-menu dropdown-menu-center show']/..//ul[@class='"+text+"']"); }
	public By Ddl_CreatePool(String create) {return By.xpath("//h5[@id='"+create+"']");}

}	

