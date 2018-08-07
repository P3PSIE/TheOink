package p3psie.theoink.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;
import p3psie.theoink.TheOink;
import p3psie.theoink.config.OinkConfig;
import p3psie.theoink.items.*;
import p3psie.theoink.items.food.*;
import p3psie.theoink.items.tools.*;

public class OinkItems {

    //Materials
    //TOOLS
    public static ToolMaterial OINK_WOOD_MATERIAL = EnumHelper.addToolMaterial("material_oink_wood", 0, 70, 10.0F, 1.0F, 12);
    public static ToolMaterial OINK_IRON_MATERIAL = EnumHelper.addToolMaterial("material_oink_iron", 2, 350, 15.0F, 2.5F, 14);
    public static ToolMaterial OINK_GOLD_MATERIAL = EnumHelper.addToolMaterial("material_oink_gold", 0, 80, 20.0F, 1.5F, 22);
    public static ToolMaterial OINK_DIAMOND_MATERIAL = EnumHelper.addToolMaterial("material_oink_diamond", 3, 350, 30.0F, 4.0F, 10);
    //ARMOR
    public static ItemArmor.ArmorMaterial OINK_WOOD_ARMOR = EnumHelper.addArmorMaterial("oink_wood_armor", TheOink.MODID +":oink_wood_armor", 10, new int[]{1, 3, 3, 2}, 5, SoundEvents.ENTITY_PIG_SADDLE, 0.0F);
    public static ItemArmor.ArmorMaterial OINK_IRON_ARMOR = EnumHelper.addArmorMaterial("oink_iron_armor", TheOink.MODID + ":oink_iron_armor", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ENTITY_PIG_SADDLE, 0.0F);
    public static ItemArmor.ArmorMaterial OINK_GOLD_ARMOR = EnumHelper.addArmorMaterial("oink_gold_armor", TheOink.MODID + ":oink_gold_armor", 15, new int[]{1, 3, 5, 2}, 25, SoundEvents.ENTITY_PIG_SADDLE, 0.0F);
    public static ItemArmor.ArmorMaterial OINK_DIAMOND_ARMOR = EnumHelper.addArmorMaterial("oink_diamond_armor", TheOink.MODID + ":oink_diamond_armor", 45, new int[]{3, 6, 8, 3}, 10, SoundEvents.ENTITY_PIG_SADDLE, 0.0F);


    //Items
    public static OinkItemBase OINK_DIAMOND = new OinkItemBase("oink_diamond");
    public static OinkItemBase OINK_STAR = new OinkItemBase("oink_star");


    //Carrots
    public static OinkCarrots OINK_IRON_CARROT = new OinkCarrots("oink_iron_carrot", "oinkIronCarrot", 3, 0.3f, false, OinkConfig.PIGS.ironCarrotsQTY);
    public static OinkCarrots OINK_GOLD_CARROT = new OinkCarrots("oink_gold_carrot", "oinkGoldCarrot", 4, 0.8f, false, OinkConfig.PIGS.goldCarrotsQTY);
    public static OinkCarrots OINK_DIAMOND_CARROT = new OinkCarrots("oink_diamond_carrot", "oinkDiamondCarrot", 8, 1.0f, false, OinkConfig.PIGS.diamondCarrotsQTY);


    //Dusts
    public static OinkItemOre OINK_IRON_DUST = new OinkItemOre("oink_iron_dust", "oinkIronDust");
    public static OinkItemOre OINK_PIG_IRON_DUST = new OinkItemOre("oink_pig_iron_dust", "oinkPigIronDust");
    public static OinkItemOre OINK_GOLD_DUST = new OinkItemOre("oink_gold_dust", "oinkGoldDust");
    public static OinkItemOre OINK_PIG_GOLD_DUST = new OinkItemOre("oink_pig_gold_dust", "oinkPigGoldDust");
    public static OinkItemOre OINK_DIAMOND_DUST = new OinkItemOre("oink_diamond_dust", "oinkDiamondDust");
    public static OinkItemOre OINK_PIG_DIAMOND_DUST = new OinkItemOre("oink_pig_diamond_dust", "oinkPigDiamondDust");

    //Ingots
    public static OinkItemOre OINK_IRON_INGOT = new OinkItemOre("oink_iron_ingot", "oinkIronIngot");
    public static OinkItemOre OINK_GOLD_INGOT = new OinkItemOre("oink_gold_ingot", "oinkGoldIngot");
    public static OinkItemOre OINK_COPPER_INGOT = new OinkItemOre("oink_copper_ingot", "oinkCopperIngot");


