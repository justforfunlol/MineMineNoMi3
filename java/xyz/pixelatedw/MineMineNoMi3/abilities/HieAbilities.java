package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.HieProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class HieAbilities
{

	public static Ability[] abilitiesArray = new Ability[] {new IceBlockPartisan(), new IceAge(), new IceBall(), new IceTimeCapsule(), new IceBlockPheasant()};
	
	public static class IceBlockPartisan extends Ability
	{
		public IceBlockPartisan() 
		{
			super(ListAttributes.ICEBLOCKPARTISAN); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new HieProjectiles.IceBlockPartisan(player.worldObj, player, ListAttributes.ICEBLOCKPARTISAN);
			super.use(player);
		};	
	}
	
	public static class IceAge extends Ability
	{
		public IceAge() 
		{
			super(ListAttributes.ICEAGE); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				for (int i = -20; i < 20; i++) 
				for (int j = -10; j < 10; j++) 
				for (int k = -20; k < 20; k++)
					if(!player.worldObj.isAirBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k) && player.worldObj.getBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k) != ListMisc.Ope
							&& player.worldObj.getBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k) != ListMisc.OpeMid && player.worldObj.getBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k) != Blocks.bedrock)
						player.worldObj.setBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k, Blocks.packed_ice);
				
				super.use(player);
			}
		};	
	}
	
	public static class IceBall extends Ability
	{
		public IceBall() 
		{
			super(ListAttributes.ICEBALL); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new HieProjectiles.IceBall(player.worldObj, player, ListAttributes.ICEBALL);
			super.use(player);
		};	
	}
	
/*	public static class IceSaber extends SharpWeapon
	{
		public IceSaber() 
		{
			super(ListAttributes.ICESABER.getItemDamage(), false);
			this.attr = ListAttributes.ICESABER; 
		}

		public void tasksHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
		{
			target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 1));
		};
	}*/
	
	public static class IceTimeCapsule extends Ability
	{
		public IceTimeCapsule() 
		{
			super(ListAttributes.ICETIMECAPSULE); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				for(EntityLivingBase l : WyHelper.getEntitiesNear(player, 25))
				{
					WyHelper.createCube(l, new int[] {2, 4, 2}, Blocks.packed_ice);
				}
				super.use(player);
			}
		};	
	}
	
	public static class IceBlockPheasant extends Ability
	{
		public IceBlockPheasant() 
		{
			super(ListAttributes.ICEBLOCKPHEASANT); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new HieProjectiles.IceBlockPheasant(player.worldObj, player, ListAttributes.ICEBLOCKPHEASANT);
			super.use(player);
		};		
	}
	
}
