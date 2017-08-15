package xyz.pixelatedw.MineMineNoMi3.api.abilities.tasks;

import net.minecraft.util.MovingObjectPosition;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityTask;

public class AbilityTaskSetOnFire extends AbilityTask
{

	private int ticks;
	
	public AbilityTaskSetOnFire(int i)
	{
		this.ticks = i;
	}
	
	public void onProjectileHit(AbilityProjectile abilityProjectile, MovingObjectPosition hit) 
	{
		if(hit.entityHit != null)
			hit.entityHit.setFire(this.ticks);
	}
	
}
