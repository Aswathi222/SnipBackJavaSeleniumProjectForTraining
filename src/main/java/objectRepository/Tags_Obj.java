package objectRepository;

import org.openqa.selenium.By;

public class Tags_Obj 

{	
	//Btn
	public By Btn_TagsButton(String text) { return By.xpath("//div[@id='navbarSupportedContent']//a[text()='"+text+"']");}
	public By Btn_TagsListPlusButton(String onclick) { return By.xpath("//button[contains(@onclick,'"+onclick+"')]");}
	public By Btn_TagsListCancelButton(String text) { return By.xpath("//h4[text()='ENTER THE LIST NAME']/../..//div//button[text()='"+text+"']");}
	public By Btn_TagEdit(String text) {return By.xpath("//label[text()='"+text+"']/../following-sibling::td[2]//button");}
	public By Btn_Tags(String text ,String tags) {return By.xpath("//div[@class='"+text+"']//ul//a[@id='"+tags+"']");}
	public By Btn_Rename(String a, String b) {return By.xpath("//label[text()='"+a+"']/../..//button[@class='"+b+"']");}
	public By Btn_DuplicateTagLists(String TagListName){return By.xpath("//label[text()='"+TagListName+"']/../..//button[contains(@id,'btnDupicate')]");}
	public By Btn_Cancel(String text1, String text2 ) { return By.xpath("(//div[@id='"+text1+"']//button[text()='"+text2+"'])"); }
	public By Btn_close(String text) {return By.xpath("//div[@class='modal-footer']//button[@id='"+text+"']");}
	public By Btn_Tagdelete(String text) {return By.xpath("//label[text()='"+text+"']/../following-sibling::td[3]//button");}
	public By Btn_DeleteIcon(String text,String text1) {return By.xpath("//table[@id='customTagTable']/tbody/tr/td/label[text()='"+text+"']/../following-sibling::td//button[@class='"+text1+"']");}
	public By Btn_DeleteIconInTags(String id,String text,String text1) {return By.xpath("//table[@id='"+id+"']/tbody/tr/td/p[text()='"+text+"']/../following-sibling::td//button[@class='"+text1+"']");}
	public By Btn_ConfirmationMessageCloseButton(String text, String text1) {return By.xpath("//div[@class='"+text+"']//button[@id='"+text1+"']");}
	public By Btn_Edit(String text, int index) { return By.xpath("//label[text()='"+text+"']/../..//child::td["+index+"]//button"); }
	
	//Ele
	public By Ele_TagsName(String text) { return By.xpath("//label[@id='"+text+"']");}
	public By Ele_UpdateTag(String text2) {return By.xpath("//div[@id='addTaglist']//div[@class='"+text2+"']");}
	public By Ele_UpdateName(String text) {return By.xpath("//table[@id='customTagTable']/tbody/tr[2]/td[@class='"+text+"']/label");}
	public By Ele_Tagframe(String text) { return By.xpath("//section[@class='"+text+"']"); }
	public By Ele_AddIconInTags(String text,String tagName) { return By.xpath("//button[@id='"+text+"']/"+tagName+""); }
	public By Ele_TagName(String text) { return By.xpath("//table/tbody/tr/td/label[text()='"+text+"']"); }
	public By Ele_TagListName(String text, String text1) { return By.xpath("//div[@class='"+text+"']//span[@id='"+text1+"']"); }
	public By Ele_ListOfTagNames(String text) { return By.xpath("//div[@class='"+text+"']/table//tr/td/label"); }
	public By Ele_DelTagsName(String text) { return By.xpath("//label[text()='"+text+"']");}
}

