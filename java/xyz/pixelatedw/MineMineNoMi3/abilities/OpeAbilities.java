package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.api.math.ISphere;
import xyz.pixelatedw.MineMineNoMi3.api.math.Sphere;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockOpeMid;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.OpeProjectiles;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.items.Heart;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class OpeAbilities 
{

	public static AbilityItem[] abilitiesArray = new AbilityItem[] {new GammaKnife(), new Mes(), new CounterShock(), new Room()};
	
	public static class Room extends AbilityItem
	{
		public Room() 
		{
			this.attr = ListAttributes.ROOM; 
		}
		
		public void tasksUse(ItemStack itemStack, final World world, EntityPlayer player)
		{
			if(!world.isRemote)
			{
				Sphere.generate((int) (int) player.posX, (int) (int) player.posY, (int) (int) player.posZ, 20, new ISphere()
				{
				    public void call(int x, int y, int z)
				    {
				    	if(world.getBlock(x, y ,z) == Blocks.air || world.getBlock(x, y ,z) == Blocks.tallgrass || world.getBlock(x, y ,z) == Blocks.leaves2 
				    			|| world.getBlock(x, y ,z) == Blocks.leaves || world.getBlock(x, y ,z) == Blocks.wheat || world.getBlock(x, y ,z) == Blocks.carrots)
				    		world.setBlock(x, y ,z, ListMisc.Ope);
				    }
				});
				player.worldObj.setBlock((int) player.posX, (int) player.posY, (int) player.posZ, ListMisc.OpeMid);
			}
		};	
	}
	
	public static class CounterShock extends AbilityItem
	{
		public CounterShock() 
		{
			this.attr = ListAttributes.COUNTERSHOCK; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new OpeProjectiles.CounterShock(world, player, attr);
		};	
	}
	
	public static class Mes extends AbilityItem
	{
		public Mes() 
		{
			this.attr = ListAttributes.MES; 
		}
		
	    public void tasksHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
	    {
			ExtendedEntityStats props = ExtendedEntityStats.get(target);

			if(props.hasHeart())
			{
				ItemStack heart = new ItemStack(ListMisc.Heart);
				((Heart) heart.getItem()).setHeartOwner(heart, target);
				heart.setStackDisplayName(target.getCommandSenderName() + "'s Heart"); 
						
				((EntityPlayer) player).inventory.addItemStackToInventory(heart);
				
				props.setHasHeart(false);			
			}
	    }
	}
	
	public static class GammaKnife extends AbilityItem
	{
		public GammaKnife() 
		{
			this.attr = ListAttributes.GAMMAKNIFE; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new OpeProjectiles.GammaKnife(world, player, attr);
		};	
	}
	
}
