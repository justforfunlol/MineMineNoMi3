package MineMineNoMi3.items;

import java.util.Random;

import MineMineNoMi3.EnumFruitType;
import MineMineNoMi3.Values;
import MineMineNoMi3.lists.ListMisc;
import WyPI.modules.WyHelper;
import WyPI.modules.WyMathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class AkumaNoMiBox extends Item
{
	
	private int tier;
	
	public AkumaNoMiBox(int tier)
	{
		this.tier = tier;
	} 

	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
	{
		if(!world.isRemote)
		{
			if(player.inventory.hasItemStack(new ItemStack(ListMisc.Key)))
			{
				for(int i = 0; i < player.inventory.mainInventory.length; i++)
				{
					if(player.inventory.getStackInSlot(i) != null && player.inventory.getStackInSlot(i).getItem() == ListMisc.Key)
					{
						player.inventory.decrStackSize(i, 1);
						break;
					}
				}
				player.inventory.deleteStack(itemStack);
				
				player.inventory.addItemStackToInventory(new ItemStack(roulette(), 1, 0));
				
			}
			else
				WyHelper.instance().sendMsgToPlayer(player, "You need a key !");
		}

		return new ActionResult(EnumActionResult.PASS, itemStack);
	}
	
	
	private AkumaNoMi roulette()
	{
		Random rand = new Random();
		int fruitListId = (int) WyMathHelper.instance().randomWithRange(0, Values.devilfruits.size() - 1);
		
		if(rand.nextInt(100) + rand.nextDouble() <= 95)
		{
			if(tier == 1)
			{
				if( ((AkumaNoMi)Values.devilfruits.get( fruitListId )).getType() == EnumFruitType.PARAMECIA )
					return ((AkumaNoMi)Values.devilfruits.get( fruitListId ));
				else
					return roulette();
			}
			else if(tier == 2)
			{
				if( ((AkumaNoMi)Values.devilfruits.get( fruitListId )).getType() == EnumFruitType.ZOAN )
					return ((AkumaNoMi)Values.devilfruits.get( fruitListId ));
				else
					return roulette();
			}
			else if(tier == 3)
			{
				if( ((AkumaNoMi)Values.devilfruits.get( fruitListId )).getType() == EnumFruitType.LOGIA )
					return ((AkumaNoMi)Values.devilfruits.get( fruitListId ));
				else
					return roulette();
			}
		}
		
		return null;
	}

}
