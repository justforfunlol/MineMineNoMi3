package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MaguProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

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
			if(!this.isOnCooldown)
			{
				for (int i = -10; i < 10; i++) 
				for (int j = -5; j < 5; j++) 
				for (int k = -10; k < 10; k++)
					if(!player.worldObj.isAirBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k) && player.worldObj.getBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k) != ListMisc.Ope
							&& player.worldObj.getBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k) != ListMisc.OpeMid && player.worldObj.getBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k) != Blocks.bedrock)
						player.worldObj.setBlock((int) player.posX + i, (int) player.posY + j, (int) player.posZ + k, Blocks.flowing_lava);	
				
				super.use(player);
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
