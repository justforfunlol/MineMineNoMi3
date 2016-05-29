package WyPI.Ability;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class AbilityRenderer extends Render implements IRenderFactory<AbilityProjectile>
{
	double scaleX, scaleY, scaleZ, rotAngle, rotX, rotY, rotZ, red, blue, green, renderPosX, renderPosY, renderPosZ;
	private ModelBase model;
    
	public AbilityRenderer(RenderManager manager)
	{
		super(manager);
	}
	
    public void render(AbilityProjectile entity, double par2, double par4, double par6, float par8, float par9)
    { 	
    	this.scaleX = entity.getAttributes().getScale()[0];
    	this.scaleY = entity.getAttributes().getScale()[1];
    	this.scaleZ = entity.getAttributes().getScale()[2];
    	
    	this.renderPosX = entity.getAttributes().getPosition()[0];
    	this.renderPosY = entity.getAttributes().getPosition()[1];
    	this.renderPosZ = entity.getAttributes().getPosition()[2];
    	
    	this.red = entity.getAttributes().getColor().getRed();
    	this.green = entity.getAttributes().getColor().getGreen();
    	this.blue = entity.getAttributes().getColor().getBlue();

    	this.rotAngle = entity.getAttributes().getRotation()[0];
    	this.rotX = entity.getAttributes().getRotation()[1];
    	this.rotY = entity.getAttributes().getRotation()[2];
    	this.rotZ = entity.getAttributes().getRotation()[3];
    	
    	this.renderPosX = entity.getAttributes().getPosition()[0]; 	
    	this.renderPosY = entity.getAttributes().getPosition()[1];    	
    	this.renderPosZ = entity.getAttributes().getPosition()[2];  	
    	
    	this.model = entity.getAttributes().getModel();   
    	
    	GlStateManager.pushMatrix();
    	GlStateManager.translate(par2 + renderPosX, par4 + renderPosY, par6 + renderPosZ);
    	GlStateManager.disableTexture2D();
    	GlStateManager.enableBlend();
    	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA); 

    	GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
    	GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);

    	GlStateManager.rotate((float)rotAngle, (float)rotX, (float)rotY, (float)rotZ);
	    
    	GlStateManager.color((float)this.red/255, (float)this.green/255, (float)this.blue/255, 255);
    	GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);

		if(entity.getAttributes().getModel() != null)
			this.model.render(entity, (float)par2, (float)par4, (float)par6, 0.0F, 0.0F, 0.0625F);
		
		GlStateManager.disableBlend();
		GlStateManager.enableTexture2D();
		GlStateManager.popMatrix();
    }

    public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9)
    {this.render(((AbilityProjectile)entity), par2, par4, par6, par8, par9);}

	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return null;
		/*if(((AbilityProjectile)entity).proj.getTexture() != null)
			return ((AbilityProjectile)entity).proj.getTexture();
		else
			return null;*/
	}

	public Render<? super AbilityProjectile> createRenderFor(RenderManager manager)
	{
		return new AbilityRenderer(manager);
	}

}
