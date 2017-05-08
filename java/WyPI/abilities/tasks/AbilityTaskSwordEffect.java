package WyPI.abilities.tasks;

import WyPI.abilities.AbilityTask;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

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
