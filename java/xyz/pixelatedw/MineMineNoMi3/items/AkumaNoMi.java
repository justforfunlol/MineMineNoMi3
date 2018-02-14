package xyz.pixelatedw.MineMineNoMi3.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.EnumFruitType;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.abilities.MeraAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.lists.ListCreativeTabs;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;


public class AkumaNoMi extends ItemFood
{
 
	public EnumFruitType type;
	public Item ability1, ability2, ability3, ability4;
	public Ability[] abilities;
	
	public AkumaNoMi(EnumFruitType type, Ability... abilitiesArray)
	{
		super(0, false);
		this.maxStackSize = 1;
		this.type = type;
		this.abilities = abilitiesArray;
		this.setCreativeTab(ListCreativeTabs.tabDevilFruits);
		this.setAlwaysEdible(); 
	} 

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
		player.setItemInUse(itemStack, itemUseDuration);
		return itemStack;
	}
    
	public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) 
	{
		ExtendedEntityStats props = ExtendedEntityStats.get(player);
		
		if(props.hasYamiPower())
		{
			if(!props.getUsedFruit().equals("yamidummy"))
				player.attackEntityFrom(DamageSource.wither, Float.POSITIVE_INFINITY);
			
			if(this.getUnlocalizedName().substring(5).replace("nomi", "").equals("yamiyami"))
				player.attackEntityFrom(DamageSource.wither, Float.POSITIVE_INFINITY);
			
			props.setUsedFruit(this.getUnlocalizedName().substring(5).replace("nomi", "").replace(":", "").replace(",", "").replace("model", ""));
			
			if(this.type == EnumFruitType.LOGIA)
				props.setIsLogia(true);
			 
			for(Ability a : abilities)
			{
				props.addDevilFruitAbility(a);
			}
		}
		else
		{	
			if(this.getUnlocalizedName().substring(5).replace("nomi", "").equals("yamiyami"))
			{
				props.setYamiPower(true);
				if(props.getUsedFruit().equals("N/A"))
					props.setUsedFruit("yamidummy");
					
				props.setIsLogia(false);
				
				for(Ability a : abilities)
				{
					props.addDevilFruitAbility(a);
				}
			}
			else
			{
				if(!props.getUsedFruit().equals("N/A") && !props.hasYamiPower())
					player.attackEntityFrom(DamageSource.wither, Float.POSITIVE_INFINITY);			
				
				if(props.getUsedFruit().equals("N/A"))				
					props.setUsedFruit(this.getUnlocalizedName().substring(5).replace("nomi", "").replace(":", "").replace(",", "").replace("model", ""));

				if(this.type == EnumFruitType.LOGIA)
					props.setIsLogia(true);
				 
				for(Ability a : abilities)
				{
					props.addDevilFruitAbility(a);
				}
			}
		}
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		for(int i = 0; i < this.abilities.length; i++)
			if(this.abilities[i] != null)
				list.add(this.abilities[i].getAttribute().getAttributeName());
			
	  	list.add("");
	  	list.add(type.getColor() + type.getName());
	}
	
	public EnumFruitType getType() { return type; }

}
