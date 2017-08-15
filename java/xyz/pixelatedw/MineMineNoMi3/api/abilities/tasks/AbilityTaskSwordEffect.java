package xyz.pixelatedw.MineMineNoMi3.api.abilities.tasks;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityTask;

public class AbilityTaskSwordEffect extends AbilityTask
{
	private PotionEffect effectOnHit;
	
	public AbilityTaskSwordEffect(PotionEffect effectOnHit)
	{
		this.effectOnHit = effectOnHit;
	}
	
	public void onItemHit(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) 
	{
		if(this.effectOnHit != null)
			target.addPotionEffect(effectOnHit);
	}
}
