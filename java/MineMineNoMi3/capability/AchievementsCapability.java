package MineMineNoMi3.capability;

import java.util.HashMap;

import MineMineNoMi3.lists.ID;
import MineMineNoMi3.packets.PacketPlayer;
import WyPI.modules.WyHelper;
import WyPI.modules.WyNetworkHelper;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class AchievementsCapability
{
	
	public interface IAchievementsCapability
	{
		int getRaiderProgress();
		void setRaiderProgress(int i);
		void addRaiderProgress();

		boolean hasAchievement(String name);
		void setAchievementState(String name, boolean state);
	}
	
	public static class Storage implements IStorage<IAchievementsCapability>
	{
		public static final Storage storage = new Storage();

		public NBTBase writeNBT(Capability<IAchievementsCapability> capability, IAchievementsCapability instance, EnumFacing side) 
		{
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger(ID.ACHIEVEMENT_RAIDER + "Progress", instance.getRaiderProgress());
			
			nbt.setBoolean(ID.ACHIEVEMENT_BECOME_A_USER, instance.hasAchievement(ID.ACHIEVEMENT_BECOME_A_USER));
			nbt.setBoolean(ID.ACHIEVEMENT_EPIC_EQUIPMENT, instance.hasAchievement(ID.ACHIEVEMENT_EPIC_EQUIPMENT));
			nbt.setBoolean(ID.ACHIEVEMENT_OVER_9000, instance.hasAchievement(ID.ACHIEVEMENT_OVER_9000));
			nbt.setBoolean(ID.ACHIEVEMENT_RAIDER, instance.hasAchievement(ID.ACHIEVEMENT_RAIDER));
			
			return nbt;
		}

		public void readNBT(Capability<IAchievementsCapability> capability, IAchievementsCapability instance, EnumFacing side, NBTBase nbtbase) 
		{ 
			NBTTagCompound nbt = (NBTTagCompound)nbtbase;
			instance.setRaiderProgress(nbt.getInteger(ID.ACHIEVEMENT_RAIDER + "Progress"));
			
			instance.setAchievementState(ID.ACHIEVEMENT_BECOME_A_USER, nbt.getBoolean(ID.ACHIEVEMENT_BECOME_A_USER));
			instance.setAchievementState(ID.ACHIEVEMENT_EPIC_EQUIPMENT, nbt.getBoolean(ID.ACHIEVEMENT_EPIC_EQUIPMENT));
			instance.setAchievementState(ID.ACHIEVEMENT_OVER_9000, nbt.getBoolean(ID.ACHIEVEMENT_OVER_9000));
			instance.setAchievementState(ID.ACHIEVEMENT_RAIDER, nbt.getBoolean(ID.ACHIEVEMENT_RAIDER));
			
		}
	}
	
	public static class Default implements IAchievementsCapability
	{
		private int raiderProgress = 0;
		private boolean hasBecomeAUser = false, hasEpicEquipment = false, hasOver9000 = false, hasRaider = false;

		public int getRaiderProgress() { return this.raiderProgress; }
		public void setRaiderProgress(int i) { this.raiderProgress = i; }
		public void addRaiderProgress() { this.raiderProgress++; }
		
		public boolean hasAchievement(String name)
		{
			switch(name)
			{
				case ID.ACHIEVEMENT_BECOME_A_USER: return hasBecomeAUser;
				case ID.ACHIEVEMENT_EPIC_EQUIPMENT: return hasEpicEquipment;
				case ID.ACHIEVEMENT_OVER_9000: return hasOver9000;
				case ID.ACHIEVEMENT_RAIDER: return hasRaider;
			}
			return false;
		}

		public void setAchievementState(String name, boolean state)
		{
			switch(name)
			{
				case ID.ACHIEVEMENT_BECOME_A_USER: hasBecomeAUser = state; break;
				case ID.ACHIEVEMENT_EPIC_EQUIPMENT: hasEpicEquipment = state; break;
				case ID.ACHIEVEMENT_OVER_9000: hasOver9000 = state; break;
				case ID.ACHIEVEMENT_RAIDER: hasRaider = state; break;
			}
		}
	}
}
