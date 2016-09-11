package MineMineNoMi3.lists;

import MineMineNoMi3.MainKeys;
import MineMineNoMi3.MainWorldGen;
import MineMineNoMi3.capability.EntityCapability;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.events.EventsCapabilities;
import MineMineNoMi3.events.EventsDrops;
import MineMineNoMi3.events.EventsEnchantments;
import MineMineNoMi3.events.EventsExtras;
import MineMineNoMi3.events.EventsPersistence;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ListForge 
{
	public static void init()
	{ 
		
		MinecraftForge.EVENT_BUS.register(new EventsCapabilities());
		MinecraftForge.EVENT_BUS.register(new EventsEnchantments());
		MinecraftForge.EVENT_BUS.register(new EventsPersistence());
		MinecraftForge.EVENT_BUS.register(new EventsDrops());
		 
		CapabilityManager.INSTANCE.register(IEntityCapability.class, EntityCapability.Storage.storage, EntityCapability.Default.class);
		
		GameRegistry.registerWorldGenerator(new MainWorldGen(), 1);
		
		FMLCommonHandler.instance().bus().register(new EventsExtras());
		
		if(FMLCommonHandler.instance().getEffectiveSide().isClient())
		{
			FMLCommonHandler.instance().bus().register(new MainKeys());
			MainKeys.init();
		}
		
	}
}
