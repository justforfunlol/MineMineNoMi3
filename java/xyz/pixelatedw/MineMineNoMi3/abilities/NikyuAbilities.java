package xyz.pixelatedw.MineMineNoMi3.abilities;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.abilities.MokuAbilities.WhiteLauncher;
import xyz.pixelatedw.MineMineNoMi3.abilities.MokuAbilities.WhiteOut;
import xyz.pixelatedw.MineMineNoMi3.abilities.MokuAbilities.WhiteSnake;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MokuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.NikyuProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class NikyuAbilities 
{

	public static Ability[] abilitiesArray = new Ability[] {new UrsusShock()};
	
	public static class PadHo extends Ability
	{
		public PadHo() 
		{
			super(ListAttributes.PADHO); 
		}
		
		public void use(EntityPlayer player)
		{		
			WyHelper.sendMsgToPlayer(player, ChatFormatting.RED + "NOT YET IMPLEMENTED");
			//super.use(player);
		}
	}
	
	public static class UrsusShock extends Ability
	{
		public UrsusShock() 
		{
			super(ListAttributes.URSUSSHOCK); 
		}
		
		public void use(EntityPlayer player)
		{		
			this.projectile = new NikyuProjectiles.UrsusShock(player.worldObj, player, attr);
			super.use(player);
		}
	}
	
}
