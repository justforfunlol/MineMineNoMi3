package xyz.pixelatedw.MineMineNoMi3.entities.particles;

import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.world.World;

public class EntityParticleFXTest extends EntityAuraFX
{
    public EntityParticleFXTest(World parWorld, double parX, double parY, double parZ, double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
       
        this.setParticleTextureIndex(163);
        this.particleScale = 2.0F;
        this.setRBGColorF(0xFF, 0xFF, 0x00);
    }
}