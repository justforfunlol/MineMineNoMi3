package MineMineNoMi3.events;

import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
