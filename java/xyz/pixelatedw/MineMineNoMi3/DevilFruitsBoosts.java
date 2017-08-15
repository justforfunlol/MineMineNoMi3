package xyz.pixelatedw.MineMineNoMi3;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class DevilFruitsBoosts
{ 

	public static boolean isEntityInRoom(EntityLivingBase entity)
	{	
		for(int i = -20; i < 20; i++)
		for(int j = -20; j < 20; j++)
		for(int k = -20; k < 20; k++)
		{
			//if(entity.worldObj.getBlock((int)entity.posX + i, (int)entity.posY + j, (int)entity.posZ + k) == ListMisc.OpeMid)
			//	return true;
		}
		
		return false;
	}
	
	public static int getExtraDamageFromClay(EntityLivingBase entity)
	{	
		int extraPower = 0;
		
		for(int i = -10; i < 10; i++)
		for(int j = -10; j < 10; j++)
		for(int k = -10; k < 10; k++)
		{
			if(entity.worldObj.getBlock((int)entity.posX + i, (int)entity.posY + j, (int)entity.posZ + k) == Blocks.clay)
			{
				extraPower++;
				entity.worldObj.setBlock((int)entity.posX + i, (int)entity.posY + j, (int)entity.posZ + k, Blocks.air);
			}
		}
		
		return extraPower;
	}
	
	public static int getRegenFromPoision(EntityLivingBase entity)
	{
		int regen = 0;
		regen = entity.getActivePotionEffect(Potion.poison).getAmplifier() / 5;
		return regen;
	}
	
}
