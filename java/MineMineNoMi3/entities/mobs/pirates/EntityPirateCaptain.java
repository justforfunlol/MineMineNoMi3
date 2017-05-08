package MineMineNoMi3.entities.mobs.pirates;

import javax.annotation.Nullable;

import MineMineNoMi3.lists.ListMisc;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityPirateCaptain extends PirateData
{ 
	private String[] textures = {"piratec1", "piratec2", "piratec3"};
	
	public EntityPirateCaptain(World world) 
	{
		super(world);
		this.setTexture(textures[this.rand.nextInt(textures.length)]);
 	} 
	  
	public void applyEntityAttributes()
	{ 
		super.applyEntityAttributes(); 
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
	}

	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	{
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ListMisc.PirateCutlass));
		
		return livingdata;
	}
}
