package WyPI.modules;

import WyPI.mobs.EntityPart;
import WyPI.mobs.IMultiPartMob;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class WyMobHelper
{
	private static WyMobHelper instance;
	public static WyMobHelper instance() 
	{ 
		if(instance == null) instance = new WyMobHelper();
		return instance;
	}

	public void spawnEntityWithParts(World worldObj, EntityMob parentObj, BlockPos pos)
	{
		if(parentObj instanceof IMultiPartMob)
		{
			worldObj.spawnEntityInWorld(parentObj);
            parentObj.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), MathHelper.wrapDegrees(worldObj.rand.nextFloat() * 360.0F), 0.0F);
            parentObj.rotationYawHead = parentObj.rotationYaw;
            parentObj.renderYawOffset = parentObj.rotationYaw;
			worldObj.spawnEntityInWorld(parentObj); 
			for(EntityPart part : ((IMultiPartMob) parentObj).getEntityParts())
			{
				part.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), MathHelper.wrapDegrees(worldObj.rand.nextFloat() * 360.0F), 0.0F);
				part.rotationYawHead = parentObj.rotationYaw;
				part.renderYawOffset = parentObj.rotationYaw;
				worldObj.spawnEntityInWorld(part); 
			}
		}
		else
			WyDebug.instance().warn(parentObj + " is not an multi part mob !");
	}
}
