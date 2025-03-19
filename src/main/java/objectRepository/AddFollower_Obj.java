package objectRepository;

import org.openqa.selenium.By;

public class AddFollower_Obj 
{
	//Btn	
	 public By Btn_RemoveAll(String id){ return By.xpath("//h3[contains(text(),'LIST OF FOLLOWERS')]/../../..//div//button[text()='"+id+"']"); }
	 public By Btn_FollowerCancel(String text1,String text2){ return By.xpath("//button[@class='"+text1+"' and text()='"+text2+"']"); }
	 public By Btn_MailTick(String text, String id)	{ return By.xpath("//div[@class='"+text+"']//i[@class='"+id+"']"); } 
	 public By Btn_FollowersUpdate(String text) {return By.xpath("//button[contains(@type,'button')][text()='"+text+"']");}
	 public By Btn_FollowersCreate(String id,String text) {return By.xpath("//button[@id='"+id+"' and text()='"+text+"']");}
	 public By Btn_FollowersEdit(String id,String text) {return By.xpath("//div[@id='"+id+"']//i[@class='"+text+"']");}
	 public By Btn_FollowersClose(String text){ return By.xpath("//button[@id='modalMessageCloseBtn' and text()='"+text+"']"); }
	 public By Btn_Followers(String id) {return By.xpath("//button[@id='"+id+"' and @disabled]");}

	 //Chk
	 public By Chk_TeamCoachAdmincheckbox(String id,String classname) {return By.xpath("//input[@id='"+id+"']//following-sibling::span[@class='"+classname+"']");}
	 public By Chk_TeamSelect(String name,String text) {return By.xpath("//div[@data-site='"+name+"']//div[@class=' d-inline-flex  align-items-center singleuser']//input[@type='"+text+"']");}
		 
	//Ele
	  public By Ele_Followers(String text) {return By.xpath("//h3[text()='"+text+"']");}
	  public By Ele_NotificationEmail(String text) {return By.xpath("//*[@id='addUserdetails']/div/div/div[@class='modal-body']/div[@class='user_role'] //div[@class='col-12 pt-3']/..//div[@class='col-12 pt-3']//label[text()='"+text+"']");}
	  public By Ele_FollowerHedder(String text) {return By.xpath("//div[@class='modal-content create_newuser']//h6[contains(text(),'"+text+"')]");}
	  public By Ele_FollowerAddEmail(String text) {return By.xpath("//div[@id='addUserdetails']//div[@class='modal-dialog modal-lg modal-dialog-centered']//div[@class='modal-content create_newuser']//div[@class='modal-body']//div//label[@for='exampleInputEmail1'][normalize-space()='"+text+"']");}
	  public By Ele_FollowerX(String text) {return By.xpath("//button[@class='btn btn-danger']//i[@class='"+text+"']");}
	  public By Ele_FollowerCheck(String text) {return By.xpath("//button[@onclick='checkMail();']//i[@class='"+text+"']");}
	  public By Ele_FollowerMessage(String id1, String id2) {return By.xpath("//div[@id='"+id1+"']//textarea[@id='"+id2+"']");}
	  public By Ele_FollowerTickBtn(String text) {return By.xpath("//button[@onclick='checkMail();']//i[@class='"+text+"']");}
	  public By Ele_FollowerCreateBtn(String id, String text) {return By.xpath("//div[@id='"+id+"']//button[contains(@id,'"+text+"')]");}
	  public By Ele_FollowerName(String name, String email) {return By.xpath("//div[@data-name='"+name+"']//div[@id='teamDetailsDiv']//p[text()='"+email+"']");}
	  public By Ele_FollowerEmailField(String text) {return By.xpath("//label[@class='form-label fw-bold fs-6'][text()='"+text+"']");}
	  public By Ele_List(String data) {return By.xpath("//select[@data-currole='"+data+"']//child::option");}  
	  public By Ele_SelectRole(String data) {return By.xpath("//option[text()='"+data+"']");}
	  public By Ele_FollowerPencil(String text) {return By.xpath("//div[@id='nav-followers']//i[@class='"+text+"']"	); }
	  public By Ele_DropdownSelection(String text, String team) {return By.xpath("//span[@class='"+text+"' and text()='"+team+"']");}
	  public By Ele_DropdownClick(String text) {return By.xpath("//button[@data-id='"+text+"']");}
	  public By Ele_FollowerList(String text, String text1) {return By.xpath("//div[@id='"+text+"']/p[@id='"+text1+"']");}
	  public By Ele_FollowerID(String id) {return By.xpath("//div[@data-id='"+id+"']");}
}
