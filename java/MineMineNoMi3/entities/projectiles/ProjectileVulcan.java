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

public class ProjectileVulcan extends AbilityProjectile
{
	
	public ProjectileVulcan(World world)
	{
		super(world);
	}
	
	public ProjectileVulcan(World world, EntityPlayer player)
	{
		super(world, player);
	}
	
	public ProjectileVulcan(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	public ProjectileVulcan(World world, EntityLivingBase player, AbilityAttribute attr)
	{
		super(world, player, attr);
	}

	public void onEntityUpdate()
	{	
		ListParticlesTemplates.spawnTemplateVulcan(this);;
	}
	
}