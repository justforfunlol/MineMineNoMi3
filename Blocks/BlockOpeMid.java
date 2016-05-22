package MineMineNoMi3.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.IPlayerCapability;
import WyPI.WyPI;

public class BlockOpeMid extends BlockContainer
{ 
		
		public BlockOpeMid()
        {
			super(Material.IRON);
        } 

		public TileEntity createNewTileEntity(World world, int i) {return new TileEntityOpe();}
		
		public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {return NULL_AABB;} 
		
		public boolean isOpaqueCube(IBlockState state) {return false;}

		public boolean isFullCube(IBlockState state) {return false;}
		
		@SideOnly(Side.CLIENT)
		public BlockRenderLayer getBlockLayer() {return BlockRenderLayer.TRANSLUCENT;}
		
	    public EnumBlockRenderType getRenderType(IBlockState state) {return EnumBlockRenderType.INVISIBLE;}
	    
}

