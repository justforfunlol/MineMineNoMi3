package MineMineNoMi3.lists;

import WyPI.WyPI;
import net.minecraft.util.ResourceLocation;

public class IDs
{

	public static ResourceLocation
	
	ID_TEXTURE_CURRENCIES = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID(), "textures/gui/currencies.png"),
	ID_TEXTURE_BLANK = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID(), "textures/gui/gui_blank.png"),
	ID_TEXTURE_JOB = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID(), "textures/gui/gui_job.png"),
	ID_TEXTURE_RACE = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID(), "textures/gui/gui_race.png"),
	ID_TEXTURE_FACTION = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID(), "textures/gui/gui_fac.png");
	
	
	public static String

	ID_FACTION_PIRATE = "Pirate",
	ID_FACTION_MARINE = "Marine",
	ID_FACTION_BOUNTYHUNTER = "Bounty Hunter",
	ID_FACTION_REVOLUTIONARY = "Revolutionary",
	ID_FACTION_BANDIT = "Bandit",
	
	ID_RACE_HUMAN = "Human",
	ID_RACE_FISHMAN = "Fishman",
	ID_RACE_CYBORG = "Cyborg",
	
	ID_JOB_SWORDSMAN = "Swordsman",
	ID_JOB_SNIPER = "Sniper",
	ID_JOB_DOCTOR = "Doctor",
	ID_JOB_THIEF = "Thief";
	
	
	public static int
	
	ID_GUI_DIALTABLE = 0,
	ID_GUI_PLAYER = 1,
	ID_GUI_CHARACTERCREATOR = 2,
	ID_GUI_ABILITIES = 3;
}
