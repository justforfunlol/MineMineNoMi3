package MineMineNoMi3.Proxy;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import MineMineNoMi3.Values;
import MineMineNoMi3.Entities.Mobs.Doppelman;
import MineMineNoMi3.Entities.Mobs.Marines.Marine;
import MineMineNoMi3.Entities.Mobs.Models.ModelMarine;
import MineMineNoMi3.Entities.Mobs.Models.ModelPirate;
import MineMineNoMi3.Entities.Mobs.Pirates.Pirate;
import MineMineNoMi3.Entities.Render.RenderMobType;

public class ClientProxy extends CommonProxy
{

	public void render()
	{	 
		for(Item devilFruit : Values.devilfruits)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(devilFruit, 0, new ModelResourceLocation("mineminenomi:" + devilFruit.getUnlocalizedName().substring(5), "inventory"));
		
		for(Item ability : Values.abilities)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ability, 0, new ModelResourceLocation("mineminenomi:" + ability.getUnlocalizedName().substring(5), "inventory"));
			
		for(Item misc : Values.miscItems)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(misc, 0, new ModelResourceLocation("mineminenomi:" + misc.getUnlocalizedName().substring(5), "inventory"));
		
		for(Block misc : Values.miscBlocks)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(misc), 0, new ModelResourceLocation("mineminenomi:" + misc.getUnlocalizedName().substring(5), "inventory"));
 
		//RenderingRegistry.registerEntityRenderingHandler(Marine.class, RenderMobType()::new);
		//RenderingRegistry.registerEntityRenderingHandler(Marine.class, new IRenderFactoryBasic(new ModelPirate()));

		RenderingRegistry.registerEntityRenderingHandler(Marine.class, new RenderMobType(new ModelMarine()));
		RenderingRegistry.registerEntityRenderingHandler(Pirate.class, new RenderMobType(new ModelPirate()));
		 
		RenderingRegistry.registerEntityRenderingHandler(Doppelman.class, new RenderMobType(new ModelBiped(), "doppelman"));
		 
	}
	
	public EntityPlayer getPlayerEntity(MessageContext ctx) 
	{
		return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}
}
