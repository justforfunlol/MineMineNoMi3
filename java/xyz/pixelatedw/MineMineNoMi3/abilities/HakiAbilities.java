package xyz.pixelatedw.MineMineNoMi3.abilities;

import java.lang.reflect.Field;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.util.JsonException;
import net.minecraft.entity.player.EntityPlayer;
import xyz.pixelatedw.MineMineNoMi3.ID;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.lists.ListAttributes;

public class HakiAbilities 
{		
	public static Ability KENBUNSHOKUHAKI = new KenbunshokuHaki();
	public static Ability BUSOSHOKUHAKI = new BusoshokuHaki();
	
	public static Ability[] abilitiesArray = new Ability[] {KENBUNSHOKUHAKI, BUSOSHOKUHAKI};
	
	public static class KenbunshokuHaki extends Ability
	{
		public KenbunshokuHaki() 
		{
			super(ListAttributes.KENBUNSHOKUHAKI); 
		}
		
		public void use(EntityPlayer player)
		{
			super.use(player);
		}
	}
	
	public static class BusoshokuHaki extends Ability
	{
		/*private ShaderGroup theShaderGroup;
		private IResourceManager resourceManager;*/
		
		public BusoshokuHaki() 
		{
			super(ListAttributes.BUSOSHOKUHAKI); 			
		}
		
		public void duringPassive(EntityPlayer player)
		{
			ExtendedEntityStats props = ExtendedEntityStats.get(player);
			
			props.triggerActiveHaki();
		}
		
		public void endPassive(EntityPlayer player)
		{
			ExtendedEntityStats props = ExtendedEntityStats.get(player);
			
			props.triggerActiveHaki();
		}
		
		/*public void duringPassive(EntityPlayer player)
		{
	        if (OpenGlHelper.shadersSupported)
	        {
				Field field = null;
				try 
				{
					field = EntityRenderer.class.getDeclaredField("resourceManager");
					field.setAccessible(true);
						
					resourceManager = (IResourceManager) field.get(Minecraft.getMinecraft().entityRenderer);
					
					this.theShaderGroup = new ShaderGroup(Minecraft.getMinecraft().getTextureManager(), this.resourceManager, Minecraft.getMinecraft().getFramebuffer(), ID.SHADER_HAKI);
					this.theShaderGroup.createBindFramebuffers(Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
				} 
				catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | JsonException e) 
				{
					e.printStackTrace();
				}
	        }

			super.use(player);
		}*/
	}
}
