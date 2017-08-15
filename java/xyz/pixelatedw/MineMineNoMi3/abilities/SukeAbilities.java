package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.SukeProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class SukeAbilities 
{

	public static AbilityItem[] abilitiesArray = new AbilityItem[] {new Skatting(), new ShisaNoTe(), null, null};

	public static class Skatting extends AbilityItem
	{
		public Skatting() 
		{
			this.attr = ListAttributes.SKATTING; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			if(player.getActivePotionEffect(Potion.invisibility) != null)
				player.removePotionEffect(Potion.invisibility.id);
			else
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, Integer.MAX_VALUE, Integer.MAX_VALUE, false));
		}
		
		public void tasksHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
		{
			if(target.getActivePotionEffect(Potion.invisibility) != null)
				target.removePotionEffect(Potion.invisibility.id);
			else
				target.addPotionEffect(new PotionEffect(Potion.invisibility.id, Integer.MAX_VALUE, Integer.MAX_VALUE, false));
			
			itemStack.getTagCompound().setInteger("ticks", this.attr.getItemCooldown());
			itemStack.getTagCompound().setBoolean("use", true);
		}
	}
	
	public static class ShisaNoTe extends AbilityItem
	{
		public ShisaNoTe() 
		{
			this.attr = ListAttributes.SHISHANOTE; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new SukeProjectiles.ShishaNoTe(world, player, attr);
		};	
	}
	
}
