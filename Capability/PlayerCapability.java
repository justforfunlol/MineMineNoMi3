package MineMineNoMi3.Capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayerCapability implements IPlayerCapability
{
	protected int doriki, bounty, belly, hakiExp, extol;
	private byte gear = 1;
	private String akumaNoMiUsed = "N/A", faction = "N/A", race = "N/A", job = "N/A";
	private boolean isLogia, hasShadow = true, hasHeart = true, firstTime = true;
	private int[] answers = {0, 0, 0};
	
	public static class Storage implements IStorage<IPlayerCapability>
	{
		public static final Storage storage = new Storage();

		public NBTBase writeNBT(Capability<IPlayerCapability> capability, IPlayerCapability instance, EnumFacing side) 
		{
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("Doriki", instance.getDoriki());
			nbt.setInteger("Bounty", instance.getBounty());
			nbt.setInteger("Belly", instance.getBelly());
			nbt.setInteger("Extol", instance.getExtol());
			
			nbt.setString("AkumaNoMiUsed", instance.getUsedFruit());
			nbt.setString("Faction", instance.getFaction());
			nbt.setString("Race", instance.getRace());
			nbt.setString("Job", instance.getJob());
			
			nbt.setBoolean("isLogia", instance.isLogia());
			nbt.setBoolean("hasHeart", instance.hasHeart());
			nbt.setBoolean("hasShadow", instance.hasShadow());
			nbt.setBoolean("firstTime", instance.isFirstTime());
			
			nbt.setByte("gear", instance.getGear());
			nbt.setIntArray("Answers", instance.getAnswers());
			
			return nbt;
		}

		public void readNBT(Capability<IPlayerCapability> capability, IPlayerCapability instance, EnumFacing side, NBTBase nbtbase) 
		{
			NBTTagCompound nbt = (NBTTagCompound)nbtbase;
			instance.setDoriki(nbt.getInteger("Doriki"));
			instance.setBounty(nbt.getInteger("Bounty"));
			instance.setBelly(nbt.getInteger("Belly"));
			instance.setExtol(nbt.getInteger("Extol"));
			
			instance.setUsedFruit(nbt.getString("AkumaNoMiUsed"));
			instance.setFaction(nbt.getString("Faction"));
			instance.setRace(nbt.getString("Race"));
			instance.setJob(nbt.getString("Job"));
			
			instance.setIsLogia(nbt.getBoolean("isLogia"));
			instance.setHasHeart(nbt.getBoolean("hasHeart"));
			instance.setHasShadow(nbt.getBoolean("hasShadow"));
			instance.setFirstTime(nbt.getBoolean("firstTime"));
			
			instance.setGear(nbt.getByte("gear"));
			instance.setFirstTime(nbt.getBoolean("Answers"));
		}
	}
	
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
	
	public boolean isFirstTime() {return this.firstTime;}
	public void setFirstTime(boolean firstTime) {this.firstTime = firstTime;}
	public void firstTimePass() {this.firstTime = false;}
	
	public void setAnswerBySlot(int slot, int i) {this.answers[slot] = i;}
	public int getAnswerBySlot(int slot) {return this.answers[slot];}
	public void setAnswers(int[] a) {this.answers = a;}
	public int[] getAnswers() {return this.answers;}
	
}
