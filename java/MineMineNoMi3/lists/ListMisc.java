package MineMineNoMi3.lists;

import java.util.Random;

import MineMineNoMi3.EnumDialType;
import MineMineNoMi3.EnumToolMats;
import MineMineNoMi3.Values;
import MineMineNoMi3.blocks.BlockBarrier;
import MineMineNoMi3.blocks.BlockDenDenMushi;
import MineMineNoMi3.blocks.BlockDial;
import MineMineNoMi3.blocks.BlockEnchantmentTable;
import MineMineNoMi3.blocks.BlockKairosekiBars;
import MineMineNoMi3.blocks.BlockOpe;
import MineMineNoMi3.blocks.BlockOpeMid;
import MineMineNoMi3.blocks.BlockPoison;
import MineMineNoMi3.blocks.tileentities.TileEntityOpe;
import MineMineNoMi3.items.CharacterCreator;
import MineMineNoMi3.items.Cola;
import MineMineNoMi3.items.Dial;
import MineMineNoMi3.items.Heart;
import MineMineNoMi3.items.ItemCoreArmor;
import WyPI.modules.WyRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

public class ListMisc 
{	
	public static Block Ope = new BlockOpe();
	public static Block OpeMid = new BlockOpeMid();
	public static Block KairosekiBlock = new Block(Material.ROCK);
	public static Block KairosekiOre = new Block(Material.ROCK)
	{
		public int quantityDropped(Random random) {return 2 + random.nextInt(3);}
		public Item getItemDropped(IBlockState state, Random rand, int fortune) {return Kairoseki;}
	};
	public static Block EnchantmentTable = new BlockEnchantmentTable();
	public static Block DenDenMushi = new BlockDenDenMushi();
	public static Block SkyBlock = new Block(Material.CLOTH);
	public static Block Dial = new BlockDial();
	public static Block Barrier = new BlockBarrier();
	public static Block Poison = new BlockPoison();
	public static Block KairosekiBars = new BlockKairosekiBars();

	public static Item CharacterCreator = new CharacterCreator();
	public static Item Kairoseki = new Item(); 
	public static Item DenseKairoseki = new Item();
	public static Item BlackMetal = new Item();
	public static Item Shadow = new Item();
	public static Item Heart = new Heart().setMaxStackSize(1);

	public static Item DialDefault = new Item(); 
	public static Item DialFire = new Dial(EnumDialType.FIRE, 2); 
	public static Item DialEisen = new Item();
	public static Item DialImpact = new Dial(EnumDialType.IMPACT, 1); 
	public static Item DialMilky = new Dial(EnumDialType.MILKY, 1);
	public static Item DialAxe = new Dial(EnumDialType.AXE, 4);
	public static Item DialBreath = new Dial(EnumDialType.BREATH, 2);
	public static Item DialReject = new Dial(EnumDialType.REJECT, 1);
	public static Item DialFlash = new Dial(EnumDialType.FLASH, 3);

	public static Item Bullets = new Item(); 
	public static Item KairosekiBullets = new Item();
	public static Item KujaArrow = new Item();
	public static Item Cola = new Cola();
	
	public static Item MarineHelm = new ItemCoreArmor(EnumToolMats.marine_armor, EntityEquipmentSlot.HEAD);
	public static Item MarineChestplate = new ItemCoreArmor(EnumToolMats.marine_armor, EntityEquipmentSlot.CHEST);
	public static Item MarineLeggings = new ItemCoreArmor(EnumToolMats.marine_armor, EntityEquipmentSlot.LEGS);
	public static Item MarineBoots = new ItemCoreArmor(EnumToolMats.marine_armor, EntityEquipmentSlot.FEET);
	
	public static Item PirateChestplate = new ItemCoreArmor(EnumToolMats.pirate_armor, EntityEquipmentSlot.CHEST);
	public static Item PirateLeggings = new ItemCoreArmor(EnumToolMats.pirate_armor, EntityEquipmentSlot.LEGS);
	public static Item PirateBoots = new ItemCoreArmor(EnumToolMats.pirate_armor, EntityEquipmentSlot.FEET);
	
