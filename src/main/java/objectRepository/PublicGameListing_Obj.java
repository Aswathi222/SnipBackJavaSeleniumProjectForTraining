package objectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class PublicGameListing_Obj 
{	
	//Ele
	public By Ele_LikesStatus(String text,String Text) {return By.xpath("//div//div[text()='"+text+"']/..//div[@class='views views-row']//div[contains(text(),'"+Text+"')]");}
	public By Ele_Views(String text) {return By.xpath("//div//div[text()='"+text+"']/..//div//div//div[@class='views-content']");}
	public By Ele_GameListingoptions(String text) {return By.xpath("//div[@id='navbarSupportedContent']/ul[@class='navbar-nav ms-auto']//a[text()='"+text+"']");}
	public By Ele_RArrow(String text) { return By.xpath("//div[@class='mainHead']//span[@class='redText' and contains(text(),'"+text+"')]/../..//section//button[@class='slick-next slick-arrow']"); }
	public By Ele_LArrow(String text) { return By.xpath("//div[@class='mainHead']//span[@class='redText' and contains(text(),'"+text+"')]/../..//section//button[@class='slick-prev slick-arrow']"); }
	public By Ele_SearchField(String text) {return By.xpath("//img[@class='"+text+"']"); }
	public By Ele_UpDownArrow(String text) {return By.xpath("//div[@class='fliter-textInput']//label[@for='"+text+"']");}	
	public By Ele_PublicGames(String text) {return By.xpath("//div[@class='todays']/div[@class='mainHead']//span[text()='"+text+"']");}
	public By Ele_GameHeader(String g) {return By.xpath("//header[@class='"+g+"']");}																																								
	public By Ele_Scrol(String data) {return By.xpath("//div[@data-gamename='"+data+"']");}
	
	//Img
	public By Img_GameClick(String v){return By.xpath("//img[@loading='"+v+"'][1]");}

	}	 


