package xyz.pixelatedw.MineMineNoMi3.lists;

import xyz.pixelatedw.MineMineNoMi3.EnumFruitType;
import xyz.pixelatedw.MineMineNoMi3.Values;
import xyz.pixelatedw.MineMineNoMi3.abilities.BaneAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.HieAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.MeraAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.NoroAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.OpeAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.PikaAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.RokushikiAbilities;
import xyz.pixelatedw.MineMineNoMi3.abilities.SukeAbilities;
import xyz.pixelatedw.MineMineNoMi3.api.WyRegistry;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.Ability;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityItem;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.AbilityProjectile;
import xyz.pixelatedw.MineMineNoMi3.api.abilities.extra.AbilityManager;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.BaneProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.HieProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.MeraProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.NoroProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.OpeProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.PikaProjectiles;
import xyz.pixelatedw.MineMineNoMi3.entities.abilityprojectiles.SukeProjectiles;
import xyz.pixelatedw.MineMineNoMi3.items.AkumaNoMi;

public class ListDevilFruits 
{
	
	public static AkumaNoMi MeraMeraNoMi, HieHieNoMi, BaneBaneNoMi, PikaPikaNoMi, GomuGomuNoMi, SukeSukeNoMi,
			OpeOpeNoMi, NoroNoroNoMi, GoroGoroNoMi, MokuMokuNoMi, NikyuNikyuNoMi, BomuBomuNoMi, GuraGuraNoMi,
			KageKageNoMi, SunaSunaNoMi, MaguMaguNoMi, DoruDoruNoMi, DokuDokuNoMi, BariBariNoMi, GasuGasuNoMi,
			YukiYukiNoMi, JikiJikiNoMi, YamiYamiNoMi, ItoItoNoMi, HoroHoroNoMi, SupaSupaNoMi, OriOriNoMi, MeroMeroNoMi,
			GoeGoeNoMi, KiloKiloNoMi, HanaHanaNoMi, HoruHoruNoMi, BetaBetaNoMi, IshiIshiNoMi, PamuPamuNoMi,
			UshiUshiNoMiBison;

	private static final Ability[][] EVERY_FRUIT = {MeraAbilities.abilitiesArray};
	public static final Object[] ALL_ENTITIES = new Object[] 
		{MeraProjectiles.abilitiesClassesArray, HieProjectiles.abilitiesClassesArray, BaneProjectiles.abilitiesClassesArray, PikaProjectiles.abilitiesClassesArray, NoroProjectiles.abilitiesClassesArray
				, SukeProjectiles.abilitiesClassesArray, OpeProjectiles.abilitiesClassesArray};
	
	public static void init() {
		/*UshiUshiNoMiBison = new AkumaNoMi(EnumFruitType.ZOAN, USHIB);
		addITEM(UshiUshiNoMiBison, "Ushi Ushi no Mi, Model Bison");
		JikiJikiNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, JIKI);
		addITEM(JikiJikiNoMi, "Jiki Jiki no Mi");
		YamiYamiNoMi = new AkumaNoMi(EnumFruitType.LOGIA, YAMI);
		addITEM(YamiYamiNoMi, "Yami Yami no Mi");
		HoruHoruNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, HORU);
		addITEM(HoruHoruNoMi, "Horu Horu no Mi");
		MeroMeroNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, MERO);
		addITEM(MeroMeroNoMi, "Mero Mero no Mi");
		KiloKiloNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, KILO);
		addITEM(KiloKiloNoMi, "Kilo Kilo no Mi");
		GoeGoeNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, GOE);
		addITEM(GoeGoeNoMi, "Goe Goe no Mi");
		SupaSupaNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, SUPA);
		addITEM(SupaSupaNoMi, "Supa Supa no Mi");
		HoroHoroNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, HORO);
		addITEM(HoroHoroNoMi, "Horo Horo no Mi");
		BariBariNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, BARI);
		addITEM(BariBariNoMi, "Bari Bari no Mi");
		ItoItoNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, ITO);
		addITEM(ItoItoNoMi, "Ito Ito no Mi");
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
		GuraGuraNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, GURA);
		addITEM(GuraGuraNoMi, "Gura Gura no Mi");
		BomuBomuNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, BOMU);
		addITEM(BomuBomuNoMi, "Bomu Bomu no Mi");
		NikyuNikyuNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, NIKYU);
		addITEM(NikyuNikyuNoMi, "Nikyu Nikyu no Mi");
		MokuMokuNoMi = new AkumaNoMi(EnumFruitType.LOGIA, MOKU);
		addITEM(MokuMokuNoMi, "Moku Moku no Mi");*/
		//GoroGoroNoMi = new AkumaNoMi(EnumFruitType.LOGIA, GORO);
		//addITEM(GoroGoroNoMi, "Goro Goro no Mi");
		/*OpeOpeNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, OpeAbilities.abilitiesArray);
		addITEM(OpeOpeNoMi, "Ope Ope no Mi");
		NoroNoroNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, NoroAbilities.abilitiesArray);
		addITEM(NoroNoroNoMi, "Noro Noro no Mi");
		SukeSukeNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, SukeAbilities.abilitiesArray);
		addITEM(SukeSukeNoMi, "Suke Suke no Mi");
		PikaPikaNoMi = new AkumaNoMi(EnumFruitType.LOGIA, PikaAbilities.abilitiesArray);
		addITEM(PikaPikaNoMi, "Pika Pika no Mi");*/
		/*GomuGomuNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, GOMU);
		addITEM(GomuGomuNoMi, "Gomu Gomu no Mi");*/
		/*BaneBaneNoMi = new AkumaNoMi(EnumFruitType.PARAMECIA, BaneAbilities.abilitiesArray);
		addITEM(BaneBaneNoMi, "Bane Bane no Mi");
		HieHieNoMi = new AkumaNoMi(EnumFruitType.LOGIA, HieAbilities.abilitiesArray);
		addITEM(HieHieNoMi, "Hie Hie no Mi");*/
		MeraMeraNoMi = new AkumaNoMi(EnumFruitType.LOGIA, MeraAbilities.abilitiesArray);
		addITEM(MeraMeraNoMi, "Mera Mera no Mi");

		for (int i = 0; i < EVERY_FRUIT.length; i++)
			for (Ability a : EVERY_FRUIT[i])
				if (a != null)
					AbilityManager.instance().registerAbility(a);
	}

	public static void addITEM(AkumaNoMi item, String localizedName) {
		if (((AkumaNoMi) item).type == EnumFruitType.LOGIA)
			Values.logias.add(item);
		Values.devilfruits.add(item);
		WyRegistry.registerItem(item, localizedName, ListCreativeTabs.tabDevilFruits);
	}

	public static void addITEM(AbilityItem item, String localizedName) {
		Values.abilities.add(item);
		WyRegistry.registerItem(item, localizedName);
	}

}
