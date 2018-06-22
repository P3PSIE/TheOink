package p3psie.theoink.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import p3psie.theoink.TheOink;

@Config(modid = TheOink.MODID)
@Config.LangKey(TheOink.MODID + ".config.title")
public class OinkConfig {

    @Config.Comment("Food Oink Configs")
    public static final Food FOOD = new Food();

    @Config.Comment("Oink Pigs Configs")
    public static final Pigs PIGS = new Pigs();


    public static class Food{
        @Config.Comment("Set the effects provided by the 'Ultimate Porkchop'")
        public String[] ultimatePorkchopEffects = new String[]{
                "theoink:oink_flight",
                "minecraft:speed"
        };

        @Config.Comment("The amount of time the effects last from porchops in ticks")
        @Config.RangeInt(min = 1)
        public int effectTime = 800;
    }

    public static class Pigs{
        @Config.Comment("This is a blacklist of blocks dropped by the Bacon entity in game, please add any 'BLOCKS' you do not want Bacon to drop!")
        public String[] blockBlackListConfig = new String[]{
                "minecraft:command_block"
        };

        @Config.Comment("This is a blacklist of items dropped by the Sausage entity in game, please add any 'ITEMS' you do not want Sausage to drop!")
        public String[] itemBlackListConfig = new String[]{
                "minecraft:item_null",
                "minecraft:end_portal_frame"
        };
    }




    @Mod.EventBusSubscriber(modid = TheOink.MODID)
    private static class EventHandler{
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(TheOink.MODID)) {
                ConfigManager.sync(TheOink.MODID, Config.Type.INSTANCE);
            }
        }
    }
}
