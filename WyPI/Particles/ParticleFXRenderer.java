package WyPI.Particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import WyPI.WyPI;

@SideOnly(Side.CLIENT)
public class ParticleFXRenderer extends Render
{
	private String texture;
	
	protected ParticleFXRenderer(String textureName) 
	{
		super(Minecraft.getMinecraft().getRenderManager());
		this.texture = textureName;
	}
	
    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        GlStateManager.pushMatrix();
        
        GlStateManager.translate(x, y, z);
        
        GlStateManager.popMatrix();
    }
    
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation(WyPI.getMODID(),  this.texture + ".png");
	}

}
