package MineMineNoMi3.blocks;

import java.util.Random;

import MineMineNoMi3.packets.PacketWorld;
import WyPI.modules.WyNetworkHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBarrier extends Block
{	
	private int ticks = 15;
	
	public BlockBarrier()
	{
		super(Material.IRON);
	} 

	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {return NULL_AABB;} 
	
	public boolean isOpaqueCube(IBlockState state) {return false;}

	public boolean isFullCube(IBlockState state) {return false;}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {return BlockRenderLayer.TRANSLUCENT;}
	
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
    	if(ticks > 0)
    		ticks--;
    	else
    		WyNetworkHelper.instance().sendToServer(new PacketWorld(pos.getX(), pos.getY(), pos.getZ(), Block.getIdFromBlock(Blocks.AIR)));
	}
}
