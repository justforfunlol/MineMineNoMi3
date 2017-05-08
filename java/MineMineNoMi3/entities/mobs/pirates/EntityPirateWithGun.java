package MineMineNoMi3.entities.mobs.pirates;

import MineMineNoMi3.lists.ListExtraAttributes;
import WyPI.abilities.AbilityProjectile;
import WyPI.modules.WyHelper;
import WyPI.modules.WyHelper.Direction;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityPirateWithGun extends PirateData
{
	private String[] textures = {"pirategun1", "pirategun2", "pirategun3"};
	private int ticksBeforeShoot = 30, ticksBeforeEvade = 40;
	
	public EntityPirateWithGun(World world) 
	{
		super(world);
		this.setTexture(textures[this.rand.nextInt(textures.length)]);
 	} 
	  
	public void applyEntityAttributes()
	{ 
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	}

	public void onEntityUpdate() 
	{	
		Direction dir = WyHelper.instance().get4Directions(this);		

		if(this.getAttackTarget() != null)
		{
			this.getLookHelper().setLookPositionWithEntity(this.getAttackTarget(), 10, 10);
			
			if(ticksBeforeShoot <= 0 && this.canEntityBeSeen(this.getAttackTarget()) && this.getDistanceSqToEntity(this.getAttackTarget()) < 120)
			{ 
	    		double d0 = this.getDistanceSqToEntity(this.getAttackTarget());
	    		float f = MathHelper.sqrt_float(MathHelper.sqrt_double(d0));
	    		double d1 = this.getAttackTarget().posX - this.posX;
	    		double d2 = this.getAttackTarget().getEntityBoundingBox().minY + (double)(this.getAttackTarget().height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
	    		double d3 = this.getAttackTarget().posZ - this.posZ;

				AbilityProjectile proj = new AbilityProjectile(this.worldObj, this, ListExtraAttributes.NORMALBULLET.setProjectileDamage(6));
				proj.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
				proj.setThrowableHeading(d1 + this.getRNG().nextGaussian(), d2, d3 + this.getRNG().nextGaussian(), 1.7F, 0);
				this.worldObj.spawnEntityInWorld(proj);

	    		ticksBeforeShoot = 30; 
			}
			else 
				ticksBeforeShoot--;
			
			if(ticksBeforeEvade <= 0 && this.getDistanceSqToEntity(this.getAttackTarget()) < 60 && this.onGround)
			{
				if (dir == Direction.NORTH) this.motionZ += 3;
				if (dir == Direction.SOUTH) this.motionZ -= 3;
				if (dir == Direction.EAST) this.motionX -= 3;
				if (dir == Direction.WEST) this.motionX += 3;
				ticksBeforeEvade = 50;
			}
			else
				ticksBeforeEvade--;
		}
		
		super.onEntityUpdate();
	}
	
	public int getCombatType() { return 1; }
}