	/*public static Item MarineSword = new ItemCoreSword(5);
	public static Item PirateCutlass = new ItemCoreSword(5);
	public static Item basicSword = new ItemCoreSword(7);
	public static Item Pipe = new ItemCoreSword(8);
	public static Item Scissors = new ItemCoreSword(9);
	public static Item Kikoku = new ItemCoreSword(9);
	public static Item Kiribachi = new ItemCoreSword(9);
	public static Item CrocodilesHook = new ItemCoreSword(9);			
	public static Item Yoru = new ItemCoreSword(14);*/
	
	public static void init()
	{
		addITEM(Kairoseki		, "Kairoseki"			, ListCreativeTabs.tabMisc);
		addITEM(DenseKairoseki	, "Dense Kairoseki"		, ListCreativeTabs.tabMisc);
		addITEM(BlackMetal		, "Black Metal"			, ListCreativeTabs.tabMisc);
		addITEM(Shadow			, "Shadow"				, ListCreativeTabs.tabMisc);
		addITEM(Heart			, "Heart"				, null);
		addITEM(Cola			, "Cola"				, ListCreativeTabs.tabMisc);
		
 		addITEM(KujaArrow		, "Kuja Arrow"			, ListCreativeTabs.tabWeapons);
 		addITEM(Bullets			, "Bullets"				, ListCreativeTabs.tabWeapons);
 		addITEM(KairosekiBullets, "Kairoseki Bullets"	, ListCreativeTabs.tabWeapons);
 		
 		addITEM(MarineHelm		, "Marine Helmet"		, ListCreativeTabs.tabMisc);
 		addITEM(MarineChestplate, "Marine Chestplate"	, ListCreativeTabs.tabMisc);
 		addITEM(MarineLeggings	, "Marine Leggings"		, ListCreativeTabs.tabMisc);
 		addITEM(MarineBoots		, "Marine Boots"		, ListCreativeTabs.tabMisc);
 	
 		addITEM(PirateChestplate, "Pirate Chestplate"	, ListCreativeTabs.tabMisc);
 		addITEM(PirateLeggings	, "Pirate Leggings"		, ListCreativeTabs.tabMisc);
 		addITEM(PirateBoots		, "Pirate Boots"		, ListCreativeTabs.tabMisc);
 		
 		/*addITEM(basicSword		, "Basic Sword"			, ListCreativeTabs.tabWeapons); 	
 		addITEM(MarineSword		, "Marine Sword"		, ListCreativeTabs.tabWeapons); 	
 		addITEM(PirateCutlass	, "Pirate Cutlass"		, ListCreativeTabs.tabWeapons); 	
 		addITEM(Pipe			, "Pipe"				, ListCreativeTabs.tabWeapons); 	
 		addITEM(Scissors		, "Scissors"			, ListCreativeTabs.tabWeapons); 	
 		addITEM(Kikoku			, "Kikoku"				, ListCreativeTabs.tabWeapons); 	
 		addITEM(Yoru			, "Yoru"				, ListCreativeTabs.tabWeapons); 
 		addITEM(CrocodilesHook	, "Crocodile's Hook"	, ListCreativeTabs.tabWeapons); */		
 		
 		addITEM(CharacterCreator, "Character Creator"	, ListCreativeTabs.tabMisc);  
 		
 		addITEM(ListAbilities.SORU		, "Soru"				, ListCreativeTabs.tabHaki); 	
		addITEM(ListAbilities.TEKKAI	, "Tekkai"				, ListCreativeTabs.tabHaki); 
 		addITEM(ListAbilities.GEPPO		, "Geppo"				, ListCreativeTabs.tabHaki); 	
		addITEM(ListAbilities.RANKYAKU	, "Rankyaku"			, ListCreativeTabs.tabHaki);
 		addITEM(ListAbilities.SHIGAN	, "Shigan"				, ListCreativeTabs.tabHaki); 	
		addITEM(ListAbilities.KAMIE		, "Kamie"				, ListCreativeTabs.tabHaki);	
		
 		addITEM(ListAbilities.UCHIMIZU				, "Uchimizu"				, ListCreativeTabs.tabHaki); 	
		addITEM(ListAbilities.YARINAMI				, "Yarinami"				, ListCreativeTabs.tabHaki); 
 		addITEM(ListAbilities.SAMEHADASHOTEI		, "Samehada Shotei"			, ListCreativeTabs.tabHaki); 	
		addITEM(ListAbilities.SOSHARK				, "Soshark"					, ListCreativeTabs.tabHaki);
 		addITEM(ListAbilities.MURASAME				, "Murasame"				, ListCreativeTabs.tabHaki); 	
		addITEM(ListAbilities.KARAKUSAGAWARASEIKEN	, "Karakusagawara Seiken"	, ListCreativeTabs.tabHaki);

		/*addITEM(BusoshokuHaki	, "Busoshoku Haki"		, ListCreativeTabs.tabHaki);
		addITEM(KenbunshokuHaki	, "Kenbunshoku Haki"	, ListCreativeTabs.tabHaki);
		addITEM(HaoshokuHaki	, "Haoshoku Haki"		, ListCreativeTabs.tabHaki);*/
		
 		addITEM(DialDefault		, "Default Dial"		, ListCreativeTabs.tabMisc);
 		addITEM(DialFire		, "Fire Dial"			, ListCreativeTabs.tabMisc);
 		addITEM(DialImpact		, "Impact Dial"			, ListCreativeTabs.tabMisc);
 		addITEM(DialEisen		, "Eisen Dial"			, ListCreativeTabs.tabMisc);
 		addITEM(DialMilky		, "Milky Dial"			, ListCreativeTabs.tabMisc);
 		addITEM(DialAxe			, "Axe Dial"			, ListCreativeTabs.tabMisc);
 		addITEM(DialBreath		, "Breath Dial"			, ListCreativeTabs.tabMisc);
 		addITEM(DialReject		, "Reject Dial"			, ListCreativeTabs.tabMisc);		
 		addITEM(DialFlash		, "Flash Dial"			, ListCreativeTabs.tabMisc);	
 		 
 		addBLOCK(Ope				, "Ope"					, Float.POSITIVE_INFINITY		, null						, ListCreativeTabs.tabMisc);
 		addBLOCK(OpeMid				, "Ope Mid"				, Float.POSITIVE_INFINITY		, TileEntityOpe.class		, ListCreativeTabs.tabMisc);
 		addBLOCK(KairosekiOre		, "Kairoseki Ore"		, 3.5F							, null						, ListCreativeTabs.tabMisc);
 		addBLOCK(KairosekiBlock		, "Kairoseki Block"		, 3.5F							, null						, ListCreativeTabs.tabMisc);
 		addBLOCK(EnchantmentTable	, "Kairoseki Table"		, 3.5F							, null						, ListCreativeTabs.tabMisc);
 		addBLOCK(DenDenMushi		, "Den Den Mushi"		, 3.5F							, null						, ListCreativeTabs.tabMisc);
 		addBLOCK(SkyBlock			, "Sky Block"			, 1.5F							, null						, ListCreativeTabs.tabMisc);
 		addBLOCK(Dial				, "Dial"				, 1.5F							, null						, null);
 		addBLOCK(Barrier			, "Crash Barrier"		, Float.POSITIVE_INFINITY		, null						, null);
 		addBLOCK(Poison				, "Poison"				, 1.5F							, null						, null);
 		addBLOCK(KairosekiBars		, "Kairoseki Bars"		, 2F							, null						, ListCreativeTabs.tabMisc);
 		
	}
	
	
	private static void addITEM(Item item,String localizedName, CreativeTabs tab)
	{	
		WyRegistry.instance().registerItem(item, localizedName, tab);
		Values.miscItems.add(item);
	}
	
	private static void addBLOCK(Block block, String localizedName, float hard, Class<? extends TileEntity> tile, CreativeTabs tab)
	{	
		WyRegistry.instance().registerBlock(block, localizedName, hard, tab);
		WyRegistry.instance().registerTileEntity(block, tile, localizedName);
		Values.miscBlocks.add(block);
	}
}
