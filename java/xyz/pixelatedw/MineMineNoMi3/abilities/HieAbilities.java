package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.abilities.BaneAbilities.SpringDeathKnock;
import xyz.pixelatedw.MineMineNoMi3.abilities.BaneAbilities.SpringHopper;
import xyz.pixelatedw.MineMineNoMi3.abilities.BaneAbilities.SpringSnipe;
import xyz.pixelatedw.MineMineNoMi3.abilities.WeaponsAbilities.SharpWeapon;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.HieProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class HieAbilities
{

	public static AbilityItem[] abilitiesArray = new AbilityItem[] {new IceBlockPartisan(), new IceAge(), new IceBall(), new IceSaber(), new IceTimeCapsule(), new IceBlockPheasant()};
	
	public static class IceBlockPartisan extends AbilityItem
	{
		public IceBlockPartisan() 
		{
			this.attr = ListAttributes.ICEBLOCKPARTISAN; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new HieProjectiles.IceBlockPartisan(world, player, attr);
		};	
	}
	
	public static class IceAge extends AbilityItem
	{
		public IceAge() 
		{
			this.attr = ListAttributes.ICEAGE; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			for (int i = -20; i < 20; i++) 
			for (int j = -10; j < 10; j++) 
			for (int k = -20; k < 20; k++)
				if(!player.worldObj.isAirBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k) && player.worldObj.getBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k) != ListMisc.Ope
						&& player.worldObj.getBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k) != ListMisc.OpeMid && player.worldObj.getBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k) != Blocks.bedrock)
					player.worldObj.setBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k, Blocks.packed_ice);	
		};	
	}
	
	public static class IceBall extends AbilityItem
	{
		public IceBall() 
		{
			this.attr = ListAttributes.ICEBALL; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new HieProjectiles.IceBall(world, player, attr);
		};	
	}
	
	public static class IceSaber extends SharpWeapon
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
	}
	
	public static class IceTimeCapsule extends AbilityItem
	{
		public IceTimeCapsule() 
		{
			this.attr = ListAttributes.ICETIMECAPSULE; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			for(EntityLivingBase l : WyHelper.getEntitiesNear(player, 25))
			{
				WyHelper.createCube(l, new int[] {2, 4, 2}, Blocks.packed_ice);
			}
		};	
	}
	
	public static class IceBlockPheasant extends AbilityItem
	{
		public IceBlockPheasant() 
		{
			this.attr = ListAttributes.ICEBLOCKPHEASANT; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new HieProjectiles.IceBlockPheasant(world, player, attr);
		};		
	}
	
}
