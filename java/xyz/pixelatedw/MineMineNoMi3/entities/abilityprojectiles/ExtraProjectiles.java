package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.BaneProjectiles.SpringDeathKnock;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;

public class ExtraProjectiles 
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {NormalBullet.class, ListExtraAttributes.NORMALBULLET});
		abilitiesClassesArray.add(new Object[] {KairosekiBullet.class, ListExtraAttributes.KAIROSEKIBULLET});
	}
		
	public static class NormalBullet extends AbilityProjectile
	{
		public NormalBullet(World world)
		{super(world);}
		
		public NormalBullet(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public NormalBullet(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	public static class KairosekiBullet extends AbilityProjectile
	{
		public KairosekiBullet(World world)
		{super(world);}
		
		public KairosekiBullet(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public KairosekiBullet(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
}
