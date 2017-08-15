package xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
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
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.Doppelman;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.EntityNewMob;
import xyz.pixelatedw.MineMineNoMi3.entities.mobs.marines.MarineData;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;

public class PirateData extends EntityNewMob
{

	private EntityAIBase attackMelee = new EntityAIAttackOnCollide(this, 1.0D, true), 
					nearestAttableTarget = new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true),
					nearestAttableTargetDopp = new EntityAINearestAttackableTarget(this, Doppelman.class, 0, true),
					nearestAttableTargetMarine = new EntityAINearestAttackableTarget(this, MarineData.class, 0, true);

	public PirateData(World world)
	{
		super(world);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIHurtByTarget(this, false));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	}

	public void onEntityUpdate()
	{
		for (EntityLivingBase entity : WyHelper.getEntitiesNear(this, 45))
		{
			if (entity instanceof EntityPlayer)
			{
				ExtendedEntityStats props = ExtendedEntityStats.get(entity);
				ExtendedEntityStats propz = ExtendedEntityStats.get(this);

				if (!((EntityPlayer) entity).capabilities.isCreativeMode)
				{
					if (!(this instanceof IRangedAttackMob))
						this.tasks.addTask(1, attackMelee);
					this.targetTasks.addTask(1, nearestAttableTarget);

					/*
					 * if(!props.getCrew().equals(propz.getCrew()) &&
					 * (!props.getCrew().equals("N/A") ||
					 * !propz.getCrew().equals("N/A"))) { if(!(this instanceof
					 * IRangedAttackMob)) this.tasks.addTask(1, attackMelee);
					 * this.targetTasks.addTask(1, nearestAttableTarget); } else
					 * { this.tasks.removeTask(attackMelee);
					 * this.targetTasks.removeTask(nearestAttableTarget); }
					 */
				}
			}
			else if (entity instanceof MarineData)
			{
				if (!(this instanceof IRangedAttackMob))
					this.tasks.addTask(1, attackMelee);
				this.targetTasks.addTask(1, nearestAttableTargetMarine);
			}
			else if(entity instanceof Doppelman)
			{
				if(!(this instanceof IRangedAttackMob))
					this.tasks.addTask(1, attackMelee);
				this.targetTasks.addTask(1, nearestAttableTargetDopp);
			}
		}
		super.onEntityUpdate();
	}

	protected boolean isValidLightLevel()
	{
		return true;
	}

	protected boolean canDespawn()
	{
		return true;
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public boolean getCanSpawnHere()
	{
		return true;
	}

}
