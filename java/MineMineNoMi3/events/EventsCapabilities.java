package MineMineNoMi3.events;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.AchievementsCapability.IAchievementsCapability;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventsCapabilities
{

	@SubscribeEvent
	public void onEntityConstructing(AttachCapabilitiesEvent.Entity event)
	{
		event.addCapability(new ResourceLocation("mineminenomi:player_cap"), new ICapabilitySerializable<NBTTagCompound>()
		{
			IEntityCapability inst = Values.ENTITY_CAPABILITIES.getDefaultInstance();

			public boolean hasCapability(Capability<?> capability, EnumFacing facing)
			{
				return capability == Values.ENTITY_CAPABILITIES;
			}

			public <T> T getCapability(Capability<T> capability, EnumFacing facing)
			{
				return capability == Values.ENTITY_CAPABILITIES ? Values.ENTITY_CAPABILITIES.<T>cast(inst) : null;
			}

			public NBTTagCompound serializeNBT()
			{
				return (NBTTagCompound) Values.ENTITY_CAPABILITIES.getStorage().writeNBT(Values.ENTITY_CAPABILITIES, inst, null);
			}

			public void deserializeNBT(NBTTagCompound nbt)
			{
				Values.ENTITY_CAPABILITIES.getStorage().readNBT(Values.ENTITY_CAPABILITIES, inst, null, nbt);
			}
		});

		event.addCapability(new ResourceLocation("mineminenomi:player_achievements"), new ICapabilitySerializable<NBTTagCompound>()
		{
			IAchievementsCapability inst = Values.ACHIEVEMENTS_CAPABILITIES.getDefaultInstance();

			public boolean hasCapability(Capability<?> capability, EnumFacing facing)
			{
				return capability == Values.ACHIEVEMENTS_CAPABILITIES;
			}

			public <T> T getCapability(Capability<T> capability, EnumFacing facing)
			{
				return capability == Values.ACHIEVEMENTS_CAPABILITIES ? Values.ACHIEVEMENTS_CAPABILITIES.<T>cast(inst) : null;
			}

			public NBTTagCompound serializeNBT()
			{
				return (NBTTagCompound) Values.ACHIEVEMENTS_CAPABILITIES.getStorage().writeNBT(Values.ACHIEVEMENTS_CAPABILITIES, inst, null);
			}

			public void deserializeNBT(NBTTagCompound nbt)
			{
				Values.ACHIEVEMENTS_CAPABILITIES.getStorage().readNBT(Values.ACHIEVEMENTS_CAPABILITIES, inst, null, nbt);
			}
		});

	}

}
