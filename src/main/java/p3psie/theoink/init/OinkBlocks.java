package p3psie.theoink.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import p3psie.theoink.blocks.ores.OinkBaseOre;
import p3psie.theoink.blocks.ores.OinkDiamondOre;
import p3psie.theoink.crops.OinkPorkCrop;

public class OinkBlocks {
    public static OinkBaseOre OINK_IRON_ORE = new OinkBaseOre("oink_iron_ore", Material.IRON, "oinkIronOre", 3.0F, 15.0F, 1);
    public static OinkBaseOre OINK_GOLD_ORE = new OinkBaseOre("oink_gold_ore", Material.IRON, "oinkGoldOre", 3.0F, 15.0F, 1);
    public static OinkDiamondOre OINK_DIAMOND_ORE = new OinkDiamondOre("oink_diamond_ore", Material.IRON, "oinkDiamondOre", 10.0F, 15.0F, 2);
    public static OinkPorkCrop OINK_PORK_CROP = new OinkPorkCrop("oink_pork_crop");

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                OINK_IRON_ORE,
                OINK_GOLD_ORE,
                OINK_DIAMOND_ORE,
                OINK_PORK_CROP
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                OINK_IRON_ORE.itemBlock(),
                OINK_GOLD_ORE.itemBlock(),
                OINK_DIAMOND_ORE.itemBlock(),
                OINK_PORK_CROP.itemBlock()
        );
    }

    public static void registerModels() {
        OINK_IRON_ORE.registerModels();
        OINK_GOLD_ORE.registerModels();
        OINK_DIAMOND_ORE.registerModels();
    }

}