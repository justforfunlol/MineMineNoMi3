package MineMineNoMi3.entities.mobs;

import javax.annotation.Nullable;

import MineMineNoMi3.entities.mobs.marines.MarineData;
import MineMineNoMi3.entities.mobs.pirates.PirateData;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class Doppelman extends EntityMob
{	
	private EntityPlayer owner;
	private int state;

	public Doppelman(World worldIn, EntityPlayer owner) 
	{
		this(worldIn);
		this.setOwner(owner);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, MarineData.class, 8.0F));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, PirateData.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, PirateData.class, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, MarineData.class, true));
	}

	public Doppelman(World worldIn) 
	{
		super(worldIn); 
	}

	protected void entityInit()
	{super.entityInit();}
	
	public void applyEntityAttributes()
	{ 
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
	}

	public void onEntityUpdate() 
	{
		
		super.onEntityUpdate();
	}
	
    public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn)
    {
    	if(entitylivingbaseIn != this.getOwner())
    		super.setAttackTarget(entitylivingbaseIn);
    }
	
	public void setAggressive() {this.state = 1;}
	public void setDefensive() {this.state = 0;}
	public int getState() {return this.state;}
	private void setOwner(EntityPlayer player) {this.owner = player;}
	public EntityPlayer getOwner() {return this.owner;}
	
}
