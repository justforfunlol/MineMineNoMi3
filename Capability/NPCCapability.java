package MineMineNoMi3.Capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class NPCCapability implements INPCCapability
{
	private String akumaNoMiUsed = "N/A";
	private boolean isLogia, hasShadow = true, hasHeart = true;
	
	public static class Storage implements IStorage<INPCCapability>
	{
		public static final Storage storage = new Storage();

		public NBTBase writeNBT(Capability<INPCCapability> capability, INPCCapability instance, EnumFacing side) 
		{
			NBTTagCompound nbt = new NBTTagCompound();

			nbt.setString("AkumaNoMiUsed", instance.getUsedFruit());
			
			nbt.setBoolean("isLogia", instance.isLogia());
			nbt.setBoolean("hasHeart", instance.hasHeart());
			nbt.setBoolean("hasShadow", instance.hasShadow());
			
			return nbt;
		}

		public void readNBT(Capability<INPCCapability> capability, INPCCapability instance, EnumFacing side, NBTBase nbtbase) 
		{
			NBTTagCompound nbt = (NBTTagCompound)nbtbase;

			instance.setUsedFruit(nbt.getString("AkumaNoMiUsed"));
			
			instance.setIsLogia(nbt.getBoolean("isLogia"));
			instance.setHasHeart(nbt.getBoolean("hasHeart"));
			instance.setHasShadow(nbt.getBoolean("hasShadow"));
		}
	}

	public boolean isLogia() {return this.isLogia;}
	public void setIsLogia(boolean isLogia) {this.isLogia = isLogia;}

	public String getUsedFruit() {return this.akumaNoMiUsed;}
	public void setUsedFruit(String name) {this.akumaNoMiUsed = name;}

	public boolean hasHeart() {return this.hasHeart;}
	public void setHasHeart(boolean hasHeart) {this.hasHeart = hasHeart;}

	public boolean hasShadow() {return this.hasShadow;}
	public void setHasShadow(boolean hasShadow) {this.hasShadow = hasShadow;}
	
}
