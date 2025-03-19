package objectRepository;
import org.openqa.selenium.By;

public class FilterMembers_Obj 

{	
	//Ele
	public By Ele_AllRoles(String role) { return By.xpath("//p[@id='"+role+"']"); }
	//Chk
	public By Chk_FilterRole(String role) { return By.xpath("//div[@class='checkbox-wrapper']/label[contains(text(),'"+role+"')]/span");}
	public By Chk_FilterAll(String id) { return By.xpath("//div[@class='"+id+"']/div[5]//span"); }
 
}	

