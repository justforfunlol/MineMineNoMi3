package WyPI;

import java.util.HashMap;

import WyPI.abilities.AbilityAttribute;

public class WyPI
{
	private ParentModContainer container;
	 
	protected HashMap lang = new HashMap();
	protected HashMap items = new HashMap();
	protected HashMap cutscenes = new HashMap();
	
	/** Null by default. Works after a new WyPI object has been created .
	 * INTERNAL USE ONLY. PLEASE avoid using this. */
	public static WyPI apiInstance;

	public WyPI(Object mod, String sourceFolder)
	{ 
		container = new ParentModContainer(mod, sourceFolder);

		apiInstance = this;
	}
	
	public HashMap getLangMap() { return lang; }
	public HashMap getItemsMap() { return items; }
	public HashMap getCutscenesMap() { return cutscenes; }
	public ParentModContainer getParentMod() { return container; }
}
