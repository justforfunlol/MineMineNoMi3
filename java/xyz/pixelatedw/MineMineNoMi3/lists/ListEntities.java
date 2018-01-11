package xyz.pixelatedw.MineMineNoMi3.lists;

import java.awt.Color;
import java.util.ArrayList;

import cpw.mods.fml.common.registry.EntityRegistry;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyRegistry;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMarine;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.EntityMarineWithGun;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirate;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirateCaptain;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirateWithGun;

public class ListEntities 
{
	
	public static void init()
	{
		int ids = 0;
		for(int i = 0; i < ListDevilFruits.ALL_ENTITIES.length; i++)
		{
			for(int j = 0; j < ((ArrayList)ListDevilFruits.ALL_ENTITIES[i]).size(); j++)
			{
				EntityRegistry.registerModEntity(((Class)((Object[])((ArrayList)ListDevilFruits.ALL_ENTITIES[i]).get(j))[0]), ((AbilityAttribute)((Object[])((ArrayList)ListDevilFruits.ALL_ENTITIES[i]).get(j))[1]).getAttributeName(), ids++, MainMod.getMineMineNoMi(), 64, 10, true);
			}
		}
		
		//Marines
		WyRegistry.registerMob("Marine with Sword", EntityMarine.class, 0x02258e, 0xFFFFFF);
		WyRegistry.registerMob("Marine with Gun", EntityMarineWithGun.class, 0x02258e, 0xFFFFFF);
		
		//Pirates
		WyRegistry.registerMob("Pirate with Sword", EntityPirate.class, 0x960606, 0xFFFFFF);
		WyRegistry.registerMob("Pirate with Gun", EntityPirateWithGun.class, 0x960606, 0xFFFFFF);
		WyRegistry.registerMob("Pirate Captain", EntityPirateCaptain.class, 0x960606, 0xFFFFFF);
		//Others
	}
	
}
