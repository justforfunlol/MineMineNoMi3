package xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.SunaProjectiles.Barjan;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;

public class MaguProjectiles 
{

	public static ArrayList<Object[]> abilitiesClassesArray = new ArrayList();
	
	static
	{
		abilitiesClassesArray.add(new Object[] {Meigo.class, ListAttributes.MEIGO});
		abilitiesClassesArray.add(new Object[] {DaiFunka.class, ListAttributes.DAIFUNKA});
	}
	
	public static class Meigo extends AbilityProjectile
	{
		public Meigo(World world)
		{super(world);}
		
		public Meigo(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public Meigo(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null)
				hit.entityHit.setFire(200);
		};
	}
	
	public static class DaiFunka extends AbilityProjectile
	{
		public DaiFunka(World world)
		{super(world);}
		
		public DaiFunka(World world, double x, double y, double z)
		{super(world, x, y, z);}
		
		public DaiFunka(World world, EntityLivingBase player, AbilityAttribute attr) 
		{		
			super(world, player, attr);		
		}
		
		public void tasksImapct(MovingObjectPosition hit)
		{
			if(hit.entityHit != null)
				hit.entityHit.setFire(100);
			
			this.worldObj.setBlock(hit.blockX, hit.blockY, hit.blockZ, Blocks.flowing_lava);
		};
	}	
	
}
