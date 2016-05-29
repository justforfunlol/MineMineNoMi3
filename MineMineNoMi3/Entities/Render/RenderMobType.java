package MineMineNoMi3.Entities.Render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import MineMineNoMi3.Entities.Mobs.Marines.MarineData;
import MineMineNoMi3.Entities.Mobs.Pirates.PirateData;

public class RenderMobType extends RenderLiving
{
	private ResourceLocation texture;
	private float scale;
	
	public RenderMobType(ModelBase model)
	{
		this(model, 1.0F, null);
	}
	
	public RenderMobType(ModelBase model, String tex)
	{
		this(model, 1.0F, tex);
	}
	
	public RenderMobType(ModelBase model, float scale, String tex)
	{
		super(Minecraft.getMinecraft().getRenderManager(), model, 0);
		this.scale = scale;
		if(tex != null)
			this.texture = new ResourceLocation("mineminenomi:textures/models/" + tex + ".png");
		else
			this.texture = null;
	}
	
	protected void preRenderCallback(EntityLivingBase livingBase, float f)
	{
		GL11.glScalef(this.scale, this.scale, this.scale);
	}
	
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		if(this.texture == null)
		{
			if(entity instanceof MarineData)
				return new ResourceLocation("mineminenomi:textures/models/" + ((MarineData)entity).getTexture() + ".png");
			if(entity instanceof PirateData)
				return new ResourceLocation("mineminenomi:textures/models/" + ((PirateData)entity).getTexture() + ".png");
			else
				return null;
		}
		else
			return this.texture;
	}
    
}
