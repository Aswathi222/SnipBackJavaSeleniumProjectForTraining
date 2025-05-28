package objectRepository;

import org.openqa.selenium.By;

public class ViewProfile_Obj {

	//Ddl
	public By Ddl_Profile(String profiledrpdwn1, String profiledrpdwn2) { return By.xpath("//ul[@class='"+profiledrpdwn1+"']//button[@class='"+profiledrpdwn2+"']"); }

	//Ele
	public By Ele_ViewProfile(String profiledrpdwn1, String profiledrpdwn2) { return By.xpath("//div[@class='"+profiledrpdwn1+"']//a[text()='"+profiledrpdwn2+"']"); }
	public By Ele_Alert(String profilealrt) { return By.xpath("//div[@id='"+profilealrt+"']"); }

	//Btn
	public By Btn_ViewProfile(String profilebtn1, String profilebtn2) { return By.xpath("//div[@class='"+profilebtn1+"']//button[@class='"+profilebtn2+"']"); }
}
