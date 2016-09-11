package MineMineNoMi3.gui;

import org.lwjgl.opengl.GL11;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.items.AkumaNoMi;
import MineMineNoMi3.lists.IDs;
import WyPI.WyPI;
import WyPI.modules.WyHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUIAbilities extends GuiScreen
{
	private EntityPlayer player;
	private AkumaNoMi akumaNoMi;
	
	public GUIAbilities(EntityPlayer player)
	{
		this.player = player;
		this.akumaNoMi = (AkumaNoMi) player.inventory.getCurrentItem().getItem();
		this.akumaNoMi.ability1 = null;
		this.akumaNoMi.ability2 = null;
		this.akumaNoMi.ability3 = null;
		this.akumaNoMi.ability4 = null;
	}
	
	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
    
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
    
		Minecraft.getMinecraft().getTextureManager().bindTexture(IDs.ID_TEXTURE_BLANK);
		
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
		drawTexturedModalRect(posX, posY + 50, 0, 0, 256, 256);
		
		GL11.glPushMatrix();
		GL11.glColor3d(255, 0, 0);
		
		GL11.glPopMatrix();
		
		super.drawScreen(x, y, f);
	}
	
	public void initGui()
	{
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;
		
		for(int i = 0; i < this.akumaNoMi.abilities.length; i++)
		{
			this.buttonList.add(new GuiButton(i, posX + 70, posY + 60 + (25 * i), 100, 20, this.akumaNoMi.abilities[i].getItemStackDisplayName(new ItemStack(this.akumaNoMi.abilities[i]))));	
			((GuiButton)this.buttonList.get(i)).packedFGColour = WyHelper.instance().hexToRGB("FF0000").getRGB();
		}
		
		this.buttonList.add(new GuiButton(100, posX + 200, posY + 60, 40, 20, "Reset"));
		this.buttonList.add(new GuiButton(101, posX + 200, posY + 85, 40, 20, "Finish"));
	}
	
	public void actionPerformed(GuiButton button)
	{
		IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
		
		switch (button.id)
		{
		case 101:
			this.mc.displayGuiScreen((GuiScreen)null);
			break;
		case 100:
			this.akumaNoMi.ability1 = null;
			this.akumaNoMi.ability2 = null;
			this.akumaNoMi.ability3 = null;
			this.akumaNoMi.ability4 = null;
			for(int i = 0; i < this.buttonList.size(); i++)
				if(((GuiButton)this.buttonList.get(i)).id != 100 && ((GuiButton)this.buttonList.get(i)).id != 101)
					((GuiButton)this.buttonList.get(i)).packedFGColour = WyHelper.instance().hexToRGB("FF0000").getRGB();
			break;
		case 0:
			if(button.packedFGColour == WyHelper.instance().hexToRGB("FF0000").getRGB() && (this.akumaNoMi.ability1 == null || this.akumaNoMi.ability2 == null || this.akumaNoMi.ability3 == null || this.akumaNoMi.ability4 == null ))
	 		{
				button.packedFGColour = WyHelper.instance().hexToRGB("15FF00").getRGB();
				if(this.akumaNoMi.ability1 == null)
					this.akumaNoMi.ability1 = this.akumaNoMi.abilities[0];
				else if(this.akumaNoMi.ability2 == null)
					this.akumaNoMi.ability2 = this.akumaNoMi.abilities[0];
				else if(this.akumaNoMi.ability3 == null)
					this.akumaNoMi.ability3 = this.akumaNoMi.abilities[0];
				else if(this.akumaNoMi.ability4 == null)
					this.akumaNoMi.ability4 = this.akumaNoMi.abilities[0];
			}
			else
			{
				button.packedFGColour = WyHelper.instance().hexToRGB("FF0000").getRGB();
				if(this.akumaNoMi.ability1 != null && this.akumaNoMi.ability1.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability1)).equals(button.displayString))
					this.akumaNoMi.ability1 = null;
				if(this.akumaNoMi.ability2 != null && this.akumaNoMi.ability2.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability2)).equals(button.displayString))
					this.akumaNoMi.ability2 = null;
				if(this.akumaNoMi.ability3 != null && this.akumaNoMi.ability3.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability3)).equals(button.displayString))
					this.akumaNoMi.ability3 = null;
				if(this.akumaNoMi.ability4 != null && this.akumaNoMi.ability4.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability4)).equals(button.displayString))
					this.akumaNoMi.ability4 = null;
			}
			break;
			
			
		case 1:
			if(button.packedFGColour == WyHelper.instance().hexToRGB("FF0000").getRGB() && (this.akumaNoMi.ability1 == null || this.akumaNoMi.ability2 == null || this.akumaNoMi.ability3 == null || this.akumaNoMi.ability4 == null ))
	 		{
				button.packedFGColour = WyHelper.instance().hexToRGB("15FF00").getRGB();
				if(this.akumaNoMi.ability1 == null)
					this.akumaNoMi.ability1 = this.akumaNoMi.abilities[1];
				else if(this.akumaNoMi.ability2 == null)
					this.akumaNoMi.ability2 = this.akumaNoMi.abilities[1];
				else if(this.akumaNoMi.ability3 == null)
					this.akumaNoMi.ability3 = this.akumaNoMi.abilities[1];
				else if(this.akumaNoMi.ability4 == null)
					this.akumaNoMi.ability4 = this.akumaNoMi.abilities[1];
			}
			else
			{
				button.packedFGColour = WyHelper.instance().hexToRGB("FF0000").getRGB();
				if(this.akumaNoMi.ability1 != null && this.akumaNoMi.ability1.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability1)).equals(button.displayString))
					this.akumaNoMi.ability1 = null;
				if(this.akumaNoMi.ability2 != null && this.akumaNoMi.ability2.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability2)).equals(button.displayString))
					this.akumaNoMi.ability2 = null;
				if(this.akumaNoMi.ability3 != null && this.akumaNoMi.ability3.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability3)).equals(button.displayString))
					this.akumaNoMi.ability3 = null;
				if(this.akumaNoMi.ability4 != null && this.akumaNoMi.ability4.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability4)).equals(button.displayString))
					this.akumaNoMi.ability4 = null;
			}
			break;
			
		case 2:
			if(button.packedFGColour == WyHelper.instance().hexToRGB("FF0000").getRGB() && (this.akumaNoMi.ability1 == null || this.akumaNoMi.ability2 == null || this.akumaNoMi.ability3 == null || this.akumaNoMi.ability4 == null ))
	 		{
				button.packedFGColour = WyHelper.instance().hexToRGB("15FF00").getRGB();
				if(this.akumaNoMi.ability1 == null)
					this.akumaNoMi.ability1 = this.akumaNoMi.abilities[2];
				else if(this.akumaNoMi.ability2 == null)
					this.akumaNoMi.ability2 = this.akumaNoMi.abilities[2];
				else if(this.akumaNoMi.ability3 == null)
					this.akumaNoMi.ability3 = this.akumaNoMi.abilities[2];
				else if(this.akumaNoMi.ability4 == null)
					this.akumaNoMi.ability4 = this.akumaNoMi.abilities[2];
			}
			else
			{
				button.packedFGColour = WyHelper.instance().hexToRGB("FF0000").getRGB();
				if(this.akumaNoMi.ability1 != null && this.akumaNoMi.ability1.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability1)).equals(button.displayString))
					this.akumaNoMi.ability1 = null;
				if(this.akumaNoMi.ability2 != null && this.akumaNoMi.ability2.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability2)).equals(button.displayString))
					this.akumaNoMi.ability2 = null;
				if(this.akumaNoMi.ability3 != null && this.akumaNoMi.ability3.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability3)).equals(button.displayString))
					this.akumaNoMi.ability3 = null;
				if(this.akumaNoMi.ability4 != null && this.akumaNoMi.ability4.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability4)).equals(button.displayString))
					this.akumaNoMi.ability4 = null;
			}
			break;
			
		case 3:
			if(button.packedFGColour == WyHelper.instance().hexToRGB("FF0000").getRGB() && (this.akumaNoMi.ability1 == null || this.akumaNoMi.ability2 == null || this.akumaNoMi.ability3 == null || this.akumaNoMi.ability4 == null ))
	 		{
				button.packedFGColour = WyHelper.instance().hexToRGB("15FF00").getRGB();
				if(this.akumaNoMi.ability1 == null)
					this.akumaNoMi.ability1 = this.akumaNoMi.abilities[3];
				else if(this.akumaNoMi.ability2 == null)
					this.akumaNoMi.ability2 = this.akumaNoMi.abilities[3];
				else if(this.akumaNoMi.ability3 == null)
					this.akumaNoMi.ability3 = this.akumaNoMi.abilities[3];
				else if(this.akumaNoMi.ability4 == null)
					this.akumaNoMi.ability4 = this.akumaNoMi.abilities[3];
			}
			else
			{
				button.packedFGColour = WyHelper.instance().hexToRGB("FF0000").getRGB();
				if(this.akumaNoMi.ability1 != null && this.akumaNoMi.ability1.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability1)).equals(button.displayString))
					this.akumaNoMi.ability1 = null;
				if(this.akumaNoMi.ability2 != null && this.akumaNoMi.ability2.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability2)).equals(button.displayString))
					this.akumaNoMi.ability2 = null;
				if(this.akumaNoMi.ability3 != null && this.akumaNoMi.ability3.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability3)).equals(button.displayString))
					this.akumaNoMi.ability3 = null;
				if(this.akumaNoMi.ability4 != null && this.akumaNoMi.ability4.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability4)).equals(button.displayString))
					this.akumaNoMi.ability4 = null;
			}
			break;
			
		case 4:
			if(button.packedFGColour == WyHelper.instance().hexToRGB("FF0000").getRGB() && (this.akumaNoMi.ability1 == null || this.akumaNoMi.ability2 == null || this.akumaNoMi.ability3 == null || this.akumaNoMi.ability4 == null ))
	 		{
				button.packedFGColour = WyHelper.instance().hexToRGB("15FF00").getRGB();
				if(this.akumaNoMi.ability1 == null)
					this.akumaNoMi.ability1 = this.akumaNoMi.abilities[4];
				else if(this.akumaNoMi.ability2 == null)
					this.akumaNoMi.ability2 = this.akumaNoMi.abilities[4];
				else if(this.akumaNoMi.ability3 == null)
					this.akumaNoMi.ability3 = this.akumaNoMi.abilities[4];
				else if(this.akumaNoMi.ability4 == null)
					this.akumaNoMi.ability4 = this.akumaNoMi.abilities[4];
			}
			else
			{
				button.packedFGColour = WyHelper.instance().hexToRGB("FF0000").getRGB();
				if(this.akumaNoMi.ability1 != null && this.akumaNoMi.ability1.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability1)).equals(button.displayString))
					this.akumaNoMi.ability1 = null;
				if(this.akumaNoMi.ability2 != null && this.akumaNoMi.ability2.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability2)).equals(button.displayString))
					this.akumaNoMi.ability2 = null;
				if(this.akumaNoMi.ability3 != null && this.akumaNoMi.ability3.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability3)).equals(button.displayString))
					this.akumaNoMi.ability3 = null;
				if(this.akumaNoMi.ability4 != null && this.akumaNoMi.ability4.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability4)).equals(button.displayString))
					this.akumaNoMi.ability4 = null;
			}
			break;
			
		case 5:
			if(button.packedFGColour == WyHelper.instance().hexToRGB("FF0000").getRGB() && (this.akumaNoMi.ability1 == null || this.akumaNoMi.ability2 == null || this.akumaNoMi.ability3 == null || this.akumaNoMi.ability4 == null ))
	 		{
				button.packedFGColour = WyHelper.instance().hexToRGB("15FF00").getRGB();
				if(this.akumaNoMi.ability1 == null)
					this.akumaNoMi.ability1 = this.akumaNoMi.abilities[5];
				else if(this.akumaNoMi.ability2 == null)
					this.akumaNoMi.ability2 = this.akumaNoMi.abilities[5];
				else if(this.akumaNoMi.ability3 == null)
					this.akumaNoMi.ability3 = this.akumaNoMi.abilities[5];
				else if(this.akumaNoMi.ability4 == null)
					this.akumaNoMi.ability4 = this.akumaNoMi.abilities[5];
			}
			else
			{
				button.packedFGColour = WyHelper.instance().hexToRGB("FF0000").getRGB();
				if(this.akumaNoMi.ability1 != null && this.akumaNoMi.ability1.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability1)).equals(button.displayString))
					this.akumaNoMi.ability1 = null;
				if(this.akumaNoMi.ability2 != null && this.akumaNoMi.ability2.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability2)).equals(button.displayString))
					this.akumaNoMi.ability2 = null;
				if(this.akumaNoMi.ability3 != null && this.akumaNoMi.ability3.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability3)).equals(button.displayString))
					this.akumaNoMi.ability3 = null;
				if(this.akumaNoMi.ability4 != null && this.akumaNoMi.ability4.getItemStackDisplayName(new ItemStack(this.akumaNoMi.ability4)).equals(button.displayString))
					this.akumaNoMi.ability4 = null;
			}
			break;
		}
	}
	
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
