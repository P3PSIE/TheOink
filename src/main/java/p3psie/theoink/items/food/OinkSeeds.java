package p3psie.theoink.items.food;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;
import p3psie.theoink.TheOink;
import p3psie.theoink.util.OinkModelRegistry;

public class OinkSeeds extends ItemSeeds implements OinkModelRegistry {
    private String name;
    public OinkSeeds(String name, Block crops, Block soil) {
        super(crops, soil);
        this.name = name;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(TheOink.OINK_TAB);
    }

    @Override
    public void registerModels() {
        TheOink.proxy.registerItemRender(this, 0, name);
    }
}
