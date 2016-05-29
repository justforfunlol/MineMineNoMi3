package WyPI.Ability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import WyPI.WyPI;

public class AbilityProjectile extends EntityThrowable
{
	
	public int ticks, maxticks;
	private AbilityAttribute attr;
	private EntityPlayer player;
	
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

	public AbilityProjectile(World world, EntityPlayer player, AbilityAttribute attr)
	{
		super(world, player);
		this.ticks = attr.getEntityTicks();
		this.maxticks = ticks;
		this.attr = attr;
		this.player = player;
		if(this.attr != null)
		{
			this.motionX *= this.attr.getSpeed();
			this.motionY *= this.attr.getSpeed();
			this.motionZ *= this.attr.getSpeed();
			
			if(WyPI.Utils.get4Directions(player) == WyPI.Dir.SOUTH)
				this.attr.setPosition(this.attr.getPosition()[0], this.attr.getPosition()[1], this.attr.getPosition()[2]);
			else if(WyPI.Utils.get4Directions(player) == WyPI.Dir.EAST)
				this.attr.setPosition(this.attr.getPosition()[2], this.attr.getPosition()[1], this.attr.getPosition()[0]);
			else if(WyPI.Utils.get4Directions(player) == WyPI.Dir.NORTH)
				this.attr.setPosition(this.attr.getPosition()[0], this.attr.getPosition()[1], this.attr.getPosition()[2]);
			else if(WyPI.Utils.get4Directions(player) == WyPI.Dir.WEST)
				this.attr.setPosition(this.attr.getPosition()[2], this.attr.getPosition()[1], this.attr.getPosition()[0]);
			 
			this.posX += this.attr.getPosition()[0];
			this.posY += this.attr.getPosition()[1];
			this.posZ += this.attr.getPosition()[2];
		}
	}
	
	public AbilityAttribute getAttributes()
	{return this.attr;}
	
	public void onEntityUpdate()
	{	
		if(this.attr.getTasks() != null)
			for(AbilityTask t : this.attr.getTasks())
				t.onProjectileUpdate(this);
		if(this.attr.getTrailForProjectile() != null )//&& System.nanoTime() % 3 == 0)
			this.attr.getTrailForProjectile().render(this, this.attr.getTrailTypeForProjectile());
		if(ticks <= 0)
		{
			ticks = maxticks;
			this.setDead();
		}
		else
			ticks--;		
	}

	public void onUpdate()
	{super.onUpdate();}

	protected void onImpact(RayTraceResult hit)
	{
		if (hit.entityHit != null && hit.entityHit instanceof EntityLivingBase)
		{   
			if(this.attr.getPotionEffectList() != null && this.attr.getPotionEffectList().length > 0)
				for(PotionEffect p : this.attr.getPotionEffectList())
					((EntityLivingBase)hit.entityHit).addPotionEffect(new PotionEffect(p));
			
			if(this.attr.getDamage() > 0)
				hit.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.attr.getDamage());
			
			if(this.attr.getEntityOnFireTimer() > 0)
				hit.entityHit.setFire(this.attr.getEntityOnFireTimer());
		}
		if (!this.worldObj.isRemote)
		{
			if(this.attr.getExplosion() > 0)
				this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, this.attr.getExplosion(), this.attr.hasFire(), this.attr.hasExplosion());

			if(this.attr.getTasks() != null)
				for(AbilityTask t : this.attr.getTasks())
					t.onProjectileHit(this, hit);
			
			this.setDead();
		}          
	}
	
	protected float getGravityVelocity()
	{return 0.001F;}

}