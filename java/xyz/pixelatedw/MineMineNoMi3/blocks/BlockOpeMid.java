package xyz.pixelatedw.MineMineNoMi3.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityOpe;

public class BlockOpeMid extends BlockContainer
{
	public BlockOpeMid()
	{
		super(Material.iron);
	} 

	public TileEntity createNewTileEntity(World world, int i) {return new TileEntityOpe();}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {return WyHelper.NULL_AABB;} 
	
	public boolean isOpaqueCube() {return false;}

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() { return 0; }

    public boolean renderAsNormalBlock() { return false; }

	
}

