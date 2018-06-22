package p3psie.theoink.world;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import p3psie.theoink.TheOink;
import p3psie.theoink.init.OinkLootTables;

import java.util.Map;
import java.util.Random;

public class OinkDungeon implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int posX = chunkX * 16;
        int posZ = chunkZ *16;
        if(world.provider.getDimension() == 0){
            generateOverworldDungeon(world, random, posX, posZ);
        }
    }
    private void generateOverworldDungeon(World world, Random random, int posX, int posZ) {

        WorldServer server = (WorldServer) world;
        TemplateManager manager = server.getStructureTemplateManager();

        Template piggy = manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(TheOink.MODID, "pigstructure"));

        if ((int) (Math.random() * 200) == 0)
        {
            int randX = posX + (int) (Math.random() * 16);
            int randZ = posZ + (int) (Math.random() * 16);
            int groundY = getGroundFromAbove(world, randX, randZ);
            BlockPos pos = new BlockPos(randX, groundY, randZ);

            if (canSpawnHere(piggy, world, pos))
            {
                piggy.addBlocksToWorld(world, pos, new PlacementSettings());
                handleDataBlocks(piggy, world, pos, new PlacementSettings());
            }
        }
    }

    private int getGroundFromAbove(World world, int x, int z)
    {
        int y = 255;
        boolean foundGround = false;
        while(!foundGround && y-- >= 63)
        {
            Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround = blockAt == Blocks.DIRT || blockAt == Blocks.GRASS || blockAt == Blocks.SAND || blockAt == Blocks.SNOW || blockAt == Blocks.SNOW_LAYER;
        }

        return y;
    }

    private boolean canSpawnHere(Template template, World world, BlockPos pos)
    {
        int z = template.getSize().getZ();
        int x = template.getSize().getX();

        boolean corner1 = isCornerValid(world, pos);
        boolean corner2 = isCornerValid(world, pos.add(x, 0, z));

        return pos.getY() > 63 && corner1 && corner2;
    }

    private boolean isCornerValid(World world, BlockPos pos)
    {
        int variation = 10;
        int highestBlock = getGroundFromAbove(world, pos.getX(), pos.getZ());

        if (highestBlock > pos.getY() - variation && highestBlock < pos.getY() + variation)
            return true;

        return false;
    }

    private void handleDataBlocks(Template template, World world, BlockPos pos, PlacementSettings settings) {
        // loop through all data blocks within the structure
        for (Map.Entry<BlockPos, String> e : template.getDataBlocks(pos, settings).entrySet()) {
            if ("common_chest".equals(e.getValue())) // check data block tag
            {
                BlockPos dataPos = e.getKey();
                world.setBlockState(dataPos, Blocks.AIR.getDefaultState(), 3); // remove data block
                TileEntity chestEntity = world.getTileEntity(dataPos.down()); // chest is located under data block

                if (chestEntity instanceof TileEntityChest) {
                    int rand = (int) (Math.random() * 100 + 1);

                    if (rand <= 85)
                        ((TileEntityChest) chestEntity).setLootTable(OinkLootTables.STRUCTURE_COMMON, world.rand.nextLong());
                    else if (rand > 95)
                        ((TileEntityChest) chestEntity).setLootTable(OinkLootTables.STRUCTURE_LEGENDARY, world.rand.nextLong());
                    else
                        ((TileEntityChest) chestEntity).setLootTable(OinkLootTables.STRUCTURE_RARE, world.rand.nextLong());
                }
            } else if ("rare_chest".equals(e.getValue())) // check data block tag
            {
                BlockPos dataPos = e.getKey();
                world.setBlockState(dataPos, Blocks.AIR.getDefaultState(), 3); // remove data block
                TileEntity chestEntity = world.getTileEntity(dataPos.down()); // chest is located under data block

                if (chestEntity instanceof TileEntityChest) {
                    int rand = (int) (Math.random() * 100 + 1);

                    if (rand <= 40)
                        ((TileEntityChest) chestEntity).setLootTable(OinkLootTables.STRUCTURE_COMMON, world.rand.nextLong());
                    else if (rand > 90)
                        ((TileEntityChest) chestEntity).setLootTable(OinkLootTables.STRUCTURE_LEGENDARY, world.rand.nextLong());
                    else
                        ((TileEntityChest) chestEntity).setLootTable(OinkLootTables.STRUCTURE_RARE, world.rand.nextLong());
                }
            } else if ("legendary_chest".equals(e.getValue())) // check data block tag
            {
                BlockPos dataPos = e.getKey();
                world.setBlockState(dataPos, Blocks.AIR.getDefaultState(), 3); // remove data block
                TileEntity chestEntity = world.getTileEntity(dataPos.down()); // chest is located under data block

                if (chestEntity instanceof TileEntityChest) {
                    int rand = (int) (Math.random() * 100 + 1);

                    if (rand <= 10)
                        ((TileEntityChest) chestEntity).setLootTable(OinkLootTables.STRUCTURE_COMMON, world.rand.nextLong());
                    else if (rand > 50)
                        ((TileEntityChest) chestEntity).setLootTable(OinkLootTables.STRUCTURE_LEGENDARY, world.rand.nextLong());
                    else
                        ((TileEntityChest) chestEntity).setLootTable(OinkLootTables.STRUCTURE_RARE, world.rand.nextLong());
                }
            }
        }
    }


}
