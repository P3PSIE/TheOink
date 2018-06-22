package p3psie.theoink.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import p3psie.theoink.init.OinkBlocks;

import java.util.Random;

public class OinkWorldGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) {
            generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }

    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOinkOre(OinkBlocks.OINK_IRON_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 18, 64, 4 + random.nextInt(6), 20);
        generateOinkOre(OinkBlocks.OINK_GOLD_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 8, 29, 4 + random.nextInt(5), 4);
        generateOinkOre(OinkBlocks.OINK_DIAMOND_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 6, 19, 1 + random.nextInt(9), 4);
    }


    private void generateOinkOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
        int deltaY = maxY - minY;

        for (int i = 0; i < chances; i++) {
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

            WorldGenMinable generator = new WorldGenMinable(ore, size);
            generator.generate(world, random, pos);
        }
    }
}
