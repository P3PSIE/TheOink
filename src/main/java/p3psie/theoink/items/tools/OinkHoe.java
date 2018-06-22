package p3psie.theoink.items.tools;

import net.minecraft.item.ItemHoe;
import p3psie.theoink.TheOink;
import p3psie.theoink.util.OinkModelRegistry;

public class OinkHoe  extends ItemHoe implements OinkModelRegistry {
    protected String name;

    public OinkHoe(String name, ToolMaterial material) {
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
