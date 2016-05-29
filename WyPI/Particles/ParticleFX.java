package WyPI.Particles;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import org.lwjgl.util.Color;

public class ParticleFX extends Entity
{

	private int life, particleType;
	private double gravity = 0.5;
	
	public ParticleFX(World worldIn) 
	{
		super(worldIn);
	}

	public void onUpdate()
	{
		super.onUpdate();
		
		this.life -= 1;
		this.posY -= this.gravity;
		if(this.life <= 0)
			this.setDead();
	}
	
	protected void entityInit() {}

	protected void readEntityFromNBT(NBTTagCompound tagCompund) {}

	protected void writeEntityToNBT(NBTTagCompound tagCompound) {}

}
