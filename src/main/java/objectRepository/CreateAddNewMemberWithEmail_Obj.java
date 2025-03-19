package objectRepository;

import org.openqa.selenium.By;

public class CreateAddNewMemberWithEmail_Obj {
	//Ele
	public By Ele_DropdownOrganisation(String text) {return By.xpath("//select[@class='"+text+"']//option[text()='AA Q-Dev - 2054']");}
	public By Ele_SelectTeam(String text) {return By.xpath("//a[@id='defaultDropdown-2']//i[@class='"+text+"']");}
	public By Ele_SelectTeam2(String text) {return By.xpath("//span[text()='"+text+"']/../..//div[@class='dropdown-wrapper teams-menu']");}
	public By Ele_SelectTeam2(String text,String classname) {return By.xpath("//span[text()='"+text+"']/../..//div[@class='"+classname+"']");}
	public By Ele_EditTeam(String text) {return By.xpath("//a[@id='"+text+"']");}
	public By Ele_SavedMemberRole(String text) {return By.xpath("//div[@for='teamCheckBox-15919']//p[@class='members-listing-content teamRole'][normalize-space()='"+text+"']");}
	public By Ele_RolesOfTheMembers(String MemberName,String Role) {return By.xpath("//button[text()='"+MemberName+"']/..//p[contains(text(),'"+Role+"')]");}
	public By Ele_MembersSearch(String MemberSearch) {return By.xpath("//div[@class='input-group position-relative-block']//input[@class='"+MemberSearch+"']");}
	public By Ele_AddUserMessagebox(String text) { return By.xpath("//textarea[@id='"+text+"']"); }
	public By Ele_Dropdots(String text,String id) { return By.xpath("//span[text()='"+text+"']/../..//a[@id='"+id+"']"); }
	public By Ele_Edit(String text,String id) { return By.xpath("//a[@id='"+text+"']/..//a[text()='"+id+"']"); }
	public By Ele_AddUserWithoutEmailtitle(String text) { return By.xpath("//h6[contains(text(),'"+text+"')]"); }
	public By Ele_ErrorMsgFName(String text) { return By.xpath("//li[contains(text(), \"" + text + "\")]"); }

	public By Ele_AlertText(String text) { return By.xpath("//li[(contains(text(),'"+text+"'))]"); }
	public By Ele_AlertName(String text) { return By.xpath("//div[text()='"+text+"']/../..//li"); }
	public By Ele_CrossMark(String text,String classname) { return By.xpath("//div[text()='"+text+"']/../..//i[@class='"+classname+"']"); }
	public By Ele_Heading(String text) { return By.xpath("//h6[text()='"+text+"']"); }
	public By Ele_EditTitle(String text) {return By.xpath("//h4[contains(text(),'"+text+"')]"); }
	public By Ele_CommonError(String a, String b) {return By.xpath("//input[@id='"+a+"']/..//span[@class='"+b+"']");}
	public By Ele_CommonErrorClick(String id1, String class1, String text1) {return By.xpath("//div[@id='"+id1+"']//div[@class='"+class1+"']//h6[text()='"+text1+"']");}
	public By Chk_TeamMembers(String text, String text1){ return By.xpath("//button[text()='"+text+"']/../../..//input[contains(@id,'"+text1+"')]"); } 
	public By Ele_FullNameField(String text, String text1){ return By.xpath("//div[@class='"+text+"']//input[@name='"+text1+"']"); } 
	public By Ele_UserRole(String id) { return By.xpath("//input[@id='"+id+"' and @disabled]"); }
	
	//Btn
	public By Btn_EditBtn(String a, String b, String c) {return By.xpath("//span[text()='"+a+"']/../..//div[@class='"+b+"']//div//a[text()='"+c+"']");}
	public By Btn_CloseBtn(String class1, String text, String class2) {return By.xpath("//div[@class='"+class1+"']/div[text()='"+text+"']/following-sibling::button[@class='"+class2+"']");}
}

