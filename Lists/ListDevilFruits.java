package MineMineNoMi3.Lists;

import MineMineNoMi3.EnumFruitType;
import MineMineNoMi3.Values;
import MineMineNoMi3.Items.AkumaNoMi;
import WyPI.WyPI;
import WyPI.Ability.AbilityItem;

public class ListDevilFruits 
{
	public static AkumaNoMi MeraMeraNoMi, HieHieNoMi, BaneBaneNoMi, PikaPikaNoMi, GomuGomuNoMi, SukeSukeNoMi, OpeOpeNoMi, NoroNoroNoMi, GoroGoroNoMi, MokuMokuNoMi, NikyuNikyuNoMi, BomuBomuNoMi, GuraGuraNoMi, 
				KageKageNoMi, SunaSunaNoMi, MaguMaguNoMi, DoruDoruNoMi, DokuDokuNoMi, BariBariNoMi, GasuGasuNoMi, YukiYukiNoMi, JikiJikiNoMi, YamiYamiNoMi, ItoItoNoMi, HoroHoroNoMi, SupaSupaNoMi, OriOriNoMi,
				MeroMeroNoMi, GoeGoeNoMi, KiloKiloNoMi, HanaHanaNoMi, HoruHoruNoMi, BetaBetaNoMi, IshiIshiNoMi, PamuPamuNoMi, UshiUshiNoMiBison;
	 
	private static final AbilityItem[] YUKI = {ListAbilities.KAMAKURA, ListAbilities.YUKIRABI, ListAbilities.FUBUKI, ListAbilities.MANNENYUKI, ListAbilities.KAMAKURAJUSSOSHI, ListAbilities.TABIRAYUKI};
	private static final AbilityItem[] GASU = {ListAbilities.GASROBE, ListAbilities.GASTILLE, ListAbilities.GASTANET, ListAbilities.SHINOKUNI, ListAbilities.KARAKUNI, ListAbilities.BLUESWORD};
	private static final AbilityItem[] DOKU = {ListAbilities.HYDRA, ListAbilities.CHLOROBALL, ListAbilities.DOKUFUGU, ListAbilities.VENOMDEMON, ListAbilities.VENOMROAD};
	private static final AbilityItem[] DORU = {ListAbilities.DORUDORUARTSMORI, ListAbilities.DORUDORUARTSKEN, ListAbilities.CANDLEWALL, ListAbilities.CANDLEHOUSE};
	private static final AbilityItem[] MAGU = {ListAbilities.DAIFUNKA, ListAbilities.MEIGO, ListAbilities.RYUSEIKAZAN, ListAbilities.BAKURETSUKAZAN};
	private static final AbilityItem[] SUNA = {ListAbilities.BARJAN, ListAbilities.SABLES, ListAbilities.GROUNDDEATH, ListAbilities.DESERTSPADA};
	private static final AbilityItem[] KAGE = {ListAbilities.BRICKBAT, ListAbilities.DOPPELMAN, ListAbilities.TSUNOTOKAGE, ListAbilities.SHADOWSASGARD, ListAbilities.BLACKBOX};
	private static final AbilityItem[] GURA = {ListAbilities.KAISHIN, ListAbilities.KABUTOWARI, ListAbilities.SHIMAYURASHI, null};
	private static final AbilityItem[] BOMU = {ListAbilities.NOSEFANCYCANNON, ListAbilities.KICKBOMB, null, null};
	private static final AbilityItem[] NIKYU = {ListAbilities.PADHO, ListAbilities.URSUSSHOCK, null, null};
	private static final AbilityItem[] MOKU = {ListAbilities.WHITEOUT, ListAbilities.WHITESNAKE, ListAbilities.WHITELAUNCHER, null};
	private static final AbilityItem[] GORO = {ListAbilities.ELTHOR, ListAbilities.SANGO, ListAbilities.KARI, ListAbilities.VOLTVARI, ListAbilities.RAIGO};
	private static final AbilityItem[] OPE = {ListAbilities.ROOM, ListAbilities.MES, ListAbilities.COUNTERSHOCK, ListAbilities.GAMMAKNIFE};
	private static final AbilityItem[] NORO = {ListAbilities.NORONOROBEAM, ListAbilities.NORONOROBEAMSWORD, null, null};
	private static final AbilityItem[] SUKE = {ListAbilities.SKATTING, ListAbilities.SHISHANOTE, null, null};
	private static final AbilityItem[] GOMU = {ListAbilities.GOMUGOMUNOPISTOL, ListAbilities.GOMUGOMUNOBAZOOKA, ListAbilities.GOMUGOMUNOGATLING, ListAbilities.GEAR};
	private static final AbilityItem[] HIE = {ListAbilities.ICEBLOCKPARTISAN, ListAbilities.ICEAGE, ListAbilities.ICEBALL, ListAbilities.ICEBLOCKPHEASANT, ListAbilities.ICESABER, ListAbilities.ICETIMECAPSULE};	
	private static final AbilityItem[] PIKA = {ListAbilities.YATANOKAGAMI, ListAbilities.YASAKANINOMAGATAMA, ListAbilities.AMATERASU, ListAbilities.AMANOMURAKUMO};
	private static final AbilityItem[] BANE = {ListAbilities.SPRINGHOPPER, ListAbilities.SPRINGSNIPE, ListAbilities.SPRINGDEATHKNOCK, null};
	private static final AbilityItem[] MERA = {ListAbilities.HIKEN, ListAbilities.HIGAN, ListAbilities.DAIENKAIENTEI, ListAbilities.HIDARUMA, ListAbilities.ENJOMO, ListAbilities.KAGERO};
	private static final AbilityItem[][] EVERY_FRUIT = {MERA, HIE, PIKA, GOMU, BANE, SUKE, NORO, OPE, GORO, MOKU, NIKYU, BOMU, GURA, KAGE, SUNA, MAGU, DORU, DOKU, GASU, YUKI};
	
