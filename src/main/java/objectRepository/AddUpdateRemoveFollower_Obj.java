package objectRepository;
import org.openqa.selenium.By;

public class AddUpdateRemoveFollower_Obj {
	public By Ele_Follower(String idname) {return By.xpath("//p[@id='" + idname + "']");}
	public By Ele_CreateNewUser(String classname, String textname) {return By.xpath("//div[@class='" + classname + "']//h6[text()='" + textname + "']");}
	public By Btn_CrossIcon(String buttonClass, String iconClass) {return By.xpath("//button[@class='" + buttonClass + "']//i[@class='" + iconClass + "']");}
	public By Btn_TickIcon(String onclickValue, String iconClass) {return By.xpath("//button[@onclick='" + onclickValue + "']//i[@class='" + iconClass + "']");}
}
