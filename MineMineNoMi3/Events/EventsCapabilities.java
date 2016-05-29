package MineMineNoMi3.Events;

import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.INPCCapability;
import MineMineNoMi3.Capability.IPlayerCapability;
import net.minecraft.entity.EntityLivingBase;
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
		if (event.getEntity() instanceof EntityPlayer)
		{			
			event.addCapability(new ResourceLocation("mineminenomi:player_cap"), new ICapabilitySerializable<NBTTagCompound>()
			{
				IPlayerCapability inst = Values.CAPABILITIES_PLAYER.getDefaultInstance();
				
				public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
				{
					return capability == Values.CAPABILITIES_PLAYER;
				} 

				public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
				{
					return capability == Values.CAPABILITIES_PLAYER ? Values.CAPABILITIES_PLAYER.<T>cast(inst) : null;
				}

				public NBTTagCompound serializeNBT() 
				{
					return (NBTTagCompound)Values.CAPABILITIES_PLAYER.getStorage().writeNBT(Values.CAPABILITIES_PLAYER, inst, null);
				}

				public void deserializeNBT(NBTTagCompound nbt) 
				{
					Values.CAPABILITIES_PLAYER.getStorage().readNBT(Values.CAPABILITIES_PLAYER, inst, null, nbt);
				}			
			});
			
		}
		
		if (event.getEntity() instanceof EntityLivingBase && !(event.getEntity() instanceof EntityPlayer))
		{			
			event.addCapability(new ResourceLocation("mineminenomi:entity_cap"), new ICapabilitySerializable<NBTTagCompound>()
			{
				INPCCapability inst = Values.CAPABILITIES_NPC.getDefaultInstance();
				
				public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
				{
					return capability == Values.CAPABILITIES_NPC;
				} 

				public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
				{
					return capability == Values.CAPABILITIES_NPC ? Values.CAPABILITIES_NPC.<T>cast(inst) : null;
				}

				public NBTTagCompound serializeNBT() 
				{
					return (NBTTagCompound)Values.CAPABILITIES_NPC.getStorage().writeNBT(Values.CAPABILITIES_NPC, inst, null);
				}

				public void deserializeNBT(NBTTagCompound nbt) 
				{
					Values.CAPABILITIES_NPC.getStorage().readNBT(Values.CAPABILITIES_NPC, inst, null, nbt);
				}			
			});
			
		}
	}
}


