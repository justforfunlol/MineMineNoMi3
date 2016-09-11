package MineMineNoMi3.lists;

import WyPI.modules.WyRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ListCreativeTabs 
{

	
	public static void init()
	{
		WyRegistry.instance().registerName("itemGroup.tab1", "Devil Fruits");
		WyRegistry.instance().registerName("itemGroup.tab2", "Weapons");
		WyRegistry.instance().registerName("itemGroup.tab3", "Speical Techniques");
		WyRegistry.instance().registerName("itemGroup.tab4", "Miscellaneous");
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
