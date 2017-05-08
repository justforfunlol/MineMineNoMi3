package MineMineNoMi3.lists;

import MineMineNoMi3.MainEnchantment;
import WyPI.modules.WyRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ListEffects 
{
	public static Enchantment dialImpact, dialFlash, dialAxe, kairoseki;
	
	public static void init()
	{		
		dialImpact = new MainEnchantment("Impact", EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
		kairoseki 	= new MainEnchantment("Kairoseki", EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});	
		
		WyRegistry.instance().registerEnchantment(dialImpact, "Impact");
		WyRegistry.instance().registerEnchantment(kairoseki, "Kairoseki");
	}
}