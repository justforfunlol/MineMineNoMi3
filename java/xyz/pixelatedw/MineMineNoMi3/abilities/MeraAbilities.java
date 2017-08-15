package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.api.math.ISphere;
import xyz.pixelatedw.MineMineNoMi3.api.math.Sphere;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MeraProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.Tasks;

public class MeraAbilities
{
	public static Ability[] abilitiesArray = new Ability[] {new Hiken(), new Higan(), new DaiEnkaiEntei(), new Hidaruma(), new Jujika(), new Enjomo()};
	
	public static class Hiken extends Ability
	{
		public Hiken() 
		{
			super(ListAttributes.HIKEN);
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new MeraProjectiles.Hiken(player.worldObj, player, ListAttributes.HIKEN);			
			super.use(player);
		}
	}
	
	public static class Higan extends Ability
	{
		public Higan() 
		{
			super(ListAttributes.HIGAN); 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new MeraProjectiles.Higan(world, player, ListAttributes.HIGAN);
			super.use(player);
		};			
	}

	public static class DaiEnkaiEntei extends Ability
	{
		public DaiEnkaiEntei() 
		{
			super(ListAttributes.DAIENKAIENTEI); 
		}
		
		public void tasksAfterUse(ItemStack itemStack, World world, EntityPlayer player, int timeLeft)
		{						
			this.projectile = new MeraProjectiles.DaiEnkaiEntei(world, player, Tasks.requestNewChargedAttribute(itemStack, player, timeLeft));
			super.use(player);
		};	
	}

	public static class Hidaruma extends Ability
	{
		public Hidaruma() 
		{
			super(ListAttributes.HIDARUMA); 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new MeraProjectiles.Hidaruma(world, player, ListAttributes.HIDARUMA);
		};			
	}

	public static class Jujika extends Ability
	{
		public Jujika() 
		{
			super(ListAttributes.JUJIKA); 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new MeraProjectiles.Jujika(world, player, ListAttributes.JUJIKA);
			super.use(player);
		};			
	}

	public static class Enjomo extends Ability
	{
		public Enjomo() 
		{
			super(ListAttributes.ENJOMO); 
		}
		
		public void use(final EntityPlayer player)
		{
			if(!player.worldObj.isRemote)
			{
				if(!isOnCooldown)
				{
					Sphere.generate((int)(int) player.posX, (int)(int) player.posY, (int)(int) player.posZ, 12, new ISphere()
				    { 
						public void call(int x, int y, int z)
						{
			    			for(int i = -3; i <= 3; i++)
					    		if(player.worldObj.isAirBlock(x, y + i, z))
					    			player.worldObj.setBlock(x, y + i, z, Blocks.fire);
						}
				    });
					
					for(EntityLivingBase l : WyHelper.getEntitiesNear(player, 12))
					{l.setFire(20);}
					
					isOnCooldown = true;
					cooldown();
				}
			}
		};			
	}

}

