package xyz.pixelatedw.MineMineNoMi3.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.gui.extra.GUIButtonNoTexture;

public class GUIGameModeSelect extends GuiScreen
{

	private String title = "Select a Game Mode";
	
	public GUIGameModeSelect()
	{
		
	}
	
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
    	this.drawDefaultBackground();
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
    	
		this.drawCenteredString(this.fontRendererObj, title, this.width / 2, 20, 16777215);
		
		this.mc.getTextureManager().bindTexture(ID.TEXTURE_WIDGETS);
		
		this.drawTexturedModalRect(posX - 50, posY + 60, 0, 0, 170, 145);
		
    	GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
		this.drawTexturedModalRect(posX + 150, posY + 60, 0, 0, 170, 145);	
		this.drawTexturedModalRect(posX	+ 50, posY + 150, 0, 0, 170, 145);	
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    public void initGui()
    { 	
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
    	
		this.buttonList.add(new GUIButtonNoTexture(1, posX - 50, posY + 60, 160, 70, ""));
		this.buttonList.add(new GUIButtonNoTexture(2, posX + 150, posY + 60, 160, 70, ""));	
		this.buttonList.add(new GUIButtonNoTexture(3, posX + 50, posY + 150, 160, 70, ""));	
    }
    
    protected void actionPerformed(GuiButton button)
    {
    	switch(button.id)
    	{
    		case 1:
    			this.mc.displayGuiScreen(new GuiSelectWorld(this));
    			break;
    		case 2:
    			this.title = "Adventures is not available yet !";
    			break;
    		case 3:
    			this.title = "Grand Adventure is not available yet !";
    			break;
    	}
    }
	
}
