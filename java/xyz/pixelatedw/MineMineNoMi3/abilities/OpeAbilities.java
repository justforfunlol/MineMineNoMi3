package xyz.pixelatedw.MineMineNoMi3.abilities;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.math.ISphere;
import xyz.pixelatedw.MineMineNoMi3.api.math.Sphere;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.OpeProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class OpeAbilities
{

	public static Ability[] abilitiesArray = new Ability[] {new Room(), new CounterShock(), new GammaKnife()};
	
	public static class GammaKnife extends Ability
	{
		public GammaKnife() 
		{
			super(ListAttributes.GAMMAKNIFE); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new OpeProjectiles.GammaKnife(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class Mes extends Ability
	{
		public Mes() 
		{
			super(ListAttributes.MES); 
		}
		
		public void use(EntityPlayer player)
		{
			WyHelper.sendMsgToPlayer(player, ChatFormatting.RED + "NOT YET IMPLEMENTED");
			//possible implementation using ~~raycasting~~ turning it passive and use the hand as means to activate Mes
			super.use(player);
		}
	}
	
	public static class CounterShock extends Ability
	{
		public CounterShock() 
		{
			super(ListAttributes.COUNTERSHOCK); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new OpeProjectiles.CounterShock(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
	public static class Room extends Ability
	{
		private boolean canSpawnRoom = true;
		
		public Room() 
		{
			super(ListAttributes.ROOM); 
		}
		
		public void use(EntityPlayer player)
		{
			if(!this.isOnCooldown && canSpawnRoom)
			{
				final World world = player.worldObj;
				Sphere.generate((int)player.posX, (int)player.posY, (int)player.posZ, 20, new ISphere()
				{
					public void call(int x, int y, int z)
					{
						if(world.getBlock(x, y ,z) == Blocks.air || world.getBlock(x, y ,z) == Blocks.tallgrass || world.getBlock(x, y ,z) == Blocks.leaves2 
								|| world.getBlock(x, y ,z) == Blocks.leaves || world.getBlock(x, y ,z) == Blocks.wheat || world.getBlock(x, y ,z) == Blocks.carrots)
							world.setBlock(x, y ,z, ListMisc.Ope);
					}
				});
				player.worldObj.setBlock((int) player.posX, (int) player.posY, (int) player.posZ, ListMisc.OpeMid);
				
				canSpawnRoom = false;
				super.use(player);
			}	
		} 
		
		public void alterSpawnFlag(boolean flag)
		{
			canSpawnRoom = flag;
		}
	}


}
