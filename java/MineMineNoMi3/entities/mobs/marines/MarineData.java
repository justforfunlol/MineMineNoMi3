package MineMineNoMi3.entities.mobs.marines;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.entities.EntityNewMob;
import WyPI.modules.WyHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MarineData extends EntityNewMob
{
	
	private EntityAIBase attackMelee = new EntityAIAttackMelee(this, 1.0D, true), 
						nearestAttableTarget = new EntityAINearestAttackableTarget(this, EntityPlayer.class, true);
	
	public MarineData(World world) 
	{
		super(world); 
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIHurtByTarget(this, true));
	} 
  
	public void onEntityUpdate() 
	{
		super.onEntityUpdate();
		for(EntityLivingBase players : WyHelper.instance().getEntitiesNear(this, 25))
		{
			if(players instanceof EntityPlayer)
			{
				IEntityCapability props = players.getCapability(Values.ENTITY_CAPABILITIES, null);
				
				if(!((EntityPlayer)players).capabilities.isCreativeMode)
				{
					if(!props.getFaction().equals("Marine"))
					{
						if(this instanceof IRangedAttackMob)
						{
							
						}
						else
						{
							this.tasks.addTask(1, attackMelee);
							this.targetTasks.addTask(1, nearestAttableTarget);
						}
					}
					else
					{
						this.tasks.removeTask(attackMelee);
						this.targetTasks.removeTask(nearestAttableTarget);	
					}
				}
			}
		}
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

