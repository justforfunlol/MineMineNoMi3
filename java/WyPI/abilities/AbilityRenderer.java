package WyPI.abilities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.lwjgl.opengl.GL11;

import WyPI.WyPI;
import WyPI.abilities.extra.AttributeManager;
import WyPI.modules.WyHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AbilityRenderer extends Render implements IRenderFactory<AbilityProjectile>
{
	private double scaleX, scaleY, scaleZ, rotAngle, rotX, rotY, rotZ, red, blue, green, renderPosX, renderPosY, renderPosZ;
	private float alpha;
	private ModelBase model;
	private AbilityAttribute ablAttr;
	private AbilityItem item;
    
	public AbilityRenderer(RenderManager manager)
	{
		super(manager);
	}  	
	
    public void render(AbilityProjectile entity, double par2, double par4, double par6, float par8, float par9)
    { 	
    	
    	Set set = AttributeManager.instance().getHashMap().entrySet();
		Iterator i = set.iterator();
		
		while(i.hasNext())
		{
			Map.Entry entry = (Map.Entry)i.next();
			if(entry.getKey().equals(entity.getCustomNameTag()))
				this.ablAttr = AttributeManager.instance().getAttribute(entity.getCustomNameTag());
		}
    	
		/*Set set = WyPI.apiInstance.getItemsMap().entrySet();
		Iterator i = set.iterator();
		
		while(i.hasNext())
		{
			Map.Entry entry = (Map.Entry)i.next();
			if(entry.getKey() instanceof AbilityItem)
			{
				if( ((AbilityItem)entry.getKey()).getAttribute().getAttributeName().equals(entity.getCustomNameTag()) )
					this.item = ((AbilityItem)entry.getKey());
			}
		} */

		if(ablAttr != null)
		{ 
	    	this.scaleX = ablAttr.getProjectileSize()[0];
	    	this.scaleY = ablAttr.getProjectileSize()[1];
	    	this.scaleZ = ablAttr.getProjectileSize()[2];

	    	this.red = ablAttr.getProjectileColor().getRed();
	    	this.green = ablAttr.getProjectileColor().getGreen();
	    	this.blue = ablAttr.getProjectileColor().getBlue();
	    	this.alpha = ablAttr.getProjectileAlpha();
	    	
	    	this.model = ablAttr.getProjectileModel(); 
		}
		/*else
		{
	    	this.scaleX = 2;
	    	this.scaleY = 2;
	    	this.scaleZ = 2;
			
	    	this.red = 0;
	    	this.green = 255;
	    	this.blue = 0;
	    	
	    	this.model = new ModelCube();
		}*/
    	
    	GlStateManager.pushMatrix();
    	GlStateManager.translate((float)par2, (float)par4, (float)par6);
    	GlStateManager.disableTexture2D();
    	GlStateManager.enableBlend();
    	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA); 

        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);

    	//GlStateManager.rotate((float)rotAngle, (float)rotX, (float)rotY, (float)rotZ);

    	GlStateManager.color((float)this.red/255, (float)this.green/255, (float)this.blue/255, this.alpha/255);
    	GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);

		if(this.model != null)
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
