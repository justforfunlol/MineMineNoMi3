package xyz.pixelatedw.MineMineNoMi3.ieep;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityManager;

public class ExtendedEntityStats implements IExtendedEntityProperties 
{

	public final static String EXT_PROP_NAME = "IEEPShared";
	private final EntityLivingBase entity;

	private boolean isInCombatMode = false;
	
	private int doriki, bounty, belly, extol, cola = 100, maxCola = 100, hakiTimer = 0, ultraCola = 0;
	private byte gear = 1;
	private String akumaNoMiUsed = "N/A", faction = "N/A", race = "N/A", job = "N/A", crew = "N/A";
	private boolean isLogia, hasShadow = true, hasHeart = true, firstTime = true, hasHakiActive = false, kilo = false;
	
	private String[] hotbarAbilities = new String[8];
	private List<String> allAbilities = new ArrayList<String>();
	private List<String> devilFruitAbilities = new ArrayList<String>();
	private List<String> racialAbilities = new ArrayList<String>();
	private List<String> hakiAbilities = new ArrayList<String>();
	/*private String[] allAbilities = new String[128];
	private String[] devilFruitAbilities = new String[32];
	private String[] racialAbilities = new String[8];
	private String[] hakiAbilities = new String[3];*/
	
	public ExtendedEntityStats(EntityLivingBase entity) 
	{
		this.entity = entity;	
		for(int i = 0; i < hotbarAbilities.length; i++)
		{
			hotbarAbilities[i] = "n/a";
		}
	}
	
	public static final void register(EntityLivingBase entity) 
	{
		entity.registerExtendedProperties(ExtendedEntityStats.EXT_PROP_NAME, new ExtendedEntityStats(entity));
	}

	public static final ExtendedEntityStats get(EntityLivingBase entity) 
	{
		return (ExtendedEntityStats) entity.getExtendedProperties(EXT_PROP_NAME);
	}

	public void saveNBTData(NBTTagCompound compound) 
	{
		NBTTagCompound props = new NBTTagCompound();

		props.setInteger("Doriki", this.doriki);
		props.setInteger("Bounty", this.bounty);
		props.setInteger("Belly", this.belly);
		props.setInteger("Extol", this.extol);
		props.setInteger("Cola", this.cola);
		props.setInteger("MaxCola", this.maxCola);	
		props.setInteger("UltraCola", this.ultraCola);
		
		props.setString("AkumaNoMi", this.akumaNoMiUsed);
		props.setString("Faction", this.faction);
		props.setString("Race", this.race);
		props.setString("Job", this.job);
		props.setString("Crew", this.crew);
		
		props.setBoolean("isLogia", this.isLogia);
		props.setBoolean("hasShadow", this.isLogia);
		props.setBoolean("hasHeart", this.hasHeart);
		props.setBoolean("firstTime", this.firstTime);
		props.setBoolean("hasKiloActive", this.kilo);
		props.setBoolean("hasHakiActive", this.hasHakiActive);
		
		props.setBoolean("isInCombatMode", this.isInCombatMode);
		
		props.setByte("Gear", this.gear);
		
		for(int i = 0; i < hotbarAbilities.length - 1; i++)
		{
			props.setString("ability" + i, hotbarAbilities[i]);
		}
		for(int i = 0; i < allAbilities.size() - 1; i++)
		{
			props.setString("available_AllAbilities" + i, allAbilities.get(i));
		}
		for(int i = 0; i < devilFruitAbilities.size() - 1; i++)
		{
			props.setString("available_DevilFruitAbilities" + i, devilFruitAbilities.get(i));
		}
		for(int i = 0; i < racialAbilities.size() - 1; i++)
		{
			props.setString("available_RacialAbilities" + i, racialAbilities.get(i));
		}
		for(int i = 0; i < hakiAbilities.size() - 1; i++)
		{
			props.setString("available_HakiAbilities" + i, hakiAbilities.get(i));
		}
		
		compound.setTag(EXT_PROP_NAME, props);
	}

	public void loadNBTData(NBTTagCompound compound) 
	{
		NBTTagCompound props = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);

		this.doriki = props.getInteger("Doriki");
		this.bounty = props.getInteger("Bounty");
		this.belly = props.getInteger("Belly");
		this.extol = props.getInteger("Extol");
		this.cola = props.getInteger("Cola");
		this.maxCola = props.getInteger("MaxCola");
		this.ultraCola = props.getInteger("UltraCola");
		
		this.akumaNoMiUsed = props.getString("AkumaNoMi");
		this.faction = props.getString("Faction");
		this.race = props.getString("Race");
		this.job = props.getString("Job");
		this.crew = props.getString("Crew");
		
		this.isLogia = props.getBoolean("isLogia");
		this.hasShadow = props.getBoolean("hasShadow");
		this.hasHeart = props.getBoolean("hasHeart");
		this.firstTime = props.getBoolean("firstTime");
		this.kilo = props.getBoolean("hasKiloActive");
		this.hasHakiActive = props.getBoolean("hasHakiActive");
		
		this.isInCombatMode = props.getBoolean("isInCombatMode");
		
		this.gear = props.getByte("Gear");
		
