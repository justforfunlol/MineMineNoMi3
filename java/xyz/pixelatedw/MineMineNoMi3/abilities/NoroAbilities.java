package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.NoroProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class NoroAbilities
{

	public static Ability[] abilitiesArray = new Ability[] {new NoroNoroBeam()};
	
	public static class NoroNoroBeam extends Ability
	{
		public NoroNoroBeam() 
		{
			super(ListAttributes.NORONOROBEAM); 
		}
		
		public void use(EntityPlayer player)
		{
			this.projectile = new NoroProjectiles.NoroNoroBeam(player.worldObj, player, attr);
			super.use(player);
		} 
	}

}
