package MineMineNoMi3.items;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Cola extends ItemFood
{

	public Cola()
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
			
			if(props.getCola() <= Values.MAX_COLA - 15) 
				props.addCola(15);
			else 
				props.setCola(Values.MAX_COLA);
		}			
	}
}
