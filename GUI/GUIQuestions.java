package MineMineNoMi3.GUI;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;

import org.lwjgl.opengl.GL11;

import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.IPlayerCapability;
import MineMineNoMi3.GUI.Utils.GUIButtonNoTexture;

public class GUIQuestions extends GuiScreen
{
	private EntityPlayer player;
	private int page;

	public GUIQuestions(EntityPlayer player)
	{
		this.player = player;
		this.page = 0;
	}

	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
		
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
		
		if(this.page == 0)
			mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "What's most important to you ?", posX - 30, posY + 80, -1);
		else if(this.page == 1)
			mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "What's most important to you ?", posX - 30, posY + 80, -1);
		else if(this.page == 2)
			mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "What's most important to you ?", posX - 30, posY + 80, -1);	
		
		super.drawScreen(x, y, f);
	}
	
	public void updateScreen()
	{		
		int posX = (this.width - 256) / 2; 
		int posY = (this.height - 256) / 2;
		
		if(this.page == 0)
		{
			((GuiButton)this.buttonList.get(0)).displayString = "\u2022 Being number one";
			((GuiButton)this.buttonList.get(1)).displayString = "\u2022 Friendship";
			((GuiButton)this.buttonList.get(2)).displayString = "\u2022 The Treasure";
		}
		else if(this.page == 1)
		{
			((GuiButton)this.buttonList.get(0)).displayString = "\u2022 Test2";
			((GuiButton)this.buttonList.get(1)).displayString = "\u2022 Test2";
			((GuiButton)this.buttonList.get(2)).displayString = "\u2022 Test2";
		}
		else if(this.page == 2)
		{
			((GuiButton)this.buttonList.get(0)).displayString = "\u2022 Test3";
			((GuiButton)this.buttonList.get(1)).displayString = "\u2022 Test3";
			((GuiButton)this.buttonList.get(2)).displayString = "\u2022 Test3";
		}
	}
	
	public void initGui()
	{
		int posX = (this.width - 256) / 2; 
		int posY = (this.height - 256) / 2;
		
		this.buttonList.add(new GUIButtonNoTexture(0, posX - 20, posY + 100, 100, 20, ""));
		this.buttonList.add(new GUIButtonNoTexture(1, posX - 20, posY + 120, 60, 20, ""));
		this.buttonList.add(new GUIButtonNoTexture(2, posX - 20, posY + 140, 80, 20, ""));
	}
	
	public void actionPerformed(GuiButton button)
	{
		IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);

		props.setAnswerBySlot(this.page, button.id);
		if(this.page != 2)
			this.page++;
		else
			System.out.println(props.getAnswers());
	}
	
	public boolean doesGuiPauseGame()
	{
		return false;
	}

}
