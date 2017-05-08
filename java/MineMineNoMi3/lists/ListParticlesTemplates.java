package MineMineNoMi3.lists;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;

public class ListParticlesTemplates 
{
	
	public static void spawnTemplateVulcan(EntityThrowable entity)
	{
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.2D, entity.posY, entity.posZ, -0.05D, 0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.2D, entity.posY, entity.posZ, -0.05D, 0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX, entity.posY + 0.3D, entity.posZ, -0.05D, 0.03D, 0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX, entity.posY - 0.4D, entity.posZ, 0.05D, 0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.1D, entity.posY, entity.posZ, 0.05D, 0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.1D, entity.posY, entity.posZ, 0.05D, 0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, -0.05D, -0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.05D, -0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, -0.05D, -0.03D, 0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, -0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.05D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.05D, 0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.05D, 0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.05D, 0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, -0.02D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.02D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.02D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.02D, 0.05D, 0.02D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.02D, 0.05D, -0.02D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.02D, 0.05D, -0.02D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, -0.05D, -0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.05D, -0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, -0.05D, -0.03D, 0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, -0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.05D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.05D, 0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.05D, 0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.05D, 0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, -0.02D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.02D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.02D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.02D, 0.05D, 0.02D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.02D, 0.05D, -0.02D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.LAVA, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.02D, 0.05D, -0.02D);
	}
	
	public static void spawnTemplateAvalanche(EntityThrowable entity)
	{
		entity.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, entity.posX + 0.2D, entity.posY, entity.posZ, -0.05D, 0.03D, 0.05D);
		entity.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, entity.posX - 0.2D, entity.posY, entity.posZ, -0.05D, 0.03D, 0.05D);
		entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX, entity.posY + 0.3D, entity.posZ, -0.05D, 0.03D, 0.05D);
		
		entity.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, entity.posX - 0.2D, entity.posY, entity.posZ, 0.05D, -0.03D, 0.05D);
		entity.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, entity.posX - 0.2D, entity.posY + 0.2D, entity.posZ, -0.03D, 0.03D, 0.05D);
		entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX, entity.posY - 0.3D, entity.posZ, 0.07D, -0.05D, -0.03D);
	    
		entity.worldObj.spawnParticle(EnumParticleTypes.WATER_DROP, entity.posX, entity.posY - 0.4D, entity.posZ, 0.05D, 0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.WATER_DROP, entity.posX + 0.1D, entity.posY, entity.posZ, 0.05D, 0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.WATER_DROP, entity.posX - 0.1D, entity.posY, entity.posZ, 0.05D, 0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.05D, 0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX - 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.05D, -0.03D, 0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.DRIP_WATER, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, -0.05D, -0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.05D, -0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.DRIP_WATER, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, -0.05D, -0.03D, 0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, -0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.05D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.05D, 0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.05D, 0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.05D, 0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, -0.02D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.02D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.02D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.02D, 0.05D, 0.02D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.02D, 0.05D, -0.02D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.02D, 0.05D, -0.02D);
	}
	
	public static void spawnTemplateSmoke(EntityThrowable entity)
	{
	    entity.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, -0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.05D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.05D, 0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.05D, 0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.05D, 0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, -0.02D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.02D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.02D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.02D, 0.05D, 0.02D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.02D, 0.05D, -0.02D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.02D, 0.05D, -0.02D);
	}
	
	public static void spawnTemplateGlint(EntityThrowable entity)
	{
	    entity.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, entity.posX + 0.2D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, entity.posX - 0.2D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, entity.posX, entity.posY + 0.3D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, entity.posX, entity.posY - 0.4D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, entity.posX + 0.1D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, entity.posX - 0.1D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	}
	
	public static void spawnTemplateGas(EntityThrowable entity)
	{
	    entity.worldObj.spawnParticle(EnumParticleTypes.PORTAL, entity.posX + 0.2D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, entity.posX - 0.2D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, entity.posX, entity.posY + 0.3D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, entity.posX, entity.posY - 0.4D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.PORTAL, entity.posX + 0.1D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, entity.posX - 0.1D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.PORTAL, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.PORTAL, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.PORTAL, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	}
	
	public static void spawnTemplateFire(EntityThrowable entity)
	{
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.2D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.2D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX, entity.posY + 0.3D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX, entity.posY - 0.4D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.1D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.1D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, -0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.05D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.05D, 0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.05D, 0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.05D, 0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, -0.02D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.02D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.02D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.02D, 0.05D, 0.02D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.02D, 0.05D, -0.02D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.02D, 0.05D, -0.02D);
	}

	public static void spawnTemplateGreenFire(EntityThrowable entity)
	{
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX + 0.2D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX - 0.2D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX, entity.posY + 0.3D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX, entity.posY - 0.4D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX + 0.1D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX - 0.1D, entity.posY, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.0D, 0.0D, 0.0D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, -0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.05D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.05D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.05D, 0.03D, 0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.05D, 0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.05D, 0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX + 0.2D, entity.posY - 0.3D, entity.posZ, -0.02D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, 0.02D, -0.03D, -0.05D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX + 0.4D, entity.posY - 0.2D, entity.posZ, -0.02D, -0.03D, -0.05D);
	    
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX - 0.2D, entity.posY + 0.1D, entity.posZ, 0.02D, 0.05D, 0.02D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX - 0.4D, entity.posY + 0.2D, entity.posZ, -0.02D, 0.05D, -0.02D);
	    entity.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, entity.posX - 0.1D, entity.posY - 0.2D, entity.posZ, 0.02D, 0.05D, -0.02D);
	}
}
