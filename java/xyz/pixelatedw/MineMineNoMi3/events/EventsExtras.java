package xyz.pixelatedw.MineMineNoMi3.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;

public class EventsExtras 
{

	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event) 
	{
		EntityPlayer player = event.player;
		ExtendedEntityStats props = ExtendedEntityStats.get(player);
		
		if (event.phase == Phase.START) 
		{	
			if(player != null && player instanceof EntityPlayer)
			{
				if((player.isInsideOfMaterial(Material.water) || (player.isWet() && player.worldObj.getBlock((int)player.posX, (int)player.posY - 3, (int)player.posZ) == Blocks.water)) && !player.capabilities.isCreativeMode)
				{
					if (!props.getUsedFruit().equals("N/A"))
						player.motionY -= 5;	

					if(props.getRace().equals(ID.RACE_FISHMAN) && props.getUsedFruit().equals("N/A"))
					{
						player.setAir(300);
						
						if ((player.motionX >= 5.0D) || (player.motionZ >= 5.0D))
						{
							player.motionX /= 1.2D;
							player.motionZ /= 1.2D;
						}
						else
						{
							player.motionX *= 1.2D;
							player.motionZ *= 1.2D;
						}
					}	
				}
				
/*				if(props.isBlind())
				{
					int t = props.getBlindTime();
					
					if(t > 0)
					{
						t--;
						//WyRenderHelper.instance().drawColorOnScreen(0, 0, 0, 255, 0, 0, sr.getScaledWidth(), sr.getScaledHeight());
					}
					else
						props.setBlind(0);
				}*/
				
				if(!player.capabilities.isCreativeMode)
				{
					/*if(Config.allowLogiaFly_actual && (props.getUsedFruit().equals("sunasuna") || props.getUsedFruit().equals("mokumoku") || props.getUsedFruit().equals("meramera")))
						player.capabilities.allowFlying = true;
					else
						player.capabilities.allowFlying = false;*/
				}
			}
		}
	}
    
}
