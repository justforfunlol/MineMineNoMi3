package MineMineNoMi3.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import MineMineNoMi3.EnumFruitType;
import MineMineNoMi3.Main;
import MineMineNoMi3.MainKeys;
import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.IPlayerCapability;
import MineMineNoMi3.Lists.ListCreativeTabs;

public class AkumaNoMi extends ItemFood
{

	public EnumFruitType type;
	public Item ability1, ability2, ability3, ability4;
	public Item[] abilities;
	
	public AkumaNoMi(EnumFruitType type, Item... abilities)
	{
		super(0, false);
		this.maxStackSize = 1;
		this.type = type;
		this.abilities = abilities;
		this.setCreativeTab(ListCreativeTabs.tabDevilFruits);
		this.setAlwaysEdible(); 
	}

    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand)
    {
		if(MainKeys.isShiftKeyDown() && this.abilities.length > 4)
			player.openGui(Main.getMineMineNoMi(), 3, world, 0, 0, 0);
		else
			player.setActiveHand(hand);
		return new ActionResult(EnumActionResult.SUCCESS, itemStack);
	}
    
	public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) 
	{
		IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
		
		if(!props.getUsedFruit().equals("N/A") && !player.capabilities.isCreativeMode)
			player.attackEntityFrom(DamageSource.wither, Float.POSITIVE_INFINITY);
		if(props.getUsedFruit().equals("N/A"))
			props.setUsedFruit(this.getUnlocalizedName().substring(5).replace("nomi", "").replace(":", "").replace("model", ""));
		
		if(this.type == EnumFruitType.LOGIA)
			props.setIsLogia(true);
		 
		if(this.ability1 != null)
		{
			ItemStack ability = new ItemStack(this.ability1);
			ability.setTagCompound(new NBTTagCompound());
			player.inventory.addItemStackToInventory(ability);
		}
		else
		{
			if(this.abilities[0] != null)
			{
				ItemStack ability = new ItemStack(this.abilities[0]);
				ability.setTagCompound(new NBTTagCompound());
				player.inventory.addItemStackToInventory(ability);
			}
		}
		if(this.ability2 != null)
		{
			ItemStack ability = new ItemStack(this.ability2);
			ability.setTagCompound(new NBTTagCompound());
			player.inventory.addItemStackToInventory(ability);
		}
		else
		{
			if(this.abilities[1] != null)
			{
				ItemStack ability = new ItemStack(this.abilities[1]);
				ability.setTagCompound(new NBTTagCompound());
				player.inventory.addItemStackToInventory(ability);
			}
		}
		if(this.ability3 != null)
		{
			ItemStack ability = new ItemStack(this.ability3);
			ability.setTagCompound(new NBTTagCompound());
			player.inventory.addItemStackToInventory(ability);
		}
		else
		{
			if(this.abilities[2] != null)
			{
				ItemStack ability = new ItemStack(this.abilities[2]);
				ability.setTagCompound(new NBTTagCompound());
				player.inventory.addItemStackToInventory(ability);
			}
		}
		if(this.ability4 != null)
		{
			ItemStack ability = new ItemStack(this.ability4);
			ability.setTagCompound(new NBTTagCompound());
			player.inventory.addItemStackToInventory(ability);
		}
		else
		{
			if(this.abilities[3] != null)
			{
				ItemStack ability = new ItemStack(this.abilities[3]);
				ability.setTagCompound(new NBTTagCompound());
				player.inventory.addItemStackToInventory(ability);
			}
		}

	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		for(int i = 0; i < this.abilities.length; i++)
			if(this.abilities[i] != null)
				list.add(this.abilities[i].getItemStackDisplayName(new ItemStack(abilities[i])));
			
	  	list.add("");
	  	list.add(type.getColor() + type.getName());
	}
}
