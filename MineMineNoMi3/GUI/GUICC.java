package MineMineNoMi3.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.IPlayerCapability;
import MineMineNoMi3.Network.PacketDispatcher;
import MineMineNoMi3.Network.Packets.PacketPlayerSERVER;
import MineMineNoMi3.Network.Packets.PacketSyncSERVER;
import WyPI.WyPI;

@SideOnly(Side.CLIENT)
public class GUICC extends GuiScreen
{
	private ResourceLocation texture = new ResourceLocation("mineminenomi", "textures/gui/gui_blank.png");
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
		IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
    
		Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
		
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
		drawTexturedModalRect(posX, posY + 50, 0, 0, 256, 256);
		
		if(this.page == 0)
			mc.fontRendererObj.drawStringWithShadow("Choose a faction ", posX + 20, posY + 59, WyPI.Utils.hexToRGB("FFFFFF").getRGB());
		if(this.page == 1)	
			mc.fontRendererObj.drawStringWithShadow("Choose a race ", posX + 20, posY + 59, WyPI.Utils.hexToRGB("FFFFFF").getRGB());
		if(this.page == 2)	
			mc.fontRendererObj.drawStringWithShadow("Choose a job ", posX + 20, posY + 59, WyPI.Utils.hexToRGB("FFFFFF").getRGB());
		
		if(props.getFaction().equals("Pirate"))
			mc.fontRendererObj.drawStringWithShadow("Pirate", posX + 250, posY + 59, WyPI.Utils.hexToRGB("FF0000").getRGB());
		if(props.getFaction().equals("Marine"))
			mc.fontRendererObj.drawStringWithShadow("Marine", posX + 250, posY + 59, WyPI.Utils.hexToRGB("00C3FF").getRGB());
		if(props.getFaction().equals("Bounty Hunter"))
			mc.fontRendererObj.drawStringWithShadow("Bounty Hunter", posX + 250, posY + 59, WyPI.Utils.hexToRGB("09FF00").getRGB());
		
		if(props.getRace().equals("Human"))
			mc.fontRendererObj.drawStringWithShadow("Human", posX + 250, posY + 79, WyPI.Utils.hexToRGB("FFDD00").getRGB());
		if(props.getRace().equals("Cyborg"))
			mc.fontRendererObj.drawStringWithShadow("Cyborg", posX + 250, posY + 79, WyPI.Utils.hexToRGB("8400FF").getRGB());
		if(props.getRace().equals("Fishman"))
			mc.fontRendererObj.drawStringWithShadow("Fishman", posX + 250, posY + 79, WyPI.Utils.hexToRGB("4D6DFF").getRGB());
		
		if(props.getJob().equals("Swordsman"))
			mc.fontRendererObj.drawStringWithShadow("Swordsman", posX + 250, posY + 99, WyPI.Utils.hexToRGB("A7ED93").getRGB());
		if(props.getJob().equals("Medic"))
			mc.fontRendererObj.drawStringWithShadow("Medic", posX + 250, posY +99, WyPI.Utils.hexToRGB("ED93AA").getRGB());
		if(props.getJob().equals("Sniper"))
			mc.fontRendererObj.drawStringWithShadow("Sniper", posX + 250, posY + 99, WyPI.Utils.hexToRGB("FF9100").getRGB());
				
		super.drawScreen(x, y, f);
	}
	
	public void initGui()
	{
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;

		this.buttonList.add(new GuiButton(100, posX + 70, posY + 190, 40, 20, "Next >"));
		
		this.buttonList.add(new GuiButton(101, posX + 10, posY + 190, 40, 20, "< Prev"));
		
		this.buttonList.add(new GuiButton(102, posX + 42, posY + 215, 40, 20, "Finish"));
				
		if(this.page == 0)
		{
			this.buttonList.add(new GuiButton(0, posX + 10, posY + 160, 100, 20, "Marine"));
			this.buttonList.add(new GuiButton(1, posX + 10, posY + 80, 100, 20, "Pirate"));
			this.buttonList.add(new GuiButton(2, posX + 10, posY + 120, 100, 20, "Bounty Hunter"));
		}
		if(this.page == 1)
		{
			this.buttonList.add(new GuiButton(10, posX + 10, posY + 160, 100, 20, "Fishman"));
			this.buttonList.add(new GuiButton(11, posX + 10, posY + 80, 100, 20, "Human"));
			this.buttonList.add(new GuiButton(12, posX + 10, posY + 120, 100, 20, "Cyborg"));		
		}
		if(this.page == 2)
		{
			this.buttonList.add(new GuiButton(20, posX + 10, posY + 160, 100, 20, "Sniper"));
			this.buttonList.add(new GuiButton(21, posX + 10, posY + 80, 100, 20, "Swordsman"));
			this.buttonList.add(new GuiButton(22, posX + 10, posY + 120, 100, 20, "Medic"));
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
		IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
		
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
	        	PacketDispatcher.sendToServer(new PacketSyncSERVER(props));
				PacketDispatcher.sendToServer(new PacketPlayerSERVER("delete_book"));
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
