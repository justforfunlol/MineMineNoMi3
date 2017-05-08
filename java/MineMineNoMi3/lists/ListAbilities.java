package MineMineNoMi3.lists;

import java.awt.Color;

import MineMineNoMi3.entities.models.ModelBird;
import MineMineNoMi3.entities.models.ModelGhost;
import MineMineNoMi3.entities.models.ModelHeart;
import MineMineNoMi3.entities.models.ModelX;
import MineMineNoMi3.items.AbilityItemPlus;
import MineMineNoMi3.zoan.TaskZoanForms;
import WyPI.abilities.AbilityAttribute;
import WyPI.abilities.AbilityItem;
import WyPI.abilities.ModelCube;
import WyPI.abilities.ModelSphere;
import WyPI.abilities.extra.EffectType;
import WyPI.abilities.extra.ItemProperty;
import WyPI.abilities.tasks.AbilityTaskChargeable;
import WyPI.abilities.tasks.AbilityTaskPlaceBlock;
import WyPI.abilities.tasks.AbilityTaskSetOnFire;
import WyPI.abilities.tasks.AbilityTaskSwordEffect;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public class ListAbilities 
{  
	
	public static AbilityItemPlus ZOANFORM_USHI = new AbilityItemPlus(new AbilityAttribute().addTasks(new TaskZoanForms("Human Point", "Power Point", "Speed Point")) );
	public static AbilityItemPlus FIDDLEBANFF = new AbilityItemPlus(new AbilityAttribute("Fiddle Banff") );
	
	public static AbilityItemPlus SAGARINORYUSEI = new AbilityItemPlus(new AbilityAttribute("Sagari no Ryusei").setItemCooldown(500).addTasks(Tasks.sagariNoRyusei) );
	public static AbilityItemPlus MOKO = new AbilityItemPlus(new AbilityAttribute("Moko").setItemCooldown(150).setProjectileModel(new ModelCube()).setProjectileSize(new double[] {0, 0, 0}).addTasks(Tasks.moko) );
	
	public static AbilityItemPlus DARKMATTER = new AbilityItemPlus(new AbilityAttribute("Dark Matter").setItemCooldown(250).setProjectileModel(new ModelSphere()).setProjectileColor("000000").setProjectileSize(5, 5, 5).addTasks(Tasks.darkMatter) );
	public static AbilityItemPlus KUROUZU = new AbilityItemPlus(new AbilityAttribute("Kurouzu").setItemCooldown(200) );
	public static AbilityItemPlus LIBERATION = new AbilityItemPlus(new AbilityAttribute("Liberation").setItemCooldown(50).addTasks(Tasks.liberation) );
	public static AbilityItemPlus BLACKHOLE = new AbilityItemPlus(new AbilityAttribute("Black Hole").setItemCooldown(200).addTasks(Tasks.blackHole) );
	
	public static AbilityItemPlus TENSIONHORMONE = new AbilityItemPlus(new AbilityAttribute("Tension Hormone").setItemCooldown(500).addTasks(Tasks.tensionHormone) );
	public static AbilityItemPlus CHIYUHORMONE = new AbilityItemPlus(new AbilityAttribute("Chiyu Hormone").setItemCooldown(500).addTasks(Tasks.chiyuHormone) );
	
	public static AbilityItemPlus KILOPRESS = new AbilityItemPlus(new AbilityAttribute("Kilo Press").setItemCooldown(80).addTasks(Tasks.kilopress) );
	
	public static AbilityItemPlus TODOROKI = new AbilityItemPlus(new AbilityAttribute("Todoroki").setItemCooldown(300).setProjectileModel(new ModelCube()).setProjectileColor("#87CEFA").setProjectileSize(5, 3, 3).setProjectileTicks(10).setProjectileDamage(15).setItemRepeater() );
	
	public static AbilityItemPlus PISTOLKISS = new AbilityItemPlus(new AbilityAttribute("Pistol Kiss").setItemCooldown(100).setProjectileModel(new ModelCube()).setProjectileSize(.3, .3, .3).setProjectileColor("#FFC0DB").setProjectileDamage(5).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.SLOWNESS, 100, 1)).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.MINING_FATIGUE, 100, 1)) );
	public static AbilityItemPlus PERFUMEFEMUR = new AbilityItemPlus(new AbilityAttribute("Perfume Femur").setItemCooldown(200).setItemDamage(15).addTasks(Tasks.parfumefemur) );
	public static AbilityItemPlus SLAVEARROW = new AbilityItemPlus(new AbilityAttribute("Slave Arrow").setItemCooldown(100).setProjectileModel(new ModelCube()).setProjectileSize(.3, .3, .3).setProjectileColor("#FFC0DB").setProjectileDamage(5).setItemRepeater() );
	public static AbilityItemPlus MEROMEROMELLOW = new AbilityItemPlus(new AbilityAttribute("Mero Mero Mellow").setItemCooldown(150).setProjectileModel(new ModelHeart()).setProjectileSize(3, 3, 3).setProjectileColor("#FFC0DB").setProjectileDamage(10).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.SLOWNESS, 200, 1)).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.MINING_FATIGUE, 200, 1)) );
	
	public static AbilityItemPlus SPIRALHOLLOW = new AbilityItemPlus(new AbilityAttribute("Spiral Hollow").setItemCooldown(200).setProjectileDamage(20).setProjectileModel(new ModelCube()).setProjectileColor("#F8F8FF").setProjectileSize(5, 3, 3).setProjectileTicks(3) );
	public static AbilityItemPlus ATOMICSPAR = new AbilityItemPlus(new AbilityAttribute("Atomic Spar").setItemCooldown(120).setProjectileModel(new ModelX()).setProjectileSize(2, 2, 2).setProjectileColor("#F8F8FF").setProjectileDamage(10) );
	public static AbilityItemPlus SPARCLAW = new AbilityItemPlus(new AbilityAttribute("Spar Claw").setItemCooldown(120).addTasks(Tasks.sparclaw) );
	public static AbilityItemPlus SPIDER = new AbilityItemPlus(new AbilityAttribute("Spider").addEffects(EffectType.USER,new PotionEffect(MobEffects.RESISTANCE, 10, 100), new PotionEffect(MobEffects.SLOWNESS, 10, 100)) );
	
	public static AbilityItemPlus NEGATIVEHOLLOW = new AbilityItemPlus(new AbilityAttribute("Negative Hollow").setItemCooldown(150).setProjectileModel(new ModelGhost()).setProjectileSize(1, 1, 1).setProjectileColor("#F8F8FF").setProjectileDamage(10).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.NAUSEA, 200, 1), new PotionEffect(MobEffects.SLOWNESS, 200, 1)) );
	public static AbilityItemPlus MINIHOLLOW = new AbilityItemPlus(new AbilityAttribute("Mini Hollow").setItemCooldown(80).setProjectileModel(new ModelGhost()).setProjectileSize(0.4, 0.4, 0.4).setProjectileColor("#F8F8FF").setProjectileDamage(5).setProjectileExplosion(2).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.NAUSEA, 200, 0), new PotionEffect(MobEffects.SLOWNESS, 200, 0)).setItemRepeater() );
	public static AbilityItemPlus TOKUHOLLOW = new AbilityItemPlus(new AbilityAttribute("Toku Hollow").setItemCooldown(250).setProjectileModel(new ModelGhost()).setProjectileSize(4, 4, 4).setProjectileColor("#F8F8FF").setProjectileDamage(10).setProjectileExplosion(7, false, false).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.NAUSEA, 200, 1), new PotionEffect(MobEffects.SLOWNESS, 200, 1)) );
	
	public static AbilityItemPlus BLACKKNIGHT = new AbilityItemPlus(new AbilityAttribute("Black Knight") );
	public static AbilityItemPlus OVERHEAT = new AbilityItemPlus(new AbilityAttribute("Overheat") );
	public static AbilityItemPlus SORANOMICHI = new AbilityItemPlus(new AbilityAttribute("Sora no Michi") );
	public static AbilityItemPlus PARASITE = new AbilityItemPlus(new AbilityAttribute("Parasite").setItemCooldown(100).setProjectileModel(new ModelCube()).setProjectileSize(1, .5, .5).setProjectileColor("#FFFFFF").setProjectileDamage(10) );
	
	public static AbilityItemPlus BARIBARINOPISTOL = new AbilityItemPlus(new AbilityAttribute("Bari Bari no Pistol").setItemDamage(20) );
	public static AbilityItemPlus BARRIERBALL = new AbilityItemPlus(new AbilityAttribute("Barrier Ball").setItemCooldown(100).addTasks(Tasks.barrierBall) );
	public static AbilityItemPlus BARRIERCRASH = new AbilityItemPlus(new AbilityAttribute("Barrier Crash").setItemCooldown(150).setProjectileTicks(20).setProjectileModel(new ModelCube()).setProjectileColor("#87CEFA").setProjectileSize(.3, 9, 9).setProjectileDamage(15) );
	public static AbilityItemPlus BARRIER = new AbilityItemPlus(new AbilityAttribute("Barrier").setItemCooldown(80).addTasks(Tasks.barrier) );
	
	public static AbilityItemPlus FUBUKI = new AbilityItemPlus(new AbilityAttribute("Fubuki").setItemCooldown(250).addTasks(Tasks.fubuki) );
	public static AbilityItemPlus TABIRAYUKI = new AbilityItemPlus(new AbilityAttribute("Tabira Yuki").setItemDamage(6).addTasks(Tasks.tabirayuki) );
	public static AbilityItemPlus MANNENYUKI = new AbilityItemPlus(new AbilityAttribute("Mannen Yuki") );
	public static AbilityItemPlus KAMAKURAJUSSOSHI = new AbilityItemPlus(new AbilityAttribute("Kamakura Jussoshi").setItemCooldown(300).addTasks(Tasks.kamakurajusshoshi) );
	public static AbilityItemPlus YUKIRABI = new AbilityItemPlus(new AbilityAttribute("Yuki Rabi").setItemCooldown(70).setProjectileColor(Color.WHITE).setProjectileDamage(5).setProjectileModel(new ModelCube()).setProjectileSize(1, 1, 1).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.SLOWNESS, 50, 1)).setItemRepeater() );
	public static AbilityItemPlus KAMAKURA = new AbilityItemPlus(new AbilityAttribute("Kamakura").setItemCooldown(100).addTasks(Tasks.kamakura) );
	
	public static AbilityItemPlus SHINOKUNI = new AbilityItemPlus(new AbilityAttribute("Shinokuni") );
	public static AbilityItemPlus KARAKUNI = new AbilityItemPlus(new AbilityAttribute("Karakuni").setItemCooldown(300).addTasks(Tasks.karakuni) );
	public static AbilityItemPlus BLUESWORD = new AbilityItemPlus(new AbilityAttribute("Blue Sword").setItemDamage(7).addTasks(Tasks.bluesword) );
	public static AbilityItemPlus GASTANET = new AbilityItemPlus(new AbilityAttribute("Gastanet").setItemCooldown(150).setProjectileExplosion(5, false) );
	public static AbilityItemPlus GASTILLE = new AbilityItemPlus(new AbilityAttribute("Gastille").setItemCooldown(200).setProjectileSpeed(6).setProjectileDamage(10).setProjectileModel(new ModelCube()).setProjectileColor("324AB2").setProjectileSize(2, 1, 1).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.POISON, 500, 1)).setItemRepeater().setProjectileExplosion(1, false) );
	public static AbilityItemPlus GASROBE = new AbilityItemPlus(new AbilityAttribute("Gas Robe").setItemCooldown(150).setProjectileSpeed(6).setProjectileDamage(10).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).setItemRepeater() );
	
	public static AbilityItemPlus DOKUFUGU = new AbilityItemPlus(new AbilityAttribute("Doku Fugu").setItemCooldown(250).setProjectileDamage(15).setProjectileModel(new ModelSphere()).setProjectileColor("A020F0").setProjectileSize(5, 5, 5).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.POISON, 500, 1)).setItemRepeater() );
	public static AbilityItemPlus VENOMDEMON = new AbilityItemPlus(new AbilityAttribute("Venom Demon") );
	public static AbilityItemPlus VENOMROAD = new AbilityItemPlus(new AbilityAttribute("Venom Road").setItemCooldown(200).setProjectileDamage(30).setProjectileModel(new ModelCube()).setProjectileColor("A020F0").setProjectileSize(6, 4, 4).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.POISON, 500, 1)).addTasks(Tasks.venomroad) );
	public static AbilityItemPlus CHLOROBALL = new AbilityItemPlus(new AbilityAttribute("Chloro Ball").setItemCooldown(150).setProjectileDamage(10).setProjectileModel(new ModelSphere()).setProjectileColor("A020F0").setProjectileSize(5, 5, 5).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.POISON, 500, 1)).addTasks(Tasks.chloroball) );
	public static AbilityItemPlus HYDRA = new AbilityItemPlus(new AbilityAttribute("Hydra").setItemCooldown(200).setProjectileDamage(30).setProjectileModel(new ModelCube()).setProjectileColor("A020F0").setProjectileSize(6, 4, 4).setProjectileTicks(10).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.POISON, 500, 1)) );
	
	public static AbilityItemPlus CANDLEHOUSE = new AbilityItemPlus(new AbilityAttribute("Candle House").setItemCooldown(250).addTasks(Tasks.candleHouse) );
	public static AbilityItemPlus CANDLEWALL = new AbilityItemPlus(new AbilityAttribute("Candle Wall").setItemCooldown(150).addTasks(Tasks.candleWall) );
	public static AbilityItemPlus DORUDORUARTSKEN = new AbilityItemPlus(new AbilityAttribute("Doru Doru Arts : Ken").setItemDamage(7) );
	public static AbilityItemPlus DORUDORUARTSMORI = new AbilityItemPlus(new AbilityAttribute("Doru Doru Arts : Mori").setItemCooldown(100).setProjectileDamage(15).setProjectileModel(new ModelCube()).setProjectileColor("A2ADD0").setProjectileSize(5, .5, .5) );
	
	public static AbilityItemPlus BAKURETSUKAZAN = new AbilityItemPlus(new AbilityAttribute("Bakuretsu Kazan").setItemCooldown(400).addTasks(Tasks.bakuretsukazan) );
	public static AbilityItemPlus RYUSEIKAZAN = new AbilityItemPlus(new AbilityAttribute("Ryusei Kazan").setItemCooldown(300).setProjectileDamage(10).setProjectileModel(new ModelCube()).setProjectileSize(4, 2, 2).setProjectileColor("CF1020").setItemRepeater().addTasks(new AbilityTaskPlaceBlock(Blocks.LAVA), new AbilityTaskSetOnFire(100)) );
	public static AbilityItemPlus MEIGO = new AbilityItemPlus(new AbilityAttribute("Meigo").setItemCooldown(200).setProjectileDamage(40).setProjectileModel(new ModelCube()).setProjectileColor("CF1020").setProjectileSize(6, 4, 4).setProjectileTicks(3) );
	public static AbilityItemPlus DAIFUNKA = new AbilityItemPlus(new AbilityAttribute("Dai Funka").setItemCooldown(150).setProjectileDamage(20).setProjectileModel(new ModelCube()).setProjectileSize(4, 2, 2).setProjectileColor("CF1020").addTasks(new AbilityTaskPlaceBlock(Blocks.LAVA), new AbilityTaskSetOnFire(100)) );
	
	public static AbilityItemPlus GROUNDDEATH = new AbilityItemPlus(new AbilityAttribute("Ground Death").setItemCooldown(300).addTasks(Tasks.groundDeath) );
	public static AbilityItemPlus BARJAN = new AbilityItemPlus(new AbilityAttribute("Barjan").setItemCooldown(150).setProjectileDamage(15).setProjectileModel(new ModelCube()).setProjectileColor("967117").setProjectileSize(1.5, 0.4, 6).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.HUNGER, 500, 1)) );
	public static AbilityItemPlus SABLES = new AbilityItemPlus(new AbilityAttribute("Sables").setItemCooldown(150).addTasks(Tasks.sables) );
	public static AbilityItemPlus DESERTSPADA = new AbilityItemPlus(new AbilityAttribute("Desert Spada").setItemCooldown(250).addTasks(Tasks.desertSpada) );
	
	public static AbilityItemPlus TSUNOTOKAGE = new AbilityItemPlus(new AbilityAttribute("Tsuno-Tokage").setItemCooldown(200).setProjectileDamage(30).setProjectileModel(new ModelCube()).setProjectileColor(Color.black).setProjectileSize(5, 2, 2).setProjectileTicks(3) );
	public static AbilityItemPlus SHADOWSASGARD = new AbilityItemPlus(new AbilityAttribute("Shadow's Asgard").setItemCooldown(400).addTasks(Tasks.shadowsasgard) );
	public static AbilityItemPlus BLACKBOX = new AbilityItemPlus(new AbilityAttribute("Black Box").setItemCooldown(200).setProjectileModel(new ModelCube()).setProjectileColor(Color.black).setProjectileSize(2, 2, 2) );
	public static AbilityItemPlus DOPPELMAN = new AbilityItemPlus(new AbilityAttribute("Doppelman").setItemCooldown(10).addTasks(Tasks.doppelman) );
	public static AbilityItemPlus BRICKBAT = new AbilityItemPlus(new AbilityAttribute("Brick Bat").setItemCooldown(100).setProjectileDamage(10).setProjectileModel(new ModelCube()).setProjectileSize(1,	1, 1).setProjectileColor(Color.black).setItemRepeater() );
	
	public static AbilityItemPlus SHIMAYURASHI = new AbilityItemPlus(new AbilityAttribute("Shima Yurashi").setItemCooldown(250).setProjectileDamage(20).setProjectileExplosion(2, false).setItemRepeater() );
	public static AbilityItemPlus KABUTOWARI = new AbilityItemPlus(new AbilityAttribute("Kabutowari").setItemCooldown(150).setProjectileExplosion(5, false) );
	public static AbilityItemPlus KAISHIN = new AbilityItemPlus(new AbilityAttribute("Kaishin").setItemCooldown(150).setProjectileDamage(50).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).setProjectileExplosion(1, false, false) );
	
	public static AbilityItemPlus KICKBOMB = new AbilityItemPlus(new AbilityAttribute("Kick Bomb").setItemCooldown(150).setProjectileExplosion(7, false) );
	public static AbilityItemPlus NOSEFANCYCANNON = new AbilityItemPlus(new AbilityAttribute("Nose Fancy Cannon").setItemCooldown(100).setProjectileModel(new ModelCube()).setProjectileColor("3D2B1F").setProjectileSize(.8, .4, .4).setProjectileDamage(10).setProjectileExplosion(3, false) );
	
	public static AbilityItemPlus URSUSSHOCK = new AbilityItemPlus(new AbilityAttribute("Ursus Shock").setItemCooldown(300).setProjectileModel(new ModelCube()).setProjectileColor("F8F8FF").setProjectileSize(1.5, 1.5, 1.5).setProjectileDamage(50).setProjectileExplosion(2, false, false).setItemCharge(40).setFalseAttribute().addTasks(new AbilityTaskChargeable()) );
	public static AbilityItemPlus PADHO = new AbilityItemPlus(new AbilityAttribute("Pad Ho").setItemCooldown(150).addTasks(Tasks.padho) );
	
	public static AbilityItemPlus WHITELAUNCHER = new AbilityItemPlus(new AbilityAttribute("White Launcher").setItemCooldown(150).addTasks(Tasks.whitelauncher) );
	public static AbilityItemPlus WHITESNAKE = new AbilityItemPlus(new AbilityAttribute("White Snake").setItemCooldown(150).setProjectileTicks(120).setProjectileModel(new ModelCube()).setProjectileSpeed(5).setProjectileSize(0, 0, 0).setProjectileDamage(15).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.POISON, 500, 1)) );
	public static AbilityItemPlus WHITEOUT = new AbilityItemPlus(new AbilityAttribute("White Out").setItemCooldown(80).setProjectileModel(new ModelCube()).setProjectileSpeed(5).setProjectileSize(0, 0, 0).setProjectileDamage(10).addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.SLOWNESS, 500, 5)).setItemRepeater() );
	
	public static AbilityItemPlus SANGO = new AbilityItemPlus(new AbilityAttribute("Sango").setItemCooldown(250).setProjectileTicks(10).setProjectileModel(new ModelCube()).setProjectileSize(10, 3, 3).setProjectileColor("7CB9E8").setProjectileDamage(15) );
	public static AbilityItemPlus KARI = new AbilityItemPlus(new AbilityAttribute("Kari").setItemCooldown(150).setProjectileExplosion(6, false, false) );
	public static AbilityItemPlus RAIGO = new AbilityItemPlus(new AbilityAttribute("Raigo").setItemCooldown(400).setProjectileModel(new ModelCube()).setProjectileColor("5D8AA8").setProjectileSize(8, 8, 8).setProjectileDamage(40).setProjectileExplosion(7, false) );
	public static AbilityItemPlus VOLTVARI = new AbilityItemPlus(new AbilityAttribute("Volt Vari").setItemCooldown(80).setProjectileModel(new ModelSphere()).setProjectileSize(3, 3, 3).setProjectileDamage(5).setProjectileColor("7CB9E8").setItemCharge(20).addTasks(new AbilityTaskChargeable()).setFalseAttribute() );
	public static AbilityItemPlus ELTHOR = new AbilityItemPlus(new AbilityAttribute("El Thor").setItemCooldown(200).addTasks(Tasks.elthor) );
	 
	public static AbilityItemPlus GAMMAKNIFE = new AbilityItemPlus(new AbilityAttribute("Gamma Knife").setItemCooldown(750).setProjectileTicks(20).setProjectileModel(new ModelCube()).setProjectileColor("00AB66").setProjectileDamage(100).setProjectileSize(5, 1, 1) );
	public static AbilityItemPlus MES = new AbilityItemPlus(new AbilityAttribute("Mes").setItemCooldown(100).addTasks(Tasks.mes) ); 
	public static AbilityItemPlus COUNTERSHOCK = new AbilityItemPlus(new AbilityAttribute("Counter Shock").setItemCooldown(200).setProjectileTicks(7).setProjectileModel(new ModelCube()).setProjectileSize(1, 1, 1).setProjectileDamage(40).setProjectileExplosion(1, false, false) );
	public static AbilityItemPlus ROOM = new AbilityItemPlus(new AbilityAttribute("Room").setItemCooldown(100).addTasks(Tasks.room) );
	
	public static AbilityItemPlus NORONOROBEAM = new AbilityItemPlus(new AbilityAttribute("Noro Noro Beam").setItemCooldown(100).setProjectileModel(new ModelCube()).setProjectileSize(.6, .6, .6).setProjectileColor("FF1DCE").addEffects(EffectType.PROJECTILE, new PotionEffect(MobEffects.SLOWNESS, 100, 10)).setProjectileSpeed(5) );
	public static AbilityItemPlus NORONOROBEAMSWORD = new AbilityItemPlus(new AbilityAttribute("Noro Noro Beam Sword").setProjectileDamage(6).addTasks( new AbilityTaskSwordEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 5)) ) );
	
	public static AbilityItemPlus SHISHANOTE = new AbilityItemPlus(new AbilityAttribute("Shisha no Te").setItemCooldown(100).setProjectileDamage(5).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).setProjectileExplosion(3, false) );
	public static AbilityItemPlus SKATTING = new AbilityItemPlus(new AbilityAttribute("Skatting").setItemCooldown(50).addTasks(Tasks.skatting) );  
	 
	public static AbilityItemPlus GEAR = new AbilityItemPlus(new AbilityAttribute("Gear").setItemCooldown(400).setItemCharge(80).addTasks(Tasks.gear).addProperty( new ItemProperty("gear", 2, PropertyGetters.GEAR) ));
	public static AbilityItemPlus GOMUGOMUNOBAZOOKA = new AbilityItemPlus(new AbilityAttribute("Gomu Gomu no Bazooka").setItemCooldown(250).setItemCharge(30).addTasks(Tasks.gomugomubazooka) );
	public static AbilityItemPlus GOMUGOMUNOGATLING = new AbilityItemPlus(new AbilityAttribute("Gomu Gomu no Gatling").setItemCooldown(250).setItemRepeater().addTasks(Tasks.gomugomugatling) ); 
	public static AbilityItemPlus GOMUGOMUNOPISTOL = new AbilityItemPlus(new AbilityAttribute("Gomu Gomu no Pistol").setItemCooldown(150).setItemCharge(20).addTasks(Tasks.gomugomupistol) );
	
	public static AbilityItemPlus AMANOMURAKUMO = new AbilityItemPlus(new AbilityAttribute("Ama no Murakumo").setItemDamage(9) ); 
	public static AbilityItemPlus AMATERASU = new AbilityItemPlus(new AbilityAttribute("Amaterasu").setItemCooldown(350).setProjectileTicks(150).setProjectileModel(new ModelCube()).setProjectileSize(5, 1.2, 1.2).setProjectileColor("FFFF00").setProjectileSpeed(7).setProjectileDamage(35).setProjectileExplosion(6, false) );
	public static AbilityItemPlus YASAKANINOMAGATAMA = new AbilityItemPlus(new AbilityAttribute("Yasakani no Magatama").setItemCooldown(60).setProjectileModel(new ModelCube()).setProjectileSize(3, .5, .5).setProjectileColor("FFFF00").setProjectileSpeed(5).setItemRepeater().setProjectileDamage(5).setProjectileExplosion(3, false) );
	public static AbilityItemPlus YATANOKAGAMI = new AbilityItemPlus(new AbilityAttribute("Yata no Kagami").setItemCooldown(100).addTasks(Tasks.yatanokagami) );
	 
	public static AbilityItemPlus SPRINGDEATHKNOCK = new AbilityItemPlus(new AbilityAttribute("Spring Death Knock").setItemCooldown(200).setProjectileDamage(20).setProjectileModel(new ModelCube()).setProjectileColor("E6E8FA").setProjectileSize(5, 3, 3).setProjectileTicks(3) );
	public static AbilityItemPlus SPRINGSNIPE = new AbilityItemPlus(new AbilityAttribute("Spring Snipe").setItemCooldown(150).setItemCharge(20).addTasks(Tasks.springsnipe) );
	public static AbilityItemPlus SPRINGHOPPER = new AbilityItemPlus(new AbilityAttribute("Spring Hopper").setItemCooldown(80).setItemCharge(15).addTasks(Tasks.springhopper) );

	public static AbilityItemPlus ICETIMECAPSULE = new AbilityItemPlus(new AbilityAttribute("Ice Time Capsule").setItemCooldown(350).addTasks(Tasks.iceTime) );
	public static AbilityItemPlus ICESABER = new AbilityItemPlus(new AbilityAttribute("Ice Saber").setItemDamage(6).addTasks(new AbilityTaskSwordEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 1)) ) ); 
	public static AbilityItemPlus ICEBALL = new AbilityItemPlus(new AbilityAttribute("Ice Ball").setItemCooldown(150).setProjectileDamage(5).setProjectileModel(new ModelSphere()).setProjectileColor("00FFFF").setProjectileSize(5, 5, 5).addTasks(Tasks.iceBall) );
	public static AbilityItemPlus ICEAGE = new AbilityItemPlus(new AbilityAttribute("Ice Age").setItemCooldown(350).addEffects(EffectType.AOE, new PotionEffect(MobEffects.SLOWNESS, 200, 100), new PotionEffect(MobEffects.MINING_FATIGUE, 200, 100)).setEffectRadius(20).addTasks(Tasks.iceAge) );
	public static AbilityItemPlus ICEBLOCKPARTISAN = new AbilityItemPlus(new AbilityAttribute("Ice Block : Partisan").setItemCooldown(100).setProjectileDamage(10).setProjectileModel(new ModelCube()).setProjectileColor("00FFFF").setProjectileSize(5, .5, .5).setItemRepeater().addTasks(new AbilityTaskPlaceBlock(Blocks.PACKED_ICE)) );
	public static AbilityItemPlus ICEBLOCKPHEASANT = new AbilityItemPlus(new AbilityAttribute("Ice Block : Pheasant").setItemCooldown(500).setProjectileDamage(15).setProjectileModel(new ModelBird()).setProjectileColor("00FFFF").setProjectileSize(5, 5, 5) );
	
	public static AbilityItemPlus ENJOMO  = new AbilityItemPlus(new AbilityAttribute("Enjomo").setItemCooldown(250).addTasks(Tasks.enjomo));
	public static AbilityItemPlus KAGERO = new AbilityItemPlus(new AbilityAttribute("Jujika").setItemCooldown(150).setProjectileDamage(5).setProjectileModel(new ModelCube()).setProjectileColor("FF0000").setProjectileSize(3, .1, .1).addTasks(Tasks.kagero));
	public static AbilityItemPlus HIDARUMA = new AbilityItemPlus(new AbilityAttribute("Hidaruma").setItemCooldown(150).setProjectileModel(new ModelCube()).setProjectileSize(0, 0, 0).addTasks(new AbilityTaskPlaceBlock(Blocks.FIRE), new AbilityTaskSetOnFire(100)) );
	public static AbilityItemPlus DAIENKAIENTEI = new AbilityItemPlus(new AbilityAttribute("Dai Enkai : Entei").setProjectileModel(new ModelSphere()).setProjectileDamage(25).setProjectileColor("FF0000").setProjectileSize(9, 9, 9).setProjectileExplosion(4).setItemCooldown(500).setItemCharge(15).addTasks(new AbilityTaskChargeable()).setFalseAttribute() );
	public static AbilityItemPlus HIGAN = new AbilityItemPlus(new AbilityAttribute("Higan").setItemCooldown(80).setProjectileModel(new ModelCube()).setProjectileDamage(5).setProjectileColor("FF0000").setProjectileSize(.3, .3, .3).setItemRepeater().addTasks(new AbilityTaskPlaceBlock(Blocks.FIRE)) );
	public static AbilityItemPlus HIKEN = new AbilityItemPlus(new AbilityAttribute("Hiken").setItemCooldown(200).setProjectileModel(new ModelCube()).setProjectileDamage(20).setProjectileColor("FF0000").setProjectileSize(2, 1, 1).setProjectileExplosion(2) );
  
	public static AbilityItemPlus SORU = new AbilityItemPlus(new AbilityAttribute("Soru").addEffects(EffectType.USER, new PotionEffect(MobEffects.SPEED, 30, 3)));
	public static AbilityItemPlus TEKKAI = new AbilityItemPlus(new AbilityAttribute("Tekkai").addEffects(EffectType.USER,new PotionEffect(MobEffects.RESISTANCE, 30, 100), new PotionEffect(MobEffects.SLOWNESS, 30, 100)));
	public static AbilityItemPlus GEPPO = new AbilityItemPlus(new AbilityAttribute("Geppo").setItemCooldown(22).addTasks(Tasks.geppo) );
	public static AbilityItemPlus RANKYAKU = new AbilityItemPlus(new AbilityAttribute("Rankyaku").setItemCooldown(200).setProjectileTicks(100).setProjectileModel(new ModelCube()).setProjectileSize(1.5, 0.4, 6).setProjectileColor("69E3FF").setProjectileDamage(20).setProjectileExplosion(5, false) );
	public static AbilityItemPlus SHIGAN = new AbilityItemPlus(new AbilityAttribute("Shigan").setItemCooldown(130).setProjectileTicks(3).setProjectileModel(new ModelCube()).setProjectileSize(6, 1, 1).setProjectileDamage(25) );
	public static AbilityItemPlus KAMIE = new AbilityItemPlus(new AbilityAttribute("Kamie").addEffects(EffectType.USER,new PotionEffect(MobEffects.RESISTANCE, 20, 100)) );
	
	public static AbilityItemPlus UCHIMIZU = new AbilityItemPlus(new AbilityAttribute("Uchimizu").setItemCooldown(100).setProjectileModel(new ModelCube()).setProjectileColor("00CED1").setProjectileSize(1.3, 1, 1).setProjectileDamage(5).setItemRepeater());
	public static AbilityItemPlus YARINAMI = new AbilityItemPlus(new AbilityAttribute("Yarinami").setItemCooldown(150).setProjectileModel(new ModelCube()).setProjectileColor("00CED1").setProjectileSize(3, 1, 1).setProjectileDamage(15) );
	public static AbilityItemPlus SAMEHADASHOTEI = new AbilityItemPlus(new AbilityAttribute("Samehada Shotei").addEffects(EffectType.USER, new PotionEffect(MobEffects.RESISTANCE, 10, 100), new PotionEffect(MobEffects.SLOWNESS, 10, 100)));
	public static AbilityItemPlus SOSHARK = new AbilityItemPlus(new AbilityAttribute("Soshark").setItemCooldown(200).addTasks(Tasks.soshark));
	public static AbilityItemPlus MURASAME = new AbilityItemPlus(new AbilityAttribute("Murasame").setItemCooldown(250).setProjectileModel(new ModelCube()).setProjectileColor("00CED1").setProjectileSize(1.8, 1, 1).setProjectileDamage(15).setItemRepeater());
	public static AbilityItemPlus KARAKUSAGAWARASEIKEN = new AbilityItemPlus(new AbilityAttribute("Karakusagawara Seiken").setItemCooldown(400).addTasks(Tasks.karakusagawaraseiken));
	
	public static AbilityItemPlus FRESHFIRE = new AbilityItemPlus(new AbilityAttribute("Fresh Fire") );
	public static AbilityItemPlus MASTERNAIL = new AbilityItemPlus(new AbilityAttribute("Master Nail") );
	public static AbilityItemPlus RADICALBEAM = new AbilityItemPlus(new AbilityAttribute("Radical Beam") );
	public static AbilityItemPlus COUPDEVENT = new AbilityItemPlus(new AbilityAttribute("Coup de Vent") );
	public static AbilityItemPlus STRONGRIGHT = new AbilityItemPlus(new AbilityAttribute("Strong Right") );
	
	public static AbilityItemPlus KENBUNSHOKUHAKI = new AbilityItemPlus(new AbilityAttribute().setItemCooldown(300).addTasks(Tasks.kenbunshokuhaki));
	public static AbilityItemPlus BUSOSHOKUHAKI = new AbilityItemPlus(new AbilityAttribute().setItemCooldown(0).addTasks(Tasks.busoshokuhaki));
	public static AbilityItemPlus HAOSHOKUHAKI = new AbilityItemPlus(new AbilityAttribute().setItemCooldown(1000).addTasks(Tasks.haohokuhaki));

	public static AbilityItem DIALREJECT = new AbilityItem(new AbilityAttribute("Reject Dial").setItemMaxStack(16).setProjectileExplosion(4, false).setItemMaxDamage(1).addTasks(Tasks.rejectDial, Tasks.consumable));
	public static AbilityItem DIALBREATH = new AbilityItem(new AbilityAttribute("Breath Dial").setItemMaxStack(16).setItemMaxDamage(4).addTasks(Tasks.breathDial, Tasks.consumable));
	public static AbilityItem DIALIMPACT = new AbilityItem(new AbilityAttribute("Impact Dial").setItemMaxStack(16).setProjectileExplosion(4, false).setItemMaxDamage(1).addTasks(Tasks.consumable));
	public static AbilityItemPlus DIALFIRE = new AbilityItemPlus(new AbilityAttribute("Fire Dial").setItemMaxStack(16).setProjectileModel(new ModelCube()).setProjectileDamage(8).setProjectileColor("FF0000").setProjectileSize(1, .8, .8).setProjectileExplosion(1).setItemMaxDamage(2).addTasks(Tasks.consumable) );
	public static AbilityItem DIALMILKY = new AbilityItem(new AbilityAttribute("Milky Road").setItemMaxStack(16).setProjectileModel(new ModelCube()).setProjectileSize(.1, .1, .1).setProjectileColor(Color.BLUE).setProjectileTicks(20).setItemMaxDamage(1).addTasks(Tasks.milkydial, Tasks.consumable));
	public static AbilityItem DIALAXE = new AbilityItem(new AbilityAttribute("Axe Dial").setItemMaxStack(16).setProjectileModel(new ModelCube()).setProjectileDamage(5).setProjectileSize(1.5, 0.4, 6).setProjectileTicks(100).setProjectileColor("69E3FF").setItemMaxDamage(4).addTasks(Tasks.consumable));
	
	//public static AbilityItemPlus DEBUG_ITEM = (AbilityItemPlus) new AbilityItemPlus(new AbilityAttribute("DEBUG ITEM").setItemCharge(20).addTasks(Tasks.debug)).setCreativeTab(Values.isDebug ? CreativeTabs.COMBAT : null);

}
