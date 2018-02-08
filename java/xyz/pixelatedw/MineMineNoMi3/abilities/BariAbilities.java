package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.math.ISphere;
import xyz.pixelatedw.MineMineNoMi3.api.math.Sphere;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.BariProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class BariAbilities 
{
	public static Ability[] abilitiesArray = new Ability[] {new Barrier(), new BarrierBall(), new BarrierCrash()};
	
	
	public static class BarrierCrash extends Ability
	{
		public BarrierCrash() 
		{
			super(ListAttributes.BARRIERCRASH); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new BariProjectiles.BarrierCrash(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class BarrierBall extends Ability
	{
		public BarrierBall() 
		{
			super(ListAttributes.BARRIERBALL); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				MovingObjectPosition rtr = WyHelper.rayTraceBlocks(player);

				final World world = player.worldObj;
				Sphere.generate((int)player.posX, (int)player.posY, (int)player.posZ, 5, new ISphere()
				{
					public void call(int x, int y, int z)
					{
						if(world.getBlock(x, y ,z) == Blocks.air || world.getBlock(x, y ,z) == Blocks.tallgrass || world.getBlock(x, y ,z) == Blocks.leaves2 
								|| world.getBlock(x, y ,z) == Blocks.leaves || world.getBlock(x, y ,z) == Blocks.wheat || world.getBlock(x, y ,z) == Blocks.carrots)
							world.setBlock(x, y ,z, ListMisc.Barrier);
					}
				});
				
				super.use(player);
			}
		} 
	}
	
	public static class Barrier extends Ability
	{
		public Barrier() 
		{
			super(ListAttributes.BARRIER); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown)
			{
				if(WyHelper.get4Directions(player) == WyHelper.Direction.NORTH)
				{
					for(int x = -3; x < 3; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -1; z <= 1; z++)
						player.worldObj.setBlock((int) player.posX - x, (int) player.posY + y, ((int) player.posZ - 3) - z, ListMisc.Barrier);
				}
				if(WyHelper.get4Directions(player) == WyHelper.Direction.SOUTH)
				{
					for(int x = -3; x < 3; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -1; z <= 1; z++)
						player.worldObj.setBlock((int) player.posX - x, (int) player.posY + y, ((int) player.posZ + 2) - z, ListMisc.Barrier);
				}
				if(WyHelper.get4Directions(player) == WyHelper.Direction.EAST)
				{
					for(int x = -1; x < 1; x++)
					for(int y = 0; y <= 3; y++)
					for(int z = -3; z <= 3; z++)
						player.worldObj.setBlock(((int) player.posX + 2) - x, (int) player.posY + y, (int) player.posZ - z, ListMisc.Barrier);
				}
				if(WyHelper.get4Directions(player) == WyHelper.Direction.WEST)
				{
					for(int x = -1; x < 1; x++)
					for(int y = 0; y <= 3; y++)
						for(int z = -3; z <= 3; z++)
						player.worldObj.setBlock(((int) player.posX - 3) - x, (int) player.posY + y, (int) player.posZ - z, ListMisc.Barrier);
				}
				
				super.use(player);
			}
		} 
	}
}
