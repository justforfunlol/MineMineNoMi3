package WyPI.abilities.tasks;

import WyPI.abilities.AbilityProjectile;
import WyPI.abilities.AbilityTask;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.RayTraceResult;

public class AbilityTaskPlaceBlock extends AbilityTask
{

	private Block block;
	
	public AbilityTaskPlaceBlock(Block block)
	{
		this.block = block;
	}
	
	public void onProjectileHit(AbilityProjectile abilityProjectile, RayTraceResult hit)
	{
		if(block != null)
			abilityProjectile.worldObj.setBlockState(abilityProjectile.getPosition(), this.block.getDefaultState());
	}
	
}
