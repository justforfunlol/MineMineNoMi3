package xyz.pixelatedw.MineMineNoMi3.lists;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.EntityRegistry;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MeraProjectiles;

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
	}
	
}
