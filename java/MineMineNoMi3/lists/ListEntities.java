package MineMineNoMi3.lists;

import MineMineNoMi3.Main;
import MineMineNoMi3.entities.mobs.Doppelman;
import MineMineNoMi3.entities.mobs.marines.Marine;
import MineMineNoMi3.entities.mobs.pirates.Pirate;
import WyPI.abilities.AbilityProjectile;
import WyPI.modules.WyRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ListEntities
{  
	public static void init()
	{
		WyRegistry.instance().registerMob("Marine", Marine.class, 0x94D5F7, 0x0000FF);
		WyRegistry.instance().registerMob("Pirate", Pirate.class, 0xC9C9C9, 0xCC3134);
		
		WyRegistry.instance().registerMob("Doppelman", Doppelman.class, -1, -1);
		
		//EntityRegistry.registerModEntity(AbilityProjectile.class, "Ability Projectile", 1000, Main.getMineMineNoMi(), 128, 3, false); 
	}

}
