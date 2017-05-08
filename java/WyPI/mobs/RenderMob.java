package WyPI.mobs;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import WyPI.WyPI;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMob extends RenderBiped<EntityMob> implements IRenderFactory<EntityMob>
{ 
	private float scale;
	private ModelBiped model;
	private String texturesSprite;
	private ResourceLocation texture;
	
	public RenderMob(RenderManager mg, ModelBiped model, float scale, String staticTexture)
	{
		super(mg, model, scale/2);
		this.model = model;
		this.scale = scale;
		this.texturesSprite = staticTexture;
		this.texture = new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID() + ":textures/mobs/" + staticTexture + ".png");	
	}    
	
	public RenderMob(RenderManager mg, ModelBiped model, float scale)
	{ 
		super(mg, model, 1);
		this.model = model;
		this.scale = scale;
		this.texture = null; 

		this.addLayer(new LayerHeldItem(this));
	}   
	
	public boolean canRenderName(EntityMob entity)
	{
		return false;
	}
	
    public void transformHeldFull3DItemLayer()
    {
        GlStateManager.translate(0.09375F, 0.1875F, 0.0F);
    }
	
    protected void preRenderCallback(EntityMob entity, float i)
    {
    	GL11.glScalef(this.scale, this.scale, this.scale);
    	if(entity instanceof IDynamicColorMob)
    	{
    		Color clr = Color.decode(((IDynamicColorMob) entity).getColor());
    		GlStateManager.color(clr.getRed()/255, clr.getGreen()/255, clr.getBlue()/255);
    	}
		//WyRenderHelper.instance().drawBoundingBox(entity, entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
    }
    
	protected ResourceLocation getEntityTexture(EntityMob entity) 
	{
		if((this.texture == null && entity instanceof IMultiTextureMob) || this.texture.equals(new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID() + ":textures/mobs/null.png")))
			return new ResourceLocation(WyPI.apiInstance.getParentMod().getParentModID() + ":textures/mobs/" + ((IMultiTextureMob)entity).getMobTexture() + ".png");
		else
			return this.texture;
	}
	
	public Render<? super EntityMob> createRenderFor(RenderManager manager)
	{
		return new RenderMob(manager, model, scale, texturesSprite);
	}
    
}
