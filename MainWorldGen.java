package MineMineNoMi3;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import MineMineNoMi3.Lists.ListMisc;

public class MainWorldGen implements IWorldGenerator 
{

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.getDimension())
		{
			case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}	
	
	private void generateSurface(World world, Random random, int i, int j) 
	{
		this.addOreSpawn(ListMisc.KairosekiOre, world, random, i, j, 16, 16, 4 + random.nextInt(3), 30, 15, 50);	
	}
	
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
		int maxPossY = minY + (maxY - 1);
		int diffBtwnMinMaxY = maxY - minY;
		
		for(int x = 0; x < chancesToSpawn; x++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(posX, posY, posZ));
			if(block == ListMisc.KairosekiOre)
				if(biome.getBiomeName().equals("Ocean") || biome.getBiomeName().equals("Deep Ocean") || biome.getBiomeName().equals("Beach"))
					new WorldGenMinable(block.getDefaultState(), maxVeinSize).generate(world, random, new BlockPos(posX, posY, posZ));
			else
				new WorldGenMinable(block.getDefaultState(), maxVeinSize).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}

		
}
