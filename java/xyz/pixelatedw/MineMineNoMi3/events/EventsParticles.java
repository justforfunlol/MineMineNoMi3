package xyz.pixelatedw.MineMineNoMi3.events;

import java.util.TimerTask;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraft.entity.player.EntityPlayer;

public class EventsParticles 
{

	private int index = 0;
	private boolean run = false;
	
	@SubscribeEvent
	public void onParticleQueue(PlayerTickEvent event)
	{
		if(event.player != null && event.phase == Phase.START)
		{
			EntityPlayer player = event.player;
			
/*			if(run)
			{
				if(index < 2000)
				{
					index++;
					if(index % 100 == 0)
					{
						System.out.println(index);
					}
				}
			}*/
			
		}
	}
	
}