    //Foods
    public static OinkIronPorkchop OINK_IRON_PORKCHOP = new OinkIronPorkchop("oink_iron_porkchop", "oinkIronPorkchop", 5, 0.8f, true);
    public static OinkGoldPorkchop OINK_GOLD_PORKCHOP = new OinkGoldPorkchop("oink_gold_porkchop", "oinkGoldPorkchop", 12, 1.0f, true);
    public static OinkDiamondPorkchop OINK_DIAMOND_PORKCHOP = new OinkDiamondPorkchop("oink_diamond_porkchop", "oinkDiamondPorkchop", 15, 1.3f, true);
    public static OinkUltimatePorkchop OINK_ULTIMATE_PORKCHOP = new OinkUltimatePorkchop("oink_ultimate_porkchop", "oinkUltimatePorkchop", 20, 1.6f, true);
    //RawPorkchops
    public static OinkRawPorkchop OINK_IRON_PORKCHOP_RAW = new OinkRawPorkchop("oink_iron_porkchop_raw", EnumRarity.UNCOMMON, "oinkIronPorkchopRaw", 6, 0.8f, false);
    public static OinkRawPorkchop OINK_GOLD_PORKCHOP_RAW = new OinkRawPorkchop("oink_gold_porkchop_raw", EnumRarity.COMMON, "oinkGoldPorkchopRaw", 6, 0.8f, false);
    public static OinkRawPorkchop OINK_DIAMOND_PORKCHOP_RAW = new OinkRawPorkchop("oink_diamond_porkchop_raw", EnumRarity.RARE, "oinkDiamondPorkchopRaw", 6, 0.8f, false);
    public static OinkRawPorkchop OINK_ULTIMATE_PORKCHOP_RAW = new OinkRawPorkchop("oink_ultimate_porkchop_raw", EnumRarity.RARE, "oinkUltimatePorkchopRaw", 6, 0.8f, false);
    public static OinkFoodBase OINK_MINCED_PORK = new OinkFoodBase("oink_minced_pork", "oinkMincedPork", 1, 0.2f, false);

    //Tools
    //WOOD
    public static OinkSword OINK_WOOD_SWORD = new OinkSword("oink_wood_sword", OINK_WOOD_MATERIAL);
    public static OinkAxe OINK_WOOD_AXE = new OinkAxe("oink_wood_axe", OINK_WOOD_MATERIAL, 2.0F, 2.0F);
    public static OinkHoe OINK_WOOD_HOE = new OinkHoe("oink_wood_hoe", OINK_WOOD_MATERIAL);
    public static OinkPick OINK_WOOD_PICK = new OinkPick("oink_wood_pick", OINK_WOOD_MATERIAL);
    public static OinkShovel OINK_WOOD_SHOVEL = new OinkShovel("oink_wood_shovel", OINK_WOOD_MATERIAL);
    //IRON
    public static OinkSword OINK_IRON_SWORD = new OinkSword("oink_iron_sword", OINK_IRON_MATERIAL);
    public static OinkAxe OINK_IRON_AXE = new OinkAxe("oink_iron_axe", OINK_IRON_MATERIAL, 6.0F, 3.2F);
    public static OinkHoe OINK_IRON_HOE = new OinkHoe("oink_iron_hoe", OINK_IRON_MATERIAL);
    public static OinkPick OINK_IRON_PICK = new OinkPick("oink_iron_pick", OINK_IRON_MATERIAL);
    public static OinkShovel OINK_IRON_SHOVEL = new OinkShovel("oink_iron_shovel", OINK_IRON_MATERIAL);
    //GOLD
    public static OinkSword OINK_GOLD_SWORD = new OinkSword("oink_gold_sword", OINK_GOLD_MATERIAL);
    public static OinkAxe OINK_GOLD_AXE = new OinkAxe("oink_gold_axe", OINK_GOLD_MATERIAL, 8.0F, 3.8F);
    public static OinkHoe OINK_GOLD_HOE = new OinkHoe("oink_gold_hoe", OINK_GOLD_MATERIAL);
    public static OinkPick OINK_GOLD_PICK = new OinkPick("oink_gold_pick", OINK_GOLD_MATERIAL);
    public static OinkShovel OINK_GOLD_SHOVEL = new OinkShovel("oink_gold_shovel", OINK_GOLD_MATERIAL);
    //DIAMOND
    public static OinkSword OINK_DIAMOND_SWORD = new OinkSword("oink_diamond_sword", OINK_DIAMOND_MATERIAL);
    public static OinkAxe OINK_DIAMOND_AXE = new OinkAxe("oink_diamond_axe", OINK_DIAMOND_MATERIAL, 8.0F, 3.8F);
    public static OinkHoe OINK_DIAMOND_HOE = new OinkHoe("oink_diamond_hoe", OINK_DIAMOND_MATERIAL);
    public static OinkPick OINK_DIAMOND_PICK = new OinkPick("oink_diamond_pick", OINK_DIAMOND_MATERIAL);
    public static OinkShovel OINK_DIAMOND_SHOVEL = new OinkShovel("oink_diamond_shovel", OINK_DIAMOND_MATERIAL);
    //OINK
    public static OinkWand OINK_WAND = new OinkWand("oink_wand");
    public static OinkTools OINK_BASIC_CRUSHER = new OinkTools("oink_basic_crusher", "Used to turn ingots or ores into dusts.", 10);
    public static OinkTools OINK_BASIC_CRUSHER_GOLD = new OinkTools("oink_basic_crusher_gold", "Used to turn ingots or ores into dusts.", 30);
    public static OinkTools OINK_BASIC_CRUSHER_DIAMOND = new OinkTools("oink_basic_crusher_diamond", "Used to turn ingots or ores into dusts.", 50);
    public static OinkTools OINK_BASIC_MASHER = new OinkTools("oink_basic_masher", "Used to turn raw porkchops into minced pork.", 10);
    public static OinkTools OINK_BASIC_MASHER_GOLD = new OinkTools("oink_basic_masher_gold", "Used to turn raw porkchops into minced pork.", 30);
    public static OinkTools OINK_BASIC_MASHER_DIAMOND = new OinkTools("oink_basic_masher_diamond", "Used to turn raw porkchops into minced pork.", 50);

