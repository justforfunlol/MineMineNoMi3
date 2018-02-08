package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class BariProjectiles 
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {BarrierCrash.class, ListAttributes.BARRIERCRASH});
	}
	
	public static class BarrierCrash extends AbilityProjectile
	{
		public BarrierCrash(World world)
		{super(world);}
		
		public BarrierCrash(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public BarrierCrash(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
}
