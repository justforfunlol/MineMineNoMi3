package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.abilities.BomuAbilities.KickBomb;
import xyz.pixelatedw.MineMineNoMi3.abilities.BomuAbilities.NoseFancyCannon;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GuraProjectiles.Kaishin;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GuraProjectiles.ShimaYurashi;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class KageProjectiles 
{
	
	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {Tsunotokage.class, ListAttributes.TSUNOTOKAGE});
		abilitiesClassesArray.add(new Object[] {BlackBox.class, ListAttributes.BLACKBOX});
		abilitiesClassesArray.add(new Object[] {BrickBat.class, ListAttributes.BRICKBAT});
	}
	
	public static class BrickBat extends AbilityProjectile
	{
		public BrickBat(World world)
		{super(world);}
		
		public BrickBat(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public BrickBat(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
	}	

	public static class BlackBox extends AbilityProjectile
	{
		public BlackBox(World world)
		{super(world);}
		
		public BlackBox(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public BlackBox(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null)
			{
				WyHelper.createCube(hit.entityHit, new int[] {4, 3, 4}, ListMisc.Darkness);
			}
		};
	}	
	
	public static class Tsunotokage extends AbilityProjectile
	{
		public Tsunotokage(World world)
		{super(world);}
		
		public Tsunotokage(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Tsunotokage(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}

	}
}
