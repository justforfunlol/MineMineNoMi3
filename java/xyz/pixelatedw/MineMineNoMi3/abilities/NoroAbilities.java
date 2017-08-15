package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.abilities.WeaponsAbilities.SharpWeapon;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.NoroProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class NoroAbilities 
{

	public static AbilityItem[] abilitiesArray = new AbilityItem[] {new NoroNoroBeam(), new NoroNoroBeamSword(), null, null};

	public static class NoroNoroBeamSword extends SharpWeapon
	{
		public NoroNoroBeamSword() 
		{
			super(2, false);
			this.attr = ListAttributes.NORONOROBEAMSWORD; 
		}
		
		public void tasksHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase player)
		{
			if(target != null)
				target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 5));
		}
	}
	
	public static class NoroNoroBeam extends AbilityItem
	{
		public NoroNoroBeam() 
		{
			this.attr = ListAttributes.NORONOROBEAM; 
		}
		
		public void tasksUse(ItemStack itemStack, World world, EntityPlayer player)
		{
			this.projectile = new NoroProjectiles.NoroNoroBeam(world, player, attr);
		};	
	}
	
}
