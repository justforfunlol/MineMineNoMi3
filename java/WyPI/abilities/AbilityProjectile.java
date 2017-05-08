package WyPI.abilities;

import WyPI.modules.WyHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class AbilityProjectile extends EntityThrowable
{
	public int ticks, maxticks;
	private AbilityAttribute attr;
	private EntityLivingBase user;
	
	public AbilityProjectile(World world)
	{
		super(world);
	}
	
	public AbilityProjectile(World world, EntityPlayer player)
	{
		super(world, player);
	}
	
	public AbilityProjectile(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	public AbilityProjectile(World world, EntityLivingBase player, AbilityAttribute attr)
	{
		super(world, player);
		this.ticks = attr.getProjectileTicks();
		this.maxticks = ticks;
		this.setCustomNameTag(WyHelper.instance().getFancyName(attr.getAttributeName()));
		this.attr = attr;
		this.user = player;
		if(this.attr != null)
		{
			/*this.motionX *= this.attr.getSpeed();
			this.motionY *= this.attr.getSpeed();
			this.motionZ *= this.attr.getSpeed();
			
			if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.SOUTH)
				this.attr.setPosition(this.attr.getPosition()[0], this.attr.getPosition()[1], this.attr.getPosition()[2]);
			else if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.EAST)
				this.attr.setPosition(this.attr.getPosition()[2], this.attr.getPosition()[1], this.attr.getPosition()[0]);
			else if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.NORTH)
				this.attr.setPosition(this.attr.getPosition()[0], this.attr.getPosition()[1], this.attr.getPosition()[2]);
			else if(WyHelper.instance().get4Directions(player) == WyHelper.Direction.WEST)
				this.attr.setPosition(this.attr.getPosition()[2], this.attr.getPosition()[1], this.attr.getPosition()[0]);
			*/
			this.posX += this.attr.getProjectilePosition()[0];
			this.posY += this.attr.getProjectilePosition()[1];
			this.posZ += this.attr.getProjectilePosition()[2];
		}
	}

	public AbilityAttribute getAttribute()
	{return this.attr;}
	 
	public void onEntityUpdate()
	{	
		if(this.attr != null)
		{
			if(this.attr.getTasks() != null)
				for(AbilityTask t : this.attr.getTasks())
					t.onProjectileUpdate(this);

			if(ticks <= 0)
			{
				ticks = maxticks;
				this.setDead();
			}
			else
				ticks--;
		}
	}

	public void onUpdate()
	{super.onUpdate();}

	protected void onImpact(RayTraceResult hit)
	{
		if(this.attr != null)
		{
			if (hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
			{  
				if(this.attr.getPotionEffectsForProjectile() != null)
					for(PotionEffect p : this.attr.getPotionEffectsForProjectile())
						((EntityLivingBase)hit.entityHit).addPotionEffect(new PotionEffect(p));
				
				if(this.attr.getProjectileDamage() > 0)
					hit.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.attr.getProjectileDamage());
				
				System.out.println( this.attr.getProjectileDamage() );
				System.out.println( this.attr.getAttributeName() );
			}
			if (!this.worldObj.isRemote)
			{
				if(this.attr.getProjectileExplosionPower() > 0)
					this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, this.attr.getProjectileExplosionPower(), this.attr.canExplosionSetFire(), this.attr.canExplosionDestroyBlocks());

				if(this.attr.getTasks() != null)
					for(AbilityTask t : this.attr.getTasks())
						t.onProjectileHit(this, hit);
				
				this.setDead();
			}  
		}
		else
			this.setDead();
	}
	
	protected float getGravityVelocity()
	{return 0.001F;}

}