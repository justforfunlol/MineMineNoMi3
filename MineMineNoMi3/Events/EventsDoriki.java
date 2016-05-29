package MineMineNoMi3.Events;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import MineMineNoMi3.EventDoriki;
import MineMineNoMi3.Values;
import MineMineNoMi3.Capability.IPlayerCapability;
import MineMineNoMi3.Entities.Mobs.Marines.MarineData;
import MineMineNoMi3.Lists.ListAbilities;
import MineMineNoMi3.Network.PacketDispatcher;
import MineMineNoMi3.Network.Packets.PacketSyncCLIENT;
import MineMineNoMi3.Network.Packets.PacketSyncSERVER;

public class EventsDoriki 
{
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		if (event.getEntityLiving() instanceof EntityPlayer)
		{	
			EntityPlayer player = (EntityPlayer)event.getEntityLiving();
			IPlayerCapability capability = player.getCapability(Values.CAPABILITIES_PLAYER, null);
			/*int extraHP = (int)Math.pow(Math.log(props.getDoriki()+1), 3)/2;

			if(extraHP < 20)
				player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
			else
				player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(extraHP);*/
		}
	}
	
	@SubscribeEvent
	public void onPlayerDeath(LivingAttackEvent event)
	{
		if(event.getEntityLiving() instanceof EntityPlayer && event.getEntityLiving().getHealth() - event.getAmount() <= 0)
		{
			EntityPlayer player = (EntityPlayer)event.getEntityLiving();
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);			
		}
	}
	
	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event)
	{
	    if(event.getSource().getEntity() instanceof EntityPlayer)
	    { 
			EntityPlayer player = (EntityPlayer)event.getSource().getEntity();
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
			EntityLivingBase target = event.getEntityLiving();
			
			IAttributeInstance attrAtk = target.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE);
			IAttributeInstance attrHP = target.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.MAX_HEALTH);
			
			if(attrAtk != null && attrHP != null)
			{ 
				double i = attrAtk.getAttributeValue();
				double j = attrHP.getAttributeValue();
				int rng = player.worldObj.rand.nextInt(3)+1;
				int haki_rng = player.worldObj.rand.nextInt(199)+1;
				
				if(target instanceof EntityPlayer)
				{
					IPlayerCapability targetprops = player.getCapability(Values.CAPABILITIES_PLAYER, null);
					
					if(props.getDoriki() < Values.MAX_DORIKI)
						props.addDoriki((targetprops.getDoriki()/3) + rng);
					if(props.getBelly() < Values.MAX_GENERAL)
						props.addBelly(targetprops.getBelly());
					if( ( props.getFaction().equals("Pirate") || props.getFaction().equals("Revolutionary") ) && targetprops.getFaction().equals("Pirate"))
						if(props.getBounty() < Values.MAX_GENERAL)
							props.addBounty(targetprops.getBounty()/2);
				} 
				else
				{
					if(props.getFaction().equals("Marine") && target instanceof MarineData)
						return;
					
					if((int)Math.round(((i + j)/10)/Math.PI) + rng > 0)
						if(props.getDoriki() < Values.MAX_DORIKI)
						{
							props.addDoriki((int)Math.round(((i + j)/10)/Math.PI) + rng);
							EventDoriki e = new EventDoriki(player);
							if (MinecraftForge.EVENT_BUS.post(e)) return;
						}
					if( props.getFaction().equals("Pirate") || props.getFaction().equals("Revolutionary") )
						if((int)Math.round((i + j)/10) + rng > 0)
							if(props.getBounty() < Values.MAX_GENERAL)
								props.addBounty((int)Math.round(((i + j)/10)/Math.PI));
				}
				
				PacketDispatcher.sendTo(new PacketSyncCLIENT(props), (EntityPlayerMP)player);
			}
	    }
	}
	
	private void ability(EntityPlayer player, int doriki, Item ability)
	{
		IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
		if(props.getDoriki() >= doriki && !player.inventory.hasItemStack(new ItemStack(ability)))
			player.inventory.addItemStackToInventory(new ItemStack(ability));	
		if(props.getDoriki() < doriki && player.inventory.hasItemStack(new ItemStack(ability)))
			player.inventory.deleteStack(new ItemStack(ability));
	}
	  
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if(event.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.getEntity();
			IPlayerCapability props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
			
			if(!player.worldObj.isRemote)
				for(int i = 0; i < player.getServer().worldServers.length; i++)
					PacketDispatcher.sendToDimension(new PacketSyncSERVER(props), i);
		}
	}
	
	@SubscribeEvent
	public void onDorikiGained(EventDoriki event)
	{
		if(event.props.getRace().equals("Human"))
		{
			ability(event.player, 500, ListAbilities.SORU);
			ability(event.player, 1500, ListAbilities.TEKKAI);
			ability(event.player, 3000, ListAbilities.SHIGAN);
			ability(event.player, 4500, ListAbilities.GEPPO);
			ability(event.player, 6000, ListAbilities.KAMIE);
			ability(event.player, 8500, ListAbilities.RANKYAKU);
		}
		else if(event.props.getRace().equals("Fishman"))
		{
			ability(event.player, 500, ListAbilities.UCHIMIZU);
			ability(event.player, 1500, ListAbilities.YARINAMI);
			ability(event.player, 3000, ListAbilities.SAMEHADASHOTEI);
			ability(event.player, 4500, ListAbilities.SOSHARK);
			ability(event.player, 6000, ListAbilities.MURASAME);
			ability(event.player, 8500, ListAbilities.KARAKUSAGAWARASEIKEN);			
		}
		else if(event.props.getRace().equals("Cyborg"))
		{
			
		}
	}
	
}
