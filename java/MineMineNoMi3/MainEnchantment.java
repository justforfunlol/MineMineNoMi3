package MineMineNoMi3;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class MainEnchantment extends Enchantment
{
    public MainEnchantment(String name, EnumEnchantmentType type, EntityEquipmentSlot[] slots)
    {
        super(Enchantment.Rarity.COMMON, type, slots);
        this.setName(name);
    }
    
    public int getMaxLevel()
    {
        return 1;
    }
}