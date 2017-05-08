package MineMineNoMi3.blocks;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDial extends Block
{
	//private static final PropertyEnum DIAL_TYPE = PropertyEnum.create("dialtype", EnumDialType.class);
    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
	 
	public BlockDial() 
	{
		super(Material.IRON);
		//this.setDefaultState(this.blockState.getBaseState().withProperty(getDialProperty(), EnumDialType.FIRE));
	}

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) { return BOUNDING_BOX; }
	
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) { return NULL_AABB; }
    
	public boolean isOpaqueCube(IBlockState state) {return false;}

	public boolean isFullCube(IBlockState state) {return false;}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {return BlockRenderLayer.TRANSLUCENT;}
	
	//public int getMetaFromState(IBlockState state) { return ((EnumDialType)state.getValue(getDialProperty())).ordinal(); }
	
	//protected BlockStateContainer createBlockState() { return new BlockStateContainer(this, new IProperty[] {getDialProperty()}); } 
	
	//public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) { return false; }	
	
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
    {
    	if(!world.isRemote)
    	{
    		/*if(world.getBlockState(pos).getValue(getDialProperty()) == EnumDialType.FIRE)
    			entity.setFire(100);
    		
    		if(world.getBlockState(pos).getValue(getDialProperty()) == EnumDialType.IMPACT)
    		{
        		world.setBlockState(pos, Blocks.AIR.getDefaultState());
    			world.newExplosion(entity, pos.getX(), pos.getY(), pos.getZ(), 2, false, true);
    		}
    		
    		if(world.getBlockState(pos).getValue(getDialProperty()) == EnumDialType.BREATH)
    			entity.motionY += 3;

    		if(world.getBlockState(pos).getValue(getDialProperty()) == EnumDialType.FLASH)
    		{
    			IEntityCapability props = entity.getCapability(Values.ENTITY_CAPABILITIES, null);
    			
    			props.setBlind(50);
    		}
    		
    		world.setBlockState(pos, Blocks.AIR.getDefaultState());*/
    	}
    	if(world.isRemote)
    		world.newExplosion(entity, pos.getX(), pos.getY(), pos.getZ(), 1, false, false);
    }
    
    /*public static PropertyEnum getDialProperty()
	{
		return DIAL_TYPE;
	}*/
}
