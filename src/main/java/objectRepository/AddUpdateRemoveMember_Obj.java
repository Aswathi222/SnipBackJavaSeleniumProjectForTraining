package objectRepository;
import org.openqa.selenium.By;

public class AddUpdateRemoveMember_Obj 

{	
	//Ele 
	public By Ele_SearchGame(String text) { return By.xpath("//div[@id='"+text+"']//h5[text()='Share Game']"); }
	public By Ele_Team(String text) { return By.xpath("//li[@data-id='"+text+"']"); }
	public By Ele_Search(String text) { return By.xpath("//div[@id='"+text+"']//h5[text()='Share']"); }
	public By Ele_SearchExternally(String text) { return By.xpath("//div[@class='smd col-md-3']//i[@class='"+text+"']"); }
	public By Ele_EventLeftMenu(String text) {return By.xpath("//div[@class='dropdown-menu dropdown-menu-center show' and @aria-labelledby='"+text+"']"); }
	public By Ele_enable(String text) { return By.xpath("//button[@data-type='"+text+"']"); }
	public By Ele_MemberNav(String text) {return By.xpath("//nav[@class='"+text+"']");}
	public By Ele_Role(String text) {return By.xpath("//div[@class='form-check form-check-inline ']//label[@for='"+text+"']");}
	public By Ele_SearchMember(String text) {return By.xpath("//input[@class='"+text+"']");}
	public By Ele_PoolTitle(String title) {return By.xpath("//div[text()='"+title+"']/../..//div[@class='subcontent']/../..//div[@class='content home_content']");}
	public By Ele_MoveToPool(String a,String z) {return By.xpath("//tr[@class='game-row ']//a[text()='"+a+"']/../..//td[@class='text-right custom-text']//button[@class=' btn dropdown-toggle01 dot-menu mx-3']/..//div[@class='dropdown list-droupdown left-menu-wrap']/..//div[@class='dropdown-menu dropdown-menu-center show']//ul[@class='left-menu-list']//li//a[text()='"+z+"']");}
	public By Ele_TeamMemberRole(String text) {return By.xpath("(//p[@id='teamRole' and text()='"+text+"'])[2]");}//Player
	public By Ele_TeamMemberDetails(String roleName,String userDetails) {return By.xpath("(//p[@id='teamRole' and text()='"+roleName+"'])[2]/preceding-sibling::p[@id='"+userDetails+"']");}
	public By Ele_TeamMemberName(String memberName) {return By.xpath("//p[@id='teamName' and text()='"+memberName+"']");}
	public By Ele_ShareHeading(String a) {return By.xpath("//div[@class='modal fade show']//div[@class='modal-dialog']//div[@class='modal-content col-12']//div[@class='modal-header']//h5[text()='"+a+"']");}
	public By Ele_EditTeam(String text) {return By.xpath("//a[@onclick='"+text+"']");}
	public By Ele_Button(String className,String text){ return By.xpath("//div[@class='d-flex flex-column']//span[text()='"+text+"']"); } 
	public By Ele_ListTxt(String text){ return By.xpath("//div[@id='"+text+"']//h3");}
	public By Ele_ListOfMembersRoles(String memberDetails) {return By.xpath("//div[@id='teamDetailsDiv']/p[@id='"+memberDetails+"']");}
	public By Ele_DialogBoxPopUp(String text){ return By.xpath("//div[@class='swal-modal' and @role='"+text+"']");}
	public By Ele_DialogBoxPopUpTextMessage(String text){ return By.xpath("//div[@class='swal-modal' and @role='"+text+"']/div[@class='swal-text']");}
	public By Ele_ChooseFileUploaad(String text){return By.xpath("//a[@onclick='"+text+"' and text()='Upload Video']");}
	public By Ele_RemovedTeamMember(String text){ return By.xpath("//ul[@class='members-list-wrap']//div//h4[text()='"+text+"']");}
	public By Ele_CurrentTeamMembers(String text) {return By.xpath("//h2[text()='"+text+"']");}
	public By Ele_SelectTeamMember(String text) {return By.xpath("(//div[@id='teamDetailsDiv']//p[text()='"+text+"'])[2]");}
	public By Ele_GetJerseyNumber(String text) {return By.xpath("//span[@data-jersey='"+text+"']");}
	public By Ele_GetThreeDotsEvent(String text) {return By.xpath("//a[text()='"+text+"']//following::div[8]");}
	public By Ele_GetUploadVideo1(String text) {return By.xpath("(//a[text()='"+text+"'])[1]");}
	public By Ele_EventGameClick(String text) {return By.xpath("(//a[@class='"+text+"'])[1]");}
	public By Ele_Team3DotsClick(String id, String class1) {return By.xpath("//div[@id='"+id+"']//a[@class='"+class1+"']");} 
	public By Ele_Game(String id, String class1) {return By.xpath("//tr[@id='"+id+"']//a[@class='"+class1+"']");} 
	public By Ele_Pool(String text1, String text2) {return By.xpath("//div[@class='"+text1+"']//a[text()='"+text2+"']");}
	public By Ele_Home(String text1, String text2) {return By.xpath("//div[@class='"+text1+"' and text()='"+text2+"']");}
	public By Ele_GameLink(String text1, String text2) {return By.xpath("//a[@class='"+text1+"' and text()='"+text2+"']");}
	public By Ele_PoolCheck() {return By.xpath("//label[contains(text(),'SemTestPool1')]//input[@class='pool-check']//..//span[@class='checkmark']");}
	public By Ele_SearchExternally(String text, String text1) { return By.xpath("//div[@class='"+text+"']//i[@class='"+text1+"']"); }

