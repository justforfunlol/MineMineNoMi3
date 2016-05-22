package MineMineNoMi3.Entities.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import MineMineNoMi3.Entities.Mobs.Models.ModelMarine;

public class IRenderFactoryBasic<T extends Entity> implements IRenderFactory
{
    public Render<? super T> createRenderFor(RenderManager manager)  
    {
		return new RenderMobType(new ModelMarine());	
    }

}
