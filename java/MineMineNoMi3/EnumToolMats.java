package MineMineNoMi3;

import MineMineNoMi3.lists.ID;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class EnumToolMats 
{	  
	  public static ArmorMaterial marine_armor = EnumHelper.addArmorMaterial("marine", ID.PROJECT_ID + ":marine", 12, new int[] {1, 2, 1, 1}, 15, null, 15); //ID.PROJECT_ID + ":marine"
	  public static ArmorMaterial pirate_armor = EnumHelper.addArmorMaterial("pirate", ID.PROJECT_ID + ":pirate", 12, new int[] {1, 2, 1, 1}, 15, null, 15);
} 