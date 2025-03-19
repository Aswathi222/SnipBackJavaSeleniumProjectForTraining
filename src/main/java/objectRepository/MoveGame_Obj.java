package objectRepository;
import org.openqa.selenium.By;

public class MoveGame_Obj 

{	
	//Btn
	public By Btn_Master_Film(String class1, String text) {return By.xpath("//li[@class='"+class1+"']/..//following-sibling::a[text()='"+text+"']");}		
	public By Btn_Master_Games(String class1, String text) {return By.xpath("//span[@class='"+class1+"']/..//following-sibling::span[text()='"+text+"']");}   
	public By Btn_Select_TeamName(String text, String class1) {return By.xpath("//span[text()='"+text+"']/../..//following-sibling::div[@class='"+class1+"']");}
	public By Btn_SelectEventsPrcaticeScout(String class1,String text1) {return By.xpath("//button[@class='"+class1+"']/..//following-sibling::button[text()='"+text1+"']");}

	//public By Btn_GameName(String class1,String text1) {return By.xpath("//a[@class='"+class1+"']/../..//following-sibling::a[text()='"+text1+"']");}
	public By Btn_GameName(String class1,String text1) {return By.xpath("//a[@class='"+class1+"']/../..//following-sibling::a[normalize-space(text())='"+text1+"']");}
	
	public By Btn_GamesNameThreeDots(String text) {return By.xpath("//a[text()='"+text+"']/../..//following-sibling::button");}
	
	public By Btn_PopUpGameMode(String class1,String text1) {return By.xpath("//div[@class='"+class1+"']/..//following-sibling::div[text()='"+text1+"']");}
	public By Btn_Video_CreateSnip(String class1,String class2) {return By.xpath("//div[@class='"+class1+"']/..//following-sibling::i[@class='"+class2+"']");}
	public By Btn_Video_CreateMySnip(String class1,String text) {return By.xpath("//ul[@class='"+class1+"']/..//following-sibling::button[text()='"+text+"']");}
	public By Btn_Video_CreateBtnSnip(String class1,String text) {return By.xpath("//div[@class='"+class1+"']/..//following-sibling::button[normalize-space(text())='"+text+"']");}
	public By Btn_Video_SnipDetails(String class1,String text) {return By.xpath("//div[@class='"+class1+"']/..//following-sibling::label[normalize-space(text())='"+text+"']");}
	
	public By Btn_3Dots(String text1) {return By.xpath("//a[normalize-space(text())='"+text1+"']/../../..//button[@id='dropdownMenuButton1']");}
	
	public By Btn_Disabled(String text1,String text2) {return By.xpath("//div[@class='"+text1+"']//div[text()='"+text2+"']");}
	
	//Ddl
	public By Ddl_DropDownMoveGame(String class1,String text1) {return By.xpath("//div[@class='"+class1+"']//child::a[text()='"+text1+"']");}
	public By Ddl_PopUpDropDownOrg(String class1,String class2) {return By.xpath("//div[@class='"+class1+"']//child::li[@class='"+class2+"']");}
	public By Ddl_PopUpDropDownOrg2(String class1,String text) {return By.xpath("//ul[@class='"+class1+"']//li[normalize-space(text())='"+text+"']");}
	
	//Ele
	public By Ele_EditTeamAgainstFirstGame(String text) { return By.xpath("./../following-sibling::td//button/following-sibling::div//a[text()='"+text+"']"); }
	public By Ele_HeaderOfPopup(String text,String tagName) { return By.xpath("//div[@id='"+text+"']//"+tagName+""); } 
	public By Ele_OrganisationAndGameModeInPopup(String text,String text1) { return By.xpath("//div[@id='"+text+"']//div[@class='"+text1+"']/p"); } 
 	public By Ele_OrganisationSelectionArrowInMoveGamePopup(String text,String tagName) { return By.xpath("//label[@for='"+text+"']/"+tagName+""); } 
	public By Ele_ListOfGameModesInMoveGamePopup(String id,String tagName) { return By.xpath("//div[@id='"+id+"']/"+tagName+""); } 
	public By Ele_TagNameGame(String class1) {return By.xpath("(//div[@class='"+class1+"']//div[@class='custom-tag-list-item' and @ishome='1']//div)[1]");}
	public By Ele_ConfirmSnipTag(String class1, String text) {return By.xpath("//section[@class='"+class1+"']//p[text()='"+text+"']");}
	public By Ele_FrameTextMatch(String id, String text) {return By.xpath("//div[@id='"+id+"']//div[text()='"+text+"']");}
	public By Ele_FrameCount(String id) {return By.xpath("//div[@id='"+id+"']/div");}
	public By Ele_AdFeatures(String text1) {return By.xpath("//p[@class='"+text1+"']");}
	
}

