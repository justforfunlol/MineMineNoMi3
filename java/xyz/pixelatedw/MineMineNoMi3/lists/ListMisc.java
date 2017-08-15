package xyz.pixelatedw.MineMineNoMi3.lists;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import xyz.pixelatedw.MineMineNoMi3.NewBlock;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.abilities.FishKarateAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.HakiAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.WeaponsAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.WyRegistry;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockBarrier;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockCustomSpawner;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockDarkness;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockDenDenMushi;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockDial;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockEnchantmentTable2;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockOpe;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockOpeMid;
import xyz.pixelatedw.MineMineNoMi3.blocks.BlockPoison;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityCustomSpawner;
import xyz.pixelatedw.MineMineNoMi3.blocks.tileentities.TileEntityOpe;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMiBox;
import xyz.pixelatedw.MineMineNoMi3.items.BellyPouch;
import xyz.pixelatedw.MineMineNoMi3.items.CharacterCreator;
import xyz.pixelatedw.MineMineNoMi3.items.Cola;
import xyz.pixelatedw.MineMineNoMi3.items.Flintlock;
import xyz.pixelatedw.MineMineNoMi3.items.Heart;
import xyz.pixelatedw.MineMineNoMi3.items.UltraCola;

public class ListMisc 
{	
	public static Block Ope = new BlockOpe();
	public static Block OpeMid = new BlockOpeMid();
	public static Block KairosekiBlock = new NewBlock(Material.rock);
	public static Block KairosekiOre = new NewBlock(Material.rock)
	{
		public int quantityDropped(Random random) {return 2 + random.nextInt(3);}
		public Item getItemDropped(int id, Random rand, int fortune) {return Kairoseki;}
	}; 
	public static Block EnchantmentTable = new BlockEnchantmentTable2();
	public static Block DenDenMushi = new BlockDenDenMushi();
	public static Block SkyBlock = new NewBlock(Material.cloth);
	public static Block Dial = new BlockDial();
	public static Block Barrier = new BlockBarrier();
	public static Block Poison = new BlockPoison();
	public static BlockCustomSpawner CustomSpawner = (BlockCustomSpawner) new BlockCustomSpawner().setTickRandomly(true);
	public static Block Darkness = new BlockDarkness();

	public static Item CharacterCreator = new CharacterCreator();
	public static Item Kairoseki = new Item(); 
	public static Item DenseKairoseki = new Item();
	public static Item BlackMetal = new Item();
	public static Item Shadow = new Item();
	public static Item Heart = new Heart().setMaxStackSize(1);
	public static Item BellyPouch = new BellyPouch().setMaxStackSize(1);
	public static Item Key = new Item();
	public static Item Box1 = new AkumaNoMiBox(1).setMaxStackSize(1);
	public static Item Box2 = new AkumaNoMiBox(2).setMaxStackSize(1);
	public static Item Box3 = new AkumaNoMiBox(3).setMaxStackSize(1);
	
	public static Item DialDefault = new Item().setMaxStackSize(16); 
	public static Item DialEisen = new Item().setMaxStackSize(16);

	public static Item Bullets = new Item(); 
	public static Item KairosekiBullets = new Item();
	public static Item KujaArrow = new Item();
	public static Item Cola = new Cola();
	public static Item UltraCola = new UltraCola();
	
	/*public static Item MarineHelm = new ItemCoreArmor(EnumToolMats.marine_armor, EntityEquipmentSlot.HEAD);
	public static Item MarineChestplate = new ItemCoreArmor(EnumToolMats.marine_armor, EntityEquipmentSlot.CHEST);
	public static Item MarineLeggings = new ItemCoreArmor(EnumToolMats.marine_armor, EntityEquipmentSlot.LEGS);
	public static Item MarineBoots = new ItemCoreArmor(EnumToolMats.marine_armor, EntityEquipmentSlot.FEET);
	 
	public static Item PirateChestplate = new ItemCoreArmor(EnumToolMats.pirate_armor, EntityEquipmentSlot.CHEST);
	public static Item PirateLeggings = new ItemCoreArmor(EnumToolMats.pirate_armor, EntityEquipmentSlot.LEGS);
	public static Item PirateBoots = new ItemCoreArmor(EnumToolMats.pirate_armor, EntityEquipmentSlot.FEET);*/
	
	public static Item Flintlock = new Flintlock();
	
