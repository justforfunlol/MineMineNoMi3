package WyPI.vfx;

import WyPI.modules.WyDebug;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ParticleTemplateForProjectile implements ParticleTemplate
{

	public void render(Entity entity, Object... particleTypes)
	{
		World w = entity.worldObj;

		for(int j = 0; j < particleTypes.length; j++)
		{
			for(int i = 0; i < 5; i++)
			{
				if(particleTypes[j] instanceof EnumParticleTypes)
					w.spawnParticle((EnumParticleTypes)particleTypes[j], entity.posX + (w.rand.nextDouble() - 0.5D), entity.posY + (w.rand.nextDouble() - 0.5D), entity.posZ + (w.rand.nextDouble() - 0.5D), 0, 0, 0, 0);		
				else
					WyDebug.instance().error("[" + this.getClass() + "] Incompatible object type ! : " + particleTypes[j].getClass());
			}
		}
	}
	
}
