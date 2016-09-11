package WyPI;

import java.util.HashMap;

public class WyPI
{
	private ParentModContainer container;
	 
	protected HashMap lang = new HashMap();
	protected HashMap items = new HashMap();
	
	/** Null by default. Works after a new WyPI object has been created .
	 * INTERNAL USE ONLY. PLEASE avoid using this. */
	public static WyPI apiInstance;

	public WyPI(Object mod)
	{
		container = new ParentModContainer(mod);

		apiInstance = this;
	}
	
	public HashMap getLangMap() { return lang; }
	public HashMap getItemsMap() { return items; }
	public ParentModContainer getParentMod() { return container; }
}
