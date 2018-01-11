package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.HieProjectiles.IceBall;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.HieProjectiles.IceBlockPartisan;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class MokuProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {WhiteSnake.class, ListAttributes.WHITESNAKE});
		abilitiesClassesArray.add(new Object[] {WhiteOut.class, ListAttributes.WHITEOUT});
	}
	
	public static class WhiteSnake extends AbilityProjectile
	{
		public WhiteSnake(World world)
		{super(world);}
		
		public WhiteSnake(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public WhiteSnake(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	
	
	public static class WhiteOut extends AbilityProjectile
	{
		public WhiteOut(World world)
		{super(world);}
		
		public WhiteOut(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public WhiteOut(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
}
