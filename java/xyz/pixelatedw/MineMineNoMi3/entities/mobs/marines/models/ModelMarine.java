package xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ModelMarine extends ModelBiped
{
	protected static final double CYCLES_PER_BLOCK = 1.0D; 
    protected int cycleIndex = 0;
    protected float[] cycle = new float[]
        { 45F, 33.75F, 22.5F, 11.25F, 0F, -11.25F, -22.5F, -33.75F, -45F, -45F, -33.75F, -22.5F, -11.25F, 0F, 11.25F, 22.5F, 33.75F, 45F };

	public ModelMarine()
	{
		super(0, 0, 64, 64);
		this.bipedHeadwear.showModel = false;
	}
	
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scaleFactor, Entity ent)
    {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, headYaw, headPitch, scaleFactor, ent);
				
		//System.out.println(ent.getDataWatcher().getWatchableObjectInt(27));
		
	    //cycleIndex = (int) (ent.ticksExisted % cycle.length);     
	    //this.bipedBody.rotateAngleY = degToRad(cycle[cycleIndex]) ;
	    //System.out.println("cycleIndex=" + cycleIndex);   
	    
		/*animator.setAnim(1);
		animator.rotate(this.bipedBody, 0, 45, 0);
		animator.rotate(this.bipedBody, 0, 0, 0);
		animator.rotate(this.bipedBody, 0, -45, 0);*/
		
        /*float f6 = MathHelper.sin(this.onGround * (float)Math.PI);
        float f7 = MathHelper.sin((1.0F - (1.0F - this.onGround) * (1.0F - this.onGround)) * (float)Math.PI);
        this.bipedRightArm.rotateAngleZ = 0.0F;
        this.bipedLeftArm.rotateAngleZ = 0.0F;
        this.bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F);
        this.bipedLeftArm.rotateAngleY = 0.1F - f6 * 0.6F;      
        this.bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
        //this.bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;       
        this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        //this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F);
        //this.bipedLeftArm.rotateAngleX = -((float)Math.PI / 2F);*/
	}

    protected float degToRad(float degrees)
    {
        return degrees * (float)Math.PI / 180 ;
    }
}

