package WyPI.mobs;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import WyPI.WyPI;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMob extends RenderLiving<EntityMob> implements IRenderFactory<EntityMob>
{ 
	private float scale;
	private ModelBase model;
	private String texturesSprite;
	private ResourceLocation texture;
	
	public RenderMob(RenderManager mg, ModelBase model, float scale, String staticTexture)
	{
		super(mg, model, scale/2);
		this.model = model;
		this.scale = scale;
		this.texturesSprite = staticTexture;
		this.texture = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID() + ":textures/mobs/" + staticTexture + ".png");		
	}   
	
	public RenderMob(RenderManager mg, ModelBase model, float scale)
	{ 
		super(mg, model, 1);
		this.model = model;
		this.scale = scale;
		this.texture = null;
	}   
	
    protected void preRenderCallback(EntityMob entity, float i)
    {
    	GL11.glScalef(this.scale, this.scale, this.scale);
		//WyRenderHelper.instance().drawBoundingBox(entity, entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
    }
    
	protected ResourceLocation getEntityTexture(EntityMob entity) 
	{
		return this.texture;
	}
	
	public Render<? super EntityMob> createRenderFor(RenderManager manager)
	{
		return new RenderMob(manager, model, scale, texturesSprite);
	}
    
}
