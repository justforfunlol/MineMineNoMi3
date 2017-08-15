package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.GoroProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class GoroAbilities 
{

	public static AbilityItem[] abilitiesArray = new AbilityItem[] {};
	
	public static class Kari extends AbilityItem
	{
		public Kari() 
		{
			this.attr = ListAttributes.KARI; 
		}
	}
	
	public static class Sango extends AbilityItem
	{
		public Sango() 
		{
			this.attr = ListAttributes.SANGO; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new GoroProjectiles.Sango(world, player, attr);
		};	
	}
	
}
