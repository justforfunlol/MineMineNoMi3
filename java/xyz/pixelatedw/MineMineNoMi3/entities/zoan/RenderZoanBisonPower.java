package xyz.pixelatedw.MineMineNoMi3.entities.zoan;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.worldGovernment.models.ModelLucci;

public class RenderZoanBisonPower extends Render 
{
	private ResourceLocation texture = new ResourceLocation(ID.PROJECT_ID, "textures/mobs/bison.png");
	private ModelBase model;
	
	public RenderZoanBisonPower()
	{
		this.shadowSize = 0;
		this.model = new ModelLucci();
	}
	
	public void render(EntityZoanBisonPower entity, double x, double y, double z, float u, float v) 
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y + 1.3F, (float) z);

		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		float f4 = 1.0F;
		GL11.glScalef(f4, f4, f4);
		this.bindEntityTexture(entity);
		GL11.glScalef(1.0F, 1.0F, 1.0F);

		this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	public void doRender(Entity entity, double x, double y, double z, float u, float v) 
	{
		this.render((EntityZoanBisonPower) entity, x, y, z, u, v);
	}

	protected ResourceLocation getEntityTexture(Entity p_110775_1_) 
	{
		return texture;
	}

}
