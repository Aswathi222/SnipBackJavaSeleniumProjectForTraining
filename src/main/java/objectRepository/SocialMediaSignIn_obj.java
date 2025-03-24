package objectRepository;

import org.openqa.selenium.By;

public class SocialMediaSignIn_obj {
	//Btn	
		public By Btn_Login(String text) {return By.xpath("//a[text()='"+text+"']");}
		public By Btn_SignInWithGoogle(String text) {return By.xpath("//a[@href='https://web06-stg-ch.snipback.com/login/google']");}
}
