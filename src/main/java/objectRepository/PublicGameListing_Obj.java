package objectRepository;
import org.openqa.selenium.By;

public class PublicGameListing_Obj {
	public By Btn_Home(String text1,String text2) { return By.xpath("//a[text()='"+text1+"' and @class='"+text2+"' ] "); }
	public By Btn_Menu(String text1,String text2) { return By.xpath("//a[text()='"+text1+"' and contains(@class,'"+text2+"')] "); }
	public By Ele_Date(String text1,String text2) { return By.xpath("//div[text()='"+text1+"']//span[text()='"+text2+"'] "); }
	
	
}
