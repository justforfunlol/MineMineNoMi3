package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.RokushikiProjectiles.Rankyaku;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.RokushikiProjectiles.Shigan;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class FishKarateProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {Uchimizu.class, ListAttributes.UCHIMIZU});
		abilitiesClassesArray.add(new Object[] {Yarinami.class, ListAttributes.YARINAMI});
		abilitiesClassesArray.add(new Object[] {Murasame.class, ListAttributes.MURASAME});
	}
	
	public static class Uchimizu extends AbilityProjectile
	{
		public Uchimizu(World world)
		{super(world);}
		
		public Uchimizu(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Uchimizu(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
	
	public static class Yarinami extends AbilityProjectile
	{
		public Yarinami(World world)
		{super(world);}
		
		public Yarinami(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Yarinami(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
	
	public static class Murasame extends AbilityProjectile
	{
		public Murasame(World world)
		{super(world);}
		
		public Murasame(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Murasame(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
}
