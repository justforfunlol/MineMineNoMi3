package MineMineNoMi3.items;

import java.util.List;

import MineMineNoMi3.MainKeys;
import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.lists.ListExtraAttributes;
import MineMineNoMi3.lists.ListMisc;
import MineMineNoMi3.packets.PacketSync;
import WyPI.abilities.AbilityProjectile;
import WyPI.modules.WyHelper;
import WyPI.modules.WyMathHelper;
import WyPI.modules.WyNetworkHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Flintlock extends Item
{

	
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
	{		
		if(!world.isRemote)
		{
			if(MainKeys.isShiftKeyDown())
			{
				if(itemStack.getTagCompound().getInteger("bulletType") == 0 && itemStack.getTagCompound().getInteger("bullets") == 0) 
				{
					itemStack.getTagCompound().setInteger("bulletType", 1);
					itemStack.setStackDisplayName("§rFlintlock <Kairoseki>");
				}
				else if(itemStack.getTagCompound().getInteger("bulletType") == 1 && itemStack.getTagCompound().getInteger("bullets") == 0) 
				{
					itemStack.getTagCompound().setInteger("bulletType", 0);
					itemStack.setStackDisplayName("§rFlintlock <Normal>");
				}
			}
			else
			{
				if(itemStack.getTagCompound().getInteger("bullets") > 0)
				{				
					int b = itemStack.getTagCompound().getInteger("bullets");
					
					AbilityProjectile proj = new AbilityProjectile(player.worldObj, player, (itemStack.getTagCompound().getInteger("bulletType") == 0 ? ListExtraAttributes.NORMALBULLET : ListExtraAttributes.KAIROSEKIBULLET) );
					proj.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1.5F, 1);
					player.worldObj.spawnEntityInWorld(proj);
					
					b--;
					itemStack.getTagCompound().setInteger("bullets", b);
				}
				else
				{
					for(int i = 0; i < player.inventory.getSizeInventory(); i++)
					{
						if(player.inventory.getStackInSlot(i) != null && ((player.inventory.getStackInSlot(i).getItem() == ListMisc.Bullets && itemStack.getTagCompound().getInteger("bulletType") == 0)
								|| (player.inventory.getStackInSlot(i).getItem() == ListMisc.KairosekiBullets && itemStack.getTagCompound().getInteger("bulletType") == 1)))
						{
							ItemStack is = player.inventory.getStackInSlot(i);
							if(is.stackSize > 16)
							{
								itemStack.getTagCompound().setInteger("bullets", 16);
								player.inventory.decrStackSize(i, 16);
							}
							else
							{
								itemStack.getTagCompound().setInteger("bullets", is.stackSize);
								player.inventory.removeStackFromSlot(i);
							}
						}
					}
				}
			}
		}
		return new ActionResult(EnumActionResult.PASS, itemStack);
	}
	
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) 
	{
		if(!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
			itemStack.getTagCompound().setInteger("bulletType", 0); // 0 - normal bullets; 1 - kairoseki bullets
			itemStack.getTagCompound().setInteger("bullets", 0);
		}
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		if(itemStack.hasTagCompound())
			list.add("Bullets : " + itemStack.getTagCompound().getInteger("bullets"));
	}
	
}
