package MineMineNoMi3.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import MineMineNoMi3.Main;

public class BlockDenDenMushi extends BlockContainer
{
	public BlockDenDenMushi() 
	{
		super(Material.ROCK);
	}
	
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack stack)
	{
		int rotation = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 2.5D) & 0x3;		
	    //par1World.setBlock(par2, par3, par4, ListMisc.DenDenMushi, rotation, 0);
	}
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {        
    	return null;
    } 
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	FMLNetworkHandler.openGui(par5EntityPlayer, Main.getMineMineNoMi(), 6, par1World, par2, par3, par4);
    	return true;
    }

    public boolean renderAsNormalBlock() {
            return false;
    }

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return null;
	}
}
