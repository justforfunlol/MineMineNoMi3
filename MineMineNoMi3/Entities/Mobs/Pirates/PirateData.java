package MineMineNoMi3.Entities.Mobs.Pirates;

import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import MineMineNoMi3.Values;
import MineMineNoMi3.Entities.Mobs.Marines.MarineData;

public class PirateData extends EntityMob
{
	
	public PirateData(World world) 
	{
		super(world);
		this.tasks.addTask(1, new EntityAISwimming(this));
        //this.tasks.addTask(2, new EntityAIAttackOnCollide(this, MarineData.class, 1.0D, false));
        //this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, MarineData.class, 8.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		this.tasks.addTask(10, new EntityAIHurtByTarget(this, true));
		this.tasks.addTask(11, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.tasks.addTask(12, new EntityAINearestAttackableTarget(this, MarineData.class, true));    
	}

	/*public void onEntityUpdate() 
	{

	}*/
	
	public String getTexture()
	{
		return this.getDataManager().get(Values.TEXTURE);
	}

	protected void setTexture(String texture)
	{
		this.getDataManager().set(Values.TEXTURE, texture);
	}
	
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		nbt.setString("Texture", getTexture());
	}
	
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		setTexture(nbt.getString("Texture"));
	}
	
	protected void entityInit()
	{
		super.entityInit();
	    this.getDataManager().register(Values.TEXTURE, "n/a");
	}
	
	public boolean attackEntityFrom(DamageSource damageSource, float f)
	{return super.attackEntityFrom(damageSource, f);}

	protected boolean isValidLightLevel()
	{return true;} 
    
	protected boolean canDespawn()
	{return true;}
    
	public boolean isAIEnabled()
	{return true;}
	
	public boolean getCanSpawnHere()
	{return true;}

}

