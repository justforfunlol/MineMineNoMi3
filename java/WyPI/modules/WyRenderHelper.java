package WyPI.modules;

import javax.annotation.Nullable;

import WyPI.Module;
import WyPI.WyPI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class WyRenderHelper extends Module
{

	private static WyRenderHelper instance;
	public static WyRenderHelper instance() 
	{ 
		if(instance == null) instance = new WyRenderHelper(WyPI.apiInstance);
		return instance;
	}
	
	public WyRenderHelper(WyPI instance)
	{
		super(instance);
	}

    public void renderItem(int x, int y, EntityPlayer player, @Nullable ItemStack stack)
    {
        if (stack != null)
        {
            float f = (float)stack.animationsToGo - 0;

            if (f > 0.0F)
            {
                GlStateManager.pushMatrix();
                float f1 = 1.0F + f / 5.0F;
                GlStateManager.translate((float)(x + 8), (float)(y + 12), 0.0F);
                GlStateManager.scale(1.0F / f1, (f1 + 1.0F) / 2.0F, 1.0F);
                GlStateManager.translate((float)(-(x + 8)), (float)(-(y + 12)), 0.0F);
            }

            Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(player, stack, x, y);

            if (f > 0.0F)
                GlStateManager.popMatrix();

            Minecraft.getMinecraft().getRenderItem().renderItemOverlays(Minecraft.getMinecraft().fontRendererObj, stack, x, y);
        }
    }
	
	public void drawColorOnScreen(int r, int g, int b, int alpha, double posX, double posY, double width, double height)
	{
		GlStateManager.disableTexture2D();
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer vexBuffer = tessellator.getBuffer();	
		 
		vexBuffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
		
		vexBuffer.pos(posX, posY + height, 100).color(r, g, b, alpha).endVertex();
		vexBuffer.pos(posX + width, posY + height, 100).color(r, g, b, alpha).endVertex();
		vexBuffer.pos(posX + width, posY, 100).color(r, g, b, alpha).endVertex();
		vexBuffer.pos(posX, posY, 100).color(r, g, b, alpha).endVertex();

		tessellator.draw();
		GlStateManager.enableTexture2D();		
	}

	public void drawTextureOnScreen()
	{
		
	}
	
	public void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent)
	{
		GlStateManager.enableColorMaterial();
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) posX, (float) posY, 50.0F);
		GlStateManager.scale((float) (-scale), (float) scale, (float) scale);
		GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
		float f = ent.renderYawOffset;
		float f1 = ent.rotationYaw;
		float f2 = ent.rotationPitch;
		float f3 = ent.prevRotationYawHead;
		float f4 = ent.rotationYawHead;
		GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-((float) Math.atan((double) (mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
		ent.renderYawOffset = (float) Math.atan((double) (mouseX / 40.0F)) * 20.0F;
		ent.rotationYaw = (float) Math.atan((double) (mouseX / 40.0F)) * 40.0F;
		ent.rotationPitch = -((float) Math.atan((double) (mouseY / 40.0F))) * 20.0F;
		ent.rotationYawHead = ent.rotationYaw;
		ent.prevRotationYawHead = ent.rotationYaw;
		GlStateManager.translate(0.0F, 0.0F, 0.0F);
		RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
		rendermanager.setPlayerViewY(180.0F);
		rendermanager.setRenderShadow(false);
		rendermanager.doRenderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
		rendermanager.setRenderShadow(true);
		ent.renderYawOffset = f;
		ent.rotationYaw = f1;
		ent.rotationPitch = f2;
		ent.prevRotationYawHead = f3;
		ent.rotationYawHead = f4;
		GlStateManager.popMatrix();
		RenderHelper.disableStandardItemLighting();
		GlStateManager.disableRescaleNormal();
		GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GlStateManager.disableTexture2D();
		GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}

	public void drawBoundingBox(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		GlStateManager.depthMask(false);
		GlStateManager.disableTexture2D();
		GlStateManager.disableLighting();
		GlStateManager.disableCull();
		GlStateManager.disableBlend();
		float f = entity.width / 2.0F;
		AxisAlignedBB axisalignedbb = entity.getEntityBoundingBox();
		AxisAlignedBB axisalignedbb1 = new AxisAlignedBB(axisalignedbb.minX - entity.posX + x,
				axisalignedbb.minY - entity.posY + y, axisalignedbb.minZ - entity.posZ + z,
				axisalignedbb.maxX - entity.posX + x, axisalignedbb.maxY - entity.posY + y,
				axisalignedbb.maxZ - entity.posZ + z);
		RenderGlobal.drawOutlinedBoundingBox(axisalignedbb1, 255, 255, 255, 255);

		if (entity instanceof EntityLivingBase)
		{
			float f1 = 0.01F;
			if (entity.getParts() != null)
			{
				for (Entity part : entity.getParts())
					RenderGlobal.drawOutlinedBoundingBox(part.getEntityBoundingBox(), 0, 255, 0, 255);
			} else
				RenderGlobal.drawOutlinedBoundingBox(
						new AxisAlignedBB(x - (double) f, y + (double) entity.getEyeHeight() - 0.009999999776482582D,
								z - (double) f, x + (double) f,
								y + (double) entity.getEyeHeight() + 0.009999999776482582D, z + (double) f),
						255, 0, 0, 255);
		}

		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer vertexbuffer = tessellator.getBuffer();
		Vec3d vec3d = entity.getLook(partialTicks);
		vertexbuffer.begin(3, DefaultVertexFormats.POSITION_COLOR);
		vertexbuffer.pos(x, y + (double) entity.getEyeHeight(), z).color(0, 0, 255, 255).endVertex();
		vertexbuffer.pos(x + vec3d.xCoord * 2.0D, y + (double) entity.getEyeHeight() + vec3d.yCoord * 2.0D,
				z + vec3d.zCoord * 2.0D).color(0, 0, 255, 255).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.enableLighting();
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);
	}
	
}
