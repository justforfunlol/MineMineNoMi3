package MineMineNoMi3.blocks.tileentities;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.lists.ListMisc;
import WyPI.modules.WyHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityOpe extends TileEntity implements ITickable
{
	
	public TileEntityOpe()
	{
		
	}
	
	public void update() 
	{
		for(EntityLivingBase elb : WyHelper.instance().getEntitiesNear(this, new int[] {28, 28, 28}))
		{
			if(elb instanceof EntityPlayer)
			{ 
				EntityPlayer user = (EntityPlayer) elb;
				IEntityCapability props = user.getCapability(Values.ENTITY_CAPABILITIES, null);
				if(props.getUsedFruit().equals("opeope"))
				{
					if(user.getDistanceSqToCenter(new BlockPos(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ())) > 810)
					{
						final World world = this.worldObj;
						if(!world.isRemote)
						{
							for(int i = -22; i < 22; i++)
							for(int k = -21; k < 21; k++)
							for(int j = -22; j < 22; j++)
								if(world.getBlockState(new BlockPos((int) this.getPos().getX() + i, (int) this.getPos().getY() + k, (int) this.getPos().getZ() + j)) == ListMisc.Ope.getDefaultState())
									world.setBlockState(new BlockPos((int) this.getPos().getX() + i, (int) this.getPos().getY() + k, (int) this.getPos().getZ() + j), Blocks.AIR.getDefaultState());
							world.setBlockState(new BlockPos((int) this.getPos().getX(), (int) this.getPos().getY(), (int) this.getPos().getZ()), Blocks.AIR.getDefaultState());
						}
					}		
				}
			}
		}
	}
	
}

