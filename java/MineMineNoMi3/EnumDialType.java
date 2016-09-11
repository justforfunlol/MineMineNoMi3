package MineMineNoMi3;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

public enum EnumDialType implements IStringSerializable
{
	FIRE, IMPACT, FLASH, BREATH, MILKY, AXE, REJECT;
	
	private EnumDialType(){}
	
	public String getName() 
	{
		return name().toLowerCase();
	}
	
	public String toString()
	{
		return getName();
	}
}