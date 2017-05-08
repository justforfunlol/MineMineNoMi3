package WyPI.abilities.extra;

import net.minecraft.item.IItemPropertyGetter;

public class ItemProperty 
{
	
	private String name;
	private IItemPropertyGetter ipg;
	private int value;
	
	public ItemProperty(String name, int value, IItemPropertyGetter ipg)
	{
		this.name = name;
		this.ipg = ipg;
		this.value = value;
	}
	
	public String getName() { return name; }
	
	public IItemPropertyGetter getItemPropertyGetter() { return ipg; }
	
	public int getValue() { return value; }

}
