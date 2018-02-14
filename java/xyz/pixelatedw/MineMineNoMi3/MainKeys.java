package xyz.pixelatedw.MineMineNoMi3;

import org.apache.commons.codec.language.bm.Lang;
import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.InputEvent.MouseInputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.packets.PacketPlayer;

public class MainKeys 
{

	public static KeyBinding guiPlayer, enterCombatMode;
	
	public static void init() 
	{		
		guiPlayer = new KeyBinding(ID.LANG_KEY_PLAYER, Keyboard.KEY_R, ID.LANG_KEYS_CATEGORY);
		ClientRegistry.registerKeyBinding(guiPlayer);
		
		enterCombatMode = new KeyBinding(ID.LANG_KEY_COMBATMODE, Keyboard.KEY_LMENU, ID.LANG_KEYS_CATEGORY);
		ClientRegistry.registerKeyBinding(enterCombatMode);
	}
	    
	public static boolean isShiftKeyDown()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);		
	}
	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) 
	{		
    	Minecraft minecraft = Minecraft.getMinecraft();
    	EntityPlayer player = minecraft.thePlayer; 
    	WorldClient world = minecraft.theWorld;  
    	ExtendedEntityStats props = ExtendedEntityStats.get(player);
    	
		if(guiPlayer.isPressed())
		{
        	player.openGui(MainMod.getMineMineNoMi(), 1, world, (int)player.posX, (int)player.posY, (int)player.posZ);
        	
        	WyNetworkHelper.sendToServer(new PacketPlayer("forcesync"));
		}
		
		if(enterCombatMode.isPressed()) 
		{
			props.setCombatMode(!props.isInCombatMode());
        	WyNetworkHelper.sendToServer(new PacketPlayer("enterCombatMode"));
		}
			
		for(int i = 0; i < 8; i++)
		{
			if(Minecraft.getMinecraft().gameSettings.keyBindsHotbar[i].isPressed())
			{
	        	if(props.isInCombatMode())
	        		WyNetworkHelper.sendToServer(new PacketPlayer("useAbility" + i));
	        	else
	        		player.inventory.currentItem = i;
			}
		}
	}
	
	@SubscribeEvent
	public void onMoseInput(MouseInputEvent event)
	{
		Minecraft minecraft = Minecraft.getMinecraft();
		EntityPlayer player = minecraft.thePlayer; 
		ExtendedEntityStats props = ExtendedEntityStats.get(player);
	}
	
}
