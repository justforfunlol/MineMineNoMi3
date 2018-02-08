package xyz.pixelatedw.MineMineNoMi3.gui;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainConfig;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityManager;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.gui.extra.GUIButtonNoTexture;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketSync;

public class GUISelectHotbarAbilities extends GuiScreen
{
	protected EntityPlayer player;
	protected ExtendedEntityStats props;
	
	private RenderItem renderItem;
	private int slotSelected = -1;
	private int menuSelected = 0;
	
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
	
        GL11.glEnable(GL11.GL_BLEND);		
        
		for(int i = 0; i < 8; i++)
		{
            if(this.slotSelected == i)
            	this.drawTexturedModalRect((posX - 200 + (i * 50)) / 2, posY - 33, 48, 0, 23, 23);
            else
            	this.drawTexturedModalRect((posX - 200 + (i * 50)) / 2, posY - 33, 0, 0, 23, 23);
		} 		
		
		for(int i = 0; i < 8; i++)
		{
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            if(props.getAbilityFromSlot(i) != null)
            	WyRenderHelper.drawAbilityIcon(WyHelper.getFancyName(props.getAbilityFromSlot(i).getAttribute().getAttributeName()), (posX - 192 + (i * 50)) / 2, posY - 29, 16, 16);         
        }
		this.mc.getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);	
		
		if(props.getUsedFruit() != null && !props.getUsedFruit().toLowerCase().equals("n/a"))
		{
			this.drawTexturedModalRect((posX - 280) / 2, posY - 220, 0, 23, 27, 26);
			WyRenderHelper.drawAbilityIcon(props.getUsedFruit() + "nomi", (posX - 268) / 2, posY - 214, 16, 16);
			this.mc.getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);	
		}
		if(props.getRacialAbilities()[0] != null && !props.getRacialAbilities()[0].equals("n/a"))
		{
			this.drawTexturedModalRect((posX - 280) / 2, posY - 190, 0, 23, 27, 26);
			WyRenderHelper.drawAbilityIcon(props.getRacialAbilities()[0], (posX - 268) / 2, posY - 184, 16, 16);	
			this.mc.getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);	
		}
		if(props.getHakiAbilities()[0] != null && !props.getHakiAbilities()[0].equals("n/a"))
		{
			this.drawTexturedModalRect((posX - 280) / 2, posY - 160, 0, 23, 27, 26);
			WyRenderHelper.drawAbilityIcon(props.getHakiAbilities()[0], (posX - 268) / 2, posY - 154, 16, 16);	
			this.mc.getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);	
		}
		
		GL11.glDisable(GL11.GL_BLEND);		
		
		super.drawScreen(x, y, f);
	}
	
	public void initGui()
	{
		ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		
		int posX = sr.getScaledWidth();
		int posY = sr.getScaledHeight();

		//if(MainConfig.devilFruitAbilitiesSystem == 0 || MainConfig.devilFruitAbilitiesSystem == 1)
		//	this.buttonList.add(new GuiButton(-1, (posX + 250) / 2, posY - 220, 80, 20, "Edit Abilities"));
		
		if(props.getUsedFruit() != null && !props.getUsedFruit().toLowerCase().equals("n/a"))
			this.buttonList.add(new GUIButtonNoTexture(10, (posX - 280) / 2, posY - 220, 27, 25, ""));
		if(props.getRacialAbilities()[0] != null && !props.getRacialAbilities()[0].equals("n/a"))
			this.buttonList.add(new GUIButtonNoTexture(11, (posX - 280) / 2, posY - 190, 27, 25, ""));
		if(props.getHakiAbilities()[0] != null && !props.getHakiAbilities()[0].equals("n/a"))
			this.buttonList.add(new GUIButtonNoTexture(12, (posX - 280) / 2, posY - 160, 27, 25, ""));
		
		for(int i = 0; i < 8; i++)
		{
            GL11.glEnable(GL11.GL_BLEND);
			this.buttonList.add(new GUIButtonNoTexture(i, (posX - 196 + (i * 50)) / 2, posY - 31, 21, 21, ""));
		}
		
		for(int i = 0; i < props.getDevilFruitAbilities().length - 1; i++)
		{
			if(AbilityManager.instance().getAbilityByName(props.getDevilFruitAbilities()[i]) != null)
			{
				if( i % 2 == 0)
					this.buttonList.add(new GuiButton(100 + i, posX - 325, (posY - 180 + (i * 35)) / 2, 100, 20, AbilityManager.instance().getAbilityByName(props.getDevilFruitAbilities()[i]).getAttribute().getAttributeName() ));
				else
					this.buttonList.add(new GuiButton(100 + i, posX - 210, (posY - 215 + (i * 35)) / 2, 100, 20, AbilityManager.instance().getAbilityByName(props.getDevilFruitAbilities()[i]).getAttribute().getAttributeName() ));
			}
		}
		
		for(int i = 0; i < props.getRacialAbilities().length - 1; i++)
		{		
			if(AbilityManager.instance().getAbilityByName(props.getRacialAbilities()[i]) != null)
			{	
				if( i % 2 == 0)
					this.buttonList.add(new GuiButton(150 + i, posX - 325, (posY - 180 + (i * 35)) / 2, 100, 20, AbilityManager.instance().getAbilityByName(props.getRacialAbilities()[i]).getAttribute().getAttributeName() ));
				else
					this.buttonList.add(new GuiButton(150 + i, posX - 210, (posY - 215 + (i * 35)) / 2, 100, 20, AbilityManager.instance().getAbilityByName(props.getRacialAbilities()[i]).getAttribute().getAttributeName() ));
			}
		}
		
		for(int i = 0; i < props.getHakiAbilities().length - 1; i++)
		{
			if(AbilityManager.instance().getAbilityByName(props.getHakiAbilities()[i]) != null)
			{
				if( i % 2 == 0)
					this.buttonList.add(new GuiButton(190 + i, posX - 325, (posY - 180 + (i * 35)) / 2, 100, 20, AbilityManager.instance().getAbilityByName(props.getHakiAbilities()[i]).getAttribute().getAttributeName() ));
				else
					this.buttonList.add(new GuiButton(190 + i, posX - 210, (posY - 215 + (i * 35)) / 2, 100, 20, AbilityManager.instance().getAbilityByName(props.getHakiAbilities()[i]).getAttribute().getAttributeName() ));
			}
		}
		
		updateScreen();
	}
	
	public void updateScreen()
	{
		for(Object button : this.buttonList)
		{
			if(button instanceof GuiButton)
			{
				if( ((GuiButton) button).id >= 100 && ((GuiButton) button).id < 200 )
				{
					((GuiButton) button).visible = false;
				}
			}
		}
		
		if(this.menuSelected == 0)
		{		
			for(Object button : this.buttonList)
			{
				if(button instanceof GuiButton)
				{
					if( ((GuiButton) button).id >= 100 && ((GuiButton) button).id < 150)
					{
						((GuiButton) button).visible = true;
					}
				}
			}
		}
		
		if(this.menuSelected == 1)
		{		
			for(Object button : this.buttonList)
			{
				if(button instanceof GuiButton)
				{
					if( ((GuiButton) button).id >= 150 && ((GuiButton) button).id < 190)
					{
						((GuiButton) button).visible = true;
					}
				}
			}
		}
		
		if(this.menuSelected == 2)
		{		
			for(Object button : this.buttonList)
			{
				if(button instanceof GuiButton)
				{
					if( ((GuiButton) button).id >= 190 && ((GuiButton) button).id < 200)
					{
						((GuiButton) button).visible = true;
					}
				}
			}
		}
	}
	
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton)
    {
    	if(mouseButton == 1)
    	{
            for (int l = 0; l < this.buttonList.size(); ++l)
            {
                GuiButton guibutton = (GuiButton)this.buttonList.get(l);
                
                if(guibutton.id >= 100 && this.slotSelected != -1)
                {
                	//props.getAbilityFromSlot(this.slotSelected).setSlotId(-1);
                	props.setAbilityInSlot(this.slotSelected, null);
                }
            }
    	}
    	super.mouseClicked(mouseX, mouseY, mouseButton);
    }
	
	public void actionPerformed(GuiButton button)
	{
		if(button.id >= 10 && button.id <= 20)
		{
			this.menuSelected = button.id % 10;
			this.updateScreen();
		}
		if(button.id >= 0 && button.id <= 7)
		{
			if(this.slotSelected != button.id)
				slotSelected = button.id;
			else
				slotSelected = -1;
		}
		if(button.id >= 100)
		{
			if(this.slotSelected != -1)
			{				
				props.setAbilityInSlot(this.slotSelected, AbilityManager.instance().getAbilityByName(WyHelper.getFancyName(button.displayString)));
            	//props.getAbilityFromSlot(this.slotSelected).setSlotId(this.slotSelected);
			}
			else
			{
				
			}
		}
	}
	
	public void onGuiClosed()
	{
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
