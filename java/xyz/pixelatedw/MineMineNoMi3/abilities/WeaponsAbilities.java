package xyz.pixelatedw.MineMineNoMi3.abilities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Geppo;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Kamie;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Rankyaku;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Shigan;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Soru;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities.Tekkai;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityAttribute;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.FishKarateProjectiles;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class WeaponsAbilities 
{
	public static AbilityItem MARINESWORD = new MarineSword();
	public static AbilityItem PIRATECUTLASS = new PirateCutlass();
	public static AbilityItem PIPE = new Pipe();
	public static AbilityItem SCISSORS = new Scissors();
	public static AbilityItem KIKOKU = new Kikoku();
	public static AbilityItem KIRIBACHI = new Kiribachi();
	public static AbilityItem HOOK = new Hook();
	public static AbilityItem YORU = new Yoru();	
	public static AbilityItem BISETO = new Biseto();
	public static AbilityItem BOSTICK = new BoStick();
	public static AbilityItem UMBRELLA = new Umbrella();
	public static AbilityItem JITTE = new Jitte();
	
	public static AbilityItem[] abilitiesArray = new AbilityItem[] {};
	
	public static class SharpWeapon extends AbilityItem
	{
		private boolean canUseSpecial = false;
		
		public SharpWeapon(int damage, boolean canUseSpecial) 
		{
			this.attr = new AbilityAttribute().setItemDamage(damage); 
			this.canUseSpecial = canUseSpecial;
		}
	}
	
	public static class MarineSword extends SharpWeapon
	{
		public MarineSword() { super(5, false); }
	}
	
	public static class PirateCutlass extends SharpWeapon
	{
		public PirateCutlass() { super(5, false); }
	}
	
	public static class Pipe extends SharpWeapon
	{
		public Pipe() { super(4, true); }
	}
	
	public static class Scissors extends SharpWeapon
	{
		public Scissors() { super(7, true); }
	}
	
	public static class Kikoku extends SharpWeapon
	{
		public Kikoku() { super(8, true); }
	}
	
	public static class Kiribachi extends SharpWeapon
	{
		public Kiribachi() { super(6, true); }
	}
	
	public static class Hook extends SharpWeapon
	{
		public Hook() { super(7, true); }
	}
	
	public static class Yoru extends SharpWeapon
	{
		public Yoru() { super(12, true); }
	}
	
	public static class Biseto extends SharpWeapon
	{
		public Biseto() { super(12, true); }
	}
	
	public static class BoStick extends SharpWeapon
	{
		public BoStick() { super(6, true); }
	}
	
	public static class Umbrella extends SharpWeapon
	{
		public Umbrella() { super(6, false); }
	}
	
	public static class Jitte extends SharpWeapon
	{
		public Jitte() { super(7, false); }
	}
}
