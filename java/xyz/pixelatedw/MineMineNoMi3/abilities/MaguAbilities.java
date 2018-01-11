package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MaguProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class MaguAbilities 
{

	public static Ability[] abilitiesArray = new Ability[] {new BakuretsuKazan(), new RyuseiKazan(), new Meigo(), new DaiFunka()};

	public static class BakuretsuKazan extends Ability
	{
		public BakuretsuKazan() 
		{
			super(ListAttributes.BAKURETSUKAZAN); 
		}
		
		public void use(EntityPlayer player)
		{		
			if(!player.worldObj.isRemote)
			{
				if(!isOnCooldown)
				{
					if(!player.worldObj.isRemote)
					{
						for(int i = -7; i < 7; i++)
						for(int j = -5; j < 0; j++)
						for(int k = -7; k < 7; k++)
							player.worldObj.setBlock((int) (int) player.posX + i, (int) (int) player.posY + j, (int) (int) player.posZ + k, Blocks.flowing_lava);
					}
					
					isOnCooldown = true;
					startCooldown();
				}
			}
		} 
	}
	
	public static class RyuseiKazan extends Ability
	{
		public RyuseiKazan() 
		{
			super(ListAttributes.RYUSEIKAZAN); 
		}
		
		public void use(EntityPlayer player)
		{		
			this.projectile = new MaguProjectiles.DaiFunka(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class Meigo extends Ability
	{
		public Meigo() 
		{
			super(ListAttributes.MEIGO); 
		}
		
		public void use(EntityPlayer player)
		{		
			this.projectile = new MaguProjectiles.Meigo(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class DaiFunka extends Ability
	{
		public DaiFunka() 
		{
			super(ListAttributes.DAIFUNKA); 
		}
		
		public void use(EntityPlayer player)
		{		
			this.projectile = new MaguProjectiles.DaiFunka(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
}
