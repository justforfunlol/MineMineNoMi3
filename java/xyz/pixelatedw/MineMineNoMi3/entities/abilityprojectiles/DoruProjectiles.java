package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class DoruProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {DoruDoruArtsMori.class, ListAttributes.DORUDORUARTSMORI});
	}
	
	public static class DoruDoruArtsMori extends AbilityProjectile
	{
		public DoruDoruArtsMori(World world)
		{super(world);}
		
		public DoruDoruArtsMori(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public DoruDoruArtsMori(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
	}
	
	
}
