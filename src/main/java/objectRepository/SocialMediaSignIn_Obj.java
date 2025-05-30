package objectRepository;
import org.openqa.selenium.By;

public class SocialMediaSignIn_Obj
{
	//Btn	
	public By Btn_SignInOption(String GoogleSignintext) { return By.xpath("//i[@class='"+GoogleSignintext+"']"); }
}
