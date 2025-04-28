package objectRepository;

import org.openqa.selenium.By;

public class AddorEditInfo_Obj {
	public By Ele_ThreeDots(String text,String classDots){return By.xpath("//a[normalize-space(text())='"+text+"']/../../..//div[@class='"+classDots+"']");}
	public By Ele_ThreeDotsText(String textDots,String textDotAI){return By.xpath("//a[normalize-space(text())='"+textDots+"']/../../..//a[normalize-space(text())='"+textDotAI+"']");}
	public By Ele_AddInfoText(String addInfoText){return By.xpath("//label[normalize-space(text())='"+addInfoText+"']");}
	public By Ele_ThreeDotsOnClick(String textDots,String textDotEdit){return By.xpath("//a[normalize-space(text())='"+textDots+"']/../../..//a[contains(@onclick,'"+textDotEdit+"')]");}
}
