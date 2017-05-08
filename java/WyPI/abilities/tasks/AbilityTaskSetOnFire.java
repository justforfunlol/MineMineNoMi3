package WyPI.abilities.tasks;

import WyPI.abilities.AbilityProjectile;
import WyPI.abilities.AbilityTask;
import net.minecraft.util.math.RayTraceResult;

public class AbilityTaskSetOnFire extends AbilityTask
{

	private int ticks;
	
	public AbilityTaskSetOnFire(int i)
	{
		this.ticks = i;
	}
	
	public void onProjectileHit(AbilityProjectile abilityProjectile, RayTraceResult hit) 
	{
		if(hit.entityHit != null)
			hit.entityHit.setFire(this.ticks);
	}
	
}
