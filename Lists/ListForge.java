package MineMineNoMi3.Lists;

import MineMineNoMi3.MainKeys;
import MineMineNoMi3.MainWorldGen;
import MineMineNoMi3.Capability.INPCCapability;
import MineMineNoMi3.Capability.IPlayerCapability;
import MineMineNoMi3.Capability.NPCCapability;
import MineMineNoMi3.Capability.PlayerCapability;
import MineMineNoMi3.Capability.PlayerCapability.Storage;
import MineMineNoMi3.Events.EventTicks;
import MineMineNoMi3.Events.EventsCapabilities;
import MineMineNoMi3.Events.EventsDevilFruits;
import MineMineNoMi3.Events.EventsDoriki;
import MineMineNoMi3.Events.EventsDrops;
import MineMineNoMi3.Events.EventsEnchantments;
import MineMineNoMi3.Events.EventsJobs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ListForge 
{
	public static void init()
	{ 
		
		MinecraftForge.EVENT_BUS.register(new EventsCapabilities());
		MinecraftForge.EVENT_BUS.register(new EventsDevilFruits());
		MinecraftForge.EVENT_BUS.register(new EventsEnchantments());
		MinecraftForge.EVENT_BUS.register(new EventsDoriki());
		MinecraftForge.EVENT_BUS.register(new EventsDrops());
		MinecraftForge.EVENT_BUS.register(new EventsJobs());
		 
		CapabilityManager.INSTANCE.register(IPlayerCapability.class, PlayerCapability.Storage.storage, PlayerCapability.class);
		CapabilityManager.INSTANCE.register(INPCCapability.class, NPCCapability.Storage.storage, NPCCapability.class);
		
		GameRegistry.registerWorldGenerator(new MainWorldGen(), 1);
		
		FMLCommonHandler.instance().bus().register(new EventTicks());
		
		if(FMLCommonHandler.instance().getEffectiveSide().isClient())
		{
			FMLCommonHandler.instance().bus().register(new MainKeys());
			MainKeys.init();
		}
		
	}
}
