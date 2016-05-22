package MineMineNoMi3.Entities.AI;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import MineMineNoMi3.Entities.Mobs.Doppelman;
import WyPI.*;

public class EntityAIDoppelman extends EntityAIBase
{
	private Doppelman doppelman;
	private EntityPlayer owner;
	
	public EntityAIDoppelman(EntityCreature e, EntityPlayer owner)
	{
		this.doppelman = (Doppelman) e;
		this.owner = owner;
	}
	
	public boolean shouldExecute() 
	{return true;}
	
    public void updateTask()
    {
    	if(doppelman.getDistanceSqToEntity(owner) > 200)
    		doppelman.setPositionAndUpdate(owner.posX, owner.posY, owner.posZ);
    	
    	for(EntityLivingBase e : WyPI.Utils.getEntitiesNear(doppelman, 100))
    	{
    		if(doppelman.getState() == 1)
    		{

    		}
    	}
    }

}
