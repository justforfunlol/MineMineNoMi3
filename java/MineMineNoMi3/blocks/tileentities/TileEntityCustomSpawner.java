package MineMineNoMi3.blocks.tileentities;

import java.util.ArrayList;

import WyPI.modules.WyHelper;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityCustomSpawner extends TileEntity implements ITickable
{
	
	private String entityToSpawn;
	private int spawnLimit;
	private ArrayList spawnedEntities = new ArrayList();
	
	public TileEntityCustomSpawner(String entityToSpawn, int spawnLimit)
	{
		this.entityToSpawn = entityToSpawn;
		this.spawnLimit = spawnLimit;
	}
	
	public void update() 
	{
		if(!WyHelper.instance().getEntitiesNear(this, 30, EntityPlayer.class).isEmpty())
		{
			EntityLivingBase elb = WyHelper.instance().getEntitiesNear(this, 30, EntityPlayer.class).get(0);
			//EntityList.createEntityByName(entityName, worldIn)
			if(elb instanceof EntityPlayer)
			{ 
				EntityPlayer player = (EntityPlayer) elb;

				if((this.spawnedEntities.size() < this.spawnLimit) && !this.worldObj.isRemote)
				{			
					EntityLivingBase newSpawn = (EntityLivingBase) EntityList.createEntityByName(this.entityToSpawn, this.worldObj);//new EntityPig(this.worldObj);
					newSpawn.setLocationAndAngles(this.pos.getX(), this.pos.getY(), this.pos.getZ(), 0, 0);
					this.worldObj.spawnEntityInWorld(newSpawn);
					this.spawnedEntities.add(newSpawn);
				}
			}
		} 
		else
		{ 
			for(Object elbz : this.spawnedEntities.toArray())
			{
				((EntityLivingBase)elbz).setDead();
				this.spawnedEntities.clear();
			}
		}
	}
	
}