		for(int i = 0; i < hotbarAbilities.length - 1; i++)
		{
			this.hotbarAbilities[i] = props.getString("ability" + i);
		}
		for(int i = 0; i < allAbilities.size() - 1; i++)
		{
			this.allAbilities.set(i, props.getString("available_AllAbilities" + i));
		}
		for(int i = 0; i < devilFruitAbilities.size() - 1; i++)
		{
			this.devilFruitAbilities.set(i, props.getString("available_DevilFruitAbilities" + i));
		}
		for(int i = 0; i < racialAbilities.size() - 1; i++)
		{
			this.racialAbilities.set(i, props.getString("available_RacialAbilities" + i));
		}
		for(int i = 0; i < hakiAbilities.size() - 1; i++)
		{
			this.hakiAbilities.set(i, props.getString("available_HakiAbilities" + i));
		}
	}

	public void init(Entity entity, World world) {}

	// #REGION AVAILABLE DEVIL FRUITS ABILITIES
	public void addDevilFruitAbility(Ability abl)
	{
		if(!this.devilFruitAbilities.contains(WyHelper.getFancyName(abl.getAttribute().getAttributeName())))
			this.devilFruitAbilities.add(WyHelper.getFancyName(abl.getAttribute().getAttributeName()));
	}
	public void removeDevilFruitAbility(Ability abl)
	{
		if(this.devilFruitAbilities.contains(WyHelper.getFancyName(abl.getAttribute().getAttributeName())))
			this.devilFruitAbilities.remove(WyHelper.getFancyName(abl.getAttribute().getAttributeName()));
	}
	public List<String> getDevilFruitAbilities()
	{ 
		return this.devilFruitAbilities; 
	}
	public void clearDevilFruitAbilities()
	{
		this.devilFruitAbilities.clear();
	}
	//	#END REGION
	
	public void setAbilityInSlot(int slot, Ability abl)
	{
		this.hotbarAbilities[slot] = WyHelper.getFancyName(abl.getAttribute().getAttributeName());
	}
	public Ability getAbilityFromSlot(int slot)
	{
		return AbilityManager.instance().getAbilityByName(this.hotbarAbilities[slot]);
	}
	
	public void setCombatMode(boolean value) { this.isInCombatMode = value; }
	public boolean isInCombatMode() { return this.isInCombatMode; }
	
	public int getDoriki() {return doriki;}
	public void addDoriki(int i) {doriki += i;}	
	public void decDoriki(int i) {doriki -= i;}	
	public void setDoriki(int i) {doriki = i;}
	
	public int getExtol() {return this.extol;}
	public void setExtol(int i) {this.extol = i;}
	public void addExtol(int i) {this.extol += i;}
	public void decExtol(int i) {this.extol -= i;}
	
	public int getBelly() {return this.belly;}
	public void setBelly(int i) {this.belly = i;}
	public void addBelly(int i) {this.belly += i;}
	public void decBelly(int i)	{this.belly -= i;}
	
	public int getBounty() {return this.bounty;}
	public void setBounty(int i) {this.bounty = i;}
	public void addBounty(int i) {this.bounty += i;}
	public void decBounty(int i) {this.bounty -= i;}

	public int getCola() {return this.cola;}
	public void setCola(int i) {this.cola = i;}
	public void addCola(int i) {this.cola += i;}
	public void decCola(int i) {this.cola -= i;}	
	
	public int getUltraColaConsumed() { return this.ultraCola; }
	public void setUltraCola(int i) { this.ultraCola = i; }
	public void addUltraCola() { this.ultraCola++; }
	
	public int getMaxCola() { return this.maxCola; }
	public void setMaxCola(int maxCola) { this.maxCola = maxCola; }
	
	public boolean isLogia() {return this.isLogia;}
	public void setIsLogia(boolean i) {this.isLogia = i;}
	
	public String getUsedFruit() {return this.akumaNoMiUsed;}
	public void setUsedFruit(String name) {this.akumaNoMiUsed = name;}
	
	public boolean hasHeart() {return this.hasHeart;}
	public void setHasHeart(boolean b) {this.hasHeart = b;}
	
	public boolean hasShadow() {return this.hasShadow;}
	public void setHasShadow(boolean b) {this.hasShadow = b;}
	
	public void setGear(byte i) {this.gear = i;}
	public byte getGear() {return this.gear;}
	
	public String getJob() {return this.job;}
	public void setJob(String i) {this.job = i;}
	
	public String getRace() {return this.race;}
	public void setRace(String i) {this.race = i;}
	
	public String getFaction() {return this.faction;}
	public void setFaction(String i) {this.faction = i;}
	
	public String getCrew() {return this.crew;}
	public void setCrew(String crewName) {this.crew = crewName;}
	
	public boolean isFirstTime() {return this.firstTime;}
	public void setFirstTime(boolean firstTime) {this.firstTime = firstTime;}
	public void firstTimePass() {this.firstTime = false;}
	
	public boolean hasHakiActive() { return hasHakiActive; }
	public void triggerActiveHaki() { this.hasHakiActive = !hasHakiActive(); }
	public int getHakiTimer() { return hakiTimer; }
	public void addHakiTimer() { hakiTimer++; }
	public void resetHakiTimer() { hakiTimer = 0; }

	public void setKilo(boolean kilo) { this.kilo = kilo; }
	public boolean getKilo() { return kilo; } 
}