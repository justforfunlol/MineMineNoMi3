package MineMineNoMi3.Entities.Mobs.Marines;

import net.minecraft.world.World;
import MineMineNoMi3.MainOnePieceAI;

public class MarineData extends MainOnePieceAI
{
	
	public MarineData(World world) 
	{
		super(world); 
		//this.tasks.addTask(1, new EntityAIAggressive(this, 8));
		/*this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, PirateData.class, 1.0D, false));
		this.tasks.addTask(3, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, PirateData.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.tasks.addTask(9, new EntityAIHurtByTarget(this, true));
		this.tasks.addTask(10, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.tasks.addTask(11, new EntityAINearestAttackableTarget(this, PirateData.class, true));  */
	}
 
	public void onEntityUpdate() 
	{
		super.onEntityUpdate();
		/*for(EntityLivingBase players : WyPI.Utils.getEntitiesNear(this, 25))
		{
			if(players instanceof EntityPlayer)
			{
				MainExtendedPlayer props = MainExtendedPlayer.get((EntityPlayer) players);
				
				/*if(!props.getFaction().equals("Marine") && !((EntityPlayer)players).capabilities.isCreativeMode)
				{
					if(this instanceof MarineWithGun)
						this.tasks.addTask(12, new EntityAIArrowAttack((IRangedAttackMob)this, 1.0D, 20, 60, 15.0F));
					else
						this.tasks.addTask(13, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
				}
			}
		}*/
	}

	protected boolean isValidLightLevel()
	{return true;} 
    
	protected boolean canDespawn()
	{return true;}
    
	public boolean isAIEnabled()
	{return true;}
	
	public boolean getCanSpawnHere()
	{return true;}
		
}

