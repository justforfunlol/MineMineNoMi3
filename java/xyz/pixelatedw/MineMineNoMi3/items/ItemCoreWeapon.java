package xyz.pixelatedw.MineMineNoMi3.items;

import com.google.common.collect.Multimap;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCoreWeapon extends Item
{
	private double damage = 1;
	private boolean canUseSpecial = false;
	
	public ItemCoreWeapon(int damage)
	{
		this.damage = damage;
		this.setFull3D();
	}
	
	public ItemCoreWeapon(int damage, boolean canUseSpecial)
	{
		this.damage = damage;
		this.canUseSpecial = canUseSpecial;
		this.setFull3D();
	}
	
	public Multimap getAttributeModifiers(ItemStack stack)
	{
		Multimap multimap = super.getAttributeModifiers(stack);
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.damage, 0)); 
		return multimap;	
	}
}
