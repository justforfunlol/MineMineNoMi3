package MineMineNoMi3.entities;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityNewMob extends EntityMob
{

	private int doriki, belly;
	private String texture = "N/A", model = "N/A";
	private boolean isAggressive;
	
	public EntityNewMob(World worldIn) 
	{
		super(worldIn);
	}
	
	public String getTexture() {return texture;}
	protected void setTexture(String texture) {this.texture =  texture;}

	public String getModel() {return model;}
	protected void setModel(String model) {this.model = model;}
	
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		nbt.setString("Texture", getTexture());
		nbt.setString("Model", getModel());
	}
	
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		setTexture(nbt.getString("Texture"));
		setModel(nbt.getString("Model"));
	}
	
	protected void entityInit()
	{super.entityInit();}
	
	protected boolean isValidLightLevel()
	{return true;} 
    
	protected boolean canDespawn()
	{return true;}
    
	public boolean isAIEnabled()
	{return true;}
	
	public boolean getCanSpawnHere()
	{return true;}

}
