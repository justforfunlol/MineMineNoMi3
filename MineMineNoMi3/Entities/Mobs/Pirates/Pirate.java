package MineMineNoMi3.Entities.Mobs.Pirates;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class Pirate extends PirateData
{
	private String[] textures = {"pirate1", "pirate2", "pirate3"};
	
	public Pirate(World world) 
	{
		super(world);
		this.setTexture(textures[this.rand.nextInt(textures.length)]);
 	} 
	  
	public void applyEntityAttributes()
	{ 
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	}
	
}
