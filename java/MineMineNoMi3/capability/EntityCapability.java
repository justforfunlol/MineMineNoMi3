package MineMineNoMi3.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class EntityCapability
{
	
	public interface IEntityCapability
	{
		int getDoriki();
		void addDoriki(int i);
		void decDoriki(int i);
		void setDoriki(int i);
		
		int getBounty();
		void addBounty(int i);
		void decBounty(int i);
		void setBounty(int i);
		
		int getBelly();
		void addBelly(int i);
		void decBelly(int i);
		void setBelly(int i);
		
		int getExtol();
		void addExtol(int i);
		void decExtol(int i);
		void setExtol(int i);
		
		int getCola();
		void addCola(int i);
		void decCola(int i);
		void setCola(int i);
		
		boolean isLogia();
		void setIsLogia(boolean isLogia);
		
		String getJob();
		void setJob(String job);
		
		String getRace();
		void setRace(String race);
		
		String getFaction();
		void setFaction(String faction);
		
		String getUsedFruit();
		void setUsedFruit(String name);
		
		boolean hasHeart();
		void setHasHeart(boolean hasHeart);
		
		boolean hasShadow();
		void setHasShadow(boolean hasShadow);
		
		void setGear(byte gear);
		byte getGear();
		
		boolean isFirstTime();
		void setFirstTime(boolean firstTime);
		void firstTimePass();
		
		boolean isBlind();
		int getBlindTime();
		void setBlind(int time);
	}
	
	public static class Storage implements IStorage<IEntityCapability>
	{
		public static final Storage storage = new Storage();

		public NBTBase writeNBT(Capability<IEntityCapability> capability, IEntityCapability instance, EnumFacing side) 
		{
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("Doriki", instance.getDoriki());
			nbt.setInteger("Bounty", instance.getBounty());
			nbt.setInteger("Belly", instance.getBelly());
			nbt.setInteger("Extol", instance.getExtol());
			nbt.setInteger("Cola", instance.getCola());
			
			nbt.setString("AkumaNoMiUsed", instance.getUsedFruit());
			nbt.setString("Faction", instance.getFaction());
			nbt.setString("Race", instance.getRace());
			nbt.setString("Job", instance.getJob());
			
			nbt.setBoolean("isLogia", instance.isLogia());
			nbt.setBoolean("hasHeart", instance.hasHeart());
			nbt.setBoolean("hasShadow", instance.hasShadow());
			nbt.setBoolean("firstTime", instance.isFirstTime());
			
			nbt.setByte("gear", instance.getGear());
			
			return nbt;
		}

		public void readNBT(Capability<IEntityCapability> capability, IEntityCapability instance, EnumFacing side, NBTBase nbtbase) 
		{ 
			NBTTagCompound nbt = (NBTTagCompound)nbtbase;
			instance.setDoriki(nbt.getInteger("Doriki"));
			instance.setBounty(nbt.getInteger("Bounty"));
			instance.setBelly(nbt.getInteger("Belly"));
			instance.setExtol(nbt.getInteger("Extol"));
			instance.setCola(nbt.getInteger("Cola"));
			
			instance.setUsedFruit(nbt.getString("AkumaNoMiUsed"));
			instance.setFaction(nbt.getString("Faction"));
			instance.setRace(nbt.getString("Race"));
			instance.setJob(nbt.getString("Job"));
			
			instance.setIsLogia(nbt.getBoolean("isLogia"));
			instance.setHasHeart(nbt.getBoolean("hasHeart"));
			instance.setHasShadow(nbt.getBoolean("hasShadow"));
			instance.setFirstTime(nbt.getBoolean("firstTime"));
			
			instance.setGear(nbt.getByte("gear"));
		}
	}
	
	public static class Default implements IEntityCapability
	{
		protected int doriki, bounty, belly, hakiExp, extol, blindness, cola = 100;
		private byte gear = 1;
		private String akumaNoMiUsed = "N/A", faction = "N/A", race = "N/A", job = "N/A";
		private boolean isLogia, hasShadow = true, hasHeart = true, firstTime = true;
		
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
	
		public boolean isBlind() { return this.blindness > 0; }
		public int getBlindTime() { return this.blindness; }
		public void setBlind(int time) { this.blindness = time; }
	}
}
