package objectRepository;
import org.openqa.selenium.By;

public class GameListing_Obj {
	
		//Btn
		public By Btn_Film(String class1,String text) {return By.xpath("//li[@class='"+class1+"']//a[text()='"+text+"']");}
		
		//Ele
		public By Ele_FilmBanner(String class1,String text) {return By.xpath("//div[@class='"+class1+"']//div[normalize-space(text())='"+text+"']");}	
		public By Ele_Sort(String class1,String class2) {return By.xpath("//img[@class='"+class1+"']/ancestor::div[@class='"+class2+"']");}
		
		//Ddl
		public By Ddl_Team(String class1,String id1) {return By.xpath("//div[@class='"+class1+"']//select[@id='"+id1+"']");}
				
	

}
