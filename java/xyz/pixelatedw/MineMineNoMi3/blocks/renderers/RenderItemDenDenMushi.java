package xyz.pixelatedw.MineMineNoMi3.blocks.renderers;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class RenderItemDenDenMushi implements IItemRenderer
{

	private TileEntitySpecialRenderer render;
	private TileEntity entity;

	public RenderItemDenDenMushi(TileEntitySpecialRenderer render, TileEntity entity)
	{
		this.entity = entity;
		this.render = render;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		if (type == IItemRenderer.ItemRenderType.ENTITY)
			GL11.glTranslatef(-0.5F, 0.0F, -0.5F);

		this.render.renderTileEntityAt(this.entity, 0.0D, 0.0D, 0.0D, 0.0F);
	}

}
