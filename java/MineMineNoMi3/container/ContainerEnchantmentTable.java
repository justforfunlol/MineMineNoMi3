package MineMineNoMi3.container;

import MineMineNoMi3.lists.ListAbilities;
import MineMineNoMi3.lists.ListEffects;
import MineMineNoMi3.lists.ListMisc;
import WyPI.abilities.AbilityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ContainerEnchantmentTable extends Container
{	
	private World world;
	private EntityPlayer player;
	
	public IInventory dialEnch = new InventoryBasic("DialEnchant", true, 1)
	{
		public int getInventoryStackLimit(){return 1;}
		public void markDirty()
		{
			super.markDirty();
			ContainerEnchantmentTable.this.onCraftMatrixChanged(this);
		}
	};
    
	public IInventory dialSlots = new InventoryBasic("DialSlots", true, 3)
	{
		public int getInventoryStackLimit(){return 1;}
		public void markDirty()
		{
			super.markDirty();
			ContainerEnchantmentTable.this.onCraftMatrixChanged(this);
		}
	};

	public ContainerEnchantmentTable(EntityPlayer player, World world)
	{
		this.world = world;
		this.player = player;
		
        this.addSlotToContainer(new Slot(this.dialEnch, 0, 78, 52));
		
        this.addSlotToContainer(new Slot(this.dialSlots, 0, 112, 10));
        this.addSlotToContainer(new Slot(this.dialSlots, 1, 78, 10));
        this.addSlotToContainer(new Slot(this.dialSlots, 2, 44, 10));
        
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
        }
	}

	public void onCraftMatrixChanged(IInventory par1IInventory)
	{
		ItemStack itemStack = this.dialEnch.getStackInSlot(0);
		
		if(!this.world.isRemote && this.dialEnch.getStackInSlot(0) != null && this.dialSlots.getStackInSlot(0) != null && this.dialSlots.getStackInSlot(1) != null && this.dialSlots.getStackInSlot(2) != null)
		{	
			if(!itemStack.isItemEnchanted())
			{
				Item mat0 = this.dialSlots.getStackInSlot(0).getItem();
				Item mat1 = this.dialSlots.getStackInSlot(1).getItem();
				Item mat2 = this.dialSlots.getStackInSlot(2).getItem();
					
				if(itemStack.getItem() instanceof ItemSword || (itemStack.getItem() instanceof AbilityItem && ((AbilityItem)itemStack.getItem()).getAttribute().getItemDamage() > 0 ))
				{								
					if(mat0 == ListAbilities.DIALFIRE && mat1 == ListAbilities.DIALFIRE && mat2 == ListAbilities.DIALFIRE)	
						itemStack.addEnchantment(Enchantments.FIRE_ASPECT, 1);
					if(mat0 == ListAbilities.DIALIMPACT && mat1 == ListAbilities.DIALIMPACT && mat2 == ListAbilities.DIALIMPACT)	
						itemStack.addEnchantment(ListEffects.dialImpact, 1);
					if(mat0 == ListMisc.DialEisen && mat1 == ListMisc.DialEisen && mat2 == ListMisc.DialEisen)	
						itemStack.addEnchantment(Enchantments.SHARPNESS, 2);
					if(mat0 == ListAbilities.DIALBREATH && mat1 == ListAbilities.DIALBREATH && mat2 == ListAbilities.DIALBREATH)	
						itemStack.addEnchantment(Enchantments.KNOCKBACK, 2);
					if(mat0 == ListMisc.Kairoseki && mat1 == ListMisc.Kairoseki && mat2 == ListMisc.Kairoseki)
						itemStack.addEnchantment(ListEffects.kairoseki, 1);
					if(mat0 == ListMisc.BlackMetal && mat1 == ListMisc.BlackMetal && mat2 == ListMisc.BlackMetal)
					{
						itemStack.addEnchantment(Enchantments.SHARPNESS, 10);
						itemStack.addEnchantment(Enchantments.SHARPNESS, 2);
					}
					
					this.dialSlots.setInventorySlotContents(0, null);
					this.dialSlots.setInventorySlotContents(1, null);
					this.dialSlots.setInventorySlotContents(2, null);
				}
					/*if(itemStack.getItem() instanceof ItemArmor)
					{
						if(mat == ListMisc.DialFire)	
							itemStack.addEnchantment(Enchantment.fireProtection, 1);
						if(mat == ListMisc.DialEisen)
							itemStack.addEnchantment(Enchantment.protection, 2);
						if(mat == ListMisc.DialImpact)
							itemStack.addEnchantment(Enchantment.blastProtection, 2);
						if(mat == ListMisc.DialBreath)
							itemStack.addEnchantment(Enchantment.thorns, 1);					
					}*/
			}			
		}
	}
	
	public boolean canInteractWith(EntityPlayer arg0) 
	{
		return true;
	}
	
    public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);

        if (!this.world.isRemote)
        {            
            for(int i = 0; i < this.dialSlots.getSizeInventory(); i++)
            {
            	if(this.dialSlots.getStackInSlot(i) != null)
            	{
            		player.entityDropItem(this.dialSlots.getStackInSlot(i), 1);
            	}
            }
            
        	ItemStack slot1 = this.dialEnch.getStackInSlot(0);
        	
            if (slot1 != null)
            {
                player.entityDropItem(slot1, 1);
            }
        }
    }	
}