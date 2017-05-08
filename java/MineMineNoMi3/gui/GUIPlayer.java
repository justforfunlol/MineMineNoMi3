package MineMineNoMi3.gui;

import org.lwjgl.opengl.GL11;

import MineMineNoMi3.Values;
import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.lists.ID;
import WyPI.WyPI;
import WyPI.modules.WyHelper;
import WyPI.modules.WyRenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GUIPlayer extends GuiScreen
{
	private EntityPlayer player;
	private RenderItem renderItem;
	private IEntityCapability props;

	public GUIPlayer(EntityPlayer player)
	{
		this.player = player;
		this.renderItem = Minecraft.getMinecraft().getRenderItem();
		this.props = player.getCapability(Values.ENTITY_CAPABILITIES, null);	
	}

	public void drawScreen(int x, int y, float f)
	{
		drawDefaultBackground();
    
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);	
		
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;

		if(!props.getRace().equals(ID.RACE_CYBORG))
			mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "DORIKI: " + TextFormatting.RESET + "" + props.getDoriki(), posX - 30, posY + 70, -1);
		else
			mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "COLA: " + TextFormatting.RESET + "" + props.getCola(), posX - 30, posY + 70, -1);
		mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "FACTION: " + TextFormatting.RESET + "" + props.getFaction(), posX - 30, posY + 90, -1);
		mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "RACE: " + TextFormatting.RESET + "" + props.getRace(), posX - 30, posY + 110, -1);
		mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "JOB: " + TextFormatting.RESET + "" + props.getJob(), posX - 30, posY + 130, -1);

		if(props.getBelly() > 0)
		{
			mc.fontRendererObj.drawStringWithShadow("" + props.getBelly(), posX + 215, posY + 72, -1);
			this.mc.renderEngine.bindTexture(ID.TEXTURE_CURRENCIES);
			this.drawTexturedModalRect(posX + 190, posY + 60, 0, 32, 32, 64);
		}
		
		if(props.getExtol() > 0)
		{
			mc.fontRendererObj.drawStringWithShadow("" + props.getExtol(), posX + 215, posY + 102, -1);
			this.mc.renderEngine.bindTexture(ID.TEXTURE_CURRENCIES);
			this.drawTexturedModalRect(posX + 190, posY + 90, 34, 32, 64, 86);
		}

		if(!props.getUsedFruit().equals("N/A") && !props.getUsedFruit().equals("null"))
		{
			String model = "";
			if(props.getUsedFruit().equals("ushiushibison"))
				model = "bison";
			
			ItemStack df = new ItemStack(GameRegistry.findItem(WyPI.apiInstance.getParentMod().getParentModID(), props.getUsedFruit().replace(model, "") + "nomi" + model));
			mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + df.getDisplayName(), posX - 28, posY + 194, -1);
			this.renderItem.renderItemIntoGUI(df, posX - 50, posY + 190);
		}
		 
		WyRenderHelper.instance().drawEntityOnScreen(posX + 140, posY + 180 , 68, 0, 0, this.player);
    
		if(props.getFaction().equals(ID.FACTION_PIRATE) && props.getBounty() > 0)
		{
			this.mc.renderEngine.bindTexture(ID.TEXTURE_BOUNTYPOSTER);
			this.drawTexturedModalRect(posX + 200, posY + 130, 0, 0, 180, 200);
			mc.fontRendererObj.drawStringWithShadow(TextFormatting.BOLD + "" + props.getBounty(), posX + 220, posY + 208, -1);
			this.mc.renderEngine.bindTexture(ID.TEXTURE_CURRENCIES);
			this.drawTexturedModalRect(posX + 200, posY + 195, 0, 32, 32, 64);
		}		

		super.drawScreen(x, y, f);
	}

	public void initGui()
	{
		int posX = (this.width - 256) / 2;
		int posY = (this.height - 256) / 2;

		//this.buttonList.add(new GuiButton(1, posX - 32, posY + 35, 80, 20, "Achievements"));
	}
	
	public void actionPerformed(GuiButton button)
	{
		
	}
	
	public boolean doesGuiPauseGame()
	{
		return false;
	}

}
