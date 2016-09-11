package MineMineNoMi3;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;

public class MainEnchantment extends Enchantment
{
	int max;
	
	protected MainEnchantment(Enchantment.Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) 
	{
		super(rarityIn, typeIn, slots);	
	}

	public int getMinEnchantability(int par1)
	{
		return 10 + 20 * (par1 - 1);
	}

	public int getMaxEnchantability(int par1)
	{
		return super.getMinEnchantability(par1) + 50;
	}

	public int getMaxLevel()
	{
		return this.max;
	}

	public boolean canApply(ItemStack stack)
	{
		if ((stack.getItem() instanceof ItemSword))
			return true;
		return false;
	}

	public boolean canApplyAtEnchantingTable(ItemStack stack)
	{
		return false;
	}

	public boolean isAllowedOnBooks()
	{
		return false;
	}
}