	public static void init()
	{
		addITEM(Kairoseki							, "Kairoseki"				, ListCreativeTabs.tabMisc);
		addITEM(DenseKairoseki						, "Dense Kairoseki"			, ListCreativeTabs.tabMisc);
		addITEM(BlackMetal							, "Black Metal"				, ListCreativeTabs.tabMisc);
		addITEM(Shadow								, "Shadow"					, ListCreativeTabs.tabMisc);
		addITEM(Heart								, "Heart"					, null);
		addITEM(Cola								, "Cola"					, ListCreativeTabs.tabMisc);
		addITEM(UltraCola							, "Ultra Cola"				, ListCreativeTabs.tabMisc);
		addITEM(BellyPouch							, "Belly Pouch"				, ListCreativeTabs.tabMisc);
		addITEM(Key									, "Key"						, ListCreativeTabs.tabMisc);
		addITEM(Box1								, "Wooden Box"				, ListCreativeTabs.tabMisc);
		addITEM(Box2								, "Iron Box"				, ListCreativeTabs.tabMisc);
		addITEM(Box3								, "Golden Box"				, ListCreativeTabs.tabMisc);
		
 		addITEM(KujaArrow							, "Kuja Arrow"				, ListCreativeTabs.tabWeapons);
 		addITEM(Bullets								, "Bullets"					, ListCreativeTabs.tabWeapons);
 		addITEM(KairosekiBullets					, "Kairoseki Bullets"		, ListCreativeTabs.tabWeapons);
 		
/* 		addITEM(MarineHelm							, "Marine Helmet"			, ListCreativeTabs.tabMisc);
 		addITEM(MarineChestplate					, "Marine Chestplate"		, ListCreativeTabs.tabMisc);
 		addITEM(MarineLeggings						, "Marine Leggings"			, ListCreativeTabs.tabMisc);
 		addITEM(MarineBoots							, "Marine Boots"			, ListCreativeTabs.tabMisc);
 	
 		addITEM(PirateChestplate					, "Pirate Chestplate"		, ListCreativeTabs.tabMisc);
 		addITEM(PirateLeggings						, "Pirate Leggings"			, ListCreativeTabs.tabMisc);
 		addITEM(PirateBoots							, "Pirate Boots"			, ListCreativeTabs.tabMisc);
*/ 		
		addITEM(Flintlock							, "Flintlock"				, ListCreativeTabs.tabWeapons); 	
 		addITEM(WeaponsAbilities.MARINESWORD		, "Marine Sword"			, ListCreativeTabs.tabWeapons); 	
 		addITEM(WeaponsAbilities.PIRATECUTLASS		, "Pirate Cutlass"			, ListCreativeTabs.tabWeapons); 	
 		addITEM(WeaponsAbilities.PIPE				, "Pipe"					, ListCreativeTabs.tabWeapons); 	
 		addITEM(WeaponsAbilities.SCISSORS			, "Scissors"				, ListCreativeTabs.tabWeapons); 	
 		addITEM(WeaponsAbilities.KIKOKU				, "Kikoku"					, ListCreativeTabs.tabWeapons); 	
 		addITEM(WeaponsAbilities.KIRIBACHI			, "Kiribachi"				, ListCreativeTabs.tabWeapons); 
 		addITEM(WeaponsAbilities.YORU				, "Yoru"					, ListCreativeTabs.tabWeapons); 
 		addITEM(WeaponsAbilities.BISETO				, "Biseto"					, ListCreativeTabs.tabWeapons); 
 		addITEM(WeaponsAbilities.HOOK				, "Hook"					, ListCreativeTabs.tabWeapons);	
 		addITEM(WeaponsAbilities.UMBRELLA			, "Umbrella"				, ListCreativeTabs.tabWeapons);	
		addITEM(WeaponsAbilities.JITTE				, "Jitte"					, ListCreativeTabs.tabWeapons);	
		addITEM(WeaponsAbilities.BOSTICK			, "Bo"						, ListCreativeTabs.tabWeapons);	
 		
 		addITEM(CharacterCreator					, "Character Creator"		, ListCreativeTabs.tabMisc);  
 		
 		addITEM(RokushikiAbilities.abilitiesArray[0], "Soru"					, ListCreativeTabs.tabHaki); 	
		addITEM(RokushikiAbilities.abilitiesArray[1], "Tekkai"					, ListCreativeTabs.tabHaki); 
 		addITEM(RokushikiAbilities.abilitiesArray[2], "Geppo"					, ListCreativeTabs.tabHaki); 	
		addITEM(RokushikiAbilities.abilitiesArray[3], "Rankyaku"				, ListCreativeTabs.tabHaki);
 		addITEM(RokushikiAbilities.abilitiesArray[4], "Shigan"					, ListCreativeTabs.tabHaki); 	
		addITEM(RokushikiAbilities.abilitiesArray[5], "Kamie"					, ListCreativeTabs.tabHaki);	
		
 		addITEM(FishKarateAbilities.UCHIMIZU		, "Uchimizu"				, ListCreativeTabs.tabHaki); 	
		addITEM(FishKarateAbilities.YARINAMI		, "Yarinami"				, ListCreativeTabs.tabHaki); 
 		addITEM(FishKarateAbilities.SAMEHADASHOTEI	, "Samehada Shotei"			, ListCreativeTabs.tabHaki); 	
		addITEM(FishKarateAbilities.SOSHARK			, "Soshark"					, ListCreativeTabs.tabHaki);
 		addITEM(FishKarateAbilities.MURASAME		, "Murasame"				, ListCreativeTabs.tabHaki); 	
		addITEM(FishKarateAbilities.KARAKUSAGAWARASEIKEN, "Karakusagawara Seiken"	, ListCreativeTabs.tabHaki);

		addITEM(HakiAbilities.BUSOSHOKUHAKI			, "Busoshoku Haki"			, ListCreativeTabs.tabHaki);
		addITEM(HakiAbilities.KENBUNSHOKUHAKI		, "Kenbunshoku Haki"		, ListCreativeTabs.tabHaki);
		addITEM(HakiAbilities.HAOSHOKUHAKI			, "Haoshoku Haki"			, ListCreativeTabs.tabHaki);
		
 		/*addITEM(DialDefault							, "Default Dial"			, ListCreativeTabs.tabMisc);
 		addITEM(DialEisen							, "Eisen Dial"				, ListCreativeTabs.tabMisc);
 		addITEM(ListAttributes.DIALMILKY				, "Milky Dial"				, ListCreativeTabs.tabMisc);
 		addITEM(ListAttributes.DIALAXE				, "Axe Dial"				, ListCreativeTabs.tabMisc);
 		addITEM(ListAttributes.DIALFIRE				, "Fire Dial"				, ListCreativeTabs.tabMisc);
 		addITEM(ListAttributes.DIALIMPACT			, "Impact Dial"				, ListCreativeTabs.tabMisc);
 		addITEM(ListAttributes.DIALBREATH			, "Breath Dial"				, ListCreativeTabs.tabMisc);
 		addITEM(ListAttributes.DIALREJECT			, "Reject Dial"				, ListCreativeTabs.tabMisc);*/
 		  
 		addBLOCK(Ope				, "Ope"					, Float.POSITIVE_INFINITY		, null							, ListCreativeTabs.tabMisc);
 		addBLOCK(OpeMid				, "Ope Mid"				, Float.POSITIVE_INFINITY		, TileEntityOpe.class			, ListCreativeTabs.tabMisc);
 		addBLOCK(KairosekiOre		, "Kairoseki Ore"		, 3.5F							, null							, ListCreativeTabs.tabMisc);
 		addBLOCK(KairosekiBlock		, "Kairoseki Block"		, 3.5F							, null							, ListCreativeTabs.tabMisc);
 		addBLOCK(EnchantmentTable	, "Kairoseki Table"		, 3.5F							, null							, ListCreativeTabs.tabMisc);
 		addBLOCK(DenDenMushi		, "Den Den Mushi"		, 3.5F							, null							, ListCreativeTabs.tabMisc);
 		addBLOCK(SkyBlock			, "Sky Block"			, 1.5F							, null							, ListCreativeTabs.tabMisc);
 		addBLOCK(Dial				, "Dial"				, 1.5F							, null							, null);
 		addBLOCK(Barrier			, "Crash Barrier"		, Float.POSITIVE_INFINITY		, null							, null);
 		addBLOCK(Poison				, "Poison"				, 1.5F							, null							, null);
 		addBLOCK(CustomSpawner		, "Custom Spawner"		, Float.POSITIVE_INFINITY		, TileEntityCustomSpawner.class	, null);
 		addBLOCK(Darkness			, "Darkness"			, Float.POSITIVE_INFINITY		, null							, ListCreativeTabs.tabMisc);
 		
	}   
	 
	private static void addITEM(Item item,String localizedName, CreativeTabs tab)
	{	
		WyRegistry.registerItem(item, localizedName, tab);
		Values.miscItems.add(item);
	}
	
	private static void addBLOCK(Block block, String localizedName, float hard, Class<? extends TileEntity> tile, CreativeTabs tab)
	{	
		WyRegistry.registerBlock(block, localizedName, hard, tab);
		WyRegistry.registerTileEntity(block, tile, localizedName);
		Values.miscBlocks.add(block);
	}
}
