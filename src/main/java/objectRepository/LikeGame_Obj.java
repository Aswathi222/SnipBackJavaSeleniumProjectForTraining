package objectRepository;

import org.openqa.selenium.By;

public class LikeGame_Obj 
{
	//Ele
	public By Ele_LikeButton(String class1, String text1) { return By.xpath("//i[@class='"+class1+"' or @class='"+text1+"' ]");}
	public By Ele_LikedFilm(String class1,String text1) {return By.xpath("//input[@id='"+class1+"']/../..//following-sibling::label[text()='"+text1+"']");}
}
