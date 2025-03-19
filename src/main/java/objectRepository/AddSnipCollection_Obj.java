package objectRepository;
import org.openqa.selenium.By;

public class AddSnipCollection_Obj 

{	
	//Ele 
	public By Ele_Checkbox(String text) { return By.xpath("//label[@class='"+text+"']"); }
	public By Ele_CustomTag(String text) { return By.xpath("//li[@id='tabcontent-game-org-collection']//div[@class='custom-tag-label' and text()='"+text+"'] "); }
	public By Ele_HomeCollection(String text) { return By.xpath("//li[@id='tabcontent-home-org-collection']//div[text()='"+text+"']"); }
	public By Ele_Snip(String text) { return By.xpath("//div[@class='each-shot  selected-pined1 foredshot1']//div[text()='"+text+"']"); }
	public By Ele_PlusIcon(String text) { return By.xpath("//div[contains(@class, '"+text+"')]"); }
	public By Ele_OrgCollection(String class1, String text) { return By.xpath("//ul[@class='"+class1+"']//li[text()='"+text+"']"); }
	public By Ele_SelAllCheckBox(String text, String class1) { return By.xpath("//p[text()='"+text+"']/following-sibling::input[@class='"+class1+"']"); }
	public By Ele_SnipCollection(String class1, String text) { return By.xpath("//div[@class='"+class1+"']//div[@data-value='"+text+"']"); }
}

