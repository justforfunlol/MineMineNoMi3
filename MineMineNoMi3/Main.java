package MineMineNoMi3;

import java.io.File;
import java.util.logging.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import MineMineNoMi3.Commands.CommandBelly;
import MineMineNoMi3.Commands.CommandBounty;
import MineMineNoMi3.Commands.CommandDoriki;
import MineMineNoMi3.Commands.CommandExtol;
import MineMineNoMi3.GUI.GUIHandler;
import MineMineNoMi3.Lists.ListAchievements;
import MineMineNoMi3.Lists.ListCreativeTabs;
import MineMineNoMi3.Lists.ListDevilFruits;
import MineMineNoMi3.Lists.ListEffects;
import MineMineNoMi3.Lists.ListEntities;
import MineMineNoMi3.Lists.ListForge;
import MineMineNoMi3.Lists.ListMisc;
import MineMineNoMi3.Lists.ListRecipes;
import MineMineNoMi3.Network.PacketDispatcher;
import MineMineNoMi3.Proxy.CommonProxy;
import WyPI.WyPI;

@Mod(modid = "mineminenomi", name = "Mine Mine no Mi", version = "0.3.0")
public class Main 
{

	@Instance("mineminenomi")
	private static Main instance;	
	@SidedProxy(clientSide = "MineMineNoMi3.Proxy.ClientProxy", serverSide = "MineMineNoMi3.Proxy.CommonProxy")
	public static CommonProxy proxy;
	public static Logger logger;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
		PacketDispatcher.registerPackets();
		WyPI.setup(instance);

		ListDevilFruits.init();
		ListMisc.init();
		
		if(true)
		{
			WyPI.Utils.generateJSONModels();
		}
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
		GameRegistry.registerWorldGenerator(new MainWorldGen(), 1);	
		
		proxy.render();
		proxy.tick();
		
		ListEntities.init();
		ListEffects.init();
		ListCreativeTabs.init();
		ListRecipes.init();
		ListAchievements.init();
		ListForge.init();
		
		if(true)
			WyPI.Utils.generateLangFiles();
	} 
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {}	
	
	@EventHandler
	public void serverInit(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandDoriki());
		event.registerServerCommand(new CommandBelly());
		event.registerServerCommand(new CommandExtol());
		event.registerServerCommand(new CommandBounty());
	}

	public static Main getMineMineNoMi() {return instance;}
}
