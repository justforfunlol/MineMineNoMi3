package xyz.pixelatedw.MineMineNoMi3.lists;

import java.util.TimerTask;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;

public class ListParticleEffects 
{
	
	public static TimerTask createSphereFX(EntityPlayer player, String fxName, int radius, int density, int repeats)
	{
		return new Sphere(player, fxName, radius, density, repeats);
	}
	
}

class Sphere extends TimerTask
{
	
	private EntityPlayer player;
	private String fxName;
	private int radius, density, repeats;

	public Sphere(EntityPlayer player, String fxName, int radius, int density, int repeats)
	{
		this.player = player;
		this.fxName = fxName;
		this.radius = radius;
		this.density = density;
		this.repeats = repeats;
	}
	
	public void run()
	{
		double phi = 0;
		while(phi < repeats * Math.PI)
		{
			phi += Math.PI / density;
			
			for(double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / density)
			{
				double r = radius;
				double x = r * Math.cos(theta) * Math.sin(phi);
				double y = r * Math.cos(phi) + 1.5;
				double z = r * Math.sin(theta) * Math.sin(phi);
				
				try 
				{
					player.worldObj.spawnParticle(fxName, player.posX + x, player.posY - 1.5 + y, player.posZ + z, 0, 0, 0);
					Thread.sleep(1);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}	
			}
		}
	}
	
}