    //Armor
    //WOOD
    public static OinkArmorBase OINK_WOOD_HELMET = new OinkArmorBase("oink_wood_helmet", false, OINK_WOOD_ARMOR, 1, EntityEquipmentSlot.HEAD);
    public static OinkArmorBase OINK_WOOD_CHESTPLATE = new OinkArmorBase("oink_wood_chestplate", false, OINK_WOOD_ARMOR, 1, EntityEquipmentSlot.CHEST);
    public static OinkArmorBase OINK_WOOD_LEGGINGS = new OinkArmorBase("oink_wood_leggings", false, OINK_WOOD_ARMOR, 2, EntityEquipmentSlot.LEGS);
    public static OinkArmorBase OINK_WOOD_BOOTS = new OinkArmorBase("oink_wood_boots", false, OINK_WOOD_ARMOR, 1, EntityEquipmentSlot.FEET);
    //IRON
    public static OinkArmorBase OINK_IRON_HELMET = new OinkArmorBase("oink_iron_helmet", false, OINK_IRON_ARMOR, 1, EntityEquipmentSlot.HEAD);
    public static OinkArmorBase OINK_IRON_CHESTPLATE = new OinkArmorBase("oink_iron_chestplate", false, OINK_IRON_ARMOR, 1, EntityEquipmentSlot.CHEST);
    public static OinkArmorBase OINK_IRON_LEGGINGS = new OinkArmorBase("oink_iron_leggings", false, OINK_IRON_ARMOR, 2, EntityEquipmentSlot.LEGS);
    public static OinkArmorBase OINK_IRON_BOOTS = new OinkArmorBase("oink_iron_boots", false, OINK_IRON_ARMOR, 1, EntityEquipmentSlot.FEET);
    //GOLD
    public static OinkArmorBase OINK_GOLD_HELMET = new OinkArmorBase("oink_gold_helmet", false, OINK_GOLD_ARMOR, 1, EntityEquipmentSlot.HEAD);
    public static OinkArmorBase OINK_GOLD_CHESTPLATE = new OinkArmorBase("oink_gold_chestplate", false, OINK_GOLD_ARMOR, 1, EntityEquipmentSlot.CHEST);
    public static OinkArmorBase OINK_GOLD_LEGGINGS = new OinkArmorBase("oink_gold_leggings", false, OINK_GOLD_ARMOR, 2, EntityEquipmentSlot.LEGS);
    public static OinkArmorBase OINK_GOLD_BOOTS = new OinkArmorBase("oink_gold_boots", false, OINK_GOLD_ARMOR, 1, EntityEquipmentSlot.FEET);
    //DIAMOND
    public static OinkArmorBase OINK_DIAMOND_HELMET = new OinkArmorBase("oink_diamond_helmet", false, OINK_DIAMOND_ARMOR, 1, EntityEquipmentSlot.HEAD);
    public static OinkArmorBase OINK_DIAMOND_CHESTPLATE = new OinkArmorBase("oink_diamond_chestplate", false, OINK_DIAMOND_ARMOR, 1, EntityEquipmentSlot.CHEST);
    public static OinkArmorBase OINK_DIAMOND_LEGGINGS = new OinkArmorBase("oink_diamond_leggings", false, OINK_DIAMOND_ARMOR, 2, EntityEquipmentSlot.LEGS);
    public static OinkArmorBase OINK_DIAMOND_BOOTS = new OinkArmorBase("oink_diamond_boots", false, OINK_DIAMOND_ARMOR, 1, EntityEquipmentSlot.FEET);

