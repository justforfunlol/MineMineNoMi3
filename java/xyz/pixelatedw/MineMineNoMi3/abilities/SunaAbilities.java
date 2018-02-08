package xyz.pixelatedw.MineMineNoMi3.abilities;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.SunaProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class SunaAbilities 
{

	public static Ability[] abilitiesArray = new Ability[] {new Barjan(), new Sables(), new GroundDeath(), new DesertSpada()};

	public static class Barjan extends Ability
	{
		public Barjan() 
		{
			super(ListAttributes.BARJAN); 
		}
		
		public void use(EntityPlayer player)
		{		
			this.projectile = new SunaProjectiles.Barjan(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class Sables extends Ability
	{
		public Sables() 
		{
			super(ListAttributes.SABLES); 
		}
		
		public void use(EntityPlayer player)
		{		
			WyHelper.sendMsgToPlayer(player, ChatFormatting.RED + "NOT YET IMPLEMENTED");
			super.use(player);
		} 
	}
	
	public static class GroundDeath extends Ability
	{
		public GroundDeath() 
		{
			super(ListAttributes.GROUNDDEATH); 
		}
		
		public void use(EntityPlayer player)
		{	
			if(!isOnCooldown)
			{
				for(EntityLivingBase l : WyHelper.getEntitiesNear(player, 25))
				{
					for(int i = -2; i < 2; i++)
					for(int j = -3; j < 3; j++)
					for(int k = -2; k < 2; k++)
					{
						l.worldObj.setBlock((int) l.posX + k, (int) l.posY - j, (int) l.posZ + i, Blocks.air);
						l.worldObj.setBlock((int) l.posX + k, (int) l.posY + j, (int) l.posZ + i, Blocks.sand);
					}
				}				
				super.use(player);
			}
		}
	}
	
	public static class DesertSpada extends Ability
	{
		public DesertSpada() 
		{
			super(ListAttributes.DESERTSPADA); 
		}
		
		public void use(EntityPlayer player)
		{		
			if(!isOnCooldown)
			{
				if(WyHelper.get4Directions(player) == WyHelper.Direction.NORTH)
				{
					for(int i = -3; i < 3; i++)
					for(int j = 0; j < 5; j++)
					for(int k = 0; k < 12; k++)		
					{
						player.worldObj.setBlock((int) player.posX + i, (int) player.posY - (j + 2), (int) player.posZ - (k + 2), Blocks.air);
						player.worldObj.setBlock((int) player.posX + i, (int) player.posY + (j + 2), (int) player.posZ - (k + 2), Blocks.sand);
					}
				}
				else if(WyHelper.get4Directions(player) == WyHelper.Direction.SOUTH)
				{
					for(int i = -3; i < 3; i++)
					for(int j = 0; j < 5; j++)
					for(int k = 0; k < 12; k++)		
					{
						player.worldObj.setBlock((int) player.posX + i, (int) player.posY - (j + 2), (int) player.posZ + (k + 2), Blocks.air);
						player.worldObj.setBlock((int) player.posX + i, (int) player.posY + (j + 2), (int) player.posZ + (k + 2), Blocks.sand);
					}
				}
				else if(WyHelper.get4Directions(player) == WyHelper.Direction.EAST)
				{
					for(int i = 0; i < 12; i++)
					for(int j = 0; j < 5; j++)
					for(int k = -3; k < 3; k++)		
					{
						player.worldObj.setBlock((int) player.posX + (i + 2), (int) player.posY - (j + 2), (int) player.posZ + k, Blocks.air);
						player.worldObj.setBlock((int) player.posX + (i + 2), (int) player.posY + (j + 2), (int) player.posZ + k, Blocks.sand);
					}
				}
				else if(WyHelper.get4Directions(player) == WyHelper.Direction.WEST)
				{
					for(int i = 0; i < 12; i++)
					for(int j = 0; j < 5; j++)
					for(int k = -3; k < 3; k++)		
					{
						player.worldObj.setBlock((int) player.posX - (i + 2), (int) player.posY - (j + 2), (int) player.posZ + k, Blocks.air);
						player.worldObj.setBlock((int) player.posX - (i + 2), (int) player.posY + (j + 2), (int) player.posZ + k, Blocks.sand);
					}
				}				
				super.use(player);
			}
		}
	}
	
}
