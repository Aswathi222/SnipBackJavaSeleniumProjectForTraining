package objectRepository;
import org.openqa.selenium.By;

public class Registration_Obj {	

	//Btn
	public By Btn_RegistrationSignUp(String btn) {return By.xpath("//button[@class ='"+btn+"' ]");}	

	//Edt
	public By Edt_Name(String text) {return By.xpath("//input[@placeholder='"+text+"']");}
	public By Edt_SignUpPopupPassword(String text) {return By.xpath("//span[@id='"+text+"']");} 
	public By Edt_SignUpMinConfPassword(String text) {return By.xpath("//span[@class='"+text+"']");} 

	//Ele
	public By Ele_ErrorMessage(String text) {return By.xpath("//li[normalize-space(text())='"+text+"']");}
	public By Ele_Alert(String text){return By.xpath("//span[contains(text(),'"+text+"')]");}
	public By Ele_Signup(String classname) {return By.xpath("//p[@class='"+classname+"']");}
	public By Ele_SignupField(String name) { return By.xpath("//input[@name='"+name+"']");}
	public By Ele_OtpPage(String page) {return By.xpath("//div[@id='"+page+"']");}
	public By Ele_Message(String id,String text) {return By.xpath("//input[@id='"+id+"']//preceding::label[text()='"+text+"']");}
	public By Ele_RegistrationExists(String exists) {return By.xpath("//label[text()='"+exists+"']");}
	public By Ele_Terms() {return By.xpath("//b[text()='Organization Terms of Service']");}

	//Img
	public By Img_SignUpPageLogo(String classvalue) {return By.xpath("//img[@class='"+classvalue+"']/../..//a[@target='_blank']");}

	//Navigation
	public By Nav_RegistrationPage(String page) { return By.xpath("//form[@id= '"+page+"']"); }

}	

