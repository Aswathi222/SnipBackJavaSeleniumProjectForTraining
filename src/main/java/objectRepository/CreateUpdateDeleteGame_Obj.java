package objectRepository;
import org.openqa.selenium.By;

public class CreateUpdateDeleteGame_Obj 

{	
	//Btn
	public By Btn_GThreeDots(String text)  {return By.xpath("//a[normalize-space(text())='"+text+"']/../..//following-sibling::td//button"); }
	public By Btn_Create(String c, String d) {return By.xpath("//button[@class='"+c+"']/..//button[@class='"+d+"']");}
	public By Btn_Film(String text1,String text2) {return By.xpath("//li[@class='"+text1+"']//a[text()='"+text2+"']");}
	public By Btn_Team(String team) {return By.xpath("//ul[@class='"+team+"']");}
	public By Btn_CreateTeam(String create) {return By.xpath("//i[@id='"+create+"']");}
	public By Btn_CreateGameButton(String text,String text1) { return By.xpath("//div[@id='"+text+"']//button[text()='"+text1+"']"); }
	public By Btn_UpdateButtonInEditGame(String text,String text1) { return By.xpath("//div[@class='"+text+"']//button[text()='"+text1+"']"); }
	public By Btn_GameType(String text,String game) { return By.xpath("//div[@id='"+text+"']//div[@id='"+game+"']"); }
	public By Btn_Delete(String text1,String text2){ return By.xpath("//div[@class='"+text1+"']//child::a[text()='"+text2+"']");  }
	public By Btn_CREATE(String text1,String text2){ return By.xpath("//button[@class='"+text1+"' and text()='"+text2+"']");  }
	//Ele
	public By Ele_CreateGamePopUp(String text)  { return By.xpath("//h3[contains(text(),'"+text+"')]"); }
	public By Ele_TeamSelect(String teamname) { return By.xpath("//div[contains(@class,'search-result-wrap mt-')]//span[text()='"+teamname+"']"); }
	public By Ele_Room(String text) { return By.xpath("//a[@id='"+text+"']"); }
	public By Ele_Time(String time) {return By.xpath("//li[@class='"+time+"']");}
	public By Ele_FirstTeamName(String text) { return By.xpath("(//div[@id='"+text+"']/div/div)[1]"); }
	public By Ele_CreateGameTitle(String text) { return By.xpath("//h3[@class='"+text+"']"); }
	public By Ele_ThreeDotBasedOnGameName(String gameName) { return By.xpath("//a[text()='"+gameName+"']/../following-sibling::td//button[@id='dropdownMenuButton1']"); }
	public By Ele_ThreeDotDeleteBasedOnGameName(String gameName) { return By.xpath("//a[text()='"+gameName+"']/../following-sibling::td//button[@id='dropdownMenuButton1']/following-sibling::div//a[text()='Delete']"); }
	public By Ele_Category(String data) {return By.xpath("//li[@data-name='"+data+"']");}
	public By Ele_EditGameHeader(String text,String text1) { return By.xpath("//div[@id='"+text+"']//"+text1+""); }
	public By Ele_CheckPublicorPrivate(String id,String cls, String text) { return By.xpath("//div[@id='"+id+"']//div[@class='"+cls+"' and text()='"+text+"']");}
	public By Ele_DropdownClick(String cls,String cls1) { return By.xpath("//div[@class='"+cls+"']//li[@class='"+cls1+"'] ");}
	public By Ele_DropdownDetails(String cls,String cls1, String cls2, String text) { return By.xpath("//div[@class='"+cls+"']//ul[@class='"+cls1+"']//li[@class='"+cls2+"' and normalize-space(text())='"+text+"']");}
	public By Ele_OtherTeam(String cls, String index) { return By.xpath("(//ul[@class='"+cls+"']//li)['"+index+"']");}

	//Ddl
	//public By Ddl_FacilityCamera(String id, String value) { return By.xpath("//div[@id='"+id+"']//span[text()='"+value+"']"); }
	public By Ddl_CategoryOpt(String text, String id) {return By.xpath("//div[@class='"+text+"']//div[@id='"+id+"']"); }

}
