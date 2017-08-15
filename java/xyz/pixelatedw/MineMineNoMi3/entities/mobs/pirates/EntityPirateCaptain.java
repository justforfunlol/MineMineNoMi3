package xyz.pixelatedw.MineMineNoMi3.entities.mobs.pirates;

import net.minecraft.entity.SharedMonsterAttributes;
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
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
	}
/*
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	{
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ListMisc.PirateCutlass));
		
		return livingdata;
	}*/
}
