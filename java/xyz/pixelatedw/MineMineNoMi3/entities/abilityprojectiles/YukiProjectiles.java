package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GasuProjectiles.GasRobe;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GasuProjectiles.Gastille;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class YukiProjectiles 
{
	
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {YukiRabi.class, ListAttributes.YUKIRABI});
	}
	
	public static class YukiRabi extends AbilityProjectile
	{
		public YukiRabi(World world)
		{super(world);}
		
		public YukiRabi(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public YukiRabi(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}	
	}
	

}
