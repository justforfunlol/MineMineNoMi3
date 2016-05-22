package MineMineNoMi3.Events;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.IPlayerCapability;

public class EventTicks 
{
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event) 
	{
		EntityPlayer player = event.player;
		IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
		
		if (event.phase == Phase.START) 
		{	
			if(player != null && player instanceof EntityPlayer)
			{
				if((player.isInsideOfMaterial(Material.WATER) || (player.isWet() && player.worldObj.getBlockState(new BlockPos((int)player.posX, (int)player.posY - 3, (int)player.posZ)) == Blocks.WATER.getDefaultState())) && !player.capabilities.isCreativeMode)
				{
					if (!props.getUsedFruit().equals("N/A"))
						player.motionY -= 5;	

					if(props.getRace().equals("Fishman") && props.getUsedFruit().equals("N/A"))
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
