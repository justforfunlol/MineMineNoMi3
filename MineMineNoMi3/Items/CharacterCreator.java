package MineMineNoMi3.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import MineMineNoMi3.Main;

public class CharacterCreator extends Item
{
	
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
    { 
		player.openGui(Main.getMineMineNoMi(), 2, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		return new ActionResult(EnumActionResult.SUCCESS, itemStack);	  
	}
	
}
