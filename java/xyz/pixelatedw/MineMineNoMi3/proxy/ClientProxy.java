package xyz.pixelatedw.MineMineNoMi3.proxy;

import java.util.ArrayList;

import cpw.mods.fml.client.registry.RenderingRegistry;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityRenderer;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.MobRenderer;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMarine;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMarineWithGun;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.models.ModelMarine;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.models.ModelMarineWithGun;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirate;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirateCaptain;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirateWithGun;
import xyz.pixelatedw.MineMineNoMi3.lists.ListDevilFruits;

public class ClientProxy extends CommonProxy
{

	public void preInit()
	{

	}
	
	public void init()
	{	
		for(int i = 0; i < ListDevilFruits.ALL_ENTITIES.length; i++)
		{
			for(int j = 0; j < ((ArrayList)ListDevilFruits.ALL_ENTITIES[i]).size(); j++)
			{
				RenderingRegistry.registerEntityRenderingHandler(((Class)((Object[])((ArrayList)ListDevilFruits.ALL_ENTITIES[i]).get(j))[0]), new AbilityRenderer(((AbilityAttribute)((Object[])((ArrayList)ListDevilFruits.ALL_ENTITIES[i]).get(j))[1])));
			}
		}
		
		//Marines
		RenderingRegistry.registerEntityRenderingHandler(EntityMarine.class, new MobRenderer(new ModelMarine()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMarineWithGun.class, new MobRenderer(new ModelMarineWithGun()));
		
		//Pirates
		RenderingRegistry.registerEntityRenderingHandler(EntityPirate.class, new MobRenderer(new ModelMarine()));
		RenderingRegistry.registerEntityRenderingHandler(EntityPirateWithGun.class, new MobRenderer(new ModelMarineWithGun()));		
		RenderingRegistry.registerEntityRenderingHandler(EntityPirateCaptain.class, new MobRenderer(new ModelMarine()));		
	}
	
}
