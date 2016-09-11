package MineMineNoMi3;

import WyPI.vfx.ParticleTemplateForProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ParticleTemplateForProjectileWithLOD extends ParticleTemplateForProjectile
{
	private int lod;
	
	public ParticleTemplateForProjectileWithLOD(int LOD)
	{
		this.lod = LOD;
	}

	public void render(Entity entity, Object... particleTypes)
	{
		World w = entity.worldObj;

		for(int j = 0; j < particleTypes.length; j++)
			for(int i = 0; i < this.lod; i++)
				w.spawnParticle((EnumParticleTypes)particleTypes[j], entity.posX + (w.rand.nextDouble() - 0.5D), entity.posY + (w.rand.nextDouble() - 0.5D), entity.posZ + (w.rand.nextDouble() - 0.5D), 0, 0, 0, 0);		
	}
	
}