	//Ddl
	public By Ddl_EmailTxt(String text) { return By.xpath("//ul[@id='"+text+"']//li"); }
	public By Ddl_Duration(String text1, String text2) {return By.xpath("//select[@class='"+text1+"']//option[text()='"+text2+"']");}
	public By Ddl_Email(String text1, String text2) {return By.xpath("//li[@class='"+text1+"']//a[text()='"+text2+"']");}
	public By Ddl_PoolOrg(String text1, String text2) {return By.xpath("//a[@class='"+text1+"']//span[text()='"+text2+"']");}

	//Btn
	public By Btn_PoolCreate(String text) {return By.xpath("//button[text()='"+text+"']/../..//div[@class='modal-footer border-0 flex-column1']");}
	public By Btn_Dots(String id) {  return By.xpath("//tr[@id='"+id+"']//button[@id='dropdownMenuButton1']"); }
	public By Btn_Close(String text) { return By.xpath("//div[@id='card_3']//button[@class='"+text+"']");} 
	public By Btn_Threedot(String text){ return By.xpath("//tr[@id='30631']//button[@id='"+text+"']");  }
	public By Btn_PoolThreeDots(String z,String t) {return By.xpath("//tr[@class='game-row ']//a[text()='"+z+"']/../..//td[@class='text-right custom-text']//button[@class='"+t+"']");}
	public By Btn_ShareInternalHeading(String h) {return By.xpath("//div[@class='type col-md-4 shareinternally']//a[@class='"+h+"']");}
	public By Btn_ActualShare(String x,String z) {return By.xpath("//div[@id='"+x+"']//button[@id='"+z+"']");}
	public By Btn_TeamThreeDot(String text) { return By.xpath("//div[@id='5380']//div[@class='"+text+"']"); }
	public By Btn_selectteam(String text) { return By.xpath("//div[@id='"+text+"']"); }
	public By Btn_DialogBox(String text) {return By.xpath("//button[@class='swal-button swal-button--confirm' and text()='"+text+"']");}
	public By Btn_Update(String text) { return By.xpath("//button[@class='"+text+"' and text()='UPDATE']");}
	public By Btn_CreateGame(String class1, String class2){return By.xpath("//div[@class='"+class1+"']//button[@class='"+class2+"']");}
	public By Btn_AdvanceFeaturesGame(String id, String text){return By.xpath("//div[@id='"+id+"']//div[text()='"+text+"']");}
	public By Btn_Dismiss(String clas, String text){return By.xpath("//button[@class='"+clas+"' and text()='"+text+"']");}
	public By Btn_CREATE(String clas, String text){return By.xpath("//div[@class='"+clas+"']//button[text()='"+text+"']");}
	public By Btn_ShareInternalHeading(String g, String h) {return By.xpath("//div[@class='"+g+"']//a[@class='"+h+"']");}

	//Chk
	public By Chk_TeamMembers(String text){ return By.xpath("//input[@id='"+text+"']/.."); } 
	public By Chk_Players(String tt,String ttt) {return By.xpath("//p[text()='"+tt+"']/..//span[@class='"+ttt+"']");}
	public By Chk_RightTeamMembers(String text){ return By.xpath("//li[@id='players_data_15849']//span[@class='"+text+"']/.."); } 
	public By Chk_EditTeamMembers(String text){ return By.xpath("//button[text()='"+text+"']/../../..//input[contains(@id,'teamCheckBox')]"); } 

	//sel
	public By Sel_Roll(String name){ return By.xpath("//select[@name='"+name+"']");}
	public By Sel_Selected(String id){return By.xpath("//select[@id='"+id+"']//option[@selected='selected']");}

}

