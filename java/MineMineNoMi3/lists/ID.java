package MineMineNoMi3.lists;

import WyPI.WyPI;
import net.minecraft.util.ResourceLocation;

public class ID
{

	public static final ResourceLocation
	
	TEXTURE_BOUNTYPOSTER = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID(), "textures/gui/gui_bounty.png"),
	TEXTURE_WIDGETS = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID(), "textures/gui/widgets.png"),
	TEXTURE_CURRENCIES = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID(), "textures/gui/currencies.png"),
	TEXTURE_BLANK = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID(), "textures/gui/gui_blank.png"),
	TEXTURE_JOB = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID(), "textures/gui/gui_job.png"),
	TEXTURE_RACE = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID(), "textures/gui/gui_race.png"),
	TEXTURE_FACTION = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID(), "textures/gui/gui_fac.png");
	
	
	public static final String

	PROJECT_ID = "mineminenomi",
	PROJECT_NAME = "Mine Mine no Mi",
	PROJECT_VERSION = "0.3.0",
	
	CONFIG_BASIC = "Basic Configurations",
	
	FACTION_PIRATE = "Pirate",
	FACTION_MARINE = "Marine",
	FACTION_BOUNTYHUNTER = "Bounty Hunter",
	FACTION_REVOLUTIONARY = "Revolutionary",
	FACTION_BANDIT = "Bandit",
	
	RACE_HUMAN = "Human",
	RACE_FISHMAN = "Fishman",
	RACE_CYBORG = "Cyborg",
	
	JOB_SWORDSMAN = "Swordsman",
	JOB_SNIPER = "Sniper",
	JOB_DOCTOR = "Doctor",
	JOB_THIEF = "Thief",
	JOB_ARCHAEOLOGIST = "Archaeologist",
	
	ACHIEVEMENT_EPIC_EQUIPMENT = "Epic Equipment",
	ACHIEVEMENT_OVER_9000 = "Over 9000",
	ACHIEVEMENT_RAIDER = "Raider",
	ACHIEVEMENT_BECOME_A_USER = "The power of the Devil",
	ACHIEVEMENT_GREEDY = "Greedy",
	ACHIEVEMENT_ROKUSHIKI_MASTER = "Rokushiki Master";
	
	
	public static final int 
	
	GUI_DIALTABLE = 0,
	GUI_PLAYER = 1,
	GUI_CHARACTERCREATOR = 2,
	GUI_ABILITIES = 3;
}
