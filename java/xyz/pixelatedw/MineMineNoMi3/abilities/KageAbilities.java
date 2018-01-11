package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.KageProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class KageAbilities 
{

	public static Ability[] abilitiesArray = new Ability[] {new BrickBat(), new Doppelman(), new BlackBox(), new Tsunotokage()};

	public static class BrickBat extends Ability
	{
		public BrickBat() 
		{
			super(ListAttributes.BRICKBAT); 
		}
		
		public void use(EntityPlayer player)
		{		
			this.projectile = new KageProjectiles.BrickBat(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class Doppelman extends Ability
	{
		public Doppelman() 
		{
			super(ListAttributes.DOPPELMAN); 
		}
		
		public void use(EntityPlayer player)
		{		
			WyHelper.sendMsgToPlayer(player, "NOT YET IMPLEMENTED");
			super.use(player);
		} 
	}
	
	public static class BlackBox extends Ability
	{
		public BlackBox() 
		{
			super(ListAttributes.BLACKBOX); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new KageProjectiles.BlackBox(player.worldObj, player, attr);
			super.use(player);
		} 
	}
	
	public static class Tsunotokage extends Ability
	{
		public Tsunotokage() 
		{
			super(ListAttributes.TSUNOTOKAGE); 
		}
		
		public void use(EntityPlayer player)
		{	
			this.projectile = new KageProjectiles.Tsunotokage(player.worldObj, player, attr);
			super.use(player);
		} 
	}
}
