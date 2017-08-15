package xyz.pixelatedw.MineMineNoMi3.api.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MeraProjectiles;

public class Ability 
{
	
	protected AbilityProjectile projectile;
	private AbilityAttribute attr;
	protected boolean isOnCooldown = false;
	private int ticksForCooldown;
	
	public Ability(AbilityAttribute attr)
	{
		this.attr = attr;
		ticksForCooldown = attr.getItemCooldown();
	}
	
	public AbilityAttribute getAttribute() { return attr; }
		
	public void use(EntityPlayer player)
	{		
		//isOnCooldown = false;
		if(!isOnCooldown)
		{
			if(projectile != null)
			{
				player.worldObj.spawnEntityInWorld(projectile);
				System.out.println(attr.getAttributeName());
			}
			
			if(this.attr.getPotionEffectsForUser() != null)
				for(PotionEffect p : this.attr.getPotionEffectsForUser())				
					player.addPotionEffect(new PotionEffect(p));
					 
			if(this.attr.getPotionEffectsForAoE() != null) 
				for(PotionEffect p : this.attr.getPotionEffectsForAoE())
					for(EntityLivingBase l : WyHelper.getEntitiesNear(player, this.attr.getEffectRadius())) 
						l.addPotionEffect(new PotionEffect(p));
	
			if(!(this.attr.getItemMaxCharges() > 0) && this.attr.getItemExplosionPower() > 0)
				player.worldObj.newExplosion(player, player.posX, player.posY, player.posZ, this.attr.getItemExplosionPower(), this.attr.getItemExplosionHasFire(), this.attr.getItemExplosionHasSmoke());		
			
			isOnCooldown = true;
			cooldown();
		}
	}
	
	public boolean isOnCooldown()
	{
		return isOnCooldown;
	}
	
	protected void cooldown()
	{
		if(isOnCooldown)
		{
			Cooldown cd = new Cooldown(ticksForCooldown);
			cd.start();
		}
	}
	
	class Cooldown extends Thread
	{
		private int forSeconds;
		
		public Cooldown(int forSeconds)
		{
			super("Cooldown Thread");
			this.forSeconds = forSeconds;
		}
		
		public void run()
		{
			while(forSeconds >= 0)
			{
				forSeconds--;
				try {
					sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}		
			isOnCooldown = false;
		}
	}
}
