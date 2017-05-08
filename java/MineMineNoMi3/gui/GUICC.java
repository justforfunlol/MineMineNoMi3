package MineMineNoMi3.gui;

import org.lwjgl.opengl.GL11;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.gui.extra.GUIButtonNoTexture;
import MineMineNoMi3.lists.ID;
import MineMineNoMi3.packets.PacketPlayer;
import MineMineNoMi3.packets.PacketSync;
import WyPI.modules.WyHelper;
import WyPI.modules.WyNetworkHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUICC extends GuiScreen
{
	private EntityPlayer player;
	private int page = 0;
	
	public GUICC(EntityPlayer player)
	{
		this.player = player;
	}
	
	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
    
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
    
		if(this.page == 0) Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_FACTION);
		if(this.page == 1) Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_RACE);
		if(this.page == 2) Minecraft.getMinecraft().getTextureManager().bindTexture(ID.TEXTURE_JOB);
		
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
		drawTexturedModalRect(posX, posY + 50, 0, 0, 256, 256);
		
		if(!props.getFaction().equals("N/A"))
			mc.fontRendererObj.drawStringWithShadow(props.getFaction(), posX + 250, posY + 59, WyHelper.instance().hexToRGB("FFFFFF").getRGB());
		
		if(!props.getRace().equals("N/A"))
			mc.fontRendererObj.drawStringWithShadow(props.getRace(), posX + 250, posY + 79, WyHelper.instance().hexToRGB("FFFFFF").getRGB());

		if(!props.getJob().equals("N/A"))
			mc.fontRendererObj.drawStringWithShadow(props.getJob(), posX + 250, posY + 99, WyHelper.instance().hexToRGB("FFFFFF").getRGB());
				
		super.drawScreen(x, y, f);
	}
	
	public void initGui()
	{
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;

		this.buttonList.add(new GuiButton(100, posX + 140, posY + 190, 40, 20, "Next >"));
		
		this.buttonList.add(new GuiButton(101, posX + 70, posY + 190, 40, 20, "< Prev"));
		
		this.buttonList.add(new GuiButton(102, posX + 102, posY + 215, 40, 20, "Finish"));
				
		if(this.page == 0)
		{
			this.buttonList.add(new GUIButtonNoTexture(0, posX + 130, posY + 70, 100, 50, ID.FACTION_MARINE));
			this.buttonList.add(new GUIButtonNoTexture(1, posX + 10, posY + 70, 100, 50, ID.FACTION_PIRATE));
			this.buttonList.add(new GUIButtonNoTexture(2, posX + 10, posY + 135, 100, 50, ID.FACTION_BOUNTYHUNTER));
		}
		if(this.page == 1)
		{
			this.buttonList.add(new GUIButtonNoTexture(10, posX + 130, posY + 70, 100, 50, ID.RACE_FISHMAN));
			this.buttonList.add(new GUIButtonNoTexture(11, posX + 10, posY + 70, 100, 50, ID.RACE_HUMAN));
			this.buttonList.add(new GUIButtonNoTexture(12, posX + 10, posY + 135, 100, 50, ID.RACE_CYBORG));		
		}
		if(this.page == 2)
		{
			this.buttonList.add(new GUIButtonNoTexture(20, posX + 130, posY + 135, 100, 50, ID.JOB_SNIPER));
			this.buttonList.add(new GUIButtonNoTexture(21, posX + 130, posY + 70, 100, 50, ID.JOB_SWORDSMAN));
			this.buttonList.add(new GUIButtonNoTexture(22, posX + 10, posY + 70, 100, 50, ID.JOB_DOCTOR));
		}

	}

	public void updateScreen()
	{
		if(this.page == 0)
			((GuiButton)this.buttonList.get(1)).visible = false;
		if(this.page == 2)
			((GuiButton)this.buttonList.get(0)).visible = false;
		if(this.page != 2)
			((GuiButton)this.buttonList.get(2)).visible = false;
	}
	
	public void actionPerformed(GuiButton button)
	{
		IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
		
		if(button.id >= 0 && button.id < 10)
			props.setFaction(button.displayString);	
		
		if(button.id >= 10 && button.id < 20)
			props.setRace(button.displayString);

		if(button.id >= 20 && button.id < 30)
			props.setJob(button.displayString);	
		
		switch (button.id)
		{ 
		case 102:
			if(!props.getRace().equals("N/A") && !props.getFaction().equals("N/A") && !props.getJob().equals("N/A"))
			{
				this.mc.displayGuiScreen((GuiScreen)null);
				WyNetworkHelper.instance().sendToServer(new PacketSync(props));
				WyNetworkHelper.instance().sendToServer(new PacketPlayer("delete_book"));
			}
			break;
		case 100:
			if(this.page < 2)
				this.page++;
			this.mc.displayGuiScreen((GuiScreen)this);
			break;
			
		case 101:
			if(this.page > 0)
				this.page--;
			this.mc.displayGuiScreen((GuiScreen)this);
			break;
		}
	}
	
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
