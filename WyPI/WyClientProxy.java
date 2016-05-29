package WyPI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import WyPI.Ability.AbilityProjectile;
import WyPI.Ability.AbilityRenderer;

public class WyClientProxy extends WyCommonProxy
{

	public void render()
	{
		RenderingRegistry.registerEntityRenderingHandler(AbilityProjectile.class, (IRenderFactory) new AbilityRenderer(Minecraft.getMinecraft().getRenderManager()));
	}

}
