package MineMineNoMi3.Lists;

import MineMineNoMi3.Entities.Mobs.Doppelman;
import MineMineNoMi3.Entities.Mobs.Marines.Marine;
import MineMineNoMi3.Entities.Mobs.Pirates.Pirate;
import WyPI.*;

public class ListEntities
{ 

	public static void init()
	{
		WyPI.Registry.addMOB("Marine", Marine.class, 0x94D5F7, 0x0000FF);
		WyPI.Registry.addMOB("Pirate", Pirate.class, 0xC9C9C9, 0xCC3134);
		
		WyPI.Registry.addMOB("Doppelman", Doppelman.class, -1, -1);
	}
	
	/*private static void addENTITY(String name, Class<? extends Entity> entity, int color1, int color2)
	{
		if(color1 != -1 && color2 != -1)
			EntityRegistry.registerGlobalEntityID(entity, name, EntityRegistry.findGlobalUniqueEntityId(), color1, color2);
		else
			EntityRegistry.registerGlobalEntityID(entity, name, EntityRegistry.findGlobalUniqueEntityId());
		LanguageRegistry.instance().addStringLocalization("entity."+name+".name", "en_US", name);			
	}*/
}
