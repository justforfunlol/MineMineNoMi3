package WyPI.Particles;

import net.minecraft.entity.Entity;

public interface ParticleTemplate
{
	
	public void render(Entity entity, Object... particleTypes); //throws WrongParticleTypeException;

}
