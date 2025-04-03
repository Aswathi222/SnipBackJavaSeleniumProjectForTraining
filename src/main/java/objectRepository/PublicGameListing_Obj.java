package objectRepository;
import org.openqa.selenium.By;

public class PublicGameListing_Obj {
	public By Btn_Home(String text1,String className) { return By.xpath("//a[text()='"+text1+"' and @class='"+className+"' ] "); }
	public By Btn_Menu(String text1,String className) { return By.xpath("//a[text()='"+text1+"' and contains(@class,'"+className+"')] "); }
	public By Ele_Date(String text1,String text2) { return By.xpath("//div[text()='"+text1+"']//span[text()='"+text2+"'] "); }
	public By Ele_GameDate(int index, String value) {return By.xpath("(//span[@class='" + value + "'])[" + index + "]");}
	
}
