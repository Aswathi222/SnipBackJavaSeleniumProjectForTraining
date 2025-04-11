package objectRepository;

import org.openqa.selenium.By;

public class CreateAndAddNewMemberWithOrWithoutEmail_Obj {	
	//Btn
	public By DdlOrg(String HomeClass) {return By.xpath("//select[@class='"+HomeClass+"']");}
	public By Btn_ThreeDots(String ThreeDotsid, String ThreeDots_id) {return By.xpath("//div[@id='"+ThreeDotsid+"']//a[@id='"+ThreeDots_id+"']");}
	public By Btn_EditTeam(String EdtTeam_dataname) {return By.xpath("//a[@data-name='"+EdtTeam_dataname+"']");}
	//Ele	
	public By Ele_list(String Ele_listid, String Ele_list_id) {return By.xpath("//div[@id='"+Ele_listid+"']//div[@id='"+Ele_list_id+"']");}
	//Edt
	public By Ele_SearchGame(String Edt_TeamNameClass) {return By.xpath("//input[@class='"+Edt_TeamNameClass+"']");}
	public By Edt_TextArea(String TextArea_id) {return By.xpath("//textarea[@id='"+TextArea_id+"']");}	
}