    //Crops
    //Pork Crop
    public static OinkSeeds OINK_PORK_SEED = new OinkSeeds("oink_pork_seed",OinkBlocks.OINK_PORK_CROP, Blocks.FARMLAND);


    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                //INGOTS
                OINK_IRON_INGOT,
                OINK_GOLD_INGOT,
                OINK_COPPER_INGOT,
                OINK_PIG_IRON_DUST,
                OINK_PIG_GOLD_DUST,
                OINK_PIG_DIAMOND_DUST,

                //MISC ITEMS
                OINK_DIAMOND,
                OINK_STAR,

                //CARROTS
                OINK_IRON_CARROT,
                OINK_GOLD_CARROT,
                OINK_DIAMOND_CARROT,

                //DUSTS
                OINK_IRON_DUST,
                OINK_GOLD_DUST,
                OINK_DIAMOND_DUST,

                //FOODS
                OINK_IRON_PORKCHOP,
                OINK_GOLD_PORKCHOP,
                OINK_DIAMOND_PORKCHOP,
                OINK_ULTIMATE_PORKCHOP,
                //Raw
                OINK_IRON_PORKCHOP_RAW,
                OINK_GOLD_PORKCHOP_RAW,
                OINK_DIAMOND_PORKCHOP_RAW,
                OINK_ULTIMATE_PORKCHOP_RAW,
                OINK_MINCED_PORK,

                //TOOLS
                //Wood
                OINK_WOOD_SWORD,
                OINK_WOOD_AXE,
                OINK_WOOD_HOE,
                OINK_WOOD_PICK,
                OINK_WOOD_SHOVEL,
                //Iron
                OINK_IRON_SWORD,
                OINK_IRON_AXE,
                OINK_IRON_HOE,
                OINK_IRON_PICK,
                OINK_IRON_SHOVEL,
                //Gold
                OINK_GOLD_SWORD,
                OINK_GOLD_AXE,
                OINK_GOLD_HOE,
                OINK_GOLD_PICK,
                OINK_GOLD_SHOVEL,
                //Diamond
                OINK_DIAMOND_SWORD,
                OINK_DIAMOND_AXE,
                OINK_DIAMOND_HOE,
                OINK_DIAMOND_PICK,
                OINK_DIAMOND_SHOVEL,
                //Oink
                OINK_WAND,
                OINK_BASIC_CRUSHER,
                OINK_BASIC_CRUSHER_GOLD,
                OINK_BASIC_CRUSHER_DIAMOND,
                OINK_BASIC_MASHER,
                OINK_BASIC_MASHER_GOLD,
                OINK_BASIC_MASHER_DIAMOND,

                //ARMOR
                //Wood
                OINK_WOOD_HELMET,
                OINK_WOOD_CHESTPLATE,
                OINK_WOOD_LEGGINGS,
                OINK_WOOD_BOOTS,
                //Iron
                OINK_IRON_HELMET,
                OINK_IRON_CHESTPLATE,
                OINK_IRON_LEGGINGS,
                OINK_IRON_BOOTS,
                //Gold
                OINK_GOLD_HELMET,
                OINK_GOLD_CHESTPLATE,
                OINK_GOLD_LEGGINGS,
                OINK_GOLD_BOOTS,
                //Diamond
                OINK_DIAMOND_HELMET,
                OINK_DIAMOND_CHESTPLATE,
                OINK_DIAMOND_LEGGINGS,
                OINK_DIAMOND_BOOTS,

