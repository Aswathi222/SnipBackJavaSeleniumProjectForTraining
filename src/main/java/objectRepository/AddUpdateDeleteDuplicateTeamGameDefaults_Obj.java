package objectRepository;

import org.openqa.selenium.By;

public class AddUpdateDeleteDuplicateTeamGameDefaults_Obj 
{

	//Btn
	public By Btn_TeamTick(String id, String clas) {return By.xpath("//button[@id='"+id+"']//i[@class='"+clas+"']"); }
	public By Btn_TeamAddAlertClose(String id) { return By.xpath("(//button[@id='"+id+"'])[1]"); }
	public By Btn_Close(String x,String y) {return By.xpath("//section[@class='"+x+"']//button[@id='"+y+"']");}
	public By Btn_GameDefaults(String text){ return By.xpath("//div[@class='btn-wrap']/button[@class='"+text+"']");  }
	public By Btn_DuplicateTeam(String text) {return By.xpath("//div[@id='teamDropdownMenu-1']//a[text()='"+text+"']");}
	public By Btn_AddUserTeam(String b,String c) {return By.xpath("//a[@class='"+b+"']//span[text()='"+c+"']");}
	public By Btn_Save(String j,String i) {return By.xpath("//button[@class='"+j+"']//img[@src='"+i+"']");}
	
	//Ele
	public By Ele_EditTeam(String z) {return By.xpath("//a[@data-name='"+z+"']");}
	public By Ele_TeamIcons(String g,String h) {return By.xpath("//div[@id='"+g+"']//i[@class='"+h+"']");}
	public By Ele_DuplicateTeamAlert(String text) { return By.xpath("//p[contains(text(),'"+text+"')]"); }
	public By Ele_TeamName(String id, String text) { return By.xpath("//div[@id='"+id+"']//input[@type='"+text+"']"); }	
	public By Ele_CurrentMembersTitle(String clas) {return By.xpath("//h2[@class='"+clas+"']");  }
	public By Ele_TeamAddedSuccessfully(String id,String text) { return By.xpath("//p[@id='"+id+"' and text()='"+text+"']"); }
	public By Ele_CrossTick(String j,String i) {return By.xpath("//button[@class='"+j+"']//i[@class='"+i+"']");}
	public By Ele_Success(String a,String b) {return By.xpath("//div[@class='"+a+"']//p[text()='"+b+"']");}
	public By Ele_SettingsInGameDefaultsHeader(String text) { return By.xpath("//div[@class='"+text+"']/h3"); }
	public By Ele_AwayDefaultList(String text) { return By.xpath("//div[@class='"+text+"']//div[@class='mb-3 d-flex justify-content-between']/p"); }
	public By Ele_GameModeOptions(String text,String text1) { return By.xpath("//p[text()='"+text+"']/../div[@id='"+text1+"']/div"); }
	public By Ele_DuplicateTitle(String text) {return By.xpath("//div[@id='duplicateTeamModal']//h5[@class='"+text+"']");}
	public By Ele_CurrentTeamtext(String text) {return By.xpath("//h2[text()='"+text+"']");}
	public By Ele_Selecttype(String id,String text) {return By.xpath("//select[@id='"+id+"']//child::option[text()='"+text+"']");}
	public By Ele_SelectRoomList(String text) { return By.xpath("//div[@id='"+text+"']/p"); }
	public By Ele_SelectRoomListHeader(String text,String text1) { return By.xpath("//div[@id='"+text+"']//h6[@id='"+text1+"']"); }
	public By Ele_SelectRoomListEachElement(String text,int value) { return By.xpath("(//div[@id='"+text+"']/p)["+value+"]"); }
	public By Ele_SelectCameraCheckBoxText(String text,int checkBoxNo,String tagName) {return By.xpath("(//div[@id='"+text+"']//span)["+checkBoxNo+"]/following-sibling::"+tagName+"");}
	public By Ele_HomeSelection(String text) {return By.xpath("//div[@class='toggle-item active' and text()='"+text+"']");}
	public By Ele_DurationSelect(String id, String text) {return By.xpath("//option[@class='"+id+"' and text()='"+text+"']");}
	public By Ele_DelTeam(String text1, String text2) {return By.xpath("//span[text()='"+text1+"']/../following-sibling::div//a[text()='"+text2+"']");}

	//Ddl
	public By Ddl_TeamCategoryAddTeam(String id,String value) {return By.xpath("//select[@id='"+id+"']//option[@value='"+value+"']"); }
	public By Ddl_TeamDropdwn(String text,String text2)  { return By.xpath("//select[@class='"+text+"' and @id='"+text2+"']");  } 

	//Chk
	public By Chk_TeamAddFromList(int n) {return By.xpath("(//ul[@class='members-list-wrap get-newteam-users']/li//span[@class='checkmark'])["+n+"]");}
	public By Chk_SelectCameraCheckBox(String text,int checkBoxNo) {return By.xpath("(//div[@id='"+text+"']//span)["+checkBoxNo+"]");}
	public By Chk_TeamTick(String text,String z) {return By.xpath("//li[@data-size='"+text+"']//span[@class='"+z+"']");} 
	public By Chk_TeamTennisAddFromList(int n) {return By.xpath("(//ul[@class='members-list-wrap']/li//span[@class='checkmark'])["+n+"]");}
	public By Chk_TeamTennisAddFromListRight(int n) {return By.xpath("(//div[@class='bg-scroll col-lg-12']//input[@class='form-check-input checkRight'])["+n+"]");}
	//img
	public By Img_Save() {return By.xpath("//img[@src='https://snipback.com/assets/images/film/save-btn.svg']");}  
	
}
