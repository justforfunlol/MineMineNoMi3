package MineMineNoMi3.Events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import MineMineNoMi3.Values;
import MineMineNoMi3.Lists.ListAbilities;
import MineMineNoMi3.Lists.ListMisc;
import WyPI.Ability.AbilityItem;

public class EventsDrops
{
 
	@SubscribeEvent	
	public void onTossedItem(ItemTossEvent event)
	{		
		Item item = event.getEntityItem().getEntityItem().getItem();
		
		if(item instanceof AbilityItem)
		{
			event.setCanceled(true);			
			if(event.getPlayer() instanceof EntityPlayer)
				event.getPlayer().inventory.addItemStackToInventory(new ItemStack(item));
		}
	}
	
	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event)
	{
		if(event.getEntityLiving() instanceof EntityPlayer)
		{	
			EntityPlayer player = ((EntityPlayer)event.getEntityLiving());
			
			for(int i=0; i < Values.abilities.size(); i++)
				player.inventory.deleteStack(new ItemStack(Values.abilities.get(i)));

			player.inventory.deleteStack(new ItemStack(ListMisc.CharacterCreator));
			 
			player.inventory.deleteStack(new ItemStack(ListAbilities.SORU));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.TEKKAI));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.GEPPO));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.SHIGAN));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.KAMIE));	
			player.inventory.deleteStack(new ItemStack(ListAbilities.RANKYAKU));	
			
			/*player.inventory.consumeInventoryItem(ListMisc.BusoshokuHaki);	
			player.inventory.consumeInventoryItem(ListMisc.KenbunshokuHaki);	
			player.inventory.consumeInventoryItem(ListMisc.HaoshokuHaki);	*/
		}
	}
}
