package objectRepository;
import org.openqa.selenium.By;

public class DuplicateTeam_Obj 

{	

	//Ele
	public By Ele_DashboardHeaderLink(String text) { return By.xpath("//ul[@class='navbar-nav ms-auto']//a[@href='"+text+"']"); }
	public By Ele_ThreeDotsOfTeam(String text,int index) { return By.xpath("(//div[@class='"+text+"'])["+index+"]"); }
	public By Ele_ThreeDotsOfTeamDropDownItems(String text,int index,String text1) { return By.xpath("(//div[@class='"+text+"'])["+index+"]//a[@class='"+text1+"']"); }
	public By Ele_TeamName(String text) { return By.xpath("//span[@class='"+text+"']/.."); }
	public By Ele_ThreeDotMenuOfTeamBasedOnTeamName(String text,String text1) { return By.xpath("//span[text()='"+text+"']/../following-sibling::div[@class='"+text1+"']"); }
	public By Ele_EditTeamBasedOnTeamName(String text,String text1) { return By.xpath("//span[text()='"+text+"']/../following-sibling::div//a[text()='"+text1+"']"); }
	public By Ele_HomeDefaultsList(String text,int index,String text1) { return By.xpath("//div[@class='"+text+"']/div["+index+"]//"+text1+""); }
	public By Ele_EditTeamPageHeader(String text,String tagName) { return By.xpath("//span[@id='"+text+"']/following-sibling::"+tagName+""); }
}

