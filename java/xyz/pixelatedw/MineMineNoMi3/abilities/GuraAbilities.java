package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GuraProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class GuraAbilities 
{

	public static Ability[] abilitiesArray = new Ability[] {new Kaishin(), new Kabutowari(), new ShimaYurashi()};

	public static class Kaishin extends Ability
	{
		public Kaishin() 
		{
			super(ListAttributes.KAISHIN); 
		}
		
		public void use(EntityPlayer player)
		{			
			this.projectile = new GuraProjectiles.Kaishin(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class Kabutowari extends Ability
	{
		public Kabutowari() 
		{
			super(ListAttributes.KABUTOWARI); 
		}
		
		public void use(EntityPlayer player)
		{			
			super.use(player);
		} 
	}
	
	public static class ShimaYurashi extends Ability
	{
		public ShimaYurashi() 
		{
			super(ListAttributes.SHIMAYURASHI); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new GuraProjectiles.ShimaYurashi(player.worldObj, player, attr);
			super.use(player);
		} 
	}
}
