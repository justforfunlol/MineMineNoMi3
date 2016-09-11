package MineMineNoMi3.events.entityevents;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;

public class DorikiEvent extends EntityEvent
{
	public EntityPlayer player;
	public IEntityCapability props;
	public int doriki;
	
	public DorikiEvent(EntityPlayer entity) 
	{
		super(entity);
		this.player = entity;
		this.props = player.getCapability(Values.ENTITY_CAPABILITIES, null);
	}

}
