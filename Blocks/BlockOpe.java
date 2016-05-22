package MineMineNoMi3.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
public class BlockOpe extends Block
{			
	public BlockOpe()
	{
		super(Material.IRON);
	} 

	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {return NULL_AABB;} 
	
	public boolean isOpaqueCube(IBlockState state) {return false;}

	public boolean isFullCube(IBlockState state) {return false;}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {return BlockRenderLayer.TRANSLUCENT;}
	
}
