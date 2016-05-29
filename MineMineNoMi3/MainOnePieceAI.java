package MineMineNoMi3;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class MainOnePieceAI extends EntityMob
{

	private int enmity, isAggressive;
	
	public MainOnePieceAI(World worldIn) 
	{
		super(worldIn);
		this.enmity = 0;
	}
	
	public String getTexture() {return this.getDataManager().get(Values.TEXTURE);}
	protected void setTexture(String texture) {this.getDataManager().set(Values.TEXTURE, texture);}
	
	public int getEnmity() {return this.getDataManager().get(Values.ENMITY);}
	protected void setEnmity(int val) {this.getDataManager().set(Values.ENMITY, val);}
		
	public byte getModel() {return this.getDataManager().get(Values.MODEL);}
	protected void setModel(byte model) {this.getDataManager().set(Values.MODEL, model);}
	
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		nbt.setInteger("Enmity", getEnmity());
		nbt.setString("Texture", getTexture());
		nbt.setByte("Model", getModel());
	}
	
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		setEnmity(nbt.getInteger("Enmity"));
		setTexture(nbt.getString("Texture"));
		setModel(nbt.getByte("Model"));
	}
	
	protected void entityInit()
	{
		super.entityInit();
	    this.getDataManager().register(Values.ENMITY, 0);
	    this.getDataManager().register(Values.TEXTURE, "n/a");
	    this.getDataManager().register(Values.MODEL, (byte)0);
	}

}
