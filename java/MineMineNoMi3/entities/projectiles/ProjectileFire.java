package MineMineNoMi3.entities.projectiles;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import MineMineNoMi3.lists.ListParticlesTemplates;
import WyPI.WyPI;
import WyPI.abilities.AbilityAttribute;
import WyPI.abilities.AbilityItem;
import WyPI.abilities.AbilityProjectile;
import WyPI.abilities.AbilityTask;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ProjectileFire extends AbilityProjectile
{
	
	public ProjectileFire(World world)
	{
		super(world);
	}
	
	public ProjectileFire(World world, EntityPlayer player)
	{
		super(world, player);
	}
	
	public ProjectileFire(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	public ProjectileFire(World world, EntityLivingBase player, AbilityAttribute attr)
	{
		super(world, player, attr);
	}

	public void onEntityUpdate()
	{	
		ListParticlesTemplates.spawnTemplateFire(this);
	}
	
}