package objectRepository;

import org.openqa.selenium.By;

public class CreateAndAddNewMemberWithOrWithoutEmail_Obj {	
	
	//Btn
	public By Btn_Team(String Team_id, String Team_text) {return By.xpath("//div[@id='"+Team_id+"']//span[text()='"+Team_text+"']");}
	public By Btn_ThreeDots(String ThreeDots_id1, String ThreeDots_id2) {return By.xpath("//div[@id='"+ThreeDots_id1+"']//a[@id='"+ThreeDots_id2+"']");}
	public By Btn_EditTeam(String EdtTeam_dataname) {return By.xpath("//a[@data-name='"+EdtTeam_dataname+"']");}
	//Ele	
	public By Ele_list(String Ele_list_id1, String Ele_list_id2) {return By.xpath("//div[@id='"+Ele_list_id1+"']//div[@id='"+Ele_list_id2+"']");}
	public By Ele_SearchGame(String Edt_TeamNameClass) {return By.xpath("//input[@class='"+Edt_TeamNameClass+"']");}
	//Edt
	public By Edt_TextArea(String TextArea_id) {return By.xpath("//textarea[@id='"+TextArea_id+"']");}	
	//Ddl
	public By DdlOrg(String HomeClass) {return By.xpath("//select[@class='"+HomeClass+"']");}
}
