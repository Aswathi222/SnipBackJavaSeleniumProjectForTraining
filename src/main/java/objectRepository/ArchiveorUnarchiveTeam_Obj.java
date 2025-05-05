package objectRepository;

import org.openqa.selenium.By;

public class ArchiveorUnarchiveTeam_Obj {
	public By Ele_ArchiveTeam(String teamId,String teamClasscontains){return By.xpath("//div[@id='"+teamId+"']//div[contains(@class,'"+teamClasscontains+"')]");}
	public By Ele_ArchiveTeamDots(String archiveTeamId,String teamClassDot){return By.xpath("//div[@id='"+archiveTeamId+"']//a[@class='"+teamClassDot+"']");}
	public By Ele_ArchiveOptionText(String archiveTeamId,String archiveText){return By.xpath("//div[@id='"+archiveTeamId+"']//a[text()='"+archiveText+"']");}
	public By Ele_ArchivedTeam(String archivedTeamClass,String archivedTeamText){return By.xpath("//div[@class='"+archivedTeamClass+"']//span[text()='"+archivedTeamText+"']");}
}
