package MineMineNoMi3.lists;

import MineMineNoMi3.Main;
import MineMineNoMi3.entities.mobs.Doppelman;
import MineMineNoMi3.entities.mobs.marines.EntityCoby;
import MineMineNoMi3.entities.mobs.marines.EntityMarine;
import MineMineNoMi3.entities.mobs.marines.EntityMarineWithGun;
import MineMineNoMi3.entities.mobs.marines.EntityMomonga;
import MineMineNoMi3.entities.mobs.pirates.EntityPirate;
import MineMineNoMi3.entities.mobs.pirates.EntityPirateCaptain;
import MineMineNoMi3.entities.mobs.pirates.EntityPirateWithGun;
import MineMineNoMi3.entities.mobs.pirates.arlong.EntityArlong;
import MineMineNoMi3.entities.mobs.pirates.arlong.EntityChew;
import MineMineNoMi3.entities.mobs.pirates.arlong.EntityKuroobi;
import MineMineNoMi3.entities.mobs.pirates.baroqueworks.EntityMr0;
import MineMineNoMi3.entities.mobs.pirates.baroqueworks.EntityMr1;
import MineMineNoMi3.entities.mobs.pirates.baroqueworks.EntityMr3;
import MineMineNoMi3.entities.mobs.pirates.baroqueworks.EntityMr5;
import MineMineNoMi3.entities.mobs.pirates.krieg.EntityDonKrieg;
import MineMineNoMi3.entities.mobs.pirates.krieg.EntityGin;
import MineMineNoMi3.entities.mobs.pirates.krieg.EntityPearl;
import MineMineNoMi3.entities.projectiles.ProjectileAvalanche;
import MineMineNoMi3.entities.projectiles.ProjectileFire;
import MineMineNoMi3.entities.projectiles.ProjectileGas;
import MineMineNoMi3.entities.projectiles.ProjectileGlint;
import MineMineNoMi3.entities.projectiles.ProjectileGreenFire;
import MineMineNoMi3.entities.projectiles.ProjectileSmoke;
import MineMineNoMi3.entities.projectiles.ProjectileVulcan;
import WyPI.abilities.AbilityProjectile;
import WyPI.modules.WyRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ListEntities
{  
	public static void init()
	{
		EntityRegistry.registerModEntity(AbilityProjectile.class, "Ability Projectile", 1, Main.getMineMineNoMi(), 64, 10, true); 
		EntityRegistry.registerModEntity(ProjectileFire.class, "Ability Projectile Fire", 2, Main.getMineMineNoMi(), 64, 10, true); 
		EntityRegistry.registerModEntity(ProjectileAvalanche.class, "Ability Projectile Avalanche", 3, Main.getMineMineNoMi(), 64, 10, true); 
		EntityRegistry.registerModEntity(ProjectileVulcan.class, "Ability Projectile Vulcan", 4, Main.getMineMineNoMi(), 64, 10, true); 
		EntityRegistry.registerModEntity(ProjectileGas.class, "Ability Projectile Gas", 5, Main.getMineMineNoMi(), 64, 10, true); 
		EntityRegistry.registerModEntity(ProjectileGlint.class, "Ability Projectile Glint", 6, Main.getMineMineNoMi(), 64, 10, true); 
		EntityRegistry.registerModEntity(ProjectileSmoke.class, "Ability Projectile Smoke", 7, Main.getMineMineNoMi(), 64, 10, true); 
		EntityRegistry.registerModEntity(ProjectileGreenFire.class, "Ability Projectile Green Fire", 8, Main.getMineMineNoMi(), 64, 10, true); 
		
		//Marines
		WyRegistry.instance().registerMob("Marine", EntityMarine.class, 0x94D5F7, 0x0000FF);
		WyRegistry.instance().registerMob("Marine with Gun", EntityMarineWithGun.class, 0x94D5F7, 0x0000FF);
		WyRegistry.instance().registerMob("Coby", EntityCoby.class, 0x94D5F7, 0x0000FF);
		WyRegistry.instance().registerMob("Momonga", EntityMomonga.class, 0x94D5F7, 0x0000FF);
		
		//Pirates
		WyRegistry.instance().registerMob("Pirate", EntityPirate.class, 0xC9C9C9, 0xCC3134);
		WyRegistry.instance().registerMob("Pirate Captain", EntityPirateCaptain.class, 0xC9C9C9, 0xCC3134);
		WyRegistry.instance().registerMob("Pirate with Gun", EntityPirateWithGun.class, 0xC9C9C9, 0xCC3134);

		WyRegistry.instance().registerMob("Arlong", EntityArlong.class, 0xFF00FF, 0xFF00FF);
		WyRegistry.instance().registerMob("Chew", EntityChew.class, 0xFF00FF, 0xFF00FF);
		WyRegistry.instance().registerMob("Kuroobi", EntityKuroobi.class, 0xFF00FF, 0xFF00FF);
		
		WyRegistry.instance().registerMob("Don Krieg", EntityDonKrieg.class, 0xFF00FF, 0xFF00FF);
		WyRegistry.instance().registerMob("Gin", EntityGin.class, 0xFF00FF, 0xFF00FF);
		WyRegistry.instance().registerMob("Pearl", EntityPearl.class, 0xFF00FF, 0xFF00FF);
		
		WyRegistry.instance().registerMob("Mr 0", EntityMr0.class, 0xFF00FF, 0xFF00FF);
		WyRegistry.instance().registerMob("Mr 1", EntityMr1.class, 0xFF00FF, 0xFF00FF);
		WyRegistry.instance().registerMob("Mr 3", EntityMr3.class, 0xFF00FF, 0xFF00FF);
		WyRegistry.instance().registerMob("Mr 5", EntityMr5.class, 0xFF00FF, 0xFF00FF);
		
		//Misc
		WyRegistry.instance().registerMob("Doppelman", Doppelman.class, -1, -1);
		
	}

}
