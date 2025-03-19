package objectRepository;
import org.openqa.selenium.By;

public class SocialMediaSignIn_Obj {	

		//Btn
		public By Btn_SignInWithGoogle(String text) {return By.xpath("//a[@href='"+text+"']");}

		//Ele
		public By Ele_ErrorMessage(String text) {return By.xpath("//h1[@class='"+text+"']");}
		public By Ele_SignInWithGoogle(String text ,String classname) {return By.xpath("//a[text()='"+text+"']//parent::a[@class='"+classname+"']");}

}	



