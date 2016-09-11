package WyPI.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityPart extends EntityMob
{

	private IMultiPartMob parentMob;
	
	public EntityPart(IMultiPartMob mob, World worldIn)
	{
		super(worldIn);
		this.parentMob = mob;
	}

	protected void entityInit()
	{
		super.entityInit();
	}

	public boolean canBeCollidedWith()
	{
		return true;
	}

	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		return this.isEntityInvulnerable(source) ? false : this.parentMob.attackEntityFromPart(this, source, amount);
	}

	public boolean isEntityEqual(Entity entityIn)
	{
		return this == entityIn || this.parentMob == entityIn;
	}
}
