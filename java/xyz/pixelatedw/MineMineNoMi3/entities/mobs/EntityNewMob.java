package xyz.pixelatedw.MineMineNoMi3.entities.mobs;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityNewMob extends EntityMob implements IMultiTextureMob
{

	private boolean hasHaki = false, isLogia = false;
	private String texture = "N/A", model = "N/A";
	private boolean isAggressive;
	
	public EntityNewMob(World worldIn) 
	{
		super(worldIn);
	}
	
	public boolean isLogia() { return isLogia; }
	protected void setAsLogiaUser(boolean value) { this.isLogia = value; }
	
	public boolean hasHaki() {return hasHaki;}
	protected void isHakiUser(boolean value) {this.hasHaki = value;}
	
	public String getTexture() {return texture;}
	protected void setTexture(String texture) {this.texture = texture;}
	
	public String getModel() {return model;}
	protected void setModel(String model) {this.model = model;}

	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		nbt.setString("Texture", getTexture());
		nbt.setString("Model", getModel());
		nbt.setBoolean("Haki", hasHaki());
		nbt.setBoolean("Logia", isLogia());
	}
	
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		setTexture(nbt.getString("Texture"));
		setModel(nbt.getString("Model"));
		isHakiUser(nbt.getBoolean("Haki"));
		setAsLogiaUser(nbt.getBoolean("Logia"));
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

	public String getMobTexture()
	{ return this.getTexture(); }
	
	// 0 - Melee ONLY; 1 - Range ONLY; 2 - Both Melee and Range
	public int getCombatType()
	{ return 2; }
}
