package WyPI.abilities.extra;

import java.util.HashMap;

import WyPI.abilities.AbilityAttribute;
import WyPI.modules.WyDebug;
import WyPI.modules.WyHelper;

public class AttributeManager
{
	private static AttributeManager instance;
	public static AttributeManager instance() 
	{ 
		if(instance == null) instance = new AttributeManager();
		return instance;
	}
	
	
	private HashMap<String, AbilityAttribute> registeredAttributes = new HashMap<String, AbilityAttribute>();
	
	
	public void registerAttribute(AbilityAttribute attr)
	{
		if( !attr.getAttributeName().equals("N/A") )
		{
			if( !this.registeredAttributes.containsKey(attr.getAttributeName()) ) this.registeredAttributes.put(WyHelper.instance().getFancyName(attr.getAttributeName()), attr);
			else WyDebug.instance().warn(attr.getAttributeName() + " is already registered once !");
		}
		else
		{
			String name = "abilityattribute" + registeredAttributes.size();
			if( !this.registeredAttributes.containsKey(name) ) 
			{
				this.registeredAttributes.put(WyHelper.instance().getFancyName(name), attr.setAttributeName(name));
				WyDebug.instance().info("An attribute was registered with a random name ! (" + name + ")");
			}
			else WyDebug.instance().warn(attr.getAttributeName() + " is already registered once !");
		}
	}
	
	public AbilityAttribute getAttribute(String name)
	{
		if(this.registeredAttributes.containsKey(WyHelper.instance().getFancyName(name)))
			return this.registeredAttributes.get(WyHelper.instance().getFancyName(name));
		else
		{
			WyDebug.instance().error("No Attribute with " + name + " could've been found ! Returning NULL !");
			return null;
		}
	}

	public HashMap<String, AbilityAttribute> getHashMap() { return this.registeredAttributes; }
}
