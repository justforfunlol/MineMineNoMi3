package xyz.pixelatedw.MineMineNoMi3;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class NewBlock extends Block
{

	public NewBlock(Material mat) 
	{
		super(mat);
	}

	public void registerBlockIcons(IIconRegister reg)
	{
		this.blockIcon = reg.registerIcon(MainMod.getMineMineNoMi().getModId() + ":" + this.getUnlocalizedName().substring(5));
	}
}
