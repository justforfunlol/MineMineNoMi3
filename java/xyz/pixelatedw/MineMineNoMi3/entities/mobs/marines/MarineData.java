package xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.Doppelman;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.EntityPirate;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates.PirateData;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;

public class MarineData extends EntityNewMob
{
	protected EntityAIBase entityAIMeleeAttack = new EntityAIAttackOnCollide(this, 1.0D, false);
	
	public MarineData(World world)
	{
		super(world);
		this.tasks.addTask(0, entityAIMeleeAttack);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, PirateData.class, 0, true));
	}
  
	public void onEntityUpdate() 
	{
/*		if(this.getAttackTarget() != null)
		{
			if(this.getAttackTarget() instanceof EntityPlayer)
			{
				ExtendedEntityStats props = ExtendedEntityStats.get(((EntityPlayer)this.getAttackTarget()));
				
				if(!(((EntityPlayer)this.getAttackTarget()).capabilities.isCreativeMode))
				{
					if(!props.getFaction().equals("Marine"))
					{
						this.targetTasks.addTask(1, attackMelee);
						this.targetTasks.addTask(2, nearestTarget);
					}
					else
					{
						this.targetTasks.removeTask(attackMelee);
						this.targetTasks.removeTask(nearestTarget);	
					}
				}	
			}
			else
			{
				this.targetTasks.addTask(1, attackMelee);			
			}
		}*/
		
		super.onEntityUpdate();
	}

	protected boolean isValidLightLevel()
	{return true;} 
    
	protected boolean canDespawn()
	{return true;}
    
	public boolean isAIEnabled()
	{return true;}
	
	public boolean getCanSpawnHere()
	{return true;}
		
}

