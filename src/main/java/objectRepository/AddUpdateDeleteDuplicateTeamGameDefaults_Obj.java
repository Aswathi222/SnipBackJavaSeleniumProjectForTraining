package objectRepository;

import org.openqa.selenium.By;

public class AddUpdateDeleteDuplicateTeamGameDefaults_Obj
{
	//Ele
	public By Ele_Memberandfollower(String heading1) {return By.xpath("//h3[contains(text(),'"+heading1+"')]");}	
	public By Ele_CurrentTeamMembers(String heading1) {return By.xpath("//h2[contains(text(),'"+heading1+"')]");}
	public By Ele_CheckboxSelect(String DataSizeValue1,String Classvalue1) {return By.xpath("//li[contains(normalize-space(.),'"+DataSizeValue1 +"')]//span[@class='"+Classvalue1+"']");}
	public By Ele_Message(String text) {return By.xpath("//p[text()='"+text+"']");}
	public By Ele_SelectedDropdown(String Dropdownid,String text) {return By.xpath("//select[@id='"+Dropdownid+"']//option[text()='"+text+"']");}

	//Btn
	public By Btn_CloseClick(String Classvalue,String Closebuttonid) {return By.xpath("//div[@class='"+Classvalue+"']//button[@id='"+Closebuttonid+"']");}
}
