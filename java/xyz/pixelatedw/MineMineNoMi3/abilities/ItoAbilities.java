package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.ItoProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class ItoAbilities 
{
	
	public static Ability[] abilitiesArray = new Ability[] {new Parasite(), new SoraNoMichi(), new Overheat()};
	
	public static class Overheat extends Ability
	{
		public Overheat() 
		{
			super(ListAttributes.OVERHEAT); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new ItoProjectiles.Overheat(player.worldObj, player, attr);
			super.use(player);
		};	
	}
	
	public static class SoraNoMichi extends Ability
	{
		public SoraNoMichi() 
		{
			super(ListAttributes.SORANOMICHI); 
		}
		
		public void use(EntityPlayer player)
		{
			Direction dir = WyHelper.get8Directions(player);
			
			if(player.onGround)
				player.motionY += 1.8;
			else
				player.motionY += 1.96;

			if(dir == WyHelper.Direction.NORTH) player.motionZ -= 1;
			if(dir == WyHelper.Direction.NORTH_WEST) {player.motionZ -= 1;player.motionX -= 1;}
			if(dir == WyHelper.Direction.SOUTH) player.motionZ += 1;
			if(dir == WyHelper.Direction.NORTH_EAST) {player.motionZ -= 1;player.motionX += 1;}
			if(dir == WyHelper.Direction.WEST) player.motionX -= 1;
			if(dir == WyHelper.Direction.SOUTH_WEST) {player.motionZ += 1;player.motionX -= 1;}
			if(dir == WyHelper.Direction.EAST) player.motionX += 1;
			if(dir == WyHelper.Direction.SOUTH_EAST) {player.motionZ += 1;player.motionX += 1;}
			
			super.use(player);
		};	
	}
	
	public static class Parasite extends Ability
	{
		public Parasite() 
		{
			super(ListAttributes.PARASITE); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!player.worldObj.isRemote)
			{
				if(!isOnCooldown)
				{					
					for(EntityLivingBase l : WyHelper.getEntitiesNear(player, 20))
					{
						l.addPotionEffect(new PotionEffect(Potion.blindness.id, 1, 200));
						l.addPotionEffect(new PotionEffect(Potion.confusion.id, 1, 200));
					}
					
					isOnCooldown = true;
					startCooldown();
				}
			}
		};	
	}

}
