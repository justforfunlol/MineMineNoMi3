package MineMineNoMi3.entities.mobs.marines;

import javax.annotation.Nullable;

import MineMineNoMi3.lists.ListMisc;
import WyPI.modules.WyHelper;
import WyPI.modules.WyHelper.Direction;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityMomonga extends MarineData
{
	private int ticksBeforeSoru = 50;
	
	public EntityMomonga(World world)
	{
		super(world);
	}
	
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(140.0D);
	}

	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	{
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		
		this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(ListMisc.MarineSword));
		
		return livingdata;
	}
	
	public void onUpdate() 
	{
		Direction dir = WyHelper.instance().get4Directions(this);
		
		if(this.getAttackTarget() != null)
		{
			
			if(this.getHealth() < this.getMaxHealth()/2)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
			
			if(ticksBeforeSoru <= 0 && this.getDistanceSqToEntity(this.getAttackTarget()) < 250 && this.onGround)
			{
				if(this.getHealth() < this.getMaxHealth() / 2)
				{
					if (dir == Direction.NORTH) this.motionZ -= 2.8;
					if (dir == Direction.SOUTH) this.motionZ += 2.8;
					if (dir == Direction.EAST) this.motionX += 2.8;
					if (dir == Direction.WEST) this.motionX -= 2.8;
					this.rotationPitch += 180;
				}
				else
				{
					if (dir == Direction.NORTH) this.motionZ -= 3.3;
					if (dir == Direction.SOUTH) this.motionZ += 3.3;
					if (dir == Direction.EAST) this.motionX += 3.3;
					if (dir == Direction.WEST) this.motionX -= 3.3;
					this.rotationPitch += 180;
				}
				this.ticksBeforeSoru = 40;
			}
			else
				this.ticksBeforeSoru--;
		}
		
		super.onUpdate();
	}
}