	public static void init()
	{	
		YukiYukiNoMi = new AkumaNoMi(EnumFruitType.LOGIA, YUKI);
		addITEM(YukiYukiNoMi, "Yuki Yuki no Mi");
		GasuGasuNoMi = new AkumaNoMi(EnumFruitType.LOGIA, GASU);
		addITEM(GasuGasuNoMi, "Gasu Gasu no Mi");
		DokuDokuNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, DOKU);
		addITEM(DokuDokuNoMi, "Doku Doku no Mi");
		DoruDoruNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, DORU);
		addITEM(DoruDoruNoMi, "Doru Doru no Mi");
		MaguMaguNoMi = new AkumaNoMi(EnumFruitType.LOGIA, MAGU);
		addITEM(MaguMaguNoMi, "Magu Magu no Mi");
		SunaSunaNoMi = new AkumaNoMi(EnumFruitType.LOGIA, SUNA);
		addITEM(SunaSunaNoMi, "Suna Suna no Mi");
		KageKageNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, KAGE);
		addITEM(KageKageNoMi, "Kage Kage no Mi");
		BomuBomuNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, BOMU);
		addITEM(BomuBomuNoMi, "Bomu Bomu no Mi");	
		NikyuNikyuNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, NIKYU);
		addITEM(NikyuNikyuNoMi, "Nikyu Nikyu no Mi");	
		MokuMokuNoMi = new AkumaNoMi(EnumFruitType.LOGIA, MOKU);
		addITEM(MokuMokuNoMi, "Moku Moku no Mi");	
		GoroGoroNoMi = new AkumaNoMi(EnumFruitType.LOGIA, GORO);
		addITEM(GoroGoroNoMi, "Goro Goro no Mi");	
		OpeOpeNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, OPE);
		addITEM(OpeOpeNoMi, "Ope Ope no Mi");
		NoroNoroNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, NORO);
		addITEM(NoroNoroNoMi, "Noro Noro no Mi");		
		SukeSukeNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, SUKE);
		addITEM(SukeSukeNoMi, "Suke Suke no Mi");		
		PikaPikaNoMi = new AkumaNoMi(EnumFruitType.LOGIA, PIKA); 
		addITEM(PikaPikaNoMi, "Pika Pika no Mi");	
		BaneBaneNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, BANE);
		addITEM(BaneBaneNoMi, "Bane Bane no Mi");	
		GomuGomuNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, GOMU);
		addITEM(GomuGomuNoMi, "Gomu Gomu no Mi");
		HieHieNoMi = new AkumaNoMi(EnumFruitType.LOGIA, HIE);
		addITEM(HieHieNoMi, "Hie Hie no Mi");	
		MeraMeraNoMi = new AkumaNoMi(EnumFruitType.LOGIA, MERA);
		addITEM(MeraMeraNoMi, "Mera Mera no Mi");

		//addITEM(ListAbilities.DEBUG_ITEM, "DEBUG ITEM");
		
		for(int i = 0; i < EVERY_FRUIT.length; i++)
			for(AbilityItem a : EVERY_FRUIT[i])	
				if(a != null)
					addITEM(a, a.getAttribute().getAttributeName());		
	}

	public static void addITEM(AkumaNoMi item, String localizedName)
	{	
		if(((AkumaNoMi)item).type == EnumFruitType.LOGIA)
			Values.logias.add(item);	
		Values.devilfruits.add(item);
		WyPI.Registry.addITEM(item, localizedName, ListCreativeTabs.tabDevilFruits);
	}
	
	public static void addITEM(AbilityItem item, String localizedName)
	{	
		Values.abilities.add(item);	
		WyPI.Registry.addITEM(item, localizedName);
	}
	
}
