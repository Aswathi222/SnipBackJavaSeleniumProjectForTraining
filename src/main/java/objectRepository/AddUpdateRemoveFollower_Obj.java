package objectRepository;
import org.openqa.selenium.By;

public class AddUpdateRemoveFollower_Obj {
	public By Ele_Follower(String idname) {return By.xpath("//p[@id='" + idname + "']");}
	public By Ele_CreateNewUser(String classname, String textname) {return By.xpath("//div[@class='" + classname + "']//h6[text()='" + textname + "']");}
	public By Btn_CrossIcon(String buttonClass, String iconClass) {return By.xpath("//button[@class='" + buttonClass + "']//i[@class='" + iconClass + "']");}
	public By Btn_TickIcon(String onclickValue, String iconClass) {return By.xpath("//button[@onclick='" + onclickValue + "']//i[@class='" + iconClass + "']");}
    public By Ele_SelectText(String className, String textValue) {return By.xpath("//div[@class='" + className + "']//div[text()='" + textValue + "']");}
	public By Ele_TextArea(String parentClass, String textAreaClass) {return By.xpath("//div[@class='" + parentClass + "']//textarea[@class='" + textAreaClass + "']");}
	public By Btn_AddPlayer(String parentClass, String buttonText) {return By.xpath("//div[@class='" + parentClass + "']//button[text()='" + buttonText + "']");}
	public By Btn_FollowersEdit(String divId, String iconClass) {return By.xpath("//div[@id='" + divId + "']//i[@class='" + iconClass + "']");}
	public By Chk_FollowerSelect(String siteName, String inputType) {return By.xpath("//div[@data-site='" + siteName + "']//input[@type='" + inputType + "']");}

}
