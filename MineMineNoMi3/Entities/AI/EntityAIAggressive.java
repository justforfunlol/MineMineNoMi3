package MineMineNoMi3.Entities.AI;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import MineMineNoMi3.Entities.Mobs.Marines.MarineData;
import WyPI.WyPI;

public class EntityAIAggressive extends EntityAIBase
{
	private MarineData theEntity;
	private EntityLivingBase target;
	private int view;

	public EntityAIAggressive(MarineData e, int view_range)
	{
		this.theEntity = e;
		this.view = view_range;
	}
	
	public boolean shouldExecute() 
	{
		return true;
	}
	 
    public void updateTask()
    {
    	for(EntityLivingBase e : WyPI.Utils.getEntitiesNear(this.theEntity, this.view))
    	{
	    	if(((EntityLiving) this.theEntity).getEntitySenses().canSee(e))
	    	{
	    		if(e instanceof EntityPlayer && ((EntityPlayer) e).capabilities.isCreativeMode)
	    			return;
	    		if(this.target == null)
	    			this.target = e;
	    		else
	    		{
	    			((EntityLiving) this.theEntity).getNavigator().tryMoveToEntityLiving(this.target, 1);
	    			if(this.theEntity.getDistanceSqToEntity(this.target) > 200)
	    				this.target = null;
	    		}
    		}
    	}
    }

}
