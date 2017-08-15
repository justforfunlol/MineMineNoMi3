package xyz.pixelatedw.MineMineNoMi3.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;


public class BlockDarkness extends Block
{
	private static final AxisAlignedBB BOUNDING_BOX = AxisAlignedBB.getBoundingBox(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
	
	public BlockDarkness()
	{
		super(Material.iron);
	} 

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) { entity.setInWeb(); }
	
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) { return BOUNDING_BOX; }
		
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {return WyHelper.NULL_AABB;} 
	
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
    	world.spawnParticle(EnumParticleTypes.TOWN_AURA.getParticleName(), x + rand.nextDouble(), y, z + rand.nextDouble(), 0, 4.0, 0);
	}
}
