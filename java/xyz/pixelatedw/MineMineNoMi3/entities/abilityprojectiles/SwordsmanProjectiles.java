package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.RokushikiProjectiles.Rankyaku;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class SwordsmanProjectiles
{
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {SanbyakurokujuPoundHo.class, ListAttributes.SANBYAKUROKUJUPOUNDHO});
	}
	
	public static class SanbyakurokujuPoundHo extends AbilityProjectile
	{
		public SanbyakurokujuPoundHo(World world)
		{super(world);}
		
		public SanbyakurokujuPoundHo(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public SanbyakurokujuPoundHo(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}
}