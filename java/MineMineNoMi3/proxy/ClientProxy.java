package MineMineNoMi3.proxy;

import MineMineNoMi3.entities.mobs.marines.Marine;
import MineMineNoMi3.entities.mobs.models.ModelMarine;
import MineMineNoMi3.entities.mobs.models.ModelPirate;
import MineMineNoMi3.entities.mobs.pirates.Pirate;
import WyPI.abilities.AbilityProjectile;
import WyPI.abilities.AbilityRenderer;
import WyPI.mobs.RenderMob;
import WyPI.modules.WyHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{

	public void preInit()
	{
		RenderingRegistry.registerEntityRenderingHandler(AbilityProjectile.class, (IRenderFactory) new AbilityRenderer(Minecraft.getMinecraft().getRenderManager()));
		
		RenderingRegistry.registerEntityRenderingHandler(Marine.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelMarine(), 1, "marine1"));
		RenderingRegistry.registerEntityRenderingHandler(Pirate.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelPirate(), 1, "pirate1"));
	}

	
	public void init()
	{	 
		//RenderingRegistry.registerEntityRenderingHandler(Doppelman.class, new RenderMob(new ModelBiped(), "doppelman"));
		 
		WyHelper.instance().generateIngameModels();
	}
}
