package xyz.pixelatedw.MineMineNoMi3.lists;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import xyz.pixelatedw.MineMineNoMi3.MainEnchantment;
import xyz.pixelatedw.MineMineNoMi3.api.WyRegistry;

public class ListEffects 
{
	public static Enchantment dialImpact, dialFlash, dialAxe, kairoseki;
	
	public static void init()
	{		
		dialImpact = new MainEnchantment(100, 1, EnumEnchantmentType.weapon, "Impact");
		kairoseki  = new MainEnchantment(101, 1, EnumEnchantmentType.weapon, "Kairoseki");
		
		//WyRegistry.registerEnchantment(dialImpact, "Impact");
		//WyRegistry.registerEnchantment(kairoseki, "Kairoseki");
	}
}