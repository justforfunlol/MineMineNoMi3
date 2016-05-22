package MineMineNoMi3.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDial extends Block
{
	public static final PropertyEnum DIAL_TYPE = PropertyEnum.create("dialtype", DialType.class);
	
	public BlockDial() 
	{ 
		super(Material.IRON);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIAL_TYPE, DialType.FIRE));
	} 

	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {return NULL_AABB;} 

	public boolean isOpaqueCube(IBlockState state) {return false;}

	public boolean isFullCube(IBlockState state) {return false;}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {return BlockRenderLayer.TRANSLUCENT;}
	
	public int getMetaFromState(IBlockState state)
	{
		return ((DialType)state.getValue(DIAL_TYPE)).ordinal();
	}
	
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {DIAL_TYPE});
	}
	
    public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entityIn)
    {
    	if(!world.isRemote)
    		System.out.println(world.getBlockState(pos).getValue(DIAL_TYPE));
    }
    
    public static enum DialType implements IStringSerializable
    {
    	FIRE, IMPACT, FLASH, BREATH;
    	
    	private DialType(){}
    	
		public String getName() 
		{
			return name().toLowerCase();
		}
		
		public String toString()
		{
			return getName();
		}
    }
}
