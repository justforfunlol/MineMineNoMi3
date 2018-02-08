package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.HieProjectiles.IceBall;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.HieProjectiles.IceBlockPartisan;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListExtraAttributes;

public class GoroProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {ElThorThunder.class, ListExtraAttributes.ELTHORTHUNDER});
		abilitiesClassesArray.add(new Object[] {Sango.class, ListAttributes.SANGO});
		abilitiesClassesArray.add(new Object[] {Raigo.class, ListAttributes.RAIGO});
		abilitiesClassesArray.add(new Object[] {VoltVari.class, ListAttributes.VOLTVARI});
	}
	
	public static class ElThorThunder extends AbilityProjectile
	{
		public ElThorThunder(World world)
		{super(world);}
		
		public ElThorThunder(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public ElThorThunder(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	public static class Sango extends AbilityProjectile
	{
		public Sango(World world)
		{super(world);}
		
		public Sango(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Sango(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	public static class Raigo extends AbilityProjectile
	{
		public Raigo(World world)
		{super(world);}
		
		public Raigo(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Raigo(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
	
	public static class VoltVari extends AbilityProjectile
	{
		public VoltVari(World world)
		{super(world);}
		
		public VoltVari(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public VoltVari(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
	
}
