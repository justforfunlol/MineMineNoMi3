package xyz.pixelatedw.MineMineNoMi3.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityManager;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.gui.extra.GUIButtonNoTexture;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class GUISelectHotbarAbilities extends GuiScreen
{
	protected EntityPlayer player;
	protected ExtendedEntityStats props;
	
	private RenderItem renderItem;
	private int slotSelected = -1;
	
	public GUISelectHotbarAbilities(EntityPlayer player)
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
		
		this.mc.getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);	
		for(int i = 0; i < 8; i++)
		{
            GL11.glEnable(GL11.GL_BLEND);
            if(this.slotSelected == i)
            	this.drawTexturedModalRect((posX - 200 + (i * 50)) / 2, posY - 33, 48, 0, 70, 23);
            else
            	this.drawTexturedModalRect((posX - 200 + (i * 50)) / 2, posY - 33, 0, 0, 23, 23);
		} 
	       
		for(int i = 0; i < 8; i++)
		{
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            if(props.getAbilityFromSlot(i) != null)
            	WyRenderHelper.drawAbilityIcon(props.getAbilityFromSlot(i).getAttribute().getAttributeName(), (posX - 192 + (i * 50)) / 2, posY - 29, 16, 16);	           
        }
		
		GL11.glDisable(GL11.GL_BLEND);
		
		super.drawScreen(x, y, f);
	}
	
	public void initGui()
	{
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		
		int posX = sr.getScaledWidth();
		int posY = sr.getScaledHeight();
		
		for(int i = 0; i < 8; i++)
		{
            GL11.glEnable(GL11.GL_BLEND);
			this.buttonList.add(new GUIButtonNoTexture(i, (posX - 196 + (i * 50)) / 2, posY - 31, 21, 21, ""));
		}
		
		for(int i = 0; i < props.getDevilFruitAbilities().size(); i++)
		{
			if( i % 2 == 0)
				this.buttonList.add(new GuiButton(100 + i, posX - 325, (posY - 180 + (i * 35)) / 2, 100, 20, AbilityManager.instance().getAbilityByName(props.getDevilFruitAbilities().get(i)).getAttribute().getAttributeName() ));
			else
				this.buttonList.add(new GuiButton(100 + i, posX - 210, (posY - 215 + (i * 35)) / 2, 100, 20, AbilityManager.instance().getAbilityByName(props.getDevilFruitAbilities().get(i)).getAttribute().getAttributeName() ));
		}
	}
	
	
	public void actionPerformed(GuiButton button)
	{
		if(button.id >= 0 && button.id <= 7)
		{
			slotSelected = button.id;
		}
		if(button.id >= 100)
		{
			if(this.slotSelected != -1)
			{
				props.setAbilityInSlot(this.slotSelected, AbilityManager.instance().getAbilityByName(WyHelper.getFancyName(button.displayString)));
			}
			else
			{

			}
		}
		
		WyNetworkHelper.sendToServer(new PacketSync(props));
	}
	
	public boolean doesGuiPauseGame()
	{
		return false;
	}

    private void drawItemStack(ItemStack itemStack, int x, int y, String string)
    {
        GL11.glTranslatef(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        itemRender.zLevel = 200.0F;
        FontRenderer font = null;
        if (itemStack != null) font = itemStack.getItem().getFontRenderer(itemStack);
        if (font == null) font = fontRendererObj;
        itemRender.renderItemAndEffectIntoGUI(font, this.mc.getTextureManager(), itemStack, x, y);
        itemRender.renderItemOverlayIntoGUI(font, this.mc.getTextureManager(), itemStack, x, y - 0, string);
        this.zLevel = 0.0F;
        itemRender.zLevel = 0.0F;
    }

}
