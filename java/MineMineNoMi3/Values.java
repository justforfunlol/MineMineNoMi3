package MineMineNoMi3;

import java.util.ArrayList;
import java.util.List;

import MineMineNoMi3.capability.EntityCapability.IEntityCapability;
import MineMineNoMi3.lists.ListMisc;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class Values 
{
	public static List<Item> abilities = new ArrayList();
	public static List<Item> devilfruits = new ArrayList();
	public static List<Item> logias = new ArrayList();
	public static List<Item> miscItems = new ArrayList();
	public static List<Block> miscBlocks = new ArrayList();
	public static List<Object[]> customDFs = new ArrayList();
	
	public static final int MAX_DORIKI = 10000;
	public static final int MAX_COLA = 100;
	public static final int MAX_GENERAL = 999999999; //Used by Bounty, Reputation, Belly & Extol
	public static final int MAX_CREW = 50;
	
	public static IBlockState[] BANNED_BLOCKS = new IBlockState[] {Blocks.BEDROCK.getDefaultState(), ListMisc.Ope.getDefaultState(), ListMisc.OpeMid.getDefaultState()};	

	@CapabilityInject(IEntityCapability.class)
    public static final Capability<IEntityCapability> ENTITY_CAPABILITIES = null;

	public static final DataParameter<String> TEXTURE = EntityDataManager.<String>createKey(Entity.class, DataSerializers.STRING);
	public static final DataParameter<Integer> ENMITY = EntityDataManager.<Integer>createKey(Entity.class, DataSerializers.VARINT);
	public static final DataParameter<Byte> MODEL = EntityDataManager.<Byte>createKey(Entity.class, DataSerializers.BYTE);

}
