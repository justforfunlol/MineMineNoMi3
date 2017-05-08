package MineMineNoMi3.items;

import java.util.List;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.lists.ID;
import MineMineNoMi3.lists.ListStats;
import MineMineNoMi3.packets.PacketSync;
import WyPI.modules.WyHelper;
import WyPI.modules.WyMathHelper;
import WyPI.modules.WyNetworkHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.stats.StatisticsManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class BellyPouch extends Item
{
	public BellyPouch()
	{
		
	} 

	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
	{
		IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);

		//player.addStat(stat);
		
		if(!world.isRemote)
		{
			//player.addStat(ListStats.SHIPS_RAIDED);
			//System.out.println( ((EntityPlayerMP)player).getStatFile().readStat(ListStats.SHIPS_RAIDED) );
			
			int amount = (int) WyMathHelper.instance().randomWithRange(5, 100);
			
			if(props.getBelly() <= Values.MAX_GENERAL - amount)
			{
				props.addBelly(amount);
				WyHelper.instance().sendMsgToPlayer(player, "You've obtained " + amount + " belly !");
				player.inventory.deleteStack(itemStack);
			}
			else
				props.setBelly(Values.MAX_GENERAL);
		}
		
		WyNetworkHelper.instance().sendToServer(new PacketSync(props));
		
		return new ActionResult(EnumActionResult.PASS, itemStack);
	}

}
