package MineMineNoMi3.events;

import MineMineNoMi3.lists.ListEffects;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventsEnchantments
{
	@SubscribeEvent
	public void onLivingAttackEvent(LivingAttackEvent event)
	{
		if (((event.getSource().getEntity() instanceof EntityPlayer)) && ((event.getEntityLiving() instanceof EntityLiving)))
		{
			EntityPlayer player = (EntityPlayer)event.getSource().getEntity();
			EntityLiving living = (EntityLiving)event.getEntityLiving();
			ItemStack hand = player.inventory.getCurrentItem();
			
			if(hand != null && hand.isItemEnchanted())
			{
				if(!living.worldObj.isRemote)
				{
					if (EnchantmentHelper.getEnchantmentLevel(ListEffects.dialImpact, player.getHeldItem(EnumHand.MAIN_HAND)) == 1)
					{
						int r = living.worldObj.rand.nextInt(10);
						if(r < 2)
						{	    			  
							player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 40, 10)); 
							living.worldObj.createExplosion(living, living.posX, living.posY, living.posZ, 1.4F, true);
						}
					} 
				}
			}
		}
	}
}