package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;

public class EventExtendedProperties 
{

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) 
	{
		if (event.entity instanceof EntityLivingBase && ExtendedEntityStats.get((EntityLivingBase) event.entity) == null)
			ExtendedEntityStats.register((EntityLivingBase) event.entity);
	}
}