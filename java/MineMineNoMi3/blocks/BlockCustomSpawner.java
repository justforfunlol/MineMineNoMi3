package MineMineNoMi3.blocks;

import java.util.Random;

import MineMineNoMi3.blocks.tileentities.TileEntityCustomSpawner;
import MineMineNoMi3.packets.PacketWorld;
import WyPI.modules.WyNetworkHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCustomSpawner extends BlockContainer
{

	protected String entityToSpawn = "Pig";
	protected int spawnLimit = 5;
	
	public BlockCustomSpawner()
	{
		super(Material.AIR);
	} 

	public BlockCustomSpawner setSpawnerMob(String toSpawn) { entityToSpawn = toSpawn; return this; }
	public BlockCustomSpawner setSpawnerLimit(int limit) { spawnLimit = limit; return this; }
	
	public TileEntity createNewTileEntity(World world, int i) {return new TileEntityCustomSpawner(entityToSpawn, spawnLimit);}
	
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {return NULL_AABB;} 
	
	public boolean isOpaqueCube(IBlockState state) {return false;}
	
	public boolean isFullCube(IBlockState state) {return false;}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {return BlockRenderLayer.TRANSLUCENT;}
	
	public EnumBlockRenderType getRenderType(IBlockState state) {return EnumBlockRenderType.INVISIBLE;}

    public void randomDisplayTick(IBlockState stateIn, World world, BlockPos pos, Random rand)
    {
    	if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())) == Blocks.AIR.getDefaultState())
    		WyNetworkHelper.instance().sendToServer(new PacketWorld(pos.getX(), pos.getY(), pos.getZ(), Block.getIdFromBlock(Blocks.AIR)));
	}
}
