package MineMineNoMi3.items;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class Heart extends Item
{
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
	{
		if(world.getEntityByID(itemStack.getTagCompound().getInteger("owner")) != null)
		{
			world.getEntityByID(itemStack.getTagCompound().getInteger("owner")).attackEntityFrom(DamageSource.magic, 5);
			((EntityLivingBase) world.getEntityByID(itemStack.getTagCompound().getInteger("owner"))).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 250, 1));
			((EntityLivingBase) world.getEntityByID(itemStack.getTagCompound().getInteger("owner"))).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 250, 1));
		}
		else
			player.inventory.deleteStack(itemStack);			
		return new ActionResult(EnumActionResult.PASS, itemStack);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		if(player.worldObj.getEntityByID(itemStack.getTagCompound().getInteger("owner")) != null)
		{
			list.add(TextFormatting.GOLD + "[Owner] " + TextFormatting.RESET + player.worldObj.getEntityByID(itemStack.getTagCompound().getInteger("owner")).getDisplayName().getFormattedText());
			list.add(TextFormatting.GOLD + "[HP] " + TextFormatting.RESET + ((EntityLivingBase) player.worldObj.getEntityByID(itemStack.getTagCompound().getInteger("owner"))).getHealth());
			list.add(TextFormatting.GOLD + "[Location] " + TextFormatting.RESET + (int)player.worldObj.getEntityByID(itemStack.getTagCompound().getInteger("owner")).posX + "X " + (int)player.worldObj.getEntityByID(itemStack.getTagCompound().getInteger("owner")).posY + "Y " + (int)player.worldObj.getEntityByID(itemStack.getTagCompound().getInteger("owner")).posZ +"Z");
		}
		else
			list.add(TextFormatting.GOLD + itemStack.getDisplayName().replace("'s Heart", "") + " is dead !");
	}
	
	public void setHeartOwner(ItemStack itemStack, EntityLivingBase e)
	{
		itemStack.setTagCompound(new NBTTagCompound());
		itemStack.getTagCompound().setInteger("owner", e.getEntityId());
	}
	
}
