package objectRepository;
import org.openqa.selenium.By;

public class HighlightReels_Obj 
{
	//Btn
	public By Btn_HL(String id1, String class1) { return By.xpath("//div[@id='"+id1+"']//div[@class='"+class1+"']");}
	public By Btn_HL_Popup(String class1) { return By.xpath("//div[@class='"+class1+"' and contains(@style, 'display: block;')]");}
	public By Btn_icon(String class1, String class2) { return By.xpath("//a[@class='"+class1+"']//i[@class='"+class2+"']");}
	public By Btn_Music(String music) {return By.xpath("//button[@data-bs-target='"+music+"']");}
	public By Btn_HRSave(String text1, String text2) { return By.xpath("//button[@style='"+text1+"']/../button[text()='"+text2+"']");}
	public By Btn_Delete(String text1,String text2){ return By.xpath("//a[@class='"+text1+"'and @title='"+text2+"']");}
	public By Btn_Music(String class1, String id1) { return By.xpath("//div[@class='"+class1+"']//h2[@id='"+id1+"']");}	
	public By Btn_Game(String class1, String text1) { return By.xpath("//div[@class='"+class1+"']//a[text()='"+text1+"']");}	
	public By Btn_Edit(String class1, String text1) { return By.xpath("//ul[@class='"+class1+"']//li[text()='"+text1+"']");}	
	public By Btn_EditHighlt(String text) {return By.xpath("//h3[text()='"+text+"']");}
	public By Btn_Cancel(String class1, String text1,String text2) { return By.xpath("//div[@class='"+class1+"']//button[@class='"+text1+"' and text()='"+text2+"']");}	
	public By Btn_Del(String text) {return By.xpath("//div[@class='"+text+"'][1]");}
	public By Btn_AutoGame(String class1, String text1,String text2) { return By.xpath("//div[@class='"+class1+"']//a[@class='"+text1+"' and text()='"+text2+"']");}	
	
	
		//Ele
	public By Ele_ExtroSubHeaderMedium(String text) { return By.xpath("//textarea[@class='"+text+"']");}	
	public By Ele_Social_Media(String class1, String id1) { return By.xpath("//span[@class='"+class1+"']//img[@src='"+id1+"']");}
	public By Ele_HighlightReelsPlus(String class1, String class2) { return By.xpath("//a[@class='"+class1+"']//i[@class='"+class2+"']");}
	public By Ele_HighlightReelsPopup(String class1, String text) { return By.xpath("//div[@class='"+class1+"']//div[text()='"+text+"']");}
	public By Ele_HighlightReelsDrop(String text) { return By.xpath("//button[normalize-space(text())='"+text+"']");}
	public By Ele_LogoMessage(String text,String text1) { return By.xpath("//h3[text()='"+text+"']/span[@id='"+text1+"']"); }  
	public By Ele_ExtroSubheaderClose(String text,String text1) { return By.xpath("//h3[text()='"+text+"']//following::a[@class='"+text1+"']"); }
	public By Ele_ExtroHeader(String id1, String name1) { return By.xpath("//input[@id='"+id1+"' and @name='"+name1+"']");}
	public By Ele_ExtroSubHeader(String name1, String id1) { return By.xpath("//textarea[@name='"+name1+"' and @id='"+id1+"']");}
	public By Ele_IntroClear(String class1) { return By.xpath("(//a[@onclick='"+class1+"'])[1]");}
	public By Ele_Subheader(String text) {return By.xpath("//textarea[@name='"+text+"']");}
	public By Ele_Audio(String audio) {return By.xpath("//option[@data-url='"+audio+"']");}
	public By Ele_Seek(String seek) {return By.xpath("//audio[@id='"+seek+"']");}
	public By Ele_HighlightReelsName(String class1,String text1) { return By.xpath("//div[@class='"+class1+"']//div[normalize-space(text())='"+text1+"']");}		
	public By Ele_InvalidIntro(String class1) { return By.xpath("(//button[@class='"+class1+"'])[1]");}
	public By Ele_SignupField(String value) { return By.xpath("//input[@value='"+value+"']");}	
		//chk
	public By Chk_HighlightReelsPublic(String class1, String class2) { return By.xpath("//label[normalize-space(text())='"+class1+"']//span[@class='"+class2+"']");}
	public By Chk_PrivateRadioButton(String id,String tag,String text){ return By.xpath("//input[@id='"+id+"']/following-sibling::"+tag+"[@class='"+text+"']"); } 
  
		//Ddl
	public By Ddl_SnipbackThemeDropDown(String class1, String class2) { return By.xpath("//div[@class='"+class1+"']//select[@class='"+class2+"']");}

	//Img
	public By Img_SnipImg(String id){ return By.xpath("//form[@id='"+id+"']//i");  }  
	public By Img_Logo(String text,String text1){ return By.xpath("//h3[text()='"+text+"']//i[@class='"+text1+"']");  } 
	
	
}
