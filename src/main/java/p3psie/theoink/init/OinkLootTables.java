package p3psie.theoink.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import p3psie.theoink.TheOink;

public class OinkLootTables {

    public static final ResourceLocation ENTITIES_BACON = register("oink_bacon");
    public static final ResourceLocation ENTITIES_SAUSAGE = register("oink_sausage");



    // structures
    public static final ResourceLocation STRUCTURE_COMMON = register("structures/common");
    public static final ResourceLocation STRUCTURE_RARE = register("structures/rare");
    public static final ResourceLocation STRUCTURE_LEGENDARY = register("structures/legendary");



    private static ResourceLocation register(String id)
    {
        return LootTableList.register(new ResourceLocation(TheOink.MODID, id));
    }
}
