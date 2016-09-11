package MineMineNoMi3.lists;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ListRecipes 
{

	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(ListMisc.EnchantmentTable, 1), new Object[] {"###","@#@","@@@", '#', ListMisc.DenseKairoseki, '@', Blocks.LOG});	
		
		GameRegistry.addRecipe(new ItemStack(ListMisc.KairosekiBlock, 1), new Object[] {"###","###","###", '#', ListMisc.Kairoseki});	
		GameRegistry.addShapelessRecipe(new ItemStack(ListMisc.Kairoseki, 9), new Object[] {ListMisc.KairosekiBlock});
		
		GameRegistry.addRecipe(new ItemStack(ListMisc.DenseKairoseki, 1), new Object[] {"#$.","$#.","...", '#', ListMisc.Kairoseki, '$', Items.IRON_INGOT});
		GameRegistry.addRecipe(new ItemStack(ListMisc.DenseKairoseki, 1), new Object[] {"$#.","#$.","...", '#', ListMisc.Kairoseki, '$', Items.IRON_INGOT});
		GameRegistry.addRecipe(new ItemStack(ListMisc.DenseKairoseki, 1), new Object[] {".$#",".#$","...", '#', ListMisc.Kairoseki, '$', Items.IRON_INGOT});
		GameRegistry.addRecipe(new ItemStack(ListMisc.DenseKairoseki, 1), new Object[] {".#$",".$#","...", '#', ListMisc.Kairoseki, '$', Items.IRON_INGOT});
		GameRegistry.addRecipe(new ItemStack(ListMisc.DenseKairoseki, 1), new Object[] {"...","$#.","#$.", '#', ListMisc.Kairoseki, '$', Items.IRON_INGOT});	
		GameRegistry.addRecipe(new ItemStack(ListMisc.DenseKairoseki, 1), new Object[] {"...","#$.","$#.", '#', ListMisc.Kairoseki, '$', Items.IRON_INGOT});
		GameRegistry.addRecipe(new ItemStack(ListMisc.DenseKairoseki, 1), new Object[] {"...",".#$",".$#", '#', ListMisc.Kairoseki, '$', Items.IRON_INGOT});	
		GameRegistry.addRecipe(new ItemStack(ListMisc.DenseKairoseki, 1), new Object[] {"...",".$#",".#$", '#', ListMisc.Kairoseki, '$', Items.IRON_INGOT});	
		
		GameRegistry.addRecipe(new ItemStack(ListMisc.BlackMetal, 1), new Object[] {"###","#$#","###", '#', ListMisc.DenseKairoseki, '$', Items.LAVA_BUCKET});		
	}
	
}
