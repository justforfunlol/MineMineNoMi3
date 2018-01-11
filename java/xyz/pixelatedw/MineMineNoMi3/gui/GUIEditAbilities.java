package xyz.pixelatedw.MineMineNoMi3.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;

public class GUIEditAbilities extends GuiScreen
{
	protected EntityPlayer player;
	protected ExtendedEntityStats props;
	
	private int slotSelected = -1;
	private int menuSelected = 0;
	
	public GUIEditAbilities(EntityPlayer player)
	{
		this.player = player;
		this.props = ExtendedEntityStats.get(player);
	}
	
	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_BLANK);
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		
		int posX = sr.getScaledWidth();
		int posY = sr.getScaledHeight();
		drawTexturedModalRect((posX - 250) / 2, (posY - 230) / 2, 0, 0, 256, 256);
		drawTexturedModalRect((posX - 250) / 2, posY - 60, 0, 0, 256, 256);
		
		super.drawScreen(x, y, f);
	}
	
	public void initGui()
	{
		updateScreen();
	}
	
	public void updateScreen()
	{
		
	}
	
	public void actionPerformed(GuiButton button)
	{
		
	}
	
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
