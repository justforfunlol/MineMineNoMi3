package MineMineNoMi3.GUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import MineMineNoMi3.Lists.ListMisc;

public class GUIHandler implements IGuiHandler
{
	
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		switch(id)
		{
			case 0: return id == 0 && world.getBlockState(new BlockPos(x, y, z)) == ListMisc.EnchantmentTable.getDefaultState() ? new GUIEnchantmentTable(player, world, x, y, z) : null;
			case 1: return id == 1 ? new GUIPlayer(player) : null;
			case 2: return id == 2 ? new GUICC(player) : null;
			case 3: return id == 3 ? new GUIAbilities(player) : null;
			case 4: return id == 4 ? new GUIQuestions(player) : null;
		}
		return null;
	}
	
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		switch(id)
		{
			case 0: return id == 0 && world.getBlockState(new BlockPos(x, y, z)) == ListMisc.EnchantmentTable.getDefaultState() ? new ContainerEnchantmentTable(player, world) : null;
		}
		return null;
	}
}
