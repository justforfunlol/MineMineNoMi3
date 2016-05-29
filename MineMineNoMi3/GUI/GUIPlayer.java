package MineMineNoMi3.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.lwjgl.opengl.GL11;

import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.IPlayerCapability;
import WyPI.WyPI;

public class GUIPlayer extends GuiScreen
{
	private ResourceLocation texture = new ResourceLocation("mineminenomi", "textures/gui/currencies.png");
	private EntityPlayer player;
	private RenderItem renderItem;

	public GUIPlayer(EntityPlayer player)
	{
		this.player = player;
		this.renderItem = Minecraft.getMinecraft().getRenderItem();
	}

	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
    
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);		
		
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;

		mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "DORIKI: " + TextFormatting.RESET + "" + props.getDoriki(), posX - 30, posY + 70, -1);
		mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "FACTION: " + TextFormatting.RESET + "" + props.getFaction(), posX - 30, posY + 90, -1);
		mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "RACE: " + TextFormatting.RESET + "" + props.getRace(), posX - 30, posY + 110, -1);
		mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "JOB: " + TextFormatting.RESET + "" + props.getJob(), posX - 30, posY + 130, -1);

		if(props.getBelly() > 0)
		{
			mc.fontRendererObj.drawStringWithShadow("" + props.getBelly(), posX + 215, posY + 72, -1);
			this.mc.renderEngine.bindTexture(texture);
			this.drawTexturedModalRect(posX + 190, posY + 60, 0, 32, 32, 64);
		}

		if(!props.getUsedFruit().equals("N/A") && !props.getUsedFruit().equals("null"))
		{
			String model = "";
			if(props.getUsedFruit().equals("ushiushibison"))
				model = "bison";
			
			ItemStack df = new ItemStack(GameRegistry.findItem("mineminenomi", props.getUsedFruit().replace(model, "") + "nomi" + model));
			mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + df.getDisplayName(), posX - 28, posY + 194, -1);
			this.renderItem.renderItemIntoGUI(df, posX - 50, posY + 190);
		}
		
		WyPI.Utils.drawEntityOnScreen(posX + 140, posY + 180 , 68, 0, 0, this.player);
    
		super.drawScreen(x, y, f);
	}

	public boolean doesGuiPauseGame()
	{
		return false;
	}

}
