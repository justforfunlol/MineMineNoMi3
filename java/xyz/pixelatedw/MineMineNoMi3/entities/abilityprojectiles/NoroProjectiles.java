package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.HieProjectiles.IceBall;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.HieProjectiles.IceBlockPartisan;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class NoroProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {NoroNoroBeam.class, ListAttributes.NORONOROBEAM});
	}
	
	public static class NoroNoroBeam extends AbilityProjectile
	{
		public NoroNoroBeam(World world)
		{super(world);}
		
		public NoroNoroBeam(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public NoroNoroBeam(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	
}
