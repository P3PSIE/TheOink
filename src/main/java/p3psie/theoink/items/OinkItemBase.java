package p3psie.theoink.items;

import net.minecraft.item.Item;
import p3psie.theoink.TheOink;
import p3psie.theoink.util.OinkModelRegistry;

public class OinkItemBase extends Item implements OinkModelRegistry {
    protected String name;

    public OinkItemBase(String name){
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
