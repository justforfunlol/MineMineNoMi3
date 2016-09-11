package WyPI.mobs;

import java.util.List;

import net.minecraft.util.DamageSource;

public interface IMultiPartMob
{

	void addPart(EntityPart e);
	
	void removePart(EntityPart e);
	
	List<EntityPart> getEntityParts();
	
	boolean attackEntityFromPart(EntityPart dragonPart, DamageSource source, float damage);
	
}
