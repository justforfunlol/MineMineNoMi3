package MineMineNoMi3.items;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.lists.ID;
import MineMineNoMi3.packets.PacketSync;
import WyPI.modules.WyHelper;
import WyPI.modules.WyNetworkHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class UltraCola extends ItemFood
{

	public UltraCola()
	{
		super(0, false);
		this.maxStackSize = 16;  
	} 
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
	{
		player.setActiveHand(hand);
		return new ActionResult(EnumActionResult.PASS, itemStack);
	}
	
	
	public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) 
	{
		if(!world.isRemote)
		{
			IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);

			if(props.getRace().equals(ID.RACE_CYBORG))
			{
				if(props.getUltraColaConsumed() <= Values.MAX_ULTRACOLA - 1)
				{
					props.addUltraCola();
					props.setMaxCola(props.getMaxCola() + 15);
					props.setCola(props.getMaxCola());
				}
				else
				{
					player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 100, 0));
					player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 200, 0));
					player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 0));
				}
			}
			else
				player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 250, 0));
				
			WyNetworkHelper.instance().sendTo(new PacketSync(props), (EntityPlayerMP) player);
		}			
	}
}
