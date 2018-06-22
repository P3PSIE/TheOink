package p3psie.theoink;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import p3psie.theoink.commands.CommandsOink;
import p3psie.theoink.init.OinkBlocks;
import p3psie.theoink.init.OinkItems;
import p3psie.theoink.init.OinkSmeltingRecipes;
import p3psie.theoink.init.OinkTab;
import p3psie.theoink.potions.OinkFly;
import p3psie.theoink.proxy.CommonProxy;
import p3psie.theoink.world.OinkDungeon;
import p3psie.theoink.world.OinkWorldGen;

import static p3psie.theoink.TheOink.*;

@Mod(modid = MODID, name = NAME, version = VERSION, acceptedMinecraftVersions = AVERSION)
public class TheOink {
    public static final String MODID = "theoink";
    public static final String NAME = "The Oink";
    public static final String VERSION = "1.12.2-1.0.1";
    public static final String AVERSION = "1.12.2";
    public static final String CLIENT_PROXY = "p3psie.theoink.proxy.ClientProxy";
    public static final String COMMON_PROXY = "p3psie.theoink.proxy.CommonProxy";


    //Potions
    public static Potion OINK_FLY;

    @Instance
    public static TheOink instance;

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static CommonProxy proxy;

    public static CreativeTabs OINK_TAB = new OinkTab("theoink");


    @EventHandler
    public void preInit(FMLPreInitializationEvent event){ proxy.preInit(); }

    @EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init();
        OinkSmeltingRecipes.init();
        OinkSmeltingRecipes.oreInit();

        OINK_FLY = new OinkFly(false, 2, "oinkfly").setIconIndex(0, 0);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit();
        GameRegistry.registerWorldGenerator(new OinkWorldGen(), 3);
        GameRegistry.registerWorldGenerator(new OinkDungeon(), 3);
    }

    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent event){
        event.registerServerCommand(new CommandsOink());
    }


    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            OinkItems.register(event.getRegistry());
            OinkBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            OinkItems.registerModels();
            OinkBlocks.registerModels();
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            OinkBlocks.register(event.getRegistry());
        }
    }

}