package MineMineNoMi3.Entities.Mobs;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import MineMineNoMi3.Lists.ListMisc;

public class DenDenMushi extends EntityMob
{

	public DenDenMushi(World world) 
	{
		super(world);
        this.tasks.addTask(1, new EntityAILookIdle(this));
        this.tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
	}
	
    protected void applyEntityAttributes()
    {
    	
        super.applyEntityAttributes();     
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.12000000417232513D); 
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);  	
    }
    
    public boolean interact(EntityPlayer player)
    {
    	ItemStack heldItem = player.inventory.getCurrentItem();
    	if(heldItem != null && heldItem.getItem() == Items.IRON_INGOT)
    	{  
    		player.inventory.addItemStackToInventory(new ItemStack(ListMisc.DenDenMushi));
    		heldItem.stackSize--;
    		this.setDead();
    		return true;
    	}
		return false;
    }
    
    
    protected void entityInit()
    {
        super.entityInit();
    }
    
    protected boolean isValidLightLevel()
    {
    	return true; 
    } 
    
    protected boolean canDespawn()
    {
        return true;
    }
    
    public boolean getCanSpawnHere()
    {
        return true;
    }
}
