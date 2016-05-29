package MineMineNoMi3;

import MineMineNoMi3.Capability.IPlayerCapability;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;

public class EventDoriki extends EntityEvent
{
	public EntityPlayer player;
	public IPlayerCapability props;
	public int doriki;
	
	public EventDoriki(EntityPlayer entity) 
	{
		super(entity);
		this.player = entity;
		this.props = player.getCapability(Values.CAPABILITIES_PLAYER, null);
	}

}
