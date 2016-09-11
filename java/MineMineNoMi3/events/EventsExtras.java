package MineMineNoMi3.events;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.lists.IDs;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EventsExtras 
{

	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event) 
	{
		EntityPlayer player = event.player;
		IEntityCapability props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		
		if (event.phase == Phase.START) 
		{	
			if(player != null && player instanceof EntityPlayer)
			{
				if((player.isInsideOfMaterial(Material.WATER) || (player.isWet() && player.worldObj.getBlockState(new BlockPos((int)player.posX, (int)player.posY - 3, (int)player.posZ)) == Blocks.WATER.getDefaultState())) && !player.capabilities.isCreativeMode)
				{
					if (!props.getUsedFruit().equals("N/A"))
						player.motionY -= 5;	

					if(props.getRace().equals(IDs.ID_RACE_FISHMAN) && props.getUsedFruit().equals("N/A"))
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
				
				if(props.isBlind())
				{
					int t = props.getBlindTime();
					
					if(t > 0)
					{
						t--;
						//WyRenderHelper.instance().drawColorOnScreen(0, 0, 0, 255, 0, 0, sr.getScaledWidth(), sr.getScaledHeight());
					}
					else
						props.setBlind(0);
				}
				
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
