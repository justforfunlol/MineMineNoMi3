package MineMineNoMi3.Entities.Mobs;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import MineMineNoMi3.Entities.AI.EntityAIDoppelman;

public class Doppelman extends EntityMob
{	
	private EntityPlayer owner;
	private int state;
	
	public Doppelman(World worldIn, EntityPlayer owner) 
	{
		this(worldIn);
		this.setOwner(owner);
		this.setDefensive();
		this.tasks.addTask(0, new EntityAIDoppelman(this, owner)); 
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
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
	}
	
	public void setAggressive() {this.state = 1;}
	public void setDefensive() {this.state = 0;}
	public int getState() {return this.state;}
	private void setOwner(EntityPlayer player) {this.owner = player;}
	public EntityPlayer getOwner() {return this.owner;}
	
}
