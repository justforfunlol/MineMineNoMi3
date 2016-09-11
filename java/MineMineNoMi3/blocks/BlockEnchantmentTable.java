package MineMineNoMi3.blocks;

import MineMineNoMi3.Main;
import MineMineNoMi3.lists.ListCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockEnchantmentTable extends Block 
{

    public BlockEnchantmentTable()
    {
    	super(Material.IRON);
        this.setLightOpacity(0);
        this.setCreativeTab(ListCreativeTabs.tabMisc); 
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }  
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
            return true;
        else
        {
            par5EntityPlayer.openGui(Main.getMineMineNoMi(), 0, par1World, par2, par3, par4);
            return true;
        }
    }
}
