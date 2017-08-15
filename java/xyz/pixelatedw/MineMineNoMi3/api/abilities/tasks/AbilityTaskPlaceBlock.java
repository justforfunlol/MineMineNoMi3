package xyz.pixelatedw.MineMineNoMi3.api.abilities.tasks;

import net.minecraft.block.Block;
import net.minecraft.util.MovingObjectPosition;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityTask;

public class AbilityTaskPlaceBlock extends AbilityTask
{

	private Block block;
	
	public AbilityTaskPlaceBlock(Block block)
	{
		this.block = block;
	}
	
	public void onProjectileHit(AbilityProjectile abilityProjectile, MovingObjectPosition hit)
	{
		if(block != null)
			abilityProjectile.worldObj.setBlock((int)abilityProjectile.posX, (int)abilityProjectile.posY, (int)abilityProjectile.posZ, this.block);
	}
	
}
