package xyz.pixelatedw.MineMineNoMi3.gui;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.MainMod;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyRenderHelper;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityManager;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;

@SideOnly(Side.CLIENT)
public class GUICombatMode extends Gui
{
	private Minecraft mc;
	protected static final RenderItem itemRenderer = new RenderItem();
	
	public GUICombatMode(Minecraft mc)
	{	
		this.mc = mc;
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderUI(RenderGameOverlayEvent event)
	{		
		EntityPlayer player = mc.thePlayer;
		ExtendedEntityStats props = ExtendedEntityStats.get(player);
		
		int xPos = event.resolution.getScaledWidth();
		int yPos = event.resolution.getScaledHeight();
		
		if (props.isInCombatMode() && event.type == ElementType.HOTBAR)
		{ 
			event.setCanceled(true);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			this.mc.getTextureManager().bindTexture(ID.TEXTURE_COMBATMODE);           
			
			for(int i = 0; i < 8; i++)
			{
	            GL11.glEnable(GL11.GL_BLEND);
	            if(props.getAbilityFromSlot(i) != null && props.getAbilityFromSlot(i).isOnCooldown())
	            	this.drawTexturedModalRect((xPos - 200 + (i * 50)) / 2, yPos - 23, 24, 0, 23, 23);
	            else if(props.getAbilityFromSlot(i) != null && props.getAbilityFromSlot(i).isCharging())
	            	this.drawTexturedModalRect((xPos - 200 + (i * 50)) / 2, yPos - 23, 72, 0, 23, 23);
	            else if(props.getAbilityFromSlot(i) != null && props.getAbilityFromSlot(i).isPassiveActive())
	            	this.drawTexturedModalRect((xPos - 200 + (i * 50)) / 2, yPos - 23, 48, 0, 23, 23);
	            else
	            	this.drawTexturedModalRect((xPos - 200 + (i * 50)) / 2, yPos - 23, 0, 0, 23, 23);
			}
			
			if(props.getRace().equals(ID.RACE_CYBORG))
			{
				this.drawTexturedModalRect((xPos - 260) / 2, yPos - 42, 0, 52, 23, 56);
				int barHeight = (int) ( ((float)props.getCola() / props.getMaxCola()) * 30) + 23; // 139
				
				if(barHeight > 0 && barHeight < 24) barHeight = 24;
				else if(barHeight > 52) barHeight = 52;		
				
				this.drawTexturedModalRect((xPos - 252) / 2, yPos - 42, 32, barHeight, 16, 32); //23 - 52
			
				this.drawCenteredString(this.mc.fontRenderer, props.getCola() + "",(xPos - 237) / 2, yPos - 12, Color.WHITE.getRGB());
			}
			
			for(int i = 0; i < 8; i++)
			{
	            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
	            if(props.getAbilityFromSlot(i) != null)
            		WyRenderHelper.drawAbilityIcon(WyHelper.getFancyName(props.getAbilityFromSlot(i).getAttribute().getAttributeName()), (xPos - 192 + (i * 50)) / 2, yPos - 19, 16, 16);	           
            }			
			
			GL11.glDisable(GL11.GL_BLEND);		
			
		}
	}
	
}
