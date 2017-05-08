package MineMineNoMi3;

import MineMineNoMi3.lists.ListMisc;
import WyPI.modules.WyHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.util.math.BlockPos;

public class DevilFruitAbilitiesHelper
{ 
	public static boolean isEntityInRoom(EntityLivingBase entity)
	{	
		for(int i = -20; i < 20; i++)
		for(int j = -20; j < 20; j++)
		for(int k = -20; k < 20; k++)
		{
			if(entity.worldObj.getBlockState(new BlockPos(entity.posX + i, entity.posY + j, entity.posZ + k)).getBlock() == ListMisc.OpeMid)
				return true;
		}
		 
		return false;
	}
}
 