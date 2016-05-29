package WyPI;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import WyPI.Ability.AbilityProjectile;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = WyPI.MODID, name = "WyPI", version = "1.0")

public class WyPI 
{
	protected static final String MODID = "wypi_elr";
	private static String ACTUAL_MODID;
	private static String SCHEMATICS_PATH = "schematics/";
	private static HashMap lang = new HashMap();
	private static HashMap items = new HashMap();
	private static File sourceFolder;
	
	@Instance(MODID)
	protected static WyPI instance;	
	@SidedProxy(clientSide = "WyPI.WyClientProxy", serverSide = "WyPI.WyCommonProxy")
	protected static WyCommonProxy proxy;
	
	private int version;
	
	public static WyPI instance()
	{
		return instance;
	}
	
	public static void setup(Object mod)
	{
		ModContainer mc = FMLCommonHandler.instance().findContainerFor(mod);
		ACTUAL_MODID = mc.getModId();
		sourceFolder = mc.getSource();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.render();	
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
	
	}

	public static String getMODID() {return ACTUAL_MODID;}		
	
	public static String getPathForSchematics() {return SCHEMATICS_PATH;}
	public static void setPathForSchematics(String path) {SCHEMATICS_PATH = path;}
	
	public enum Dir {SOUTH, SOUTH_EAST, EAST, NORTH, NORTH_EAST, NORTH_WEST, WEST, SOUTH_WEST;}
	
