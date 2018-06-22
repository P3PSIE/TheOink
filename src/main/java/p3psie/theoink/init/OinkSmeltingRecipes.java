package p3psie.theoink.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class OinkSmeltingRecipes {
    public static void init() {
        //Oink Ores to Ingots
        GameRegistry.addSmelting(OinkBlocks.OINK_IRON_ORE, new ItemStack(OinkItems.OINK_IRON_INGOT), 1.0F);
        GameRegistry.addSmelting(OinkBlocks.OINK_GOLD_ORE, new ItemStack(OinkItems.OINK_GOLD_INGOT), 1.0F);

        //Oink Dust to Ingots
        GameRegistry.addSmelting(OinkItems.OINK_PIG_IRON_DUST, new ItemStack(OinkItems.OINK_IRON_INGOT, 2, 0), 0.7F);
        GameRegistry.addSmelting(OinkItems.OINK_PIG_GOLD_DUST, new ItemStack(OinkItems.OINK_GOLD_INGOT, 2, 0), 0.7F);
        GameRegistry.addSmelting(OinkItems.OINK_PIG_DIAMOND_DUST, new ItemStack(OinkItems.OINK_DIAMOND, 2, 0), 0.7F);
        GameRegistry.addSmelting(OinkItems.OINK_IRON_DUST, new ItemStack(Items.IRON_INGOT, 1, 0), 0.7F);
        GameRegistry.addSmelting(OinkItems.OINK_GOLD_DUST, new ItemStack(Items.GOLD_INGOT, 1, 0), 0.7F);
        GameRegistry.addSmelting(OinkItems.OINK_DIAMOND_DUST, new ItemStack(Items.DIAMOND, 1, 0), 0.7F);

        //Oink Ingots to Vanilla Ingots
        GameRegistry.addSmelting(OinkItems.OINK_IRON_INGOT, new ItemStack(Items.IRON_INGOT, 1, 0), 0.7F);
        GameRegistry.addSmelting(OinkItems.OINK_GOLD_INGOT, new ItemStack(Items.GOLD_INGOT, 1, 0), 0.7F);
        GameRegistry.addSmelting(OinkItems.OINK_DIAMOND, new ItemStack(Items.DIAMOND, 1, 0), 0.7F);

        //Food
        GameRegistry.addSmelting(OinkItems.OINK_MINCED_PORK, new ItemStack(Items.COOKED_PORKCHOP, 2, 0), 0.5F);
        GameRegistry.addSmelting(OinkItems.OINK_IRON_PORKCHOP_RAW, new ItemStack(OinkItems.OINK_IRON_PORKCHOP, 1, 0), 0.5F);
        GameRegistry.addSmelting(OinkItems.OINK_GOLD_PORKCHOP_RAW, new ItemStack(OinkItems.OINK_GOLD_PORKCHOP, 1, 0), 0.5F);
        GameRegistry.addSmelting(OinkItems.OINK_DIAMOND_PORKCHOP_RAW, new ItemStack(OinkItems.OINK_DIAMOND_PORKCHOP, 1, 0), 0.5F);
        GameRegistry.addSmelting(OinkItems.OINK_ULTIMATE_PORKCHOP_RAW, new ItemStack(OinkItems.OINK_ULTIMATE_PORKCHOP, 1, 0), 3.0F);

        //Oink Stuff to MC Stuff
        GameRegistry.addSmelting(OinkItems.OINK_IRON_INGOT, new ItemStack(Items.IRON_INGOT, 2), 1.8F);
    }

    public static void oreInit(){
        OinkBlocks.OINK_IRON_ORE.initOreDict();
        OinkItems.OINK_IRON_INGOT.initOreDict();
    }
}