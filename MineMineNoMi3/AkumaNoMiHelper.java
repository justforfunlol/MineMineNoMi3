package MineMineNoMi3;

import java.util.ArrayList;
import java.util.List;

import MineMineNoMi3.Lists.ListMisc;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class AkumaNoMiHelper
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
	
	public static int getExtraDamageFromClay(EntityLivingBase entity)
	{	
		int extraPower = 0;
		
		for(int i = -10; i < 10; i++)
		for(int j = -10; j < 10; j++)
		for(int k = -10; k < 10; k++)
		{
			if(entity.worldObj.getBlockState(new BlockPos(entity.posX + i, entity.posY + j, entity.posZ + k)).getBlock() == Blocks.CLAY)
			{
				extraPower++;
				entity.worldObj.setBlockState(new BlockPos(entity.posX + i, entity.posY + j, entity.posZ + k), Blocks.AIR.getDefaultState());
			}
		}
		
		return extraPower;
	}
	
}