	public static class Utils
	{
		public static void generateLangFiles()
		{
			Set set = WyPI.lang.entrySet();
			Iterator i = set.iterator();
			
			File langFolder = new File(sourceFolder + "/assets/" + getMODID() + "/lang/");

			if(langFolder.exists())
			{			
				try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sourceFolder + "/assets/" + getMODID() + "/lang/en_US.lang"), "UTF-8"))) 
				{
					while(i.hasNext())
					{
						Map.Entry entry = (Map.Entry)i.next();
						 
						writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
					}
					writer.close();
				}
				catch(Exception e) {e.getStackTrace();}
			}
			else
			{
				new File(sourceFolder + "/assets/" + getMODID() + "/lang/").mkdir();
				generateLangFiles();
			}
		}
		
		public static void generateJSONModels()
		{
			File itemFolder = new File(sourceFolder + "/assets/" + getMODID() + "/models/item/");
			File blockstateFolder = new File(sourceFolder + "/assets/" + getMODID() + "/blockstates/");
			File blockFolder = new File(sourceFolder + "/assets/" + getMODID() + "/models/block/");
			
			Set set = WyPI.items.entrySet();
			Iterator i = set.iterator();
			
			if(itemFolder.exists() && blockFolder.exists() && blockstateFolder.exists())
			{
				while(i.hasNext())
				{
					Map.Entry entry = (Map.Entry)i.next();
					if(entry.getKey() instanceof Item)
					{
						try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sourceFolder + "/assets/" + getMODID() + "/models/item/" + ((Item)entry.getKey()).getUnlocalizedName().substring(5) + ".json"), "UTF-8"))) 
						{
							writer.write("{\"parent\": \"item/generated\", \"textures\": { \"layer0\": \"" + getMODID() + ":items/" + ((Item)entry.getKey()).getUnlocalizedName().substring(5) + "\"}}");
							writer.close();
						}
						catch(Exception e) {e.getStackTrace();}
					}
					else if(entry.getKey() instanceof Block)
					{
						try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sourceFolder + "/assets/" + getMODID() + "/models/block/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + ".json"), "UTF-8"))) 
						{
							writer.write("{\"parent\": \"block/cube_all\",\"textures\": {\"all\": \"" + getMODID() + ":blocks/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + "\"}}");
							writer.close();
						}
						catch(Exception e) {e.getStackTrace();}
						try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sourceFolder + "/assets/" + getMODID() + "/models/item/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + ".json"), "UTF-8"))) 
						{
							writer.write("{\"parent\":\"" + getMODID() + ":block/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + "\"}");
							writer.close();
						}
						catch(Exception e) {e.getStackTrace();}
						try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sourceFolder + "/assets/" + getMODID() + "/blockstates/" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + ".json"), "UTF-8"))) 
						{
							writer.write("{\"variants\": {\"normal\": { \"model\": \"" + getMODID() + ":" + ((Block)entry.getKey()).getUnlocalizedName().substring(5) + "\" }}}");
							writer.close();
						}
						catch(Exception e) {e.getStackTrace();}
					}
				}
			}
			else
			{
				if(!itemFolder.exists())
					new File(sourceFolder + "/assets/" + getMODID() + "/models/item/").mkdir();
				if(!blockFolder.exists())
					new File(sourceFolder + "/assets/" + getMODID() + "/models/block/").mkdir();
				if(!blockstateFolder.exists())
					new File(sourceFolder + "/assets/" + getMODID() + "/blockstates/").mkdir();
				generateJSONModels();
			}
		}

		public static void createSphere(Object e, int size, final IBlockState b)
		{
			BlockPos pos = e instanceof Entity ? ((Entity) e).getPosition() : e instanceof TileEntity ? ((TileEntity) e).getPos() : null;
			final World world = e instanceof Entity ? ((Entity) e).getEntityWorld() : e instanceof TileEntity ? ((TileEntity) e).getWorld() : null;
			UtilSphere.generate(pos.getX(), pos.getY(), pos.getZ(), size, new UtilISphere()
			{
			    public void call(int x, int y, int z)
			    {world.setBlockState(new BlockPos(x, y ,z), b);}
			});
		}
		
		public static void createSphere(Object e, BlockPos pos, int size, final IBlockState b)
		{
			final World world = e instanceof Entity ? ((Entity) e).getEntityWorld() : e instanceof TileEntity ? ((TileEntity) e).getWorld() : null;
			UtilSphere.generate(pos.getX(), pos.getY(), pos.getZ(), size, new UtilISphere()
			{
			    public void call(int x, int y, int z)
			    {world.setBlockState(new BlockPos(x, y ,z), b);}
			});
		}
		
		public static RayTraceResult rayTraceBlocks(Entity e)
		{
			float f = 1.0F;
			float f1 = e.prevRotationPitch + (e.rotationPitch - e.prevRotationPitch) * f;
			float f2 = e.prevRotationYaw + (e.rotationYaw - e.prevRotationYaw) * f;
			double d = e.prevPosX + (e.posX - e.prevPosX) * (double)f;
			double d1 = (e.prevPosY + (e.posY - e.prevPosY) * (double)f + 1.6200000000000001D) - (double)e.getYOffset();
			double d2 = e.prevPosZ + (e.posZ - e.prevPosZ) * (double)f;
			Vec3d vec3d = new Vec3d(d, d1, d2);
			float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
			float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);	      
			float f5 = -MathHelper.cos(-f1 * 0.01745329F);
			float f6 = MathHelper.sin(-f1 * 0.01745329F);
			float f7 = f4 * f5;
			float f9 = f3 * f5;
			double d3 = 5000D;
			
			Vec3d vec3 = vec3d.addVector((double)f7 * d3, (double)f6 * d3, (double)f9 * d3);
			RayTraceResult ray = e.worldObj.rayTraceBlocks(vec3d, vec3, false);	

			return ray;
		}
		
		public static void createCube(Entity e, int i, IBlockState b)
		{createCube(e, new int[] {i, i, i}, b);}
		
		public static void createCube(Entity e, int[] s, IBlockState b)
		{
			for (int x = (s[0] * 0) - s[0]; x < s[0]; x++) 
			for (int y = (s[1] * 0) - s[1]; y < s[1]; y++) 
			for (int z = (s[2] * 0) - s[2]; z < s[2]; z++) 
			{
				e.worldObj.setBlockState(new BlockPos(e.getPosition().getX() + x, e.getPosition().getY() + y, e.getPosition().getZ() + z), b);
			}
		}
		
		public static void sendMsgToPlayer(EntityPlayer player, String text)
		{player.addChatComponentMessage(new TextComponentString(text));}
	    
		public static String getFancyName(String text)
		{return text.replaceAll("\\s+","").toLowerCase().replaceAll("'", "").replaceAll("-", "").replaceAll(":", "").replaceAll("#", "").replace(",", "");}
	
		public static Color hexToRGB(String hexColor)
		{return Color.decode("#"+hexColor);} 
		
	    public static List<EntityLivingBase> getEntitiesNear(Entity e, double radius)
	    {
	    	AxisAlignedBB aabb = new AxisAlignedBB(e.posX, e.posY, e.posZ, e.posX + 1, e.posY + 1, e.posZ + 1).expand(radius, radius, radius);
	    	List<EntityLivingBase> list = e.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, aabb);
	    	list.remove(e);
		    return list;
	    }
	    
	    public static List<EntityLivingBase> getEntitiesNear(TileEntity e, int[] radius)
	    {
	    	AxisAlignedBB aabb = new AxisAlignedBB((double)e.getPos().getX(), (double)e.getPos().getY(), (double)e.getPos().getZ(), (double)(e.getPos().getX() + 1), (double)(e.getPos().getY() + 1), (double)(e.getPos().getZ() + 1)).expand(radius[0], radius[1], radius[2]);
	    	List<EntityLivingBase> list = e.getWorld().getEntitiesWithinAABB(EntityLivingBase.class, aabb);
			return list;
	    }

		public static Dir get4Directions(Entity e)
		{
			switch(MathHelper.floor_double(e.rotationYaw * 4.0F / 360.0F + 0.5D) & 3)
			{case 0: return Dir.SOUTH; case 1: return Dir.WEST; case 2: return Dir.NORTH; case 3: return Dir.EAST;}
			return null;
		}
		
		public static Dir get8Directions(Entity e)
		{
			switch(MathHelper.floor_double(e.rotationYaw * 8.0F / 360.0F + 0.5D) & 7)
			{case 0: return Dir.SOUTH; case 1: return Dir.SOUTH_WEST; case 2: return Dir.WEST; case 3: return Dir.NORTH_WEST; case 4: return Dir.NORTH; case 5: return Dir.NORTH_EAST; case 6: return Dir.EAST; case 7: return Dir.SOUTH_EAST;}
			return null;
		}
		
	    /*public static void addTextureOnScreen(ResourceLocation r)
	    {
	    	ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
	        GlStateManager.disableDepth();
	        GlStateManager.depthMask(false);
	        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	        GlStateManager.disableAlpha();
	        Minecraft.getMinecraft().getTextureManager().bindTexture(r);
	        Tessellator tessellator = Tessellator.getInstance();
	        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
	        worldrenderer.startDrawingQuads();
	        worldrenderer.addVertexWithUV(0.0D, (double)sr.getScaledHeight(), -90.0D, 0.0D, 1.0D);
	        worldrenderer.addVertexWithUV((double)sr.getScaledWidth(), (double)sr.getScaledHeight(), -90.0D, 1.0D, 1.0D);
	        worldrenderer.addVertexWithUV((double)sr.getScaledWidth(), 0.0D, -90.0D, 1.0D, 0.0D);
	        worldrenderer.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
	        tessellator.draw();
	        GlStateManager.depthMask(true);
	        GlStateManager.enableDepth();
	        GlStateManager.enableAlpha();
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	    }*/
	    
	    public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent)
	    {
	        GlStateManager.enableColorMaterial();
	        GlStateManager.pushMatrix();
	        GlStateManager.translate((float)posX, (float)posY, 50.0F);
	        GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
	        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	        float f = ent.renderYawOffset;
	        float f1 = ent.rotationYaw;
	        float f2 = ent.rotationPitch;
	        float f3 = ent.prevRotationYawHead;
	        float f4 = ent.rotationYawHead;
	        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
	        RenderHelper.enableStandardItemLighting();
	        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
	        GlStateManager.rotate(-((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
	        ent.renderYawOffset = (float)Math.atan((double)(mouseX / 40.0F)) * 20.0F;
	        ent.rotationYaw = (float)Math.atan((double)(mouseX / 40.0F)) * 40.0F;
	        ent.rotationPitch = -((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F;
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
	    
		public static String makeFabulous(String text)
		{
			int stringLength = text.length();
			if (stringLength < 1)
				return "";
			String outputString = "";
			TextFormatting[] colorChar = {TextFormatting.RED, TextFormatting.GOLD, TextFormatting.YELLOW, TextFormatting.GREEN, TextFormatting.AQUA, TextFormatting.LIGHT_PURPLE, TextFormatting.DARK_PURPLE, TextFormatting.AQUA, TextFormatting.WHITE, TextFormatting.DARK_RED};
			Random rand = new Random();
			for (int i = 0; i < stringLength; i++)
				outputString = outputString + colorChar[rand.nextInt(stringLength) % 10] + text.substring(i, i + 1);
			return outputString;
		}
		
		public static List<EntityPlayer> getPlayers()
		{
			int numDimensions = Minecraft.getMinecraft().thePlayer.getServer().worldServers.length;
			List<EntityPlayer> playerList = new ArrayList<EntityPlayer>();
			for(int x = 0; x < numDimensions; x++)
				playerList.addAll(Minecraft.getMinecraft().thePlayer.getServer().worldServers[x].playerEntities);	
			return playerList;
		}
	}
	
	public static class Registry
	{
		public static void addNAME(String key, String localizedName)
		{
			WyPI.lang.put(key, localizedName);
		} 
		
		public static void addTILE(Block block, Class<? extends TileEntity> tile, String localizedName)
		{
			GameRegistry.registerTileEntity(tile, block.getUnlocalizedName().substring(5));
		}
		
		public static void addBLOCK(Block block, String localizedName, float hard)
		{	
			addBLOCK(block, localizedName, hard, null);
		}
		
		public static void addBLOCK(Block block, String localizedName, float hard, CreativeTabs tab)
		{	
			String truename = WyPI.Utils.getFancyName(localizedName);
			if(tab != null)
				block.setUnlocalizedName(truename).setHardness(hard).setCreativeTab(tab);
			else
				block.setUnlocalizedName(truename).setHardness(hard);
			GameRegistry.registerBlock(block, truename);
			WyPI.items.put(block, localizedName);
			addNAME("tile." + truename + ".name", localizedName);
		}
		
		public static void addITEM(Item item, String localizedName)
		{	
			addITEM(item, localizedName, null);
		}
		
		public static void addITEM(Item item, String localizedName, CreativeTabs tab)
		{	
			String truename = WyPI.Utils.getFancyName(localizedName);
			if(tab != null)
				item.setUnlocalizedName(truename).setCreativeTab(tab);
			else
				item.setUnlocalizedName(truename);
			GameRegistry.registerItem(item, truename);
			WyPI.items.put(item, localizedName);
			addNAME("item." + truename + ".name", localizedName);
		}
		
		public static void addMOB(String name, Class<? extends Entity> entity)
		{
			addMOB(name, entity, -1, -1);
		}
		
		public static void addMOB(String name, Class<? extends Entity> entity, int color1, int color2)
		{
			EntityRegistry.registerModEntity(entity, name, EntityRegistry.findGlobalUniqueEntityId(), WyPI.instance, 64, 10, true);
			if(color1 != -1 && color2 != -1)
				EntityRegistry.registerEgg(entity, color1, color2);
			addNAME("entity.wypi_elr." + name + ".name", name);
		}	
	}
 
	public static class SchematicHelper
	{	
		public static Schematic get(String name)
		{
			try
			{
				InputStream is = SchematicHelper.class.getClassLoader().getResourceAsStream("assets/" + WyPI.getMODID() + "/" + WyPI.getPathForSchematics() + name + ".schematic");	
				NBTTagCompound nbt = CompressedStreamTools.readCompressed(is);
				
				short width = nbt.getShort("Width");
				short height = nbt.getShort("Height");
				short length = nbt.getShort("Length");
				
				byte[] blocks = nbt.getByteArray("Blocks");
				byte[] data = nbt.getByteArray("Data");
				
				NBTTagList tiles = nbt.getTagList("TileEntities", 10);
				
				//System.out.println("Successfully loaded new Schematic [" + name + "] W:" + width + "; H: " + height + "; L: " + length + "; B:" + blocks.length);
				is.close();
				
				return new Schematic(name, tiles, width, height, length, blocks, data);
			}
			catch(Exception e){return null;}	
		}
	}

}
