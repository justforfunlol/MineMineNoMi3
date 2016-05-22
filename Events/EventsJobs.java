package MineMineNoMi3.Events;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.IPlayerCapability;
import MineMineNoMi3.Lists.ListMisc;

import com.google.common.collect.Iterables;

public class EventsJobs 
{

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
	    if (event.getEntity() instanceof EntityPlayer && !event.getEntity().worldObj.isRemote)
	    {
	    	EntityPlayer player = (EntityPlayer)event.getEntity();
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);

	    	if(props.getRace().equals("N/A") && props.getFaction().equals("N/A") && props.getJob().equals("N/A") && !player.inventory.hasItemStack(new ItemStack(ListMisc.CharacterCreator)))
	    		player.inventory.addItemStackToInventory(new ItemStack(ListMisc.CharacterCreator, 1));
	    }
	}
	
	@SubscribeEvent
	public void onEntityUpdateEvent(LivingEvent.LivingUpdateEvent event)
	{	
		if(event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.getEntityLiving();
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
			ItemStack heldItem = player.getHeldItem(EnumHand.MAIN_HAND);
 
			if(heldItem != null) 
			{	
				if(props.getJob().equals("Swordsman") && !heldItem.getItem().getItemAttributeModifiers(EntityEquipmentSlot.MAINHAND).isEmpty() && ((AttributeModifier)Iterables.get(heldItem.getItem().getItemAttributeModifiers(EntityEquipmentSlot.MAINHAND).get(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName()), 0)).getAmount() > 0)
					player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("damageBoost"), 2, 0, false, false));
				
				if(props.getJob().equals("Sniper") && heldItem.getItemUseAction() == EnumAction.BOW)
				{
					//if(!heldItem.isItemEnchanted())
						//heldItem.addEnchantment(Enchantment.p, 1);					
				}
		
			}
		}
	}

}
