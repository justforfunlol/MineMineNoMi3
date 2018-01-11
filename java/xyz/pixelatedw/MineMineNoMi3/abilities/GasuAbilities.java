package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GasuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class GasuAbilities 
{

	public static Ability[] abilitiesArray = new Ability[] {new GasRobe(), new Gastille(), new Gastanet(), new Karakuni()};	
		
	
	public static class Karakuni extends Ability
	{
		public Karakuni() 
		{
			super(ListAttributes.KARAKUNI); 
		}
		
		public void use(EntityPlayer player)
		{	
			if(!player.worldObj.isRemote)
			{
				if(!isOnCooldown)
				{
					for(EntityLivingBase e : WyHelper.getEntitiesNear(player, 25))
					{
						e.attackEntityFrom(DamageSource.causePlayerDamage(player), 20);
						e.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1000, 2));
					}
					
					isOnCooldown = true;
					startCooldown();
				}
			}
		} 
	}
	
	public static class Gastanet extends Ability
	{
		public Gastanet() 
		{
			super(ListAttributes.GASTANET); 
		}
		
		public void use(EntityPlayer player)
		{	
			super.use(player);
		} 
	}
	
	public static class Gastille extends Ability
	{
		public Gastille() 
		{
			super(ListAttributes.GASTILLE); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new GasuProjectiles.Gastille(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class GasRobe extends Ability
	{
		public GasRobe() 
		{
			super(ListAttributes.GASROBE); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new GasuProjectiles.GasRobe(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
}
