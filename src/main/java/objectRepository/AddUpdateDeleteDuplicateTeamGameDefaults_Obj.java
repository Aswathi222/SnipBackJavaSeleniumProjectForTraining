package objectRepository;

import org.openqa.selenium.By;

public class AddUpdateDeleteDuplicateTeamGameDefaults_Obj
{
	//Ele
	public By Ele_Memberandfollower(String heading1) {return By.xpath("//h3[contains(text(),'"+heading1+"')]");}	
	public By Ele_CurrentTeamMembers(String heading1) {return By.xpath("//h2[contains(text(),'"+heading1+"')]");}
	public By Ele_CheckboxSelect(String DataSizeValue1,String Classvalue1) {return By.xpath("//li[@data-size='"+DataSizeValue1+"']//span[@class='"+Classvalue1+"']");}
}
