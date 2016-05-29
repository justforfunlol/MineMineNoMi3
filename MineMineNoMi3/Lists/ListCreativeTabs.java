package MineMineNoMi3.Lists;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import WyPI.*;

public class ListCreativeTabs 
{

	
	public static void init()
	{
		WyPI.Registry.addNAME("itemGroup.tab1", "Devil Fruits");
		WyPI.Registry.addNAME("itemGroup.tab2", "Weapons");
		WyPI.Registry.addNAME("itemGroup.tab3", "Speical Techniques");
		WyPI.Registry.addNAME("itemGroup.tab4", "Miscellaneous");
	}
	
	public static CreativeTabs tabDevilFruits = new CreativeTabs("tab1") {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return ListDevilFruits.MeraMeraNoMi;
	    }
	};
	
	public static CreativeTabs tabWeapons = new CreativeTabs("tab2") {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return ListMisc.Kairoseki;
	    }
	};
	
	public static CreativeTabs tabHaki = new CreativeTabs("tab3") {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return ListAbilities.SORU;
	    }
	};
	
	public static CreativeTabs tabMisc = new CreativeTabs("tab4") {
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return ListMisc.Kairoseki;
	    }
	};

}
