package p3psie.theoink.proxy;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import p3psie.theoink.config.OinkConfig;
import p3psie.theoink.init.OinkEntities;
import p3psie.theoink.util.handlers.RenderingHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommonProxy {

    public void preInit(){
        OinkEntities.entityReg();
        RenderingHandler.init();
    }

    public void init(){ }

    public void postInit(){
        getRegistries();
    }

    public void registerItemRender(Item item, int meta, String id){}


    public static void getRegistries(){
        ArrayList<Block> blockList = Lists.newArrayList(Block.REGISTRY);
        ArrayList<Item> itemList = Lists.newArrayList(Item.REGISTRY);

        Set<String> blacklistBlocks = Sets.newHashSet(OinkConfig.PIGS.blockBlackListConfig);
        blockList.removeIf(block -> blacklistBlocks.contains(block.getRegistryName().toString()));

        Set<String> blacklistItems = Sets.newHashSet(OinkConfig.PIGS.itemBlackListConfig);
        itemList.removeIf(item -> blacklistItems.contains(item.getRegistryName().toString()));
    }
}
