package MineMineNoMi3.blocks;

import java.util.Random;

import MineMineNoMi3.packets.PacketWorld;
import WyPI.modules.WyNetworkHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDarkness extends Block
{
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
	
	public BlockDarkness()
	{
		super(Material.IRON);
	} 

    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) { entityIn.setInWeb(); }
	
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) { return BOUNDING_BOX; }
	
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {return NULL_AABB;} 
	
    public void randomDisplayTick(IBlockState stateIn, World world, BlockPos pos, Random rand)
    {
    	world.spawnParticle(EnumParticleTypes.TOWN_AURA, pos.getX() + rand.nextDouble(), pos.getY(), pos.getZ() + rand.nextDouble(), 0, 4.0, 0);
	}
}