                //Crops
                OINK_PORK_SEED
        );
    }

    public static void registerModels() {
        //INGOTS
        OINK_IRON_INGOT.registerModels();
        OINK_GOLD_INGOT.registerModels();
        OINK_COPPER_INGOT.registerModels();
        OINK_PIG_IRON_DUST.registerModels();
        OINK_PIG_GOLD_DUST.registerModels();
        OINK_PIG_DIAMOND_DUST.registerModels();

        //MISC ITEMS
        OINK_DIAMOND.registerModels();
        OINK_STAR.registerModels();

        //CARROTS
        OINK_IRON_CARROT.registerModels();
        OINK_GOLD_CARROT.registerModels();
        OINK_DIAMOND_CARROT.registerModels();

        //DUSTS
        OINK_IRON_DUST.registerModels();
        OINK_GOLD_DUST.registerModels();
        OINK_DIAMOND_DUST.registerModels();

        //FOODS
        OINK_IRON_PORKCHOP.registerModels();
        OINK_GOLD_PORKCHOP.registerModels();
        OINK_DIAMOND_PORKCHOP.registerModels();
        OINK_ULTIMATE_PORKCHOP.registerModels();
        //RAW
        OINK_IRON_PORKCHOP_RAW.registerModels();
        OINK_GOLD_PORKCHOP_RAW.registerModels();
        OINK_DIAMOND_PORKCHOP_RAW.registerModels();
        OINK_ULTIMATE_PORKCHOP_RAW.registerModels();
        OINK_MINCED_PORK.registerModels();

        //TOOLS
        //Wood
        OINK_WOOD_SWORD.registerModels();
        OINK_WOOD_AXE.registerModels();
        OINK_WOOD_HOE.registerModels();
        OINK_WOOD_PICK.registerModels();
        OINK_WOOD_SHOVEL.registerModels();
        //Iron
        OINK_IRON_SWORD.registerModels();
        OINK_IRON_AXE.registerModels();
        OINK_IRON_HOE.registerModels();
        OINK_IRON_PICK.registerModels();
        OINK_IRON_SHOVEL.registerModels();
        //Gold
        OINK_GOLD_SWORD.registerModels();
        OINK_GOLD_AXE.registerModels();
        OINK_GOLD_HOE.registerModels();
        OINK_GOLD_PICK.registerModels();
        OINK_GOLD_SHOVEL.registerModels();
        //Diamond
        OINK_DIAMOND_SWORD.registerModels();
        OINK_DIAMOND_AXE.registerModels();
        OINK_DIAMOND_HOE.registerModels();
        OINK_DIAMOND_PICK.registerModels();
        OINK_DIAMOND_SHOVEL.registerModels();

        //OINK
        OINK_WAND.registerModels();
        OINK_BASIC_CRUSHER.registerModels();
        OINK_BASIC_CRUSHER_GOLD.registerModels();
        OINK_BASIC_CRUSHER_DIAMOND.registerModels();
        OINK_BASIC_MASHER.registerModels();
        OINK_BASIC_MASHER_GOLD.registerModels();
        OINK_BASIC_MASHER_DIAMOND.registerModels();

        //ARMOR
        //Wood
        OINK_WOOD_HELMET.registerModels();
        OINK_WOOD_CHESTPLATE.registerModels();
        OINK_WOOD_LEGGINGS.registerModels();
        OINK_WOOD_BOOTS.registerModels();
        //Iron
        OINK_IRON_HELMET.registerModels();
        OINK_IRON_CHESTPLATE.registerModels();
        OINK_IRON_LEGGINGS.registerModels();
        OINK_IRON_BOOTS.registerModels();
        //Gold
        OINK_GOLD_HELMET.registerModels();
        OINK_GOLD_CHESTPLATE.registerModels();
        OINK_GOLD_LEGGINGS.registerModels();
        OINK_GOLD_BOOTS.registerModels();
        //Diamond
        OINK_DIAMOND_HELMET.registerModels();
        OINK_DIAMOND_CHESTPLATE.registerModels();
        OINK_DIAMOND_LEGGINGS.registerModels();
        OINK_DIAMOND_BOOTS.registerModels();

        //Crops
        OINK_PORK_SEED.registerModels();
    }
}