package p3psie.theoink.items.tools;

import net.minecraft.item.ItemSpade;
import p3psie.theoink.TheOink;
import p3psie.theoink.util.OinkModelRegistry;

public class OinkShovel extends ItemSpade implements OinkModelRegistry {
    protected String name;

    public OinkShovel(String name, ToolMaterial material) {
        super(material);
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
