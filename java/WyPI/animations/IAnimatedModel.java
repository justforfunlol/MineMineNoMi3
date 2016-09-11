package WyPI.animations;

import net.minecraft.client.model.ModelRenderer;

public interface IAnimatedModel
{

	void setAnimationFor(ModelRenderer cube, float posFrom, float posTo, int axis, int fps);
	
}
