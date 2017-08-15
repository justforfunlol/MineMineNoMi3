package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.GuiOpenEvent;

public class EventsMenus 
{
/*
	@SubscribeEvent
	public void onGUIOpen(GuiOpenEvent event)
	{  
		//if(event.getGui() instanceof GuiWorldSelection && Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu)
		//	event.setGui(new GUIGameModeSelect());
	}
	*/
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(GuiOpenEvent event)
	{

	}
}
