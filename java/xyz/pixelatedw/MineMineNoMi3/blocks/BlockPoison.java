package xyz.pixelatedw.MineMineNoMi3.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;

public class BlockPoison extends Block
{
	protected static final AxisAlignedBB CARPET_AABB = AxisAlignedBB.getBoundingBox(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
	
	public BlockPoison()
	{
		super(Material.iron);
	}  

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) { return CARPET_AABB; }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {return CARPET_AABB;} 
	
	public boolean isOpaqueCube() {return false;}

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() { return 0; }

    public boolean renderAsNormalBlock() { return false; }
	
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
    	if(entity instanceof EntityLivingBase)
    	{
    		ExtendedEntityStats props = ExtendedEntityStats.get((EntityLivingBase) entity);
    		
    		if(!props.getUsedFruit().equals("dokudoku"))
    			((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 300, 1));
    		else
    			((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.regeneration.id, 50, 0));
    	}
    }
}
