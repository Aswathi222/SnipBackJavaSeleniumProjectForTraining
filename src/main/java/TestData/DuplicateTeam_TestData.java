package TestData;

import utilPack.BasePge;

public class DuplicateTeam_TestData 
{
	//DT_01_DuplicateTeam
	public static String DT_01_OrgName="demo organization";
	public static String DT_01_TeamName="DupTeam";
	
	//DT_02_DuplicateTeam
	public static String DT_02_OrgName="demo organization";
	public static String DT_02_TeamName="DupTeam";
	
	//DT_03_DuplicateTeam
	public static String DT_03_OrgName="demo organization";
	public static String DT_03_TeamName="DupTeam";
	public static String DT_03_ValidMessage="Team Name already exists";
	
	//DT_04_DuplicateTeam
	public static String DT_04_OrgName="demo organization";
	public static String DT_04_TeamName="DupTeam";
	public static String DT_04_DupTeamName="DupTeam"+BasePge.CreateRandomWithoutNumbers(2);
	public static String DT_04_ValidMessage="Successfully Duplicated";
}
