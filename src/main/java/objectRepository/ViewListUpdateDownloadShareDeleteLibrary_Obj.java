package objectRepository;
import org.openqa.selenium.By;

public class ViewListUpdateDownloadShareDeleteLibrary_Obj 

{	

	//Ele 
	public By Ele_Reels(String text) { return By.xpath("//table[@class='"+text+"']"); }
	public By Ele_Shareoptions(String text) {return By.xpath("//div[@class='smd']//i[@class='"+text+"']");}
	public By Ele_LinkMsg(String text) {return By.xpath("//div[@id='reelSocialShareModal']//span[@class='"+text+"']");}
	public By Ele_WhiteRow() {return By.xpath("//tr//th[@class='text-center']/following-sibling::th[@class='game-wrap']/following-sibling::th[@class='text-left status-head']/following-sibling::th[@class='text-center status-head']");}
	public By Ele_Sub(String name, String subname) {return By.xpath("//h5[text()='"+name+"']/../..//label[text()='"+subname+"']");}
	public By Ele_ReelsDelete(String id,String text) { return By.xpath("//a[@onclick='"+id+"']//i[@class='"+text+"']"); }
	public By Ele_Name(String name) {return By.xpath("//u[text()='"+name+"']");}
	public By Ele_Team(String a , String b) {return By.xpath("//div[@class='"+a+"']//span[text()='"+b+"']");}
	public By Ele_File(String a) {return By.xpath("//h4[@class='"+a+"']");}
	
	//Btn
	public By Btn_Share(String a , String text) {return By.xpath("//tr[@id='"+a+"']//i[@class='"+text+"']");}
	public By Btn_CopiedLink(String text) {return By.xpath("//button[@class='cpy reelCopy-shareurl']//i[@class='"+text+"']");}
	public By Btn_Rename(String a, String b){ return By.xpath("//u[text()='"+a+"']/../..//a[@title='"+b+"']"); } 
	public By Btn_Download(String gamedownload) {return By.xpath("//tbody/tr/td[5]/u[text()='"+gamedownload+"']/../following-sibling::td//a[2]");}
	public By Btn_Sharereel(String gameshare) {return By.xpath("//tbody/tr/td[5]/u[text()='"+gameshare+"']/../following-sibling::td//a[3]");}
	public By Btn_elete(String gamedelete) {return By.xpath("//tbody/tr/td[5]/u[text()='"+gamedelete+"']/../following-sibling::td//a[2]");}
	public By Btn_Icon(String share,String icon) {return By.xpath("//div[@class='"+share+"']//i[@class='"+icon+"']");}
	public By Btn_Close(String close,String button) {return By.xpath("//h5[text()='"+close+"']/..//button[@class='"+button+"']");}
	public By Btn_ShareClose(String text) {return By.xpath("//div[@id='reelSocialShareModal']//span[text()='"+text+"']");}
	public By Btn_ReelsCancel(String id,String text) { return By.xpath("//button[@class='"+id+"' and text()='"+text+"']"); }
	public By Btn_WBDlete(String text) {return By.xpath("//a[@title='Delete']");}

}	

