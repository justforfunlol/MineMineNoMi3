package MineMineNoMi3.proxy;

import MineMineNoMi3.entities.mobs.Doppelman;
import MineMineNoMi3.entities.mobs.marines.EntityCoby;
import MineMineNoMi3.entities.mobs.marines.EntityMarine;
import MineMineNoMi3.entities.mobs.marines.EntityMarineWithGun;
import MineMineNoMi3.entities.mobs.marines.EntityMomonga;
import MineMineNoMi3.entities.mobs.models.ModelArlong;
import MineMineNoMi3.entities.mobs.models.ModelChew;
import MineMineNoMi3.entities.mobs.models.ModelCoby;
import MineMineNoMi3.entities.mobs.models.ModelGin;
import MineMineNoMi3.entities.mobs.models.ModelKrieg;
import MineMineNoMi3.entities.mobs.models.ModelKuroobi;
import MineMineNoMi3.entities.mobs.models.ModelMarine;
import MineMineNoMi3.entities.mobs.models.ModelMarineWithGun;
import MineMineNoMi3.entities.mobs.models.ModelMomonga;
import MineMineNoMi3.entities.mobs.models.ModelMr0;
import MineMineNoMi3.entities.mobs.models.ModelMr1;
import MineMineNoMi3.entities.mobs.models.ModelMr3;
import MineMineNoMi3.entities.mobs.models.ModelPearl;
import MineMineNoMi3.entities.mobs.models.ModelPirate;
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
import WyPI.abilities.AbilityRenderer;
import WyPI.mobs.RenderMob;
import WyPI.modules.WyHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{ 

	public void preInit()
	{
		RenderingRegistry.registerEntityRenderingHandler(AbilityProjectile.class, (IRenderFactory) new AbilityRenderer(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(ProjectileFire.class, (IRenderFactory) new AbilityRenderer(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(ProjectileAvalanche.class, (IRenderFactory) new AbilityRenderer(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(ProjectileVulcan.class, (IRenderFactory) new AbilityRenderer(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(ProjectileGas.class, (IRenderFactory) new AbilityRenderer(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(ProjectileGlint.class, (IRenderFactory) new AbilityRenderer(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(ProjectileSmoke.class, (IRenderFactory) new AbilityRenderer(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(ProjectileGreenFire.class, (IRenderFactory) new AbilityRenderer(Minecraft.getMinecraft().getRenderManager()));
		
		RenderingRegistry.registerEntityRenderingHandler(Doppelman.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 1, "doppelman"));
		 
		//Marines
		RenderingRegistry.registerEntityRenderingHandler(EntityMarine.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelMarine(), 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityMarineWithGun.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelMarineWithGun(), 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityCoby.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelCoby(), 1, "coby"));
		RenderingRegistry.registerEntityRenderingHandler(EntityMomonga.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelMomonga(), 1, "momonga"));
		
		//Pirates
		RenderingRegistry.registerEntityRenderingHandler(EntityPirate.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelPirate(), 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityPirateCaptain.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelPirate(), 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityPirateWithGun.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelMarineWithGun(), 1));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityArlong.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelArlong(), 1, "arlong"));
		RenderingRegistry.registerEntityRenderingHandler(EntityChew.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelChew(), 1, "chew"));
		RenderingRegistry.registerEntityRenderingHandler(EntityKuroobi.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelKuroobi(), 1, "kuroobi"));

		RenderingRegistry.registerEntityRenderingHandler(EntityDonKrieg.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelKrieg(), 1, "krieg"));
		RenderingRegistry.registerEntityRenderingHandler(EntityGin.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelGin(), 1, "gin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityPearl.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelPearl(), 1, "pearl"));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMr0.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelMr0(), 1, "mr0"));
		RenderingRegistry.registerEntityRenderingHandler(EntityMr1.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelMr1(), 1, "mr1"));
		RenderingRegistry.registerEntityRenderingHandler(EntityMr3.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelMr3(), 1, "mr3"));
		RenderingRegistry.registerEntityRenderingHandler(EntityMr5.class, (IRenderFactory) new RenderMob(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 1, "mr5"));
	}

	
	public void init()
	{	 
		WyHelper.instance().generateIngameModels();
	}
}
