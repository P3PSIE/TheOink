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
        @Config.Comment("Set the effects provided by the 'Iron Porkchop'")
        @Config.Name("Iron Porkchop Effects")
        public String[] ironPorkchopEffects = new String[]{
                "minecraft:haste,500,1",
                "minecraft:speed,500,1",
                "minecraft:night_vision,500,1"
        };

        @Config.Comment("Set the effects provided by the 'Gold Porkchop'")
        @Config.Name("Gold Porkchop Effects")
        public String[] goldPorkchopEffects = new String[]{
                "minecraft:haste,500,1",
                "minecraft:speed,500,1",
                "minecraft:night_vision,500,1",
                "minecraft:resistance,500,1",
                "minecraft:fire_resistance,500,1"
        };

        @Config.Comment("Set the effects provided by the 'Diamond Porkchop'")
        @Config.Name("Diamond Porkchop Effects")
        public String[] diamondPorkchopEffects = new String[]{
                "minecraft:haste,500,1",
                "minecraft:speed,500,1",
                "minecraft:night_vision,500,1",
                "minecraft:resistance,500,1",
                "minecraft:fire_resistance,500,1",
                "minecraft:regeneration,500,1",
                "minecraft:strength,500,1"
        };

        @Config.Comment("Set the effects provided by the 'Ultimate Porkchop'")
        @Config.Name("UltimatePorkchop Effects")
        public String[] ultimatePorkchopEffects = new String[]{
                "minecraft:haste,500,1",
                "minecraft:speed,500,1",
                "minecraft:night_vision,500,1",
                "minecraft:resistance,500,1",
                "minecraft:fire_resistance,500,1",
                "minecraft:regeneration,500,1",
                "minecraft:strength,500,1"
        };
    }

    public static class Pigs{
        @Config.Comment("This is a blacklist of blocks dropped by the Bacon entity in game, please add any 'BLOCKS' you do not want Bacon to drop!")
        @Config.Name("Bacon Block Blacklist")
        public String[] blockBlackListConfig = new String[]{
                "minecraft:command_block",
                "minecraft:chain_command_block"

    };

        @Config.Comment("This is a blacklist of items dropped by the Sausage entity in game, please add any 'ITEMS' you do not want Sausage to drop!")
        @Config.Name("Sausage Item Blacklist")
        public String[] itemBlackListConfig = new String[]{
                "minecraft:item_null",
                "minecraft:end_portal_frame"
        };

        @Config.Comment("Quanty of pigs spawned when iron carrots fed to Bacon or Sausage.")
        @Config.Name("Iron Carrot")
        public int ironCarrotsQTY = 5;

        @Config.Comment("Quanty of pigs spawned when gold carrots fed to Bacon or Sausage.")
        @Config.Name("Oink Gold Carrot")
        public int goldCarrotsQTY = 10;

        @Config.Comment("Quanty of pigs spawned when diamond carrots fed to Bacon or Sausage.")
        @Config.Name("Oink Diamond Carrot")
        public int diamondCarrotsQTY = 20;
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
