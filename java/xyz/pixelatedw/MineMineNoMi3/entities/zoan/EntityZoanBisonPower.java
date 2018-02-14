package xyz.pixelatedw.MineMineNoMi3.entities.zoan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityZoanBisonPower extends Entity
{

	private EntityPlayer owner;
	
	public EntityZoanBisonPower(World world)
	{
		super(world);
		this.motionX *= 0;
		this.motionY *= 0;
		this.motionZ *= 0;
		
		this.noClip = true;
		this.ignoreFrustumCheck = true;
	}
	
	public void onUpdate()
	{	
	    this.lastTickPosX = this.posX;
	    this.lastTickPosY = this.posY;
	    this.lastTickPosZ = this.posZ;
	    
		if(!this.worldObj.isRemote)
		{			
			if(owner == null)
				this.setDead();			
			
			if(owner != null)
			{
				if(owner.isDead)
					this.setDead();
				
				this.posX = owner.posX;
				this.posY = owner.posY;
				this.posZ = owner.posZ;
				this.rotationYaw = owner.rotationYaw;
			}
		}
		
		super.onUpdate();
	}
	
	public boolean canBeCollidedWith()
	{
		return false;
	}
	
	public boolean canBePushed()
	{
		return false;
	}
	
	public void setOwner(EntityPlayer owner)
	{
		this.owner = owner;
	}

	protected void entityInit() 
	{
		
	}

	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {}

	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {}
	
}
