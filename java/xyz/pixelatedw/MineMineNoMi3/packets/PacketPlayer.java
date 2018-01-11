package xyz.pixelatedw.MineMineNoMi3.packets;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.network.WyNetworkHelper;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.items.CharacterCreator;

public class PacketPlayer implements IMessage
{
	private String cmd;
	private double mX, mY, mZ;
	
	public PacketPlayer() {}
	
	public PacketPlayer(String cmd) 
	{
		this.cmd = cmd;
	}
	
	public PacketPlayer(String cmd, double mX, double mY, double mZ) 
	{
		this.cmd = cmd;		
		this.mX = mX;
		this.mY = mY;
		this.mZ = mZ;
	}
	
	public void fromBytes(ByteBuf buf) 
	{
		this.cmd = ByteBufUtils.readUTF8String(buf);
		this.mX = buf.readDouble();
		this.mY = buf.readDouble();
		this.mZ = buf.readDouble();
	}

	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeUTF8String(buf, this.cmd);
		buf.writeDouble(this.mX);
		buf.writeDouble(this.mY);
		buf.writeDouble(this.mZ);
	}

	public static class ClientHandler implements IMessageHandler<PacketPlayer, IMessage>
	{
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketPlayer message, MessageContext ctx) 
		{
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			ExtendedEntityStats props = ExtendedEntityStats.get(player);
			
			if(message.cmd.contains("motion+"))
			{
				player.motionX += message.mX;
				player.motionY += message.mY;
				player.motionZ += message.mZ;			
			}
			if(message.cmd.contains("motion-"))
			{
				player.motionX -= message.mX;
				player.motionY -= message.mY;
				player.motionZ -= message.mZ;			
			}
			if(message.cmd.contains("motion="))
			{
				player.motionX = message.mX;
				player.motionY = message.mY;
				player.motionZ = message.mZ;						
			}
			if(message.cmd.contains("motion*"))
			{
				player.motionX *= message.mX;
				player.motionY *= message.mY;
				player.motionZ *= message.mZ;						
			}	
			if(message.cmd.contains("pos"))
			{
				player.setPositionAndRotation(message.mX, message.mY, message.mZ, player.rotationYaw, player.rotationPitch);
			}
			
			return null;		
		}
	}
	
	public static class ServerHandler implements IMessageHandler<PacketPlayer, IMessage>
	{
		public IMessage onMessage(PacketPlayer message, MessageContext ctx) 
		{
			EntityPlayer player = ctx.getServerHandler().playerEntity;
			ExtendedEntityStats props = ExtendedEntityStats.get(player);
	
			if(message.cmd.equals("delete_book"))
				for(ItemStack is : player.inventory.mainInventory)
					if(is != null && is.getItem() instanceof CharacterCreator)
						WyHelper.removeStackFromInventory(player, is);
			if(message.cmd.equals("forcesync"))
				WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			if(message.cmd.contains("msg"))
				WyHelper.sendMsgToPlayer(player, message.cmd.replace("msg", ""));
			if(message.cmd.equals("enterCombatMode"))
			{
				props.setCombatMode(!props.isInCombatMode());
				//WyNetworkHelper.sendTo(new PacketSync(props), (EntityPlayerMP) player);
			}
			for(int i = 0; i < 8; i++)
			{
				if(message.cmd.equals("useAbility" + i))
				{
					if(props.getAbilityFromSlot(i) != null) 
					{
						for(int j = 0; j < 8; j++)
						{
							if(props.getAbilityFromSlot(j) != null) 
							{
								if(props.getAbilityFromSlot(j).isCharging())
									return null;
								if(props.getAbilityFromSlot(i) != props.getAbilityFromSlot(j) && props.getAbilityFromSlot(j).isPassiveActive() && props.getAbilityFromSlot(i).getAttribute().isPassive())
									return null;
							}							
						}
						
						if(props.getAbilityFromSlot(i).getAttribute().isPassive())
							props.getAbilityFromSlot(i).passive(player);
						else if(props.getAbilityFromSlot(i).getAttribute().getAbilityCharges() > 0)
							props.getAbilityFromSlot(i).startCharging(player);
						else
							props.getAbilityFromSlot(i).use(player);
					}
				}
			}

			return null;
		}
	}
	
}
