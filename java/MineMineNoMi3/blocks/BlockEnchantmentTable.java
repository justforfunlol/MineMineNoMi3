package MineMineNoMi3.blocks;

import javax.annotation.Nullable;

import MineMineNoMi3.Main;
import MineMineNoMi3.lists.ListCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEnchantmentTable extends Block 
{

    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
	
    public BlockEnchantmentTable()
    {
    	super(Material.IRON);
        this.setLightOpacity(0);
        this.setCreativeTab(ListCreativeTabs.tabMisc); 
    }
      
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) { return AABB; }
    public boolean isFullCube(IBlockState state) { return false; }  
    public boolean isOpaqueCube(IBlockState state) { return false; }
    public EnumBlockRenderType getRenderType(IBlockState state) { return EnumBlockRenderType.MODEL; }
   
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    { 
        if (world.isRemote)
            return true;
        else
        {
            player.openGui(Main.getMineMineNoMi(), 0, world, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
    }
}
