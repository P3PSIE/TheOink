package p3psie.theoink.blocks.ores;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import p3psie.theoink.init.OinkItems;

import java.util.Random;

public class OinkDiamondOre extends OinkBaseOre{
    public OinkDiamondOre(String name, Material materialIn, String oreName, float hardness, float resistance, float lightLevel) {
        super(name, materialIn, oreName, hardness, resistance, lightLevel);
        this.setHarvestLevel("pickaxe", 2);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return OinkItems.OINK_DIAMOND;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1 + random.nextInt(4);
    }
}